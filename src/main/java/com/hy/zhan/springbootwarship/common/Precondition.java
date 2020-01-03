package com.hy.zhan.springbootwarship.common;

import java.util.Collection;

/**
 * author: HyJame
 * date:   2020/1/3
 * desc:   TODO
 */
public class Precondition {

    public static void ifTrue(Boolean isTrue, Action action) {
        if (isTrue) {
            action.run();
        }
    }

    public static void ifFalse(Boolean isTrue, Action action) {
        if (isTrue) {
            action.run();
        }
    }

    public static void ifEmpty(Collection collection, Action action) {
        if (collection.isEmpty()) {
            action.run();
        }
    }

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
}
