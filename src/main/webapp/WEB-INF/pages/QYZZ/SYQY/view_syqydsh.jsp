<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sinosoft.util.StringUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@ page import="com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise"%>
<%@ page import="com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterpriseAccessory"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Set<FirstEnterpriseAccessory> accessorySet = ((FirstEnterprise)request.getAttribute("waitEnter")).getAccessories();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看审核首营企业</title>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;首营企业&nbsp;>&nbsp;查看审核首营企业</font>
		  <%
            	FirstEnterprise enterptise = (FirstEnterprise)request.getAttribute("waitEnter");
            	
            %>
		<form action="" name="audit_syqydsh" id="audit_syqydsh" method="post">
		 	<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span >1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span >2</span>
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
          <th>客户编号：</th>
            <td><input name="customerNumber" type="text" class="text1" size="40" value="${waitEnter.customerNumber}" readonly="readonly"/></td>	
            <th width="150">企业名称：</th>
            <td><input name="companyName" type="text" class="text1" size="40" value="${waitEnter.companyName}" readonly="readonly"/></td>
            
          </tr>
          <tr>
          <th>拼音码：</th>
            <td><input name="pinyinCode" type="text" class="text1" size="40" value="${waitEnter.pinyinCode}" readonly="readonly"/></td>
          <th>邮      编：</th>
            <td><input name="postalcode" type="text" class="text1" size="40" value="${waitEnter.postalcode}" readonly="readonly"/></td>
          </tr>
          <tr>
            <th>联系电话：</th>
            <td><input name="phone" type="text" class="text1" size="40" value="${waitEnter.phone}" readonly="readonly"/></td>
            <th>传真：</th>
            <td><input name="portraiture" type="text" class="text1" size="40" value="${waitEnter.portraiture}" readonly="readonly"/></td>
          </tr>
         <tr>
         	<th width="150">法人代表/负责人：</th>
            <td><input name="corporation" type="text" class="text1" size="40" value="${waitEnter.corporation}" readonly="readonly"/></td>
             <th>纳税人登记号：</th>
            <td><input name="taxpayerRegisterNo" type="text" class="text1" size="40" value="${waitEnter.taxpayerRegisterNo}" readonly="readonly"/></td>
         </tr>
         <tr>
            <th>开户银行：</th>
            <td><input name="bankName" type="text" class="text1" size="40" value="${waitEnter.bankName}" readonly="readonly"/></td>
            <th>开户银行账号：</th>
            <td><input name="bankNumber" type="text" class="text1" size="40" value="${waitEnter.bankNumber}" readonly="readonly"/></td>
          </tr>
          <tr>
           <th>开户户名<span class="required">*</span>：</th>
            <td><input name="bankUserName" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkChina'" value="${waitEnter.bankUserName}" size="40"/></td>
            <th>销售代表：</th>
            <td><input name="sales_deputy" type="text" class="text1" size="40" value="${waitEnter.sales_deputy.saleName}" readonly="readonly"/></td>
          </tr>
          <tr>
          	 <th>Email地址：</th>
            <td><input name="email" type="text" class="text1" size="40" value="${waitEnter.email}" readonly="readonly"/></td>
          </tr>
         <!--  <tr>
            <th>企业地址：</th>
            <td><input name="compamyAddress" type="text" class="text1" size="40" value="${waitEnter.compamyAddress}" readonly="readonly"/></td>
            
          </tr>
          <tr>
            <th>质量负责人：</th>
            <td><input name="quality_principal" type="text" class="text1" size="40" value="${waitEnter.quality_principal}" readonly="readonly"/></td>
            
          </tr> <tr> -->
         
            
           <!--   <th>提货人员：</th>
              <td>
           	<input type="text" name="deliveryPersonnel" class="text1" value="${waitEnter.deliveryPersonnel}" size="40" readonly="readonly"/>
           </td> -->
           <!-- 
            <th>十位码：</th>
            <td><input name="tenBitCode" type="text" class="text1" size="40" value="${waitEnter.tenBitCode}" readonly="readonly"/></td>-->
              <!-- <th>企业经济性质：</th>
            <td>
            <c:choose>
            	<c:when test="${waitEnter.economic_nature==1}">
            		<input type="text" value="国有企业" class="text1" size="40" readonly="readonly"/>
            	</c:when>
            	<c:when test="${waitEnter.economic_nature ==2}">
            		<input type="text" value="私营企业" class="text1" size="40" readonly="readonly"/>
            	</c:when>
            	<c:when test="${waitEnter.economic_nature ==3}">
            		<input type="text" value="个人独资企业" class="text1" size="40" readonly="readonly"/>
            	</c:when>
            	<c:when test="${waitEnter.economic_nature ==4}">
            		<input type="text" value="集体企业" class="text1" size="40" readonly="readonly"/>
            	</c:when>
            	<c:when test="${waitEnter.economic_nature ==5}">
            		<input type="text" value="外资企业企业" class="text1" size="40" readonly="readonly"/>
            	</c:when>
            	<c:otherwise>
            		<input type="text" value="" class="text1" size="40" readonly="readonly"/>
            	</c:otherwise>
            </c:choose>
         </td>
          </tr> --> 
          
      
        <!--   <tr>
            <th>经营/生产许可证号：</th>
            <td><input name="license_No" type="text" class="text1" size="40" value="${waitEnter.license_No}" readonly="readonly"/></td>
            <th> 营业执照号：</th>
            <td><input name="business_license_No" type="text" class="text1" size="40" value="${waitEnter.business_license_No}" readonly="readonly"/></td>
          </tr>
          <tr>
           
            <th>认证证书号码：</th>
            <td><input name="certificate_No" type="text" class="text1" size="40" value="${waitEnter.certificate_No}" readonly="readonly"/></td>
          </tr>
          
          <tr> -->
         
         
         <!--  
            <th>提货人员：</th>
             <td>
           	<input type="text" name="deliveryPersonnel" class="text1" value="${waitEnter.deliveryPersonnel}" size="40" readonly="readonly"/>
           </td> </tr>-->
          
          <tr>
            <th valign="top">经营/生产范围：</th>
            <td colspan="3"><textarea name="businessScope" cols="94" rows="4" class="textarea" readonly="readonly">${waitEnter.businessScope}</textarea></td>
          </tr>
          <tr>
            <th valign="top">申请原因：</th>
            <td colspan="3"><textarea name="apply_cause" cols="94" rows="4" class="textarea" readonly="readonly">${waitEnter.apply_cause}</textarea></td>
          </tr>
             <tr>
            <th valign="top">备注：</th>
            <td colspan="3"><textarea name="remark" cols="94" rows="4" class="textarea" >${waitEnter.remark}</textarea></td>
          </tr>
          <tr>
            <th>营业执照：</th>
              <% if(StringUtil.isNull(enterptise.getBusiness_licence_path())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${waitEnter.business_licence_path}"><%=enterptise.getCompanyName()+"营业执照"+StringUtil.fileExtensions(enterptise.getBusiness_licence_path())%></a>
               
           </td>
           <%}else{ %>
            <td>
            <input type="text" name="" class="text1" size="40" value="未上传附件" readonly="readonly"/>
            </td>
           <%} %>
            <th>营业执照到期时间：</th>
            <td>
            	<input type="text" name="business_licence_date" class="easyui-datebox"  size="40" value="${waitEnter.business_licence_date}" data-options="disabled:true"/>
            </td>
          </tr>
       <%--     <tr>
              <th>营业执照年检：</th>
           <% if(StringUtil.isNull(enterptise.getBusiness_licence_inspection_path())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${waitEnter.business_licence_inspection_path}"><%=enterptise.getCompanyName()+"营业执照年检"+StringUtil.fileExtensions(enterptise.getBusiness_licence_inspection_path())%></a>
           </td>
           <%}else{ %>
            <td>
            <input type="text" name="" value="未上传附件" class="text1" size="40" readonly="readonly"/>
            </td>
           <%} %>
            <th>营业执照年检时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="business_licence_inspection_date" class="easyui-datebox" data-options="required:true" size="40" value="${waitEnter.business_licence_inspection_date}"/>
            </td>
          </tr>--%>
            <tr>
            <th>经营/生产许可证：</th>
             <% if(StringUtil.isNull(enterptise.getLicence_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${waitEnter.licence_path}"><%=enterptise.getCompanyName()+"经营/生产许可证"+StringUtil.fileExtensions(enterptise.getLicence_path())%></a>
             </td>
            <%}else{%>
            	<td>
           		 <input type="text" name="" value="未上传附件" class="text1" size="40" readonly="readonly"/>
            	</td>
            <%} %>
            <th>经营/生产许可证到期日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="licence_date" class="easyui-datebox"  data-options="disabled:true" size="40" value="${waitEnter.licence_date}"/>
            </td>
          </tr>
           <tr>
            <th>GSP/GMP证书：</th>
             <% if(StringUtil.isNull(enterptise.getGsp_certificate_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${waitEnter.gsp_certificate_path}"><%=enterptise.getCompanyName()+"GSP/GMP证书"+StringUtil.fileExtensions(enterptise.getGsp_certificate_path())%></a>
             </td>
            <%}else{%>
            	<td>
           		 <input type="text" name="" value="未上传附件" class="text1" size="40" readonly="readonly"/>
            	</td>
            <%} %>
            <th>GSP/GMP证书截止日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="gsp_certificate_date" class="easyui-datebox"  data-options="disabled:true" size="40" value="${waitEnter.gsp_certificate_date}"/>
            </td>
          </tr>
          <tr>
            <th>组织机构代码证：</th>
             <% if(StringUtil.isNull(enterptise.getOrganization_code_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${waitEnter.organization_code_path}"><%=enterptise.getCompanyName()+"组织机构代码证"+StringUtil.fileExtensions(enterptise.getOrganization_code_path())%></a>
             </td>
            <%}else{%>
            	<td>
           		 <input type="text" name="" value="未上传附件" class="text1" size="40" readonly="readonly"/>
            	</td>
            <%} %>
            <th>组织机构代码到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="organization_code_date" class="easyui-datebox"  data-options="disabled:true" size="40" value="${waitEnter.organization_code_date}"/>
            </td>
          </tr>
           <tr>
            <th>组织机构代码证年检：</th>
             <% if(StringUtil.isNull(enterptise.getOrganization_code_inspection_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${waitEnter.organization_code_inspection_path}"><%=enterptise.getCompanyName()+"组织机构代码证年检"+StringUtil.fileExtensions(enterptise.getOrganization_code_inspection_path())%></a>
             </td>
            <%}else{%>
            	<td>
           		 <input type="text" name="" value="未上传附件" class="text1" size="40" readonly="readonly"/>
            	</td>
            <%} %>
            <th>组织机构代码年检时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="organization_code_inspection_date" class="easyui-datebox"  data-options="disabled:true" size="40" value="${waitEnter.organization_code_inspection_date}"/>
            </td>
          </tr>
            <tr>
            <th>质量保证协议：</th>
             <% if(StringUtil.isNull(enterptise.getQuality_assurance_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${waitEnter.quality_assurance_path}"><%=enterptise.getCompanyName()+"质量保证协议"+StringUtil.fileExtensions(enterptise.getQuality_assurance_path())%></a>
             </td>
            <%}else{%>
            	<td>
           		 <input type="text" name="" value="未上传文件" class="text1" size="40" readonly="readonly"/>
            	</td>
            <%} %>
            <th>质量保证书到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="quality_assurance_date" class="easyui-datebox"  data-options="disabled:true" size="40" value="${waitEnter.quality_assurance_date}"/>
            </td>
          </tr>
                <tr>
            <th>法人委托书：</th>
             <% if(StringUtil.isNull(enterptise.getAuthorization_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${waitEnter.authorization_path}"><%=enterptise.getCompanyName()+"法人委托书"+StringUtil.fileExtensions(enterptise.getAuthorization_path())%></a>
             </td>
            <%}else{%>
            	<td>
           		 <input type="text" name="" value="未上传文件" class="text1" size="40"/>
            	</td>
            <%} %>
            <th>法人委托书到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="authorization_path" class="easyui-datebox"  data-options="disabled:true" size="40" value="${waitEnter.authorization_date}"/>
            </td>
          </tr>
          <%-- 
          <tr>
            <th>认证证书：</th>
               <% if(StringUtil.isNull(enterptise.getLittCredentPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${waitEnter.littCredentPath}"><%=enterptise.getCompanyName()+"认证证书"+StringUtil.fileExtensions(enterptise.getLittCredentPath())%></a>
               
           </td>
           <%}else{ %>
            <td>
            <input type="text" name="" class="text1" size="40" value="未上传附件" readonly="readonly"/>
            </td>
           <%} %>
            <th>认证证书到期日期：</th>
            <td>
            	<input type="text" name="littCredentDate" class="easyui-datebox"  size="40" value="${waitEnter.littCredentDate}" data-options="disabled:true"/>
            </td>
          </tr>
           <tr>
            <th>开户信息：</th>
           <% if(StringUtil.isNull(enterptise.getAccountPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${waitEnter.accountPath}"><%=enterptise.getCompanyName()+"开户信息"+StringUtil.fileExtensions(enterptise.getAccountPath())%></a>
               
           </td>
           <%}else{ %>
            <td>
            <input type="text" name="" class="text1" size="40" value="未上传附件" readonly="readonly"/>
            </td>
           <%} %>
            <th>开户信息到期日期：</th>
            <td>
            	<input type="text" name="accountDate" class="easyui-datebox"  size="40" value="${waitEnter.accountDate}" data-options="disabled:true"/> </td>
          </tr>
          <tr>
            <th>年检证明：</th>
               <% if(StringUtil.isNull(enterptise.getAnnualSurveyPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${waitEnter.annualSurveyPath}"><%=enterptise.getCompanyName()+"年检证明"+StringUtil.fileExtensions(enterptise.getAnnualSurveyPath())%></a>
               
           </td>
           <%}else{ %>
            <td>
            <input type="text" name="" class="text1" size="40" value="未上传附件" readonly="readonly"/>
            </td>
           <%} %>
            <th>年检证明到期日期：</th>
            <td>
            	<input type="text" name="annualSurveyDate" class="easyui-datebox"  size="40" value="${waitEnter.annualSurveyDate}" data-options="disabled:true"/>
            </td>
          </tr>
          --%>
        </table>
                <table id ="add_dttachment" class="xx_table2">
         <%
          		Iterator<FirstEnterpriseAccessory> it = accessorySet.iterator();
          		while(it.hasNext()){
          			FirstEnterpriseAccessory accessory = it.next();
          			int index = Integer.valueOf(accessory.getRequest_name().substring(accessory.getRequest_name().length()-1));
          %>
         
          <%if(accessory.getRequest_type().equals("GSP")) {%>
           <tr>
          	<th>GSP/GMP证书号码<span class="required">*</span>：</th>
          	<td><input type='text' name='firstAccessoryList[<%=index %>].certificateNumber' class='text1' readonly="readonly" size='20' value="<%=accessory.getCertificateNumber() %>"/></td>
          	<th>GSP/GMP证书到期时间<span class="required">*</span>：</th>
          	<td>
          		<input type="text" name="firstAccessoryList[<%=index%>].accessoryDate" class="easyui-datebox" data-options="disabled:true" size="20" style="height: 28px;" value="<%=accessory.getAccessoryDate() %>"/>
          	</td>
          	<% if(StringUtil.isNull(accessory.getAccessoryPath())){ %>
          	<td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=<%=accessory.getAccessoryPath() %>"><%="GSP/GMP证书附件"+StringUtil.fileExtensions(accessory.getAccessoryPath())%></a>
              	<input type="hidden" name="firstAccessoryList[<%=index%>].accessoryPath" value="<%=accessory.getAccessoryPath() %>">
             </td>
          	<%} else{ %>
          	<td>
				<input type='file' name='request_name<%=index %>' class='text1' size='20' value="未上传附件"/>          	
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
          	<td><input type='text' name='firstAccessoryList[<%=index %>].certificateNumber' class='text1' readonly="readonly"  size='20' value="<%=accessory.getCertificateNumber() %>"/></td>
          	<th>证书到期时间<span class="required">*</span>：</th>
          	<td>
          		<input type="text" name="firstAccessoryList[<%=index%>].accessoryDate" class="easyui-datebox" data-options="disabled:true" size="20" style="height: 28px;" value="<%=accessory.getAccessoryDate() %>"/>
          	</td>
          	<% if(StringUtil.isNull(accessory.getAccessoryPath())){ %>
          	<td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=<%=accessory.getAccessoryPath() %>"><%="证书附件"+StringUtil.fileExtensions(accessory.getAccessoryPath())%></a>
              	<input type="hidden" name="firstAccessoryList[<%=index%>].accessoryPath" value="<%=accessory.getAccessoryPath() %>">
            </td>
          	<%} else{ %>
          	<td>
				<input type='file' name='request_name<%=index %>' class='text1' value="未上传附件" size='20'/>         	
          	</td>
          	<%} %>
          	
          	<td>
          		<input type="hidden" name="firstAccessoryList[<%=index%>].request_name" value="<%=accessory.getRequest_name() %>">
          		<input type="hidden" name="firstAccessoryList[<%=index%>].request_type" value="<%=accessory.getRequest_type() %>">
          		<input type="hidden" name="firstAccessoryList[<%=index%>].accssoryId" value="<%=accessory.getAccssoryId() %>">
          	</td>
          </tr>
         <%} }%>
        </table>
       <table border="0" cellspacing="0" cellpadding="0" class="xx_table2">
           <tr height="80">
            <td colspan="4" align="center" valign="bottom">
           		<input type="hidden" id="save_type" name="save_type" value=""/>
				<input type="hidden" id="id" name="id" value="${waitEnter.id}"/>
                <input name="" type="button" class="btn_big" value="批准" onclick="update_syqydsh(0)"/>
                <input name="" type="button" class="btn_big" value="驳回" onclick="$('#dialog').dialog('open')"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
       </table>
        </form>
        <div id="dialog" title="申请驳回" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:true,top:1000">
        <form id="audit" name="" method="post">
    	<table>
    	<tr>
            <th valign="top">驳回原因：</th>
            <td colspan="3"><textarea name="reject_cause" cols="94" rows="4" class="easyui-validatebox textarea"  data-options="required:true,validType:'checkChina'"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
			<input type="hidden" id="save_type2" name="save_type" value="1"/>
			<input type="hidden" id="id2" name="id" value="${waitEnter.id}"/>
           	<input type="button" class="btn_big" onclick="audit(1)" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
		</form>
        </div>
	
	<script type="text/javascript">
		function update_syqydsh(value){
			
			document.getElementById("save_type").value=value;
			var form = document.getElementById("audit_syqydsh");
			form.action="audit_syqydsh.html";
			var con = confirm("是否确认！");
			if(con){
				form.submit();
			}else{
				return;
			}
			
		}
		function audit(value){
			document.getElementById("save_type2").value=value;
			var form = document.getElementById("audit");
			form.action="audit_syqydsh.html";
			var con = confirm("是否确认！");
			if(con){
				form.submit();
			}else{
				return;
			}
			
		}
	</script>
</body>
</html>