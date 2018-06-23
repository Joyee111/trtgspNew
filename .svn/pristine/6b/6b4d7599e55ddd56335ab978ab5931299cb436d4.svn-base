<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="委托储存验收检查记录" />
</title>

</head>
<script type="text/javascript">
		  function find(s){
	    if(s.value!=""){
			$.post("${ctx}/qualityRecords/qualityQuery/quamap.html",{
			"quamap" : s,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					$("#dosageforms").val(c[1]);
					$("#specifications").val(c[2]);
					$("#licensenumber").val(c[3]);
					var tt = document.getElementById("quaMedicId");   
       				for(var ll=0;ll<tt.length;ll++){
        				if(c[5]==tt.options[ll].value){
            			tt.options[ll].selected=true;
		               }  
    	           }
				}else{
					return;
				}
			});
	    }else{
	    	$("#dosageforms").val("");
			$("#specifications").val("");
			$("#licensenumber").val("");
	    }
    
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
    function exportExcel(){
    	var  checkBox = document.getElementsByName("select_box");
    	var  value = "";
    	for(var i=0,n=checkBox.length;i<n;i++){
    		var obj = checkBox[i];
    		if(obj.checked==true){
    			value =obj.value;
    			
    		}
    	}
    	//alert(value);
    	$("#batchNumber").val(value);
    	if($("#batchNumber").val()=="" || $("#batchNumber").val()==null){
    		alert("请选择要打印的入库单！");
    		return;
    	}
    	var batch_number = $("#batchNumber").val();
    //	alert(batch_number);
    	
    	$("#export_form").submit();
    	if(typeof (batch_number) !="undefined" && batch_number!=""){
    		var array = batch_number.split(",");
    		$.post("${ctx}/drugState/checkaccept/ajaxChangePrintFlag.html",{
			acceptNoteId : array[0]
			},function(data){
				window.location.reload();
			});
    	}
		
	}
	function viewEntryTicket(){
    	var  checkBox = document.getElementsByName("select_box");
    	var  value = "";
    	for(var i=0,n=checkBox.length;i<n;i++){
    		var obj = checkBox[i];
    		if(obj.checked==true){
    			value =obj.value;
    			
    		}
    	}
    //	alert(value);
    	$("#batchNumber").val(value);
    	if($("#batchNumber").val()=="" || $("#batchNumber").val()==null){
    		alert("请选择要修改的入库单！");
    		return;
    	}
    	$("#export_form").attr("action","../../ireport/viewEntryTicket.html");
    	$("#export_form").submit();

	}
	$(function(){
		setDefaultForRadio("department","${department}");
		setDefaultForRadio("printFlag","${printFlag}");
		setDefaultForRadio("isfood","${isfood}");
	})
</script>

<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;委托储存验收检查记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				<th width="150">通用名称：</th>
				<input type="text" name="mingcheng" style="width:130px;" id="mingcheng" value="${mingcheng}" class="text1">
			<!--  
			<input type="text" class="easyui-combobox  text1" style="width:150px;" data-options="
      	 	valueField: 'id',
       		textField: 'text',
       		value:'${mingcheng}',
      		url:'${ctx}/drugState/inspectionRecords/findypboxqy.html',
      		onSelect: function(rec){
      			find(rec.id);
      		}
			" name="mingcheng" id="mingcheng" size="25"/>-->&nbsp;&nbsp;
				<label for="pinming">批号:</label>
				<input type="text" name="pihao" style="width:130px;" id="pihao" value="${pihao}" class="text1">
				
				<label>经营公司：</label>
				经营<input type="radio" name="department" value="1001"/>
				新品<input type="radio" name="department" value="2001"/>
				市场<input type="radio" name="department" value="3001"/>
				
				<label>打印类别：</label>
				未打印<input type="radio" name="printFlag" value="0">
				已打印<input type="radio" name="printFlag" value="1">
				<!--  
				<label>药品管理：</label>
				中成药<input type="radio" name="medicineManagement" value="0">
				专门管理要求药品<input type="radio" name="medicineManagement" value="1">
				-->
				<input type="submit" value="查询" class="btn_big"/>
								
			</form><!-- 
			<form action="../../ireport/exportEntryTicketJH.html" id="export_form" method="post" target="_blank">
				<input type="hidden" name="batchNumber" value="0010527" id="batchNumber"/>
				<shiro:hasPermission name="CheckRecord_PrintOrder">
					<input type="button" value="打印入库单" class="btn_big" onclick="exportExcel()"/>
				</shiro:hasPermission>
				
				<input type="button" value="修改入库单" class="btn_big" onclick="viewEntryTicket()"> 
			</form>-->
		</div>
	</div>
	</div>
		
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table_print" export="true" size="${resultSize}" partialList="true">
		<c:choose >
			<c:when test="${records.printFlag == '1'}">
				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"select_box\")' />全选" class="print_flag" ><input type="checkbox" name="select_box" value="${records.checkAcceptId },${records.shengchanph }" onclick="checkSelect()" /></display:column>
				<display:column property="department" sortable="true" titleKey="经营公司" class="print_flag"/>
				<display:column property="tongyongmc" sortable="true" titleKey="通用名称"  class="print_flag"/>
				<display:column property="jixing"  escapeXml="true" sortable="true" titleKey="剂型"  class="print_flag"></display:column>
				<display:column property="guige"  escapeXml="true" titleKey="规格" class="print_flag"></display:column>
				<display:column property="pizhunwenhao"  escapeXml="true" titleKey="批准文号" class="print_flag"></display:column>
				<display:column property="shengchanph"  escapeXml="true" titleKey="生产批号" class="print_flag"></display:column>
				<display:column property="shengchanrq"  escapeXml="true" titleKey="生产日期" class="print_flag"></display:column>
				<display:column property="youxiaoqz"  escapeXml="true" titleKey="有效期至" class="print_flag"></display:column>
				<display:column property="shengchancs"  escapeXml="true" titleKey="生产厂家" class="print_flag"></display:column>
				<display:column property="gonghuodw"  escapeXml="true" titleKey="供货单位" class="print_flag"></display:column>
				<display:column property="shuliang"  escapeXml="true" titleKey="到货数量" class="print_flag"></display:column>
				<display:column property="daohuorq"  escapeXml="true" titleKey="到货日期" class="print_flag"></display:column>
				<display:column property="hegesl"  escapeXml="true" titleKey="验收合格数量" class="print_flag"></display:column>
				<display:column escapeXml="true" titleKey="验收结果" class="print_flag">
					<c:if test="${records.yanshoujg != null}">
						<c:choose>
							<c:when test="${records.yanshoujg eq '0'}">合格</c:when>
							<c:when test="${records.yanshoujg eq '1'}">不合格</c:when>
						</c:choose>
					</c:if>
				</display:column>
				<display:column property="unhgsl"  escapeXml="true" titleKey="不合格数量" class="print_flag"></display:column>
				<display:column property="buhgx"  escapeXml="true" titleKey="不合格项" class="print_flag"></display:column>
				<display:column property="chuzhics"  escapeXml="true" titleKey="处理措施" class="print_flag"></display:column>
	  			<display:column property="ysnshouyuan"  escapeXml="true" titleKey="验收员" class="print_flag"></display:column>
     			 <display:column property="yanshourq"  escapeXml="true" titleKey="验收日期" class="print_flag"></display:column>    
     			 <display:column property="ysnshouyuan2"  escapeXml="true" titleKey="验收员2" class="print_flag"></display:column>
     			 <display:column property="yanshourq2"  escapeXml="true" titleKey="验收日期2" class="print_flag"></display:column> 
			</c:when>
			<c:otherwise>
				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id}' onclick='checkAll(\"select_box\")' />全选" class="noPrint_flag" ><input type="checkbox" name="select_box" value="${records.checkAcceptId },${records.shengchanph }" onclick="checkSelect()" ></display:column>
				<display:column property="department" sortable="true" titleKey="经营公司"  class="noPrint_flag" />
				<display:column property="tongyongmc" sortable="true" titleKey="通用名称"  class="noPrint_flag"/>
				<display:column property="jixing"  escapeXml="true" sortable="true" titleKey="剂型"  class="noPrint_flag"></display:column>
				<display:column property="guige"  escapeXml="true" titleKey="规格" class="noPrint_flag"></display:column>
				<display:column property="pizhunwenhao"  escapeXml="true" titleKey="批准文号" class="noPrint_flag"></display:column>
				<display:column property="shengchanph"  escapeXml="true" titleKey="生产批号" class="noPrint_flag"></display:column>
				<display:column property="shengchanrq"  escapeXml="true" titleKey="生产日期" class="noPrint_flag"></display:column>
				<display:column property="youxiaoqz"  escapeXml="true" titleKey="有效期至" class="noPrint_flag"></display:column>
				<display:column property="shengchancs"  escapeXml="true" titleKey="生产厂商" class="noPrint_flag"></display:column>
				<display:column property="gonghuodw"  escapeXml="true" titleKey="供货单位" class="noPrint_flag"></display:column>
				<display:column property="shuliang"  escapeXml="true" titleKey="到货数量" class="noPrint_flag"></display:column>
				<display:column property="daohuorq"  escapeXml="true" titleKey="到货日期" class="noPrint_flag"></display:column>
				<display:column property="hegesl"  escapeXml="true" titleKey="验收合格数量" class="noPrint_flag"></display:column>
				<display:column escapeXml="true" titleKey="验收结果" class="noPrint_flag">
					<c:if test="${records.chuzhics != null}">
						<c:choose>
							<c:when test="${records.chuzhics eq ''}">合格</c:when>
							<c:when test="${records.chuzhics eq '1'}">不合格</c:when>
							<c:when test="${records.chuzhics eq '2'}">不合格</c:when>
						</c:choose>
					</c:if>
					
					<c:if test="${records.chuzhics == null}">
						合格
					</c:if>
					
				</display:column>
				<display:column property="unhgsl"  escapeXml="true" titleKey="不合格数量" class="noPrint_flag"></display:column>
				<display:column property="buhgx"  escapeXml="true" titleKey="不合格项" class="noPrint_flag"></display:column>
				<display:column escapeXml="true" titleKey="处理措施" class="noPrint_flag">
					<c:if test="${records.chuzhics != null}">
						<c:choose>
							<c:when test="${records.chuzhics eq '1'}">报废</c:when>
							<c:when test="${records.chuzhics eq '2'}">退回</c:when>
						</c:choose>
					</c:if>
				</display:column>
	  			<display:column property="ysnshouyuan"  escapeXml="true" titleKey="验收员" class="noPrint_flag"></display:column>
     			 <display:column property="yanshourq"  escapeXml="true" titleKey="验收日期" class="noPrint_flag"></display:column>   
     			 <display:column property="ysnshouyuan2"  escapeXml="true" titleKey="验收员2" class="noPrint_flag"></display:column>
     			 <display:column property="yanshourq2"  escapeXml="true" titleKey="验收日期2" class="noPrint_flag"></display:column>  
			</c:otherwise>
		</c:choose>
		<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
		</display:setProperty> 
		<display:setProperty name="export.excel" value="true"/>
	</display:table>
	</div>
</form>




