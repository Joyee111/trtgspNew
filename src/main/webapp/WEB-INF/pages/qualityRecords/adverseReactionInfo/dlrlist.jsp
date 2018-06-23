<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="不良反应" />
</title>
</head>
<script type="text/javascript">
	function check(){
		alert(1);
	}
	function onDelete(){
		var from =document.getElementById("recordsss");
		var r=confirm("是否确认删除！");
		if(r){
			from.action="${ctx}/qualityRecords/adverseReactionInfo/dlrdel.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/qualityRecords/adverseReactionInfo/dlradd.html";
    	form.submit();
    }
	function deletess(a){
	var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	from.action="${ctx}/qualityRecords/adverseReactionInfo/dlrdel.html";
	    	from.submit();
    	}else{
			return;
		}
	}
</script>

   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">质量记录管理&nbsp;>&nbsp;不良反应</font>               
<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				 <label for="handperson">不良反应名称:</label>
				<input type="text" name="name" id="name" value="${name}" class="text1">
				<label for="handoverdate">发生时间:</label>
				<input type="text" class="easyui-datebox text1" name="occurrenceDate" id="occurrenceDate" value="${occurrenceDate}">
				<input type="submit" class="btn_big" value="查询"  /> 
			</form>
		</div>
</div>
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
	<display:table name="recordlist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选" media="html" ><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="name" escapeXml="true" sortable="true" titleKey="不良反应名称" />
		<display:column property="occurrenceDate" escapeXml="true" sortable="true" titleKey="发生时间"/>
		<display:column property="medicalRecordNo"  escapeXml="true" sortable="true" titleKey="病历号/医院名称"></display:column>
		<display:column property="adverseReactionResult"  escapeXml="true" sortable="true" titleKey="不良反应结果"  style="width:15%;"></display:column>
		<display:column property="originalDisease"  escapeXml="true" titleKey="原患疾病"></display:column>
		<display:column property="patientName"  titleKey="患者名称" autolink="true" media="html" style="border-right:1px solid #feb808;"></display:column>
		<display:column property="phone" escapeXml="true" sortable="true" titleKey="联系方式"></display:column>
		<display:column titleKey="user.operate" autolink="true"  style="border-right:1px solid #feb808;">
		<img src="../../images/edit.gif"/><a href="${ctx}/qualityRecords/adverseReactionInfo/dlredit.html?id=<c:out value="${records.id}"/>&thispage=${thispage}">
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
        <input name="" type="button" onclick="add()"  class="btn_big" value="新增"/>
        <c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				  <input name="" type="button" onclick="onDelete()" class="btn_big" value="删除"/>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
      
    </div>
</div>
