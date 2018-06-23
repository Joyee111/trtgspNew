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
    <title>添加员工基本信息</title>
  </head>
  
  <body style="background:#fff8ee;">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="10%" valign="top">
			<a href="baseInfoMain/add.html">添加字段</a><br/>
			<a href="baseInfoMain/list.html">字段列表</a>		
		</td>
		<td width="90%">

		 
		 <form action="employeeBaseInfo/saveEmployeeBaseInfo.html" method="post">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		  	<c:forEach items="list" var="item">
		  	<tr>
		  		<th>${item.columnName }</th>
		  		<td>
		  			<input type="text" name="column_${item.columnId }" id="column_${item.columnId }"/>"
		  		</td>
		  	</tr>	
		  	</c:forEach>
		  </table>
			 
		  <center><input type="submit" value="保存"/>"</center>
		 </form>
		 
		</td>
	</tr>  
  </table>


  </body>
</html>
