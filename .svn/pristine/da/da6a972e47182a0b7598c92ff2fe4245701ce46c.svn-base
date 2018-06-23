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
		<title>购进推出变更记录</title>
	</head>
	<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;购进推出管理&nbsp;>&nbsp;购进推出变更记录</font>
		<display:table name="recordList" cellspacing="0" cellpadding="0"
			requestURI="" style="width:98%;" id="record"
			pagesize="${pagesize}" class="table" export="true"
			size="${resultSize}" partialList="true">
			<display:column
				title="<input type='checkbox' id='checkall' name='checkall' value='${record.id }' onclick='checkAll(\"delete_id\")' />全选" media="html">
				<input type="checkbox" name="delete_id" value="${record.id}">
			</display:column>
			<display:column property="projectName" escapeXml="true"
				sortable="false" titleKey="项目名称" />
			<display:column property="changeContent" escapeXml="true"
				sortable="false" titleKey="变更情况" />
			<display:column property="changeReason" escapeXml="true"
				sortable="false" titleKey="变更原因" />
			<display:column property="modityUser.realname" escapeXml="true"
				sortable="false" titleKey="变更人" />
			<display:column property="modityDate" escapeXml="true"
				sortable="false" decorator="com.sinosoft.util.FormatDateColumnDecorator"  titleKey="变更时间" />
		</display:table>
		<input type="hidden" id="midinceId" value="${midinceId}">
		 <div class="caozuo_box2">
            <input name="" type="button" class="btn_big" value="返回" onclick="goBack()"/>
            </div>
	</body>
</html>