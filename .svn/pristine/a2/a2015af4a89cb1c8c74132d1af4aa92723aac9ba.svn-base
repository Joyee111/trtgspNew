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
    	var useFlag = "${order.useFlag}";
    	if(useFlag!=null && useFlag!=""){
    		setDefaultForRadio("useFlag",useFlag)
    	};
    	})
    	function audit_purchase(value){
    		var useFlag = $(':radio[name="useFlag"]:checked');
			if(value==0 && useFlag.val()==1){
				alert("作废请选择保存");
				return
			}
			$("#type").val(value);
		
		  $('#audit_purchaseOrder').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURIComponent( json.success));
				}
				location.href="dshlist.html";
			    }  
			});  
		}
    	//计算金额
    	function count_total_meony(quality,taxprice,koulv,total,totalMoney){
    	var i = $("#orderQuant").val();//订单数量
 		var qua = $("#"+quality).val();//数量
 		var tax = $("#"+taxprice).val();//单价
 		var kl =  $("#"+koulv).val();//扣率
 		var total_money = $("#"+totalMoney).val();//总金额
 		
 		if(isNotNull(qua) && isNotNull(tax) && isNotNull(kl)){
 			var qua1 = $("#"+quality).val();//数量
 			var tax1 = $("#"+taxprice).val();//单价
 			var kl1 =  $("#"+koulv).val();//扣率
 			var money = 	parseFloat(qua1*tax1*((kl1)/100)).toFixed(2);
 			$("#"+total).val(money);
 			$("#"+totalMoney).val(money);
 			
 		}else if(isNotNull(qua) && isNotNull(tax) && !isNotNull(kl)){
 			var qua2 = $("#"+quality).val();//数量
 			var tax2 = $("#"+taxprice).val();//单价
 			var money = 	qua2*tax2;
 			var total_m = 0;
 			$("#"+total).val(parseFloat(money).toFixed(2));
 			
 			$("#"+totalMoney).val(parseFloat(money).toFixed(2));
 		}
 	} 
	function isNotNull(value){
		return typeof(value)!=undefined && value!=null && value!="";
	}
	//保存
	function save_purchase(value){
		
		var useFlag = $(':radio[name="useFlag"]:checked');
		
		if(value==1 && useFlag.val()==1){
			$('#void_dialog').dialog('open')
			return
		}
		if(value==3){
			value=1
			$('#void_dialog').dialog('close')
		}
		var dialog = $("#void_dialog").dialog();
		var reason = dialog.get(0).getElementsByTagName("textarea")[0].value;
		$("#reason").val(reason);
		
		
		$("#type").val(value);
		var arr = [];
		var batch = null;
		var quant = null;
		var bodies = $("#condition_table").children("tbody");
		for(var j=0;j<bodies.size();j++){
			var shuliang = "#quantity";
			//var shengchanpihao= "#batch";
			//var youxiaoqi = "#validDate";
			//var tkdat = "#tkdat";
			//if($(tkdat).datebox('getValue') == "" || $(tkdat).datebox('getValue') == null){
			//	alert("请填写生产日期");
			//	return;
			//}
			//if($(youxiaoqi).datebox('getValue') == "" || $(youxiaoqi).datebox('getValue') == null){
			//	alert("请填写有效期");
			//	return;
			//}
			//batch = $(shengchanpihao).val();
			//quant = $(shuliang).val();
			//arr[j] = {"batch":batch,"quant":quant};
		}
		/* 数量控制暂时不做
		var vJson = [];
		for(var j=0 in arr ){
		   if(vJson[arr[j].batch] == undefined){//没有这个批号的数据,把批号加入json
			   vJson[arr[j].batch] = {"quant":parseInt(arr[j].quant)};
			}else{
			   //vJson[i] = {arr[i].batch,vJson.get(arr[i].batch)+arr[i].quant};
		     vJson[arr[j].batch].quant += parseInt(arr[j].quant);//含有这个批号的数据,开始累加数量
			}
		}
		var flag = 0;
		for(var k = 0 in arr){
			$.ajax({
				url:"${ctx}/drugState/purchaseNote/findavailablequant.html",
				data:{batch:arr[k].batch},
				type:"POST",
				dataType:'json',
				async : false,//不同步
				success:function(data){
					if(data){
						var zuidashuliang = "#zuidashuliang"+k;
						var max = parseInt($("#zuidashuliang"+k).val());
						var available = max*10000-data.quant;
						if(vJson[arr[k].batch].quant>available){
							alert("批号:"+arr[k].batch+"的药品数量总和超过计划数量");
							flag = 1;
						}
					}else{}
				},
				error:function(e){
					alert("保存失败");
					flag = 1;
					return;
				}
			})
			if(flag == 1){
				return;
			}
		}
		*/
			//var dialog = $("#dialog").dialog();
			//var value = dialog.get(0).getElementsByTagName("textarea")[0].value;
			//$("#modify_reason").val(value);
			$('#audit_purchaseOrder').form('submit', {
						success : function(data) {
							var json = jsonParse(data);
							if (json.success == "1") {
								alert("此编号已经存在,新生成的编号为：" + json.number + ",已经保存成功!");
							} else {
								alert("数据保存成功!");
							}
							location.href = "dshlist.html";
						}
					});
	}
    </script>
</head>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">&nbsp;药品状态管理&nbsp;&gt;&nbsp;采购订单管理&nbsp;&gt;&nbsp;采购订单${titles}</font>


<div class="box_big">
<form  method="post" action="auditPurchaseOrder.html" id="audit_purchaseOrder">

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
		<th>经营公司<span class="required">*</span></th>
		<td>
			<label>经营</label>
			<input type="radio" name="departmentId"  value="1001" disabled="true" readonly="readonly" />
			<label>新品</label>
			<input type="radio" name="departmentId"  value="2001" disabled="true" readonly="readonly"/>
			<label>市场</label>
			<input type="radio" name="departmentId"  value="3001" disabled="true" readonly="readonly"/>
		</td>
		<th>状态<span class="required">*</span>：</th>
		<td>
			&nbsp;合格&nbsp;<input type="radio" name="useFlag"  value="0" disabled="true"  readonly="readonly">
			&nbsp;作废&nbsp;<input type="radio" name="useFlag"  value="1" disabled="true"  readonly="readonly">
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
	  			<td><input type="text" name="quantity" id="quantity" value="${item.quanlity }" class="text1" size="6" style="" 
	  			onchange="count_total_meony('quantity','taxPrice','rate','money','totalMoney')"/></td>
	  			<!--  
	  			<td><input type="text" name="batch" id="batch" value="${item.batchNumber }" class="text1" size="8" style="border: none;" readonly="readonly"/></td>
	  			-->
	  			<td><input type="text" name="" value="${item.productUnit }" class="text1" size="25" style="border: none;" readonly="readonly"/></td>
	  			<td><input type="text" name="" value="${item.approvalNumber }" class="text1" size="10" style="border: none;" readonly="readonly"/></td>
	  			<td><input type="text" name="taxPrice" id="taxPrice" value="${item.taxtPrice }" class="text1" size="6" style="" 
	  			onchange="count_total_meony('quantity','taxPrice','rate','money','totalMoney')"/></td>
	  			<td><input type="text" name="rate" id="rate" value="${item.deductionRate }" class="text1" size="4" style="border: none;" readonly="readonly"/></td>
	  			<td><input type="text" name="money" id="money" value="${item.money }" class="text1" size="6" style="border: none;" readonly="readonly"/></td>
	  			<!-- 
	  			<td><input type="text" name="tkdat" id="tkdat" value="${item.tkdat }" class="easyui-datebox" size="8" style="" /></td>
	  			<td><input type="text" name="validDate"id="validDate" value="${item.validDate }" class="easyui-datebox" size="8" style="" /></td>
	  			 -->
	  		</tr>
	  	</tbody>
	  </c:forEach>
</table>
<p style="padding-right:130px;float:right;"><label style="font-weight: bold;font-size: 14px;color: #727171;text-align: right;line-height: 28px;">总金额：</label><input type="text" name="totalMoney" id="totalMoney" value="${totalMoney}" style="border: 0px;" readonly="readonly"/></p>

<table>
	
	<tr align="center">
		<td colspan="3">
			<input type="hidden" name="type" id="type" value=""/>
			<input type="hidden" name="id" value="${order.id }">
			<input type="hidden" name= "orderQuant" id = "orderQuant" value="${orderQuant}"/>
			<input type="hidden" name="reason" id = "reason" value="">
			<input type="button" class="btn_big" name="save"  value="<fmt:message key="保存"/>" onclick="save_purchase('1')"/>
			<input type="button" class="btn_big" name="save"  value="<fmt:message key="提交"/>" onclick="audit_purchase('0')"/>
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
           	<input type="button" class="btn_big" onclick="save_purchase('3')" value="确定">
           	<input type="button" class="btn_big" onclick="$('#void_dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
</div>