<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="roleList.title"/></title>
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
<div class="box_big" style="height: 500px;">
<form method="post" action="${ctx}/user/roleform.html?method=query&operate=select" id="searchForm">
	<div class="bj_biao" onclick="hiddenselectcon();"><h4><fmt:message key="user.selectcon"/></h4></div>
	<div class="box5" id="selectcondiv" style="">
		<table  border="0" cellspacing="0" cellpadding="0" class="table_bj">
			<tr height="18">
				<th width="100">
					<fmt:message key="role.rolename"/>:
				</th>
				<td width="200">
					<input type="text" size="20" name="rolename" id="query" value="${param.rolename}" class="text4"/>
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
	<table align="left" width="100%">
		<shiro:hasPermission name="RoleManage_add">
		<tr>
			<td align="left"><input type="button" onclick="location.href='<c:url value="/user/roleform.html?method=Add&from=list"/>'" value="<fmt:message key="button.add"/>" class="btn_big"/></td>
		</tr>
		</shiro:hasPermission>
	</table>
</form>
<form id="deleteform" method="post">
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type="hidden" name="tz" value="${thispage}"/>
</form>
<display:table name="roleList" cellspacing="0" cellpadding="0"
	requestURI="" id="roles" pagesize="${pagesize}" class="table" style="width:98%;" export="true" size="${resultSize}" partialList="true">
	<display:column property="roleid" titleKey="ID" escapeXml="true" sortable="true" />
	<display:column property="rolename" escapeXml="true" sortable="true" titleKey="role.rolename" paramId="id" paramProperty="id" />
	<display:column property="createtime" titleKey="role.createtime" sortable="true" format="{0,date,yyyy-MM-dd HH:mm:ss}" maxLength="10"/>
	<display:column property="createuser" titleKey="role.creater" sortable="true"/>
	<display:column property="description" sortable="true" titleKey="role.description"
		style="width: 40%" autolink="true" media="html" />
	<display:column titleKey="user.operate" style="width:13%; border-right:1px solid #feb808;" media="html">
	<%--<shiro:hasPermission name="RoleManage_modify">--%>
	<a href="${ctx}/user/roleform.html?method=update&id=<c:out value="${roles.roleid}&tz=${thispage}&ptmeth=${ptmeth}"/>">
		<fmt:message key="button.update"/>
	</a>
	<%--</shiro:hasPermission>--%>
	&nbsp;&nbsp;&nbsp;
	<shiro:hasPermission name="RoleManage_del">
	<a onclick="onDelete(<c:out value="${roles.roleid}"/>)">
		<fmt:message key="button.delete"/>
	</a>
	</shiro:hasPermission>
	</display:column>
	<display:setProperty name="export.pdf" value="false" /> 
	<display:setProperty name="export.csv" value="false" /> 
	<display:setProperty name="export.xml" value="false" /> 
</display:table>
</div>
<script type="text/javascript">
    highlightTableRows("roles");
    function onDelete(id)
    {
    	var msg = "<fmt:message key="role.deletemsg"/>";
    	ans = confirm(msg);
    	if(ans)
   		{
	    	var form = document.getElementById("deleteform");
	    	form.action = "${ctx}/user/roleform.html?delete=delete&roleid="+id;
	    	form.submit();
   		}
    }
</script>