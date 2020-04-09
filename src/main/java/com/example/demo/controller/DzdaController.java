package com.example.demo.controller;

import com.example.demo.core.FastDFSClientUtil;
import com.example.demo.core.Result;
import com.example.demo.core.ResultGenerator;
import com.example.demo.model.Matetial;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
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

    @Autowired
    private FastFileStorageClient storageClient;

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
    public Result upload(MultipartFile[] files){
        List<String> groupNames= new ArrayList<>();
        for (int i = 0; i <files.length ; i++) {
            MultipartFile multipartFile = files[i];
            String originalFilename = multipartFile.getOriginalFilename();
            try {
                InputStream inputStream = files[i].getInputStream();
                long size = files[i].getSize();
                String  groupName = storageClient.uploadFile(inputStream,size, FilenameUtils.getExtension(originalFilename),null).getFullPath();
                groupNames.add(groupName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResultGenerator.genSuccessResult(groupNames);
    }

    @RequestMapping("/viewImg")
    public void viewImg(@RequestParam String groupName){
        String group = groupName.substring(0, groupName.indexOf("/"));
        String path = groupName.substring(groupName.indexOf("/") + 1);
        InputStream inputStream = storageClient.downloadFile(group, path, null);
    }
}
