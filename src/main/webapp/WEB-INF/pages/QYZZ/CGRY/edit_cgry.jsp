<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sinosoft.util.StringUtil"%>
<%@ page import="com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff"%>
<%@page import="com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ProcurementStaff sales = (ProcurementStaff)request.getAttribute("procurementStaff");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>采购人员/提货人员编辑</title>
</head>
<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;采购人员/提货人员&nbsp;>&nbsp;采购人员/提货人员编辑</font>
	<form action="updateProcurementStaff.html" name="edit_xsry" id="edit_xsry" method="post" enctype="multipart/form-data">
		 	<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span  >1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span class="ok" >2</span>
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
            <th width="150">姓名：</th>
            <td><input name="procurementName" value="${procurementStaff.procurementName }" type="text" class="easyui-validatebox text1" data-options="required:false,validType:'checkChina'" size="40" onblur="ajaxChanggeChinaToPinyin(this,'pinyinCode')"/></td>
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
            <td><input name="pinyinCode" id="pinyinCode" value="${procurementStaff.pinyinCode }" type="text" class="easyui-validatebox text1" data-options="required:false" size="40"/></td>
            <th>身份证号：</th>
            <td><input name="IDNumber" value="${procurementStaff.IDNumber }" type="text" class="easyui-validatebox text1" data-options="required:false,validType:'idcard'" size="40"/></td>
          </tr>
          <!-- 
          <tr>
            <th>出生日期：</th>
            <td><input type="text"  name="birthday" value="${procurementStaff.birthday }" class="easyui-datebox text1" data-options="required:false"  style="height: 28px;" size="40"/></td>
          </tr>
           -->
          <tr>
            <th>法人委托书：</th>
           <% if(StringUtil.isNull(sales.getPowerOfAttorneyPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${procurementStaff.powerOfAttorneyPath}"><%="法人委托书"+StringUtil.fileExtensions(sales.getPowerOfAttorneyPath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${procurementStaff.id}','${procurementStaff.powerOfAttorneyPath }','frwts')" value="删除"/>
                 <input type="hidden" name="powerOfAttorneyPath" value="${procurementStaff.powerOfAttorneyPath}">
           </td>
           <%}else{ %>
            <td>
            <input type="file" name="powerOfAttorney" class="text1" size="40"/>
            </td>
            <%} %>
            <th>法人委托书到期日期：</th>
            <td>
            	<input type="text" name="powerOfAttorneyDate" value="${procurementStaff.powerOfAttorneyDate }" class="easyui-datebox text1" data-options="required:false,validType:'date'"  style="height: 28px;" size="40"/>
            </td>
          </tr>
           <tr>
            <th>身份证复印件：</th>
               <% if(StringUtil.isNull(sales.getIdentityCardPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${procurementStaff.identityCardPath}"><%="身份证复印件"+StringUtil.fileExtensions(sales.getIdentityCardPath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${procurementStaff.id}','${procurementStaff.identityCardPath }','sfz')" value="删除"/>
                <input type="hidden" name="identityCardPath" value="${procurementStaff.identityCardPath }">
           </td>
           <%}else{ %>
            <td>
            <input type="file" name="identityCard" class="text1" size="40"/>
            </td>
            <%} %>
            <th>身份证有效期：</th>
            <td>
            	<input type="text" name="identityCardDate" value="${procurementStaff.identityCardDate}" class="easyui-datebox text1" data-options="required:false,validType:'date'" style="height: 28px;"   size="40"/>
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
           		 <input type="hidden" name="id" value="${procurementStaff.id }">
                <input name="" type="button" class="btn_big" value="保存" onclick="update_xsry(0)"/>
                <input name="" type="button" class="btn_big" value="提交" onclick="update_xsry(1)"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	<script type="text/javascript">
		$(function(){
			setDefaultForRadio("personType","${procurementStaff.personType}");
		});
		function update_xsry(value){
			$("#save_type").val(value);
			var radioValue = getRadioValueByName("personType");
			if(typeof(radioValue) == 'undefined' || radioValue=='' ){
				alert("请选择要添加的人员类别！");
				return null;
			}
		  $('#edit_xsry').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="procurementStaffList.html?type=0";
			    }  
			});  
			
		}
		function deleteFile(id,fileName,type){
			$.post("delteProcurementStaff.html",{
				id : id,
				fileName : fileName,
				type : type
			},function(data){
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.reload();
			});
		}
		setDefaultForCheckbox("gender","${procurementStaff.gender}")
	</script>
</body>
</html>