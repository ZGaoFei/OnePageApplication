package com.zgf.onepageapplication.net;

import com.zgf.onepageapplication.model.Tea;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 网络访问接口
 */
public interface ApiService {

    @GET(ApiPath.mainUrl)
    Observable<Tea> getTea(
            @Query("apikey") String apiKey,
            @Query("fromat") String format,
            @Query("method") String method
    );
}
