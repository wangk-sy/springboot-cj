package com.example.demo.controller;

import com.example.demo.core.FastDFSClientUtil;
import com.example.demo.core.Result;
import com.example.demo.core.ResultGenerator;
import com.example.demo.model.Matetial;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName :DzdaController
 * @Description :TODO
 * @Author :16388
 * @Date :2020/3/31 15:02
 * @Version :1.0
 **/
@Controller
public class DzdaController {

    @Autowired
    private StudentService service;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/getMaterial")
    public Result getMaterial(String projId,String idcard,String xzqh,String code) {

        List<Matetial> list = service.getMaterial(projId,idcard,xzqh,code);

        return ResultGenerator.genSuccessResult(list);
    }

    @RequestMapping("/goUpload")
    public String goUpload(){
        return "upload";
    }

    @ResponseBody
    @RequestMapping("/upload")
    public Result upload(MultipartFile[] file,String fileId){
        FastDFSClientUtil clientUtil = new FastDFSClientUtil();
        String uploadFile="";
        for (int i = 0; i <file.length ; i++) {
            MultipartFile multipartFile = file[i];
            String originalFilename = multipartFile.getOriginalFilename();
            try {
                uploadFile   = clientUtil.uploadFile(multipartFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResultGenerator.genSuccessResult(uploadFile);
    }
}
