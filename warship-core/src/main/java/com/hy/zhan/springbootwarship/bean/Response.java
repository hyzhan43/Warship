package com.hy.zhan.springbootwarship.bean;

import lombok.Data;

/**
 * author :  HyJame
 * date  :   2020/3/27
 * desc :    tell me what
 */
@Data
public class Response<T> {

    private final static int SUCCESS = 0;

    private Integer code;

    private String message;

    private T data;

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setCode(SUCCESS);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> error(String msg) {
        Response<T> response = new Response<>();
        response.setCode(SUCCESS);
        response.setMessage(msg);
        return response;
    }

    public boolean isSuccess() {
        return SUCCESS == code;
    }
}
