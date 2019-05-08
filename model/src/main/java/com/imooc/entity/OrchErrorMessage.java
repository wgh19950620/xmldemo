package com.imooc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 编排器错误信息
 *
 * @author wangguanghui
 */


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrchErrorMessage {

    /**
     * 错误码
     */
    @JsonProperty("err_code")
    private String errorCode;

    /**
     * 错误信息
     */
    @JsonProperty("err_msg")
    private String errorMessage;
}
