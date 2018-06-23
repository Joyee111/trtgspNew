<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="运输记录"/></title>
    <meta />
</head>
<script type="text/javascript">
/* function find(s){
 alert(s);
	    if(s.value!=""){
			$.post("${ctx}/qualityRecords/transportRecords/hgmap.html",{
			"hgmap" : s,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					var b = data.toString();
					var c = b.split(",");
					$("#deliverydate").val(c[0]);
					$("#deliveryaddress").val(c[1]);
					$("#receivingunit").val(c[2]);
					$("#receivingaddress").val(c[3]);
					$("#quantity").val(c[4]);
					$("#transporttype").val(c[5]);
					$("#plateno").val(c[6]);
					$("#transporterName").val(c[8]);
					$("#userName").val(c[7]);
				}else{
					return;
				}
			});
	    }else{
	    	$("#deliverydate").val("");
	    	$("#deliveryaddress").val("");
	    	
	    	$("#receivingunit").val("");
	    	$("#receivingaddress").val("");
	    	$("#quantity").val("");
	    	$("#transporttype").val("");
	    	$("#plateno").val("");
	    	$("#transporterName").val("");
	    	$("#userName").val("");
	    }
    
    }
    
   */
       

	function onCancel() {
		history.go(-1);
	}
	function save() {
		$('#drs').form('submit', {
			success : function(data) {
				var json = jsonParse(data);
				if (json.success != null && json.success != "") {
					alert(decodeURI(json.success));
				}
				location.href = "list.html";
			}
		});
	}
/*	$(function() {
		var tt = document.getElementById("transporttype");
		var jj = document.getElementById("transporttypeValue").value;
		for ( var ll = 0; ll < tt.length; ll++) {
			if (jj == tt.options[ll].value) {
				tt.options[ll].selected = true;
			}
		}
		var tt = document.getElementById("carrierunit");
		var jj = document.getElementById("carrierunitValue").value;
		for ( var ll = 0; ll < tt.length; ll++) {
			if (jj == tt.options[ll].value) {
				tt.options[ll].selected = true;
			}
		}

	});*/
</script>
<form:form commandName="tr" method="post" action="saveOrUpdata.html" id="drs">
<form:hidden path="id"/>
<input type="hidden" name="method" value="${method}" />
<input type="hidden" name="thispage" value="${thispage}" />

<div class="ceng_mar5" style="padding-bottom:5px;">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;运输记录&nbsp;>&nbsp;${titles}</font>
	<tr>
		<th width="150">派车单编号<span class="required">*</span>：</th>

	<td style="width:400px;">
		<!-- 	<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
       		value:'${tr.transportRecordsResource.id}',
      		url:'${ctx}/qualityRecords/transportRecords/findypboxqy.html',
      		onSelect: function(rec){
      			find(rec.text);
      		}
			" name="orderno" id="orderno" size="40"/>&nbsp;&nbsp; -->
			<input type="text" name="orderno" value="${tr.orderno }" class="easyui-validatebox text1" size="40">
		</td>
		<th width="150">发货时间：</th>
	<td>
		
		<input type="text"  name="deliverydate"  value="${tr.deliverydate}" class="text1"   size="40"/>
	</td>
	
		</tr>
		<tr>
			<th width="150">发货地址：</th>
	<td>
		<input type="text"  name="deliveryaddress"  value="${tr.deliveryaddress}" class="text1"   size="40"/>
	</td>
			<th width="150">委托经办人：</th>
	<td>
		<input type="text"  name="operator"  value="${tr.operator}" class="text1"  size="40"/>
	</td>
		</tr>
			

	<tr>	
	<th width="150">收货单位：</th>
	<td>
		<input type="text" name="receivingunit"  value="${tr.receivingunit }"  class="text1"   size="40"/>
	</td>
	<th width="150">收货地址：</th>
	<td>
		<input type="text" name="receivingaddress"  value="${tr.receivingaddress }"   class="text1"  size="40"/>
	</td>	
		
	</tr>
	<tr>	
	<th width="150">药品件数：</th>
	<td>
		<input type="text" name="quantity"  value="${tr.quantity }"  class="text1"  size="40"/>
	</td>
	<th width="150">运输方式：</th>
	<td>
		<input type="text" name="transporttype" value="${tr.transporttype }"   class="text1"  size="40"/>
	</td>	
	
		
	</tr>		
	<tr>	
	<th width="150">车牌号：</th>
	<td>
		<input type="text" name="plateno" value="${tr.plateno }"  class="text1"   size="40"/>
	</td>
	<th width="150">签收时间<span class="required">*</span>：</th>
	<td>
		<input type="text" name="hdtime"  value="${tr.hdtime }"  class="easyui-datebox  text1" data-options="required:true"  size="40"/>
	</td>
	<%-- 
	<th width="150">件数<span class="required">*</span>：</th>
	<td>
		<input type="text" name="quantity"  value="${tr.quantity }"  class="easyui-validatebox  text1" data-options="required:true"  size="40"/>
	</td>
	
	<th width="150">承运单位：</th>
	<td>
		<input type="text" name="carrierunit" id=carrierunit value="${tr.carrierunit }"   class="text1"  size="40"/>
	</td>	
	--%>
		
	</tr>

	<tr>	
	<th width="150">包数：</th>
	<td>
		<input type="text" name="baoshu"  value="${tr.baoshu }"  class="text1"   size="40"/>
	</td>
	<th width="150">重量：</th>
	<td>
		<input type="text" name="zhongliang"  value="${tr.zhongliang }"   class="text1"  size="40"/>
	</td>	
	
		
	</tr>
	<tr>	
	<th width="150">车次：</th>
	<td>
		<input type="text" name="checi"  value="${tr.checi }"  class="text1"   size="40"/>
	</td>
	<th width="150">运费：</th>
	<td>
		<input type="text" name="yunfei"  value="${tr.yunfei }"   class="text1"  size="40"/>
	</td>	
	
		
	</tr>
		<tr>	
	<th width="150">运输时限：</th>
	<td>
		<input type="text" name="yssx"  value="${tr.yssx }"  class="text1"   size="40"/>
	</td>
	<th width="150">签收人：</th>
	<td>
		<input type="text" name="qsr"  value="${tr.qsr }"   class="text1"  size="40"/>
	</td>	
	
		
	</tr>
	<tr>
	<th width="150">承运单位：</th>
	<td>
		<input type="text" name="carrierunit" id=carrierunit value="${tr.carrierunit }"   class="text1"  size="40"/>
	</td>
	</tr>
	
</table>
<table>
	<tr align="center">
		<td colspan="4">
				<!-- <input type="hidden"   name="id"  value="${tr.id }"/> -->
			<!-- 	<input type="button" class="btn_big"  name="" onclick="save()" value="<fmt:message key='button.save'/>"/>  -->
			<input type="button" class="btn_big" name="cancel" onclick="onCancel();" value="<fmt:message key="返回"/>"/>
		</td>
	</tr>
</table>
</div>
<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
</form:form>



