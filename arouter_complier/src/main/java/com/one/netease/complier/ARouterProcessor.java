package com.one.netease.complier;

import com.google.auto.service.AutoService;
import com.one.netease.annotation.ARouter;
import com.one.netease.complier.utils.Constants;
import com.one.netease.complier.utils.EmptyUtils;

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
@SupportedOptions({Constants.MODULE_NAME,Constants.APT_PACKAGE})
public class ARouterProcessor extends AbstractProcessor {



    private Elements elementUtils;


    private Types typeUtils;

    private Messager messager;

    private Filer filer;



    // 子模块名 如: app/order/personal 需要拼接类名时候用到ARouter$$Group$$order
    private String moduleName;


    // 包名,用于存放APT 生成的类文件
    private String packageNameForAPT;



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

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment environment) {
       // 一旦有类 使用了ARouter
        if (!EmptyUtils.isEmpty(set)) {
            Set<? extends Element> elements = environment.getElementsAnnotatedWith(ARouter.class);
            if (!EmptyUtils.isEmpty(elements)) {
                parseElements(elements);
            }
        }
        return true ;
    }

    private void parseElements(Set<? extends Element> elements) {

    }
}
