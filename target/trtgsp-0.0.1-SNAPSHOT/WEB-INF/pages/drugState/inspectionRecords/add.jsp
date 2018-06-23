<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title>收货${titles}</title>
    <meta />
	<script type="text/javascript">
	</script>
</head>


		<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;收货管理&nbsp;>&nbsp;收货${titles}</font>
<div class="box_big">
<form  method="post" action="saveOrUpdata.html" id="res">
<input type="hidden" name="id" id="id" value="${re.id}" />
<input type="hidden" name="method" id="method" value="${method}" />
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" id="quamap" value = "${quamap}" />
<div class="ceng_mar5" style="padding-bottom:5px;">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
	<tr>
		<th width="150">生产批号：</th>
		<td style="width:400px;">
			<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
      		url:'${ctx}/drugState/inspectionRecords/findcgd.html',
      		onSelect: function(rec){
      			$('#purchaseNumber').val(rec.id);
      			find(rec.id);
      		}
			" name="" id="caigoudan" size="40"/>&nbsp;&nbsp;
		</td>
		<th>存储条件<span class="required">*</span>：</th>
		<td>
		<input type="text" class="text1" id="storageConditions" size="40" value="" readonly="readonly"/>
		</td>
		<!-- <th width="150">收货单号<span class="required">*</span>：</th>
		<td class="left" style="width:200px;">-->
			<input type="hidden" class="easyui-validatebox text1" readonly="readonly" maxlength="20" data-options="required:true" name="number" value="${re.number}" id="number" size="40"/>
	<!-- </td> -->
	</tr>
	<tr>
	<th width="150"><fmt:message key="re.receivedDate"/><span class="required">*</span>：</th>
	<td>
		<c:choose>
			<c:when test="${dateDisableFlag == 'true'}">
				<input type="text" data-options="required:true,validType:'checkDate',disabled:true" class="easyui-datebox" name="receivedDate" id="receivedDate" value="${re.receivedDate}" size="40"/>
			</c:when>
			<c:when test="${dateDisableFlag == 'false'}">
				<input type="text" data-options="required:true,validType:'checkDate',disabled:true" class="easyui-datebox"  name="receivedDate" id="receivedDate" value="${re.receivedDate}" size="40"/>
			</c:when>
		</c:choose>
	</td>
	<th width="150"><fmt:message key="re.supplyUnit"/><span class="required">*</span>：</th>
	<td>
	<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
      		url:'${ctx}/firstEnterprise/qualitySupplyJson.html',
      		value:'${gongyingshang}',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#qualifiedSupplierIdValue').val(str[1]);
      		}
			" name="" id="commonnameboxs" size="40"/>
	<input type="hidden" id="qualifiedSupplierIdValue" name="qualifiedSupplierIdValue" value="${re.qualifiedSupplierId.id}"/>
	</td>
	</tr>
	<tr>
	<th width="150"><fmt:message key="re.receivingUnit"/><span class="required">*</span>：</th>
	<td>
	
	<input type="text" name="receivingUnit" id="receivingUnit"  value="${re.receivingUnit}" class="easyui-validatebox text1" data-options="required:true" readonly="readonly" size="40"/>
	</td>
	<th width="150"><fmt:message key="re.deliveryAddress"/><span class="required">*</span>：</th>
	<td>
		<input type="text" name="receivingAddress" id="receivingAddress" value="${re.receivingAddress}" class="easyui-validatebox text1" maxlength="33" data-options="required:true" readonly="readonly" size="40"/>
	</td>
	</tr>
	<tr>
		<th width="150"><fmt:message key="检查结论"/>：</th>
		<td>
		<select name="checkConclusion" onchange="changesel(this)" id="checkConclusion" class="easyui-validatebox text1" data-options="required:true" >
		<option value="" >请选择</option>
		<option value="1" >合格</option>
		<option value="2" >不合格</option>
		</select>
		<input type="hidden" id="checkConclusionValue" name="checkConclusionValue" value="${re.checkConclusion}"/>
		</td>
	    <th>存储库区<span class="required">*</span>：</th>
		<td>
		<input type="text" class="text1" id="storageStore" size="40" value="" readonly="readonly"/>
		</td>

	</tr>
	
	<tr>
	<th valign="top">处理结果：</th>
	 <td colspan="3">
		<textarea name="result" id="result"  cols="94" maxlength="33" rows="4"  class="textarea" >${re.result}</textarea>
	</td>
	</tr>
</table>
<table id="condition_table" class="table"   border="0" cellpadding="0" cellspacing="1" width="100%" align="center">
	<thead class='pn-lthead'>
	 <tr>
	 	<th>通用名称</th><th>剂型</th><th>规格</th> <th>数量</th><th>生产批号</th><th>批准文号</th><th>生产企业</th><th> 生产日期</th><th> 有效期至</th><!-- <th> 操作</th> -->
	 
	  </tr>
	 </thead>
</table>
<table>
	<tr align="center">
		<td colspan="3">
			<input type="hidden" name="purchaseNumber" id="purchaseNumber" value="${re.purchaseNumber }" />
			<input type="hidden" class="btn_big" name="cancel" onclick="addyp();" value="<fmt:message key="新增药品"/>"/>
			<input type="button" class="btn_big" name="save" onclick="savess();" value="<fmt:message key="button.save"/>"/>
			<input type="button" class="btn_big" name="cancel" onclick="onCancel();" value="<fmt:message key="button.cancel"/>"/>
		</td>
	</tr>
</table>
</div>
<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" id="receItem" name="receItem" value="${receItem}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type="hidden" name="counts" id="counts" value=""/>
</form>
</div>
<script type="text/javascript">
function changesel(obj){
	if(obj.value==1){
		document.getElementById("result").value="";
		document.getElementById("result").disabled="disabled";
	}else{
		document.getElementById("result").value="";
		document.getElementById("result").disabled="";
	}
}
$("#commonnameboxs").combobox({
	filter: function(q, row){
	var opts = $(this).combobox('options');
	return row[opts.valueField].indexOf(q) >-1;
	}
});
function find(resId){
    for(var ii=0;ii<i;ii++){
        var table = document.getElementById("condition_table");
    	var tbodies= table.getElementsByTagName("tbody");
    	for(var f=0;f<tbodies.length;f++){
		  table.removeChild(tbodies[f]);             
		} 
    }
    $("#qualifiedSupplierId").val("");
	    i=0;
	    $("#counts").val(0);
	    var d;
	    //var a = document.getElementById("caigoudan").value;
	    $.post("${ctx}/drugState/inspectionRecords/find.html",{
			"caigoudan" : resId,
			},function(data){
				if(data){
					var b = data.toString();
					//alert(b);
					var c = b.split(",");
					d=c[1];
					$("#qualifiedSupplierIdValue").val(c[0]);
					 $.post("${ctx}/drugState/inspectionRecords/findmx.html",{
					"id" : c[4],
					},function(data){
					if(data){
					var datas="["+data+"]";
    				var jsons=eval("("+datas+")");
    				var quamap=$("#quamap").val();
				   	var aa = quamap.substring(1,quamap.length-1);
				   	var f = aa.split(",");
				   	var g ="";
				   	for(var j=0;j<f.length;j++){
			    		var e = f[j].split("=");
			    		g+="<option value=\""+e[0]+"\">"+e[1]+"</option>"; 
			    	}
					for(var s=0; s<jsons.length; s++)  {
							i++;
					 		var j = jsons[s];
					        var pinming = "pinming"+s;
					    	var jixing = "jixing"+s;
					    	var guige = "guige"+s;
					    	var shuliang = "shuliang"+s;
					    	var pizhun = "pizhun"+s;
					    	var youxiaoqi = "youxiaoqi"+s;
					    	var hegezheng = "hegezheng"+s;
		 					var zhuceshangbiao="zhuceshangbiao"+s;
		 					var shengchanpihao = "shengchanpihao"+s;
		 					var shengchanqiye = "shengchanqiye"+s;
					    	var tbody="tbody"+s;
					    	var shengchanriqi = "shengchanriqi"+s;
					    	$("#storageConditions").val(j.storageConditions);
					    	$("#storageStore").val(j.storageStore);
					        $("#condition_table").append(" <tbody id=\""+tbody+"\"  class='pn-ltbody'>  " +
					    	"<td> " +
							"<input id=\""+pinming+"\"  name=\""+pinming+"\" >" +
							"</td> " +
							"<td> " +
								" <input type=\"text\" style=\"width:50px;\" value=\""+j.jixing+"\" name=\""+jixing+"\" id=\""+jixing+"\" readonly='readonly' /> "+
							"</td> " +	
							"<td> " +
								" <input type=\"text\" style=\"width:100px;\" value=\""+j.guige+"\" name=\""+guige+"\" id=\""+guige+"\"readonly='readonly' /> "+
							"</td> " +	
							"<td> " +
								" <input type=\"text\" style=\"width:40px;\" value=\""+j.shuliang+"\"  name=\""+shuliang+"\" id=\""+shuliang+"\" readonly='readonly'/> "+
							"</td> " +	
							"<td> " +
							" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanpihao+"\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" readonly='readonly'/> "+
							"</td> " +
							"<td> " +
								" <input type=\"text\" style=\"width:100px;\" value=\""+j.pizhunwenhao+"\" name=\""+pizhun+"\" id=\""+pizhun+"\" readonly='readonly'/> "+
							"</td> " +	
							"<td> " +
								" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchangqiye+"\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\" readonly='readonly'/> "+
							"</td> " +	

							"<td> " +
							" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanriqi+"\" name=\""+shengchanriqi+"\" id=\""+shengchanriqi+"\" class=\"easyui-datebox\"data-options='disabled:true'  /> "+
							"</td> " +
							
							"<td> " +
								" <input type=\"text\" style=\"width:100px;\" value=\""+j.youxiaoqizhi+"\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\" data-options='disabled:true'  /> "+
							"</td> " +
							/*+	
							"<td> " +
							"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchu("+s+")\" value=\"删除\"/>"+
							"</td> " +	*/
					    	"</tbody>"
					    	);
					    	$("#counts").val(i);
					    	$.parser.parse($("#condition_table"));
					        $("#"+pinming).combobox({
				   			url:"${ctx}/drugState/inspectionRecords/findypboxqy.html",
							valueField:'id', 
							textField:'text',
							disabled:true,
							value:j.yaopinming,
							onSelect: function(rec){
				      			changqm(pinming,this.rec.id);
				      		}
							}); 
					}
				}else{
				}
			});
		}else{
		}
	});
	$("#counts").val(i);
}
	function savess(){
		if(checkSubmit()){
			$('#res').form('submit',{
			    success: function(data){  
				var json = jsonParse(data);
					if(json.success=="1"){
						alert("此编号已经存在,新生成的编号为："+json.number+",已经保存成功!");
					}else{
							alert("数据保存成功!");
					}
				location.href="list.html";
			    }  
			});  
		}
	}
var i=0;
    function onCancel()
    {
    	history.go(-1);
    }
    $(function() {
	  	var quamap=$("#quamap").val();
	   	 var aa = quamap.substring(1,quamap.length-1);
	   	 var f = aa.split(",");
	   	 var g ="";
	   	 for(var j=0;j<f.length;j++){
    	 	var e = f[j].split("=");
    	 	g+="<option value=\""+e[0]+"\">"+e[1]+"</option>"; 
    	 }
    	var a =$("#method").val();
    		var ttttt = document.getElementById("checkConclusion"); 
			var ddd = document.getElementById("checkConclusionValue").value;
	   		for(var lss=0;lss<ttttt.length;lss++){
	        if(ddd==trim(ttttt.options[lss].value.toString())){
            ttttt.options[lss].selected=true;
	        }  
	   	 }
    	if(a!="add"){
	    	var b=$("#receItem").val();
	    	var json=eval("("+b+")");
	    	i=json.length;
			for(var s=0; s<json.length; s++)  {
			 	var j = JSON.parse(json[s]);
			        var pinming = "pinming"+s;
			    	var jixing = "jixing"+s;
			    	var guige = "guige"+s;
			    	var shuliang = "shuliang"+s;
			    	var pizhun = "pizhun"+s;
			    	var youxiaoqi = "youxiaoqi"+s;
			    	var hegezheng = "hegezheng"+s;
 					var zhuceshangbiao="zhuceshangbiao"+s;
 					var shengchanpihao = "shengchanpihao"+s;
 					var shengchanqiye = "shengchanqiye"+s;
 					var shengchanriqi ="shengchanriqi"+s;
			    	var tbody="tbody"+s;
			    	$("#storageConditions").val(j.storageConditions);
			    	$("#storageStore").val(j.storageStore);
			        $("#condition_table").append(" <tbody id=\""+tbody+"\"  class='pn-ltbody'>  " +
			    	"<td> " +
					"<input id=\""+pinming+"\"  name=\""+pinming+"\" >" +
					"</td> " +
					"<td> " +
						" <input type=\"text\" style=\"width:50px;\" value=\""+j.jixing+"\" name=\""+jixing+"\" id=\""+jixing+"\" readonly='readonly'/> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.guige+"\" name=\""+guige+"\" id=\""+guige+"\" readonly='readonly'/> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:40px;\" value=\""+j.shuliang+"\"  name=\""+shuliang+"\" id=\""+shuliang+"\" readonly='readonly'/> "+
					"</td> " +	
					"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanpihao+"\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" readonly='readonly'/> "+
					"</td> " +
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.pizhunwenhao+"\" name=\""+pizhun+"\" id=\""+pizhun+"\" readonly='readonly'/> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchangqiye+"\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\" readonly='readonly'/> "+
					"</td> " +	

					"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanriqi+"\" name=\""+shengchanriqi+"\" id=\""+shengchanriqi+"\" class=\"easyui-datebox\" data-options='disabled:true'/> "+
					"</td> " +	
					
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.youxiaoqizhi+"\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\"  data-options='disabled:true'/> "+
					"</td> " +	
					"<td> " +
					/*"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchu("+s+")\" value=\"删除\"/>"+
					"</td> " +	*/
			    	"</tbody>"
			    	);
			    	$.parser.parse($("#condition_table"));
			    	$("#"+pinming).combobox({
		   			url:"${ctx}/drugState/inspectionRecords/findypboxqy.html",
					valueField:'id', 
					textField:'text',
					disabled:true,
					value:j.yaopinming,
					onSelect: function(rec){
		      			changqm(pinming,rec.id);
		      		}
		});
			    	$("#counts").val(i);
			    	
			} 
			//收货修改时所有值都不能改
    		var pihao = $("#caigoudan");
			var batch = $("#shengchanpihao0").val();
			pihao.combobox('disable');
			pihao.combobox('textbox').val(batch);
			
			$("#result").attr("readonly","readonly");
			$("#commonnameboxs").combobox('disable'); 
			$("#checkConclusion").attr("disabled","disabled");
			
		}
		
});
    function changqm(s,bbbb){
		var a = s.substring(7,s.length);
	    var	quamap=bbbb;
	    var pinming = "pinming"+a;
		var jixing = "jixing"+a;
    	var guige = "guige"+a;
    	var shuliang = "shuliang"+a;
    	var pizhun = "pizhun"+a;
    	var youxiaoqi = "youxiaoqi"+a;
	    var hegezheng = "hegezheng"+a;
 		var zhuceshangbiao="zhuceshangbiao"+a;
 		var shengchanqiye = "shengchanqiye" +a;
	    if(quamap!=""){
			$.post("${ctx}/drugState/inspectionRecords/quamap.html",{
			"quamap" : quamap,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					$("#jixing"+a).val(c[0]);
					$("#guige"+a).val(c[1]);
					$("#shengchanqiye"+a).val(c[2]);
					$("#pizhun"+a).val(c[3]);
					$("#zhuceshangbiao"+a).val(c[4]);
					$("#hegezheng"+a).val(c[5]);
					$("#youxiaoqi"+a).val(c[6]);
					$("#shengchanqiye"+a).val(c[7]);
				}else{
					return;
				}
			});
	    }else{
   			$("#jixing"+a).val("");
			$("#guige"+a).val("");
			$("#pizhun"+a).val("");
			$("#zhuceshangbiao"+a).val("");
			$("#hegezheng"+a).val("");
			$("#youxiaoqi"+a).val("");
			$("#shuliang"+a).val("");
			$("#shengchanpihao"+a).val("");
			$("#shengchanqiye"+a).val("");
	    }
    
    }
    function addyp(){
    	 var quamap=$("#quamap").val();
    	 var c = quamap.substring(1,quamap.length-1);
    	 var b = c.split(",");
    	 var d ="";
    	 var pinming = "pinming"+i;
    	 var jixing = "jixing"+i;
    	 var guige = "guige"+i;
    	 var shuliang = "shuliang"+i;
    	 var pizhun = "pizhun"+i;
    	 var youxiaoqi = "youxiaoqi"+i;
    	 var tbody="tbody"+i;
    	 var hegezheng = "hegezheng"+i;
    	 var zhuceshangbiao="zhuceshangbiao"+i;
    	 var shengchanpihao = "shengchanpihao"+i;
    	 var shengchanqiye = "shengchanqiye"+i;
    	 var shengchanriqi = "shengchanriqi"+i;
    	 for(var j=0;j<b.length;j++){
    	 	var e = b[j].split("=");
    	 	d+="<option value=\""+e[0]+"\">"+e[1]+"</option>"; 
    	 }
    	$("#condition_table").append(" <tbody id=\""+tbody+"\" class='pn-ltbody'>  " +
    	"<td> " +
		"<input id=\""+pinming+"\"  name=\""+pinming+"\" >" +
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:50px;\" name=\""+jixing+"\" id=\""+jixing+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+guige+"\" id=\""+guige+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:40px;\" name=\""+shuliang+"\" id=\""+shuliang+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" /> "+
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+pizhun+"\" id=\""+pizhun+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+hegezheng+"\" id=\""+hegezheng+"\" /> "+
		"</td> " +

		"<td> " +
		" <input type=\"text\" style=\"width:100px;\" name=\""+shengchanriqi+"\" id=\""+shengchanriqi+"\" class=\"easyui-datebox\"  /> "+
		"</td> " +	
		
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\"  /> "+
		"</td> " +	
		"<td> " +
			"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchu("+i+")\" value=\"删除\"/>"+
		"</td> " +	
    	"</tbody>"
    	);
    	i++;
    	$("#counts").val(i);
    	$.parser.parse($("#condition_table"));
   		$("#"+pinming).combobox({
   			url:"${ctx}/drugState/inspectionRecords/findypboxqy.html",
			valueField:'id', 
			textField:'text',
			onSelect: function(rec){
      			changqm(pinming,rec.id);
      		}
		});
    }
    function shanchu(a){
    	var b = "tbody"+a;
		var table = document.getElementById("condition_table");
    	var tbodies= table.getElementsByTagName("tbody");
    	for(var f=0;f<tbodies.length;f++){
		if(tbodies[f].id==b){
		   table.removeChild(tbodies[b]);             
		    }          
		}  
    }
    function trim(str){	
 		return str.replace(/(^\s*)|(\s*$)/g, ""); 
 	}
</script>

