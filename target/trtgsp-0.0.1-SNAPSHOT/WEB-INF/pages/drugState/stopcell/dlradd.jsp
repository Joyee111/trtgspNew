<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title><fmt:message key="添加"/></title>
    <meta />
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</head>
<script type="text/javascript">
0</script>
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;停售管理&nbsp;>&nbsp;停售录入新增</font>
<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span class="ok">1</span>
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
            	<span>5</span>
                <br />审核通过
            </td>
            <td align="right" width="5"><img src="../../images/lch_r.gif" /></td>
          </tr>
        </table>
<div class="box_big">
<form method="post" action="dlrsave.html" id="res">
<input type="hidden" name="id" value="${id}"/>
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" id="quamap" value = "${quamap}" />
<div class="ceng_mar5" style="padding-bottom:5px;">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
	<tr>
	<th width="150">通用名称<span class="required">*</span>：</th>
	<td style="width:400px;">
		<input type="text" class="easyui-combobox  text1" data-options="
			required:true,
     	 	valueField: 'id',
      		textField: 'text',
     		url:'${ctx}/drugState/stopcell/findypboxqy.html',
     		value:'${re.qualifiedMedicineId}',
     		onSelect: function(rec){ 
     			change(rec.id);
     		}
		" name="qualifiedMedicineId" id="caigoudan" size="40"/>&nbsp;&nbsp;
	</td>
	<th width="150">剂型：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="jixing" id="jixing" readonly="readonly" class="text1" size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">规格：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="guige" id="guige" readonly="readonly" class="text1" size="40"/>
	</td>	
	<th width="150">生产厂家：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="shengchanchangjia" readonly="readonly" id="shengchanchangjia" class="text1" size="40"/>
	</td>
	
	</tr>
	<tr>
	<th width="150">检查日期 <span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<c:choose>
					<c:when test="${dateDisableFlag == 'true'}">
						<input type="text" class="easyui-datebox text1" data-options="required:true,value:getCurrentDate()" name="checkDate" id="checkDate"  size="40"/>
					</c:when>
					<c:when test="${dateDisableFlag == 'false'}">
						<input type="text" class="easyui-datebox text1" data-options="required:true,value:getCurrentDate(),disabled:true" name="checkDate" id="checkDate"  size="40"/>
					</c:when>
				</c:choose>
		
	</td>
	<th width="150">存放地点<span class="required">*</span>：</th>
		<td class="left" style="width:350px;">
			<input type="text" name="location" id="location"  data-options="required:true" class="easyui-validatebox text1" readonly="readonly" size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">生产批号<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		 <!--<input id="batchProduction" class="easyui-combobox" size="40" data-options="required:true,valueField:'id',textField:'text',
		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#batchProductionValue').val(str[0]);
      			$('#maxquantity').val(str[1]);
      		}
		" />
		<input type="hidden" name="batchProduction" id="batchProductionValue"/>-->
		<input type="text" name="batchProduction" id="batchProduction"  data-options="required:true" class="easyui-validatebox text1" size="40"/> 
		</td>
	<th width="150">数量<span class="required">*</span>：</th>
	<td class="left" style="width:350px;">
		<input type="text" name="quantity" id="quantity" data-options="required:true" class="easyui-validatebox text1" size="40"/>
		<input type="hidden" name="maxquantity" id="maxquantity"/>
	</td>
	</tr>
	<tr>
	   <!--  <th>库房标识<span class="required">*</span>：</th>
          	<td>
          		<label for="" style="font-size:12px; color:#727171; font-weight:bold;">合格</label>
          		<input type="radio" name="state" value="A">
          		<label for="" style="font-size:12px; color:#727171; font-weight:bold;">不合格</label>
          		<input type="radio" name="state" value="C">
           </td>-->
	</tr>
	<tr>
	<th valign="top">停售原因<span class="required">*</span>：</th>
	 <td colspan="3">
		<textarea type="" name="checkSituation" id="checkSituation" cols="94" rows="4" data-options="required:true" class="easyui-validatebox textarea" ></textarea>
	</td>
	</tr>
	<tr>
	<th>
	<input type="checkbox" id="checkTempStopStatus" onchange="if(this.checked==true){this.value='1'}else{this.value='0'};$('#tempStopStatus').val(this.value);" value="0" />
	</th>
	 <td colspan="3">
	       &nbsp;暂时停售
	</td>
	</tr>
</table>
<table>
	<tr align="center">
		<td colspan="3">
			<input type="button" class="btn_big" name="提交" onclick="submits(1)" value="<fmt:message key="提交"/>"/>
			<input type="button" class="btn_big" name="save" onclick="submits(0)" value="<fmt:message key="button.save"/>"/>
			<input type="button" class="btn_big" name="cancel" onclick="onCancel();" value="<fmt:message key="button.cancel"/>"/>
		</td>
	</tr>
</table>
</div>
<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" id="receItem" name="receItem" value="${receItem}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type="hidden" name="submitType" id="submitType" value="0" />
<input type="hidden" name="tempStopStatus" id="tempStopStatus" value = "0" />
</form>
</div>
<script type="text/javascript">
/*function changequ(obj){
	var a = Number(trim(obj.value));
	var b =Number(trim(document.getElementById("maxquantity").value));
	if(a>b){
		alert("数量大于此批次最大数量！");
		obj.value="";
	}
}*/
    function onCancel()
    {
    	history.go(-1);
    }
   function submits(value){
	    $("#submitType").val(value);
	    if(checkSubmit()){
		    $('#res').form('submit',{
				    success: function(data){  
					var json = jsonParse(data);
						if(json.success!=null && json.success!=""){
							alert(decodeURI( json.success));
						}
					location.href="dlrlist.html";
				    }  
				});  
		}
    }
    
    function change(s){
	    if(s.value!=""){
			$.post("${ctx}/drugState/inspectionRecords/quamap.html",{
			"quamap" : s,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					$("#jixing").val(c[0]);
					$("#guige").val(c[1]);
					$("#shengchanchangjia").val(c[7]);
					$("#location").val(c[12]);
				}else{
					return;
				}
			});
	    }else{
	    	$("#jixing").val("");
			$("#guige").val("");
			$("#shengchanchangjia").val("");
	    }
    
    }
    function getCurrentDate(){
   		var date = new Date();
   		var year = date.getFullYear();
   		var moth = date.getMonth()+1;
   		var day = date.getDate();
   		if(parseInt(moth)< 9){
   			moth = "0"+moth;
   		}
   		if(parseInt(day)< 9){
   			day = "0"+day;
   		}
   		return year+"-"+moth+"-"+day;
   }
   
</script>

