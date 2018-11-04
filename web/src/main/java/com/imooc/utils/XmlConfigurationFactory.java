package com.imooc.utils;

import org.apache.commons.lang3.StringUtils;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * XML 配置数据读取工厂
 * @author zoe
 */
public final class XmlConfigurationFactory {
    /**
     * 缓存
     */
    private static final Map<Class<?> , Object> CACHE = new ConcurrentHashMap<>();

    /**
     * 构造函数
     */
    private XmlConfigurationFactory() {
        super();
    }

    /**
     * @see XmlConfigurationFactory#init(Class, Map)
     */
    public static <T> T init(Class<T> clazz) {
        return init(clazz , null);
    }

    /**
     * 初始化指定配置类
     * <p>
     *     此方法仅会初始化一次配置类，之后总是从缓存中读取配置结果，不推荐修改初始化数据
     * </p>
     * @param clazz 模型类元
     * @param xmlReplacer 数据定义文件切换配置
     * @param <T> 模型类
     * @return 初始化好的配置类
     */
    public static <T> T init(Class<T> clazz , Map<String , String> xmlReplacer) {
        if (CACHE.containsKey(clazz)) {
            //noinspection unchecked
            return (T)CACHE.get(clazz);
        }

        T target = null;

        if (clazz.isAnnotationPresent(ImportXml.class)) {
            String xml = clazz.getAnnotation(ImportXml.class).xml();
            String xsd = clazz.getAnnotation(ImportXml.class).xsd();

            if (null != xmlReplacer && xmlReplacer.size() > 0) {
                String replacer = xmlReplacer.get(xml);

                if (StringUtils.isNotBlank(replacer)) {
                    xml = replacer;
                }
            }

            InputStream xmlInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(xml);
            InputStream xsdInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(xsd);

            boolean noErrors = false;

            try {
                SchemaFactory factory =
                                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                Schema schema = factory.newSchema(new StreamSource(xsdInputStream));
                Validator validator = schema.newValidator();
                validator.validate(new StreamSource(xmlInputStream));

                noErrors = true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (!noErrors) {
                throw new RuntimeException("XML Configuration file: " + xml + " can not validated.");
            }


            try {
                xmlInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(xml);

                JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                //noinspection unchecked
                target = (T) jaxbUnmarshaller.unmarshal(xmlInputStream);
            } catch (JAXBException e) {
                e.printStackTrace();
                throw new RuntimeException("XML Configuration file: " + xml + " reading error.");
            }

            CACHE.put(clazz , target);
        }

        return target;
    }
}
