package com.imooc.enums;

import lombok.Getter;
import lombok.Setter;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 工单导出名称
 *
 * @author wangguanghui
 */
public enum OrderType {

    /**
     * 天翼云新装主机
     */
    CT_YUN_HWS_CREATE_VM("天翼云工单信息（订购主机）"),

    /**
     * 天翼云主机升级系统磁盘
     */
    CT_YUN_HWS_UPGRADE_SYSTEM_DISK("天翼云工单信息（升级系统磁盘）"),

    /**
     * 天翼云主机升级规格
     */
    CT_YUN_HWS_UPGRADE_FLAVOR("天翼云工单信息（升级规格）"),

    /**
     * 天翼云主机降级规格
     */
    CT_YUN_HWS_DEGRADE_FLAVOR("天翼云工单信息（降级规格）"),

    /**
     * 天翼云主机切换系统
     */
    CT_YUN_HWS_CHANGE_OS("天翼云工单信息（切换系统）"),

    /**
     * 天翼云主机系统重装
     */
    CT_YUN_HWS_RESET_OS("天翼云工单信息（系统重装）"),

    /**
     * 天翼云主机新装带宽
     */
    CT_YUN_HWS_PURCHASE_NETWORK("天翼云工单信息（订购带宽）"),

    /**
     * 天翼云主机升级带宽
     */
    CT_YUN_HWS_UPGRADE_NETWORK("天翼云工单信息（升级带宽）"),

    /**
     * 天翼云主机降级带宽
     */
    CT_YUN_HWS_DEGRADE_NETWORK("天翼云工单信息（降级带宽）"),

    /**
     * 天翼云主机拆除带宽
     */
    CT_YUN_HWS_RELEASE_NETWORK("天翼云工单信息（拆带宽）"),

    /**
     * 天翼云主机添加数据磁盘
     */
    CT_YUN_HWS_ADD_DATA_DISK("天翼云工单信息（订购数据磁盘）"),

    /**
     * 天翼云主机升级数据磁盘
     */
    CT_YUN_HWS_UPGRADE_DATA_DISK("天翼云工单信息（升级数据磁盘）"),

    /**
     * 天翼云主机拆数据磁盘
     */
    CT_YUN_HWS_RELEASE_DATA_DISK("天翼云工单信息（拆数据磁盘）"),

    /**
     * 天翼云hws拆除主机
     */
    CT_YUN_HWS_RELEASE_VM("天翼云工单信息（拆主机）"),

    /**
     * 天翼云vms拆除主机
     */
    CT_YUN_VMS_RELEASE_VM("天翼云工单信息（拆主机）"),

    /**
     * 省内新装编排器IPRAN
     */
    ORCH_IPRAN_CREATE_VPN("编排器工单信息（新装）"),

    /**
     * 省内变更用户侧地址段IPRAN
     */
    ORCH_IPRAN_MODIFY_USER_ADDR("编排器工单信息（变更地址段）"),

    /**
     * 省内变更速率IPRAN
     */
    ORCH_IPRAN_MODIFY_BANDWIDTH("编排器工单信息（变更速率）"),

    /**
     * 省内拆除编排器IPRAN
     */
    ORCH_IPRAN_RELEASE_VPN("编排器工单信息（拆机）"),

    /**
     * 省内新装编排器PON
     */
    ORCH_PON_CREATE_VPN("编排器工单信息（新装）"),

    /**
     * 省内变更用户侧地址段PON
     */
    ORCH_PON_MODIFY_USER_ADDR("编排器工单信息（变更地址段）"),

    /**
     * 省内变更速率PON
     */
    ORCH_PON_MODIFY_BANDWIDTH("编排器工单信息（变更速率）"),

    /**
     * 省内拆除编排器PON
     */
    ORCH_PON_RELEASE_VPN("编排器工单信息（拆机）"),

    /**
     * 集团新装云调
     */
    DCI_CREATE_VPN("云调工单信息（新装）"),

    /**
     * 集团新装云调报竣
     */
    DCI_CREATE_NOTICE_VPN("云调工单信息（新装报竣）"),

    /**
     * 集团变更客户侧地址段云调
     */
    DCI_MODIFY_USER_ADDR("云调工单信息（变更地址段）"),

    /**
     * 集团变更客户侧地址段云调报竣
     */
    DCI_MODIFY_USER_ADDR_NOTICE("云调工单信息（变更地址段报竣）"),

    /**
     * 集团变更速率
     */
    DCI_MODIFY_BANDWIDTH("云调工单信息（变更速率）"),

    /**
     * 集团变更速率云调报竣
     */
    DCI_MODIFY_BANDWIDTH_NOTICE("云调工单信息（变更速率报竣）"),

    /**
     * 集团拆除云调
     */
    DCI_RELEASE_VPN("云调工单信息（拆机）"),

    /**
     * 集团拆除云调失败
     */
    DCI_ERROR_RELEASE_VPN("云调工单信息（拆机失败）"),

    /**
     * 集团拆除云调报竣
     */
    DCI_RELEASE_NOTICE_VPN("云调工单信息（拆机报竣）"),


    /**
     * 集团拆除云调报竣
     */
    DCI_ERROR_RELEASE_NOTICE_VPN("云调工单信息（拆机失败报竣）"),

    /**
     * 天翼云2.0新装主机
     */
    CT_YUN_VMS_CREATE_VM("天翼云工单信息（订购主机）");

    private static final Map<String, String> FILENAME = new HashMap<>();

    static {
        for (OrderType orderType : EnumSet.allOf(OrderType.class)) {
            FILENAME.put(orderType.name(), orderType.getOrderFileName());
        }
    }

    @Setter
    @Getter
    private String orderFileName;

    OrderType(String orderFileName) {
        this.orderFileName = orderFileName;
    }

    public static String getFileName(String orderType) {
        System.out.println("filename：" + FILENAME.get(orderType));
        return FILENAME.get(orderType);
    }

}
