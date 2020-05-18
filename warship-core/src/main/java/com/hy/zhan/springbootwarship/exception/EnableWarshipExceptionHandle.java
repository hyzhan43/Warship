package com.hy.zhan.springbootwarship.exception;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * author: HyJame
 * date:   2020/5/3
 * desc:   TODO
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({WarshipExceptionHandlerSelector.class})
public @interface EnableWarshipExceptionHandle {
}
