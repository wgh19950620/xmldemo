package com.imooc.web.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.imooc.business.service.UserService;
import com.imooc.entity.RestResponse;
import com.imooc.entity.User;
import com.imooc.page.PageInfo;

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
    @ApiOperation(value = "用户分页", notes = "用户分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "当前页显示数", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/findByPage")
    public RestResponse findByPage(int pageNo, int pageSize) {

        Page<User> page = userServiceImpl.findByPage(pageNo, pageSize);
        RestResponse response = RestResponse.success(new PageInfo<>(page));
        return response;
    }

    /**
     * 测试post提交url拼接参数传递
     *
     * @param message 测试数据
     */
    @ApiOperation(value = "url测试", notes = "url测试")
    @ApiImplicitParam(name = "message", value = "测试数据", required = true, dataType = "String", paramType = "query")
    @PostMapping("/url/test")
    public void urlRequestParamTest(String message) {
        System.out.println(message);
    }

    /**
     * 测试post提交url拼接参数传递
     *
     * @param message 测试数据
     */
    @ApiOperation(value = "url测试", notes = "url测试")
    @ApiImplicitParam(name = "message", value = "测试数据", required = true, dataType = "String", paramType = "path")
    @PostMapping("/url/test/{message}")
    public void urlPathVariableTest(@PathVariable String message) {
        System.out.println(message);
    }
}
