package com.xxx.springbootmybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FIleUploadController {

    @RequestMapping("/upload")
    @ResponseBody
    public  String  upload(@RequestParam("myFile") MultipartFile file){
        System.out.println("fileName:"+file.getOriginalFilename());
        //获取文件名
        String fileName=file.getOriginalFilename();
        //获取后缀
        String  suffixName=fileName.substring(fileName.lastIndexOf("."));
//      System.out.println("文件后缀名："+suffixName);
        //文件上传路径
        String path="D://upload/";
        fileName=path+ UUID.randomUUID()+suffixName;//中间加上随机数，上传同样名称的文件也不会覆盖
        //创建文件对象
        File f=new File(fileName);
        if(!f.getParentFile().exists()){//如果父目录不存在，则创建
            f.mkdirs();
        }
        try {
            file.transferTo(f);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "上传失败";
    }
}
