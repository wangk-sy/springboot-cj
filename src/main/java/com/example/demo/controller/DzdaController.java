package com.example.demo.controller;

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

}
