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
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>委托储存单位新增</title>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;委托储存单位资质&nbsp;>&nbsp;委托储存单位新增</font>
<form action="saveCommissionedStorageUnitQualification.html" name="add_wtccdwzz" id="add_wtccdwzz" method="post" enctype="multipart/form-data"> 
      <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
      <tr>
        	<th>编号<span class="required">*</span>：</th>
        	<td><input id="companyNumber" name="companyNumber" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkNumber'" size="40" value=""/></td>
        </tr>
        
      <tr>
        	<th>公司名称<span class="required">*</span>：</th>
        	<td>
        	  <input type="text" value="" class="easyui-validatebox text1" id="companyName" name="companyName" data-options="required:true" />
        	</td>
            <th width="150">法定代表人<span class="required">*</span>：</th>
            <td>
              <input id="legalRepresentative" name="legalRepresentative" type="text" data-options="required:true" class="easyui-validatebox text1" size="40"/>
            </td>
        </tr>
          <tr>
          	<th>企业地址<span class="required">*</span>：</th>
          	<td><input type="text" class="easyui-validatebox text1" size="40" value="" data-options="required:true" name="compamyAddress" id="compamyAddress"/></td>
          	<th>质量负责人<span class="required">*</span>：</th>
            <td><input type="text" name="quality_principal" id="quality_principal" data-options="required:true" value="" class="easyui-validatebox text1" size="40"/></td>
          </tr>
          <!--  
          <tr>
          	<th>开户银行：</th>
          	<td><input type="text" class="easyui-validatebox text1" size="40" value="" data-options="required:false"  name="bankName" id="bankName"/></td>
          	<th>银行账号：</th>
            <td><input type="text" name="bankNumber" value="" class="easyui-validatebox text1" data-options="required:false" size="40"/></td>
          </tr>
          
          <tr>
          	<th>税票信息地址：</th>
          	<td><input type="text" class="easyui-validatebox text1" size="40" data-options="required:false" value="" name="taxReceiptAddress" id="taxReceiptAddress"/></td>
          	<th>税票信息电话：</th>
            <td><input type="text" name="taxReceiptPhone" id="taxReceiptPhone" data-options="required:false"  value="" class="easyui-validatebox text1" size="40"/></td>
          </tr>
          -->
          <tr>
            <th valign="top">储存仓库地址<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="warehouseAddress" id="warehouseAddress" data-options="required:true" cols="94" rows="4" class="easyui-validatebox  textarea" ></textarea></td>
          </tr>
          
          <tr>
            <th valign="top">储存范围<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="storageScope" id="storageScope" data-options="required:true" cols="94" rows="4" class="easyui-validatebox  textarea" ></textarea></td>
          </tr>
          
          </table>
          
          
          <table border="0" cellspacing="0" cellpadding="0" class="xx_table2">
          <tr>
            <th>营业执照：</th>
             <td><input name="business_licence_path" type="file" class="easyui-validatebox text1" size="40" /></td>
           <th>营业执照到期时间<span class="required">*</span>：</th>
           <td>
                <input type="text" value="" name="business_licence_date" id="business_licence_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
          </tr>
          
          <tr>
            <th>经营许可证：</th>
             <td><input name="licence_path" type="file" class="easyui-validatebox text1"  size="40" /></td>
           <th>经营许可证到期时间<span class="required">*</span>：</th>
           <td>
                <input type="text" value="" name="licence_date" id="licence_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
          </tr>
          
          
          <tr>
            <th>GSP/GMP：</th>
             <td><input name="gsp_certificate_path" type="file" class="easyui-validatebox text1" size="40" /></td>
           
           <th>GSP/GMP到期时间<span class="required">*</span>：</th>
           <td>
                <input type="text" value="" name="gsp_certificate_date" id="gsp_certificate_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
          </tr>
          
          <!-- 
          <tr>
            <th>组织机构代码证：</th>
             <td><input name="organization_code_path" type="file" class="easyui-validatebox text1" size="40" /></td>
           <th>组织机构代码证到期时间：</th>
           <td>
                <input type="text" value="" name="organization_code_date" id="organization_code_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
           
          </tr>
          <tr>
         	 <th></th>
         	 <th></th>
         	 <th>组织机构代码年检到期时间：</th>
         	  <td>
                <input type="text" value="" name="organization_code_inspection_date" id="organization_code_inspection_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           	  </td>
          </tr>
          
          <tr>
            <th>税务登记证：</th>
             <td><input name="tax_Registration_Certificate_Path" type="file" class="easyui-validatebox text1" data-options="required:false" size="40" /></td>
          </tr>
           -->
          
          <tr>
            <th>开展第三方药品物流业务确认书：</th>
             <td><input name="third_logistics_drug_confirmation_path" type="file" class="easyui-validatebox text1" size="40" /></td>
           <th>开展第三方药品物流业务确认书到期时间<span class="required">*</span>：</th>
           <td>
                <input type="text" name="third_logistics_drug_confirmation_date" id="third_logistics_drug_confirmation_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
          </tr>
          
          <tr>
            <td colspan="4" align="center" valign="bottom">
            	<input type="hidden" name="reason" id="reason" value=""/>
                <input name="" type="button" class="btn_big" value="保存" onclick="save_wtccdwzz()"/>
                <input name="" type="button" class="btn_big" value="返回" onclick="goBack()"/>
            </td>
          </tr>
        </table>
    </form>
    
  <script type="text/javascript">
  	function goBack(){
    		window.location.href="wtccdwzz.html"
    }
    function save_wtccdwzz(){
    	$('#add_wtccdwzz').form('submit',{  
		    success: function(data){  
			var json = jsonParse(data);
			if(json.success!=null && json.success!=""){
				alert(decodeURI( json.success));
			}
			location.href="wtccdwzz.html";
		    }  
		}); 
    }
    </script>
</body>
</html>