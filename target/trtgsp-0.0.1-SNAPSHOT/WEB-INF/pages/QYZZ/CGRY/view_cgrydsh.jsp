<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sinosoft.util.StringUtil"%>
<%@ page import="com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff"%>
<%@page import="com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ProcurementStaff sales = (ProcurementStaff)request.getAttribute("procurementStaff");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>采购人员/提货人员审核</title>
</head>
<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;采购人员/提货人员&nbsp;>&nbsp;采购人员/提货人员待审核</font>
	<form action="auditProcurementStaff.html" name="edit_xsrydsh" id="edit_xsrydsh" method="post" >
		 	<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span  >1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span  >2</span>
                <br />已保存
            </td>
            <td valign="top" align="center" width="20%">
            	<span class="ok">3</span>
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
            <td><input name="procurementName" value="${procurementStaff.procurementName }" type="text" class="text1" readonly="readonly" size="40" onblur="ajaxChanggeChinaToPinyin(this,'pinyinCode')"/></td>
            <th width="150">性别：</th>
           <td>
            <c:if test="${procurementStaff.gender=='0'}">
            	 <input name="gender1" type="text" class="text1" value="男" size="40" maxlength="20" readonly="readonly"/>
            	 <input type="hidden" name="gender" value="0">
            </c:if>
             <c:if test="${procurementStaff.gender=='1'}">
            	<input name="gender1" type="text" class="text1" value="女" size="40" maxlength="20" readonly="readonly"/>
            	<input type="hidden" name="gender" value="1">
            </c:if>
             <c:if test="${procurementStaff.gender=='2'}">
            	<input name="gender1" type="text" class="text1" value="未知" size="40" maxlength="20" readonly="readonly"/>
            	<input type="hidden" name="gender" value="2">
            </c:if>
            </td>
          </tr>
          <tr>
            <th>拼音码：</th>
            <td><input name="pinyinCode" value="${procurementStaff.pinyinCode }" type="text" class="text1" readonly="readonly" size="40"/></td>
            <th>身份证号：</th>
            <td><input name="IDNumber" value="${procurementStaff.IDNumber }" type="text" class="text1" readonly="readonly" size="40"/></td>
          </tr>
          <!-- 
          <tr>
            <th>出生日期：</th>
            <td><input type="text"  name="birthday" value="${procurementStaff.birthday }" class="text1" readonly="readonly" style="height: 28px;" size="40"/></td>
          </tr>
           -->
          <tr>
            <th>法人委托书：</th>
           <% if(StringUtil.isNull(sales.getPowerOfAttorneyPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${procurementStaff.powerOfAttorneyPath}"><%="法人委托书"+StringUtil.fileExtensions(sales.getPowerOfAttorneyPath())%></a>
            	<input type="hidden" name="powerOfAttorneyPath" value="${procurementStaff.powerOfAttorneyPath }">
           </td>
           <%}else{ %>
            <td>
            <input type="text" name="powerOfAttorney" value="未上传附件" readonly="readonly" class="text1" size="40"/>
            </td>
            <%} %>
            <th>法人委托书到期日期：</th>
            <td>
            	<input type="text" name="powerOfAttorneyDate" value="${procurementStaff.powerOfAttorneyDate }" disabled='false' class="easyui-datebox text1" data-options="disabled:false"  style="height: 28px;" size="40"/>
            </td>
          </tr>
           <tr>
            <th>身份证复印件：</th>
               <% if(StringUtil.isNull(sales.getIdentityCardPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${procurementStaff.identityCardPath}"><%="身份证复印件"+StringUtil.fileExtensions(sales.getIdentityCardPath())%></a>
            	<input type="hidden" name="identityCardPath" value="${procurementStaff.identityCardPath }">
           </td>
           <%}else{ %>
            <td>
            <input type="text" name="identityCard" value="未上传文件" readonly="readonly" class="text1" size="40"/>
            </td>
            <%} %>
            <th>身份证有效期：</th>
            <td>
            	<input type="text" name="identityCardDate" value="${procurementStaff.identityCardDate}" disabled='false' class="easyui-datebox text1" data-options="disabled:false" style="height: 28px;"   size="40"/>
            </td>
          </tr>
           <tr>
          	<th>人员类别<span class="required">*</span>：</th>
          	<td>
          		&nbsp;采购人员&nbsp;<input type="radio" name="personType" value="0" class="easyui-validatebox" disabled='false' data-options="required:true" readonly="readonly">
          		&nbsp;提货人员&nbsp;<input type="radio" name="personType" value="1" class="easyui-validatebox" disabled='false' data-options="required:true" readonly="readonly">
          	</td>
          </tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
           		 <input type="hidden" id="save_type" name="save_type" value=""/>
           		 <input type="hidden" name="id" value="${procurementStaff.id }">
                <input name="" type="button" class="btn_big" value="批准" onclick="update_xsrydsh(0)"/>
                <input name="" type="button" class="btn_big" value="驳回" onclick="$('#dialog').dialog('open')"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	
	 <div id="dialog" title="申请驳回" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:true,top:100">
        <form id="audit" name="" action="auditProcurementStaff.html" method="post">
    	<table>
    	<tr>
            <th valign="top">驳回原因：</th>
            <td colspan="3"><textarea name="reject_reason" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:false"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
			<input type="hidden" id="save_type2" name="save_type" value="1" />
			<input type="hidden" id="id2" name="p_id" value="${procurementStaff.id}"/>
           	<input type="button" class="btn_big" onclick="audit(1)" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
		  </form>
        </div>
     
	<script type="text/javascript">
	$(function(){
			setDefaultForRadio("personType","${procurementStaff.personType}");
		});
		function update_xsrydsh(value){
			$("#save_type").val(value);
		  $('#edit_xsrydsh').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="procurementStaffList.html?type=1";
			    }  
			});  
			
		}
		function audit(value){
			$("#save_type2").val(value);
			var v =$("#save_type2").val();
			//alert(v);
		  $('#audit').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="procurementStaffList.html?type=1";
			    }  
			});  
			
		}
	</script>
</body>
</html>