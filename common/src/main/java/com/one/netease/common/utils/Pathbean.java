package com.one.netease.common.utils;

/**
 * @author diaokaibin@gmail.com on 2019-12-23.
 * 路径对象
 */
public class Pathbean {

    private String path;
    private Class clazz;

    public Pathbean() {
    }

    public Pathbean(String path, Class clazz) {
        this.path = path;
        this.clazz = clazz;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
