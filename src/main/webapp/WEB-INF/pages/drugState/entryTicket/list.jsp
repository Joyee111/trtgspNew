<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>入库单制单
</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
</script>
 <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/ext/styles/display/display.css'/>" />
     <link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/themes/default/easyui.css"> 
 <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript"
	src="/zywx3/ext/scripts/user/selectarea.js">
</script>
<script>
</script>
<script type="text/javascript">
	
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/drugState/EntryTicket/add.html";
    	form.submit();
    }
    function addJH(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/drugState/EntryTicket/addJH.html";
    	form.submit();
    }
	
	function exportExcel(){
		
    	var  checkBox = document.getElementsByName("ids");
    	var  value = "";
    	for(var i=0,n=checkBox.length;i<n;i++){
    		var obj = checkBox[i];
    		if(obj.checked==true){
    			value =obj.value;
    			
    		}
    	}
    	//alert(value);
    	var val = value.split(",");
    	
    	$("#batchNumber").val(value);
    	//alert($("#batchNumber").val());
    	//return;
    	var sendFlag = true;
    	if($("#batchNumber").val()=="" || $("#batchNumber").val()==null){
    		alert("请选择要打印的入库单！");
    		sendFlag = false ;
    		return;
    	}
    	
    	if(sendFlag){
    		$("#id").val(val[3]);
	    	$("#export_form").attr("action","../../ireport/exportEntryTicket.html");
	    	$("#export_form").submit();
	    	if(typeof (batch_number) !="undefined" && batch_number!=""){
	    		//var array = batch_number.split(",");
	    		
	    		$.post("${ctx}/trtgsp/drugState/checkaccept/ajaxChangePrintFlagNew.html",{
				acceptNoteId : val[0],flag:val[2]
				},function(data){
					window.location.reload();
				});
	    	}
    	}
    }
	function checkSelect(){
    	var  checkBox = document.getElementsByName("ids");
    	var index = 0;
    	for(var i=0,n=checkBox.length;i<n;i++){
    		var obj = checkBox[i];
    		if(obj.checked==true){
    			index++;
    			if(index>1){
    				alert("您最多只能选中一条记录进行导出！");
    				obj.checked=false;
    				return;
    			}
    		}
    	}
    	
    }
</script>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;入库单制单</font>
<div class="tab_con">
	 <div class="caozuo_box">
		<form action="${ctx}/drugState/EntryTicket/list.html" method="post" >
			<!--<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
			<!--  通用名称：<input name="yhdate" type="text" value="${yhDate}" class="text1"/>
			供货单位: <input name="ypname" type="text" value="${ypname}" class="text1"/>
			退出日期: <input name="returnTime" type="text" value="${returnTime}" class="easyui-datebox text1" />-->
			批号: <input name="batch" type="text" value="${batchNumber}" class="text1"/>
			<!-- <br>
			<br>
			经营公司：&nbsp;经营&nbsp;<input type="radio" name="department" value="1001"/>
			&nbsp;新品&nbsp;<input type="radio" name="department" value="2001"/>
			&nbsp;市场&nbsp;<input type="radio" name="department" value="3001"/>	 -->	
			
			<input class="btn_big" type="submit" value="查询"  /> 
		</form>
		<form action="" id = "export_form" method="post" target="_blank" >
				<input type="hidden" name="batchNumber" id="batchNumber" value="">
				<input type="hidden" name="id" id="id"value="">
				<input type="hidden" name="flag" id="flag"value="">
				
				<input class="btn_big" type="submit" value="打印入库单"  onclick="exportExcel()"/> 
				
		</form>  
	</div>	
		
	
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input name="yhdate" type="hidden" value="${yhDate}" />
		<input name="ypname" type="hidden" value="${ypname}" />
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选">
		<input type="checkbox" name="ids" value="${records.acceptanceId },${records.scph },${records.flag},${records.id}" onclick="checkSelect()" >
		</display:column>
		
		<display:column escapeXml="true" titleKey="经营公司" >
			<c:if test="${records.jygs != null}">
				<c:choose>
					<c:when test="${records.jygs eq '1001'}">经营</c:when>
					<c:when test="${records.jygs eq '2001'}">新品</c:when>
					<c:when test="${records.jygs eq '3001'}">市场</c:when>
				</c:choose>
			</c:if>
		</display:column>
		<display:column property="bh" escapeXml="true" sortable="true" titleKey="编号"/>
		<display:column property="ghdw"  escapeXml="true" sortable="true" titleKey="供货单位"></display:column>
		<display:column property="ghrq" escapeXml="true" sortable="true" titleKey="供货日期"/>
		<display:column property="tymc" escapeXml="true" sortable="true" titleKey="通用名称"/>
		<display:column property="jx"  escapeXml="true" sortable="true" titleKey="剂型"></display:column>
		<display:column property="gg" escapeXml="true" sortable="true" titleKey="规格"/>
		<display:column property="dw"  escapeXml="true" sortable="true" titleKey="单位"></display:column>
		<display:column property="dj" escapeXml="true" sortable="true" titleKey="单价"/>
		<display:column property="sl"  escapeXml="true" sortable="true" titleKey="数量"></display:column>
		<display:column property="je"  escapeXml="true" sortable="true" titleKey="金额"></display:column>
		<display:column property="scph"  escapeXml="true" sortable="true" titleKey="生产批号"></display:column>
		<display:column property="hh"  escapeXml="true" sortable="true" titleKey="货号"></display:column>
		<display:column property="yxqz"  escapeXml="true" sortable="true" titleKey="有效期至"></display:column>
		<display:column property="ysy"  escapeXml="true" titleKey="验收员"></display:column>
		<display:column property="ysy2"  escapeXml="true" titleKey="验收员2"></display:column>

		<display:column titleKey="user.operate" autolink="true" media="html">
		<img src="../../images/look.gif"/>
		<a href="${ctx}/drugState/EntryTicket/view.html?id=${records.id}">查看</a>
		<img src="../../images/edit.gif"/><a href="${ctx}/drugState/EntryTicket/edit.html?id=<c:out value="${records.id}"/>&thispage=${thispage}">
			<fmt:message key="button.update"/>
		</a>
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
        <input name="" type="button" onclick="add()"  class="btn_big" value="入库单制单"/>
        <input name="" type="button" onclick="addJH()"  class="btn_big" value="委托储存入库单制单"/>
    </div>
    
</div>
