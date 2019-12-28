package com.one.netease.modular.test;

import com.one.netease.arouter.api.core.ARouterLoadGroup;
import com.one.netease.arouter.api.core.ARouterLoadPath;

import java.util.HashMap;
import java.util.Map;

/**
 * @author diaokaibin@gmail.com on 2019-12-26.
 *
 *
 */
public class ARouter$$Group$$order implements ARouterLoadGroup {
    @Override
    public Map<String, Class<? extends ARouterLoadPath>> loadGroup() {

        Map<String, Class<? extends ARouterLoadPath>> groupMap = new HashMap<>();
        groupMap.put("order",ARouter$$Path$$order.class);

        return groupMap;
    }
}
