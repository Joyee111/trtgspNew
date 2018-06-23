<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.Set"%>
<%@ page import="com.sinosoft.util.StringUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyAccessory"%>
<%@page import="com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers"%>
<%@page import="com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyDrugFroms"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Set<QulifiedSupplyAccessory> accessorySet = ((QualifiedSuppliers)request.getAttribute("qualifiedSupply")).getAccessories();
Set<QulifiedSupplyDrugFroms> drugFromsSet = ((QualifiedSuppliers)request.getAttribute("qualifiedSupply")).getDrugFroms();
int drugFromsSize = drugFromsSet.size();
int accssorySize = accessorySet.size();
request.setAttribute("accssorySize",accssorySize);
request.setAttribute("drugFromsSize",drugFromsSize);
	QualifiedSuppliers supplier = (QualifiedSuppliers)request.getAttribute("qualifiedSupply");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改合格供货单位</title>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;合格供货单位&nbsp;>&nbsp;合格供货单位修改</font>
	<form action="update_hggys.html" name="edit_hggys" id="edit_hggys" method="post" enctype="multipart/form-data">
		 <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
          <tr>
            <th width="150">编&nbsp;号：</th>
            <td><input type="text" name="customerNumber" value="${qualifiedSupply.customerNumber}" class="easyui-validatebox text1" data-options="required:true,validType:'checkNumber'" size="40"/></td>
            <th width="150">客户名称：</th>
            <td><input type="text" name="customerName" value="${qualifiedSupply.customerName}" class="easyui-validatebox text1" data-options="required:true" size="40" onchange="ajaxChanggeChinaToPinyin(this,'pinyinCode')"/></td>
          </tr>
          <tr>
            <th>营业执照到期时间：</th>
            <td><input type="text" name="busiLiceExpiDate" value="${qualifiedSupply.busiLiceExpiDate}" class="easyui-datebox" data-options="required:true,validType:'date'" size=40/></td>
            <th>法人委托书到期时间：</th>
            <td><input name="authorizationDate" value="${qualifiedSupply.authorizationDate}" type="text" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>
           <%--  <th>营业执照年检时间：</th>
            <td><input type="text" name="busiLIceAnnuSurvey" value="${qualifiedSupply.busiLIceAnnuSurvey}" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>--%>
          </tr>
          <tr>
            <th>经营/生产许可证到期日期：</th>
            <td><input type="text" name="liceExpiDate" value="${qualifiedSupply.liceExpiDate}" class="easyui-datebox"  data-options="required:true,validType:'date'" size="40"/></td>
            <th>GSP/GMP截止日期：</th>
            <td><input type="text" name="gspExpirDate" value="${qualifiedSupply.gspExpirDate}" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>
          </tr>
          <tr>
            <th>组织机构代码到期时间：</th>
            <td><input type="text" name="organizationCodeDate" value="${qualifiedSupply.organizationCodeDate}" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>
            <th>组织机构代码年检日期：</th>
            <td><input type="text" name="organizationCodeInspectionDate" value="${qualifiedSupply.organizationCodeInspectionDate}" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>
          </tr>
           <tr>
            <th>质量保证书到期时间：</th>
            <td><input name="qualityAssuranceDate" value="${qualifiedSupply.qualityAssuranceDate}" type="text" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>
              <th>销售代表：</th>
            <td>
             <input type="text" class="easyui-combobox  text1" data-options="
              required:true,
      	 	valueField: 'id',
       		textField: 'text',
      		url:'../firstEnterprise/findSalesStaffJson.html',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#sales_deputy').val(str[1]);
      		}" name="" id="commonnamebox" size="40"/>&nbsp;&nbsp;
			</td>
          </tr>
          <tr>
            <th>拼音码：</th>
            <td><input name="pinyinCode" id="pinyinCode" value="${qualifiedSupply.pinyinCode}" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
            <th>邮&nbsp;编：</th>
            <td>
            <input name="postalCode" value="${qualifiedSupply.postalCode}" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkPostCode'" size="40"/>
            </td>
          </tr>
          <tr>
            <th>电&nbsp;话：</th>
            <td><input name="phone" value="${qualifiedSupply.phone}" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
            <th>传&nbsp;真：</th>
            <td>
            <input  name="portraiture" value="${qualifiedSupply.portraiture}" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/>
            </td>
          </tr>
          <tr>
            <th>法定代表人/负责人：</th>
            <td><input name="corporation" value="${qualifiedSupply.corporation}" type="text" class="easyui-validatebox text1" data-options="required:true,validType:['checkChina','length[2,10]']" size="40"/></td>
            <th>纳税人登记号：</th>
            <td>
            <input  name="taxRegisNo" value="${qualifiedSupply.taxRegisNo}" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkCertificate'"  size="40"/>
            </td>
          </tr>
          <tr>
            <th>开户银行：</th>
            <td><input name="bankName" value="${qualifiedSupply.bankName}" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkChina'" size="40"/></td>
            <th>银行账户:</th>
            <td>
            <input  name="bankNumber" value="${qualifiedSupply.bankNumber}" type="text" class="easyui-validatebox text1" data-options="required:true,validType:['checkNumber','length[16,19]']" size="40"/>
            </td>
          </tr>
            <tr>
            <!-- 
            <th>十位码：</th>
            <td><input name="tenBitCode" value="${qualifiedSupply.tenBitCode}" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkTenCode'" size="40"/></td>
             -->
             <th>开户户名：</th>
            <td><input name="bankUserName" value="${qualifiedSupply.bankUserName}" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkChina'" size="40"/></td>
            <th>Email地址：</th>
            <td><input name="email" value="${qualifiedSupply.email}" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'email'"size="40"/></td>
          </tr>
                <tr>
            
           <!--  <th>提货人员：</th>
            <td><input name="deliveryPersonnel" value="${qualifiedSupply.deliveryPersonnel}" type="text" class="easyui-validatebox text1" data-options="required:false"size="40"/></td>
            -->
          </tr>
          <tr>
            <th valign="top">经营/生产范围：</th>
            <td colspan="3"><textarea name="businessScope" readonly='readonly' id="businessScope" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true">${qualifiedSupply.businessScope}</textarea></td>
          </tr>
          <tr>
          <th></th><td></td><th></th>
          <td align="right"><input name="" type="button" class="btn_small" onclick="$('#drugFromForm').dialog('open')" value="选择剂型"/></td>
          </tr>
            <tr>
            <th valign="top">备注：</th>
            <td colspan="3"><textarea name="remark" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:false">${qualifiedSupply.remark}</textarea></td>
          </tr>
          <tr>
          	<th>停用标识：</th>
          	<td><font style="font-size:12px; color:#727171; font-weight:bold;">启用</font><input type="radio" name="useFlag" value="0" checked="checked"/>&nbsp;&nbsp;
          		<font style="font-size:12px; color:#727171; font-weight:bold;">停用</font><input type="radio" name="useFlag" value="1" />&nbsp;&nbsp;
          		<font style="font-size:12px; color:#727171; font-weight:bold;">暂时停用</font><input type="radio" name="useFlag" value="2" />
          		</td>
          </tr>
          <tr>
          	<th>营业执照：</th>
          <% if(StringUtil.isNull(supplier.getBusiness_licence_path())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualifiedSupply.business_licence_path}"><%="营业执照"+StringUtil.fileExtensions(supplier.getBusiness_licence_path())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${qualifiedSupply.id}','${qualifiedSupply.business_licence_path }','yyzz')" value="删除"/>
           </td>
           <%}else{ %>
            <td>
            <input type="file" name="business_licence_path" class="text1" size="40"/>
            </td>
           <%} %>
            <th>法人委托书：</th>
             <% if(StringUtil.isNull(supplier.getAuthorization_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualifiedSupply.authorization_path}"><%="法人委托书"+StringUtil.fileExtensions(supplier.getAuthorization_path())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${qualifiedSupply.id}','${qualifiedSupply.authorization_path}','wtsqs')"/>
             </td>
            <%}else{%>
            	<td>
           		 <input type="file" name="authorization_path" class="text1" size="40"/>
            	</td>
            <%} %>
          <%-- 	<th>营业执照年检：</th>
          	 <% if(StringUtil.isNull(supplier.getBusiness_licence_inspection_path())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualifiedSupply.business_licence_inspection_path}"><%="营业执照"+StringUtil.fileExtensions(supplier.getBusiness_licence_inspection_path())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${qualifiedSupply.id}','${qualifiedSupply.business_licence_inspection_path }','yyzznj')" value="删除"/>
           </td>
           <%}else{ %>
            <td>
            <input type="file" name="business_licence_inspection_path" class="text1" size="40"/>
            </td>
           <%} %>--%>
          </tr>
          <tr>
          	<th>经营/生产许可证：</th>
             <% if(StringUtil.isNull(supplier.getLicence_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualifiedSupply.licence_path}"><%="经营/生产许可证"+StringUtil.fileExtensions(supplier.getLicence_path())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${qualifiedSupply.id}','${qualifiedSupply.licence_path}','xkz')"/>
             </td>
            <%}else{%>
            	<td>
           		 <input type="file" name="licence_path" class="text1" size="40"/>
            	</td>
            <%} %>
             <th>GSP/GMP证书：</th>
             <% if(StringUtil.isNull(supplier.getGsp_certificate_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualifiedSupply.gsp_certificate_path}"><%="GSP/GMP证书"+StringUtil.fileExtensions(supplier.getGsp_certificate_path())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${qualifiedSupply.id}','${qualifiedSupply.gsp_certificate_path}','gsp')"/>
             </td>
            <%}else{%>
            	<td>
           		 <input type="file" name="gsp_certificate_path" class="text1" size="40"/>
            	</td>
            <%} %>
          </tr>
          <tr>
          	 <th>组织机构代码证：</th>
             <% if(StringUtil.isNull(supplier.getOrganization_code_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualifiedSupply.organization_code_path}"><%="组织机构代码证"+StringUtil.fileExtensions(supplier.getOrganization_code_path())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${qualifiedSupply.id}','${qualifiedSupply.organization_code_path}','zzjgdm')"/>
             </td>
            <%}else{%>
            	<td>
           		 <input type="file" name="organization_code_path" class="text1" size="40"/>
            	</td>
            <%} %>
             <th>组织机构代码证年检：</th>
             <% if(StringUtil.isNull(supplier.getOrganization_code_inspection_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualifiedSupply.organization_code_inspection_path}"><%="组织机构代码证年检"+StringUtil.fileExtensions(supplier.getOrganization_code_inspection_path())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${qualifiedSupply.id}','${qualifiedSupply.organization_code_inspection_path}','zzjgdmnj')"/>
             </td>
            <%}else{%>
            	<td>
           		 <input type="file" name="organization_code_inspection_path" class="text1" size="40"/>
            	</td>
            <%} %>
          </tr>
          <tr>
          		<th>质量保证协议：</th>
             <% if(StringUtil.isNull(supplier.getQuality_assurance_path())){ %>
             <td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualifiedSupply.quality_assurance_path}"><%="质量保证协议"+StringUtil.fileExtensions(supplier.getQuality_assurance_path())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${qualifiedSupply.id}','${qualifiedSupply.quality_assurance_path}','zbxy')"/>
             </td>
            <%}else{%>
            	<td>
           		 <input type="file" name="quality_assurance_path" class="text1" size="40"/>
            	</td>
            <%} %>
            
          </tr>
       <tr></tr>
          <tr >
          	<td colspan="2" align="center" valign="top"><input name="" type="button" class="btn_big1" value="新增GSP" onclick="addGSPAccessory()"/></td>
          	<td colspan="2" align="center" valign="top"><input name="" type="button" class="btn_big1" value="新增其它证件" onclick="addOtherPAccessory()"/></td>
          </tr>
        </table>
        <table id ="add_dttachment" class="xx_table2">
         <%
          		Iterator<QulifiedSupplyAccessory> it = accessorySet.iterator();
          		int index = 0;
          		while(it.hasNext()){
          			QulifiedSupplyAccessory accessory = it.next();
          			
          %>
         
          <%if(accessory.getRequest_type().equals("GSP")) {%>
           <tr>
          	<th>GSP/GMP证书号码<span class="required">*</span>：</th>
          	<td><input type='text' name='qualifiedAccessoryLst[<%=index %>].certificateNumber' class='text1'  size='20' value="<%=accessory.getCertificateNumber() %>"/></td>
          	<th>GSP/GMP证书到期时间<span class="required">*</span>：</th>
          	<td>
          		<input type="text" name="qualifiedAccessoryLst[<%=index%>].accessoryDate" class="easyui-datebox" data-options="disabled:false" size="20" style="height: 28px;" value="<%=accessory.getAccessoryDate() %>"/>
          	</td>
          	<% if(StringUtil.isNull(accessory.getAccessoryPath())){ %>
          	<td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=<%=accessory.getAccessoryPath() %>"><%="GSP/GMP证书附件"+StringUtil.fileExtensions(accessory.getAccessoryPath())%></a>
              	<input type="hidden" name="qualifiedAccessoryLst[<%=index%>].accessoryPath" value="<%=accessory.getAccessoryPath() %>">
              	<input name="" type="button" class="btn_small" onclick="deleteFile('<%=accessory.getAccssoryId() %>','<%=accessory.getAccessoryPath() %>','')" value="删除"/>
             </td>
          	<%} else{ %>
          	<td>
				<input type='file' name='<%=accessory.getRequest_name() %>' class='text1' size='20' />          	
          	</td>
          	<%} %>
          	
          	<td>
          		<input type="hidden" name="qualifiedAccessoryLst[<%=index%>].request_name" value="<%=accessory.getRequest_name() %>">
          		<input type="hidden" name="qualifiedAccessoryLst[<%=index%>].request_type" value="<%=accessory.getRequest_type() %>">
          		<input type="hidden" name="qualifiedAccessoryLst[<%=index%>].accssoryId" value="<%=accessory.getAccssoryId() %>">
          	</td>
          </tr>
          <%
          	}else{
          	
           %>
           <tr>
           <th>证书号码<span class="required">*</span>：</th>
          	<td><input type='text' name='qualifiedAccessoryLst[<%=index %>].certificateNumber' class='text1'   size='20' value="<%=accessory.getCertificateNumber() %>"/></td>
          	<th>证书到期时间<span class="required">*</span>：</th>
          	<td>
          		<input type="text" name="qualifiedAccessoryLst[<%=index%>].accessoryDate" class="easyui-datebox" data-options="disabled:false" size="20" style="height: 28px;" value="<%=accessory.getAccessoryDate() %>"/>
          	</td>
          	<% if(StringUtil.isNull(accessory.getAccessoryPath())){ %>
          	<td>
             	<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=<%=accessory.getAccessoryPath() %>"><%="证书附件"+StringUtil.fileExtensions(accessory.getAccessoryPath())%></a>
              	<input type="hidden" name="qualifiedAccessoryLst[<%=index%>].accessoryPath" value="<%=accessory.getAccessoryPath() %>">
              	<input name="" type="button" class="btn_small" onclick="deleteFile('<%=accessory.getAccssoryId() %>','<%=accessory.getAccessoryPath() %>,'')" value="删除"/>
              	
            </td>
          	<%} else{ %>
          	<td>
				<input type='file' name='<%=accessory.getRequest_name() %>' class='text1'  size='20'/>         	
          	</td>
          	<%} %>
          	
          	<td>
          		<input type="hidden" name="qualifiedAccessoryLst[<%=index%>].request_name" value="<%=accessory.getRequest_name() %>">
          		<input type="hidden" name="qualifiedAccessoryLst[<%=index%>].request_type" value="<%=accessory.getRequest_type() %>">
          		<input type="hidden" name="qualifiedAccessoryLst[<%=index%>].accssoryId" value="<%=accessory.getAccssoryId() %>">
          	</td>
          </tr>
         <%} index++; }%>
        </table>
        <table id ="add_drugFroms" class="xx_table2">
         <%
          		Iterator<QulifiedSupplyDrugFroms> dit = drugFromsSet.iterator();
          	    index = 0;
          		while(dit.hasNext()){
          			QulifiedSupplyDrugFroms accessory = dit.next();
          			
          %>
           <tr>
          	<th>GMP剂型名称<span class="required">*</span>：</th>
          	<td><input type='text' readonly='readonly'  class='text1'  size='20' value="<%=accessory.getDrugFormDictionary().getFormName() %>"/></td>
          	<th>GMP证书剂型到期时间<span class="required">*</span>：</th>
          	<td>
          		<input type="text" readonly='readonly' name="qulifiedSupplyDrugFromsList[<%=index%>].drugFormDate" class="easyui-datebox" data-options="disabled:false" size="20" style="height: 28px;" value="<%=accessory.getDrugFormDate() %>"/>
          	</td>
          	
          	<td>
          		<input type="hidden" name="qulifiedSupplyDrugFromsList[<%=index%>].id" value="<%=accessory.getId() %>">
          		<input type="hidden" name="qulifiedSupplyDrugFromsList[<%=index%>].qualifiedSuppliers_id" value="<%=accessory.getQualifiedSuppliers_id() %>">
          		<input type="hidden" name="qulifiedSupplyDrugFromsList[<%=index%>].drugFormDictionary_id" value="<%=accessory.getDrugFormDictionary_id() %>">
          	</td>
          </tr>
         
         <% index++; }%>
        </table>
       <table border="0" cellspacing="0" cellpadding="0" class="xx_table2">
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
            	<input type="hidden" id="id" name="id" value="${qualifiedSupply.id}"/>
            	<input type="hidden" name="reason" id="reason"/>
            	<input type="hidden" id="sales_deputy" name="sales_deputy" value="${qualifiedSupply.sales_deputy.id }">
                <input name="" type="button" class="btn_big" value="保存" onclick="$('#dialog').dialog('open')"/>
                <input name="" type="button" class="btn_big" value="返回" onclick="goBack()"/>
            </td>
            </tr>
        </table>
        <div id="dialog" title="修改原因" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:600">
    	<table>
    	<tr>
            <th valign="top">修改原因：</th>
            <td colspan="3"><textarea name="rejectcause" id="rejectcause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
           	<input type="button" class="btn_big" onclick="update_hggys()" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
        </div>
        <div id="drugFromForm" title="选择剂型" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:520">
    <ul style="padding: 10px 25px;">
        <c:forEach items="${drugFromList}" var="list" varStatus="status">
        <li>
        <div style="float: left;padding: 4px;">
        <input type="checkbox" id ="drugFromItem" name="drugFromItem" value="${list.id}"/>${list.formName}
        </div>
        </li>
        </c:forEach>
    </ul> 
    <table>
    <tr>
        <td colspan="4" align="center" valign="bottom">
        <input type="button" class="btn_big" onclick="updateScope(${qualifiedSupply.id})" value="确定">
        <input type="button" class="btn_big" onclick="$('#drugFromForm').dialog('close')" value="取消">
    </tr>
    </table> 
    </div>
	</form>
	
	 
    <form action="updateScope.html" name="editScope" id="editScope" method="post" enctype="multipart/form-data">
          <input type="hidden" id="id" name="id" value="${qualifiedSupply.id}"/>
          <input type="hidden" name="drugFromList" id="drugFromList" value=""/>
    </form>
	<script type="text/javascript">
	function deleteFile(id,fileName,type){
			$.post("qualifiedSupplierFile.html",{
				id : id,
				fileName : fileName,
				type : type
			},function(data){
			//alert(data);
				var json = jsonParse(data);
			//	alert(json);
				if(json.success!=null && json.success!=""){
					alert(decodeURI(json.success));
				}
				location.reload();
			});
		}
	$("#commonnamebox").combobox({
			filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q) == 0;
			},
			value:""+'${qualifiedSupply.sales_deputy.pinyinCode}'+"_"+'${qualifiedSupply.sales_deputy.id}'
		}
		
	)
	function update_hggys(){
		var  dialog = $("#dialog").dialog();
		var value =  dialog.get(0).getElementsByTagName("textarea")[0].value;
		$("#reason").val(value);
		  $('#edit_hggys').form('submit',{  
			    success: function(data){  
			//  alert(data);
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="hggys.html";
			    }  
			});  
		}
		function addDrugFroms(index,formName,qualifiedSuppliers_id,drugFormDictionary_id){
		var myDate = new Date();
		var drugFormDate = myDate.getFullYear()+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate();
		var tr ="<tr><th>GMP剂型名称<span class='required'>*</span>：</th>"+
			"<td><input type='text' readonly='readonly'  class='text1' value='"+formName+"' size='20'/></td>"+
			"<th width='150'>GMP证书剂型到期时间<span class='required'>*</span>：</th>"+
			"<td><input type='text' id='drugFormDate"+index+"' name='qulifiedSupplyDrugFromsList["+index+"].drugFormDate' value = '"+drugFormDate+"' class='easyui-datebox text1' style='height: 28px;' data-options='required:true' size='20'/></td>"+
			"<td>"+
			"<input type='hidden' name='qulifiedSupplyDrugFromsList["+index+"].id' value=''>"+
			"<input type='hidden' name='qulifiedSupplyDrugFromsList["+index+"].qualifiedSuppliers_id' value='"+qualifiedSuppliers_id+"'/>"+
			"<input type='hidden' name='qulifiedSupplyDrugFromsList["+index+"].drugFormDictionary_id' value='"+drugFormDictionary_id+"'/></td></tr>";
			
			$("#add_drugFroms").append(tr);
			$.parser.parse($('#drugFormDate'+index).parent()); 
	    }
var attachment_index  = "${accssorySize}";
		//alert(attachment_index);
		function addGSPAccessory(){
		var tr ="<tr><th width='150'>GSP/GMP证书号码 <span class='required'>*</span>：</th>"+
			"<td><input type='text' name='qualifiedAccessoryLst["+attachment_index+"].certificateNumber' class='easyui-validatebox text1' data-options='required:true' size='20'/></td>"+
			"<th width='150'>GSP/GMP证书到期时间<span class='required'>*</span>：</th>"+
			"<td><input type='text' id='accsoryCombox_id"+attachment_index+"' name='qualifiedAccessoryLst["+attachment_index+"].accessoryDate' class='easyui-datebox text1' style='height: 28px;' data-options='required:true' size='20'/></td>"+
			"<th width='150'>GSP/GMP证书附件</th>"+
			"<td><input type='file' name='request_name"+attachment_index+"' class='text1' size='20'/></td><td><input type='button' class='btn_big' value='删除' onclick='deleteAccssory(this)'>"+
			"<input type='hidden' name='qualifiedAccessoryLst["+attachment_index+"].request_name' value='request_name"+attachment_index+"'/>"+
			"<input type='hidden' name='qualifiedAccessoryLst["+attachment_index+"].request_type' value='GSP'/> </td></tr>";
			$("#add_dttachment").append(tr);
			$.parser.parse($('#accsoryCombox_id'+attachment_index).parent()); 
			attachment_index++;
	}
	function addOtherPAccessory(){
		var tr ="<tr><th width='150'>证书号码 <span class='required'>*</span>：</th>"+
			"<td><input type='text' name='qualifiedAccessoryLst["+attachment_index+"].certificateNumber' class='easyui-validatebox text1' data-options='required:true' size='20'/></td>"+
			"<th width='150'>证书到期时间<span class='required'>*</span>：</th>"+
			"<td><input type='text' id='accsoryOtherCombox_id"+attachment_index+"' name='qualifiedAccessoryLst["+attachment_index+"].accessoryDate' class='easyui-datebox text1' style='height: 28px;' data-options='required:true' size='20'/></td>"+
			"<th width='150'>证书附件</th>"+
			"<td><input type='file' name='request_name"+attachment_index+"' class='text1' size='20'/></td><td><input type='button' class='btn_big' value='删除' onclick='deleteAccssory(this)'>"+
			"<input type='hidden' name='qualifiedAccessoryLst["+attachment_index+"].request_name' value='request_name"+attachment_index+"'/>"+
			"<input type='hidden' name='qualifiedAccessoryLst["+attachment_index+"].request_type' value='other'/></td></tr>";
			$("#add_dttachment").append(tr);
			$.parser.parse($('#accsoryOtherCombox_id'+attachment_index).parent()); 
			attachment_index++;
	}
	
	function deleteAccssory(obj){
		$(obj).parent().parent().remove();
	}
	function updateScope(qualifiedSuppliers_id){
		var  dialog = $("#drugFromForm").dialog();
		var value = "";
		var str = dialog.get(0).getElementsByTagName("input");
		var index = 0;
		
		$("#add_drugFroms").empty();
		for(var i=0;i<str.length;i++){
		    if(str[i].checked == true){
		        var nodeValue = str[i].nextSibling.nodeValue;
		        nodeValue = nodeValue.substring(0,nodeValue.length - 9) ;
		        value += nodeValue + '，';
		        addDrugFroms(index,nodeValue,qualifiedSuppliers_id,str[i].value);
		        index ++;
		    }
		}
		value=value.substring(0,value.length-1)
		$("#businessScope").val(value);
	}
	//设置停用标识
	setDefaultForRadio("useFlag","${qualifiedSupply.useFlag}");
	</script>
</body>
</html>