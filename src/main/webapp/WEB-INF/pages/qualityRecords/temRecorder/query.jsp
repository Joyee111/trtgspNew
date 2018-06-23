<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="温湿度记录" />
</title>

</head>
<script type="text/javascript">
	function chaxun(){
		var kssj = $("#kssj").datebox("getValue");
		var zhi = $("#zhi").datebox("getValue");
		var queryYear = $("#queryYear").val();
		var reg = new RegExp("^[0-9]*$"); 
		/*
		if(!reg.test(queryYear)){
			alert("查询年份只能为数字");
			return;
		}
		if(queryYear.trim() == ""){
			alert("查询年份不能为空");
			return;
		}*/
		if(kssj == ""){
			alert("开始时间不能为空");
			return;
		}
		if(kssj !=''&& zhi!=''&& kssj > zhi){
			alert("开始时间不能早于截止时间");
	           return;
		}else{
			var form = document.getElementById("query");
	    	form.submit();
		}
	}
	
</script>

<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;温湿度记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
			<%-- 查询年份：<input type="text" value="${queryYear}" name="queryYear" id="queryYear" />--%>
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
			     <label for="maintaindate">测点位置:</label>
				<input type="text"  name="weizhi" id="weizhi" value="${weizhi}">
				<label for="pinming">开始时间:</label>
				<input type="text" class="easyui-datebox text1" data-options="validType:'date'" name="kssj" id="kssj" value="${kssj}">
				<label for="pinming">至:</label>
				<input type="text" class="easyui-datebox text1" data-options="validType:'date'" name="zhi" id="zhi" value="${zhi}">
					<input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>
				
			</form>
		</div>
	</div>
	</div>
		
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column property="sensorname" sortable="true" titleKey="测点位置"  style="width:25%;" />
		<display:column property="datetime" sortable="true" titleKey="记录时间" style="width:25%;" />
		<display:column property="max_temperature"  escapeXml="true" sortable="true" titleKey="最高温度"  />
		<display:column property="avg_temperature"  escapeXml="true" sortable="true" titleKey="平均温度"  />
		<display:column property="min_temperature"  escapeXml="true" sortable="true" titleKey="最低温度"  />
		<display:column property="max_humidity"     escapeXml="true" sortable="true" titleKey="最高湿度"  />
		<display:column property="avg_humidity"     escapeXml="true" sortable="true" titleKey="平均湿度"  />
		<display:column property="min_humidity"     escapeXml="true" sortable="true" titleKey="最低湿度"  />
		<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
		</display:setProperty> 
		<display:setProperty name="export.excel" value="true"/>
	</display:table>
	</div>
</form>




