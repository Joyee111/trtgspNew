<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>售出退货录入
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
			from.action="${ctx}/drugState/salereturn/dlrdel.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/drugState/salereturn/dlradd.html";
    	form.submit();
    }
	function deletess(a){
	var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	from.action="${ctx}/drugState/salereturn/dlrdel.html";
	    	from.submit();
    	}else{
			return;
		}
	}
</script>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;售出退货管理&nbsp;>&nbsp;售出退货录入</font>
	<div class="tab_biao">
	<shiro:hasPermission name="SellReturn_recorded">
		<a href="dlrlist.html" class="on" ><span><font>录入</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="SellReturn_auditing">
		<a href="dshlist.html" ><span><font>审核</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="SellReturn_audited">
		<a href="yshlist.html"><span><font>已审核</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="SellReturn_reject">
		<a href="ybhlist.html"><span><font>已驳回</font>
		</span>
		</a>
		</shiro:hasPermission>	
	</div>

<div class="tab_con">
	<div class="caozuo_box">
		<form action="${ctx}/drugState/salereturn/dlrlist.html" method="post" >
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
					通用名称：<input name="yhdate" type="text" value="${yhDate}" class="text1"/>
					购货单位: <input name="ypname" type="text" value="${ypname}" class="text1"/>
			<input class="btn_big" type="submit" value="查询"  /> 
		</form>
	</div>
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input name="yhdate" type="hidden" value="${yhDate}" />
		<input name="ypname" type="hidden" value="${ypname}" />
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选"><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="number" escapeXml="true" sortable="true" titleKey="单据号" />
		<display:column property="qualityMidicine.commonname" escapeXml="true" sortable="true" titleKey="通用名称"/>
		<display:column property="qualifiedPurchaseUnits.customerName"  escapeXml="true" sortable="true" titleKey="购货单位"></display:column>
		<display:column property="returnReason"  escapeXml="true" sortable="true" titleKey="退货原因" ></display:column>
		<display:column property="user.realname"  escapeXml="true" titleKey="申请人"></display:column>
		<display:column property="applicationTime"  titleKey="申请时间"  ></display:column>
		<display:column titleKey="user.operate" autolink="true" media="html">
		<img src="../../images/edit.gif"/><a href="${ctx}/drugState/salereturn/dlredit.html?id=<c:out value="${records.id}"/>&thispage=${thispage}">
			<fmt:message key="button.update"/>
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
        <input name="" type="button" onclick="add()"  class="btn_big" value="新增"/>
        <c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				<input name="" type="button" onclick="onDelete()" class="btn_big" value="删除"/>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
        
    </div>
</div>
