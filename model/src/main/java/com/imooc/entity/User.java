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
    private Integer classId;
    private Integer courseId;

    private String name;

    private Integer age;
    private Integer isValidate;
    private String username;
    private String password;

    private String identity;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
