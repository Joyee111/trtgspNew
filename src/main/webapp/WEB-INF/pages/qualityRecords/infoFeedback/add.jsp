<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title><fmt:message key="信息反馈" />
	</title>
	<meta />
	<script type="text/javascript">
		 function findQualityMedc(s){
        	//alert(s);
		    if(s.value!=""){
				$.post("${ctx}/qualityRecords/qualityQuery/quamap.html",{
				"quamap" : s,
				},function(data){
					if(data){
						var b = data.toString();
						//alert(b);
						var c = b.split(",");
						$("#dosageforms").val(c[1]);
						$("#specifications").val(c[2]);
						$("#licensenumber").val(c[3]);
						$("#produceno").val(c[4]);
						$("#unit").val(c[6]);
						var tt = document.getElementById("qualifiedmedicineid");   
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
				$("#produceno").val("");
				$("#unit").val("");
		    }
    
    }
    function saveInfoFeedBack(){
    	$("#infoFeedBack_form").form("submit",{
    		success : function(data){
    			var json = jsonParse(data);
    			var succ = json.success;
    			if(typeof (succ) != 'undefined' && succ != ""){
    				alert(decodeURI(succ));
    			}
    			location.href="list.html";
    		}
    	})
    }

  function assginInfoFeedBack(){
  	var assginUsers = $("#assginUsers").combobox("getValues");
  //	alert(assginUsers);
  	var assgintype=$("#assgintype").val();
  //	alert(assgintype)
  	var commonName = $("#commonName").val();//通用名称
	var specification = $("#specification").val();//规格
	var drugForm = $("#drugForm").val();//剂型
	var approvalNumber = $("#approvalNumber").val() ;//批准文号
	var manufacturer = $("#manufacturer").val();//生产厂家
	var unit = $("#unit").val();//单位
	var batchproduction = $("#batchproduction").val();//批号
	var quantity = $("#quantity").val() ;  // -- 数量 
	var feedbackdepartment = $("#feedbackdepartment").val() ;//    -- 反馈部门 
	var feedbacksuggestion = $("#feedbacksuggestion").val(); //   -- 质量情况反映
	var returnUnit = $("#returnUnit").val();//来货单位
	
	var  infoFeedId = $("#infoFeedId").val();
	
	if(typeof (feedbackdepartment) === 'undefined' || feedbackdepartment ===''){
		alert("反馈部门不能为空，请填写反馈部门！");
		return;
	}
	if(typeof (returnUnit) === 'undefined' || returnUnit ===''){
		alert("来货单位不能为空，请填写来货单位！");
		return;
	}
	if(typeof (commonName) === 'undefined' || commonName ===''){
		alert("通用名称不能为空，请填写通用名称！");
		return;
	}
	if(typeof (specification) === 'undefined' || specification ===''){
		alert("规格 不能为空，请填写规格！");
		return;
	}
	if(typeof (drugForm) === 'undefined' || drugForm ===''){
		alert("剂型 不能为空，请填写剂型！");
		return;
	}
	if(typeof (approvalNumber) === 'undefined' || approvalNumber ===''){
		alert("批准文号 不能为空，请填写批准文号！");
		return;
	}
	if(typeof (manufacturer) === 'undefined' || manufacturer ===''){
		alert("生产厂家 不能为空，请填写生产厂家！");
		return;
	}
	if(typeof (unit) === 'undefined' || unit ===''){
		alert("单位 不能为空，请填写单位！");
		return;
	}
	if(typeof (batchproduction) === 'undefined' || batchproduction ===''){
		alert("批号不能为空，请填写批号！");
		return;
	}
	if(typeof (quantity) === 'undefined' || quantity ===''){
		alert("数量不能为空，请填写数量！");
		return;
	}
	if(typeof (feedbacksuggestion) === 'undefined' || feedbacksuggestion ===''){
		alert("反映情况不能为空，请填写反映情况！");
		return;
	}
	
	$.post("ajaxAssginInfoFeedBack.html",{
		id : infoFeedId,
		type : assgintype,
		assginUserIds : ''+assginUsers,
		commonName : commonName,
		specification : specification,
		drugForm : drugForm,
		approvalNumber : approvalNumber,
		manufacturer : manufacturer,
		unit : unit,
		batchproduction : batchproduction,
		quantity : quantity,
		feedbackdepartment : feedbackdepartment,
		feedbacksuggestion : feedbacksuggestion,
		returnUnit : returnUnit
	},function(data){
		$('#dialogss').dialog('close');
		var json = jsonParse(data), success = json.success, infoFeedbackVO =json.infoFeedbackVO, type = json.type;
		if(typeof(success)!="undefined" && success != ""  ){
			alert(decodeURI(success));
		}
		 $("#commonName").val(infoFeedbackVO.commonName);//通用名称
		 $("#specification").val(infoFeedbackVO.specification);//规格
		 $("#drugForm").val(infoFeedbackVO.drugForm);//剂型
		 $("#approvalNumber").val(infoFeedbackVO.approvalNumber) ;//批准文号
		 $("#manufacturer").val(infoFeedbackVO.manufacturer);//生产厂家
		 $("#unit").val(infoFeedbackVO.unit);//单位
		 $("#batchproduction").val(infoFeedbackVO.batchproduction);//批号
		 $("#quantity").val(infoFeedbackVO.quantity) ;  // -- 数量 
		 $("#feedbackdepartment").val(infoFeedbackVO.feedbackdepartment) ;//    -- 反馈部门 
		 $("#feedbacksuggestion").val(infoFeedbackVO.feedbacksuggestion); //   -- 质量情况反映
		 $("returnUnit").val(infoFeedbackVO.returnUnit);//来货单位
		 $("#infoFeedId").val(infoFeedbackVO.id);
		 $("#id").val(infoFeedbackVO.id);
		if(typeof(type)!= 'undefined' && type === "0"){
			$("#handlingsuggestion").val("已指派");
			
		}else if(type === "1"){
			$("#handlingresult").val("已指派");
		}else if(type === "2"){
			$("#bumenyijian").val("已指派");
		}else if(type === "3"){
			$("#chulijiguo").val("已指派");
		}
		
	})
}
	function openAssginUserDialog(type){
		$("#assgintype").val(type);
		$('#dialogss').dialog('open');
	}
	$(function (){
		var assginType = "${alreadyAssignList}";
		// assginTypes = assginType.split(",");
		 //alert(assginType);
		 $.each(assginType,function (index,type){
		 //	alert(index);
		 //	alert(type);
		 //	alert(type);
		 	if(typeof(type)!= 'undefined' && type === "0"){
				$("#handlingsuggestion").val("已指派");
			}else if(type === "1"){
				$("#handlingresult").val("已指派");
			}else if(type === "2"){
				$("#bumenyijian").val("已指派");
			}else if(type === "3"){
				$("#chulijiguo").val("已指派");
			}
		 })
	});
	</script>
</head>
<body>
	<font style="font-family: '宋体'; font-weight: normal; font-size: 12; color: #8d3c01; padding: 10px;">质量记录管理&nbsp;>&nbsp;信息反馈&nbsp;>&nbsp;${titles}</font>
	<form action="saveInfoFeedBack.html" method="post" id="infoFeedBack_form">
	<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
		<tr>
			<th width="150">
				反馈部门
				<span class="required">*</span>：
			</th>
			<td>
				<input type="text" name="feedbackdepartment" id="feedbackdepartment"
					value="${infoFeddBack.feedbackdepartment }" class="easyui-validatebox text1"
					data-options="required:true" size="40"  />
			</td>

			<th width="150">
				来货单位
				：
			</th>
			<td>
				<input type="text" name="returnUnit" id="returnUnit" class="text1" size="40" value="${infoFeddBack.returnUnit}"/>
			</td>

		</tr>
		<tr>
			<th width="150">
				通用名称：
			</th>
			<td style="width: 400px;">
				<input type="text" class="easyui-validatebox text1" name="commonName" id="commonName"  size="40"  value="${infoFeddBack.commonName }"/>
				&nbsp;&nbsp;

			</td>
			<th width="150">
				规格：
			</th>
			<td>
				<input type="text" name="specification" id="specification" class="easyui-validatebox text1" size="40"  value="${infoFeddBack.specification }"/>
			</td>

		</tr>

		<tr>
			<th width="150">
				剂型：
			</th>
			<td>
				<input type="text" name="drugForm" id="drugForm"  class="easyui-validatebox text1" size="40"  value="${infoFeddBack.drugForm }"/>
			</td>
			<th width="150">
				批准文号：
			</th>
			<td>
				<input type="text" name="approvalNumber" id="approvalNumber"  class="easyui-validatebox text1" size="40"  value="${infoFeddBack.approvalNumber }"/>
			</td>

		</tr>
		<tr>
			<th width="150">
				生产厂家：
			</th>
			<td>
				<input type="text" name="manufacturer" id="manufacturer"  class="easyui-validatebox text1" size="40" value="${infoFeddBack.manufacturer }"/>
			</td>
			<th width="150">
				单位：
			</th>
			<td>
				<input type="text" name="unit" id="unit"  class="easyui-validatebox text1" size="40" value="${infoFeddBack.unit }"/>
			</td>
		</tr>

		<tr>
			<th width="150">
				批号：
			</th>
			<td>
				<input type="text" name="batchproduction" id="batchproduction"  class="easyui-validatebox text1" size="40" value="${infoFeddBack.batchproduction }"/>
			</td>
			<th width="150">
				数量：
			</th>
			<td>
				<input type="text" name="quantity" id="quantity" class="easyui-validatebox text1" size="40" maxlength="20" value="${infoFeddBack.quantity }"/>
			</td>
		</tr>
		<tr>
			<th valign="top">
				质量情况反映：
			</th>
			<td colspan="3">
				<textarea name="feedbacksuggestion" id="feedbacksuggestion" cols="94" rows="4" class="easyui-validatebox  textarea">${infoFeddBack.feedbacksuggestion }</textarea>
				<input type="hidden" name="infoFeedId" id="infoFeedId" value="${infoFeddBack.id}"/>
				<input type="hidden" id = "assgintype" value=""/>
			</td>
		</tr>
	

		<tr align="center">
			<td colspan="4">
				<shiro:hasPermission name="FeedbackManage_save1">
					<input name="" type="button" class="btn_big" value="指派給" onclick="openAssginUserDialog('0')" />
				</shiro:hasPermission>
			</td>
		</tr>

		<tr>
			<th valign="top">
				所在部门意见：
			</th>
			<td colspan="3">
				<textarea name="handlingsuggestion" id="handlingsuggestion" cols="94" rows="4" class="easyui-validatebox  textarea"></textarea>
			</td>
		</tr>


		<tr align="center">
			<td colspan="4">
				<shiro:hasPermission name="FeedbackManage_save2">
					<input name="" type="button" class="btn_big" value="指派給" onclick="openAssginUserDialog('1')" />
				</shiro:hasPermission>
			</td>
		</tr>

		<tr>
			<th valign="top">
				经营质量办意见：
			</th>
			<td colspan="3">
				<textarea name="handlingresult" id="handlingresult" cols="94" rows="4" class="easyui-validatebox  textarea"></textarea>
			</td>
		</tr>


		<tr align="center">
			<td colspan="4">
				<shiro:hasPermission name="FeedbackManage_save3">
					<input name="" type="button" class="btn_big" value="指派給" onclick="openAssginUserDialog('2')" />
				</shiro:hasPermission>
			</td>
		</tr>

		<tr>
			<th valign="top">
				有关部门意见：
			</th>
			<td colspan="3">
				<textarea name="bumenyijian" id="bumenyijian" cols="94" rows="4" class="easyui-validatebox  textarea"></textarea>
			</td>
		</tr>

		<tr align="center">
			<td colspan="4">
				<shiro:hasPermission name="FeedbackManage_save4">
					<input name="" type="button" class="btn_big" value="指派給" onclick="openAssginUserDialog('3')" />
				</shiro:hasPermission>
			</td>
		</tr>

		<tr>
			<th valign="top">
				处理结果：
			</th>
			<td colspan="3">
				<textarea name="chulijiguo" id="chulijiguo" cols="94" rows="4" class="easyui-validatebox  textarea">${df.chulijiguo}</textarea>
				<input type="hidden" name="id" id="id" value="${infoFeddBack.id}"/>
			</td>
		</tr>

	</table>
	</form>
	<div id="dialogss" title="指派用户" class="easyui-dialog" style="width: 800px; height: 300px; padding: 10px; margin-top: 20px;" data-options="closed:true,modal:false,top:500">
		<table>
			<tr>
				<td colspan="4" align="center" valign="bottom">
					<label>请选择要指派的人：</label><input type="text" class="easyui-combobox text1" name="assginUsers" id="assginUsers" data-options="
					valueField : 'id',
       				textField : 'text',
       				multiple : true ,
       				separator : ',' ,
       				required : true ,
       				filter: function(q, row){
						var opts = $(this).combobox('options');
						return row[opts.textField].indexOf(q) == 0;
					},
      				url:'${ctx}/qualityRecords/infoFeedback/ajaxQueryAssginUser.html'
					" >
					<input type="button" class="btn_big" onclick="assginInfoFeedBack()" value="保存">
					<input type="button" class="btn_big" onclick="$('#dialogss').dialog('close')" value="取消">
				</td>
			</tr>
		</table>
	</div>
	<table>
		<tr align="center">
			<td colspan="4">
				<shiro:hasPermission name="FeedbackManage_save5">
					<input name="" type="button" class="btn_big"
						value="<fmt:message key='button.save'/>"
						onclick="saveInfoFeedBack()" />
					<input type="button" class="btn_big" name="cancel"
						onclick="goBack();" value="<fmt:message key="button.cancel"/>" />
				</shiro:hasPermission>
			</td>
		</tr>
	</table>
	<input type="hidden" name="tz" value="${tzpage}" />
	<input type="hidden" name="pagename" value="${pagename}" />
	<input type="hidden" name="ptmeth" value="${ptmeth}" />
</body>



