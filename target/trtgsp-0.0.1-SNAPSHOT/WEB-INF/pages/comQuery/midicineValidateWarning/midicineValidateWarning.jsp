<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>近效期药品月预警</title>
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
	
		<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;近效期药品月预警</font>
    	 <div class="tab_con">
 			<display:table name="storeList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="strore" pagesize="${pagesize}" class="table" export="true" size="${resultSize}" partialList="true" >
 				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html"><input type="checkbox" name="delete_id" value="${strore.id}" ></display:column>
 				
				<display:column property="qualityMidicine.commonname" escapeXml="true" sortable="false" titleKey="通用名称"/>
				<display:column property="batchproduction" escapeXml="true" sortable="false" titleKey="生产批号"/>
				<display:column property="validdate" escapeXml="true" sortable="false" titleKey="药品有效期终止时间"/>
				<display:column property="qualityMidicine.medicinalAttribute" escapeXml="true" sortable="false" titleKey="存储条件"/>
				<display:column property="quantity" escapeXml="true" sortable="false" titleKey="现存数量"/>
				<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
				</display:setProperty> 
				<display:setProperty name="export.excel" value="true"/>
			</display:table>
            <div class="caozuo_box2">
            </div>
            </div>
</body>
</html>