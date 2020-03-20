package com.hy.zhan.springbootwarship.admin.bean;

import lombok.Data;

/**
 * author :  HyJame
 * date  :   2020/3/20
 * desc :    tell me what
 */
@Data
public class Response {

    private String message;

    private Integer code;

    public Response(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
