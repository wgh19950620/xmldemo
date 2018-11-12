package com.imooc.web;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OtherTest {

    @Test
    public void test() {
        User user = new User("lisi", 18, "A");
        User copyUser = new User();
        BeanUtils.copyProperties(user, copyUser);
        System.out.println(user);
        System.out.println(copyUser);
        Assert.assertEquals(user, copyUser);
    }
}
