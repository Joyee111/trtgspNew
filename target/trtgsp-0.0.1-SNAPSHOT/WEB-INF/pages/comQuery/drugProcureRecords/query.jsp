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
		$(function(){
			setDefaultForRadio("department","${department}");
			setDefaultForRadio("useFlag","${useFlag}");
			setDefaultForRadio("isfood","${isfood}");
		})
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
				<label for="pinming">采购订单号：</label>
				<input type="text" name="caigoudh" id="caigoudh" value="${caigoudh}" class="text1">
				&nbsp;&nbsp;<label>通用名称：</label>
				<input type="text" class="text1" size="25" name="commonName" value="${commonName}"/><br/><br/>
				<label for="pinming">批号：</label>
				<input type="text" name="pihao" id="pihao" value="${pihao}" class="text1">
				&nbsp;&nbsp;&nbsp;&nbsp;<label for="medcNo">药品编号：</label>
				<input type="text" name="medcNo" id="medcNo" value="${medcNo}" class="text1">
				<label>经营公司：</label>
				经营<input type="radio" name="department" value="1001">
				&nbsp;新品<input type="radio" name="department" value="2001">
				&nbsp;市场<input type="radio" name="department" value="3001">
				&nbsp;<label>状态：</label>
				合格<input type="radio" name="useFlag" value="0">
				&nbsp;作废<input type="radio" name="useFlag" value="1">
			 <input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>
				
			</form>
		</div>
	</div>
	</div>
		
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column property="caigoudh" sortable="true" titleKey="采购单单号"  maxLength="15"/>
		<display:column property="departmentId" sortable="true" titleKey="公司名称"  maxLength="15"/>
		<display:column property="gouriqi" sortable="true" titleKey="购货日期"  maxLength="15"/>
		<display:column property="gonghuodw" sortable="true" titleKey="供货单位 "  maxLength="15"/>
		<display:column property="yopinbh" sortable="true" titleKey="药品编号"  maxLength="15"/>
		<display:column property="tongyongmc" sortable="true" titleKey="通用名称"  maxLength="15"/>
		<display:column property="jixing"  escapeXml="true" sortable="true" titleKey="剂型"  style="width:10%;"></display:column>
		<display:column property="guige"  escapeXml="true" titleKey="规格"></display:column>
			<display:column property="danwei"  escapeXml="true" titleKey="单位"></display:column>
		<display:column property="goujinjg"  escapeXml="true" titleKey="购进价格"></display:column>
		<display:column property="goujinsl"  escapeXml="true" titleKey="购进数量"></display:column>
		<display:column property="actualReceivedQuantity"  escapeXml="true" titleKey="实际收货数量"></display:column>
		<display:column property="pihao"  escapeXml="true" titleKey="批号"></display:column>
			<display:column property="shengchancs"  escapeXml="true" titleKey="生产厂商"></display:column>
			<display:column property="youxiaoqi"  escapeXml="true" titleKey="有效期至"></display:column>
			<display:column property="caigouyuan"  escapeXml="true" titleKey="采购员"></display:column>
        <display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
				</display:setProperty> 
		<display:setProperty name="export.excel" value="true"/>
	

	</display:table>
	</div>
</form>




