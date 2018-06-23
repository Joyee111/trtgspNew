<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="报废药品"/></title>
    <meta />
</head>
<form commandName="um" method="post" action="dlrupdate.html" id="drs">  
<input type="hidden" name="method" value="${method}" />
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" name="id" value="${um.id}" />
<input type="hidden" name="shuliang" id="shuliang"  value="${um.quantity}" />
<input type="hidden" name="qpihao" id="qpihao"  value="${um.batchno}" />
<input type="hidden" name="qbhgQuantity" id="qbhgQuantity"  value="${qbhgQuantity}" />
<input type="hidden" name="qhgQuantity" id="qhgQuantity"  value="${qhgQuantity}" />
<input type="hidden" name="batchno2" id="batchno2"  />
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">	
    <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;报废药品&nbsp;>&nbsp;${titles}</font>
	
	<tr>
	<!--  <th width="150">生产批号<span class="required">*</span>：</th>

		<td class="left" style="width:350px;">
		<input id="batchno"  class="easyui-combobox" data-options="
		value:'${um.batchno}',
		valueField:'id',
		textField:'text',
		url:'${ctx}/drugState/scrap/findbatch.html',
		onSelect: function(rec){
      			$('#batchnoValue').val(rec.text);
      			find(rec.id);
      		}
		" />
		<input type="hidden" name="batchno" id="batchnoValue" value="${um.batchno}"/>
	</td>-->
	<th width="150">药品编号<span class="required">*</span>：</th>

		<td class="left" style="width:350px;">
		<input id="medicinalNo"  class="easyui-combobox" data-options="
		value:'${um.medicinalNo}',
		valueField:'id',
		textField:'text',
		url:'${ctx}/drugState/scrap/findbatch.html',
		onSelect: function(rec){
      			$('#medicinalNoValue').val(rec.text);
      			find(rec.id);
      		}
		" />
		<!--<input type="hidden" name="medicinalNo" id="medicinalNoValue" value="${um.qualifiedmedcstore.qualityMidicine.medicinalNo}"/>-->
		<input type="hidden" name="medicinalNo" id="medicinalNoValue" value="${um.medicinalNo}"/>
	</td>
	<th width="150">数量<span class="required">*</span>：</th>
	<td>
		<input type="text"  name="quantity" id="quantity"  value="${um.quantity}"  class="easyui-validatebox text1"  data-options="required:true,validType:'checkInt'" size="40" maxlength="20"/>
		
	</td>
		
	</tr>
	<tr>
     	<th width="150">通用名称<span class="required">*</span>：</th>
		<td style="width:400px;">
			<input type="text" class="easyui-validatebox  text1" value="${qm.commonname}"
			" name="commonname" id="commonName" size="40"/>&nbsp;&nbsp;
			<input type="hidden" name="qualifiedmedicineid"  id="qualifiedMedicineId"  value="${um.qualifiedmedicineid}"/>
		</td>
	<th width="150">生产批号<span class="required">*</span>：</th> 
	<td>
		<input type="text" name="batchno" id="batchno" class="easyui-validatebox text1" data-options="required:true" size="40" value="${um.batchno}"  />
	</td>
	<!--  <th width="150">药品编号<span class="required">*</span>：</th>
	<td>
		<input type="text" name="medicinalNo" id="medicinalNo" class="easyui-validatebox text1" data-options="required:true" size="40" value="${um.qualifiedmedcstore.qualityMidicine.medicinalNo}"  />
	</td>-->
	</tr>
	<tr>
	<th width="150">单位<span class="required">*</span>：</th>
	<td>
		<!-- <input type="text" name="qualifiedmedcstore.qualityMidicine.unit" id="unit"  value="${um.qualifiedmedcstore.qualityMidicine.unit}" class="easyui-validatebox text1" size="40"/>-->
		<input type="text" name="unit" id="unit"  value="${qm.unit}" class="easyui-validatebox text1" size="40"/>
	</td>
		<!--  <th width="150">剂型<span class="required">*</span>：</th>
	<td>
		<input type="text" name="qualifiedmedcstore.qualityMidicine.dosageforms.formName" id="dosageforms"  value="${um.qualifiedmedcstore.qualityMidicine.dosageforms.formName}" class="easyui-validatebox text1" size="40"/>
	</td>-->
		<th width="150">规格<span class="required">*</span>：</th>
	<td>
		<!-- <input type="text" name="qualifiedmedcstore.qualityMidicine.specifications" id="specifications"  value="${um.qualifiedmedcstore.qualityMidicine.specifications}" class="easyui-validatebox text1"  size="40"/>-->
	    <input type="text" name="specifications" id="specifications"  value="${qm.specifications}" class="easyui-validatebox text1"  size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">生产厂家<span class="required">*</span>：</th>
	<td>
		<!-- <input type="text" name="qualifiedmedcstore.qualityMidicine.produceno.customerName" id="produceno" value="${um.qualifiedmedcstore.qualityMidicine.produceno.customerName}" class="easyui-validatebox text1"  size="40"/>-->
	    <input type="text" name="qualityMidicine.produceno.customerName" id="produceno" value="${qm.produceno.customerName}" class="easyui-validatebox text1"  size="40"/>
	</td>
	<th>供货单位<span class="required">*</span>：</th>
	<td>
		<!--<input type="text" name="qualifiedmedcstore.qualityMidicine.supplyUnit.customerName" id="customerName"  value="${um.qualifiedmedcstore.qualityMidicine.supplyUnit.customerName}" class="easyui-validatebox text1" size="40"/>-->
		<input type="text" name="qualityMidicine.supplyUnit.customerName" id="customerName"  value="${qm.supplyUnit.customerName}" class="easyui-validatebox text1" size="40"/>
	</td>
	
	</tr>	
	
	
	<tr>
	   <th width="150">通知日期<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="processingDate" id="processingDate" value="${um.processingDate}"   class="easyui-datebox text1" data-options="required:true"  style="width:260px"  />
		</td>
	
      <th width="150">财损<span class="required">*</span>：</th>
      <td>
      <input type="text"  name="lossProperty" id="lossProperty"  value="${um.lossProperty}"  class="easyui-validatebox text1"  data-options="required:true,validType:'checkInt'" size="40" maxlength="20"/>
      </td>	
	<!--<th width="150">收货日期<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="shipmentdate" id="shipmentdate"  value="${um.shipmentdate}"  class="easyui-datebox text1" data-options="required:true"  style="width:260px"  />
	</td>
		<th width="150">收货凭证号<span class="required">*</span>：</th>
	<td>
		<input type="text" name="harvestNumber" id="harvestNumber"  value="${um.harvestNumber}"  class="easyui-validatebox text1"  data-options="required:true,validType:'checkInt'" size="40" maxlength="20"/>
	</td>-->
	</tr>	
		<!--  <tr>
	<th width="150">不合格项<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="unqualified" id="unqualified"  value="${um.unqualified}"  class="easyui-validatebox text1" data-options="required:true"  style="width:260px"  />
	</td>
		<th width="150">处理单号<span class="required">*</span>：</th>
	<td>
		<input type="text" name="processingNo" id="processingNo"  value="${um.processingNo}"  class="easyui-validatebox text1"  data-options="required:true,validType:'checkInt'" size="40" maxlength="20"/>
	</td>
	</tr>	
			<tr>
	<th width="150">处理日期<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="processingDate" id="processingDate" value="${um.processingDate}"   class="easyui-datebox text1" data-options="required:true"  style="width:260px"  />
	</td>
	
	<th>有效期至<span class="required">*</span>：</th>
		<td>
		<input type="text" name="validUntil" id="validUntil" class="easyui-datebox text1" data-options="required:true" value="${um.validUntil}" style="width:260px"/>
		</td>
	</tr>	
		  <tr>
            <th valign="top">质量情况：</th>
            <td colspan="3"><textarea name="qualitysituation" id="qualitysituation" cols="99" rows="4" class="easyui-validatebox  textarea"  >${um.qualitysituation}</textarea></td>
      </tr>
        <tr>
            <th valign="top">处理结果：</th>
            <td colspan="3"><textarea name="result" id="result" cols="99" rows="4" class="easyui-validatebox  textarea"  >${um.result}</textarea></td>
      </tr>
       <tr>
            <th valign="top">备注：</th>
            <td colspan="3"><textarea name="remark" id="remark" cols="99" rows="4" class="easyui-validatebox  textarea"  >${um.remark}</textarea></td>
      </tr>
      <tr>
            <th valign="top">申请原因：</th>
            <td colspan="3"><textarea name="scrapReason" id="scrapReason" cols="99" rows="4" class="easyui-validatebox  textarea"  >${um.scrapReason}</textarea></td>
      </tr>-->
      <tr>
	      <th>库房标识<span class="required">*</span>：</th>
          	<td>
          		    <c:choose>
          		         <c:when test="${um.state eq 'A'}">
          		              	<label for="" style="font-size:12px; color:#727171; font-weight:bold;">合格</label>
          		                   <input type="radio" name="state" value="A" checked/>
          		                   <label for="" style="font-size:12px; color:#727171; font-weight:bold;">不合格</label>
          		                   <input type="radio" name="state" value="C"/>
          		         </c:when>
          		         <c:when test="${um.state eq 'C'}">
          		              	   <label for="" style="font-size:12px; color:#727171; font-weight:bold;">合格</label>
          		                   <input type="radio" name="state" value="A"/>
          		                   <label for="" style="font-size:12px; color:#727171; font-weight:bold;">不合格</label>
          		                   <input type="radio" name="state" value="C" checked/>
          		         </c:when>
          		         <c:otherwise>
          		                   <label for="" style="font-size:12px; color:#727171; font-weight:bold;">合格</label>
          		                   <input type="radio" name="state" value="A"/>
          		                   <label for="" style="font-size:12px; color:#727171; font-weight:bold;">不合格</label>
          		                   <input type="radio" name="state" value="C"/>
          		         
          		         </c:otherwise>
          		    </c:choose>
          	         	
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
	
</table>
<table>
	<tr align="center">
		<td colspan="4">
				<input type="button" class="btn_big"  name="" onclick="save(0)" value="<fmt:message key='button.save'/>"/>
				<input type="button" class="btn_big"  name="" onclick="save(1)" value="提交"/>
			<input type="button" class="btn_big" name="cancel" onclick="onCancel();" value="<fmt:message key="button.cancel"/>"/>
		</td>
	</tr>
</table>
<input type="hidden" name="type" id="type" value="${um.status}"/>

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
			$.post("${ctx}/drugState/scrap/quamap.html",{
			"quamap" : s,
			},function(data){
				if(data){
					var b = data.toString();
					
					var c = b.split(",");
					
					$("#qualifiedMedicineId").val(c[0]);
					$("#commonName").val(c[1]);
					$("#medicinalNo").val(c[2]);
					$("#dosageforms").val(c[3]);
					$("#specifications").val(c[4]);
					$("#produceno").val(c[5]);
					$("#customerName").val(c[7]);
					//$("#quantity").val(c[7]);
					//$("#batchno").val(c[8]);
					//$("#shipmentdate").datebox('setValue',c[9]);
					$("#harvestNumber").val(c[10]);
					$("#unqualified").val(c[11]);
					$("#processingNo").val(c[12]);
					$("#processingDate").datebox('setValue',c[13]);
					//$("#validUntil").datebox('setValue',c[14]);
					$("#qualitysituation").val(c[15]);
					$("#result").val(c[16]);
					//$("#remark").val(c[17]);
					
				}else{
					return;
				}
			});
	    }else{
	    	$("#qualifiedMedicineId").val("");
			$("#commonName").val("");
			$("#medicinalNo").val("");
			$("#dosageforms").val("");
			$("#specifications").val("");
			$("#produceno").val("");
			$("#customerName").val("");
			//$("#quantity").val("");
			//$("#batchno").val("");
			//$("#shipmentdate").datebox('setValue',"");
			$("#harvestNumber").val("");
			$("#unqualified").val("");
			$("#processingNo").val("");
			$("#processingDate").datebox('setValue',"");
			//$("#validUntil").datebox('setValue',"");
			$("#qualitysituation").val("");
			$("#result").val("");
			//$("#remark").val("");
	    }
    
    }
   function save(type){
   var quantity=$("#quantity").val();
   if(isNaN(quantity)){
    $("#quantity").val(0);
   }
   quantity=$("#quantity").val();
   if(parseInt(quantity)<1){
       alert("数量必须大于0");
       return;
   }
   $("#type").val(type);
         $('#drs').form('submit',{  
		    success: function(data){  
			var json = jsonParse(data);
			if(json.success!=null && json.success!=""){
				alert(decodeURI( json.success));
				
			}
			location.href="dlrlist.html";
		    }  
		}); 
		
	}
	$(function() {
    	var tt = document.getElementById("qualifiedmedicineid");   
    	/*var jj = document.getElementById("qualifiedmedicineidValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
    	}
    	*/
    
    });
</script>

