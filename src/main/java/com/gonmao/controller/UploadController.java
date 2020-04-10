package com.gonmao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @Author:陈炯
 * @Date：2020/3/11-14:52
 */
@Controller
@RequestMapping("/uploadController")
public class UploadController {

    private static final String UPLOAD_PATH = "F:\\upload";

    // 如何实现参数的封装   上传的时候，如何给出判断或验证
    // 使用到的类：CommonsMultipartResolver 配置SpringMVC容器
    @RequestMapping("/upload.do")
    // 得到前端页面form表单中 标签参数name为myPic的  MultipartFile值
    public ModelAndView upload(@RequestParam("myPic") MultipartFile myPic) throws IOException {

        //1、文件在服务器上的存储（保存到服务器的哪里）    文件地址 + 文件名 + 后缀名
        // 先生成新的文件名
        UUID rid = UUID.randomUUID();
        long uid = rid.getLeastSignificantBits();
        // 取出后缀名 进行字符串拼接
        String filename = myPic.getOriginalFilename();
        // 获取日期
        Calendar calendar = Calendar.getInstance();
        // 获取当前年
        int year = calendar.get(Calendar.YEAR);
        // 获取当前月
        int month = calendar.get(Calendar.MONTH) + 1;
        // 获取当前日
        int day = calendar.get(Calendar.DATE);
        String date = year+"-"+month+"-"+day;
        String suffix = filename.substring(filename.lastIndexOf('.'));
        File file = new File(UPLOAD_PATH+"/"+date+uid+suffix);
        myPic.transferTo(file);
        //2、文件地址的回显
        ModelAndView mv = new ModelAndView();
        mv.setViewName("upLoad");
        mv.addObject("upload_file_path","/upload/"+file.getName());
        //3、给出页面的跳转
        return mv;
    }

}
