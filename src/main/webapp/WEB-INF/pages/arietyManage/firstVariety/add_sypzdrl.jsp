<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首营品种新增</title>
</head>
<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">品种管理&nbsp;>&nbsp;首营品种&nbsp;>&nbsp;首营品种新增</font>
	<form action="saveFirstVariety.html" name="add_syybdlr" id="add_syybdlr" method="post" enctype="multipart/form-data">
		 	<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span class="ok" >1</span>
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
            <th width="150">通用名称<span class="required">*</span>：</th>
            <td><input name="commonName" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
            <th width="150">剂    型<span class="required">*</span>：</th>
            <td><select name="dosageForm" id="dosageForms" class="easyui-validatebox text1" data-options="required:true" ><option>请选择剂型</option></select></td>
          </tr>
           <tr>
            <th width="150">货号<span class="required">*</span>：</th>
            <td><input name="medicinalNo" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
            <th>批准文号<span class="required">*</span>：</th>
            <td><input name="licenseNumber" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
              
          </tr>
          <tr>
            <th>生产企业<span class="required">*</span>：</th>
            <td>
            <input type="text" class="easyui-combobox  text1"  data-options="
            required:true,
      	 	valueField: 'id',
       		textField: 'text',
      		url:'../firstEnterprise/qualitySupplyJson.html',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#produce_no').val(str[1]);
      		}
			" name="commonnamebox" id="commonnamebox" size="40"/>&nbsp;&nbsp;
			</td>
			<th>供货单位<span class="required">*</span>：</th>
            <td>
            <input type="text" class="easyui-combobox  text1"   data-options="
            required:true,
      	 	valueField: 'id',
       		textField: 'text',
      		url:'../firstEnterprise/qualitySupplyJson.html',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#supply_unit').val(str[1]);
      		}
			" name="commonnameboxsupply" id="commonnameboxsupply" size="40"/>&nbsp;&nbsp;
			</td>
          </tr>
          <tr>
            <th>药品规格<span class="required">*</span>：</th>
            <td><input name="medicSpecifications" type="text" class="easyui-validatebox text1" size="40" data-options="required:true" maxlength="20"/></td>
            <th>规格<span class="required">*</span>：</th>
            <td><input name="specifications" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
           
          </tr>
          <tr>
            <th>单位<span class="required">*</span>：</th>
            <td><input name="unit" type="text" class="easyui-validatebox text1" size="40" data-options="required:true" maxlength="20"/></td>
            <th>质量标准依据<span class="required">*</span>：</th>
            <td>
             <input type="text" class="easyui-combobox  text1"  data-options="
             required:true,
      	 	valueField: 'id',
       		textField: 'text',
      		url:'../drugVarieties/basedCriteriaJson.html',
      		onSelect: function(rec){
      		}
			" name="commonnameboxbase" id="commonnameboxbase" size="40"/>
          </tr>
          
          <tr>
            <th>药品类别<span class="required">*</span>：</th>
            <td>
             <select name="drugCategor" id="drugCategor" class="easyui-validatebox text1" data-options="required:true" >
            	<option value="">请选择药品类别</option>
            	<option value="中成药">中成药</option>
            	<option value="化学药制剂">化学药制剂</option>
            	<option value="抗生素">抗生素</option>
            	<option value="生化药品">生化药品</option>
            </select>
            </td>
            <th>药品管理<span class="required">*</span>：</th>
            <td>
             <select name="specialManagement" id="specialManagement" class="easyui-validatebox text1" data-options="required:true" >
            	<option value="">请选择药品类别</option>
            	<option value="一般药品">一般药品</option>
            	<option value="专门管理要求药品">专门管理要求药品</option>
            </select>
            </td>
          </tr>
          <tr>
              <th>存储条件<span class="required">*</span>：</th>
            <td>
            <select name="storageConditions" id="storageConditions" class="easyui-validatebox text1" data-options="required:true" >
            	<option value="">请选择存储条件</option>
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
            	<!--  <option value="阴凉药品库">阴凉药品库</option>
            	<option value="含麻黄碱药品库">含麻黄碱药品库</option>-->
            </select>
            </td>
          </tr>
          <tr>
         	 <th>注册商标<span class="required">*</span>：</th>
            <td><input name="registeredTrademarks" type="text" class="easyui-validatebox text1" size="40" data-options="required:true" maxlength="20"/></td>
            <th>有效期（月）<span class="required">*</span>：</th>
            <td><input name="validDate" type="text" class="easyui-validatebox text1" size="40" data-options="required:true" maxlength="20"/></td>
          </tr>
          <tr> 
          	<th>受托方企业名称<span class="required"></span>：</th>
            <td><input name="trusteeEnterprise" type="text" class="easyui-validatebox text1" size="40" data-options="" maxlength="100"/></td>
             
            <th>经营公司<span class="required">*</span>：</th>
            <td>
				<label for="" style="font-size:12px; color:#727171; font-weight:bold;">经营</label>
				<input type="radio" name="departmentId" value="1001"  />
				<label for="" style="font-size:12px; color:#727171; font-weight:bold;">新品</label>
				<input type="radio" name="departmentId" value="2001" />
				<label for="" style="font-size:12px; color:#727171; font-weight:bold;">市场</label>
				<input type="radio" name="departmentId" value="3001" />
			</td>
          </tr>
   
          <tr>
            <th valign="top">药品功能<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="function" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true,validType:'checkChina'"></textarea></td>
          </tr>
          <tr>
            <th valign="top">申请原因<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="applicationReason" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true,validType:'checkChina'"></textarea></td>
          </tr>
       <!-- 根据20130729新需求暂时删除   <tr>
            <th>厂商证照：</th>
            <td>
            <input type="file" name="manufacturerPath" class="text1" size="40"/>
            </td>
            <th>注册商标：</th>
            <td>
            <input type="file" name="registeredPath" class="text1" size="40"/>
            </td>
          </tr> -->
          <tr>
            <th>药品注册批准文件：</th>
            <td>
            <input type="file" name="approvalPath" class="text1" size="40"/>
            </td>
            <th>质量标准依据：</th>
            <td>
            <input type="file" name="qualityPath" class="text1" size="40"/>
            </td>
          </tr>
          <tr>
            <th>包装情况：</th>
            <td>
            <input type="file" name="packPath" class="text1" size="40"/>
            </td>
            <th>标签、说明书：</th>
            <td>
            <input type="file" name="instructPath" class="text1" size="40"/>
            </td>
          </tr>
          <tr>
          <!-- 
            <th>检验报告书：</th>
            <td>
            <input type="file" name="checkReportpath" class="text1" size="40"/>
            </td>
            
             <th>注册证：</th>
            <td>
            <input type="file" name="medcRegistrAppPath" class="text1" size="40"/>
            </td> -->
          </tr>
          <tr>
            <th>注册证件到期日<span class="required">*</span>：</th>
            <td>
            <input type="text" name="medcRegistrApprovalDate" class="easyui-datebox text1" data-options="required:true,validType:'date'" size="35"/>
            </td>
          </tr>
          
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
            	<input type="hidden" id="departmentId" name="departmentId" value=""/>
           		 <input type="hidden" id="save_type" name="save_type" value=""/>
           		 <input type="hidden" name="produce_no" id="produce_no" value="">
           		 <input type="hidden" name="supply_unit" id="supply_unit" value="">
           		  <input type="hidden" name="quality_standard" id="quality_standard" value="">
                <input name="" type="button" class="btn_big" value="保存" onclick="save_syqy(0)"/>
                <input name="" type="button" class="btn_big" value="提交" onclick="save_syqy(1)"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	<script type="text/javascript">
	
	$("#commonnamebox").combobox( {
		filter : function(q, row) {
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q.toUpperCase()) == 0;
		}
	})
	$("#commonnameboxsupply").combobox( {
		filter : function(q, row) {
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q.toUpperCase()) == 0;
		}
	})
	$("#commonnameboxbase").combobox( {
		filter : function(q, row) {
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q.toUpperCase()) == 0;
		}
	})
	$(function() {
		ajaxQueryForm();
		//ajaxQueryQualifiedSuppliers();
	})
	function save_syqy(value) {
		$("#save_type").val(value);
		var comboxValue = $("#commonnameboxbase").combobox('getText');
		//alert(comboxValue)
			//alert(vaule);
			$("#quality_standard").val(comboxValue);
		$('#add_syybdlr').form('submit', {
			success : function(data) {
				var json = jsonParse(data);
				if (json.success != null && json.success != "") {
					alert(decodeURI( json.success));
				}
				location.href = "firstVariety.html?type=input";
			}
		});
	}
</script>
</body>
</html>