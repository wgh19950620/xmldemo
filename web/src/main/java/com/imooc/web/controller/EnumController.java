package com.imooc.web.controller;

import com.imooc.dto.ResultDto;
import com.imooc.entity.ThirdApplicationRequest;
import com.imooc.enums.PaymentChannelEnum;
import com.imooc.enums.PaymentPatternEnum;
import com.imooc.enums.PaymentTypeEnum;
import com.imooc.enums.ThirdApplicationEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EnumController extends BaseController {

    @GetMapping("index")
    public String direct() {
        return "demo";
    }

    @GetMapping("/select/paymentType")
    @ResponseBody
    public ResultDto<Map<Integer, String>> getPaymentTypeEnum() {
        HashMap<Integer, String> paymentType = new HashMap<>();

        for (PaymentTypeEnum payment : PaymentTypeEnum.values()) {
            paymentType.put(payment.getValue(), payment.getDescription());
        }

        return success(paymentType);
    }

    @GetMapping("/select/paymentChannel")
    @ResponseBody
    public ResultDto<Map<Integer, String>> getPaymentChannelEnum(@RequestParam Integer code) {
        HashMap<Integer, String> paymentChannelMap = new HashMap<>();

        for (PaymentChannelEnum paymentChannel : PaymentChannelEnum.values()) {

            if (code.equals(paymentChannel.getCode())) {
                paymentChannelMap.put(paymentChannel.getValue(), paymentChannel.getDescription());
            }
        }

        return success(paymentChannelMap);
    }

    @GetMapping("/select/paymentPattern")
    @ResponseBody
    public ResultDto<Map<Integer, String>> getPaymentPatternEnum(@RequestParam Integer typeCode, @RequestParam Integer channelCode) {

        HashMap<Integer, String> paymentPatternMap = new HashMap<>();

        for (PaymentPatternEnum paymentPattern : PaymentPatternEnum.values()) {

            String code = typeCode + "-" + channelCode;
            if (code.equals(paymentPattern.getCode())) {
                paymentPatternMap.put(paymentPattern.getValue(), paymentPattern.getDescription());
            }
        }

        return success(paymentPatternMap);
    }

    @GetMapping("/select/thirdApplication")
    @ResponseBody
    public ResultDto<Map<Integer, String>> getThirdApplicationEnum() {

        HashMap<Integer, String> thirdApplicationMap = new HashMap<>();

        for (ThirdApplicationEnum thirdApplicationEnum : ThirdApplicationEnum.values()) {
            thirdApplicationMap.put(thirdApplicationEnum.getValue(), thirdApplicationEnum.getDescription());
        }

        return success(thirdApplicationMap);
    }


    @PostMapping("/create/thirdApplication")
    @ResponseBody
    public ResultDto create(@RequestBody ThirdApplicationRequest applicationRequest) {
        System.out.println(applicationRequest.getPaymentChannel());
        System.out.println(applicationRequest.getPaymentPatternList());
        System.out.println(applicationRequest.getPaymentType());
        System.out.println(applicationRequest.getThirdApplication());

        return success("添加成功");
    }
}
