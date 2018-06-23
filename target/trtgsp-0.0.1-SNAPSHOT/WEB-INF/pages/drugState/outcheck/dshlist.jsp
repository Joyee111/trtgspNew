<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>出库复核审核
</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
</script>
 <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript"
	src="/zywx3/ext/scripts/user/selectarea.js">
</script>
<script type="text/javascript">
</script>
<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;出库复核管理&nbsp;>&nbsp;出库复核确认</font>
  	<div class="tab_biao">
	<shiro:hasPermission name="OutboundCheck_recorded">
		<a href="dlrlist.html"><span><font>录入</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="OutboundCheck_auditing">
		<a href="dshlist.html" class="on" ><span><font>确认</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="OutboundCheck_audited">
		<a href="yshlist.html"><span><font>已确认</font>
		</span>
		</a>
		</shiro:hasPermission>	
	<!-- 	<shiro:hasPermission name="OutboundCheck_reject">
		<a href="ybhlist.html"><span><font>已驳回</font>
		</span>
		</a>
		</shiro:hasPermission>	 -->
	</div>
	<div class="tab_con">
			<!-- 
	<div class="caozuo_box">
	<form action="${ctx}/drugState/checkaccept/dlrlist.html" >
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		验收日期：<input name="yhdate" type="text" value="${yhdate}" >
		通用名称: <input name="ypname" type="text" value="${ypname}" />
		<input class="btn_big" type="submit" value="查询"  /> 
	</form>
		</div>
		 -->
	</div>	
<form action="dshlist.html" id="audit_syqydsh" method="post">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="thispage" value="${thispage}"/>
	<div class="ceng_mar5">
	<display:table name="recordlist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选"><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="salesFromNumber" escapeXml="true" sortable="true" titleKey="合同号"/>
		<display:column property="salesItemNumber" escapeXml="true" sortable="true" titleKey="票号"/>
		<display:column property="commoneName" escapeXml="true" sortable="true" titleKey="通用名称"/>
		<display:column property="drugFrom" escapeXml="true" sortable="true" titleKey="剂型"/>
		<display:column property="specification" escapeXml="true" sortable="true" titleKey="规格"/>
		<display:column property="batchNumber" escapeXml="true" sortable="true" titleKey="批号"/>
		<display:column property="quantity" escapeXml="true" sortable="true" titleKey="数量"/>
		<display:column property="purchaseUnits" escapeXml="true" sortable="true" titleKey="购货单位"/>
				<display:column  escapeXml="true" sortable="true" titleKey="质量状况">
			<c:if test="${records.qaualityStatus != null}">
			<c:if test="${records.qaualityStatus eq '1'}"><fmt:message key="合格"/></c:if>
			<c:if test="${records.qaualityStatus eq '2'}"><fmt:message key="不合格"/></c:if>
			</c:if>
		</display:column>
		<display:column property="outDate" escapeXml="true" sortable="true" titleKey="销售时间"/>
		<display:column property="applityPerson" escapeXml="true" sortable="true" titleKey="申请人"/>
		<display:column property="remark" escapeXml="true" sortable="true" titleKey="备注"/>
		<display:column titleKey="user.operate" autolink="true" media="html">
		<shiro:hasPermission name="OutboundCheck_auditing_look">
		<a href="dshview.html?id=${records.id}">查看</a>
		</shiro:hasPermission>
	</display:column>
	<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
	</display:table>
	</div>
	<input type="hidden" name="batch_type" id="batch_type" value="">
</form>
<div class="caozuo_box2">
<c:if test="${dateDisableFlag eq 'true'}">
<input type="button" value="批量确认" class="btn_big" onclick="batchAction('0')" />
</c:if>
<!-- <input type="button" onclick="batchAction('1')" value="批量驳回" class="btn_big"/> -->
</div>

</div>
	<script type="text/javascript">
	function addFirsrEnterprise(){
		window.location.href="";
	}
	function batchAction(type){
		var from =document.getElementById("audit_syqydsh");
		from.action="${ctx}/drugState/outcheck/audit.html";
		if(type=="0"){
			document.getElementById("batch_type").value="0";
			var r=confirm("是否确认批量审核！")
			if(r){
				from.submit();
			}else{
				return;
			}
		}else if(type=="1"){
			document.getElementById("batch_type").value="1";
			var n=confirm("是否确认批量驳回！")
			if(n){
				from.submit();
			}else{
				return;
			}
		}else{
			return;
		}
		
	}
	</script>