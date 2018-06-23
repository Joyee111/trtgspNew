<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="药品养护"/></title>
    <meta />
</head>
<form:form commandName="dm" method="post" action="${ctx}/qualityRecords/drugMaintenance/saveOrUpdata.html" id="drs">
<form:hidden path="id"/>
<input type="hidden" name="method" value="${method}" />
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" name="re_id" value="${dm.qualifiedmedcstoreRe.id}"/>

<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">质量记录管理&nbsp;>&nbsp;药品养护&nbsp;>&nbsp;${titles}</font>
     <tr>
     	<th width="150">通用名称<span class="required">*</span>：</th>
		<td style="width:400px;">
		<input type="text" class="easyui-combobox  text1" data-options="
     	 	valueField: 'id',
      		textField: 'text',
     		url:'${ctx}/drugState/stopcell/findypboxqy.html',
     		  value:'${dm.qualifiedmedcstoreRe.qualityMidicine.id}',
     		onSelect: function(rec){
     			var url = '${ctx}/drugState/stopcell/findypboxbyid.html?id='+rec.id;
     			$('#batchnumber').combobox('setValue', '');  
     			 $('#batchnumber').combobox('reload', url);   
     			find(rec.id);
     		}
		" name="qualifiedMedicineId" id="qualifiedMedicineId" size="40"/>&nbsp;&nbsp;
			<input type="hidden" name="qualifiedmedicineidValue" id="qualifiedmedicineidValue" class="text1" value="${dm.qualifiedmedicineid}" size="40"/>
	</td>
		<th width="150">养护日期<span class="required">*</span>：</th>
	<td>
	
	<c:choose>
		<c:when test="${dateDisableFlag == 'true'}">
			<input type="text" class="easyui-datebox" name="maintaindate" id="maintaindate" value="" class="easyui-datebox text1" data-options="required:true,validType:'date',disabled:true" size="40"/>
		</c:when>
		<c:when test="${dateDisableFlag == 'false'}">
			<input type="text" class="easyui-datebox" name="maintaindate" id="maintaindate" value="" class="easyui-datebox text1" data-options="required:true,disabled:true" size="40"/>
		</c:when>
	</c:choose>
	
	</td>
		</tr>	
	<tr>
	<th width="150">生产批号<span class="required">*</span>：</th>

		<td class="left" style="width:350px;">
		<input id="batchnumber"  class="easyui-combobox text1" data-options="valueField:'id',textField:'text',
		value:'${dm.batchnumber}',
		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#batchnumberValue').val(str[0]);
      			$('#maxquantity').val(str[1]);
      		}
		"  size="40"/>
			<input type="hidden" name="batchnumber" id="batchnumberValue" value="${dm.batchnumber}"/>
	</td>
	<th width="150">数量<span class="required">*</span>：</th>
	<td>
		<input type="text" name="quantity" id="quantity" value="${dm.quantity}"   class="easyui-validatebox text1"  data-options="required:true,validType:'checkInt'" size="40" maxlength="20"/>
	</td>
	
	</tr>
	<tr>
	
	<th width="150">货位：</th>
	<td>
		<input type="text" name="goodsallocation" id="goodsallocation" value="${dm.goodsallocation}"  class="easyui-validatebox text1" data-options="required:false"  size="40"/>
	</td>
		<th width="150">是否合格<span class="required">*</span>：</th>
	<td>
		<select style="width:260px" data-options="required:true" class="easyui-validatebox text1" name="isqualified" id="isqualified">
				<option value="1">合格</option>
				<option value="0">不合格</option>
				
			</select>	
			<input type="hidden" name="isqualifiedValue" id="isqualifiedValue" class="text1" value="${dm.isqualified}" size="40"/>
	</td>
	</tr>
	 <tr>
            <th valign="top">质量情况：</th>
            <td colspan="3"><textarea name="qualityproblemString" id="qualityproblemString" cols="94" rows="4" class="easyui-validatebox  textarea"  >${dm.qualityproblemString}</textarea></td>
	</tr>
	 <tr>
            <th valign="top">养护措施：</th>
            <td colspan="3"><textarea name="conservationmeasures" id="conservationmeasures" cols="94" rows="4" class="easyui-validatebox  textarea"  >${dm.conservationmeasures}</textarea></td>
      </tr>
       <tr>
            <th valign="top">处理结果：</th>
            <td colspan="3"><textarea name="result" id="result" cols="94" rows="4" class="easyui-validatebox  textarea" >${dm.result}</textarea></td>
      </tr>
         <tr>
            <th valign="top">备注：</th>
            <td colspan="3"><textarea name="remark" id="remark" cols="94" rows="4" class="easyui-validatebox  textarea"  >${dm.remark}</textarea></td>
      </tr>
</table>
<table>
	<tr align="center">
		<td colspan="4">
			<c:choose>
				<c:when test="${method eq 'add'}">
					<input type="button" class="btn_big"  name="" onclick="save()" value="<fmt:message key='button.save'/>"/>
				</c:when>
				<c:otherwise>
					<input type="button" class="btn_big"  name="" onclick="$('#dialog').dialog('open')" value="<fmt:message key='button.save'/>"/>
				</c:otherwise>
			</c:choose>
			
			<input type="button" class="btn_big" name="cancel" onclick="onCancel();" value="<fmt:message key="button.cancel"/>"/>
		</td>
	</tr>
</table>
      <div id="dialog" title="修改原因" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:200">
    	<table>
    	<tr>
            <th valign="top">修改原因：</th>
            <td colspan="3"><textarea name="rejectcause" id="rejectcause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
           	<input type="button" class="btn_big" onclick="save()" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
        </div>

<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type = "hidden" name="modify_reason" id="modify_reason"/>

</form:form>
<script type="text/javascript">
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
	    }
    
    }
    function save(){
    	var  dialog = $("#dialog").dialog();
		var value =  dialog.get(0).getElementsByTagName("textarea")[0].value;
		$("#modify_reason").val(value);
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
    	var tt = document.getElementById("isqualified");   
    	var jj = document.getElementById("isqualifiedValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
    	}
    	
 
    	
    
    });
    $(function() {
    	//alert(getCurrentDate());
    	$("#maintaindate").datebox("setValue",getCurrentDate());
    	var tt = document.getElementById("qualifiedmedicineid");   
    	var jj = document.getElementById("qualifiedmedicineidValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
    	}
    	
    
    });
    
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
</script>

