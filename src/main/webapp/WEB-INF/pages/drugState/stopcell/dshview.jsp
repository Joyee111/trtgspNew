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
<title>查看审核停售</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
<link href="<%=basePath%>js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/easyui/jquery-1.8.0.min.js" ></script>
<script type="text/javascript">
	function pass(){
		$("#types").val(2);
		var form = document.getElementById("check_one");
		if(checkSubmit()){
			form.submit();
		}
	}
	function back(){
		$("#types").val(3);
		var form = document.getElementById("check_one");
		if(checkSubmit()){
			form.submit();
		}
	}
</script>
</head>
	   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;停售管理&nbsp;>&nbsp;查看审核停售</font>
<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span >1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span>2</span>
                <br />已保存
            </td>
            <td valign="top" align="center" width="20%">
            	<span class="ok">3</span>
                <br />审核
            </td>
            <td valign="top" align="center" width="20%">
            	<span>4</span>
                <br />已驳回
            </td>
            <td valign="top" align="center" width="20%">
            	<span>5</span>
                <br />审核通过
            </td>
            <td align="right" width="5"><img src="../../images/lch_r.gif" /></td>
          </tr>
        </table>
<body>
	<form action="dshview.html">
	<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
	<tr>
	<th width="150">通用名称：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="jixing" id="jixing" value="${qm.commonname}" readonly="readonly" class="text1" size="40"/>
	</td>
	<th width="150">剂型：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="jixing" id="jixing" value="${qm.dosageforms.formName}" readonly="readonly" class="text1" size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">规格：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="guige" id="guige" value="${qm.specifications}" readonly="readonly" class="text1" size="40"/>
	</td>	
	<th width="150">检查日期 ：</th>
	<td class="left" style="width:350px;">
		<input type="text" class="easyui-datebox text1" value="${mc.checkDate}" data-options="disabled:true" readonly="readonly" name="checkDate" id="checkDate"  size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">存放地点：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="location" id="location" value="${mc.location}" readonly="readonly" class="text1" size="40"/>
	</td>
	<th width="150">生产厂家：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="shengchanchangjia" id="shengchanchangjia" readonly="readonly" value="${qm.produceno.customerName}" class="text1" size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">生产批号：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="batchProduction" readonly="readonly" value="${mc.batchProduction}" id="batchProduction" class="text1" size="40"/>
	</td>
	<th width="150">数量：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="quantity" readonly="readonly" value="${mc.quantity}" id="quantity" class="text1" size="40"/>
	</td>
	</tr>
	<tr>
	   <!--  <th>库房标识<span class="required">*</span>：</th>
          	<td>
          		    <c:choose>
          		         <c:when test="${mc.state eq 'A'}">
          		              	<label for="" style="font-size:12px; color:#727171; font-weight:bold;">合格</label>
          		                   <input type="radio" name="state" value="A" checked disabled/>
          		                   <label for="" style="font-size:12px; color:#727171; font-weight:bold;">不合格</label>
          		                   <input type="radio" name="state" value="C" disabled/>
          		         </c:when>
          		         <c:when test="${mc.state eq 'C'}">
          		              	   <label for="" style="font-size:12px; color:#727171; font-weight:bold;">合格</label>
          		                   <input type="radio" name="state" value="A" disabled/>
          		                   <label for="" style="font-size:12px; color:#727171; font-weight:bold;">不合格</label>
          		                   <input type="radio" name="state" value="C" checked disabled/>
          		         </c:when>
          		         <c:otherwise>
          		                   <label for="" style="font-size:12px; color:#727171; font-weight:bold;">合格</label>
          		                   <input type="radio" name="state" value="A" disabled/>
          		                   <label for="" style="font-size:12px; color:#727171; font-weight:bold;">不合格</label>
          		                   <input type="radio" name="state" value="C" disabled/>
          		         
          		         </c:otherwise>
          		    </c:choose>
          	         	
           </td> -->
	</tr>
	<tr>
	<th valign="top">停售原因：</th>
	 <td colspan="3">
		<textarea type="" readonly="readonly" name="checkSituation" id="checkSituation" cols="94" rows="4" class="textarea" >${mc.checkSituation}</textarea>
	</td>
	</tr>
	
	<tr>
		<th>
			<input type="checkbox" disabled="disabled" id="checkTempStopStatus" onchange="if(this.checked==true){this.value='0'}else{this.value='1'};$('#tempStopStatus').val(this.value);" value="${mc.tempStopStatus}" />
		</th>
		 <td colspan="3">
	       &nbsp;暂时停售
		</td>
	</tr>
	
	
</table>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type="hidden" name="thispage" value="${thispage}"/>
<input type="hidden" name="id" value="${ms.id}"/>
	</form>
  	<br>
  	<table>
		<tr align="center">
		  	<td><input type="button" class="btn_big" value="通过" onclick="pass()"/></td>
		  	<td><input type="button" class="btn_big" value="驳回" onclick="back()"/></td>
		 	<td><input type="button" class="btn_big" value="返回" onclick="goBack()"/></td>
		</tr>
	</table>
 	<form action="shviewcheck.html" id="check_one">
 		<input type="hidden" id="id" name="id" value="${mc.id}"/>
 		<input type="hidden" id="types" name="types" value=""/>
 	</form>
 	<script type="text/javascript">
	 	<c:choose>
			<c:when test="${mc.tempStopStatus == 1}">
			$("#checkTempStopStatus").attr("checked",'true')
			</c:when>
		</c:choose>
	</script>
</body>
</html>