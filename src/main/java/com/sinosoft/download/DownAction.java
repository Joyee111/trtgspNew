package com.sinosoft.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.BaseFormController;
@Controller
public class DownAction extends BaseFormController {
		public ModelAndView download(HttpServletRequest request,HttpServletResponse response) throws Exception{
      //  response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("UTF-8");  
        java.io.BufferedInputStream bis = null;  
        java.io.BufferedOutputStream bos = null;  
        String fileName = request.getParameter("fileName");
        URLDecoder.decode(fileName, "utf-8");
        
        String ctxPath = request.getSession().getServletContext().getRealPath(  
                "/");
        String downLoadPath = ctxPath + fileName;  
        System.out.println(downLoadPath);  
        try {  
            long fileLength = new File(downLoadPath).length();  
            response.setContentType("application/x-msdownload;");  
            response.setHeader("Content-disposition", "attachment; filename="  
                    + fileName);  
            response.setHeader("Content-Length", String.valueOf(fileLength));  
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
            bos = new BufferedOutputStream(response.getOutputStream());  
            byte[] buff = new byte[2048];  
            int bytesRead;  
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
                bos.write(buff, 0, bytesRead);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (bis != null)  
                bis.close();  
            if (bos != null)  
                bos.close();  
        }  
        return null;  
		}
		@RequestMapping("/download.html")
		public String downLoad(HttpServletRequest request, HttpServletResponse response) throws IOException{
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			String file_name = request.getParameter("fileName");
			try{
				URLDecoder.decode(file_name, "utf-8");
				String ctxPath = request.getSession().getServletContext().getRealPath(  
	            "/");
				String downLoadPath = ctxPath + file_name;  
				File file = new File(downLoadPath);
				///String fileName = file.getName();
				// long fileLength = new File(downLoadPath).length();  
				  	response.reset();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("application/x-download; charset=utf-8");

					// 解决下载文件名中文乱码
					String fileName = file.getName();
					if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
						try {
							fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// firefox浏览器
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					} else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
						try {
							fileName = URLEncoder.encode(fileName, "UTF-8");// IE浏览器
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}else if (request.getHeader("User-Agent").toLowerCase().indexOf("chrome") > 0) {
						try {
							fileName = new String(fileName.getBytes("UTF-8"), "UTF-8");// chrome浏览器
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}

					response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
					
					 bis = new BufferedInputStream(new FileInputStream(downLoadPath));  //读去
			            bos = new BufferedOutputStream(response.getOutputStream());  
			            byte[] buff = new byte[2048];  
			            int bytesRead;  
			            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
			                bos.write(buff, 0, bytesRead);  
			            }  
			}catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            if (bis != null)  
	                bis.close();  
	            if (bos != null)  
	                bos.close();  
	        }  
			
			return null;
		}
}
