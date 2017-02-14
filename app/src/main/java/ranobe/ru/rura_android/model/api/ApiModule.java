package ranobe.ru.rura_android.model.api;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class ApiModule {

  private static final boolean ENABLE_AUTH = false;
  private static final String AUTH_64 = "***"; //your code here


  public static ApiInterface getApiInterface() {

    OkHttpClient httpClient = new OkHttpClient();
    httpClient.interceptors().add(chain -> {
      Request original = chain.request();
      Request request = original.newBuilder()
          .method(original.method(), original.body())
          .build();

      return chain.proceed(request);
    });


    Retrofit.Builder builder = new Retrofit.Builder().
        baseUrl("http://ruranobe.ru/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    if (ENABLE_AUTH) builder.client(httpClient);

    return builder.build().create(ApiInterface.class);
  }
}
