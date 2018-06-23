<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>">
</script>
<head>
	<title><fmt:message key="sysConfigList.title" />
	</title>
</head>

<script language="javascript" type="text/javascript"
	src="/zywx3/ext/scripts/display/displaypage.js">
</script>
<script type="text/javascript">
function deleteornot(str) {
	var del_str = "<fmt:message key='collect.delete_or_not'/>";

if (!confirm(del_str)) {
	}else{
		var pt = document.getElementById("ptmeth").value; 
		window.location = "${ctx}/systemConfig/sysConfigEdit.html?method=delete&ptmeth="+pt+"&configId="+str+"&tz="+${thispage};
	}
}


jQuery(function() {
	
	
	jQuery("#displayallpage").val(${displayallpage});
	jQuery("#tz").val(${thispage});})

</script>


<body>
	<div id="content">
		<div class="box_big">

			<form:form commandName="systemConfig" method="post"
				action="${ctx}/systemConfig/sysConfigEdit.html?method=select">



				<div onclick="hiddenselectcon();" class="bj_biao">
					<h4>
						<fmt:message key="user.selectcon" />
					</h4>
				</div>
				<div style="display: none;" id="selectcondiv" class="box4">
					<table border="0" cellspacing="0" cellpadding="0" class="table_cx2">
						<tr>

							<th width="10%">
								<fmt:message key="systemConfig.configKey" />
								：
							</th>
							<td width="10%">
								<form:input path="configKey" id="configKey" />
							</td>
							<th width="10%">
								<fmt:message key="systemConfig.createTime" />
								：
							</th>
							<td width="30%">
								<form:input path="btime" id="btime" cssClass="Wdate" size="12"
									onclick="WdatePicker({dateFmt:'yyyy-MM-dd ',lang:'${lang}'})" />
								<fmt:message key="zywx.timefrom" />
								<form:input path="etime" id="etime" cssClass="Wdate" size="12"
									onclick="WdatePicker({dateFmt:'yyyy-MM-dd ',lang:'${lang}'})" />
							</td>


							<td width="10%">

								<input type="submit" class="btn_blue2"
									value="<fmt:message key="button.search"/>" />
							</td>

						</tr>


					</table>
					<%--
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr height="50" valign="top">
							<td align="center">
								<input type="submit" class="btn_blue2"
									value="<fmt:message key="button.search"/>" />
							</td>
						</tr>
					</table>

				--%>
				</div>

			</form:form>

			<input type="button" class="btn_blue2"
				onclick="location.href='<c:url value="/systemConfig/sysConfigEdit.html?method=inedit"/>'"
				value="<fmt:message key="button.add"/>" />
				
			<input type="hidden" id="ptmeth" value="${ptmeth}" />

			<display:table name="sysConfigList" cellspacing="0" cellpadding="0"
				requestURI="" partialList="true" size="${resultSize}"
				style="width:100%;" class="table_cx" defaultsort="4" defaultorder="descending"
				id="systemConfig" pagesize="10" export="true">


				<display:column property="configKey" escapeXml="true"
					sortable="true" titleKey="systemConfig.configKey" maxLength="10"
					style="width: 20%;border-left:1px solid #feb808;" />

				<display:column property="configValue" sortable="true"
					maxLength="10" titleKey="systemConfig.configValue"
					style="width: 20%" />

				<display:column property="configDes" sortable="true"
					titleKey="systemConfig.configDes" style="width: 20%" />
				<display:column property="createTime" sortable="true"
					format="{0,date,yyyy-MM-dd HH:mm:ss}" maxLength="10"
					titleKey="systemConfig.createTime" style="width: 20%" />

				<display:column style="width: 10%;border-right:1px solid #feb808;"
					titleKey="product.opt">

					<a
						href="${ctx}/systemConfig/sysConfigEdit.html?method=inedit&configId=${systemConfig.configId}&tz=${thispage}&ptmeth=${ptmeth}"><fmt:message
							key="button.update" /> </a>
					<a href="#" onclick="deleteornot(${systemConfig.configId});"><fmt:message
							key="button.delete" /> </a>
				</display:column>

				<display:setProperty name="export.pdf" value="false" />
				<display:setProperty name="export.csv" value="false" />
				<display:setProperty name="export.xml" value="false" />

			</display:table>
		</div>
	</div>
</body>
