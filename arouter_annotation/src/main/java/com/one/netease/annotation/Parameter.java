package com.one.netease.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author diaokaibin@gmail.com on 2019-12-30.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface Parameter {

    // 不填写 name 的注解值表示该属性名就算key,填了就算用注解值作为key
    // 从 getIntent() 方法中获取传递参数值
    String name()  default "";
}
