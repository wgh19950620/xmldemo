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
}
