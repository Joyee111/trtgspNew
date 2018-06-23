<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="设备运行" />
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
			from.action="${ctx}/qualityRecords/euqipmentOperation/del.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/qualityRecords/euqipmentOperation/add.html";
    	form.submit();
    }
	
	function deletess(a){
		var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	from.action="${ctx}/qualityRecords/euqipmentOperation/del.html";
	    	from.submit();
    	}else{
			return;
		}
	}
	
</script>

<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">质量记录管理&nbsp;>&nbsp;设备运行</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				<label for="handperson">交班人:</label>
				<input type="text" name="handperson" id="handperson" value="${handperson}" class="text1">
				<label for="handoverdate">交接日期:</label>
				<input type="text" class="easyui-datebox text1"  name="handoverdate" id="handoverdate" value="${handoverdate}">
				<input type="submit" class="btn_big" value="查询"/> 
			</form>
		</div>
	</div>	
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}'  onclick='checkAll(\"ids\")' />全选" media="html" ><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="handoverdate" sortable="true" titleKey="交接日期 "  maxLength="15"/>
		<display:column property="handperson"  escapeXml="true" sortable="true" titleKey="交班人"></display:column>
		<display:column property="receiveperson"  escapeXml="true" sortable="true" titleKey="接班人"  style="width:15%;"></display:column>
		<display:column property="runtime"  escapeXml="true" titleKey="运行时间"></display:column>
       <display:column property="downtimehours"  escapeXml="true" titleKey="故障停机（小时）"></display:column>
		

			<display:column property="isreport"  escapeXml="true" titleKey="是否上报"></display:column>
			<display:column property="istroubleclear"  escapeXml="true" titleKey="故障是否排除"></display:column>
           	<display:column titleKey="user.operate" autolink="true" style="border-right:1px solid #feb808;">
                <img src="../../images/edit.gif"/><a href="${ctx}/qualityRecords/euqipmentOperation/add.html?method=edit&id=<c:out value="${records.id}"/>&thispage=${thispage}">
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
<input type="button" onclick="add()" class="btn_big" value="新增"/>
	<c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				 <input type="button" value="删除" class="btn_big" onclick="onDelete()" />
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
	
	 
</div>	


</div>

