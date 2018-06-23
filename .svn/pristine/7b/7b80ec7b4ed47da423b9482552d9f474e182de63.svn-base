<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%><head>
    <title><fmt:message key="不良反应"/></title>
    <meta />
    
</head>
<form commandName="ar" method="post" action="dlrupdate.html" id="res">
<input type="hidden" name="id" value="${ar.id}" />
<input type="hidden" name="thispage" value="${thispage}" />
<input type="hidden" id="receItem" value = "${receItem}" />
<input type="hidden" id="useItem" value = "${useItem}" />
<input type="hidden" id="quamap" value = "${quamap}" />
<input type="hidden" id="quamaps" value = "${quamaps}" />
<div class="ceng_mar5" style="padding-bottom:5px;">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
   <font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">质量记录管理&nbsp;>&nbsp;不良反应&nbsp;>&nbsp;不良反应修改</font>
		<tr>
	<th width="150">不良反应名称<span class="required">*</span>：</th>
	<td>
		
		<input type="text"  name="name" id="name" value="${ar.name}"  class="easyui-validatebox text1" data-options="required:true" size="40"/>
	</td>
	<th width="150">发生时间<span class="required">*</span>：</th>
	<td>
	<input type="text"  name="occurrenceDate" id="occurrenceDate" value="${ar.occurrenceDate}"  class="easyui-datebox text1" data-options="required:true"  size="40"/>

	</td>
	</tr>
	<tr>
	<th width="150">病历号/医院名称<span class="required">*</span>：</th>
	<td>
		<input type="text" name="medicalRecordNo" id="medicalRecordNo"  value="${ar.medicalRecordNo}" class="easyui-validatebox text1" data-options="required:true" size="40"/>
	</td>
	<th width="150">不良反应类型<span class="required">*</span>：</th>
	<td>
		<select style="width:260px" data-options="required:true" class="easyui-validatebox text1" name="type" id="type" class="easyui-validatebox text1" data-options="required:true">
		 <option value="">--请选择--</option>
			<option value="0">新的</option>
			<option value="1">严重</option>
			<option value="2">一般</option>
		</select>
			<input type="hidden" id="typeValue" value="${ar.type}" class="text1" size="40"/>
	</td>
	</tr>
<tr>
	<th width="150">上报者类型<span class="required">*</span>：</th>
	<td>
		<select  style="width:260px" data-options="required:true" class="easyui-validatebox text1" name="reportType" id="reportType" class="easyui-validatebox text1" data-options="required:true">
		 <option value="">--请选择--</option>
			<option value="0">个人</option>
			<option value="1">医疗卫生机构</option>
			<option value="2">生产企业经营企业</option>
		</select>
		<input type="hidden" id="reportTypeValue" value="${ar.reportType}" class="text1" size="40"/>
	</td>
	<th width="150">单位名称<span class="required">*</span>：</th>
	<td>
		<input type="text" name="unitName" id="unitName" value="${ar.unitName}" class="text1" size="40"/>
	</td>
	
	</tr>
	<tr>
	<th width="150">部门<span class="required">*</span>：</th>
	<td>
		<input type="text" name="departmentName" id="departmentName" value="${ar.departmentName}" class="text1" size="40"/>
	</td>
	<th width="150"><fmt:message key="电话"/></th>
	<td>
		<input type="text" name="phone" id="phone" value="${ar.phone}" class="text1" size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">报告日期<span class="required">*</span>：</th>
	<td>
		<input type="text" name="reportDate" id="reportDate" value="${ar.reportDate}" class="easyui-datebox text1" data-options="required:true"  size="40"/>
	</td>
	<th width="150">患者名称<span class="required">*</span>：</th>
	<td>
		<input type="text" name="patientName" id="patientName" value="${ar.patientName}" class="easyui-validatebox text1" data-options="required:true" size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">性别<span class="required">*</span>：</th>
		<td>
		<select style="width:260px" data-options="required:true" class="easyui-validatebox text1" name="gender" id="gender" class="easyui-validatebox text1" data-options="required:true">
		 <option value="">--请选择--</option>
			<option value="0">男</option>
			<option value="1">女</option>
	
		</select>
		<input type="hidden" id="genderValue" value="${ar.gender}" class="text1" size="40"/>
	</td>
	<th width="150">出生日期<span class="required">*</span>：</th>
	<td>
		<input type="text" name="birthdate" id="birthdate" value="${ar.birthdate}" class="easyui-datebox text1" data-options="required:true"  size="40"/>
	</td>
	</tr>
<tr>
	<th width="150">民族<span class="required">*</span>：</th>
	<td>
		<input type="text" name="nation" id="nation" value="${ar.nation}" class="easyui-validatebox text1" data-options="required:true" size="40"/>
	</td>
	<th width="150">体重<span class="required">*</span>：</th>
	<td>
		<input type="text" name="weight" id="weight" value="${ar.weight}" class="easyui-validatebox text1" data-options="required:true" size="40"/>
	</td>
	</tr>
	
	
	
		<tr>
	<th width="150">既往不良反应<span class="required">*</span>：</th>
		<td>
		<select  style="width:260px" data-options="required:true" class="easyui-validatebox text1" name="sinceAdverseReaction" id="sinceAdverseReaction"class="easyui-validatebox text1" data-options="required:true">
		 <option value="">--请选择--</option>
			<option value="0">有</option>
			<option value="1">无</option>
			<option value="2">不详</option>
		</select>
		<input type="hidden" id="sinceAdverseReactionValue" value="${ar.sinceAdverseReaction}" class="text1" size="40"/>
	</td>
	<th width="150">不良反应结果<span class="required">*</span>：</th>
		<td>
		<select style="width:260px" data-options="required:true" class="easyui-validatebox text1" name="adverseReactionResult" id="adverseReactionResult"class="easyui-validatebox text1" data-options="required:true">
		 <option value="">--请选择--</option>
			<option value="0">治愈</option>
			<option value="1">好转</option>
			<option value="2">后遗症</option>
			<option value="3">死亡</option>
		</select>
			<input type="hidden" id="adverseReactionResultValue" value="${ar.adverseReactionResult}" class="text1" size="40"/>
	</td>
	</tr>
		<tr>
	<th width="150">原疾病<span class="required">*</span>：</th>
	<td>
		<input type="text" name="originalDisease" id="originalDisease" value="${ar.originalDisease}" class="easyui-validatebox text1" data-options="required:true" size="40"/>
	</td>
	
	<th width="150">对原疾病影响<span class="required">*</span>：</th>
		<td>
		<select style="width:260px" data-options="required:true" class="easyui-validatebox text1" name="influence" id="influence" class="easyui-validatebox text1" data-options="required:true">
		 <option value="">--请选择--</option>
			<option value="0">不明显</option>
			<option value="1">病程延长</option>
				<option value="2">病情加重</option>
			<option value="3">后遗症</option>
				<option value="4">死亡</option>	
		</select>
		<input type="hidden" id="influenceValue" value="${ar.influence}" class="text1" size="40"/>
	</td>
	</tr>
	<tr>
	<th width="150">国内类似<span class="required">*</span>：</th>
		<td>
		<select style="width:260px" data-options="required:true" class="easyui-validatebox text1" name="similarDomestic" id="similarDomestic" class="easyui-validatebox text1" data-options="required:true">
		 <option value="">--请选择--</option>
			<option value="0">有</option>
			<option value="1">无</option>
			<option value="2">不详</option>
		</select>
			<input type="hidden" id="similarDomesticValue" value="${ar.similarDomestic}" class="text1" size="40"/>
	</td>
	<th width="150">国外类似<span class="required">*</span>：</th>
		<td>
		<select style="width:260px" data-options="required:true" class="easyui-validatebox text1" name="foreignSimilar" id="foreignSimilar" class="easyui-validatebox text1" data-options="required:true">
		 <option value="">--请选择--</option>
			<option value="0">有</option>
			<option value="1">无</option>
			<option value="2">不详</option>
		</select>
		<input type="hidden" id="foreignSimilarValue" value="${ar.foreignSimilar}" class="text1" size="40"/>
	</td>
	</tr>
		<tr>
	
	<th width="150">家庭不良反应<span class="required">*</span>：</th>
		<td>
		<select  style="width:260px" data-options="required:true" class="easyui-validatebox text1" name="familyAdverseReaction" id="familyAdverseReaction" class="easyui-validatebox text1" data-options="required:true">
		 <option value="">--请选择--</option>
			<option value="0">有</option>
			<option value="1">无</option>
			<option value="2">不详</option>
		</select>
		<input type="hidden" id="familyAdverseReactionValue" value="${ar.familyAdverseReaction}" class="text1" size="40"/>
	</td>
	</tr>
	<tr>
            <th valign="top">过程描述：</th>
            <td colspan="3"><textarea name="procedureDescription" id="procedureDescription" cols="94" rows="4" class="textarea">${ar.procedureDescription}</textarea></td>
      </tr>
</table>
<table id="condition_table" class="table"   border="0" cellpadding="0" cellspacing="1" width="100%" align="center">
	<thead class='pn-lthead'>
	 <tr>
	 	<th>商品名称</th><th>通用名称</th><th>批号</th> <th>用法用量</th>	 <th>用药开始时间</th>	 <th>用药原因</th><th> 备注</th>
	 
	  </tr>
	 </thead>
</table>
<table>
	<tr align="center">
		<td colspan="4">
			<input type="button" class="btn_big" name="cancel" onclick="addyp();" value="<fmt:message key="新增怀疑药品"/>"/>

		</td>
	</tr>
</table>
<table id="condition_tables" class="table"   border="0" cellpadding="0" cellspacing="1" width="100%" align="center">
	<thead class='pn-lthead'>
	 <tr>
	 	<th>商品名称</th><th>通用名称</th><th>批号</th> <th>用法用量</th>	 <th>用药开始时间</th>	 <th>用药原因</th><th> 备注</th>
	 
	  </tr>
	 </thead>
</table>
<table>
	<tr align="center">
		<td colspan="4">
			<input type="button" class="btn_big" name="cancel" onclick="addbyyp();" value="<fmt:message key="新增并用药品"/>"/>
			<input type="button"  class="btn_big" name="save" onclick="save2()"  value="<fmt:message key="button.save"/>"/>
			<input type="button" class="btn_big" name="cancel" onclick="onCancel()" value="<fmt:message key="button.cancel"/>"/>
		</td>
	</tr>
</table>
</div>
<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" id="receItem" name="receItem" value="${receItem}"/>
<input type="hidden" id="useItem" name="useItem" value="${useItem}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
<input type="hidden" name="counts" id="counts" value=""/>
<input type="hidden" name="countss" id="countss" value=""/>
<input type="hidden" id="submitType" name="submitType" value="0" />
</form>

<script type="text/javascript">
var i=0;
var n=0;
        function onCancel()
    {
    	history.go(-1);
    }
   function submits(){
    	var form = document.getElementById("res");
    	document.getElementById("submitType").value="1";
    	form.submit();
    }
    $(function() {
	  	var quamap=$("#quamap").val();
	   	 var aa = quamap.substring(1,quamap.length-1);
	   	 var f = aa.split(",");
	   	 var g ="";
	   	 for(var j=0;j<f.length;j++){
    	 	var e = f[j].split("=");
    	 	g+="<option value=\""+e[0]+"\">"+e[1]+"</option>"; 
    	 }
    	 	var quamaps=$("#quamaps").val();
	   	 var bb = quamaps.substring(1,quamap.length-1);
	   	 var h = bb.split(",");
	   	 var r ="";
	   	 for(var e=0;j<h.length;e++){
    	 	var t = h[e].split("=");
    	 	r+="<option value=\""+t[0]+"\">"+t[1]+"</option>"; 
    	 }
    	 
    	var a =$("#method");
    	if(a!="add"){
    	var tt = document.getElementById("type");   
    	var jj = document.getElementById("typeValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
		 }
		 var tt = document.getElementById("reportType");   
    	var jj = document.getElementById("reportTypeValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
		 }
		  var tt = document.getElementById("gender");   
    	var jj = document.getElementById("genderValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
		 }
		  var tt = document.getElementById("familyAdverseReaction");   
    	var jj = document.getElementById("familyAdverseReactionValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
		 }
		  var tt = document.getElementById("sinceAdverseReaction");   
    	var jj = document.getElementById("sinceAdverseReactionValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
		 }
		   var tt = document.getElementById("adverseReactionResult");   
    	var jj = document.getElementById("adverseReactionResultValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
		 }
		   var tt = document.getElementById("influence");   
    	var jj = document.getElementById("influenceValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
		 }
		 	   var tt = document.getElementById("similarDomestic");   
    	var jj = document.getElementById("similarDomesticValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
		 }
		 	 	   var tt = document.getElementById("foreignSimilar");   
    	var jj = document.getElementById("foreignSimilarValue").value; 
        for(var ll=0;ll<tt.length;ll++){
          if(jj==tt.options[ll].value){
              tt.options[ll].selected=true;
		      }  
		 }
	    	var b=$("#receItem").val();
	    	var json=eval("("+b+")");
	    	i=json.length;
			for(var s=0; s<json.length; s++)  {
			 	var j = JSON.parse(json[s]);
			        var pinming = "pinming"+s;
		        	var tongyongming = "tongyongming"+s;
    				var pihao = "pihao"+s;
    	           var yongfayongliang = "yongfayongliang"+s;
    	           var yongyaoshijian = "yongyaoshijian"+s;
    	          var yongyaoyuanyin = "yongyaoyuanyin"+s;
    	          var beizhu = "beizhu"+s;
			    	var tbody="tbody"+s;
			        $("#condition_table").append(" <tbody id=\""+tbody+"\"  class='pn-ltbody'>  " +
			    	"<td> " +
					"<input id=\""+pinming+"\"  name=\""+pinming+"\" >" +
					"</td> " +
					"<td> " +
						" <input type=\"text\" style=\"width:50px;\" value=\""+j.tongyongming+"\" name=\""+tongyongming+"\" id=\""+tongyongming+"\" /> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.pihao+"\" name=\""+pihao+"\" id=\""+pihao+"\" /> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:40px;\" value=\""+j.yongfayongliang+"\"  name=\""+yongfayongliang+"\" id=\""+yongfayongliang+"\" /> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:40px;\" value=\""+j.yongyaoshijian+"\"  name=\""+yongyaoshijian+"\" id=\""+yongyaoshijian+"\" /> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.yongyaoyuanyin+"\" name=\""+yongyaoyuanyin+"\" id=\""+yongyaoyuanyin+"\" /> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.beizhu+"\" name=\""+beizhu+"\" id=\""+beizhu+"\" /> "+
					"</td> " +	
					
					"<td> " +
						"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchu("+s+")\" value=\"删除\"/>"+
					"</td> " +	
			    	"</tbody>"
			    	);
			    	$("#counts").val(i);
			        $("#"+pinming).combobox({
					url:"${ctx}/drugState/inspectionRecords/findypboxqy.html",
					valueField:'id', 
					textField:'text',
					value:j.pinming,
					onSelect: function(rec){
			     			changqm(pinming,rec.id);
			     		}
					}); 
			}
				var c=$("#useItem").val();
				
	    	var jsons=eval("("+c+")");
	    	n=jsons.length;
			for(var s=0; s<jsons.length; s++)  {
			 	var j = JSON.parse(jsons[s]);
			        var pm = "pm"+s;
		        	var tym = "tym"+s;
    				var ph = "ph"+s;
    	           var yfyl = "yfyl"+s;
    	           var yysj = "yysj"+s;
    	          var yyyy = "yyyy"+s;
    	          var bz = "bz"+s;
			    	var tbodys="tbodys"+s;
			        $("#condition_tables").append(" <tbody id=\""+tbodys+"\"  class='pn-ltbody'>  " +
			    	"<td> " +
					"<input id=\""+pm+"\"  name=\""+pm+"\" >" +
					"</td> " +
					"<td> " +
						" <input type=\"text\" style=\"width:50px;\" value=\""+j.tym+"\" name=\""+tym+"\" id=\""+tym+"\" /> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.ph+"\" name=\""+ph+"\" id=\""+ph+"\" /> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:40px;\" value=\""+j.yfyl+"\"  name=\""+yfyl+"\" id=\""+yfyl+"\" /> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:40px;\" value=\""+j.yysj+"\"  name=\""+yysj+"\" id=\""+yysj+"\" /> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.yyyy+"\" name=\""+yyyy+"\" id=\""+yyyy+"\" /> "+
					"</td> " +	
					"<td> " +
						" <input type=\"text\" style=\"width:100px;\" value=\""+j.bz+"\" name=\""+bz+"\" id=\""+bz+"\" /> "+
					"</td> " +	
					
					"<td> " +
						"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchus("+s+")\" value=\"删除\"/>"+
					"</td> " +	
			    	"</tbody>"
			    	);
			    	$("#countss").val(i);
			        $("#"+pm).combobox({
					url:"${ctx}/drugState/inspectionRecords/findypboxqy.html",
					valueField:'id', 
					textField:'text',
					value:j.pm,
					onSelect: function(rec){
			     			changqm(pm,rec.id);
			     		}
					});  
		        
			}   
			}
	     
});
    function changqm(s,aaaaa){
		var a = s.substring(7,s.length);
	    var	quamap=aaaaa;
	    var pinming = "pinming"+a;
		var tongyongming = "tongyongming"+a;
    	var pihao = "pihao"+a;
    	var yongfayongliang = "yongfayongliang"+a;
    	var yongyaoshijian ="yongyaoshijian"+a;
    	var yongyaoyuanyin = "yongyaoyuanyin"+a;
    	var beizhu = "beizhu"+a;
	    if(quamap!=""){
			$.post("${ctx}/qualityRecords/adverseReactionInfo/quamap.html",{
			"quamap" : quamap,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					
					$("#tongyongming"+a).val(c[0]);
				}else{
					return;
				}
			});
	    }else{
			$("#tongyongming"+a).val("");
			$("#pihao"+a).val("");
			$("#yongfayongliang"+a).val("");
			$("#yongyaoshijian"+a).val("");
			$("#yongyaoyuanyin"+a).val("");
			$("#beizhu"+a).val("");
	    }
    
    }
    function addyp(){
    	 var quamap=$("#quamap").val();
    	 var c = quamap.substring(1,quamap.length-1);
    	 var b = c.split(",");
    	 var d ="";
    	 var pinming = "pinming"+i;
    	 var tongyongming = "tongyongming"+i;
    	 var pihao = "pihao"+i;
    	 var yongfayongliang = "yongfayongliang"+i;
    	 var yongyaoshijian = "yongyaoshijian"+i;
    	 var yongyaoyuanyin = "yongyaoyuanyin"+i;
    	 var beizhu = "beizhu"+i;
    	 var tbody="tbody"+i;
    	 for(var j=0;j<b.length;j++){
    	 	var e = b[j].split("=");
    	 	d+="<option value=\""+e[0]+"\">"+e[1]+"</option>"; 
    	 }
    	$("#condition_table").append(" <tbody id=\""+tbody+"\" class='pn-ltbody'>  " +
    	"<td> " +
		"<input id=\""+pinming+"\"  name=\""+pinming+"\" >" +
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:50px;\" name=\""+tongyongming+"\" id=\""+tongyongming+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+pihao+"\" id=\""+pihao+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:40px;\" name=\""+yongfayongliang+"\" id=\""+yongfayongliang+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+yongyaoshijian+"\" id=\""+yongyaoshijian+"\" class='easyui-datebox'/> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+yongyaoyuanyin+"\" id=\""+yongyaoyuanyin+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+beizhu+"\" id=\""+beizhu+"\" /> "+
		"</td> " +	
		"<td> " +
			"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchu("+i+")\" value=\"删除\"/>"+
		"</td> " +	
    	"</tbody>"
    	);
    	i++;
    	$("#counts").val(i);
    	$.parser.parse($("#condition_table"));
    	$("#"+pinming).combobox({
		url:"${ctx}/drugState/inspectionRecords/findypboxqy.html",
		valueField:'id', 
		textField:'text',
		value:j.yaopinming,
		onSelect: function(rec){
     			changqm(pinming,rec.id);
     		}
		});
    }
    function shanchu(a){
    	i--;
    	$("#counts").val(i);
    	var b = "tbody"+a;
		var table = document.getElementById("condition_table");
    	var tbodies= table.getElementsByTagName("tbody");
    	for(var f=0;f<tbodies.length;f++){
		if(tbodies[f].id==b){
		   table.removeChild(tbodies[b]);             
		    }          
		}  
    }
    function changqms(s,aaaaa){
		var a = s.substring(2,s.length);
	    var	quamaps=aaaaa;
	     var pm = "pm"+a;
		var tym = "tym"+a;
    	var ph = "ph"+a;
    	var yfyl = "yfyl"+a;
    	var yysj = "yysj"+a;
    	var yyyy = "yyyy"+a;
    	var bz = "bz"+a;
	    if(quamaps!=""){
			$.post("${ctx}/qualityRecords/adverseReactionInfo/quamaps.html",{
			"quamaps" : quamaps,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					$("#tym"+a).val(c[1]);
				}else{
					return;
				}
			});
	    }else{
	    	$("#pm"+a).val("");
			$("#tym"+a).val("");
	    }
    
    }
        function addbyyp(){
    	 var quamaps=$("#quamaps").val();
    	 var c = quamaps.substring(1,quamaps.length-1);
    	 var b = c.split(",");
    	 var d ="";
    	 var pm = "pm"+n;
    	 var tym = "tym"+n;
    	 var ph = "ph"+n;
    	 var yfyl = "yfyl"+n;
    	 var yysj = "yysj"+n;
    	 var yyyy = "yyyy"+n;
    	 var bz = "bz"+n;
    	 var tbodys="tbodys"+n;
    	 for(var j=0;j<b.length;j++){
    	 	var e = b[j].split("=");
    	 	d+="<option value=\""+e[0]+"\">"+e[1]+"</option>"; 
    	 }
    	$("#condition_tables").append(" <tbody id=\""+tbodys+"\" class='pn-ltbody'>  " +
    	"<td> " +
		"<input id=\""+pm+"\"  name=\""+pm+"\" >" +
		"</td> " +
		"<td> " +
			" <input type=\"text\" style=\"width:50px;\" name=\""+tym+"\" id=\""+tym+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+ph+"\" id=\""+ph+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:40px;\" name=\""+yfyl+"\" id=\""+yfyl+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+yysj+"\" id=\""+yysj+"\" class='easyui-datebox'/> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+yyyy+"\" id=\""+yyyy+"\" /> "+
		"</td> " +	
		"<td> " +
			" <input type=\"text\" style=\"width:100px;\" name=\""+bz+"\" id=\""+bz+"\" /> "+
		"</td> " +		
		"<td> " +
			"<input type=\"button\" style=\"width:30px;\" onclick=\"shanchus("+n+")\" value=\"删除\"/>"+
		"</td> " +	
    	"</tbody>"
    	);
    	n++;
    	$("#countss").val(n);
    	$.parser.parse($("#condition_tables"));
    	$("#"+pm).combobox({
		url:"${ctx}/drugState/inspectionRecords/findypboxqy.html",
		valueField:'id', 
		textField:'text',
		value:j.yaopinming,
		onSelect: function(rec){
     			changqms(pm,rec.id);
     		}
		});
    }
        function shanchus(a){
     
    	n--;
    	$("#countss").val(n);
    	var b = "tbodys"+a;
    	
		var table = document.getElementById("condition_tables");
    	var tbodies= table.getElementsByTagName("tbody");
    	for(var f=0;f<tbodies.length;f++){
		if(tbodies[f].id==b){
		   table.removeChild(tbodies[b]);             
		    }          
		}  
    }
    	function save2(){
			 var occurrenceDate = $("#occurrenceDate").datebox("getValue");
			 var reportDate = $("#reportDate").datebox("getValue");
			 var birthdate = $("#birthdate").datebox("getValue");
		
			 if(occurrenceDate!=''&& reportDate!=''&& occurrenceDate >reportDate){
           alert("报告时间不能早于发生时间");
            return;
		}else if(occurrenceDate!=''&& birthdate!=''&& occurrenceDate <birthdate){
		alert("发生时间不能早于出生日期");
            return;
		}else{
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
		  function trim(str){	
 		return str.replace(/(^\s*)|(\s*$)/g, ""); 
 	}
</script>
