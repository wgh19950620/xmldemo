package com.imooc.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 工单查询字段
 * @author wangguanghui
 */
public enum KeyWordType {

    /**
     * 查询关键字
     */
    ALL("全部", "KeyWordTypeAll"),

    BIZID("bizId", "KeyWordTypeBizId"),

    REQUEST_ID("请求ID", "KeyWordTypRequestId"),

    ORDER_ID("工单ID", "KeyWordTypeOrderId"),

    PLATFORM_ID("成员接入号", "KeyWordTypePlatformId"),

    COMBINATION_TAG("组合接入号", "KeyWordTypeCombinationTag");

    @Getter
    @Setter
    private String KeyWordTypeName;

    @Getter
    @Setter
    private String KeyWordTypeCode;

    KeyWordType(String KeyWordTypeName, String KeyWordTypeCode) {
        this.KeyWordTypeName = KeyWordTypeName;
        this.KeyWordTypeCode = KeyWordTypeCode;
    }

}
