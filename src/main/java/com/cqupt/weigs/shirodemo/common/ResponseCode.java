package com.cqupt.weigs.shirodemo.common;

/**
 * @author weigs
 * @date 2018/11/11 0011
 */
public enum ResponseCode {
    SUCCESS(200,"success"),
    ERROR(500,"error");
    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
