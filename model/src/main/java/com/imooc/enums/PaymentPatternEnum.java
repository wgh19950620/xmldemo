package com.imooc.enums;

/**
 * 第三方支付类型枚举类
 *
 * @author wangguanghui
 */
public enum PaymentPatternEnum {

    /**
     * 支付宝被扫
     */
    ALIPAY_PASSIVE_SACN_ONE("1-1", 1, "支付宝被扫"),

    /**
     * 微信被扫
     */
    WECHAT_PASSIVE_SACN_ONE("1-1", 2, "微信被扫"),

    /**
     * 银联云闪付被扫
     */
    UNIONPAY_PASSIVE_SACN_ONE("1-1", 3, "银联云闪付被扫"),

    /**
     * 支付宝被扫
     */
    ALIPAY_PASSIVE_SACN_TWO("1-2", 1, "支付宝被扫"),

    /**
     * 微信被扫
     */
    WECHAT_PASSIVE_SACN_TWO("1-2", 2, "微信被扫"),

    /**
     * 银联云闪付被扫
     */
    UNIONPAY_PASSIVE_SACN_TWO("1-2", 3, "银联云闪付被扫"),

    /**
     * 支付宝主扫
     */
    ALIPAY_ACTIVE_SACN_ONE("2-1", 1, "支付宝主扫"),

    /**
     * 微信主扫
     */
    WECHAT_ACTIVE_SACN_ONE("2-1", 2, "微信主扫"),

    /**
     * 银联云闪付主扫
     */
    UNIONPAY_ACTIVE_SACN_ONE("2-1", 3, "银联云闪付主扫");

    private String code;

    private Integer value;

    private String description;

    PaymentPatternEnum(String code, Integer value, String description) {
        this.code = code;
        this.value = value;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
