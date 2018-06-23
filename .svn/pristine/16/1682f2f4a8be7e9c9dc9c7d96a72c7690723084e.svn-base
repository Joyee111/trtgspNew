<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>购进退出录入
</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
</script>
 <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/ext/styles/display/display.css'/>" />
     <link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/themes/default/easyui.css"> 
 <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/ext/scripts/user/selectarea.js'/>"></script>
<script>
</script>
<script type="text/javascript">
	function onDelete(){
		var from =document.getElementById("recordsss");
		var r=confirm("是否确认删除！");
		if(r){
			from.action="${ctx}/drugState/purreturn/dlrdel.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/drugState/purreturn/dlradd.html";
    	form.submit();
    }
	function deletess(a){
	var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	from.action="${ctx}/drugState/purreturn/dlrdel.html";
	    	from.submit();
    	}else{
			return;
		}
	}
	$(function(){
		setDefaultForRadio("department","${department}");
	})
/**	function exportExcel(){
    	var  checkBox = document.getElementsByName("ids");
    	var  value = "";
    	for(var i=0,n=checkBox.length;i<n;i++){
    		var obj = checkBox[i];
    		if(obj.checked==true){
    			value =obj.value;
    			
    		}
    	}
    	//alert(value);
    	$("#purchaseReturnId").val(value);
    	if($("#purchaseReturnId").val()=="" || $("#purchaseReturnId").val()==null){
    		alert("请选择要导出的入库单！");
    		return;
    	}
    	$("#export_form").attr("action","../..//ireport/exportPurchaseReturnToExcel.html");
    	$("#export_form").submit();
		
	}
	function checkSelect(){
    	var  checkBox = document.getElementsByName("ids");
    	var index = 0;
    	for(var i=0,n=checkBox.length;i<n;i++){
    		var obj = checkBox[i];
    		if(obj.checked==true){
    			index++;
    			if(index>1){
    				alert("您最多只能选中一条记录进行导出！");
    				obj.checked=false;
    				return;
    			}
    		}
    	}
    	
    }*/
</script>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;购进退出管理&nbsp;>&nbsp;购进退出录入</font>
<div class="tab_con">
	<div class="caozuo_box">
		<form action="${ctx}/drugState/purreturn/dlrlist.html" method="post" >
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
			通用名称：<input name="yhdate" type="text" value="${yhDate}" class="text1"/>
			供货单位: <input name="ypname" type="text" value="${ypname}" class="text1"/>
			退出日期: <input name="returnTime" type="text" value="${returnTime}" class="easyui-datebox text1" />
			批号: <input name="batchNumber" type="text" value="${batchNumber}" class="text1"/>
			<br>
			<br>
			
			经营公司：&nbsp;经营&nbsp;<input type="radio" name="department" value="1001"/>
			&nbsp;新品&nbsp;<input type="radio" name="department" value="2001"/>
			&nbsp;市场&nbsp;<input type="radio" name="department" value="3001"/>	
				
		
			<input class="btn_big" type="submit" value="查询"  /> 
		</form>
	<!-- 	<form id = "export_form" target="_blank" >
				<input type="hidden" name="id" id="purchaseReturnId">
				<input class="btn_big" type="submit" value="打印入库负票"  onclick="exportExcel()"/> 
		</form>  -->
	</div>
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input name="yhdate" type="hidden" value="${yhDate}" />
		<input name="ypname" type="hidden" value="${ypname}" />
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选"><input type="checkbox" name="ids" value="${records.id}" onclick="checkSelect()" ></display:column>
		<display:column  escapeXml="true" sortable="true" titleKey="经营公司">
			<c:choose>
				<c:when test="${records.qualityMidicine.departmentId eq '1001'}">
					<c:out value="经营"></c:out>
				</c:when>
				<c:when test="${records.qualityMidicine.departmentId eq '2001'}">
					<c:out value="新品"></c:out>
				</c:when>
				<c:when test="${records.qualityMidicine.departmentId eq '3001'}">
					<c:out value="市场"></c:out>
				</c:when>
			</c:choose>
		</display:column>
		<display:column property="qualityMidicine.commonname" escapeXml="true" sortable="true" titleKey="通用名称"/>
		<display:column property="qualifiedSuppliers.customerName"  escapeXml="true" sortable="true" titleKey="供货单位"></display:column>
		<display:column property="qualityMidicine.medicinalNo" escapeXml="true" sortable="true" titleKey="药品号"/>
		<display:column property="qualityMidicine.dosageforms.formName"  escapeXml="true" sortable="true" titleKey="剂型"></display:column>
		<display:column property="qualityMidicine.specifications" escapeXml="true" sortable="true" titleKey="规格"/>
		<display:column property="qualityMidicine.unit"  escapeXml="true" sortable="true" titleKey="单位"></display:column>
		<display:column property="puMoney" escapeXml="true" sortable="true" titleKey="购进价格"/>
		<display:column property="quantity"  escapeXml="true" sortable="true" titleKey="退出数量"></display:column>
		<display:column property="money" escapeXml="true" sortable="true" titleKey="退出金额"/>
		<display:column property="batchNumber"  escapeXml="true" sortable="true" titleKey="批号"></display:column>
		<display:column property="qualityMidicine.produceno.customerName"  escapeXml="true" sortable="true" titleKey="供货单位"></display:column>
		<display:column property="endTime"  escapeXml="true" sortable="true" titleKey="有效期至"></display:column>
		<display:column property="returnReason"  escapeXml="true" sortable="true" titleKey="退货原因" ></display:column>
		<display:column property="user.realname"  escapeXml="true" titleKey="采购员"></display:column>
		<display:column  escapeXml="true" titleKey="库房标识">
		    <c:choose>
				<c:when test="${records.state eq 'a'}">
					<c:out value="合格"></c:out>
				</c:when>
				<c:when test="${records.state eq 'd'}">
					<c:out value="不合格"></c:out>
				</c:when>
				<c:when test="${records.state eq 'c'}">
					<c:out value="报废"></c:out>
				</c:when>
			</c:choose>         
		</display:column>
		<display:column titleKey="user.operate" autolink="true" media="html">
		<img src="../../images/look.gif"/>
		<a href="findPurchaseRetuenBillRecords.html?id=${records.id}">查看修改记录</a>
		<img src="../../images/edit.gif"/><a href="${ctx}/drugState/purreturn/dlredit.html?id=<c:out value="${records.id}"/>&thispage=${thispage}">
			<fmt:message key="button.update"/>
		</a>
		<c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				<a onclick="deletess(<c:out value="${records.id}"/>)">
					<fmt:message key="删除"/>
				</a>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
			
	</display:column>
	</display:table>
</form>
<form id="baseForm" method="post">
	<input type="hidden" name="thispage" value="${thispage}" />
</form>
<form id="delForm" method="post">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" id="resId" name="ids"  value=""   />
</form>
	<div class="caozuo_box2">
        <input name="" type="button" onclick="add()"  class="btn_big" value="购进退出制单"/>
        <c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				<input name="" type="button" onclick="onDelete()" class="btn_big" value="删除"/>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
        
    </div>
</div>
