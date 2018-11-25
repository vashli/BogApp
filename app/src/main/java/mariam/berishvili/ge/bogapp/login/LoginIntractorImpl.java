package mariam.berishvili.ge.bogapp.login;
import mariam.berishvili.ge.bogapp.api.Api;
import mariam.berishvili.ge.bogapp.model.login.ClientLoginInfo;
import mariam.berishvili.ge.bogapp.network.RetrofitProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginIntractorImpl implements LoginContract.UserInfoIntractor {
    @Override
    public void getLoginInfo(final OnFinishedListener onFinishedListener, String username, String password) {
        /** Create handle for the RetrofitInstance interface*/
        Api service = RetrofitProvider.getRetrofitInstance().create(Api.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<ClientLoginInfo> call = service.getClientLoginInfo(username, password);

        call.enqueue(new Callback<ClientLoginInfo>() {
            @Override
            public void onResponse(Call<ClientLoginInfo> call, Response<ClientLoginInfo> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<ClientLoginInfo> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }

        });

    }
}
