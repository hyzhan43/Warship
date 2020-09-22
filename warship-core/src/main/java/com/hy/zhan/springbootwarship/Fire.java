package com.hy.zhan.springbootwarship;

import com.hy.zhan.springbootwarship.exception.BaseException;
import com.hy.zhan.springbootwarship.exception.CommonErrorCode;
import com.hy.zhan.warshiptest.IErrorCode;

import java.util.Collection;

/**
 * author :  HyJame
 * date  :   2020/3/6
 * desc :    抛出异常类
 */
public class Fire {

    public static void error(IErrorCode errorCode) {
        throw new BaseException(errorCode);
    }

    public static void checkNull(Object o, IErrorCode errorCode) {
        if (o == null){
            Fire.error(errorCode);
        }
    }

    public static void checkNotNull(Object o, IErrorCode errorCode) {
        if (o != null){
            Fire.error(errorCode);
        }
    }

    public static <T> void checkEmpty(Collection<T> collection, CommonErrorCode errorCode) {
        if (collection == null || collection.isEmpty()){
            Fire.error(errorCode);
        }
    }

    public static <T> void checkNotEmpty(Collection<T> collection, CommonErrorCode errorCode) {
        if (collection != null && !collection.isEmpty()){
            Fire.error(errorCode);
        }
    }


    /**
     * try {
     * return Integer.parseInt(value);
     * } catch (Exception e) {
     * e.printStackTrace();
     * Shift.fatal(PARK_SETTING_VALUE_IS_NOT_INTEGER);
     * return 0;
     * }
     */
//    public static <T> T checkThrow(Supplier<T> supplier, T defValue, StatusCode statusCode) {
//        try {
//            return supplier.get();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Shift.fatal(statusCode);
//            return defValue;
//        }
//    }
//
//    public static void checkThrow(Actuator actuator, StatusCode statusCode) {
//        try {
//            actuator.execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Shift.fatal(statusCode);
//        }
//    }


}
