<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title>验收新增</title>
    <meta />
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</head>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;验收管理&nbsp;>&nbsp;验收新增</font>
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
<form method="post" action="dlrsave.html" id="res">
<input type="hidden" name="id" value="${id}"/>
<!-- <input type="hidden" name="thispage" value="${thispage}" />-->
<input type="hidden" id="quamap" value = "${quamap}" />
<div class="ceng_mar5" style="padding-bottom:5px;">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
<tr>
		<th width="150">生产批号<span class="required">*</span>：</th>
		<td style="width:400px;">
			<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
      		url:'${ctx}/drugState/inspectionRecords/findshd.html',
      		onSelect: function(rec){
      		var str = rec.id.split('_');
     			find(str[0],str[1]);
     			$('#receivingNumber').val(str[0]);
      		}
			" name="receiving_Number" id="caigoudan" size="40"/>&nbsp;&nbsp;
		</td>
		<th width="150">供货单位<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
		<input type="text" class="easyui-combobox  text1" data-options="
			 required:true,
      	 	valueField: 'id',
       		textField: 'text',
       		value:'${gongyingshang}',
      		url:'${ctx}/firstEnterprise/qualitySupplyJson.html',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#qualifiedSupplierIdValue').val(str[1]);
      		}
			" name="" id="commonnameboxs" size="40"/>
	<input type="hidden" id="qualifiedSupplierIdValue" name="qualifiedSupplierId" />
		</td>
	</tr>
	<tr>
		<th width="150">单据号<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="number" id="number" maxlength="20" class="easyui-validatebox text1" value="${mc.number}" data-options="required:true" onblur="ajaxCompare(this)" size="40"/>
		</td>
		<th width="150">收货员：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="goodsClerk" id="goodsClerk" class="easyui-validatebox text1" readonly="readonly" size="40"/>
	</td>
	</tr>
	<tr>
		<th width="150">到货日期<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
			<c:choose>
				<c:when test="${dateDisableFlag == 'true'}">
					<input type="text" class="easyui-datebox text1" value=""  data-options="required:true,validType:'date',disabled:true"" name="arrivalDate" id="arrivalDate"  size="40"/>
				</c:when>
				<c:when test="${dateDisableFlag == 'false'}">
					<input type="text" class="easyui-datebox text1" value=""  data-options="required:true,validType:'date',disabled:true" name="arrivalDate" id="arrivalDate"  size="40"/>
				</c:when>
			</c:choose>
			
		</td>
		
		<th width="150">验收日期<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
		<c:choose>
				<c:when test="${dateDisableFlag == 'true'}">
					<input type="text" class="easyui-datebox text1" value="${mc.checkAcceptDate}"  data-options="required:true,validType:'date',disabled:true"" name="checkAcceptDate" id="checkAcceptDate"   size="40"/>
				</c:when>
				<c:when test="${dateDisableFlag == 'false'}">
					<input type="text" class="easyui-datebox text1" value="${mc.checkAcceptDate}"  data-options="required:true,validType:'date',disabled:true" name="checkAcceptDate" id="checkAcceptDate"   size="40"/>
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
		<textarea type="" name="result" id="result" maxlength="33 " cols="94" rows="4" class="textarea" ></textarea>
	</td>
	</tr>
	<tr>
	<th valign="top">检查结论：</th>
	 <td colspan="3">
		<textarea  name="checkConclusion" maxlength="18" id="checkConclusion" cols="94" rows="4" class="textarea" ></textarea>
	</td>
	</tr>
</table>
<table  class="table" id="condition_table"  border="0" cellpadding="0" cellspacing="1" width="98%" align="center">
	<thead>
	 <tr>
	 	<th>通用名称</th><th>剂型</th><th>规格</th> <th>数量</th><th>合格数量</th><th>生产批号</th><th>批准文号</th><th>生产厂商</th><th>生产日期</th><th>有效期至</th><th width="50">不合格数量</th><th>不合格项</th><th>处理措施</th><!--<th>操作</th>-->
	  </tr>
	 </thead>
</table>
<table>
	<tr align="center">
		<td colspan="4">
			<input type="hidden" name="receivingNumber" value="${mc.receivingNumber }" id="receivingNumber" />
		<!--  	<input type="button" class="btn_big" name="cancel" onclick="addyp();" value="<fmt:message key="新增药品"/>"/> -->
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
<input type="hidden" name="submitType" id="submitType" value="0" />
</form>
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
$("#commonnameboxs").combobox({
			filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q) >-1;
			}
		});
function find(resId,bNo){
for(var ii=0;ii<i;ii++){
        var table = document.getElementById("condition_table");
    	var tbodies= table.getElementsByTagName("tbody");
    	for(var f=0;f<tbodies.length;f++){
		  table.removeChild(tbodies[f]);             
		} 
}
$("#qualifiedSupplierId").val("");
	 $("#goodsClerk").val("");
	 $("#counts").val(0);
	i=0;
	var d;
	//alert(resId);
	//var a = document.getElementById("caigoudan").value;
	$.post("${ctx}/drugState/inspectionRecords/findsh.html",{
			"shouhuodan" : resId,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					d=c[1];
					//alert(c[4]);
					 $("#goodsClerk").val(c[2]);
					 $("#qualifiedSupplierIdValue").val(c[0]);
					 $('#commonnameboxs').combobox('setValue',c[3]);
					 $("#arrivalDate").datebox('setValue',c[4]);
					 $.post("${ctx}/drugState/inspectionRecords/findshmx.html",{
					"id" : c[1],
					},function(data){
					if(data){
					var datas="["+data+"]";
    				var jsons=eval("("+datas+")");
    				/*lfl var quamap=$("#quamap").val();
    				alert(quamap);
				  	var aa = quamap.substring(1,quamap.length-1);
				   	var f = aa.split(",");
				   	var g ="";
				   	for(var j=0;j<f.length;j++){
			    		var e = f[j].split("=");
			    		g+="<option value=\""+e[0]+"\">"+e[1]+"</option>"; 
			    	}*/
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
		 					var hegeshuliang ="hegeshuliang"+s;
		 					var buhegeshu ="buhegeshu"+s;
					    	var buhegexiang="buhegexiang"+s;
					    	var chuzhicuoshi="chuzhicuoshi"+s;
					    	var buhegeshu ="buhegeshu"+s;
					    	var buhegexiang="buhegexiang"+s;
					    	var chuzhicuoshi="chuzhicuoshi"+s;
					    	var shengchanriqi="shengchanriqi"+s;
					    	var tbody="tbody"+s;
					    	$("#storageConditions").val(j.storageConditions);
					    	$("#storageStore").val(j.storageStore);
					        $("#condition_table").append(" <tbody id=\""+tbody+"\"  class='pn-ltbody'>  " +
					    	"<td> " +
							"<input id=\""+pinming+"\"  name=\""+pinming+"\" >" +
							"</td> " +
							"<td> " +
							" <input type=\"text\" style=\"width:60px;\" value=\""+j.jixing+"\" name=\""+jixing+"\" id=\""+jixing+"\" readonly='readonly' /> "+
							"</td> " +	
							"<td> " +
								" <input type=\"text\" style=\"width:60px;\" value=\""+j.guige+"\" name=\""+guige+"\" id=\""+guige+"\" readonly='readonly'/> "+
							"</td> " +	
							"<td> " +
								" <input type=\"text\" style=\"width:80px;\"  value=\""+j.shuliang+"\"  name=\""+shuliang+"\" id=\""+shuliang+"\" readonly='readonly'/> "+
							"</td> " +	
							"<td> " +
								" <input type=\"text\" style=\"width:80px;\" value=\""+j.shuliang+"\"  onchange=\"countQuantity('"+shuliang+"','"+hegeshuliang+"','"+buhegeshu+"','"+hegeshuliang+"')\"  name=\""+hegeshuliang+"\" id=\""+hegeshuliang+"\" readonly='readonly' /> "+
							"</td> " +	
							"<td> " +
							" <input type=\"text\" style=\"width:80px;\" value=\""+j.shengchanpihao+"\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" readonly='readonly'/> "+
							"</td> " +
							"<td> " +
								" <input type=\"text\" style=\"width:80px;\" value=\""+j.pizhunwenhao+"\" name=\""+pizhun+"\" id=\""+pizhun+"\" readonly='readonly'/> "+
							"</td> " +	
							"<td> " +
								" <input type=\"text\" style=\"width:100px;\" value=\""+j.shengchangqiye+"\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\" readonly='readonly'/> "+
							"</td> " +	
							"<td> " +
								" <input type=\"text\" style=\"width:93px;\" value=\""+j.shengchanriqi+"\" name=\""+shengchanriqi+"\" id=\""+shengchanriqi+"\" class=\"easyui-datebox\" data-options='disabled:true' /> "+
							"</td> " +	
							"<td> " +
								" <input type=\"text\" style=\"width:93px;\" value=\""+j.youxiaoqizhi+"\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\" data-options='disabled:true'  /> "+
							"</td> " +	
							"<td> " +
							" <input type=\"text\" style=\"width:80px;\" onchange=\"countQuantity('"+shuliang+"','"+hegeshuliang+"','"+buhegeshu+"','"+buhegeshu+"')\" value='0' name=\""+buhegeshu+"\" id=\""+buhegeshu+"\" readonly='readonly' /> "+
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
							"<td> " +
							/*"<input type=\"button\" style=\"width:50px;\" onclick=\"shanchu("+s+")\" value=\"删除\"/>"+
							"</td> " +	*/
					    	"</tbody>"
					    	);
					    	var t = document.getElementById(pinming); 
				            for(var l=0;l<t.length;l++){
				              if(j.chuzhicuoshi==trim(t.options[l].value.toString())){
				                  t.options[l].selected=true;
				              }  
				          }
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
    function changqm(s,bbbb){
		var a = s.substring(7,s.length);
	    var	quamap=bbbb;
	    var pinming = "pinming"+a;
		var jixing = "jixing"+a;
    	var guige = "guige"+a;
    	var shuliang = "shuliang"+a;
    	var hegeshuliang = "hegeshuliang"+a;
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
					$("#shengchang"+a).val(c[2]);
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
			$("#shengchang"+a).val("");
			$("#zhuceshangbiao"+a).val("");
			$("#pizhun"+a).val("");
			$("#hegezheng"+a).val("");
			$("#youxiaoqi"+a).val("");
			$("#shuliang"+a).val("");
			$("#hegeshuliang"+a).val("");
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
    	 var shengchanqiye = "shengchanqiye"+i;
    	 var shengchanpihao ="shengchanpihao"+i;
    	 var buhegeshu ="buhegeshu"+i;
    	 var buhegexiang="buhegexiang"+i;
    	 var chuzhicuoshi="chuzhicuoshi"+i;
    	 var shengchanriqi="shengchanriqi"+i;
    	 for(var j=0;j<b.length;j++){
    	 	var e = b[j].split("=");
    	 	d+="<option value=\""+e[0]+"\">"+e[1]+"</option>"; 
    	 }
    	$("#condition_table").append(" <tbody id=\""+tbody+"\" class='pn-ltbody'>  " +
    	"<td> " +
		"<input id=\""+pinming+"\"  name=\""+pinming+"\" style='width:80;'>" +
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:60px;\" name=\""+jixing+"\" id=\""+jixing+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:60px;\" name=\""+guige+"\" id=\""+guige+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:60px;\" onchange=\"findcount("+i+","+1+")\" name=\""+shuliang+"\" id=\""+shuliang+"\"  /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:60px;\" onchange=\"findcount("+i+","+2+")\" name=\""+hegeshuliang+"\" id=\""+hegeshuliang+"\" readonly='readonly' /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:80px;\" name=\""+shengchanpihao+"\" id=\""+shengchanpihao+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:80px;\" name=\""+pizhun+"\" id=\""+pizhun+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:80px;\" name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\" /> "+
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:93px;\" name=\""+shengchanriqi+"\" id=\""+shengchanriqi+"\" class=\"easyui-datebox\" data-options='disabled:true' /> "+
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:93px;\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\"  /> "+
		"</td> " +	
		"<td> " +
		" <input type=\"text\" style=\"width:60px;\" onchange=\"findcount("+i+","+3+")\" name=\""+buhegeshu+"\" id=\""+buhegeshu+"\" readonly='readonly' /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:80px;\" name=\""+buhegexiang+"\" id=\""+buhegexiang+"\" readonly='readonly' /> "+
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
			value:j.yaopinming,
			onSelect: function(rec){
		    			changqm(pinming,rec.id);
		    		}
			});
    }
    function findcount(a,one){
	    var b=$("#shuliang"+a).val();
	    var c=$("#buhegeshu"+a).val();
	    var d=$("#hegeshuliang"+a).val();
	   	if(b!="" && d !=""){
	   		var bb=$("#shuliang"+a).val();
	    	//var cc=$("#buhegeshu"+a).val();
	    	var dd=$("#hegeshuliang"+a).val();	
	    	var xx = bb-dd;	
	    //var x = b-d;
	    	$("#buhegeshu"+a).val(xx);
	    }
	    if(b!= ""  && c!=""){
	    	var bbb=$("#shuliang"+a).val();
	    	var ccc=$("#buhegeshu"+a).val(); 
	    	var xxx = bbb-ccc;
	    	$("#hegeshuliang"+a).val(xxx);
	    }
	    var bb1=$("#shuliang"+a).val();
	    var cc1=$("#buhegeshu"+a).val();
	    var dd1=$("#hegeshuliang"+a).val();
	    if($("#buhegeshu"+a).val()!=null && $("#buhegeshu"+a).val()!="" && $("#hegeshuliang"+a).val()!=null && $("#hegeshuliang"+a).val()!=""&& $("#shuliang"+a).val()!=null && $("#shuliang"+a).val()!="")
    	if(parseInt(bb1)!=parseInt(cc1)+parseInt(dd1)){
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
    
   function countQuantity(totalQuantity,quQuantity,unQuantity,type){
    	if(type === quQuantity ){
    		var total = $("#"+totalQuantity).val();
    		var qu = $("#"+quQuantity).val();
    		var un = $("#"+unQuantity).val();
    		if(typeof(total) != 'undefined' && typeof(qu) != 'undefined' && typeof(un) != 'undefined'){
    			if(parseFloat(qu)<0){
    				alert("合格数量不能小于0！");
    				$("#"+quQuantity).focus();
    			}
    			if(parseFloat(qu)>parseFloat(total)){
    				alert("合格数量不能大于总数量！");
    				$("#"+quQuantity).focus();
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

