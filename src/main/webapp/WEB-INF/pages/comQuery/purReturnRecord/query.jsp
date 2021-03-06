<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="药品购进退出记录" />
</title>

</head>
<script type="text/javascript">
	
    setDefaultForRadio("printFlag","${printFlag}");
    setDefaultForRadio("department","${department}");
    

    /* function chaxun(){
	
	 var tuihuoriqi = $("#tuihuoriqi").datebox("getValue");
		  var zhi = $("#zhi").datebox("getValue");

		  if(tuihuoriqi !=''&& zhi!=''&& tuihuoriqi > zhi){
           alert("开始时间不能早于截止时间");
            return;
		}else{
		var form = document.getElementById("query");
    	form.submit();
		}
		}   
		*/
		function exportAllToExcel(){
			$("#query").attr("action","exportAllToExcel.html");
			$("#query").submit();
			$("#query").attr("action","query.html");
		}
		
		
	function exportExcel(){
    	var  checkBox = document.getElementsByName("ids");
    	var  value = "";
    	for(var i=0,n=checkBox.length;i<n;i++){
    		var obj = checkBox[i];
    		if(obj.checked==true){
    			value =obj.value;
    			
    		}
    	}
    	//alert(value);
    	$("#purchaseReturnId").val(value);
    	if($("#purchaseReturnId").val()=="" || $("#purchaseReturnId").val()==null){
    		alert("请选择要导出的入库单！");
    		return;
    	}
    	$("#export_form").attr("action","../../ireport/exportPurchaseReturnToExcel.html");
    	$("#export_form").submit();
    	
    	var purchaseReturnId = $("#purchaseReturnId").val();
    	$.post("${ctx}/drugState/purreturn/ajaxChangePrintFlag.html",{
    		returnBillId :  purchaseReturnId
    	},function(data){
    		window.location.reload();
    	});
		
	}
	function checkSelect(){
    	var  checkBox = document.getElementsByName("ids");
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
      		value:'${tuihuodanwei}',
     		url:'${ctx}/drugState/inspectionRecords/findypboxqy.html',
     		onSelect: function(rec){
     			$('#yhDate').val(rec.id);
     		}
		" name="qualifiedMedicineId" id="caigoudan" size="25"/>&nbsp;&nbsp;
	&nbsp;<label>打印类别：</label>
	未打印&nbsp;<input type="radio" name="printFlag" value="0">
	&nbsp;已打印<input type="radio" name="printFlag" value="1">
	&nbsp;<label>经营公司：</label>
	经营<input type="radio" name="department" value="1001">
	&nbsp;新品<input type="radio" name="department" value="2001">
	&nbsp;市场<input type="radio" name="department" value="3001">
			
					 <input type="submit" class="btn_big"  name=""  value="查询"/>
			</form>
			<form id = "export_form" target="_blank" >
				<input type="hidden" name="id" id="purchaseReturnId">
				<shiro:hasPermission name="PurchaseReturn_Record_printOrder">
				<input class="btn_big" type="submit" value="打印入库负票"  onclick="exportExcel()"/> 
				</shiro:hasPermission>
		</form>
		</div>
	</div>
	</div>
		
<form action="" id="records">
		<input type="hidden" name="ptmeth" value="${ptmeth}"/>
		<input type="hidden" name="tz" value="${thispage}"/>
		<input name="yhdate" type="hidden" value="${yhDate}" />
		<input name="ypname" type="hidden" value="${ypname}" />
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table_print" export="true" size="${resultSize}" partialList="true">
		<c:choose>
			<c:when test="${records.printFlag=='1'}">
				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选" media="html" class="print_flag"><input type="checkbox" name="ids" value="${records.id}" onclick="checkSelect()" / ></display:column>
				<display:column escapeXml="true" sortable="true" titleKey="经营公司" class="print_flag">
					<c:choose>
						<c:when test="${records.qualityMidicine.departmentId == '1001'}">
							<c:out value="经营"></c:out>
						</c:when>
						<c:when test="${records.qualityMidicine.departmentId == '2001'}">
							<c:out value="新品"></c:out>
						</c:when>
						<c:when test="${records.qualityMidicine.departmentId == '3001'}">
							<c:out value="市场"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value=""></c:out>
						</c:otherwise>
					</c:choose>
				</display:column>
				<display:column property="returnTime" escapeXml="true" sortable="true" titleKey="退出日期" class="print_flag"/>
				<display:column property="qualityMidicine.medicinalNo" escapeXml="true" sortable="true" titleKey="药品编号" class="print_flag"/>
				<display:column property="qualityMidicine.commonname" escapeXml="true" sortable="true" titleKey="通用名称" class="print_flag"/>
				<display:column property="qualityMidicine.dosageforms.formName"  escapeXml="true" sortable="true" titleKey="剂型" class="print_flag"/>
				<display:column property="qualityMidicine.massSpecifications" escapeXml="true" sortable="true" titleKey="规格" class="print_flag"/>
				<display:column property="qualityMidicine.unit"  escapeXml="true" sortable="true" titleKey="单位" class="print_flag"/>
				<display:column property="puMoney" escapeXml="true" sortable="true" titleKey="购进价格" class="print_flag"/>
				<display:column property="quantity"  escapeXml="true" sortable="true" titleKey="退出数量" class="print_flag"/>
				<display:column property="money" escapeXml="true" sortable="true" titleKey="退出金额" class="print_flag"/>			
				<display:column property="batchNumber"  escapeXml="true" sortable="true" titleKey="批号" class="print_flag" />
				<display:column property="qualityMidicine.produceno.customerName"  escapeXml="true" sortable="true" titleKey="供货单位" class="print_flag"/>
				<display:column property="endTime"  escapeXml="true" sortable="true" titleKey="有效期至" class="print_flag"/>
				<display:column property="user.realname"  escapeXml="true" titleKey="采购员" class="print_flag"/>
				<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
				</display:setProperty> 
			</c:when>
			<c:otherwise>
				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"ids\")' />全选" media="html" class="noPrint_flag"><input type="checkbox" name="ids" value="${records.id}" onclick="checkSelect()"  / ></display:column>
				<display:column escapeXml="true" sortable="true" titleKey="经营公司" class="noPrint_flag">
					<c:choose>
						<c:when test="${records.qualityMidicine.departmentId == '1001'}">
							<c:out value="经营"></c:out>
						</c:when>
						<c:when test="${records.qualityMidicine.departmentId == '2001'}">
							<c:out value="新品"></c:out>
						</c:when>
						<c:when test="${records.qualityMidicine.departmentId == '3001'}">
							<c:out value="市场"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value=""></c:out>
						</c:otherwise>
					</c:choose>
				</display:column>
				<display:column property="returnTime" escapeXml="true" sortable="true" titleKey="退出日期" class="noPrint_flag"/>
				<display:column property="qualityMidicine.medicinalNo" escapeXml="true" sortable="true" titleKey="药品编号" class="noPrint_flag"/>
				<display:column property="qualityMidicine.commonname" escapeXml="true" sortable="true" titleKey="通用名称" class="noPrint_flag"/>
				<display:column property="qualityMidicine.dosageforms.formName"  escapeXml="true" sortable="true" titleKey="剂型" class="noPrint_flag"/>\
				<display:column property="qualityMidicine.massSpecifications" escapeXml="true" sortable="true" titleKey="规格" class="noPrint_flag"/>
				<display:column property="qualityMidicine.unit"  escapeXml="true" sortable="true" titleKey="单位" class="noPrint_flag"/>
				<display:column property="puMoney" escapeXml="true" sortable="true" titleKey="购进价格" class="noPrint_flag"/>
				<display:column property="quantity"  escapeXml="true" sortable="true" titleKey="退出数量" class="noPrint_flag"/>
				<display:column property="money" escapeXml="true" sortable="true" titleKey="退出金额" class="noPrint_flag" />		
				<display:column property="batchNumber"  escapeXml="true" sortable="true" titleKey="批号" class="noPrint_flag"/>
				<display:column property="qualityMidicine.produceno.customerName"  escapeXml="true" sortable="true" titleKey="供货单位" class="noPrint_flag"/>
				<display:column property="endTime"  escapeXml="true" sortable="true" titleKey="有效期至" class="noPrint_flag"/>
				<display:column property="user.realname"  escapeXml="true" titleKey="采购员" class="noPrint_flag"/>
				<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
				</display:setProperty> 
			</c:otherwise>
		</c:choose>
		

	</display:table>
	<input type="button" value="导出Excel" class="btn_big" onclick="exportAllToExcel()" style="margin-left: 70px;margin-top: -21px;">
</form>




