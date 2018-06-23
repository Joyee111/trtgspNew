<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>出库复核录入
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
	function onDelete(){
		var from =document.getElementById("recordsss");
		var r=confirm("是否确认删除！");
		if(r){
			from.action="${ctx}/drugState/outcheck/dlrdel.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/drugState/outcheck/dlradd.html";
    	form.submit();
    }
	function deletess(a){
	var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	from.action="${ctx}/drugState/outcheck/dlrdel.html";
	    	from.submit();
    	}else{
			return;
		}
	}
	//批量录入
	function viewe(){
		var s = showModalDialog("${ctx}/drugState/outcheck/saleNodlr.html", "", "dialogWidth:52.08em; dialogHeight:29em; "); 
		if(s==1){
			alert("批量录入成功!");
			location.href="dlrlist.html";
		}
	}
</script>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;出库复核管理</font>
	<div class="tab_biao">
	<shiro:hasPermission name="OutboundCheck_recorded">
		<a href="dlrlist.html" class="on" ><span><font>录入</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="OutboundCheck_auditing">
		<a href="dshlist.html" ><span><font>确认</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="OutboundCheck_audited">
		<a href="yshlist.html"><span><font>已确认</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<!--<shiro:hasPermission name="OutboundCheck_reject">
		<a href="ybhlist.html"><span><font>已驳回</font>
		</span>
		</a>
		</shiro:hasPermission>	-->
	</div> 

<div class="tab_con">
<!-- 
	<div class="caozuo_box">
		<form action="${ctx}/drugState/checkaccept/dlrlist.html" >
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
					验收日期：<input name="yhdate" type="text" value="${yhdate}" >
					通用名称: <input name="ypname" type="text" value="${ypname}" />
			<input class="btn_big" type="submit" value="查询"  /> 
		</form>
	</div>
-->
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
	<display:table name="recordlist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选"><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="salesFromNumber" escapeXml="true" sortable="true" titleKey="合同号"/>
		<display:column property="salesItemNumber" escapeXml="true" sortable="true" titleKey="票号"/>
		<display:column property="commoneName" escapeXml="true" sortable="true" titleKey="通用名称"/>
		<display:column property="drugFrom" escapeXml="true" sortable="true" titleKey="剂型"/>
		<display:column property="specification" escapeXml="true" sortable="true" titleKey="规格"/>
		<display:column property="batchNumber" escapeXml="true" sortable="true" titleKey="批号"/>
		<display:column property="quantity" escapeXml="true" sortable="true" titleKey="数量"/>
		<display:column property="purchaseUnits" escapeXml="true" sortable="true" titleKey="购货单位"/>
				<display:column  escapeXml="true" sortable="true" titleKey="质量状况">
			<c:if test="${records.qaualityStatus != null}">
			<c:if test="${records.qaualityStatus eq '1'}"><fmt:message key="合格"/></c:if>
			<c:if test="${records.qaualityStatus eq '2'}"><fmt:message key="不合格"/></c:if>
			</c:if>
		</display:column>
		<display:column property="outDate" escapeXml="true" sortable="true" titleKey="销售时间"/>
		<display:column property="applityPerson" escapeXml="true" sortable="true" titleKey="申请人"/>
		<display:column property="remark" escapeXml="true" sortable="true" titleKey="备注"/>
		<display:column titleKey="user.operate" autolink="true" media="html">
		<shiro:hasPermission name="OutboundCheck_recorded_modify">
		<img src="../../images/edit.gif"/><a href="${ctx}/drugState/outcheck/dlredit.html?id=<c:out value="${records.id}"/>&thispage=${thispage}">
			<fmt:message key="button.update"/>
		</a>
		</shiro:hasPermission>
		<c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
					<shiro:hasPermission name="OutboundCheck_recorded_delete">
			<a onclick="deletess(<c:out value="${records.id}"/>)">
			<fmt:message key="删除"/>
		</a>
		</shiro:hasPermission>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
		
	</display:column>
	<display:setProperty name="export.pdf" value="false" /> 
	<display:setProperty name="export.csv" value="false" /> 
	<display:setProperty name="export.xml" value="false" /> 
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
	<form>
	</form>
	<c:if test="${dateDisableFlag eq 'true'}">
		<input name="" type="button" onclick="viewe()"  class="btn_big" value="批量录入"/>
	</c:if>
	
	<shiro:hasPermission name="OutboundCheck_recorded_add">
        <input name="" type="button" onclick="add()"  class="btn_big" value="新增"/>
        </shiro:hasPermission>
        <c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				 <shiro:hasPermission name="OutboundCheck_recorded_delete">
		        <input name="" type="button" onclick="onDelete()" class="btn_big" value="删除"/>
		        </shiro:hasPermission>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
       
    </div>
</div>
