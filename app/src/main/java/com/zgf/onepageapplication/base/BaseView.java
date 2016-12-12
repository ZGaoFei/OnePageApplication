package com.zgf.onepageapplication.base;

/**
 * Created by zgf on 2016/12/6.
 */

public interface BaseView {
    void showError(String msg);

    // 应用于全局的设置夜间模式
    void useNightMode(boolean isNight);
}
