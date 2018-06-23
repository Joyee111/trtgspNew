<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="运输记录" />
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
			from.action="${ctx}/qualityRecords/transportRecords/del.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/qualityRecords/transportRecords/add.html";
    	form.submit();
    }
	
	function deletess(a){
		var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	from.action="${ctx}/qualityRecords/transportRecords/del.html";
	    	from.submit();
    	}else{
			return;
		}
	}
	 function chaxun(){
	
	 var kssj = $("#fhsj").datebox("getValue");
		  var zhi = $("#zhi").datebox("getValue");

		  if(kssj !=''&& zhi!=''&& kssj > zhi){
           alert("开始时间不能早于截止时间");
            return;
		}else{
		var form = document.getElementById("query");
    	form.submit();
		}
		}
		$(function(){
			setDefaultForRadio("trasportType","${trasportType}");
		});
</script>

<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;运输记录</font>
		<div class="tab_con">
		<div class="caozuo_box">
		<form name="query" id="query" action="query.html" method="post">
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
			<label for="drugsnumber">派车单号：</label>
			<input type="text" name="pcdh" id="pcdh" value="${pcdh}" class="text1">
			<label for=""pinming"">发货时间：</label>
			<input type="text" class="easyui-datebox text1" name="fhsj" id="fhsj" value="${fhsj}">
			<label for=""pinming"">至：</label>
			<input type="text" class="easyui-datebox text1" name="zhi" id="zhi" value="${zhi}">
			<!-- &nbsp;<label>运输方式： </label>
			&nbsp;自运&nbsp;<input type="radio" name="trasportType" value="自运"/>
			&nbsp;承运&nbsp;<input type="radio" name="trasportType" value="承运"/> -->
		    <input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>
		</form>
		</div>
	</div>	
		<div class="ceng_mar5">
<form action="" id="records">
			<display:table name="reslist" cellspacing="0" cellpadding="0"
				requestURI="" style="width:100%;" id="records"
				pagesize="${pageSize}" class="table" export="true"
				size="${resultSize}" partialList="true">
				<display:column
					title="<input type='checkbox' id='checkall' name='checkall' value='${id}'  onclick='checkAll(\"ids\")' />全选"
					media="html">
					<input type="checkbox" name="ids" value="${records.id}">
				</display:column>
				<display:column property="orderno" sortable="true" titleKey="派车单编号"
					maxLength="15" />
				<display:column property="deliverydate" sortable="true"
					titleKey="发货时间"
					decorator="com.sinosoft.util.FormatDateColumnDecorator"
					maxLength="15" />
				<display:column property="deliveryaddress" sortable="true"
					titleKey="发货地址" maxLength="15" />
				<display:column property="quantity" escapeXml="true" titleKey="药品件数"></display:column>
				<display:column property="baoshu" sortable="true" titleKey="包数"
					maxLength="15" />
				<display:column property="zhongliang" sortable="true"
					titleKey="重量（T）"
					decorator="com.sinosoft.util.FormatFloatColumnDecorator"
					maxLength="15" />
				<display:column property="checi" sortable="true" titleKey="车次"
					maxLength="15"
					decorator="com.sinosoft.util.FormatFloatColumnDecorator" />
				<display:column property="yunfei" sortable="true" titleKey="运费（元）"
					decorator="com.sinosoft.util.FormatFloatColumnDecorator"
					maxLength="15" />
				<display:column property="receivingunit" escapeXml="true"
					sortable="true" titleKey="收货单位"></display:column>
				<display:column property="receivingaddress" escapeXml="true"
					titleKey="收货地址"></display:column>
				<display:column property="operator" escapeXml="true" sortable="true"
					titleKey="委托经办人"></display:column>
				<display:column property="plateno" escapeXml="true" sortable="true"
					titleKey="车牌号"></display:column>
				<display:column property="hdtime" escapeXml="true" sortable="true"
					titleKey="签收时间"></display:column>
				<display:column property="qsr" escapeXml="true" sortable="true"
					titleKey="签收人"></display:column>
				<display:column property="transporttype" escapeXml="true"
					titleKey="运输方式"></display:column>
				<display:column property="carrierunit" escapeXml="true"
					titleKey="承运单位"></display:column>
				<display:column property="yssx" escapeXml="true" titleKey="运输时限"></display:column>
				<display:column titleKey="user.operate" autolink="true" media="html"
					style="border-right:1px solid #feb808;">
					<img src="../../images/look.gif" />
					<a
						href="${ctx}/qualityRecords/transportRecords/add.html?method=edit&id=<c:out value="${records.id}"/>&thispage=${thispage}">
						<fmt:message key="查看" /> </a>
					<!-- <a onclick="deletess(<c:out value="${records.id}"/>)">
			<fmt:message key="删除"/>
	
		</a> -->
					<display:setProperty name="export.banner">
						<div class="exportlinks">
							<fmt:message key="export.banner" />
						</div>
					</display:setProperty>
					<display:setProperty name="export.excel" value="true" />
				</display:column>
			</display:table>
		</form>
</div>
<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>
<form id="delForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" id="resId" name="ids"  value=""   />
</form>
<!-- 
<div class="caozuo_box2">
<input type="button" onclick="add()" class="btn_big" value="新增"/>
	 <input type="button" value="删除" class="btn_big" onclick="onDelete()" />
	 
</div>	
 -->


</div>

