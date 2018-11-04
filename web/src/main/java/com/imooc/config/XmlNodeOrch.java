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
 *     XML 配置模型的说明全部写在 XML 文件注释中
 * </p>
 * @author zoe
 */
@ImportXml(xml = "config/orch.xml" , xsd = "config/orch.xsd")
@XmlRootElement(name = "orch")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlNodeOrch {
    @Getter
    private XmlNodePon pon;

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class XmlNodePon {

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
            private String cityCode;

            @Getter
            @XmlAttribute
            private String comment;
        }

        @Getter
        @XmlElementWrapper(name = "bandwidths")
        @XmlElement(name = "bandwidth")
        private List<XmlNodePonBandwidth> bandwidths;

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class XmlNodePonBandwidth {

            @Getter
            @XmlAttribute
            private Integer value;

            @Getter
            @XmlAttribute
            private Integer code;
        }
    }

    @Getter
    private XmlNodeIpran ipran;

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class XmlNodeIpran {
        @Getter
        @XmlElementWrapper(name = "bandwidths")
        @XmlElement(name = "bandwidth")
        private List<XmlNodeIpranBandwidth> bandwidths;

        public static class XmlNodeIpranBandwidth {

            @Getter
            @XmlAttribute
            private Integer value;

            @Getter
            @XmlAttribute
            private Integer code;
        }
    }

    @Getter
    private XmlNodeFilter filters;

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class XmlNodeFilter {
        @Getter
        @XmlElement(name = "replace")
        private List<XmlNodeReplace> replaces;

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class XmlNodeReplace {
            @Getter
            @XmlAttribute
            private String id;

            @Getter
            @XmlElement(name = "from")
            private List<String> froms;

            @Getter
            private String to;
        }
    }

    @Getter
    private XmlNodeVpn vpn;

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class XmlNodeVpn {

        @Getter
        @XmlElement(name = "define")
        private List<XmlNodeDefine> defines;

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class XmlNodeDefine {
            @Getter
            @XmlAttribute
            private String cloud;

            @Getter
            @XmlAttribute
            private String type;

            @Getter
            @XmlAttribute
            private String action;

            @Getter
            @XmlElement(name = "property")
            private List<XmlNodeProperty> properties;

            @XmlAccessorType(XmlAccessType.FIELD)
            public static class XmlNodeProperty {
                @Getter
                @XmlAttribute
                private String name;

                @Getter
                @XmlAttribute
                private String type;

                @Getter
                @XmlAttribute
                private String optional;

                @Getter
                @XmlAttribute
                private String filter;

                @Getter
                @XmlAttribute
                private String limit;
            }
        }
    }
}
