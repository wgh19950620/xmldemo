package com.imooc.config;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 地市配置
 *
 * @author wangguanghui
 */
public final class OrchConfiguration {

    private static Logger logger = LoggerFactory.getLogger(OrchConfiguration.class);

    /**
     * province 配置
     */
    @Getter
    private OrchProvinceConfiguration province;

    /**
     * 构造函数
     *
     * @param orch 配置文件的 orch 节点
     */
    public OrchConfiguration(XmlNodeOrch orch) {
        province = new OrchProvinceConfiguration(orch.getProvince());
    }

    /**
     * 创建配置实例
     *
     * @see OrchConfiguration#OrchConfiguration(XmlNodeOrch)
     */
    public static OrchConfiguration make(XmlNodeOrch orch) {
        return new OrchConfiguration(orch);
    }

    /**
     * 初始化系统配置项
     */
    public void init() {
        logger.info("初始化[编排器]系统配置项");
    }
}
