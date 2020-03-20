package com.hy.zhan.springbootwarship.admin.controller;

import com.hy.zhan.springbootwarship.admin.bean.Response;
import com.hy.zhan.springbootwarship.admin.bean.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author :  HyJame
 * date  :   2020/3/20
 * desc :    登录 Controller
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public Response login(User user) {
        return new Response("Hello", 1);
    }
}
