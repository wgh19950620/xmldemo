package com.imooc.web.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件上传/下载
 *
 * @author wangguanghui
 */
@Controller
public class IOController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IOController.class);

    @Value("${filePath}")
    private String filePath;
    /**
     * 跳转页面路径
     *
     * @return 页面名称
     */
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "upload";
    }

    /**
     * 文件上传
     *
     * @param file 文件
     * @return 响应信息
     */
    @PostMapping("/uploading")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }

    /**
     * 文件上传，未明确下载路径  需校验
     *
     * @param file 文件
     * @return 响应信息
     */
    @PostMapping("/upload/file")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        File targetFile = new File(filePath);
        // 文件路径不存在，创建多层路径
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath + file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            fileOutputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // 关闭流
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "上传成功！";
    }

    /**
     * 文件下载
     * @param response HttpServletResponse
     * @param filename 文件名称
     * @return 响应消息
     */
    @PostMapping("/download/file")
    @ResponseBody
    public String download(HttpServletResponse response, @RequestParam("filename") String filename) {
        File file = new File(filePath, filename);

        if (file.exists()) {
            // 设置响应的内容格式，force-download表示只要点击下载按钮就会自动下载文件
            response.setContentType("application/force-download");

            // 设置头信息，filename表示前端下载时的文件名
            response.addHeader("Content-Disposition", "attachment,fileName=" + filename);

            // 进行读写操作
            byte[] buffer = new byte[1024];
            FileInputStream fileInputStream = null;
            BufferedInputStream bufferedInputStream = null;

            try {
                fileInputStream = new FileInputStream(file);
                bufferedInputStream = new BufferedInputStream(fileInputStream);

                // 获取输出流
                OutputStream outputStream = response.getOutputStream();

                // 读写并写入文件到输出流
                int read = bufferedInputStream.read(buffer);
                while (read != -1) {
                    outputStream.write(buffer, 0, read);
                    read = bufferedInputStream.read(buffer);
                }

                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                // 当写入流不为空时进行关闭
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                // 当输入流不为空时进行关闭
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return "下载失败";
    }

}
