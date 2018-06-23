<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title>购进退出制单</title>
    <meta />
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</head>
<script type="text/javascript">
</script>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;购进退出管理&nbsp;>&nbsp;购进退出制单</font>
<div class="box_big">
<form method="post" action="dlrsave.html" id="res">

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
      		value:'${gongyingshang}',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			findypboxqyByGHDW(str[1]);
      			$('#qualifiedSupplierIdValue').val(str[1]);
      		}
			" name="" id="commonnameboxs" size="40"/>
	<input type="hidden" id="qualifiedSupplierIdValue" name="qualifiedSupplierId" />
	</td>
	<th width="150">通用名称<span class="required">*</span>：</th>
	<td style="width:400px;">
		<input type="text" class="easyui-combobox  text1" data-options="
     	 	valueField: 'id',
      		textField: 'text',
     		url:'${ctx}/drugState/stopcell/findypboxqy.html',
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
		<input type="text" name="jixing" id="jixing"  readonly="readonly" class="text1" size="40"/>
	</td>
	<th width="150">规格：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="guige" id="guige"  readonly="readonly" class="text1" size="40"/>
	</td>	
	</tr>
	<tr>
	<th width="150">生产厂商<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="shengchanchagnshang" data-options="required:true" class="easyui-validatebox text1" id="shengchanchagnshang" class="text1" size="40" readonly="readonly"/>
	</td>	
	<th width="150">单位<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="danwei" data-options="required:true" class="easyui-validatebox text1" id="danwei" class="text1" size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">生产批号<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
	<%-- 
		<input id="batchProduction" class="easyui-combobox" size="40" data-options="required:true,valueField:'id',textField:'text',
		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#batchProductionValue').val(str[0]);
      			$('#maxquantity').val(str[1]);
      			$('#endTime').datebox('setValue',str[3]);
      			setPrice(str[0]);
      		}
		" />
		<input type="hidden" name="batchNumber" id="batchProductionValue"/>--%>
		<input type="text" name="batchNumber" id="batchProductionValue"data-options="required:true" class="easyui-validatebox text1" size="40" />
	</td>	
	<th width="150">退出数量<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="quantity" id="quantity" onchange="count_total_meony('quantity','puMoney','money')" class="easyui-validatebox text1"  data-options="required:true,validType:'checkInt'" size="40"/>
		<input type="hidden" id="maxquantity" />
	</td>
	</tr>
	<tr>
	<th width="150">购进价格<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="puMoney" id="puMoney" class="easyui-validatebox text1" onchange="count_total_meony('quantity','puMoney','money')" data-options="required:true" maxlength="20" size="40" />
	</td>
	
	<th width="150">制单日期<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="returnTime" id="returnTime" class="easyui-datebox text1" data-options="required:true,disabled:true" maxlength="20" size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">退出金额<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="money" id="money" class="easyui-validatebox text1" data-options="required:true" maxlength="20" size="40" readonly="readonly"/>
	</td>
	<th width="150">有效期至<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="endTime" id="endTime" class="easyui-datebox text1" data-options="required:true" maxlength="20" size="40"/>
	</td>
	</tr>
	<tr>
     <th width="150">票据类型<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
		<input type="text" class="easyui-combobox  text1" data-options="
	      	 	valueField: 'id',
	       		textField: 'text',
	      		url:'${ctx}/drugState/purreturn/getNumberJson.html',
	      		value:'',
	      		onSelect: function(rec){
	      			var str = rec.id.split('_');
	      			$('#number').val(str[1]);
	      			$('#billTypeId').val(str[0]);
	      		}
				" name="" id="commonnameboxs" size="40"/>
		<input type="hidden" id="billTypeId" name="billTypeId" />
    </td>   
	<th width="150">票号<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="number" id="number" class="easyui-validatebox text1" data-options="required:true,disabled:true" maxlength="20" size="40" value=""/>
		
	</td>
	
	<tr>
     <th width="150">药品状态<span class="required">*</span>：</th>
	   <td class="left" style="width:350px;font-size: 12px;font-weight: bold;color: #727171;line-height: 28px;">
	             合格<input type="radio" name="state" value="A"/>
	           &nbsp; &nbsp; 不合格<input type="radio" name="state" value="D"/>
	           &nbsp; &nbsp;  退回<input type="radio" name="state" value="C"/>
	   </td>
	</tr>
	</tr>
	<tr>
	<th valign="top">备注：</th>
	 <td colspan="3">
		<textarea type="" name="returnReason" id="returnReason"    cols="94" rows="4" class="textarea" ></textarea>
	</td>
	</tr>
	<!-- 
	<tr>
	<th width="150">退货类别：</th>
	 <td colspan="3">
		<input type="checkbox" name="returnType" id="returnType" value="1" /><font style="font-size:12px; color:#727171; font-weight:bold;">经营退货</font>
		<input type="checkbox" name="returnType" id="returnType" value="2" /><font style="font-size:12px; color:#727171; font-weight:bold;">质量退货</font>
		<input type="checkbox" name="returnType" id="returnType" value="3" /><font style="font-size:12px; color:#727171; font-weight:bold;">是否需传回退货样品或图片传真、邮件资料</font>
		<input type="hidden" id ="returnTypeValue" name="returnTypeValue" />
	</td>
	</tr> -->
</table>
<table>
	<tr align="center">
		<td colspan="3">
			<input type="button" class="btn_big" name="save" onclick="savess(0);" value="<fmt:message key="button.save"/>"/>
			<input type="button" class="btn_big" name="cancel" onclick="onCancel();" value="<fmt:message key="button.cancel"/>"/>
		</td>
	</tr>
</table>
</div>
<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" id="receItem" name="receItem" value="${receItem}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type="hidden" name="submitType" id="submitType" value="0" />
</form>
</div>
<script type="text/javascript">

function getCurrentDate(){
   		var date = new Date();
   		var year = date.getFullYear();
   		var moth = date.getMonth()+1;
   		var day = date.getDate();
   		if(parseInt(moth)< 9){
   			moth = "0"+moth;
   		}
   		if(parseInt(day)< 9){
   			day = "0"+day;
   		}
   		return year+"-"+moth+"-"+day;
   }
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
		$('#submitType').val(a);
		if(checkSubmit()){
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
    
    //价格设置为根据批号查询采购订单的价格
    function setPrice(batch){
    	if(batch != ""){
    		$.post("${ctx}/drugState/purchaseNote/findprice.html",{
    			"batch" : batch,
    		},function(data){
    			if(data){
    				var price = data.price.toString();
    				$("#puMoney").val(price);
    			}else{
    				return;
    			}
    		});
    	}else{
    		$("#puMoney").val("");
    	}
    }
    
    function change(s){
	    if(s.value!=""){
			$.post("${ctx}/drugState/inspectionRecords/quamap.html",{
			"quamap" : s,
			},function(data){
				if(data){
				//alert(data);
					var b = data.toString();
					var c = b.split(",");
				//	alert(c[11]);
					$("#jixing").val(c[0]);
					$("#guige").val(c[1]);
					$("#shengchanchagnshang").val(c[7]);
					$("#danwei").val(c[8]);
					//$("#puMoney").val(c[11])
				}else{
					return;
				}
			});
	    }else{
	    	$("#jixing").val("");
			$("#guige").val("");
			$("#shengchanchagnshang").val("");
			$("#danwei").val("");
	    }
    
    }
    function count_total_meony(quality,taxprice,total){
   
 		var qua = $("#"+quality).val();//数量
 		var tax = $("#"+taxprice).val();//含税单价
 		 var a = Number(trim(qua));
		var b =Number(trim(document.getElementById("maxquantity").value));
		//alert(b);
		if(a>0){
			alert("退出数量必须为负数！");
			return ;
		}
		/* 
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
	function isNotNull(value){
		return typeof(value)!=undefined && value!=null && value!="";
	}
	$(function(){
		$("#returnTime").datebox("setValue",getCurrentDate());
	})
	function findypboxqyByGHDW(qsid){
		var urlStr ="${ctx}/drugState/stopcell/findypboxqy.html?qsid="+qsid;  
        //$("#caigoudan").combobox("reload",urlStr);  

	}
</script>

