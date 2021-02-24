package com.imooc.web.dto;

/**
 * http请求状态
 */
public enum CommonRestCodeEnum implements ResultCode {

    OK(0, "success"),

    FAIL(-1, "失败"),

    ;

    private final int status;

    private final String message;

    CommonRestCodeEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getStatus() {
        return status;
    }
}
