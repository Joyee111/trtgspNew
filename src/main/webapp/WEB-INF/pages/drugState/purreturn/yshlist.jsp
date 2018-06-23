<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>购进退出已审核
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

<div id="syqy_tab" >
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;购进退出管理&nbsp;>&nbsp;购进退出已审核</font>
	<div class="tab_biao">
		<a href="dlrlist.html" ><span><font>录入</font>
		</span>
		</a>
		<a href="dshlist.html"><span><font>审核</font>
		</span>
		</a>
		<a href="yshlist.html" class="on" ><span><font>已审核</font>
		</span>
		</a>
		<a href="ybhlist.html"><span><font>已驳回</font>
		</span>
		</a>
	</div>
  	  
</div>

<div>
	<div class="tab_con">
	<div class="caozuo_box">
		<form action="${ctx}/drugState/purreturn/yshlist.html" method="post" >
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
					通用名称：<input name="yhdate" type="text" value="${yhDate}" >
					供货单位: <input name="ypname" type="text" value="${ypname}" />
			<input class="btn_big" type="submit" value="查询"  /> 
		</form>
	</div>
</div>
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input name="yhdate" type="hidden" value="${yhDate}" />
		<input name="ypname" type="hidden" value="${ypname}" />
	<div class="ceng_mar5">
	<display:table name="recordlist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选"><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="qualityMidicine.commonname" escapeXml="true" sortable="true" titleKey="通用名称"/>
		<display:column property="qualifiedSuppliers.customerName"  escapeXml="true" sortable="true" titleKey="供货单位"></display:column>
		<display:column property="returnReason"  escapeXml="true" sortable="true" titleKey="退货原因" ></display:column>
		<display:column property="user.realname"  escapeXml="true" titleKey="申请人"></display:column>
		<display:column property="applicationTime"  titleKey="申请时间"  ></display:column>
		<display:column titleKey="user.operate" autolink="true" media="html">
		<a href="yshview.html?id=${records.id}">查看</a>
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
