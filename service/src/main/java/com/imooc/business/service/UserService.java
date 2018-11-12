package com.imooc.business.service;


import com.github.pagehelper.Page;
import com.imooc.entity.User;

/**
 * user service interface
 *
 * @author wangguanghui
 */
public interface UserService {

    /**
     * 用户分页
     *
     * @param pageNo   当前页
     * @param pageSize 当前页记录数
     * @return 分页数据
     */
    Page<User> findByPage(int pageNo, int pageSize);
}
