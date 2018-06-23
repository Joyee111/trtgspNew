<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@ page import="com.sinosoft.util.StringUtil"%>
<%@ page import="com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise"%>
<%@ page import="com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterpriseAccessory"%>

    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Set<FirstEnterpriseAccessory> accessorySet = ((FirstEnterprise)request.getAttribute("enterprise")).getAccessories();
int accssorySize = accessorySet.size();
request.setAttribute("accssorySize",accssorySize);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改首营企业</title>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;&gt;&nbsp;首营企业&nbsp;&gt;&nbsp;首营企业修改</font>
	<form action="update_syqy.html?t=(new Date()).valueOf()" name="edit_syqy" id="edit_syqy" method="post" enctype="multipart/form-data">
		 	<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span >1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span class="ok">2</span>
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

        <table border="0" cellspacing="0" cellpadding="0" class="xx_table1">
          <tr>
          <th>客户编号<span class="required">*</span>：</th>
            <td><input name="customerNumber" type="text" class="easyui-validatebox text1" size="40" data-options="required:false,validType:'checkNumber'" maxlength="20"  value="${enterprise.customerNumber}"/></td>
            <th width="150">企业名称<span class="required">*</span>：</th>
            <td><input name="companyName" type="text" class="easyui-validatebox text1" data-options="required:true" size="40" value="${enterprise.companyName}" onchange="ajaxChanggeChinaToPinyin(this,'pinyinCode')"/></td>
          </tr>
          <tr>
          	 <th>拼音码<span class="required">*</span>：</th>
            <td><input name="pinyinCode" id="pinyinCode" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${enterprise.pinyinCode}"/></td>
            <th>邮      编<span class="required">*</span>：</th>
            <td><input name="postalcode" type="text" class="easyui-validatebox text1" data-options="required:false,validType:'checkPostCode'" size="40" value="${enterprise.postalcode}"/></td>
          </tr>
           <tr>
            <th>联系电话<span class="required">*</span>：</th>
            <td><input name="phone" type="text" class="easyui-validatebox text1" data-options="required:false" maxlength="20" size="40" value="${enterprise.phone}"/></td>
            <th>传  真<span class="required">*</span>：</th>
            <td><input name="portraiture" type="text" class="text1" data-options="required:true" size="40" value="${enterprise.portraiture}"/></td>
          </tr>
          <tr>
            <th width="150">法人代表/负责人<span class="required">*</span>：</th>
            <td><input name="corporation" type="text" class="easyui-validatebox text1" data-options="required:true,validType:['checkChina','length[2,10]']"  size="40" value="${enterprise.corporation}"/></td>
              <th>纳税人登记号<span class="required">*</span>：</th>
            <td><input name="taxpayerRegisterNo" type="text" class="easyui-validatebox text1" data-options="required:false,validType:'checkCertificate'" size="40" value="${enterprise.taxpayerRegisterNo}"/></td>
          </tr>
          <tr>
            <th>开户银行<span class="required">*</span>：</th>
            <td><input name="bankName" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkChina'" size="40" value="${enterprise.bankName}"/></td>
            <th>开户银行账号<span class="required">*</span>：</th>
            <td><input name="bankNumber" type="text" class="easyui-validatebox text1" data-options="required:true,validType:['checkNumber','length[16,19]']" size="40" value="${enterprise.bankNumber}"/></td>
          </tr>
          <tr>
          	<th>开户户名<span class="required">*</span>：</th>
            <td><input name="bankUserName" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkChina'" size="40" value="${enterprise.bankUserName }"/></td>
            <th>销售代表<span class="required">*</span>：</th>
            <td>
            <input type="text" class="easyui-combobox  text1" data-options="
             required:true,
      	 	valueField: 'id',
       		textField: 'text',
      		url:'../firstEnterprise/findSalesStaffJson.html',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#sales_deputy').val(str[1]);
      		}" name="" id="commonnamebox" size="40"/>
          </tr>
          <tr>
          <th>Email地址<span class="required">*</span>：</th>
            <td><input name="email" type="text" class="easyui-validatebox text1" data-options="required:false,validType:'email'"  size="40" value="${enterprise.email}"/></td>
          </tr>
        <!--   <tr>
            <th>企业地址<span class="required">*</span>：</th> -->
            <%
            	FirstEnterprise enterptise = (FirstEnterprise)request.getAttribute("enterprise");
            	
            %>
          <!--   <td><input name="compamyAddress" type="text" class="text1" size="40" value="${enterprise.compamyAddress}"/></td>
            
          </tr>
          <tr>
            <th>质量负责人<span class="required">*</span>：</th>
            <td><input name="quality_principal" type="text" class="easyui-validatebox text1" data-options="required:true,validType:['checkChina','length[2,10]']"  size="40" value="${enterprise.quality_principal}"/></td>
            
          </tr>
          <tr> -->
            
            <!-- <th>十位码<span class="required">*</span>：</th>
            <td><input name="tenBitCode" type="text" class="easyui-validatebox text1" data-options="required:false,validType:'checkTenCode'" size="40" value="${enterprise.tenBitCode}"/></td>
            -->
            <!--   <th>提货人员：</th>
           <td>
           	<input type="text" name="deliveryPersonnel" value="${enterprise.deliveryPersonnel}" class="easyui-validatebox text1" data-options="required:false,validType:'checkChina'" size="40"/>
           </td> -->
          <!--   <th>企业经济性质<span class="required">*</span>：</th>
            <td><select name="economic_nature" id="economic_nature">
            <option value="1">国有企业</option>
				<option value="2">私营企业</option>
				<option value="3">个人独资企业</option>
				<option value="4">集体企业</option>
				<option value="5">外资企业企业</option>
            </select></td>
          </tr>
        
       -->
       <!--    <tr>
            <th>经营/生产许可证号<span class="required">*</span>：</th>
            <td><input name="license_No" type="text" class="easyui-validatebox text1" data-options="required:false,validType:'checkCertificate'" size="40" value="${enterprise.license_No}"/></td>
            <th> 营业执照号<span class="required">*</span>：</th>
            <td><input name="business_license_No" type="text" class="easyui-validatebox text1" data-options="required:false,validType:'checkCertificate'" size="40" value="${enterprise.business_license_No}"/></td>
          </tr>
          <tr>
          
            <th>认证证书号码<span class="required">*</span>：</th>
            <td><input name="certificate_No" type="text" class="easyui-validatebox text1" data-options="required:false,validType:'checkCertificate'" size="40" value="${enterprise.certificate_No}"/></td>
          </tr> -->
          
          <tr>
          
           
            <!-- 
             <th>提货人员<span class="required">*</span>：</th>
           <td>
           	<input type="text" name="deliveryPersonnel" value="${enterprise.deliveryPersonnel}" class="easyui-validatebox text1" data-options="required:true,validType:'checkChina'" size="40"/>
           </td> -->
          </tr>
          <tr>
            <th valign="top">经营/生产范围<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="businessScope" cols="94" rows="4" class="easyui-validatebox textarea" data-options="required:true,validType:'checkChina'">${enterprise.businessScope}</textarea></td>
          </tr>
          <tr>
            <th valign="top">申请原因<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="apply_cause" cols="94" rows="4" class="easyui-validatebox textarea" data-options="required:true,validType:'checkChina'">${enterprise.apply_cause}</textarea></td>
          </tr>
           <tr>
            <th valign="top">备注：</th>
            <td colspan="3"><textarea name="remark" cols="94" rows="4" class="textarea" >${enterprise.remark}</textarea></td>
          </tr>
          <tr>
            <th>营业执照：</th>
           <% if(StringUtil.isNull(enterptise.getBusiness_licence_path())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${enterprise.business_licence_path}"><%=enterptise.getCompanyName()+"营业执照"+StringUtil.fileExtensions(enterptise.getBusiness_licence_path())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${enterprise.id}','${enterprise.business_licence_path }','yyzz')" value="删除"/>
           </td>
           <%}else{ %>
            <td>
            <input type="file" name="business_licence_path" class="text1" size="40"/>
            </td>
           <%} %>
            <th>营业执照到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="business_licence_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40" value="${enterprise.business_licence_date}"/>
            </td>
          </tr>
          <tr>
           <%--    <th>营业执照年检：</th>
           <% if(StringUtil.isNull(enterptise.getBusiness_licence_inspection_path())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${enterprise.business_licence_inspection_path}"><%=enterptise.getCompanyName()+"营业执照"+StringUtil.fileExtensions(enterptise.getBusiness_licence_inspection_path())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${enterprise.id}','${enterprise.business_licence_inspection_path }','yyzznj')" value="删除"/>
           </td>
           <%}else{ %>
            <td>
            <input type="file" name="business_licence_inspection_path" class="text1" size="40"/>
            </td>
           <%} %>
            <th>营业执照年检时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="business_licence_inspection_date" class="easyui-datebox" data-options="required:true,validType:'date'" size="40" value="${enterprise.business_licence_inspection_date}"/>
            </td>
          </tr>--%>
           <tr>
            <th>经营/生产许可证：</th>
             <% if(StringUtil.isNull(enterptise.getLicence_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${enterprise.licence_path}"><%=enterptise.getCompanyName()+"经营/生产许可证"+StringUtil.fileExtensions(enterptise.getLicence_path())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${enterprise.id}','${enterprise.licence_path}','xkz')"/>
             </td>
            <%}else{%>
            	<td>
           		 <input type="file" name="licence_path" class="text1" size="40"/>
            	</td>
            <%} %>
            <th>经营/生产许可证到期日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="licence_date" class="easyui-datebox"  data-options="required:true,validType:'date'" size="40" value="${enterprise.licence_date}"/>
            </td>
          </tr>
           <tr>
            <th>GSP/GMP证书：</th>
             <% if(StringUtil.isNull(enterptise.getGsp_certificate_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${enterprise.gsp_certificate_path}"><%=enterptise.getCompanyName()+"GSP/GMP证书"+StringUtil.fileExtensions(enterptise.getGsp_certificate_path())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${enterprise.id}','${enterprise.gsp_certificate_path}','gsp')"/>
             </td>
            <%}else{%>
            	<td>
           		 <input type="file" name="gsp_certificate_path" class="text1" size="40"/>
            	</td>
            <%} %>
            <th>GSP/GMP证书截止日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="gsp_certificate_date" class="easyui-datebox"  data-options="required:true,validType:'date'" size="40" value="${enterprise.gsp_certificate_date}"/>
            </td>
          </tr>
          <tr>
            <th>组织机构代码证：</th>
             <% if(StringUtil.isNull(enterptise.getOrganization_code_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${enterprise.organization_code_path}"><%=enterptise.getCompanyName()+"组织机构代码证"+StringUtil.fileExtensions(enterptise.getOrganization_code_path())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${enterprise.id}','${enterprise.organization_code_path}','zzjgdm')"/>
             </td>
            <%}else{%>
            	<td>
           		 <input type="file" name="organization_code_path" class="text1" size="40"/>
            	</td>
            <%} %>
            <th>组织机构代码到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="organization_code_date" class="easyui-datebox"  data-options="required:true,validType:'date'" size="40" value="${enterprise.organization_code_date}"/>
            </td>
          </tr>
           <tr>
            <th>组织机构代码证年检：</th>
             <% if(StringUtil.isNull(enterptise.getOrganization_code_inspection_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${enterprise.organization_code_inspection_path}"><%=enterptise.getCompanyName()+"组织机构代码证年检"+StringUtil.fileExtensions(enterptise.getOrganization_code_inspection_path())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${enterprise.id}','${enterprise.organization_code_inspection_path}','zzjgdmnj')"/>
             </td>
            <%}else{%>
            	<td>
           		 <input type="file" name="organization_code_inspection_path" class="text1" size="40"/>
            	</td>
            <%} %>
            <th>组织机构代码年检时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="organization_code_inspection_date" class="easyui-datebox"  data-options="required:true,validType:'date'" size="40" value="${enterprise.organization_code_inspection_date}"/>
            </td>
          </tr>
            <tr>
            <th>质量保证协议：</th>
             <% if(StringUtil.isNull(enterptise.getQuality_assurance_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${enterprise.quality_assurance_path}"><%=enterptise.getCompanyName()+"质量保证协议"+StringUtil.fileExtensions(enterptise.getQuality_assurance_path())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${enterprise.id}','${enterprise.quality_assurance_path}','zbxy')"/>
             </td>
            <%}else{%>
            	<td>
           		 <input type="file" name="quality_assurance_path" class="text1" size="40"/>
            	</td>
            <%} %>
            <th>质量保证书到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="quality_assurance_date" class="easyui-datebox"  data-options="required:true,validType:'date'" size="40" value="${enterprise.quality_assurance_date}"/>
            </td>
          </tr>
           <tr>
            <th>法人委托书：</th>
             <% if(StringUtil.isNull(enterptise.getAuthorization_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${enterprise.authorization_path}"><%=enterptise.getCompanyName()+"法人委托书"+StringUtil.fileExtensions(enterptise.getAuthorization_path())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${enterprise.id}','${enterprise.authorization_path}','wtsqs')"/>
             </td>
            <%}else{%>
            	<td>
           		 <input type="file" name="authorization_path" class="text1" size="40"/>
            	</td>
            <%} %>
            <th>法人委托书到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="authorization_date" value="${enterprise.authorization_date}" class="easyui-datebox"  data-options="required:true ,validType:'date'" size="40" value="${enterprise.authorization_date}"/>
            </td>
          </tr>
         <%-- 
          <tr>
          
            <th>认证证书：</th>
            <% if(StringUtil.isNull(enterptise.getLittCredentPath())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${enterprise.littCredentPath}"><%=enterptise.getCompanyName()+"认证证书"+StringUtil.fileExtensions(enterptise.getLittCredentPath())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${enterprise.id}','${enterprise.littCredentPath}','rzzs')"/>
             </td>
            <%}else{%>
            	<td>
            	<input type="file" name="littCredentPath" class="text1 " size="40"/>
            	</td>
            <%} %>
            
            <th>认证证书到期日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="littCredentDate" class="easyui-datebox" data-options="required:true"  size="40" value="${enterprise.littCredentDate}"/>
            </td>
          </tr>
           <tr>
            <th>开户信息：</th>
             <% if(StringUtil.isNull(enterptise.getAccountPath())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${enterprise.accountPath}"><%=enterptise.getCompanyName()+"开户信息"+StringUtil.fileExtensions(enterptise.getAccountPath())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${enterprise.id}','${enterprise.accountPath}','khxx')"/>
             </td>
            <%}else{%>
           	<td>
            <input type="file" name="accountPath" class="text1" size="40"/>
            </td>
            <%} %>
           
            <th>开户信息到期日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="accountDate" class="easyui-datebox" data-options="required:true"  size="40" value="${enterprise.accountDate}"/>
            </td>
          </tr>
          <tr>
            <th>年检证明：</th>
             <% if(StringUtil.isNull(enterptise.getAnnualSurveyPath())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${enterprise.annualSurveyPath}"><%=enterptise.getCompanyName()+"年检证明"+StringUtil.fileExtensions(enterptise.getAnnualSurveyPath())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${enterprise.id}','${enterprise.annualSurveyPath}','njzm')"/>
             </td>
            <%}else{%>
           	 <td>
            <input type="file" name="annualSurveyPath" class="text1" size="40"/>
            </td>
            <%} %>            
            <th>年检证明到期日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="annualSurveyDate" class="easyui-datebox" data-options="required:true" size="40" value="${enterprise.annualSurveyDate}"/>
            </td>
          </tr>
          --%>
          <%--
          <tr id="add_dttachment" >
          	<td colspan="4" align="center" valign="top"><input name="" type="button" class="btn_big" value="新增附件" onclick="add_children()"/></td>
          </tr>
          <%
          		Iterator<FirstEnterpriseAccessory> it = accessorySet.iterator();
          		while(it.hasNext()){
          			FirstEnterpriseAccessory accessory = it.next();
          			int index = Integer.valueOf(accessory.getRequest_name().substring(accessory.getRequest_name().length()-1));
          %>
          <tr>
          	<th>附件：<%=index%></th>
          	<% if(StringUtil.isNull(accessory.getAccessoryPath())){ %>
          	<td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=<%=accessory.getAccessoryPath() %>"><%="附件"+index+StringUtil.fileExtensions(accessory.getAccessoryPath())%></a>
              	<input type="hidden" name="firstAccessoryList[<%=index-1%>].accessoryPath" value="<%=accessory.getAccessoryPath() %>">
             </td>
          	<%} else{ %>
          	<td>
				<input type="file" name="<%=accessory.getRequest_name() %>" class="text1" size="40"/>          	
          	</td>
          	<%} %>
          	<th>附件<%=index%>到期日期：</th>
          	<td>
          		<input type="text" name="firstAccessoryList[<%=index-1%>].accessoryDate" class="easyui-datebox" data-options="required:true" size="40" value="<%=accessory.getAccessoryDate() %>"/>
          	</td>
          	<td>
          		<input type="hidden" name="firstAccessoryList[<%=index-1%>].request_name" value="<%=accessory.getRequest_name() %>">
          		<input type="hidden" name="firstAccessoryList[<%=index-1%>].accssoryId" value="<%=accessory.getAccssoryId() %>">
          	</td>
          </tr>
          <%
          	}
           %>
           --%>
           <tr >
          	<td colspan="2" align="center" valign="top"><input name="" type="button" class="btn_big1" value="新增GSP/GMP" onclick="addGSPAccessory()"/></td>
          	<td colspan="2" align="center" valign="top"><input name="" type="button" class="btn_big1" value="新增其它证件" onclick="addOtherPAccessory()"/></td>
          </tr>
        </table>
        <table id ="add_dttachment" class="xx_table2">
         <%
          		Iterator<FirstEnterpriseAccessory> it = accessorySet.iterator();
          		int index = 0;
          		while(it.hasNext()){
          			FirstEnterpriseAccessory accessory = it.next();
          			
          %>
         
          <%if(accessory.getRequest_type().equals("GSP")) {%>
           <tr>
          	<th>GSP/GMP证书号码<span class="required">*</span>：</th>
          	<td><input type='text' name='firstAccessoryList[<%=index %>].certificateNumber' class='easyui-validatebox text1' data-options="required:true" size='20' value="<%=accessory.getCertificateNumber() %>"/></td>
          	<th>GSP/GMP证书到期时间<span class="required">*</span>：</th>
          	<td>
          		<input type="text" name="firstAccessoryList[<%=index%>].accessoryDate" class="easyui-datebox" data-options="required:true" size="20" style="height: 28px;" value="<%=accessory.getAccessoryDate() %>"/>
          	</td>
          	<% if(StringUtil.isNull(accessory.getAccessoryPath())){ %>
          	<td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=<%=accessory.getAccessoryPath() %>"><%="GSP/GMP证书附件"+StringUtil.fileExtensions(accessory.getAccessoryPath())%></a>
              	<input type="hidden" name="firstAccessoryList[<%=index%>].accessoryPath" value="<%=accessory.getAccessoryPath() %>">
             </td>
          	<%} else{ %>
          	<td>
				<input type='file' name='<%=accessory.getRequest_name() %>' class='text1' size='20'/>          	
          	</td>
          	<%} %>
          	
          	<td>
          		<input type="hidden" name="firstAccessoryList[<%=index%>].request_name" value="<%=accessory.getRequest_name() %>">
          		<input type="hidden" name="firstAccessoryList[<%=index%>].request_type" value="<%=accessory.getRequest_type() %>">
          		<input type="hidden" name="firstAccessoryList[<%=index%>].accssoryId" value="<%=accessory.getAccssoryId() %>">
          	</td>
          </tr>
          <%
          	}else{
          	
           %>
           <tr>
           <th>证书号码<span class="required">*</span>：</th>
          	<td><input type='text' name='firstAccessoryList[<%=index %>].certificateNumber' class='easyui-validatebox text1' data-options='required:true' size='20' value="<%=accessory.getCertificateNumber() %>"/></td>
          	<th>证书到期时间<span class="required">*</span>：</th>
          	<td>
          		<input type="text" name="firstAccessoryList[<%=index%>].accessoryDate" class="easyui-datebox" data-options="required:true" size="20" style="height: 28px;" value="<%=accessory.getAccessoryDate() %>"/>
          	</td>
          	<% if(StringUtil.isNull(accessory.getAccessoryPath())){ %>
          	<td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=<%=accessory.getAccessoryPath() %>"><%="证书附件"+StringUtil.fileExtensions(accessory.getAccessoryPath())%></a>
              	<input type="hidden" name="firstAccessoryList[<%=index%>].accessoryPath" value="<%=accessory.getAccessoryPath() %>">
            </td>
          	<%} else{ %>
          	<td>
				<input type='file' name='<%=accessory.getRequest_name() %>' class='text1' size='20'/>         	
          	</td>
          	<%} %>
          	
          	<td>
          		<input type="hidden" name="firstAccessoryList[<%=index%>].request_name" value="<%=accessory.getRequest_name() %>">
          		<input type="hidden" name="firstAccessoryList[<%=index%>].request_type" value="<%=accessory.getRequest_type() %>">
          		<input type="hidden" name="firstAccessoryList[<%=index%>].accssoryId" value="<%=accessory.getAccssoryId() %>">
          	</td>
          </tr>
         <%}index++; }%>
        </table>
        <table border="0" cellspacing="0" cellpadding="0" class="xx_table2">
        	<tr height="80">
            <td colspan="4" align="center" valign="bottom">
           		<input type="hidden" id="save_type" name="save_type" value=""/>
				<input type="hidden" id="id" name="id" value="${enterprise.id}"/>
				<input type="hidden" id="sales_deputy" name="sales_deputy" value="${enterprise.sales_deputy.id }">
                <input name="" type="button" class="btn_big" value="保存" onclick="save_syqy(0)"/>
                <input name="" type="button" class="btn_big" value="提交" onclick="save_syqy(1)"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	<script type="text/javascript">
	$("#commonnamebox").combobox({
			filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q.toUpperCase()) == 0;
			},
			value:(""+'${enterprise.sales_deputy.pinyinCode}'+"_"+'${enterprise.sales_deputy.id}').toUpperCase()
		}
		
	)
		function save_syqy(value){
			$("#save_type").val(value);
			$('#edit_syqy').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="syqydlr.html";
			    }  
			});  
		}
		function deleteFile(id,fileName,type){
			$.post("deltefile.html",{
				id : id,
				fileName : fileName,
				type : type
			},function(data){
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI(json.success));
				}
				location.reload();
			});
		}
		setDefaultForCheckbox("economic_nature","${enterprise.economic_nature}");
		var attachment_index  = "${accssorySize}";
		//alert(attachment_index);
		function addGSPAccessory(){
		var tr ="<tr><th width='150'>GSP/GMP证书号码 <span class='required'>*</span>：</th>"+
			"<td><input type='text' name='firstAccessoryList["+attachment_index+"].certificateNumber' class='easyui-validatebox text1' data-options='required:true' size='20'/></td>"+
			"<th width='150'>GSP/GMP证书到期时间<span class='required'>*</span>：</th>"+
			"<td><input type='text' id='accsoryCombox_id"+attachment_index+"' name='firstAccessoryList["+attachment_index+"].accessoryDate' class='easyui-datebox text1' style='height: 28px;' data-options='required:true' size='20'/></td>"+
			"<th width='150'>GSP/GMP证书附件</th>"+
			"<td><input type='file' name='request_name"+attachment_index+"' class='text1' size='20'/></td><td><input type='button' class='btn_big' value='删除' onclick='deleteAccssory(this)'>"+
			"<input type='hidden' name='firstAccessoryList["+attachment_index+"].request_name' value='request_name"+attachment_index+"'/>"+
			"<input type='hidden' name='firstAccessoryList["+attachment_index+"].request_type' value='GSP'/> </td></tr>";
			$("#add_dttachment").append(tr);
			$.parser.parse($('#accsoryCombox_id'+attachment_index).parent()); 
			attachment_index++;
	}
	function addOtherPAccessory(){
		var tr ="<tr><th width='150'>证书号码 <span class='required'>*</span>：</th>"+
			"<td><input type='text' name='firstAccessoryList["+attachment_index+"].certificateNumber' class='easyui-validatebox text1' data-options='required:true' size='20'/></td>"+
			"<th width='150'>证书到期时间<span class='required'>*</span>：</th>"+
			"<td><input type='text' id='accsoryOtherCombox_id"+attachment_index+"' name='firstAccessoryList["+attachment_index+"].accessoryDate' class='easyui-datebox text1' style='height: 28px;' data-options='required:true' size='20'/></td>"+
			"<th width='150'>证书附件</th>"+
			"<td><input type='file' name='request_name"+attachment_index+"' class='text1' size='20'/></td><td><input type='button' class='btn_big' value='删除' onclick='deleteAccssory(this)'>"+
			"<input type='hidden' name='firstAccessoryList["+attachment_index+"].request_name' value='request_name"+attachment_index+"'/>"+
			"<input type='hidden' name='firstAccessoryList["+attachment_index+"].request_type' value='other'/></td></tr>";
			$("#add_dttachment").append(tr);
			$.parser.parse($('#accsoryOtherCombox_id'+attachment_index).parent()); 
			attachment_index++;
	}
	
	function deleteAccssory(obj){
		$(obj).parent().parent().remove();
	}
	</script>
</body>
</html>