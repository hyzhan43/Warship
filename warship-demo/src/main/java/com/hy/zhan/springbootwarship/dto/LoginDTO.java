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

    @NotNull
    private String username;

    @NotNull
    private String password;
}
