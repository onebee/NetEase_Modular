package com.one.netease.arouter.api.core;

import com.one.netease.annotation.model.RouterBean;

import java.util.Map;

/**
 * @author diaokaibin@gmail.com on 2019-12-24.
 *
 * 路由组对应的详细Path 加载数据接口
 * 比如: app 分组对应有哪些类需要加载
 */

public interface ARouterLoadPath {

    Map<String, RouterBean> loadPath();

}
