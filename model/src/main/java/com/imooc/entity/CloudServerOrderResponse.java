package com.imooc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 云网通开通接口响应报文
 * @author zoe
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloudServerOrderResponse {
    @JsonProperty(value = "network_status")
    private Map<String , Object> networkStatus;

    @JsonProperty(value = "server_status")
    private Map<String , Object> serverStatus;

    private String status;

    /**
     * 响应返回码
     * <p>
     *     子工单，三项同时成功才返回 成功
     *     三项有一项失败就返回 失败
     * </p>
     */
    private Integer code;

    /**
     * 响应返回码 常量表
     */
    public interface Code {
        /**
         * 成功
         */
        int SUCCESS = 1;

        /**
         * 失败
         */
        int FAIL = 2;
    }

    /**
     * 错误信息
     * <p>
     *     仅在 返回码为 失败 的情况下，才返回该字段
     * </p>
     */
    private String error;

    public boolean isSuccess() {
        return Integer.valueOf(Code.SUCCESS).equals(this.code);
    }

    @JsonProperty(value = "server_msg")
    private Map<String , Object> serverMsg;

    @JsonProperty(value = "network_msg")
    private Map<String , Object> networkMsg;
}
