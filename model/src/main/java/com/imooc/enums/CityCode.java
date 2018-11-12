package com.imooc.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 平台地市代码
 * @author wangguanghui
 */
public enum  CityCode {
    /**
     * 全部动作类型
     */
    ALL("全部","-2"),

    NANJING("南京", "3"),

    SUZHOU("苏州", "20"),

    WUXI("无锡", "15"),

    CHANGZHOU("常州", "69"),

    ZHENJIANG("镇江", "4"),

    YANGZHOU("扬州", "33"),

    NANTONG("南通", "26"),

    TAIZHOU("泰州", "79"),

    XUZHOU("徐州", "48"),

    HUAIAN("淮安", "60"),

    YANCHENG("盐城", "39"),

    LIANYUNGANG("连云港", "63"),


    SUQIAN("宿迁", "84");

    @Getter
    @Setter
    private String cityName;

    @Getter
    @Setter
    private String cityCode;

    CityCode(String cityName, String cityCode) {
        this.cityName = cityName;
        this.cityCode = cityCode;
    }

}
