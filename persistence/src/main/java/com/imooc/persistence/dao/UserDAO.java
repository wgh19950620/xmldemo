package com.imooc.persistence.dao;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.imooc.entity.User;

/**
 * user DAO
 *
 * @author wangguanghui
 */
@Repository
public interface UserDAO {

    /**
     * 分页查询
     *
     * @return
     */
    Page<User> findByPage();
}
