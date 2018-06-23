<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
<script type="text/javascript" src="${ctx}/js/jsPrototype.js"></script>
<title>采购订单${titles}</title>
<meta />
</head>
<font
	style="font-family: '宋体'; font-weight: normal; font-size: 12; color: #8d3c01; padding: 10px;"><br>药品状态管理&nbsp;>&nbsp;采购订单管理&nbsp;>&nbsp;采购订单${titles}</font>


<div class="box_big">
	<form method="post" action="saveOrUpdata.html" id="res">
		<input type="hidden" name="id" id="id" value="${re.id}" /> <input
			type="hidden" name="method" id="method" value="${method}" /> <input
			type="hidden" name="thispage" value="${thispage}" /> <input
			type="hidden" id="quamap" value="${quamap}" />
		<div class="ceng_mar5" style="padding-bottom: 5px;">
			<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
				<tr>
					<th width="150"><fmt:message key="re.supplyUnit" /><span
						class="required">*</span>：</th>
					<td><input type="text" class="easyui-combobox  text1"
						data-options="
      	 	valueField: 'id',
       		textField: 'text',
      		url:'${ctx}/firstEnterprise/qualitySupplyJson.html',
      		value:'${gongyingshang}',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#qualifiedSupplierIdValue').val(str[1]);
      		}
			"
						name="" id="commonnameboxs" size="40" /> <input type="hidden"
						id="qualifiedSupplierIdValue" name="qualifiedSupplierIdValue"
						value="${re.qualifiedSupplierId.id}" /></td>
					<th width="150">订单编号<span class="required">*</span>：
					</th>
					<td><input type="text" readonly="readonly" name="number"
						id="number" value="${re.number}" class="easyui-validatebox text1"
						data-options="required:true" size="40" maxlength="20" /></td>
				</tr>
				<tr>
					<!-- <th width="150">计划时间<span class="required">*</span>：</th>
		<td>
			<input type="text" readonly="readonly" name="season" id="season" value="${re.season}" class="easyui-validatebox text1" data-options="required:true" size="40" maxlength="20"/>
		</td>-->
					<th>经营公司<span class="required">*</span></th>
					<td><label>经营</label> <input type="radio" name="departmentId"
						value="1001" /> <label>新品</label> <input type="radio"
						name="departmentId" value="2001" /> <label>市场</label> <input
						type="radio" name="departmentId" value="3001" /> <input
						type="hidden" value="${re.rejectFlag }" name="rejectFlag"
						id="rejectFlag" /></td>
					<th>状态<span class="required">*</span>：
					</th>
					<td>&nbsp;合格&nbsp;<input type="radio" name="useFlag" value="0"
						checked="checked"> &nbsp;作废&nbsp;<input type="radio"
						name="useFlag" value="1">
					</td>
				</tr>
			</table>
			<table id="condition_table" class="table" border="0" cellpadding="0"
				cellspacing="1" width="100%" align="center">
				<thead class='pn-lthead'>
					<tr>
						<!-- 
	 	<th>通用名称</th><th>剂型</th><th>规格</th><th>单位</th><th>数量</th><th>生产企业</th><th>批准文号</th><th>单价</th><th>扣率(%)</th><th>金额</th><th>生产日期</th><th>有效期至</th><th>操作</th>
	  -->
						<th>通用名称</th>
						<th>剂型</th>
						<th>规格</th>
						<th>单位</th>
						<th>数量</th>
						<th>生产企业</th>
						<th>批准文号</th>
						<th>单价</th>
						<th>扣率(%)</th>
						<th>金额</th>
						<th>操作</th>

					</tr>
				</thead>
			</table>
			<p style="padding-right: 130px; float: right;">
				<label
					style="font-weight: bold; font-size: 14px; color: #727171; text-align: right; line-height: 28px;">总金额：</label><input
					type="text" name="totalMoney" id="totalMoney" value="0"
					style="border: 0px;" readonly="readonly" />
			</p>

			<table>

				<tr align="center">
					<td colspan="3"><input type="button" class="btn_big"
						name="cancel" onclick="addyp();" value="<fmt:message key="新增药品"/>" />
						<input type="hidden" name="type" id="save_type" value="0" /> <c:choose>
							<c:when test="${re.rejectFlag != null && re.rejectFlag eq '1'}">
								<input type="button" class="btn_big" name="save"
									onclick="$('#dialog').dialog('open')"
									value="<fmt:message key="提交"/>" />
							</c:when>
							<c:otherwise>
								<input type="button" class="btn_big" name="save"
									onclick="savess('1');" value="<fmt:message key="提交"/>" />
							</c:otherwise>
						</c:choose> <input type="button" class="btn_big" name="save"
						onclick="savess('0');" value="<fmt:message key="button.save"/>" />
						<input type="button" class="btn_big" name="cancel"
						onclick="onCancel();" value="<fmt:message key="button.cancel"/>" />
					</td>
				</tr>
			</table>
		</div>
		<input type="hidden" name="tz" value="${tzpage}" /> <input
			type="hidden" id="receItem" name="receItem" value="${receItem}" /> <input
			type="hidden" name="pagename" value="${pagename}" /> <input
			type="hidden" name="ptmeth" value="${ptmeth}" /> <input type="hidden"
			name="counts" id="counts" value="" /> <input type="hidden"
			name="modify_reason" id="modify_reason"> <input type="hidden"
			name="reason" id="reason">
	</form>
</div>
<div id="dialog" title="修改原因" class="easyui-dialog"
	style="width: 800px; height: 300px; padding: 10px; margin-top: 20px;"
	data-options="closed:true,modal:false,top:200">
	<table>
		<tr>
			<th valign="top">修改原因：</th>
			<td colspan="3"><textarea name="rejectcause" id="rejectcause"
					cols="94" rows="4" class="easyui-validatebox  textarea"
					data-options="required:true"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom"><input
				type="button" class="btn_big" onclick="savess('1')" value="确定">
				<input type="button" class="btn_big"
				onclick="$('#dialog').dialog('close')" value="取消"></td>
		</tr>
	</table>
</div>

<div id="void_dialog" title="作废原因" class="easyui-dialog"
	style="width: 800px; height: 300px; padding: 10px; margin-top: 20px;"
	data-options="closed:true,modal:false,top:200">
	<table>
		<tr>
			<th valign="top">作废原因：</th>
			<td colspan="3"><textarea name="void_reason" id="void_reason"
					cols="94" rows="4" class="easyui-validatebox  textarea"
					data-options="required:true"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom"><input
				type="button" class="btn_big" onclick="savess('3')" value="确定">
				<input type="button" class="btn_big"
				onclick="$('#void_dialog').dialog('close')" value="取消"></td>
		</tr>
	</table>
</div>
<script type="text/javascript">
$("#commonnameboxs").combobox({
	filter: function(q, row){
	var opts = $(this).combobox('options');
	return row[opts.valueField].indexOf(q) >-1;
	}
});
var i=0;
function savess(str) {
	var useFlag = $(':radio[name="useFlag"]:checked');
	if(str==1 && useFlag.val()==1){
		alert("作废请选择保存");
		return
	}
	if(str==0 && useFlag.val()==1){
		$('#void_dialog').dialog('open')
		return
	}
	if(str==3){
		str=0
		$('#void_dialog').dialog('close')
	}
	
	
	 var medcElems = $("#condition_table").children("tbody")
	 var trElems = medcElems.find("tr");
	 if(medcElems.length < 1){
		 alert("请填写药品信息")
		 return
	 }
	 var dpId = $("input[name='departmentId']:checked").val(); 
	 var medcQuantity = {};
	 var medcIds = "";
	 var itemIds = "";
	 for(var j=0;j<medcElems.length;j++){
		 var medcId = trElems.find("input[id^='pinming']").combobox('getValue');
		 var quantity = trElems.find("input[id^='shuliang']").val();
		 var itemId = trElems.find("input[name^='purchaseOrderItemId']").val();
		 var text = trElems.find("input[id^='pinming']").combobox('getText');
		 
		 if(!medcQuantity.hasOwnProperty(medcId)){
			 medcQuantity[medcId] = {};
			 medcQuantity[medcId]["quantity"] = 0;
		 }
		 medcQuantity[medcId]["id"] = medcId;
		 medcQuantity[medcId]["text"] = text;
		 medcQuantity[medcId]["quantity"] = medcQuantity[medcId]["quantity"] + (quantity * 1);
		 if(medcId != undefined && medcId != null && medcId != ""){
			 medcIds += medcId + ","
		 }
		 if(itemId != undefined && itemId != null && itemId != ""){
			 itemIds += itemId + ",";
		 }
	 }
	 $.ajax({
		 url:"${ctx}/drugState/purchaseNote/ajaxQueryMedcAllowBuyQuantity.html"
		 ,data : {medcIds:medcIds,itemIds:itemIds,dpId:dpId}
		 ,dataType:"JSON"
		 ,type:"POST"
		 ,success:function(msg){
		 }
	 }).done(function(medcDatas){
		 for(var j=0;j<medcDatas.length;j++){
			 /*
			  * 采购计划数量 - 采购订单已购买数量(不包含本次购买数量) = 本订单药品可购买数量
			  */
			  var planQuantity = medcDatas[j].maxBuyQuantity;
			  
			  //这么减是因为有一部分订单的数量可能处于新建的状态(已经保存在采购订单了,但是处于新建状态),而新建的数量是属于那种需要锁定的数据,公式为:全部购买数量 - 当前订单数量 = 已购买数量(不包含本次订单但包含其余新建订单的数量)
			  var buyQuantity = Math.Number.subtract(medcDatas[j].buyQuantity,medcDatas[j].thatQuantity,0);
			  //本次订单的购买量
			  var thatQuantity = medcQuantity[medcDatas[j].qualified_medicine_id].quantity
			  if(Math.Number.subtract(Math.Number.subtract(planQuantity,buyQuantity,0),thatQuantity,0) < 0){
				  alert("药品:["+medcQuantity[medcDatas[j].qualified_medicine_id].text+"]无法超出采购计划数量(剩余:"+Math.Number.subtract(Math.Number.subtract(planQuantity,buyQuantity,0),thatQuantity,0)+"),若需要创建订单请追加采购计划")
				  return
			  }
		 }
		var dialog = $("#dialog").dialog();
		var value = dialog.get(0).getElementsByTagName("textarea")[0].value;
		$("#modify_reason").val(value);
		//作废原因
		var dialog = $("#void_dialog").dialog();
		var value = dialog.get(0).getElementsByTagName("textarea")[0].value;
		$("#reason").val(value);
		
		$("#save_type").val(str);
		$('#res').form('submit', {
			success : function(data) {
				var json = jsonParse(data);
				if (json.success == "1") {
					alert("此编号已经存在,新生成的编号为：" + json.number + ",已经保存成功!");
				} else {
					alert("数据保存成功!");
				}
				location.href = "list.html";
			}
		});
	 })
}

    function onCancel()
    {
    	history.go(-1);
    }
    $(function() {
    	var departViewId = "${re.departmentId}";
    	if(departViewId!=null && departViewId!=""){
    		setDefaultForRadio("departmentId",departViewId)
    	}
    	var useFlag = "${re.useFlag}";
    	if(useFlag!=null && useFlag!=""){
    		setDefaultForRadio("useFlag",useFlag)
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
    	//alert(a);
    	if(a!="add"){
    		var depart_id = getRadioValueByName("departmentId");
	    	var b=$("#receItem").val();
	    	//alert(b);
	    	var json=eval("("+b+")");
	    	i=json.length;
	    	var totalMoney = 0;
			for(var s=0; s<json.length; s++)  {
			 	var j = JSON.parse(json[s]);
			        var pinming = "pinming"+s;
			    	var jixing = "jixing"+s;
			    	var guige = "guige"+s;
			    	var danwei = "danwei"+s;
			    	var shuliang = "shuliang"+s;
			    	var pizhun = "pizhun"+s;
			    	var youxiaoqi = "youxiaoqi"+s;
			    	var tkdat = "tkdat"+s;
 					var shengchanqiye = "shengchanqiye"+s;
 					var shengchanpihao= "shengchanpihao"+s;
 					var zuidashuliang="zuidashuliang"+s;
 					var money="money"+s;
			 		var rate = "rate"+s;
			 		var taxPrice = "taxPrice"+s;
			    	var tbody="tbody"+s;
			    	var purchaseOrderId ="purchaseOrderId"+s;
			    	var purchaseOrderItemId ="purchaseOrderItemId"+s;
			    	totalMoney = totalMoney + parseFloat(j.jine);
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
					"<td><input type='text' style='width:50px' value='"+j.danwei+"' name='"+danwei+"' id='"+danwei+"' readonly='readonly'/></td>"+
					"<td> " +
						" <input type=\"text\" style=\"width:40px;\" class=\"easyui-validatebox\" required=\"true\" value=\""+j.shuliang+"\"  name=\""+shuliang+"\" id=\""+shuliang+"\" onchange=\"count_total_meony('"+shuliang+"','"+taxPrice+"','"+rate+"','"+money+"','"+zuidashuliang+"','totalMoney')\"/> "+
						" <input type=\"hidden\" name=\""+zuidashuliang+"\" value=\""+j.zuidashuliang+"\" id=\""+zuidashuliang+"\" /> "+
						" <input type=\"hidden\" name=\""+shengchanpihao+"\" value=\""+j.shengchanpihao+"\" id=\""+shengchanpihao+"\" />"+
					"</td> " +	
					//"<td> " +
					//" <input type=\"text\" style=\"width:100px;\" class=\"easyui-validatebox\" required=\"true\" value=\""+j.shengchanpihao+"\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" /> "+
					//"</td> " +
					"<td> " +
						" <input type=\"text\" style=\"width:80px;\" value=\""+j.shengchangqiye+"\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\" readonly='readonly'/> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:90px;\" value=\""+j.pizhunwenhao+"\" name=\""+pizhun+"\" id=\""+pizhun+"\" readonly='readonly'/> "+
					"</td> " +	
					"<td> " +
					" <input type=\"text\" style=\"width:60px;\" value=\""+j.hanshuidanjia+"\" name=\""+taxPrice+"\" id=\""+taxPrice+"\" onkeyup=\"count_total_meony('"+shuliang+"','"+taxPrice+"','"+rate+"','"+money+"','totalMoney')\" readonly='readonly'/> "+
					"</td> " +
					"<td> " +
						" <input type=\"text\" style=\"width:60px;\" value=\""+j.koulv+"\" name=\""+rate+"\" id=\""+rate+"\" onkeyup=\"count_total_meony('"+shuliang+"','"+taxPrice+"','"+rate+"','"+money+"','totalMoney')\" /> "+
					"</td> " +
					"<td> " +
						" <input type=\"text\" style=\"width:60px;\" value=\""+j.jine+"\" name=\""+money+"\" id=\""+money+"\" readonly='readonly'/> "+
					"</td> " +

					//"<td> " +
					//" <input type=\"text\" style=\"width:95px;\" data-options:\"required='true'\" value=\""+j.shengchanriqi+"\" name=\""+tkdat+"\" id=\""+tkdat+"\" class=\"easyui-datebox\" /> "+
					//"</td> " +	
					
					//"<td> " +
					//	" <input type=\"text\" style=\"width:95px;\" value=\""+j.youxiaoqizhi+"\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\" /> "+
					//"</td> " +	

					"<td> " +
					"<input type='hidden' name='"+purchaseOrderId+"' value='"+j.purchaseOrderId+"' />"+
					"<input type='hidden' name='"+purchaseOrderItemId+"' value='"+j.purchaseOrderItemId+"' />"+
					"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchu("+s+")\" value=\"删除\"/>"+
					"</td> " +	
			    	"</tbody>"
			    	);
			    	$("#counts").val(i);
			    	//alert(j.yaopinming)
			    	$.parser.parse($("#condition_table"));
			        $("#"+pinming).combobox({
		   			url:"${ctx}/drugState/purchaseNote/findypboxqy.html?departmentId="+depart_id,
					valueField:'id', 
					textField:'text',
					value:j.yaopinming,
					onSelect: function(rec){
		      			changqm(pinming,rec.id);
		      		}
					});
			}  
			
			$("#totalMoney").val(totalMoney);
		}
});
    function changqm(s,aaaa){
		var a = s.substring(7,s.length);
	    var	quamap=aaaa;
	    var pinming = "pinming"+a;
		var jixing = "jixing"+a;
    	var guige = "guige"+a;
    	var danwei = "danwei"+a;
    	var shuliang = "shuliang"+a;
    	var pizhun = "pizhun"+a;
    	var youxiaoqi = "youxiaoqi"+a;
	    var hegezheng = "hegezheng"+a;
 		var zhuceshangbiao="zhuceshangbiao"+a;
 		var shengchanqiye = "shengchanqiye" +a;
 		var zuidashuliang= "zuidashuliang"+a;
 		var dept_id = getRadioValueByName("departmentId");
	    if(quamap!=""){
			$.post("${ctx}/drugState/inspectionRecords/quamap.html?departmentId="+dept_id,{
			"quamap" : quamap,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					//alert(c[6]);
					//alert(c[11]);
					$("#jixing"+a).val(c[0]);
					$("#guige"+a).val(c[1]);
					$("#shengchanqiye"+a).val(c[2]);
					$("#pizhun"+a).val(c[3]);
					$("#zhuceshangbiao"+a).val(c[4]);
					$("#hegezheng"+a).val(c[5]);
					//$("#youxiaoqi"+a).val(c[6]);
					$("#shengchanqiye"+a).val(c[7]);
					$("#zuidashuliang"+a).val(c[9]);
					$("#taxPrice"+a).val(c[11]);
					$("#danwei"+a).val(c[8]);
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
			$("#zuidashuliang"+a).val("");
	    }
    
    }
    function addyp(){
    	 var  departmentValue = getRadioValueByName("departmentId");
    	 if(typeof(departmentValue)==undefined || departmentValue==""){
    	 	alert("请先选择经营公司！");
    	 	return;
    	 }
    	 var qualifiedSupplierId = $("#qualifiedSupplierIdValue").val();
    	 if(qualifiedSupplierId=="" || qualifiedSupplierId==null ){
			alert("请选择供货单位");	
			return;
    	 }
    	 var quamap=$("#quamap").val();
    	 var c = quamap.substring(1,quamap.length-1);
    	 var b = c.split(",");
    	 var d ="";
    	 var pinming = "pinming"+i;
    	 var jixing = "jixing"+i;
    	 var guige = "guige"+i;
    	 var danwei = 'danwei'+i;
    	 var shuliang = "shuliang"+i;
    	 var pizhun = "pizhun"+i;
    	 var youxiaoqi = "youxiaoqi"+i;
    	 var shengchanpihao = "shengchanpihao"+i;
    	 var shengchanqiye = "shengchanqiye"+i;
    	 var remark = "remark"+i;
    	 var taxPrice = "taxPrice"+i;
 		 var money="money"+i;
 		 var rate = "rate"+i;
    	 var tbody="tbody"+i;
    	 var tkdat = "tkdat"+i;
    	 var zuidashuliang="zuidashuliang"+i;
    	 for(var j=0;j<b.length;j++){
    	 	var e = b[j].split("=");
    	 	d+="<option value=\""+e[0]+"\">"+e[1]+"</option>"; 
    	 }
    	$("#condition_table").append(" <tbody id=\""+tbody+"\" class='pn-ltbody'>  " +
    	"<td> " +
		"<input id=\""+pinming+"\"  name=\""+pinming+"\" >" +
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:80px;\" name=\""+jixing+"\" id=\""+jixing+"\" readonly='readonly'/> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:80px;\" name=\""+guige+"\" id=\""+guige+"\" readonly='readonly'/> "+
		"</td> " +	
		"<td><input type='text' style='width:50px;' name='"+danwei+"' id='"+danwei+"' readonly='readonly'></td>" +
		"<td> " +
	//		" <input type=\"text\" style=\"width:40px;\" onchange=\"valshuliang("+i+")\"  name=\""+shuliang+"\" id=\""+shuliang+"\" /> "+
		" <input type=\"text\" style=\"width:80px;\" class=\"easyui-validatebox\" required=\"true\" name=\""+shuliang+"\" id=\""+shuliang+"\" onchange=\"count_total_meony('"+shuliang+"','"+taxPrice+"','"+rate+"','"+money+"','"+zuidashuliang+"','totalMoney')\"/> "+
	
			" <input type=\"hidden\" name=\""+zuidashuliang+"\" id=\""+zuidashuliang+"\" /> "+
		"</td> " +	
		//"<td> " +
//采购不再输入批号2017-5-25 14:08:28		" <input type=\"text\" style=\"width:80px;\" class=\"easyui-validatebox\" required=\"true\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" /> "+
		//"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:90px;\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\" readonly='readonly'/> "+
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:120px;\" name=\""+pizhun+"\" id=\""+pizhun+"\" readonly='readonly'/> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:60px;\" name=\""+taxPrice+"\" id=\""+taxPrice+"\" onkeyup=\"count_total_meony('"+shuliang+"','"+taxPrice+"','"+rate+"','"+money+"','totalMoney')\" readonly='readonly'/> "+
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:60px;\" name=\""+rate+"\" value='100' id=\""+rate+"\" onkeyup=\"count_total_meony('"+shuliang+"','"+taxPrice+"','"+rate+"','"+money+"','totalMoney')\" /> "+
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:60px;\"class=\"easyui-validatebox\" required=\"true\" name=\""+money+"\" id=\""+money+"\" readonly='readonly'/> "+
		"</td> " +
		
		//"<td> " +
		//" <input type=\"text\" style=\"width:95px; data-options:\"required='true'\" name=\""+tkdat+"\" id=\""+tkdat+"\" class=\"easyui-datebox\" /> "+
		//"</td> " +	
		
		//"<td> " +
		//	" <input type=\"text\" style=\"width:95px;data-options:\"required='true'\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\" /> "+
		//"</td> " +	
		
		"<td> " +
			"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchu("+i+")\" value=\"删除\"/>"+
		"</td> " +	
    	"</tbody>"
    	);
    	i++;
    	$("#counts").val(i);
    	$.parser.parse($("#"+tbody));
    	var value= qualifiedSupplierId +','+departmentValue;
    	$("#"+pinming).combobox({
		url:"${ctx}/drugState/purchaseNote/findypboxqy.html?value="+value,
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
    	var currentMoney = "money"+a;
		deleteCountMoney(currentMoney);
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
 	function valshuliang(s){
 	}
 	/*
 		quality 数量DOMID
 		taxprice 单价DOMID
 		koulv 扣率DOMID
 		total 金额DOMID
	*/
 	function count_total_meony(quality,taxprice,koulv,total,maxQuality,totalMoney){
 		var qua = $("#"+quality).val();//数量
 		var tax = $("#"+taxprice).val();//单价
 		var kl =  $("#"+koulv).val();//扣率
 		var total_money = $("#"+totalMoney).val();//总金额
 		
 	//	var max = $("#"+maxQuality).val();
 		if(isNotNull(qua) && isNotNull(tax) && isNotNull(kl)){
 			var qua1 = $("#"+quality).val();//数量
 			var tax1 = $("#"+taxprice).val();//单价
 			var kl1 =  $("#"+koulv).val();//扣率
 			//var money = 	(parseFloat(qua1))*(parseFloat(tax1))*(parseFloat(kl1)/100);
 			var money = 	parseFloat(qua1*tax1*((kl1)/100)).toFixed(2);
 			var total_m = 0 ;
 			//alert(money);
 			$("#"+total).val(money);
 			for(var j=0;j<i;j++){
 				var itemMoney = $("#money"+j).val();
 				if(typeof(itemMoney)!='undefined' && itemMoney!=""){
 					total_m = parseFloat(total_m) + parseFloat(itemMoney);
 				}
 			}
 			$("#"+totalMoney).val(parseFloat(total_m).toFixed(2));
 		}else if(isNotNull(qua) && isNotNull(tax) && !isNotNull(kl)){
 			var qua2 = $("#"+quality).val();//数量
 			var tax2 = $("#"+taxprice).val();//单价
 			var money = 	qua2*tax2;
 		//	var money = 	qua2*tax2;
 			var total_m = 0;
 			//alert(money);
 			$("#"+total).val(parseFloat(money).toFixed(2));
 			for(var j=0;j<i;j++){
 				var itemMoney = $("#money"+j).val();
 				if(typeof(itemMoney)!='undefined' && itemMoney!=""){
 					total_m = parseFloat(total_m) + parseFloat(itemMoney);
 					//total_m = total_m+itemMoney;
 				}
 			}
 			$("#"+totalMoney).val(parseFloat(total_m).toFixed(2));
 		}
 	} 
	function isNotNull(value){
		return typeof(value)!=undefined && value!=null && value!="";
	}
	function deleteCountMoney(current){
			var tot = $("#totalMoney").val();
			var cu =$("#"+current).val();
			var last = parseFloat(tot)-parseFloat(cu);
			$("#totalMoney").val(parseFloat(last).toFixed(2));
	}
	//if("${re.departmentId}"!=""){
	//	setDefaultForRadio("operatingCompany","${re.departmentId}");
	//}
</script>

