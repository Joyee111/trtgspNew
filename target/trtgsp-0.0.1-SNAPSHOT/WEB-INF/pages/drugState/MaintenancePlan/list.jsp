<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="养护计划" />
</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
</script>
 <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript"
	src="/zywx3/ext/scripts/user/selectarea.js">
</script>
<script type="text/javascript">
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/drugState/inspectionRecords/add.html";
    	form.submit();
    }
    $(function(){
    	$("#startDate").datebox({
    		onSelect:function(date){
    			//alert(date);
    			var startDate=$("#startDate").datebox("getValue");
    			var endDate = $("#endDate").datebox("getValue");
    			
    			if(typeof(endDate)!=undefined && endDate!=""){
    				if(startDate > endDate){
    					alert("起始时间不能大于结束时间");
    				}
    			}
    			
    		}
    	});
    	$("#endDate").datebox({
    		onSelect:function(date){
    			//alert(date);
    			var startDate = $("#startDate").datebox("getValue");
    			var endDate = $("#endDate").datebox("getValue");
    		
    			if(typeof(startDate)!=undefined && startDate!=""){
    				if(startDate > endDate){
    					alert("结束时间不能大于开始时间");
    				}
    			}
    			
    		}
    	});
    });
</script>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;养护计划</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="list.html" method="post">
				时间范围：<input type="text" id="startDate" name="startDate" value="${startDate}" class="easyui-datebox text" style="height: 28px;"/>&nbsp;--至--
				<input type="text" id="endDate" name="endDate" value="${endDate}" class="easyui-datebox text1" style="height: 28px;">
				&nbsp;&nbsp;批号：<input type="text" class="text1" size="25" name="batchNumber" value="" />
				<input type="submit" name="submit_button" id="submit_button" class="btn_big" value="查询" />
			</form>
		</div>
	</div>
<form action="" id="recordsss" method="post" >
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input type="hidden" name="yhDate" id="yhdate" value="${yhDate}" >
		<input type="hidden" name="ypname" id="ypname" value="${ypname}" />
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table_yh" export="true" size="${resultSize}" partialList="true">
		<c:choose>
			<c:when test="${records.color =='1'}">
				<display:column property="qualityMidicine.commonname" escapeXml="true" sortable="true" titleKey="通用名称" />
				<display:column property="qualityMidicine.dosageforms.formName"  escapeXml="true" sortable="true" titleKey="剂型"/>
				<display:column property="quantity"  escapeXml="true"  sortable="true" titleKey="数量"></display:column>
				<display:column property="batchproduction"  escapeXml="true"  sortable="true" titleKey="生产批号"></display:column>
				<display:column property="validdate"  escapeXml="true" sortable="true" titleKey="有效期至"></display:column>
				<display:column property="nextmaintaindate"  escapeXml="true"  sortable="true" titleKey="下一个养护日期"></display:column>
			</c:when>
			<c:when test="${records.color =='2'}">
				<display:column property="qualityMidicine.commonname" style="color:#a87122"  escapeXml="true" sortable="true" titleKey="通用名称" />
				<display:column property="qualityMidicine.dosageforms.formName" style="color:#a87122"  escapeXml="true" sortable="true" titleKey="剂型"/>
				<display:column property="quantity"  escapeXml="true" style="color:#a87122" sortable="true" titleKey="数量"></display:column>
				<display:column property="batchproduction"  escapeXml="true"  style="color:#a87122"  sortable="true" titleKey="生产批号"></display:column>
				<display:column property="validdate"  escapeXml="true" style="color:#a87122" sortable="true" titleKey="有效期至"></display:column>
				<display:column property="nextmaintaindate"  escapeXml="true" style="color:#a87122" sortable="true" titleKey="下一个养护日期"></display:column>
			</c:when>
		</c:choose>
		<display:column titleKey="user.operate" autolink="true" media="html">
		<img src="../../images/edit.gif"/><a href="${ctx}/drugState/MaintenancePlan/add.html?method=add&id=<c:out value="${records.id}"/>&thispage=${thispage}">
			<fmt:message key="生成养护检查记录"/>
		</a>
	</display:column>
	</display:table>
	</div>
</form>
