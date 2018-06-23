<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="userProfile.title"/></title>
</head>
<link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/themes/default/easyui.css">
<script type="text/javascript" src="${ctx}/js/easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    $(function() {
        $("#authoriyTree").tree({
           url:"${ctx}/user/authoriyform.html?method=tree",
            onSelect:function(node) {
              $("#parentDesc").val(node.text);
                $("#parentId").val(node.id);
            }
        });

    });
jQuery.validator.setDefaults( {
	submitHandler : function() {
		document.userForm.submit;
	}
});

jQuery().ready(function() {
		jQuery("#roleForm").validate({
			rules:{
				authoriyname:{
					required: true
				},
				description:{
					required: true
				}
			},
			messages:{
				authoriyname:{
					required: "<fmt:message key="validate.authoriyname.nul"/>"
				},
				description:{
					required: "<fmt:message key="validate.description.nul"/>"
				}
			}
		});
	});
</script>
<div class="box_big" style="height: 400px;overflow: scroll">
<form:form commandName="authoriy" method="post" action="authoriyform.html" id="roleForm">
<form:hidden path="authoriyid"/>
<div class="bj_biao"style="text-align: center">
	<h4>
		<fmt:message key="authoriy.baseheader"/>:
	</h4>
</div>
   <ul style="list-style: none">
       <p>选择父节点</p>
       <li style="float: left;width: 30%;">
<div id="authoriyTree"></div>
       </li>
    <li style="float: left">
    <table border="0" cellspacing="0" cellpadding="0" class="table_bj">
	<tr>
		<th width="200">
			<fmt:message key="authoriy.name"/><span class="required">*</span>:
		</th>
		<td width="460">
			
				<form:input path="authoriyname" id="name" cssClass="text"/>
			
		</td>
	</tr>
	<tr>
		<th>
			<fmt:message key="authoriy.description"/><span class="required">*</span>:
		</th>
		<td>
			<form:input path="description" id="description" cssClass="text"/>
		</td>
	</tr>
	<tr>
		<th>
			<fmt:message key="authoriy.parentid"/><span class="required">*</span>:
		</th>
		<td>
			<input type="text" id="parentDesc" value="${parent.description}" readonly>
            <input type="hidden" name="parentid" id="parentId" value="${parent.authoriyid}">
		</td>
	</tr>
	<tr style="text-align: center">
		<td >
			<input type="submit" class="btn_blue2" name="save" value="<fmt:message key="button.save"/>"/>
        	<input type="button" class="btn_blue2" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="onCancel()"/>
		</td>
	</tr>
</table>
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>
<input type="hidden" name="method" value="<c:out value="${param.method}"/>"/>
    </li>
   </ul>
</form:form>

</div>
<script type="text/javascript">
function onCancel()
{
	window.location.href="${ctx}/user/authoriyform.html?method=query";
}
</script>


