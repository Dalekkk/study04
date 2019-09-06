package com.wzx.job;


import com.wzx.dao.staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class Search extends HttpServlet {

    @Autowired
    private com.wzx.mapper.staffMapper staffMapper;

    @RequestMapping(value = "Search",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public List<staff> staffSearch(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String usercode=request.getParameter("word");
        System.out.println(usercode);
        List<staff> staffdata= new ArrayList<>();
        staffdata.add(staffMapper.selectByPrimaryKey(usercode));
        System.out.println(staffdata);

        return staffdata;
    }
}
