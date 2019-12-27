package com.one.netease.complier;

import com.google.auto.service.AutoService;
import com.one.netease.annotation.ARouter;
import com.one.netease.annotation.model.RouterBean;
import com.one.netease.complier.utils.Constants;
import com.one.netease.complier.utils.EmptyUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

/**
 * @author diaokaibin@gmail.com on 2019-12-24.
 */

@AutoService(Processor.class)
@SupportedAnnotationTypes(Constants.AROUTER_ANNOTATION_TYPES)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
// 接收build.gradle 传递过来的参数
@SupportedOptions({Constants.MODULE_NAME, Constants.APT_PACKAGE})
public class ARouterProcessor extends AbstractProcessor {


    private Elements elementUtils;


    private Types typeUtils;

    private Messager messager;

    private Filer filer;


    // 子模块名 如: app/order/personal 需要拼接类名时候用到ARouter$$Group$$order
    private String moduleName;


    // 包名,用于存放APT 生成的类文件
    private String packageNameForAPT;


    // 临时map存储，用来存放路由组Group对应的详细Path类对象，生成路由路径类文件时遍历
    // key:组名"app", value:"app"组的路由路径"ARouter$$Path$$app.class"
    private Map<String , List<RouterBean>> tempPathMap = new HashMap<>();


    // 临时map存储，用来存放路由Group信息，生成路由组类文件时遍历
    // key:组名"app", value:类名"ARouter$$Path$$app.class"
    private Map<String, String> tempGroupMap = new HashMap<>();


    @Override
    public synchronized void init(ProcessingEnvironment environment) {
        super.init(environment);

        elementUtils = environment.getElementUtils();
        typeUtils = environment.getTypeUtils();
        messager = environment.getMessager();
        filer = environment.getFiler();

        // 通过ProcessingEnvironment去获取对应的参数
        Map<String, String> options = environment.getOptions();
        if (!EmptyUtils.isEmpty(options)) {
            moduleName = options.get(Constants.MODULE_NAME);
            packageNameForAPT = options.get(Constants.APT_PACKAGE);
            // 有坑：Diagnostic.Kind.ERROR，异常会自动结束，不像安卓中Log.e
            messager.printMessage(Diagnostic.Kind.NOTE, "moduleName >>> " + moduleName);
            messager.printMessage(Diagnostic.Kind.NOTE, "packageNameForAPT >>> " + packageNameForAPT);
        }

        // 必传参数判空（乱码问题：添加java控制台输出中文乱码）
        if (EmptyUtils.isEmpty(moduleName) || EmptyUtils.isEmpty(packageNameForAPT)) {
            throw new RuntimeException("注解处理器需要的参数moduleName或者packageName为空，请在对应build.gradle配置参数");
        }

    }


    /**
     * 相当于main函数，开始处理注解
     * 注解处理器的核心方法，处理具体的注解，生成Java文件
     *
     * @param set         使用了支持处理注解的节点集合
     * @param environment 当前或是之前的运行环境,可以通过该对象查找的注解。
     * @return true 表示后续处理器不会再处理（已经处理完成）
     */
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment environment) {
        // 一旦有类 使用了ARouter
        if (!EmptyUtils.isEmpty(set)) {
            Set<? extends Element> elements = environment.getElementsAnnotatedWith(ARouter.class);
            if (!EmptyUtils.isEmpty(elements)) {
                parseElements(elements);
            }
        }
        return true;
    }

    private void parseElements(Set<? extends Element> elements) {

        // 获取Activity Call back 类型
        TypeElement activityType = elementUtils.getTypeElement(Constants.ACTIVITY);

//        // 显示类信息(获取被注解节点,类节点) 这里也叫字描述 Mirror
        TypeMirror activityMirror = activityType.asType();

        for (Element element : elements) {
            TypeMirror elementType = element.asType();

            messager.printMessage(Diagnostic.Kind.NOTE, " 遍历元素的信息为-->> " + activityMirror.toString());

            // 获取每个类上的ARouter的 注解 对应path 的值
            ARouter aRouter = element.getAnnotation(ARouter.class);

            // 路由的详细信息封装到实体类
            RouterBean bean = new RouterBean.Builder().setGroup(aRouter.group())
                    .setPath(aRouter.path())
                    .setElement(element)
                    .build();

            // 高级判断, @ARouter 注解只能用于类上,并且是规定的Activity
            if (typeUtils.isSubtype(elementType, activityMirror)) {
                bean.setType(RouterBean.Type.ACTIVITY);
            } else {
                throw new RuntimeException("@ARouter 注解目前仅限于用于Activity 之上");
            }

            // 赋值临时的map 存储以上信息,用来遍历时生成代码
            valueOfPathMap(bean);
        }

        // ARouterLoadGroup 和ARouterLoadPath 用来重新生成类文件,实现接口

        TypeElement groudLoadType = elementUtils.getTypeElement(Constants.AROUTE_GROUP);
        TypeElement pathLoadType = elementUtils.getTypeElement(Constants.AROUTE_PATH);

        // 1. 生成 路由的详细Path 类文件, 如ARouter$$Path$$app
        createPathFile(pathLoadType);

        // 2. 生成 路由组 Group 类文件
        createGroupFile(groudLoadType,pathLoadType);

    }

    private void createGroupFile(TypeElement groupType, TypeElement pathType) {


    }

    private void createPathFile(TypeElement pathType) {
        if (EmptyUtils.isEmpty(tempPathMap))return;


        // 方法的返回值 Map<String, RouterBean>

    }

    private void valueOfPathMap(RouterBean bean) {

        if (checkRouterPath(bean)) {
            messager.printMessage(Diagnostic.Kind.NOTE, " RouteBean >>> " + bean.toString());
            // 开始赋值
            List<RouterBean> routerBeans = tempPathMap.get(bean.getGroup());
            if (EmptyUtils.isEmpty(routerBeans)) {
                routerBeans = new ArrayList<>();
                routerBeans.add(bean);
                tempPathMap.put(bean.getGroup(), routerBeans);
            } else {
                // 找到key 直接加入临时集合
                for (RouterBean routerBean : routerBeans) {
                    if (!bean.getPath().equalsIgnoreCase(routerBean.getPath())) {
                        routerBeans.add(bean);
                    }
                }
            }

        } else {
            messager.printMessage(Diagnostic.Kind.NOTE,"@ARouter 注解未按规范使用,如/app/MainActivity");
        }

    }

    private boolean checkRouterPath(RouterBean bean) {
        String group = bean.getGroup();
        String path = bean.getPath();
        // @ARouter注解中的path值，必须要以 / 开头（模仿阿里Arouter规范）
        if (EmptyUtils.isEmpty(path) || !path.startsWith("/")) {
            messager.printMessage(Diagnostic.Kind.ERROR, "@ARouter注解中的path值，必须要以 / 开头");
            return false;
        }
        // 比如开发者代码为：path = "/MainActivity"，最后一个 / 符号必然在字符串第1位
        if (path.lastIndexOf("/") == 0) {
            // 架构师定义规范，让开发者遵循
            messager.printMessage(Diagnostic.Kind.ERROR, "@ARouter注解未按规范配置，如：/app/MainActivity");
            return false;
        }

        // 从第一个 / 到第二个 / 中间截取，如：/app/MainActivity 截取出 app 作为group
        String finalGroup = path.substring(1, path.indexOf("/", 1));

        // @ARouter注解中的group有赋值情况
        if (!EmptyUtils.isEmpty(group) && !group.equals(moduleName)) {
            // 架构师定义规范，让开发者遵循
            messager.printMessage(Diagnostic.Kind.ERROR, "@ARouter注解中的group值必须和子模块名一致！");
            return false;
        } else {
            bean.setGroup(finalGroup);
        }
        return true;
    }
}
