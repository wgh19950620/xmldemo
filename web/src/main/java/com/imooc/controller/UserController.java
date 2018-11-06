package com.imooc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import com.github.pagehelper.Page;
import com.imooc.dao.UserDAOImpl;
import com.imooc.entity.RestResponse;
import com.imooc.entity.SelectOrderCondition;
import com.imooc.entity.User;
import com.imooc.entity.page.PageInfo;
import com.imooc.service.UserService;

/**
 * @author wangguanghui
 */
@RestController
public class UserController {

    /**
     * 构造器方式注入
     */
    private final UserDAOImpl userDAOImpl;

    @Autowired
    private UserService userService;

    /**
     * 可写可不写
     *
     * @param userDAOImpl
     */
    @Autowired
    public UserController(UserDAOImpl userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }

    @PostMapping("/person/save")
    public RestResponse save(@RequestParam("name") String name) {
        User user = new User();

        user.setName(name);
        if (userDAOImpl.save(user)) {
            System.out.println("用户对象：保存成功");
            System.out.printf("用户对象：%s 保存成功! \n", user);
        }

        return RestResponse.success(user);
    }

    @GetMapping("/person/find/all")
    public Collection<User> find() {

        return userDAOImpl.findAll();
    }

    @PostMapping(value = "/findByPage")
    public RestResponse fingByPage(@RequestBody SelectOrderCondition condition, int pageNo, int pageSize) {

        Page<User> page = userService.findByPage(pageNo, pageSize);
        RestResponse response = RestResponse.success(new PageInfo<>(page));
        return response;
    }
}
