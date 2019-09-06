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
		Staff staff1=new Staff("YN20190301","����","�з���");
        Staff staff2=new Staff("YN20190302","����","���²�");
        Staff staff3=new Staff("YN20190303","����","���۲�");
        Staff staff4=new Staff("YN20190351","���Ӻ�","����������");
        Staff staff5=new Staff("YN20190360","������","����������");
    
        
		List<Staff> stafflist = new ArrayList<Staff>();
	    stafflist.add(staff1);
		stafflist.add(staff2);
		stafflist.add(staff3);
		stafflist.add(staff4);
		stafflist.add(staff5);

		StaffTotal st = new StaffTotal(stafflist.size(), stafflist);
		
		//����GSON jar���߰���װ�õ�toJson��������ֱ������JSON�ַ���
		Gson gson = new Gson();
		String json = gson.toJson(st);
		
		//��������� 
		System.out.println(json);
    	resp.setContentType("text/plain");
    	resp.setCharacterEncoding("gb2312");
		PrintWriter out = new PrintWriter(resp.getOutputStream());
		out.print(json);
		out.flush();
		//����Gsonʹ���뿴JsonTest��
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
