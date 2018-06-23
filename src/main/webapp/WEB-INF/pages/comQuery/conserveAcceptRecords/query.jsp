<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="药品养护检查记录" />
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
    function chaxun(){
	
	 var jianchariqi = $("#jianchariqi").datebox("getValue");
		  var zhi = $("#zhi").datebox("getValue");

		  if(jianchariqi !=''&& zhi!=''&& jianchariqi > zhi){
           alert("开始时间不能早于截止时间");
            return;
		}else{
		var form = document.getElementById("query");
    	form.submit();
		}
		}
</script>

<div>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;药品养护检查记录</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
				<input type="hidden" name="ptmeth" value="${ptmeth}"/>
				<input type="hidden" name="tz" value="${thispage}"/>
				<label for="maintaindate">检查日期:</label>
				<input type="text"  class="easyui-datebox text1" name="jianchariqi" id="jianchariqi" value="${jianchariqi}" data-options="validType:'date'">
				<label for="maintaindate">至:</label>
				<input type="text"  class="easyui-datebox text1" name="zhi" id="zhi" value="${zhi}" data-options="validType:'date'">
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
				<label for="pinming">批号:</label>
				<input type="text" name="pihao" id="pihao" value="${pihao}" class="text1">
				<br>
				<br>
				<label>经营公司：</label>
				经营<input type="radio" name="department" value="1001">
				&nbsp;新品<input type="radio" name="department" value="2001">
				&nbsp;市场<input type="radio" name="department" value="3001">&nbsp;


				 <input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>
				
			</form>
		</div>
	</div>
	</div>
		
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:100%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		<display:column property="maintaindate"  escapeXml="true" titleKey="检查日期"></display:column>
		<display:column property="qualifiedmedcstoreRe.qualityMidicine.medicinalNo" sortable="true" titleKey="货号"  maxLength="15"/>
		<display:column property="qualifiedmedcstoreRe.qualityMidicine.commonname" sortable="true" titleKey="通用名称"  maxLength="15"/>
		<display:column property="qualifiedmedcstoreRe.qualityMidicine.dosageforms.formName"  escapeXml="true" sortable="true" titleKey="剂型"  style="width:15%;"></display:column>
		<display:column property="qualifiedmedcstoreRe.qualityMidicine.specifications"  escapeXml="true" titleKey="规格"></display:column>
		<display:column property="qualifiedmedcstoreRe.qualityMidicine.unit"  escapeXml="true" titleKey="单位"></display:column>
			<display:column property="quantity"  escapeXml="true" titleKey="检查数量"></display:column>
			<display:column property="qualifiedmedcstoreRe.qualityMidicine.produceno.customerName"  escapeXml="true" titleKey="生产厂商"></display:column>
			<display:column property="batchnumber"  escapeXml="true" titleKey="批号"></display:column>
			<display:column property="qualifiedmedcstoreRe.validdate"  escapeXml="true" titleKey="有效期至"></display:column>
		<display:column property="qualityproblemString"  escapeXml="true" titleKey="包装、外观检查情况及结论"></display:column>
				<display:column property="user.realname"  escapeXml="true" titleKey="养护员"></display:column>
				<display:column property="result"  escapeXml="true" titleKey="处理意见"></display:column>
			
	<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
				</display:setProperty> 
				<display:setProperty name="export.excel" value="true"/>
	</display:table>
	</div>
</form>




