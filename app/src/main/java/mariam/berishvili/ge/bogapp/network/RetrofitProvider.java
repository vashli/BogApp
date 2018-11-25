package mariam.berishvili.ge.bogapp.network;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProvider {
    private static Retrofit retrofit;
    private static  final String BASE_URL = "https://api.fintech.ge/";
    public  static String session_id = "";

    public static Retrofit getRetrofitInstance(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url();
                if(!session_id.isEmpty()) {
                    url = url.newBuilder().addPathSegment(session_id).build();
                }
                request.newBuilder().addHeader("Content-Type", "application/json");
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        });

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }
}
