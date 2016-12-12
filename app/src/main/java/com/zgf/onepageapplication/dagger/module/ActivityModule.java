package com.zgf.onepageapplication.dagger.module;

import android.app.Activity;

import com.zgf.onepageapplication.dagger.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zgf on 2016/12/7.
 */

@Module
public class ActivityModule {
    Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity providerActivity() {
        return activity;
    }
}
