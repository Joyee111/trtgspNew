<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="药品检查验收记录" />
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
pr</script>


<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;药品检查验收记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				<th width="150">通用名称：</th>
			<input type="text" class="easyui-combobox  text1" style="width:150px;" data-options="
      	 	valueField: 'id',
       		textField: 'text',
       		value:'${mingcheng}',
      		url:'${ctx}/drugState/inspectionRecords/findypboxqy.html',
      		onSelect: function(rec){
      			find(rec.id);
      		}
			" name="mingcheng" id="mingcheng" size="25"/>&nbsp;&nbsp;
				<label for="pinming">批号:</label>
				<input type="text" name="pihao" style="width:130px;" id="pihao" value="${pihao}" class="text1">
				
				<label>经营公司：</label>
				经营<input type="radio" name="department" value="1001"/>
				新品<input type="radio" name="department" value="2001"/>
				市场<input type="radio" name="department" value="3001"/>
				
				<label>打印类别：</label>
				未打印<input type="radio" name="printFlag" value="0">
				已打印<input type="radio" name="printFlag" value="1">
				
				<label>药品管理：</label>
				一般药品<input type="radio" name="medicineManagement" value="0">
				专门管理要求药品<input type="radio" name="medicineManagement" value="1">
				
				<input type="submit" value="查询" class="btn_big"/>
								
			</form>
		</div>
	</div>
	</div>
	<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>	





