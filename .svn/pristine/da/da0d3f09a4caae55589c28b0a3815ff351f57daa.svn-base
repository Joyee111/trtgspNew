<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@page import="com.sinosoft.varietyManger.firstVarietyManger.model.QualityTrackRecord"%>
<%@page import="com.sinosoft.util.StringUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
QualityTrackRecord redord = (QualityTrackRecord)request.getAttribute("record") ;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>质量档案修改</title>
</head>
<script type="text/javascript">
	
</script>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">品种管理&nbsp;&gt;&nbsp;质量档案&nbsp;&gt;&nbsp;质量档案修改</font>
	<form action="updateQualityTrackRecord.html" name="update_qualityTrackRecord" id="update_qualityTrackRecord" method="post" enctype="multipart/form-data">

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
            <td><input name="dosageforms" id="dosageforms" value="${record.qualityFiles.qualityMidicine.dosageforms.formName }" type="text" class="text1" readonly="readonly" size="40"/></td>
          </tr>
          <tr>
          	<th>商品名称</th>
          	<td>
          		<input type="text" name="tradename" id="tradename" value="${record.qualityFiles.qualityMidicine.tradename }" class="text1" size="40">
          	</td>
            <th>规格：</th>
			<td ><input name="specifications" id="specifications"  value="${record.qualityFiles.qualityMidicine.specifications }"  type="text" class="text1" readonly="readonly" size="40"/></td>
		</tr>
		<tr>
			<th>有效期：</th>
			<td ><input name="validdate" id="validdate" type="text" value="${record.qualityFiles.qualityMidicine.validdate }"  class="text1" readonly="readonly" size="40"/></td>    
			<th>生产厂商：</th>
			<td ><input name="qualifiedSuppliers" id="qualifiedSuppliers"  value="${record.qualityFiles.qualityMidicine.produceno.customerName}"  type="text" class="text1" readonly="readonly" size="40"/></td>    
		</tr>
           <tr>
            <th valign="top">项目名称<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="projectName" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true">${record.projectName}</textarea></td>
          </tr>
          <tr>
            <th valign="top">变更情况<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="changContent" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true">${record.changContent}</textarea></td>
          </tr>
          <tr>
          	<th>附件：</th>
             <% if(StringUtil.isNull(redord.getAccessoryPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${record.accessoryPath}"><%="附件"+StringUtil.fileExtensions(redord.getAccessoryPath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${record.id}','${record.accessoryPath }')" value="删除"/>
                <input type="hidden" name="accessoryPath" value="${record.accessoryPath }"/>
           </td>
           <%}else{ %>
            <td>
            <input type="file" name="accessory_path" class="text1" size="40"/>
            </td>
           <%} %>
           </tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
            	<input name="id" type="hidden" value="${record.id}">
            	<input name="qualityFilesId" type="hidden" value="${record.qualityFiles.id}">
            	<shiro:hasPermission name="QualityStandardManage_save">
                <input name="" type="button" class="btn_big" value="保存" onclick="upadte_qualityTrackrecord()"/>
                </shiro:hasPermission>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
		<script type="text/javascript">
		$(function(){
			$("#commonnamebox").combobox("setValue","("+"${record.qualityFiles.qualityMidicine.medicinalNo}"+")"+"${record.qualityFiles.qualityMidicine.commonname}");
		
		});
		function upadte_qualityTrackrecord(){
		  $('#update_qualityTrackRecord').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				var qulityFilesId =json.qulityFilesId;
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				var midinceId = $("#qualifiedMedicineId").val();
				location.href="findQualityTrackRecord.html?qualityFilesId="+qulityFilesId;
			    }  
			});  
		}
		function deleteFile(id,fileName){
			$.post("deleteQualityTrackRecordFile.html",{
				id : id,
				fileName : fileName,
				//stype : type
			},function(data){
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.reload();
			});
		}
	</script>
	</body>
</html>