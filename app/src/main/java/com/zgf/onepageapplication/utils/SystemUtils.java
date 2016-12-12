package com.zgf.onepageapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.zgf.onepageapplication.app.MyApplication;

/**
 * Created by zgf on 2016/12/7.
 */

public class SystemUtils {

    public static boolean isNetWorkConnected() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) MyApplication
                .getInstance()
                .getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
