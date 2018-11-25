package mariam.berishvili.ge.bogapp.login;


import mariam.berishvili.ge.bogapp.model.login.ClientLoginInfo;

public class LoginPresenterImpl implements LoginContract.Presenter {

    private static final int USERNAME_MIN_LENGTH = 4;
    private static final int PASSWORD_MIN_LENGTH = 4;
    private LoginContract.LoginView loginView;
    private LoginContract.UserInfoIntractor loginIntractor;

    public  LoginPresenterImpl(LoginContract.LoginView loginView, LoginContract.UserInfoIntractor loginIntractor ){
        this.loginView = loginView;
        this.loginIntractor = loginIntractor;
    }

    @Override
    public void fetchLoginDataFromServer(String username, String password) {
        if (!validUsernamePassword(username, password)) {
            loginView.onInvalidUsernamePassword();
        } else{
            loginIntractor.getLoginInfo(new LoginContract.UserInfoIntractor.OnFinishedListener() {

                @Override
                public void onFinished(ClientLoginInfo loginInfo) {
                    loginView.onLoginSuccess(loginInfo);
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

    private boolean validUsernamePassword(String username, String password){
        return (username.length() >= USERNAME_MIN_LENGTH && password.length() >= PASSWORD_MIN_LENGTH );
    }
}
