package com.imooc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallbackMessage {

    private String statusCode;

    private ReturnObject returnObj;

    @JsonIgnoreProperties()
    private class ReturnObject {
        private boolean handled;

        private String statusCode;

        private String returnObj;
    }
}
