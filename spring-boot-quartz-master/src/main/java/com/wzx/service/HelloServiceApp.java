package com.wzx.service;

import javax.xml.ws.Endpoint;

public class HelloServiceApp {
    public static void main(String[] args){
        System.out.println("web service start");
        HelloServiceImp helloServiceImp=new HelloServiceImp();
        String address="http://192.168.51.30:9999/HelloService?wsdl";
        Endpoint.publish(address,helloServiceImp);
        System.out.println("web service started");
    }
}
