<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title><fmt:message key="信息反馈" />
	</title>
	<meta />
	<script type="text/javascript">
		
    function saveInfoFeedBack(){
    	$("#infoFeedBack_form").form("submit",{  
			    success: function(data){ 
    			
    			if(typeof (data) != 'undefined' && data != ""){
    				alert(decodeURI(data));
    			}
    			location.href="list.html";
    		}
    	})
    }
 
	</script>
</head>
<body>
	<font style="font-family: '宋体'; font-weight: normal; font-size: 12; color: #8d3c01; padding: 10px;">质量记录管理&nbsp;>&nbsp;信息反馈&nbsp;>&nbsp;${titles}</font>
	<form action="saveInfoFeedBacks.html" method="post" id="infoFeedBack_form">
	<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
	
		<tr>
			<th width="150">
				反馈部门
				<span class="required">*</span>：
			</th>
			<td>
				<input type="text" name="feedbackdepartment" id="feedbackdepartment"
					value="${infoFeddBack.feedbackdepartment }" class="easyui-validatebox text1"
					data-options="required:true" size="40"   readonly="readonly"/>
			</td>

			<th width="150">
				来货单位
				<span class="required">*</span>：
			</th>
			<td>
				<input type="text" name="returnUnit" id="returnUnit" class="text1" size="40" value="${infoFeddBack.returnUnit }" readonly="readonly"/>
			</td>

		</tr>
		<tr>
			<th width="150">
				通用名称：
			</th>
			<td style="width: 400px;">
				<input type="text" class="easyui-validatebox text1" name="commonName" id="commonName"  size="40"  value="${infoFeddBack.commonName }" readonly="readonly"/>
				&nbsp;&nbsp;

			</td>
			<th width="150">
				规格：
			</th>
			<td>
				<input type="text" name="specification" id="specification" class="easyui-validatebox text1" size="40"  value="${infoFeddBack.specification }" readonly="readonly"/>
			</td>

		</tr>

		<tr>
			<th width="150">
				剂型：
			</th>
			<td>
				<input type="text" name="drugForm" id="drugForm"  class="easyui-validatebox text1" size="40"  value="${infoFeddBack.drugForm }" readonly="readonly"/>
			</td>
			<th width="150">
				批准文号：
			</th>
			<td>
				<input type="text" name="approvalNumber" id="approvalNumber"  class="easyui-validatebox text1" size="40"  value="${infoFeddBack.approvalNumber }" readonly="readonly"/>
			</td>

		</tr>
		<tr>
			<th width="150">
				生产厂家：
			</th>
			<td>
				<input type="text" name="manufacturer" id="manufacturer"  class="easyui-validatebox text1" size="40" value="${infoFeddBack.manufacturer }" readonly="readonly"/>
			</td>
			<th width="150">
				单位：
			</th>
			<td>
				<input type="text" name="unit" id="unit"  class="easyui-validatebox text1" size="40" value="${infoFeddBack.unit }" readonly="readonly"/>
			</td>
		</tr>

		<tr>
			<th width="150">
				批号：
			</th>
			<td>
				<input type="text" name="batchproduction" id="batchproduction"  class="easyui-validatebox text1" size="40" value="${infoFeddBack.batchproduction }" readonly="readonly"/>
			</td>
			<th width="150">
				数量：
			</th>
			<td>
				<input type="text" name="quantity" id="quantity" class="easyui-validatebox text1" size="40" maxlength="20" value="${infoFeddBack.quantity }" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<th valign="top">
				质量情况反映：
			</th>
			<td colspan="3">
				<textarea name="feedbacksuggestion" id="feedbacksuggestion" cols="94" rows="4" class="easyui-validatebox  textarea" readonly="readonly">${infoFeddBack.feedbacksuggestion }</textarea>
				<input type="hidden" name="infoFeedId" id="infoFeedId" value="${infoFeddBack.id}"/>
				<input type="hidden" id = "assgintype" value=""/>
			</td>
		</tr>
		<c:forEach items="${waitDoList}" var="item" varStatus="index">
			<tr>
				<th>
					<c:choose>
						<c:when test="${item.type == '0'}">
							<c:out value="所在部门意见："/>
						</c:when>
						<c:when test="${item.type == '1'}">
							<c:out value="经营质量办意见："/>
						</c:when>
						<c:when test="${item.type == '2'}">
							<c:out value="有关部门意见："/>
						</c:when>
						<c:when test="${item.type == '3'}">
							<c:out value="处理结果："/>
						</c:when>
					</c:choose>
				</th>
				<td colspan="3">
					<textarea name="list[${index.index }].content" id="handlingsuggestion" cols="94" rows="4" class="easyui-validatebox  textarea">${item.content}</textarea>
					<input type="hidden" name="list[${index.index }].type" value="${item.type }"/>
					<input type="hidden" name="list[${index.index }].infoFeedbackId" value="${item.infoFeedbackId}"/>
					<input type="hidden" name="list[${index.index }].zhipaiId" value="${item.zhipaiId }"/>
					<input type="hidden" name="list[${index.index }].id" value="${item.id }"/>
				</td>
			</tr>
				<input type="hidden" name="infoFeedId" id="infoFeedId" value=""/>
				<input type="hidden" id = "assgintype" value=""/>
		</c:forEach>
	</table>
	</form>
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
</body>


