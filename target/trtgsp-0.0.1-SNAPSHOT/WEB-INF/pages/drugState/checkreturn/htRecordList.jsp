<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>退货验收回退记录</title>
	</head>
	<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;退货验收管理&nbsp;>&nbsp;退货验收回退记录</font>
		<display:table name="recordList" cellspacing="0" cellpadding="0"
			requestURI="" style="width:98%;" id="record"
			pagesize="${pagesize}" class="table" export="true"
			size="${resultSize}" partialList="true">
			<display:column property="rollbackReason" escapeXml="true"
				sortable="false" titleKey="申请原因" />
			<display:column property="applicant.realname" escapeXml="true"
				sortable="false" titleKey="申请人" />
			<display:column property="applyDate" escapeXml="true"
				sortable="false" decorator="com.sinosoft.util.FormatDateColumnDecorator"  titleKey="申请时间" />
		</display:table>
		 <div class="caozuo_box2">
            <input name="" type="button" class="btn_big" value="返回" onclick="goBack()"/>
            </div>
	</body>
</html>