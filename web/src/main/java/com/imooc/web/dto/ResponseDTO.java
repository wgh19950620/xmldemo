package com.imooc.web.dto;

import lombok.Data;

@Data
public class ResponseDTO {

    private Integer code;

    private String desc;

    private Object data;

    public ResponseDTO() {
    }

    public ResponseDTO(Integer code, String desc, Object data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public ResponseDTO(ResultCode resultCode) {
        this.code = resultCode.getStatus();
        this.desc = resultCode.getMessage();
    }

    public ResponseDTO(ResultCode resultCode, Object data) {
        this.code = resultCode.getStatus();
        this.desc = resultCode.getMessage();
        this.data = data;
    }

    /**
     * 判断结果是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        return code.intValue() == 0;
    }

    /**
     * 请求成功
     *
     * @return
     */
    public static ResponseDTO ok(String desc) {
        return new ResponseDTO(CommonRestCodeEnum.OK.getStatus(), desc, null);
    }

    public static ResponseDTO ok(Object data) {
        return new ResponseDTO(CommonRestCodeEnum.OK, data);
    }

    /**
     * 请求失败
     *
     * @param desc
     * @return
     */
    public static ResponseDTO error(String desc) {
        return new ResponseDTO(CommonRestCodeEnum.FAIL.getStatus(), desc, null);
    }
}
