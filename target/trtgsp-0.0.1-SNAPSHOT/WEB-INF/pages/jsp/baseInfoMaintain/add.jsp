<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加基本字段</title>
  </head>
  
  <body style="background:#fff8ee;">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="10%" valign="top">
			<a href="baseInfoMain/add.html">添加字段</a><br/>
			<a href="baseInfoMain/list.html">字段列表</a>		
		</td>
		<td width="90%">

		 
		 <form action="baseInfoMaintain/saveColumn.html" method="post">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		    <tr>
		      <td width="13%">字段名称：</td>
		      <td width="37%"><label>
		        <input name="columnName" type="text" id="columnName" />
		      </label></td>
		      <td width="14%">字段类型：</td>
		      <td width="36%"><input name="columnFieldType" type="text" id="columnFieldType" /></td>
		    </tr>
		    <tr>
		      <td>字段长度：</td>
		      <td><input name="columnLength" type="text" id="columnLength" /></td>
		      <td>所属类别：</td>
		      <td><label>
		        <select name="columnTypeId" id="columnTypeId">
		          <option value="default">---请选择---</option>
		          <option value="EmployeeBaseInfo">员工信息</option>
		          <option value="EmployeeEducation">学历信息</option>
		        </select>
		      </label></td>
		    </tr>
		    <tr>
		      <td>备注：</td>
		      <td colspan="3"><label>
		        <textarea name="note" id="note"></textarea>
		      </label></td>
		    </tr>
		  </table>

			 
		  <center><input type="submit" value="添加字段"/>"</center>
		 </form>
		 
		</td>
	</tr>  
  </table>


  </body>
</html>
