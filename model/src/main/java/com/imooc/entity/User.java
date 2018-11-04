package com.imooc.entity;

import lombok.Data;

/**
 * 用户模型
 *
 * @author wangguanghui
 */
@Data
public class User {
    private Integer id;

    /**
     * 用户名称
     */
    private String name;

    private Integer age;

    private String cupSize;

}
