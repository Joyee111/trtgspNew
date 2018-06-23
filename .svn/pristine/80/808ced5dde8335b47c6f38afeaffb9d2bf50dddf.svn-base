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
	<title>我公司资质管理</title>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;我公司资质管理</font>
 			
        <div class="zhushi_box">
        	<img src="../images/zhushi.gif"/>
            <span><marquee width=95% onmouseover="this.stop()" onmouseout="this.start()"  scrollamount="5" id="warnMessage"></marquee></span>
        </div>
 			<display:table name="ourQualityManagementList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="ourQualityManagement" pagesize="${pagesize}" class="table_print" export="true" size="${resultSize}" partialList="true">
 				<c:choose>
 					<c:when test="${ourQualityManagement.useFlag=='1'}">
						<display:column property="customer_name" escapeXml="true" sortable="false" titleKey="公司名称"  class="print_flag"/>
						<display:column property="businessLicenceDate" escapeXml="true" sortable="false" titleKey="营业执照到期时间" class="print_flag"/>
						<display:column property="businessPermitDate" escapeXml="true" sortable="false" titleKey="经营/生产许可证到期时间" class="print_flag"/>
						<display:column property="gspCertificateDate" escapeXml="true" sortable="false" titleKey="GSP/GMP证书到期" class="print_flag"/>
						<display:column property="organizationCodeDate" escapeXml="true" sortable="false" titleKey="组织机构代码到期时间" class="print_flag"/>
						
						<display:column titleKey="操作" autolink="true" media="html"  class="print_flag">
		               	 <img src="../images/look.gif"/><a href="query_wgszzgljl.html?id=${ourQualityManagement.id}">查看修改记录</a>
						 <img src="../images/edit.gif"/><a href="view_wgszzglxg.html?id=${ourQualityManagement.id}">修改</a>
						</display:column>
 					</c:when>
 					<c:otherwise>
						<display:column property="customer_name" escapeXml="true" sortable="false" titleKey="公司名称"  class="noPrint_flag"/>
						<display:column property="businessLicenceDate" escapeXml="true" sortable="false" titleKey="营业执照到期时间" class="noPrint_flag"/>
						<display:column property="businessPermitDate" escapeXml="true" sortable="false" titleKey="经营/生产许可证到期时间" class="noPrint_flag"/>
						<display:column property="gspCertificateDate" escapeXml="true" sortable="false" titleKey="GSP/GMP证书到期" class="noPrint_flag"/>
						<display:column property="organizationCodeDate" escapeXml="true" sortable="false" titleKey="组织机构代码到期时间" class="noPrint_flag"/>
						
						<display:column titleKey="操作" autolink="true" media="html" class="noPrint_flag">
		               	 <img src="../images/look.gif"/><a href="query_wgszzgljl.html?id=${ourQualityManagement.id}">查看修改记录</a>
						 <img src="../images/edit.gif"/><a href="view_wgszzglxg.html?id=${ourQualityManagement.id}">修改</a>
						</display:column>
 					</c:otherwise>	
 				</c:choose>
 				
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>
			<script type="text/javascript">
			$(function(){
			$.post("ajaxQueryWarnOurQualityManagement.html",function(data){
				var json = jsonParse(data);
				var str = json.success;	
				//alert(str);
				$("#warnMessage").empty();
				$("#warnMessage").append(str);
			})
		})
		</script>
</body>
</html>