<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="质量事故"/></title>
    <meta />
</head>
<form:form commandName="qa" method="post" action="saveOrUpdata.html" id="drs">
<form:hidden path="id"/>
<input type="hidden" name="method" value="${method}" />
<input type="hidden" name="thispage" value="${thispage}" />

<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">质量记录管理&nbsp;>&nbsp;质量事故&nbsp;>&nbsp;${titles}</font>   
	<tr>
	<th width="150">编号<span class="required">*</span>：</th>
	<td>
		<input type="text" name="number" id="number" value="${qa.number}"  class="easyui-validatebox text1" data-options="required:true"  size="40"/>
	</td>
	<th width="150">药品编号<span class="required">*</span>：</th>
	<td>
		<input type="text" name="drugsnumber" id="drugsnumber" value="${qa.drugsnumber}"  class="easyui-validatebox text1" data-options="required:true"  size="40"/>
	</td>
	</tr>
	<tr>
		  	<th width="150">通用名称<span class="required">*</span>：</th>
		<td style="width:400px;">
			<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
       			value:'${qa.qualityMidicine.id}',
      		url:'${ctx}/drugState/inspectionRecords/findypboxqy.html',
      		onSelect: function(rec){
      			find(rec.id);
      		}
			" name="qualifiedmedicineid" id="qualifiedmedicineid" size="40"/>&nbsp;&nbsp;
		</td>
		<th width="150">剂型<span class="required">*</span>：</th>
	<td>
		<input type="text" name="qualityMidicine.dosageforms.formName" id="dosageforms" value="${qa.qualityMidicine.dosageforms.formName}" class="text1" size="40"/>
	</td>
	</tr>
	<tr>	
	

	<th width="150">规格<span class="required">*</span>：</th>
	<td>
		<input type="text" name="qualityMidicine.specifications" id="specifications" value="${qa.qualityMidicine.specifications}" class="text1" size="40"/>
	</td>
		<th width="150">批号<span class="required">*</span>：</th>
	<td>
		<input type="text" name="batchproduction" id="batchproduction"  value="${qa.batchproduction}" class="easyui-validatebox text1" data-options="required:true"  size="40"/>
	</td>	
	</tr>	
	<tr>
	<th width="150">生产厂家<span class="required">*</span>：</th>
	<td>
		<input type="text" name="qualityMidicine.produceno.customerName" id="produceno"  value="${qa.qualityMidicine.produceno.customerName}"  class="easyui-validatebox text1"  size="40"/>
	</td>
	<th width="150">供货单位<span class="required">*</span>：</th>
	<td>
	<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
      		url:'${ctx}/firstEnterprise/qualitySupplyJson.html',
      		value:'${gongyingshang}',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#deliveryunitidValue').val(str[1]);
      		}
			" name="" id="commonnamebox" size="40"/>&nbsp;&nbsp;
	
		<input type="hidden" name="deliveryunitid" id="deliveryunitidValue" class="text1" value="${qa.deliveryunitid}" size="40"/>
	</tr>
	<tr>
	<th width="150">数量<span class="required">*</span>：</th>
	<td>
		<input type="text" name="quantity" id="quantity" value="${qa.quantity}"  class="easyui-validatebox text1"  data-options="required:true,validType:'checkInt'" size="40" maxlength="20"/>
	</td>
	</tr>
	<tr>
            <th valign="top">事故情况:</th>
            <td colspan="3"><textarea name="accidentconditions" id="accidentconditions" cols="94" rows="4" class="textarea">${qa.accidentconditions}</textarea></td>
      </tr>
	<tr>
            <th valign="top">处理意见:</th>
            <td colspan="3"><textarea name="handlingsuggestion" id="handlingsuggestion" cols="94" rows="4" class="textarea">${qa.handlingsuggestion}</textarea></td>
      </tr>

	<tr>
            <th valign="top">事故分析:</th>
            <td colspan="3"><textarea name="accidentanalysis" id="accidentanalysis" cols="94" rows="4" class="textarea">${qa.accidentanalysis}</textarea></td>
      </tr>
	 <tr>
            <th valign="top">处理结果：</th>
            <td colspan="3"><textarea name="result" id="result" cols="94" rows="4" class="textarea">${qa.result}</textarea></td>
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
</form:form>
<script type="text/javascript">
    function onCancel()
    {
    	history.go(-1);
    }
          function find(s){
	    if(s.value!=""){
			$.post("${ctx}/qualityRecords/qualityQuery/quamap.html",{
			"quamap" : s,
			},function(data){
				if(data){
					var b = data.toString();
					
					var c = b.split(",");
					$("#dosageforms").val(c[1]);
					$("#specifications").val(c[2]);
					$("#licensenumber").val(c[3]);
					$("#produceno").val(c[4]);
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
    	
    
    }
  
    );
</script>

