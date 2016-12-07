package com.zgf.onepageapplication.presenter;

import com.zgf.onepageapplication.base.RxPresenter;
import com.zgf.onepageapplication.contract.MainContract;
import com.zgf.onepageapplication.model.Tea;
import com.zgf.onepageapplication.net.RetrofitHelper;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 表示器
 */
public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{
    private RetrofitHelper retrofitHelper;

    @Inject
    public MainPresenter(RetrofitHelper retrofitHelper) {
        this.retrofitHelper = retrofitHelper;
    }

    @Override
    public void getTeaContent(String apiKey, String format, final String method) {
        Subscription subscribe = retrofitHelper
                .getTea(apiKey,
                        format,
                        method)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.io())
                .subscribe(new Action1<Tea>() {
                    @Override
                    public void call(Tea tea) {
                        mView.showContent(tea);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError(throwable.getMessage());
                    }
                });
        addSubscribe(subscribe);
    }
}
