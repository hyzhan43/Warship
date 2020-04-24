package com.hy.zhan.springbootwarship.common;

/**
 * author :  HyJame
 * date  :   2019/11/28
 * desc :    默认参数初始化
 */
public class WDefault {

    public static <T> T init(T t, T defValue) {
        if (t == null) return defValue;
        return t;
    }
}
