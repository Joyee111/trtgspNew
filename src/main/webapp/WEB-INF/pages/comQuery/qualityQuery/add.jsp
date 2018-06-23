<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="药品质量查询"/></title>
    <meta />
</head>
<form:form commandName="qq" method="post" action="saveOrUpdata.html" id="drs">
<form:hidden path="id"/>
<input type="hidden" name="method" value="${method}" />
<input type="hidden" name="thispage" value="${thispage}" />
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">	
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;药品质量查询&nbsp;>&nbsp;${titles}</font>   
	<tr>	
	<th width="150">查询单位<span class="required">*</span>：</th>
	<td>
		<input type="text" name="inquiryunit" id="inquiryunit"  value="${qq.inquiryunit}" class="easyui-validatebox text1" data-options="required:true"  size="40" />
	</td>
	<th width="150">查询时间<span class="required">*</span>：</th>
	<td>
	<input type="text"  name="qualitydate" id="qualitydate" value="${qq.qualitydate}" class="easyui-datebox text1" data-options="required:true,validType:'date'"  size="40"/>
	</td>
	</tr>
	<tr>
		
	<th width="150">通用名称<span class="required">*</span>：</th>
		<td style="width:400px;">
			<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
       		value:'${qq.qualifiedmedicineid}',
      			url:'${ctx}/qualityRecords/complantManger/findypboxqy.html',
      		onSelect: function(rec){
      			find(rec.id);
      		}
			" name="qualifiedmedicineid" id="qualifiedmedicineid" size="40" readonly="readonly"/>&nbsp;&nbsp;
		</td>
	<th width="150">剂型：</th>
	<td>
		<input type="text" name="dosageforms" id="dosageforms"   value="${qq.jixing}" class="easyui-validatebox text1"  size="40" readonly="readonly"/>
	</td>
	</tr>
	<tr>
	
	<th width="150">规格：</th>
	<td>
		<input type="text" name="specifications" id="specifications"   value="${qq.guige}" class="easyui-validatebox text1" size="40" readonly="readonly"/>
	</td>
	<th width="150">批准文号：</th>
	<td>
		<input type="text" name="licensenumber" id="licensenumber" value="${qq.pihao}"  class="easyui-validatebox text1"  size="40" readonly="readonly"/>
	</td>
	</tr>	
	
	<tr>
	<th width="150">生产厂商：</th>
	<td>
		<input type="text" name="produceno" id="produceno"  value="${qq.scdw}"  class="easyui-validatebox text1"  size="40"/>
	</td>
	<th width="150">批号<span class="required">*</span>：</th>
	<td>
		<input type="text" name="batchproduction" id="batchproduction" value="${qq.batchproduction}"  class="easyui-validatebox text1" data-options="required:true" readonly="readonly" size="40"/>
	</td>
	</tr>	
	<tr>
		<th width="150">数量：</th>
	<td>
		<input type="text" name="quantity" id="quantity"   value="${qq.quantity}" class="easyui-validatebox text1"   size="40" maxlength="20" readonly="readonly"/>
	</td>
	</tr>
    <tr>
         <th valign="top">查询原因：</th>
         <td colspan="3"><textarea name="qualityreason" id="qualityreason" cols="94"rows="4"  class="easyui-validatebox  textarea" readonly="readonly" >${qq.qualityreason}</textarea></td>
      </tr>
	<tr>
         <th valign="top">查核情况：</th>
         <td colspan="3"><textarea name="checksituation" id="checksituation" cols="94" rows="4" class="easyui-validatebox  textarea"  readonly="readonly">${qq.checksituation}</textarea></td>
      </tr>
	 <tr>
          <th valign="top">处理结果：</th>
          <td colspan="3"><textarea name="result" id="result" cols="94" rows="4" class="easyui-validatebox  textarea"  readonly="readonly">${qq.result}</textarea></td>
      </tr>
	

</table>
<table>
	<tr align="center">
		<td colspan="4">
			<input type="button" class="btn_big" name="cancel" onclick="onCancel();" value="还回"/>
		</td>
	</tr>
</table>
</div>
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

