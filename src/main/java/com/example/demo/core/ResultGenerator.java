package com.example.demo.core;

/**
 * @ClassName :ResultGenerator
 * @Description :响应结果生成工具
 * @Author :16388
 * @Date :2020/3/31 16:17
 * @Version :1.0
 **/
public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";


    public static Result genSuccessResult(){
        return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
}
