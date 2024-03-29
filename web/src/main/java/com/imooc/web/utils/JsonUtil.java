package com.imooc.web.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * JSON 字元串工具
 * @author zoe
 */
public class JsonUtil {
    /**
     * 美化 JSON 字元串
     * <p>
     *     主要用于调试期使用，便于查看响应消息
     * </p>
     * @param uglyJSONString 未格式化的 JSON 字元串
     * @return 美化后的字符串，若美化失败则返回原始字符串
     */
    public static String prettyFormat(String uglyJSONString) {

        return prettyFormat(uglyJSONString , uglyJSONString);
    }

    /**
     * 美化 JSON 字元串
     * <p>
     *     主要用于调试期使用，便于查看响应消息
     * </p>
     * @param uglyJSONString 未格式化的 JSON 字元串
     * @param defaultString 转换失败时返回的字符串
     * @return 美化后的字符串，若美化失败则返回调用时提供的默认字符串
     */
    public static String prettyFormat(String uglyJSONString , String defaultString) {
        String prettyJsonString = "";

        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(uglyJSONString);
            prettyJsonString = gson.toJson(je);
        } catch (Exception ex) {
            prettyJsonString = defaultString;
        }

        return prettyJsonString;
    }

    /**
     * 生成对象的 JSON 字符串并美化结果
     * @param data 数据对象
     * @return 美化后的字符串，若美化失败则返回字符串 {}
     */
    public static String prettyString(Object data) {

        return prettyString(data , "{}");
    }

    /**
     * 生成对象的 JSON 字符串并美化结果
     * @param data 数据对象
     * @param defaultString 转换失败时返回的字符串
     * @return 美化后的字符串，若美化失败则返回调用时提供的默认字符串
     */
    public static String prettyString(Object data , String defaultString) {
        String content;

        try {
            content = new ObjectMapper().writeValueAsString(data);
        } catch (Exception ex) {
            return defaultString;
        }

        return prettyFormat(content , defaultString);
    }

    /**
     * 生成对象的 JSON 字符串
     * @param data 数据对象
     * @return 转换后的字符串，若转换失败则返回调用时提供的默认字符串 "{}"
     */
    public static String stringify(Object data) {
        return stringify(data , "{}");
    }

    /**
     * 生成对象的 JSON 字符串
     * @param data 数据对象
     * @return 转换后的字符串
     */
    public static Optional<String> stringifyStrict(Object data) {
        String json = stringify(data , null);

        return null != json ? Optional.of(json) : Optional.empty();
    }

    /**
     * 生成对象的 JSON 字符串
     * @param data 数据对象
     * @return 转换后的字符串
     * @throws JsonProcessingException 若转换异常则直接抛出异常
     */
    public static String stringifyOrException(Object data) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(data);
    }

    /**
     * 生成对象的 JSON 字符串
     * @param data 数据对象
     * @param defaultString 转换失败时返回的字符串
     * @return 转换后的字符串，若转换失败则返回调用时提供的默认字符串
     */
    public static String stringify(Object data , String defaultString) {
        String content;

        try {
            content = new ObjectMapper().writeValueAsString(data);
        } catch (Exception ex) {
            return defaultString;
        }

        return content;
    }

    public static <T , E extends T> T parseObject(String jsonString , Class<T> tClass , E defaultValue) {
        Optional<T> result = parseObject(jsonString , tClass);

        return result.isPresent() ? result.get() : defaultValue;
    }

    public static <T> Optional<T> parseObject(String jsonString , Class<T> tClass) {
        T object;

        try {
            object = new ObjectMapper().readValue(jsonString , tClass);
        } catch (Exception ex) {
            object = null;
        }

        return null != object ? Optional.of(object) : Optional.empty();
    }

    public static <T> List<T> parseObjectList(String jsonString , Class<T> tClass) {
        CollectionType listType = TypeFactory.defaultInstance()
                        .constructCollectionType(ArrayList.class, tClass);

        List<T> resultList;

        try {
            resultList = new ObjectMapper().readValue(jsonString , listType);
        } catch (Exception ex) {
            resultList = new ArrayList<>();
        }

        return resultList;
    }

    public static Map<String , Object> parseMap(String jsonString , Map<String , Object> defaultValue) {
        Optional<Map<String , Object>> result = parseMap(jsonString);

        return result.isPresent() ? result.get() : defaultValue;
    }

    public static Optional<Map<String , Object>> parseMap(String jsonString) {
        MapLikeType typeMapStringObject = TypeFactory
                        .defaultInstance().constructMapLikeType(HashMap.class , String.class , Object.class);

        Map<String , Object> object;

        try {
            object = new ObjectMapper().readValue(jsonString , typeMapStringObject);
        } catch (Exception ex) {
            object = null;
        }

        return null != object ? Optional.of(object) : Optional.empty();
    }
}
