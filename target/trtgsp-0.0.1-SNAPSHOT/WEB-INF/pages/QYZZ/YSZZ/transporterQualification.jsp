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
	<title>承运资质</title>
</head>
<body>
		<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;承运资质</font>
    	 <div class="tab_con">
        	<div class="caozuo_box">
        	<form name="query_cys" id="query_cys" action="queryTransporterQualification.html" method="post">
               	 承运商名称： <input name="query_cysmc" id="query_cysmc" type="text" class="text1" size="20"/>
               	 合同名称： <input name="query_htmc" id="query_htmc" type="text" class="text1" size="20"/>
                &nbsp;&nbsp;&nbsp;&nbsp;<!-- 证照号 <input name="query_zjhm" id="query_zjhm" type="text" class="text1" size="20"/> -->
                <shiro:hasPermission name="CarriageQualify_find">
                	<input name="" type="submit" class="btn_big" value="查询"/>
                </shiro:hasPermission>
           </form>
            </div>
            <div class="ceng_mar5">
            <form name="del_cyszz" action="deleteTransporterQualification.html" id="del_cyszz" method="post" >
 			<display:table name="transQualifList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="transporter" pagesize="${pagesize}" class="table_yh" export="true" size="${resultSize}" partialList="true">
 				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html"><input type="checkbox" name="delete_id" value="${transporter.id}" ></display:column>
 				
				<c:choose>
					<c:when test="${transporter.deleteFlag == '0'}">
						<display:column style="color:#a87122" property="transporterName" escapeXml="true" sortable="false" titleKey="承运商名称" />
						<display:column style="color:#a87122" property="legalRepresentative" escapeXml="true" sortable="false" titleKey="法人代表"/>
						<display:column style="color:#a87122" property="businessLicense" escapeXml="true" sortable="false" titleKey="营业执证号"/>
						<display:column style="color:#a87122" property="transportationLicense" escapeXml="true" sortable="false" titleKey="运输经营/生产许可证号"/>
						<display:column style="color:#a87122" property="contractName" escapeXml="true" sortable="false" titleKey="合同名称"/>
						<display:column style="color:#a87122"  escapeXml="true" sortable="false" titleKey="状态">启用</display:column>
					</c:when>
					<c:when test="${transporter.deleteFlag == '1'}">
						<display:column style="color:#FF0000" property="transporterName" escapeXml="true" sortable="false" titleKey="承运商名称" />
						<display:column style="color:#FF0000" property="legalRepresentative" escapeXml="true" sortable="false" titleKey="法人代表"/>
						<display:column style="color:#FF0000" property="businessLicense" escapeXml="true" sortable="false" titleKey="营业执证号"/>
						<display:column style="color:#FF0000" property="transportationLicense" escapeXml="true" sortable="false" titleKey="运输经营/生产许可证号"/>
						<display:column style="color:#FF0000" property="contractName" escapeXml="true" sortable="false" titleKey="合同名称"/>
						<display:column  style="color:#FF0000" escapeXml="true" sortable="false" titleKey="状态">停用</display:column>
					</c:when>
					<c:when test="${transporter.deleteFlag == '2'}">
						<display:column style="color:#0000FF" property="transporterName" escapeXml="true" sortable="false" titleKey="承运商名称" />
						<display:column style="color:#0000FF" property="legalRepresentative" escapeXml="true" sortable="false" titleKey="法人代表"/>
						<display:column style="color:#0000FF" property="businessLicense" escapeXml="true" sortable="false" titleKey="营业执证号"/>
						<display:column style="color:#0000FF" property="transportationLicense" escapeXml="true" sortable="false" titleKey="运输经营/生产许可证号"/>
						<display:column style="color:#0000FF" property="contractName" escapeXml="true" sortable="false" titleKey="合同名称"/>
						<display:column style="color:#0000FF" escapeXml="true" sortable="false" titleKey="状态">暂时停用</display:column>
					</c:when>
				</c:choose>
				
				<display:column titleKey="操作" autolink="true" media="html"  class="border_rnone">
				<shiro:hasPermission name="CarriageQualify_modifyRecord">
					<img src="../images/look.gif"/><a href="queryTranQuaRecords.html?id=${transporter.id}">查看修改记录</a>
				</shiro:hasPermission>
				<shiro:hasPermission name="CarriageQualify_look">
					<img src="../images/look.gif"/><a href="viewTransporterQualification.html?type=view&id=${transporter.id}">查看</a>
				</shiro:hasPermission>
				<shiro:hasPermission name="CarriageQualify_modify">
					<img src="../images/edit.gif"/><a href="viewTransporterQualification.html?type=edit&id=${transporter.id}">编辑</a>
				</shiro:hasPermission>
				</display:column>
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>
			</form>
			</div>
            <div class="caozuo_box2">
            <shiro:hasPermission name="CarriageQualify_add">
            	 <input name="" type="button" class="btn_big" value="新增" onclick="addFirsrtransporter()"/>
            </shiro:hasPermission>
           	<shiro:hasPermission name="CarriageQualify_del">
           		<input name="" type="button" class="btn_big" value="删除" onclick="delFirsrtransporter()"/>
           	</shiro:hasPermission>
            
            </div>
            </div>
	<script type="text/javascript">
	function addFirsrtransporter(){
		window.location.href="addTransporterQualification.html";
	}
	function delFirsrtransporter(){
		//var from =document.getElementById("del_cyszz");
		var r=confirm("是否确认删除！")
		if(r){
			$("#del_cyszz").form("submit",{
				 success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="transporterQualification.html";
			    }  
			});
		}else{
			return;
		}
	}
    </script>
</body>
</html>