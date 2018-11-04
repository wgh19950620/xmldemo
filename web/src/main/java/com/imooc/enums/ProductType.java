package com.imooc.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 产品类型
 * @author wangguanghui
 */
public enum ProductType {

    /**
     * 全部产品类型
     */
    ALL("全部"),

    CTYUN_VM("天翼云主机"),

    CTYUN_PON_VPN("天翼云PON专线"),

    CTYUN_IPRAN_VPN("天翼云IPRAN专线");

    @Getter
    @Setter
    private String typeName;


    ProductType(String typeName) {
        this.typeName = typeName;
    }
}
