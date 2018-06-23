<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>质量档案新增</title>
</head>
<script type="text/javascript">
	
</script>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">品种管理&nbsp;>&nbsp;质量档案&nbsp;>&nbsp;质量档案新增</font>
	<form action="updateQualityFiles.html" name="add_qualityFiles" id="update_qualityFiles" method="post" >

        <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
          <tr>
            
            <th width="150">通用名称<span class="required">*</span>：</th>
            <td>
            <input type="text" class="easyui-combobox  text1" data-options="
             required:true,
      	 	valueField: 'id',
       		textField: 'text',
      		url:'../drugVarieties/ajaxQueryQualityMidince.html',
      		onSelect: function(rec){
      			$('#qualityMidicineId').val(rec.id);
      			queryQualityMidince(rec.id);
      		}
			" name="" id="commonnamebox" size="40"/>&nbsp;&nbsp;
            </td>
            <th width="150">剂型：</th>
            <td><input name="dosageforms" id="dosageforms" value="${qualityFiles.qualityMidicine.dosageforms.formName }" type="text" class="text1" readonly="readonly" size="40"/></td>
          </tr>
          <tr>
          	<th>商品名称</th>
          	<td>
          		<input type="text" name="tradename" id="tradename" value="${qualityFiles.qualityMidicine.tradename }" class="text1" size="40">
          	</td>
            <th>规格：</th>
			<td ><input name="specifications" id="specifications"  value="${qualityFiles.qualityMidicine.specifications }"  type="text" class="text1" readonly="readonly" size="40"/></td>
		</tr>
		<tr>
			<th>有效期：</th>
			<td ><input name="validdate" id="validdate" type="text" value="${qualityFiles.qualityMidicine.validdate }"  class="text1" readonly="readonly" size="40"/></td>    
			<th>生产厂商：</th>
			<td ><input name="qualifiedSuppliers" id="qualifiedSuppliers"  value="${qualityFiles.qualityMidicine.produceno.customerName}"  type="text" class="text1" readonly="readonly" size="40"/></td>    
		</tr>
		<tr>
			<th>厂商证照审核情况<span class="required">*</span>:</th>
			<td ><input name="vendorLicensesStatus" id="vendorLicensesStatus"  value="${qualityFiles.vendorLicensesStatus}" type="text" class="easyui-validate text1" data-options="required:true" size="40"/></td> 
			<th>注册商标名称<span class="required">*</span>:</th>
			<td ><input name="registeredTrademarkName" id="registeredTrademarkName"  value="${qualityFiles.registeredTrademarkName}" type="text" class="easyui-validate text1" data-options="required:true"  size="40"/></td> 
		</tr>
		<tr>
			<th>批准文件<span class="required">*</span>:</th>
			<td ><input name="approvalDocumentName" id="approvalDocumentName" value="${qualityFiles.approvalDocumentName}" type="text" class="easyui-validate text1" data-options="required:true" size="40"/></td> 
			<th>质量标准名称<span class="required">*</span>:</th>
			<td ><input name="qualityStandardsName" id="qualityStandardsName" value="${qualityFiles.qualityStandardsName}" type="text" class="easyui-validate text1" data-options="required:true"  size="40"/></td> 
		</tr>
		<tr>
			<th>检验报告书审核情况<span class="required">*</span>:</th>
			<td ><input name="inspectionYeportStatus" id="inspectionYeportStatus"  value="${qualityFiles.inspectionYeportStatus}" type="text" class="easyui-validate text1" data-options="required:true" size="40"/></td> 
			<th> 包装审核情况<span class="required">*</span>:</th>
			<td ><input name="packageStatus" id="packageStatus" value="${qualityFiles.packageStatus}" type="text" class="easyui-validate text1" data-options="required:true"  size="40"/></td> 
		</tr>
		<tr>
			<th>标签、说明书审核情况<span class="required">*</span>:</th>
			<td ><input name="brochuresStatus" id="brochuresStatus" value="${qualityFiles.brochuresStatus}" type="text" class="easyui-validate text1" data-options="required:true" size="40"/></td> 
		</tr>
		<tr>
		</tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
            	<input name="createDate" type="hidden" value="${qualityFiles.createDate}">
            	<input type="hidden" name="id" value="${qualityFiles.id }">
            	<input name="qualityMidicineId" type="hidden" id="qualityMidicineId" value="${qualityFiles.qualityMidicine.id}">
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	<script type="text/javascript">
	$(function(){
		$("#commonnamebox").combobox("setValue","("+"${qualityFiles.qualityMidicine.medicinalNo}"+")"+"${qualityFiles.qualityMidicine.commonname}");
		
	})
		
	</script>
</body>
</html>