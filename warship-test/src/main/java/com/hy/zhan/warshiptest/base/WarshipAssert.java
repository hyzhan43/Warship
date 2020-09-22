package com.hy.zhan.warshiptest.base;

import com.hy.zhan.warshiptest.Action;
import com.hy.zhan.warshiptest.IErrorCode;

import static org.junit.jupiter.api.Assertions.*;

/**
 * author: HyJame
 * date:   2020/5/2
 * desc:   TODO
 */
public class WarshipAssert {

    public static void expectMessage(Action action, IErrorCode errorCode) {
        Exception exception = assertThrows(Exception.class, action::run);
        assertNotNull(exception.getMessage());
        assertEquals(errorCode.getMessage(), exception.getMessage());
    }
}
