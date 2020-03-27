package com.hy.zhan.springbootwarship.controller;

import com.hy.zhan.springbootwarship.bean.Response;
import com.hy.zhan.springbootwarship.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author :  HyJame
 * date  :   2020/3/27
 * desc :    tell me what
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    public Response<String> login(@RequestBody User user) {
        return Response.success("Hello");
    }
}
