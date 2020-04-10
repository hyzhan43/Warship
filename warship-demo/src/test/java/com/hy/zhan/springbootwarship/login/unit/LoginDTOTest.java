package com.hy.zhan.springbootwarship.login.unit;

import com.hy.zhan.springbootwarship.BaseRequestTest;
import com.hy.zhan.springbootwarship.bean.Response;
import com.hy.zhan.springbootwarship.dto.LoginDTO;
import com.hy.zhan.springbootwarship.exception.ErrorCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * author :  HyJame
 * date  :   2020/4/1
 * desc :    tell me what
 */
public class LoginDTOTest extends BaseRequestTest {

    @Test
    public void test_user_dto_validate() {
        Response<Object> response = request("/login", new LoginDTO());
        assertEquals(ErrorCode.PARAMETER.getCode(), response.getCode());
    }
}
