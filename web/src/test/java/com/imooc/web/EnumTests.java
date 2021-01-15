package com.imooc.web;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.imooc.enums.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnumTests {

    @Test
    public void test1() {
        HashMap<String, Map<String, String>> maps = new HashMap<>();

        HashMap<String, String> actionMap = new HashMap<>();
        HashMap<String, String> productTypeMap = new HashMap<>();
        HashMap<String, String> stateMap = new HashMap<>();
        HashMap<String, String> cityMap = new HashMap<>();
        HashMap<String, String> keyWordTypeMap = new HashMap<>();

        for (JobAction action : JobAction.values()) {
            actionMap.put(action.getAction(), action.getCode());
        }

        for (ProductType productType : ProductType.values()) {
            productTypeMap.put(productType.getTypeName(), productType.name());
        }

        for (CityCode cityCode : CityCode.values()) {
            cityMap.put(cityCode.getCityName(), cityCode.getCityCode());
        }

        for (KeyWordType keyWordType : KeyWordType.values()) {
            keyWordTypeMap.put(keyWordType.getKeyWordTypeName(), keyWordType.getKeyWordTypeCode());
        }

        for (JobState jobState : JobState.values()) {
            stateMap.put(jobState.getStateName(), jobState.getStateCode());
        }

        maps.put("action", actionMap);
        maps.put("productType", productTypeMap);
        maps.put("state", stateMap);
        maps.put("cityCode", cityMap);
        maps.put("keyWordType", keyWordTypeMap);

        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(maps);
        System.out.println(jsonElement);
    }

    @Test
    public void test2() {
        System.out.println(JobAction.ALL);
    }

    @Test
    public void test3() {
        try {
            // 创建解析器工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            Document document = db.newDocument();

            // 不显示standalone="no"
            document.setXmlStandalone(true);
            Comment server = document.createComment("Server");
            // 向Server根节点添加子节点
            Element book = document.createElement("book");
            Element name = document.createElement("name");
            // 不显示内容 name.setNodeValue("不好使");
            name.setTextContent("雷神");
            book.appendChild(name);
            // 为book节点添加属性
            book.setAttribute("id", "1");
            // 将book节点添加到Server根节点
            server.appendChild(book);
            // 将bookstore节点（已添加book）添加到dom树中
            document.appendChild(server);

            // 创建transformerFactory对象
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            // 创建transformer对象
            Transformer transformer = transformerFactory.newTransformer();
            // 输出内容是否使用换行
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // 创建xml文件并写入内容
            transformer.transform(new DOMSource(document), new StreamResult(new File("server.xml")));
            System.out.println("生成成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成失败");
        }
    }

    @Test
    public void test4() {
        String comma = ",";
        System.out.println("adf,dfs".contains(comma));
        String[] strings = "adf,dfs".split(comma);
        for (String string : strings) {

            System.out.println(string);
        }
    }

    @Test
    public void test5() {
        String fileName = OrderType.getFileName("CT_YUN_HWS_CREATE_VM");
        System.out.println(fileName);
    }

    @Test
    public void test6() {
        String fileName = "作废功能梳理.xmind";
        String[] split = fileName.split("\\.");
        for (int i = 0; i < split.length; i++) {

            System.out.println(split[i]);
        }
    }
}
