package com.one.netease.annotation.model;

import javax.lang.model.element.Element;

/**
 * @author diaokaibin@gmail.com on 2019-12-24.
 */
public class RouterBean {

    public enum Type{
        ACTIVITY
    }

    // 枚举类型
    private Type type;

    // 类节点
    private Element element;

    // 被@ARouter 注解的类对象
    private Class<?> clazz;

    // 路由的组名
    private String group;

    // 路由的地址
    private String path;


    private RouterBean(Builder builder) {
        this.element = builder.element;
        this.group = builder.group;
        this.path = builder.path;

    }

    private RouterBean(Type type, Class<?> clazz, String path, String group) {
        this.type = type;
        this.clazz = clazz;
        this.path = path;
        this.group = group;
    }


    // 对外提供简单的实例化方法
    public static RouterBean create(Type type, Class<?> clazz, String path, String group) {
        return new RouterBean(type, clazz, path, group);
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Type getType() {
        return type;
    }

    public Element getElement() {
        return element;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public String getGroup() {
        return group;
    }

    public String getPath() {
        return path;
    }

    public final static class Builder {

        // 类节点
        private Element element;
        // 路由的组名
        private String group;

        // 路由的地址
        private String path;


        public Builder setElement(Element element) {
            this.element = element;
            return this;
        }

        public Builder setGroup(String group) {
            this.group = group;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        // 最后的一个方法build 或者 create 方法,往往是做参数的校验和初始化操作
        public RouterBean build() {
            if (path == null || path.length() == 0) {
                throw new IllegalArgumentException("path 必填项为空,如 /app/MainActivity");
            }
            return new RouterBean(this);
        }

    }

    @Override
    public String toString() {
        return "RouterBean{" +
                "group='" + group + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
