package com.imooc.web.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImportXml {
    /**
     * xml 文件路径
     */
    String xml() default "#";

    /**
     * xsd 文件路径
     */
    String xsd() default "#";
}
