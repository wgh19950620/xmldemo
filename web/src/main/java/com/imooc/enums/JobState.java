package com.imooc.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 工单状态
 * @author wangguanghui
 */
public enum JobState {

    /**
     * 全部状态类型
     */
    ALL("全部", "-2"),

    ROUTE("在途", "-1"),

    SUCCESS("成功", "0"),

    FAILURE("失败", "10");

    @Getter
    @Setter
    private String stateName;

    @Getter
    @Setter
    private String stateCode;

    JobState(String stateName, String stateCode) {
        this.stateName = stateName;
        this.stateCode = stateCode;
    }

}
