<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>采购计划
</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
</script>
 <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript">
 function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/drugState/procurementProgram/add.html";
    	form.submit();
    }
    function changetext(){
	var year = document.getElementById("year").value;
	$("#years").val(year); 
}
function changeselect(){
	var season = document.getElementById("season").value;
	$("#seasons").val(season); 
}
function changeradio(){
	var season = document.getElementsByName("quantity");
	var strNew;
	   for(var j=0;j<season.length;j++){    
	    if(season[j].checked){   
	          strNew=season[j].value;    
        }else{
           }
       }
	$("#types").val(strNew); 
}
$(function() {
		var tt = document.getElementById("season");   
    	var jj = document.getElementById("seasons").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
		 }
	var a=$("#types").val();
	var season = document.getElementsByName("quantity");
	   for(var j=0;j<season.length;j++){ 
	    if(a==season[j].value){   
	      	season[j].checked=true;    
	      	break;
       	 }
       }
       setDefaultForRadio("department","${department}");
	});	
	function exportToExcel(){
		$("#export_purchasePlan").attr("action","exportToExcel.html");
		$("#export_purchasePlan").submit();
		$("#export_purchasePlan").attr("action","${ctx}/drugState/procurementProgram/list.html");
		//window.location.reload();
	}
</script>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;采购计划</font>
<div>
<!-- <div class="tab_con">
		<div class="caozuo_box">
			<form action="${ctx}/drugState/returnRecords/list.html" method="post" >
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				发货日期：<input name="yhDate" type="text" value="${yhDate}" />
				购货商: <input name="ypname" type="text" value="${ypname}" />
				<input type="submit" class="btn_big" value="查询"  /> 
			</form>
		</div>
</div>
 -->
 <div class="tab_con">
		<div class="caozuo_box">
			<form action="${ctx}/drugState/procurementProgram/list.html" method="post" id="export_purchasePlan" >
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				计划年份：<input name="years" type="text" value="${years}" class="text1"/>&nbsp;&nbsp;
				<!-- 计划季度: <select onchange="changeselect()" id="season" name="season">
	 			<option value="">请选择</option>
            	<option value="1">1季度</option>
				<option value="2">2季度</option>
				<option value="3">3季度</option>
				<option value="4">4季度</option>
    			</select>&nbsp;&nbsp; -->
				供货单位: <input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
      		url:'${ctx}/firstEnterprise/qualitySupplyJson.html',
      		value:'${gongyingshang}',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#qualifiedSupplierId').val(str[1]);
      		}
			" name="" id="commonnameboxs" size="40"/>&nbsp;&nbsp;
			计划类别: 
			<input type="radio" onchange="changeradio()" id="quantity1" name="quantity" value="1" /> <font style="font-size:12px; color:#727171; font-weight:bold;">正常</font>
			<input type="radio" onchange="changeradio()" id="quantity2" name="quantity" value="2" /> <font style="font-size:12px; color:#727171; font-weight:bold;">追加</font>
			<input type="radio" onchange="changeradio()" id="quantity3" name="quantity" value="3" /> <font style="font-size:12px; color:#727171; font-weight:bold;">消减</font><br/><br/>
			计划编号: <input type="text" id="plNo" name="plNo" value="${plNo}" class="text1"/>
			经营公司: 
			<input type="radio"  id="" name="department" value="1001" /> <font style="font-size:12px; color:#727171; font-weight:bold;">经营</font>
			<input type="radio"  id="" name="department" value="2001" /> <font style="font-size:12px; color:#727171; font-weight:bold;">新品</font>
			<input type="radio"  id="" name="department" value="3001" /> <font style="font-size:12px; color:#727171; font-weight:bold;">市场</font>
			<input type="submit" class="btn_big" value="查询"  /> 
			<input type="hidden" id="years" name="years" value="${years}" />
			<input type="hidden" id="seasons" name="seasons" value="${seasons}" />
			<input type="hidden" id="types" name="types" value="${types}"/>
			<input type="hidden" id="qualifiedSupplierId" name="qualifiedSupplierId" value="${qualifiedSupplierId}"/>
			</form>
		</div>
</div>
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input name="yhDate" type="hidden" value="${yhhDate}" />
	<div class="ceng_mar5">
	<display:table name="recordlist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选" media="html"><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="purchasePlan.planNo" escapeXml="true" sortable="true" titleKey="计划单号"  />
		<display:column property="purchasePlan.year" escapeXml="true" sortable="true" titleKey="年度"  />
		<display:column titleKey="计划类别">
			<c:if test="${records.planType==1}">
				<c:out value="正常"/>
			</c:if>
			<c:if test="${records.planType==2}">
				<c:out value="追加"/>
			</c:if>
			<c:if test="${records.planType==3}">
				<c:out value="消减"/>
			</c:if>
		 </display:column>
		 <display:column titleKey="经营公司">
			<c:if test="${records.purchasePlan.departmentId==1001}">
				<c:out value="经营"/>
			</c:if>
			<c:if test="${records.purchasePlan.departmentId==2001}">
				<c:out value="新品"/>
			</c:if>
			<c:if test="${records.purchasePlan.departmentId==3001}">
				<c:out value="市场"/>
			</c:if>
		 </display:column>
		 
		<display:column property="qualityMidicine.medicinalNo"  escapeXml="true" sortable="true" titleKey="货号" ></display:column>
		<display:column property="qualityMidicine.commonname"  escapeXml="true" sortable="true" titleKey="通用名称" ></display:column>
		<display:column property="qualityMidicine.specifications"  escapeXml="true" titleKey="规格"></display:column>
		<display:column property="quantity"  escapeXml="true" sortable="true" titleKey="数量(万盒)"></display:column>
		<display:column property="taxPrice"  escapeXml="true" sortable="true" titleKey="批发单价(元)"></display:column>
		<display:column property="deductionRate"  escapeXml="true" sortable="true" titleKey="扣率(%)"></display:column>
		<display:column property="money"  escapeXml="true" sortable="true" titleKey="金额(万元)"></display:column>
		
		<display:column property="qualityMidicine.supplyUnit.customerName"  escapeXml="true" sortable="true" titleKey="供货单位"></display:column>
		<display:column property="qualityMidicine.produceno.customerName"  escapeXml="true" sortable="true" titleKey="生产厂商"></display:column>
		
		<display:column property="remark"  escapeXml="true" sortable="true" titleKey="备注"></display:column>
		<display:setProperty name="export.banner" >
			<div class="exportlinks"><fmt:message key="export.banner"/></div>
		</display:setProperty> 
	</display:table>
	<input type="button" value="导出Excel" class="btn_big" style="margin-left:70px; margin-top:-21px;" onclick="exportToExcel()">
	</div>
</form>
<form id="baseForm" >

</form>
<div class="caozuo_box2">
	<shiro:hasPermission name="ProcurementPlan_add">
	 <input type="button"  value="新增" class="btn_big" onclick="add()" />
	 </shiro:hasPermission>
	</div>
</div>

