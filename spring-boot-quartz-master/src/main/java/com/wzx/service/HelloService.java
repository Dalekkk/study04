package com.wzx.service;

import com.wzx.dao.staff;
import com.wzx.mapper.staffMapper;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface HelloService {
    public staff selectById(String usercode);
    public List<staff> selectAll();
}
