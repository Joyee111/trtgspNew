<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>药品质量标准档案</title>
	</head>
	<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">品种管理&nbsp;>&nbsp;质量标准档案</font>
		<div class="caozuo_box">
			<form name="query_drugstand" id="query_drugstand"
				action="queryStandardFiles.html" method="post">
				编号
				<input name="query_number" id="query_number" type="text"
					class="text1" size="20" />
				&nbsp;&nbsp;&nbsp;&nbsp;通用名称
				<input name="query_commonname" id="query_commonname" type="text"
					class="text1" size="20" />
				<shiro:hasPermission name="MedicineArchivesManage_find">
					<input name="" type="submit" class="btn_big" value="搜索" />
				</shiro:hasPermission>
				<shiro:hasPermission name="MedicineArchivesManage_add">
					<input name="" type="button" class="btn_big" value="新增" onclick="addStandardFile()" />
				</shiro:hasPermission>
				<c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				<input name="" type="hidden" class="btn_big" value="删除" onclick="delFirsrEnterprise()" />
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
				
			</form>
		</div>
		<form action="delete_standardFile.html" name="del_standardFile" id="del_standardFile" method="post">
		<display:table name="standardFiles" cellspacing="0" cellpadding="0"
			requestURI="" style="width:98%;" id="standardFile"
			pagesize="${pagesize}" class="table" export="true"
			size="${resultSize}" partialList="true">
			<display:column
				title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html">
				<input type="checkbox" name="delete_id" value="${standardFile.id}">
			</display:column>
			<display:column property="number" escapeXml="true"
				sortable="false" titleKey="编号" />
			<display:column property="commonName" escapeXml="true"
				sortable="false" titleKey="通用名称" />
			<display:column property="standardAccord" escapeXml="true"
				sortable="false" titleKey="标准依据" />
			<display:column property="createDate" escapeXml="true"
				sortable="false" titleKey="建档日期"  decorator="com.sinosoft.util.FormatDateColumnDecorator"/>
			<display:column property="createUserName" escapeXml="true"
				sortable="false" titleKey="建档人" />
			<display:column titleKey="操作" autolink="true" media="html" class="">
				<shiro:hasPermission name="MedicineArchivesManage_look">
					<img src="../images/look.gif" />
					<a href="view_standardFile.html?type=view&id=${standardFile.id}">查看</a>
				</shiro:hasPermission>
				<shiro:hasPermission name="MedicineArchivesManage_modify">
					<img src="../images/edit.gif" />
					<a href="view_standardFile.html?type=edit&id=${standardFile.id}">修改</a>
				</shiro:hasPermission>
				
			</display:column>
			<display:setProperty name="export.pdf" value="false" />
			<display:setProperty name="export.csv" value="false" />
			<display:setProperty name="export.xml" value="false" />
		</display:table>
		</form>
		<script type="text/javascript">
		function addStandardFile(){
			window.location.href="add_standardFile.html";
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