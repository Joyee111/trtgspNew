<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>合格采购人员/提货人员</title>
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
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;合格采购人员/提货人员</font>
   <div class="caozuo_box">
    <form name="query_hgcgry" id="query_enterprise" action="queryhgcgry.html" method="post"  >
                                姓名 <input name="query_proName" id="query_proName" type="text" class="text1" size="20"/>
                                人员类别：
            &nbsp;采购人员&nbsp;<input type="radio" name="query_person_type" value="0">
            &nbsp;提货人员&nbsp;<input type="radio" name="query_person_type" value="1">
            <input name="" type="submit" class="btn_big" value="搜索"/>
    </form>
  </div>
  <div class="zhushi_box">
      <img src="../images/zhushi.gif"/>
            <span><marquee width=95% onmouseover="this.stop()" onmouseout="this.start()"  scrollamount="5" id="warnMessage"></marquee></span>
        </div>
 			<display:table name="procurementStaffList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="proStaff" pagesize="${pagesize}" class="table_print" export="true" size="${resultSize}" partialList="true">
 			    <display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html" class="noPrint_flag"><input type="checkbox" name="delete_id" value="${proStaff.id}" class="noPrint_flag"></display:column>
 				<display:column property="procurementName" escapeXml="true" sortable="false" titleKey="姓名 " class="noPrint_flag"/>
				<display:column escapeXml="true" sortable="false" titleKey="性别" class="noPrint_flag">
					<c:if test="${proStaff.gender=='0'}">
						<c:out value="男"></c:out>
					</c:if>
					<c:if test="${proStaff.gender=='1'}">
						<c:out value="女"></c:out>
					</c:if>
				</display:column>
				<display:column property="IDNumber" escapeXml="true" sortable="false" titleKey="身份证号" class="noPrint_flag"/>
 				<display:column property="powerOfAttorneyDate" escapeXml="true" sortable="false" titleKey="法人委托书到期日期" class="noPrint_flag"/>		
				<display:column property="identityCardDate" escapeXml="true" sortable="false" titleKey="身份证有效期" class="noPrint_flag"/>
				<display:column  escapeXml="true" sortable="false" class="noPrint_flag" titleKey="人员类别">
					<c:if test="${proStaff.personType != null}">
						<c:if test="${proStaff.personType eq '0'}">
							<c:out value="采购人员"/>
						</c:if>
						<c:if test="${proStaff.personType eq '1'}">
							<c:out value="提货人员"/>
						</c:if>
					</c:if>
				</display:column>
				<display:column titleKey="操作" autolink="true" media="html" class="noPrint_flag">
		            <img src="../images/look.gif"/><a href="hgcgryxgjl.html?id=${proStaff.id}">查看修改记录</a>
				    <img src="../images/edit.gif"/><a href="view_hgcgry.html?id=${proStaff.id}">修改</a>
				</display:column>
 				
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>
			<script type="text/javascript">
			
			$(function(){
			$.post("ajaxQueryWarnProcurementStaff.html",function(data){
				var json = jsonParse(data);
				var str = json.success;	
				$("#warnMessage").empty();
				$("#warnMessage").append(str);
			})
		})
		</script>
</body>
</html>