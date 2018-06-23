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
    <title>基础编码</title>
    
    <script type="text/javascript">
    	function add(){
    		location.href="<%=basePath %>baseInfoMaintain/addColumn.html?category=add";
    	}
    
    
    </script>
    
  </head>
  
  <body style="background:#fff8ee;">
  <table width="100%" border="1">
	<tr>
		<td width="15%" valign="top">
			<a href="#">添加字段</a>
			<a href="#">字段列表</a>		
		</td>
		<td width="85%">
		
		 <table width="100%" border="1" cellspacing="0" cellpadding="0">
		 	<tr height="100" valign="top">
				<td>
					<form action="baseInfoMaintain/find.html" method="post">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								编码：<input type="text" name="code" id="code"/>
							</td>
							<td>
								字段名称：<input type="text" name="columnName" id="columnName"/>
							</td>
						</tr>
						<tr>
							<td>
								所属类别：<select name="columnTypeId" id="columnTypeId">
											<option value="varchar">varchar</option>
											<option value="int">int</option>
											<option value="byte">byte</option>
											<option value="double">double</option>	
										 </select>
							</td>
							<td>
								字段长度：<input type="text" name="columnLength" id="columnLength"/>
							</td>
						</tr>
					
					
						<tr>
							<td align="center"><input type="button" value="查询"/></td>
							<td align="center"><input type="button" value="添加" onclick="add();" /></td>
						</tr>
					</table>
					</form>
				</td>		 	
		 	</tr>
		 <div class="ceng_mar5">
		 	<tr height="400" valign="top">
		 		<td>
		 		 <table width="100%" border="0" cellspacing="0" cellpadding="0">
			  	  <tr height="30">
					<td width="16%">编码</td>
					<td width="12%">字段名称</td>
					<td width="12%">所属类别</td>
					<td width="12%">字段类型</td>
					<td width="12%">字段长度</td>
					<td width="12%">备注</td>
					<td width="12%">操作</td>
			  	  </tr>
				  <c:forEach items="${list}" var="item" varStatus="status">
				  <tr>
					<td>${item.code }</td>
					<td>${item.columnName }</td>
					<td>${item.columnTypeId }</td>
					<td>${item.columnFieldType }</td>
					<td>${item.columnLength }</td>
					<td>${item.note }</td>
					<td>
						<a href="<%=basePath %>baseInfoMaintain/addColumn.html?method=${item.columnTypeId }&category=edit&id=${item.columnId}">编辑</a>&nbsp;&nbsp;&nbsp;
						<a href="<%=basePath %>baseInfoMaintain/addColumn.html?method=${item.columnTypeId }&category=remove&id=${item.columnId}">删除</a>
					</td>
				  </tr>  
				  </c:forEach>
			    </table>
		 		
		 		</td>
		 	</tr>
</div>
		 </table>
		
		 

		</td>
	</tr>  
  </table>

  </body>
</html>
