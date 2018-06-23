<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title>售出退货修改</title>
    <meta />
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</head>
<script type="text/javascript">
</script>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;售出退货管理&nbsp;>&nbsp;售出退货修改</font>
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
<form method="post" action="dlrupdate.html" id="res">
<input type="hidden" name="id" value="${mc.id}"/>
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" id="quamap" value = "${quamap}" />
<div class="ceng_mar5" style="padding-bottom:5px;">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
	<tr>
	<th width="150">购货单位<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" class="easyui-combobox  text1" data-options="required:true,value:'${gouhuoshang}'" name="" id="commonnameboxs" size="40"/>
		<input type="hidden" id="qualifiedPurchaseUnitsIdValue" name="qualifiedPurchaseUnitsId" value="${mc.qualifiedPurchaseUnitsId}"/>
	</td>
	<th width="150">通用名称<span class="required">*</span>：</th>
	<td style="width:400px;">
		<input type="text" class="easyui-combobox  text1" data-options="
     	 	valueField: 'id',
      		textField: 'text',
     		url:'${ctx}/drugState/inspectionRecords/findypboxqy.html',
     		value:'${mc.qualifiedMedicineId}',
     		onSelect: function(rec){
     			change(rec.id);
     		}
		" name="qualifiedMedicineId" id="caigoudan" size="40"/>&nbsp;&nbsp;
	</td>
	</tr>
	<tr>
	<th width="150">剂型：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="jixing" id="jixing" value="${qm.dosageforms.formName}" readonly="readonly" class="text1" size="40"/>
	</td>
	<th width="150">规格：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="guige" id="guige" value="${qm.specifications}" readonly="readonly" class="text1" size="40"/>
	</td>	
	</tr>
	<tr>
	<th width="150">数量：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="quantity" value="${mc.quantity}" id="quantity" value="" data-options="required:true" class="easyui-validatebox text1" class="text1" size="40"/>
	</td>
	<th width="150">生产批号：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="batchNumber" value="${mc.batchNumber}" data-options="required:true" class="easyui-validatebox text1" id="batchNumber" class="text1" size="40"/>
	</td>	
	</tr>
	<tr>
	<th valign="top">退货原因：</th>
	 <td colspan="3">
		<textarea type="" name="returnReason" id="returnReason" readonly="readonly" cols="94" rows="4" class="textarea" >${mc.returnReason}</textarea>
	</td>
	</tr>
	<tr>
	<th width="150">退货类别：</th>
	 <td colspan="3">
		<input type="checkbox" name="returnType" id="returnType1" value="1" /><font style="font-size:12px; color:#727171; font-weight:bold;">经营退货</font>
		<input type="checkbox" name="returnType" id="returnType2" value="2" /><font style="font-size:12px; color:#727171; font-weight:bold;">质量退货</font>
		<input type="checkbox" name="returnType" id="returnType3" value="3" /><font style="font-size:12px; color:#727171; font-weight:bold;">是否需传回退货样品或图片传真、邮件资料</font>
		<input type="hidden" id ="returnTypeValue" name="returnTypeValue" value="${mc.returnType}" />
	</td>
	</tr>
</table>
<table>
	<tr align="center">
		<td colspan="3">
			<input type="button" class="btn_big" name="提交" onclick="savess(1)" value="<fmt:message key="提交"/>"/>
			<input type="button" class="btn_big" name="save" onclick="savess(0);" value="<fmt:message key="button.save"/>"/>
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
$("#commonnameboxs").combobox({
	filter: function(q, row){
	var opts = $(this).combobox('options');
	return row[opts.valueField].indexOf(q) >-1;
	}
});
	function savess(value){
	$("#submitType").val(value);
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
    function onCancel()
    {
    	history.go(-1);
    }
    function submits(value){
	    $("#submitType").val(value);
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
    
    function change(s){
	    if(s.value!=""){
			$.post("${ctx}/drugState/inspectionRecords/quamap.html",{
			"quamap" : s,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					$("#jixing").val(c[0]);
					$("#guige").val(c[1]);
				}else{
					return;
				}
			});
	    }else{
	    	$("#jixing").val("");
			$("#guige").val("");
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
    	var  returnValue=document.getElementById("returnTypeValue");
     	var  returnType1=document.getElementById("returnType1");
     	var  returnType2=document.getElementById("returnType2");
     	var  returnType3=document.getElementById("returnType3");
     	if(returnValue != null && ""!=returnValue){
     		var a = returnValue.value.split(",");
     		for(var i=0;i<a.length;i++){
     			if(a[i]==returnType1.value){
     				returnType1.checked=true;
     			}
				if(a[i]==returnType2.value){
     				returnType2.checked=true;
     			}
     			if(a[i]==returnType3.value){
     				returnType3.checked=true;
     			}
     		}
     		
     	}
    });
</script>

