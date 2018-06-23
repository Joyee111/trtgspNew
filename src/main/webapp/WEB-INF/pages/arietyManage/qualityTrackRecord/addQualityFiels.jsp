<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="saveQualityFiles.html" name="add_qualityFiles" id="add_qualityFiles" method="post" >

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
            <td><input name="dosageforms" id="dosageforms" type="text" class="text1" readonly="readonly" size="40"/></td>
          </tr>
          <tr>
          	<th>商品名称：</th>
          	<td>
          		<input type="text" name="tradename" id="tradename" class="text1" size="40">
          	</td>
            <th>规格：</th>
			<td ><input name="specifications" id="specifications" type="text" class="text1" readonly="readonly" size="40"/></td>
		</tr>
		<tr>
			<th>有效期：</th>
			<td ><input name="validdate" id="validdate" type="text" class="text1" readonly="readonly" size="40"/></td>    
			<th>生产厂商：</th>
			<td ><input name="qualifiedSuppliers" id="qualifiedSuppliers" type="text" class="text1" readonly="readonly" size="40"/></td>    
		</tr>
		<tr>
			<th>厂商证照审核情况<span class="required">*</span>:</th>
			<td ><input name="vendorLicensesStatus" id="vendorLicensesStatus" type="text" class="easyui-validatebox text1" data-options="required:false" size="40"/></td> 
			<th>注册商标名称<span class="required">*</span>:</th>
			<td ><input name="registeredTrademarkName" id="registeredTrademarkName" type="text" class="easyui-validatebox text1" data-options="required:false"  size="40"/></td> 
		</tr>
		<tr>
			<th>批准文件<span class="required">*</span>:</th>
			<td ><input name="approvalDocumentName" id="approvalDocumentName" type="text" class="easyui-validatebox text1" data-options="required:false" size="40"/></td> 
			<th>质量标准名称<span class="required">*</span>:</th>
			<td ><input name="qualityStandardsName" id="qualityStandardsName" type="text" class="easyui-validatebox text1" data-options="required:false"  size="40"/></td> 
		</tr>
		<tr>
			<th>检验报告书审核情况<span class="required">*</span>:</th>
			<td ><input name="inspectionYeportStatus" id="inspectionYeportStatus" type="text" class="easyui-validatebox text1" data-options="required:false" size="40"/></td> 
			<th> 包装审核情况<span class="required">*</span>:</th>
			<td ><input name="packageStatus" id="packageStatus" type="text" class="easyui-validatebox text1" data-options="required:false"  size="40"/></td> 
		</tr>
		<tr>
			<th>标签、说明书审核情况<span class="required">*</span>:</th>
			<td ><input name="brochuresStatus" id="brochuresStatus" type="text" class="easyui-validatebox text1" data-options="required:false" size="40"/></td> 
		</tr>
		<tr>
		</tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
            	<input name="qualityMidicineId" type="hidden" id="qualityMidicineId">
                <input name="" type="button" class="btn_big" value="保存" onclick="save_qualityFiles()"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	<script type="text/javascript">
		function save_qualityFiles(){
		  $('#add_qualityFiles').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="qualityFiles.html";
			    }  
			});  
		}
	 function queryQualityMidince(s){
	 	if(s.value!=""){
			$.post("../qualityRecords/qualityQuery/quamap.html",{
			"quamap" : s,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					$("#dosageforms").val(c[1]);
					$("#specifications").val(c[2]);
					$("#qualifiedSuppliers").val(c[4]);
					$("#tradename").val(c[8]);
					$("#validdate").val(c[7])
				}else{
					return;
				}
			});
	    }
	 }	
	</script>
</body>
</html>