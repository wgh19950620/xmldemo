package com.imooc.web.controller;

import com.imooc.entity.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.File;


/**
 * 邮件 控制台
 */
@RestController
public class MailController {

    private static Logger logger = LoggerFactory.getLogger(MailController.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${filePath}")
    private String filePath;

    /**
     * 发送普通邮件
     *
     * @param mail 邮件信息
     * @return 响应消息
     */
    @PostMapping("/send/surfaceMail")
    public String sendSurfaceMail(@RequestBody Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(mail.getSender());
        mailMessage.setTo(mail.getReceiver());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getText());

        javaMailSender.send(mailMessage);
        logger.info("发送成功！");

        return "发送成功!";
    }

    /**
     * 发送附件
     *
     * @param mail 邮件信息
     * @return 响应消息
     * @throws Exception 异常
     */
    @PostMapping("/send/attachmentsMail")
    public String sendAttachmentsMail(@RequestBody Mail mail) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom(mail.getSender());
        mimeMessageHelper.setTo(mail.getReceiver());
        mimeMessageHelper.setSubject(mail.getSubject());
        mimeMessageHelper.setText(mail.getText());

        // 获取文件信息
        File file = new File(filePath, "myPhoto.jpg");
        mimeMessageHelper.addAttachment("附件.jpg", file);

        javaMailSender.send(mimeMessage);
        logger.info("发送成功！");
        return "发送成功！";
    }

    /**
     * 发送内嵌式文件
     *
     * @param mail 邮件信息
     *             text 设置html  可以插入图片<html><body><img src='cid:identifier1234'></body></html>
     * @return 响应消息
     * @throws Exception 异常
     */
    @PostMapping("/send/inlineMail")
    public String sendInlineMail(@RequestBody Mail mail) throws Exception {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom(mail.getSender());
        mimeMessageHelper.setTo(mail.getReceiver());
        mimeMessageHelper.setSubject(mail.getSubject());

        // 文本为html信息
        mimeMessageHelper.setText(mail.getText(), true);

        File file = new File(filePath, "myPhoto.jpg");
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        mimeMessageHelper.addInline("identifier1234", fileSystemResource);

        javaMailSender.send(mimeMessage);

        return "发送成功！";
    }

    /**
     * 发送模板
     *
     * @param mail 邮件信息
     * @return 响应消息
     * @throws Exception 异常
     */
    @PostMapping("/send/templateMail")
    public String sendTemplateMail(@RequestBody Mail mail) throws Exception {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom(mail.getSender());
        mimeMessageHelper.setTo(mail.getReceiver());
        mimeMessageHelper.setSubject(mail.getSubject());

        // 创建邮件正文
        Context context = new Context();
        context.setVariable("id", "1");
        context.setVariable("name", "zhujing");

        // 这里需要设置thymeleaf 的模板   测试不通
        String emailTemplate = templateEngine.process("mailTemplate", context);
        mimeMessageHelper.setText(emailTemplate, true);

        javaMailSender.send(mimeMessage);

        return "发送成功！";
    }
}
