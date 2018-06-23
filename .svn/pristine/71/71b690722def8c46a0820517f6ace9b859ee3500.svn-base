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
	<title>首营品种已审核</title>
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
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">品种管理&nbsp;>&nbsp;首营品种&nbsp;>&nbsp;首营品种已审核</font>
		 <div class="tab_biao">
			<shiro:hasPermission name="PurchaseUnit_recorded">
				<a href="firstVariety.html?type=input"><span><font>录入</font>
				</span> </a>
			</shiro:hasPermission>
			<shiro:hasPermission name="FirstMedicine_auditing">
				<a href="firstVariety.html?type=waitAudit" ><span><font>审核</font>
				</span> </a>
			</shiro:hasPermission>
			<shiro:hasPermission name="FirstMedicine_audited">
				<a href="firstVariety.html?type=audited" class="on"><span><font>已审核</font>
				</span> </a>
			</shiro:hasPermission>
			<shiro:hasPermission name="FirstMedicine_reject">
				<a href="firstVariety.html?type=rejected"><span><font>已驳回</font>
				</span> </a>
			</shiro:hasPermission>
		</div>

    	 <div class="tab_con">
        	<div class="caozuo_box">
        		<form name="query_syqydlr" id="query_firstVariety" action=queryfirstVariety.html method="post">
               	 通用名称 <input name="query_commonname" id="query_commonname" type="text" class="text1" size="20"/>
                &nbsp;&nbsp;&nbsp;&nbsp;剂型 <input name="query_dosageForms" id="query_dosageForms" type="text" class="text1" size="20"/>
                    <input type="hidden" name="type" type="button" value="audited" >
               <shiro:hasPermission name="FirstMedicine_audited_find">
                <input name="" type="submit" class="btn_big" value="查询"/>
                </shiro:hasPermission>
           </form>
       
            </div>
            <form name="del_sypzdlr" action="delte_syqydql.html" id="del_sypzdlr" method="post" >
 			<display:table name="firstVarietyList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="firstVariety" pagesize="${pagesize}" class="table" export="true" size="${resultSize}" partialList="true">
 				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html"><input type="checkbox" name="delete_id" value="${firstVariety.id}" ></display:column>
 				<display:column property="commonName" escapeXml="true" sortable="false" titleKey="通用名称" />
				<display:column property="dosageForms.formName" escapeXml="true" sortable="false" titleKey="剂型"/>
				<display:column property="produceNo.customerName" escapeXml="true" sortable="false" titleKey="生产企业"/>
				<display:column property="specifications" escapeXml="true" sortable="false" titleKey="规    格"/>
				<display:column property="licenseNumber" escapeXml="true" sortable="false" titleKey="批准文号"/>
				<display:column property="qualityStandardName" escapeXml="true" sortable="false" titleKey="质量标准依据"/> 
				<display:column property="validDate" escapeXml="true" sortable="false" titleKey="有 效 期"/>
				<shiro:hasPermission name="FirstMedicine_audited_look">
				<display:column titleKey="操作" autolink="true" media="html"  class="border_rnone">
				<img src="../images/look.gif"/><a href="viewAuditedFirstVariety.html?id=${firstVariety.id}">查看</a>
				</display:column>
				</shiro:hasPermission>
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>
			</form>
            </div>
	<script type="text/javascript">
	function addFirsrVariety(){
		window.location.href="addFirstVariety.html";
	}
	function delFirsrVariety(){
		var from =document.getElementById("del_sypzdlr");
		var r=confirm("是否确认删除！")
		if(r){
			from.submit();
		}else{
			return;
		}
	}
    </script>
</body>
</html>