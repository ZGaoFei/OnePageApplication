package com.zgf.onepageapplication.contract;

import com.zgf.onepageapplication.base.BasePresenter;
import com.zgf.onepageapplication.base.BaseView;
import com.zgf.onepageapplication.model.Tea;

/**
 * Created by zgf on 2016/12/6.
 */

public interface MainContract {

    interface View extends BaseView {
        void showContent(Tea tea);
    }

    interface Presenter extends BasePresenter<View> {
        void getTeaContent(String apiKey, String format, String method);
    }
}
