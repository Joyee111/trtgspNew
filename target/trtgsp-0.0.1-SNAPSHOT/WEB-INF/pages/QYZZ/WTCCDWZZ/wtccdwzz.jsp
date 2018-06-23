<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>委托储存单位资质</title>
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
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;委托储存单位资质</font>
   <div class="caozuo_box">
    <form name="query_wtccdwzz" id="query_enterprise" action="querywtccdwzz.html" method="post"  >
        	编号 <input name="query_khbh" id="query_khbh" type="text" class="text1" size="20"/>
            &nbsp;&nbsp;&nbsp;&nbsp;委托储存单位 <input name="query_kfmc"  id="query_kfmc" type="text" class="text1" size="20"/>
            <input name="" type="submit" class="btn_big" value="搜索"/>
    </form>
        </div>
       
 			
        <div class="zhushi_box">
        	<img src="../images/zhushi.gif"/>
            <span><marquee width=95% onmouseover="this.stop()" onmouseout="this.start()"  scrollamount="5" id="warnMessage"></marquee></span>
        </div>
 			<display:table name="csuqList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="csuq" pagesize="${pagesize}" class="table_print" export="true" size="${resultSize}" partialList="true">
 				<c:choose>
 					<c:when test="${csuq.useFlag=='1'}">
		 				<display:column property="companyNumber" escapeXml="true" sortable="false" titleKey="编号" class="print_flag"/>
						<display:column property="companyName" escapeXml="true" sortable="false" titleKey="委托储存单位"  class="print_flag"/>
						<display:column property="business_licence_date" escapeXml="true" sortable="false" titleKey="营业执照到期时间" class="print_flag"/>
						<display:column property="licence_date" escapeXml="true" sortable="false" titleKey="经营/生产许可证到期时间" class="print_flag"/>
						<display:column property="gsp_certificate_date" escapeXml="true" sortable="false" titleKey="GSP/GMP证书到期" class="print_flag"/>
						
						<display:column property="third_logistics_drug_confirmation_date" escapeXml="true" sortable="false" titleKey="第三方药品物流业务确认书到期时间" class="print_flag"/>
						
						<display:column titleKey="操作" autolink="true" media="html"  class="print_flag">
		               	 <img src="../images/look.gif"/><a href="query_wtccdwzzjl.html?id=${csuq.id}">查看修改记录</a>
						 <img src="../images/edit.gif"/><a href="view_wtccdwzz.html?id=${csuq.id}">修改</a>
						</display:column>
 					</c:when>
 					<c:otherwise>
		 				<display:column property="companyNumber" escapeXml="true" sortable="false" titleKey="编号" class="noPrint_flag"/>
						<display:column property="companyName" escapeXml="true" sortable="false" titleKey="委托储存单位"  class="noPrint_flag"/>
						<display:column property="business_licence_date" escapeXml="true" sortable="false" titleKey="营业执照到期时间" class="noPrint_flag"/>
						<display:column property="licence_date" escapeXml="true" sortable="false" titleKey="经营/生产许可证到期时间" class="noPrint_flag"/>
						<display:column property="gsp_certificate_date" escapeXml="true" sortable="false" titleKey="GSP/GMP证书到期" class="noPrint_flag"/>
						
						<display:column property="third_logistics_drug_confirmation_date" escapeXml="true" sortable="false" titleKey="第三方药品物流业务确认书到期时间" class="noPrint_flag"/>
						
						<display:column titleKey="操作" autolink="true" media="html" class="noPrint_flag">
		               	 <img src="../images/look.gif"/><a href="query_wtccdwzzjl.html?id=${csuq.id}">查看修改记录</a>
						 <img src="../images/edit.gif"/><a href="view_wtccdwzz.html?id=${csuq.id}">修改</a>
						</display:column>
 					</c:otherwise>	
 				</c:choose>
 				
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>
			<div class="caozuo_box2">
            <shiro:hasPermission name="CommissionedStorageUnitQualification_add">
            <input name="" type="button" class="btn_big" value="新增" onclick="addCommissionedStorageUnitQualification()"/>
           </shiro:hasPermission>
           <c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				 <shiro:hasPermission name="CommissionedStorageUnitQualification_delete">
            <input name="" type="button" class="btn_big" value="删除" onclick="delCommissionedStorageUnitQualification()"/>
            </shiro:hasPermission>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
         	
            </div>
			<script type="text/javascript">
			$(function(){
			$.post("ajaxQueryWarnCommissionedStorageUnitQualification.html",function(data){
				var json = jsonParse(data);
				var str = json.success;	
				//alert(str);
				$("#warnMessage").empty();
				$("#warnMessage").append(str);
			})
		})
		
		
	function addCommissionedStorageUnitQualification(){
		window.location.href="addCommissionedStorageUnitQualification.html";
	}
	function delCommissionedStorageUnitQualification(){
		//var from =document.getElementById("del_syqydlr");
		var r=confirm("是否确认删除！")
		if(r){
			$("#del_xsry").form("submit",{
				 success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI(json.success));
				}
				location.href="salesStaff.html?type=0";
			    }  
			});
		}else{
			return;
		}
	}
	
		</script>
</body>
</html>