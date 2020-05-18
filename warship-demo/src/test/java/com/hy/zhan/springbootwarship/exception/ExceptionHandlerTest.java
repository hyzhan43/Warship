package com.hy.zhan.springbootwarship.exception;

import com.hy.zhan.springbootwarship.Fire;
import org.junit.jupiter.api.Test;

import static com.hy.zhan.springbootwarship.base.WarshipAssert.expectMessage;


/**
 * author: HyJame
 * date:   2020/5/3
 * desc:   TODO
 */
public class ExceptionHandlerTest {

    @Test
    public void test_exception_handler() {
        expectMessage(() -> Fire.error(CommonErrorCode.HTTP_METHOD_ERROR), CommonErrorCode.HTTP_METHOD_ERROR);
    }
}
