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
	<form action="saveTransporterQualification.html" name="add_cyszz" id="add_cyszz" method="post">
        <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
          <tr>
            <th width="150">承运商名称<span class="required">*</span>：</th>
            <td><input name="transporterName" type="text" class="easyui-validatebox text1" data-options="required:true" size="40" /></td>
            <th width="150">法人代表<span class="required">*</span>：</th>
            <td><input name="legalRepresentative" type="text" class="easyui-validatebox text1" data-options="required:true,validType:['checkChina','length[2,10]']" size="40" /></td>
          </tr>
          <tr>
            <th>营业执照号<span class="required">*</span>：</th>
            <td><input name="businessLicense" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
            <th>营业执照到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="businessLicenseDate" class="easyui-datebox text1" data-options="required:true,validType:'date'"  style="height: 28px;" size="40"/>
            </td>
          </tr>
          <tr>
            <th>运输经营/生产许可证号<span class="required">*</span>：</th>
            <td><input name="transportationLicense" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
            <th>运输许可证到期日期<span class="required">*</span>：</th>
             <td>
            	<input type="text" name="transportationLicenseDate" class="easyui-datebox text1" data-options="required:true,validType:'date'"  style="height: 28px;" size="40"/>
            </td>
          </tr>
          <tr>
            <th>合同名称<span class="required">*</span>：</th>
            <td><input name="contractName" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
            <th>合同到期日期<span class="required">*</span>：</th>
             <td>
            	<input type="text" name="contractDate" class="easyui-datebox text1" data-options="required:true,validType:'date'"  style="height: 28px;" size="40"/>
            </td>
          </tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
                <input name="" type="button" class="btn_big" value="保存" onclick="save_cyszz()"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	<script type="text/javascript">
		function save_cyszz(){
		  $('#add_cyszz').form('submit',{  
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