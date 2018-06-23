<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看复检退货验收</title>
<script type="text/javascript"
	src="<c:url value='/ext/scripts/index/index.js'/>"></script>
<link href="<%=basePath%>js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
</head>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;退货验收管理&nbsp;>&nbsp;查看复检</font>
<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span >1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span >2</span>
                <br />已保存
            </td>
            <td valign="top" align="center" width="20%">
            	<span>3</span>
                <br />已验收1
            </td>
            <td valign="top" align="center" width="20%">
            	<span  class="ok">4</span>
                <br />已验收
            </td>
            <td valign="top" align="center" width="20%">
            	<span>5</span>
                <br />已复检
            </td>
            <td align="right" width="5"><img src="../../images/lch_r.gif" /></td>
          </tr>
        </table>
<body>
<form action="recheck.html" id="recheck_from_one" method="post">
	<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
		<tr>
		<th width="150">退货单号：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="returnNo" id="returnNo" data-options="disabled:true" readonly="readonly" value="${mc.returnNo}" class="text1" size="40"/>
		</td>
		<th width="150">退货单位：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="text1" readonly="readonly" data-options="disabled:true" name="arrivalDate" id="arrivalDate" value="${qu.customerName}" class="text1" size="40"/>
		</td>
		</tr>
		<tr>
		<th width="150">报告单号：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="reportNo" id="reportNo" data-options="disabled:true" readonly="readonly" value="${mc.reportNo}" class="text1" size="40"/>
		</td>
		<th width="150">退货日期：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-datebox" data-options="disabled:true,disabled:true" id="arrivalDate" value="${mc.arrivalDate}" class="text1"/>
		</td>
		</tr>
		<tr>
		<th width="150">验收日期：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-datebox" data-options="disabled:true" value="${mc.checkAcceptDate}"/>
		</td>
		<th width="150">验收日期2：</th>
		<td class="left" style="width:350px;">
			<input type="text" class="easyui-datebox" data-options="disabled:true" value="${mc.checkAcceptDate2}"/>
		</td>
	</tr>
	<tr>
	   <th width="150">收货员：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="goodsClerk" readonly="readonly" id="goodsClerk" value="${mc.goodsClerk}" class="text1" size="40"/>
		</td>
	   <th width="150">存储库区：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="storageStore" readonly="readonly" id="storageStore" value="${storageStore}" class="text1" size="40"/>
		</td>
	</tr>
	<tr>
	<th valign="top">验收结果：</th>
	 <td colspan="3">
		<textarea type="" name="result" readonly="readonly" id="result" cols="94" rows="4" class="textarea" >${mc.result}</textarea>
	</td>
	</tr>
	<tr>
	<th valign="top">验收结果2：</th>
	 <td colspan="3">
		<textarea type="" name="result2" readonly="readonly" id="result2" cols="94" rows="4" class="textarea" >${mc.result2}</textarea>
	</td>
	</tr>
	<tr>
	<th valign="top">退回原因：</th>
	 <td colspan="3">
		<textarea type="" name="checkConclusion" readonly="readonly" id="checkConclusion"  cols="94" rows="4" class="textarea" >${mc.checkConclusion}</textarea>
	</td>
	</tr>
	<tr>
	<th valign="top">复查结论：</th>
	 <td colspan="3">
		<textarea type="" name="visualExamination"  id="visualExamination" cols="94" rows="4" class="textarea" >${mc.visualExamination}</textarea>
		<input type="hidden" id="id" name="id" value="${mc.id}" />
		<input type="hidden" name="count" value="${count }">
		<input type = "hidden" name="modify_reson" id="modify_reson">
		<input type = "hidden" name="submitType" id="submitType">
		<input type = "hidden" name="roll_back_reason" id="roll_back_reason">
	</td>
	</tr>
	
	<!-- <tr>
		<th>
			<input type="checkbox" id="checkUnqmr" onchange="if(this.checked==true){this.value='1'}else{this.value='0'};$('#outUnqmr').val(this.value);" value="0" />
		 	<input type="hidden" id="outUnqmr" name="outUnqmr" value="" />
		</th>
		<td colspan="3">
		       &nbsp;入不合格品库
		</td>
	</tr> -->
	
	
</table>
<div style="width:1206px;height:85px;overflow-x: auto;">
<table id="condition_table" class="table_yh"  border="0" cellpadding="0" cellspacing="1" width="100%" align="center">
	<thead class='pn-lthead'>
	 <tr>
	 	<th style="width: 80px;">通用名称</th><th>剂型</th><th>规格</th> <th>数量</th><th>合格数量</th><th>不合格数量</th><th>退回供应商</th><th>生产批号</th><th>批准文号</th><th>生产企业</th><th>有效期至</th><th>生产日期</th>
	  </tr>
	  </thead>
	  <c:forEach items="${chIt}" var="item" varStatus="index">
	  	<tbody class="pn-ltbody">
	  		<tr>
	  		
	  			<td style="width: 80px;"><input type="text" name="pingming${index.index }" value="${item.qualityMidicine.commonname }" readonly="readonly" class="text1" size="12" style="border: none;"/></td>
	  			<td style="width: 80px;"><input type="text" name="jixing${index.index }" value="${item.qualityMidicine.dosageforms.formName }" readonly="readonly" class="text1"  size="10" style="border: none;"/></td>
	  			<td style="width: 80px;"><input type="text" name="guige${index.index }" value="${item.qualityMidicine.specifications }" readonly="readonly" class="text1"  size="10" style="border: none;"/></td>
	  			<td style="width: 80px;"><input type="text" name="shuliang${index.index }" id="shuliang${index.index }" value="${item.quantity}" class="text1"  size="8" style="border: none;" readonly="readonly"/></td>
	  			<td style="width: 80px;"><input type="text" name="hegeshuliang${index.index }" id="hegeshuliang${index.index }" value="${item.quantity}"  class="text1"  size="8" style="border: none;" onchange="computeQuanlity('shuliang${index.index }','hegeshuliang${index.index }','buhegeshuliang${index.index }','tuihuishuliang${index.index }','hege')"/></td> 
	  			
	  			<td style="width: 80px;"><input type="text" name="buhegeshuliang${index.index }" id ="buhegeshuliang${index.index }" value="0" class="text1"  size="8" style="border: none;" onchange="computeQuanlity('shuliang${index.index }','hegeshuliang${index.index }','buhegeshuliang${index.index }','tuihuishuliang${index.index }','buhege')"/></td>
              	<c:choose>
	  			    <c:when test="${item.invalidQuantity==0}">
	  			    <td style="width: 75px;"><input type="text" name="tuihuishuliang${index.index }" id ="tuihuishuliang${index.index }" value="" class="text1"  size="8" style="border: none;" /></td>
	  			    </c:when>
	  			    <c:otherwise>
	  			        <td style="width: 75px;"><input type="text" name="tuihuishuliang${index.index }" id ="tuihuishuliang${index.index }" value="" class="text1"  size="8" style="border: none;"/></td>
	  			    </c:otherwise>
	  			</c:choose>
	  			<td style="width: 80px;"><input type="text" name="pihao${index.index }" value="${item.batchProduction}" class="text1"  size="15" style="border: none;" readonly="readonly"/></td>
	  			<td style="width: 80px;"><input type="text" name="pizhunwenhao${index.index }" value="${item.qualityMidicine.licensenumber}" readonly="readonly" class="text1"  size="15" style="border: none;"/></td>
	  			<td style="width: 80px;"><input type="text" name="shengchanqiye${index.index }" value="${item.qualityMidicine.produceno.customerName}" readonly="readonly" class="text1"  size="35" style="border: none;"/></td>
	  			<td style="width: 80px;">
	  			<input type="text" name="youxiaoqizhi${index.index }" value="${item.validateDate}" readonly="readonly" class="text1"  size="10" style="border: none;"/>
	  			<input type="hidden" name="medicId${index.index }" value="${item.qualityMidicine.id}" />
	  			<input type="hidden" name="itemId${index.index }" value="${item.id}" />
	  			
	  			</td>
	  			<td>
	  			<input type="text" name="shengchanriqi${index.index }" value="${item.productionDate}" readonly="readonly" class="text1"  size="10" style="border: none;"/>
	  			</td>
	  			
	  		</tr>
	  	</tbody>
	  </c:forEach>
	
</table>
</div>
	</form>
	<br/>
	 <input type="hidden" value=""/>
  	<table>
		<tr align="center">
		
<%-- 		  <shiro:hasPermission name="ReturnCheckAccept_apply_rollback">
		 	<td><input type="button" class="btn_big" value="申请回退" onclick="$('#dialog_roll_back').dialog('open')" /></td>
	 		</shiro:hasPermission> --%>
		
		
		  	<td>
		  	<c:choose>
				<c:when test="${mc.rejectFlag != null && mc.rejectFlag eq '1'}">
					<input type="button" class="btn_big" name="提交" onclick="$('#dialog').dialog('open')" value="<fmt:message key="提交"/>"/>
				</c:when>
				<c:otherwise>
					<input type="button" class="btn_big" value="确认" onclick="recheckFrom()"/>
				</c:otherwise>
			</c:choose>
		  	</td>
		 	<td><input type="button" class="btn_big" value="返回" onclick="goBack()"/></td>
		</tr>
	</table>
	     <div id="dialog" title="修改原因" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:200">
    	<table>
    	<tr>
            <th valign="top">修改原因：</th>
            <td colspan="3"><textarea name="rejectcause" id="rejectcause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
           	<input type="button" class="btn_big" onclick="recheckFrom()" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
        </div>
        
        <div id="dialog_roll_back" title="回退原因" class="easyui-dialog" style="width:800px;height:200px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:200">
    	<table>
    	<tr>
            <th valign="top">回退原因：</th>
            <td colspan="3"><textarea name="rejectcause" id="roll_back_cause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
           	<input type="button" class="btn_big" onclick="rollBack(2)" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog_roll_back').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
    </div> 
	
 	<script type="text/javascript">	
 		function recheckFrom(){
 			var  dialog = $("#dialog").dialog();
			var value =  dialog.get(0).getElementsByTagName("textarea")[0].value;
			$("#modify_reson").val(value);
			var shuliang=$("#shuliang0").val();
			var hgNo=$("#hegeshuliang0").val();
			var bgNo=$("#buhegeshuliang0").val();
			var thNo=$("#tuihuishuliang0").val();
			var amount=parseFloat(hgNo)+parseFloat(bgNo)+parseFloat(thNo);
			if(parseFloat(hgNo)>parseFloat(shuliang)){
			   alert("合格数量不能大于总数量");
			   return;
			}
		    if(parseFloat(bgNo)>parseFloat(shuliang)){
			   alert("不合格数量不能大于总数量");
			   return;
			}
			if(parseFloat(thNo)>parseFloat(shuliang)){
			   alert("退回供应商数量不能大于总数量");
			   return;
			}
			if(amount!=parseFloat(shuliang)){
			     alert("合格数量、不合格数量、退回供应商数量之和必须等于数量！"); 
                return;
			}

			if(checkSubmit()){
				$('#recheck_from_one').form('submit',{  
					success: function(data){  
					var json = jsonParse(data);
					if(typeof(json.success)!=undefined  && json.success!=""){
						alert(decodeURI( json.success));
					}
					window.location.href="rechecklist.html"
				    }  
				});  
			} 
 		}
 		
 	
 		function computeQuanlity(totalStr,quStr,unQuStr,thStr,type){
 			var totalQuanlity = $("#"+totalStr).val();			
 			if(type=='hege'){
 				if(isNaN($("#"+quStr).val())){
 				    $("#"+quStr).val("0");
 				}
 				if(parseFloat($("#"+quStr).val())< 0){
 					 $("#"+quStr).val("0");
 				}
 				/*if(parseFloat($("#"+quStr).val())>totalQuanlity){
 					alert("合格数量不能大于总数量！");
 					$("#"+quStr).focus();
 				}
 				if(parseFloat($("#"+quStr).val())< 0){
 					alert("合格数量不能小于0！");
 					$("#"+quStr).focus();
 				}*/
 				//var un = parseFloat(totalQuanlity)-parseFloat($("#"+quStr).val());
 				//$("#"+unQuStr).val(parseFloat(un));
 			}else if(type=='buhege'){
 		        if(isNaN($("#"+unQuStr).val())){
 				    $("#"+unQuStr).val("0");
 				}
                if(parseFloat($("#"+unQuStr).val())< 0){
 					$("#"+unQuStr).val("0");
 				}
 		        /*if(parseFloat($("#"+unQuStr).val())>totalQuanlity){
 					alert("不合格数量不能大于总数量！");
 					$("#"+unQuStr).focus();
 				 
 				}
 				if(parseFloat($("#"+unQuStr).val())< 0){
 					alert("不合格数量不能小于0！");
 				
 					$("#"+unQuStr).focus();
 				}*/
 				//var th = parseFloat(totalQuanlity)-parseFloat($("#"+unQuStr).val())-parseFloat($("#"+quStr).val());
 				//$("#"+thStr).val(parseFloat(th));
 			}else{
 			    if(isNaN($("#"+thStr).val())){
 				    $("#"+thStr).val("0");
 				}
 			    if(parseFloat($("#"+thStr).val())< 0){
 					 $("#"+thStr).val("0");
 				}
 			    
 			    /*if(parseFloat($("#"+thStr).val())>totalQuanlity){
 					alert("退回供应商数量不能大于总数量！");
 					
 					$("#"+unQuStr).focus();
 				}
 				if(parseFloat($("#"+thStr).val())< 0){
 					alert("退回供应商数量不能小于0！");
 					$("#"+unQuStr).focus();
 				}*/ 	
 			}
 			
 			/*var amount=parseFloat($("#"+quStr).val())+parseFloat($("#"+unQuStr).val())+parseFloat($("#"+thStr).val());
 			
 			
 			if(amount!=totalQuanlity){
 			   flag=false;
 			   alert("合格数量、不合格数量、退回供应商之和必须等于数量！"); 
 			}else{
 			   flag=true;
 			}*/

 		}
 		
 			//申请回退
	  	function rollBack(value){
		    $("#submitType").val(value);
		    var  dialog = $("#dialog_roll_back").dialog();
			var value =  dialog.get(0).getElementsByTagName("textarea")[0].value;
			if(value == undefined || trim(value) == ""){
				alert("请输入原因");
				return;
			}
			$("#roll_back_reason").val(value);
			if(checkSubmit()){
		    $('#recheck_from_one').form('submit',{
				    success: function(data){  
					var json = jsonParse(data);
						if(json.success!=null && json.success!=""){
							alert(decodeURI( json.success));
						}
					location.href="rechecklist.html";
				    }  
				});  
				}
	    }
 		
 	</script>
</body>
</html>