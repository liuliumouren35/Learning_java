package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.itheima.utils.AliOSSUtils;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("uploadController")

@Slf4j
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    // @PostMapping("/upload")
    // public String upload(String username, Integer age, MultipartFile image) {
    //     log.info("上传的文件名: {}", image.getOriginalFilename());
    //     log.info("上传的文件类型: {}", image.getContentType());
    //     log.info("上传的文件大小: {}", image.getSize());
    //     log.info("上传的文件名: {}", username);
    //     log.info("上传的文件类型: {}", age);
    //     return "上传成功";
    // }

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("上传的文件名: {}", image.getOriginalFilename());
        log.info("上传的文件类型: {}", image.getContentType());
        log.info("上传的文件大小: {}", image.getSize());
        //调用阿里云OSS工具类上传文件
        String url = aliOSSUtils.upload(image);
        log.info("文件上传成功: {}", url);
        return Result.success(url);
    }
}
