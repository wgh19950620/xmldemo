package com.imooc.entity;

import lombok.Data;

/**
 * 工单查询条件
 * @author wangguanghui
 */
@Data
public class SelectOrderCondition {

    private String productType;

    private Integer areaCode;

    private Integer action;

    private Integer state;

    private String bizId;

    private String orderId;

    private String requestId;

    private String platformId;

    private String combinationTag;
}
