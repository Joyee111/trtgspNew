<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>">
</script>
<head>
	<title><fmt:message key="sysLogList.title" />
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

			<form:form commandName="systemLog" method="post"
				action="${ctx}/systemConfig/sysLog.html?method=select">



				<div onclick="hiddenselectcon();" class="bj_biao">
					<h4>
						<fmt:message key="user.selectcon" />
					</h4>
				</div>
				<div style="display: none;" id="selectcondiv" class="box4">
					<table border="0" cellspacing="0" cellpadding="0" class="table_cx2">
						<tr>

							<th width="10%">
								<fmt:message key="systemLog.logType" />
								：
							</th>
							<td width="10%">
								<form:select path="logType" id="logType" >
								<form:option value=''><fmt:message key="common.pleaseselect"/></form:option>
								<c:forEach var="str" items="${logType}">
									<form:option value='${str}'>${str}</form:option>
								</c:forEach>
								</form:select>
							</td>
							<th width="10%">
								<fmt:message key="systemLog.createTime" />
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
				</div>

			</form:form>


			<input type="hidden" id="ptmeth" value="${ptmeth}" />

			<display:table name="sysLogList" cellspacing="0" cellpadding="0"
				requestURI="" partialList="true" size="${resultSize}" defaultorder="descending"
				style="width:100%;" class="table_cx" id="systemLog"
				pagesize="10" export="true">
				<c:if test="${systemLog.logType=='info'}">
					<display:column property="logType" escapeXml="true" sortable="true"
						titleKey="systemLog.logType"
						style="width: 10%;border-left:1px solid #feb808;color:#6699ff;" />
				</c:if>

				<c:if test="${systemLog.logType=='info'}">

					<display:column property="description" sortable="true"
						maxLength="50" titleKey="systemLog.description" style="width: 80%;color:#6699ff;" />
				</c:if>
				<c:if test="${systemLog.logType=='info'}">
					<display:column property="createTime" sortable="true"
						format="{0,date,yyyy-MM-dd HH:mm:ss}" maxLength="10"
						titleKey="systemLog.createTime" style="width: 10%;color:#6699ff;" />

				</c:if>

				<c:if test="${systemLog.logType=='warn'}">
					<display:column property="logType" escapeXml="true" sortable="true"
						titleKey="systemLog.logType"
						style="width: 10%;border-left:1px solid #feb808;color:#ff9900;" />
				</c:if>
				
				<c:if test="${systemLog.logType=='warn'}">

					<display:column property="description" sortable="true"
						maxLength="50" titleKey="systemLog.description" style="width: 80%;color:#ff9900;" />
				</c:if>
				<c:if test="${systemLog.logType=='warn'}">
					<display:column property="createTime" sortable="true"
						format="{0,date,yyyy-MM-dd HH:mm:ss}" maxLength="10"
						titleKey="systemLog.createTime" style="width: 10%;color:#ff9900;" />

				</c:if>
				
				
				<c:if test="${systemLog.logType=='debug'}">
					<display:column property="logType" escapeXml="true" sortable="true"
						titleKey="systemLog.logType"
						style="width: 10%;border-left:1px solid #feb808;color:#000000;" />
				</c:if>
				
				<c:if test="${systemLog.logType=='debug'}">

					<display:column property="description" sortable="true"
						maxLength="50" titleKey="systemLog.description" style="width: 80%;color:#000000;" />
				</c:if>
				<c:if test="${systemLog.logType=='debug'}">
					<display:column property="createTime" sortable="true"
						format="{0,date,yyyy-MM-dd HH:mm:ss}" maxLength="10"
						titleKey="systemLog.createTime" style="width: 10%;color:#000000;" />

				</c:if>
				
				<c:if test="${systemLog.logType=='error'}">
					<display:column property="logType" escapeXml="true" sortable="true"
						titleKey="systemLog.logType"
						style="width: 10%;border-left:1px solid #feb808;color:#ff0000;" />
				</c:if>
				
				<c:if test="${systemLog.logType=='error'}">

					<display:column property="description" sortable="true"
						maxLength="50" titleKey="systemLog.description" style="width: 80%;color:#ff0000;" />
				</c:if>
				<c:if test="${systemLog.logType=='error'}">
					<display:column property="createTime" sortable="true"
						format="{0,date,yyyy-MM-dd HH:mm:ss}" maxLength="10"
						titleKey="systemLog.createTime" style="width: 10%;color:#ff0000;" />

				</c:if>


				<display:setProperty name="export.pdf" value="false" />
				<display:setProperty name="export.csv" value="false" />
				<display:setProperty name="export.xml" value="false" />

			</display:table>
		</div>
	</div>
</body>
