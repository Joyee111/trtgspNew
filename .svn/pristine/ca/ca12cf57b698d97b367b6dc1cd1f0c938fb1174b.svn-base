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
	<title>购货单位录入</title>
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
		<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;购货单位&nbsp;>&nbsp;购货单位录入</font>
	 	<div class="tab_biao">
			<shiro:hasPermission name="PurchaseUnit_recorded">
				<a href="ghdwdlr.html" class="on"><span><font>录入</font>
				</span>
				</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="PurchaseUnit_auditing">
				<a href="ghdwdsh.html"><span><font>审核</font>
				</span>
				</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="PurchaseUnit_audited">
				<a href="ghdwysh.html"><span><font>已审核</font>
				</span>
				</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="PurchaseUnit_reject">
				<a href="ghdwybh.html"><span><font>已驳回</font>
				</span>
				</a>
			</shiro:hasPermission>
		</div>
        <div class="tab_con">
        	<div class="caozuo_box">
        	<form name="query_ghdwdlr" id="query_ghdwdlr" action="query_ghdwdlr.html" method="post">
             	   企业/法人名称 <input name="query_qycx" id="query_qycx" type="text" class="text1" size="20"/>
                &nbsp;&nbsp;&nbsp;&nbsp;<!-- 证照号 <input name="query_zjhm" id="query_zjhm" type="text" class="text1" size="20"/> -->
                <shiro:hasPermission name="PurchaseUnit_recorded_find">
                <input name="" type="submit" class="btn_big" value="查询"/>
                </shiro:hasPermission>
            </form>
          </div>
          <form name="del_ghdwdlr" action="delte_ghdwdql.html" id="del_ghdwdlr" method="post" >
           	<display:table name="purchaseUnitsList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="purchaseUnit" pagesize="${pagesize}" class="table" export="true" size="${resultSize}" partialList="true">
 				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html"><input type="checkbox" name="delete_id" value="${purchaseUnit.id}" ></display:column>
 				<display:column property="customerNumber" escapeXml="true" sortable="false" titleKey="客户编码" />
 				<display:column property="companyName" escapeXml="true" sortable="false" titleKey="企业名称" />
				<display:column property="corporation" escapeXml="true" sortable="false" titleKey="法定代表人/负责人"/>
				<display:column property="address" escapeXml="true" sortable="false" titleKey="企业地址"/>
				<display:column property="postalCode" escapeXml="true" sortable="false" titleKey="邮编"/>
				<display:column  escapeXml="true" sortable="false" titleKey="企业经营类型">
					<c:choose>
						<c:when test="${purchaseUnit.economicNature eq '1'}">
							<c:out value="批发"></c:out>
						</c:when>
						<c:when test="${purchaseUnit.economicNature eq '2'}">
							<c:out value="零售"></c:out>
						</c:when>
						<c:when test="${purchaseUnit.economicNature eq '3'}">
							<c:out value="零售（连锁）"></c:out>
						</c:when>
						<c:when test="${purchaseUnit.economicNature eq '4'}">
							<c:out value="医疗机构"></c:out>
						</c:when>
						<c:when test="${purchaseUnit.economicNature eq '5'}">
							<c:out value="其它"></c:out>
						</c:when>
					</c:choose>
					
				</display:column>
				<%--<display:column property="licenseNo" escapeXml="true" sortable="false" titleKey="经营/生产/医疗机构许可证号"/>
				<display:column property="businessLicenseNo" escapeXml="true" sortable="false" titleKey="营业执照号"/>--%>
				<display:column  escapeXml="true" sortable="false" titleKey="开户公司">
					<c:if test="${purchaseUnit.openCompany =='0'}"><c:out value="经营"></c:out></c:if>
					<c:if test="${purchaseUnit.openCompany =='1'}"><c:out value="新品"></c:out></c:if>
					<c:if test="${purchaseUnit.openCompany =='2'}"><c:out value="市场"></c:out></c:if>
				</display:column>
				 <shiro:hasPermission name="PurchaseUnit_recorded_modify">
				<display:column titleKey="操作" autolink="true" media="html" class="border_rnone">
				<img src="../images/look.gif"/><a href="modify_ghdwdlr.html?id=${purchaseUnit.id}">编辑</a>
				</display:column>
				</shiro:hasPermission>
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>
		</form>
            <div class="caozuo_box2">
            <shiro:hasPermission name="PurchaseUnit_recorded_add">
            <input name="" type="button" class="btn_big" value="新增" onclick="add()"/>
            </shiro:hasPermission>
            <c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				 <shiro:hasPermission name="PurchaseUnit_recorded_delete">
            <input name="" type="button" class="btn_big" value="删除" onclick="delte_ghdwdql()"/>
            </shiro:hasPermission>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
			</c:choose>
            
            </div>
        </div>
	<script type="text/javascript">
	function add(){
		window.location.href="add_ghdwdlr.html";
	}
	function delte_ghdwdql(){
		var from =document.getElementById("del_ghdwdlr");
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