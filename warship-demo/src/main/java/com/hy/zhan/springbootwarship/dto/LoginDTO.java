package com.hy.zhan.springbootwarship.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * author :  HyJame
 * date  :   2020/3/27
 * desc :    tell me what
 */
@Data
public class LoginDTO {

    @NotNull(message = "username 不能为空")
    private String username;

    @NotNull(message = "password 不能为空")
    private String password;
}
