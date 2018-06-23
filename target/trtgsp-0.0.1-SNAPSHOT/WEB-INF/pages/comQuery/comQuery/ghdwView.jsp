<%@ page language="java"
    pageEncoding="UTF-8"%>
<%@page import="com.sinosoft.util.StringUtil"%>
<%@page import="com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits"%>
    <%@ include file="/common/taglibs.jsp"%><head>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
QualifiedPurchaseUnits purchaseUnit = (QualifiedPurchaseUnits)request.getAttribute("quaPurchUnit");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查看购货单位</title>
</head>
<body>
<font style="font-family: '宋体'; font-weight: normal; font-size: 12; color: #8d3c01; padding: 10px;">综合查询统计分析&nbsp;>&nbsp;供货单位购货单位&nbsp;>&nbsp;查看购货单位</font>
<form action="update_hgghdw.html" name="edit_hgghdw" id="edit_hgghdw" method="post">
      <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
      <tr>
        	<th>省份<span class="required">*</span>：</th>
        	<td>
        		<select name="shengfen" id="shengfen" class="easyui-validatebox" data-options="required:true" onchange="changeNumber(this)" disabled="disabled" >
        			<option value="">请选择</option>
        		</select>
        	<input value="${quamap}" type="hidden" id="quamap"/>
        	<input type="hidden" value="${shengfenValue}" id="shengfenValue" />
        	</td>
            <th width="150">编号：</th>
            <td><input id="customerNumber" name="customerNumber" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkNumber'" size="40" value="${quaPurchUnit.customerNumber}" readonly="readonly"/></td>
        </tr>
          <tr>
            <th width="150">客户名称：</th>
            <td><input name="customerName" type="text" class="easyui-validatebox text1" data-options="required:true" size="40" value="${quaPurchUnit.customerName }" onchange="ajaxChanggeChinaToPinyin(this,'pinyinCode')" readonly="readonly"/></td>
              <th>拼音码：</th>
            <td><input type="text" name="pinyinCode" id="pinyinCode" value="${quaPurchUnit.pinyinCode}" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
           
          </tr>
          <tr>
          	<th>企业地址：</th>
          	<td><input type="text" name="address" class="text1" size="40" value="${quaPurchUnit.address}"/></td>
          	<th>邮  编：</th>
            <td><input type="text" name="postalCode" value="${quaPurchUnit.postalCode}" class="easyui-validatebox text1" data-options="required:true,validType:'checkPostCode'" size="40"/></td>
          </tr>
          <tr>
            <th>企业联系电话：</th>
            <td><input type="text" name="companyPhone" value="${quaPurchUnit.companyPhone}" class="easyui-validatebox text1" data-options="required:false" size="40"/></td>
            <th>传  真：</th>
            <td><input type="text" name="portraiture" value="${quaPurchUnit.portraiture}" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
          </tr>
          <tr>
            <th>法  人：</th>
            <td><input type="text" name="corporation" value="${quaPurchUnit.corporation}" class="easyui-validatebox text1" data-options="required:true,validType:['checkChina','length[2,10]']" size="40"/></td>
            <th>纳税人登记号：</th>
            <td><input type="text" name="taxpayeRegisterNo" value="${quaPurchUnit.taxpayeRegisterNo}" class="easyui-validatebox text1" data-options="required:true,validType:'checkCertificate'" size="40"/></td>
          </tr>
          <tr>
            <th>客户电子监管码<span class="required">*</span>：</th>
           <td><input name="electronicMonitoringCode" value="${quaPurchUnit.electronicMonitoringCode }" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
           <th>质量负责人<span class="required">*</span>：</th>
           <td>
           		<input type="text" name="qualityPrincipal" value="${quaPurchUnit.qualityPrincipal }" class="easyui-validatebox text1" data-options="required:true" size="40">
           </td>
          </tr>
          <tr>
          	 <th>采购人员<span class="required">*</span>：</th>
            <td>
            <input name="salesDeputy" type="text" class="text1" size="40" value="${quaPurchUnit.procurementStaff.procurementName}" readonly="readonly"/>
            <!-- 
             <input type="text" class="easyui-combobox  text1" data-options="
            required:true,
      	 	valueField: 'id',
      	 	value : '${quaPurchUnit.procurementStaff.procurementName }',
       		textField: 'text',
      		url:'../../firstEnterprise/findProcurementSatffJson.html?personType=0'
      		" name="" id="commonnamebox" size="40"/> -->
      		</td>
      		<th>采购人联系电话：</th>
            <td><input type="text" name="phone" value="${quaPurchUnit.phone}" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
          </tr>
          <tr>
			<th>身份证号:</th>
			<td><input name="IDNumber" type="text" class="text1" size="40" 	value="${quaPurchUnit.procurementStaff.IDNumber}"  readonly="readonly"/></td>
			<th>采购人法人委托书到期日期</th>
			<td><input name="identityCardDate" type="text" class="text1" size="40" value="${quaPurchUnit.procurementStaff.identityCardDate}"  readonly="readonly"/></td>
		  </tr>
           <tr>
            <th>开户日期：</th>
            <td><input type="text" name="accountOpeningDate" value="${quaPurchUnit.accountOpeningDate}" class="easyui-datebox text1" data-options="required:true,validType:'date'" size="40"/></td>
            <th>开户银行：</th>
            <td><input type="text" name="bankName" value="${quaPurchUnit.bankName}" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
          </tr>
          <tr>
            <th>银行账户：</th>
            <td><input type="text" name="bankNumber" value="${quaPurchUnit.bankNumber}" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
             <th>税票信息地址<span class="required">*</span>：</th>
            <td><input name="taxReceiptAddress" value="${quaPurchUnit.taxReceiptAddress }" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
          </tr>
           <tr>
           
         	<th>税票信息电话<span class="required">*</span>：</th>
           <td><input name="taxReceiptPhone" value="${quaPurchUnit.taxReceiptPhone }" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
            <th>发货地址<span class="required">*</span>：</th>
            <td><input name="shippingAddress" value="${quaPurchUnit.shippingAddress}" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
          </tr>
          <tr>
         	<th>收货人<span class="required">*</span>：</th>
           <td><input name="consigneeName" value="${quaPurchUnit.consigneeName }" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
            <th>收货人电话<span class="required">*</span>：</th>
            <td><input name="consigneePhone" value="${quaPurchUnit.consigneePhone }" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
          </tr>
          <tr>
          	<th>提货人员：</th>
          	<td>
          		<input type="text" name="receivingPerson" value="${quaPurchUnit.procurementReceiving.procurementName }" class="text1" readonly="readonly" size=40/>
          	</td>
          </tr>
          <tr>
			<th>身份证号:</th>
			<td><input name="IDNumber2" type="text" class="text1" size="40"  value="${quaPurchUnit.procurementReceiving.IDNumber}"  readonly="readonly"/></td>
			<th>提货人法人委托书到期日期</th>
			<td><input name="powerOfAttorneyDate2" type="text" class="text1"  size="40" value="${quaPurchUnit.procurementReceiving.powerOfAttorneyDate}"  readonly="readonly"/></td>
		  </tr>
             <tr>
            <th>营业执照到期时间：</th>
            <td><input type="text" name="busLiceExpiraDate" value="${quaPurchUnit.busLiceExpiraDate}" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>
            <%-- <th>营业执照年检时间：</th>
            <td><input type="text" name="busLiceAnnualSurvey" value="${quaPurchUnit.busLiceAnnualSurvey}" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>
           --%>
                       <th>法人委托书到期时间：</th>
            <td><input type="text" name="authorizationDate" value="${quaPurchUnit.authorizationDate}" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>
          </tr>
            <tr>
             <th>经营/生产许可证到期时间期：</th>
            <td><input type="text" name="liceExpirationDate" value="${quaPurchUnit.liceExpirationDate}" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>
            <th>GSP截止日期：</th>
            <td><input type="text" name="gpsExpirationDate" value="${quaPurchUnit.gpsExpirationDate}" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>
          </tr>
          <tr>
           <th>组织机构代码到期时间：</th>
            <td><input type="text" name="organizationCodeDate" value="${quaPurchUnit.organizationCodeDate}" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>
            <th>组织机构代码年检时间：</th>
            <td><input type="text" name="organizationCodeInspectionDate" value="${quaPurchUnit.organizationCodeInspectionDate}" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>
          </tr>
           <tr>
           <th>质量保证书到期时间：</th>
            <td><input type="text" name="qualityAssuranceDate" value="${quaPurchUnit.qualityAssuranceDate}" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/></td>
			<th>企业经营类型：</th>
            <td><select name="economicNature" id="economicNature">
            	<option value="1">批发</option>
				<option value="2">零售</option>
				<option value="3">零售（连锁）</option>
				<option value="4">医疗机构</option>
				<option value="5">其他</option>
            </select></td>
          </tr>
         
          <tr>
            <th valign="top">生产/经营范围：</th>
            <td colspan="3"><textarea name="businessScope" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true">${quaPurchUnit.businessScope }</textarea></td>
          </tr>
            <tr>
            <th valign="top">备注：</th>
            <td colspan="3"><textarea name="remark" cols="94" rows="4" class="textarea"  >${quaPurchUnit.remark}</textarea></td>
          </tr>
          <tr>
          <th width="150">销售类别：</th>
          <td>
			<input type="checkbox" name="saleCompany" id="returnType1" value="1" /><font style="font-size:12px; color:#727171; font-weight:bold;">经营</font>
			<input type="checkbox" name="saleCompany" id="returnType2" value="2" /><font style="font-size:12px; color:#727171; font-weight:bold;">新品</font>
			<input type="checkbox" name="saleCompany" id="returnType3" value="3" /><font style="font-size:12px; color:#727171; font-weight:bold;">市场</font>
		  	<input type="hidden" id="saleCompanyValue" value="${quaPurchUnit.saleCompany}"/>
		  </td>
		   <th>开户公司<span class="required">*</span>：</th>
		  <td>
		  <select name="openCompany" id ="openCompany" class="easyui-validatebox text1">
				<option value="">请选择开户公司</option>
				<option value="0">经营</option>
				<option value="1">新品</option>
				<option value="2">市场</option>		  
		  </select>
		  </td>
          </tr>
          </table>
          <table border="0" cellspacing="0" cellpadding="0" class="xx_table2">
           <tr>
          	<th>旧客户编号<span class="required">*</span>：</th>
          	<td><span id="oldNumber" ></span>
          		<input type="hidden" id="oldNo" value="${quaPurchUnit.oldNo}"/>
          	</td>
          </tr>
          <tr>
          	<th>停用标识：</th>
          	<td><font style="font-size:12px; color:#727171; font-weight:bold;">启用</font><input type="radio" name="userFlag" value="0" checked="checked"/>&nbsp;&nbsp;
          		<font style="font-size:12px; color:#727171; font-weight:bold;">停用</font><input type="radio" name="userFlag" value="1" />&nbsp;&nbsp;
          		<font style="font-size:12px; color:#727171; font-weight:bold;">暂时停用</font><input type="radio" name="userFlag" value="2" />
          	</td>
          </tr>
                     <tr>
            <th>营业执照：</th>
            <% if(StringUtil.isNull(purchaseUnit.getBusinessLicencePath())){ %>
           <td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${quaPurchUnit.businessLicencePath}"><%="营业执照"+StringUtil.fileExtensions(purchaseUnit.getBusinessLicencePath())%></a>
           </td>
           <%}else{ %>
              <td><input name=authorizationPath type="text" class="easyui-validatebox text1" size="40"  value="未上传附件"/></td>
           <%} %>
         <%--    <th>营业执照年检：</th>
            <% if(StringUtil.isNull(purchaseUnit.getBusinessLicenseInspectionPath())){ %>
           <td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${quaPurchUnit.businessLicenseInspectionPath}"><%= "营业执照年检"+StringUtil.fileExtensions(purchaseUnit.getBusinessLicenseInspectionPath())%></a>
           </td>
           <%}else{ %>
            <td><input name=authorizationPath type="text" class="easyui-validatebox text1" size="40"  value="未上传附件"/></td>
           <%} %>--%>
            <th>法人委托书：</th>
            <% if(StringUtil.isNull(purchaseUnit.getAuthorizationPath())){ %>
           <td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${quaPurchUnit.authorizationPath}"><%="法人委托书"+StringUtil.fileExtensions(purchaseUnit.getAuthorizationPath())%></a>
           </td>
           <%}else{ %>
             <td><input name=authorizationPath type="text" class="easyui-validatebox text1" size="40"  value="未上传附件"/></td>
           <%} %>
          </tr>
         
           <tr>
            <th>经营/生产许可证：</th>
            <% if(StringUtil.isNull(purchaseUnit.getLicencePath())){ %>
           <td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${quaPurchUnit.licencePath}"><%="经营/生产许可证"+StringUtil.fileExtensions(purchaseUnit.getLicencePath())%></a>
           </td>
           <%}else{ %>
             <td><input name=authorizationPath type="text" class="easyui-validatebox text1" size="40"  value="未上传附件"/></td>
           <%} %>
            <th>GSP/GMP证书：</th>
            <% if(StringUtil.isNull(purchaseUnit.getGspCertificatePath())){ %>
           <td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${quaPurchUnit.gspCertificatePath}"><%="GSP/GMP证书"+StringUtil.fileExtensions(purchaseUnit.getGspCertificatePath())%></a>
           </td>
           <%}else{ %>
            <td><input name=authorizationPath type="text" class="easyui-validatebox text1" size="40"  value="未上传附件"/></td>
           <%} %>
            
          </tr>
           <tr>
            <th>组织机构代码证：</th>
            <% if(StringUtil.isNull(purchaseUnit.getOrganizationCodePath())){ %>
           <td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${quaPurchUnit.organizationCodePath}"><%="组织机构代码证"+StringUtil.fileExtensions(purchaseUnit.getOrganizationCodePath())%></a>
           </td>
           <%}else{ %>
              <td><input name=authorizationPath type="text" class="easyui-validatebox text1" size="40"  value="未上传附件"/></td>
           <%} %>
            <th>组织机构代码证年检：</th>
            <% if(StringUtil.isNull(purchaseUnit.getOrganizationCodeInspectionPath())){ %>
           <td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${quaPurchUnit.organizationCodeInspectionPath}"><%="组织机构代码证年检"+StringUtil.fileExtensions(purchaseUnit.getOrganizationCodeInspectionPath())%></a>
           </td>
           <%}else{ %>
              <td><input name=authorizationPath type="text" class="easyui-validatebox text1" size="40"  value="未上传附件"/></td>
           <%} %>
          </tr>
           <tr>
            <th>质量保证协议：</th>
            <% if(StringUtil.isNull(purchaseUnit.getQualityAssurancePath())){ %>
           <td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${quaPurchUnit.qualityAssurancePath}"><%="质量保证协议"+StringUtil.fileExtensions(purchaseUnit.getQualityAssurancePath())%></a>
           </td>
           <%}else{ %>
               <td><input name=authorizationPath type="text" class="easyui-validatebox text1" size="40"  value="未上传附件"/></td>
           <%} %>
           
          </tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
                <input name="" type="button" class="btn_big" value="返回" onclick="goBack()"/>
            </td>
          <td>
        </table>
      
    </form>   
    <script type="text/javascript">
var s=0;
    function find(){
	var oldNumber="oldNumber"+s;
	var deloldNumber="deloldNumber"+s;
		$("#oldNumber").append("<input type='text' id='"+oldNumber+"' class='text1' size=40 name='oldNumber' readonly='readonly'/>&nbsp;&nbsp;");
		if(s%2==0)
		$("#oldNumber").append("</tr>")
		//$("#oldNumber").append("<input type='button' id=\""+deloldNumber+"\" value='删除' onclick=\"del("+s+")\" name='oldNumber' class='btn_big'/><br>");
		s++;
	}
	function del(vals){
		$("#oldNumber"+vals).next().remove();
		$("#oldNumber"+vals).remove();
		$("#deloldNumber"+vals).remove();
		s--;
	}
	function changeNumber(obj){
		$.post("${ctx}/firstEnterprise/findNumber.html",{
		number : obj.value,
		},function(data){
		if(data){
			$("#customerNumber").val(data);
			}
		});
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
     	$("#oldNumber").append("&nbsp;&nbsp;<input type='text' id='"+oldNumber+"' value='"+b[i]+"' class='text1' size=40 name='oldNumber'/>");
	//	$("#oldNumber").append("<input type='button' id=\""+deloldNumber+"\" value='删除' onclick=\"del("+s+")\" name='oldNumber' class='btn_big'/><br>");
     	s++;
     	}
	});
    function updata_hgghdw(){
    var dialog = $("#dialog").dialog();
    var dialogvalue = dialog.get(0).getElementsByTagName("textarea")[0].value;
    $("#reason").val(dialogvalue);
	var value = $("#commonnamebox").combobox('getText');
	$("#procurement_staff").val(value);
	  $('#edit_hgghdw').form('submit',{  
		    success: function(data){  
		//  alert(data);
			var json = jsonParse(data);
			if(json.success!=null && json.success!=""){
				alert(decodeURI( json.success));
			}
			location.href="hgghdw.html";
		    }  
		});  
	}
	//alert("${quaPurchUnit.openCompany}");
	setDefaultForCheckbox("economicNature","${quaPurchUnit.economicNature}");
    setDefaultForRadio("userFlag","${quaPurchUnit.useFlag}");
    setDefaultForCheckbox("openCompany","${quaPurchUnit.openCompany}");
    
    </script>
</body>
</html>