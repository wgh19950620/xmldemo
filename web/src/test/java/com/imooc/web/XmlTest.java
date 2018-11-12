package com.imooc.web;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XmlTest {
    @Test
    public void fun() throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 10; i++) {

            String filePath = "D:\\test\\"
                    + "CH_" + i + ".xml";
            File file = new File(filePath);
            if (!file.exists()) {
                createXML(file, i);
                modifyXmlFiles(file);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("写入xml文件完成!");
        System.out.println("程序总共执行了：" + (endTime - startTime) + "毫秒");
    }

    // 删除文件中的第一行空白数据
    private void modifyXmlFiles(File file) throws IOException {
        // TODO Auto-generated method stub
        FileInputStream fis = new FileInputStream(file);
        List<String> list = IOUtils.readLines(fis);
        fis.close();
        if (file.exists()) {
            file.delete();
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).trim().equals("")) {
            } else {
                IOUtils.write(list.get(i) + "\r\n", new FileOutputStream(file,
                        true));
            }
        }
    }

    /**
     * DOM4J方式创建xml文件
     *
     * @param file
     * @throws Exception
     */
    public void createXML(File file, int i) throws Exception {
        Document document = DocumentHelper.createDocument();

        Element root = document.addElement("Server");
        // document.getRootElement().asXML();
        Element server = root.addElement("server");
        String textString = "CH_" + i;
        server.setText(textString);

        Element question_type = root.addElement("question_type");
        question_type.setText("1");

        Element serial_number_label = root.addElement("serial_number_label");

        Element answer = serial_number_label.addElement("answer");
        String randomString = pickRandom();
        answer.setText(randomString);

        Element score = serial_number_label.addElement("score");
        score.setText("2");

        Element people_number = serial_number_label.addElement("people_number");
        people_number.setText("0");

        Element comment = serial_number_label.addElement("comment");
        comment.setText("正确答案1");
        OutputFormat format = OutputFormat.createPrettyPrint();
        //format.setNewLineAfterDeclaration(false);
        // format.setNewlines(true);
        // format.setTrimText(true);
        // 将XML内容写入到文件当中
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        writer.setEscapeText(false);// 字符是否转义,默认true
        // 如果是需要默认头部，那么就是
        // Writer(document);
        // 如果不需要默认头部;
        // System.out.println(document.getRootElement().asXML());
        writer.write(document.getRootElement());
        writer.close();
    }

    // 获取一个数组中任意的一个元素
    private String pickRandom() {
        String[] array = {"A", "B", "C", "D"};
        int length = array.length;
        Random random = new Random();
        return array[random.nextInt(length)];
    }

}
