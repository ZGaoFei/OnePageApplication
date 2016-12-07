package com.zgf.onepageapplication.app;

import java.io.File;

/**
 * 所有静态常量类
 */

public class Constants {

    //============== path =============
    public static final String PATH_DATA = MyApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

}
