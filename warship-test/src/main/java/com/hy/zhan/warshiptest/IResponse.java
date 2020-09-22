package com.hy.zhan.warshiptest;

/**
 * author :  HyJame
 * date  :   2020/3/27
 * desc :    tell me what
 */
public interface IResponse<T> {

    boolean isSuccess();

    T getData();
}
