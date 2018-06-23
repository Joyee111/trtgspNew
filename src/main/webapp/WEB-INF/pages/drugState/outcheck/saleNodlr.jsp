<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head></head>
<title>出库复核录入
</title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/style/home.css'/>" />
<script type="text/javascript" src="${ctx}/js/easyui/jquery-1.8.0.min.js" ></script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/ext/styles/display/display.css'/>" />
     <link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/themes/default/easyui.css"> 
     <script type="text/javascript" src="${ctx}/ext/scripts/display/displaypage.js"></script>
     <script type="text/javascript">
     	function addTodsh(){
     		var from =document.getElementById("saleNodlr");
     		if(!isCheckboxSelect("salesItemNum")){
     			alert("请选择批量录入数据！");
     			return;
     		}
			var r=confirm("是否批量录入！");
			if(r){
				from.action="${ctx}/drugState/outcheck/saleNoadd.html";
				from.submit();
			}else{
				return;
			}
     		window.returnValue=1;
    		close();
     	}
     var checkflag = "false";
/**
 *checkbox 全选 和 取消
 * @param fieldName name名称
 * @return
 */
function checkAll(fieldName) {
//	alert(field);
//	var field=document.getElementsByName("delete_id");
	var field=document.getElementsByName(fieldName);
//	alert(field);
	if (checkflag == "false") {
	for (i = 0; i < field.length; i++) {
	field[i].checked = true;}
	checkflag = "true";
	return "Uncheck All"; }
	else {
	for (i = 0; i < field.length; i++) {
	field[i].checked = false; }
	checkflag = "false";
	return "Check All"; }
}
     	
		function isCheckboxSelect(checkboxName){
			var checkboxs = document.getElementsByName(checkboxName);
			for(var i=0,length = checkboxs.length;i<length;i++){
				if(checkboxs[i].checked)
						return true;
			}
			return false;
		}
		jQuery(function(){
		jQuery("#displayallpage").val(${displayallpage});
		jQuery("#tz").val(${thispage});
		});
     </script>
<base target="_self">
<div class="tab_con">
	<div class="caozuo_box">
		<form action="${ctx}/drugState/outcheck/saleNodlr.html" >
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
					销售单号：<input name="saleNumber" type="text" class="text1" value="${saleNumber}" >
					合同号：<input type="text" name="contractNumber" class="text1" value="${contractNumber}"/>
			<input class="btn_big" type="submit" value="查询"  /> 
		</form>
	</div>

 <form id="saleNodlr" action="" method="post">
       	<display:table name="fromInfoVOList" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" size="${resultSize}" partialList="true">
			<display:column title="<input type='checkbox' id='checkall' name='checkall'  onclick='checkAll(\"salesItemNum\")' />全选"><input type="checkbox" name="salesItemNum" value="${records.salesItemNumber}" ></display:column>
			<display:column property="contractNo" escapeXml="true" sortable="true" titleKey="合同号"/>
			<display:column property="salesItemNumber" escapeXml="true" sortable="true" titleKey="票号"/>
			<display:column property="commonName" escapeXml="true" sortable="true" titleKey="通用名称"/>
			<display:column property="salesDate" escapeXml="true" sortable="true" titleKey="销售日期"/>
		</display:table>
	</form>
	<table>
		<tr align="center">
			<td colspan="2">
	         	<input  type="button" class="btn_big" onclick="addTodsh()" value="确定"/>
	         	<input type="button" class="btn_big" onclick="window.close();" value="取消"/>
	       	</td>
	   	</tr>
	</table>
</div>	
