package com.example.demo.demo;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String param="<?xml version=\"1.0\" encoding=\"UTF-8\"?> <Array><code>yt01.06</code><idcard>123</idcard><accessKey>330301</accessKey><userId>666</userId><loginName>dzdacs</loginName><userName>dzdacs</userName><bizId>5a06241asbecd15f2210a</bizId><dzdaId></dzdaId><pid></pid></Array>";

        String address="http://localhost:8080/bipWZ/ws/LicenseLibraryvView?wsdl";

        try {

            JaxWsDynamicClientFactory dynamicClientFactory =JaxWsDynamicClientFactory.newInstance();

            Client client = dynamicClientFactory.createClient(address);

            Object[] ob = client.invoke("licenseLibraryvView", param);

            String result = ob[0].toString();



        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parseXml() {
        String t = "a||b||c||d";
        String[] temp = t.split("\\|\\|");
        System.out.println(temp.length);
    }

}
