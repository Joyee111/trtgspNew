<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="采购订单管理" />
</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
</script>
 <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/ext/scripts/user/selectarea.js'/>"></script>

<script type="text/javascript">
	function check(){
		alert(1);
	}
	function onDelete(){
		var from =document.getElementById("recordsss");
		var r=confirm("是否确认删除！");
		if(r){
			from.action="${ctx}/drugState/purchaseNote/del.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/drugState/purchaseNote/add.html";
    	form.submit();
    }
	function deletess(a){
	var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	from.action="${ctx}/drugState/purchaseNote/del.html";
	    	from.submit();
    	}else{
			return;
		}
	}
	$(function(){
		setDefaultForRadio("department","${department}");
	});
</script>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;采购订单管理</font>
	 <div class="tab_biao">
	 			<shiro:hasPermission name="PurchasingOrder_enter">
				<a href="list.html" class="on"><span><font>录入</font>
				</span> </a>
				</shiro:hasPermission>
				<shiro:hasPermission name="PurchasingOrder_confirm">
				<a href="dshlist.html" ><span><font>确认</font>
				</span> </a>
				</shiro:hasPermission>
				<shiro:hasPermission name="PurchasingOrder_confirmed">
				<a href="yshlist.html" ><span><font>已确认</font>
				</span> </a>
				</shiro:hasPermission>
				<shiro:hasPermission name="PurchasingOrder_void">
				<a href="yzflist.html" ><span><font>已作废</font>
				</span> </a>
				</shiro:hasPermission>
		</div>
<div class="tab_con">
	<div class="caozuo_box">
		<form action="${ctx}/drugState/purchaseNote/list.html" method="post" >
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
					通用名称：<input type="text" class="easyui-combobox  text1" data-options="
     	 	valueField: 'id',
      		textField: 'text',
      		value:'${yhDate}',
     		url:'${ctx}/drugState/inspectionRecords/findypboxqy.html',
     		onSelect: function(rec){
     			$('#yhDate').val(rec.id);
     		}
		" name="qualifiedMedicineId" id="caigoudan" size="40"/>&nbsp;&nbsp;
		 <input type="hidden" value="${yhDate}" name="yhDate" id="yhDate"/>
		 <!--  
					批号: <input name="ypname" type="text" value="${ypname}" class="text1"/>
		 -->
		 订单编号: <input name="orderNumber" type="text"  class="text1"/>
		 订单日期: <!--<input name="modityDate" type="text"  class="text1"/>  -->
		  <input type="text" class="easyui-datebox" data-options="disabled:false,disabled:false" id="modityDate"  class="text1" name="modityDate" />
					&nbsp;<label>经营公司：</label>
					&nbsp;经营<input type="radio" name="department" value="1001"/>
					&nbsp;新品<input type="radio" name="department" value="2001"/>
					&nbsp;市场<input type="radio" name="department" value="3001"/>
					
				<input class="btn_big" type="submit" value="查询"  /> 
		</form>
	</div>
</div>
<div class="tab_con">
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选"><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="department" escapeXml="true" sortable="true" titleKey="经营公司" />
		<display:column property="orderNumber" escapeXml="true" sortable="true" titleKey="订单编号" />
		<display:column property="medcNo" escapeXml="true" sortable="true" titleKey="货号" />
		<display:column property="commonName" escapeXml="true" sortable="true" titleKey="通用名称" />
		<display:column property="drugFrom" escapeXml="true" sortable="true" titleKey="剂型" />
		<display:column property="specification" escapeXml="true" sortable="true" titleKey="规格" />
		<display:column property="unit" escapeXml="true" sortable="true" titleKey="单位" />
		
		<display:column property="quanlity" escapeXml="true" sortable="true" titleKey="数量" />
	
		<display:column property="taxPrice" escapeXml="true" sortable="true" titleKey="单价" />
		<display:column property="deductionRate" escapeXml="true" sortable="true" titleKey="扣率" />
		<display:column property="money" escapeXml="true" sortable="true" titleKey="金额" />
		
		<display:column property="customerName" escapeXml="true" sortable="true" titleKey="供货单位" />
		
		<display:column property="modityDate" escapeXml="true" sortable="true" titleKey="订单日期" />
		<display:column  escapeXml="true" sortable="true" titleKey="订单签订人" >
		    <c:if test="${records.modifyPerson !=null}">
		       <c:choose>
		            <c:when test="${records.modifyPerson eq '管理员'}">
		               <c:out value=""></c:out>
		           </c:when>
		           <c:otherwise>
		              <c:out value="${records.modifyPerson}"></c:out>
		           </c:otherwise>
		       </c:choose>
		    </c:if>
		</display:column>
		<display:column titleKey="user.operate" autolink="true" media="html">
		<shiro:hasPermission name="PurchasingOrder_enter_modify">
		<img src="../../images/edit.gif"/><a href="${ctx}/drugState/purchaseNote/add.html?method=edit&id=<c:out value="${records.id}"/>&thispage=${thispage}">
			<fmt:message key="button.update"/>
		</a>
		</shiro:hasPermission>
		<c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				<shiro:hasPermission name="PurchasingOrder_enter_del">
				<a onclick="deletess(<c:out value="${records.id}"/>)">
				<fmt:message key="删除"/>
				</a>
			</shiro:hasPermission>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
		 
	</display:column>
	<display:setProperty name="export.csv" value="false"/>
	<display:setProperty name="export.excel" value="false"/>
	<display:setProperty name="export.pdf" value="false"/>
	<display:setProperty name="export.xml" value="false"/>
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
	<shiro:hasPermission name="PurchasingOrder_enter_add">
	 <input type="button"  value="新增" class="btn_big" onclick="add()" />
	 </shiro:hasPermission>
	 <c:choose>
			<c:when test="${deleteItemFlag eq 'true'}">
				<shiro:hasPermission name="PurchasingOrder_enter_del">
	 <input type="button" value="删除" class="btn_big" onclick="onDelete()" />
	 </shiro:hasPermission>
			</c:when>
			<c:when test="${deleteItemFlag eq 'false'}">
			</c:when>
		</c:choose>
	 
	</div>
</div>
