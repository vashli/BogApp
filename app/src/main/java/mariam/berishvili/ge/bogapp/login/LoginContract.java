package mariam.berishvili.ge.bogapp.login;


import mariam.berishvili.ge.bogapp.model.login.ClientLoginInfo;

public interface LoginContract {
    interface Presenter{
        void onDestroy();
        void fetchLoginDataFromServer(String username, String password);
    }

    interface LoginView {
        void onLoginSuccess(ClientLoginInfo loginInfo);
        void onLoginFailure(Throwable throwable);
        void onInvalidUsernamePassword(int status);
    }

    interface UserInfoIntractor {
        interface OnFinishedListener {
            void onFinished(ClientLoginInfo loginInfo);
            void onFailure(Throwable t);
        }
        void getLoginInfo(OnFinishedListener onFinishedListener, String username, String password);
    }
}
