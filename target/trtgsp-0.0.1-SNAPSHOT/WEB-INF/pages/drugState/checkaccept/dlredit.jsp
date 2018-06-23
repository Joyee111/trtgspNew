<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title>验收修改</title>
    <meta />
</head>



<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;验收管理&nbsp;>&nbsp;验收修改</font>
<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span>1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span class="ok">2</span>
                <br />已保存
            </td>
            <td valign="top" align="center" width="20%">
            	<span>3</span>
                <br />审核
            </td>
            <td valign="top" align="center" width="20%">
            	<span>4</span>
                <br />待确认
            </td>
            <td valign="top" align="center" width="20%">
            	<span>5</span>
                <br />已确认
            </td>
            <td align="right" width="5"><img src="../../images/lch_r.gif" /></td>
          </tr>
        </table>
<div class="box_big">
<form:form commandName="mc" method="post" action="dlrupdate.html" id="res">
<form:hidden path="id"/>
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" id="receItem" value = "${receItem}" />
<input type="hidden" id="quamap" value = "${quamap}" />
<div class="ceng_mar5" style="padding-bottom:5px;">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
<tr>
		<th width="150">生产批号<span class="required">*</span>：</th>
		<td style="width:400px;">
			<input type="text" class="easyui-combobox  text1" data-options="
			 required:false,
      	 	valueField: 'id',
       		textField: 'text',
      		url:'${ctx}/drugState/inspectionRecords/findshd.html',
      		onSelect: function(rec){
      		var str = rec.id.split('_');
     			find(str[0],str[1]);
      		}
			" name="receiving_Number" id="caigoudan" size="40"/>&nbsp;&nbsp;
		</td>
		<th width="150">供货单位<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
       		disabled :true,
      		url:'${ctx}/firstEnterprise/qualitySupplyJson.html',
      		value:'${gongyingshang}',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#qualifiedSupplierIdValue').val(str[1]);
      			$('#receivingNumber').val(str[0]);
      		}
			" name="" id="commonnameboxs" size="40"/>
	<input type="hidden" id="qualifiedSupplierIdValue" name="qualifiedSupplierId" value="${mc.qualifiedSupplierId}"/>
		</td>	
	</tr>
	<tr>
		<th width="150">单据号<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="number"  id="number" value="${mc.number}" maxlength="20" class="easyui-validatebox text1" data-options="required:true" onchange="ajaxCompare(this)" size="40"/>
		</td>
		<th width="150">收货员：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="goodsClerk" id="goodsClerk" value="${mc.goodsClerk}" class="easyui-validatebox text1" size="40" readonly="readonly"/>
	</td>
	</tr>
	<tr>
		<th width="150">到货日期<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
				<c:choose>
					<c:when test="${dateDisableFlag == 'true'}">
						<input type="text" class="easyui-datebox text1" data-options="required:true,disabled:true" value="${mc.arrivalDate }" name="arrivalDate" id="arrivalDate" value="" size="40"/>
					</c:when>
					<c:when test="${dateDisableFlag == 'false'}">
						<input type="text" class="easyui-datebox text1" data-options="required:true,disabled:true" value="${mc.arrivalDate }" name="arrivalDate" id="arrivalDate" value="" size="40"/>
					</c:when>
				</c:choose>
			
			
		</td>
		
		<th width="150">验收日期<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
			<c:choose>
					<c:when test="${dateDisableFlag == 'true'}">
						<input type="text" class="easyui-datebox text1" data-options="required:true,disabled:true" name="checkAcceptDate" id="checkAcceptDate" value="${mc.checkAcceptDate}" size="40"/>
					</c:when>
					<c:when test="${dateDisableFlag == 'false'}">
						<input type="text" class="easyui-datebox text1" data-options="required:true,disabled:true" name="checkAcceptDate" id="checkAcceptDate" value="${mc.checkAcceptDate}" size="40"/>
					</c:when>
				</c:choose>
			
		</td>
	</tr>
	<tr>
		<th>验收状态<span class="required">*</span>:</th>
		<td>
		<select name="checkIsQualified" class="text" id="checkIsQualified">
			<option value="0">合格</option>
			<option value="1">不合格</option>
		</select>
		</td>
	</tr>
	<tr>
		<th>存储条件<span class="required">*</span></th>
		<td><input type="text" class="text1" size="40" id="storageConditions" value="" readonly="readonly"/></td>
		<th>存储库区<span class="required">*</span></th>
		<td><input type="text" class="text1" size="40" id="storageStore" value="" readonly="readonly"/></td>
	</tr>
		<tr>
     <th valign="top">处理结果：</th>
	 <td colspan="3">
		<textarea type="" name="result" id="result" cols="94" rows="4" class="textarea" >${mc.result}</textarea>
	</td>
	</tr>
	<tr>
	<th valign="top">检查结论：</th>
	 <td colspan="3">
		<textarea type="" name="checkConclusion" id="checkConclusion" cols="94" rows="4" class="textarea" >${mc.checkConclusion}</textarea>
	</td>
	</tr>
</table>
<table id="condition_table" class="table"  border="0" cellpadding="0" cellspacing="1" width="100%" >
	<thead class='pn-lthead'>
	 <tr>
	 	<th>通用名称</th><th>剂型</th><th>规格</th> <th>数量</th><th>合格数量</th><th>生产批号</th><th>批准文号</th><th>生产厂商</th><th>生产日期</th><th>有效期至</th><th>不合格数量</th><th>不合格项</th><th>处理措施</th><!--<th>操作</th>-->
	  </tr>
	 </thead>
</table>
<table>
	<tr align="center">
		<td colspan="4">
			<!-- <input type="button" class="btn_big" name="cancel" onclick="addyp();" value="<fmt:message key="新增药品"/>"/> -->
			<input type="button" class="btn_big" name="提交" onclick="submits(1)" value="<fmt:message key="提交"/>"/>
			<input type="button" class="btn_big" name="save" onclick="submits(0)" value="<fmt:message key="button.save"/>"/>
			<input type="button" class="btn_big" name="cancel" onclick="onCancel();" value="<fmt:message key="button.cancel"/>"/>
		</td>
	</tr>
</table>
</div>
<input type="hidden" name="receivingNumber" id ="receivingNumber" value="${mc.receivingNumber }"> 
<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" id="receItem" name="receItem" value="${receItem}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type="hidden" name="counts" id="counts" value=""/>
<input type="hidden" id="submitType" name="submitType" value="0" />
</form:form>
</div>
<script type="text/javascript">

function ajaxCompare(str){
	$.post("ajaxCompareNumber.html",{
		number : str.value
	},function(date){
		var json = jsonParse(date);
		var success = json.success;
		if(success==null || success==""){
		
		}else if(success=="1"){
			alert("单据号不能为空！");
			$(str).focus();
		}else if(success=="2"){
			alert("系统已经存在此单据号，请从新输入单据号！");
			$(str).focus();
		}
	})
}
setDefaultForCheckbox("checkIsQualified","${mc.checkIsQualified}")
$("#commonnameboxs").combobox({
	filter: function(q, row){
	var opts = $(this).combobox('options');
	return row[opts.valueField].indexOf(q) >-1;
	}
});
function find(resId,bNo){
var i=$("#counts").val();
for(var ii=0;ii<i;ii++){
        var table = document.getElementById("condition_table");
    	var tbodies= table.getElementsByTagName("tbody");
    	for(var f=0;f<tbodies.length;f++){
		  table.removeChild(tbodies[f]);             
		} 
}
$("#qualifiedSupplierId").val("");
	 $("#goodsClerk").val("");
	i=0;
	var d;
	//var a = document.getElementById("caigoudan").value;
	$.post("${ctx}/drugState/inspectionRecords/findsh.html",{
			"shouhuodan" : resId,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					d=c[1];
					
					$("#goodsClerk").val(c[2]);
					$("#qualifiedSupplierIdValue").val(c[0]);
					$('#commonnameboxs').combobox('setValue',c[3]);
					$("#arrivalDate").datebox("setValue",c[4]);
					$.post("${ctx}/drugState/inspectionRecords/findshmx.html",{
					"id" : c[1],
					},function(data){
					if(data){
					var datas="["+data+"]";
    				var jsons=eval("("+datas+")");
    				var quamap=$("#quamap").val();
				   	var aa = quamap.substring(1,quamap.length-1);
				   	var f = aa.split(",");
				   	var g ="";
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
					    	var hegeshuliang = "hegeshuliang"+s;
		 					var zhuceshangbiao="zhuceshangbiao"+s;
		 					var shengchanpihao = "shengchanpihao"+s;
		 					var shengchanqiye = "shengchanqiye"+s;
		 					var buhegeshu ="buhegeshu"+s;
					    	var buhegexiang="buhegexiang"+s;
					    	var chuzhicuoshi="chuzhicuoshi"+s;
					    	var shengchanriqi ="shengchanriqi"+s;
					    	var tbody="tbody"+s;
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
								" <input type=\"text\" style=\"width:40px;\" onchange=\"findcount("+s+","+1+")\" value=\""+j.shuliang+"\"  name=\""+shuliang+"\" id=\""+shuliang+"\" readonly='readonly'/> "+
							"</td> " +	
							"<td> " +
							" <input type=\"text\" style=\"width:40px;\" onchange=\"findcount("+s+","+2+")\" value=\""+j.hegeshuliang+"\"  name=\""+hegeshuliang+"\" id=\""+hegeshuliang+"\" /> "+
							"</td> " +	
							"<td> " +
							" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanpihao+"\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" /> "+
							"</td> " +
							"<td> " +
								" <input type=\"text\" style=\"width:100px;\" value=\""+j.pizhunwenhao+"\" name=\""+pizhun+"\" id=\""+pizhun+"\" readonly='readonly'/> "+
							"</td> " +	
							"<td> " +
								" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchangqiye+"\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\" readonly='readonly'/> "+
							"</td> " +	
							"<td> " +
								" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanriqi+"\" name=\""+shengchanriqi+"\" id=\""+shengchanriqi+"\" class=\"easyui-datebox\" data-options='disabled:true' /> "+
							"</td> " +	
							"<td> " +
							" <input type=\"text\" style=\"width:100px;\" value=\""+j.youxiaoqizhi+"\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\" data-options='disabled:true'/> "+
							"</td> " +	
							"<td> " +
							" <input type=\"text\" style=\"width:100px;\" onchange=\"findcount("+s+","+3+")\" value=\""+j.buhegeshu+"\" name=\""+buhegeshu+"\" id=\""+buhegeshu+"\" /> "+
							"</td> " +	
							"<td> " +
								" <input type=\"text\" style=\"width:100px;\" value=\""+j.buhegexiang+"\" name=\""+buhegexiang+"\" id=\""+buhegexiang+"\" readonly='readonly' /> "+
							"</td> " +	
							"<td> " +
								"<select id=\""+chuzhicuoshi+"\" name=\""+chuzhicuoshi+"\" cssClass=\"text2\" disabled='true' >" +
								"<option value=\"\">请选择</option>" +
								"<option value=\"1\">报废</option>" +
								"<option value=\"2\">退回</option>" +
								"</select>" +
							"</td> " +
						
							/*"<td> " +
							"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchu("+s+")\" value=\"删除\"/>"+
							"</td> " +*/
					    	"</tbody>"
					    	);
					    	$("#counts").val(i);
					    	var t = document.getElementById(chuzhicuoshi); 
					    	for(var l=0;l<t.length;l++){
				              if(j.chuzhicuoshi==trim(t.options[l].value.toString())){
				                  t.options[l].selected=true;
				              }  
				          	}
					    	$.parser.parse($("#condition_table"));
					        $("#"+pinming).combobox({
				   			url:"${ctx}/drugState/inspectionRecords/findypboxqy.html",
							valueField:'id', 
							textField:'text',
							disabled:true,
							value:j.yaopinming,
							disabled:true,
							onSelect: function(rec){
				      			changqm(pinming,rec.id);
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
var i=0;
    function onCancel()
    {
    	history.go(-1);
    }
    function submits(value){
	    $("#submitType").val(value);
	    if(checkSubmit()){
	    $('#res').form('submit',{
			    success: function(data){  
				var json = jsonParse(data);
					if(json.success=="1"){
						//alert("此编号已经存在,新生成的编号为："+json.number+",已经保存成功!");
					}else{
							alert("数据保存成功!");
					}
				location.href="dlrlist.html";
			    }  
			}); 
		}
    }
    $(function() {
	  	var quamap=$("#quamap").val();
	   	 var aa = quamap.substring(1,quamap.length-1);
	   	 var f = aa.split(",");
	   	 var g ="";
    	var a =$("#method");
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
			    	var hegeshuliang = "hegeshuliang"+s;
			    	var pizhun = "pizhun"+s;
			    	var hegezheng = "hegezheng"+s;
 					var zhuceshangbiao = "zhuceshangbiao"+s;
			    	var youxiaoqi = "youxiaoqi"+s;
			    	var tbody="tbody"+s;
			    	var shengchanpihao="shengchanpihao"+s;
			    	var shengchanqiye ="shengchanqiye"+s;
			    	var buhegeshu ="buhegeshu"+s;
			    	var buhegexiang="buhegexiang"+s;
			    	var chuzhicuoshi="chuzhicuoshi"+s;
			    	var shengchanriqi ="shengchanriqi"+s;
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
						" <input type=\"text\" style=\"width:40px;\"  value=\""+j.shuliang+"\"  name=\""+shuliang+"\" id=\""+shuliang+"\" readonly='readonly'/> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:40px;\" value=\""+j.hegeshuliang+"\"  onchange=\"countQuantity('"+shuliang+"','"+hegeshuliang+"','"+buhegeshu+"','"+hegeshuliang+"')\"  name=\""+hegeshuliang+"\" id=\""+hegeshuliang+"\" readonly='readonly' /> "+
					"</td> " +	
					"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanpihao+"\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" readonly='readonly'/> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.pizhunwenhao+"\" name=\""+pizhun+"\" id=\""+pizhun+"\" readonly='readonly'/> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchangqiye+"\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\" readonly='readonly' /> "+
					"</td> " +	
					"<td> " +
								" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanriqi+"\" name=\""+shengchanriqi+"\" id=\""+shengchanriqi+"\" class=\"easyui-datebox\" data-options='disabled:true' /> "+
							"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.youxiaoqizhi+"\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\" data-options='disabled:true' /> "+
					"</td> " +	
					"<td> " +
					" <input type=\"text\" style=\"width:100px;\" onchange=\"countQuantity('"+shuliang+"','"+hegeshuliang+"','"+buhegeshu+"','"+buhegeshu+"')\" value=\""+j.buhegeshu+"\" name=\""+buhegeshu+"\" id=\""+buhegeshu+"\" readonly='readonly' /> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.buhegexiang+"\" name=\""+buhegexiang+"\" id=\""+buhegexiang+"\" readonly='readonly' /> "+
					"</td> " +	
					"<td> " +
						"<select id=\""+chuzhicuoshi+"\" name=\""+chuzhicuoshi+"\" cssClass=\"text2\" disabled='true' >" +
						"<option value=\"\">请选择</option>" +
						"<option value=\"1\">报废</option>" +
						"<option value=\"2\">退回</option>" +
						"</select>" +
					"</td> " +
					/*"<td> " +
						"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchu("+s+")\" value=\"删除\"/>"+
					"</td> " +	*/
			    	"</tbody>"
			    	);
			    	$("#counts").val(i);
			    	$.parser.parse($("#condition_table"));
			    	var t = document.getElementById(chuzhicuoshi); 
					    	for(var l=0;l<t.length;l++){
				              if(j.chuzhicuoshi==trim(t.options[l].value.toString())){
				                  t.options[l].selected=true;
				              }  
				          	}
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
    function changqm(s,aaaa){
		var a = s.substring(7,s.length);
	    var	quamap=aaaa;
	    var pinming = "pinming"+a;
		var jixing = "jixing"+a;
    	var guige = "guige"+a;
    	var shuliang = "shuliang"+a;
    	var hegeshuliang ="hegeshuliang"+a;
    	var pizhun = "pizhun"+a;
    	var shangbiao = "shangbiao"+a;
    	var hegezheng = "hegezheng"+a;
 		var zhuceshangbiao = "zhuceshangbiao"+a;
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
    	 var hegeshuliang = "hegeshuliang"+i;
    	 var pizhun = "pizhun"+i;
    	 var hegezheng = "hegezheng"+i;
 		 var zhuceshangbiao = "zhuceshangbiao"+i;
    	 var youxiaoqi = "youxiaoqi"+i;
    	 var tbody="tbody"+i;
    	 var shengchanpihao = "shengchanpihao"+i;
    	 var shengchanqiye = "shengchanqiye"+i;
    	 var buhegeshu ="buhegeshu"+i;
    	 var buhegexiang="buhegexiang"+i;
    	 var chuzhicuoshi="chuzhicuoshi"+i;
    	 var shengchanriqi ="shengchanriqi"+i;
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
			" <input type=\"text\" style=\"width:40px;\" onchange=\"findcount("+i+","+1+")\" name=\""+shuliang+"\" id=\""+shuliang+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:40px;\" onchange=\"findcount("+i+","+2+")\" name=\""+hegeshuliang+"\" id=\""+hegeshuliang+"\" readonly='readonly' /> "+
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
			" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanriqi+"\" name=\""+shengchanriqi+"\" id=\""+shengchanriqi+"\" class=\"easyui-datebox\" data-options='disabled:true' /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\" /> "+
		"</td> " +	
		"<td> " +
					" <input type=\"text\" style=\"width:100px;\" onchange=\"findcount("+i+","+3+")\"  name=\""+buhegeshu+"\" id=\""+buhegeshu+"\" readonly='readonly' /> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" name=\""+buhegexiang+"\" id=\""+buhegexiang+"\" readonly='readonly' /> "+
					"</td> " +	
					"<td> " +
						"<select id=\""+chuzhicuoshi+"\" name=\""+chuzhicuoshi+"\" cssClass=\"text2\" disabled='true' >" +
						"<option value=\"\">请选择</option>" +
						"<option value=\"1\">报废</option>" +
						"<option value=\"2\">退回</option>" +
						"</select>" +
					"</td> " +
		/*"<td> " +
			"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchu("+i+")\" value=\"删除\"/>"+
		"</td> " +	*/
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
     function findcount(a,one){
	    var b=0;
	    var c =0;
	    var d =0;
	    if($("#shuliang"+a).val()!=0){
	    	b=$("#shuliang"+a).val();
	    }
	    if($("#buhegeshu"+a).val()!=0){
	    	c=$("#buhegeshu"+a).val();
	    }
	    if($("#hegeshuliang"+a).val()!=0){
	    	d=$("#hegeshuliang"+a).val();
	    }
	    if($("#buhegeshu"+a).val()!=null && $("#buhegeshu"+a).val()!="" && $("#hegeshuliang"+a).val()!=null && $("#hegeshuliang"+a).val()!=""&& $("#shuliang"+a).val()!=null && $("#shuliang"+a).val()!="")
    	if(parseInt(b)!=parseInt(c)+parseInt(d)){
    		alert("请输入正确的数量！");
    		if(one==1){
    		$("#shuliang"+a).val("");
    		}else if (one==2){
    		$("#hegeshuliang"+a).val("");
    		}else{
    		$("#buhegeshu"+a).val("");
    		}
    	}
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
 	 function countQuantity(totalQuantity,quQuantity,unQuantity,type){
    	if(type === quQuantity ){
    		var total = $("#"+totalQuantity).val();
    		var qu = $("#"+quQuantity).val();
    		var un = $("#"+unQuantity).val();
    		if(typeof(total) != 'undefined' && typeof(qu) != 'undefined' && typeof(un) != 'undefined'){
    			if(parseFloat(qu)<0){
    				alert("合格数量不能小于0！");
    				$("#"+quQuantity).val()
    			}
    			if(parseFloat(qu)>parseFloat(total)){
    				alert("合格数量不能大于总数量！");
    				$("#"+quQuantity).val()
    			}
    			var u = parseFloat(total)-parseFloat(qu);
    			$("#"+unQuantity).val(parseFloat(u).toFixed(2));
    		}
    	}else if(type === unQuantity ){
    		var total = $("#"+totalQuantity).val();
    		var qu = $("#"+quQuantity).val();
    		var un = $("#"+unQuantity).val();
    		if(typeof(total) != 'undefined' && typeof(qu) != 'undefined' && typeof(un) != 'undefined'){
    			if(parseFloat(un)<0){
    				alert("不合格数量不能小于0！");
    				$("#"+unQuantity).val()
    			}
    			if(parseFloat(un)>parseFloat(total)){
    				alert("不合格数量不能大于总数量！");
    				$("#"+unQuantity).val()
    			}
    			var q = parseFloat(total)-parseFloat(un);
    			$("#"+quQuantity).val(parseFloat(q).toFixed(2));
    	}
    }
}
</script>

