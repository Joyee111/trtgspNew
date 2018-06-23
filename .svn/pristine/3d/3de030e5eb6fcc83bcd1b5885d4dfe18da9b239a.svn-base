<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sinosoft.util.StringUtil"%>
<%@ page import="com.sinosoft.enterpriseManage.firstEnterprise.model.PurchaseUnit"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
PurchaseUnit purchaseUnit = (PurchaseUnit)request.getAttribute("purchaseUnit");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查看审核购货单位</title>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;购货单位&nbsp;>&nbsp;查看审核购货单位</font>
	<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span >1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span>2</span>
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
		<form action="" name="update_ghdwdsh" id="update_ghdwdsh" method="post" enctype="multipart/form-data">
        <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
        <tr>
        <th>省份<span class="required">*</span>：</th>
         <td><input name="name" type="text" class="text1" size="40" value="${name}" readonly="readonly"/></td>
         <th>客户编号：</th>
        <td><input name="customerNumber" type="text" class="text1" size="40" value="${purchaseUnit.customerNumber}" readonly="readonly"/></td>
        </tr>
          <tr>
            <th width="150">企业名称：</th>
            <td><input name="companyName" type="text" class="text1" size="40" value="${purchaseUnit.companyName}" readonly="readonly"/></td>
            <th width="150">法定代表人/负责人：</th>
            <td><input name="corporation" type="text" class="text1" size="40" value="${purchaseUnit.corporation}" readonly="readonly"/></td>
          </tr>
          <tr>
            <th>企业地址：</th>
            <td><input name="address" type="text" class="text1" size="40" value="${purchaseUnit.address}" readonly="readonly"/></td>
            <th>邮      编：</th>
            <td><input name="postalCode" type="text" class="text1" size="40" value="${purchaseUnit.postalCode}" readonly="readonly"/></td>
          </tr>
          <tr>
          <th>企业联系电话：</th>
          <td><input name="companyPhone" type="text" class="easyui-validatebox text1" size="40" value="${purchaseUnit.compantPhone}" readonly="readonly"/></td>
            <th>企业经营类型：</th>
            <td>
            <c:choose>
            	<c:when test="${purchaseUnit.economicNature==1}">
            		<input type="text" value="批发" class="text1" size="40" readonly="readonly"/>
            	</c:when>
            	<c:when test="${purchaseUnit.economicNature ==2}">
            		<input type="text" value="零售" class="text1" size="40" readonly="readonly"/>
            	</c:when>
            	<c:when test="${purchaseUnit.economicNature ==3}">
            		<input type="text" value="零售（连锁）" class="text1" size="40" readonly="readonly"/>
            	</c:when>
            	<c:when test="${purchaseUnit.economicNature ==4}">
            		<input type="text" value="医疗机构" class="text1" size="40" readonly="readonly"/>
            	</c:when>
            	<c:otherwise>
            		<input type="text" value="其他" class="text1" size="40" readonly="readonly"/>
            	</c:otherwise>
            </c:choose>
            </td>
          </tr>
          <tr>
            <th>采购人员：</th>
            <td><input name="salesDeputy" type="text" class="text1" size="40" value="${purchaseUnit.procurementStaff.procurementName}" readonly="readonly"/></td>
            <th>采购人联系电话：</th>
            <td><input name="phone" type="text" class="text1" size="40" value="${purchaseUnit.phone}" readonly="readonly"/></td>
          </tr>
          <tr>
            <th>质量负责人：</th>
            <td><input name="qualityPrincipal" type="text" class="text1" size="40" value="${purchaseUnit.qualityPrincipal}" readonly="readonly"/></td>
            <!-- 
            <th>十位码：</th>
            <td><input name="tenBitCode" type="text" class="text1" size="40" value="${purchaseUnit.tenBitCode}" readonly="readonly"/></td>
             -->
            <th>拼音码：</th>
            <td><input name="pinyinCode" type="text" class="text1" size="40" value="${purchaseUnit.pinyinCode}" readonly="readonly"/></td>
          </tr>
            <tr>
            <th>传&nbsp;真：</th>
            <td><input name="portraiture" type="text" class="text1" size="40" value="${purchaseUnit.portraiture}" readonly="readonly"/></td>
            <th>经营/生产/医疗机构许可证号：</th>
            <td><input name="licenseNo" type="text" class="text1" size="40" value="${purchaseUnit.licenseNo}" readonly="readonly"/></td>
          </tr>
          <tr>
            <th> 营业执照号：</th>
            <td><input name="businessLicenseNo" type="text" class="text1" size="40" value="${purchaseUnit.businessLicenseNo}" readonly="readonly"/></td>
            <th>GSP/GMP认证证书号码：</th>
            <td><input name="certificateNo" type="text" class="text1" size="40" value="${purchaseUnit.certificateNo}" readonly="readonly"/></td>
          </tr>
          <tr>
            <th>纳税人登记号：</th>
            <td><input name="taxpayerRegisterNo" type="text" class="text1" size="40" value="${purchaseUnit.taxpayerRegisterNo}" readonly="readonly"/></td>
            <th>开户银行：</th>
            <td><input name="bankName" type="text" class="text1" size="40" value="${purchaseUnit.bankName}" readonly="readonly"/></td>
          </tr>
           <tr>
            <th>开户银行账号：</th>
            <td><input name="bankNumber" type="text" class="text1" size="40" value="${purchaseUnit.bankNumber}" readonly="readonly"/></td>
            <th>开户日期：</th>
            <td><input name="accountOpeningDate" type="text" class="easyui-datebox text1" size="40" value="${purchaseUnit.accountOpeningDate}" data-options="disabled:true"/></td>
          </tr>
  
         <tr>
            <th>税票信息地址<span class="required">*</span>：</th>
            <td><input name="taxReceiptAddress" value="${purchaseUnit.taxReceiptAddress }" type="text" class="text1" readonly="readonly" size="40"/></td>
         	<th>税票信息电话<span class="required">*</span>：</th>
           <td><input name="taxReceiptPhone" value="${purchaseUnit.taxReceiptPhone}" type="text" class="text1" readonly="readonly" size="40"/></td>
          </tr>
          <tr>
            <th>发货地址<span class="required">*</span>：</th>
            <td><input name="shippingAddress" value="${purchaseUnit.shippingAddress}" type="text" class="text1" readonly="readonly" size="40"/></td>
         	<th>收货人<span class="required">*</span>：</th>
           <td><input name="consigneeName" value="${purchaseUnit.consigneeName }" type="text" class="text1" readonly="readonly" size="40"/></td>
          </tr>
          <tr>
            <th>收货人电话<span class="required">*</span>：</th>
            <td><input name="consigneePhone" value="${purchaseUnit.consigneePhone }" type="text" class="text1" readonly="readonly" size="40"/></td>
         	<th>客户电子监管码<span ></span>：</th>
           <td><input name="electronicMonitoringCode" value="${purchaseUnit.electronicMonitoringCode }" type="text" class="text1" readonly="readonly" size="40"/></td>
          </tr>
          <tr>
          	<th>提货人员：</th>
          	<td>
          		<input type="text" name="receivingPerson" value="${purchaseUnit.procurementReceiving.procurementName }" class="text1" readonly="readonly" size=40/>
          	</td>
          	<th>企业年度信息报告到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="businessLicenseInspectionDate" class="easyui-datebox" size="40" value="${purchaseUnit.businessLicenseInspectionDate}" data-options="disabled:true"/>
            </td>
          </tr>
          <tr>
            <th valign="top">生产/经营范围：</th>
            <td colspan="3"><textarea name="businessScope" cols="94" rows="4" class="textarea" readonly="readonly">${purchaseUnit.businessScope}</textarea></td>
          </tr>
          <tr>
            <th valign="top">申请原因：</th>
            <td colspan="3"><textarea name="applyCause" cols="94" rows="4" class="textarea" readonly="readonly">${purchaseUnit.applyCause}</textarea></td>
          </tr>
          <tr>
            <th valign="top">审批意见：</th>
            <td colspan="3"><textarea name="examineContent" cols="94" rows="4"  class="easyui-validatebox  textarea"  data-options="required:true,validType:'checkChina'">${purchaseUnit.examineContent}</textarea></td>
          </tr>
            <tr>
            <th valign="top">备注：</th>
            <td colspan="3"><textarea name="remark" cols="94" rows="4" class="textarea" >${purchaseUnit.remark }</textarea></td>
          </tr>
          <tr>
          <th width="150">销售类别：</th>
          <td>
			<input type="checkbox" disabled="disabled" name="saleCompany" id="returnType1" value="1" /><font style="font-size:12px; color:#727171; font-weight:bold;">经营</font>
			<input type="checkbox" disabled="disabled" name="saleCompany" id="returnType2" value="2" /><font style="font-size:12px; color:#727171; font-weight:bold;">新品</font>
			<input type="checkbox" disabled="disabled" name="saleCompany" id="returnType3" value="3" /><font style="font-size:12px; color:#727171; font-weight:bold;">市场</font>
		  	<input type="hidden" id="saleCompanyValue" value="${purchaseUnit.saleCompany}"/>
		  </td>
		  <th>开户公司：</th>
		  <td>
		  		<c:if test="${purchaseUnit.openCompany=='0'}">
		  			<input type="text" class="text1" size="40" value="经营" readonly="readonly"/>
		  		</c:if>
		  		<c:if test="${purchaseUnit.openCompany=='1'}">
		  			<input type="text" class="text1" size="40" value="新品" readonly="readonly"/>
		  		</c:if>
		  		<c:if test="${purchaseUnit.openCompany=='2'}">
		  			<input type="text" class="text1" size="40" value="市场" readonly="readonly"/>
		  		</c:if>
		  </td>
          </tr>
          <%-- 
          <tr>
            <th>营业执照：</th>
                  <% if(StringUtil.isNull(purchaseUnit.getBusinessLicencePath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${purchaseUnit.businessLicencePath}"><%=purchaseUnit.getCompanyName()+"营业执照"+StringUtil.fileExtensions(purchaseUnit.getBusinessLicencePath())%></a>
               
           </td>
           <%}else{ %>
             <td><input name="businessLicencePath" type="text" class="easyui-validatebox text1" size="40"  value="未上传附件" readonly="readonly"/></td>
           <%} %>
            <th>营业执照到期时间：</th>
            <td>
            	<input type="text" name="businessLicenceDate" class="easyui-datebox" required="required" size="40" value="${purchaseUnit.businessLicenceDate }" data-options="disabled:true"/>
            </td>
          </tr>
           <tr>
            <th>许可证：</th>
             <% if(StringUtil.isNull(purchaseUnit.getLicencePath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${purchaseUnit.licencePath}"><%=purchaseUnit.getCompanyName()+"营业执照"+StringUtil.fileExtensions(purchaseUnit.getLicencePath())%></a>
               
           </td>
           <%}else{ %>
             <td><input name="licencePath" type="text" class="easyui-validatebox text1" value="未上传附件" readonly="readonly" size="40" /></td>
           <%} %>
            <th>许可证到期日期：</th>
            <td>
            	<input type="text" name="licenceDate" class="easyui-datebox" required="required" size="40" value="${purchaseUnit.licenceDate}" data-options="disabled:true"/>
            </td>
          </tr>
           <tr>
            <th>证明材料：</th>
                <% if(StringUtil.isNull(purchaseUnit.getDocumentEvidencePath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${purchaseUnit.documentEvidencePath}"><%=purchaseUnit.getCompanyName()+"营业执照"+StringUtil.fileExtensions(purchaseUnit.getDocumentEvidencePath())%></a>
               
           </td>
           <%}else{ %>
             <td><input name="documentEvidencePath" type="text" class="easyui-validatebox text1" value="未上传附件" readonly="readonly" size="40" /></td>
           <%} %>
            <th>证明材料到期日期：</th>
            <td>
            	<input type="text" name="documentEvidenceDate" class="easyui-datebox" required="required" size="40" value="${purchaseUnit.documentEvidenceDate}" data-options="disabled:true"/>
            </td>
          </tr>--%>
           <tr>
            <th>营业执照：</th>
            <% if(StringUtil.isNull(purchaseUnit.getBusinessLicencePath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${purchaseUnit.businessLicencePath}"><%=purchaseUnit.getCompanyName()+"营业执照"+StringUtil.fileExtensions(purchaseUnit.getBusinessLicencePath())%></a>
           </td>
           <%}else{ %>
             <td><input name="businessLicencePath" type="text" value="未上传附件" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
            <th>营业执照到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="businessLicenceDate" class="easyui-datebox"  size="40" value="${purchaseUnit.businessLicenceDate }" data-options="disabled:true"/>
            </td>
          </tr>
        <%--    <tr>
            <th>营业执照年检：</th>
            <% if(StringUtil.isNull(purchaseUnit.getBusinessLicenseInspectionPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${purchaseUnit.businessLicenseInspectionPath}"><%=purchaseUnit.getCompanyName()+"营业执照年检"+StringUtil.fileExtensions(purchaseUnit.getBusinessLicenseInspectionPath())%></a>
           </td>
           <%}else{ %>
             <td><input name="businessLicenseInspectionPath" type="text" value="未上传附件" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
            <th>营业执照年检时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="businessLicenseInspectionDate" class="easyui-datebox" size="40" value="${purchaseUnit.businessLicenseInspectionDate}" data-options="disabled:true"/>
            </td>
          </tr>--%>
         
           <tr>
            <th>经营/生产许可证：</th>
            <% if(StringUtil.isNull(purchaseUnit.getLicencePath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${purchaseUnit.licencePath}"><%=purchaseUnit.getCompanyName()+"经营/生产许可证"+StringUtil.fileExtensions(purchaseUnit.getLicencePath())%></a>
           </td>
           <%}else{ %>
             <td><input name="licencePath" type="text" value="未上传附件" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
            <th>经营/生产许可证到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="licenceDate" class="easyui-datebox" size="40" data-options="disabled:true" value="${purchaseUnit.licenceDate}"/>
            </td>
          </tr>
          
           <tr>
            <th>GSP证书：</th>
            <% if(StringUtil.isNull(purchaseUnit.getGspCertificatePath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${purchaseUnit.gspCertificatePath}"><%=purchaseUnit.getCompanyName()+"GSP/GMP证书"+StringUtil.fileExtensions(purchaseUnit.getGspCertificatePath())%></a>
           </td>
           <%}else{ %>
             <td><input name="gspCertificatePath" type="text" value="未上传附件" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
            <th>GSP证书截止日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="gspCertificateDate" class="easyui-datebox" size="40" data-options="disabled:true" value="${purchaseUnit.gspCertificateDate}"/>
            </td>
          </tr>
           <tr>
            <th>组织机构代码证：</th>
            <% if(StringUtil.isNull(purchaseUnit.getOrganizationCodePath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${purchaseUnit.organizationCodePath}"><%=purchaseUnit.getCompanyName()+"组织机构代码证"+StringUtil.fileExtensions(purchaseUnit.getOrganizationCodePath())%></a>
           </td>
           <%}else{ %>
             <td><input name="licencePath" type="text" value="未上传附件" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
            <th>组织机构代码到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="organizationCodeDate" class="easyui-datebox" size="40" data-options="disabled:true"value="${purchaseUnit.organizationCodeDate}"/>
            </td>
          </tr>
           <tr>
            <th>组织机构代码证年检：</th>
            <% if(StringUtil.isNull(purchaseUnit.getOrganizationCodeInspectionPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${purchaseUnit.organizationCodeInspectionPath}"><%=purchaseUnit.getCompanyName()+"组织机构代码证年检"+StringUtil.fileExtensions(purchaseUnit.getOrganizationCodeInspectionPath())%></a>
           </td>
           <%}else{ %>
             <td><input name="organizationCodeInspectionPath" type="text" value="未上传附件" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
            <th>组织机构代码年检时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="organizationCodeInspectionDate" class="easyui-datebox" size="40" data-options="disabled:true" value="${purchaseUnit.organizationCodeInspectionDate}"/>
            </td>
          </tr>
           <tr>
            <th>质量保证协议：</th>
            <% if(StringUtil.isNull(purchaseUnit.getQualityAssurancePath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${purchaseUnit.qualityAssurancePath}"><%=purchaseUnit.getCompanyName()+"质量保证协议"+StringUtil.fileExtensions(purchaseUnit.getQualityAssurancePath())%></a>
           </td>
           <%}else{ %>
             <td><input name="qualityAssurancePath" type="text" value="未上传附件" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
            <th>质量保证书到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="qualityAssuranceDate" class="easyui-datebox" size="40" data-options="disabled:true" value="${purchaseUnit.qualityAssuranceDate}"/>
            </td>
          </tr>
           <tr>
            <th>法人委托书：</th>
            <% if(StringUtil.isNull(purchaseUnit.getAuthorizationPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${purchaseUnit.authorizationPath}"><%=purchaseUnit.getCompanyName()+"法人委托书"+StringUtil.fileExtensions(purchaseUnit.getAuthorizationPath())%></a>
           </td>
           <%}else{ %>
             <td><input name=authorizationPath type="text" value="未上传附件" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
            <th>法人委托书到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="authorizationDate" class="easyui-datebox" size="40" data-options="disabled:true" value="${purchaseUnit.authorizationDate}"/>
            </td>
          </tr>
          <tr>
          <c:choose>
           	<c:when test="${dateDisableFlag eq 'true'}">
           			<th>旧客户编号<span class="required">*</span>：</th>
          	<td><span id="oldNumber" ></span>
          	<input type="hidden" id="oldNo" value="${purchaseUnit.oldNo}"/>
          	</td>
           	</c:when>
           </c:choose>
          
          </tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
           		 <input type="hidden" name="autid_type" id="autid_type"  value=""/>
           	 	<input type="hidden" id="id" name="id" value="${purchaseUnit.id}"/>
                <input name="" type="button" class="btn_big" value="批准" onclick="update_syqy(0)"/>
                <input name="" type="button" class="btn_big" value="驳回"  onclick="$('#dialog').dialog('open')"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
        </table>
        </form>
         <div id="dialog" title="申请驳回" class="easyui-dialog" style="width:800px;height:300px;padding:10px;margin-top:20px;"  data-options=" closed: true,modal:true,top:500">
         <form id="audit_ghdwdsh"  method="post">
    	<table>
    	<tr>
            <th valign="top">驳回原因：</th>
            <td colspan="3"><textarea name="rejectCause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true,validType:'checkChina'"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
			 <input type="hidden" id="autid_type2" name="autid_type" value=""/>
           	 	<input type="hidden" id="id2" name="id" value="${purchaseUnit.id}"/>
           	<input type="button" class="btn_big" onclick="update_2(1)" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
		</form>
        </div>
	<script type="text/javascript">
	var s =0;
	$(function() {
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
     	$("#oldNumber").append("<input type='text' readonly='readonly' id=\""+oldNumber+"\" value=\""+b[i]+"\" class='text1' size=40 name='oldNumber'/><br>");
     	s++;
     	}
	});
		function update_syqy(value){
			document.getElementById("autid_type").value=value;
			var form = document.getElementById("update_ghdwdsh");
			form.action="autid_ghdwdsh.html";
			var con = confirm("是否确认！");
			if(con){
				form.submit();	
			}else{
				return;
			}
			form.submit();
			$('#dialog').dialog('close');
		}
		function update_2(value){
			document.getElementById("autid_type2").value=value;
			var form = document.getElementById("audit_ghdwdsh");
			form.action="autid_ghdwdsh.html";
			var con = confirm("是否确认！");
			if(con){
				form.submit();	
			}else{
				return;
			}
			form.submit();
			$('#dialog').dialog('close');
		}
		function open(){
			$('#dialog').dialog('open');
		}
		function close(){
			$('#dialog').dialog('close');
		}
	</script>
</body>
</html>