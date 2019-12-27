package com.one.netease.complier.utils;

/**
 * @author diaokaibin@gmail.com on 2019-12-24.
 */
public class Constants {

    /**
     * 注解处理器支持的注解类型
     */
    public static final String AROUTER_ANNOTATION_TYPES = "com.one.netease.annotation.ARouter";

    /**
     * 每个子模块的模块名
     */
    public static final String MODULE_NAME = "module_name";

    /**
     * 用于存放APT 生成的类文件
     */
    public static final String APT_PACKAGE = "packageNameForAPT";

    // Activity全类名
    public static final String ACTIVITY = "android.app.Activity";

    // 包名前缀封装
    static final String BASE_PACKAGE = "com.one.netease.arouter.api";
    // 路由组Group加载接口

    public static final String AROUTE_GROUP = BASE_PACKAGE + ".core.ARouterLoadGroup";
    // 路由组Group对应的详细Path加载接口

    public static final String AROUTE_PATH = BASE_PACKAGE + ".core.ARouterLoadPath";

}
