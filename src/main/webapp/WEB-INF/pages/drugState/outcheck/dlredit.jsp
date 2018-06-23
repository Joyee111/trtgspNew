<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title>出库复核修改</title>
    <meta />
</head>
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
                <br />已驳回
            </td>
            <td valign="top" align="center" width="20%">
            	<span>5</span>
                <br />审核通过
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
		<th width="150">购货单位<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="qualifiedPurchaseUnitsIdName" id="qualifiedPurchaseUnitsIdValue" value="${mc.qualifiedPurchaseUnits.customerName}" readonly="readonly" class="text1" size="40"/>
			<input type="hidden" id="qualifiedPurchaseUnitsId" name="qualifiedPurchaseUnitsId" value="${mc.qualifiedPurchaseUnitsId}"/>
		</td>
		<th width="150">票号<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
		<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
       		value:'${xiaoshou}'
			" name="salesNumber" id="salesNumber" size="40"/>
		</td>
	</tr>
	<tr>
	<th width="150">销售日期<span class="required">*</span>：</th>
	<td>
		<input type="text" data-options="required:true,validType:'checkDate',disabled:true" value="${mc.saleTime}" class="easyui-datebox" name="saleTime"  id="saleTime" size="40"/>
	</td>
	<!-- 
	<th>出库日期<span class="required">*</span>：</th>
	<td>
		<input type="text" name="outLibraryDate" class="easyui-datebox text1" value="${mc.outLibraryDate }" data-options="required:true" id="outLibraryDate" size="40" >
	</td>
	 -->
	 <th>合同号<span class="required">*</span>:</th>
	<td><input name="salesFromNumber" id="salesFromNumber" value="${salesFromNumber }" type="text" class="text1" size="40" readonly="readonly"/></td>
	</tr>
	<%-- <tr>
	 <th width="150">质量状况<span class="required">*</span>：</th>
		<td>
		<select name="qualitySituation" id="qualitySituation" class="easyui-validatebox text1" data-options="required:true" >
		<option value="1" >合格</option>
		<option value="2" >不合格</option>
		</select>
		<input type="hidden" id="qualitySituationValue" name="qualitySituationValue" value="${mc.qualitySituation}" />
		</td>
	</tr>
	<tr>
		
	</tr>
	<tr>
	<th valign="top">备注</th>
	 <td colspan="3">
		<textarea type="" name="remark" id="remark"   cols="94" rows="4" class="textarea" >${mc.remark}</textarea>
	</td>
	</tr>--%>
</table>
<table id="condition_table" class="table"  border="0" cellpadding="0" cellspacing="1" width="100%" >
	<thead class='pn-lthead'>
	 <tr>
	 	<th>通用名称</th><th>剂型</th><th>规格</th> <th>数量</th><th>生产批号</th><th>批准文号</th><th>生产企业</th><th>有效期至</th><!-- <th>操作</th> -->
	 
	  </tr>
	 </thead>
</table>
<table>
	<tr align="center">
		<td colspan="4">
		<!-- 	<input type="button" class="btn_big" name="cancel" onclick="addyp();" value="<fmt:message key="新增药品"/>"/>
			<input type="button" class="btn_big" name="save" onclick="savess(0);" value="<fmt:message key="button.save"/>"/>  -->
			<input type="button" class="btn_big" name="save" onclick="savess(1);" value="<fmt:message key="提交"/>"/>
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
<input type="hidden" id="submitType" name="submitType" value="0" />
</form:form>
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
		 $.post("${ctx}/drugState/outcheck/findxsmx.html",{
		"id" : a,
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
				var xiaoshouriqi = "xiaoshouriqi"+s;
				$("#saleTime").datebox('setValue',j.xiaoshouriqi);
				$("#qualifiedPurchaseUnitsIdValue").val(j.gouhuodanwei);
		    	$("#qualifiedPurchaseUnitsId").val(j.gouhuodanweiId);
		    	$("#salesFromNumber").val(j.salesFromNumber);
		    	var tbody="tbody"+s;
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
					" <input type=\"text\" style=\"width:40px;\" value=\""+j.shuliang+"\"  name=\""+shuliang+"\" id=\""+shuliang+"\" readonly='readonly' /> "+
				"</td> " +	
				"<td> " +
				" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchanpihao+"\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" readonly='readonly' /> "+
				"</td> " +
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.pizhunwenhao+"\" name=\""+pizhun+"\" id=\""+pizhun+"\" readonly='readonly'/> "+
				"</td> " +	
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchangqiye+"\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\" readonly='readonly'/> "+
				"</td> " +	
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.youxiaoqizhi+"\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\" data-options='disabled:true' /> "+
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
				value:j.yaopinming,
				disabled :true,
				onSelect: function(rec){
	      			changqm($(this).arrt("id"),rec.id);
	      		}
				}); 
		}
	}else{
	}
});
}
function savess(a){
		$('#submitType').val(a);
		if(checkSubmit()){
			$('#res').form('submit',{
			    success: function(data){  
				var json = jsonParse(data);
					if(json.success!=null && json.success!=""){
						alert(decodeURI( json.success));
					}
				location.href="dlrlist.html";
			    }  
			}); 
		 } 
		}
var i=0;
  function onCancel()
  {
  	history.go(-1);
  }
   function submits(){
    	var form = document.getElementById("res");
    	document.getElementById("submitType").value="1";
    	form.submit();
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
   		         $('#salesNumber').combobox({  
        //url:urlStr,  
        valueField: 'id',
      	textField: 'text', 
        onChange:function (newValue, oldValue){  
            if(newValue !=null && newValue!=""){  
                var urlStr ="${ctx}/drugState/outcheck/findxsd.html?requestName=" + encodeURIComponent(newValue);  
                $("#salesNumber").combobox("reload",urlStr);  
            }  
        }  ,
        onSelect: function(rec){
      			find(rec.id);
      		}
    });  
   		 
    	var ttttt = document.getElementById("qualitySituation"); 
		var ddd = document.getElementById("qualitySituationValue").value;
   		for(var lss=0;lss<ttttt.length;lss++){
        if(ddd==trim(ttttt.options[lss].value.toString())){
            ttttt.options[lss].selected=true;
	        }  
	   	 }
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
	    	i=json.length;
			for(var s=0; s<json.length; s++)  {
			 	var j = JSON.parse(json[s]);
			        var pinming = "pinming"+s;
			    	var jixing = "jixing"+s;
			    	var guige = "guige"+s;
			    	var shuliang = "shuliang"+s;
			    	var pizhun = "pizhun"+s;
			    	var hegezheng = "hegezheng"+s;
 					var zhuceshangbiao = "zhuceshangbiao"+s;
			    	var youxiaoqi = "youxiaoqi"+s;
			    	var shengchanqiye = "shengchanqiye"+s;
			    	var shengchanpihao = "shengchanpihao"+s;
			    	var xiaoshouriqi = "xiaoshouriqi"+s;
			    	var tbody="tbody"+s;
			    	$("#xiaoshousj").val(j.xiaoshouriqi);
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
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.youxiaoqizhi+"\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\" data-options='disabled:true' /> "+
					"</td> " +	
				/*	"<td> " +
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
					value:j.yaopinming,
					disabled : true,
					onSelect: function(rec){
		      			changqm($(this).attr("id"),rec.id);
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
    	var pizhun = "pizhun"+a;
    	var shangbiao = "shangbiao"+a;
    	var hegezheng = "hegezheng"+a;
 		var zhuceshangbiao = "zhuceshangbiao"+a;
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
    	 var pizhun = "pizhun"+i;
    	 var hegezheng = "hegezheng"+i;
 		 var zhuceshangbiao = "zhuceshangbiao"+i;
    	 var youxiaoqi = "youxiaoqi"+i;
    	 var shengchanqiye = "shengchanqiye"+i;
    	 var tbody="tbody"+i;
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
			" <input type=\"text\" style=\"width:100px;\" name=\""+pizhun+"\" id=\""+pizhun+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\" /> "+
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

