package com.zgf.onepageapplication.dagger.component;

import com.zgf.onepageapplication.app.MyApplication;
import com.zgf.onepageapplication.dagger.ContextLife;
import com.zgf.onepageapplication.dagger.model.AppModel;
import com.zgf.onepageapplication.net.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zgf on 2016/12/7.
 */

@Singleton
@Component(modules = AppModel.class)
public interface AppComponent {

    @ContextLife("Application")
    MyApplication getApplication();

    RetrofitHelper getRetrofit();
}
