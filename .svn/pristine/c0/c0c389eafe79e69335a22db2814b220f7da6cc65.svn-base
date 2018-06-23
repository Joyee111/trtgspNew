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
<title>合格品种修改</title>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">品种管理&nbsp;>&nbsp;合格品种&nbsp;>&nbsp;合格品种修改</font>
	<form action="updateQulidiedMedicinal.html" name="edit_hgypda" id="edit_hgypda" method="post" enctype="multipart/form-data">
        <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
          <tr>
            <th width="150">通用名称<span class="required">*</span>：</th>
            <td><input name="commonname" value="${qualityMidicine.commonname}" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
            <th width="150">剂    型<span class="required">*</span>：</th>
             <td><select name="dosageform" id="dosageForms" class="easyui-validatebox text1" data-options="required:true"><option>请选择剂型</option></select></td>
          </tr>
            <tr>
            <th width="150">货号<span class="required">*</span>：</th>
            <td><input name="medicinalNo" value="${qualityMidicine.medicinalNo}" type="text" class="easyui-validatebox text1" data-options="required:true" size="40" /></td>
            <th>批准文号<span class="required">*</span>：</th>
            <td><input name="licensenumber" value="${qualityMidicine.licensenumber}" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
          </tr>
          <tr>
            <th>生产企业<span class="required">*</span>：</th>
            <td>
            <input type="text" class="easyui-combobox  text1" data-options="
             required:true,
      	 	valueField: 'id',
       		textField: 'text',
      		url:'../firstEnterprise/qualitySupplyJson.html',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#produce_no').val(str[1]);
      		}
			" name="" id="commonnamebox" size="40"/>&nbsp;&nbsp;
			</td>
			<th>供货单位<span class="required">*</span>：</th>
            <td>
            <input type="text" class="easyui-combobox  text1" data-options="
            required:true,
      	 	valueField: 'id',
       		textField: 'text',
      		url:'../firstEnterprise/qualitySupplyJson.html',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#supply_unit').val(str[1]);
      		}
			" name="" id="commonnameboxsupply" size="40"/>&nbsp;&nbsp;
			</td>
            
          </tr>
          
          <tr>
            <th>药品规格<span class="required">*</span>：</th>
            <td><input name="massSpecifications" value="${qualityMidicine.massSpecifications}" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
            <th>规格<span class="required">*</span>：</th>
            <td><input name="specifications" value="${qualityMidicine.specifications}" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
            
          </tr>
          <tr>
            <th>单位<span class="required">*</span>：</th>
            <td><input name="unit" value="${qualityMidicine.unit}" type="text" class="easyui-validatebox text1" size="40" data-options="required:true"/></td>
            <th>质量标准依据<span class="required">*</span>：</th>
            <td>
            <input type="text" class="easyui-combobox  text1" data-options="
            required:true,
      	 	valueField: 'id',
       		textField: 'text',
      		url:'../drugVarieties/basedCriteriaJson.html',
      		onSelect: function(rec){
      		}
			" name="" id="commonnameboxbase" size="40"/>
          </tr>
          <tr>
            <th>药品类别<span class="required">*</span>：</th>
            <td>
             <select name="medicinecategory" id="medicinecategory" class="easyui-validatebox text1" data-options="required:true" 
             			onchange="controll(this.value)">
            	<option value="">请选择药品类别</option>
            	<option value="中成药">中成药</option>
            	<option value="化学药制剂">化学药制剂</option>
            	<option value="抗生素">抗生素</option>
            	<option value="生化药品">生化药品</option>
            </select>
            </td>
             <th>药品管理<span class="required">*</span>：</th>
            <td>
             <select name="medicineManagement" id="medicineManagement" class="easyui-validatebox text1" data-options="required:true" >
            	<option value="">请选择药品类别</option>
            	<option value="一般药品">一般药品</option>
            	<option value="专门管理要求药品">专门管理要求药品</option>
            </select>
            </td>
          </tr>
          <tr>
            <th>存储条件<span class="required">*</span>：</th>
            <td>
            <select name="medicinalAttribute" id="medicinalAttribute" class="easyui-validatebox text1"  data-options="required:true">
            	<option value="">请选择药品属性</option>
            	<option value="常温">常温</option>
            	<option value="阴凉">阴凉</option>
            	<option value="专门管理要求药品">专门管理要求药品</option>
            </select>
            </td>
            
            <th>内服外用<span class="required">*</span>：</th>
            <td>
            <select name="storageStore" id="storageStore" class="easyui-validatebox text1" data-options="required:true" >
            	<option value="">请选择内服外用</option>
            	<option value="内服">内服</option>
            	<option value="外用">外用</option>
            	<!-- <option value="阴凉药品库">阴凉药品库</option>
            	<option value="常温含麻黄碱药品库">常温含麻黄碱药品库</option>-->
            </select>
            </td>
          </tr>
           <tr>
           <!-- 根据2013年新需求暂时去掉 修改人lfl
            <th>商品名<span class="required">*</span>：</th>
            <td><input name="tradename" value="${qualityMidicine.tradename}" type="text" class="easyui-validatebox text1" size="40" data-options="required:false" /></td>
            -->
            <th>注册商标<span class="required">*</span>:</th>
            <td><input type="text" name="registeredTrademarks" value="${qualityMidicine.registeredTrademarks }" class="easyui-validatebox text1" size="40" data-options="required:true"/></td>
            <th>有效期（月）<span class="required">*</span>：</th>
            <td><input name="validdate" value="${qualityMidicine.validdate}" type="text" class="text1" size="40" data-options="required:true" maxlength="20"/></td>
          </tr>
          <tr>
          <th>养护周期（月）<span class="required">*</span>：</th>
            <td><input name="maintainCycle" value="${qualityMidicine.maintainCycle}" type="text" class="easyui-validatebox text1" size="40" data-options="required:true" /></td>
            <th>注册证到期日<span class="required">*</span>：</th>
            <td>
            <input type="text" name="medcRegistrApprovalDate" class="easyui-datebox text1" value="${qualityMidicine.medcRegistrApprovalDate}" data-options="required:true,validType:'date'" size="35"/>
            </td>
          </tr>
          <tr>
          	<th>受托方企业名称<span class="required"></span>：</th>
            <td><input name="trusteeEnterprise" value="${qualityMidicine.trusteeEnterprise}"type="text" class="easyui-validatebox text1" size="40" data-options="" maxlength="100" /></td>
           </tr> 
          <tr>
          	<th>状态标识<span class="required">*</span>：</th>
          	<td>
          		&nbsp;&nbsp;<font style="font-size:12px; color:#727171; font-weight:bold;">启用</font><input type="radio" name="useflag" value="0">&nbsp;&nbsp;<font style="font-size:12px; color:#727171; font-weight:bold;">停用</font><input type="radio" name="useflag" value="1">
          	</td>
          	<th>经营公司<span class="required">*</span>：</th>
          	<td>
          		<label for="" style="font-size:12px; color:#727171; font-weight:bold;">经营</label>
          		<input type="radio" name="departmentId" value="1001">
          		<label for="" style="font-size:12px; color:#727171; font-weight:bold;">新品</label>
          		<input type="radio" name="departmentId" value="2001">
          		<label for="" style="font-size:12px; color:#727171; font-weight:bold;">市场</label>
          		<input type="radio" name="departmentId" value="3001">
          	</td>
          </tr>
          <tr>
            <th valign="top">药品功能<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="function" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true,validType:'checkChina'">${qualityMidicine.function}</textarea></td>
          </tr>
       <%--  此处根据新需求暂时删除 20130729  <tr>
            <th>厂商证照：</th>
            <% if(StringUtil.isNull(variety.getManufacturerlicensepath())){ %>
            	<td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualityMidicine.manufacturerlicensepath}"><%="厂商证照"+StringUtil.fileExtensions(variety.getManufacturerlicensepath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${qualityMidicine.id}','${qualityMidicine.manufacturerlicensepath}','cszz')" value="删除"/>
                </td>
            <%}else{ %>
             <td>
            <input type="file" name="manufacturerPath" class="text1" size="40"/>
            </td>
            <%} %>
            <th>注册商标：</th>
            <% if(StringUtil.isNull(variety.getRegisteredtrademarkpath())){ %>
            	<td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualityMidicine.registeredtrademarkpath}"><%="注册商标"+StringUtil.fileExtensions(variety.getRegisteredtrademarkpath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${qualityMidicine.id}','${qualityMidicine.registeredtrademarkpath}','zcsb')" value="删除"/>
                </td>
            <%}else{ %>
            <td>
            <input type="file" name="registeredPath" class="text1" size="40"/>
            </td>
            <%} %>
          </tr>
            --%>
          <tr>
          <%--   <th>批准文件：</th>
            <% if(StringUtil.isNull(variety.getApprovaldocumentpath())){ %>
            	<td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualityMidicine.approvaldocumentpath}"><%="批准文件"+StringUtil.fileExtensions(variety.getApprovaldocumentpath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${qualityMidicine.id}','${qualityMidicine.approvaldocumentpath}','pzwj')" value="删除"/>
                </td>
            <%}else{ %>
            <td>
            <input type="file" name="approvalPath" class="text1" size="40"/>
            </td>
            <%} %>--%>
            <th>质量标准依据：</th>
             <% if(StringUtil.isNull(variety.getQualitystandardpath())){ %>
            	<td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualityMidicine.qualitystandardpath}"><%="质量标准依据"+StringUtil.fileExtensions(variety.getQualitystandardpath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${qualityMidicine.id}','${qualityMidicine.qualitystandardpath}','zlbz')" value="删除"/>
                </td>
            <%}else{ %>
            <td>
            <input type="file" name="qualityPath" class="text1" size="40"/>
            </td>
            <%} %>
             <th>药品注册批准文件：</th>
            <%if(StringUtil.isNull(variety.getMedcRegistrApprovalPath())){ %>
            <td>
            <img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualityMidicine.medcRegistrApprovalPath}"><%="药品注册批准文件"+StringUtil.fileExtensions(variety.getMedcRegistrApprovalPath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${qualityMidicine.id}','${qualityMidicine.medcRegistrApprovalPath}','ypzcpzwj')" value="删除"/>
            </td>
            <%}else { %>
            <td>
             <input type="file" name="medcRegistrAppPath" class="text1" size="40"/>
             </td>
            <%} %>
          </tr>
          <tr>
            <th>包装情况：</th>
              <% if(StringUtil.isNull(variety.getPackingpath())){ %>
            	<td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualityMidicine.packingpath}"><%="包装情况"+StringUtil.fileExtensions(variety.getPackingpath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${qualityMidicine.id}','${qualityMidicine.packingpath}','bzqk')" value="删除"/>
                </td>
            <%}else{ %>
            <td>
            <input type="file" name="packPath" class="text1" size="40"/>
            </td>
            <%} %>
            <th>标签说明书：</th>
                    <% if(StringUtil.isNull(variety.getInstructionspath())){ %>
            	<td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${qualityMidicine.instructionspath}"><%="标签、说明书"+StringUtil.fileExtensions(variety.getInstructionspath())%></a>
                <input name="" type="button" class="btn_small" onclick="deleteFile('${qualityMidicine.id}','${qualityMidicine.instructionspath}','bqsm')" value="删除"/>
                </td>
            <%}else{ %>
            <td>
            <input type="file" name="instructPath" class="text1" size="40"/>
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
           	     <input type="hidden" name="reject_cause" id="reject_cause" value="" />
                <input name="" type="button" class="btn_big" value="保存" onclick="$('#dialog').dialog('open')"/>
                
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
        <div id="dialog" title="修改原因" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:500">
    	<table>
    	<tr>
            <th valign="top">修改原因：</th>
            <td colspan="3"><textarea name="rejectcause" id="rejectcause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
           	<input type="button" class="btn_big" onclick="updateHgypda()" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
        </div>
	</form>
	<script type="text/javascript">
	//alert("${qualityMidicine.useflag}")
	setDefaultForRadio("useflag","${qualityMidicine.useflag}");
	setDefaultForRadio("isfood","${qualityMidicine.isfood}");
	setDefaultForCheckbox("storageStore","${qualityMidicine.storageStore}");
	var fromDefault =   "${qualityMidicine.dosageforms.id}";
	//var supplyDefault = "${qualityMidicine.produceno.id}";
	$(function(){
		ajaxQueryForm();
	//	ajaxQueryQualifiedSuppliers();
	})
	$("#commonnamebox").combobox({
			filter: function(q, row){
				console.debug(row)
				var opts = $(this).combobox('options');
				return row[opts.valueField].indexOf(q.toUpperCase()) == 0;
			},
			value:""+'${qualityMidicine.produceno.customerName}'
		}
		
	)
	$("#commonnameboxsupply").combobox({
			filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q.toUpperCase()) == 0;
			},
			value:""+'${qualityMidicine.supplyUnit.customerName}'
		}
		
	)
	$("#commonnameboxbase").combobox(
			{
				filter : function(q, row) {
					var opts = $(this).combobox('options');
					return row[opts.textField].indexOf(q.toUpperCase()) == 0;
				},
				value : '${qualityMidicine.qualityStandardName}'
			}

	)
	function controll(data){
		//alert(data);
		var a="中成药";
		if(data!=a){
			setDefaultForRadio("useflag","1");
		}else{
			setDefaultForRadio("useflag","0");
		}
		
	}
	function updateHgypda(){
	  // var ff = window.frames[0];
	  //   alert(ff);
	  //	var f = $.find('iframe')[0];
	  //	alert(f);
	  //	var datagrid = $.find('iframe')[0].contentWindow.$('#dialog');
		
	//	alter(datagrid);
	//	var datagrid = window.contentWindow.document.getElementById('rejectcause');
	//	var reasion = datagrid.text();
		var dia = $("#dialog").dialog();
		//alert(dia);
		//var value = dia.get(0).document.getElementById("rejectcause");
		//var b = dia.get(0).getElementsByTagName("textarea")[0].value;
		//alert(b);
		var value = dia.get(0).getElementsByTagName("textarea")[0].value;
		var comboxVaule = $("#commonnameboxbase").combobox('getText');
			//alert(vaule);
		$("#quality_standard").val(comboxVaule);
		//alert(value);
		$("#reject_cause").val(value);
		//alert($("#reject_cause").val());
		//检测药品类别，不是中成药的将状态标识改为停用
		var a="中成药";
		var medicinecategory=$("#medicinecategory").val();
		if(medicinecategory!=a){
			setDefaultForRadio("useflag","1");
		}
		
		
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
	setDefaultForCheckbox("medicineManagement","${qualityMidicine.medicineManagement}")
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
	
	//alert("${qualityMidicine.departmentId}");
	setCheckByName("departmentId","${qualityMidicine.departmentId}")
	</script>
</body>
</html>