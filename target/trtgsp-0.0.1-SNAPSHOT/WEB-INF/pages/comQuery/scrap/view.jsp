<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="药品报废申请记录"/></title>
    <meta />
</head>
<form commandName="um" method="post" action="" id="drs">  
<input type="hidden" name="method" value="${method}" />
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" name="id" value="${um.id}" />
<input type="hidden" name="shuliang" id="shuliang"  value="${um.quantity}" />
<input type="hidden" name="qpihao" id="qpihao"  value="${um.batchno}" />
<input type="hidden" name="qbhgQuantity" id="qbhgQuantity"  value="${qbhgQuantity}" />
<input type="hidden" name="qhgQuantity" id="qhgQuantity"  value="${qhgQuantity}" />
<input type="hidden" name="batchno2" id="batchno2"  />
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">	
    <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;药品报废申请记录&nbsp;>&nbsp;查看</font>
	
	<tr>
	<th width="150">生产批号<span class="required">*</span>：</th>

		<td class="left" style="width:350px;">
		<input id="batchno"  class="easyui-validatebox text1" data-options="" value="${um.batchno}"  readonly="readonly"size="40" />
		<input type="hidden" name="batchno" id="batchnoValue" value="${um.batchno}"/>
	</td>
	<th width="150">数量<span class="required">*</span>：</th>
	<td>
		<input  readonly="readonly"type="text"  name="quantity" id="quantity"  value="${um.quantity}"  class="easyui-validatebox text1"  data-options=" validType:'checkInt'" size="40" maxlength="20"/>
		
	</td>
		
	</tr>
	<tr>
     	<th width="150">通用名称<span class="required">*</span>：</th>
		<td style="width:400px;">
			<input  readonly="readonly" type="text" class="easyui-validatebox  text1" value="${qm.commonname}"
			" name="commonname" id="commonName" size="40"/>&nbsp;&nbsp;
			<input type="hidden" name="qualifiedmedicineid"  id="qualifiedMedicineId"  value="${um.qualifiedmedicineid}"/>
		</td>
	<th width="150">药品编号<span class="required">*</span>：</th>
	<td>
		<input  readonly="readonly" type="text" name="medicinalNo" id="medicinalNo" class="easyui-validatebox text1" data-options=" " size="40" value="${um.medicinalNo}"  />
	</td>
	</tr>
	<tr>
		<th width="150">剂型<span class="required">*</span>：</th>
	<td>
		<input readonly="readonly" type="text" name="qualityMidicine.dosageforms.formName" id="dosageforms"  value="${qm.dosageforms.formName}" class="easyui-validatebox text1" size="40"/>
	</td>
		<th width="150">规格<span class="required">*</span>：</th>
	<td>
		<input readonly="readonly" type="text" name="specifications" id="specifications"  value="${qm.specifications}" class="easyui-validatebox text1"  size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">生产厂家<span class="required">*</span>：</th>
	<td>
		<input readonly="readonly" type="text" name="qualityMidicine.produceno.customerName" id="produceno" value="${qm.produceno.customerName}" class="easyui-validatebox text1"  size="40"/>
	</td>
	<th>供货单位<span class="required">*</span>：</th>
	<td>
		<input readonly="readonly" type="text" name="qualityMidicine.supplyUnit.customerName" id="customerName"  value="${qm.supplyUnit.customerName}" class="easyui-validatebox text1" size="40"/>
		
	</td>
	
	</tr>	
	
	
		<tr>
	<th width="150">收货日期<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input disabled="disabled" type="text" name="shipmentdate" id="shipmentdate"  value="${um.shipmentdate}"  class="easyui-datebox text1" data-options=" "  style="width:260px"  />
	</td>
		<th width="150">收货凭证号<span class="required">*</span>：</th>
	<td>
		<input readonly="readonly" type="text" name="harvestNumber" id="harvestNumber"  value="${um.harvestNumber}"  class="easyui-validatebox text1"  data-options=" validType:'checkInt'" size="40" maxlength="20"/>
	</td>
	</tr>	
		<tr>
	<th width="150">不合格项<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input readonly="readonly" type="text" name="unqualified" id="unqualified"  value="${um.unqualified}"  class="easyui-validatebox text1" data-options=" "  style="width:260px"  />
	</td>
		<th width="150">处理单号<span class="required">*</span>：</th>
	<td>
		<input readonly="readonly" type="text" name="processingNo" id="processingNo"  value="${um.processingNo}"  class="easyui-validatebox text1"  data-options=" validType:'checkInt'" size="40" maxlength="20"/>
	</td>
	</tr>	
			<tr>
	<th width="150">处理日期<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input disabled="disabled" type="text" name="processingDate" id="processingDate" value="${um.processingDate}"   class="easyui-datebox text1" data-options=" "  style="width:260px"  />
	</td>
	
	<th>有效期至<span class="required">*</span>：</th>
		<td>
		<input disabled="disabled" type="text" name="validUntil" id="validUntil" class="easyui-datebox text1" data-options="required:true" value="${um.validUntil}" style="width:260px"/>
		</td>
	</tr>
	<tr>
	  <th width="150">财损<span class="required">*</span>：</th>
      <td>
      <input type="text"  name="lossProperty" id="lossProperty"  value="${um.lossProperty}"  class="easyui-validatebox text1"  data-options="required:true,validType:'checkInt'" size="40" maxlength="20"/>
      </td>
	</tr>	
		  <tr>
            <th valign="top">质量情况：</th>
            <td colspan="3"><textarea readonly="readonly" name="qualitysituation" id="qualitysituation" cols="99" rows="4" class="easyui-validatebox  textarea"  >${um.qualitysituation}</textarea></td>
      </tr>
        <tr>
            <th valign="top">处理结果：</th>
            <td colspan="3"><textarea readonly="readonly" name="result" id="result" cols="99" rows="4" class="easyui-validatebox  textarea"  >${um.result}</textarea></td>
      </tr>
       <tr>
            <th valign="top">备注：</th>
            <td colspan="3"><textarea readonly="readonly" name="remark" id="remark" cols="99" rows="4" class="easyui-validatebox  textarea"  >${um.remark}</textarea></td>
      </tr>
      <tr>
            <th valign="top">申请原因：</th>
            <td colspan="3"><textarea readonly="readonly" name="scrapReason" id="scrapReason" cols="99" rows="4" class="easyui-validatebox  textarea"  >${um.scrapReason}</textarea></td>
      </tr>
	
</table>
<table>
	<tr align="center">
		<td colspan="4">
				
			<input type="button" class="btn_big" name="cancel" onclick="onCancel();" value="返回"/>
		</td>
	</tr>
</table>

<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
</form>

<script type="text/javascript">
$("#commonnamebox").combobox({
			filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q) > -1;
	}
		})
    function onCancel()
    {
    	history.go(-1);
    }
       
</script>

