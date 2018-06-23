<%@ include file="/common/taglibs.jsp"%>
<head>
	<title><fmt:message key="userProfile.title"/></title>
	<script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>
<link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/themes/default/easyui.css">
<script type="text/javascript" src="${ctx}/js/easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    $(function() {
        $("#authoriyTree").tree({
            checkbox:true,
            cascadeCheck:false,
           onCheck:function(node){
            //	alert("Hellow");
          //  alert(node.checked);
            	if(isLeaf(node)){
            		alert("hellow");
            		if(node.checked==false){
            			uncheck(node);
            			check(node.getParent());
            		}
            	}
            },
            <c:if test="${param.method eq 'Add'}">
            url:"${ctx}/user/authoriyform.html?method=tree"
            </c:if>
            <c:if test="${param.method ne 'Add'}">
            url:"${ctx}/user/authoriyform.html?method=entireTree&roleId=${role.roleid}",
            </c:if>
        });
    });
</script>

<div class="box_big" style="height: 500px;overflow: scroll;">
<form:form commandName="role" method="post" action="roleform.html" id="roleForm">
	<form:hidden path="roleid" />
	<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>
	<input type="hidden" name="method" value="<c:out value="${param.method}"/>"/>
	<div class="bj_biao">
		<h4>
			<fmt:message key="role.baseheader"/>:
		</h4>
	</div>
	<table border="0" cellspacing="0" cellpadding="0" class="table_bj">
		<tr>
			<th width="80" class="fz_12"><fmt:message key="role.rolename"/><span class="required">*</span>:</th>
			<td width="200">
				
					<form:input path="rolename" id="name" cssClass="text"/>
				
				<input type="hidden" name="operator" value="${param.method}"/>
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${tzpage}"/>
				<input type="hidden" name="pagename" value="${pagename}"/>
			</td>
			<th width="140" class="fz_12"><fmt:message key="role.description"/>:</th>
			<td width="200"><form:input path="description" id="description" cssClass="text"/></td>
		  </tr>
	</table>
	<div class="bj_biao">
		<h4>
			<fmt:message key="role.assignAuthoriy"/>
		</h4>
	</div>
    <input type="hidden" name="permissons" id="permissons">
    <div id="authoriyTree" style="margin-left: 500px;" ></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center">
				<input type="button" class="btn_blue2" name="save" onclick="onSave();" value="<fmt:message key="button.save"/>" />
				<input type="button" class="btn_blue2" name="cancel" onclick="onCancel();" value="<fmt:message key="button.cancel"/>" />
			</td>
		</tr>
	</table>
</form:form>
</div>
<script type="text/javascript">
function onSave(){
    var nodes = $("#authoriyTree").tree("getChecked");
    var permissionIds="";
    $(nodes).each(function() {
        permissionIds+=this.id;
        permissionIds+=",";
    });
    $("#permissons").val(permissionIds);
    $("#roleForm").submit();
}
function onCancel()
{
	history.go(-1);
}
</script>