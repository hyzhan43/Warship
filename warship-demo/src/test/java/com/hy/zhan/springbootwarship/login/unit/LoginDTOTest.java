package com.hy.zhan.springbootwarship.login.unit;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hy.zhan.springbootwarship.BaseRequestTest;
import com.hy.zhan.springbootwarship.bean.Response;
import com.hy.zhan.springbootwarship.dto.LoginDTO;
import com.hy.zhan.springbootwarship.service.LoginService;
import com.hy.zhan.springbootwarship.vo.LoginVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * author :  HyJame
 * date  :   2020/4/1
 * desc :    tell me what
 */
public class LoginDTOTest extends BaseRequestTest {

    @MockBean
    private LoginService loginService;

    @Test
    public void test_user_dto_validate() {
        when(loginService.login(any())).thenReturn(new LoginVO());
        LoginDTO loginDTO = new LoginDTO();
        request("/login", loginDTO, new TypeReference<Response<LoginVO>>() {
        });

    }
}
