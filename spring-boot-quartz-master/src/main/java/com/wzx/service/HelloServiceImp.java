package com.wzx.service;

import com.wzx.dao.staff;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.wzx.service.HelloService",serviceName = "HelloService")
public class HelloServiceImp implements HelloService {

    @Autowired
    private com.wzx.mapper.staffMapper staffMapper;

    @Override
    public staff selectById(String usercode){
        staff staff=staffMapper.selectByPrimaryKey(usercode);
        return staff;
    }
    @Override
    public List<staff> selectAll(){
        List<staff> staffList=staffMapper.selectAll();
        return staffList;
    }
}
