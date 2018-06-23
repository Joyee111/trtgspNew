<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="收货管理收货" />
</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
</script>
 <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>

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
    	form.action="${ctx}/drugState/inspectionRecords/add.html";
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
	function uploadTicketSamples(){
		$("#ticketSamplesFrom").form("submit",{
			success : function(data){
				alert(decodeURI(data));
				window.location.reload();
			}
		})
	}
	
	function uploadStamp(){
		$("#stampFrom").form("submit",{
			success : function(data){
				alert(decodeURI(data));
				window.location.reload();
			}
		})
	}
	
	$(function(){
		setDefaultForRadio("checkConclusion","${checkConclusion}");
	})
</script>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;收货管理&nbsp;>&nbsp;收货</font>
<div class="tab_con">
	<div class="tab_biao" id="xxxxxxxxxxx">
		<shiro:hasPermission name="Receiving_receive">
			<a href="${ctx}/drugState/inspectionRecords/list.html" class="on" ><span><font>收货</font>
		</span>
		</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="Receiving_return">
		<a href="${ctx}/drugState/returnRecords/list.html" ><span><font>退货药品</font>
		</span>
		</a>
			</shiro:hasPermission>
	</div>
<div class="tab_con">
		<div class="caozuo_box">
			<form action="${ctx}/drugState/inspectionRecords/list.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				收货日期：<input  name="yhDate" id="yhdate" class="easyui-datebox text1" type="text" value="${yhDate}" >
				&nbsp;&nbsp;批号： <input class="text1" name="ypname" id="ypname" type="text" value="${ypname}" />
				&nbsp;检查结论：&nbsp;合格&nbsp;<input type="radio" name="checkConclusion" value="1">
				&nbsp;不合格&nbsp;<input type="radio" name="checkConclusion" value="2">
					
				<input type="submit" class="btn_big" value="查询"  /> 
			</form>
		</div>
</div>
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input type="hidden" name="yhDate" id="yhdate" value="${yhDate}" >
		<input type="hidden" name="ypname" id="ypname" value="${ypname}" />
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${reveivingId}' onclick='checkAll(\"ids\")' />全选"><input type="checkbox" name="ids" value="${records.reveivingId}" ></display:column>
		<display:column property="commonName" escapeXml="true" sortable="true" titleKey="通用名称" />
		<display:column property="batchNumber" escapeXml="true" sortable="true" titleKey="批号"/>
		<display:column property="quality"  escapeXml="true" sortable="true" titleKey="数量"></display:column>
		<display:column property="goodsReceiptDate"  escapeXml="true" sortable="true" titleKey="收货日期" ></display:column>
		<%--<display:column property="shipTime"  escapeXml="true" sortable="true" titleKey="发货日期" ></display:column>--%>
		<display:column property="receiptAddress"  escapeXml="true" sortable="true" titleKey="收货地址" ></display:column>
		
		<display:column  escapeXml="true" sortable="true" titleKey="检查结论">
		<c:if test="${records.inspectionResults != null}">
		<c:if test="${records.inspectionResults eq '1'}"><fmt:message key="合格"/></c:if>
		<c:if test="${records.inspectionResults eq '2'}"><fmt:message key="不合格"/></c:if>
		</c:if>
		</display:column>
		<display:column property="receiptPeople"  titleKey="re.goodsClerk" autolink="true" media="html"></display:column>
		<display:column titleKey="user.operate" autolink="true" media="html">
		<shiro:hasPermission name="Receiving_receive_mdy">
		<img src="../../images/edit.gif"/><a href="${ctx}/drugState/inspectionRecords/add.html?method=edit&id=<c:out value="${records.reveivingId}"/>&thispage=${thispage}">
			<fmt:message key="button.update"/>
		</a>
		</shiro:hasPermission>
		<c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				<shiro:hasPermission name="Receiving_receive_del">
			<a onclick="deletess(<c:out value="${records.reveivingId}"/>)">
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
	<c:choose>
			<c:when test="${hideUpload eq 'true'}">
				
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
				<form action="uploadTicketSamples.html" id="ticketSamplesFrom" enctype="multipart/form-data" method="post">
					<shiro:hasPermission name="Receiving_receive_upload">
					票样上传：<input type="file" name="ticketSamples" class="text1" size="40" onchange="uploadTicketSamples()"/>
					</shiro:hasPermission>
					<a href="${ctx }/download.html?fileName=${ticketSamples.ticketSamplesPath}">票样查看</a>
				</form>
				<form action="uploadStamp.html" id="stampFrom" enctype="multipart/form-data" method="post">
					<shiro:hasPermission name="Receiving_receive_upload">
					图章上传：<input type="file" name="stamp" class="text1" size="40" onchange="uploadStamp()"/>
					</shiro:hasPermission>
					<a href="${ctx }/download.html?fileName=${stamp.ticketSamplesPath}">图章查看</a>
				</form>
			</c:when>
		</c:choose>
	<shiro:hasPermission name="Receiving_receive_add">
	 <input type="button"  value="新增" class="btn_big" onclick="add()" />
	 </shiro:hasPermission>
	 <c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				 <shiro:hasPermission name="Receiving_receive_del">
	 <input type="button" value="删除" class="btn_big" onclick="onDelete()" />
	 </shiro:hasPermission>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
	
	</div>
</div>

