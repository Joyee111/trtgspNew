<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看已驳回出库复核</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
<link href="<%=basePath%>js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/easyui/jquery-1.8.0.min.js" ></script>
<script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript"
	src="/zywx3/ext/scripts/user/selectarea.js">
</script>
<script type="text/javascript">
	function pass(){
		$("#types").val(2);
		var form = document.getElementById("check_one");
		form.submit();
	}
	function bhback(){
		var form = document.getElementById("check_one");
		form.submit();
	}
</script>
</head>
<body>
<form action="dshview.html">
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;出库复核管理&nbsp;>&nbsp;查看已驳回出库复核</font>
		<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span >1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span>2</span>
                <br />已保存
            </td>
            <td valign="top" align="center" width="20%">
            	<span>3</span>
                <br />审核
            </td>
            <td valign="top" align="center" width="20%">
            	<span class="ok">4</span>
                <br />已驳回
            </td>
            <td valign="top" align="center" width="20%">
            	<span>5</span>
                <br />审核通过
            </td>
            <td align="right" width="5"><img src="../../images/lch_r.gif" /></td>
          </tr>
        </table>
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
		<tr>
		<th width="150">购货单位：</th>
		<td class="left" style="width:350px;">
		<input type="text" id="qualifiedPurchaseUnitsId" readonly="readonly" name="qualifiedPurchaseUnitsId" value="${qu.customerName}" class="text1" size="40"/>
		</td>
		<th width="150">票号<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="salesNumber" readonly="readonly" id="salesNumber" value="${mc.salesNumber}" data-options="required:true" class="easyui-validatebox text1" size="40"/>
		</td>
	</tr>
	<tr>
		<th width="150">质量状况：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="qualitySituation" readonly="readonly" id="qualitySituation" class="text1" value="${mc.qualitySituation}" size="40"/>
		</td>
		<th width="150">销售日期<span class="required">*</span>：</th>
	<td>
		<input type="text" disabled="disabled" readonly="readonly" data-options="required:true,validType:'checkDate'" value="${mc.saleTime}" class="easyui-datebox" name="saleTime"  id="saleTime" size="40"/>
	</td>
	</tr>
	<tr>
	<th valign="top">备注</th>
	 <td colspan="3">
		<textarea type="" name="remark" id="remark" readonly="readonly"  cols="94" rows="4" class="textarea" >${mc.remark}</textarea>
	</td>
	</tr>
</table>
	
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="thispage" value="${thispage}"/>
		<input type="hidden" name="id" value="${mc.id}"/>
		<div class="ceng_mar5">
			<display:table name="chIt" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" class="table" id="chItem" pagesize="${pageSize}" export="true" size="${resultSize}" partialList="true">
			<display:column property="qualityMidicine.commonname" escapeXml="true" sortable="true" titleKey="通用名称"/>
			<display:column property="batchNo"  escapeXml="true" sortable="true" titleKey="生产批号" ></display:column>
			<display:column property="quantity"  escapeXml="true" sortable="true" titleKey="数量" ></display:column>
			<display:column property="qualityMidicine.produceno.customerName" escapeXml="true" sortable="true" titleKey="生产厂商 "/>
			<display:column property="qualityMidicine.dosageforms.formName"  escapeXml="true" sortable="true" titleKey="剂型"></display:column>
			<display:column property="specifications"  escapeXml="true" sortable="true" titleKey="规格" ></display:column>
			<display:column property="licenseNumber"  escapeXml="true" sortable="true" titleKey="批准文号"></display:column>
		</display:table>
		</div>
	</form>
  	<br>
  	<table>
		<tr align="center">
			<td><input type="button" class="btn_big" value="驳回确认" onclick="bhback()"/></td>
		 	<td><input type="button" class="btn_big" value="返回" onclick="goBack()"/></td>
		</tr>
	</table>
 	<form action="bhback.html" id="check_one">
 		<input type="hidden" id="id" name="id" value="${mc.id}"/>
 		<input type="hidden" id="types" name="types" value=""/>
 	</form>
</body>
</html>