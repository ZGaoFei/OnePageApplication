package com.zgf.onepageapplication.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * 图片加载类
 */

public class ImageLoader {
    public static void load(Context context, String url, ImageView view) {
        Glide.with(context).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(view);
    }

}
