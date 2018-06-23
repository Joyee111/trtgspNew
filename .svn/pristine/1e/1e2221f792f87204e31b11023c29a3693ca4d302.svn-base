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
	<title>合格供货单位修改明细</title>
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
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;合格购货单位&nbsp;>&nbsp;合格购货单位修改记录</font>
 			<display:table name="accessoryList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="archives" pagesize="${pagesize}" class="table" export="true" size="${resultSize}" partialList="true">
 				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html"><input type="checkbox" name="delete_id" value="${archives.id}" ></display:column>
 				<display:column property="project_name" escapeXml="true" sortable="false" titleKey="项目名称" />
				<display:column property="changeContent" escapeXml="true" sortable="false" titleKey="变更内容" />
				<display:column property="modifier.realname" escapeXml="true" sortable="false" titleKey="变更人" />
				<display:column property="reason" escapeXml="true" sortable="false" titleKey="变更原因" />
				<display:column property="modified_time" escapeXml="true" sortable="false" titleKey="变更时间" decorator="com.sinosoft.util.FormatDateColumnDecorator"/>
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>
			 <div class="caozuo_box2">
            <input name="" type="button" class="btn_big" value="返回" onclick="return_back()"/>
            </div>
	<script type="text/javascript">
//	parent.highlightTableRows("firstEnterpriseList");	
/*	function addFirsrEnterprise(){
		window.location.href="";
	}
	
	function delFirsrEnterprise(){
		var from =document.getElementById("del_syqydlr");
		var r=confirm("是否确认删除！")
		if(r){
			from.submit();
		}else{
			return;
		}
	}*/
    </script>
    
    <script type="text/javascript">
    	function return_back(){
    		window.location.href="hgghdw.html"
    	}
    	
    </script>
</body>
</html>