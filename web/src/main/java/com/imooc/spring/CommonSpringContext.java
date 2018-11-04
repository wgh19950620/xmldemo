package com.imooc.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Properties;

/**
 * @author luyang
 *
 */
@Component
public class CommonSpringContext implements ApplicationContextAware {
    private static ApplicationContext context;

    private static Properties properties;

    @Override public void setApplicationContext(ApplicationContext context) throws BeansException {
        CommonSpringContext.context = context;
    }

    public void setProperties(Properties properties) {
        CommonSpringContext.properties = properties;
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    public static <T> Map<String , T> getBeansOfType(Class<T> tClass) {
        return context.getBeansOfType(tClass);
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }

    public static String getProperty(String name) {
        return properties.getProperty(name);
    }
}
