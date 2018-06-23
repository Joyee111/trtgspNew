<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="质量事故" />
</title>
</head>
<script type="text/javascript">
	function check(){
		alert(1);
	}
	function onDelete(){
		var from =document.getElementById("records");
		var r=confirm("是否确认删除！");
		if(r){
			from.action="${ctx}/qualityRecords/qualityAccident/del.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/qualityRecords/qualityAccident/add.html";
    	form.submit();
    }
	
	function deletess(a){
		var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	from.action="${ctx}/qualityRecords/qualityAccident/del.html";
	    	from.submit();
    	}else{
			return;
		}
	}
	
</script>

<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">质量记录管理&nbsp;>&nbsp;质量事故</font>
	<div class="tab_con">
		<div class="caozuo_box">
		<form name="query" id="query" action="query.html" method="post">
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
			<label for="drugsnumber">药品编号:</label>
			<input type="text" name="drugsnumber" id="drugsnumber" value="${drugsnumber}" class="text1">
			<label for=""pinming"">通用名称:</label>
			<input type="text" name="pinming" id="pinming" value="${pinming}" class="text1">
			<input type="submit" class="btn_big" value="查询"/> 
		</form>
		</div>
	</div>	
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}'  onclick='checkAll(\"ids\")' />全选" media="html" ><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="number" sortable="true" titleKey="编号"  maxLength="15"/>
		<display:column property="drugsnumber" sortable="true" titleKey="药品编号"  maxLength="15"/>
		<display:column property="qualityMidicine.commonname"  escapeXml="true" sortable="true" titleKey="品名"></display:column>
		<display:column property="qualityMidicine.dosageforms.formName"  escapeXml="true" sortable="true" titleKey="剂型"  style="width:15%;"></display:column>
		<display:column property="qualityMidicine.specifications"  escapeXml="true" titleKey="规格"></display:column>
		<display:column property="qualityMidicine.licensenumber"  titleKey="批号" autolink="true" media="html" style="border-right:1px solid #feb808;"></display:column>
			<display:column property="qualityMidicine.unit"  escapeXml="true" titleKey="单位"></display:column>
			<display:column property="quantity"  escapeXml="true" titleKey="数量"></display:column>
			<display:column property="qualityMidicine.produceno.customerName"  escapeXml="true" titleKey="生产厂商"></display:column>
			
           	<display:column titleKey="user.operate" autolink="true"  style="border-right:1px solid #feb808;">
           	<shiro:hasPermission name="QualityAccidentManage_modify">
	              <img src="../../images/edit.gif"/><a href="${ctx}/qualityRecords/qualityAccident/add.html?method=edit&id=<c:out value="${records.id}"/>&thispage=${thispage}">
					<fmt:message key="编辑"/>
				</a>
		</shiro:hasPermission>
		<c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				<shiro:hasPermission name="QualityAccidentManage_del">
				<a onclick="deletess(<c:out value="${records.id}"/>)">
					<fmt:message key="删除"/>
				</a>
			</shiro:hasPermission>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
			
	
		
		
	</display:column>
	</display:table>
	</div>
</form>
<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>
<form id="delForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" id="resId" name="ids"  value=""   />
</form>
<div class="caozuo_box2">
	 <shiro:hasPermission name="QualityAccidentManage_add">
	 	<input type="button" onclick="add()" class="btn_big" value="新增"/>
	 </shiro:hasPermission>	
	 <c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				<shiro:hasPermission name="QualityAccidentManage_del">
	 	<input type="button" value="删除" class="btn_big" onclick="onDelete()" />
	 </shiro:hasPermission>	
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
	 
	 
	  
</div>	


</div>

