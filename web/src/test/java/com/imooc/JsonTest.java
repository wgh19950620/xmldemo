package com.imooc;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonTest {

    @Test
    public void test1() throws Exception {
        HttpServletResponse response;
        String message = "<Server>\n" + "\t<requestId>nbssm_wgh_20181026_server0000</requestId>\n"
                        + "\t<productId>193144903983</productId>\n"
                        + "\t<combinedAccessNumber>nbssm_20181026_c1340</combinedAccessNumber>\n"
                        + "\t<accessNumber>nbssm_20181026_c1349_server00</accessNumber>\n"
                        + "\t<orderId>nbssm_wgh_20181026_server0000</orderId>\n"
                        + "\t<businessCode>nbssm_wgh_20181026_server0000</businessCode>\n"
                        + "\t<customerId>191002083002</customerId>\n" + "\t<loginName>31120059220049</loginName>\n"
                        + "\t<areaCode>69</areaCode>\n" + "\t<action>1</action>\n" + "\t<subjoin>1</subjoin>\n"
                        + "\t<server>\n" + "\t\t<cloudType>1060</cloudType>\n"
                        + "\t\t<customerName>江苏隆力奇生物&gt;科技股份有限公司</customerName>\n"
                        + "\t\t<customerEmail>webmaster@longliqi.com</customerEmail>\n"
                        + "\t\t<customerPhone>18015650473</customerPhone>\n" + "\t\t<orderCycle/>\n"
                        + "\t\t<id>76f7c749-311e-4a79-b77b-95a2fb81d9c1</id>\n" + "\t\t<name/>\n" + "\t\t<type/>\n"
                        + "\t\t<regionId>1</regionId>\n" + "\t\t<cpu>1</cpu>\n" + "\t\t<oldCpu>1</oldCpu>\n"
                        + "\t\t<memery>1</memery>\n" + "\t\t<oldMemery>1</oldMemery>\n" + "\t\t<os>30</os>\n"
                        + "\t\t<oldOs>30</oldOs>\n" + "\t\t<rootPassword>QAZwsx123</rootPassword>\n"
                        + "\t\t<networkName>network</networkName>\n" + "\t\t<networkCategory/>\n"
                        + "\t\t<networkType>1</networkType>\n" + "\t\t<bandwidth></bandwidth>\n"
                        + "\t\t<oldBandwidth></oldBandwidth>\n" + "\t\t<lanIp/>\n" + "\t\t<lanGateway/>\n"
                        + "\t\t<lanNetmask/>\n" + "\t\t<disk>\n" + "\t\t\t<size>40</size>\n"
                        + "\t\t\t<oldSize>40</oldSize>\n" + "\t\t\t<type/>\n" + "\t\t\t<level>1</level>\n"
                        + "\t\t</disk>\n" + "\t\t<attachedDisks>\n" + "\t\t\t<disk>\n" + "\t\t\t\t<name></name>\n"
                        + "\t\t\t\t<size></size>\n" + "\t\t\t\t<oldSize></oldSize>\n" + "\t\t\t\t<type></type>\n"
                        + "\t\t\t\t<level></level>\n" + "\t\t\t</disk>\n" + "\t\t</attachedDisks>\n" + "\t</server>\n"
                        + "</Server>\n";
        System.out.println(message);

        String filePath = "D:\\test\\"
                        + UUID.randomUUID() + "OSS工单详情" + ".xml";
        File file = new File(filePath);
        OutputFormat format = OutputFormat.createPrettyPrint();
        //format.setNewLineAfterDeclaration(false);
        // format.setNewlines(true);
        // format.setTrimText(true);
        // 将XML内容写入到文件当中
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
//        writer.setEscapeText(false);// 字符是否转义,默认true
        // 如果是需要默认头部，那么就是
        // Writer(document);
        // 如果不需要默认头部;
        // System.out.println(document.getRootElement().asXML());
        writer.write(message);
        writer.close();
    }
}
