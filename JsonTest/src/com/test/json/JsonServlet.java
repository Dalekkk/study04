package com.test.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.model.StaffTotal;
import com.test.model.Staff;

public class JsonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Staff staff1=new Staff("YN20190301","张三","研发部");
        Staff staff2=new Staff("YN20190302","李四","人事部");
        Staff staff3=new Staff("YN20190303","王五","销售部");
        Staff staff4=new Staff("YN20190351","陈子豪","技术开发部");
        Staff staff5=new Staff("YN20190360","张天旭","技术开发部");
    
        
		List<Staff> stafflist = new ArrayList<Staff>();
	    stafflist.add(staff1);
		stafflist.add(staff2);
		stafflist.add(staff3);
		stafflist.add(staff4);
		stafflist.add(staff5);

		StaffTotal st = new StaffTotal(stafflist.size(), stafflist);
		
		//调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
		Gson gson = new Gson();
		String json = gson.toJson(st);
		
		//输出到界面 
		System.out.println(json);
    	resp.setContentType("text/plain");
    	resp.setCharacterEncoding("gb2312");
		PrintWriter out = new PrintWriter(resp.getOutputStream());
		out.print(json);
		out.flush();
		//更多Gson使用请看JsonTest类
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
