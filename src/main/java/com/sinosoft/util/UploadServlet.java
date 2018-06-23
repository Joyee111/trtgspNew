package com.sinosoft.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.base.Constants;
import com.sinosoft.drugState.inspectionRecords.model.TicketSamples;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.inspectionRecords.service.impl.InspectionMngImpl;

@SuppressWarnings("serial")
public class UploadServlet extends HttpServlet {
	@Autowired
	private InspectionMng  inspectionMng;
	/**
	 * Constructor of the object.
	 */
	public UploadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cacha");
		
		String serverRealPath = request.getSession().getServletContext().getRealPath("/");//获取服务器绝对路径
		String fileSavePath = serverRealPath+Constants.UPLOAD_PATH;//上传文件存储的绝对路径
		String fileTempPath = serverRealPath+Constants.TEMPPATH;//上传文件在服务器临时存储的的绝对路径
		new File(fileSavePath).mkdirs();
		try{
			File tempPathFile = new File(fileTempPath);
			if(!tempPathFile.exists()){
				tempPathFile.mkdirs();
			}
		int sizeThreshold = Integer.valueOf(Constants.SIZETHRESHOLD);//缓冲区的大小
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(tempPathFile);
		factory.setSizeThreshold(sizeThreshold);
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = upload.parseRequest(request);
		Iterator<FileItem> its = items.iterator();
		while(its.hasNext()){
			FileItem item = its.next();
			String fileName = "ticketSamples";//重命名文件名
			FileItem uploadFile = (FileItem) item;
			String fileNameLong = uploadFile.getName();//获取上传文件的名称
		//	String requestName = uploadFile.getFieldName();//获取上传文件对应字段名称
			String fileNameExtension = FileUtil.getFileExtension(fileNameLong);//获取文件的上传拓展名
			String relativeSavePath = Constants.UPLOAD_PATH+fileName+"."+fileNameExtension;//用户保存到数据库的相对文件路径及名称
			relativeSavePath = relativeSavePath.substring(1);
			File savaFile = new File(fileSavePath+fileName+"."+fileNameExtension);
			//InspectionMngImpl mngImpl = new InspectionMngImpl();
			TicketSamples ticketSamples = inspectionMng.getTicketSamplesByName("ticketSamples");
			if(ticketSamples != null){
				String ticketPath = ticketSamples.getTicketSamplesPath();
				if( ticketPath != null && !"".equals(ticketPath.trim())){
					File f = new File(Constants.UPLOAD_PATH+ticketPath);
					if(f.exists()){
						FileOperate.delFile(Constants.UPLOAD_PATH+ticketPath);
					}
				}
			}
			uploadFile.write(savaFile);
			TicketSamples ticket = inspectionMng.getTicketSamplesByName("ticketSamples");
			if(ticket == null){
				ticket = new TicketSamples();
				ticket.setTicketSamplesName("ticketSamples");
				ticket.setTicketSamplesPath(fileSavePath+fileName+"."+fileNameExtension);
				inspectionMng.saveOrUpdateTicketSamples(ticket);
			}else{
				ticket.setTicketSamplesPath(fileSavePath+fileName+"."+fileNameExtension);
				inspectionMng.saveOrUpdateTicketSamples(ticket);
			}
		}
		}catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
