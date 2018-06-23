<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="不合格药品"/></title>
    <meta />
</head>
<form commandName="um" method="post" action="updata.html" id="drs">  
<input type="hidden" name="method" value="${method}" />
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" name="id" value="${um.id}" />
<input type="hidden" name="shuliang" id="shuliang"  value="${um.quantity}" />
<input type="hidden" name="qpihao" id="qpihao"  value="${um.batchno}" />
<input type="hidden" name="qbhgQuantity" id="qbhgQuantity"  value="${qbhgQuantity}" />
<input type="hidden" name="qhgQuantity" id="qhgQuantity"  value="${qhgQuantity}" />
<input type="hidden" name="batchno2" id="batchno2"  />
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">	
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">质量记录管理&nbsp;>&nbsp;不合格药品&nbsp;>&nbsp;${titles}</font>
<tr>
     	<th width="150">通用名称<span class="required">*</span>：</th>
		<td style="width:400px;">
			<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
       	     value:'${um.qualifiedmedicineid}',
      		 url:'${ctx}/qualityRecords/unqualifiedManger/queryQualifiedMedc.html',
      		onSelect: function(rec){
     			//var url = '${ctx}/drugState/stopcell/findypboxbyid.html?id='+rec.id;
     			//$('#batchno').combobox('setValue', '');   
     			//$('#batchno').combobox('reload', url);   
     			find(rec.id);
     		}
		" name="qualifiedMedicineId" id="qualifiedmedicineid" size="40"/>

	
				<input type="hidden" name="qualifiedmedicineidValue" id="qualifiedmedicineidValue" class="text1" value="${um.qualifiedmedicineid}" size="40"/>
		</td>
		<th width="150">药品编号<span class="required">*</span>：</th>
		<td>
	<input type="text" name="medicinalNo" id="medicinalNo"   value="${um.qualifiedmedcstore.qualityMidicine.medicinalNo}" class="easyui-validatebox text1" size="40"/>
	</td>
	</tr>
	<tr>
		<!-- <th width="150">剂型<span class="required">*</span>：</th>
	<td>
		<input type="text" name="qualifiedmedcstore.qualityMidicine.dosageforms.formName" id="dosageforms"  value="${um.qualifiedmedcstore.qualityMidicine.dosageforms.formName}" class="easyui-validatebox text1" size="40"/>
	</td> -->
	    <th>单位<span class="required">*</span>：</th>
		<td>
		  <input type="text" name="qualifiedmedcstore.qualityMidicine.unit" id="unit"  value="${um.qualifiedmedcstore.qualityMidicine.unit}"  class="easyui-validatebox text1" data-options="required:true"  style="width:260px"  />
		</td>
		<th width="150">规格<span class="required">*</span>：</th>
	<td>
		<input type="text" name="qualifiedmedcstore.qualityMidicine.specifications" id="specifications"  value="${um.qualifiedmedcstore.qualityMidicine.specifications}" class="easyui-validatebox text1"  size="40"/>
	</td>
	
	</tr>

	<tr>

	<%--<th width="150">批准文号<span class="required">*</span>：</th>
	<td>
		<input type="text" name="qualifiedmedcstore.qualityMidicine.licensenumber" id="licensenumber" value="${um.qualifiedmedcstore.qualityMidicine.licensenumber}" class="easyui-validatebox text1"  size="40"/>
	</td>--%>
	<th width="150">生产厂家<span class="required">*</span>：</th>
	<td>
		<input type="text" name="qualifiedmedcstore.qualityMidicine.produceno.customerName" id="produceno" value="${um.qualifiedmedcstore.qualityMidicine.produceno.customerName}" class="easyui-validatebox text1"  size="40"/>
	</td>
	<th>供货单位<span class="required">*</span>：</th>
	<td>
		<input type="text" name="qualifiedmedcstore.qualityMidicine.supplyUnit.customerName" id="customerName"value="${um.qualifiedmedcstore.qualityMidicine.supplyUnit.customerName }" class="easyui-validatebox text1" data-options="required:true" size="40"  />
	</td>
	</tr>	
	
	<tr>
	<th width="150">数量<span class="required">*</span>：</th>
	<td>
			<input type="hidden" name="maxquantity" id="maxquantity" />
		<input type="text" name="quantity" id="quantity"  value="${um.quantity}"  class="easyui-validatebox text1"  data-options="required:true,validType:'checkInt'" size="40" maxlength="20"/>
		<input type="hidden" name="bhgquantity" id="bhgquantity"/>
	</td>
	
	<th width="150">生产批号<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
	<!--  <input id="batchno" class="easyui-combobox" data-options="valueField:'id',textField:'text',
		value:'${um.batchno}',
		url :'${ctx}/drugState/stopcell/findypboxbyid.html?id='+${um.qualifiedmedcstore.qualityMidicine.id},
		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#batchnoValue').val(str[0]);
      			$('#maxquantity').val(str[1]);
      			$('#bhgquantity').val(str[2]);
      			$('#batchno2').val(str[0]);
      			$('#validUntil').attr('value',str[3]);
      		}
		" />
		<input type="hidden" name="batchno" id="batchnoValue" value="${um.batchno}"/>-->
		<input id="batchno"  name="batchno" class="easyui-validatebox text1" value="${um.batchno}" data-options="required:true,validType:'checkInt'" size="40" maxlength="8"/>
	</tr>
		<tr>
	<!-- <th width="150">收货日期<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="shipmentdate" id="shipmentdate"  value="${um.shipmentdate}"  class="easyui-datebox text1" data-options="required:true"  style="width:260px"  />
	</td>
		<th width="150">收货凭证号<span class="required">*</span>：</th>
	<td>
		<input type="text" name="harvestNumber" id="harvestNumber"  value="${um.harvestNumber}"  class="easyui-validatebox text1"  data-options="required:true,validType:'checkInt'" size="40" maxlength="20"/>
	</td>
	</tr>	
		<tr>
	<th width="150">不合格项<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="unqualified" id="unqualified"  value="${um.unqualified}"  class="easyui-validatebox text1" data-options="required:true"  style="width:260px"  />
	</td>
		<th width="150">处理单号<span class="required">*</span>：</th>
	<td>
		<input type="text" name="processingNo" id="processingNo"  value="${um.processingNo}"  class="easyui-validatebox text1"  data-options="required:true,validType:'checkInt'" size="40" maxlength="20"/>
	</td> -->
	</tr>	
			<tr>
	<th width="150">处理日期<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="processingDate" id="processingDate" value="${um.processingDate}"   class="easyui-datebox text1" data-options="required:true"  style="width:260px"  />
	</td>
	<!--  <th>有效期至<span class="required">*</span>：</th>
		<td>
		<input type="text" name="validUntil" id="validUntil" class="easyui-datebox text1" data-options="required:true,value:'${um.validUntil }'" style="width:260px"/>
		</td>-->
	<th width="150">通知日期<span class="required">*</span>：</th>
	<td>
	    <input type="text" name="shipmentdate" id="shipmentdate"  value="${um.shipmentdate}"  class="easyui-datebox text1" data-options="required:true"  style="width:260px"  />
	</td>
	</tr>
		  <tr>
            <th valign="top">检查情况：</th>
            <td colspan="3"><textarea name="qualitysituation" id="qualitysituation" cols="99" rows="4" class="easyui-validatebox  textarea"  >${um.qualitysituation}</textarea></td>
      </tr>
        <tr>
            <th valign="top">处理意见：</th>
            <td colspan="3"><textarea name="result" id="result" cols="99" rows="4" class="easyui-validatebox  textarea"  >${um.result}</textarea></td>
      </tr>
        <tr>
           <!-- <th valign="top">备注：</th>
            <td colspan="3"><textarea name="remark" id="remark" cols="99" rows="4" class="easyui-validatebox  textarea"  >${um.remark}</textarea></td> --> 
      </tr>
	
</table>
<table>
	<tr align="center">
		<td colspan="4">
				<input type="button" class="btn_big"  name="" onclick="save()" value="<fmt:message key='button.save'/>"/>
			<input type="button" class="btn_big" name="cancel" onclick="onCancel();" value="<fmt:message key="button.cancel"/>"/>
		</td>
	</tr>
</table>

<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
</form>

<script type="text/javascript">
$("#commonnamebox").combobox({
			filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q) > -1;
	}
		})
    function onCancel()
    {
    	history.go(-1);
    }
        function find(s){
	    if(s.value!=""){
			$.post("${ctx}/qualityRecords/unqualifiedManger/quamap.html",{
			"quamap" : s,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
				    $("#dosageforms").val(c[1]);
					$("#specifications").val(c[2]);
					$("#licensenumber").val(c[3]);
					$("#produceno").val(c[4]);
					$("#customerName").val(c[7]);
					$("#medicinalNo").val(c[5]);
					$("#unit").val(c[6]);	
					/*$("#medicinalNo").val(c[1]);
					$("#dosageforms").val(c[1]);
					$("#specifications").val(c[2]);
					$("#licensenumber").val(c[3]);
					$("#produceno").val(c[4]);
				    $("#customerName").val(c[5]);*/	
				var tt = document.getElementById("qualifiedmedicineid");   
       				for(var ll=0;ll<tt.length;ll++){
        				if(c[5]==tt.options[ll].value){
            			tt.options[ll].selected=true;
		                 }  
    	            }
				}else{
					return;
				}
			});
	    }else{
	    	$("#dosageforms").val("");
			$("#specifications").val("");
			$("#licensenumber").val("");
			$("#produceno").val("");
			$("#customerName").val("");
	    }
    
    }
     function save(){

      
            $('#drs').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="list.html";
			    }  
			});  
         

		
		}
			$(function() {
    	var tt = document.getElementById("qualifiedmedicineid");   
    	var jj = document.getElementById("qualifiedmedicineidValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
    	}
    	
    
    });
</script>

