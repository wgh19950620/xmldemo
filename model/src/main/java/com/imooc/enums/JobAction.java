package com.imooc.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 工单动作类型
 * @author wangguanghui
 */
public enum JobAction {

    /**
     * 全部动作类型
     */
    ALL("全部", "-2"),

    CREATE("新装", "1"),

    MODIFY("变更", "1179"),

    RELEASE("拆机", "3"),

    HALT("停机", "43"),

    REACTIVE("复机", "45"),

    JOIN("纳入组合", "1141"),

    EXIT("退出组合", "1142");

    @Getter
    @Setter
    private String action;

    @Getter
    @Setter
    private String code;

    JobAction(String action, String code) {
        this.action = action;
        this.code = code;
    }


}
