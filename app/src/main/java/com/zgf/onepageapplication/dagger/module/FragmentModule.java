package com.zgf.onepageapplication.dagger.module;

import android.app.Activity;
import android.app.Fragment;

import com.zgf.onepageapplication.dagger.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zgf on 2016/12/12.
 */

@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity providerActivity() {
        return fragment.getActivity();
    }
}
