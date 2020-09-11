package com.imooc.web;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.imooc.entity.CallbackMessage;
import com.imooc.entity.CloudServerOrderResponse;
import com.imooc.entity.OrchErrorMessage;
import com.imooc.entity.User;
import com.imooc.utils.JsonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OtherTest {

    @Test
    public void test() {
        User user = new User("lisi", 18);
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

        Optional<User> optionalUser =
                        list.stream().filter(existUser -> "zhangsan2".equals(existUser.getName())).findFirst();

        if (optionalUser.isPresent()) {
            User user1 = optionalUser.get();
            System.out.println("user1: " + user1);
        }

        List<User> collect = list.stream().filter(existUser -> "zhangsan3".equals(existUser.getName()))
                        .collect(Collectors.toList());
        System.out.println("collect: " + collect);

        List<Integer> integerList = list.stream().map(User::getId).collect(Collectors.toList());
        System.out.println("integerList: " + integerList);
    }

    @Test
    public void test2() {
        Map<String, Object> errorMap = new HashMap<>();
        OrchErrorMessage orchErrorMessage = new OrchErrorMessage();
        orchErrorMessage.setErrorCode("1002");
        orchErrorMessage.setErrorMessage("ip地址冲突");

        errorMap.put("error", new Gson().toJson(orchErrorMessage));
        //        String error = new Gson().toJson(errorMap.get("error"));

        Optional<OrchErrorMessage> errorMessage =
                        JsonUtil.parseObject(errorMap.get("error").toString(), OrchErrorMessage.class);
        OrchErrorMessage error = (OrchErrorMessage) errorMap.get("error");
        System.out.println(errorMessage.isPresent() ? errorMessage.get() : null);
        System.out.println(error);

    }

    @Test
    public void test3() {
        String message =
                        "BSS开通返回失败，返回内容：{\"statusCode\":200,\"returnObj\":\"{\\\"handled\\\":false,\\\"statusCode\\\":900,\\\"returnObj\\\":{\\\"linecode\\\":\\\"10yzx000804\\\",\\\"virtual_gateway\\\":\\\"{\\\\\\\"statusCode\\\\\\\":800,\\\\\\\"returnObj\\\\\\\":{\\\\\\\"virtual_gateway\\\\\\\":{\\\\\\\"ipsec_bandwidth\\\\\\\":1,\\\\\\\"vpc_id\\\\\\\":\\\\\\\"311cb5b5-30d0-4ea9-a823-843b6133157d\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"default\\\\\\\",\\\\\\\"tenant_id\\\\\\\":\\\\\\\"fd9daafffc294ae0b0030adaae4d28a2\\\\\\\",\\\\\\\"admin_state_up\\\\\\\":true,\\\\\\\"name\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"device_id\\\\\\\":\\\\\\\"10.255.114.34\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"PENDING_CREATE\\\\\\\",\\\\\\\"id\\\\\\\":\\\\\\\"24f8eb90-6a27-47f3-a35a-7d68a83c476f\\\\\\\",\\\\\\\"description\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"local_ep_group_id\\\\\\\":\\\\\\\"9d777720-92bc-45c1-976d-087d84b19e49\\\\\\\",\\\\\\\"redundant_device_id\\\\\\\":\\\\\\\"\\\\\\\"}}}\\\",\\\"direct_connect\\\":\\\"{\\\\\\\"statusCode\\\\\\\":800,\\\\\\\"returnObj\\\\\\\":{\\\\\\\"direct_connect\\\\\\\":{\\\\\\\"id\\\\\\\":\\\\\\\"fa4944e0-9446-4bf3-90fa-b5b52929aa90\\\\\\\",\\\\\\\"admin_state_up\\\\\\\":true,\\\\\\\"status\\\\\\\":\\\\\\\"BUILD\\\\\\\",\\\\\\\"tenant_id\\\\\\\":\\\\\\\"fd9daafffc294ae0b0030adaae4d28a2\\\\\\\",\\\\\\\"interface_name\\\\\\\":\\\\\\\"Eth-Trunk2\\\\\\\",\\\\\\\"provider_status\\\\\\\":\\\\\\\"ACTIVE\\\\\\\",\\\\\\\"bandwidth\\\\\\\":10000,\\\\\\\"port_type\\\\\\\":\\\\\\\"10G\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"cloudvpn_10yzx000804\\\\\\\",\\\\\\\"peer_location\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"create_time\\\\\\\":\\\\\\\"2019-03-05 02:20:25.640558\\\\\\\",\\\\\\\"device_id\\\\\\\":\\\\\\\"10.255.114.34\\\\\\\",\\\\\\\"apply_time\\\\\\\":\\\\\\\"2019-03-05 02:20:25.640558\\\\\\\",\\\\\\\"provider\\\\\\\":\\\\\\\"中国电信\\\\\\\",\\\\\\\"product_id\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"order_id\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"description\\\\\\\":\\\\\\\"cloudvpn_10yzx000804\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"standard\\\\\\\",\\\\\\\"location\\\\\\\":\\\\\\\"无锡市滨湖区蠡湖街道金城西路500号图书馆地下室机房\\\\\\\",\\\\\\\"charge_mode\\\\\\\":\\\\\\\"\\\\\\\"}}}\\\",\\\"vpc_cidr\\\":\\\"{\\\\\\\"statusCode\\\\\\\":800,\\\\\\\"returnObj\\\\\\\":{\\\\\\\"dc_endpoint_group\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"tenant_id\\\\\\\":\\\\\\\"fd9daafffc294ae0b0030adaae4d28a2\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"cidr\\\\\\\",\\\\\\\"endpoints\\\\\\\":[\\\\\\\"172.16.100.0/24\\\\\\\"],\\\\\\\"description\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"id\\\\\\\":\\\\\\\"9d777720-92bc-45c1-976d-087d84b19e49\\\\\\\"}}}\\\",\\\"user_cidr\\\":\\\"{\\\\\\\"statusCode\\\\\\\":800,\\\\\\\"returnObj\\\\\\\":{\\\\\\\"dc_endpoint_group\\\\\\\":{\\\\\\\"type\\\\\\\":\\\\\\\"cidr\\\\\\\",\\\\\\\"tenant_id\\\\\\\":\\\\\\\"fd9daafffc294ae0b0030adaae4d28a2\\\\\\\",\\\\\\\"id\\\\\\\":\\\\\\\"9e6d9d75-9555-477d-81b6-5993564244a6\\\\\\\",\\\\\\\"description\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"endpoints\\\\\\\":[\\\\\\\"10.85.64.0/24\\\\\\\",\\\\\\\"192.168.200.0/30\\\\\\\"],\\\\\\\"name\\\\\\\":\\\\\\\"\\\\\\\"}}}\\\",\\\"virtual_interface\\\":\\\"{\\\\\\\"statusCode\\\\\\\":900,\\\\\\\"message\\\\\\\":\\\\\\\"{\\\\\\\\\\\\\\\"NeutronError\\\\\\\\\\\\\\\": {\\\\\\\\\\\\\\\"message\\\\\\\\\\\\\\\": \\\\\\\\\\\\\\\"VirtualGatewayStateInvalid, id: 24f8eb90-6a27-47f3-a35a-7d68a83c476f, status: PENDING_CREATE\\\\\\\\\\\\\\\", \\\\\\\\\\\\\\\"type\\\\\\\\\\\\\\\": \\\\\\\\\\\\\\\"VirtualGatewayStateInvalid\\\\\\\\\\\\\\\", \\\\\\\\\\\\\\\"detail\\\\\\\\\\\\\\\": \\\\\\\\\\\\\\\"\\\\\\\\\\\\\\\"}};\\\\\\\"}\\\",\\\"workId\\\":\\\"d719e971-d04a-47d1-8b56-89d95464d2f5\\\"},\\\"msg\\\":null}\"}";
        String quotationMark = "\"";
        String slash = "\\";
        StringBuilder oldChar = new StringBuilder();
        StringBuilder newChar = new StringBuilder();
        StringBuilder replaceChar = new StringBuilder();
        oldChar.append(slash).append(slash).append(slash).append(quotationMark);
        replaceChar.append(slash).append(slash).append(slash).append(slash).append(slash).append(quotationMark);
        newChar.append(slash).append(quotationMark);
        System.out.println(oldChar);
        System.out.println(newChar);
        System.out.println(replaceChar);
        int start = message.indexOf("{\"statusCode");
        System.out.println(start);
        String substring = message.substring(start);
        String replace = substring.replace(oldChar, newChar);
        System.out.println(replace);
        String replaceExist = replace.replace(replaceChar, newChar);
        System.out.println(replaceExist);
        Optional<CallbackMessage> callbackMessage = JsonUtil.parseObject(replaceExist, CallbackMessage.class);
        System.out.println(callbackMessage.get());
    }

    @Test
    public void test4() {
        String message =
                        "{\"status\":\"error\",\"code\":2,\"error\":null,\"success\":false,\"network_status\":{\"73480f95-b0c5-4e50-9d2b-93b550420798-2\":1,\"73480f95-b0c5-4e50-9d2b-93b550420798-3\":1,\"73480f95-b0c5-4e50-9d2b-93b550420798-1\":4},\"server_status\":null,\"server_msg\":null,\"network_msg\":{\"73480f95-b0c5-4e50-9d2b-93b550420798-2\":{\"err_code\":null,\"err_msg\":\"接收工单成功\"},\"73480f95-b0c5-4e50-9d2b-93b550420798-3\":{\"err_code\":null,\"err_msg\":\"接收工单成功\"},\"73480f95-b0c5-4e50-9d2b-93b550420798-1\":{\"err_code\":\"1002\",\"err_msg\":\"device_ip(IP地址冲突)\"}}}";

        AtomicReference<String> errorCode = new AtomicReference<>();
        Optional<CloudServerOrderResponse> response = JsonUtil.parseObject(message, CloudServerOrderResponse.class);

        if (response.isPresent()) {
            response.get().getNetworkStatus().forEach((network, status) -> {

                Object object = response.get().getNetworkMsg().get(network);

                Optional<OrchErrorMessage> errorMessage =
                                JsonUtil.parseObject(new JsonParser().parse(object.toString()).toString(),
                                                OrchErrorMessage.class);

                if (errorMessage.orElse(null) != null) {

                    errorCode.set(errorMessage.orElse(null).getErrorCode());
                }

            });
        }
        System.out.println(errorCode.get() != null ? errorCode.get() : null);
    }
}
