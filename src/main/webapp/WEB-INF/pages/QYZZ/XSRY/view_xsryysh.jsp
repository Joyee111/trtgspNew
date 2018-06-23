<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sinosoft.util.StringUtil"%>
<%@ page import="com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SalesStaff sales = (SalesStaff)request.getAttribute("salesStaff");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>供货单位销售人员已审核</title>
</head>
<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;供货单位销售人员&nbsp;>&nbsp;供货单位销售人员已审核</font>
	<form action="qualifiedSalespersonToReject.html" name="edit_xsryysh" id="edit_xsryysh" method="post" >
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
            	<span >3</span>
                <br />审核
            </td>
            <td valign="top" align="center" width="20%">
            	<span>4</span>
                <br />已驳回
            </td>
            <td valign="top" align="center" width="20%">
            	<span class="ok">5</span>
                <br />审核通过
            </td>
            <td align="right" width="5"><img src="../images/lch_r.gif" /></td>
          </tr>
        </table>
        <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
          <tr>
            <th width="150">姓名<span class="required">*</span>：</th>
            <td><input name="saleName" value="${salesStaff.saleName }" type="text" class="text1" readonly="readonly" size="40" onblur="ajaxChanggeChinaToPinyin(this,'pinyinCode')"/></td>
            <th width="150">性别<span class="required">*</span>：</th>
            <td>
            <c:if test="${salesStaff.gender=='0'}">
            	 <input name="gender1" type="text" class="text1" value="男" size="40" maxlength="20" readonly="readonly"/>
            	 <input type="hidden" name="gender" value="0">
            </c:if>
             <c:if test="${salesStaff.gender=='1'}">
            	<input name="gender1" type="text" class="text1" value="女" size="40" maxlength="20" readonly="readonly"/>
            	<input type="hidden" name="gender" value="1">
            </c:if>   
            <c:if test="${salesStaff.gender=='2'}">
            	<input name="gender1" type="text" class="text1" value="未知" size="40" maxlength="20" readonly="readonly"/>
            	<input type="hidden" name="gender" value="2">
            </c:if>
            </td>
          </tr>
          <tr>
            <th>拼音码<span class="required">*</span>：</th>
            <td><input name="pinyinCode" value="${salesStaff.pinyinCode }" type="text" class="text1" readonly="readonly" size="40"/></td>
            <th>身份证号<span class="required">*</span>：</th>
            <td><input name="IDNumber" value="${salesStaff.IDNumber }" type="text" class="text1" readonly="readonly" size="40"/></td>
          </tr>
          <tr>
          	<th>联系电话<span class="required">*</span>:</th>
          	<td><input type="text" name="telephone" value="${salesStaff.telephone}" id="telephone" class="text1" size="40"/></td>
          </tr>
       <!--   <tr>
            <th>出生日期<span class="required">*</span>：</th>
            <td><input type="text"  name="birthday" value="${salesStaff.birthday }" class="text1" readonly="readonly" style="height: 28px;" size="40"/></td>
          </tr> --> 
          <tr>
            <th>法人委托书：</th>
           <% if(StringUtil.isNull(sales.getPowerOfAttorneyPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${salesStaff.powerOfAttorneyPath}"><%="法人委托书"+StringUtil.fileExtensions(sales.getPowerOfAttorneyPath())%></a>
           </td>
           <%}else{ %>
            <td>
            <input type="text" name="powerOfAttorney" value="未上传附件" readonly="readonly" class="text1" size="40"/>
            </td>
            <%} %>
            <th>法人委托书到期日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="powerOfAttorneyDate" value="${salesStaff.powerOfAttorneyDate }" class="easyui-datebox text1" data-options="disabled:false"  style="height: 28px;" size="40"/>
            </td>
          </tr>
           <tr>
            <th>身份证复印件：</th>
               <% if(StringUtil.isNull(sales.getIdentityCardPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${salesStaff.identityCardPath}"><%="身份证复印件"+StringUtil.fileExtensions(sales.getIdentityCardPath())%></a>
           </td>
           <%}else{ %>
            <td>
            <input type="text" name="identityCard" value="未上传文件" readonly="readonly" class="text1" size="40"/>
            </td>
            <%} %>
            <th>身份证有效期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="identityCardDate" value="${salesStaff.identityCardDate}" class="easyui-datebox text1" data-options="disabled:false" style="height: 28px;"   size="40"/>
            </td>
          </tr>
          <tr>
            <th>药品推销员证书：</th>
              <% if(StringUtil.isNull(sales.getTrainingCertificatePath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${salesStaff.trainingCertificatePath}"><%="药品推销员证书"+StringUtil.fileExtensions(sales.getTrainingCertificatePath())%></a>
           </td>
           <%}else{ %>
            <td>
            <input type="text" name="trainingCertificate" value="未上传文件"  readonly="readonly" class="text1" size="40"/>
            </td>
            <%} %>
            <th>药品推销员证书有效期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="trainingCertificateDate" value="${salesStaff.trainingCertificateDate}"  class="easyui-datebox text1" data-options="disabled:false" style="height: 28px;"   size="40"/>
            </td>
          </tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
           		 <input type="hidden"  name="id" value="${salesStaff.id }"/>
           		 <shiro:hasPermission name="SalesQualify_audited_return">
                <input name="" type="button" class="btn_big" value="确认驳回" onclick="update_xsrydsh()"/>
                </shiro:hasPermission>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	<script type="text/javascript">
		
		function update_xsrydsh(){
		var con = confirm("是否确认驳回！");
		if(con){
		  $('#edit_xsryysh').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI(json.success));
				}
				location.href="salesStaff.html?type=2";
			    }  
			});  
		}else{
			return;
		}	
		}
		
	</script>
</body>
</html>s