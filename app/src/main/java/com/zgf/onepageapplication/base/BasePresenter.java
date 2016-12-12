package com.zgf.onepageapplication.base;

/**
 * Created by zgf on 2016/12/6.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void detachView();
}
