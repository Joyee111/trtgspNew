<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>供货单位购货单位</title>
		<script type="text/javascript">
	function view(a,b){
		var from =document.getElementById("delForm");
		$("#resId").val(a);
		 from.action="${ctx}/trtgsp/comQuery/comQuery/gysypView.html";
	  	 from.submit();
	}
		
    function tijiao(){
    var from =document.getElementById("query");

    from.action="${ctx}/trtgsp/comQuery/comQuery/query.html";
	   from.submit();
    }
  
    </script>
	</head>
	<body>
		<font
			style="font-family: '宋体'; font-weight: normal; font-size: 12; color: #8d3c01; padding: 10px;">综合查询统计分析&nbsp;>&nbsp;供货单位购货单位</font>
		<div class="tab_con">
			<div class="caozuo_box">
				<form name="query" id="query" method="post">
					<label for="mc">
						查询类别:
					</label>
					<select style="width: 200px" name="customer_type" id="customer_type"
						class="easyui-validatebox text1">
						<option value="">
							--请选择--
						</option>
						<option value="0" selected="selected">
							供货单位
						</option>
						<option value="1">
							购货单位
						</option>
					</select>
					<label>
						客户编号：
					</label>
					<input name="customerNumber" id="customer_number" class="text1" size="40">
					&nbsp;&nbsp;
					<label>
						客户名称：
					</label>
					<input name="customerName" id="customer_name" class="text1" size="40"/>
					<input type="hidden" name="mcValue" id="mcValue" class="text1"
						value="${mc}" size="40" />
					&nbsp;&nbsp;
					<br/><br/>
					<label>使用状态：</label>
					<input type="checkbox" name="status" value="0" checked="checked">&nbsp;<font>启用</font>
					<input type="checkbox" name="status" value="1" checked="checked">&nbsp;<font>停用</font>
					<input type="checkbox" name="status" value="2" checked="checked">&nbsp;<font>暂时停用</font>					
					<input class="btn_big" type="button" value="查询" onclick="tijiao()" />
				</form>
			</div>
		
		<%
			int index = 0;
		%>
		<form name="del_syqydlr" action="delte_syqydql.html" id="del_syqydlr"
			method="post">
			<display:table name="quSuppList" cellspacing="0"
				cellpadding="0" requestURI="" style="width:98%;" id="enterprise"
				pagesize="${pagesize}" class="table" export="true"
				size="${resultSize}" partialList="true">
				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html"><input type="checkbox" name="delete_id" value="${qualifiesSupply.id}" ></display:column>
 				<display:column property="customerNumber" escapeXml="true" sortable="false" titleKey="编号" />
				<display:column property="customerName" escapeXml="true" sortable="false" titleKey="客户名称" />
				<display:column property="busiLiceExpiDate" escapeXml="true" sortable="false" titleKey="营业执照到期时间"/>
				<display:column property="liceExpiDate" escapeXml="true" sortable="false" titleKey="经营/生产许可证到期时间"/>
				<display:column property="gspExpirDate" escapeXml="true" sortable="false" titleKey="GSP/GMP证书截止日期"/>
				<display:column property="organizationCodeDate" escapeXml="true" sortable="false" titleKey="组织机构代码到期时间"/>
				<display:column property="organizationCodeInspectionDate" escapeXml="true" sortable="false" titleKey="组织机构代码年检日"/>
				<display:column property="qualityAssuranceDate" escapeXml="true" sortable="false" titleKey="质量保证协议到期日"/>
				<display:column property="authorizationDate" escapeXml="true" sortable="false" titleKey="授权委托书到期日"/>
				<display:column titleKey="操作" autolink="true" media="html"
					class="border_rnone">
					<img src="../../images/look.gif"/><a href="gysView.html?id=<c:out value="${enterprise.id}"/>" />查看</a>
					<img src="../../images/look.gif"/><a onclick="view(<c:out value="${enterprise.id}"/>)">查看药品信息</a>
				</display:column>
				<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
				</display:setProperty> 
				<display:setProperty name="export.excel" value="true"/>
			</display:table>
		</form>

		<form id="delForm">
			<input type="hidden" name="thispage" value="${thispage}" />
			<input type="hidden" id="resId" name="ids" value="" />
			<!-- <input type="hidden" id="statyId" name="statyId" value="" /> -->
		</form>
</div>
	</body>
</html>