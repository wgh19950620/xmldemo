package com.imooc.enums;

/**
 * 第三方支付类型枚举类
 *
 * @author wangguanghui
 */
public enum PaymentChannelEnum {

    /**
     * ETS直连渠道
     */
    ETS_DIRECT_CONNECTION_CHANNEL(1, 1, "ETS直连渠道"),

    /**
     * 威富通渠道
     */
    SWIFT_PASS_CHANNEL_ONE(1, 2, "威富通渠道"),

    /**
     * 威富通渠道
     */
    SWIFT_PASS_CHANENEL_TOW(2, 1, "威富通渠道"),

    /**
     * 翼支付代扣
     */
    BESTPAY_WITHHOLD(3, 1, "翼支付代扣"),

    /**
     * 支付宝人脸代扣
     */
    ALIPAY_BRUSH_FACE_WITHHOLD(4, 1, "支付宝人脸代扣"),

    /**
     * 微信人脸代扣
     */
    WECHAT_BRUSH_FACE_WITHHOLD(4, 2, "微信人脸代扣");

    private Integer code;
    private Integer value;

    private String description;

    PaymentChannelEnum(Integer code, Integer value, String description) {
        this.code = code;
        this.value = value;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
