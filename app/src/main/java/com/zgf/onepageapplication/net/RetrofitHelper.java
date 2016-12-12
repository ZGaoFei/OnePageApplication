package com.zgf.onepageapplication.net;

import com.zgf.onepageapplication.app.Constants;
import com.zgf.onepageapplication.model.Tea;
import com.zgf.onepageapplication.utils.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
//        initOkhttp();
        initOkHttp();

        apiService = getApiService();
    }

    /**
     * 没有设置缓存
     */
    private static void initOkhttp() {
        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    /**
     * 设置缓存
     */
    private static void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!SystemUtils.isNetWorkConnected()) {
                    request = request
                            .newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (SystemUtils.isNetWorkConnected()) {
                    int maxAge = 0;
                    // 有网络时, 不缓存, 最大保存时长为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }

                return response;
            }
        };
        Interceptor apikey = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                request = request.newBuilder()
//                        .addHeader("apikey",Constants.KEY_API)
//                        .addHeader("X-LC-Id",Constants.LEANCLOUD_ID)
//                        .addHeader("X-LC-Sign",Constants.LEANCLOUD_SIGN)
                        .build();

                return chain.proceed(request);
            }
        };

//        builder.addInterceptor(apikey);
        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);

        client = builder.build();
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
