<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="药品采购记录" />
</title>

</head>
<script type="text/javascript">
function chaxun(){
	
	 var gouriqi = $("#gouriqi").datebox("getValue");
		  var zhi = $("#zhi").datebox("getValue");

		  if(gouriqi !=''&& zhi!=''&& gouriqi > zhi){
           alert("开始时间不能早于截止时间");
            return;
		}else{
		var form = document.getElementById("query");
    	form.submit();
		}
		}
</script>


<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;药品采购记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				<label for="maintaindate">购货日期：</label>
				<input type="text"  class="easyui-datebox text1" name="gouriqi" id="gouriqi" value="${gouriqi}" data-options="validType:'date'">
				<label for="maintaindate">至：</label>
				<input type="text"  class="easyui-datebox text1" name="zhi" id="zhi" value="${zhi}" data-options="validType:'date'">
				<label for="pinming">采购订单号:</label>
				<input type="text" name="caigoudh" id="caigoudh" value="${caigoudh}" class="text1">
				&nbsp;&nbsp;<label>通用名称：</label> 
				<input type="text" class="text1" size="25" name="commonName" value="${commonName}"/> <br/><br/>
				<label for="pinming">批号：</label>
				<input type="text" name="pihao" id="pihao" value="${pihao}" class="text1">
				&nbsp;&nbsp;&nbsp;&nbsp;<label for="medcNo">药品编号：</label>
				<input type="text" name="medcNo" id="medcNo" value="${medcNo}" class="text1">
				<label>经营公司：</label>
				经营<input type="radio" name="department" value="1001">
				&nbsp;新品<input type="radio" name="department" value="2001">
				&nbsp;市场<input type="radio" name="department" value="3001">&nbsp;
				<label>状态：</label>
				合格<input type="radio" name="useFlag" value="0">
				&nbsp;作废<input type="radio" name="useFlag" value="1">
			 <input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>
			</form>
		</div>
	</div>
	</div>
	<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>	





