package com.sinosoft.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
/**
 * @author zyl:
 * @version 创建时间：2013-07
 * Ireport 相关方法 
 */
public class IreportUtil {
	/**
	 * 导出数据到execl
	 * 
	 * @param list 列表数据
	 * @param templetPath 模板路径
	 * @param targetPath 文件导出路径
	 * @return 无
	 */
	public void exporterExecl(List<Object> list,String templetPath,String targetPath ) throws JRException, IOException {  
		JasperPrint print = null;
        
        File file = new File(targetPath);
		OutputStream out  = new FileOutputStream(file);
        InputStream is = new FileInputStream(templetPath);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(is);
        HashMap<String, Object> parameters1 = new HashMap<String, Object>();
        print = JasperFillManager.fillReport(jasperReport, parameters1,new JRBeanCollectionDataSource(list));
        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
        exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
        exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.FALSE);
        exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
        exporter.exportReport();
        out.flush();
        out.close();
	}
	/**
	 * 输出io流到前台
	 * 
	 * @param list 列表数据
	 * @param templetPath 模板路径
	 * @return 输出流
	 */
	public static void exporterIO(List<?> list, String templetPath,
			HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, JRException {

		// OutputStream out = null ;
		String filePath = request.getSession().getServletContext().getRealPath(
				"/");
		String jasperTempFile = filePath + "templet\\" + templetPath
				+ ".jasper";

		try {
			response.setContentType("text/html; charset=UTF-8");
			ServletOutputStream out = response.getOutputStream();
			File file = new File(jasperTempFile);
			JasperReport jsReport = (JasperReport) JRLoader.loadObject(file);
			JasperPrint jsPrint = JasperFillManager.fillReport(jsReport,
					new HashMap<String, Object>(),
					new JRBeanCollectionDataSource(list));
			JRHtmlExporter export = new JRHtmlExporter();
			export.setParameter(JRExporterParameter.JASPER_PRINT, jsPrint);
			export.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
			export.exportReport();
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 导出 excle
	 * @param file 模版路径
	 * @param reportChineseName 导出Excle名称
	 * @param request
	 * @param response
	 */
	public static  void export(String file, String reportChineseName,List<?> list ,HttpServletRequest request,HttpServletResponse response) {
		  System.out.println("ReportList.export()");
		  
		  String filePath = request.getSession().getServletContext().getRealPath("/");
		  String jasperTempFile = filePath + "templet\\" + file + ".jasper";
		  File jasperFile = new File(jasperTempFile);
		  try{
		         JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile.getPath(),new HashMap<String, Object>(),new JRBeanCollectionDataSource(list));                                                                               
		         JRExporter   exporter   =   new   JRXlsExporter();   

		   byte[]   bytes;   
		   ByteArrayOutputStream   baos   =   new   ByteArrayOutputStream();   
		   
		   exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);   
		   exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,baos);
		//   exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
		   exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE); 
		   exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE); 
		   exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		   exporter.exportReport();   
		   
		   bytes   =   baos.toByteArray();   
		    if   (bytes   !=   null   &&   bytes.length   >   0){   
		     response.reset();   
		     response.setCharacterEncoding("utf-8");
		     response.setContentType("application/vnd.ms-excel;charset=GB2312");   
		     response.setHeader("Content-disposition","attachment;   filename=\"" + URLEncoder.encode(reportChineseName, "UTF-8") + ".xls\"");   
		     response.setContentLength(bytes.length);   
		     ServletOutputStream   ouputStream   =   response.getOutputStream();   
		     ouputStream.write(bytes,   0,   bytes.length);   
		     ouputStream.flush();   
		     ouputStream.close();  
		     baos.close();   
		    }   
		  
		  }catch(Exception e){   
		   try {
		    throw e;
		   } catch (Exception e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		   }  
		  }
		}
}

