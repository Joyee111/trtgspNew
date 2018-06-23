<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="药品销售记录" />
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
				<input type="text" name="pihao" id="pihao" value="${pihao}" class="text1"><br/><br/>
				<label for="">通用名称:</label>
				<input type="text" name="commonName" id="commonName" value="${commonName }" class="text1">
				销售时间：<input type="text" class="easyui-datebox text1" name="startDate" id="startDate"  />&nbsp;--&nbsp;<input type="text" class="easyui-datebox text1" name="endDate" id="endDate" />
				<label>经营公司:</label>
				经营&nbsp;<input type="radio" name="deparment" value="1001">
				新品&nbsp;<input type="radio" name="deparment" value="2001">
				市场&nbsp;<input type="radio" name="deparment" value="3001">
				<input type="submit" value="查询" class="btn_big"/>
				<%--<input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>--%>
			</form>
		</div>
	</div>
	</div>
	<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>	





