package com.one.netease.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author diaokaibin@gmail.com on 2019-12-23.
 * 全局路径记录器, 可根据子模块分组
 *
 */
public class RecordPathManager {

    /**
     * //key:"order"组，value：order子模块所有activity的路劲信息
     */
    private static Map<String, List<Pathbean>> groupMap = new HashMap<>();


    /**
     * 将路径信息加入全局Map
     *
     * @param groupName 组名，如："personal"
     * @param pathName  路劲名，如："Personal_MainActivity"
     * @param clazz     类对象，如：Personal_MainActivity.class
     */
    public static void joinGroup(String groupName, String pathName, Class<?> clazz) {
        List<Pathbean> list = groupMap.get(groupName);
        if (list == null) {
            list = new ArrayList<>();
            list.add(new Pathbean(pathName, clazz));
            groupMap.put(groupName, list);
        } else {
            groupMap.put(groupName, list);
        }
        groupMap.put(groupName, list);
    }

    /**
     * 根据组名和路径名获取类对象，达到跳转目的
     *
     * @param groupName 组名
     * @param pathName  路径名
     * @return 跳转目标的class类对象
     */
    public static Class<?> getTargetClass(String groupName, String pathName) {
        List<Pathbean> list = groupMap.get(groupName);
        if (list == null) return null;
        for (Pathbean path : list) {
            if (pathName.equalsIgnoreCase(path.getPath())) {
                return path.getClazz();
            }
        }
        return null;
    }

    /**
     * 清理、回收
     */
    public static void recycleGroup() {
        groupMap.clear();
        groupMap = null;
        System.gc();
    }
}
