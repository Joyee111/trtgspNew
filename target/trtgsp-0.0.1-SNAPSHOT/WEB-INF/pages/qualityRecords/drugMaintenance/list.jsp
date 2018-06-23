<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="药品养护" />
</title>

</head>
<script type="text/javascript">
	function check(){
		alert(1);
	}
	function onDelete(){
		var from =document.getElementById("records");
		var r=confirm("是否确认删除！");
		if(r){
			from.action="${ctx}/qualityRecords/drugMaintenance/del.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/qualityRecords/drugMaintenance/add.html";
    	form.submit();
    }
	
	function deletess(a){
		var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	from.action="${ctx}/qualityRecords/drugMaintenance/del.html";
	    	from.submit();
    	}else{
			return;
		}
	}
	
</script>

<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">质量记录管理&nbsp;>&nbsp;药品养护</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				<label for="maintaindate">养护日期:</label>
				<input type="text"  class="easyui-datebox text1" name="maintaindate" id="maintaindate" value="${maintaindate}">
				<label for="pinming">通用名称:</label>
				<input type="text" name="pinming" id="pinming" value="${pinming}" class="text1"/>
				<input type="submit" class="btn_big" value="查询"/> 
			</form>
		</div>
	</div>
	
		
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}'  onclick='checkAll(\"ids\")' />全选" media="html"><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="qualifiedmedcstoreRe.qualityMidicine.medicinalNo" sortable="true" titleKey="货号"  maxLength="15"/>
				<display:column property="qualifiedmedcstoreRe.qualityMidicine.commonname" sortable="true" titleKey="通用名称"  maxLength="15"/>
		<display:column property="qualifiedmedcstoreRe.qualityMidicine.dosageforms.formName"  escapeXml="true" sortable="true" titleKey="剂型"  style="width:15%;"></display:column>
		<display:column property="qualifiedmedcstoreRe.qualityMidicine.specifications"  escapeXml="true" titleKey="规格"></display:column>
		<display:column property="qualifiedmedcstoreRe.qualityMidicine.licensenumber"  escapeXml="true" titleKey="批准文号"></display:column>
		<display:column property="qualifiedmedcstoreRe.qualityMidicine.produceno.customerName"  escapeXml="true" titleKey="生产厂商"></display:column>
		<display:column property="quantity"  escapeXml="true" titleKey="数量"></display:column>
			<display:column property="maintaindate"  escapeXml="true" titleKey="养护日期"></display:column>
			<display:column property="batchnumber"  escapeXml="true" titleKey="批号"></display:column>
			<display:column property="user.realname"  escapeXml="true" titleKey="养护员"></display:column>
           	<display:column titleKey="user.operate" autolink="true"  style="border-right:1px solid #feb808;">
           		<img src="../../images/look.gif"/><a href="${ctx }/qualityRecords/drugMaintenance/findDrugMaintenanceRecords.html?id=${records.id}">查看变更记录</a>
                <img src="../../images/edit.gif"/><a href="${ctx}/qualityRecords/drugMaintenance/add.html?method=edit&id=<c:out value="${records.id}"/>&thispage=${thispage}">
			<fmt:message key="编辑"/>
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
	</div>
</form>
<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>
<form id="delForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" id="resId" name="ids"  value=""   />
</form>

<div class="caozuo_box2">
<input type="button" onclick="add()" value="新增" class="btn_big"/>
<c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				<input type="button" value="删除" class="btn_big" onclick="onDelete()" />
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
</div>

</div>

