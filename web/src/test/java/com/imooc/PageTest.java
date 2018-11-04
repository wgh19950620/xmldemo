package com.imooc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.imooc.entity.RestResponse;
import com.imooc.entity.User;
import com.imooc.entity.page.PageInfo;
import com.imooc.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PageTest {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        Page<User> page = userService.findByPage(1, 10);
        RestResponse response = RestResponse.success(new PageInfo<>(page));
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(response);
        System.out.println(jsonElement);
        System.out.println(response);
    }
}
