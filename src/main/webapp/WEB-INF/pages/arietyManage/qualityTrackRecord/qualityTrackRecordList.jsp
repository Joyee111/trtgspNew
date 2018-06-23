<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>质量档案记录</title>
		<script type="text/javascript">
			function delFirsrEnterprise(str){
			//var from =document.getElementById("del_standardFile");
			var r=confirm("是否确认删除！")
			if(r){
				//from.submit();
				$.post("deleteQualityTrackRecord.html",{
					id:str
				},function(date){
					var json = jsonParse(date);
					if(json.success!=null && json.success!=""){
						alert(decodeURI( json.success));
					}
					var midinceId = $("#midinceId").val();
					window.location.href="findQualityTrackRecord.html?midinceId="+midinceId
				})
			}else{
				return;
			}
		}
		</script>
	</head>
	<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">品种管理&nbsp;>&nbsp;质量档案记录&nbsp;>&nbsp;质量档案记录明细</font>
		<display:table name="recordList" cellspacing="0" cellpadding="0"
			requestURI="" style="width:98%;" id="record"
			pagesize="${pagesize}" class="table" export="true"
			size="${resultSize}" partialList="true">
			<display:column
				title="<input type='checkbox' id='checkall' name='checkall' value='${record.id }' onclick='checkAll(\"delete_id\")' />全选" media="html">
				<input type="checkbox" name="delete_id" value="${record.id}">
			</display:column>
			<display:column property="qualityFiles.qualityMidicine.commonname" escapeXml="true"
				sortable="false" titleKey="通用名称" />
				<display:column property="qualityFiles.qualityMidicine.produceno.customerName" escapeXml="true"
				sortable="false" titleKey="生产厂商" />
				<display:column property="qualityFiles.qualityMidicine.validdate" escapeXml="true"
				sortable="false" titleKey="有效期" />
			<display:column property="projectName" escapeXml="true"
				sortable="false" titleKey="项目名称" />
			<display:column property="changContent" escapeXml="true"
				sortable="false" titleKey="变更情况" />
			<display:column property="modifiedTime" escapeXml="true"
				sortable="false" decorator="com.sinosoft.util.FormatDateColumnDecorator"  titleKey="变更时间" />
			<display:column titleKey="操作" autolink="true" media="html" class="">
				<img src="../images/look.gif"/>
				<a href="viewQualityTrackRecord.html?id=${record.id}">修改</a>
				<c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				<a href="javascript:delFirsrEnterprise('${record.id}');">删除</a>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
				
			</display:column>
			<display:setProperty name="export.pdf" value="false" />
			<display:setProperty name="export.csv" value="false" />
			<display:setProperty name="export.xml" value="false" />
		</display:table>
		<input type="hidden" id="midinceId" value="${midinceId}">
		 <div class="caozuo_box2">
		 	<form action="addQualityTrackRecord.html" style="float:left;margin-left: 980px;" method="post">
		 		<input name="qualityFilesId"  type="hidden" value="${qualified}" />
		 		<shiro:hasPermission name="QualityStandardManage_add">
		 		 <input name="" type="submit" class="btn_big" value="新增"   />
		 		 </shiro:hasPermission>
		 	</form>
            <input name="" type="button" class="btn_big" value="返回" onclick="returnQualityTrackRecord()"/>
            </div>
		<script type="text/javascript">
		function returnQualityTrackRecord(){
			window.location.href="qualityFiles.html";
		}
		
		</script>
	</body>
</html>