<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="投诉管理"/></title>
    <meta />
</head>
<form:form commandName="dr" method="post" action="saveOrUpdata.html" id="drs">
<form:hidden path="id"/>
<input type="hidden" name="method" value="${method}" />
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" name="role_Id"  id="role_Id" value="" />
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;投诉查询&nbsp;>&nbsp;${titles}</font>
   <tr>
   	 <th width="150">编号<span class="required">*</span>：</th>
		<td>
			<input type="text" name="bianhao" id="bianhao"  value="${dr.bianhao}"  readonly="readonly" class="easyui-validatebox text1" data-options="required:true" size="40" maxlength="20"/>
		</td>
	 <th width="150">投诉者<span class="required">*</span>：</th>
		<td>
			<input type="text" name="complainant" id="complainant"  value="${dr.complainant}" readonly="readonly"  class="easyui-validatebox text1" data-options="required:true" size="40" maxlength="20"/>
		</td>
			
	
	</tr>
	<tr>
     	
		 <th width="150">通用名称：</th>
            <td><input name="commonname" value="${dr.quaMedicId}" type="text" readonly="readonly" class="easyui-validatebox text1"  size="40"/></td>
			
	   <th width="150">剂型：</th>
		<td>
			<input type="text" name="dosageforms" id="dosageforms" readonly="readonly" value="${dr.jixing}" class="easyui-validatebox text1"  size="40"/>
		</td>
		<tr>
		<th width="150">规格：</th>
		<td>
			<input type="text" name="specifications" id="specifications" readonly="readonly" value="${dr.guige}" class="easyui-validatebox text1" size="40"/>
		</td>
	
		<th width="150">批号：</th>
		<td>
			<input type="text"  name="licensenumber" id="licensenumber"  readonly="readonly" value="${dr.pihao}" class="easyui-validatebox text1"  size="40"/>
		</td>
		<tr>
			<th width="150">数量<span class="required">*</span>：</th>
		<td>
			<input type="text" name="quantity" id="quantity" value="${dr.quantity}" readonly="readonly" class="easyui-validatebox text1"  data-options="required:true,validType:'checkInt'" size="40" maxlength="20"/>
		</td>
		<th width="150">接收部门<span class="required">*</span>：</th>
		<td>
			<input type="text" name="jieshoubumen" id="jieshoubumen" value="${dr.jieshoubumen}" readonly="readonly" class="easyui-validatebox text1" data-options="required:true" size="40" maxlength="20"/>
		</td>
			
	</tr>
		
	<tr>
			<th width="150">联系电话<span class="required">*</span>：</th>
		<td>
			<input type="text" name="phone" id="phone" value="${dr.phone}" readonly="readonly"class="easyui-validatebox text1" data-options="required:true,validType:'checkTellOrPhone'" size="40" maxlength="20"/>
		</td>
		
	<th width="150">联系地址<span class="required">*</span>：</th>
		<td>
			<input type="text" name="address" id="address"  value="${dr.address}" readonly="readonly" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
		</td>
		
		
	</tr>	
		<tr>
			
		
	<th width="150">投诉方式<span class="required">*</span>：</th>
			 <td><input name="tousufangshi" value="${dr.tousufangshi}" type="text" readonly="readonly" class="easyui-validatebox text1"  size="40"/></td>
	</td>
			
	</tr>	
	<tr>
            <th valign="top">投诉内容：</th>
            <td colspan="3"><textarea name="compcontent" id="compcontent" readonly="readonly" cols="94" rows="4" class="easyui-validatebox  textarea"  >${dr.compcontent}</textarea></td>
      </tr> 
	  <tr>
            <th valign="top">调查与评估：</th>
            <td colspan="3"><textarea name="handsuggestion" id="handsuggestion" readonly="readonly" cols="94" rows="4" class="easyui-validatebox  textarea"  >${dr.handsuggestion}</textarea></td>
      </tr>
	
	   <tr>
            <th valign="top">处理措施：</th>
            <td colspan="3"><textarea name="results" id="results" cols="94" rows="4" readonly="readonly" class="easyui-validatebox  textarea"  >${dr.results}</textarea></td>
      </tr>
         <tr>
            <th valign="top">反馈与事后跟踪：</th>
            <td colspan="3"><textarea name="infofree" id="infofree" cols="94" rows="4" readonly="readonly" class="easyui-validatebox  textarea"  >${dr.infofree}</textarea></td>
      </tr>
</table>

<table>
	<tr align="center">
		<td colspan="4">
	
			<input type="button" class="btn_big"  name="cancel" onclick="onCancel();" value="<fmt:message key="返回"/>"/>
		
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
					var tt = document.getElementById("quaMedicId");   
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
		var dia = $("#dialog").dialog();
	    var value = dia.get(0).getElementsByTagName("select")[0].value;
		$("#role_Id").val(value);
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
    	var tt = document.getElementById("tousufangshi");   
    	var jj = document.getElementById("tousufangshiValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
    	}
    	
    	
    });
</script>

