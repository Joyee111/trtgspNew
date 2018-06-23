<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sinosoft.util.StringUtil"%>
<%@ page import="com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
QualityMidicine  variety =(QualityMidicine) request.getAttribute("qualityMidicine");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>品种查询</title>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;品种查询&nbsp;>&nbsp;品种查询查看</font>
	<form action="updateQulidiedMedicinal.html" name="edit_hgypda" id="edit_hgypda" method="post" enctype="multipart/form-data">
        <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
          <tr>
            <th width="150">通用名称：</th>
            <td><input name="commonname" value="${qualityMidicine.commonname}" type="text" readonly="readonly" class="easyui-validatebox text1"  size="40"/></td>
            <th width="150">剂    型：</th>
           
            <td><input name="dosageform.formName" value="${qualityMidicine.dosageforms.formName}" type="text" readonly="readonly" class="easyui-validatebox text1"  size="40"/></td>
          </tr>
            <tr>
            <th width="150">货号：</th>
            <td><input name="medicinalNo" value="${qualityMidicine.medicinalNo}" type="text" readonly="readonly" class="easyui-validatebox text1"  size="40" /></td>
            <th>批准文号：</th>
            <td><input name="licensenumber" value="${qualityMidicine.licensenumber}" type="text" readonly="readonly" class="easyui-validatebox text1"  size="40"/></td>
          </tr>
          <tr>
            <th>生产企业：</th>
              <td><input name="produceno.customerName" value="${qualityMidicine.produceno.customerName}" type="text" readonly="readonly" class="easyui-validatebox text1"  size="40"/></td>
           
			<th>供货单位：</th>
            <td><input name="supplyUnit.customerName" value="${qualityMidicine.supplyUnit.customerName}" type="text" readonly="readonly" class="easyui-validatebox text1"  size="40"/></td>
           
            
          </tr>
          
          <tr>
            <th>药品规格：</th>
            <td><input name="massSpecifications" value="${qualityMidicine.massSpecifications}" type="text" readonly="readonly" class="easyui-validatebox text1"  size="40"/></td>
            <th>包装规格：</th>
            <td><input name="specifications" value="${qualityMidicine.specifications}" type="text" readonly="readonly" class="easyui-validatebox text1" size="40"/></td>
            
          </tr>
          <tr>
            <th>单位：</th>
            <td><input name="unit" value="${qualityMidicine.unit}" type="text" readonly="readonly" class="easyui-validatebox text1" size="40" /></td>
            <th>质量标准依据：</th>
            <td><input name="qualityMidicine.qualitystandardpath" value="${qualityMidicine.qualityStandardName}" type="text" readonly="readonly" class="easyui-validatebox text1"  size="40"/></td>
          </tr>
         
          <tr>
          <th>药品类别：</th>
           <td><input name="qualityMidicine.medicinecategory" value="${qualityMidicine.medicinecategory}" type="text" readonly="readonly" class="easyui-validatebox text1"  size="40"/></td>
          <th>存储条件：</th>
       <td><input name="qualityMidicine.medicinalAttribute" value="${qualityMidicine.medicinalAttribute}" type="text" readonly="readonly" class="easyui-validatebox text1"  size="40"/></td>
          </tr>
           <tr>
            <th>商品名：</th>
            <td><input name="tradename" value="${qualityMidicine.tradename}" type="text" readonly="readonly" class="easyui-validatebox text1" size="40"  /></td>
            <th>药品有效期：</th>
            <td><input name="validdate" value="${qualityMidicine.validdate}" type="text" readonly="readonly" class="text1" size="40"  maxlength="20"/></td>
          </tr>
          <tr>
          <th>养护周期：</th>
            <td><input name="maintainCycle" value="${qualityMidicine.maintainCycle}" readonly="readonly" type="text" class="easyui-validatebox text1" size="40" /></td>
            <th>药品注册文件到期日期：</th>
            <td>
            <input type="text" name="medcRegistrApprovalDate" class="easyui-datebox text1" data-options="validType:'date'" readonly="readonly" value="${qualityMidicine.medcRegistrApprovalDate}" size="35"/>
            </td>
          </tr>
          <tr>
           <th>药品管理<span class="required">*</span>：</th>
            <td>
                <select name="medicineManagement" id="medicineManagement" class="easyui-validatebox text1" data-options="required:true" disabled="disabled">
                    <option value="">请选择药品类别</option>
		            <option value="一般药品" selected="selected">一般药品</option>
		            <option value="专门管理要求药品">专门管理要求药品</option>
               </select>

            </td> 
            <th>内服外用<span class="required">*</span>：</th>
            <td>
            <select name="storageStore" id="storageStore" class="easyui-validatebox text1" data-options="required:true" disabled="disabled">
            	<option value="">请选择内服外用</option>
            	<option value="内服">内服</option>
            	<option value="外用">外用</option>
            	<option value="阴凉药品库">阴凉药品库</option>
            	<option value="含麻黄碱药品库">含麻黄碱药品库</option>
            </select>
            </td>
          </tr> 
          <tr>
          	 <th>受托方企业名称：</th>
            <td><input name="trusteeEnterprise" value="${qualityMidicine.trusteeEnterprise}" readonly="readonly" type="text" class="easyui-validatebox text1" size="40" /></td>
           </tr>
          <tr>
            <th valign="top">药品功能：</th>
            <td colspan="3"><textarea name="function" cols="94" rows="4" class="easyui-validatebox  textarea"  >${qualityMidicine.function}</textarea></td>
          </tr>
          <tr>
            <th>厂商证照：</th>
            <% if(StringUtil.isNull(variety.getManufacturerlicensepath())){ %>
            	<td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${qualityMidicine.manufacturerlicensepath}"><%="厂商证照"+StringUtil.fileExtensions(variety.getManufacturerlicensepath())%></a>
                </td>
            <%}else{ %>
             <td>
           <input type="text" name="medcRegistrAppPath" value="未上传附件" class="text1" size="40" readonly="readonly"/>
            </td>
            <%} %>
           <th>注册商标<span class="required">*</span>:</th>
            <td>
            <input type="text" name="registeredTrademarks" value="${qualityMidicine.registeredTrademarks }" class="easyui-validatebox text1" size="40" data-options="required:true" readonly="readonly"/>
            </td>
           <!--   <th>注册商标：</th>
            <% if(StringUtil.isNull(variety.getRegisteredtrademarkpath())){ %>
            	<td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${qualityMidicine.registeredtrademarkpath}"><%="注册商标"+StringUtil.fileExtensions(variety.getRegisteredtrademarkpath())%></a>
                </td>
            <%}else{ %>
            <td>
           <input type="text" name="medcRegistrAppPath" value="未上传附件" class="text1" size="40" readonly="readonly"/>
            </td>
            <%} %>-->
          </tr>
          <tr>
            <th>批准文件：</th>
            <% if(StringUtil.isNull(variety.getApprovaldocumentpath())){ %>
            	<td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${qualityMidicine.approvaldocumentpath}"><%="批准文件"+StringUtil.fileExtensions(variety.getApprovaldocumentpath())%></a>
                </td>
            <%}else{ %>
            <td>
          <input type="text" name="medcRegistrAppPath" value="未上传附件" class="text1" size="40" readonly="readonly"/>
            </td>
            <%} %>
            <th>质量标准依据：</th>
             <% if(StringUtil.isNull(variety.getQualitystandardpath())){ %>
            	<td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${qualityMidicine.qualitystandardpath}"><%="质量标准依据"+StringUtil.fileExtensions(variety.getQualitystandardpath())%></a>
                </td>
            <%}else{ %>
            <td>
            <input type="text" name="medcRegistrAppPath" value="未上传附件" class="text1" size="40" readonly="readonly"/>
            </td>
            <%} %>
          </tr>
          <tr>
            <th>包装情况：</th>
              <% if(StringUtil.isNull(variety.getPackingpath())){ %>
            	<td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${qualityMidicine.packingpath}"><%="包装情况"+StringUtil.fileExtensions(variety.getPackingpath())%></a>
                </td>
            <%}else{ %>
            <td>
            <input type="text" name="medcRegistrAppPath" value="未上传附件" class="text1" size="40" readonly="readonly"/>
            </td>
            <%} %>
            <th>标签、说明书：</th>
                    <% if(StringUtil.isNull(variety.getInstructionspath())){ %>
            	<td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${qualityMidicine.instructionspath}"><%="标签、说明书"+StringUtil.fileExtensions(variety.getInstructionspath())%></a>
                </td>
            <%}else{ %>
            <td>
            <input type="text" name="medcRegistrAppPath" value="未上传附件" class="text1" size="40" readonly="readonly"/>
            </td>
            <%} %>
          </tr>
           <tr>
            <th>检验报告书：</th>
              <% if(StringUtil.isNull(variety.getCheckoutreportpath())){ %>
            	<td>
           		<img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${qualityMidicine.checkoutreportpath}"><%="包装情况"+StringUtil.fileExtensions(variety.getCheckoutreportpath())%></a>
                </td>
            <%}else{ %>
            <td>
           <input type="text" name="medcRegistrAppPath" value="未上传附件" class="text1" size="40" readonly="readonly"/>
            </td>
            <%} %>
         <th>药品注册批准文件：</th>
            <%if(StringUtil.isNull(variety.getMedcRegistrApprovalPath())){ %>
            <td>
            <img src="../../images/pdf.gif" />
            	<a href="../../download.html?fileName=${qualityMidicine.medcRegistrApprovalPath}"><%="药品注册批准文件"+StringUtil.fileExtensions(variety.getMedcRegistrApprovalPath())%></a>
            </td>
            <%}else { %>
            <td>
             <input type="text" name="medcRegistrAppPath" value="未上传附件" class="text1" size="40" readonly="readonly"/>
             </td>
            <%} %>
          </tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
           		 <input type="hidden" id="save_type" name="save_type" value=""/>
           		 <input type="hidden" id="produce_no" name="produce_no" value="${qualityMidicine.produceno.id}">
           		 <input type="hidden" id="supply_unit" name="supply_unit" value="${qualityMidicine.supplyUnit.id}">
           		  <input type="hidden" name="quality_standard" id="quality_standard" value="${qualityMidicine.qualityStandardName}">
           		 <input type="hidden" name="p_id" value="${qualityMidicine.id}">
                <input name="" type="button" class="btn_big" value="返回" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	<script type="text/javascript">
	var medicineManagement="${qualityMidicine.medicineManagement}"
	var storageStore="${qualityMidicine.storageStore}"
	$(function(){
	   add();
	})
	function add(){
	    $("#medicineManagement option[value='"+medicineManagement+"']").attr("selected","selected");
	    $("#storageStore option[value='"+storageStore+"']").attr("selected","selected");
	}
	
		
	var fromDefault =   "${qualityMidicine.dosageforms.id}";
	//var supplyDefault = "${qualityMidicine.produceno.id}";
	
	$("#commonnamebox").combobox({
			filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q) == 0;
			},
			value:""+'${qualityMidicine.produceno.pinyinCode}'+"_"+'${qualityMidicine.produceno.id}'
		}
		
	)
	$("#commonnameboxsupply").combobox({
			filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q) == 0;
			},
			value:""+'${qualityMidicine.supplyUnit.pinyinCode}'+"_"+'${qualityMidicine.supplyUnit.id}'
		}
		
	)
	$("#commonnameboxbase").combobox(
			{
				filter : function(q, row) {
					var opts = $(this).combobox('options');
					return row[opts.textField].indexOf(q) == 0;
				},
				value : "" + '${qualityMidicine.qualityStandardName}'
			}

	)
	
	function updateHgypda(){
		$("#edit_hgypda").form('submit',{success:function(data){
			var json = jsonParse(data);
			if(json.success!=null && json.success!=""){
				alert(decodeURI( json.success));
			}
			location.href="qulidiedMedicinal.html";
		}})
	}
	setDefaultForCheckbox("medicinalAttribute","${qualityMidicine.medicinalAttribute}")
	setDefaultForCheckbox("medicinecategory","${qualityMidicine.medicinecategory}")
	function deleteFile(id,fileName,type){
			$.post("deleteQualityMidinceFile.html",{
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