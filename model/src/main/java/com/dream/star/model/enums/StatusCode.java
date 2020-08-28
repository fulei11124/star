package com.dream.star.model.enums;

/**
 * 服务接口响应状态码枚举类
 */
public enum StatusCode {
    ERROR(500, "服务器错误，请联系管理员!"),
    SUCCESS(200, "请求成功!"),
    EXTERNAL_SERVER(2002, "请求外部服务错误!"),
    DATA_NULL(1000,"请求数据为空!"),
    PARAM_ERROR(1001, "参数错误!"),
    NOT_LOGIN(1010, "用户未登录！！");

    private final Integer code;
    private final String msg;

    StatusCode(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}