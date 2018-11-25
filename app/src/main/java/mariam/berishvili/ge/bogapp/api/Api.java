package mariam.berishvili.ge.bogapp.api;

import java.util.List;

import mariam.berishvili.ge.bogapp.model.actives.AssetsAndLiabilities;
import mariam.berishvili.ge.bogapp.model.cards.Card;
import mariam.berishvili.ge.bogapp.model.profile.ClientInfo;
import mariam.berishvili.ge.bogapp.model.login.ClientLoginInfo;
import mariam.berishvili.ge.bogapp.model.transactions.Transactions;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("api/Clients/Login/{username}/{password}")
    Call<ClientLoginInfo> getClientLoginInfo(@Path("username") String username,
                                             @Path("password") String password);

    @GET("api/Clients/ClientInfo/{sessionId}")
    Call<ClientInfo> getClientInfo();

    @GET("api/Products/AssetsAndLiabilities/{sessionId}")
    Call<AssetsAndLiabilities> getAssetsAndLiabilities();

    @GET("api/Products/Transactions/{sessionId}")
    Call<Transactions> getTransactions();

    @GET("api/Products/Cards/{sessionId}")
    Call<List<Card>> getCards();
}
