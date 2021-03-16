package com.imooc.web.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @Deprecated 文件操作工具类
 * @return:
 * @Author: hzg
 * @date: 2019/7/19
 */
@Slf4j
public class FileUtil {

    private static final String[][] MIME_MapTable = {
            // {后缀名， MIME类型}
            { ".doc", "application/msword" },
            { ".docx",
                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document" },
            { ".xls", "application/vnd.ms-excel" },
            { ".xlsx",
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" },
            { ".pdf", "application/pdf" },
            { ".ppt", "application/vnd.ms-powerpoint" },
            { ".pptx",
                    "application/vnd.openxmlformats-officedocument.presentationml.presentation" },
            { ".txt", "text/plain" }, { ".wps", "application/vnd.ms-works" },
            { "", "*/*" }
    };

    /**
     * 文件或目录是否存在
     */
    public static boolean exists(String path) {
        return new File(path).exists();
    }

    /**
     * 文件是否存在
     */
    public static boolean existsFile(String path) {
        File file = new File(path);
        return file.exists() && file.isFile();
    }

    /**
     * 文件或目录是否存在
     */
    public static boolean existsAny(String... paths) {
        return Arrays.stream(paths).anyMatch(path -> new File(path).exists());
    }

    /**
     * 删除文件或文件夹
     */
    public static void deleteIfExists(File file) throws IOException {
        if (file.exists()) {
            if (file.isFile()) {
                if (!file.delete()) {
                    throw new IOException("Delete file failure,path:" + file.getAbsolutePath());
                }
            } else {
                File[] files = file.listFiles();
                if (files != null && files.length > 0) {
                    for (File temp : files) {
                        deleteIfExists(temp);
                    }
                }
                if (!file.delete()) {
                    throw new IOException("Delete file failure,path:" + file.getAbsolutePath());
                }
            }
        }
    }

    /**
     * 删除文件或文件夹
     */
    public static void deleteIfExists(String path) throws IOException {
        deleteIfExists(new File(path));
    }

    /**
     * 根据文件后缀名获得对应的MIME类型。
     *
     */
    public static String getMIMEType(File file) {
        String type = "*/*";
        String fName = file.getName();
        // 获取后缀名前的分隔符"."在fName中的位置。
        int dotIndex = fName.lastIndexOf(".");
        if (dotIndex < 0) {
            return type;
        }
        /* 获取文件的后缀名 */
        String end = fName.substring(dotIndex, fName.length()).toLowerCase();
        if (end == ""){
            return type;
        }
        // 在MIME和文件类型的匹配表中找到对应的MIME类型。
        for (int i = 0; i < MIME_MapTable.length; i++) {
            if (end.equals(MIME_MapTable[i][0])){
                type = MIME_MapTable[i][1];
            }
        }
        return type;
    }

    /**
     * 根据相对路径下载文件
     *
     * @param request             HttpServletRequest
     * @param response            HttpServletResponse
     * @param file                目标文件
     */
    public static void downloadFileByName(HttpServletRequest request, HttpServletResponse response, File file) {
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            // 下载文件名称
            String downloadZipFileName = file.getName();

            fileInputStream = new FileInputStream(file);

            if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
                downloadZipFileName = new String(downloadZipFileName.getBytes("GB2312"), StandardCharsets.ISO_8859_1);
            } else {
                // 对文件名进行编码处理中文问题
                downloadZipFileName = java.net.URLEncoder.encode(downloadZipFileName, "UTF-8");
                downloadZipFileName = new String(downloadZipFileName.getBytes(StandardCharsets.UTF_8), "GBK");
            }

            response.reset();
            response.setCharacterEncoding("UTF-8");
            //此处修改字节码方式。
            response.setContentType("application/multipart/form-data;charset=utf-8");

            // 默认为inline方式
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadZipFileName);
            // 设置文件长度
            response.addHeader("Content-Length", Long.toString(file.length()));
            outputStream = response.getOutputStream();

            //读取文件流
            int len;
            byte[] buffer = new byte[1024 * 10];
            while ((len = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush();
            outputStream.close();

            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeOutputStream(outputStream);
            closeInputStream(fileInputStream);
        }
    }

    /**
     * 关闭文件输入流
     *
     * @param inputStream 输入流
     */
    public static void closeInputStream(InputStream inputStream) {
        if (null != inputStream) {
            try {
                inputStream.close();
            } catch (Exception e) {
                log.error("文件流关闭错误", e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭文件输出流
     *
     * @param outputStream 输出流
     */
    public static void closeOutputStream(OutputStream outputStream) {
        if (null != outputStream) {
            try {
                outputStream.close();
            } catch (Exception e) {
                log.error("文件流关闭错误", e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
