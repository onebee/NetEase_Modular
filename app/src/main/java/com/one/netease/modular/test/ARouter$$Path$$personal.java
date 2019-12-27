package com.one.netease.modular.test;

import com.one.netease.annotation.model.RouterBean;
import com.one.netease.core.ARouterLoadPath;
import com.one.netease.personal.Personal_MainActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author diaokaibin@gmail.com on 2019-12-26.
 */
public class ARouter$$Path$$personal implements ARouterLoadPath {

    @Override
    public Map<String, RouterBean> loadPath() {
        Map<String, RouterBean> pathMap = new HashMap<>();
        pathMap.put("/personal/Personal_MainActivity",
                RouterBean.create(RouterBean.Type.ACTIVITY, Personal_MainActivity.class,

                "/personal/Personal_MainActivity",
                "personal"
                ));
        return pathMap;
    }
}
