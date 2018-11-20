package com.imooc.config;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 省内地市配置
 *
 * @author xuliucong
 */
public class OrchProvinceConfiguration {
    /**
     * 平台地市代码 与 地市 对照表
     */
    private Map<String, String> areaCodeToComment = new ConcurrentHashMap<>();

    /**
     * 构造函数
     *
     * @param province 配置文件的 province 节点
     */
    public OrchProvinceConfiguration(XmlNodeOrch.XmlNodeProvince province) {
        province.getAreaCodes().forEach(areaCode -> areaCodeToComment
                        .put(StringUtils.trim(areaCode.getValue()), StringUtils.trim(areaCode.getComment())));
    }

    /**
     * 通过平台地市代码获取地市名称
     *
     * @param areaCode 平台地市代码
     * @return 对应地市名称
     */
    public String getAreaComment(String areaCode) {
        return areaCodeToComment.get(areaCode);
    }

    /**
     * 获取地市代码映射
     *
     * @return 地市代码映射
     */
    public Map<String, String> getAreaCodeMapping() {
        return new HashMap<>(areaCodeToComment);
    }
}
