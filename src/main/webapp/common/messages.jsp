<%-- Error Messages --%>
<c:if test="${not empty errors}">
    <div style="margin-top: 5px;" id="errorMessages">
        <c:forEach var="error" items="${errors}">
            <img src="<c:url value="/images/iconWarning.gif"/>"
                alt="<fmt:message key="icon.warning"/>" class="icon" />
            <c:out value="${error}"/><br />
        </c:forEach>
    </div>
    <c:remove var="errors"/>
</c:if>

<%-- Success Messages --%>
<c:if test="${not empty successMessages}">
    <div class="message" id="successMessages">
        <c:forEach var="msg" items="${successMessages}">
            <img src="<c:url value="/images/iconInformation.gif"/>"
                alt="<fmt:message key="icon.information"/>" class="icon" />
            <c:out value="${msg}"/><br />
        </c:forEach>
    </div>
    <c:remove var="successMessages" scope="session"/>
</c:if>
