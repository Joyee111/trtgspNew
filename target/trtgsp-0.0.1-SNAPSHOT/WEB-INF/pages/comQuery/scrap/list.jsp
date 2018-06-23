<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>药品报废申请记录
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
<script>
</script>
<script type="text/javascript">
	
</script>

<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;药品报废申请记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
	<form name="query" id="query" action="list.html" method="post">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
					通用名称：<input name="ypname" type="text" value="${ypname}" class="text1">
				<input type="submit" class="btn_big"  value="查询"/> &nbsp;
			
	</form>
		</div>
	</div>		
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}'  onclick='checkAll(\"ids\")' />全选" media="html" ><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<%--<display:column property="qualifiedmedcstore.qualityMidicine.medicinalNo"  escapeXml="true" sortable="true" titleKey="药品号"></display:column>
		<display:column property="qualifiedmedcstore.qualityMidicine.commonname"  escapeXml="true" sortable="true" titleKey="品名"></display:column>
		<display:column property="qualifiedmedcstore.qualityMidicine.dosageforms.formName"  escapeXml="true" sortable="true" titleKey="剂型"  style="width:10%;"></display:column>
		<display:column property="qualifiedmedcstore.qualityMidicine.specifications"  escapeXml="true" titleKey="规格"></display:column>
		<display:column property="qualifiedmedcstore.qualityMidicine.licensenumber"  titleKey="批号" autolink="true" media="html" style="border-right:1px solid #feb808;"></display:column>
			<display:column property="qualifiedmedcstore.qualityMidicine.unit"  escapeXml="true" titleKey="单位"></display:column>
			<display:column property="quantity"  escapeXml="true" titleKey="数量"></display:column>
			<display:column property="qualifiedmedcstore.validdate"  escapeXml="true" titleKey="有效期至"></display:column>
			<display:column property="qualifiedmedcstore.qualityMidicine.produceno.customerName"  escapeXml="true" titleKey="生产厂商"></display:column>
			<display:column property="qualifiedmedcstore.qualityMidicine.supplyUnit.customerName"  escapeXml="true" titleKey="供货单位"></display:column>
			<display:column property="scrapReason"  escapeXml="true" titleKey="申请原因"></display:column>--%>
			
			
			
			
			
			<display:column property="medicinalNo"  escapeXml="true" sortable="true" titleKey="药品号"></display:column>
		    <display:column property="commonname"  escapeXml="true" sortable="true" titleKey="品名"></display:column>
		    <display:column property="formName"  escapeXml="true" sortable="true" titleKey="剂型"  style="width:10%;"></display:column>
		    <display:column property="specifications"  escapeXml="true" titleKey="规格"></display:column>
		    <display:column property="batchno"  titleKey="批号" autolink="true" media="html" style="border-right:1px solid #feb808;"></display:column>
			<display:column property="unit"  escapeXml="true" titleKey="单位"></display:column>
			<display:column property="quantity"  escapeXml="true" titleKey="数量"></display:column>
			<display:column property="validdate"  escapeXml="true" titleKey="有效期至"></display:column>
			<display:column property="customerName1"  escapeXml="true" titleKey="生产厂商"></display:column>
			<display:column property="customerName2"  escapeXml="true" titleKey="供货单位"></display:column>
			<display:column property="scrapReason"  escapeXml="true" titleKey="申请原因"></display:column>
			<display:column property="applyTime"  escapeXml="true" titleKey="申请时间" format="{0,date,dd-MM-yyyy}"></display:column>
				<%--<display:column property="qualifiedmedcstore.receivedDate"  escapeXml="true" titleKey="收货日期"></display:column>--%>
           	<display:column titleKey="user.operate" autolink="true"  style="border-right:1px solid #feb808;">
               <img src="../../images/edit.gif"/><a href="${ctx}/comQuery/scrap/view.html?id=<c:out value="${records.id}"/>&thispage=${thispage}">
			<fmt:message key="查看"/>
		</a>
	</display:column>
	</display:table>
	</div>
</form>
</div>








