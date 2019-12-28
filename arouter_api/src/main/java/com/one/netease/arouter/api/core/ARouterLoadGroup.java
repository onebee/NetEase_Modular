package com.one.netease.arouter.api.core;

import java.util.Map;

/**
 * @author diaokaibin@gmail.com on 2019-12-24.
 *
 * 路由组 对外提供加载数据接口
 */
public interface ARouterLoadGroup {

    Map<String,Class<? extends ARouterLoadPath>> loadGroup();

}
