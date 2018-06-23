<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	 <title>首营企业已审核</title>
    <script type="text/javascript">
	function check(){
		var field=document.getElementsByName("delete_id");
		var j =1;
		for (i = 0; i < field.length; i++) {
				if(field[i].checked = false){
					document.getElementById("checkall").checked = false;
					return;
				}
				j++;
		}
		if(j==field.length){
			document.getElementById("checkall").checked = true;
		}
	}
    </script>
</head>
<body>
		<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;首营企业&nbsp;>&nbsp;首营企业已审核</font>
		<div class="tab_biao">
			 <shiro:hasPermission name="FirstEnterprise_recorded">
			<a href="syqydlr.html" ><span><font>录入</font>
			</span>
			</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="FirstEnterprise_auditing">
			<a href="syqydsh.html" ><span><font>审核</font>
			</span>
			</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="FirstEnterprise_audited">
			<a href="syqyysh.html"  class="on"><span><font>已审核</font>
			</span>
			</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="FirstEnterprise_reject">
			<a href="syqyybh.html"><span><font>已驳回</font>
			</span>
			</a>
		</shiro:hasPermission>
		</div>

		<div class="tab_con">
			<div class="caozuo_box">
				<form name="query_syqyysh" id="query_syqyysh"
					action="query_syqyysh.html" method="post">
					企业/法人名称
					<input name="query_qycx" id="query_qycx" type="text" class="text1"
						size="20" />
					&nbsp;&nbsp;&nbsp;&nbsp;<!-- 证照号
					<input name="query_zjhm" id="query_zjhm" type="text" class="text1"
						size="20" /> -->
					<shiro:hasPermission name="FirstEnterprise_audited_find">
					<input name="" type="submit" class="btn_big" value="查询" />
					</shiro:hasPermission>
				</form>
			</div>
				<form name="audited_syqyysh" action="" id="audited_syqyysh" method="post" >
 			<display:table name="firstEnterAuditedList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="auditedEnter" pagesize="${pagesize}" class="table" export="true" size="${resultSize}" partialList="true">
 				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html"><input type="checkbox" name="delete_id" value="${auditedEnter.id}" ></display:column>
 				<display:column property="companyName" escapeXml="true" sortable="false" titleKey="企业名称" />
				<display:column property="corporation" escapeXml="true" sortable="false" titleKey="法人代表/负责人"/>
				<display:column property="business_licence_date" escapeXml="true" sortable="false" titleKey="营业执照到期时间"/>
				<display:column property="licence_date" escapeXml="true" sortable="false" titleKey="经营/生产许可证到期时间"/>
				<display:column property="gsp_certificate_date" escapeXml="true" sortable="false" titleKey="GSP/GMP证书截止日期"/>
				<display:column property="organization_code_date" escapeXml="true" sortable="false" titleKey="组织机构代码到期时间"/>
				<display:column property="organization_code_inspection_date" escapeXml="true" sortable="false" titleKey="组织机构代码年检日"/>
				<display:column property="quality_assurance_date" escapeXml="true" sortable="false" titleKey="质量保证协议到期日"/>
				<display:column property="authorization_date" escapeXml="true" sortable="false" titleKey="授权委托书到期日"/>
				<shiro:hasPermission name="FirstEnterprise_audited_look">
				<display:column titleKey="操作" autolink="true" media="html" class="border_rnone">
				 <img src="../images/look.gif"/><a href="view_syqyysh.html?id=${auditedEnter.id }">查看</a>
				</display:column>
				</shiro:hasPermission>
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>
			</form>
		</div>
	<script type="text/javascript">
	function delFirsrEnterprise(){
		var from =document.getElementById("del_syqydlr");
		var r=confirm("是否确认删除！")
		if(r){
			from.submit();
		}else{
			return;
		}
	}
    </script>
</body>
</html>