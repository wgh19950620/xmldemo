package com.imooc.web;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Test
    public void test1() {

        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setAge(10 + i);
            user.setName("zhangsan" + i);
            list.add(user);
        }
        System.out.println("list: " + list);

        Optional<User> optionalUser = list.stream().filter(existUser -> "zhangsan2".equals(existUser.getName())).findFirst();

        if(optionalUser.isPresent()) {
            User user1 = optionalUser.get();
            System.out.println("user1: " + user1);
        }

        List<User> collect = list.stream().filter(existUser -> "zhangsan3".equals(existUser.getName())).collect(Collectors.toList());
        System.out.println("collect: " + collect);

        List<Integer> integerList = list.stream().map(User::getId).collect(Collectors.toList());
        System.out.println("integerList: " + integerList);
    }
}
