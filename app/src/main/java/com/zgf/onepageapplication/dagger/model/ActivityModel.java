package com.zgf.onepageapplication.dagger.model;

import android.app.Activity;

import com.zgf.onepageapplication.dagger.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zgf on 2016/12/7.
 */

@Module
public class ActivityModel {
    Activity activity;

    public ActivityModel(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity providerActivity() {
        return activity;
    }
}
