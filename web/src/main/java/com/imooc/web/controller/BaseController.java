package com.imooc.web.controller;

import com.imooc.contants.ResultPage;
import com.imooc.dto.ResultDto;
import org.springframework.stereotype.Component;

/**
 * @auther JunDeng
 * @Date 2019/7/14
 * @desc 公共返回
 */
@Component
public class BaseController {

    /**
     * @Deprecated 列表数据异常
     * @param msg
     * @return: com.ets.ecard.dto.ResultDto
     * @Author: DengJun
     * @date: 2019/7/15
     */
    public ResultDto fail(String msg){
        ResultDto resultDto = new ResultDto();
        resultDto.setMsg(msg);
        resultDto.setCode(-1);
        return resultDto;
    }

    /**
     * @Deprecated 数据返回
     * @param o 返回数据
     * @return: com.ets.ecard.dto.ResultDto
     * @Author: DengJun
     * @date: 2019/7/18
     */
    public ResultDto success(Object o){
        ResultDto resultDto = new ResultDto();
        resultDto.setMsg("ok");
        resultDto.setCode(0);
        resultDto.setData(o);
        if(o instanceof ResultPage){
            resultDto.setCount(((ResultPage)o).getTotal());
        }
        return resultDto;
    }

    /**
     * @Deprecated 列表数据封装
     * @param resultPage
     * @return: com.ets.ecard.dto.ResultDto
     * @Author: DengJun
     * @date: 2019/7/15
     */
    public ResultDto success(ResultPage resultPage){
        ResultDto resultDto = new ResultDto();
        resultDto.setMsg("ok");
        resultDto.setCount(resultPage.getTotal());
        resultDto.setCode(0);
        resultDto.setData(resultPage.getData());
        return resultDto;
    }

}
