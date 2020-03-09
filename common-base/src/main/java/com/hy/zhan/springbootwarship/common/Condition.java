package com.hy.zhan.springbootwarship.common;

import java.util.Collection;

/**
 * author: HyJame
 * date:   2020/1/3
 * desc:   TODO
 */
public class Condition {

    public static void ifNull(Object object, Action action) {
        if (object == null) {
            action.run();
        }
    }

    public static void ifNonNull(Object object, Action action) {
        if (object != null) {
            action.run();
        }
    }

    public static void ifTrue(Boolean isTrue, Action action) {
        if (isTrue) {
            action.run();
        }
    }

    public static void ifFalse(Boolean isFalse, Action action) {
        if (isFalse) {
            action.run();
        }
    }

    public static <T> void ifEmpty(Collection<T> collection, Action action) {
        if (collection == null || collection.isEmpty()) {
            action.run();
        }
    }

    public static <T> void ifNotEmpty(Collection<T> collection, Action action) {
        if (collection != null && !collection.isEmpty()) {
            action.run();
        }
    }
}
