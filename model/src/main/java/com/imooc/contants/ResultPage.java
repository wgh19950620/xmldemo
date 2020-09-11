package com.imooc.contants;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 返回分页数据 
 * @author JiC
 * @date 2019-07-04 14:16
 */
@ApiModel(value = "ResultPageList", description = "返回分页数据 ")
@Data
@Accessors(chain = true)
public class ResultPage<T> implements Serializable {

    private static final long serialVersionUID = 3815532976698056439L;

    @ApiModelProperty("数据集")
    private List<T> data;

    @ApiModelProperty("总条数")
    private Long total;

    @ApiModelProperty("总页数")
    private int pages;
}
