package com.imooc.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstDemoApplicationTests {

    @Test
    public void contextLoads() {
        int num = 0;
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!" + num);
            }
        };
        runnable1.run();

        Runnable runnable2 = () -> System.out.println("hello lambada!" + num);
        runnable2.run();
    }


    @Test
    public void test1() {
        Integer value1 = null;
        Integer value2 = new Integer(10);
        System.out.println(value1);
        System.out.println(value2);
        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.ofNullable(value2);
        System.out.println(a);
        System.out.println(b);

    }

    @Test
    public void test2() {
        Integer value1 = null;
        Integer value2 = new Integer(10);
        System.out.println(value1);
        System.out.println(value2);
//        Optional<Integer> a = Optional.of(value1);
        Optional<Integer> b = Optional.of(value2);
//        System.out.println(a);
        System.out.println(b);

    }


    @Test
    public void test3() {
        Integer value1 = null;
        Integer value2 = new Integer(10);
        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.of(value2);
        System.out.println(a.isPresent());
        System.out.println(b.isPresent());
//        System.out.println(a.get());
        System.out.println(b.get());
        System.out.println(a.orElse(2));
        System.out.println(b.orElse(3));

    }

    @Test
    public void test4() {

        Consumer<String> con = x -> System.out.println(x);
        con.accept("consumer");
    }

    @Test
    public void test5() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        for (String player : players) {
            System.out.println(player + ";  ");
        }

        System.out.println("---------------------------------");

        players.forEach((player) -> System.out.println(player + ";  "));

        System.out.println("---------------------------------");

        players.forEach(System.out::println);
    }

    @Test
    public void test6() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World !");
            }
        }).start();

        new Thread(() -> System.out.println("Hello World too!")).start();
    }

    @Test
    public void test7() {
        Runnable runOne = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World One !");
            }
        };

        Runnable runTwo = () -> System.out.println("Hello World tow !");

        runOne.run();
        runTwo.run();
    }

    @Test
    public void test8() {
        System.out.println(3 * 0.1 == 0.3);
    }

}
