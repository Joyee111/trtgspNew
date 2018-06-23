<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title>采购订单${titles}</title>
    <meta />
    <script type="text/javascript">
    	$(function(){
    			var departViewId = "${order.departmentId}";
	    	if(departViewId!=null && departViewId!=""){
	    		setDefaultForRadio("departmentId",departViewId)
	    	};
	    	var useFlagd = "${order.useFlag}";
	    //	alert(useFlagd);
	    	if(useFlagd!=null && useFlagd!=""){
	    		setDefaultForRadio("use_Flag",useFlagd)
	    	};
    	})
    	function audit_purchase(str){
			//$("#save_type").val(value);
		   
		   //var value = getRadioValueByName("use_Flag");
		   if(str != 3){
			   $("#useFlag").val(str);
		   }
		   if(str==1){
			   $('#void_dialog').dialog('open')
				return
		   }
		   if(str==3){
				$('#void_dialog').dialog('close')
			}
			var dialog = $("#void_dialog").dialog();
			var reason = dialog.get(0).getElementsByTagName("textarea")[0].value;
			$("#reason").val(reason);
		  $('#comfrim_purchaseOrder').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURIComponent( json.success));
				}
				location.href="yshlist.html";
			    }  
			});  
		}
    </script>
</head>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;&gt;&nbsp;采购订单管理&nbsp;&gt;&nbsp;采购订单${titles}</font>


<div class="box_big">
<form  method="post" action="confrimRejectPurchaseOrder.html" id="comfrim_purchaseOrder">

<div class="ceng_mar5" style="padding-bottom:5px;">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
	<tr>
	<th width="150"><fmt:message key="re.supplyUnit"/><span class="required">*</span>：</th>
	<td>
	<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
      	 	disabled:true,
       		textField: 'text',
      		url:'${ctx}/firstEnterprise/qualitySupplyJson.html',
      		value:'${order.qualifiedSupplierId.pinyinCode }'+'_'+'${order.qualifiedSupplierId.id }',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#qualifiedSupplierIdValue').val(str[1]);
      		}
			" name="" id="commonnameboxs" size="40"/>
	<input type="hidden" id="qualifiedSupplierIdValue" name="qualifiedSupplierIdValue" value="${order.qualifiedSupplierId.id}"/>
	</td>
	<th width="150">订单编号<span class="required">*</span>：</th>
	<td>
		<input type="text" readonly="readonly" name="number" id="number" value="${order.number}" class="easyui-validatebox text1" data-options="required:true" size="40" maxlength="20"/>
	</td>
	</tr>
	<tr>
		<!-- <th width="150">计划时间<span class="required">*</span>：</th>
		<td>
			<input type="text" readonly="readonly" name="season" id="season" value="${re.season}" class="easyui-validatebox text1" data-options="required:true" size="40" maxlength="20"/>
		</td>-->
		<th>经营公司<span class="required">*</span>：</th>
		<td>
			<label>经营</label>
			<input type="radio" name="departmentId" disabled="true" value="1001"  readonly="readonly"/>
			<label>新品</label>
			<input type="radio" name="departmentId" disabled="true" value="2001" readonly="readonly"/>
			<label>市场</label>
			<input type="radio" name="departmentId" disabled="true" value="3001" readonly="readonly"/>
		</td>
		<th>状态<span class="required">*</span>：</th>
		<td>
			&nbsp;合格&nbsp;<input type="radio" name="use_Flag" value="0" disabled="true" readonly="readonly">
			&nbsp;作废&nbsp;<input type="radio" name="use_Flag" value="1" disabled="true" readonly="readonly">
		</td>
	</tr>
</table>
<table id="condition_table" class="table"   border="0" cellpadding="0" cellspacing="1" width="100%" align="center">
	<thead class='pn-lthead'>
	 <tr>
	 	<th>通用名称</th><th>剂型</th><th>规格</th><th>单位</th><th>数量</th><th>生产企业</th><th>批准文号</th><th>单价</th><th>扣率(%)</th><th>金额</th>
	  </tr>
	 </thead>
	 <c:set var="totalMoney" value="${0}"></c:set>
	 <c:forEach items="${itemList}" var="item" varStatus="index">
	 <c:set var="totalMoney" value="${totalMoney + item.money}"></c:set>
	  	<tbody class="pn-ltbody" >
	  		<tr >
	  			<td ><input type="text" name="" value="${item.commonName }" class="text1" size="10" style="border: none;" readonly="readonly"/></td>
	  			<td><input type="text" name="" value="${item.drugFrom }" class="text1" size="10" style="border: none;" readonly="readonly"/></td>
	  			<td><input type="text" name="" value="${item.specification }" class="text1" size="6" style="border: none;" readonly="readonly"/></td>
	  			<td><input type="text" name="" value="${item.unit}" class="text1" size="6" style="border: none;" readonly="readonly"/></td>
	  			<td><input type="text" name="" value="${item.quanlity }" class="text1" size="6" style="border: none;" readonly="readonly"/></td>
	  			<!-- 
	  			<td><input type="text" name="" value="${item.batchNumber }" class="text1" size="8" style="border: none;" readonly="readonly"/></td>
	  			 -->
	  			<td><input type="text" name="" value="${item.productUnit }" class="text1" size="25" style="border: none;" readonly="readonly"/></td>
	  			<td><input type="text" name="" value="${item.approvalNumber }" class="text1" size="10" style="border: none;" readonly="readonly"/></td>
	  			<td><input type="text" name="" value="${item.taxtPrice }" class="text1" size="6" style="border: none;" readonly="readonly"/></td>
	  			<td><input type="text" name="" value="${item.deductionRate }" class="text1" size="6" style="border: none;" readonly="readonly"/></td>
	  			<td><input type="text" name="" value="${item.money }" class="text1" size="6" style="border: none;" readonly="readonly"/></td>
	  			<!--  
	  			<td><input type="text" name="" value="${item.tkdat }" class="text1" size="6" style="border: none;" readonly="readonly"/></td>
	  			<td><input type="text" name="" value="${item.validDate }" class="text1" size="6" style="border: none;" readonly="readonly"/></td>
	  		    --> 
	  		</tr>
	  	</tbody>
	  </c:forEach>
</table>
<p style="padding-right:130px;float:right;"><label style="font-weight: bold;font-size: 14px;color: #727171;text-align: right;line-height: 28px;">总金额：</label><input type="text" name="totalMoney" id="totalMoney" value="${totalMoney }" style="border: 0px;" readonly="readonly"/></p>

<table>
	
	<tr align="center">
		<td colspan="3">
			<input type="hidden" name="type" value="0"/>
			<input type="hidden" name="id" value="${order.id}">
			<input type="hidden" name="useFlag" value="${order.useFlag}" id="useFlag">
			<input type="hidden" name="reason" id = "reason" value="">
			<input type="button" class="btn_big" name="save"  value="<fmt:message key="作废"/>" onclick="audit_purchase('1')"/>
			<input type="button" class="btn_big" name="save"  value="<fmt:message key="确认回退"/>" onclick="audit_purchase('0')"/>
			<input type="button" class="btn_big" name="save"  value="<fmt:message key="返回"/>" onclick="goBack()"/>
		</td>
	</tr>
</table>
</div>
</form>
</div>
<div id="void_dialog" title="作废原因" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:200">
    	<table>
    	<tr>
            <th valign="top">作废原因：</th>
            <td colspan="3"><textarea name="void_reason" id="void_reason" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
           	<input type="button" class="btn_big" onclick="audit_purchase('3')" value="确定">
           	<input type="button" class="btn_big" onclick="$('#void_dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
</div>