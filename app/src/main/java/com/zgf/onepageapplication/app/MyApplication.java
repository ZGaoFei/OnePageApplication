package com.zgf.onepageapplication.app;

import android.app.Activity;
import android.app.Application;

import com.zgf.onepageapplication.dagger.component.AppComponent;
import com.zgf.onepageapplication.dagger.component.DaggerAppComponent;
import com.zgf.onepageapplication.dagger.model.AppModel;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zgf on 2016/12/6.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;
    private Set<Activity> allActivities;

    public static synchronized MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;

        // 初始化一些操作

    }

    public void addActivity(Activity activity) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (allActivities != null) {
            allActivities.remove(activity);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity activity : allActivities) {
                    activity.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public static AppComponent getAppComponent() {
        return DaggerAppComponent
                .builder()
                .appModel(new AppModel(myApplication))
                .build();
    }
}
