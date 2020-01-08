package com.one.netease.arouter.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;

import com.one.netease.arouter.api.core.ARouterLoadGroup;
import com.one.netease.arouter.api.core.ARouterLoadPath;


/**
 * @author diaokaibin@gmail.com on 2020-01-08.
 */
public class RouterManager {

    // 路由组名
    private String group;

    // 路由Path 路径
    private String path;

    private static RouterManager instance;

    //Lru 缓存,key : 组名, value : 路由group 路径加载接口
    private LruCache<String, ARouterLoadGroup> groupLruCache;

    //
    private LruCache<String, ARouterLoadPath> pathLruCache;

    // APT 生成类文件 后缀名(包名拼接)
    private static final String GROUP_FILE_PREFIX_NAME = "ARouter$$Group$$";


    private RouterManager() {
        groupLruCache = new LruCache<>(163);
        pathLruCache = new LruCache<>(163);
    }

    public static RouterManager getInstance() {
        if (instance == null) {
            synchronized (RouterManager.class) {
                if (instance == null) {
                    instance = new RouterManager();
                }
            }
        }

        return instance;
    }

    /**
     * @param path 传递路由的地址
     * @return
     */
    public BundleManager build(String path) {

        if (TextUtils.isEmpty(path) || !path.startsWith("/")) {
            throw new IllegalArgumentException("请按规范配置,如:/app/MainActivity");
        }

        group = subFromPath2Group(path);
        this.path = path;
        return new BundleManager();
    }

    private String subFromPath2Group(String path) {
        if (path.lastIndexOf("/") == 0) {
            throw new IllegalArgumentException("请按规范配置,如:/app/MainActivity");
        }
        // 从第一个/ 到第二个/ 中间截取
        String finalGroup = path.substring(1, path.indexOf("/", 1));
        if (TextUtils.isEmpty(finalGroup)) {
            throw new IllegalArgumentException("请按规范配置,如:/app/MainActivity");
        }

        return finalGroup;
    }

    /**
     * @param context
     * @param manager
     * @param i
     * @return
     */
    public Object navigation(Context context, BundleManager manager, int i) {

        //ARouter$$Group$$order
        String groupClassName = context.getPackageManager() + ".apt." + GROUP_FILE_PREFIX_NAME + group;

        Log.i("netease >>>", groupClassName);

        // 读取路由组 Group 类文件(缓存 赖加载)
        ARouterLoadGroup groupLoad = groupLruCache.get(this.group);
        try {
            if (groupLoad == null) {

                // 加载APT 路由组Group 类文件ARouter$$Group$$personal

                Class<?> clazz = Class.forName(groupClassName);
                // 初始化类文件
                groupLoad = (ARouterLoadGroup) clazz.newInstance();
                groupLruCache.put(group, groupLoad);

            }

            if (groupLoad.loadGroup().isEmpty()) {
                throw new RuntimeException("路由表加载失败");
            }

            // 读取路由path 路径类文件缓存
            ARouterLoadPath pathLoad = pathLruCache.get(this.path);
            if (pathLoad == null) {

                // 通过组名Group 加载接口,获取Path 加载接口
                Class<? extends ARouterLoadPath> clazz = groupLoad.loadGroup().get(group);
                if (clazz != null)
                    pathLoad = clazz.newInstance();

                if (pathLoad != null) {
                    pathLruCache.put(group, pathLoad);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
