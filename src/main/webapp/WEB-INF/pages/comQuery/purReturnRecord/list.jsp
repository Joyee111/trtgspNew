<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="药品购进退出记录" />
</title>

</head>
<script type="text/javascript">
  function chaxun(){
		var form = document.getElementById("query");
    	form.submit();
	
		}  
</script>


<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;药品购进退出记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
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
		" name="qualifiedMedicineId" id="caigoudan" size="25"/>&nbsp;&nbsp;
	&nbsp;<label>打印类别：</label>
	未打印<input type="radio" name="printFlag" value="0">
	&nbsp;已打印<input type="radio" name="printFlag" value="1">
	&nbsp;&nbsp;&nbsp;<label>经营公司：</label>
	经营<input type="radio" name="department" value="1001">
	&nbsp;新品<input type="radio" name="department" value="2001">
	&nbsp;市场<input type="radio" name="department" value="3001">

	         <input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>
			</form>
		</div>
	</div>
	</div>
	<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>	





