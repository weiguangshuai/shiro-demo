package com.cqupt.weigs.shirodemo.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author weigs
 * @date 2018/11/11 0011
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(){

    }

    private Result(int code) {
        this.code =code;
    }

    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    private Result(int code, T data) {
        this.code = code;
        this.data = data;
    }


    public static <T> Result<T> success(T data) {
        return new Result<>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T>Result<T> error(String msg) {
        return new Result<>(ResponseCode.ERROR.getCode(), msg);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getT() {
        return data;
    }
}
