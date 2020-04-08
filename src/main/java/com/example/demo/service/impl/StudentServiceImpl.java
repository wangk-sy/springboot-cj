package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.core.WebServiceUtil;
import com.example.demo.dao.StudentMapper;
import com.example.demo.model.License;
import com.example.demo.model.Matetial;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;


/**
 * Created by CodeGenerator on 2020/03/31.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper mapper;

    @Override
    public boolean save(Student entity) {
        int result = mapper.insert(entity);
        if (result==0){
            return false;
        }
        return true;
    }

    @Override
    public boolean saveBatch(Collection<Student> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Student> entityList) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Student> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        int deleteId = mapper.deleteById(id);
        return id.equals(deleteId);
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<Student> queryWrapper) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    public boolean updateById(Student entity) {
        return false;
    }

    @Override
    public boolean update(Student entity, Wrapper<Student> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Student> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Student entity) {
        return false;
    }

    @Override
    public Student getById(Serializable id) {

        return mapper.selectById(id);
    }

    @Override
    public Collection<Student> listByIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public Collection<Student> listByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public Student getOne(Wrapper<Student> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Student> queryWrapper) {
        return null;
    }

    @Override
    public Object getObj(Wrapper<Student> queryWrapper) {
        return null;
    }

    @Override
    public int count(Wrapper<Student> queryWrapper) {
        return 0;
    }

    @Override
    public List<Student> list(Wrapper<Student> queryWrapper) {
        return mapper.selectList(null);
    }

    @Override
    public IPage<Student> page(IPage<Student> page, Wrapper<Student> queryWrapper) {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.eq("sex",2);
        mapper.selectPage(page,wrapper);
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<Student> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> listObjs(Wrapper<Student> queryWrapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<Student> page, Wrapper<Student> queryWrapper) {
        return null;
    }

    @Override
    public List<Matetial> getMaterial(String projId, String idcard, String xzqh,String code) {

        List<Matetial> matetials = new ArrayList<>();

        String url="http://localhost:8080/bipWZ/ws/entityDeployView?wsdl";
        String methodName="entityDeployView";
        String params="<?xml version=\"1.0\" encoding=\"UTF-8\"?><Array><accessKey>"+xzqh+"</accessKey><code>"+code+"</code><loginName>loginName</loginName><userName>userName</userName><bizId>"+projId+"</bizId></Array>";

//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        String result = WebServiceUtil.send(url, methodName, params);
        String result="<?xml version=\"1.0\" encoding=\"UTF-8\"?><entitys><entity><attchmentId></attchmentId><entityId>380570350</entityId><material>《实行综合计算工时工作制和不定时工作制申报表》</material><detail>null</detail><flag>1</flag><isScan>1</isScan><isShow>1</isShow><entityClassId>380570349</entityClassId><refer>0</refer></entity><entity><attchmentId></attchmentId><entityId>380570352</entityId><material>营业执照或社会保险登记证</material><detail>null</detail><flag>1</flag><isScan>1</isScan><isShow>1</isShow><entityClassId>380570351</entityClassId><refer>0</refer></entity><entity><attchmentId></attchmentId><entityId>380570354</entityId><material>工会（或涉岗职工）意见</material><detail>null</detail><flag>1</flag><isScan>0</isScan><isShow>1</isShow><entityClassId>380570353</entityClassId><refer>0</refer></entity></entitys>";

        if (StringUtils.isNotEmpty(result)){
            try {
                Document document = DocumentHelper.parseText(result);
                Element rootElement = document.getRootElement();
                List<Element> elements = rootElement.elements();
                if (elements.size() > 0){
                    for (Element element: elements) {
                        Matetial material = new Matetial();
                        if (element.element("material")!=null) {
                            material.setName(element.element("material").getTextTrim());
                        }
                        if (element.element("entityClassId")!=null) {
                            material.setClassnumber(element.element("entityClassId").getTextTrim());
                        }
                        if (element.element("entityId")!=null) {
                            material.setId(Long.valueOf(element.element("entityId").getTextTrim()));
                        }
                        if (element.element("isScan")!=null) {
                            material.setIsScan(element.element("isScan").getTextTrim());
                        }
                        if (element.element("refer")!=null) {
                            material.setRefer(element.element("refer").getTextTrim());
                        }
                        matetials.add(material);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        List<License> licenses = getLicenses(projId, idcard, xzqh, code);
        if (matetials.size()>0&&licenses.size() > 0){
            addLicenseToMaterial(matetials,licenses);
        }
        return matetials;
    }

    public List<License> getLicenses(String projId, String idcard, String xzqh, String code){

        List<License> licenses = new ArrayList<>();

        String url="http://localhost:8080/bipWZ/ws/LicenseLibraryvView?wsdl";
        String methodName="licenseLibraryvView";
        String params="<?xml version=\"1.0\" encoding=\"UTF-8\"?><Array><accessKey>"+xzqh+"</accessKey><code>"+code+"</code><loginName>loginName</loginName><userName>userName</userName><bizId>"+projId+"</bizId></Array>";
        String result="<?xml version=\"1.0\" encoding=\"UTF-8\"?><licences><licence><ftpPath>/ygzw/20200324/dda8e7e9-c289-4ae2-b2e0-137df4a6b3ad.jpg</ftpPath><fileName>dzdacs-2020-03-249:39:55-晴明</fileName><classNumber>1</classNumber><attchmentId>381861806</attchmentId><entityId>380570350</entityId><entityClassId>379806966</entityClassId><flag>-1</flag><materialName>身份证</materialName></licence></licences>";
//        String result = WebServiceUtil.send(url, methodName, params);

        if (StringUtils.isNotEmpty(result)) {
            try {
                Document document = DocumentHelper.parseText(result);
                Element rootElement = document.getRootElement();
                List<Element> elements = rootElement.elements();
                if (elements.size() > 0) {
                    for (Element element : elements) {
                        License license = new License();
                        if (element.element("fileName")!=null) {
                            license.setFileName(element.element("fileName").getTextTrim());
                        }
                        if (element.element("ftpPath")!=null) {
                            license.setPath(element.element("ftpPath").getTextTrim());
                        }
                        if (element.element("entityId")!=null) {
                            license.setEntityId(Long.valueOf(element.element("entityId").getTextTrim()));
                        }
                        if (element.element("refer")!=null) {
                            license.setRefer(element.element("refer").getTextTrim());
                        }
                        if (element.element("fileSize")!=null) {
                            license.setFileSize(element.element("fileSize").getTextTrim());
                        }
                        licenses.add(license);
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  licenses;
    }
    public void addLicenseToMaterial(List<Matetial> matetials,List<License> licenses){
        for (Matetial matetial:matetials) {
            int count=0;
            List<License> mLicense= new ArrayList<> ();
            for (License license:licenses) {
                if (matetial.getId().equals(license.getEntityId())){
                    mLicense.add(license);
                    count++;
                }
            }
            matetial.setCount(count);
            matetial.setContent(mLicense);
        }
    }
}
