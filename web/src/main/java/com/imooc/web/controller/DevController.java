package com.imooc.web.controller;

import com.imooc.web.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
@Slf4j
@RequestMapping("/dev/version")
public class DevController {

    /**
     * 下载文件
     *
     * @param resourcePath 资源路径
     */
    @RequestMapping("/downloadFile")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, String resourcePath) {

        if (StringUtils.isEmpty(resourcePath)) {
            log.info("资源目录不存在");
            return;
        }

        File file = new File(resourcePath);

        if (!file.exists()) {
            log.info("当前文件不存在");
            return;
        }

        FileUtil.downloadFileByName(request, response, file);

        log.info(file.getName() + "文件下载成功");
    }
}
