<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.sinosoft.ireportDTO.EntryTicket"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.File"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="net.sf.jasperreports.engine.util.JRLoader"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page
	import="net.sf.jasperreports.engine.data.JRBeanCollectionDataSource"%>
<%@page import="java.util.HashMap"%>
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporter"%>
<%@page import="net.sf.jasperreports.engine.JRExporterParameter"%>
<%@page
	import="net.sf.jasperreports.engine.export.JRHtmlExporterParameter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
	function printdiv() {
		var newstr = document.getElementById("print_area").innerHTML; //获得需要打印的内容
		var oldstr = document.body.innerHTML; //保存原先网页的代码
		document.body.innerHTML = newstr; //将网页内容更改成需要打印
		window.print();
		document.body.innerHTML = oldstr; //将网页还原
		return false;
	}
</script>
</head>
<body>
		<div id="print_div" >
		<input type="button" id="print_button" class="btn_big" value="打印"  onclick="printdiv()" style="float: right;margin-right: 200px;">
		<div id="print_area">
		 
		<%
			List<EntryTicket> list = (List<EntryTicket>)request.getAttribute("entryTicketList");
			String filePath = request.getSession().getServletContext()
					.getRealPath("/");
			String jasperTempFile = filePath + "templet\\entry_ticket.jasper";
			if(list!=null && list.size()>0){
			File file = new File(jasperTempFile);
			JasperReport jasperReport = (JasperReport) JRLoader
					.loadObject(file);
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, new HashMap<String, Object>(),
					new JRBeanCollectionDataSource(list));
			JRHtmlExporter htmlExporter = new JRHtmlExporter();
			htmlExporter.setParameter(JRExporterParameter.JASPER_PRINT,
					jasperPrint);
			htmlExporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
			htmlExporter.setParameter(
					JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,
					Boolean.FALSE);
			htmlExporter.exportReport();
			
			}
			out.flush();
			//out.close();
		%>
		
		</div>
		</div>
</body>
</html>