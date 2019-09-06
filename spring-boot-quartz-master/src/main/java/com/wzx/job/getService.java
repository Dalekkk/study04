package com.wzx.job;

import com.wzx.dao.staff;
import com.wzx.service.HelloService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import java.util.List;

public class getService {
    public static void main(String[] args){
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://192.168.51.30:8080/HelloService?wsdl");
        jaxWsProxyFactoryBean.setServiceClass(HelloService.class);

        HelloService helloService=(HelloService) jaxWsProxyFactoryBean.create();
        staff staff=helloService.selectById("YN20190351");
        System.out.println("username"+staff.getUsername());
        List<staff> staffs=helloService.selectAll();
        System.out.println(staffs);
    }
}
