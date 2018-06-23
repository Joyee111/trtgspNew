<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title>采购计划添加</title>
    <meta />
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
</head>
<script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
<link href="<%=basePath%>js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />

<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;采购计划&nbsp;>&nbsp;采购计划新增</font>
<div class="box_big">
<form  method="post" action="savePurchasePlan.html" id="purchasePlan" >
<input type="hidden" name="method" id="method" value="${method}" />
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" id="quamap" value = "${quamap}" />
<table class="xx_table">
	<tr>
	<th width="150"><fmt:message key="计划年份"/><span class="required">*</span>：</th>
	<td>
		<input type="text" onchange="changetext()" data-options="required:true" class="easyui-validatebox text1" id="year" name="year"  size="40"/>
	</td>
	<th width="150"><fmt:message key="计划编号"/>：</th>
		<td>
		<input type="text" readonly="readonly" class="easyui-validatebox text1" name="plNos" id="plNos" size="40"/>
	</td>
	<!-- <th width="150"><fmt:message key="计划季度"/><span class="required">*</span>：</th> -->
	 <td style="display: none;"><select onchange="changeselect()" id="season" name="season">
	 		<!-- <option value="">请选择</option>  -->	
            	<option value="1" selected="selected">1季度</option>
				<option value="2">2季度</option>
				<option value="3">3季度</option>
				<option value="4">4季度</option>
    </select></td>
	</tr>
	<tr>
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
      			$('#qualifiedSupplierId').val(str[1]);
      		}
			" name="" id="commonnameboxs" size="40"/>
	<input type="hidden" id="qualifiedSupplierIdValue" name="qualifiedSupplier" />
	</td>
	<th width="150"><fmt:message key="计划类别"/><span class="required">*</span>：</th>
		<td colspan="3">
			<input type="radio" onchange="changeradio('quantity','types')" id="quantity1" name="quantity" value="1" /> <font style="font-size:12px; color:#727171; font-weight:bold;">正常</font>
			<input type="radio" onchange="changeradio('quantity','types')" id="quantity2" name="quantity" value="2" /> <font style="font-size:12px; color:#727171; font-weight:bold;">追加</font>
			<input type="radio" onchange="changeradio('quantity','types')" id="quantity3" name="quantity" value="3" /> <font style="font-size:12px; color:#727171; font-weight:bold;">消减</font>
		</td>
	</tr>
<!--	<tr>
		<th width="150"><fmt:message key="购货时间"/><span class="required">*</span>：</th>
		<td>
		<input type="text" data-options="required:true,validType:'checkDate',onSelect: function(){   $('#supplyTimes').val($('#purchaseTime').datebox('getValue')); }" class="easyui-datebox" name="purchaseTime" id="purchaseTime" size="40"/>
		</td>
		
	</tr> -->
	<tr>
		<th>经营公司<span class="required">*</span>：</th>
		<td>
			<label>经营</label>
			<input type="radio" name="operatingCompany" onchange="changeradio('operatingCompany','department_Id')" value="1001"/>
			<label>新品</label>
			<input type="radio" name="operatingCompany" onchange="changeradio('operatingCompany','department_Id')" value="2001"/>
			<label>市场</label>
			<input type="radio" name="operatingCompany" onchange="changeradio('operatingCompany','department_Id')" value="3001"/>
		</td>
	</tr>
</table>
</form>
<%
	//生成token值存入session用于服务端判断表单重复提交
	String token = UUID.randomUUID().toString().replace("-","");
	session.setAttribute("token",token);
 %>
<form  method="post" action="savePurchasePlanItem.html" id="purchasePlanItem" >
<input type="hidden" id="years" name="years"/>
<input type="hidden" id="seasons" name="seasons" value="1"/>
<input type="hidden" id="types" name="types"/>
<input type="hidden" id="qualifiedSupplierId" name="qualifiedSupplier" />
<input type="hidden" name="counts" id="counts" value=""/>
<input type="hidden" name="supplyTimes" id="supplyTimes"  />
<input type="hidden" name="plNo" id="plNo" />
<input type="hidden" name="departmentId" id="department_Id">
<input type="hidden" name="formtoken" value="<%=token %>">
<table id="condition_table"  border="0" class="table"  cellpadding="0" cellspacing="1" width="100%" align="center">
	<thead class='pn-lthead'>
	 <tr>
	 	<th>通用名称</th><th>剂型</th><th>规格</th> <th>批准文号</th><th>数量(万盒)</th><th>批发价</th><th>扣率(%)</th><th>金额(万元)</th><th>备注</th><th>操作</th>
	  </tr>
	 </thead>
</table>
</form>
</div>
<table>
	<tr align="center">
		<td colspan="3">
			<input type="button" class="btn_big" name="cancel" onclick="savesss();" value="<fmt:message key="新增药品"/>"/>
			<input type="button" class="btn_big" name="save" onclick="savess();" value="<fmt:message key="button.save"/>"/>
			<input type="button" class="btn_big" name="cancel" onclick="back();" value="<fmt:message key="button.cancel"/>"/>
		</td>
	</tr>
</table>
<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" id="receItem" name="receItem" value="${receItem}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type="hidden" id="ddddddd" name="ddddddd" value="0"/>
<form action="list.html" id="backsss">


</form>
<script type="text/javascript">
$("#commonnameboxs").combobox({
	filter: function(q, row){
	var opts = $(this).combobox('options');
	return row[opts.valueField].indexOf(q) >-1;
	}
});
function back(){
	var form=document.getElementById("backsss");
    	form.submit();
}
var i=0;
function changetext(){
	var year = document.getElementById("year").value;
	$("#years").val(year); 
}
function changeselect(){
	var season = document.getElementById("season").value;
	$("#seasons").val(season); 
}
	function savesss(){
		var year = $("#years").val();
    	var seasons = $("#seasons").val();
    	var types = $("#types").val();
    	var qualifiedSupplierId = $("#qualifiedSupplierId").val();
    	var datess = $("#supplyTimes").val();
    	if(year=="" || year==null ){
			alert("请填写计划年份");	
			return;
    	}
    	if(seasons=="" || seasons==null ){
			alert("请填写计划季度");	
			return;
    	}
    	if(qualifiedSupplierId=="" || qualifiedSupplierId==null ){
			alert("请选择供货单位");	
			return;
    	}
    	if(types=="" || types==null ){
			alert("请填写计划类别");	
			return;
    	}
    	/*if(datess=="" || datess==null ){
			alert("请填写购货时间");	
			return;
    	}*/
		$('#purchasePlan').form('submit',{
		    success: function(data){  
			var json = jsonParse(data);
				if(json.success!=null && json.success!="" &&  json.success =="1"){
				$("#ddddddd").val(1);
					alert("计划已经存在！");
					return ;
				}else if(json.success!=null && json.success!="" &&  json.success =="2"){
					alert("计划不存在！");
					return ;
				}else{
					$("#plNo").val(json.plNo);
					$("#plNos").val(json.plNo);
					addyp();
					return;
				}
		   }  
		});  
	}
	function savess(){
    if(i==0){
    	alert("请填写药品！");
    	return;
    }
	if($("#ddddddd").val()==0){
		alert("请选择药品！");
		return;
	}
		$('#purchasePlanItem').form('submit',{
		    success: function(data){  
			var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
			location.href="list.html";
		   }  
		});  
	}
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
					//alert(c[10]);
					$("#jixing"+a).val(c[0]);
					$("#guige"+a).val(c[1]);
					$("#pizhun"+a).val(c[3]);
					$("#zhuceshangbiao"+a).val(c[4]);
					$("#hegezheng"+a).val(c[5]);
					$("#youxiaoqi"+a).val(c[6]);
					$("#pifajia"+a).val(c[10]);
					$("#ddddddd").val(1);//不设置会出现即使选择了药品,保存时也提示要选择药品的问题
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
			$("#pifajia"+a).vla("")
	    }
    
    }
    function addyp(){
    	var year = $("#years").val();
    	var seasons = $("#seasons").val();
    	var types = $("#types").val();
    	var qualifiedSupplierId = $("#qualifiedSupplierId").val();
    	var departmentId = $("#department_Id").val();
    	if(year=="" || year==null ){
			alert("请填写计划年份");	
			return;
    	}
    	if(seasons=="" || seasons==null ){
			alert("请填写计划季度");	
			return;
    	}
    	if(qualifiedSupplierId=="" || qualifiedSupplierId==null ){
			alert("请选择供货单位");	
			return;
    	}
    	if(types=="" || types==null ){
			alert("请填写计划类别");	
			return;
    	}
    	if(departmentId=="" || departmentId==null ){
			alert("请选择经营公司");	
			return;
    	}
    	
    	 var pinming = "pinming"+i;
    	 var jixing = "jixing"+i;
    	 var guige = "guige"+i;
    	 var shuliang = "shuliang"+i;
    	 var pizhun = "pizhun"+i;
 		 var money="money"+i;
    	 var youxiaoqi = "youxiaoqi"+i;
    	 var shengchanpihao = "shengchanpihao"+i;
    	 var remark = "remark"+i;
    	 var pifajia ="pifajia"+i;
    	 var koulv = "koulv"+i;
    	 var tbody="tbody"+i;
    	$("#condition_table").append(" <tbody id=\""+tbody+"\" class='pn-ltbody'>  " +
    	"<td> " +
		"<input style=\"width:180px;\" id=\""+pinming+"\"  name=\""+pinming+"\" >" +
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:80px;\" name=\""+jixing+"\" id=\""+jixing+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+guige+"\" id=\""+guige+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+pizhun+"\" id=\""+pizhun+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" class=\"easyui-validatebox\" required=\"true\" style=\"width:60px;\" onkeyup=\"countMoney('"+shuliang+"','"+pifajia+"','"+koulv+"','"+money+"','quanlity')\" name=\""+shuliang+"\" id=\""+shuliang+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:60px;\" onkeyup=\"countMoney('"+shuliang+"','"+pifajia+"','"+koulv+"','"+money+"','taxprice')\" name=\""+pifajia+"\" id=\""+pifajia+"\" /> "+
		"</td> " +
		"<td>"+
			"<input type='text' style='width:60px;' name='"+koulv+"' id='"+koulv+"' value='75' onkeyup=\"countMoney('"+shuliang+"','"+pifajia+"','"+koulv+"','"+money+"','koulv')\" >" +
		"</td>"+
		"<td> " +
			" <input type=\"text\" class=\"easyui-validatebox\" required=\"true\" style=\"width:60px;\" name=\""+money+"\" id=\""+money+"\" /> "+
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:150px;\" name=\""+remark+"\" id=\""+remark+"\" /> "+
		"</td> " +
		"<td> " +
			"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchu("+i+")\" value=\"删除\"/>"+
		"</td> " +	
    	"</tbody>"
    	);
    	i++;
    	$("#counts").val(i);
    	$.parser.parse($("#condition_table"));
    	var departmentId = getRadioValueByName("operatingCompany");
    	var value= qualifiedSupplierId +','+departmentId;
    	$("#"+pinming).combobox({
   			url:"${ctx}/drugState/inspectionRecords/findypboxqy.html?value="+value,
			valueField:'id', 
			textField:'text',
			onSelect: function(rec){
      			changqm(pinming,rec.id);
      		}
		});
		$("#ddddddd").val(0);
    }
    function changepfj(a){
    if($("#pifajia"+a).val()!=null && $("#pifajia"+a).val()!="" && $("#shuliang"+a).val()!=null && $("#shuliang"+a).val()!=""){
    	var b = parseFloat($("#pifajia"+a).val())*10000;
    	var c = parseFloat($("#shuliang"+a).val())*10000;
    	var e = c*b/100000000;
    	$("#money"+a).val(parseFloat(e).toFixed(2));
   		}
    }
    function countMoney(quanlity,taxprice,deductionRate,totalMoney,type){
    	if(typeof(type)=== 'undefined' && type=== ""){
    		return ;
    	}else if(type ==="quanlity"){
    		var quan = $("#"+quanlity).val(),
    			taxp = $("#"+taxprice).val(),
   				dedu = $("#"+deductionRate).val();
   			
   			var money = ((parseFloat(quan)*10000)*parseFloat(taxp)*(parseFloat(dedu)/100))/10000;
   			$("#"+totalMoney).val(parseFloat(money.toFixed(2)));
   				
    	}else if(type==='taxprice'){
    		var quan = $("#"+quanlity).val(),
    			taxp = $("#"+taxprice).val(),
   				dedu = $("#"+deductionRate).val();
   			
   			var money = ((parseFloat(quan)*10000)*parseFloat(taxp)*(parseFloat(dedu)/100))/100000;
   			$("#"+totalMoney).val(parseFloat(money.toFixed(2)));
    	}else if(type==="koulv"){
    		var quan = $("#"+quanlity).val(),
    			taxp = $("#"+taxprice).val(),
   				dedu = $("#"+deductionRate).val();
   			
   			var money = ((parseFloat(quan)*10000)*parseFloat(taxp)*(parseFloat(dedu)/100))/10000;
   			$("#"+totalMoney).val(parseFloat(money.toFixed(2)));
    	}
    }
   
    function shanchu(a){
    	var b = "tbody"+a;
		var table = document.getElementById("condition_table");
    	var tbodies= table.getElementsByTagName("tbody");
    	for(var f=0;f<tbodies.length;f++){
		if(tbodies[f].id==b){
		   table.removeChild(tbodies[b]);
		   i = i-1;
		    }          
		}  
    }
     function trim(str){	
 		return str.replace(/(^\s*)|(\s*$)/g, ""); 
 	}
 	
</script>

