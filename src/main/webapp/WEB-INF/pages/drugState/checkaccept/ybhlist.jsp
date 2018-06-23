<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>验收管理已确认
</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
</script>
 <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript"
	src="/zywx3/ext/scripts/user/selectarea.js">
</script>
<script type="text/javascript">

	function check(){
		alert(1);
	}
	function onDelete(){
		var from =document.getElementById("recordsss");
		var r=confirm("是否确认删除！");
		if(r){
			from.action="${ctx}/drugState/inspectionRecords/del.html";
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
	    	from.action="${ctx}/drugState/inspectionRecords/del.html";
	    	from.submit();
    	}else{
			return;
		}
	}
</script>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;验收管理&nbsp;>&nbsp;验收管理已确认</font>
<div id="syqy_tab" >
  	<div class="tab_biao">
		<shiro:hasPermission name="CheckAccept_recorded">
		<a href="dlrlist.html" ><span><font>录入</font>
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
		<a href="ybhlist.html" class="on" ><span><font>已确认</font>
		</span>
		</a>
		</shiro:hasPermission>	
	</div>
  	  
</div>

<div>
	<div class="tab_con">
	<div class="caozuo_box">
	<form action="${ctx}/drugState/checkaccept/ybhlist.html" method="post" >
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
			<input type="hidden" name="ypType" id ="ypType" value="${ypType}"/>
					验收日期：<input name="yhdate" type="text" value="${yhDate}" class="easyui-datebox text1" >
					供货单位: <input name="ypname" type="text" value="${ypname}" style="height:21px;" class="easyui-validatebox text1 validatebox-text"/>
			<shiro:hasPermission name="CheckAccept_reject_find">
			
			<font style="font-size:12px; color:#727171; font-weight:bold;">一般药品</font>
			<input type="radio" name="useflag" value="0" <c:if test="${ypType eq '0'}">checked</c:if> onclick="$('#ypType').val(this.value);">
			&nbsp;&nbsp;
			<font style="font-size:12px; color:#727171; font-weight:bold;">专门管理要求药品</font>
			<input type="radio" name="useflag" value="1" <c:if test="${ypType eq '1'}">checked</c:if> onclick="$('#ypType').val(this.value);">
        	
				<input class="btn_big" type="submit" value="查询"  /> 
			</shiro:hasPermission>	
	</form>
		</div>
</div>
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input name="yhdate" type="hidden" value="${yhDate}" >
		<input name="ypname" type="hidden" value="${ypname}" />
		<input name="ypType" type="hidden" value="${ypType}" >
	<div class="ceng_mar5">
	<display:table name="recordlist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
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
				<c:when test="${records.checkIsQualified eq '1'}">
					<c:out value="不合格"/>
				</c:when>
				<c:otherwise>
					<c:out value=""/>
				</c:otherwise>
			</c:choose>
		</display:column>
		<display:column property="checkUser"  titleKey="验收员"></display:column>
		<display:column property="checkAcceptDate2"  escapeXml="true" sortable="true" titleKey="验收日期2"></display:column>
		<display:column   titleKey="验收结果2">
			<c:choose>
				<c:when test="${records.checkIsQualified2 eq '0'}">
					<c:out value="合格"/>
				</c:when>
				<c:when test="${records.checkIsQualified2 eq '1'}">
					<c:out value="不合格"/>
				</c:when>
				<c:otherwise>
					<c:out value=""/>
				</c:otherwise>
			</c:choose>
		</display:column>
		<display:column property="checkUser2"  titleKey="验收员2"></display:column>
		<display:column titleKey="user.operate" autolink="true" media="html">
		<shiro:hasPermission name="CheckAccept_reject_look">
		<a href="ybhview.html?id=${records.checkAcceptId}">查看</a>
		</shiro:hasPermission>	
		</display:column>
	</display:table>
	</div>
</form>
<form id="baseForm" method="post">
	<input type="hidden" name="thispage" value="${thispage}" />
</form>
<form id="delForm" method="post">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" id="resId" name="ids"  value=""   />
</form>
</div>
