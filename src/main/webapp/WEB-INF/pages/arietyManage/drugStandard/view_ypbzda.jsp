<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sinosoft.util.StringUtil"%>
<%@ page import="com.sinosoft.varietyManger.firstVarietyManger.model.DrugStandardsFiles"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	DrugStandardsFiles drugStandardsFiles =(DrugStandardsFiles) request.getAttribute("standardsFile");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>质量标准档案修改</title>
<script type="text/javascript">
	
</script>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">品种管理&nbsp;>&nbsp;质量标准档案&nbsp;>&nbsp;质量标准档案修改</font>
	<form action="update_standardFile.html" name="update_ypzlbzda" id="update_ypzlbzda" method="post">

        <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
          <tr>
            <th width="150">编号<span class="required">*</span>：</th>
            <td><input name="number" value="${standardsFile.number}" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkNumber'" size="40"/></td>
            <th width="150">通用名称<span class="required">*</span>：</th>
           <td>
            	<input type="text" class="easyui-combobox  text1" data-options="
             required:true, 
      	 	valueField: 'id',
       		textField: 'text',
       		value : '${standardsFile.commonName}',
      		url:'../drugVarieties/ajaxAllQueryMedicine.html',
      		onSelect: function(rec){
      		}
			" name="" id="commonnamebox" size="40"/>&nbsp;&nbsp;
           </td>
          </tr>
          <tr>
          	<th>剂型<span class="required">*</span>：</th>
          	<td><input type="text" name="formsName" class="easyui-validatebox text1"  data-options="required:true" value="${standardsFile.formsName }"/></td>
          </tr>
          <tr>
            <th>标准依据<span class="required">*</span>：</th>
				<td colspan="3"><input name="standardAccord" value="${standardsFile.standardAccord}" type="text" class="easyui-validatebox text1" data-options="required:true" size="123"/></td>  
			</tr>
           <tr>
            <th valign="top">备注：</th>
            <td colspan="3"><textarea name="remark" cols="94" rows="4" class="textarea">${standardsFile.remark}</textarea></td>
          </tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
            	<input name="id" type="hidden" value="${standardsFile.id}">
            	<input type="hidden" name="commonName" id ="commonName" value="${standardsFile.commonName}">
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	</body>
</html>