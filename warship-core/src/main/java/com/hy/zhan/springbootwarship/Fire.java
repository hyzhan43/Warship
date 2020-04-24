package com.hy.zhan.springbootwarship;

import java.util.function.Supplier;

/**
 * author :  HyJame
 * date  :   2020/3/6
 * desc :    抛出异常类
 */
public class Fire {

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
