<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>恢复销售已审核
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
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;恢复销售管理&nbsp;>&nbsp;恢复销售已审核</font>
<div id="syqy_tab" >
	<div class="tab_biao">
	<shiro:hasPermission name="RecoverySale_recorded">
		<a href="dlrlist.html"><span><font>录入</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="RecoverySale_auditing">
		<a href="dshlist.html" ><span><font>审核</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="RecoverySale_audited">
		<a href="yshlist.html" class="on"><span><font>已审核</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="RecoverySale_reject">
		<a href="ybhlist.html"><span><font>已驳回</font>
		</span>
		</a>
		</shiro:hasPermission>	
	</div>
  	  
</div>

<div class="tab_con">
	<div class="caozuo_box">
		<form action="${ctx}/drugState/recoverycell/yshlist.html" method="post">
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
			通用名称：<input name="ypname" type="text" value="${ypname}" class="text1"/>
			<shiro:hasPermission name="RecoverySale_audited_find">
			<input class="btn_big" type="submit" value="查询"  /> 
			</shiro:hasPermission>
		</form>
	</div>

<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input name="ypname" type="hidden" value="${ypname}" />
	<div class="ceng_mar5">
	<display:table name="recordlist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选"><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="commonName" escapeXml="true" sortable="true" titleKey="通用名称" />
		<display:column property="batchProduction" escapeXml="true" sortable="true" titleKey="批号" />
		<display:column property="quantity" escapeXml="true" sortable="true" titleKey="数量" />
		<display:column property="location" escapeXml="true" sortable="true" titleKey="检查情况"/>
		<display:column property="checkSituation"  escapeXml="true" sortable="true" titleKey="检查结论"></display:column>
		<display:column property="applicationName"  escapeXml="true" titleKey="申请人"></display:column>
		<display:column property="applicationTime"  titleKey="申请时间"  ></display:column>
		<display:column titleKey="user.operate" autolink="true" media="html">
		<shiro:hasPermission name="RecoverySale_audited_look">
		<a href="yshview.html?id=${records.id}">查看</a>
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
