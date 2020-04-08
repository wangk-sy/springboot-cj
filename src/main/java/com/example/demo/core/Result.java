package com.example.demo.core;

/**
 * @ClassName :Result
 * @Description :统一api响应结果封装
 * @Author :16388
 * @Date :2020/3/31 16:08
 * @Version :1.0
 **/
public class Result<T> {

    private int code;

    private String message;

    private T data;

    public int getCode() {
        return code;
    }

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }
}
