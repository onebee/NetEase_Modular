package com.one.netease.complier;

import com.google.auto.service.AutoService;
import com.one.netease.complier.utils.Constants;

import java.sql.Types;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/**
 * @author diaokaibin@gmail.com on 2019-12-30.
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes(Constants.PARAMETER_ANNOTATION_TYPES)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class ParameterProcessor extends AbstractProcessor {




    private Element elementUtils;
    private Types typeUtils;
    private Filer filer;

    private Messager messager;


    @Override
    public synchronized void init(ProcessingEnvironment environment) {
        super.init(environment);
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment environment) {
        return false;
    }
}
