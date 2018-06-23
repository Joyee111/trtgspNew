<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:forEach items="${leftMenuList}" var="leftMenu">
    <shiro:hasPermission name="${leftMenu.authoriy.authoriyname}">
	<li onmouseover='displaySubMenu(this)' onmouseout='hideSubMenu(this)'>
		<!-- 一级菜单 -->
		<c:if test="${fn:contains(leftMenu.controlUrl,'javascript')}">
			<a href="${leftMenu.controlUrl}"><span>${leftMenu.menuName}</span></a>
		</c:if>
		<c:if test="${fn:contains(leftMenu.controlUrl,'javascript') == false}">
			<a href="${ctx }${leftMenu.controlUrl}"><span>${leftMenu.menuName}</span></a>
		</c:if>
		<c:if test="${fn:length(leftMenu.child) > 0}">
			<ul>
				<c:forEach items="${leftMenu.child}" var="item1">
                    <shiro:hasPermission name="${item1.authoriy.authoriyname}">
					<li onmouseover='displaySubMenu(this)' onmouseout='hideSubMenu(this)'>
						<!-- 二级菜单 -->
						<c:if test="${fn:contains(item1.controlUrl,'javascript')}">
							<a href="${item1.controlUrl}">${item1.menuName}</a>
						</c:if>
						<c:if test="${fn:contains(item1.controlUrl,'javascript') == false}">
							<a href="${ctx }${item1.controlUrl}">${item1.menuName}</a>
						</c:if>

						<c:if test="${fn:length(item1.child) > 0}">
							<ul>
								<c:forEach items="${item1.child}" var="item2">
									<li>
										<!-- 三级菜单 -->
										
										<c:if test="${fn:contains(item2.controlUrl,'javascript')}">
											<a href="${item2.controlUrl}">${item2.menuName}</a>
										</c:if>
										<c:if test="${fn:contains(item2.controlUrl,'javascript') == false}">
											<a href="${ctx }${item2.controlUrl}">${item2.menuName}</a>
										</c:if>
									</li>
								</c:forEach>
							</ul>
						</c:if>
					</li>
                    </shiro:hasPermission>
				</c:forEach>
			</ul>
		</c:if>
	</li>
    </shiro:hasPermission>
</c:forEach>