package com.hy.zhan.springbootwarship.controller;

import com.hy.zhan.springbootwarship.bean.Response;
import com.hy.zhan.springbootwarship.dto.LoginDTO;
import com.hy.zhan.springbootwarship.service.LoginService;
import com.hy.zhan.springbootwarship.vo.LoginVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * author :  HyJame
 * date  :   2020/3/27
 * desc :    登陆模块
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private final LoginService loginService;

    @RequestMapping("/login")
    public Response<LoginVO> login(@Valid @RequestBody LoginDTO loginDTO) {
        return Response.success(loginService.login(loginDTO));
    }
}
