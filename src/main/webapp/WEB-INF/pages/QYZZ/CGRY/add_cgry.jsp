<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>采购人员/提货人员新增</title>
</head>
<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;采购人员/提货人员&nbsp;>&nbsp;采购人员/提货人员新增</font>
	<form action="saveProcurementStaff.html" name="add_xsry" id="add_xsry" method="post" enctype="multipart/form-data">
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
            <td><input name="procurementName" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkChina'" size="40" onblur="ajaxChanggeChinaToPinyin(this,'pinyinCode')"/></td>
            <th width="150">性别：</th>
            <td>
            <select name="gender" id="gender" class="easyui-validatebox text1" data-options="required:false">
            		<option value="">请选择性别</option>
            		<option value="0">男</option>
            		<option value="1">女</option>
            		<option value="2">未知</option>
            </select>
            </td>
          </tr>
          <tr>
            <th>拼音码：</th>
            <td><input name="pinyinCode" id="pinyinCode" type="text" class="easyui-validatebox text1" data-options="required:false" size="40"/></td>
            <th>身份证号：</th>
            <td><input name="IDNumber" type="text" class="easyui-validatebox text1" data-options="required:false,validType:'idcard'" size="40"/></td>
          </tr>
          <!-- 
          <tr>
            <th>出生日期：</th>
            <td><input type="text" name="birthday" class="easyui-datebox text1" data-options="required:false"  style="height: 28px;" size="40"/></td>
          </tr>
          -->
          <tr>
            <th>法人委托书：</th>
            <td>
            <input type="file" name="powerOfAttorney" class="text1" size="40"/>
            </td>
            <th>法人委托书到期日期：</th>
            <td>
            	<input type="text" name="powerOfAttorneyDate" class="easyui-datebox text1" data-options="required:false,validType:'date'"  style="height: 28px;" size="40"/>
            </td>
          </tr>
           <tr>
            <th>身份证复印件：</th>
            <td>
            <input type="file" name="identityCard" class="text1" size="40"/>
            </td>
            <th>身份证有效期：</th>
            <td>
            	<input type="text" name="identityCardDate" class="easyui-datebox text1" data-options="required:false,validType:'date'" style="height: 28px;"   size="40"/>
            </td>
          </tr>
          <tr>
          	<th>人员类别<span class="required">*</span>：</th>
          	<td>
          		&nbsp;采购人员&nbsp;<input type="radio" name="personType" value="0" class="easyui-validatebox" data-options="required:true">
          		&nbsp;提货人员&nbsp;<input type="radio" name="personType" value="1" class="easyui-validatebox" data-options="required:true">
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
			var radioValue = getRadioValueByName("personType");
			if(typeof(radioValue) == 'undefined' || radioValue=='' ){
				alert("请选择要添加的人员类别！");
				return null;
			}
		
		  $('#add_xsry').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI(json.success));
				}
				location.href="procurementStaffList.html?type=0";
			    }  
			});  
		}
	</script>
</body>
</html>