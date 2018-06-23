<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看已审核售出退货</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
<link href="<%=basePath%>js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/easyui/jquery-1.8.0.min.js" ></script>
<script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript"
	src="/zywx3/ext/scripts/user/selectarea.js">
</script>
<script type="text/javascript">
	function back(){
		var form = document.getElementById("check_one");
		form.submit();
	}
	 $(function() {
    	var  returnValue=document.getElementById("returnTypeValue");
     	var  returnType1=document.getElementById("returnType1");
     	var  returnType2=document.getElementById("returnType2");
     	var  returnType3=document.getElementById("returnType3");
     	if(returnValue != null && ""!=returnValue){
     		var a = returnValue.value.split(",");
     		for(var i=0;i<a.length;i++){
     			if(a[i]==returnType1.value){
     				returnType1.checked=true;
     			}
				if(a[i]==returnType2.value){
     				returnType2.checked=true;
     			}
     			if(a[i]==returnType3.value){
     				returnType3.checked=true;
     			}
     		}
     		
     	}
    });
	
	
</script>
</head>
<body>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;售出退货管理&nbsp;>&nbsp;查看已审核售出退货</font>
   <table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span>1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span>2</span>
                <br />已保存
            </td>
            <td valign="top" align="center" width="20%">
            	<span>3</span>
                <br />审核
            </td>
            <td valign="top" align="center" width="20%">
            	<span>4</span>
                <br />已驳回
            </td>
            <td valign="top" align="center" width="20%">
            	<span class="ok">5</span>
                <br />审核通过
            </td>
            <td align="right" width="5"><img src="../../images/lch_r.gif" /></td>
          </tr>
        </table>
	<form action="dshview.html">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
	<tr>
	<th width="150">购货单位：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="customerName" id="customerName" value="${qs.customerName}" readonly="readonly" class="text1" size="40"/>
	</td>
	<th width="150">通用名称：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="jixing" id="jixing" value="${qm.commonname}" readonly="readonly" class="text1" size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">剂型：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="jixing" id="jixing" value="${qm.dosageforms.formName}" readonly="readonly" class="text1" size="40"/>
	</td>
	<th width="150">规格：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="guige" id="guige" value="${qm.specifications}" readonly="readonly" class="text1" size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">数量：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="quantity" value="${mc.quantity}" readonly="readonly" id="quantity" value="" data-options="required:true" class="easyui-validatebox text1" class="text1" size="40"/>
	</td>
	<th width="150">生产批号：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="batchNumber" value="${mc.batchNumber}" readonly="readonly" data-options="required:true" class="easyui-validatebox text1" id="batchNumber" class="text1" size="40"/>
	</td>	
	</tr>
	<tr>
	<th valign="top">退货原因：</th>
	 <td colspan="3">
		<textarea type="" name="returnReason" id="returnReason" readonly="readonly" cols="94" rows="4" class="textarea" >${mc.returnReason}</textarea>
	</td>
	</tr>
	<tr>
	<th width="150">退货类别：</th>
	 <td colspan="3">
		<input type="checkbox" disabled="disabled" name="returnType" id="returnType1" value="1" /><font style="font-size:12px; color:#727171; font-weight:bold;">经营退货</font>
		<input type="checkbox" disabled="disabled" name="returnType" id="returnType2" value="2" /><font style="font-size:12px; color:#727171; font-weight:bold;">质量退货</font>
		<input type="checkbox" disabled="disabled" name="returnType" id="returnType3" value="3" /><font style="font-size:12px; color:#727171; font-weight:bold;">是否需传回退货样品或图片传真、邮件资料</font>
		<input type="hidden" id ="returnTypeValue" name="returnTypeValue" value="${mc.returnType}" />
	</td>
	</tr>
</table>
	</form>
  	<br>
  	<table>
		<tr align="center">
			<td><input type="button" class="btn_big" value="回退" onclick="back()"/></td>
		 	<td><input type="button" class="btn_big" value="返回" onclick="goBack()"/></td>
		</tr>
	</table>
 	<form action="backcheck.html" id="check_one">
 		<input type="hidden" id="id" name="id" value="${mc.id}"/>
 	</form>
</body>
</html>