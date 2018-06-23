<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
    <title>菜单列表</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/ext/styles/display/display.css">
	<script type="text/javascript" src="${ctx}/js/easyui/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="<c:url value='/ext/scripts/display/displaypage.js'/>"></script>
</head>

<script type="text/javascript">
	function updateMenuConfig(type, menuId){
		window.parent.location.href="${ctx}/menuManage/update.html?type="+type+"&menuId="+menuId;
	}
	function deleteMenuConfig(menuId){
		var conFlag = confirm("确实要删除菜单？");
		if(conFlag){
			location.href = "${ctx}/menuManage/frame/deleteMenuConfig.html?menuId="+menuId;
		}
	}

	function addMenuConfig(){
		var menuId = '${menuId}';
		var flag = false;
		if(menuId == ''){
			flag = confirm("确定添加一级菜单？")
			if(flag){
				menuId = '-1';
			}
		}
		if(menuId != ''){
			window.parent.location.href='${ctx}/menuManage/update.html?type=add&menuId='+menuId;
		}
	}
	
	jQuery(function(){
		jQuery("#displayallpage").val(${displayallpage});
		jQuery("#tz").val(${thispage});
	});
</script>
<body style="background: none repeat scroll 0 0 #fff8ec;">
<div class="box_big">
	<form:form commandName="entity" method="post" action="${ctx}/menuManage/menuConfigeList.html" id="searchForm">
		<div class="bj_biao" onclick="hiddenselectcon();"><h4><fmt:message key="user.selectcon"/></h4></div>
		<div class="box5" id="selectcondiv" style="display: none;">
		<table border="0" cellspacing="0" cellpadding="0" class="table_cx2">
			<tr height="18">
				<th>
					菜单名称：
				</th>
				<td>
					<form:input path="menuName" cssClass="text4" cssStyle="width:80px;"/>
				</td>
				<th>
					唯一标识；
				</th>
				<td>
					<form:input path="uniqueKey" cssClass="text4"  cssStyle="width:80px;"/>
				</td>
				<th>
					父节点：
				</th>
				<td>
					<form:input path="parentId" cssClass="text3"/>
				</td>
			</tr>

		</table>
		</div>
		<table width="100%">
			<tr>
				<td align="left">
					<input type="button" onclick="javascript:addMenuConfig();" value="<fmt:message key="button.add"/>" class="btn_blue2"/>
				</td>
			</tr>
		</table>
	</form:form>
	<form id="deleteform" method="post">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
	</form>		
	<div class="ceng_mar5" style="500px;">
		<display:table name="entityList" cellspacing="0" cellpadding="0" requestURI="" style="width:100%;" id="entityList" pagesize="${pageSize}" class="table_cx" export="true" size="${resultSize}" partialList="true">
			<display:column property="id" escapeXml="true" sortable="true" titleKey="ID" />
			<display:column property="menuName" escapeXml="true" sortable="true" titleKey="菜单名称"/>
			<display:column property="uniqueKey" escapeXml="true" sortable="true" titleKey="唯一标识"/>
			<display:column property="controlUrl" escapeXml="true" sortable="true" titleKey="操作链接"/>
			<display:column property="authoriy.description" sortable="true" titleKey="对应权限" />
			<display:column property="parentId" sortable="true" titleKey="父菜单" />
			<display:column titleKey="操作" autolink="true" media="html" style="border-right:1px solid #feb808;">
				<a href="javascript:updateMenuConfig('edit','${entityList.id}');">修改</a>
				<a href="javascript:deleteMenuConfig('${entityList.id}');">删除</a>
			</display:column>
		    <display:setProperty name="export.pdf" value="false" /> 
			<display:setProperty name="export.csv" value="false" /> 
			<display:setProperty name="export.xml" value="false" /> 
		</display:table>
	</div>
</div>
</body>
</html>