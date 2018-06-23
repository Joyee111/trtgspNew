<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>系统数据字典维护</title>
</head>
<body>
		<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">系统管理&nbsp;>&nbsp;数据字典&nbsp;>&nbsp;剂型维护</font>
		 <div class="tab_biao">
			<a href="drugFroms.html" class="on" ><span><font>剂型维护</font>
			</span>
			</a>
			<a href="baseCriterias.html" ><span><font>质量标准依据</font>
			</span>
			</a>
		</div>

    	 <div class="tab_con">
        	<div class="caozuo_box">
        	<form name="query_drugfrom" id="query_drugfrom" action="queryDrugFrom.html" method="post">
               	剂型名称 <input name="formName" id="formName" type="text" class="text1" size="20"/>
                <input name="" type="submit" class="btn_big" value="查询"/>
           </form>
            </div>
            <form name="drugFrom" action="" id="drug_From" method="post" >
 			<display:table name="drugFromList" cellspacing="0" cellpadding="0" requestURI="" style="width:98%;" id="drugFrom" pagesize="${pagesize}" class="table" export="true" size="${resultSize}" partialList="true">
 				<display:column title="<input type='checkbox' id='checkall' name='checkall' value='${id }' onclick='checkAll(\"delete_id\")' />全选" media="html"><input type="checkbox" name="delete_id" value="${drugFrom.id}" ></display:column>
 				<display:column property="id" escapeXml="true" sortable="false" titleKey="ID " />
				<display:column property="formName" escapeXml="true" sortable="false" titleKey="剂型名称"/>
				<display:column titleKey="操作" autolink="true" media="html"  class="border_rnone">
				<img src="../../images/edit.gif"/><a href="editDrugFrom.html?id=${drugFrom.id}&type=0">编辑</a>
				</display:column>
    			<display:setProperty name="export.pdf" value="false" /> 
				<display:setProperty name="export.csv" value="false" /> 
				<display:setProperty name="export.xml" value="false" /> 
			</display:table>
			</form>
            <div class="caozuo_box2">
            <input name="" type="button" class="btn_big" value="新增" onclick="addDrugFrom()"/>
            </div>
            </div>
	<script type="text/javascript">
	function addDrugFrom(){
		window.location.href="addDrugFrom.html";
	}
	function deletDrugFrom(str){
		//var from =document.getElementById("del_syqydlr");
		var  value = str; 
		var r=confirm("是否确认删除！")
		if(r){
			$.post("ajaxDeleteDrugFrom.html",{
				id : value
			},function(date){
				var json = jsonParse(date);
				var success = json.success;
				if(success!=null && success!=""){
					alert(decodeURI(success));
				}
				location.href="drugFroms.html";
			})
		}else{
			return;
		}
	}
    </script>
</body>
</html>