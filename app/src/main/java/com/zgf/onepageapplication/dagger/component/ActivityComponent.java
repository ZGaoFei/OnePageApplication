package com.zgf.onepageapplication.dagger.component;

import android.app.Activity;

import com.zgf.onepageapplication.dagger.ActivityScope;
import com.zgf.onepageapplication.dagger.module.ActivityModule;
import com.zgf.onepageapplication.ui.main.activity.MainActivity;

import dagger.Component;

/**
 * Created by zgf on 2016/12/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(MainActivity mainActivity);
}
