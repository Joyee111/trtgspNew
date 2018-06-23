<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title>出库复核新增</title>
    <meta />
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</head>
<!-- <table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
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
                <br />已驳回
            </td>
            <td valign="top" align="center" width="20%">
            	<span>5</span>
                <br />审核通过
            </td>
            <td align="right" width="5"><img src="../../images/lch_r.gif" /></td>
          </tr>
        </table> -->
<div class="box_big">
<form method="post" action="dlrsave.html" id="res">
<input type="hidden" name="id" value="${id}"/>
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" id="quamap" value = "${quamap}" />
<div class="ceng_mar5" style="padding-bottom:5px;">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
	<tr>
		<th width="150">购货单位<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
		<input type="text" name="qualifiedPurchaseUnitsIdName" id="qualifiedPurchaseUnitsIdValue" readonly="readonly" class="text1" size="40"/>
		<input type="hidden" id="qualifiedPurchaseUnitsId" name="qualifiedPurchaseUnitsId" />
		</td>
		<th width="150">票号<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
		<input type="text" class="easyui-combobox  text1" data-options="
		 required:true,
      	 	valueField: 'id',
       		textField: 'text'
			" name="salesNumber" id="salesNumber" size="40"/>
		</td>
	</tr>
	<tr>
	
	<th width="150">销售日期<span class="required">*</span>：</th>
	<td>
		<input type="text" data-options="required:true,validType:'checkDate',disabled:true" class="easyui-datebox text1" name="saleTime"  id="saleTime" size="40"/>
	</td>
	<!-- <th>出库日期<span class="required">*</span>：</th>
	<td>
		<input type="text" name="outLibraryDate" class="easyui-datebox text1" data-options="required:true" id="outLibraryDate" size="40" >
	</td> -->
	<th>合同号<span class="required">*</span>:</th>
	<td><input name="salesFromNumber" id="salesFromNumber" type="text" class="text1" size="40" readonly="readonly"/></td>
	</tr>
	<!-- <tr>
	<th width="150">质量状况<span class="required">*</span>：</th>
		<td>
		<select name="qualitySituation" id="qualitySituation" class="easyui-validatebox text1" data-options="required:true">
		<option value="1" >合格</option>
		<option value="2" >不合格</option>
		</select>
		</td>
	</tr>
	<tr>
		
	</tr>
	<tr>
	<th valign="top">备注</th>
	 <td colspan="3">
		<textarea type="" name="remark" id="remark"    cols="94" rows="4" class="textarea" ></textarea>
	</td>
	</tr> -->
</table>
<table  class="table" id="condition_table"  border="0" cellpadding="0" cellspacing="1" width="98%" align="center">
	<thead>
	 <tr>
	 	<th>通用名称</th><th>剂型</th><th>规格</th> <th>数量</th><th>生产批号</th><th>批准文号</th><th>生产企业</th><th>有效期至</th><!-- <th>操作</th>  -->
	  </tr>
	 </thead>
</table>
<table>
	<tr align="center">
		<td colspan="4">
			<!-- <input type="button" class="btn_big" name="cancel" onclick="addyp();" value="<fmt:message key="新增药品"/>"/> 
			<input type="button" class="btn_big" name="save" onclick="savess(0);" value="<fmt:message key="button.save"/>"/>-->
			<input type="button" class="btn_big" name="save" onclick="savess(1);" value="提交"/>
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
		for(var s=0; s<jsons.length; s++)  {
				i++;
		 		var j = jsons[s];
		        var pinming = "pinming"+s;
		       // alert(pinming);
		        //alert(pingming);
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
		    	var tbody="tbody"+s;
		    	$("#saleTime").datebox('setValue',j.xiaoshouriqi);
		    	$("#qualifiedPurchaseUnitsIdValue").val(j.gouhuodanwei);
		    	$("#qualifiedPurchaseUnitsId").val(j.gouhuodanweiId);
		    	$("#salesFromNumber").val(j.salesFromNumber);
		        $("#condition_table").append(" <tbody id=\""+tbody+"\"  class='pn-ltbody'>  " +
		    	"<td> " +
				"<input id=\""+pinming+"\"  name=\""+pinming+"\" >" +
				"</td> " +
				"<td> " +
					" <input type=\"text\" style=\"width:50px;\" value=\""+j.jixing+"\" name=\""+jixing+"\" id=\""+jixing+"\" readonly='readonly'/> "+
				"</td> " +	
				"<td> " +
					" <input type=\"text\" style=\"width:100px;\" value=\""+j.guige+"\" name=\""+guige+"\" id=\""+guige+"\" readonly='readonly' /> "+
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
					//alert(pinming)
	      			changqm($(this).attr("id"),rec.id);
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
   
 });     
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
    function submits(value){
	   var form = document.getElementById("res");
    	document.getElementById("submitType").value="1";
    	form.submit();
    }
    function changqm(str,aaaa){
    	//alert(str);
		var a = str.substring(7,str.length);
		//alert(a);
	    var	quamap=aaaa;
	    var pinming = "pinming"+a;
		var jixing = "jixing"+a;
    	var guige = "guige"+a;
    	var shuliang = "shuliang"+a;
    	var pizhun = "pizhun"+a;
    	var youxiaoqi = "youxiaoqi"+a;
    	var hegezheng = "hegezheng"+a;
    	var zhuceshangbiao = "zhuceshangbiao"+a;
    	var shengchanqiye = "shengchanqiye"+a;
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
    	 var shengchang = "shengchang"+i;
    	 var pizhun = "pizhun"+i;
    	 var youxiaoqi = "youxiaoqi"+i;
    	 var tbody="tbody"+i;
    	 var hegeshuliang="hegeshuliang"+i;
    	 var hegezheng = "hegezheng"+i;
    	 var zhuceshangbiao = "zhuceshangbiao"+i;
    	 var shengchanqiye = "shengchanqiye"+i;
    	 var shengchanpihao = "shengchanpihao"+i;
    	 var xiaoshouriqi ="xiaoshouriqi"+i;
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
			" <input type=\"text\" style=\"width:100px;\"  name=\""+shengchanqiye+"\" id=\""+shengchanqiye+"\" /> "+
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+youxiaoqi+"\" id=\""+youxiaoqi+"\" class=\"easyui-datebox\" /> "+
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

