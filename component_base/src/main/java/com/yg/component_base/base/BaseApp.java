package com.yg.component_base.base;

import android.app.Application;

import com.yg.component_base.http.HttpHelper;
import com.yg.component_base.http.URL;

import java.util.List;


/**
 * Created by Administrator on 2018-12-12.
 */

public class BaseApp extends Application{
    public static final String ROOT_PACKAGE = "com.yg";
    private static BaseApp sInstance;

    private List<IApplicationDelegate> mAppDelegateList;


    public static BaseApp getIns() {
        return sInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        new HttpHelper.Builder(this)
                .initOkHttp()
                .createRetrofit(URL.BASE_URL)
                .build();

        mAppDelegateList = ClassUtils.getObjectsWithInterface(this, IApplicationDelegate.class, ROOT_PACKAGE);
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onCreate();
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTerminate();
        }
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onLowMemory();
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTrimMemory(level);
        }
    }
}
