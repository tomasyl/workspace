package com.lx.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.lx.common.util.UploadUtil;
   
@WebServlet(name="UploadServlet" ,urlPatterns={"/upload"})  
@MultipartConfig  
public class UploadServlet extends HttpServlet{  
       public void init(ServletConfig config)throws ServletException{  
              super.init(config);  
       }  
       public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{  
              Part part = request.getPart("file");  
              PrintWriter out = response.getWriter();  
              out.println("此文件的大小："+part.getSize()+"<br />");  
              out.println("此文件类型："+part.getContentType()+"<br />");  
              out.println("文本框内容："+request.getParameter("name")+"<br />");  
              out.println(UploadUtil.getFileName(part)+"<br />");  
              part.write("F:\\1."+UploadUtil.getFileType(part));  
       }  
}
