package com.imooc.dao;

import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;
import com.imooc.entity.User;

/**
 * user DAO
 * @author wangguanghui
 */
@Component
public interface UserDAO {
    /**
     * 分页查询
     * @return
     */
    Page<User> findByPage();
}
