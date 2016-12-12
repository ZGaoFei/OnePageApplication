package com.zgf.onepageapplication;

import com.zgf.onepageapplication.net.RetrofitHelper;
import com.zgf.onepageapplication.presenter.MainPresenter;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by zgf on 2016/12/8.
 */

public class MainPresenterTest {
    private static RetrofitHelper retrofitHelper;

    @Test
    public void test() throws Exception {
        retrofitHelper = mock(RetrofitHelper.class);
        MainPresenter mainPresenter = new MainPresenter(retrofitHelper);

        mainPresenter.getTeaContent("b4f4ee31a8b9acc866ef2afb754c33e6", "json", "news.getSlideshow");
        verify(retrofitHelper).getTea("b4f4ee31a8b9acc866ef2afb754c33e6", "json", "news.getSlideshow");
    }

    @Test
    public void test2() throws Exception {
        MainPresenter mock = mock(MainPresenter.class);

        mock.getTeaContent("b4f4ee31a8b9acc866ef2afb754c33e6", "json", "news.getSlideshow");
        verify(mock).getTeaContent("b4f4ee31a8b9acc866ef2afb754c33e6", "json", "news.getSlideshow");
    }
}
