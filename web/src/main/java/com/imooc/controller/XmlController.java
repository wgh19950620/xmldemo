package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author wangguanghui
 */
@RestController
public class XmlController {


    @PostMapping(value = "/export")
    public void export(HttpServletResponse response, HttpServletRequest request, String stringBuffer) {
        System.out.println(stringBuffer);

        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(currentTime);
        String filename = UUID.randomUUID() + "OSS工单_" + dateString + ".xml";
        try {

            response.setContentType("application/xml");
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("UTF-8"),
                            "ISO8859-1"));
            response.flushBuffer();
            BufferedOutputStream stream = new BufferedOutputStream(response.getOutputStream());
            byte[] bytes = stringBuffer.toString().getBytes();
            int len = bytes.length;
            stream.write(bytes, 0, len);
            stream.flush();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/export/two")
    public void exportTwo(HttpServletResponse response) {

        StringBuffer stringBuffer = new StringBuffer();
        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
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

        stringBuffer = stringBuffer.append(header).append(message);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(currentTime);
        String filename = UUID.randomUUID() + "_OSS工单_" + dateString + ".xml";
        try {

            response.setContentType("application/xml");
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("UTF-8"),
                            "ISO8859-1"));
            response.flushBuffer();
            BufferedOutputStream stream = new BufferedOutputStream(response.getOutputStream());
            byte[] bytes = stringBuffer.toString().getBytes();
            int len = bytes.length;
            stream.write(bytes, 0, len);
            stream.flush();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
