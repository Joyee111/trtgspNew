<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<div id='nav2'>
<shiro:hasPermission name="SystemManage">
	<div id='nav2R' onmouseover='displaySubMenu(this)' onmouseout='hideSubMenu(this)'>
		<a href='javascript:void(0)'><span>系统管理</span></a>
		<ul>
			<shiro:hasPermission name="UserManage">
			<li>
				<a href="${ctx}/user/users.html?method=list"><fmt:message key="menu.sysmanage.sys1"/></a>
			</li>
			</shiro:hasPermission>
			<shiro:hasPermission name="RoleManage">
			<li>
				<a href="${ctx}/user/roleform.html?method=query&operate=select"><fmt:message key="menu.sysmanage.sys2"/></a>
			</li>
			</shiro:hasPermission>
			<shiro:hasPermission name="ResourceManage">
			<li>
				<a href="${ctx}/user/authoriyform.html?method=query"><fmt:message key="menu.sysmanage.sys3"/></a>
			</li>
			</shiro:hasPermission>
			<shiro:hasPermission name="ConfigManage">
			<li>
				<a href="${ctx}/systemConfig/sysConfigEdit.html?method=list"><fmt:message key="menu.sysmanage.sys4"/></a>
			</li>
			</shiro:hasPermission>
			<shiro:hasPermission name="LogManage">
			<li>
				<a href="${ctx}/systemConfig/sysLog.html?method=list"><fmt:message key="menu.sysmanage.sys5"/></a>
			</li>
            </shiro:hasPermission>
			<shiro:hasPermission name="CompanyManage">
			<li>
				<a href="${ctx}/systemConfig/sysLog.html?method=list"><fmt:message key="menu.sysmanage.sys6"/></a>
			</li>
            </shiro:hasPermission>
			<shiro:hasPermission name="DBManage">
			<li>
				<a href="${ctx}/systemConfig/sysLog.html?method=list"><fmt:message key="menu.sysmanage.sys7"/></a>
			</li>
            </shiro:hasPermission>
            <shiro:hasPermission name="dictmanage">
			<li>
				<a href="${ctx }/dictInfoManage/dictInfoFrame.html"><fmt:message key="menu.sysmanage.sys8"/></a>
			</li>
			</shiro:hasPermission>
         
			<shiro:hasPermission name="menumanage">
			<li>
				<a href="${ctx }/menuManage/menuConfigFrame.html">菜单配置</a>
			</li>
			</shiro:hasPermission>
			
		</ul>
	</div>
 </shiro:hasPermission>
</div>
