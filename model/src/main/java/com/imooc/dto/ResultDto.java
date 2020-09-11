package com.imooc.dto;

import lombok.Data;

/**
 * @auther JunDeng
 * @Date 2019/7/15
 * @desc
 */
@Data
public class ResultDto<T> {
    /*列表数据*/
    private T data;
    /*消息*/
    private String msg;
    /*code*/
    private Integer code;
    /*总条数*/
    private Long count;
}
