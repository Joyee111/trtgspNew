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
	<title>合格品种</title>
</head>
<body>
		<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">品种管理&nbsp;>&nbsp;合格品种</font>
        	<div class="caozuo_box">
        	<form name="query_qualifiedMedic" id="query_qualifiedMedic" action="queryQulidiedMedicinal.html" method="post">
               	 通用名称：<input name="query_commonname" id="query_commonname" type="text" class="text1" size="20"/>
                &nbsp;&nbsp;&nbsp;&nbsp;剂型： <input name="query_forms" id="query_forms" type="text" class="text1" size="20"/>
                货号 ：<input name="query_number" id="query_number" type="text" class="text1" size="20"/>
                 <input type="hidden" name="type" type="button" value="waitAudit" >
                <input name="" type="submit" class="btn_big" value="查询"/><input name="" type="button" class="btn_big" value="新增合格药品" onclick="addQualiryMedicinal()"/>
           </form>
            </div>
          <div class="zhushi_box">
        	<img src="../images/zhushi.gif"/>
            <span><marquee width=95% onmouseover="this.stop()" onmouseout="this.start()"  scrollamount="5" id="warnMessage"></marquee></span>
        </div>
            <form  id="del_sypzdsh" method="post" >
 			<display:table name="qualityMidicinesList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="qualifiedMedic" pagesize="${pagesize}" class="table_print" export="true" size="${resultSize}" partialList="true">
				<display:column
					title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选"
					media="html" class="${qualifiedMedic.useflag == '0' ? 'noPrint_flag' : 'print_flag'}">
					<input type="checkbox" name="delete_id" value="${firstVariety.id}">
				</display:column>
				<display:column property="commonname" escapeXml="true" sortable="false" titleKey="通用名称" class="${qualifiedMedic.useflag == '0' ? 'noPrint_flag' : 'print_flag'}"/>
				<display:column property="dosageforms.formName" escapeXml="true" sortable="false" titleKey="剂型" class="${qualifiedMedic.useflag == '0' ? 'noPrint_flag' : 'print_flag'}" />
				<display:column property="produceno.customerName" escapeXml="true" sortable="false" titleKey="生产企业" class="${qualifiedMedic.useflag == '0' ? 'noPrint_flag' : 'print_flag'}" />
				<display:column property="specifications" escapeXml="true" sortable="false" titleKey="规    格" class="${qualifiedMedic.useflag == '0' ? 'noPrint_flag' : 'print_flag'}" />
				<display:column property="licensenumber" escapeXml="true" sortable="false" titleKey="批准文号" class="${qualifiedMedic.useflag == '0' ? 'noPrint_flag' : 'print_flag'}" />
				<display:column property="validdate" escapeXml="true" sortable="false" titleKey="有 效 期" class="${qualifiedMedic.useflag == '0' ? 'noPrint_flag' : 'print_flag'}" />
				<display:column titleKey="操作" autolink="true" media="html"  class="${qualifiedMedic.useflag == '0' ? 'noPrint_flag' : 'print_flag'}">
				<img src="../images/look.gif"/><a href="queryQulidiedMedicinalRecord.html?id=${qualifiedMedic.id}">查看修改记录</a>
				 <img src="../images/edit.gif"/><a href="viewQulidiedMedicinal.html?id=${qualifiedMedic.id}">修改</a>
				</display:column>
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>
			<input type="hidden" name="save_type" id="save_type">
			</form>
	<script type="text/javascript">
	$(function(){
		$.post("ajaxQueryWarnMedicinal.html",function(data){
				var json = jsonParse(data);
				var str = json.success;	
				//alert(str);
				$("#warnMessage").empty();
				$("#warnMessage").append(str);
			})
	})
	function addQualiryMedicinal(){
		window.location.href="newQulidiedMedicinal.html";
	}
    </script>
</body>
</html>