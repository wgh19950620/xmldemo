package com.imooc.entity;

import lombok.Data;

/**
 * rest响应
 *
 * @author wuliang
 */
@Data
public class RestResponse {

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应码常量表
     */
    public interface Code {
        /**
         * 响应码常量：成功
         */
        Integer SUCCESS = 0;

        /**
         * ：失败
         */
        Integer ERROR = 1;

    }

    /**
     * 附加数据
     */
    private Object data;


    /**
     * 使用消息文本生成错误响应对象
     *
     * @param code    编码
     * @param message 消息
     */
    public RestResponse(int code, String message) {
        super();

        this.code = code;
        this.msg = message;
    }

    public RestResponse(int code, String message, Object data) {
        super();
        this.data = data;
        this.code = code;
        this.msg = message;
    }

    /**
     * 使用消息文本生成错误响应对象
     *
     * @param message 消息文本
     * @return 响应对象
     */
    public static RestResponse error(String message) {
        return new RestResponse(Code.ERROR, message);
    }

    /**
     * 使用消息文本生成成功响应对象
     *
     * @param message 消息文本
     * @return 响应对象
     */
    public static RestResponse success(String message) {
        return new RestResponse(Code.SUCCESS, message);
    }

    public static RestResponse success(Object data) {
        return new RestResponse(Code.SUCCESS, "", data);
    }

}
