package com.one.netease.modular.base;

import com.one.netease.common.base.BaseApplication;
import com.one.netease.common.utils.RecordPathManager;
import com.one.netease.modular.MainActivity;
import com.one.netease.order.Order_MainActivity;
import com.one.netease.personal.Personal_MainActivity;

/**
 * @author diaokaibin@gmail.com on 2019-12-23.
 */
public class App extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        RecordPathManager.joinGroup("app","MainActivity", MainActivity.class);
        RecordPathManager.joinGroup("order","Order_MainActivity", Order_MainActivity.class);
        RecordPathManager.joinGroup("personal","Personal_MainActivity", Personal_MainActivity.class);
    }
}
