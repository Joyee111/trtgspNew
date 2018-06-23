<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title>退货验收修改</title>
    <meta />
</head>
<script type="text/javascript">
</script>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;验收管理&nbsp;>&nbsp;退货验收修改</font>
<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../../images/lch_l.gif" /></td>
             <td valign="top" align="center" width="20%">
            	<span >1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span >2</span>
                <br />已保存
            </td>
            <td valign="top" align="center" width="20%">
            	<span class="ok">3</span>
                <br />已验收1
            </td>
            <td valign="top" align="center" width="20%">
            	<span>4</span>
                <br />已验收
            </td>
            <td valign="top" align="center" width="20%">
            	<span>5</span>
                <br />已复检
            </td>
            <td align="right" width="5"><img src="../../images/lch_r.gif" /></td>
          </tr>
        </table>


<div class="box_big">
<form:form commandName="mc" method="post" action="dysupdate.html" id="res">
<form:hidden path="id"/>
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" id="receItem" value = "${receItem}" />
<input type="hidden" id="quamap" value = "${quamap}" />
<div class="ceng_mar5" style="padding-bottom:5px;">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
	<tr>
		<th width="150">退货单号<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" class="easyui-combobox  text1" data-options="
		 	required:true,
      	 	valueField: 'id',
       		textField: 'text',
       		value:'${mc.returnNo}',
      		url:'${ctx}/drugState/checkreturn/findthd.html',
      		onSelect: function(rec){
      			find(rec.id);
      			$('#returnNoValue').val(rec.text);
      		}
			" name="" id="returnNo" size="40"/>
			<input type="hidden" name="returnNo" value="${mc.returnNo}" id="returnNoValue"/>
	</td>
		<th width="150">退货单位<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-validatebox text1" readonly="readonly" id="qualifiedPurchaseUnitsIdValue" size="40" value="${mc.qualifiedPurchaseUnits.customerName}"/>	
			<input type="hidden" id="qualifiedPurchaseUnitsIdValue" name="qualifiedPurchaseUnitsId" value="${mc.qualifiedPurchaseUnitsId}" />
		</td>
	</tr>
	<tr>
	<th width="150">报告单号<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="reportNo" readonly="readonly" id="reportNo" class="easyui-validatebox text1" data-options="required:true" value="${mc.reportNo}" size="40"/>
	</td>
	<c:choose>
		<c:when test="${dateDisableFlag eq 'true'}">
			<th width="150">退货日期<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-datebox text1" data-options="required:true" name="arrivalDate" id="arrivalDate" value="${mc.arrivalDate}" size="40"/>
		</td>
		</c:when>
		<c:when test="${dateDisableFlag eq 'false'}">
			<th width="150">退货日期<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-datebox text1" data-options="required:true,disabled:true" name="arrivalDate" id="arrivalDate" value="${mc.arrivalDate}" size="40"/>
		</td>
		</c:when>
	</c:choose>
	
	</tr>
	<tr>
	
		<th width="150">验收日期2<span class="required">*</span>：</th>
		
		<td class="left" style="width:350px;">
		<input type="text" class="easyui-datebox text1" data-options="required:true,value:'${mc.checkAcceptDate2}', disabled:true"  name="checkAcceptDate2" id="checkAcceptDate2" size="40"/>
		</td>
		<th width="150">收货员：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="goodsClerk" id="goodsClerk" value="${mc.goodsClerk }" class="easyui-validatebox text1" readonly='readonly' size="40"/>
		</td>
	</tr>
	<tr>
	   <th width="150">存储库区：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="storageStore" id="storageStore"  class="easyui-validatebox text1" readonly='readonly' size="40"/>
		</td>
	</tr>
	<tr>
	<th valign="top">验收结果2：</th>
	 <td colspan="3">
		<textarea type="" name="result2" id="result2" cols="94" rows="4" class="textarea" >${mc.result2}</textarea>
	</td>
	</tr>
	<tr>
	<th valign="top">退货原因：</th>
	 <td colspan="3">
		<textarea type="" name="checkConclusion" id="checkConclusion" cols="94" rows="4" class="textarea" readonly="readonly">${mc.checkConclusion}</textarea>
	</td>
	</tr>
</table>
<table id="condition_table" class="table"  border="0" cellpadding="0" cellspacing="1" width="100%" align="center">
	<thead class='pn-lthead'>
	 <tr>
	 	<th>通用名称</th><th>剂型</th><th>规格</th> <th>数量</th><!-- <th>合格数量</th> --><th>生产批号</th><th>批准文号</th><th>生产企业</th><th>有效期至</th><th>生产日期</th><!-- <th>操作</th> -->
	 
	  </tr>
	 </thead>
</table>
<table>
	<tr align="center">
		<td colspan="4">
			<c:choose>
				<c:when test="${mc.rejectFlag != null && mc.rejectFlag eq '1'}">
					<input type="button" class="btn_big" name="提交" onclick="$('#dialog').dialog('open')" value="<fmt:message key="提交"/>"/>
				</c:when>
				<c:otherwise>
					<input type="button" class="btn_big" name="提交" onclick="submits(1)" value="<fmt:message key="提交"/>"/>
				</c:otherwise>
			</c:choose>
			<input type="button" class="btn_big" name="save" onclick="submits(0)" value="<fmt:message key="button.save"/>"/>
			
			<shiro:hasPermission name="ReturnCheckAccept_apply_rollback">
		 	<input type="button" class="btn_big" name="申请回退" onclick="$('#dialog_roll_back').dialog('open')" value="<fmt:message key="申请回退"/>"/>
	 		</shiro:hasPermission>
			
			
			<input type="button" class="btn_big" name="cancel" onclick="onCancel();" value="<fmt:message key="button.cancel"/>"/>
		</td>
	</tr>
</table>
</div>
<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" id="receItem" name="receItem" value="${receItem}"/>
<input type="hidden" id="rejectFlag" name="rejectFlag" value="${mc.rejectFlag}"/>
<input type="hidden" name="modify_reason" id = "modify_reason" />
<input type="hidden" name="roll_back_reason" id ="roll_back_reason" />
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type="hidden" name="counts" id="counts" value=""/>
<input type="hidden" id="submitType" name="submitType" value="0" />
</form:form>
</div>
    <div id="dialog" title="修改原因" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:200">
    	<table>
    	<tr>
            <th valign="top">修改原因：</th>
            <td colspan="3"><textarea name="rejectcause" id="rejectcause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
           	<input type="button" class="btn_big" onclick="submits(1)" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
    </div> 
    <div id="dialog_roll_back" title="回退原因" class="easyui-dialog" style="width:800px;height:200px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:200">
    	<table>
    	<tr>
            <th valign="top">回退原因：</th>
            <td colspan="3"><textarea name="rejectcause" id="roll_back_cause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
           	<input type="button" class="btn_big" onclick="rollBack(2)" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog_roll_back').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
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
	i=0;
	$("#counts").val(0);
	$.post("${ctx}/drugState/checkreturn/findthdItem.html",{
		"id" : a,
		},function(data){
		if(data){
		var datas="["+data+"]";
		var jsons=eval("("+datas+")");
		for(var s=0; s<jsons.length; s++)  {
				i++;
		 		var j = jsons[s];
		        var pinming = "pinming"+s;
		    	var jixing = "jixing"+s;
		    	var guige = "guige"+s;
		    	var shuliang = "shuliang"+s;
		    	var pizhun = "pizhun"+s;
		    	var youxiaoqi = "youxiaoqi"+s;
		    	var shengchanriqi = "shengchanriqi"+s;
		    	var hegezheng = "hegezheng"+s;
				var zhuceshangbiao="zhuceshangbiao"+s;
				var shengchanpihao = "shengchanpihao"+s;
				var shengchanqiye = "shengchanqiye"+s;
				var xiaoshouriqi = "xiaoshouriqi"+s;
				var hegeshuliang="hegeshuliang"+s;
		    	var tbody="tbody"+s;
		    	$("#saleTime").datebox('setValue',j.xiaoshouriqi);
		    	$("#qualifiedPurchaseUnitsIdValue").val(j.gouhuodanwei);
		    	$("#qualifiedPurchaseUnitsId").val(j.gouhuodanweiId);
		    	$("#goodsClerk").val(j.receivePerson);
		    	$("#storageStore").val(j.storageStore);
		    	$("#arrivalDate").datebox("setValue",j.tuihuoriq);
		        $("#condition_table").append(" <tbody id=\""+tbody+"\"  class='pn-ltbody'>  " +
		    	"<td> " +
				"<input id=\""+pinming+"\"  name=\""+pinming+"\" >" +
				"</td> " +
				"<td> " +
					" <input type=\"text\" style=\"width:50px;\" value=\""+j.jixing+"\" name=\""+jixing+"\" id=\""+jixing+"\" readonly='readonly' /> "+
				"</td> " +	
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.guige+"\" name=\""+guige+"\" id=\""+guige+"\" readonly='readonly'/> "+
				"</td> " +	
				"<td> " +
					" <input type=\"text\" style=\"width:40px;\" value=\""+j.shuliang+"\"  name=\""+shuliang+"\" id=\""+shuliang+"\" readonly='readonly'/> "+
				"</td> " +	
				"<td> " +
				" <input type=\"text\" style=\"width:40px;\" name=\""+hegeshuliang+"\" id=\""+hegeshuliang+"\" readonly='readonly'/> "+
				"</td> " +	
				"<td> " +
				" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanpihao+"\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" readonly='readonly'/> "+
				"</td> " +
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.pizhunwenhao+"\" name=\""+pizhun+"\" id=\""+pizhun+"\" /> "+
				"</td> " +	
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchangqiye+"\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\" readonly='readonly'/> "+
				"</td> " +	
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.youxiaoqizhi+"\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\"  readonly='readonly'/> "+
				"</td> " +	
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value='' name=\""+shengchanriqi+"\" id=\""+shengchanriqi+"\" class=\"easyui-datebox\" data-options='required:true' /> "+
				"</td> " +
				/*"<td> " +
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
	      			changqm(pinming,rec.id);
	      		}
				}); 
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
var i=0;
    function onCancel()
    {
    	history.go(-1);
    }
     function submits(value){
	   $("#submitType").val(value);
	    var  dialog = $("#dialog").dialog();
		var value =  dialog.get(0).getElementsByTagName("textarea")[0].value;
		$("#modify_reason").val(value);
		if(checkSubmit()){
	    $('#res').form('submit',{
			    success: function(data){  
				var json = jsonParse(data);
					if(json.success!=null && json.success!=""){
						alert(decodeURI( json.success));
					}
				location.href="dyslist.html";
			    }  
			});  
			}
   }
   
   	//申请回退
  	function rollBack(value){
	    $("#submitType").val(value);
	    var  dialog = $("#dialog_roll_back").dialog();
		var value =  dialog.get(0).getElementsByTagName("textarea")[0].value;
		if(value == undefined || trim(value) == ""){
			alert("请输入原因");
			return;
		}
		$("#roll_back_reason").val(value);
		if(checkSubmit()){
	    $('#res').form('submit',{
			    success: function(data){  
				var json = jsonParse(data);
					if(json.success!=null && json.success!=""){
						alert(decodeURI( json.success));
					}
				location.href="dyslist.html";
			    }  
			});  
			}
    }
    $(function() {
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
      			$('#qualifiedPurchaseUnitsIdValue').val(str[1]);
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
			    	//var hegeshuliang = "hegeshuliang"+s;
			    	var pizhun = "pizhun"+i;
			    	var hegezheng = "hegezheng"+s;
 					var zhuceshangbiao = "zhuceshangbiao"+s;
			    	var youxiaoqi = "youxiaoqi"+s;
			    	var tbody="tbody"+s;
			    	var shengchanpihao = "shengchanpihao"+s;
 					var shengchanqiye = "shengchanqiye"+s;
 					var shengchanriqi = "shengchanriqi"+s;
 					
 					$("#storageStore").val(j.storageStore);
 					
 					var itemId = "itemId"+s;
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
				/*	"<td> " +
						" <input type=\"text\" style=\"width:40px;\" value=\""+j.hegeshuliang+"\"  name=\""+hegeshuliang+"\" id=\""+hegeshuliang+"\" /> "+
					"</td> " +	*/
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
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.youxiaoqizhi+"\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\" data-options='disabled:true' /> "+
						"<input type='hidden' name='"+itemId+"' value='"+j.purchaseOrderId+"'/>"+
					"</td> " +	
					"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanriqi+"\"  name=\""+shengchanriqi+"\" id=\""+shengchanriqi+"\" class=\"easyui-datebox\" data-options='disabled:true' /> "+
					"</td> " +
					/*"<td> " +
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
		      			changqm(pinming,rec.id);
		      		}
					}); 
			}  
		}
});
    function changqm(s,aaaa){
		var a = s.id.substring(7,s.id.length);
	    var	quamap=$("#pinming"+a).val();
	    var pinming = "pinming"+a;
		var jixing = "jixing"+a;
    	var guige = "guige"+a;
    	var pizhun = "pizhun"+a;
    	var shangbiao = "shangbiao"+a;
    	var hege = "hege"+a;
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
    	 var shengchang = "shengchang"+i;
    	 var pizhun = "pizhun"+i;
    	 var youxiaoqi = "youxiaoqi"+i;
    	 var tbody="tbody"+i;
    	 var hegeshuliang="hegeshuliang"+i;
    	 var hegezheng = "hegezheng"+i;
    	 var zhuceshangbiao = "zhuceshangbiao"+i;
    	 var shenchanqiye = "shenchanqiye"+i;
    	  var shengchanpihao ="shengchanpihao"+i;
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
			" <input type=\"text\" style=\"width:40px;\" name=\""+shuliang+"\" id=\""+shuliang+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:40px;\" name=\""+hegeshuliang+"\" id=\""+hegeshuliang+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+pizhun+"\" id=\""+pizhun+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+shenchanqiye+"\" id=\""+shenchanqiye+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\" /> "+
		"</td> " +	
		"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value='' name=\""+shengchanriqi+"\" id=\""+shengchanriqi+"\" class=\"easyui-datebox\" data-options='required:true' /> "+
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

