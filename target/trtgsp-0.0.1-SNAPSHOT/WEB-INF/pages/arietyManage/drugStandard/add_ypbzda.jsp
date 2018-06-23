<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>质量标准档案新增</title>
</head>
<script type="text/javascript">
	$(function(){
		ajaxQueryQualityMidince();
	})
		
</script>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">品种管理&nbsp;>&nbsp;质量标准档案&nbsp;>&nbsp;质量标准档案新增</font>
	<form action="save_standardFile.html" name="add_ypzlbzda" id="add_ypzlbzda" method="post">

        <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
          <tr>
            <th width="150">编号<span class="required">*</span>：</th>
            <td><input name="number" type="text" class="easyui-validatebox text1" value="${maxNumber }" data-options="required:true,validType:'checkNumber'" size="40"/></td>
            <th width="150">通用名称<span class="required">*</span>：</th>
            <td>
            	<input type="text" class="easyui-combobox  text1" data-options="
             required:true,
      	 	valueField: 'id',
       		textField: 'text',
      		url:'../drugVarieties/ajaxAllQueryMedicine.html',
      		onSelect: function(rec){
      			
      		}
			" name="" id="commonnamebox" size="40"/>&nbsp;&nbsp;
            </td>
          </tr>
          <tr>
          	<th>剂型<span class="required">*</span>：</th>
          	<td><input type="text" name="formsName" class="easyui-validatebox text1" data-options="required:true" size="40"/> </td>
          </tr>
          <tr>
            <th>标准依据<span class="required">*</span>：</th>
				<td colspan="3"><input name="standardAccord" type="text" class="easyui-validatebox text1" data-options="required:true" size="100"/></td>  
			</tr>
           <tr>
            <th valign="top">备注：</th>
            <td colspan="3"><textarea name="remark" cols="94" rows="4" class="textarea"></textarea></td>
          </tr>
       <!--    <tr>
          	<th>附件</th>
          	<td><input type="file" name="attach_path" class="text1" size="40"/></td>
          </tr> -->
          
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
            	<input type="hidden" name="commonName" id="commonName" value="">
                <input name="" type="button" class="btn_big" value="保存" onclick="save_zlbzda()"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	<script type="text/javascript">
		$("#commonnamebox").combobox({
			filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q) == 0;
	}
		})
		function save_zlbzda(){
		  var common_name = $("#commonnamebox").combobox('getText');
		   $("#commonName").val(common_name);
		  $('#add_ypzlbzda').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="standardFiles.html";
			    }  
			});  
		}
		 		
	</script>
</body>
</html>