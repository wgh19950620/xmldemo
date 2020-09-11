package com.imooc.enums;

import java.io.Serializable;

/**
 * 第三方公共枚举类
 *
 * @author wangguanghui
 */
public enum ThirdApplicationEnum implements Serializable {

    /**
     * 融合支付-ETS直连渠道
     */
    FUSION_PAY_ETS_CHANNEL(1, "融合支付-ETS直连渠道"),

    /**
     * 融合支付-威富通渠道
     */
    FUSION_PAY_SWIFT_PASS_CHANNEL(2, "融合支付-威富通渠道"),

    /**
     * 融合支付-建行
     */
    FUSION_PAY_DRAGON(3, "融合支付-建行"),

    /**
     * 融合支付-工行
     */
    FUSION_PAY_ICBC_CHANNEL(4, "融合支付-工行"),

    /**
     * 自助机威富通被扫充值渠道
     */
    SWIFT_PASS_CAD_PASSIVE_SACN_CHANNEL(5, "自助机威富通被扫充值渠道"),

    /**
     * 翼支付代扣
     */
    BESTPAY_WITHHOLD(6, "翼支付代扣"),

    /**
     * 微信刷脸代扣
     */
    WECHAT_BRUSH_FACE_WITHHOLD(7, "微信刷脸代扣"),

    /**
     * 支付宝刷脸代扣
     */
    ALIPAY_BRUSH_FACE_WITHHOLD(8, "支付宝刷脸代扣");

    private Integer value;

    private String description;

    ThirdApplicationEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
