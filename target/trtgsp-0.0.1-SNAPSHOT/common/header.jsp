<%@ include file="/common/taglibs.jsp"%>
<div class="language">
	<div class="language_di">
		<div class="language_con" id="language" style="height: 25px;"
			onmouseover="languageDo()" onmouseout="xialaNo()">
			<p>
				<a href="<c:url value='/?locale=zh_CN'/>"><fmt:message key="header.language.chinese"/></a>
			</p>
			<p>
				<a href="<c:url value='/?locale=en'/>"><fmt:message key="header.language.english"/></a>
			</p>
		</div>
	</div>
</div>
<%-- Put constants into request scope --%>
<appfuse:constants scope="request" />