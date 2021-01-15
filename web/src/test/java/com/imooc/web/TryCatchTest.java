package com.imooc.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class TryCatchTest {

    Logger logger = LoggerFactory.getLogger(TryCatchTest.class);

    @Test
    public void circularProcess() {

        //循环判断是否超时, 限定重连次数为3次
        int timeoutCount = 0;
        int maxCount = 3;
        do {
            try {
                int a = 10;
                int b = 0;
                System.out.println(a / b);
                timeoutCount = maxCount;
            } catch (Exception e) {
                logger.error(e.getMessage());
                timeoutCount++;
                logger.info("[CRM][service][连接超时]第" + timeoutCount + "次连接");
            }
        } while (timeoutCount < maxCount);
    }
}
