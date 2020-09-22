package com.hy.zhan.springbootwarship.exception;

import com.hy.zhan.warshiptest.IErrorCode;

/**
 * author :  HyJame
 * date  :   2020/3/27
 * desc :    tell me what
 */
public class BaseException extends RuntimeException {

    private final IErrorCode errorCode;

    public BaseException(IErrorCode errorCode) {
        super(errorCode.getMessage());

        this.errorCode = errorCode;
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
