package com.it.springbootwebsp.controller;


import com.it.springbootwebsp.anno.Log;
import com.it.springbootwebsp.pojo.Result;
import com.it.springbootwebsp.utils.AliOSSUtils;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    AliOSSUtils aliOSSUtils;

    //本地存储文件
//    @PostMapping("/upload")
//    public Result upload(String username, String name, MultipartFile image) throws Exception{
//        log.info("文件上传:{},{},{}",username, name, image);
//        //将接收的文件保存
//
//        //获取文件名
//        String originalFilename = image.getOriginalFilename();
//        //构造唯一文件名--uuid+原始文件名.
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFilename = UUID.randomUUID().toString() + extname;
//        log.info("获取新文件名:{}",newFilename);
//        //存储
//        image.transferTo(new File("D:\\temp\\"+newFilename));
//        return Result.success();
//    }

    @Log
    //阿里云OSS存储文件
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("阿里云OSS文件上传:{}", image.getOriginalFilename());
        //阿里云OSS工具类
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成{}",url);
        return Result.success(url);
    }

}
