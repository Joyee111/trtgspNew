<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
	<%@ page import="com.sinosoft.util.StringUtil"%>
	<%@ page
		import="com.sinosoft.enterpriseManage.firstEnterprise.model.PurchaseUnit"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
PurchaseUnit purchaseUnit = (PurchaseUnit)request.getAttribute("purchaseUnit");
%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>修改购货单位</title>
		</head>
		<body>
			&nbsp;
			<font
				style="font-family: '宋体'; font-weight: normal; font-size: 12; color: #8d3c01; padding: 10px;">企业资质管理&nbsp;&gt;&nbsp;购货单位&nbsp;&gt;&nbsp;购货单位修改</font>
			<table width="70%" border="0" cellspacing="0" cellpadding="0"
				class="lch">
				<tr height="89">
					<td align="left" width="5">
						<img src="../images/lch_l.gif" />
					</td>
					<td valign="top" align="center" width="20%">
						<span>1</span>
						<br />
						开始
					</td>
					<td valign="top" align="center" width="20%">
						<span class="ok">2</span>
						<br />
						已保存
					</td>
					<td valign="top" align="center" width="20%">
						<span>3</span>
						<br />
						审核
					</td>
					<td valign="top" align="center" width="20%">
						<span>4</span>
						<br />
						已驳回
					</td>
					<td valign="top" align="center" width="20%">
						<span>5</span>
						<br />
						审核通过
					</td>
					<td align="right" width="5">
						<img src="../images/lch_r.gif" />
					</td>
				</tr>
			</table>
			<form action="update_ghdwdlr.html" name="update_ghdwdlr"
				id="update_ghdwdlr" method="post" enctype="multipart/form-data">
				<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
					<tr>
						<th>
							省份
							<span class="required">*</span>：
						</th>
						<td>
							<select name="shengfen" class="easyui-validatebox"
								data-options="required:true" onchange="changeNumber(this)"
								id="shengfen">
								<option value="">
									请选择
								</option>
							</select>
							<input value="${quamap}" type="hidden" id="quamap" />
							<input type="hidden" value="${shengfenValue}" id="shengfenValue" />
						</td>
						<th>
							客户编号
							<span class="required">*</span>：
						</th>
						<td>
							<input name="customerNumber" id="customerNumber" type="text"
								class="easyui-validatebox text1"
								data-options="required:true,validType:'checkNumber'"
								maxlength="20" size="40" value="${purchaseUnit.customerNumber}" />
						</td>
					</tr>
					<tr>
						<th width="150">
							企业名称
							<span class="required">*</span>：
						</th>
						<td>
							<input name="companyName" type="text"
								class="easyui-validatebox text1" data-options="required:true"
								size="40" value="${purchaseUnit.companyName}"
								onchange="ajaxChanggeChinaToPinyin(this,'pinyinCode')" />
						</td>
						<th width="150">
							法定代表人/负责人
							<span class="required">*</span>：
						</th>
						<td>
							<input name="corporation" type="text"
								class="easyui-validatebox text1"
								data-options="required:true,validType:['checkChina','length[2,10]']"
								size="40" value="${purchaseUnit.corporation}" />
						</td>
					</tr>
					<tr>
						<th>
							企业地址
							<span class="required">*</span>：
						</th>
						<td>
							<input name="address" type="text"
								class="easyui-validatebox text1" data-options="required:true"
								size="40" value="${purchaseUnit.address}" />
						</td>
						<th>
							邮 编
							<span class="required">*</span>：
						</th>
						<td>
							<input name="postalCode" type="text"
								class="easyui-validatebox text1"
								data-options="required:true,validType:'checkPostCode'" size="40"
								value="${purchaseUnit.postalCode}" />
						</td>
					</tr>
					<tr>
						<th>
							企业联系电话：
						</th>
						<td>
							<input name="companyPhone" type="text"
								class="easyui-validatebox text1" data-options="required:false"
								size="40" value="${purchaseUnit.compantPhone}" />
						</td>
						<th>
							企业经营类型：
						</th>
						<td>
							<select name="economicNature" id="economicNature">
								<option value="1">
									批发
								</option>
								<option value="2">
									零售
								</option>
								<option value="3">
									零售（连锁）
								</option>
								<option value="4">
									医疗机构
								</option>
								<option value="5">
									其他
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>
							采购人员
							<span class="required">*</span>：
						</th>
						<td>
						<input type="text" class="easyui-validatebox text1 " readonly="true" name="" id="procurement_staff_name" 
								data-options="required:true,validType:'checkChina'"  value="${purchaseUnit.procurementStaff.procurementName }" size="28" />
							<input name="" type="button" onclick="openCgry(0)" class="btn_small" value="选择">
							
						</td>

						<th>
							联系电话
							<span class="required">*</span>：
						</th>
						<td>
							<input name="phone" type="text" class="easyui-validatebox text1"
								data-options="required:true" size="40"
								value="${purchaseUnit.phone}" />
						</td>
					</tr>
					<tr>
						<th>
							质量负责人
							<span class="required">*</span>：
						</th>
						<td>
							<input name="qualityPrincipal" type="text"
								class="easyui-validatebox text1"
								data-options="required:true,validType:['checkChina','length[2,10]']"
								size="40" value="${purchaseUnit.qualityPrincipal}" />
						</td>
						<!-- 
            <th>十位码<span class="required">*</span>：</th>
            <td><input name="tenBitCode" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkTenCode'" size="40" value="${purchaseUnit.tenBitCode}"/></td>
            --->
						<th>
							拼音码
							<span class="required">*</span>：
						</th>
						<td>
							<input name="pinyinCode" id="pinyinCode" type="text"
								class="easyui-validatebox text1" data-options="required:true"
								size="40" value="${purchaseUnit.pinyinCode}" />
						</td>
					</tr>
					<tr>
						<th>
							传&nbsp;真
							<span class="required">*</span>：
						</th>
						<td>
							<input name="portraiture" type="text"
								class="easyui-validatebox text1" data-options="required:true"
								size="40" value="${purchaseUnit.portraiture}" />
						</td>
						<th>
							经营/生产/医疗机构许可证号：
						</th>
						<td>
							<input name="licenseNo" type="text"
								class="easyui-validatebox text1" data-options="required:false"
								size="40" value="${purchaseUnit.licenseNo}" />
						</td>
					</tr>
					<tr>
						<th>
							营业执照号：
						</th>
						<td>
							<input name="businessLicenseNo" type="text"
								class="easyui-validatebox text1" data-options="required:false"
								size="40" value="${purchaseUnit.businessLicenseNo}" />
						</td>
						<th>
							GSP/GMP认证证书号码：
						</th>
						<td>
							<input name="certificateNo" type="text"
								class="easyui-validatebox text1" data-options="required:false"
								size="40" value="${purchaseUnit.certificateNo}" />
						</td>
					</tr>
					<tr>
						<th>
							纳税人登记号
							<span class="required">*</span>：
						</th>
						<td>
							<input name="taxpayerRegisterNo" type="text"
								class="easyui-validatebox text1"
								data-options="required:true,validType:'checkCertificate'"
								size="40" value="${purchaseUnit.taxpayerRegisterNo}" />
						</td>
						<th>
							开户银行
							<span class="required">*</span>：
						</th>
						<td>
							<input name="bankName" type="text"
								class="easyui-validatebox text1" data-options="required:true"
								size="40" value="${purchaseUnit.bankName}" />
						</td>
					</tr>
					<tr>
						<th>
							开户银行账号
							<span class="required">*</span>：
						</th>
						<td>
							<input name="bankNumber" type="text"
								class="easyui-validatebox text1" data-options="required:true"
								size="40" value="${purchaseUnit.bankNumber}" />
						</td>
						<th>
							开户日期：
						</th>
						<td>
							<input name="accountOpeningDate" type="text"
								class="easyui-datebox text1"
								data-options="required:true,validType:'date'" size="40"
								value="${purchaseUnit.accountOpeningDate}" />
						</td>
					</tr>

					<tr>
						<th>
							税票信息地址
							<span class="required">*</span>：
						</th>
						<td>
							<input name="taxReceiptAddress"
								value="${purchaseUnit.taxReceiptAddress }" type="text"
								class="easyui-validatebox text1" data-options="required:true"
								size="40" />
						</td>
						<th>
							税票信息电话
							<span class="required">*</span>：
						</th>
						<td>
							<input name="taxReceiptPhone"
								value="${purchaseUnit.taxReceiptPhone }" type="text"
								class="easyui-validatebox text1" data-options="required:true"
								size="40" />
						</td>
					</tr>
					<tr>
						<th>
							发货地址
							<span class="required">*</span>：
						</th>
						<td>
							<input name="shippingAddress"
								value="${purchaseUnit.shippingAddress}" type="text"
								class="easyui-validatebox text1" data-options="required:true"
								size="40" />
						</td>
						<th>
							收货人
							<span class="required">*</span>：
						</th>
						<td>
							<input name="consigneeName"
								value="${purchaseUnit.consigneeName }" type="text"
								class="easyui-validatebox text1" data-options="required:true"
								size="40" />
						</td>
					</tr>
					<tr>
						<th>
							收货人电话
							<span class="required">*</span>：
						</th>
						<td>
							<input name="consigneePhone"
								value="${purchaseUnit.consigneePhone }" type="text"
								class="easyui-validatebox text1" data-options="required:true"
								size="40" />
						</td>
						<th>
							客户电子监管码
							<span ></span>：
						</th>
						<td>
							<input name="electronicMonitoringCode"
								value="${purchaseUnit.electronicMonitoringCode }" type="text"
								class="easyui-validatebox text1" data-options=""
								size="40" />
						</td>
					</tr>
					<tr>
						<th>
							提货人员:
						</th>
						<td>
							<input type="text" class="easyui-validatebox text1" readonly="true" name="" id="procurement_staff_name1" 
								   value="${purchaseUnit.procurementReceiving.procurementName}" size="28" />
							<input name="" type="button" onclick="openCgry(1)" class="btn_small" value="选择">
						</td>
						<th>企业年度信息报告到期时间<span class="required">*</span>：</th>
			            <td>
			            	<input type="text" name="businessLicenseInspectionDate" class="easyui-datebox" data-options="required:true,validType:'date'" size="40" value="${purchaseUnit.businessLicenseInspectionDate}"/>
			            </td>
					</tr>
					<tr>
						<th valign="top">
							生产/经营范围
							<span class="required">*</span>：
						</th>
						<td colspan="3">
							<textarea id="businessScope" name="businessScope" cols="94"
								rows="4" class="easyui-validatebox textarea" readonly="readonly"
								data-options="required:true">${purchaseUnit.businessScope}</textarea>
						</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td align="right">
							<input name="" type="button"
								onclick="$('#businessScope_div').dialog('open')"
								class="btn_small" value="选择" />
						</td>
					</tr>
					<tr>
						<th valign="top">
							申请原因
							<span class="required">*</span>：
						</th>
						<td colspan="3">
							<textarea name="applyCause" cols="94" rows="4"
								class="easyui-validatebox textarea"
								data-options="required:true,validType:'checkChina'">${purchaseUnit.applyCause}</textarea>
						</td>
					</tr>
					<tr>
						<th valign="top">
							备注：
						</th>
						<td colspan="3">
							<textarea name="remark" cols="94" rows="4" class="textarea">${purchaseUnit.remark }</textarea>
						</td>
					</tr>
					<tr>
						<th width="150">
							销售类别：
						</th>
						<td>
							<input type="checkbox" name="saleCompany" id="returnType1"
								value="1" />
							<font style="font-size: 12px; color: #727171; font-weight: bold;">经营</font>
							<input type="checkbox" name="saleCompany" id="returnType2"
								value="2" />
							<font style="font-size: 12px; color: #727171; font-weight: bold;">新品</font>
							<input type="checkbox" name="saleCompany" id="returnType3"
								value="3" />
							<font style="font-size: 12px; color: #727171; font-weight: bold;">市场</font>
							<input type="hidden" id="saleCompanyValue"
								value="${purchaseUnit.saleCompany}" />
						</td>
						<th>
							开户公司
							<span class="required">*</span>：
						</th>
						<td>
							<select name="openCompay" id="openCompay"
								class="easyui-validatebox text1">
								<option value="">
									请选择开户公司
								</option>
								<option value="0">
									经营
								</option>
								<option value="1">
									新品
								</option>
								<option value="2">
									市场
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>
							营业执照：
						</th>
						<% if(StringUtil.isNull(purchaseUnit.getBusinessLicencePath())){ %>
						<td>
							<img src="../images/pdf.gif" />
							<a
								href="../download.html?fileName=${purchaseUnit.businessLicencePath}"><%=purchaseUnit.getCompanyName()+"营业执照"+StringUtil.fileExtensions(purchaseUnit.getBusinessLicencePath())%></a>
							<input name="" type="button" class="btn_small" value="删除"
								onclick="deleteFile('${purchaseUnit.id}','${purchaseUnit.businessLicencePath }','yyzz')" />
						</td>
						<%}else{ %>
						<td>
							<input name="businessLicencePath" type="file"
								class="easyui-validatebox text1" size="40" />
						</td>
						<%} %>
						<th>
							营业执照到期时间
							<span class="required">*</span>：
						</th>
						<td>
							<input type="text" name="businessLicenceDate"
								class="easyui-datebox"
								data-options="required:true,validType:'date'" size="40"
								value="${purchaseUnit.businessLicenceDate }" />
						</td>
					</tr>
					<%--  <tr>
            <th>营业执照年检：</th>
            <% if(StringUtil.isNull(purchaseUnit.getBusinessLicenseInspectionPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${purchaseUnit.businessLicenseInspectionPath}"><%=purchaseUnit.getCompanyName()+"营业执照年检"+StringUtil.fileExtensions(purchaseUnit.getBusinessLicenseInspectionPath())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${purchaseUnit.id}','${purchaseUnit.businessLicenseInspectionPath }','yyzznj')"/>
           </td>
           <%}else{ %>
             <td><input name="businessLicenseInspectionPath" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
            <th>营业执照年检时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="businessLicenseInspectionDate" class="easyui-datebox" data-options="required:true,validType:'date'" size="40" value="${purchaseUnit.businessLicenseInspectionDate}"/>
            </td>
          </tr>--%>

					<tr>
						<th>
							经营/生产许可证：
						</th>
						<% if(StringUtil.isNull(purchaseUnit.getLicencePath())){ %>
						<td>
							<img src="../images/pdf.gif" />
							<a href="../download.html?fileName=${purchaseUnit.licencePath}"><%=purchaseUnit.getCompanyName()+"经营/生产许可证"+StringUtil.fileExtensions(purchaseUnit.getLicencePath())%></a>
							<input name="" type="button" class="btn_small" value="删除"
								onclick="deleteFile('${purchaseUnit.id}','${purchaseUnit.licencePath }','xkz')" />
						</td>
						<%}else{ %>
						<td>
							<input name="licencePath" type="file"
								class="easyui-validatebox text1" size="40" />
						</td>
						<%} %>
						<th>
							经营/生产许可证到期时间
							<span class="required">*</span>：
						</th>
						<td>
							<input type="text" name="licenceDate" class="easyui-datebox"
								size="40" data-options="required:true,validType:'date'"
								value="${purchaseUnit.licenceDate}" />
						</td>
					</tr>

					<tr>
						<th>
							GSP/GMP证书：
						</th>
						<% if(StringUtil.isNull(purchaseUnit.getGspCertificatePath())){ %>
						<td>
							<img src="../images/pdf.gif" />
							<a
								href="../download.html?fileName=${purchaseUnit.gspCertificatePath}"><%=purchaseUnit.getCompanyName()+"GSP/GMP证书"+StringUtil.fileExtensions(purchaseUnit.getGspCertificatePath())%></a>
							<input name="" type="button" class="btn_small" value="删除"
								onclick="deleteFile('${purchaseUnit.id}','${purchaseUnit.gspCertificatePath }','gspzs')" />
						</td>
						<%}else{ %>
						<td>
							<input name="gspCertificatePath" type="file"
								class="easyui-validatebox text1" size="40" />
						</td>
						<%} %>
						<th>
							GSP/GMP证书截止日期
							<span class="required">*</span>：
						</th>
						<td>
							<input type="text" name="gspCertificateDate"
								class="easyui-datebox" size="40"
								data-options="required:true,validType:'date'"
								value="${purchaseUnit.gspCertificateDate}" />
						</td>
					</tr>
					<tr>
						<th>
							组织机构代码证：
						</th>
						<% if(StringUtil.isNull(purchaseUnit.getOrganizationCodePath())){ %>
						<td>
							<img src="../images/pdf.gif" />
							<a
								href="../download.html?fileName=${purchaseUnit.organizationCodePath}"><%=purchaseUnit.getCompanyName()+"组织机构代码证"+StringUtil.fileExtensions(purchaseUnit.getOrganizationCodePath())%></a>
							<input name="" type="button" class="btn_small" value="删除"
								onclick="deleteFile('${purchaseUnit.id}','${purchaseUnit.organizationCodePath}','zzjgdm')" />
						</td>
						<%}else{ %>
						<td>
							<input name="organizationCodePath" type="file"
								class="easyui-validatebox text1" size="40" />
						</td>
						<%} %>
						<th>
							组织机构代码到期时间
							<span class="required">*</span>：
						</th>
						<td>
							<input type="text" name="organizationCodeDate"
								class="easyui-datebox" size="40"
								data-options="required:true,validType:'date'"
								value="${purchaseUnit.organizationCodeDate}" />
						</td>
					</tr>
					<tr>
						<th>
							组织机构代码证年检：
						</th>
						<% if(StringUtil.isNull(purchaseUnit.getOrganizationCodeInspectionPath())){ %>
						<td>
							<img src="../images/pdf.gif" />
							<a
								href="../download.html?fileName=${purchaseUnit.organizationCodeInspectionPath}"><%=purchaseUnit.getCompanyName()+"组织机构代码证年检"+StringUtil.fileExtensions(purchaseUnit.getOrganizationCodeInspectionPath())%></a>
							<input name="" type="button" class="btn_small" value="删除"
								onclick="deleteFile('${purchaseUnit.id}','${purchaseUnit.organizationCodeInspectionPath }','zzjgdmnj')" />
						</td>
						<%}else{ %>
						<td>
							<input name="organizationCodeInspectionPath" type="file"
								class="easyui-validatebox text1" size="40" />
						</td>
						<%} %>
						<th>
							组织机构代码年检时间
							<span class="required">*</span>：
						</th>
						<td>
							<input type="text" name="organizationCodeInspectionDate"
								class="easyui-datebox" size="40"
								data-options="required:true,validType:'date'"
								value="${purchaseUnit.organizationCodeInspectionDate}" />
						</td>
					</tr>
					<tr>
						<th>
							质量保证协议：
						</th>
						<% if(StringUtil.isNull(purchaseUnit.getQualityAssurancePath())){ %>
						<td>
							<img src="../images/pdf.gif" />
							<a
								href="../download.html?fileName=${purchaseUnit.qualityAssurancePath}"><%=purchaseUnit.getCompanyName()+"质量保证协议"+StringUtil.fileExtensions(purchaseUnit.getQualityAssurancePath())%></a>
							<input name="" type="button" class="btn_small" value="删除"
								onclick="deleteFile('${purchaseUnit.id}','${purchaseUnit.qualityAssurancePath }','zlbzxy')" />
						</td>
						<%}else{ %>
						<td>
							<input name="qualityAssurancePath" type="file"
								class="easyui-validatebox text1" size="40" />
						</td>
						<%} %>
						<th>
							质量保证书到期时间
							<span class="required">*</span>：
						</th>
						<td>
							<input type="text" name="qualityAssuranceDate"
								class="easyui-datebox" size="40"
								data-options="required:true,validType:'date'"
								value="${purchaseUnit.qualityAssuranceDate}" />
						</td>
					</tr>
					<tr>
						<th>
							法人委托书：
						</th>
						<% if(StringUtil.isNull(purchaseUnit.getAuthorizationPath())){ %>
						<td>
							<img src="../images/pdf.gif" />
							<a
								href="../download.html?fileName=${purchaseUnit.authorizationPath}"><%=purchaseUnit.getCompanyName()+"法人委托书"+StringUtil.fileExtensions(purchaseUnit.getAuthorizationPath())%></a>
							<input name="" type="button" class="btn_small" value="删除"
								onclick="deleteFile('${purchaseUnit.id}','${purchaseUnit.authorizationPath}','wtsqs')" />
						</td>
						<%}else{ %>
						<td>
							<input name=authorizationPath type="file"
								class="easyui-validatebox text1" size="40" />
						</td>
						<%} %>
						<th>
							法人委托书到期时间
							<span class="required">*</span>：
						</th>
						<td>
							<input type="text" name="authorizationDate"
								class="easyui-datebox" size="40"
								data-options="required:true,validType:'date'"
								value="${purchaseUnit.authorizationDate}" />
						</td>
					</tr>
					<%-- 
           <tr>
            <th>证明材料：</th>
             <% if(StringUtil.isNull(purchaseUnit.getDocumentEvidencePath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${purchaseUnit.documentEvidencePath}"><%=purchaseUnit.getCompanyName()+"营业执照"+StringUtil.fileExtensions(purchaseUnit.getDocumentEvidencePath())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${purchaseUnit.id}','${purchaseUnit.documentEvidencePath }','zmcl')"/>
           </td>
           <%}else{ %>
             <td><input name="documentEvidencePath" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
            <th>证明材料到期日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="documentEvidenceDate" size="40" class="easyui-datebox" required="required" value="${purchaseUnit.documentEvidenceDate}"/>
            </td>
          </tr>--%>
					<tr>
						<c:choose>
							<c:when test="${dateDisableFlag eq 'true'}">
								<th>
									旧客户编号
									<span class="required">*</span>：
								</th>
								<td>
									<span id="oldNumber"></span>
								</td>
								<input type="hidden" id="oldNo" value="${purchaseUnit.oldNo}" />
							</c:when>
						</c:choose>


					</tr>
					<tr height="80">
						<td colspan="4" align="center" valign="bottom">
							<input type="hidden" id="save_type" name="save_type" value="" />
							<input type="hidden" id="id" name="id" value="${purchaseUnit.id}" />
							<input type="hidden" id="procurement_staff"
								name="procurement_staff" value="${purchaseUnit.procurementStaff.id}" />
							<input type="hidden" id="procurement_staff1"
								name="procurement_staff1" value="${purchaseUnit.procurementReceiving.id}" />
							<input type="hidden" id="receivingPerson" name="receivingPerson"
								value="${purchaseUnit.receivingPerson }">
							<c:choose>
								<c:when test="${dateDisableFlag eq 'true'}">
									<input name="" type="button" class="btn_big" value="新增旧编号"
										onclick="find()" />
								</c:when>
							</c:choose>

							<input name="" type="button" class="btn_big" value="保存"
								onclick="update_syqy(0)" />
							<input name="" type="button" class="btn_big" value="提交"
								onclick="update_syqy(1)" />
							<input name="" type="button" class="btn_big" value="取消"
								onclick="goBack()" />
						</td>
				</table>
				<div id="businessScope_div" title="选择生产/经营范围" class="easyui-dialog"
					style="width: 800px; height: 200px; padding: 10px; margin-top: 20px;"
					data-options="closed:true,modal:false,top:520">
					<ul style="padding: 10px 25px;">
						<c:forEach items="${drugFromList}" var="list" varStatus="status">
							<li>
								<div style="float: left; padding: 4px;">
									<input type="checkbox" id="drugFromItem" name="drugFromItem"
										value="${list}" />
									${list}
								</div>
							</li>
						</c:forEach>
					</ul>
					<table>
						<tr>
							<td colspan="4" align="center" valign="bottom">
								<input type="button" class="btn_big" onclick="updateScope()"
									value="确定">
								<input type="button" class="btn_big"
									onclick="$('#businessScope_div').dialog('close')" value="取消">
						</tr>
					</table>
				</div>
			</form>
			<div id="procurementStaff_0_dlg" title="" class="easyui-dialog"
					style="width: 820px; height: 430px; padding: 10px; margin-top: 20px;"
					data-options="closed:true,modal:true,top:520">
					<form action="${ctx}/firstEnterprise/saveProcurementStaff.html" title="" id="add_xsry" method="post" enctype="multipart/form-data">
						<table id="tab_procurementStaff_0" title="" border="0" cellspacing="0" cellpadding="0" class="xx_table">
							<tr>
								<th width="150">
									姓名
									<span class="required">*</span>：
								</th>
								<td id="procurementName">
									<input type="text" class="easyui-combobox  text1"
									data-options="
							            required:true,
							            validType:'checkChina',
							      	 	valueField: 'id',
							       		textField: 'text',
							      		onSelect : function(record){
							      			var select = $('#ps_name').combobox('getValue')
							      			//alert(select);
											$($('#ps_name').combobox('getData')).each(function(i,e){
												if(e.id == select){
													$('#ps_pinyinCode').val(Pinyin.GetJP(e.text).toUpperCase())
													return false;
												}
											})
							      			var id = record.id;
							      			var personType = $('#personType').val();
							      			if(personType==0){
							      				$('#procurement_staff').val(id);
							      				$('#procurement_staff_name').val($(this).combobox('textbox').val())
							      			}
							      			if(personType==1){
							      				$('#procurement_staff1').val(id);
							      				$('#procurement_staff_name1').val($(this).combobox('textbox').val())
							      				
							      			}
							      			find_cgry(id);
							      		}"
									name="ps_name" id="ps_name" size="40" />
									
									
								<input name="" type="button" onclick="createNew()" class="btn_small" value="新增" />
								</td>
								
								<th width="150">
									性别：
								</th>
								<td>
									<select name="gender" id="gender"
										class="easyui-validatebox text1" data-options="required:false">
										<option value="">
											请选择性别
										</option>
										<option value="0">
											男
										</option>
										<option value="1">
											女
										</option>
										<option value="2">
											未知
										</option>
									</select>
								</td>
							</tr>
							
							<tr>
								<th>
									拼音码：
								</th>
								<td>
									<input name="ps_pinyinCode" id="ps_pinyinCode" type="text"
										class="easyui-validatebox text1" data-options="required:false"
										size="40" />
								</td>
								<th>
									身份证号<span class="required">*</span>：
								</th>
								<td>
									<input name="IDNumber" type="text" id="IDNumber"
										class="easyui-validatebox text1"
										data-options="required:true,validType:'idcard'" size="40" />
								</td>
							</tr>
							<tr>
								<th>
									法人委托书：
								</th>
					           <td id="powerOfAttorney">
					           		<input name="powerOfAttorney" type="file" class="easyui-validatebox text1" size="40" />
					           </td>
					           <th>
									法人委托书到期日期<span class="required">*</span>：
								</th>
								<td>
									<input type="text" name="powerOfAttorneyDate" id="powerOfAttorneyDate"
										class="easyui-datebox text1"
										data-options="required:true,validType:'date'"
										style="height: 28px;" size="40" />
								</td>
							</tr>
							<tr>
								<th>
									身份证复印件：
								</th>
								<td id="identityCard">
									<input name="identityCard" type="file" class="easyui-validatebox text1" size="40" />
						        </td>
								<th>
									身份证有效期：
								</th>
								<td>
									<input type="text" name="identityCardDate" id="identityCardDate"
										class="easyui-datebox text1"
										data-options="required:false,validType:'date'"
										style="height: 28px;" size="40" />
								</td>
							</tr>
							<tr>
								<td>
									<input type="hidden" name="personType" id="personType" value=""/>
									<input type="hidden" name="type" id="type" value="1"/>
								</td>
								
							</tr>
							
							<tr height="80">
								<td colspan="4" align="center" valign="bottom">
									<input name="" type="button" class="btn_big" value="保存"
										onclick="pSSaveOrUpdate()" />
									<input name="" type="button" class="btn_big" value="取消"
										onclick="$('#procurementStaff_0_dlg').dialog('close')" />
								</td>
							</tr>
						</table>
						</form>
				</div>
				
			<script type="text/javascript">
		$(function(){
		$('#ps_name').combobox('textbox').blur(function(){
			$('#ps_pinyinCode').val(Pinyin.GetJP(this.value).toUpperCase());
			var personType = $("#personType").val();
			if(personType==0){
				$('#procurement_staff_name').val(this.value);
			}
			if(personType==1){
				$('#procurement_staff_name1').val(this.value);
			}
		})
	})
	var s=0;
	function find(){
	var oldNumber="oldNumber"+s;
	var deloldNumber="deloldNumber"+s;
		$("#oldNumber").append("<input type='text' class='text1'  id=\""+oldNumber+"\"  size='35' name='oldNumber'/>&nbsp;&nbsp;<select class='text1' onchange='appendToOldNumber(this)' ><option value=''>请选择编码类别</option><option value='1001'>经营</option><option value='2001'>新品</option><option value='3001'>市场</option></select>");
		$("#oldNumber").append("<input type='button' id=\""+deloldNumber+"\" value='删除' onclick=\"del("+s+")\" name='oldNumber' class='btn_big'/><br>");
	s++;
	}
	function del(vals){
		$("#oldNumber"+vals).next().remove();
		$("#oldNumber"+vals).remove();
		$("#deloldNumber"+vals).remove();
		s--;
	}
		function appendToOldNumber(object){
		var prvValue = $(object).prev().val();
		//alert(prvValue);
		if(prvValue==null || prvValue==""){
			alert("请先填写编码信息！");
			return;
		}
		var selectValue = $(object).val();
		//alert(selectValue);
		if(!prvValue.indexOf("/")){
			$(object).prev().val(prvValue+"/"+selectValue);
		}else{
			var str = prvValue.split("/")[0];
			$(object).prev().val(str+"/"+selectValue);
		}
		
	}
	function changeNumber(obj){
		$.post("${ctx}/firstEnterprise/findNumber.html",{
		"number" : obj.value,
		},function(data){
		if(data){
			$("#customerNumber").val(data);
			}
		});
	}
	$("#commonnamebox").combobox({
			filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q.toUpperCase()) == 0;
			}//,
			//value:'${purchaseUnit.procurementStaffName}'
			
		}
	);
	$("#commonname_box").combobox({
			filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q.toUpperCase()) == 0;
			},
			value:'${purchaseUnit.receivingPerson}'
			
		}
	);
	$(function() {
		var customerNumber = document.getElementById("shengfen");
		var quamap=$("#quamap").val();
	   	var aa = quamap.substring(1,quamap.length-1);
	   	var f = aa.split(",");
	   	var g ="";
	   	for(var j=0;j<f.length;j++){
    		var e = f[j].split("=");
    		customerNumber.options.add(new Option(trim(e[1]),trim(e[0]))); 
    	}
    	for(var l=0;l<customerNumber.length;l++){
              if($("#shengfenValue").val()==trim(customerNumber.options[l].value.toString())){
                  customerNumber.options[l].selected=true;
              }  
          	}
        var  returnValue=document.getElementById("saleCompanyValue");
     	var  returnType1=document.getElementById("returnType1");
     	var  returnType2=document.getElementById("returnType2");
     	var  returnType3=document.getElementById("returnType3");
     	if(returnValue != null && ""!=returnValue){
     		var a = returnValue.value.split(",");
     		for(var i=0;i<a.length;i++){
     			if(a[i]==returnType1.value){
     				returnType1.checked=true;
     			}
				if(a[i]==returnType2.value){
     				returnType2.checked=true;
     			}
     			if(a[i]==returnType3.value){
     				returnType3.checked=true;
     			}
     		}
     		
     	}
     	var oldNo = document.getElementById("oldNo").value;
     	var b = oldNo.split(",");
     	for(var i =0;i<b.length;i++){
     	var oldNumber="oldNumber"+s;
		var deloldNumber="deloldNumber"+s;
     	$("#oldNumber").append("<input type='text' id=\""+oldNumber+"\" value=\""+b[i]+"\" class='text1' size=35 name='oldNumber'/>&nbsp;&nbsp;&nbsp;<select class='text1' onchange='appendToOldNumber(this)' ><option value=''>请选择编码类别</option><option value='1001'>经营</option><option value='2001'>新品</option><option value='3001'>市场</option></select>");
		$("#oldNumber").append("<input type='button' id=\""+deloldNumber+"\" value='删除' onclick=\"del("+s+")\" name='oldNumber' class='btn_big'/><br>");
     	s++;
     	}
	});
	
		function update_syqy(value){
			
			$("#save_type").val(value);
			//var pru_value=$("#commonnamebox").combobox('getText');
			//$("#procurement_staff").val(pru_value);
			//var tihuiren = $("#commonname_box").combobox('getText');
			//alert(vaule);
			//$("#receivingPerson").val(tihuiren);
			
			$('#update_ghdwdlr').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="ghdwdlr.html";
			    }  
			});  
			
		}
		function deleteFile(id,fileName,type){
			$.post("delteAttachment.html",{
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
		function updateScope(){
			var  dialog = $("#businessScope_div").dialog();
			var value = "";
			var str = dialog.get(0).getElementsByTagName("input");
			var index = 0;
			
			for(var i=0;i<str.length;i++){
			    if(str[i].checked == true){
			        var nodeValue = str[i].nextSibling.nodeValue;
			        nodeValue = nodeValue.substring(0,nodeValue.length - 9).trim() ;
			        value += nodeValue + '，';
			        index ++;
			    }
			}
			value=value.substring(0,value.length-1).trim();
			$("#businessScope").val(value);
		}
		function createNew(){
			var personType = $("#personType").val();
			$("#procurementName").empty();
			$("#procurementName").append(
				$('<input  type="text" name="ps_name" id="ps_name" calss="" data-options="required:true,validType:\'checkChina\'" size="40">').validatebox().blur(function(){                                      
				$("#ps_pinyinCode").val(Pinyin.GetJP(this.value).toUpperCase());
				var personType = $("#personType").val()
				if(personType==0){
					$("#procurement_staff_name").val(this.value)
				}
				if(personType==1){
					$("#procurement_staff_name1").val(this.value)
				}
			}));
			document.getElementById('ps_name').style.cssText="line-height:26px;border: 1px solid #c9caca;vertical-align: middle;";
			//$("#procurementName").append('<input name="" type="button" onclick="createNew()" class="btn_small" value="新增" />');
			cleanProcurementStaff();
			if(personType==1){
				$("#ps_name").validatebox({required:false});
			}
			$("#type").val("0");//新增
			
		}
		function cleanProcurementStaff(){//清空采购人提货人表单
			$("#ps_pinyinCode").val("");
			$("#IDNumber").val("");
			$("#powerOfAttorneyDate").datebox("setValue","");
			$("#identityCardDate").datebox("setValue","");
			$("#gender").val("");
			$("#powerOfAttorney").empty();
			$("#identityCard").empty();
			$("#powerOfAttorney").append(
				"<input name=\"powerOfAttorney\" type=\"file\" class=\"easyui-validatebox text1\" size=\"40\" />"
			);
			$("#identityCard").append(
				"<input name=\"identityCard\" type=\"file\" class=\"easyui-validatebox text1\" size=\"40\" />"
			);
		}
		
		function openCgry(a){
			$("#procurementName").empty();
			cleanProcurementStaff();
			var ps_nameObj = $('<input type="text"  name="ps_name" id="ps_name">')
			$("#procurementName").append(ps_nameObj)
			ps_nameObj.combobox()
			ps_nameObj.combobox({required:true,
		            validType:'checkChina',
		      	 	valueField: 'id',
		       		textField: 'text',
					onSelect : function(record){
		      			var select = $('#ps_name').combobox('getValue')
		      			//alert(select);
						$($('#ps_name').combobox('getData')).each(function(i,e){
							if(e.id == select){
								$('#ps_pinyinCode').val(Pinyin.GetJP(e.text).toUpperCase())
								return false;
							}
						})
		      			var id = record.id;
		      			var personType = $('#personType').val();
		      			if(personType==0){
		      				$('#procurement_staff').val(id);
		      				$('#procurement_staff_name').val($(this).combobox('textbox').val())
		      			}
		      			if(personType==1){
		      				$('#procurement_staff1').val(id);
		      				$('#procurement_staff_name1').val($(this).combobox('textbox').val())
		      				
		      			}
		      			find_cgry(id)
		      		}})
			
			$("#procurementName").append($('<input name="" type="button" onclick="createNew()" class="btn_small" value="新增" />'));
				ps_nameObj.combobox('textbox').blur(function(){
				$('#ps_pinyinCode').val(Pinyin.GetJP(this.value).toUpperCase());
				var personType = $("#personType").val();
				if(personType==0){
					$('#procurement_staff_name').val(this.value);
				}
				if(personType==1){
					$('#procurement_staff_name1').val(this.value);
				}
			})
			if(a==0){
				var url='../firstEnterprise/findProcurementSatffJson.html?personType=0';
				$("#ps_name").combobox({url:url,width:180});
				$("#procurementStaff_0_dlg").panel({title:'选择采购人员'});
				var name=$('#procurement_staff_name').val();
				$("#ps_name").combobox('setValue',name);
				$("#personType").val("0");
				var id=$("#procurement_staff").val();
				//alert(id);
				if(id !=null && id != ""){
					find_cgry(id);
				}
				$("#IDNumber").validatebox({required:true})
				$("#powerOfAttorneyDate").datebox({required:true})
			}
			if(a==1){
				var url='../firstEnterprise/findProcurementSatffJson.html?personType=1';
				$("#ps_name").combobox({url:url,width:180,required:false});
				$('#procurementStaff_0_dlg').panel({title:'选择提货人员'});
				var name=$('#procurement_staff_name1').val();
				$("#ps_name").combobox('setValue',name);
				$("#personType").val("1");
				
				var id=$("#procurement_staff1").val();
				//alert(id);
				if(id !=null && id != ""){
					find_cgry(id);
				}
				$("#IDNumber").validatebox({required:false})
				$("#powerOfAttorneyDate").datebox({required:false})
				
			}
			$("#type").val("1");//打开时设置为点保存时如果没有点新增为修改
			$('#procurementStaff_0_dlg').dialog('open');
		}
		
		function find_cgry(id){
			$.post("${ctx}/firstEnterprise/find_hgcgry.html",{"id":id},
			function(data){
			if(data){
				var json = jsonParse(data);
				
				
      			$('#ps_pinyinCode').val(Pinyin.GetJP(json.name).toUpperCase());
				
				$("#IDNumber").val(json.IDNumber)
				$("#powerOfAttorneyDate").datebox("setValue",json.powerOfAttorneyDate);
				$("#identityCardDate").datebox("setValue",json.idCardDate);
				setDefaultForCheckbox("gender",json.gender);
				$("#powerOfAttorney").empty();
				$("#identityCard").empty();
				$("#powerOfAttorney").append(
					"<input name=\"powerOfAttorney\" type=\"file\" class=\"easyui-validatebox text1\" size=\"40\" />"
				);
				$("#identityCard").append(
					"<input name=\"identityCard\" type=\"file\" class=\"easyui-validatebox text1\" size=\"40\" />"
				);
				var aPath = json.attorneyPath;
				//alert(aPath);
				if(aPath != null && aPath!=""){
					$("#powerOfAttorney").empty();
					$("#powerOfAttorney").append(
					    "<img src=\"../images/pdf.gif\" />"+
		            	"<a href=\"../download.html?fileName="+aPath+"\">法人委托书</a>"+
		            	"<input name=\"\" type=\"button\" class=\"btn_small\" value=\"删除\" onclick=\"deleteFileProcurement('"+id+"','"+aPath+"','frwts')\"/>"					
		        );
				};
				var idPath = json.idCardPath;
				if(idPath != null && idPath!=""){
					$("#identityCard").empty();
					$("#identityCard").append(
					    "<img src=\"../images/pdf.gif\" />"+
		            	"<a href=\"../download.html?fileName="+idPath+"\">身份证复印件</a>"+
		            	"<input name=\"\" type=\"button\" class=\"btn_small\" value=\"删除\" onclick=\"deleteFileProcurement('"+id+"','"+idPath+"','sfzfyj')\"/>"					
		        );
				};
			}
			}
			
		);
		}
		
		function pSSaveOrUpdate(){
			var personType = $("#personType").val();
			var type = $("#type").val();
			var procStaff1 = $("#procurement_staff1").val();
			if(personType==1 && (procStaff1==null || procStaff1=="")){
				$('#procurementStaff_0_dlg').dialog('close');
				return false;
			}
			var pUrl = null;
			var pType = 2;
			$("#cgry_save_type").remove();
			$("#cgry_id").remove();
			$("#cgry_procurementName").remove();
			$("#cgry_pinyinCode").remove();
			if(type == "0"){//新增
				//ajaxAddProcurementStaff.html
				pUrl = "${ctx}/firstEnterprise/ajaxAddProcurementStaff.html"
			}else if (type == "1"){//修改
				//update_hgcgry.html
				pUrl = "${ctx}/firstEnterprise/update_hgcgry.html"
			}
			var save_type = $('<input type="hidden" name="save_type" id="cgry_save_type" />');  
			save_type.attr('value', pType);
			//构建采购人员的属性
			var id = $('<input type="hidden" name="id" id="cgry_id"/>')
			if(type == "1"){//修改
				if(personType==0){
					id.attr("value",$("#procurement_staff").val());
				}
				if(personType==1){
					id.attr("value",$("#procurement_staff1").val());
				}
				
				$('#add_xsry').append(id);
				$('input[name="identityCard"]').attr('name','identityCardPath');
				$('input[name="powerOfAttorney"]').attr('name','powerOfAttorneyPath');
			}
			if(type==0){
				id.attr("value","");
			}
			
			var procurementName = $('<input type="hidden" name="procurementName" id="cgry_procurementName" />')
			if(personType==0){
				procurementName.attr("value",$("#procurement_staff_name").val());
			}
			if(personType==1){
				procurementName.attr("value",$("#procurement_staff_name1").val());
			}
			
			var pinyinCode = $('<input type="hidden" name="pinyinCode" id="cgry_pinyinCode" />')
			pinyinCode.attr("value",$("#ps_pinyinCode").val())
			$('#add_xsry').append(pinyinCode)
			$('#add_xsry').append(procurementName)
			$('#add_xsry').append(save_type)
		  $('#add_xsry').attr("action",pUrl)
		  $('#add_xsry').form('submit',{  
			    success: function(data){  
				  var json = jsonParse(data);
					if(json.success!=null && json.success!=""){
						if(json.success = "保存数据成功！"){
							if(type = 1){
								if(personType==0){
									$('#procurement_staff').val(json.psid);
									$('#procurementStaff_0_dlg').dialog('close')
								}
								if(personType==1){
									$('#procurement_staff1').val(json.psid);
									$('#procurementStaff_0_dlg').dialog('close')
								}
								
							}
						}else{//保存成功无需提醒,保存失败后提醒失败了
							alert(decodeURI(json.success));
						}
						
					}
					
			    }  
			})
		}
		
		
		function deleteFileProcurement(id,fileName,type){
			$.post("delteQualifiedProcurementStaffAttachment.html",{
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
		
		setDefaultForCheckbox("economicNature","${purchaseUnit.economicNature}")
		setDefaultForCheckbox("openCompay","${purchaseUnit.openCompany}")
		
	</script>
		</body>
	</html>