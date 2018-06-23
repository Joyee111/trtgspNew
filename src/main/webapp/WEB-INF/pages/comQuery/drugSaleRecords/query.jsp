<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="药品销售记录" />
</title>

</head>&nbsp; 
<script type="text/javascript">
	
   $(function() {
   		setDefaultForRadio("deparment","${deparment}");
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
    
    $("#startDate").datebox({
    		onSelect:function(date){
    			//alert(date);
    			var startDate=$("#startDate").datebox("getValue");
    			var endDate = $("#endDate").datebox("getValue");
    			
    			if(typeof(endDate)!=undefined && endDate!=""){
    				if(startDate > endDate){
    					alert("起始时间不能大于结束时间");
    					$("#startDate").datebox("setValue","");
    				}
    			}
    			
    		}
    	});
    	$("#endDate").datebox({
    		onSelect:function(date){
    			//alert(date);
    			var startDate = $("#startDate").datebox("getValue");
    			var endDate = $("#endDate").datebox("getValue");
    		
    			if(typeof(startDate)!=undefined && startDate!=""){
    				if(startDate > endDate){
    					alert("结束时间不能大于开始时间");
    					$("#endDate").datebox("setValue","");
    				}
    			}
    			
    		}
    	}); 
 }); 
   function chaxun() {
		var startDate = $("#startDate").datebox("getValue");
		if(startDate == ""){
			alert("销售时间不能为空");
			return;
		} else {
			var form = document.getElementById("query");
			form.submit();
		}
	}
 
</script>

<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;药品销售记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
			<label for="maintaindate">销售单号:</label>
				<input type="text"  name="xiaoshoudh" id="xiaoshoudh" value="${xiaoshoudh}" class="text1">
				<label for="maintaindate">购货单位:</label>
				<input type="text" class="easyui-combobox  text1" data-options="value: '${tuihuodanwei}'" name="" id="commonnameboxs" size="40"/>
	          <input type="hidden" id="tuihuodanwei" name="tuihuodanwei" value=""/>
				<label for="pinming">批号:</label>
				<input type="text" name="pihao" id="pihao" value="${pihao}" class="text1"><br/><br>
				<label for="">通用名称:</label>
				<input type="text" name="commonName" id="commonName" value="${commonName }" class="text1">
				销售时间：<input type="text" class="easyui-datebox text1" value="${startDate}" name="startDate" id="startDate" data-options="required:true,validType:'date'" />&nbsp;--&nbsp;<input type="text" class="easyui-datebox text1" name="endDate" id="endDate" value="${endDate}"/>
				<label>经营公司:</label>
				经营&nbsp;<input type="radio" name="deparment" value="1001">
				新品&nbsp;<input type="radio" name="deparment" value="2001">
				市场&nbsp;<input type="radio" name="deparment" value="3001">
				<input type="submit" value="查询" class="btn_big"/>
				<%-- <input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>--%>
				
			</form>
		</div>
	</div>
	</div>
		
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		
		<display:column property="xiaoshouriqi" sortable="true" titleKey="销售日期" decorator="com.sinosoft.util.FormatDateColumnDecorator" />
		<display:column property="saleItemNumber" sortable="true" titleKey="销售明细单号"  />
		<display:column sortable="true" titleKey="经营公司">
			<c:choose>
				<c:when test="${records.department=='1001'}">
					<c:out value="经营"></c:out>
				</c:when>
				<c:when test="${records.department=='2001'}">
					<c:out value="新品"></c:out>
				</c:when>
				<c:when test="${records.department=='3001'}">
					<c:out value="市场"></c:out>
				</c:when>
			</c:choose>
		</display:column>
		<display:column property="gouhuodw" sortable="true" titleKey="购货单位"  />
		<display:column property="yaopinhao" sortable="true" titleKey="药品编号"  />
		<display:column property="mingcheng" sortable="true" titleKey="通用名称"  />
		<display:column property="jixing"  escapeXml="true" sortable="true" titleKey="剂型"  ></display:column>
		<display:column property="guige"  escapeXml="true" titleKey="规格"></display:column>
		<display:column property="danwei"  escapeXml="true" titleKey="单位"></display:column>
		<display:column property="jiage"  escapeXml="true" titleKey="单价"></display:column>
		<display:column property="shuliang"  escapeXml="true" titleKey="销售数量"></display:column>
		 <display:column property="jine"  escapeXml="true" titleKey="金额"></display:column>
		 		 <display:column property="pihao"  escapeXml="true" titleKey="批号"></display:column>
		<display:column property="youxiaoqi"  escapeXml="true" titleKey="有效期至"></display:column>
		<display:column property="shengchancs"  escapeXml="true" titleKey="生产厂商"></display:column>
		<display:column property="xiaoshouyuan"  escapeXml="true" titleKey="销售员"></display:column>
		<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
				</display:setProperty> 
				<display:setProperty name="export.excel" value="true"/>
	</display:table>
	</div>
</form>




