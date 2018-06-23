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
		<title>质量档案记录</title>
	</head>
	<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">品种管理&nbsp;>&nbsp;质量档案记录</font>
		<div class="caozuo_box">
			<form name="query_drugstand" id="query_drugstand"
				action="qualityFiles.html" method="post">
				货号
				<input name="medicNo" id="query_medicinalNo" type="text"
					class="text1" size="20" />
				&nbsp;&nbsp;&nbsp;&nbsp;通用名称
				<input name="commonName" id="query_commonname" type="text"
					class="text1" size="20" />
				<input name="" type="submit" class="btn_big" value="查询" />
				<shiro:hasPermission name="QualityStandardManage_add">
				<input name="" type="button" class="btn_big" value="新增" onclick="addQualityFiles()" />
				</shiro:hasPermission>
			</form>
		</div>
		<form action="delete_standardFile.html" name="del_standardFile" id="del_standardFile" method="post">
		<display:table name="qualitFilesList" cellspacing="0" cellpadding="0"
			requestURI="" style="width:98%;" id="record"
			pagesize="${pagesize}" class="table" export="true"
			size="${resultSize}" partialList="true">
			<display:column
				title="<input type='checkbox' id='checkall' name='checkall' value='${record.id }' onclick='checkAll(\"delete_id\")' />全选" media="html">
				<input type="checkbox" name="delete_id" value="${record.id}">
			</display:column>
			<display:column property="qualityMidicine.medicinalNo" escapeXml="true"
				sortable="false" titleKey="货号" />
			<display:column property="qualityMidicine.commonname" escapeXml="true"
				sortable="false" titleKey="通用名称" />
			<display:column property="qualityMidicine.specifications" escapeXml="true"
				sortable="false" titleKey="规格" />
			<display:column property="qualityMidicine.unit" escapeXml="true"
				sortable="false" titleKey="单位" />
			<display:column property="qualityMidicine.produceno.customerName" escapeXml="true"
				sortable="false" titleKey="生产厂商" />
			<display:column property="createDate" escapeXml="true"
				sortable="false" titleKey="建档时间" decorator="com.sinosoft.util.FormatDateColumnDecorator" />
			<display:column titleKey="操作" autolink="true" media="html" class="">
				<img src="../images/look.gif"/>
				<a href="findQualityTrackRecord.html?qualityFilesId=${record.id}">查看跟踪记录</a>
				<img src="../images/look.gif"/>
				<a href="viewQualityFiles.html?type=view&id=${record.id}">查看</a>
				<img src="../images/edit.gif"/>
				<a href="viewQualityFiles.html?type=edit&id=${record.id}">修改</a>
			</display:column>
			<display:setProperty name="export.pdf" value="false" />
			<display:setProperty name="export.csv" value="false" />
			<display:setProperty name="export.xml" value="false" />
			<display:setProperty name="export.excel" value="false" />
		</display:table>
		</form>
		<script type="text/javascript">
		function addQualityFiles(){
			window.location.href="addQualityFiles.html";
		}
		function delFirsrEnterprise(){
			var from =document.getElementById("del_standardFile");
			var r=confirm("是否确认删除！")
			if(r){
				from.submit();
			}else{
				return;
			}
		}
		</script>
	</body>
</html>