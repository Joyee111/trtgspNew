<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>售出退货审核
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
<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;售出退货管理&nbsp;>&nbsp;售出退货审核</font>
  	<div class="tab_biao">
	<shiro:hasPermission name="SellReturn_recorded">
		<a href="dlrlist.html"  ><span><font>录入</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="SellReturn_auditing">
		<a href="dshlist.html" class="on"><span><font>审核</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="SellReturn_audited">
		<a href="yshlist.html"><span><font>已审核</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="SellReturn_reject">
		<a href="ybhlist.html"><span><font>已驳回</font>
		</span>
		</a>
		</shiro:hasPermission>	
	</div>
	<div class="tab_con">
		<div class="caozuo_box">
  		<form action="${ctx}/drugState/salereturn/dshlist.html" method="post" >
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
					通用名称：<input name="yhdate" type="text" value="${yhDate}" class="text1">
					购货单位: <input name="ypname" type="text" value="${ypname}" class="text1"/>
			<input class="btn_big" type="submit" value="查询"  /> 
		</form>
			</div>
	</div>	
<form action="dshlist.html" id="audit_syqydsh">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="thispage" value="${thispage}"/>
		<input name="yhdate" type="hidden" value="${yhDate}" />
		<input name="ypname" type="hidden" value="${ypname}" />
	<div class="ceng_mar5">
	<display:table name="recordlist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选"><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="number" escapeXml="true" sortable="true" titleKey="单据号" />
		<display:column property="qualityMidicine.commonname" escapeXml="true" sortable="true" titleKey="通用名称"/>
		<display:column property="qualifiedPurchaseUnits.customerName"  escapeXml="true" sortable="true" titleKey="购货单位"></display:column>
		<display:column property="returnReason"  escapeXml="true" sortable="true" titleKey="退货原因" ></display:column>
		<display:column property="user.realname"  escapeXml="true" titleKey="申请人"></display:column>
		<display:column property="applicationTime"  titleKey="申请时间"  ></display:column>
		<display:column titleKey="user.operate" autolink="true" media="html">
		<a href="dshview.html?id=${records.id}">查看</a>
	</display:column>
	</display:table>
	</div>
	<input type="hidden" name="batch_type" id="batch_type" value="">
</form>
<div class="caozuo_box2">
<input type="button" value="批量审核" class="btn_big" onclick="batchAction('0')" />
<input type="button" onclick="batchAction('1')" value="批量驳回" class="btn_big"/>
</div>

</div>
	<script type="text/javascript">
	function addFirsrEnterprise(){
		window.location.href="";
	}
	function batchAction(type){
		var from =document.getElementById("audit_syqydsh");
		from.action="${ctx}/drugState/salereturn/audit.html";
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