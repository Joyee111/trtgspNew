<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<li onmouseover='displaySubMenu(this)' onmouseout='hideSubMenu(this)'>
	<a href='${ctx}/indexPage.html'><span>首页</span></a>
</li>
<li onmouseover='displaySubMenu(this)' onmouseout='hideSubMenu(this)'>
	<a href='javascript:void(0)'><span>人员管理</span></a>
	<ul>
		<shiro:hasPermission name="usermanage">
		<li>
			<a href="${ctx}/perInfoManage/perInfoFrame.html?type=Search">人员信息查询</a>
		</li>
		</shiro:hasPermission>
		<shiro:hasPermission name="rolemanage">
		<li>
			<a href="${ctx}/perInfoManage/perInfoFrame.html?type=Manage">人员信息管理</a>
		</li>
		</shiro:hasPermission>
	</ul>
</li>
<li onmouseover='displaySubMenu(this)' onmouseout='hideSubMenu(this)'>
	<a href='javascript:void(0)'><span>劳资管理</span></a>
	<ul>
		<li><a href="${ctx}/contractInfoManage/contractInfoFrame.html">合同信息查询</a></li>
		<li ><a href="${ctx}/contractInfoManage/manageConInfoFrame.html?deptId=1">合同信息维护</a></li>
        <li><a href="${ctx}/salaryInfoManage/salaryInfoFrame.html?type=view">薪资信息查询</a></li>
        <li><a href="${ctx}/salaryInfoManage/salaryInfoFrame.html?type=edit">薪资信息维护</a></li>
	</ul>
</li>
<li onmouseover='displaySubMenu(this)' onmouseout='hideSubMenu(this)'>
	<a href='javascript:void(0)'><span>党委团委管理</span></a>
	<ul>
		<li><a href="${ctx}/partyInfoManage/partyOrgFrame.html">党组织信息管理</a></li>
		<li><a href="javascript:void(0)">党干部管理</a></li>
		<li><a href="javascript:void(0)">党员管理</a></li>
		<li><a href="javascript:void(0)">党会议管理</a></li>
	</ul>
</li>
<li onmouseover='displaySubMenu(this)' onmouseout='hideSubMenu(this)'>
	<a href='javascript:void(0)'><span>系统基础编码维护</span></a>
	<ul>
		<li onmouseover='displaySubMenu(this)' onmouseout='hideSubMenu(this)' >
			<a href='javascript:void(0)'>人员编码管理</a>
			<ul>
				<shiro:hasPermission name="usermanage">
				<li>
					<a href="${ctx}/perInfoManage/perColuList.html?method=list">人员基础编码</a>
				</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="rolemanage">
				<li>
					<a href="${ctx}/degreeInfoManage/baseColumnList.html?method=list">学历基础编码</a>
				</li>
				<li>
					<a href="${ctx}/positionInfoManage/baseColumnList.html?method=EmployeePost">岗位基础编码</a>
				</li>
				<li>
					<a href="${ctx}/performanceInfoManage/baseColumnList.html?method=EmployeePerformance">业绩基础编码</a>
				</li>
				<li>
					<a href="${ctx}/jobTitleInfoManage/baseColumnList.html?method=EmployeeStafftitles">职称基础编码</a>
				</li>
				<li>
					<a href="${ctx}/skillLevelInfoManage/baseColumnList.html?method=industrialGrade">技能等级基础编码</a>
				</li>
				<li>
					<a href="${ctx}/politicalInfoManage/baseColumnList.html?method=PoliticalInfo">政治面貌基础编码</a>
				</li>
				<li>
					<a href="${ctx}/contactsInfoManage/baseColumnList.html?method=EmployeeContacts">通讯基础编码</a>
				</li>
				<li>
					<a href="${ctx}/trainInfoManage/baseColumnList.html?method=TrainingInformation">培训基础编码</a>
				</li>
				</shiro:hasPermission>
			</ul>
		</li>

		<shiro:hasPermission name="authoriymanage">
		<li>
			<a href="${ctx}/group/groupInfoFrame.html">组织结构编码</a>
		</li>
		</shiro:hasPermission>
		<shiro:hasPermission name="usermanage">
		<li>
			<a href="${ctx}/contractInfoManage/columnList.html?method=list">合同基础编码</a>
		</li>
        <li>
			<a href="${ctx}/salaryColumnManage/columnList.html?columnTypeId=BaseSalary">基本工资编码</a>
		</li>
        <li>
			<a href="${ctx}/salaryColumnManage/columnList.html?columnTypeId=RewardSalary">奖金基础编码</a>
		</li>
        <li>
			<a href="${ctx}/salaryColumnManage/columnList.html?columnTypeId=OtherSalary">其他工资编码</a>
		</li>
		</shiro:hasPermission>
		<shiro:hasPermission name="usermanage">
		<li onmouseover='displaySubMenu(this)' onmouseout='hideSubMenu(this)' >
			<a href='javascript:void(0)'>党组织管理</a>
			<ul>
				<li><a href="${ctx}/partyInfoManage/coluList.html?method=list&columnTypeId=PartyOrganization">党组织基础编码</a></li>
				<li><a href="${ctx}/partyInfoManage/coluList.html?method=list&columnTypeId=PartyLeader">干部基础编码</a></li>
				<li><a href="${ctx}/partyInfoManage/coluList.html?method=list&columnTypeId=PartyRecord">干部履历基础编码</a></li>
				<li><a href="${ctx}/partyInfoManage/coluList.html?method=list&columnTypeId=PartyMember">党员基础编码</a></li>
				<li><a href="${ctx}/partyInfoManage/coluList.html?method=list&columnTypeId=PartyMeet">会议基础编码</a></li>
			</ul>
		</li>
		</shiro:hasPermission>
	</ul>
</li>
