<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title>退货药品${titles}</title>
    <meta />
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
</head>


<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;收货管理&nbsp;>&nbsp;退货药品${titles}</font>
<div class="box_big">
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" id="quamap" value = "${quamap}" />
<div class="ceng_mar5" style="padding-bottom:5px;">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
	<tr>
	<th>单据号<span class="required">*</span>:</th>
	<td><input type="text" name="number" class="text1" value="${re.number}" size="40" readonly="readonly"/></td>
	<th width="150">销售单号<span class="required">*</span>：</th>
		<td style="width:400px;">
			<input type="text" class="easyui-combobox  text1" data-options="
		 	required:true,
      	 	valueField: 'id',
       		textField: 'text',
       		value:'${re.saleNo}'
			" name="saleNo" id="saleNo" disabled='true' size="40"/>
		</td>
		
	</tr>
	<tr>
		<th width="150">退货日期<span class="required">*</span>：</th>
		<td>
		<c:choose>
				<c:when test="${dateDisableFlag == 'true'}">
					<input type="text" class="easyui-datebox" name="deliveryDate" id="deliveryDate" value="${re.deliveryDate}"  data-options="required:true,disabled:true,value:'${re.deliveryDate}'" size="40"/>
				</c:when>
				<c:when test="${dateDisableFlag == 'false'}">
					<input type="text" class="easyui-datebox" name="deliveryDate" id="deliveryDate" value="${re.deliveryDate}" data-options="required:true,disabled:true,value:'${re.deliveryDate}'"  size="40"/>
				</c:when>
		</c:choose>
			
		</td>
		<th width="150">购货单位<span class="required">*</span>：</th>
		<td>
		<input type="text" class="easyui-combobox  text1" data-options="required:true,value: '${gongyingshang}',disabled:true" name="" id="commonnameboxs" size="40" />
		<input type="hidden" id="qualifiedSupplierIdValue" name="qualifiedSupplierIdValue" value="${re.qualifiedPurchaseUnitsId}"/>
		</td>
		
	</tr>
	<tr>
	<th width="150"><fmt:message key="re.receivingUnit"/><span class="required">*</span>：</th>
		<td>
			<input type="text"  name="receivingUnit"  value="${re.receivingUnit}"  id="receivingUnit" maxlength="18" data-options="required:true" class="easyui-validatebox text1" readonly="readonly" size="40"/>
		</td>
		<th width="150"><fmt:message key="re.deliveryAddress"/><span class="required">*</span>：</th>
		<td>
			<input type="text" name="receivingAddress" value="${re.receivingAddress}" id="receivingAddress"  maxlength="33" data-options="required:true" class="easyui-validatebox text1" readonly="readonly" size="40"/>
		</td>	
		
	</tr>
	<tr>
	<%--<th width="150"><fmt:message key="re.receivedDate"/><span class="required">*</span>：</th>
		<td>
			<c:choose>
				<c:when test="${dateDisableFlag == 'true'}">
					<input type="text" data-options="required:true" class="easyui-datebox" name="receivedDate"" id="receivedDate" value="${re.receivedDate}"  class="text1" size="40"/>
				</c:when>
				<c:when test="${dateDisableFlag == 'false'}">
					<input type="text" data-options="required:true,disabled:true" class="easyui-datebox" name="receivedDate"" id="receivedDate" value="${re.receivedDate}"  class="text1" size="40"/>
				</c:when>
			</c:choose>
		</td>--%>
	
	<th width="150"><fmt:message key="退货单号"/>：</th>
	<td>
		<input type="text" class="easyui-validatebox text1" name="returnNumber" id="returnNumber" value="${re.returnNumber}" readonly="readonly"  size="40"/>
	</td>
	<th>存储库区<span class="required">*</span>：</th>
		<td>
		<input type="text" class="text1" id="storageStore" size="40" value="" readonly="readonly"/>
		</td>
	</tr>	
<!-- 	<tr>
	<th valign="top"><fmt:message key="re.inspectionFindings"/>：</th>
	 <td colspan="3">
		<textarea type="" name="checkConclusion" id="checkConclusion" cols="94" rows="4" class="textarea" >${re.checkConclusion}</textarea>
	</td>
	</tr>
	<tr>
	<th valign="top"><fmt:message key="re.processingResults"/>：</th>
	 <td colspan="3">
		<textarea type="" name="result" id="result" cols="94" rows="4" class="textarea" >${re.result}</textarea>
	</td>
	</tr>-->
	<tr>
	<th valign="top">退货原因：</th>
	 <td colspan="3">
		<textarea type="" name="returnReason" id="returnReason" cols="94" rows="4" readonly="readonly" class="textarea" >${re.returnReason}</textarea>
	</td>
	</tr>
</table>
<table id="condition_table"  border="0" class="table"  cellpadding="0" cellspacing="1" width="100%" align="center">
	<thead class='pn-lthead'>
	 <tr>
	 	<th>通用名称</th><th>剂型</th><th>规格</th> <th>数量</th><th>生产批号</th><th>批准文号</th><th>生产企业</th><th> 有效期至</th><th>生产日期</th>
	 
	  </tr>
	 </thead>
</table>
<table>
	<tr align="center">
		<td colspan="3">
			<input type="hidden" class="btn_big" name="cancel" onclick="addyp();" value="<fmt:message key="新增药品"/>"/>
			<input type="button" class="btn_big" name="cancel" onclick="onCancel();" value="返回"/>
		</td>
	</tr>
</table>
</div>
<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" id="receItem" name="receItem" value="${receItem}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type="hidden" name="counts" id="counts" value=""/>
</div>
<script type="text/javascript">
function find(a){
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
	$.post("${ctx}/drugState/returnRecords/findxshd.html",{
		"saleNumber" : a,
		},function(data){
		if(data){
		var datas="["+data+"]";
		var jsons=eval("("+datas+")");
		//alert (jsons);
		for(var s=0; s<jsons.length; s++)  {
				i++;
		 		var j = jsons[s];
		        var pinming = "pinming"+s;
		    	var jixing = "jixing"+s;
		    	var guige = "guige"+s;
		    	var shuliang = "shuliang"+s;
		    	var oldshuliang = "oldshuliang"+s;
		    	var pizhun = "pizhun"+s;
		    	var youxiaoqi = "youxiaoqi"+s;
		    	var hegezheng = "hegezheng"+s;
				var zhuceshangbiao="zhuceshangbiao"+s;
				var shengchanpihao = "shengchanpihao"+s;
				var shengchanqiye = "shengchanqiye"+s;
				var xiaoshouriqi = "xiaoshouriqi"+s;
				var shengchanriqi = "shengchanriqi"+s;
		    	var tbody="tbody"+s;
		    	//var old = j.shuliang;
		    	//alert(j.xiaoshouriqi);
		    	//alert(j.youxiaoqizhi);
		    	$("#deliveryDate").datebox('setValue',j.xiaoshouriqi);
		    	$("#commonnameboxs").combobox("setValue",j.gouhuodanwei);
		    	$("#qualifiedSupplierIdValue").val(j.gouhuodanweiId);
		    	$("#storageStore").val(j.storageStore);
		        $("#condition_table").append(" <tbody id=\""+tbody+"\"  class='pn-ltbody'>  " +
		    	"<td> " +
				"<input id=\""+pinming+"\"  name=\""+pinming+"\" value='"+j.yaopinming+"' >" +
				"</td> " +
				"<td> " +
					" <input type=\"text\" style=\"width:50px;\" value=\""+j.jixing+"\" name=\""+jixing+"\" id=\""+jixing+"\" readonly='readonly'/> "+
				"</td> " +	
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.guige+"\" name=\""+guige+"\" id=\""+guige+"\" readonly='readonly'/> "+
				"</td> " +	
				"<td> " +
					" <input type=\"hidden\" style=\"width:40px;\" value=\""+j.shuliang+"\"  name=\""+oldshuliang+"\" id=\""+oldshuliang+"\" /> "+
					" <input type=\"text\" style=\"width:40px;\" value=\""+j.shuliang+"\"  name=\""+shuliang+"\" id=\""+shuliang+"\" readonly='readonly' onchange=\"compareOldAndNew('"+shuliang+"','"+oldshuliang+"')\"/> "+
					
				"</td> " +	
				"<td> " +
				" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanpihao+"\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" readonly='readonly'/> "+
				"</td> " +
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.pizhunwenhao+"\" name=\""+pizhun+"\" id=\""+pizhun+"\" readonly='readonly'/> "+
				"</td> " +	
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchangqiye+"\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\"readonly='readonly' /> "+
				"</td> " +	
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.youxiaoqizhi+"\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"\"  readonly='readonly'/> "+
				"</td> " +
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanriqi+"\" name=\""+shengchanriqi+"\" id=\""+shengchanriqi+"\" class='easyui-datebox text1'  /> "+
				"</td> " +
		    	"</tbody>"
		    	);
		    	$("#counts").val(i);
		    	//$.parser.parse($("#"+tbody));
		    	$.parser.parse($("#condition_table"));
		        $("#"+pinming).combobox({
	   			url:"${ctx}/drugState/inspectionRecords/findypboxqy.html",
				valueField:'id', 
				textField:'text',
				value:j.yaopinming,
				disabled:true,
				onSelect: function(rec){
	      			changqm(pinming,rec.id);
	      		}
				}); 
				//$("#"+pinming).combobox("setValue",j.yaopinming)
				//$.parser.parse($("#"+pinming));
				//alert(j.yaopinming);
				
				
		}
	}else{
	}
});
}
$("#commonnameboxs").combobox({
	filter: function(q, row){
	var opts = $(this).combobox('options');
	return row[opts.valueField].indexOf(q) >-1;
	}
});

	function savess(){
		if(checkSubmit()){
			$('#res').form('submit',{
			    success: function(data){  
				var json = jsonParse(data);
					if(json.success!=null && json.success!=""){
						alert(decodeURI( json.success));
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
    $.parser.parse($("#condition_table"));
    	$("#receivedDate").datebox("setValue",getCurrentDate());
    	
    	
    	$('#commonnameboxs').combobox({  
        //url:urlStr,  
        valueField: 'id',
      	textField: 'text', 
        onChange:function (newValue, oldValue){  
            if(newValue !=null && newValue!=""){  
                var urlStr ="${ctx}/drugState/inspectionRecords/qualityPurchaseJson.html?name=" + encodeURIComponent(newValue);  
                $("#commonnameboxs").combobox("reload",urlStr);  
            }  
        }  ,
        onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#qualifiedSupplierIdValue').val(str[1]);
      		}
    });  
    $('#saleNo').combobox({  
        //url:urlStr,  
        valueField: 'id',
      	textField: 'text', 
        onChange:function (newValue, oldValue){  
            if(newValue !=null && newValue!=""){  
                var urlStr ="${ctx}/drugState/returnRecords/findxsd.html?requestName=" + encodeURIComponent(newValue);  
                $("#saleNo").combobox("reload",urlStr);  
            }  
        }  ,
        onSelect: function(rec){
      			find(rec.id);
      		}
    });  
    
	  	var quamap=$("#quamap").val();
	   	 var aa = quamap.substring(1,quamap.length-1);
	   	 var f = aa.split(",");
	   	 var g ="";
	   	 for(var j=0;j<f.length;j++){
    	 	var e = f[j].split("=");
    	 	g+="<option value=\""+e[0]+"\">"+e[1]+"</option>"; 
    	 }
    	var a =$("#method").val();
    	if(a!="add"){
	    	var b=$("#receItem").val();
	    	var json=eval("("+b+")");
	    	//alert(json);
	    	i=json.length;
			for(var s=0; s<json.length; s++)  {
			 	var j = JSON.parse(json[s]);
			 	
			        var pinming = "pinming"+s;
			    	var jixing = "jixing"+s;
			    	var guige = "guige"+s;
			    	var shuliang = "shuliang"+s;
			    	var oldshuliang = "oldshuliang"+s;
			    	var pizhun = "pizhun"+i;
			    	var hegezheng = "hegezheng"+s;
 					var zhuceshangbiao="zhuceshangbiao"+s;
 					var shengchanpihao = "shengchanpihao"+s;
			    	var youxiaoqi = "youxiaoqi"+s;
			    	var shengchanqiye = "shengchanqiye"+s;
			    	var shengchanriqi = "shengchanriqi"+s;
			    	var tbody="tbody"+s;
			   // alert(j.gouhuodanwei);
			   // alert(j.yaopinming);
			    $("#commonnameboxs").combobox("setValue",j.gouhuodanwei);
		    	$("#qualifiedSupplierIdValue").val(j.gouhuodanweiId);
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
						" <input type=\"hidden\" style=\"width:40px;\" value=\""+j.shuliang+"\"  name=\""+oldshuliang+"\" id=\""+oldshuliang+"\" /> "+
						" <input type=\"text\" style=\"width:40px;\" value=\""+j.shuliang+"\"  name=\""+shuliang+"\" id=\""+shuliang+"\" readonly='readonly' onchange=\"compareOldAndNew('"+shuliang+"','"+oldshuliang+"')\" /> "+
						
					"</td> " +	
					"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanpihao+"\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" readonly='readonly'/> "+
					"</td> " +
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.pizhunwenhao+"\" name=\""+pizhun+"\" id=\""+pizhun+"\" readonly='readonly'/> "+
					"</td> " +	
					"<td> " +
					" <input type=\"text\" style=\"width:100px;\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\"  value='"+j.shengchangqiye+"' readonly='readonly'/> "+
					"</td> " +
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.youxiaoqizhi+"\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\"  class=\"easyui-datebox\" data-options='disabled:true'  /> "+
					"</td> " +	
						"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanriqi+"\" name=\""+shengchanriqi+"\" id=\""+shengchanriqi+"\" class='easyui-datebox text1' data-options='disabled:true'  /> "+
				"</td> " +
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
		      			changqm(pinming,rec.id);
		      		}
					});
			}  
		}
});
    function changqm(s,aaaaa){
		var a = s.substring(7,s.length);
	    var	quamap=aaaaa;
	    var pinming = "pinming"+a;
		var jixing = "jixing"+a;
    	var guige = "guige"+a;
    	var shuliang = "shuliang"+a;
    	var pizhun = "pizhun"+a;
    	 var hegezheng = "hegezheng"+a;
 		 var zhuceshangbiao="zhuceshangbiao"+a;
    	var youxiaoqi = "youxiaoqi"+a;
	    if(quamap!=""){
			$.post("${ctx}/drugState/inspectionRecords/quamap.html",{
			"quamap" : quamap,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					$("#jixing"+a).val(c[0]);
					$("#guige"+a).val(c[1]);
					$("#pizhun"+a).val(c[3]);
					$("#zhuceshangbiao"+a).val(c[4]);
					$("#hegezheng"+a).val(c[5]);
					$("#youxiaoqi"+a).val(c[6]);
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
    	 var hegezheng = "hegezheng"+i;
 		 var zhuceshangbiao="zhuceshangbiao"+i;
    	 var youxiaoqi = "youxiaoqi"+i;
    	  var shengchanpihao = "shengchanpihao"+i;
    	  var shengchanqiye = "shengchanqiye"+i;
    	 var tbody="tbody"+i;
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
			" <input type=\"text\" style=\"width:40px;\" name=\""+shuliang+"\" readonly='readonly' id=\""+shuliang+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" /> "+
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+pizhun+"\" id=\""+pizhun+"\" /> "+
		"</td> " +	
		"<td> " +
		" <input type=\"text\" style=\"width:100px;\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\" /> "+
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\"  class=\"easyui-datebox\"   /> "+
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
   function compareOldAndNew(newValue,oldValue){
   	var nw = $("#"+newValue).val();
   	var old = $("#"+oldValue).val();
   	var a =$("#method").val();
   	if (a != 'edit'){
   	 if(parseFloat(nw) <=0){
   	 	alert("修改数量须大于0！");
   	 	return ;
   	 }
   	 if(parseFloat(nw)>parseFloat(old)){
   	 	alert("修改数量不能大于原来数量！");
   	 	$("#"+newValue).focus();
   	 	return ;

   	 }}
   }
 	
</script>

