<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title>购进退出修改</title>
    <meta />
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</head>
<script type="text/javascript">
</script>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;购进退出管理&nbsp;>&nbsp;购进退出修改</font>
<div class="box_big">
<form method="post" action="dlrupdate.html" id="res">
<input type="hidden" name="id" value="${mc.id}"/>
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" id="quamap" value = "${quamap}" />
<div class="ceng_mar5" style="padding-bottom:5px;">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
	<tr>
	<th width="150">供货单位<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
	<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
      		url:'${ctx}/firstEnterprise/qualitySupplyJson.html',
      		value:'${gouhuoshang}',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#qualifiedSupplierIdValue').val(str[1]);
      		}
			" name="" id="commonnameboxs" size="40"/>
	<input type="hidden" id="qualifiedSupplierIdValue" name="qualifiedSupplierId" value="${mc.qualifiedSupplierId}"/>
	</td>
	<th width="150">通用名称<span class="required">*</span>：</th>
	<td style="width:400px;">
		<input type="text" class="easyui-combobox  text1" data-options="
     	 	valueField: 'id',
      		textField: 'text',
     		url:'${ctx}/drugState/stopcell/findypboxqy.html',
     		value:'${mc.qualifiedMedicineId}',
     		onSelect: function(rec){
     			$('#batchProduction').combobox('setValue', '');   
     			var url = '${ctx}/drugState/stopcell/findypboxbyid.html?id='+rec.id;
     			  
     			change(rec.id);
     		}
		" name="qualifiedMedicineId" id="caigoudan" size="40"/>&nbsp;&nbsp;
	</td>
	</tr>
	<tr>
	<th width="150">剂型：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="jixing" id="jixing" value="${qm.dosageforms.formName}" readonly="readonly" class="text1" size="40"/>
	</td>
	<th width="150">规格：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="guige" id="guige" value="${qm.specifications}" readonly="readonly" class="text1" size="40"/>
	</td>	
	</tr>
	<tr>
	<th width="150">生产厂商<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="shengchanchagnshang" value="${qm.produceno.customerName}" data-options="required:true" class="easyui-validatebox text1" id="shengchanchagnshang" class="text1" size="40" readonly="readonly" />
	</td>	
	<th width="150">单位<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="danwei" value="${qm.unit}" data-options="required:true" class="easyui-validatebox text1" id="danwei" class="text1" size="40" readonly="readonly"/>
	</td>
	</tr>
	<tr>
		<th width="150">生产批号<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
	<%-- 
		<input id="batchProduction" class="easyui-combobox" size="40" data-options="required:true,valueField:'id',textField:'text',
		value:'${mc.batchNumber}',
		url :'${ctx}/drugState/stopcell/findypboxbyid.html?id='+${mc.qualifiedMedicineId},
		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#batchProductionValue').val(str[0]);
      			$('#maxquantity').val(str[1]);
      			$('#endTime').datebox('setValue',str[3]);
      		}
		" />
		<input type="hidden" name="batchNumber" id="batchProductionValue" value="${mc.batchNumber }"/>--%>
		<input type="text" name="batchNumber" id="batchProductionValue"data-options="required:true" class="easyui-validatebox text1" size="40" value="${mc.batchNumber }"/>
	</td>
	<th width="150">退出数量<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="quantity"  value="${mc.quantity}" onchange="count_total_meony('quantity','puMoney','money')" id="quantity" class="easyui-validatebox text1"  data-options="required:true" size="40" />
		<input type="hidden" id="maxquantity" value="${maxQuantity }" />
	</td>
	
	</tr>
	<tr>
	<th width="150">购进价格<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="puMoney" value="${mc.puMoney}" id="puMoney" class="easyui-validatebox text1" data-options="required:true" maxlength="20" size="40" />
	</td>
	<th width="150">制单日期<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="returnTime" value="${mc.returnTime}" id="returnTime" class="easyui-datebox text1" data-options="required:true,disabled:true" maxlength="20" size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">退出金额<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="money" id="money" value="${mc.money}" class="easyui-validatebox text1"data-options="required:true" maxlength="20" class="text1" size="40" readonly="readonly"/>
	</td>	
	<th width="150">有效期至<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="endTime" value="${mc.endTime}" id="endTime" class="easyui-datebox text1" data-options="required:true" maxlength="20" size="40"/>
	</td>
	</tr>
	<tr>
	<th valign="top">备注：</th>
	 <td colspan="3">
		<textarea type="" name="returnReason" id="returnReason" cols="94" rows="4" class="textarea" >${mc.returnReason}</textarea>
	</td>
	</tr>
	<!-- 
	<tr>
	<th width="150">退货类别：</th>
	 <td colspan="3">
		<input type="checkbox" name="returnType" id="returnType1" value="1" /><font style="font-size:12px; color:#727171; font-weight:bold;">经营退货</font>
		<input type="checkbox" name="returnType" id="returnType2" value="2" /><font style="font-size:12px; color:#727171; font-weight:bold;">质量退货</font>
		<input type="checkbox" name="returnType" id="returnType3" value="3" /><font style="font-size:12px; color:#727171; font-weight:bold;">是否需传回退货样品或图片传真、邮件资料</font>
		<input type="hidden" id ="returnTypeValue" name="returnTypeValue" value="${mc.returnType}" />
	</td>
	</tr>
	 -->
</table>
<table>
	<tr align="center">
		<td colspan="3">
			<input type="button" class="btn_big" name="save" onclick="$('#dialog').dialog('open');" value="<fmt:message key="button.save"/>"/>
			<input type="button" class="btn_big" name="cancel" onclick="onCancel();" value="<fmt:message key="button.cancel"/>"/>
		</td>
	</tr>
</table>
</div>
<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" id="receItem" name="receItem" value="${receItem}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type="hidden" name="modify_reason" id="modify_reason"/>
<input type="hidden" name="counts" id="counts" value=""/>
<input type="hidden" name="submitType" id="submitType" value="0" />
</form>
</div> 
<div id="dialog" title="修改原因" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:200">
    	<table>
    	<tr>
            <th valign="top">修改原因：</th>
            <td colspan="3"><textarea name="rejectcause" id="rejectcause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
           	<input type="button" class="btn_big" onclick="savess(0)" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
        </div>
<script type="text/javascript">
/*
function changequ(obj){
	var a = Number(trim(obj.value));
	var b =Number(trim(document.getElementById("maxquantity").value));
	if(a>b){
		alert("数量大于此批次最大数量！");
		obj.value="";
	}
}*/
$("#commonnameboxs").combobox({
	filter: function(q, row){
	var opts = $(this).combobox('options');
	return row[opts.valueField].indexOf(q) >-1;
	}
});
function savess(a){
		var  dialog = $("#dialog").dialog();
		var value =  dialog.get(0).getElementsByTagName("textarea")[0].value;
		$("#modify_reason").val(value);
		if(checkSubmit()){
			$('#submitType').val(a);
				$('#res').form('submit',{
				    success: function(data){  
					var json = jsonParse(data);
						if(json.success!=null && json.success!=""){
							alert(decodeURI( json.success));
						}
					location.href="dlrlist.html";
				    }  
				});  
		}
		}
    function onCancel()
    {
    	history.go(-1);
    }
    function submits(){
	   document.getElementById("submitType").value="1";
	    var form = document.getElementById("res");
	    form.submit();
    }
    
    function change(s){
	    if(s.value!=""){
			$.post("${ctx}/drugState/inspectionRecords/quamap.html",{
			"quamap" : s,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					$("#jixing").val(c[0]);
					$("#guige").val(c[1]);
				}else{
					return;
				}
			});
	    }else{
	    	$("#jixing").val("");
			$("#guige").val("");
	    }
    
    }
    
    $(function() {
    	var  returnValue=document.getElementById("returnTypeValue");
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
    });
    
      function count_total_meony(quality,taxprice,total){
   
 		var qua = $("#"+quality).val();//数量
 		var tax = $("#"+taxprice).val();//含税单价
 		 var a = Number(trim(qua));
		var b =Number(trim(document.getElementById("maxquantity").value));
		//alert(b);
		if(a>0){
			alert("退出数量必须为负数！");
			return ;
		}/*
		if( Math.abs(a)>Math.abs(b)){
			alert("数量大于此批次最大数量！");
			$("#"+quality).val("");
			return ;
		}*/
 		if(isNotNull(qua) && isNotNull(tax)){
 			var money = 	(parseFloat(qua))*(parseFloat(tax));
 			//alert(money);
 			$("#"+total).val(parseFloat(money).toFixed(2));
 		}
 	} 
</script>

