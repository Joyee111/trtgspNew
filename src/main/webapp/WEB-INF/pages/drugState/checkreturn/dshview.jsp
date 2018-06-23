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
<title>查看审核退货验收</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
<link href="<%=basePath%>js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/easyui/jquery-1.8.0.min.js" ></script>
<script type="text/javascript">
	function pass(){
		$("#typess").val(2);
		var form = document.getElementById("check_one");
		form.submit();
	}
	function back(){
		$("#typess").val(3);
		var form = document.getElementById("check_one");
		form.submit();
	}
</script>
</head>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;退货验收管理&nbsp;>&nbsp;查看审核退货验收</font>
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
<form action="shviewcheck.html" id="check_one">
	<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
		<tr>
		<th width="150">退货单号：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="returnNo" id="returnNo" data-options="disabled:true" readonly="readonly" value="${mc.returnNo}" class="text1" size="40"/>
		</td>
		<th width="150">退货单位：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="text1" readonly="readonly" data-options="disabled:true" name="arrivalDate" id="arrivalDate" value="${qu.customerName}" class="text1" size="40"/>
		</td>
		</tr>
		<tr>
		<th width="150">报告单号：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="reportNo" id="reportNo" data-options="disabled:true" readonly="readonly" value="${mc.reportNo}" class="text1" size="40"/>
		</td>
		<th width="150">退货日期：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-datebox" data-options="disabled:true" id="arrivalDate" value="${mc.arrivalDate}" class="text1"/>
		</td>
		</tr>
		<tr>
		<th width="150">验收日期：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-datebox" data-options="disabled:true" value="${mc.checkAcceptDate}"/>
		</td>
		<th width="150">收货员：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="goodsClerk" readonly="readonly" id="goodsClerk" value="${mc.goodsClerk}" class="text1" size="40"/>
		</td>
	</tr>
	<tr>
	<th valign="top">验收结果：</th>
	 <td colspan="3">
		<textarea type="" name="result" readonly="readonly" id="result" cols="94" rows="4" class="textarea" >${mc.result}</textarea>
	</td>
	</tr>
	<tr>
	<th valign="top">退回原因：</th>
	 <td colspan="3">
		<textarea type="" name="checkConclusion" readonly="readonly" id="checkConclusion"  cols="94" rows="4" class="textarea" >${mc.checkConclusion}</textarea>
	</td>
	</tr>
	<tr>
	<th valign="top">复查结论：</th>
	 <td colspan="3">
		<textarea type="" name="visualExamination" readonly="readonly" id="visualExamination" cols="94" rows="4" class="textarea" >${mc.visualExamination}</textarea>
	</td>
	</tr>
</table>
<table id="condition_table" class="table_yh"  border="0" cellpadding="0" cellspacing="1" width="100%" align="center">
	<thead class='pn-lthead'>
	 <tr>
	 	<th style="width: 80px;">通用名称</th><th>剂型</th><th>规格</th> <th>数量</th><th>合格数量</th><th>不合格数量</th><th>生产批号</th><th>批准文号</th><th>生产企业</th><th>有效期至</th><th>生产日期</th>
	  </tr>
	  </thead>
	  <c:forEach items="${chIt}" var="item" varStatus="index">
	  	<tbody class="pn-ltbody">
	  		<tr>
	  			<td style="width: 80px;"><input type="text" name="pingming${index.index }" value="${item.qualityMidicine.commonname }" readonly="readonly" class="text1" size="12" style="border: none;"/></td>
	  			<td style="width: 80px;"><input type="text" name="jixing${index.index }" value="${item.qualityMidicine.dosageforms.formName }" readonly="readonly" class="text1"  size="12" style="border: none;"/></td>
	  			<td style="width: 80px;"><input type="text" name="jixing${index.index }" value="${item.qualityMidicine.specifications }" readonly="readonly" class="text1"  size="12" style="border: none;"/></td>
	  			<td style="width: 80px;"><input type="text" name="shuliang${index.index }" id="shuliang${index.index }" value="${item.quantity}" class="text1"  size="8" style="border: none;" readonly="readonly"/></td>
	  			<td style="width: 80px;"><input type="text" name="hegeshuliang${index.index }" id="hegeshuliang${index.index }" value="${item.qualifiedQuantity}"  class="text1"  size="8" style="border: none;" readonly="readonly"/></td>
	  			<td style="width: 80px;"><input type="text" name="buhegeshuliang${index.index }" id ="buhegeshuliang${index.index }" value="${item.unqualifiedQuantity}" class="text1"  size="8" style="border: none;" readonly="readonly"/></td>
	  			<td style="width: 80px;"><input type="text" name="pihao${index.index }" value="${item.batchProduction}" class="text1"  size="15" style="border: none;" readonly="readonly"/></td>
	  			<td style="width: 80px;"><input type="text" name="pizhunwenhao${index.index }" value="${item.qualityMidicine.licensenumber}" readonly="readonly" class="text1"  size="15" style="border: none;"/></td>
	  			<td style="width: 80px;"><input type="text" name="shengchanqiye${index.index }" value="${item.qualityMidicine.produceno.customerName}" readonly="readonly" class="text1"  size="35" style="border: none;"/></td>
	  			<td style="width: 80px;">
	  			<input type="text" name="youxiaoqizhi${index.index }" value="${item.validateDate}" readonly="readonly" class="text1"  size="15" style="border: none;"/>
	  			<input type="hidden" name="medicId${index.index }" value="${item.qualityMidicine.id}" />
	  			</td>
	  			
	  		</tr>
	  	</tbody>
	  </c:forEach>
	
</table>
		<input type="hidden" id="id" name="id" value="${mc.id}"/>
 		<input type="hidden" id="typess" name="types" value=""/>
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="thispage" value="${thispage}"/>
	</form>
  	<br>
  	<table>
		<tr align="center">
		  	<td><input type="button" class="btn_big" value="通过" onclick="pass()"/></td>
		  	<td><input type="button" class="btn_big" value="驳回" onclick="back()"/></td>
		 	<td><input type="button" class="btn_big" value="返回" onclick="goBack()"/></td>
		</tr>
	</table>
 
</body>
</html>