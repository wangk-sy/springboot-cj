package com.example.demo.core;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @ClassName :WebServiceUtil
 * @Description :cxf调用webservice接口
 * @Author :16388
 * @Date :2020/4/3 16:53
 * @Version :1.0
 **/
public class WebServiceUtil {

    /*
    * @MethodName:send
    * @Description:TODO
    * @Param:[url（接口地址）, methodName（方法名）, params（参数）]
    * @Return:java.lang.String
    * @Date:2020/4/6
    * @Author:wangk
     */
    public static String send(String url,String methodName,String params){

        String result="";

        try {
            //在一个方法中连续调用多次WebService接口,每次调用前需要重置上下文
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            JaxWsDynamicClientFactory dynamicClientFactory =JaxWsDynamicClientFactory.newInstance();

            Client client = dynamicClientFactory.createClient(url);

            Object[] ob = client.invoke(methodName, params);
            //重置上下文context
            Thread.currentThread().setContextClassLoader(classLoader);

            if (ob[0]!=null){
                result=ob[0].toString();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }

}
