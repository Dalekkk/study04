package com.wzx.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class loginConfirm {

    @Autowired
    private com.wzx.mapper.userMapper userMapper;

    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public String login(HttpServletRequest request){
        String msg="登录失败";
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("username:"+username+"password:"+password);
        if(userMapper.selectByName(username)!=null&userMapper.selectByName(username).getPassword().equals(password)){
            msg="success";
        }
        return msg;
    }
}
