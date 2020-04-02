package com.hy.zhan.springbootwarship.exception;

/**
 * author :  HyJame
 * date  :   2020/4/1
 * desc :    tell me what
 */
public enum ErrorCode {
    SERVER_ERROR(-1, "服务器内部异常"),
    UNKNOWN_ERROR(-2, "未知异常"),
    PARAMETER(-3, "参数异常"),
    HTTP_METHOD_ERROR(-4, "http请求方式错误"),
    ;

    private Integer code;

    private String desc;

    ErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
