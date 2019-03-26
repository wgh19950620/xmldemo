package com.imooc.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.imooc.business.service.UserService;
import com.imooc.entity.User;
import com.imooc.persistence.dao.UserDAO;

/**
 * user serviceImpl
 *
 * @author wangguanghui
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    /**
     * 用户分页
     *
     * @param pageNo   当前页
     * @param pageSize 当前页记录数
     * @return 分页数据
     */
    @Override
    public Page<User> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return userDAO.findByPage();
    }

    /**
     * 通过姓名查询用户数据
     *
     * @param user 查询条件
     * @return 用户数据
     */
    @Override
    public User findByName(User user) {
        return userDAO.findByName(user);
    }

    /**
     * 创建用户信息
     *
     * @param user 用户信息
     */
    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }
}
