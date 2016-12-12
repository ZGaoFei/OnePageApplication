package com.zgf.onepageapplication.dagger.component;

import android.app.Activity;

import com.zgf.onepageapplication.dagger.FragmentScope;
import com.zgf.onepageapplication.dagger.module.FragmentModule;

import dagger.Component;

/**
 * Created by zgf on 2016/12/12.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

    void inject(/*Fragment fragment*/);
}
