<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="销售退回药品验收记录" />
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
    
</script>


<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;销售退回验收记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				<label for="maintaindate">退货单位:</label>
	
	<input type="text" class="easyui-combobox  text1" data-options="value: '${tuihuodanwei}'" name="" id="commonnameboxs" size="40"/>
	<input type="hidden" id="tuihuodanwei" name="tuihuodanwei" value="${tuihuodanwei}"/>
			<th width="150">通用名称：</th>
		<td style="width:400px;">
			<input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
       		value:'${mingcheng}',
      		url:'${ctx}/drugState/inspectionRecords/findypboxqy.html',
      		onSelect: function(rec){
      			find(rec.id);
      		}
			" name="mingcheng" id="mingcheng" size="40"/>&nbsp;&nbsp;
		</td>
		<th>退货单号：</th>
				<td><input type="text" name="returnNo" value="${returnNo}" class="text1"></td>
		<br/><br/>
				<label for="maintaindate">退货时间:</label>
				<input type="text"  class="easyui-datebox text1" data-options="validType:'date'" name="yssj" id="yssj" value="${yssj}">
				<label for="pinming">至:</label>
				<input type="text" class="easyui-datebox text1" data-options="validType:'date'" name="zhi" id="zhi" value="${zhi}">
				<label>销售公司：</label>
				经营<input type="radio" name="department" value="Y">
				&nbsp;新品<input type="radio" name="department" value="X">
				&nbsp;市场<input type="radio" name="department" value="S">
				<input type="submit" value="查询" class="btn_big"/>
			</form>
		</div>
	</div>
	</div>
	<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>	





