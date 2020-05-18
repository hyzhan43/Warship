package com.hy.zhan.springbootwarship.exception;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * author: HyJame
 * date:   2020/5/3
 * desc:   TODO
 */
public class WarshipExceptionHandlerSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{WarshipExceptionHandler.class.getName()};
    }
}
