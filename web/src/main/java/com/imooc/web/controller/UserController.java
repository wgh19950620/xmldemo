package com.imooc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.imooc.entity.RestResponse;
import com.imooc.page.PageInfo;
import com.imooc.business.service.UserService;
import com.imooc.entity.User;

/**
 * @author wangguanghui
 */
@RestController
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    /**
     * 用户分页
     *
     * @param pageNo   当前页
     * @param pageSize 当前页记录数
     * @return 分页数据
     */
    @GetMapping(value = "/findByPage")
    public RestResponse findByPage(int pageNo, int pageSize) {

        Page<User> page = userServiceImpl.findByPage(pageNo, pageSize);
        RestResponse response = RestResponse.success(new PageInfo<>(page));
        return response;
    }
}
