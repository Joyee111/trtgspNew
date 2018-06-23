<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>退货验收管理回退
</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
</head>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/display/displaypage.js'/>">
</script>
 <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/ext/scripts/user/selectarea.js'/>"></script>
<script>
</script>
<script type="text/javascript">
	function check(){
		alert(1);
	}
    function add(){
    	var form = document.getElementById("baseForm");
    	form.action="${ctx}/drugState/checkaccept/dlradd.html";
    	form.submit();
    }
        function checkSelect(){
    	var  checkBox = document.getElementsByName("select_box");
    	var index = 0;
    	for(var i=0,n=checkBox.length;i<n;i++){
    		var obj = checkBox[i];
    		if(obj.checked==true){
    			index++;
    			if(index>1){
    				alert("您最多只能选中一条记录进行导出！");
    				obj.checked=false;
    				return;
    			}
    		}
    	}
    	
    }
</script>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;退货验收管理&nbsp;>&nbsp;回退审核</font>
<div id="syqy_tab" >
	<div class="tab_biao">
		<!--<shiro:hasPermission name="ReturnCheckAccept_recorded">
		<a href="dlrlist.html" ><span><font>录入</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="ReturnCheckAccept_checking">
		<a href="dyslist.html" ><span><font>验收</font>
		</span>
		</a>
		</shiro:hasPermission> -->
		<shiro:hasPermission name="ReturnCheckAccept_auditing">
			<a href="rechecklist.html"  ><span><font>复检</font>
		</span>
		</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="ReturnCheckAccept_audited">
		<a href="yshlist.html"><span><font>已复检</font>
		</span>
		</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="ReturnCheckAccept_rollback">
		<a href="htlist.html" class="on" ><span><font>回退审核</font>
		</span>
		</a>
		</shiro:hasPermission>
	</div>
  	  
</div>

<div>
	<div class="tab_con">
	<div class="caozuo_box">
		<form action="${ctx}/drugState/checkreturn/htlist.html"  method="post" >
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
			验收日期：<input name="yhdate" type="text" value="${yhDate}"  class="easyui-datebox text1">
			退货单位: <input name="ypname" type="text" value="${ypname}" class="text1"/>
			<shiro:hasPermission name="ReturnCheckAccept_audited_find">
			<input class="btn_big" type="submit" value="查询"  /> 
			</shiro:hasPermission>
		</form>
	</div>
</div>
<form action="" id="recordsss">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input name="yhdate" type="hidden" value="${yhDate}" >
		<input name="ypname" type="hidden" value="${ypname}" />
	<div class="ceng_mar5">
	<display:table name="recordlist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选"><input type="checkbox" name="select_box" value="${records.id}" onclick="checkSelect()"/></display:column>
		<display:column property="returnCheckAcceptNoteNumber" escapeXml="true" sortable="true" titleKey="退货单号" />
		<display:column property="purchaseUnits" escapeXml="true" sortable="true" titleKey="退货单位" />
		<display:column property="commonName" escapeXml="true" sortable="true" titleKey="通用名称" />
		<display:column property="drugFrom" escapeXml="true" sortable="true" titleKey="剂型" />
		<display:column property="specification" escapeXml="true" sortable="true" titleKey="规格" />
		<display:column property="totalQuality" escapeXml="true" sortable="true" titleKey="退货数量" />
		<display:column property="qualifiedQuality" escapeXml="true" sortable="true" titleKey="合格数量" />
		<display:column property="unqualifiedQuantity" escapeXml="true" sortable="true" titleKey="不合格数量" />
		<display:column property="invalidQuantity" escapeXml="true" sortable="true" titleKey="退回数量" />
		<display:column property="arrivalDate" escapeXml="true" sortable="true" titleKey="退货日期"/>
		<display:column property="acceptanceDate"  escapeXml="true" sortable="true" titleKey="验收日期"/>
		<display:column property="inspectionResults"  titleKey="验收结果"  ></display:column>
		<display:column property="acceptanceDate2"  escapeXml="true" sortable="true" titleKey="验收日期2"/>
		<display:column property="inspectionResults2"  titleKey="验收结果2"  ></display:column>
		
		<display:column titleKey="user.operate" autolink="true" media="html">
		<img src="../../images/look.gif"/>
		<a href="findCheckRetrunAcceptRollbackRecords.html?id=${records.id}">查看回退记录</a>
		<shiro:hasPermission name="ReturnCheckAccept_rollback_look">
		<a href="htview.html?id=${records.id}">查看</a>
		</shiro:hasPermission>
	</display:column>
	</display:table>
	</div>
</form>
<form id="baseForm" method="post">
	<input type="hidden" name="thispage" value="${thispage}" />
</form>
<form id="delForm" method="post">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" id="resId" name="ids"  value=""   />
</form>
</div>
