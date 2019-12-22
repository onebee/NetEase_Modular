package com.one.netease.common.base;

import android.app.Application;
import android.util.Log;

import com.one.netease.common.utils.Cons;

/**
 * @author diaokaibin@gmail.com on 2019-12-22.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(Cons.TAG,"common/BaseApplication");

    }
}

