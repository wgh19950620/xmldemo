package com.imooc.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SsThirdApplication implements Serializable {
    private Integer id;

    private String legalPersonCode;

    private Integer applicationType;//第三方应用（1-支付宝扫码 2-微信扫码 3-银联扫码 4-翼支付扫码 5-威富通扫码 6-翼支付代扣,7-微信刷脸代扣）

    private String name;//应用名称

    private String mchNo;//商户号

    private String mchKey;//商户密钥

    private Date createTime;

    private Date updateTime;

    private Integer status;
    private String organizationId;
    private String mchName;
    private String mchSerialNo;

    private Integer opId;

    private String back1;

    private String back2;

    private String appid;//appid 支付宝 微信使用
    private String checkServiceUrl;//系统手动对账服务地址
    private String primarykey;//第三方签名公钥
    private String privatekey;//第三方签名私钥
    private String remotehost;//账单FTP地址
    private Integer remoteport;//账单FTP端口
    private String remoteftpuppath;//账单上传目录/地址
    private String remoteftpdownpath;//账单下载目录/地址
    private String remoteuser;//账单FTP用户名
    private String remotepass;//账单FTP密码
    private String serverurl;//交易服务地址
    private String notifyurl;//交易回调地址
}