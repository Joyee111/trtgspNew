<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="退货收货记录" />
</title>

</head>
<script type="text/javascript">
	
   $(function() {
    	$('#commonnameboxs').combobox({  
        //url:urlStr,  
        valueField: 'id',
      	textField: 'text', 
        onChange:function (newValue, oldValue){  
            if(newValue !=null && newValue!=""){  
                var urlStr ="${ctx}/drugState/inspectionRecords/qualityPurchaseJson.html?name=" + encodeURIComponent(newValue);  
                $("#commonnameboxs").combobox("reload",urlStr);  
            }  
        }  ,
        onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#tuihuodanwei').val(str[1]);
      		}
    });  
 }); 
     function chaxun(){
	
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
		
		function exportAllRecords(){
			$("#query").attr("action","exportAllRecords.html");
			$("#query").submit();
			$("#query").attr("action","query.html");
		}
</script>

<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;退货收货记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				退货日期：<input name="yhDate" type="text" value="${yhDate}" class="easyui-datebox text1" data-options="validType:'date'"/> &nbsp;
				通用名称：<input type="text" name="commonName" value="${commonName }" class="text1" /> &nbsp;
				销售单号：<input type="text" name="xiaoshoudanhao" value="${xiaoshoudanhao }" class="text1" />
			    <input type="submit" value="查询" class="btn_big"/>
				
			</form>
		</div>
	</div>
	</div>
		
<form action="" id="records" method="post">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column property="number" sortable="true" titleKey="单据号"  />
		<display:column property="salesNum" sortable="true" titleKey="销售单号"  />
		<display:column property="commonName" sortable="true" titleKey="通用名称"  />
		
		<display:column property="medc_no" sortable="true" titleKey="货号"  />
		<display:column property="batchProduction"  escapeXml="true" sortable="true" titleKey="批号"  ></display:column>
		<display:column property="customerName"  escapeXml="true" titleKey="退货单位"></display:column>
		<display:column property="quantity"  escapeXml="true" titleKey="退货数量"></display:column>
        <display:column property="arrivalDate"  escapeXml="true" titleKey="退货时间"></display:column>
		<display:column property="enddate"  escapeXml="true" titleKey="有效期至"></display:column>
		<display:column property="checkConclusion"  escapeXml="true" titleKey="退货原因"></display:column>
		<display:column property="goodsClerk"  escapeXml="true" titleKey="收货员"></display:column>
		

	</display:table>
	<!--  <input type="button" value="导出Excel" class="btn_big" style="margin-left: 70px;margin-top: -21px;" onclick="exportAllRecords()"> -->
	</div>
</form>




