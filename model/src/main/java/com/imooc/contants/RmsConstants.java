package com.imooc.contants;


import com.imooc.config.OrchConfiguration;
import com.imooc.config.XmlConfigurationFactory;
import com.imooc.config.XmlNodeOrch;

/**
 * rms常量
 *
 * @author wangguanghui
 */
public interface RmsConstants {
    /**
     * orch配置项
     */
    OrchConfiguration ORCH_CONFIGURATION = OrchConfiguration.make(XmlConfigurationFactory.init(XmlNodeOrch.class));
}
