package com.wzx.job;

import com.wzx.dao.staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;

@Controller
@RequestMapping("/query")
public class queryData extends HttpServlet {
    @Autowired
    private com.wzx.mapper.staffMapper staffMapper;

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/searchData",method = RequestMethod.POST)
    @ResponseBody
    public staff searchData(String usercode){
        System.out.println(usercode);
        staff staffdata=staffMapper.selectByPrimaryKey(usercode);
        System.out.println(staffdata);
        return staffdata;
    }
}
