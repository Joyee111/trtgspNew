<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sinosoft.util.StringUtil"%>
<%@ page import="com.sinosoft.varietyManger.firstVarietyManger.model.FirstVariety"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
FirstVariety  variety =(FirstVariety) request.getAttribute("firstVariety");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查看已驳回首营品种</title>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">品种管理&nbsp;>&nbsp;首营品种&nbsp;>&nbsp;查看已驳回首营品种</font>
	<form action="rejectFirstVariety.html" name="reject_syybybh" id="reject_syybybh" method="post" enctype="multipart/form-data">
		 	<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span  >1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span >2</span>
                <br />已保存
            </td>
            <td valign="top" align="center" width="20%">
            	<span>3</span>
                <br />审核
            </td>
            <td valign="top" align="center" width="20%">
            	<span class="ok">4</span>
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
            <th width="150">通用名称<span class="required">*</span>：</th>
            <td><input name="commonName" value="${firstVariety.commonName}" type="text"  size="40" readonly="readonly"/></td>
            <th width="150">剂    型<span class="required">*</span>：</th>
            <td><input name="dosageForm" value="${firstVariety.dosageForms.formName}"  type="text"  size="40" maxlength="20" readonly="readonly"/></td>
          </tr>
           <tr>
            <th width="150">货号<span class="required">*</span>：</th>
            <td><input name="medicinalNo" value="${firstVariety.medicinalNo}" type="text" class="text1" size="40" readonly="readonly"/></td>
            <th>批准文号<span class="required">*</span>：</th>
            <td><input name="licenseNumber" value="${firstVariety.licenseNumber}" type="text"  size="40" readonly="readonly"/></td>
          </tr>
          <tr>
            <th>生产企业<span class="required">*</span>：</th>
            <td><input name="produce_no" value="${firstVariety.produceNo.customerName}" type="text"  size="40" readonly="readonly"/></td>
           <th>供货单位<span class="required">*</span>：</th>
            <td><input name="supply_unit" value="${firstVariety.supplyUnit.customerName}" class="text1" type="text" size="40" readonly="readonly"/></td>
          </tr>
       
          <tr>
          <th>药品规格<span class="required">*</span>：</th>
            <td><input name="medicSpecifications" type="text" value="${firstVariety.medicSpecifications}" class="text1" size="40" readonly="readonly"/></td>
             <th>规格<span class="required">*</span>：</th>
            <td><input name="specifications" value="${firstVariety.specifications}" type="text"  size="40" readonly="readonly"/></td>
          </tr>
             <tr>
             <th>单位<span class="required">*</span>：</th>
            <td><input name="unit" type="text" value="${firstVariety.unit}" class="easyui-validatebox text1" size="40" readonly="readonly"/></td>
            <th>质量标准依据<span class="required">*</span>：</th>
            <td><input name="qualityStandardName" value="${firstVariety.qualityStandardName}" type="text"  size="40"  readonly="readonly"/></td>
          </tr>
          <tr>
            <th>药品类别<span class="required">*</span>：</th>
            <td>
             <select name="drugCategor" id="drugCategor" class="easyui-validatebox text1" data-options="required:true" disabled="disabled" >
            	<option value="">请选择药品类别</option>
            	<option value="中成药">中成药</option>
            	<option value="化学药制剂">化学药制剂</option>
            	<option value="抗生素">抗生素</option>
            	<option value="生化药品">生化药品</option>
            </select>
            </td>
             <th>药品管理<span class="required">*</span>：</th>
            <td>
             <select name="specialManagement" id="specialManagement" class="easyui-validatebox text1" data-options="required:true" disabled="disabled" >
            	<option value="">请选择药品类别</option>
            	<option value="一般药品">一般药品</option>
            	<option value="ＯＴＣ">ＯＴＣ</option>
            	<option value="食品">食品</option>
            	<option value="保健品">保健品</option>
            	<option value="含麻黄碱制剂">含麻黄碱制剂</option>
            	<option value="专门管理要求药品">专门管理要求药品</option>
            	<option value="其它">其它</option>
            </select>
            </td>
          </tr>
          
           <tr>
              <th>存储条件<span class="required">*</span>：</th>
            <td>
            <select name="storageConditions" id="storageConditions" class="text1" disabled="disabled" >
            	<option value="">请选择存储条件</option>
            	<option value="常温">常温</option>
            	<option value="阴凉">阴凉</option>
            	<option value="专门管理要求药品">专门管理要求药品</option>
            </select>
            </td>
             <th>内服外用<span class="required">*</span>：</th>
          
            <td>
            <select name="storageStore" id="storageStore" class="text1" disabled="disabled" >
            	<option value="">请选择内服外用</option>
            	<option value="内服">内服</option>
            	<option value="外用">外用</option>
            	<!--  <option value="阴凉药品库">阴凉药品库</option>
            	<option value="含麻黄碱药品库">含麻黄碱药品库</option>-->
            </select>
            </td>
          </tr>
          
          <tr>
          	<th>注册商标<span class="required">*</span>：</th>
            <td><input name="registeredTrademarks" value="${registeredTrademarks.validDate}" class="text1" type="text"  maxlength="20"  readonly="readonly"/></td>
          	<th>有效期（月）<span class="required">*</span>：</th>
            <td><input name="validDate" value="${firstVariety.validDate}" class="text1" type="text"  maxlength="20"  readonly="readonly"/></td>
          </tr>
          <tr>  
          	<th>受托方企业名称<span class="required"></span>：</th>
            <td><input name="trusteeEnterprise" value="${firstVariety.trusteeEnterprise}"type="text" class="easyui-validatebox text1" size="40" data-options="" maxlength="100" /></td>
           
            <th>经营公司<span class="required">*</span>：</th>
            <td>
				<label for="" style="font-size:12px; color:#727171; font-weight:bold;">经营</label>
				<input disabled="disabled" type="radio" name="departmentId" value="1001"  />
				<label for="" style="font-size:12px; color:#727171; font-weight:bold;">新品</label>
				<input disabled="disabled" type="radio" name="departmentId" value="2001" />
				<label for="" style="font-size:12px; color:#727171; font-weight:bold;">市场</label>
				<input disabled="disabled" type="radio" name="departmentId" value="3001" />
			</td>
          </tr>s
          <tr>
            <th valign="top">药品功能<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="function" cols="94" rows="4" readonly="readonly">${firstVariety.function}</textarea></td>
          </tr>
          <tr>
            <th valign="top">驳回原因<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="rejectReason" cols="94" rows="4" readonly="readonly">${firstVariety.rejectReason}</textarea></td>
          </tr>
          <%-- 
          <tr>
            <th>厂商证照：</th>
            <% if(StringUtil.isNull(variety.getManufacturerLicensePath())){ %>
            	<td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${firstVariety.manufacturerLicensePath}"><%="厂商证照"+StringUtil.fileExtensions(variety.getManufacturerLicensePath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${firstVariety.id}','${firstVariety.manufacturerLicensePath}','cszz')" value="删除"/>
                </td>
            <%}else{ %>
             <td>
            <input type="text" name="h" class="text1" value="未上传附件" size="40" readonly="readonly"/>
            </td>
            <%} %>
            <th>注册商标：</th>
            <% if(StringUtil.isNull(variety.getRegisteredTrademarkPath())){ %>
            	<td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${firstVariety.registeredTrademarkPath}"><%="注册商标"+StringUtil.fileExtensions(variety.getRegisteredTrademarkPath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${firstVariety.id}','${firstVariety.registeredTrademarkPath}','zcsb')" value="删除"/>
                </td>
            <%}else{ %>
            <td>
            <input type="text" name="" value="未上传附件" readonly="readonly" class="text1" size="40"/>
            </td>
            <%} %>
          </tr>
          --%>
          <tr>
            <th>药品注册批准文件：</th>
            <% if(StringUtil.isNull(variety.getApprovalDocumentPath())){ %>
            	<td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${firstVariety.approvalDocumentPath}"><%="药品注册批准文件"+StringUtil.fileExtensions(variety.getApprovalDocumentPath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${firstVariety.id}','${firstVariety.approvalDocumentPath}','pzwj')" value="删除"/>
                </td>
            <%}else{ %>
            <td>
            <input type="text" name="" value="未上传附件" readonly="readonly"  class="text1" size="40"/>
            </td>
            <%} %>
            <th>质量标准依据：</th>
             <% if(StringUtil.isNull(variety.getQualityStandardPath())){ %>
            	<td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${firstVariety.qualityStandardPath}"><%="质量标准依据"+StringUtil.fileExtensions(variety.getQualityStandardPath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${firstVariety.id}','${firstVariety.qualityStandardPath}','zlbz')" value="删除"/>
                </td>
            <%}else{ %>
            <td>
            <input type="text" name="" value="未上传附件" readonly="readonly" class="text1" size="40"/>
            </td>
            <%} %>
          </tr>
          <tr>
            <th>包装情况：</th>
              <% if(StringUtil.isNull(variety.getPackingPath())){ %>
            	<td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${firstVariety.packingPath}"><%="包装情况"+StringUtil.fileExtensions(variety.getPackingPath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${firstVariety.id}','${firstVariety.packingPath}','bzqk')" value="删除"/>
                </td>
            <%}else{ %>
            <td>
            <input type="text" name="" value="未上传附件" readonly="readonly" class="text1" size="40"/>
            </td>
            <%} %>
            <th>标签、说明书：</th>
                    <% if(StringUtil.isNull(variety.getInstructionsPath())){ %>
            	<td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${firstVariety.instructionsPath}"><%="标签、说明书"+StringUtil.fileExtensions(variety.getInstructionsPath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${firstVariety.id}','${firstVariety.instructionsPath}','bqsm')" value="删除"/>
                </td>
            <%}else{ %>
            <td>
            <input type="text" name="" value="未上传附件" readonly="readonly" class="text1" size="40"/>
            </td>
            <%} %>
          </tr>
          <%-- 
            <tr>
          	<th>检验报告书:</th>
                    <% if(StringUtil.isNull(variety.getCheckoutReportpath())){ %>
            	<td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${firstVariety.checkoutReportpath}"><%="检验报告书"+StringUtil.fileExtensions(variety.getCheckoutReportpath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${firstVariety.id}','${firstVariety.checkoutReportpath}','jybg')" value="删除"/>
                </td>
            <%}else{ %>
            <td>
            <input type="text" name="" value="未上传附件" class="text1" size="40"/>
            </td>
            <%} %>
          <th>注册证：</th>
            <%if(StringUtil.isNull(variety.getMedcRegistrApprovalPath())){ %>
            <td>
            <img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${firstVariety.medcRegistrApprovalPath}"><%="注册证"+StringUtil.fileExtensions(variety.getMedcRegistrApprovalPath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${firstVariety.id}','${firstVariety.medcRegistrApprovalPath}','ypzcpzwj')" value="删除"/>
            </td>
            <%}else { %>
            <td>
             <input type="text" name="" value="未上传附件" class="text1" size="40"/>
             </td>
            <%} %>
          </tr>--%>
          <tr>
            <th>注册证到期日<span class="required">*</span>：</th>
            <td>
            <input type="text" name="medcRegistrApprovalDate" class="easyui-datebox text1" value="${firstVariety.medcRegistrApprovalDate}" data-options="disabled:true,validType:'date'" size="35"/>
            </td>
          </tr>
       
   
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
           		 <input type="hidden" id="save_type" name="save_type" value=""/>
           		 <input type="hidden" name="id" value="${firstVariety.id}">
                 <input name="" type="submit" class="btn_big" value="确认驳回" />
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
               
            </td>
            </tr>
        </table>
       
	</form>
	
<script type="text/javascript">
	(function(){
		$()
	})
	setDefaultForCheckbox("drugCategor", "${firstVariety.drugCategor}");
	setDefaultForCheckbox("specialManagement","${firstVariety.specialManagement}");
	setDefaultForCheckbox("storageConditions","${firstVariety.storageConditions}");
	setDefaultForCheckbox("storageStore","${firstVariety.storageStore}");
	setDefaultForRadio("isfood","${firstVariety.isfood}");
	setCheckByName("departmentId","${firstVariety.departmentId}");
</script>
</body>
</html>