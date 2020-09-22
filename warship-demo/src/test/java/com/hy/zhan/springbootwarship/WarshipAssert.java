package com.hy.zhan.springbootwarship;

import com.hy.zhan.springbootwarship.common.Action;
import com.hy.zhan.warshiptest.IErrorCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * author: HyJame
 * date:   2020/5/2
 * desc:   TODO
 */
public class WarshipAssert {

    public static void expectMessage(Action action, IErrorCode errorCode) {
        Exception exception = assertThrows(Exception.class, action::run);
        assertEquals(errorCode.getMessage(), exception.getMessage());
    }
}
