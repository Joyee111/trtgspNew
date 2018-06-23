<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>退货验收管理审核
</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
t</script>
 <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript"
	src="/zywx3/ext/scripts/user/selectarea.js">
</script>
<script type="text/javascript">
	function check(){
		alert(1);
	}
	function onDelete(){
		var from =document.getElementById("recordsss");
		var r=confirm("是否确认删除！");
		if(r){
			from.action="${ctx}/drugState/inspectionRecords/del.html";
			from.submit();
		}else{
			return;
		}
    }
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/drugState/checkaccept/dlradd.html";
    	form.submit();
    }
	function deletess(a){
	var from =document.getElementById("delForm");
		$("#resId").val(a);
		var r=confirm("是否确认删除！");
		if(r){
	    	from.action="${ctx}/drugState/inspectionRecords/del.html";
	    	from.submit();
    	}else{
			return;
		}
	}
</script>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;退货验收管理&nbsp;>&nbsp;退货验收管理审核</font>
<div>
  	<div class="tab_biao">
	<shiro:hasPermission name="ReturnCheckAccept_recorded">
		<a href="dlrlist.html" ><span><font>录入</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<a href="rechecklist.html" ><span><font>复检</font>
		</span>
		</a>
		<shiro:hasPermission name="ReturnCheckAccept_auditing">
		<a href="dshlist.html" class="on" ><span><font>审核</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="ReturnCheckAccept_audited">
		<a href="yshlist.html"><span><font>已审核</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="ReturnCheckAccept_reject">
		<a href="ybhlist.html"><span><font>已驳回</font>
		</span>
		</a>
		</shiro:hasPermission>	
		
		<shiro:hasPermission name="ReturnCheckAccept_rollback">
		<a href="htlist.html"><span><font>回退</font>
		</span>
		</a>
		</shiro:hasPermission>
	</div>
	<div class="tab_con">
		<div class="caozuo_box">
  		<form action="${ctx}/drugState/checkreturn/dshlist.html"  method="post" >
  			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
			验收日期：<input name="yhdate" type="text" value="${yhDate}"  class="easyui-datebox text1">
			退回单位: <input name="ypname" type="text" value="${ypname}"  class="text1"/>
			<shiro:hasPermission name="ReturnCheckAccept_auditing_find">
			<input type="submit" class="btn_big"  value="查询"/> &nbsp;
			</shiro:hasPermission>
		</form>
			</div>
	</div>	
<form action="dshlist.html" id="audit_syqydsh">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="thispage" value="${thispage}"/>
		<input name="yhdate" type="hidden" value="${yhDate}" >
		<input name="ypname" type="hidden" value="${ypname}" />
	<div class="ceng_mar5">
	<display:table name="recordlist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选"><input type="checkbox" name="ids" value="${records.id}" ></display:column>
		<display:column property="returnCheckAcceptNoteNumber" escapeXml="true" sortable="true" titleKey="退货单号" />
		<display:column property="purchaseUnits" escapeXml="true" sortable="true" titleKey="退货单位" />
		<display:column property="commonName" escapeXml="true" sortable="true" titleKey="通用名称" />
		<display:column property="drugFrom" escapeXml="true" sortable="true" titleKey="剂型" />
		<display:column property="specification" escapeXml="true" sortable="true" titleKey="规格" />
		<display:column property="totalQuality" escapeXml="true" sortable="true" titleKey="退货数量" />
		<display:column property="qualifiedQuality" escapeXml="true" sortable="true" titleKey="合格数量" />
		<display:column property="arrivalDate" escapeXml="true" sortable="true" titleKey="到货日期"/>
		<display:column property="acceptanceDate"  escapeXml="true" sortable="true" titleKey="验收日期"/>
		<display:column property="inspectionResults"  titleKey="检查结论"  ></display:column>
		<display:column titleKey="user.operate" autolink="true" media="html">
		<shiro:hasPermission name="ReturnCheckAccept_auditing_look">
		<a href="dshview.html?id=${records.id}">查看</a>
		</shiro:hasPermission>
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
		from.action="${ctx}/drugState/checkreturn/audit.html";
		if(type=="0"){
			document.getElementById("batch_type").value="0";
			var r=confirm("是否确认批量审核！");
			if(r){
				from.submit();
			}else{
				return;
			}
		}else if(type=="1"){
			document.getElementById("batch_type").value="1";
			var n=confirm("是否确认批量驳回！");
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