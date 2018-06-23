<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="userList.title"/></title>
    <script type="text/javascript" src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
</script>
<script type="text/javascript"
	src="/zywx3/ext/scripts/user/selectarea.js">
</script>
<script>
jQuery(function(){
		jQuery("#displayallpage").val(${displayallpage});
		jQuery("#tz").val(${thispage});
	});
</script>
<div class="box_big" style="height: 500px">
<form:form commandName="user" method="post" action="${ctx}/user/users.html?method=select" id="searchForm">
	<div class="bj_biao" onclick="hiddenselectcon();"><h4><fmt:message key="user.selectcon"/></h4></div>
	<div class="box5" id="selectcondiv" >
	<table border="0" cellspacing="0" cellpadding="0" class="table_cx2">
		<tr height="18">
			<th>
				<fmt:message key="user.username"/>:
			</th>
			<td>
				<form:input path="username" cssClass="text4" cssStyle="width:80px;"/>
			</td>
			<th>
				<fmt:message key="user.realname"/>:
			</th>
			<td>
				<form:input path="realname" cssClass="text4"  cssStyle="width:80px;"/>
			</td>
			<th>
				<fmt:message key="user.islocked"/>:
			</th>
			<td>
				<form:select path="islocked" cssClass="text4" cssStyle="width:60px;">
	            	<option value=""><fmt:message key="common.pleaseselect"/></option>
	            	<form:option value="1"><fmt:message key="user.locked"/></form:option>
	            	<form:option value="2"><fmt:message key="user.nolocked"/></form:option>
	            </form:select>
			</td>
		</tr>
		<tr>
			
			
		</tr>
		<tr>
			<th>
				<fmt:message key="user.registertime"/>:
			</th>
			<td colspan="3">
				<form:input path="starttime"  class="easyui-datebox"/>
				<fmt:message key="order.to"/>
				<form:input path="endtime" class="easyui-datebox"/>
			</td>
			
			<td><input type="submit" value="<fmt:message key="button.search"/>" class="btn_blue2"/></td>
			
		</tr>
	</table>
	</div>
	<table width="98%">
		<tr>
			<td align="left">
				<shiro:hasPermission name="UserManage_add">
				<input type="button" onclick="location.href='<c:url value="/user/userform.html?method=add"/>'" value="<fmt:message key="button.add"/>" class="btn_big"/>
				</shiro:hasPermission>
			</td>
		</tr>
	</table>
</form:form>
<form id="deleteform" method="post">
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type="hidden" name="tz" value="${thispage}"/>
</form>
<div class="ceng_mar5">
<display:table name="userList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="users" pagesize="${pagesize}" class="table" export="true" size="${resultSize}" partialList="true">
	<display:column property="username" escapeXml="true" sortable="true" titleKey="user.username" />
	<display:column property="realname" escapeXml="true" sortable="true" titleKey="user.realname"/>
	<%--<display:column property="company" escapeXml="true" sortable="true" titleKey="user.companytable"/>--%>
	<display:column property="registertime" sortable="true" titleKey="user.registertime" decorator="com.sinosoft.util.FormatDateColumnDecorator" maxLength="15"/>
	<%--<display:column escapeXml="true" sortable="true" titleKey="user.territory">
	<c:forEach var="t" items="${territory}">
		<c:if test="${t.key eq users.territory}">
			${t.value}
		</c:if>
	</c:forEach>
	</display:column>--%>
	<display:column escapeXml="true" sortable="true" titleKey="user.roles" maxLength="100" style="width:15%;">
		<c:forEach var="r" items="${users.roles}" varStatus="state">
			<c:if test="${state.index == 0}">${r.rolename}</c:if><c:if test="${state.index != 0}">,${r.rolename}</c:if>
		</c:forEach>
	</display:column>
	<display:column escapeXml="true" titleKey="user.islocked">
		<c:if test="${users.islocked != null}">
			<c:if test="${users.islocked eq '1'}"><fmt:message key="user.locked"/></c:if>
			<c:if test="${users.islocked eq '2'}"><fmt:message key="user.nolocked"/></c:if>
		</c:if>
	</display:column>
	<display:column titleKey="user.operate" autolink="true" media="html" style="border-right:1px solid #feb808;">
		<shiro:hasPermission name="UserManage_modify">
		<a href="${ctx}/user/userform.html?method=update&id=<c:out value="${users.id}"/>&tz=${thispage}&ptmeth=${ptmeth}">
			<fmt:message key="button.update"/>
		</a>
		</shiro:hasPermission>
		&nbsp;&nbsp;&nbsp;
		<shiro:hasPermission name="UserManage_del">
		<a onclick="onDelete(<c:out value="${users.id}"/>)">
			<fmt:message key="button.delete"/>
		</a>
		</shiro:hasPermission>
	</display:column>
    <display:setProperty name="export.pdf" value="false" /> 
	<display:setProperty name="export.csv" value="false" /> 
	<display:setProperty name="export.xml" value="false" /> 
</display:table>
</div>
</div>
<script type="text/javascript">
   //highlightTableRows("users");
    function onDelete(id)
    {
    	var msg = "<fmt:message key="user.deletemsg"/>";
    	ans = confirm(msg);
    	if(ans)
   		{
	    	var form = document.getElementById("deleteform");
	    	form.action = "${ctx}/user/saveuser.html?delete=delete&id="+id;
	    	form.submit();
   		}
    }
    
</script>