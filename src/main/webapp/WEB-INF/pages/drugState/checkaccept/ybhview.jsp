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
<title>查看已驳回验收</title>
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
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;验收管理&nbsp;>&nbsp;查看已驳回验收</font>
<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span>1</span>
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
            	<span  >4</span>
                <br />待确认
            </td>
            <td valign="top" align="center" width="20%">
            	<span class="ok">5</span>
                <br />已确认
            </td>
            <td align="right" width="5"><img src="../../images/lch_r.gif" /></td>
          </tr>
        </table>
<body>
<form action="dshview.html">
		
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
		<tr>
		<th width="150">供货单位：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="text1" readonly="readonly" data-options="disabled:true" name="arrivalDate" id="arrivalDate" value="${qs.customerName}" class="text1" size="40"/>
		</td>
		<th width="150">单据号：</th>
		<td class="left" style="width:350px;">
			<input type="text1" class="easyui-datebox" readonly="readonly" data-options="disabled:true" name="arrivalDate" id="arrivalDate" value="${mc.number}" class="text1" size="40"/>
		</td>
		</tr>

		<tr>
		<th width="150">到货日期：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-datebox" readonly="readonly" data-options="disabled:true" name="arrivalDate" id="arrivalDate" value="${mc.arrivalDate}" class="text1" size="40"/>
		</td>
		<th width="150">收货员：</th>
	    <td class="left" style="width:350px;">
		    <input type="text" name="goodsClerk" readonly="readonly"  id="goodsClerk" value="${mc.goodsClerk}" class="text1" size="40"/>
	    </td>
		
	</tr>
	<tr>
	<th>存储条件<span class="required">*</span></th>
		<td>
		<c:if test="${chIt!=null}">
			<input type="text" class="text1" size="40" value="${chIt[0].qualityMidicine.medicinalAttribute}" readonly="readonly"/>
		</c:if>
		<c:if test="${chIt==null}">
				<input type="text" class="text1" size="40" value=""/>
			</c:if>
		</td>
	<th>存储库区<span class="required">*</span></th>
		<td>
		<c:if test="${chIt!=null}">
			<input type="text" class="text1" size="40" value="${chIt[0].qualityMidicine.storageStore}" readonly="readonly"/>
		</c:if>
		<c:if test="${chIt==null}">
				<input type="text" class="text1" size="40" value=""/>
		</c:if>
		</td>
	</tr>
	<tr>
	    <th width="150">验收日期：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-datebox" readonly="readonly" data-options="disabled:true" name="checkAcceptDate" id="checkAcceptDate" value="${mc.checkAcceptDate}" class="text1" size="40"/>
		</td>
		<th>验收状态<span class="required">*</span>:</th>
		<td>
		<select name="checkIsQualified" class="text" id="checkIsQualified" disabled='true'>
			<option value="0">合格</option>
			<option value="1">不合格</option>
		</select>
		</td>
	</tr>
	<tr>
	<th width="150">处理结果：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="result" id="result" readonly="readonly" value="${mc.result}" class="text1" size="40"/>
	</td>
	</tr>
	
	<tr>
	<th valign="top">检查结论：</th>
	 <td colspan="3">
		<textarea type="" name="checkConclusion" readonly="readonly" id="checkConclusion" cols="94" rows="4" class="textarea" >${mc.checkConclusion}</textarea>
	</td>
	</tr>
	<tr>
	    <th width="150">验收日期2：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-datebox" readonly="readonly" data-options="disabled:true" name="checkAcceptDate2" id="checkAcceptDate2" value="${mc.checkAcceptDate2}" class="text1" size="40"/>
		</td>
		<th>验收状态2<span class="required">*</span>:</th>
		<td>
		<select name="checkIsQualified2" class="text" id="checkIsQualified2" disabled='true'>
			<option value="0">合格</option>
			<option value="1">不合格</option>
		</select>
		</td>
	</tr>
	<tr>
	<th width="150">处理结果2：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="result2" id="result2" readonly="readonly" value="${mc.result2}" class="text1" size="40"/>
	</td>
	</tr>
	
	<tr>
	<th valign="top">检查结论2：</th>
	 <td colspan="3">
		<textarea type="" name="checkConclusion2" readonly="readonly" id="checkConclusion2" cols="94" rows="4" class="textarea" >${mc.checkConclusion2}</textarea>
	</td>
	</tr>
</table>
	<table id="condition_table" class="table_yh"  border="0" cellpadding="0" cellspacing="1" width="100%" align="center">
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
	
</table>
	
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="thispage" value="${thispage}"/>
		<input type="hidden" name="id" value="${mc.id}"/>
	</form>
  	<br>
  	<table>
		<tr align="center">
		 	<td><input type="button" class="btn_big" value="返回" onclick="goBack()"/></td>
		</tr>
	</table>
 	<form action="bhback.html" id="check_one">
 		<input type="hidden" id="id" name="id" value="${ch.id}"/>
 		<input type="hidden" id="types" name="types" value=""/>
 	</form>
 	<script type="text/javascript">
 		setDefaultForCheckbox("checkIsQualified","${mc.checkIsQualified}");
 		setDefaultForCheckbox("checkIsQualified2","${mc.checkIsQualified2}");
 	</script>
</body>
</html>