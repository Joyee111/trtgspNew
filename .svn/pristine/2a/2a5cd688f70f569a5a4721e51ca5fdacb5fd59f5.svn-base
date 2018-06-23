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
	<form action="saveQualityTrackRecord.html" name="add_qualityTrackRecord" id="add_qualityTrackRecord" method="post" enctype="multipart/form-data">

        <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
        <tr>
                 <th width="150">通用名称<span class="required">*</span>：</th>
            <td>
            <input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
       		disabled:'true'
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
            <th valign="top">项目名称<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="projectName" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true"></textarea></td>
          </tr>
          <tr>
            <th valign="top">变更情况<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="changContent" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true"></textarea></td>
          </tr>
          <tr>
          	<th>附件:</th>
          	<td><input type="file" name="accessory_path" class="text1" size="40"/></td>
          </tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
            	<input name="qualityFilesId" type="hidden" id="qualityFilesId" value="${qualityFilesId}">
                <input name="" type="button" class="btn_big" value="保存" onclick="save_qualityTrackqualityFiles()"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	<script type="text/javascript">
	$(function(){
		$("#commonnamebox").combobox("setValue","("+"${qualityFiles.qualityMidicine.medicinalNo}"+")"+"${qualityFiles.qualityMidicine.commonname}");
		
	})
		function save_qualityTrackqualityFiles(){
		  $('#add_qualityTrackRecord').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				var qulityFilesId = json.qualityFilesId;
				//alert(json.qualityFilesId);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="findQualityTrackRecord.html?qualityFilesId="+qulityFilesId;
			    }  
			});  
		}
	</script>
</body>
</html>