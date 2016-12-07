package com.zgf.onepageapplication.presenter;

import android.util.Log;

import com.zgf.onepageapplication.contract.MainContract;
import com.zgf.onepageapplication.model.Tea;
import com.zgf.onepageapplication.net.RetrofitHelper;

import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 表示器
 */
public class MainPresenter implements MainContract.Presenter{
    private RetrofitHelper retrofitHelper;
    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        retrofitHelper = new RetrofitHelper();
        this.view = view;
        view.setPresenter(this);
    }

    public MainPresenter(RetrofitHelper retrofitHelper) {
        this.retrofitHelper = retrofitHelper;
    }

    @Override
    public void getTeaContent(String apiKey, String format, String method) {
        retrofitHelper
                .getTea(apiKey,
                        format,
                        method)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.io())
                .subscribe(new Action1<Tea>() {
                    @Override
                    public void call(Tea tea) {
                        view.showContent(tea);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e("=======", throwable.getMessage());
                    }
                });
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }
}
