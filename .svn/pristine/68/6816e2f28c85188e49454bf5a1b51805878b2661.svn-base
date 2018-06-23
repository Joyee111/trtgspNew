<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="退货收货记录" />
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
	<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>	





