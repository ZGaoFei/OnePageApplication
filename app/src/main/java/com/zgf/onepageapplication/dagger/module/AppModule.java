package com.zgf.onepageapplication.dagger.module;

import com.zgf.onepageapplication.app.MyApplication;
import com.zgf.onepageapplication.dagger.ContextLife;
import com.zgf.onepageapplication.net.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zgf on 2016/12/7.
 */

@Module
public class AppModule {
    private final MyApplication application;

    public AppModule(MyApplication myApplication) {
        this.application = myApplication;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    public MyApplication providerApplication() {
        return application;
    }

    @Provides
    @Singleton
    public RetrofitHelper providerRetrofit() {
        return new RetrofitHelper();
    }
}
