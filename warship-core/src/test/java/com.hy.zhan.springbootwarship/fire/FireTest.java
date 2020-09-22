package com.hy.zhan.springbootwarship.fire;

import com.hy.zhan.springbootwarship.Fire;
import com.hy.zhan.springbootwarship.exception.CommonErrorCode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static com.hy.zhan.warshiptest.base.WarshipAssert.expectMessage;


/**
 * author: HyJame
 * date:   2020/5/2
 * desc:   TODO
 */
public class FireTest {

    @Test
    public void test_fire_error() {
        expectMessage(() -> Fire.error(CommonErrorCode.UNKNOWN_ERROR), CommonErrorCode.UNKNOWN_ERROR);
    }

    @Test
    public void test_fire_check_null() {
        expectMessage(() -> Fire.checkNull(null, CommonErrorCode.UNKNOWN_ERROR), CommonErrorCode.UNKNOWN_ERROR);
    }

    @Test
    public void test_fire_check_not_null() {
        expectMessage(() -> Fire.checkNotNull(new Object(), CommonErrorCode.UNKNOWN_ERROR), CommonErrorCode.UNKNOWN_ERROR);
    }

    @Test
    public void test_fire_check_empty() {
        expectMessage(() -> Fire.checkEmpty(null, CommonErrorCode.UNKNOWN_ERROR), CommonErrorCode.UNKNOWN_ERROR);
        expectMessage(() -> Fire.checkEmpty(new ArrayList<>(), CommonErrorCode.UNKNOWN_ERROR), CommonErrorCode.UNKNOWN_ERROR);
    }

    @Test
    public void test_fire_check_not_empty() {
        expectMessage(() -> Fire.checkNotEmpty(Collections.singleton(new Object()), CommonErrorCode.UNKNOWN_ERROR), CommonErrorCode.UNKNOWN_ERROR);
    }
}
