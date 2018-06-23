<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>验收管理待确认
</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
t</script>
 <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript"
	src="/zywx3/ext/scripts/user/selectarea.js">
</script>
<script>
</script>
<script type="text/javascript">
	function check(){
		alert(1);
	}
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/drugState/checkaccept/dlradd.html";
    	form.submit();
    }
</script>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;验收管理&nbsp;>&nbsp;验收管理待确认</font>
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
		<a href="yshlist.html" class="on" ><span><font>待确认</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="CheckAccept_reject">
		<a href="ybhlist.html"><span><font>已确认</font>
		</span>
		</a>
		</shiro:hasPermission>	
	</div>
  	  
</div>

<div>
	<div class="tab_con">
	<div class="caozuo_box">
		<form action="${ctx}/drugState/checkaccept/yshlist.html" method="post" >
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
					验收日期：<input name="yhdate" type="text" value="${yhDate}" class="easyui-datebox text1">
					供货单位: <input name="ypname" type="text" value="${ypname}" class="text1"/>
			<shiro:hasPermission name="CheckAccept_audited_find">		
			<input class="btn_big" type="submit" value="查询"  /> 
			</shiro:hasPermission>
		</form>
	</div>
</div>
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input name="yhdate" type="hidden" value="${yhDate}" >
	<div class="ceng_mar5">
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
		<display:column titleKey="user.operate" autolink="true" media="html" >
		<shiro:hasPermission name="CheckAccept_audited_look">
		<a href="yshview.html?id=${records.checkAcceptId}">查看</a>
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
