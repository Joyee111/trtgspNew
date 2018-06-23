<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>合格品种修改记录</title>
    <script type="text/javascript">
	function check(){
		var field=document.getElementsByName("delete_id");
		var j =1;
		for (i = 0; i < field.length; i++) {
				if(field[i].checked = false){
					document.getElementById("checkall").checked = false;
					return;
				}
				j++;
		}
		if(j==field.length){
			document.getElementById("checkall").checked = true;
		}
	}
    </script>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">品种管理&nbsp;>&nbsp;合格品种&nbsp;>&nbsp;合格品种修改记录</font>
 			<display:table name="recordsyList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="record" pagesize="${pagesize}" class="table" export="true" size="${resultSize}" partialList="true">
 				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html"><input type="checkbox" name="delete_id" value="${record.id}" ></display:column>
 				<display:column property="projectName" escapeXml="true" sortable="false" titleKey="项目名称" />
				<display:column property="changeContent" escapeXml="true" sortable="false" titleKey="变更内容" />
				<display:column property="modifyReason" escapeXml="true" sortable="false" titleKey="变更原因" />
				<display:column property="modifyId.realname" escapeXml="true" sortable="false" titleKey="变更人" />
				<display:column property="modifyTime" escapeXml="true" sortable="false" titleKey="变更时间" decorator="com.sinosoft.util.FormatDateColumnDecorator"/>
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>
			 <div class="caozuo_box2">
            <input name="" type="button" class="btn_big" value="返回" onclick="return_back()"/>
            </div>
		<script type="text/javascript">
			function return_back(){
    				window.location.href="qulidiedMedicinal.html"
    			}
		</script>
</body>
</html>