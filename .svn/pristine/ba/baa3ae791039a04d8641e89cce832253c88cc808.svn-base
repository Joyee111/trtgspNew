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
<input type="hidden" id="qsmap" value = "${qsmap}" />
<input type="hidden" name="pinming" id="pinming" value="${pinming}" />
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">质量记录管理&nbsp;>&nbsp;投诉管理&nbsp;>&nbsp;${titles}</font>
   <tr>
   	 <th width="150">编号<span class="required">*</span>：</th>
		<td>
			<input type="text" name="bianhao" id="bianhao"  value="${dr.bianhao}"  class="easyui-validatebox text1" data-options="required:true" size="40" maxlength="20"/>
		</td>
	 <th width="150">投诉者<span class="required">*</span>：</th>
		<td>
			<input type="text" name="complainant" id="complainant"  value="${dr.complainant}"  class="easyui-validatebox text1" data-options="required:true" size="40" maxlength="20"/>
		</td>
			
	
	</tr>
	<tr>
     	<th width="150">通用名称：</th>
		<td style="width:400px;">
		<!-- 	<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
       		value:'${dr.quaMedicId}',
      		url:'${ctx}/qualityRecords/complantManger/findypboxqy.html',
      		onSelect: function(rec){
      			find(rec.id);
      		}
			" name="quaMedicId" id="quaMedicId" size="40"/>&nbsp;&nbsp; -->
			<input type="text" name="quaMedicId" id="quaMedicId" value="${dr.quaMedicId }" class="text1" size="40">
		
			
	   <th width="150">剂型：</th>
		<td>
			<input type="text" name="dosageforms" id="dosageforms" value="${dr.jixing}" class="easyui-validatebox text1"  size="40"/>
		</td>
		<tr>
		<th width="150">规格：</th>
		<td>
			<input type="text" name="specifications" id="specifications"  value="${dr.guige}" class="easyui-validatebox text1" size="40"/>
		</td>
	
		<th width="150">批号：</th>
		<td>
			<input type="text"  name="licensenumber" id="licensenumber"  value="${dr.pihao}" class="easyui-validatebox text1"  size="40"/>
		</td>
		<tr>
			<th width="150">数量：</th>
		<td>
			<input type="text" name="quantity" id="quantity" value="${dr.quantity}"  class="easyui-validatebox text1"  size="40" maxlength="20"/>
		</td>
		<th width="150">接收部门<span class="required">*</span>：</th>
		<td>
			<input type="text" name="jieshoubumen" id="jieshoubumen" value="${dr.jieshoubumen}" class="easyui-validatebox text1" data-options="required:true" size="40" maxlength="20"/>
		</td>
			
	</tr>
		
	<tr>
			<th width="150">联系电话<span class="required">*</span>：</th>
		<td>
			<input type="text" name="phone" id="phone" value="${dr.phone}" class="easyui-validatebox text1" data-options="required:true" size="40" maxlength="20"/>
		</td>
		
	<th width="150">联系地址<span class="required">*</span>：</th>
		<td>
			<input type="text" name="address" id="address"  value="${dr.address}"  class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
		</td>
		
		
	</tr>	
		<tr>
			
		
	<th width="150">投诉方式<span class="required">*</span>：</th>
			<td>
		<select style="width:260px" data-options="required:true" class="easyui-validatebox text1" name="tousufangshi" id="tousufangshi">
		        <option value="">--请选择--</option>
				<option value="0">电话</option>
				<option value="1">传真</option>
				<option value="2">来函</option>
				<option value="3">上门</option>
			</select>	
			<input type="hidden" name="tousufangshiValue" id="tousufangshiValue" class="text1" value="${dr.tousufangshi}" size="40"/>
	</td>
		
		
	</tr>	
	<tr>
            <th valign="top">投诉内容：</th>
            <td colspan="3"><textarea name="compcontent" id="compcontent" cols="94" rows="4" class="easyui-validatebox  textarea"  >${dr.compcontent}</textarea></td>
      </tr>
	
	
	<tr align="center">
		<td colspan="4">
	      <shiro:hasPermission name="ComplaintManage_save1">
				<input name="" type="button" class="btn_big" value="指派給" onclick="$('#dialogs').dialog('open')"/>
     </shiro:hasPermission>
		</td>
	</tr>

	 
	  <tr>
            <th valign="top">调查与评估：</th>
            <td colspan="3"><textarea name="handsuggestion" id="handsuggestion" cols="94" rows="4" class="easyui-validatebox  textarea"  >${dr.handsuggestion}</textarea></td>
      </tr>
	
	   <tr>
            <th valign="top">处理措施：</th>
            <td colspan="3"><textarea name="results" id="results" cols="94" rows="4" class="easyui-validatebox  textarea"  >${dr.results}</textarea></td>
      </tr>
         <tr>
            <th valign="top">反馈与事后跟踪：</th>
            <td colspan="3"><textarea name="infofree" id="infofree" cols="94" rows="4" class="easyui-validatebox  textarea"  >${dr.infofree}</textarea></td>
      </tr>
      
</table>
 <div id="dialogs" title="指派用户" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:500">
    	<table>
		<tr>
			<td colspan="4" align="center" valign="bottom">
				<input type="button" class="btn_big" name="cancel" onclick="addyp();" value="<fmt:message key="新增用户"/>"/>
           	<input type="button" class="btn_big" onclick="save()" value="保存">
           	<input type="button" class="btn_big" onclick="$('#dialogs').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
		
		<table id="condition_table" class="table"   border="0" cellpadding="0" cellspacing="1" width="20%" align="center">
	<thead class='pn-lthead'>
	 <tr>
	 	<th>指派的用户</th><th>操作</th>
	 
	  </tr>
	 </thead>
</table>
        </div>
<table>
	<tr align="center">
		<td colspan="4">
		<shiro:hasPermission name="ComplaintManage_save2">
				<input name="" type="button" class="btn_big" value="<fmt:message key='button.save'/>" onclick="$('#dialogs').dialog('open')"/>
			<input type="button" class="btn_big"  name="cancel" onclick="onCancel();" value="<fmt:message key="button.cancel"/>"/>
			</shiro:hasPermission>
		</td>
	</tr>
</table>
<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type="hidden" name="counts" id="counts" value=""/>
</form:form>
<script type="text/javascript">
/*	 $("#quaMedicId").combobox({
			filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q.toUpperCase()) == 0;
			
		}
	});*/
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
					$("#commonname").val(c[0]);
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
	          $("#commonname").val("");
	    	$("#dosageforms").val("");
			$("#specifications").val("");
			$("#licensenumber").val("");
	    }
    
    }
    
    
    
    function save(){
		var dia = $("#dialogs").dialog();
	    var value = dia.get(0).getElementsByTagName("select");
    	var d ="";
 		for(var j=0;j<value.length;j++ ){
 			if(j==value.length-1){
 				d+=value[j].value;
 			}else{
 				d+=value[j].value+",";
 			}
	    }
	    $("#pinming").val(d);
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
    function changqm(s,aaaa){
		var a = s.substring(7,s.length);
	    var	quamap=aaaa;
	     var pinming = "pinming"+a;
		var tongyongming = "tongyongming"+a;
    	var pihao = "pihao"+a;
    	var yongliang = "yongfayongliang"+a;
    	var yongyaoshijian = "yongyaoshijian"+a;
    	var yongyaoyuanyin = "yongyaoyuanyin"+a;
    	var beizhu = "beizhu"+a;
	  
    
    }
    $(function() {
	  	var qsmap=$("#qsmap").val();
	   	 var aa = qsmap.substring(1,qsmap.length-1);
	   	 var f = aa.split(",");
	   	 var g ="";
	   	 for(var j=0;j<f.length;j++){
    	 	var e = f[j].split("=");
    	 	g+="<option value=\""+e[0]+"\">"+e[1]+"</option>"; 
    	 }
    	var a =$("#method").val();
    	if(a!="add"){
    	var pinmings=$("#pinming").val();
    	var pinmingsz=pinmings.split(",");
			for(var s=0; s<pinmingsz.length; s++)  {
			        var pinming = "pinming"+s;
			    	var tbody="tbody"+s;
			        $("#condition_table").append(" <tbody id=\""+tbody+"\"  class='pn-ltbody'>  " +
			    	"<td> " +
			    	"<select name=\""+pinming+"\">"+g+"</select>"+
			    	"</td> " +
					"<td> " +
					"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchu("+s+")\" value=\"删除\"/>"+
					"</td> " +	
			    	"</tbody>"
			    	);
			    	$("#counts").val(i);
			    	$.parser.parse($("#condition_table"));
					var tt = $("#"+pinming);
		        	for(var ll=0;ll<tt.length;ll++){
		            if(pinmingsz[s]==tt.options[ll].value){
		              	tt.options[ll].selected=true;
				      }  
		    	}
			}  
		}
});

    var i=0;
        function addyp(){
    	 var qsmap=$("#qsmap").val();
    	 var c = qsmap.substring(1,qsmap.length-1);
    	 var b = c.split(",");
    	 var d ="";
    	 var pinming = "pinming"+i;
    	 var tbody = "tbody"+i;
    	 for(var j=0;j<b.length;j++){
    	 	var e = b[j].split("=");
    	 	d+="<option value=\""+e[0]+"\">"+e[1]+"</option>"; 
    	 }
    	$("#condition_table").append(" <tbody id=\""+tbody+"\" class='pn-ltbody'>  " +
    	"<td> " +
    	"<select name=\""+pinming+"\">"+d+"</select>"+
    	"</td> " +
		"<td> " +
			"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchu("+i+")\" value=\"删除\"/>"+
		"</td> " +	
    	"</tbody>"
    	);
    
    	i++;
    	$("#counts").val(i);
    	$.parser.parse($("#condition_table"));
    }
       function shanchu(a){
    	i--;
    	$("#counts").val(i);
    	var b = "tbody"+a;
		var table = document.getElementById("condition_table");
    	var tbodies= table.getElementsByTagName("tbody");
    	for(var f=0;f<tbodies.length;f++){
		if(tbodies[f].id==b){
		   table.removeChild(tbodies[b]);             
		    }          
		}  
    }
</script>

