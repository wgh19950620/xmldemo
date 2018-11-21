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

    /**
     * 通过姓名查询用户数据
     *
     * @param user 查询条件
     * @return 用户数据
     */
    User findByName(User user);
}
