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
    <title>基本信息维护列表</title>
    <script type="text/javascript">
    	function add(){
    		alert("添加员工信息");
    	}
    
    
    </script>
  </head>
  
    <body style="background:#fff8ee;">
  <table width="100%" border="1">
	<tr>
		<td width="10%">
			<a href="baseInfoMain/add.html">添加字段</a>
			<a href="baseInfoMain/list.html">字段列表</a>		
		</td>
		<td width="90%">
		    <div class="ceng_mar5">
			<display:table name="list" cellspacing="0" cellpadding="0" requestURI="" style="width:100%;" id="users" pagesize="${pagesize}" class="table_cx" export="true" size="${resultSize}" partialList="true">
				<display:column property="columnName"></display:column>
				<display:column property="columnTypeId"></display:column>
			</display:table>
			</div>
		</td>
	</tr>  
  </table>

  </body>
</html>
