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
    public static final String MODULE_NAME = "moduleName";

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

    // 路由组Group，参数名
    public static final String GROUP_PARAMETER_NAME = "groupMap";
    // 路由组Group，方法名
    public static final String GROUP_METHOD_NAME = "loadGroup";
    // 路由组Group对应的详细Path，参数名
    public static final String PATH_PARAMETER_NAME = "pathMap";
    // 路由组Group对应的详细Path，方法名
    public static final String PATH_METHOD_NAME = "loadPath";


    // APT生成的路由组Group源文件名
    public static final String GROUP_FILE_NAME = "ARouter$$Group$$";
    // APT生成的路由组Group对应的详细Path源文件名
    public static final String PATH_FILE_NAME = "ARouter$$Path$$";

}
