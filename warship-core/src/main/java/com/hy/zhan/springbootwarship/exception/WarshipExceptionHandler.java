package com.hy.zhan.springbootwarship.exception;

import com.hy.zhan.springbootwarship.bean.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * author：  HyZhan
 * create：  2018/11/6 21:00
 * desc：    全局异常处理
 */
@Slf4j
@ControllerAdvice
public class WarshipExceptionHandler {

    // 捕获自定义异常   响应状态码 -> 200
    @ResponseBody
    @ExceptionHandler(BaseException.class)
    public Response<Object> handle(BaseException e) {
        return Response.error(e.getErrorCode());
    }

    /**
     * 添加 @Valid 注解后, 并且 application-json 形式入参, 校验失败会抛出此异常
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<Object> jsonHandle(MethodArgumentNotValidException e) {
        e.printStackTrace();

        BindingResult bindingResult = e.getBindingResult();
        // 获取参数错误信息
        FieldError fieldError = bindingResult.getFieldError();
        if (fieldError != null) {
            String msg = fieldError.getField() + fieldError.getDefaultMessage();
            return Response.error(CommonErrorCode.PARAMETER.getCode(), msg);
        }

        return Response.error(CommonErrorCode.PARAMETER);
    }

    /**
     * 添加 @Valid 注解, 并且 form-data 形式入参, 校验失败会抛出此异常
     */
    @ResponseBody
    @ExceptionHandler(BindException.class)
    public Response<Object> formDataHandle(BindException e) {
        e.printStackTrace();

        if (!e.hasErrors() || e.getFieldError() == null) {
            return Response.error(CommonErrorCode.PARAMETER);
        }

        FieldError fieldError = e.getFieldError();
        return Response.error(CommonErrorCode.PARAMETER.getCode(), fieldError.getDefaultMessage());
    }

    /**
     * 没有传 requestBody 会抛出此异常
     */
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response<Object> methodHandle(HttpMessageNotReadableException e) {
        e.printStackTrace();

        return Response.error(CommonErrorCode.PARAMETER);
    }

    /**
     * 请求 http 方法不匹配时, 抛出此异常
     */
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response<Object> httpHandle(HttpRequestMethodNotSupportedException e) {
        e.printStackTrace();

        return Response.error(CommonErrorCode.HTTP_METHOD_ERROR);
    }

    /**
     * 捕获 服务器内部异常  状态码 -> 500
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<Object> handle(Exception e) {
        e.printStackTrace();
        return Response.error(CommonErrorCode.SERVER_ERROR);
    }
}
