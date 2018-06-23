<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>系统管理</title>
	<script type="text/javascript">
		  $(function(){
    	$("#startDate").datebox({
    		onSelect:function(date){
    			//alert(date);
    			var startDate=$("#startDate").datebox("getValue");
    			var endDate = $("#endDate").datebox("getValue");
    			
    			if(typeof(endDate)!=undefined && endDate!=""){
    				if(startDate > endDate){
    					alert("起始时间不能大于结束时间");
    				}
    			}
    			
    		}
    	});
    	$("#endDate").datebox({
    		onSelect:function(date){
    			//alert(date);
    			var startDate = $("#startDate").datebox("getValue");
    			var endDate = $("#endDate").datebox("getValue");
    		
    			if(typeof(startDate)!=undefined && startDate!=""){
    				if(startDate > endDate){
    					alert("结束时间不能大于开始时间");
    				}
    			}
    			
    		}
    	});
    });
	</script>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">系统管理&nbsp;>&nbsp;系统日志</font>
    	 <div class="tab_con">
        	<div class="caozuo_box">
        	<form action="systemLog.html">
        		时间范围：<input type="text" id="startDate" name="startDate" value="${startDate}" class="easyui-datebox text" style="height: 28px;"/>&nbsp;--至--
				<input type="text" id="endDate" name="endDate" value="${endDate}" class="easyui-datebox text1" style="height: 28px;">
				<input type="submit" value="查询" class="btn_big"/>
			</form>
            </div>
          
 			<display:table name="logList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="log" pagesize="${pagesize}" class="table" export="true" size="${resultSize}" partialList="true">
 				<display:column title="序号" value="${log_rowNum}"></display:column>
 				<display:column property="action" escapeXml="true" sortable="false" titleKey="动作" />
				<display:column property="log_date" escapeXml="true" sortable="false" titleKey="日志时间"/>
				<display:column property="action_person" escapeXml="true" sortable="false" titleKey="操作人员"/>
				<display:column property="action_type" escapeXml="true" sortable="false" titleKey="动作类型"/>
				<display:column property="ip" escapeXml="true" sortable="false" titleKey="IP"/> 
				<display:column property="module" escapeXml="true" sortable="false" titleKey="功能模块"/>
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
				<display:setProperty name="export.excel" value="false" /> 
			</display:table>
            </div>
</body>
</html>