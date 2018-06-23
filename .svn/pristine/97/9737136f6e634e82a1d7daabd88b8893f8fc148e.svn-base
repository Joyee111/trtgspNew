<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="退货药品记录" />
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
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;退货药品记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
					<label for="maintaindate">退货日期:</label>
				<input type="text"  class="easyui-datebox text1" data-options="validType:'date'" name="tuihuoriqi" id="tuihuoriqi" value="${tuihuoriqi}">
				<label for="maintaindate">至:</label>
				<input type="text"  class="easyui-datebox text1" data-options="validType:'date'" name="zhi" id="zhi" value="${zhi}">
				<label for="maintaindate">退货单位:</label>
			<input type="text" class="easyui-combobox  text1" data-options="value: '${tuihuodanwei}'" name="" id="commonnameboxs" size="30"/>
	          <input type="hidden" id="tuihuodanwei" name="tuihuodanwei" value="${tuihuodanwei}"/>
				<label for="pinming">批号:</label>
				<input type="text" name="pihao" id="pihao" value="${pihao}" class="text1">
			    <input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>
				
			</form>
		</div>
	</div>
	</div>
		
<form action="" id="records" method="post">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column property="tuihuorq" sortable="true" titleKey="退货日期"  />
		<display:column property="tuihuodw" sortable="true" titleKey="退货单位"  />
		<display:column property="huohao" sortable="true" titleKey="货号"  />
		
		<display:column property="mingcheng" sortable="true" titleKey="通用名称"  />
		<display:column property="jixing"  escapeXml="true" sortable="true" titleKey="剂型"  ></display:column>
		<display:column property="guige"  escapeXml="true" titleKey="规格"></display:column>
		<display:column property="shuliang"  escapeXml="true" titleKey="数量"></display:column>
        <display:column property="pihao"  escapeXml="true" titleKey="批号"></display:column>
		<display:column property="youxiaoqi"  escapeXml="true" titleKey="有效期至"></display:column>
		<display:column property="shengchanriqi"  escapeXml="true" titleKey="生产日期"></display:column>
		<display:column property="shanghcan"  escapeXml="true" titleKey="生产厂商"></display:column>
		<display:column property="tuihuodh"  escapeXml="true" titleKey="退货单号"></display:column>
		<display:column property="baoguanyuan" sortable="true" titleKey="保管员"  />
		<display:column property="beizhu" sortable="true" titleKey="备注"  />
		<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
				</display:setProperty> 

	</display:table>
	<input type="button" value="导出Excel" class="btn_big" style="margin-left: 70px;margin-top: -21px;" onclick="exportAllRecords()">
	</div>
</form>




