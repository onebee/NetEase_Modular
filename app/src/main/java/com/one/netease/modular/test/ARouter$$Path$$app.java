package com.one.netease.modular.test;

import com.one.netease.annotation.model.RouterBean;
import com.one.netease.core.ARouterLoadPath;
import com.one.netease.modular.MainActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author diaokaibin@gmail.com on 2019-12-26.
 */
public class ARouter$$Path$$app implements ARouterLoadPath {

    @Override
    public Map<String, RouterBean> loadPath() {
        Map<String, RouterBean> pathMap = new HashMap<>();
        pathMap.put("/app/MainActivity",
                RouterBean.create(RouterBean.Type.ACTIVITY, MainActivity.class,

                "/app/MainActivity",
                "app"
                ));
        return pathMap;
    }
}
