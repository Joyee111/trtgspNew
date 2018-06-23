<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="信息反馈" />
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
			from.action="${ctx}/qualityRecords/infoFeedback/del.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/qualityRecords/infoFeedback/add.html";
    	form.submit();
    }
	
	function deletess(a){
		//var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	//from.action="${ctx}/qualityRecords/infoFeedback/del.html";
	    	//from.submit();
	    	$("#delForm").form("submit",{
	    		success : function(data){
	    			if(typeof (data) != 'undefined' && data != ""){
	    				alert(decodeURI(data));
	    			}
	    			location.reload();
	    		}
	    	})
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
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">质量记录管理&nbsp;>&nbsp;信息反馈</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="list.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				<label for="feedbackdepartment">反馈部门:</label>
				<input type="text" name="feedbackdepartment" id="feedbackdepartment" value="${feedbackdepartment}" class="text1">
				<label for="pinming">通用名称:</label>
				<input type="text" name="pinming" id="pinming" value="${pinming}" class="text1">
				反馈时间：<input type="text" id="startDate" name="startDate" value="${startDate}" class="easyui-datebox text" style="height: 28px;"/>&nbsp;--至--
				<input type="text" id="endDate" name="endDate" value="${endDate}" class="easyui-datebox text1" style="height: 28px;">
				<input type="submit" class="btn_big" value="查询"/> 
			</form>
		</div>
	</div>
	
		
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table_print" export="true" size="${resultSize}" partialList="true">
		<c:choose>
			<c:when test="${records.type eq '0'}">
				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${records.id}'   onclick='checkAll(\"ids\")' />全选" media="html" class="noPrint_flag"><input type="checkbox" name="ids" value="${records.id}" ></display:column>
				<display:column property="feedbackdepartment" sortable="true" titleKey="反馈部门"   class="noPrint_flag"/>
				<display:column property="commonName"  escapeXml="true" sortable="true" titleKey="品名" class="noPrint_flag" />
				<display:column property="drugForm"  escapeXml="true" sortable="true" titleKey="剂型" class="noPrint_flag" />
				<display:column property="specification"  escapeXml="true" titleKey="规格" class="noPrint_flag" />
				<display:column property="batchproduction"  titleKey="批号" autolink="true" media="html" class="noPrint_flag" />
				<display:column property="unit"  escapeXml="true" titleKey="单位"  class="noPrint_flag" />
				<display:column property="quantity"  escapeXml="true" titleKey="数量" class="noPrint_flag" />
				<display:column property="manufacturer"  escapeXml="true" titleKey="生产厂商" class="noPrint_flag" />
				<display:column property="returnUnit"  escapeXml="true" titleKey="来货单位" class="noPrint_flag"/>
				<display:column property="createDate"  escapeXml="true" titleKey="反馈时间" class="noPrint_flag" decorator="com.sinosoft.util.FormatDateColumnDecorator"/>
				<display:column titleKey="user.operate" autolink="true"  class="noPrint_flag">
					<img src="../../images/edit.gif"/>
					<a href="${ctx}/qualityRecords/infoFeedback/editAssign.html?id=<c:out value='${records.id}'/>">
					<fmt:message key="处理"/>
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
			</c:when>
			<c:when test="${records.type eq '1'}">
					<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${records.id}'   onclick='checkAll(\"ids\")' />全选" media="html" class="print_flag"><input type="checkbox" name="ids" value="${records.id}" ></display:column>
							<display:column property="feedbackdepartment" sortable="true" titleKey="反馈部门"   class="print_flag"/>
							<display:column property="commonName"  escapeXml="true" sortable="true" titleKey="品名" class="print_flag" />
							<display:column property="drugForm"  escapeXml="true" sortable="true" titleKey="剂型" class="print_flag" />
							<display:column property="specification"  escapeXml="true" titleKey="规格" class="print_flag" />
							<display:column property="batchproduction"  titleKey="批号" autolink="true" media="html" class="print_flag" />
							<display:column property="unit"  escapeXml="true" titleKey="单位"  class="print_flag" />
							<display:column property="quantity"  escapeXml="true" titleKey="数量" class="print_flag" />
							<display:column property="manufacturer"  escapeXml="true" titleKey="生产厂商" class="print_flag" />
							<display:column property="returnUnit"  escapeXml="true" titleKey="来货单位" class="print_flag"/>
							<display:column property="createDate"  escapeXml="true" titleKey="反馈时间" class="print_flag" decorator="com.sinosoft.util.FormatDateColumnDecorator"/>
							
							<display:column titleKey="user.operate" autolink="true"  class="noPrint_flag">
								<img src="../../images/edit.gif"/>
								<a href="${ctx}/qualityRecords/infoFeedback/editWaitDo.html?id=<c:out value='${records.id}'/>">
								<fmt:message key="处理"/>
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
			</c:when>
		</c:choose>
	
		<display:setProperty name="export.csv" value="false"/>
		<display:setProperty name="export.pdf" value="false"/>
		<display:setProperty name="export.excel" value="false"/>
		<display:setProperty name="export.xml" value="false"/>
		<display:setProperty name="export.export name.labe">
			<span class='export'>export name</span>
		</display:setProperty>
	</display:table>
	</div>
</form>
<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>
<form id="delForm" method="post" action="del.html">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" id="resId" name="ids"  value=""   />
</form>

<div class="caozuo_box2">
<input type="button" onclick="add()" value="新增" class="btn_big"/>
<!-- <input type="button" value="删除" class="btn_big" onclick="onDelete()" /> -->
</div>
<script type="text/javascript">
	//alert("${waitToReslist}");
	function addInfoFeedBack(){
		window.location.href="add.html";
	}
</script>
</div>

