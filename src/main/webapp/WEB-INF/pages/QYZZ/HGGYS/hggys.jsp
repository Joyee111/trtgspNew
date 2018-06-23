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
	<title>合格供货单位</title>
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
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;合格供货单位</font>
  <div class="caozuo_box">
  	<form name="query_hggys" id="query_enterprise" action="queryhggys.html" method="post" >
        	编号 <input name="query_khbh" id="query_khbh" type="text" class="text1" size="20"/>
            &nbsp;&nbsp;&nbsp;&nbsp;客户名称 <input name="query_zjhm" id="query_zjhm" type="text" class="text1" size="20"/>
            <input name="" type="submit" class="btn_big" value="搜索"/>
 	</form>
   </div>
        <div class="zhushi_box">
        	<img src="../images/zhushi.gif"/>
           <span><marquee width=95% onmouseover="this.stop()" onmouseout="this.start()"  scrollamount="5" id="warnMessage"></marquee></span>
        </div>
 			<display:table name="qualifiesSupplyList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="qualifiesSupply" pagesize="${pagesize}" class="table" export="true" size="${resultSize}" partialList="true">
 				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html"><input type="checkbox" name="delete_id" value="${qualifiesSupply.id}" ></display:column>
 				<display:column property="customerNumber" escapeXml="true" sortable="false" titleKey="编号" />
				<display:column property="customerName" escapeXml="true" sortable="false" titleKey="客户名称" />
				<display:column property="busiLiceExpiDate" escapeXml="true" sortable="false" titleKey="营业执照到期时间"/>
				<display:column property="liceExpiDate" escapeXml="true" sortable="false" titleKey="经营/生产许可证到期时间"/>
				<display:column property="gspExpirDate" escapeXml="true" sortable="false" titleKey="GSP/GMP证书截止日期"/>
				<display:column property="organizationCodeDate" escapeXml="true" sortable="false" titleKey="组织机构代码到期时间"/>
				<display:column property="organizationCodeInspectionDate" escapeXml="true" sortable="false" titleKey="组织机构代码年检日"/>
				<display:column property="qualityAssuranceDate" escapeXml="true" sortable="false" titleKey="质量保证协议到期日"/>
				<display:column property="authorizationDate" escapeXml="true" sortable="false" titleKey="授权委托书到期日"/>
				<display:column titleKey="操作" autolink="true" media="html" class="border_rnone">
				<img src="../images/look.gif"/><a href="query_hggysxgjl.html?id=${qualifiesSupply.id}">查看修改记录</a>
				<img src="../images/edit.gif"/><a href="view_hggys.html?id=${qualifiesSupply.id}">修改</a>
				</display:column>
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>

	<script type="text/javascript">
		$(function(){
			$.post("ajaxQueryWarnSuppliers.html",function(data){
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