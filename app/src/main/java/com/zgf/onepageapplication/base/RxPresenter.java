package com.zgf.onepageapplication.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zgf on 2016/12/7.
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {
    protected T mView;
    protected CompositeSubscription compositeSubscription;

    protected void unSubscribe() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
        }
    }

    /**
     * 线程安全、由所有订阅者组的组
     * 他将所有的订阅者都添加进去，然后再Activity onPause
     * 或者onDestroy时候统一取消订阅，避免造成内存泄漏
     */
    protected void addSubscribe(Subscription subscription) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscription);
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }
}
