<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="药品质量查询" />
</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>

<script type="text/javascript">
	function check(){
		alert(1);
	}
	function onDelete(){
		var from =document.getElementById("records");
		var r=confirm("是否确认删除！");
		if(r){
			from.action="${ctx}/qualityRecords/qualityQuery/del.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/qualityRecords/qualityQuery/add.html";
    	form.submit();
    }
	
	function deletess(a){
		var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	from.action="${ctx}/qualityRecords/qualityQuery/del.html";
	    	from.submit();
    	}else{
			return;
		}
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

<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;药品质量查询</font>
	<div class="tab_con">
		<div class="caozuo_box">
	<form name="query" id="query" action="query.html" method="post">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<label for="inquiryunit">查询单位:</label>
		<input type="text" name="inquiryunit" id="inquiryunit" value="${inquiryunit}" class="text1">
		<label for="pinming">通用名称:</label>
		<input type="text" name="pinming" id="pinming" value="${pinming}" class="text1"/>
		查询时间：<input type="text" id="startDate" name="startDate" value="${startDate}" class="easyui-datebox text" style="height: 28px;"/>&nbsp;--至--
				<input type="text" id="endDate" name="endDate" value="${endDate}" class="easyui-datebox text1" style="height: 28px;">
		<input type="hidden" name="type" id="pinming" value="commonQuery" class="text1"/>
	   <input type="submit" class="btn_big"  value="查询"/> 
	</form>
		</div>
	</div>		
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}'  onclick='checkAll(\"ids\")' />全选" media="html" ><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="inquiryunit" sortable="true" titleKey="查询单位"  maxLength="15"/>
		<display:column property="qualifiedmedicineid"  escapeXml="true" sortable="true" titleKey="品名"></display:column>
		<display:column property="jixing"  escapeXml="true" sortable="true" titleKey="剂型"  style="width:15%;"></display:column>
		<display:column property="guige"  escapeXml="true" titleKey="规格"></display:column>
		<display:column property="batchproduction"  titleKey="批号" autolink="true" media="html" style="border-right:1px solid #feb808;"></display:column>
			<display:column property="quantity"  escapeXml="true" titleKey="数量"></display:column>
				<display:column property="scdw"  escapeXml="true" titleKey="生产厂商"></display:column>
				<display:column property="pihao"  escapeXml="true" titleKey="批准文号"></display:column>
				<display:column property="qualitydate"  escapeXml="true" titleKey="查询时间" decorator="com.sinosoft.util.FormatDateColumnDecorator"></display:column>
				
           	<display:column titleKey="user.operate" autolink="true"  style="border-right:1px solid #feb808;">
               <img src="../../images/edit.gif"/><a href="${ctx}/qualityRecords/qualityQuery/add.html?type=commonQuery&method=edit&id=<c:out value="${records.id}"/>&thispage=${thispage}">
			<fmt:message key="查看"/>
		</a>
		<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
		</display:setProperty> 
		<display:setProperty name="export.excel" value="true"/>
	</display:column>
	</display:table>
	</div>
</form>
</div>

