<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="投诉管理" />
</title>
</head>
<script type="text/javascript">
	function check(){
		alert(1);
	}
	function chaxun(){
	
	 var tousuriqi = $("#tousuriqi").datebox("getValue");
		  var zhi = $("#zhi").datebox("getValue");

		  if(tousuriqi !=''&& zhi!=''&& tousuriqi > zhi){
           alert("开始时间不能早于截止时间");
            return;
		}else{
		var form = document.getElementById("query");
    	form.submit();
		}
		}
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
    
       var  wcqkValue=document.getElementById("wcqkValue");
     	var  wcqk1=document.getElementById("wcqk1");
     	var  wcqk2=document.getElementById("wcqk2");
  
     	if(wcqkValue != null && ""!=wcqkValue){
     		var a = wcqkValue.value.split(",");
     		for(var i=0;i<a.length;i++){
     			if(a[i]==wcqk1.value){
     				wcqk1.checked=true;
     			}
				if(a[i]==wcqk2.value){
     				wcqk2.checked=true;
     			}
     			
     		}
     		
     	}
    	
    
    });
</script>

<div >
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;投诉查询</font>
	<div class="tab_con">
		<div class="caozuo_box">
			<form name="query" id="query" action="query.html" method="post">
			<input type="hidden" name="ptmeth" value="${ptmeth}"/>
			<input type="hidden" name="tz" value="${thispage}"/>
			<label for="tousu">投诉者:</label>
			<input type="text" name="tousu" id="tousu" value="${tousu}" class="text1">
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
			<label for="maintaindate">投诉日期:</label>
				<input type="text"  class="easyui-datebox text1" name="tousuriqi" id="tousuriqi" value="${tousuriqi}" data-options="validType:'date'">
				<label for="maintaindate">至:</label>
				<input type="text"  class="easyui-datebox text1" name="zhi" id="zhi" value="${zhi}" data-options="validType:'date'">
				     	</br>
			<br>
			 <label for="shzt">完成情况:</label>
	
			 <input type="checkbox" name="wcqk" id="wcqk1" value="0"  />
			 <font style="font-size:12px; color:#727171; font-weight:bold;">完成</font>
			  <input type="checkbox" name="wcqk" id="wcqk2" value="1" />
			 <font style="font-size:12px; color:#727171; font-weight:bold;">未完成</font>

			
			<input type="hidden" id ="wcqkValue" name="wcqkValue" value="${wcqk}" class="text1" />
			 <input type="button" class="btn_big"  name="" onclick="chaxun()" value="查询"/>
			</form>
		</div>
</div>	
		
<form action="" id="records">
	<div class="ceng_mar5">
	<display:table name="reslist" cellspacing="0" cellpadding="0" requestURI=""  style="width:98%;" id="records" pagesize="${pageSize}" class="table" export="true" size="${resultSize}" partialList="true">
		
		<display:column property="bianhao" sortable="true" titleKey="编号"  maxLength="15"/>
		<display:column property="complainant" sortable="true" titleKey="ddrugComInfo.complainant"  maxLength="15"/>
		<display:column property="phone"  escapeXml="true" sortable="true" titleKey="ddrugComInfo.phone"></display:column>
		<display:column property="quaMedicId"  escapeXml="true" sortable="true" titleKey="品名"  style="width:15%;"></display:column>
		<display:column property="jixing"  escapeXml="true" titleKey="剂型"></display:column>
		<display:column property="guige"  titleKey="规格" autolink="true"  ></display:column>
		<display:column property="pihao"  escapeXml="true" titleKey="批号"></display:column>
		<display:column property="quantity"  escapeXml="true" titleKey="数量"></display:column>
		<display:column property="modifiedtime"  escapeXml="true" titleKey="查询时间" decorator="com.sinosoft.util.FormatDateColumnDecorator"></display:column>
		
			<display:column titleKey="user.operate" autolink="true"  style="border-right:1px solid #feb808;">
             <img src="../../images/edit.gif"/><a href="${ctx}/comQuery/drugComInfoRecords/view.html?method=edit&id=<c:out value="${records.id}"/>&thispage=${thispage}">
			<fmt:message key="查看"/>
		
		</a>
	</display:column>
	<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
				</display:setProperty> 
				<display:setProperty name="export.excel" value="true"/>
	</display:table>
	</div>

</form>
<form id="baseForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" name="method" value="add"   />
</form>
<form id="delForm">
	<input type="hidden" name="thispage" value="${thispage}" />
	<input type="hidden" id="resId" name="ids"  value=""   />
</form>
</div>

