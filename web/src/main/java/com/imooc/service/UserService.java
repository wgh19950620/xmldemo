package com.imooc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.imooc.dao.UserDAO;
import com.imooc.entity.User;

/**
 * @author wangguanghui
 */
@Service
public class UserService {

    @Autowired
    public UserDAO userDAO;

    public Page<User> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return userDAO.findByPage();
    }
}
