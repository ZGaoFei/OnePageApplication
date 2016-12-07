package com.zgf.onepageapplication.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zgf.onepageapplication.R;
import com.zgf.onepageapplication.model.Tea;
import com.zgf.onepageapplication.utils.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{
    private Context context;
    private List<Tea.DataBean> list;

    public MainAdapter(Context context, List<Tea.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void update(List<Tea.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false);
        MainViewHolder vh = new MainViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        ImageLoader.load(context, list.get(position).getImage(), holder.imageView);
        holder.textView.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_main_item)
        TextView textView;
        @BindView(R.id.iv_main_item)
        ImageView imageView;

        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
