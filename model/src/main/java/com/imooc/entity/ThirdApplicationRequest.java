package com.imooc.entity;

import lombok.Data;

import java.util.List;

@Data
public class ThirdApplicationRequest {


    private Integer paymentType;
    private Integer paymentChannel;
    private List<Integer> paymentPatternList;

    private SsThirdApplication thirdApplication;
}
