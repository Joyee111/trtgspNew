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
<title>查看审核出库复核</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
<link href="<%=basePath%>js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/easyui/jquery-1.8.0.min.js" ></script>
<script type="text/javascript">
	function pass(){
		$("#types").val(2);
		var value = $("#qualitySituation").val(),remark = $("#remark").val();
		//alert(remark);
		if(typeof(value) != 'undefined' && value!=''){
			$("#quality_Situation").val(value);
		}
		if(typeof(remark) != 'undefined' && remark!=''){
			$("#remak_content").val(remark);
		}
		//alert($("#remak_content").val());
		var form = document.getElementById("check_one");
		if(checkSubmit){
			form.submit();
		}
		
	}
	function back(){
		$("#types").val(3);
		var form = document.getElementById("check_one");
		form.submit();
	}
	
</script>
</head>
		   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;出库复核管理&nbsp;>&nbsp;查看审核出库复核</font>
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
            	<span class="ok">3</span>
                <br />审核
            </td>
            <td valign="top" align="center" width="20%">
            	<span>4</span>
                <br />已驳回
            </td>
            <td valign="top" align="center" width="20%">
            	<span>5</span>
                <br />审核通过
            </td>
            <td align="right" width="5"><img src="../../images/lch_r.gif" /></td>
          </tr>
        </table>
<body>
	<form action="dshview.html">
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
	<th width="150">销售日期<span class="required">*</span>：</th>
	<td>
		<input type="text" disabled="disabled" readonly="readonly" data-options="required:true,validType:'checkDate'" value="${mc.saleTime}" class="easyui-datebox" name="saleTime"  id="saleTime" size="40"/>
	</td>
		
	<th>合同号<span class="required">*</span>:</th>
	<td><input name="salesFromNumber" id="salesFromNumber" value="${mc.salesFromNumber}" readonly="readonly" type="text" class="text1" size="40"/></td>
	</tr>
	<tr>
		<th width="150">质量状况<span class="required">*</span>：</th>
		<td>
		<select name="qualitySituation" id="qualitySituation" class="easyui-validatebox text1" data-options="required:true" >
		<option value="1" >合格</option>
		<option value="2" >不合格</option>
		<!-- <option value="2" >待定</option> -->
		</select>
		</td>
	</tr>
	<tr>
	<th valign="top">备注：</th>
	 <td colspan="3">
		<textarea type="" name="remark" id="remark"  cols="94" rows="4" class="textarea" >${mc.remark}</textarea>
	</td>
	</tr>
</table>
 <%--  <table id="condition_table" class="table_yh"  border="0" cellpadding="0" cellspacing="1" width="100%" align="center">
	<thead class='pn-lthead'>
	 <tr>
	 	<th style="width: 80px;">通用名称</th><th>剂型</th><th>规格</th> <th>数量</th><th>合格数量</th><th>不合格数量</th><th>生产批号</th><th>批准文号</th><th>生产企业</th><th>生产日期</th><th>有效期至</th><th>不合格项</th><th>处理措施</th>
	  </tr>
	  </thead>
	  <c:forEach items="${chIt}" var="item" varStatus="index">
	  	<tbody class="pn-ltbody">
	  		<tr>
	  			<td ><input type="text" name="pingming${index.index }" value="${item.qualityMidicine.commonname }" readonly="readonly" class="text1" size="10" style="border: none;"/></td>
	  			<td ><input type="text" name="jixing${index.index }" value="${item.qualityMidicine.dosageforms.formName }" readonly="readonly" class="text1"  size="10" style="border: none;"/></td>
	  			<td ><input type="text" name="jixing${index.index }" value="${item.qualityMidicine.specifications }" readonly="readonly" class="text1"  size="10" style="border: none;"/></td>
	  			<td ><input type="text" name="shuliang${index.index }" id="shuliang${index.index }" value="${item.quantity}" class="text1"  size="8" style="border: none;" readonly="readonly"/></td>
	  			<td ><input type="text" name="hegeshuliang${index.index }" id="hegeshuliang${index.index }" value="${item.qualifiedQuantity}"  class="text1"  size="8" style="border: none;" readonly="readonly"/></td>
	  			<td ><input type="text" name="buhegeshuliang${index.index }" id ="buhegeshuliang${index.index }" value="${item.unqualifiedAmount}" class="text1"  size="8" style="border: none;" readonly="readonly"/></td>
	  			<td ><input type="text" name="pihao${index.index }" value="${item.batchProduction}" class="text1"  size="10" style="border: none;" readonly="readonly"/></td>
	  			<td ><input type="text" name="pizhunwenhao${index.index }" value="${item.qualityMidicine.licensenumber}" readonly="readonly" class="text1"  size="10" style="border: none;"/></td>
	  			<td ><input type="text" name="shengchanqiye${index.index }" value="${item.qualityMidicine.produceno.customerName}" readonly="readonly" class="text1"  size="20" style="border: none;"/></td>
	  			<td ><input type="text" name="shengchanriqi${index.index }" value="${item.produceTime}" readonly="readonly" class="text1"  size="10" style="border: none;"/></td>
	  			<td >
	  			<input type="text" name="youxiaoqizhi${index.index }" value="${item.endTime}" readonly="readonly" class="text1"  size="10" style="border: none;"/>
	  			<input type="hidden" name="medicId${index.index }" value="${item.qualityMidicine.id}" />
	  			</td>
	  			<td>
	  			<input type="text" name="buhegexiang${index.index }" value="${item.unqualifiedItems}" readonly="readonly" class="text1"  size="10" style="border: none;"/>
	  			</td>
	  			<td>
	  			<c:if test="${item.returnGoods eq '1'}">
	  				<input type="text" name="chulicuoshi${index.index }" value="报废" readonly="readonly" class="text1"  size="10" style="border: none;"/>
	  			</c:if>
	  			<c:if test="${item.returnGoods eq '2'}">
	  				<input type="text" name="chulicuoshi${index.index }" value="退回" readonly="readonly" class="text1"  size="10" style="border: none;"/>
	  			</c:if>
	  			</td>
	  			
	  		</tr>
	  	</tbody>
	  </c:forEach>
	
</table>--%>

		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="thispage" value="${thispage}"/>
		<input type="hidden" name="id" value="${ms.id}"/>
	<div class="ceng_mar5">
			<display:table name="chIt" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" class="table" id="chItem" pagesize="${pageSize}" export="true" size="${resultSize}" partialList="true">
			<display:column property="qualityMidicine.commonname" escapeXml="true" sortable="true" titleKey="通用名称"/>
			<display:column property="batchNo"  escapeXml="true" sortable="true" titleKey="生产批号" ></display:column>
			<display:column property="quantity"  escapeXml="true" sortable="true" titleKey="数量" ></display:column>
			<display:column property="qualityMidicine.produceno.customerName" escapeXml="true" sortable="true" titleKey="生产厂商 "/>
			<display:column property="qualityMidicine.dosageforms.formName"  escapeXml="true" sortable="true" titleKey="剂型"></display:column>
			<display:column property="qualityMidicine.specifications"  escapeXml="true" sortable="true" titleKey="规格" ></display:column>
			<display:column property="qualityMidicine.licensenumber"  escapeXml="true" sortable="true" titleKey="批准文号"></display:column>
			<display:setProperty name="export.excel" value="false"/>
			<display:setProperty name="export.csv" value="false"/>
			<display:setProperty name="export.pdf" value="false"/>
			<display:setProperty name="export.xml" value="false"/>
		</display:table>
		</div>
	</form>
  	<br>
  	<table>
		<tr align="center">
		<!-- 	<td><input type="button" class="btn_big" value="锁定" onclick=""/></td> -->
		  	<td><input type="button" class="btn_big" value="确认" onclick="pass()"/></td>
		  <!-- 	<td><input type="button" class="btn_big" value="驳回" onclick="back()"/></td> -->
		 	<td><input type="button" class="btn_big" value="返回" onclick="goBack()"/></td>
		</tr>
	</table>
 	<form action="shviewcheck.html" id="check_one">
 		<input type = "hidden" name="remak_content" id="remak_content"/>
 		<input type="hidden" name="quality_Situation" id="quality_Situation" value="0">
 		<input type="hidden" id="id" name="id" value="${mc.id}"/>
 		<input type="hidden" id="types" name="types" value=""/>
 	</form>
</body>
</html>