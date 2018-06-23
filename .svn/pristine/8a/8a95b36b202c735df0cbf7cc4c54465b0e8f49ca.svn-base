<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="收货管理退货药品" />
</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
co</script>
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
	function onDelete(){
		var from =document.getElementById("recordsss");
		var r=confirm("是否确认删除！");
		if(r){
			from.action="${ctx}/drugState/returnRecords/del.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/drugState/returnRecords/add.html";
    	form.submit();
    }
	function deletess(a){
	var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	from.action="${ctx}/drugState/returnRecords/del.html";
	    	from.submit();
    	}else{
			return;
		}
	}
</script>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;收货管理&nbsp;>&nbsp;退货药品</font>
	<div class="tab_biao">
		<shiro:hasPermission name="Receiving_receive">
			<a href="${ctx}/drugState/inspectionRecords/list.html" ><span><font>收货</font>
		</span>
		</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="Receiving_return">
		<a href="${ctx}/drugState/returnRecords/list.html" class="on" ><span><font>退货药品</font>
		</span>
		</a>
			</shiro:hasPermission>
	</div>
<div>
<div class="tab_con">
		<div class="caozuo_box">
			<form action="${ctx}/drugState/returnRecords/list.html" method="post" >
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				退货日期：<input name="yhDate" type="text" value="${yhDate}" class="easyui-datebox text1" />
				退回单位：<input name="ypname" type="text" value="${ypname}" class="text1" /> &nbsp;
				通用名称：<input type="text" name="commonName" value="${commonName }" class="text1" /><br/><br/>
				销售单号：<input type="text" name="xiaoshoudanhao" value="${xiaoshoudanhao }" class="text1" />
				退货单号：<input type="text" name="tuihuodanhao" value="${tuihuodanhao }" class="text1" />
				
				<input type="submit" class="btn_big" value="查询"  /> 
			</form>
		</div>
</div>

	
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input name="yhDate" type="hidden" value="${yhhDate}" />
		<input name="ypname" type="hidden" value="${ypname}" />
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选"><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="commonName" escapeXml="true" sortable="true" titleKey="通用名称" />
		<display:column property="durgFrom" escapeXml="true" sortable="true" titleKey="剂型"/>
		<display:column property="specification"  escapeXml="true" sortable="true" titleKey="规格"/>
		<display:column property="purchaseUnit"  escapeXml="true" sortable="true" titleKey="退回单位"/>
		<display:column property="receivingUnit"  escapeXml="true" titleKey="收货单位"></display:column>
		<display:column property="receivingAddress"  escapeXml="true" titleKey="收货地址"></display:column>
	<%-- 	<display:column property="receivedDate"  titleKey="收货时间" autolink="true" media="html"></display:column>--%>
		<display:column property="deliveryDate" escapeXml="true" sortable="true" titleKey="退货时间"></display:column>
		<%--<display:column property="checkConclusion" escapeXml="true" sortable="true" titleKey="检查结论"></display:column>--%>
		<display:column property="receivingUser" escapeXml="true" sortable="true" titleKey="收货人"></display:column>
		<display:column property="modifyDate" escapeXml="true" sortable="true" titleKey="修改时间"></display:column>
		<display:column titleKey="user.operate" autolink="true" media="html">
		 <shiro:hasPermission name="Receiving_return_mdy">
			<a href="${ctx}/drugState/returnRecords/view.html?id=<c:out value="${records.id}"/>&thispage=${thispage}">查看</a>
		</shiro:hasPermission>
		<c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				 <shiro:hasPermission name="Receiving_return_del">
					<a onclick="deletess(<c:out value="${records.id}"/>)">
					<fmt:message key="删除"/>
				</a>
				</shiro:hasPermission>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
		
	</display:column>
	</display:table>
	</div>
</form>
<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>
<form id="delForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" id="resId" name="ids"  value=""   />
</form>

	<div class="caozuo_box2">
	<shiro:hasPermission name="Receiving_return_add">
	 <input type="button"  value="新增" class="btn_big" onclick="add()" />
	 </shiro:hasPermission>
	 <c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
			<shiro:hasPermission name="Receiving_return_del">
	 <input type="button" value="删除" class="btn_big" onclick="onDelete()" />
	 </shiro:hasPermission>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>

	</div>
</div>
