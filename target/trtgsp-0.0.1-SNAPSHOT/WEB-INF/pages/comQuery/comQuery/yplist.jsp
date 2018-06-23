<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>供货单位购货单位</title>
</head>
<body>
           <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;供货单位购货单位&nbsp;>&nbsp;供应商药品信息</font>
           <%
           	 int index = 0;
            %>
            <form  id="del_sypzdsh" method="post" >
 			<display:table name="qualityMidicinesList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="qualifiedMedic" pagesize="${pagesize}" class="table" export="true" size="${resultSize}" partialList="true">
 				<display:column value="<%=++index %>" titleKey="序号" escapeXml="true" sortable="true" />
 				<display:column property="commonname" escapeXml="true" sortable="false" titleKey="通用名称（品名）" />
				<display:column property="dosageforms.formName" escapeXml="true" sortable="false" titleKey="剂型"/>
				<display:column property="produceno.customerName" escapeXml="true" sortable="false" titleKey="生产企业"/>
				<display:column property="specifications" escapeXml="true" sortable="false" titleKey="规    格"/>
				<display:column property="licensenumber" escapeXml="true" sortable="false" titleKey="批准文号"/>
				<display:column property="validdate" escapeXml="true" sortable="false" titleKey="有 效 期"/>
			
    			<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
				</display:setProperty> 
				<display:setProperty name="export.excel" value="true"/>
			
			</display:table>
				<table>
	<tr align="center">
		<td colspan="4">
			 <input name="" type="button" class="btn_big" value="返回" onclick="goBack()"/>
		</td>
	</tr>
</table>
			<input type="hidden" name="save_type" id="save_type">
			
			</form>
	<script type="text/javascript">
    </script>
</body>
</html>