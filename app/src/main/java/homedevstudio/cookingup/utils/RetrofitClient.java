package homedevstudio.cookingup.utils;

import homedevstudio.cookingup.service.ApiService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by xdewnik on 27.08.2017.
 */

public class RetrofitClient {

    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(Urls.HOST)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }


    public static ApiService getApiService(){
        return getRetrofitInstance().create(ApiService.class);

    }
}
