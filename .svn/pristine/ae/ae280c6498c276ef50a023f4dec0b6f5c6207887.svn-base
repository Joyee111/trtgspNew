<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<head>
    <title><fmt:message key="authoriyList.title"/></title>
    <script type="text/javascript" src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
</script>
<script>
jQuery(function(){
		jQuery("#displayallpage").val(${displayallpage});
		jQuery("#tz").val(${thispage});
	});
</script>
<div class="box_big" style="height: 500px">
	<form:form commandName="authoriy" method="post" action="${ctx}/user/authoriyform.html?method=query" id="searchForm">
		<div class="bj_biao" onclick="hiddenselectcon();"><h4><fmt:message key="user.selectcon"/></h4></div>
		<div class="box5" id="selectcondiv" style="">
			<table  border="0" cellspacing="0" cellpadding="0" class="table_bj">
				<tr height="18">
					<th width="100">
						<fmt:message key="authoriy.name"/>:
					</th>
					<td width="200">
						<form:input size="20" path="authoriyname" cssClass="text4"/>
					</td>
					<th width="100">
						<fmt:message key="authoriy.description"/>:
					</th>
					<td width="200">
						<form:input size="20" path="description" cssClass="text4"/>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr height="50" valign="top">
					<td align="center"><input type="submit" value="<fmt:message key="button.search"/>" class="btn_blue2"/>
					</td>
				</tr>
			</table>
		</div>
		<table width="100%" align="left">
			<tr>
				<td><input type="button" onclick="location.href='<c:url value="/user/authoriyform.html?method=Add&from=list"/>'" value="<fmt:message key="button.add"/>" class="btn_blue2"/></td>
			</tr>
		</table>
	</form:form>
	<form id="deleteform" method="post"></form>
	<div class="ceng_mar5">
		<display:table name="AuthoriyList" cellspacing="0" cellpadding="0"
			requestURI="" id="authoriy" pagesize="${pagesize}" class="table" style="width:98%;" export="true" size="${resultSize}" partialList="true">
			<display:column property="authoriyid" titleKey="ID"  escapeXml="true" sortable="true"/>
			<display:column property="authoriyname" escapeXml="true" sortable="true"
				titleKey="authoriy.name" style="width: 15%"/>
			<display:column property="createtime" titleKey="authoriy.createtime" sortable="true" format="{0,date,yyyy-MM-dd HH:mm:ss}"/>
			<display:column property="description" titleKey="authoriy.description"/>
			<display:column titleKey="user.operate" style="width:13%;border-right:1px solid #feb808;" media="html">
				<a href="${ctx}/user/authoriyform.html?method=update&from=list&id=<c:out value="${authoriy.authoriyid}"/>">
					<fmt:message key="button.update"/>
				</a>
				&nbsp;&nbsp;&nbsp;
				<a onclick="onDelete(<c:out value="${authoriy.authoriyid}"/>)">
					<fmt:message key="button.delete"/>
				</a>
			</display:column>
			<display:setProperty name="export.pdf" value="false"/>
			<display:setProperty name="export.csv" value="false"/>
			<display:setProperty name="export.xml" value="false"/>
		</display:table>
	</div>
</div>
<script type="text/javascript">
    //highlightTableRows("authoriy");
    function onDelete(id)
    {
    	var msg = "<fmt:message key="authoriy.deletemsg"/>";
    	ans = confirm(msg);
    	if(ans)
   		{
	    	var form = document.getElementById("deleteform");
	    	form.action = "${ctx}/user/authoriyform.html?delete=delete&authoriyid="+id;
	    	form.submit();
   		}
    }
</script>