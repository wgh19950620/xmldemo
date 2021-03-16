package com.imooc.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * jdk 1.8 new feature
 *
 * @author wangguanghui
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Jdk8Tests {

    /**
     * summaryStatistics 方法用于求取集合中最大值、最小值、和与平均数
     *
     * 利用jdk1.8求取集合中的最大值、最小值、和与平均数
     */
    @Test
    public void summaryStatistics() {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics statistics = integers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("max: " + statistics.getMax());
        System.out.println("min: " + statistics.getMin());
        System.out.println("sum: " + statistics.getSum());
        System.out.println("average: " + statistics.getAverage());
    }

    /**
     * filter 方法用于通过设置的条件过滤出需要的元素
     *
     * 计算字符串中的空字符串的个数
     */
    @Test
    public void countEmpty() {
        List<String> strings = Arrays.asList("abc", "dad", "", "sash", "", "sdf", "");

        long count = strings.stream().filter(String::isEmpty).count();
        System.out.println("isEmpty count: " + count);

        long lengthCount = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("strings length is 3 count: " + lengthCount);

        List<String> stringList = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("get rid of the empty string: " + stringList);

        String collect = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining());
        System.out.println("concatenated string: " + collect);
    }

    /**
     * map 方法用于映射每个元素到对应的结果
     *
     * 获取元素对应的平方数，并剔除平方数
     */
    @Test
    public void squareToMap() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        List<Integer> squares = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());

        squares.forEach(System.out::println);

    }

    /**
     * sorted 方法用于对流进行排序
     *
     * limit 方法用于获取指定数量的流
     */
    @Test
    public void sortedStream() {
        Random random = new Random(10);
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    @Test
    public void compareVersion() {
        for (String s : "1.0.1".split("\\.")) {

            System.out.println(s);
        }
        int i = compareVersion("ets_face_pay_v1.0.1_20210310.apk".split("_")[3].substring(1),
                "ets_face_pay_v1.0.1_20210310.apk".split("_")[3].substring(1));
        System.out.println(i);
    }

    public static int compareVersion(String newVersionNum, String OldVersionNum) {
        if (newVersionNum.equals(OldVersionNum)) {
            return 0;
        }
        String[] newVersionArray = newVersionNum.split("\\.");
        String[] oldVersionArray = OldVersionNum.split("\\.");
        int index = 0;
        //获取最小长度值
        int minLen = Math.min(newVersionArray.length, oldVersionArray.length);
        int diff = 0;
        //循环判断每位的大小
        while (index < minLen && (diff = Integer.parseInt(newVersionArray[index]) - Integer.parseInt(oldVersionArray[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            //如果位数不一致，比较多余位数
            for (int i = index; i < newVersionArray.length; i++) {
                if (Integer.parseInt(newVersionArray[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < oldVersionArray.length; i++) {
                if (Integer.parseInt(oldVersionArray[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }
}
