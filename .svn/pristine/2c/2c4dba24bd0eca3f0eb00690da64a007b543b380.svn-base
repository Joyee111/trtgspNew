<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title>退货验收新增</title>
    <meta />
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</head>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;验收管理&nbsp;>&nbsp;退货验收新增</font>
<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span class="ok">1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span>2</span>
                <br />已保存
            </td>
            <td valign="top" align="center" width="20%">
            	<span>3</span>
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
<form method="post" action="dlrsave.html" id="res">
<input type="hidden" name="id" value="${id}"/>
<input type="hidden" name="thispage" value="${thispage}" />
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
       		value:'${re.saleNo}',
      		url:'${ctx}/drugState/checkreturn/findthd.html',
      		onSelect: function(rec){
      			find(rec.id);
      			$('#returnNoValue').val(rec.text);
      		}
			" name="" id="returnNo" size="40"/>
			<input type="hidden" name="returnNo" value="${mc.returnNo}" id="returnNoValue"/>
	</td>
		<th width="150">退货单位：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-validatebox text1" readonly="readonly" id="qualifiedPurchaseUnitsIdValue" size="40"/>	
			<input type="hidden" id="qualifiedPurchaseUnitsId" name="qualifiedPurchaseUnitsId" />
		</td>
	</tr>
	<tr>
	<th width="150">报告单号<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="reportNo" readonly="readonly" class="easyui-validatebox text1" value="${mc.reportNo}" data-options="required:true" id="reportNo" size="40"/>
	</td>
	<th width="150">退货日期<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-datebox text1" data-options="required:true,value:'${mc.arrivalDate}',disabled:true"  name="arrivalDate" id="arrivalDate" size="40"/>
		</td>
	</tr>
	<tr>
		<th width="150">验收日期<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-datebox text1" data-options="required:true,value:'${mc.checkAcceptDate}', disabled:true"  name="checkAcceptDate" id="checkAcceptDate" size="40"/>
		</td>
		<th width="150">收货员：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="goodsClerk" id="goodsClerk"  class="easyui-validatebox text1" readonly='readonly' size="40"/>
		</td>
	</tr>
	<tr>
	   <th width="150">存储库区：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="storageStore" id="storageStore"  class="easyui-validatebox text1" readonly='readonly' size="40"/>
		</td>
	</tr>
	<tr>
	<th valign="top">验收结果：</th>
	 <td colspan="3">
		<textarea type="" name="result" id="result" cols="94" rows="4" class="textarea" ></textarea>
	</td>
	</tr>
	<tr>
	<th valign="top">退货原因：</th>
	 <td colspan="3">
		<textarea type="" name="checkConclusion" id="checkConclusion" cols="94" rows="4" class="textarea" readonly="readonly"></textarea>
	</td>
	</tr>
</table>
<table  class="table" id="condition_table"  border="0" cellpadding="0" cellspacing="1" width="98%" align="center">
	<thead>
	 <tr>
	 	<th>通用名称</th><th>剂型</th><th>规格</th> <th>数量</th><th>生产批号</th><th>批准文号</th><th>生产企业</th><th>有效期至</th><th>生产日期</th><!-- <th>操作</th> -->
	 
	  </tr>
	 </thead>
</table>
<table>
	<tr align="center">
		<td colspan="4">
		<!-- 	<input type="button" class="btn_big" name="cancel" onclick="addyp();" value="<fmt:message key="新增药品"/>"/> -->
			<input type="button" class="btn_big" name="提交" onclick="submits(1)" value="<fmt:message key="提交"/>"/>
			<input type="button" class="btn_big" name="save" onclick="submits(0)" value="<fmt:message key="button.save"/>"/>
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
<input type="hidden" name="submitType" id="submitType" value="" />
</form>
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
		    	var hegezheng = "hegezheng"+s;
				var zhuceshangbiao="zhuceshangbiao"+s;
				var shengchanpihao = "shengchanpihao"+s;
				var shengchanqiye = "shengchanqiye"+s;
				var xiaoshouriqi = "xiaoshouriqi"+s;
				var shengchanriqi = "shengchanriqi"+s;
				//var hegeshuliang="hegeshuliang"+s;
		    	var tbody="tbody"+s;
		    	$("#saleTime").datebox('setValue',j.xiaoshouriqi);
		    	$("#qualifiedPurchaseUnitsIdValue").val(j.gouhuodanwei);
		    	$("#qualifiedPurchaseUnitsId").val(j.gouhuodanweiId);
		    	$("#checkConclusion").val(j.returnReason);
		    	$("#goodsClerk").val(j.receivePerson);
		    	$("#storageStore").val(j.storageStore);
		    	$("#arrivalDate").datebox("setValue",j.tuihuoriq);
		    	//alert(j.gouhuodanweiId);
		        $("#condition_table").append(" <tbody id=\""+tbody+"\"  class='pn-ltbody'>  " +
		    	"<td> " +
				"<input id=\""+pinming+"\"  name=\""+pinming+"\" >" +
				"</td> " +
				"<td> " +
					" <input type=\"text\" style=\"width:50px;\" value=\""+j.jixing+"\" name=\""+jixing+"\" id=\""+jixing+"\"  readonly='readonly'/> "+
				"</td> " +	
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.guige+"\" name=\""+guige+"\" id=\""+guige+"\" readonly='readonly' /> "+
				"</td> " +	
				"<td> " +
					" <input type=\"text\" style=\"width:40px;\" value=\""+j.shuliang+"\"  name=\""+shuliang+"\" id=\""+shuliang+"\" readonly='readonly'/> "+
				"</td> " +	
				/*"<td> " +
				" <input type=\"text\" style=\"width:40px;\" name=\""+hegeshuliang+"\" id=\""+hegeshuliang+"\" /> "+
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
						alert("此编号已经存在,新生成的编号为："+json.number+",已经保存成功!");
					}else{
							alert("数据保存成功!");
					}
				location.href="dlrlist.html";
			    }  
			});  
		}
    }
   	function save_syqy(){
		$("submitType").val(0);
		$('#res').form('submit');
	}
    function changqm(s,aaaa){
		var a = s.substring(7,s.length);
	    var	quamap=aaaa;
	    var pinming = "pinming"+a;
		var jixing = "jixing"+a;
    	var guige = "guige"+a;
    	var shuliang = "shuliang"+a;
    	var pizhun = "pizhun"+a;
    	var youxiaoqi = "youxiaoqi"+a;
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
					$("#shenchanqiye"+a).val(c[7]);
				}else{
					return;
				}
			});
	    }else{
	    	$("#jixing"+a).val("");
			$("#guige"+a).val("");
			$("#zhuceshangbiao"+a).val("");
			$("#pizhun"+a).val("");
			$("#hegezheng"+a).val("");
			$("#youxiaoqi"+a).val("");
			$("#shuliang"+a).val("");
			$("#hegeshuliang"+a).val("");
			$("#shenchanqiye"+a).val("");
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
			" <input type=\"text\" style=\"width:100px;\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\"  class=\"easyui-datebox\" /> "+
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
</script>

