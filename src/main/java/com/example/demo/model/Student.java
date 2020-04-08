package com.example.demo.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@TableName(value = "student")
public class Student {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "studentname")
    private String studentname;

    @TableField(value = "password")
    private String password;

        @TableField(value = "nick_name")
    private String nickName;

    @TableField(value = "sex")
    private Integer sex;

    @TableField(value = "register_date")
    private Date registerDate;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentname='" + studentname + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", registerDate=" + registerDate +
                '}';
    }
}