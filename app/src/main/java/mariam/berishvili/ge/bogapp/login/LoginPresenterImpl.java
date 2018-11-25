package mariam.berishvili.ge.bogapp.login;


import mariam.berishvili.ge.bogapp.model.Constants;
import mariam.berishvili.ge.bogapp.model.login.ClientLoginInfo;
import mariam.berishvili.ge.bogapp.network.RetrofitProvider;

public class LoginPresenterImpl implements LoginContract.Presenter {

    private static final int USERNAME_MIN_LENGTH = 3;
    private static final int PASSWORD_MIN_LENGTH = 3;
    private LoginContract.LoginView loginView;
    private LoginContract.UserInfoIntractor loginIntractor;

    public  LoginPresenterImpl(LoginContract.LoginView loginView, LoginContract.UserInfoIntractor loginIntractor ){
        this.loginView = loginView;
        this.loginIntractor = loginIntractor;
    }

    @Override
    public void fetchLoginDataFromServer(String username, String password) {
        int status = checkUserNamePassword(username, password);
        if (status != Constants.USERNAME_PASSWORD_OK) {
            loginView.onInvalidUsernamePassword(status);
        } else{
            loginIntractor.getLoginInfo(new LoginContract.UserInfoIntractor.OnFinishedListener() {

                @Override
                public void onFinished(ClientLoginInfo loginInfo) {
                    loginView.onLoginSuccess(loginInfo);
                    RetrofitProvider.session_id = loginInfo.getSessionId();
                }

                @Override
                public void onFailure(Throwable t) {
                    loginView.onLoginFailure(t);
                }
            }, username, password);
        }
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    private int checkUserNamePassword(String username, String password){
        if(username.isEmpty() && password.isEmpty()) return Constants.USERNAME_PASSWORD_EMPTY;
        if(username.isEmpty() && password.length() < PASSWORD_MIN_LENGTH) return Constants.USERNAME_EMPTY_PASSWORD_SHORT;
        if(username.length() < USERNAME_MIN_LENGTH && password.isEmpty()) return Constants.USERNAME_SHORT_PASSWORD_EMPTY;
        if(username.length() < USERNAME_MIN_LENGTH && password.length() < PASSWORD_MIN_LENGTH ) return Constants.USERNAME_PASSWORD_SHORT;
        if(username.isEmpty()) return Constants.USERNAME_EMPTY;
        if(password.isEmpty()) return Constants.PASSWORD_EMPTY;
        if(password.length() < PASSWORD_MIN_LENGTH) return Constants.PASSWORD_SHORT;
        if(username.length() < USERNAME_MIN_LENGTH) return Constants.USERNAME_SHORT;

        return Constants.USERNAME_PASSWORD_OK;
    }
}
