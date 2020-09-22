package com.hy.zhan.springbootwarship.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hy.zhan.warshiptest.IErrorCode;
import com.hy.zhan.warshiptest.IResponse;
import lombok.Data;

/**
 * author :  HyJame
 * date  :   2020/3/27
 * desc :    tell me what
 */
@Data
public class Response<T> implements IResponse<T> {

    private final static int SUCCESS = 0;
    private final static int ERROR = -1;

    private int code;

    private String message;

    private T data;

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setCode(SUCCESS);
        response.setData(data);
        return response;
    }

    public static Response<Object> error(String message) {
        Response<Object> response = new Response<>();
        response.setCode(ERROR);
        response.setMessage(message);
        return response;
    }

    public static Response<Object> error(Integer code, String message) {
        Response<Object> response = new Response<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public static Response<Object> error(IErrorCode errorCode) {
        Response<Object> response = new Response<>();
        response.setCode(errorCode.getCode());
        response.setMessage(errorCode.getMessage());
        return response;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESS == this.code;
    }
}
