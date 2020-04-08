package com.example.demo.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName :Matetial
 * @Description :TODO
 * @Author :16388
 * @Date :2020/4/3 16:40
 * @Version :1.0
 **/
public class Matetial {

    private Long id;
    private String name;
    private Integer count=0;
    private String classnumber;
    private List<License> content;
    private String isScan;
    private String refer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(String classnumber) {
        this.classnumber = classnumber;
    }

    public List<License> getContent() {
        return content;
    }

    public void setContent(List<License> content) {
        this.content = content;
    }

    public String getIsScan() {
        return isScan;
    }

    public void setIsScan(String isScan) {
        this.isScan = isScan;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    @Override
    public String toString() {
        return "Matetial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", classnumber='" + classnumber + '\'' +
                ", content=" + content +
                ", isScan='" + isScan + '\'' +
                ", refer='" + refer + '\'' +
                '}';
    }
}
