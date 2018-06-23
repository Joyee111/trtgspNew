<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页企业</title>
</head>
<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;承运资质&nbsp;>&nbsp;承运资质新增</font>
	<form action="updateTransporterQualification.html" name="update_cyszz" id="update_cyszz" method="post">
        <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
          <tr>
            <th width="150">承运商名称<span class="required">*</span>：</th>
            <td><input name="transporterName" type="text" class="easyui-validatebox text1" data-options="required:true" value="${transQualification.transporterName }" size="40" /></td>
            <th width="150">法人代表<span class="required">*</span>：</th>
            <td><input name="legalRepresentative" type="text" class="easyui-validatebox text1" data-options="required:true,validType:['checkChina','length[2,10]']" value="${transQualification.legalRepresentative }" size="40" /></td>
          </tr>
          <tr>
            <th>营业执照号<span class="required">*</span>：</th>
            <td><input name="businessLicense" type="text" class="easyui-validatebox text1" data-options="required:true" value="${transQualification.businessLicense }" size="40"/></td>
            <th>营业执照到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="businessLicenseDate" class="easyui-datebox text1" data-options="required:true,validType:'date'" value="${transQualification.businessLicenseDate }"  style="height: 28px;" size="40"/>
            </td>
          </tr>
          <tr>
            <th>运输经营/生产许可证号<span class="required">*</span>：</th>
            <td><input name="transportationLicense" type="text" class="easyui-validatebox text1" data-options="required:true" value="${transQualification.transportationLicense }" size="40"/></td>
            <th>运输许可证到期日期<span class="required">*</span>：</th>
             <td>
            	<input type="text" name="transportationLicenseDate" class="easyui-datebox text1" data-options="required:true,validType:'date'"  style="height: 28px;" value="${transQualification.transportationLicenseDate }" size="40"/>
            </td>
          </tr>
          <tr>
            <th>合同名称<span class="required">*</span>：</th>
            <td><input name="contractName" type="text" class="easyui-validatebox text1" data-options="required:true" value="${transQualification.contractName}" size="40"/></td>
            <th>合同到期日期<span class="required">*</span>：</th>
             <td>
            	<input type="text" name="contractDate" class="easyui-datebox text1" data-options="required:true,validType:'date'"  style="height: 28px;" value="${transQualification.contractDate }" size="40"/>
            </td>
          </tr>
          <tr>
          	<th>状态<span class="required">*</span>：</th>
          	<td>
          		<font style="font-size:12px; color:#727171; font-weight:bold;">启用</font>
          		<input name="deleteFlag" type="radio" value="0"/>
          		<font style="font-size:12px; color:#727171; font-weight:bold;">停用</font>
          		<input name="deleteFlag" type="radio" value="1"/>
          		<font style="font-size:12px; color:#727171; font-weight:bold;">暂时停用</font>
          		<input name="deleteFlag" type="radio" value="2"/>
          	</td>
          </tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
            	<input type="hidden" name="id" value="${transQualification.id}"/>
            	<input type="hidden" name="modify_reason" id="modify_reason"/>
                <input name="" type="button" class="btn_big" value="保存" onclick="$('#dialog').dialog('open')"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
       <div id="dialog" title="修改原因" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:200">
    	<table>
    	<tr>
            <th valign="top">修改原因：</th>
            <td colspan="3"><textarea name="rejectcause" id="rejectcause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
           	<input type="button" class="btn_big" onclick="updateCyszz()" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
        </div>
	</form>
	<script type="text/javascript">
	setDefaultForRadio("deleteFlag","${transQualification.deleteFlag}");
		function updateCyszz(){
		var  dialog = $("#dialog").dialog();
		var value =  dialog.get(0).getElementsByTagName("textarea")[0].value;
		$("#modify_reason").val(value);
		  $('#update_cyszz').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="transporterQualification.html";
			    }  
			});  
		}
	</script>
</body>
</html>