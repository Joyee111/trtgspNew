<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="药品出库复核记录" />
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
	
	 var cksh = $("#cksh").datebox("getValue");
		  var zhi = $("#zhi").datebox("getValue");

		  if(cksh !=''&& zhi!=''&& cksh > zhi){
           alert("开始时间不能早于截止时间");
            return;
		}else{
		var form = document.getElementById("query");
    	form.submit();
		}
		}
</script>


<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;药品出库复核记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				<label for="maintaindate">购货单位:</label>
					
	<input type="text" class="easyui-combobox  text1" data-options="value: '${tuihuodanwei}'" name="" id="commonnameboxs" size="40"/>
	<input type="hidden" id="tuihuodanwei" name="tuihuodanwei" value="${tuihuodanwei}"/>
				<label for="pinming">批号:</label>
				<input type="text" name="pihao" id="pihao" value="${pihao}" class="text1">
				<label for="maintaindate">销售单号:</label>
				<input type="text"  name="xsdh" id="xsdh" value="${xsdh}" class="text1"></br>
				<label for="pinming">出库时间:</label>
				<input type="text" class="easyui-datebox text1"  data-options="validType:'date'" name="cksj" id="cksh" value="${cksh}">
				<label for="maintaindate">至:</label>
				<input type="text"  class="easyui-datebox text1" data-options="validType:'date'" name="zhi" id="zhi" value="${zhi}">
				 <input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>
			</form>
		</div>
	</div>
	</div>
	<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>	





