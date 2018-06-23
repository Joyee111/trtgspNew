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
    <title>编辑基本字段</title>
  </head>
  
  <body style="background:#fff8ee;">
	<form:form commandName="entity" method="post" action="baseInfoMaintain/saveColumn.html" id="searchForm">
	<div class="bj_biao"><h4><fmt:message key="user.selectcon"/></h4></div>
	<div class="box5" id="selectcondiv" style="display: inline">
		  <input type="hidden" id="columnId" name="columnId" value="${entity.columnId}" />
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		    <tr>
		      <td width="13%">字段名称：</td>
		      <td width="37%"><label>
		        <form:input path="columnName" type="text" id="columnName" />
		      </label></td>
		      <td width="14%">字段类型：</td>
		      <td width="36%"><form:input path="columnFieldType" type="text" id="columnFieldType" /></td>
		    </tr>
		    <tr>
		      <td>字段长度：</td>
		      <td><form:input path="columnLength" type="text" id="columnLength" /></td>
		      <td>所属类别：</td>
		      <td><label>
		        <select name="columnTypeId" id="columnTypeId">
		          <option value="default">---请选择---</option>
		          <option value="EmployeeBaseInfo" ${entity.columnTypeId =='EmployeeBaseInfo'? 'selected':''}>员工信息</option>
		          <option value="EmployeeEducation" ${entity.columnTypeId =='EmployeeEducation'? 'selected':''}>学历信息</option>
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
	</div>
	<table width="100%">
		<tr>
			<td align="center">
				<input type="submit" value="保存" class="btn_blue2"/>
			</td>
		</tr>
	</table>
	</form:form>
	</form>
	</div>
  </body>
</html>
