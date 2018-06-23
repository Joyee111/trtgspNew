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
    setDefaultForRadio("department","${department}")
    setDefaultForRadio("isfood","${isfood}")
 }); 
   function exportAll(){
  	 $("#query").attr("action","exportAll.html");
	$("#query").submit();
	$("#query").attr("action","query.html");
   }
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
			" name="mingcheng" id=""mingcheng"" size="40"/>&nbsp;&nbsp;
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
		
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column property="tuihuidw" sortable="true" titleKey="退回单位"  maxLength="10"/>
<%-- 		<display:column  sortable="true" titleKey="销售公司">
			<c:choose>
				<c:when test="${fn:startsWith(records.xiaoshougongsi,'Y') }">
					<c:out value="经营"></c:out>
				</c:when>
				<c:when test="${fn:startsWith(records.xiaoshougongsi,'X') }">
					<c:out value="新品"></c:out>
				</c:when>
				<c:when test="${fn:startsWith(records.xiaoshougongsi,'S') }">
					<c:out value="市场"></c:out>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</display:column> --%>
		<display:column property="tuihuiriqi" sortable="true" titleKey="退货日期"  />
		<display:column property="huohao" sortable="true" titleKey="货号"  />
		<display:column property="pinming" sortable="true" titleKey="通用名称"  />
		<display:column property="jixing" sortable="true" titleKey="剂型"  />
		<display:column property="guige"  escapeXml="true" titleKey="规格"></display:column>
		<display:column property="pizhunwh"  escapeXml="true" titleKey="批准文号"></display:column>
		<display:column property="pihao"  escapeXml="true" titleKey="批号"></display:column>
		<display:column property="shengchancj"  escapeXml="true" titleKey="生产厂商" maxLength="35"></display:column>
		<display:column property="shengchanriqi"  escapeXml="true" titleKey="生产日期"></display:column>
		<display:column property="youxiaoqi"  escapeXml="true" titleKey="有效期至"></display:column>
		<display:column property="shuliang"  escapeXml="true" titleKey="退货数量"></display:column>
   		<display:column property="yanshourq"  escapeXml="true" titleKey="验收日期"></display:column>
   		<display:column property="yanshourq2"  escapeXml="true" titleKey="验收日期2"></display:column>
   		<display:column property="jianchajl"  escapeXml="true" titleKey="退货原因"></display:column>
		<display:column property="yanshoujg"  escapeXml="true" titleKey="验收结果"></display:column>
		<display:column property="yanshouyuan"  escapeXml="true" titleKey="验收员"></display:column>
		<display:column property="yanshouyuan2"  escapeXml="true" titleKey="验收员2"></display:column>
		<display:column property="hegshuliang"  escapeXml="true" titleKey="合格数量"></display:column>
		<display:column property="buhegeshuliang"  escapeXml="true" titleKey="不合格数量"></display:column>
		<display:column property="tuihuigongyingshangshuliang"  escapeXml="true" titleKey="退回供应商数量"></display:column>
		<display:column property="fuchajielun"  escapeXml="true" titleKey="复验结论" maxLength="25"></display:column>
		<display:column property="fuyanry"  escapeXml="true" titleKey="复验人员"></display:column>
		<display:column property="fujianriqi"  escapeXml="true" titleKey="复验日期"></display:column>
		<display:setProperty name="export.banner" >
			<div class="exportlinks"><fmt:message key="export.banner"/></div>
		</display:setProperty> 
	</display:table>
	<input type="button" value="导出Excel" class="btn_big" style="margin-left: 70px;margin-top: -21px" onclick="exportAll()">
	</div>
</form>




