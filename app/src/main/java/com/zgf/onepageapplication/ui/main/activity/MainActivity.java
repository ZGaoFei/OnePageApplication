package com.zgf.onepageapplication.ui.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zgf.onepageapplication.R;
import com.zgf.onepageapplication.base.BaseActivity;
import com.zgf.onepageapplication.contract.MainContract;
import com.zgf.onepageapplication.model.Tea;
import com.zgf.onepageapplication.presenter.MainPresenter;
import com.zgf.onepageapplication.ui.main.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View{
    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;
    private MainAdapter adapter;
    private List<Tea.DataBean> list;

    private MainContract.Presenter presenter;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unSubscribe();
    }

    protected void initData() {
        new MainPresenter(this);

        presenter.getTeaContent("b4f4ee31a8b9acc866ef2afb754c33e6", "json", "news.getSlideshow");

        list = new ArrayList<>();
        adapter = new MainAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showContent(Tea tea) {
        adapter.update(tea.getData());
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
