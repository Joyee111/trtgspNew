<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>验收管理录入</title>
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
			from.action="${ctx}/drugState/checkaccept/dlrdel.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/drugState/checkaccept/dlradd.html";
    	form.submit();
    }
	function deletess(a){
	var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	from.action="${ctx}/drugState/checkaccept/dlrdel.html";
	    	from.submit();
    	}else{
			return;
		}
	}
</script>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;验收管理&nbsp;>&nbsp;验收管理录入</font>
	<div class="tab_biao">
		<shiro:hasPermission name="CheckAccept_recorded">
		<a href="dlrlist.html" class="on" ><span><font>录入</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="CheckAccept_auditing">
		<a href="dshlist.html" ><span><font>批注</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="CheckAccept_audited">
		<a href="yshlist.html"><span><font>待确认</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="CheckAccept_reject">
		<a href="ybhlist.html"><span><font>已确认</font>
		</span>
		</a>
		</shiro:hasPermission>	
	</div>

<div class="tab_con">
	<div class="caozuo_box">
		<form action="${ctx}/drugState/checkaccept/dlrlist.html" method="post" >
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
					验收日期：<input name="yhdate" type="text" value="${yhDate}" class="easyui-datebox text1" >
					供货单位: <input name="ypname" type="text" value="${ypname}" class="text1" />
			<shiro:hasPermission name="CheckAccept_recorded_find">
				<input class="btn_big" type="submit" value="查询"  /> 
			</shiro:hasPermission>	
		</form>
	</div>
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input name="yhdate" type="hidden" value="${yhDate}" >
		<input name="ypname" type="hidden" value="${ypname}" />
		<display:table name="recordlist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${checkAcceptId}' onclick='checkAll(\"ids\")' />全选" media="html"><input type="checkbox" name="ids" value="${records.checkAcceptId}" ></display:column>
		<display:column property="checkAcceptNumbe" escapeXml="true" sortable="true" titleKey="单据号" />
		<display:column property="commonName" escapeXml="true" sortable="true" titleKey="通用名称" />
		<display:column property="batchNumber" escapeXml="true" sortable="true" titleKey="批号" />
		<display:column property="quality" escapeXml="true" sortable="true" titleKey="数量"/>
		<display:column property="arrivalDate" escapeXml="true" sortable="true" titleKey="收货日期"/>
		<display:column property="checkAcceptDate"  escapeXml="true" sortable="true" titleKey="验收日期"></display:column>
		<display:column   titleKey="验收结果">
			<c:choose>
				<c:when test="${records.checkIsQualified eq '0'}">
					<c:out value="合格"/>
				</c:when>
				<c:otherwise>
					<c:out value="不合格"/>
				</c:otherwise>
			</c:choose>
		</display:column>
		<display:column property="checkUser"  titleKey="验收员"></display:column>
		<display:column titleKey="user.operate" autolink="true" media="html">
		<shiro:hasPermission name="CheckAccept_recorded_modify">
		<img src="../../images/edit.gif"/><a href="${ctx}/drugState/checkaccept/dlredit.html?id=<c:out value="${records.checkAcceptId}"/>&thispage=${thispage}">
			<fmt:message key="button.update"/>
		</a>
		</shiro:hasPermission>
		<c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				<shiro:hasPermission name="CheckAccept_recorded_delete">
					<a onclick="deletess(<c:out value="${records.checkAcceptId}"/>)">
					<fmt:message key="删除"/>
					</a>
				</shiro:hasPermission>
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
	<shiro:hasPermission name="CheckAccept_recorded_add">
        <input name="" type="button" onclick="add()"  class="btn_big" value="新增"/>
   	</shiro:hasPermission>
   	<c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				<shiro:hasPermission name="CheckAccept_recorded_delete">
       			 <input name="" type="button" onclick="onDelete()" class="btn_big" value="删除"/>
    			</shiro:hasPermission>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
   	
    </div>
</div>
