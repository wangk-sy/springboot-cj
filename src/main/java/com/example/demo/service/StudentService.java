package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.Matetial;
import com.example.demo.model.Student;

import java.util.List;

/**
 * Created by CodeGenerator on 2020/03/31.
 */
public interface StudentService extends IService<Student> {


    List<Matetial> getMaterial(String projId, String idcard, String xzqh,String code);

}
