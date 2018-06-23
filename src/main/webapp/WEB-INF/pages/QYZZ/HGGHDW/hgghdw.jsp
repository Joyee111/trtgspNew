<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<<style>
.table_print .print_flag_blue 
{ text-align:center;border:1px solid #e1be9f; border-left:none; border-bottom:none; font-size:12px; color:blue; height:26px;}
</style>
<html>

<head>
	<title>合格购货单位</title>
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

<body onload="load()">
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;合格购货单位</font>
   <div class="caozuo_box">
    <form name="query_hggys" id="query_enterprise" action="queryhgghdw.html" method="post"  >
        	编号 <input name="query_khbh" id="query_khbh" type="text" class="text1" size="20"/>
            &nbsp;&nbsp;&nbsp;&nbsp;客户名称 <input name="query_kfmc"  id="query_kfmc" type="text" class="text1" size="20"/>
            <input name="" type="submit" class="btn_big" value="搜索"/>
    </form>
        </div>
       
 			
        <div class="zhushi_box">
        	<img src="../images/zhushi.gif"/>
            <span><marquee width=95% onmouseover="this.stop()" onmouseout="this.start()"  scrollamount="5" id="warnMessage"></marquee></span>
        </div>
 			<display:table name="qualifiesPurcList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="qualifiesPurch" pagesize="${pagesize}" class="table_print" export="true" size="${resultSize}" partialList="true">
 				<c:choose>
 					<c:when test="${qualifiesPurch.useFlag=='1'}">
 						<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html" class="print_flag"><input type="checkbox" name="delete_id" value="${qualifiesPurch.id}" ></display:column>
		 				<display:column property="customerNumber" escapeXml="true" sortable="false" titleKey="编号" class="print_flag"/>
						<display:column property="customerName" escapeXml="true" sortable="false" titleKey="客户名称"  class="print_flag"/>
						<display:column property="busLiceExpiraDate" escapeXml="true" sortable="false" titleKey="营业执照到期时间" class="print_flag"/>
						<display:column property="liceExpirationDate" escapeXml="true" sortable="false" titleKey="经营/生产许可证到期时间" class="print_flag"/>
						<display:column property="gpsExpirationDate" escapeXml="true" sortable="false" titleKey="GSP/GMP证书到期" class="print_flag"/>
						<display:column property="busLiceAnnualSurvey" escapeXml="true" sortable="false" titleKey="企业年度信息报告到期时间" class="print_flag"/>
						
						<display:column property="organizationCodeDate" escapeXml="true" sortable="false" titleKey="组织机构代码到期时间" class="print_flag"/>
						<display:column property="organizationCodeInspectionDate" escapeXml="true" sortable="false" titleKey="组织机构代码年检日" class="print_flag"/>
						<display:column property="qualityAssuranceDate" escapeXml="true" sortable="false" titleKey="质量保证协议到期日" class="print_flag"/>
						<display:column property="authorizationDate" escapeXml="true" sortable="false" titleKey="授权委托书到期日" class="print_flag"/>
						
						<display:column  escapeXml="true" sortable="false" titleKey="开户公司" class="print_flag">
							<c:if test="${qualifiesPurch.openCompany =='0'}"><c:out value="经营"></c:out></c:if>
							<c:if test="${qualifiesPurch.openCompany =='1'}"><c:out value="新品"></c:out></c:if>
							<c:if test="${qualifiesPurch.openCompany =='2'}"><c:out value="市场"></c:out></c:if>
						</display:column>
						<display:column titleKey="操作" autolink="true" media="html"  class="print_flag">
		               	 <img src="../images/look.gif"/><a href="hgghdwxgjl.html?id=${qualifiesPurch.id}">查看修改记录</a>
						 <img src="../images/edit.gif"/><a href="view_hgghdw.html?id=${qualifiesPurch.id}">修改</a>
						</display:column>
 					</c:when>
 					<c:when test="${qualifiesPurch.useFlag=='2'}">
 						<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html" class="print_flag"><input type="checkbox" name="delete_id" value="${qualifiesPurch.id}" ></display:column>
		 				<display:column property="customerNumber" escapeXml="true" sortable="false" titleKey="编号" class="print_flag_blue"/>
						<display:column property="customerName" escapeXml="true" sortable="false" titleKey="客户名称"  class="print_flag_blue"/>
						<display:column property="busLiceExpiraDate" escapeXml="true" sortable="false" titleKey="营业执照到期时间" class="print_flag_blue"/>
						<display:column property="liceExpirationDate" escapeXml="true" sortable="false" titleKey="经营/生产许可证到期时间" class="print_flag_blue"/>
						<display:column property="gpsExpirationDate" escapeXml="true" sortable="false" titleKey="GSP/GMP证书到期" class="print_flag_blue"/>
						<display:column property="busLiceAnnualSurvey" escapeXml="true" sortable="false" titleKey="企业年度信息报告到期时间" class="print_flag_blue"/>
						<display:column property="organizationCodeDate" escapeXml="true" sortable="false" titleKey="组织机构代码到期时间" class="print_flag_blue"/>
						<display:column property="organizationCodeInspectionDate" escapeXml="true" sortable="false" titleKey="组织机构代码年检日" class="print_flag_blue"/>
						<display:column property="qualityAssuranceDate" escapeXml="true" sortable="false" titleKey="质量保证协议到期日" class="print_flag_blue"/>
						<display:column property="authorizationDate" escapeXml="true" sortable="false" titleKey="授权委托书到期日" class="print_flag_blue"/>
						
						<display:column  escapeXml="true" sortable="false" titleKey="开户公司" class="print_flag_blue">
							<c:if test="${qualifiesPurch.openCompany =='0'}"><c:out value="经营"></c:out></c:if>
							<c:if test="${qualifiesPurch.openCompany =='1'}"><c:out value="新品"></c:out></c:if>
							<c:if test="${qualifiesPurch.openCompany =='2'}"><c:out value="市场"></c:out></c:if>
						</display:column>
						<display:column titleKey="操作" autolink="true" media="html"  class="print_flag_blue">
		               	 <img src="../images/look.gif"/><a href="hgghdwxgjl.html?id=${qualifiesPurch.id}">查看修改记录</a>
						 <img src="../images/edit.gif"/><a href="view_hgghdw.html?id=${qualifiesPurch.id}">修改</a>
						</display:column>
 					</c:when>
 					<c:when test="${qualifiesPurch.useFlag=='0'}">
 						<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html" class="noPrint_flag"><input type="checkbox" name="delete_id" value="${qualifiesPurch.id}" ></display:column>
		 				<display:column property="customerNumber" escapeXml="true" sortable="false" titleKey="编号" class="noPrint_flag"/>
						<display:column property="customerName" escapeXml="true" sortable="false" titleKey="客户名称"  class="noPrint_flag"/>
						<display:column property="busLiceExpiraDate" escapeXml="true" sortable="false" titleKey="营业执照到期时间" class="noPrint_flag"/>
						<display:column property="liceExpirationDate" escapeXml="true" sortable="false" titleKey="经营/生产许可证到期时间" class="noPrint_flag"/>
						<display:column property="gpsExpirationDate" escapeXml="true" sortable="false" titleKey="GSP/GMP证书到期" class="noPrint_flag"/>
						<display:column property="busLiceAnnualSurvey" escapeXml="true" sortable="false" titleKey="企业年度信息报告到期时间" class="noPrint_flag"/>
						<display:column property="organizationCodeDate" escapeXml="true" sortable="false" titleKey="组织机构代码到期时间" class="noPrint_flag"/>
						<display:column property="organizationCodeInspectionDate" escapeXml="true" sortable="false" titleKey="组织机构代码年检日" class="noPrint_flag"/>
						<display:column property="qualityAssuranceDate" escapeXml="true" sortable="false" titleKey="质量保证协议到期日" class="noPrint_flag"/>
						<display:column property="authorizationDate" escapeXml="true" sortable="false" titleKey="授权委托书到期日" class="noPrint_flag"/>
						
						<display:column  escapeXml="true" sortable="false" titleKey="开户公司" class="noPrint_flag">
							<c:if test="${qualifiesPurch.openCompany =='0'}"><c:out value="经营"></c:out></c:if>
							<c:if test="${qualifiesPurch.openCompany =='1'}"><c:out value="新品"></c:out></c:if>
							<c:if test="${qualifiesPurch.openCompany =='2'}"><c:out value="市场"></c:out></c:if>
						</display:column>
						<display:column titleKey="操作" autolink="true" media="html" class="noPrint_flag">
		               	 <img src="../images/look.gif"/><a href="hgghdwxgjl.html?id=${qualifiesPurch.id}">查看修改记录</a>
						 <img src="../images/edit.gif"/><a href="view_hgghdw.html?id=${qualifiesPurch.id}">修改</a>
						</display:column>
 					</c:when>
 					<c:otherwise>
 					 						<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html" class="print_flag_red"><input type="checkbox" name="delete_id" value="${qualifiesPurch.id}" ></display:column>
		 				<display:column property="customerNumber" escapeXml="true" sortable="false" titleKey="编号" class="print_flag_red"/>
						<display:column property="customerName" escapeXml="true" sortable="false" titleKey="客户名称"  class="print_flag_red"/>
						<display:column property="busLiceExpiraDate" escapeXml="true" sortable="false" titleKey="营业执照到期时间" class="print_flag_red"/>
						<display:column property="liceExpirationDate" escapeXml="true" sortable="false" titleKey="经营/生产许可证到期时间" class="print_flag_red"/>
						<display:column property="gpsExpirationDate" escapeXml="true" sortable="false" titleKey="GSP/GMP证书到期" class="print_flag_red"/>
						<display:column property="busLiceAnnualSurvey" escapeXml="true" sortable="false" titleKey="企业年度信息报告到期时间" class="print_flag_red"/>
						<display:column property="organizationCodeDate" escapeXml="true" sortable="false" titleKey="组织机构代码到期时间" class="print_flag_red"/>
						<display:column property="organizationCodeInspectionDate" escapeXml="true" sortable="false" titleKey="组织机构代码年检日" class="print_flag_red"/>
						<display:column property="qualityAssuranceDate" escapeXml="true" sortable="false" titleKey="质量保证协议到期日" class="print_flag_red"/>
						<display:column property="powerOfAttorneyDate" escapeXml="true" sortable="false" titleKey="授权委托书到期日" class="print_flag_red"/>
						
						<display:column  escapeXml="true" sortable="false" titleKey="开户公司" class="print_flag_red">
							<c:if test="${qualifiesPurch.openCompany =='0'}"><c:out value="经营"></c:out></c:if>
							<c:if test="${qualifiesPurch.openCompany =='1'}"><c:out value="新品"></c:out></c:if>
							<c:if test="${qualifiesPurch.openCompany =='2'}"><c:out value="市场"></c:out></c:if>
						</display:column>
						<display:column titleKey="操作" autolink="true" media="html" class="print_flag_red">
		               	 <img src="../images/look.gif"/><a href="hgghdwxgjl.html?id=${qualifiesPurch.id}">查看修改记录</a>
						 <img src="../images/edit.gif"/><a href="view_hgghdw.html?id=${qualifiesPurch.id}">修改</a>
						</display:column>
 					</c:otherwise>
 				</c:choose>
 				
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>
			<script type="text/javascript">
			
			function setCookie(c_name,value,expiredays)
			{
			var exdate=new Date()
			exdate.setTime(exdate.getTime()+expiredays)
			document.cookie=c_name+ "=" +escape(value)+
			((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
			}	
			function getCookie(name)
			{
			    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
			 
			    if(arr=document.cookie.match(reg))
			 
			        return (arr[2]);
			    else
			        return null;
			}
		//	var value =getCookie("sign"); 
			$(function(){
				var value =getCookie("sign"); 
				console.log(getCookie("sign"));
				if(value!=1){
				 setCookie("sign",value+"0",1200000);
				}
			console.log(getCookie("sign"));
			value =getCookie("sign"); 
			console.log(value=="null0");
				if(value=="null0"){
					alert("数据更新中,请勿操作···");
			console.log("执行");
			$.post("ajaxQueryWarnPurchase.html",function(data){
				var json = jsonParse(data);
				var str = json.success;	
				alert("数据已更新");
				$("#warnMessage").empty();
				$("#warnMessage").append(str);
				})

					 setCookie("sign",value+"1",1200000);
			console.log(getCookie("sign"))
				}



		})
		</script>
</body>
</html>