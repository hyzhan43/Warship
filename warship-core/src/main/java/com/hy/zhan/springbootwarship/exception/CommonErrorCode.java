package com.hy.zhan.springbootwarship.exception;

import com.hy.zhan.springbootwarship.IErrorCode;

/**
 * author :  HyJame
 * date  :   2020/4/1
 * desc :    通用异常状态码
 */
public enum CommonErrorCode implements IErrorCode {
    SERVER_ERROR(-1, "服务器内部异常"),
    UNKNOWN_ERROR(-2, "未知异常"),
    PARAMETER(-3, "参数异常"),
    HTTP_METHOD_ERROR(-4, "http请求方式错误"),
    ;

    private final int code;

    private final String message;

    CommonErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
