<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>供货单位销售人员新增</title>
</head>
<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;供货单位销售人员&nbsp;>&nbsp;供货单位销售人员新增</font>
	<form action="saveSalesStaff.html" name="add_xsry" id="add_xsry" method="post" enctype="multipart/form-data">
		 	<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span class="ok" >1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span >2</span>
                <br />已保存
            </td>
            <td valign="top" align="center" width="20%">
            	<span>3</span>
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
            <td align="right" width="5"><img src="../images/lch_r.gif" /></td>
          </tr>
        </table>
        <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
          <tr>
            <th width="150">姓名<span class="required">*</span>：</th>
            <td><input name="saleName" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkChina'" size="40" onblur="ajaxChanggeChinaToPinyin(this,'pinyinCode')"/></td>
            <th width="150">性别<span class="required">*</span>：</th>
            <td>
            <select name="gender" id="gender" class="easyui-validatebox text1" data-options="required:true">
            		<option value="">请选择性别</option>
            		<option value="0">男</option>
            		<option value="1">女</option>
            		<option value="2">未知</option>
            		
            </select>
            </td>
          </tr>
          <tr>
            <th>拼音码<span class="required">*</span>：</th>
            <td><input name="pinyinCode" id="pinyinCode" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
            <th>身份证号<span class="required">*</span>：</th>
            <td><input name="IDNumber" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'idcard'" size="40"/></td>
          </tr>
          <tr>
          	<th>联系电话<span class="required">*</span>:</th>
          	<td><input type="text" name="telephone" id="telephone" class="easyui-validatebox text1" size="40" data-options="required:true,validType:'checkTellOrPhone'"/></td>
          </tr>
         <!--  <tr>
            <th>出生日期<span class="required">*</span>：</th>
            <td><input type="text" name="birthday" class="easyui-datebox text1" data-options="required:true"  style="height: 28px;" size="40"/></td>
          </tr> -->
          <tr>
            <th>法人委托书：</th>
            <td>
            <input type="file" name="powerOfAttorney" class="text1" size="40"/>
            </td>
            <th>法人委托书到期日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="powerOfAttorneyDate" class="easyui-datebox text1" data-options="required:true,validType:'date'"  style="height: 28px;" size="40"/>
            </td>
          </tr>
           <tr>
            <th>身份证复印件：</th>
            <td>
            <input type="file" name="identityCard" class="text1" size="40"/>
            </td>
            <th>身份证有效期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="identityCardDate" class="easyui-datebox text1" data-options="required:true,validType:'date'" style="height: 28px;"   size="40"/>
            </td>
          </tr>
          <tr>
            <th>药品推销员证书：</th>
            <td>
            <input type="file" name="trainingCertificate" class="text1" size="40"/>
            </td>
            <th>药品推销员证书有效期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="trainingCertificateDate" class="easyui-datebox text1" data-options="required:true,validType:'date'" style="height: 28px;"   size="40"/>
            </td>
          </tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
           		 <input type="hidden" id="save_type" name="save_type" value=""/>
                <input name="" type="button" class="btn_big" value="保存" onclick="save_xsry(0)"/>
                <input name="" type="button" class="btn_big" value="提交" onclick="save_xsry(1)"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	<script type="text/javascript">
		function save_xsry(value){
			$("#save_type").val(value);
		
		  $('#add_xsry').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI(json.success));
				}
				location.href="salesStaff.html?type=0";
			    }  
			});  
		}
	</script>
</body>
</html>