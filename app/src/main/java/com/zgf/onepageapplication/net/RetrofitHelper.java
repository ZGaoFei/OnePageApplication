package com.zgf.onepageapplication.net;

import com.zgf.onepageapplication.model.Tea;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * 网络访问框架的辅助类
 */
public class RetrofitHelper {
    private static ApiService apiService;
    private static OkHttpClient client = null;

    public RetrofitHelper() {
        init();
    }

    private void init() {
        initOkhttp();

        apiService = getApiService();
    }

    private static void initOkhttp() {
        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    private static ApiService getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiPath.baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }

    public Observable<Tea> getTea(String apiKey, String format, String method) {
        return apiService.getTea(apiKey, format, method);
    }
}
