package com.sinosoft.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sinosoft.base.Constants;

public class UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpLoadServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String employId = request.getParameter("employId");
		
		request.setCharacterEncoding("utf-8");	//设置编码
		
		//获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//获取文件需要上传到的路径
		String path = request.getRealPath("/upload");
		
		File file = new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		factory.setRepository(file);
		//设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到暂时存储室
		factory.setSizeThreshold(1024*1024) ;
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			//可以上传多个文件
			List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
			for(FileItem item : list)
			{
				//获取表单的属性名字
				String name = item.getFieldName();
				//如果获取的 表单信息是普通的 文本 信息
				if(item.isFormField())
				{					
					//获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的
					String value = item.getString() ;
					request.setAttribute(name, value);
				}
				//对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
				else
				{
					PrintWriter pw = response.getWriter();
					//获取路径名
					String value = item.getName() ;
					//索引到最后一个反斜杠
					int start = value.lastIndexOf("\\");
					//截取 上传文件的 字符串名字，加1是 去掉反斜杠，
					String filename = value.substring(start+1);
					
					int sufIndex = filename.lastIndexOf(".");
					String suffix = filename.substring(sufIndex+1);//文件扩展名
					if(!Constants.Image_Format.contains(suffix.toLowerCase())){//判断是否为已知图片格式
						pw.print("请检查图片格式是否为："+Constants.Image_Format);
					}
					else{
						//filename = employId+"."+suffix;
						File imageFile = new File(path,filename);
						if(imageFile.exists()){
							imageFile.delete();
						}
						OutputStream out = new FileOutputStream(new File(path,filename));
						InputStream in = item.getInputStream() ;
						int length = 0 ;
						byte [] buf = new byte[1024] ;
						while( (length = in.read(buf) ) != -1){
							out.write(buf, 0, length);
						}
						in.close();
						out.close();
						
						pw.print("success");
					}
					pw.flush();
					pw.close();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
