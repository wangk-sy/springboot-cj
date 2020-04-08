package com.example.demo.model;

import lombok.Data;
import lombok.ToString;

import java.util.Objects;

/**
 * @ClassName :License
 * @Description :TODO
 * @Author :16388
 * @Date :2020/4/3 16:41
 * @Version :1.0
 **/
public class License {
    private Long id;
    private String path;
    private String fileName;
    private Long attchmentId;
    private Long entityClassId;
    private Long entityId;
    private String refer;
    private String fileSize;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getAttchmentId() {
        return attchmentId;
    }

    public void setAttchmentId(Long attchmentId) {
        this.attchmentId = attchmentId;
    }

    public Long getEntityClassId() {
        return entityClassId;
    }

    public void setEntityClassId(Long entityClassId) {
        this.entityClassId = entityClassId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "License{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", fileName='" + fileName + '\'' +
                ", attchmentId='" + attchmentId + '\'' +
                ", entityClassId='" + entityClassId + '\'' +
                ", entityId='" + entityId + '\'' +
                ", refer='" + refer + '\'' +
                ", fileSize='" + fileSize + '\'' +
                '}';
    }
}
