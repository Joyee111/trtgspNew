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
				<input type="text" class="easyui-combobox  text1" data-options="value: '${gouhuodw}'" name="" id="commonnameboxs" size="40"/>
	        <input type="hidden" id="tuihuodanwei" name="tuihuodanwei" value="${gouhuodw}"/>
				<label for="pinming">批号:</label>
				<input type="text" name="pihao" id="pihao" value="${pihao}" class="text1">
					<label for="maintaindate">销售单号:</label>
				<input type="text"  name="xsdh" id="xsdh" value="${xsdh}" class="text1"></br>
				<label for="pinming">出库时间:</label>
				<input type="text" class="easyui-datebox text1" data-options="validType:'date'" name="cksj" id="cksh" value="${cksj}">
				<label for="maintaindate">至:</label>
				<input type="text"  class="easyui-datebox text1" data-options="validType:'date'" name="zhi" id="zhi" value="${zhi}">
						 <input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>
				
			</form>
		</div>
	</div>
	</div>
		
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column property="xiaoshoudanhao" sortable="true" titleKey="销售单号"  />
		<display:column property="xiaoshourq" sortable="true" titleKey="销售日期"  />
		<display:column property="gouhuodw" sortable="true" titleKey="购货单位"  />
		<display:column property="yaopinm" sortable="true" titleKey="通用名称"  />
		<display:column property="jixing"  escapeXml="true" sortable="true" titleKey="剂型"  ></display:column>
		<display:column property="guige"  escapeXml="true" titleKey="规格"></display:column>
		<display:column property="shuliang"  escapeXml="true" titleKey="数量"></display:column>

		<display:column property="shengchancj"  escapeXml="true" titleKey="生产厂商"></display:column>
		 <display:column property="pihao"  escapeXml="true" titleKey="批号"></display:column>
		<display:column property="youxiaoqi"  escapeXml="true" titleKey="有效期至"></display:column>
		<display:column property="zhiliangzk"  escapeXml="true" titleKey="质量状况"></display:column>
		<display:column property="chukuren"  escapeXml="true" titleKey="出库人"></display:column>
		<display:column property="fuheren"  escapeXml="true" titleKey="复核人"></display:column>
		<display:column property="fuheren2"  escapeXml="true" titleKey="复核人2"></display:column>
		<display:column property="beizhu"  escapeXml="true" titleKey="备注"></display:column>
		<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
				</display:setProperty> 
				<display:setProperty name="export.excel" value="true"/>
	</display:table>
	</div>
</form>




