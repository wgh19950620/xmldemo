package com.imooc.contants;

/**
 * 第三方公共常量类
 *
 * @author wangguanghui
 */
public final class ThirdApplicationConstants {

    /**
     * 融合支付-ETS直连渠道
     */
    public final static Integer FUSION_PAY_ETS_CHANNEL = 1;

    /**
     * 融合支付-威富通渠道
     */
    public final static Integer FUSION_PAY_SWIFT_PASS_CHANNEL = 2;

    /**
     * 融合支付-建行
     */
    public final static Integer FUSION_PAY_DRAGON = 3;

    /**
     * 融合支付-工行
     */
    public final static Integer FUSION_PAY_ICBC_CHANNEL = 4;

    /**
     * 自助机威富通被扫充值渠道
     */
    public final static Integer SWIFT_PASS_CAD_PASSIVE_SACN_CHANNEL = 5;

    /**
     * 翼支付代扣
     */
    public final static Integer BESTPAY_WITHHOLD = 6;

    /**
     * 微信刷脸代扣
     */
    public final static Integer WECHAT_BRUSH_FACE_WITHHOLD = 7;

    /**
     * 支付宝刷脸代扣
     */
    public final static Integer ALIPAY_BRUSH_FACE_WITHHOLD = 8;

    private ThirdApplicationConstants() {
        throw new IllegalAccessError();
    }
}
