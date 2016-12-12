package com.zgf.onepageapplication;

import com.zgf.onepageapplication.net.RetrofitHelper;
import com.zgf.onepageapplication.presenter.MainPresenter;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by zgf on 2016/12/8.
 */

public class TestMainPresenter {

    @Test
    public void testGetTeaContent() throws Exception {
        RetrofitHelper mock = Mockito.mock(RetrofitHelper.class);
        MainPresenter mainPresenter = new MainPresenter(mock);

        mainPresenter.getTeaContent("b4f4ee31a8b9acc866ef2afb754c33e6", "json", "news.getSlideshow");
        Mockito.verify(mock).getTea("b4f4ee31a8b9acc866ef2afb754c33e6", "json", "news.getSlideshow");
    }
}
