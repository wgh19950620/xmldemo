package com.imooc.config;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

import com.imooc.utils.ImportXml;

/**
 * ORCH xml 配置模型
 * <p>
 * XML 配置模型的说明全部写在 XML 文件注释中
 * </p>
 *
 * @author xuliucong
 */
@ImportXml(xml = "config/orch.xml", xsd = "config/orch.xsd")
@XmlRootElement(name = "orch")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlNodeOrch {

    @Getter
    private XmlNodeProvince province;

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class XmlNodeProvince {

        @Getter
        @XmlElementWrapper(name = "areaCodes")
        @XmlElement(name = "areaCode")
        private List<XmlNodeAreaCode> areaCodes;

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class XmlNodeAreaCode {

            @Getter
            @XmlAttribute
            private String value;

            @Getter
            @XmlAttribute
            private String comment;
        }
    }
}
