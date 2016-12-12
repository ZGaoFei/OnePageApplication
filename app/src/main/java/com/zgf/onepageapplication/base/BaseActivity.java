package com.zgf.onepageapplication.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Toast;

import com.zgf.onepageapplication.app.MyApplication;
import com.zgf.onepageapplication.dagger.component.ActivityComponent;
import com.zgf.onepageapplication.dagger.component.DaggerActivityComponent;
import com.zgf.onepageapplication.dagger.module.ActivityModule;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{
    @Inject
    protected T mPresenter;
    protected Activity context;
    protected Unbinder unbinder;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        unbinder = ButterKnife.bind(this);
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

        MyApplication.getInstance().addActivity(this);
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unbinder.unbind();
        MyApplication.getInstance().removeActivity(this);
    }

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent
                .builder()
                .appComponent(MyApplication.getAppComponent())
                .activityModel(getActivityModel())
                .build();
    }

    protected ActivityModule getActivityModel() {
        return new ActivityModule(context);
    }

    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    protected abstract void initInject();
    protected abstract int getLayout();
    protected abstract void initEventAndData();
}
