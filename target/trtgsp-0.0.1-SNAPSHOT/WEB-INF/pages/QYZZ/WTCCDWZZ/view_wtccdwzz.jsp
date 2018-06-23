<%@ page language="java"
    pageEncoding="UTF-8"%>
<%@page import="com.sinosoft.enterpriseManage.firstEnterprise.model.CommissionedStorageUnitQualification"%>
<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sinosoft.util.StringUtil"%>
    <%@ include file="/common/taglibs.jsp"%><head>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
CommissionedStorageUnitQualification csuq = (CommissionedStorageUnitQualification)request.getAttribute("csuq");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>委托储存单位修改</title>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;委托储存单位资质&nbsp;>&nbsp;委托储存单位修改</font>
<form action="update_wtccdwzzxg.html" name="edit_wtccdwzz" id="edit_wtccdwzz" method="post" enctype="multipart/form-data"> 
      <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
      <tr>
        	<th>编号：</th>
        	<td><input id="customerNumber" name="customerNumber" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkNumber'" size="40" value="${csuq.companyNumber}" readonly="readonly"/></td>
        </tr>
        
      <tr>
        	<th>公司名称<span class="required">*</span>：</th>
        	<td>
        	  <input type="text" class="easyui-validatebox text1" value="${csuq.companyName}"  data-options="required:true" id="companyName" name="companyName" />
        	</td>
            <th width="150">法定代表人<span class="required">*</span>：</th>
            <td>
              <input id="legalRepresentative" name="legalRepresentative" type="text" value="${csuq.legalRepresentative}" class="easyui-validatebox text1" data-options="required:true" size="40"/>
            </td>
        </tr>
          <tr>
          	<th>企业地址<span class="required">*</span>：</th>
          	<td><input type="text" class="easyui-validatebox text1" size="40" value="${csuq.compamyAddress}" data-options="required:true" name="compamyAddress" id="compamyAddress"/></td>
          	<th>质量负责人<span class="required">*</span>：</th>
            <td><input type="text" name="quality_principal" value="${csuq.quality_principal}" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
          </tr>
          <!-- 
          <tr>
          	<th>开户银行：</th>
          	<td><input type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${csuq.bankName}" name="bankName" id="bankName"/></td>
          	<th>银行账号：</th>
            <td><input type="text" name="bankNumber" value="${csuq.bankNumber}" class="easyui-validatebox text1" data-options="required:false" size="40"/></td>
          </tr>
          
          <tr>
          	<th>税票信息地址：</th>
          	<td><input type="text" class="easyui-validatebox text1" size="40" value="${csuq.taxReceiptAddress}" name="taxReceiptAddress" id="taxReceiptAddress" data-options="required:false" /></td>
          	<th>税票信息电话：</th>
            <td><input type="text" name="taxReceiptPhone" value="${csuq.taxReceiptPhone}" class="easyui-validatebox text1" data-options="required:false" size="40"/></td>
          </tr>
           -->
          <tr>
            <th valign="top">储存仓库地址<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="warehouseAddress" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true">${csuq.warehouseAddress }</textarea></td>
          </tr>
          
          <tr>
            <th valign="top">储存范围<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="storageScope" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true">${csuq.storageScope }</textarea></td>
          </tr>
          </table>
          
          
          <table border="0" cellspacing="0" cellpadding="0" class="xx_table2">
          <tr>
            <th>营业执照：</th>
            <% if(StringUtil.isNull(csuq.getBusiness_licence_path())){ //如果营业执照不为空%>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${csuq.business_licence_path}"><%="营业执照"+StringUtil.fileExtensions(csuq.getBusiness_licence_path())%></a>
                <input name="business_licence_path" type="button" class="btn_small" value="删除" onclick="deleteFile('${csuq.id}','${csuq.business_licence_path }','yyzz')"/>
           </td>
           <%}else{ %>
             <td><input name="business_licence_path" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
           
           <th>营业执照到期时间<span class="required">*</span>：</th>
           <td>
                <input type="text" value="${csuq.business_licence_date}" name="business_licence_date" id="business_licence_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
          </tr>
          
          <tr>
            <th>经营许可证：</th>
            <% if(StringUtil.isNull(csuq.getLicence_path())){ //如果营业执照不为空%>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${csuq.licence_path}"><%="经营许可证"+StringUtil.fileExtensions(csuq.getLicence_path())%></a>
                <input name="licence_path" type="button" class="btn_small" value="删除" onclick="deleteFile('${csuq.id}','${csuq.licence_path }','jyxkz')"/>
           </td>
           <%}else{ %>
             <td><input name="licence_path" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
           
           <th>经营许可证到期时间<span class="required">*</span>：</th>
           <td>
                <input type="text" value="${csuq.licence_date}" name="licence_date" id="licence_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
          </tr>
          
          
          <tr>
            <th>GSP/GMP：</th>
            <% if(StringUtil.isNull(csuq.getGsp_certificate_path())){ //如果营业执照不为空%>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${csuq.gsp_certificate_path}"><%="GSP/GSM"+StringUtil.fileExtensions(csuq.getGsp_certificate_path())%></a>
                <input name="gsp_certificate_path" type="button" class="btn_small" value="删除" onclick="deleteFile('${csuq.id}','${csuq.gsp_certificate_path }','gspzs')"/>
           </td>
           <%}else{ %>
             <td><input name="gsp_certificate_path" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
           
           <th>GSP/GMP到期时间<span class="required">*</span>：</th>
           <td>
                <input type="text" value="${csuq.gsp_certificate_date}" name="gsp_certificate_date" id="gsp_certificate_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
          </tr>
          
          <!-- 
          <tr>
            <th>组织机构代码证：</th>
            <% if(StringUtil.isNull(csuq.getOrganization_code_path())){ //如果营业执照不为空%>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${csuq.organization_code_path}"><%="组织机构代码证"+StringUtil.fileExtensions(csuq.getOrganization_code_path())%></a>
                <input name="organization_code_path" type="button" class="btn_small" value="删除" onclick="deleteFile('${csuq.id}','${csuq.organization_code_path }','zzjgdmz')"/>
           </td>
           <%}else{ %>
             <td><input name="organization_code_path" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
           
           <th>组织机构代码证到期时间：</th>
           <td>
                <input type="text" value="${csuq.organization_code_date}" name="organization_code_date" id="organization_code_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
           
          </tr>
          <tr>
         	 <th></th>
         	 <th></th>
         	 <th>组织机构代码年检到期时间：</th>
         	  <td>
                <input type="text" value="${csuq.organization_code_inspection_date}" name="organization_code_inspection_date" id="organization_code_inspection_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           	  </td>
          </tr>
          
          <tr>
            <th>税务登记证：</th>
            <% if(StringUtil.isNull(csuq.getTax_Registration_Certificate_Path())){ //如果营业执照不为空%>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${csuq.tax_Registration_Certificate_Path}"><%="税务登记证"+StringUtil.fileExtensions(csuq.getTax_Registration_Certificate_Path())%></a>
                <input name="tax_Registration_Certificate_Path" type="button" class="btn_small" value="删除" onclick="deleteFile('${csuq.id}','${csuq.tax_Registration_Certificate_Path }','swdjz')"/>
           </td>
           <%}else{ %>
             <td><input name="tax_Registration_Certificate_Path" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
          </tr>
           -->
          
          <tr>
            <th>开展第三方药品物流业务确认书：</th>
            <% if(StringUtil.isNull(csuq.getThird_logistics_drug_confirmation_path())){ //如果营业执照不为空%>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${csuq.third_logistics_drug_confirmation_path}"><%="第三方药品物流业务确认书"+StringUtil.fileExtensions(csuq.getThird_logistics_drug_confirmation_path())%></a>
                <input name="third_logistics_drug_confirmation_path" type="button" class="btn_small" value="删除" onclick="deleteFile('${csuq.id}','${csuq.third_logistics_drug_confirmation_path }','dsfypwlywqrs')"/>
           </td>
           <%}else{ %>
             <td><input name="third_logistics_drug_confirmation_path" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
           
           <th>开展第三方药品物流业务确认书到期时间<span class="required">*</span>：</th>
           <td>
                <input type="text" value="${csuq.third_logistics_drug_confirmation_date}" name="third_logistics_drug_confirmation_date" id="third_logistics_drug_confirmation_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
          </tr>
          
          <tr>
            <td colspan="4" align="center" valign="bottom">
            	<input type="hidden" id="id" name="id" value="${csuq.id}"/>
            	<input type="hidden" name="reason" id="reason" value=""/>
                <input name="" type="button" class="btn_big" value="保存" onclick="$('#dialog').dialog('open')"/>
                <input name="" type="button" class="btn_big" value="返回" onclick="goBack()"/>
            </td>
          </tr>
          
        </table>
		
		<div id="dialog" title="修改原因" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:100">
    	<table>
    	<tr>
            <th valign="top">修改原因：</th>
            <td colspan="3"><textarea name="rejectcause" id="rejectcause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true" ></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
           	<input type="button" class="btn_big" onclick="updata_wtccdwzz()" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
       </div>
       
       
    </form>
    
  <script type="text/javascript">
  	function goBack(){
    		window.location.href="wtccdwzz.html"
    }
    function updata_wtccdwzz(){
    var dialog = $("#dialog").dialog();
    var dialogvalue = dialog.get(0).getElementsByTagName("textarea")[0].value;
    $("#reason").val(dialogvalue);
	  $('#edit_wtccdwzz').form('submit',{  
		    success: function(data){  
			var json = jsonParse(data);
			if(json.success!=null && json.success!=""){
				alert(decodeURI( json.success));
			}
			location.href="wtccdwzz.html";
		    }  
		}); 
	}
	function deleteFile(id,fileName,type){
			$.post("deleteCommissionedStorageUnitQualification.html",{
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
    </script>
</body>
</html>