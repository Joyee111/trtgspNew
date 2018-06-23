<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="温湿度" />
</title>

</head>
<script type="text/javascript">
	function chaxun() {
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
		if (kssj != '' && zhi != '' && kssj > zhi) {
			alert("开始时间不能早于截止时间");
			return;
		} else {
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
			
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				<label for="maintaindate">测点位置:</label>
				<input type="text"  name="weizhi" id="weizhi" value="${weizhi}" class="text1">
				<label for="pinming">开始时间:</label>
				<input type="text" class="easyui-datebox text1" data-options="validType:'date'" name="kssj" id="kssj" value="${kssj}">
				<label for="pinming">至:</label>
				<input type="text" class="easyui-datebox text1" data-options="validType:'date'" name="zhi" id="zhi" value="${zhi}">
			
				<input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>
			</form>
		</div>
	</div>
	</div>
	<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>	





