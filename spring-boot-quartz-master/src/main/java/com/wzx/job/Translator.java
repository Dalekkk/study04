package com.wzx.job;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.TranslatorWebService;
import cn.com.webxml.TranslatorWebServiceSoap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class Translator extends HttpServlet {

    @RequestMapping(value = "Translator",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public String Translator(HttpServletRequest request) throws UnsupportedEncodingException {
            request.setCharacterEncoding("utf-8");
            String word=request.getParameter("word");
            TranslatorWebService factory=new TranslatorWebService();
            TranslatorWebServiceSoap soap=factory.getTranslatorWebServiceSoap();
            ArrayOfString arrayOfString=soap.getEnCnTwoWayTranslator(word);
            List<String> list=arrayOfString.getString();
            System.out.println(list);
            //request.setAttribute("infor",list);

        return String.valueOf(list);
    }
}
