package com.imooc.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 邮件实体类
 */
@Data
public class Mail {

    /**
     * 发送者
     */
    private String sender;

    /**
     * 接受者
     */
    private String receiver;

    /**
     * 主题
     */
    private String subject;

    /**
     * 发送消息
     */
    private String text;

    /**
     * 附件
     */
    private List<MultipartFile> files;
}
