<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<br>
<script language="javascript" type="text/javascript"
	src="/zywx3/ext/scripts/validator/jquery.validate.js">
</script>
<br>
<script language="javascript" type="text/javascript"
	src="/zywx3/ext/scripts/validator/validateUtil.js">
</script>



<script type="text/javascript">
function backup() {
	history.go(-1);
	//self.location.reload();

}
</script>

<script type="text/javascript">
jQuery.validator.setDefaults( {
	submitHandler : function() {

		document.signupForm.submit;

	}
});

jQuery().ready(function() {
		jQuery("#signupForm").validate({
			/*errorLabelContainer: "#messageBox",		//显示错误信息的容器ID
			wrapper: "li",								//包含每个错误信息的容器*/
			rules:{
				configKey:{
					required: true,
					dataNo: true,
					rangelength: [2,20]
				},
				configValue:{
					required: true,
					rangelength: [2,200]
				}
				
			},
			messages:{
				configKey:{
					required: "<fmt:message key="configKey.nul"/>",
					dataNo: "<fmt:message key="configKey.error"/>",
					rangelength:"<fmt:message key="configKey.length"/>"
				},
				configValue:{
					required: "<fmt:message key="configValue.nul"/>",
					rangelength:"<fmt:message key="configValue.length"/>"
				}
				
			}
		});
		
	
	});
</script>
<head>
	<title><fmt:message key="sysConfigEdit.title" />
	</title>
</head>

<body>

	<div id="content">
		<div class="box_big">

			<form:form commandName="systemConfig" method="post"
				action="${ctx}/systemConfig/sysConfigEdit.html?method=edit"
				id="signupForm">
				<form:hidden path="configId" id="configId" />

				<div class="bj_biao">
					<h4>
						<fmt:message key="systemConfig.valuenull" />
					</h4>
				</div>
				<table border="0" cellspacing="0" cellpadding="0" class="table_cx2">
					<tr height="18"></tr>
					<tr>
						<th width="320">
							*
							<fmt:message key="systemConfig.configKey" />
							：
						</th>
						<td width="450">
							<form:input path="configKey" id="configKey" cssClass="text" />
						</td>
						<th width="320">
							*
							<fmt:message key="systemConfig.configValue" />
							：
						</th>
						<td width="450">
							<form:textarea path="configValue" id="configValue"   />
						</td>
					</tr>
					<tr>
						<th>
							<fmt:message key="systemConfig.configDes" />
							：
						</th>
						<td>
							<form:textarea path="configDes" id="configDes" />
						</td>
						<th></th>
						<td></td>
					</tr>




				</table>

				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr height="70" valign="top">
						<td align="center">
							<input type="submit" class="btn_blue2"
								value="<fmt:message key="button.save"/>" />
							<input onclick="backup();" type="button" class="btn_blue2"
								value="<fmt:message key='button.cancel'/>" />
						</td>
					</tr>
				</table>

				<input type="hidden" name="tz" value="${tzpage}" />
				<input type="hidden" name="pagename" value="${pagename}" />
				<input type="hidden" name="ptmeth" value="${ptmeth}" />
			</form:form>
		</div>
	</div>

</body>



