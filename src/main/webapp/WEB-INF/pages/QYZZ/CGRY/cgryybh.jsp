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
	<title>采购人员/提货人员已驳回</title>
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
		<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;采购人员/提货人员&nbsp;>&nbsp;采购人员/提货人员已驳回</font>
		 <div class="tab_biao">
			 <shiro:hasPermission name="BuyerQualify_recorded">
			<a href="procurementStaffList.html?type=0"  ><span><font>录入</font>
			</span>
			</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="BuyerQualify_auditing">
			<a href="procurementStaffList.html?type=1"   ><span><font>审核</font>
			</span>
			</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="BuyerQualify_audited">
			<a href="procurementStaffList.html?type=2"><span><font>已审核</font>
			</span>
			</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="BuyerQualify_reject">
			<a href="procurementStaffList.html?type=3" class="on"><span><font>已驳回</font>
			</span>
			</a>
			</shiro:hasPermission>
		</div>

    	 <div class="tab_con">
        	<div class="caozuo_box">
        	<form name="query_sxrydlr" id="query_sxrydlr" action="queryProcurementStaffList.html" method="post">
               	姓名： <input name="queryName" id="query_qycx" type="text" class="text1" size="20"/>
               	人员类别：
               	&nbsp;采购人员&nbsp;<input type="radio" name="person_type" value="0">
               	&nbsp;提货人员&nbsp;<input type="radio" name="person_type" value="1">
               		<input type="hidden" name="type" value="3">
               	<shiro:hasPermission name="BuyerQualify_reject_find">
                <input name="" type="submit" class="btn_big" value="查询"/> 
                </shiro:hasPermission>
           </form>
            </div>
 			<display:table name="procurementStaffList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="procurement" pagesize="${pagesize}" class="table" export="true" size="${resultSize}" partialList="true">
 				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html"><input type="checkbox" name="delete_id" value="${procurement.id}" ></display:column>
 				<display:column property="procurementName" escapeXml="true" sortable="false" titleKey="姓名 " />
				<display:column escapeXml="true" sortable="false" titleKey="性别">
					<c:if test="${procurement.gender=='0'}">
						<c:out value="男"></c:out>
					</c:if>
					<c:if test="${procurement.gender=='1'}">
						<c:out value="女"></c:out>
					</c:if>
				
				</display:column>
				<display:column property="IDNumber" escapeXml="true" sortable="false" titleKey="身份证号"/>
				<display:column  escapeXml="true" sortable="false" titleKey="人员类别">
					<c:if test="${procurement.personType != null}">
						<c:if test="${procurement.personType eq '0'}">
							<c:out value="采购人员"/>
						</c:if>
						<c:if test="${procurement.personType eq '1'}">
							<c:out value="提货人员"/>
						</c:if>
					</c:if>
				</display:column>
				<shiro:hasPermission name="BuyerQualify_reject_look">
				<display:column titleKey="操作" autolink="true" media="html"  class="border_rnone">
				<img src="../images/look.gif"/><a href="editProcurementStaff.html?id=${procurement.id}&type=3">查看</a>
				</display:column>
				</shiro:hasPermission>
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>
            </div>
</body>
</html>