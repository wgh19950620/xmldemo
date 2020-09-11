package com.imooc.enums;

/**
 * 第三方支付类型枚举类
 *
 * @author wangguanghui
 */
public enum PaymentTypeEnum {

    /**
     * 二维码被扫
     */
    QR_CODE_PASSIVE_SACN(1, "二维码被扫"),

    /**
     * 二维码主扫
     */
    QR_CODE_ACTIVE_SCAN(2, "二维码主扫"),

    /**
     * 二维码代扣
     */
    QR_CODE_WITHHOLD(3, "二维码代扣"),

    /**
     * 人脸代扣
     */
    FACE_WITHHOLD(4, "人脸代扣");

    private Integer value;

    private String description;

    PaymentTypeEnum(Integer value, String description) {
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
