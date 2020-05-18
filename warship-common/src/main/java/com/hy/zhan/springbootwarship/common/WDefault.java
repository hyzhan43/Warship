package com.hy.zhan.springbootwarship.common;

import org.springframework.util.StringUtils;

/**
 * author :  HyJame
 * date  :   2019/11/28
 * desc :    默认参数初始化
 */
public class WDefault {

    public static <T> T initIfNull(T t, T defValue) {
        if (t == null) return defValue;
        return t;
    }

    public static String initIfEmpty(String t, String defValue) {
        if (StringUtils.isEmpty(t)) return defValue;
        return t;
    }
}
