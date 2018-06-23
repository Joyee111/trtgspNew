<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="设备运行"/></title>
    <meta />
</head>
<script type="text/javascript">
 function onCancel()
    {
    	history.go(-1);
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
    	var tt = document.getElementById("istroubleclear");   
    	var jj = document.getElementById("istroubleclearValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
    	}
    	var ttt = document.getElementById("isreport");
    	var jjj = document.getElementById("isreportValue").value; 
        for(var lll=0;lll<ttt.length;lll++){
          if(jjj==ttt.options[lll].value){
              ttt.options[lll].selected=true;
		      }  
    	}
 
    	
    
    });
</script>
<form:form commandName="eo" method="post" action="saveOrUpdata.html" id="drs">
<form:hidden path="id"/>
<input type="hidden" name="method" value="${method}" />
<input type="hidden" name="thispage" value="${thispage}" />

<div class="ceng_mar5" style="padding-bottom:5px;">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">质量记录管理&nbsp;>&nbsp;设备运行&nbsp;>&nbsp;${titles}</font>
	<tr>
		<th width="150">交班人<span class="required">*</span>：</th>
	<td>
		<input type="text" name="handperson" id="handperson" value="${eo.handperson}"  class="easyui-validatebox text1" data-options="required:true"  size="40"/>
	</td>
	<th width="150">交接时间<span class="required">*</span>：</th>
	<td>
		<input type="text"  name="handoverdate" id="handoverdate" value="${eo.handoverdate}" class="easyui-datebox text1" data-options="required:true"  size="40"/>
	</td>			
	</tr>
	<tr>	
	<th width="150">接班人<span class="required">*</span>：</th>
	<td>
		<input type="text" name="receiveperson" id="receiveperson" value="${eo.receiveperson}"  class="easyui-validatebox text1" data-options="required:true"  size="40"/>
	</td>
	<th width="150">完好状态检查<span class="required">*</span>：</th>
	<td>
		<input type="text" name="intactstatus" id="intactstatus" value="${eo.intactstatus}"   class="easyui-validatebox text1" data-options="required:true"  size="40"/>
	</td>	
	
		
	</tr>	
	
	<tr>
	<th width="150">运行时间<span class="required">*</span>：</th>
	<td>
		<input type="text" name="runtime" id="runtime"  value="${eo.runtime}" class="easyui-validatebox text1" data-options="required:true"  size="40"/>
	</td>
	<th width="150">故障停机小时<span class="required">*</span>：</th>
	<td>
		<input type="text" name="downtimehours" id="downtimehours"  value="${eo.downtimehours}" class="easyui-validatebox text1" data-options="required:true"  size="40"/>
	</td>
	
	</tr>	
	
	<tr>
	<th width="150">上报<span class="required">*</span>：</th>
	<td>
		<select style="width:260px" data-options="required:true" class="easyui-validatebox text1" name="isreport" id="isreport">
		        <option value="">--请选择--</option>
				<option value="0">否</option>
				<option value="1">是</option>
			</select>	
			<input type="hidden" name="isreportValue" id="isreportValue" class="text1" value="${eo.isreport}" size="40"/>
	</td>	
	<th width="150">故障排除<span class="required">*</span>：</th>
	<td>
		<select style="width:260px" data-options="required:true" class="easyui-validatebox text1" name="istroubleclear" id="istroubleclear">
		        <option value="">--请选择--</option>
				<option value="0">否</option>
				<option value="1">是</option>
			</select>	
			<input type="hidden" name="istroubleclearValue" id="istroubleclearValue" class="text1" value="${eo.istroubleclear}" size="40"/>
	</td>
	</tr>
	  <tr>
            <th valign="top">其他维修记录：</th>
            <td colspan="3"><textarea name="elserecord" id="elserecord" cols="94" rows="4" class="textarea">${eo.elserecord}</textarea></td>
      </tr>
      <tr>
            <th valign="top">故障维修记录：</th>
            <td colspan="3"><textarea name="faultrepairrecords" id="faultrepairrecords" cols="94" rows="4" class="textarea">${eo.faultrepairrecords}</textarea></td>
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
</div>
<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
</form:form>



