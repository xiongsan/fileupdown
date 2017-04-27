package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class DownController {
@RequestMapping("/download")
public void downSomething(HttpSession session,HttpServletResponse resp) throws Exception
{
	 resp.setHeader("content-disposition", new String("attachment;filename=第三版中文版.pdf".getBytes("utf-8"),"iso8859-1"));
     ServletContext application=session.getServletContext();
     FileInputStream in=null;
     OutputStream out=null;
     try{
     in=new FileInputStream(application.getRealPath("file/SPRING in action(第三版中文版).pdf"));
     out=resp.getOutputStream();
     int n;
     byte[] b=new byte[1024];
     while((n=in.read(b))!=-1)
     {
    	 out.write(b, 0, n);
     }
     }
     catch(Exception e)
     {
    	 e.printStackTrace();
     }
     finally
     {
    	 if(in!=null)
    	 {
    		 in.close();
    	 }
    	 if(out!=null)
    	 {
    		 in.close();
    	 }
     }
}   
}
