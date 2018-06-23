<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>品种查询</title>
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
<body>
	           <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;品种查询</font>	
        	<div class="caozuo_box">
        	<form name="query_qualifiedMedic" id="query_qualifiedMedic" action="queryQulidiedMedicinal.html" method="post">
               	 通用名称（品名） <input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       	 textField: 'text',
       	 value:'${mingcheng}',
      	 url:'../../drugState/inspectionRecords/findypboxqy.html',
      	 onSelect: function(rec){
      	 find(rec.id);
      	 }
        " name="mingcheng" id="mingcheng" size="40"/>
               	
                &nbsp;&nbsp;&nbsp;&nbsp;剂型
             <input type="text" class="easyui-combobox  text1" data-options="
      	 	valueField: 'id',
       		textField: 'text',
      		url:'../../comQuery/varietyQuery/findjxboxqy.html',
      		value:'${forms}',
      		onSelect: function(rec){
      			var str = rec.id;
      			
      		}
			" name="forms" id="forms" size="40"/>&nbsp;&nbsp;
                	</br>
			<br>
			 <label for="shzt">状态标识:</label>
	
			 <input type="checkbox" name="tyzt" id="tyzt1" value="0" />
			 <font style="font-size:12px; color:#727171; font-weight:bold;">启用</font>
			  <input type="checkbox" name="tyzt" id="tyzt2" value="1" />
			 <font style="font-size:12px; color:#727171; font-weight:bold;">停用</font>
			<label>&nbsp;&nbsp;经营公司：</label>
			&nbsp;经营&nbsp;<input type="radio" name="department" value="1001"/>
			新品&nbsp;<input type="radio" name="department" value="2001"/>
			市场&nbsp;<input type="radio" name="department" value="3001"/>
			<input type="hidden" id ="tyztValue" name="tyztValue" value="${tyzt}" />
			<input class="btn_big" type="submit" value="查询"  />  
           </form>
            </div>
          <div class="zhushi_box">

            <span><marquee width=95% onmouseover="this.stop()" onmouseout="this.start()"  scrollamount="5" id="warnMessage"></marquee></span>
        </div>
            <form  id="del_sypzdsh" method="post" >
 			<display:table name="qualityMidicinesList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="qualifiedMedic" pagesize="${pagesize}" class="table" export="true" size="${resultSize}" partialList="true">
 			<display:column escapeXml="true" sortable="false" titleKey="经营公司">
 				<c:choose>
 					<c:when test="${qualifiedMedic.departmentId=='1001'}">
 						<c:out value="经营"></c:out>
 					</c:when>
 					<c:when test="${qualifiedMedic.departmentId=='2001'}">
 						<c:out value="新品"></c:out>
 					</c:when>
 					<c:when test="${qualifiedMedic.departmentId=='3001'}">
 						<c:out value="市场"></c:out>
 					</c:when>
 					<c:otherwise>
 						<c:out value=""></c:out>
 					</c:otherwise>
 				</c:choose>
 				</display:column>
 				<display:column property="medicinalNo" escapeXml="true" sortable="false" titleKey="药品编号" />
 				<display:column property="commonname" escapeXml="true" sortable="false" titleKey="通用名称（品名）" />
				<display:column property="dosageforms.formName" escapeXml="true" sortable="false" titleKey="剂型"/>
				<display:column property="produceno.customerName" escapeXml="true" sortable="false" titleKey="生产企业"/>
				<display:column property="specifications" escapeXml="true" sortable="false" titleKey="规    格"/>
				<display:column property="licensenumber" escapeXml="true" sortable="false" titleKey="批准文号"/>
				<display:column property="validdate" escapeXml="true" sortable="false" titleKey="有 效 期"/>
				<display:column titleKey="操作" autolink="true" media="html"  class="border_rnone">
				 <img src="../../images/edit.gif"/><a href="viewQulidiedMedicinal.html?id=${qualifiedMedic.id}">查看</a>
				</display:column>
    			<display:setProperty name="export.banner" >
					<div class="exportlinks"><fmt:message key="export.banner"/></div>
				</display:setProperty> 
				<display:setProperty name="export.excel" value="fales"/>
			</display:table>
			<input type="button" value="导出Excel" class="btn_big" style="margin-left: 70px;margin-top: -21px" onclick="exportAll()">
			<input type="hidden" name="save_type" id="save_type">
			</form>
	<script type="text/javascript">
	$(function(){
		$.post("../../drugVarieties/ajaxQueryWarnMedicinal.html",function(data){
				var json = jsonParse(data);
				var str = json.success;	
				//alert(str);
				$("#warnMessage").empty();
				$("#warnMessage").append(str);
			})
	})
			$(function() {
    	setDefaultForRadio("department","${department}")
    	setDefaultForRadio("isfood","${isfood}")
       var  tyztValue=document.getElementById("tyztValue");
     	var  tyzt1=document.getElementById("tyzt1");
     	var  tyzt2=document.getElementById("tyzt2");
  
     	if(tyztValue != null && ""!=tyztValue){
     		var a = tyztValue.value.split(",");
     		for(var i=0;i<a.length;i++){
     			if(a[i]==tyzt1.value){
     				tyzt1.checked=true;
     			}
				if(a[i]==tyzt2.value){
     				tyzt2.checked=true;
     			}
     			
     		}
     		
     	}
    	
    
    });
    
     function exportAll(){
  	 $("#query_qualifiedMedic").attr("action","exportAll.html");
	$("#query_qualifiedMedic").submit();
	$("#query_qualifiedMedic").attr("action","list.html");
   }
	
    </script>
</body>
</html>