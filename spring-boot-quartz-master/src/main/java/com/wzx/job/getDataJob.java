package com.wzx.job;

import org.json.JSONArray;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.wzx.dao.staff;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class getDataJob extends QuartzJobBean {

    @Autowired
    private com.wzx.mapper.staffMapper staffMapper;

    @Override
    public void executeInternal(JobExecutionContext context) {
        try {
            URL url = new URL("http://192.168.51.30:8080/JsonTest/getJson");
            //URL url = new URL("http://192.168.51.30:8080/HelloService?wsdl");
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            PrintWriter out = null;
            //请求方式
            conn.setRequestMethod("POST");
//           //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数即数据
            //out.print(data);
            //缓冲数据
            out.flush();
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"GB2312"));
            String str = "";
            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            //关闭流
            is.close();
            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
            conn.disconnect();

            System.out.println(sb);

            JSONObject jsonObject=new JSONObject(sb.toString());
            JSONArray jsonArray=jsonObject.getJSONArray("rows");
            staff staff=new staff();
            List<staff> staffList=new ArrayList<staff>();
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                System.out.println(jsonObject1);
                staff.setUsercode(jsonObject1.getString("usercode"));
                staff.setUsername(jsonObject1.getString("username"));
                staff.setDepartment(jsonObject1.getString("department"));

                //staffMapper.insert(staff);
//                System.out.println("数据存储成功");
            }
            System.out.println("数据存储成功");
            System.out.println("查询结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
