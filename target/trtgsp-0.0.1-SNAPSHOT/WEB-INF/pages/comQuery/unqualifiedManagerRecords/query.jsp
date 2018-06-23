<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="不合格品记录" />
</title>

</head>
<script type="text/javascript">
		  function find(s){
	    if(s.value!=""){
			$.post("${ctx}/qualityRecords/qualityQuery/quamap.html",{
			"quamap" : s,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					$("#dosageforms").val(c[1]);
					$("#specifications").val(c[2]);
					$("#licensenumber").val(c[3]);
					var tt = document.getElementById("quaMedicId");   
       				for(var ll=0;ll<tt.length;ll++){
        				if(c[5]==tt.options[ll].value){
            			tt.options[ll].selected=true;
		               }  
    	           }
				}else{
					return;
				}
			});
	    }else{
	    	$("#dosageforms").val("");
			$("#specifications").val("");
			$("#licensenumber").val("");
	    }
    
    }
	
</script>

<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;不合格品记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
			<label for="maintaindate">收货日期:</label>
				<input type="text"  class="easyui-datebox text1" data-options="validType:'date'" name="shouhuoriqi" id="shouhuoriqi" value="${shouhuoriqi}">
				<label for="maintaindate">通用名称:</label>
					<td style="width:400px;">
			<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
       		value:'${mingcheng}',
      		url:'${ctx}/drugState/inspectionRecords/findypboxqy.html',
      		onSelect: function(rec){
      			find(rec.id);
      		}
			" name="mingcheng" id="mingcheng" size="40"/>&nbsp;&nbsp;
		</td>
				<label for="pinming">批号:</label>
				<input type="text" name="pihao" id="pihao" value="${pihao}" class="text1">
				
				<input type="submit" value="查询" class="btn_big"/>
			</form>
		</div>
	</div>
	</div>
		
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column property="shipmentdate" sortable="true" titleKey="收货日期"  />
			<display:column property="harvestNumber" sortable="true" titleKey="收货凭证号"  />
		<display:column property="qualifiedmedcstore.qualityMidicine.medicinalNo" sortable="true" titleKey="药品编号"  />
		<display:column property="qualifiedmedcstore.qualityMidicine.commonname" sortable="true" titleKey="通用名称"  />
		<display:column property="qualifiedmedcstore.qualityMidicine.dosageforms.formName"  escapeXml="true" sortable="true" titleKey="剂型"  ></display:column>
		<display:column property="qualifiedmedcstore.qualityMidicine.specifications"  escapeXml="true" titleKey="规格"></display:column>
			<display:column property="qualifiedmedcstore.qualityMidicine.unit"  escapeXml="true" titleKey="单位"></display:column>
		<display:column property="quantity"  escapeXml="true" titleKey="数量"></display:column>
      <display:column property="batchno"  escapeXml="true" titleKey="批号"></display:column>
		<display:column property="qualifiedmedcstore.validdate"  escapeXml="true" titleKey="有效期至"></display:column>
			<display:column property="qualifiedmedcstore.qualityMidicine.supplyUnit.customerName"  escapeXml="true" titleKey="供货单位"></display:column>
		<display:column property="qualifiedmedcstore.qualityMidicine.produceno.customerName"  escapeXml="true" titleKey="生产厂商"></display:column>
		 
		<display:column property="unqualified"  escapeXml="true" titleKey="不合格项"></display:column>
		<display:column property="processingNo"  escapeXml="true" titleKey="处理单号"></display:column>
		<display:column property="processingDate"  escapeXml="true" titleKey="处理日期"></display:column>
		<display:column property="result"  escapeXml="true" titleKey="处理结果"></display:column>
		<display:column property="user.realname"  escapeXml="true" titleKey="保管员"></display:column>
		<display:column escapeXml="true" titleKey="操作员"></display:column>
			<display:column property="remark"  escapeXml="true" titleKey="备注"></display:column>
			<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
				</display:setProperty> 
				<display:setProperty name="export.excel" value="true"/>
	</display:table>
	</div>
</form>




