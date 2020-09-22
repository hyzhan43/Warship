package com.hy.zhan.springbootwarship.exception;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * author: HyJame
 * date:   2020/5/3
 * desc:   开启 Warship 异常拦截器, 捕获通用异常
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({WarshipExceptionHandlerSelector.class})
public @interface EnableWarshipExceptionHandle {
}
