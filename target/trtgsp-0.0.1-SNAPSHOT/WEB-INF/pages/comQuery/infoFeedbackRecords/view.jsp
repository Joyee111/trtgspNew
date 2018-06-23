<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="信息反馈"/></title>
    <meta />
</head>
<form:form commandName="df" method="post" action="" id="drs">
<table border="0" cellspacing="0" cellpadding="0" class="xx_table">
	
		<tr>
			<th width="150">
				反馈部门
				<span class="required">*</span>：
			</th>
			<td>
				<input type="text" name="feedbackdepartment" id="feedbackdepartment"
					value="${infoFeedBack.feedbackdepartment}" class="easyui-validatebox text1"
					data-options="required:true" size="40" />
			</td>

			<th width="150">
				来货单位
				<span class="required">*</span>：
			</th>
			<td>
				<input type="text" class="text1" value="${infoFeedBack.returnUnit }" size="40"/>
			</td>
		</tr>
		<tr>
			<th width="150">
				通用名称：
			</th>
			<td style="width: 400px;">
				<input type="text" class="text1" value="${infoFeedBack.commonName }"  size="40"/> 
			</td>
			<th width="150">
				规格：
			</th>
			<td>
				<input type="text" name="specifications" id="specifications" value="${infoFeedBack.specification}" class="easyui-validatebox text1" size="40" />
			</td>

		</tr>

		<tr>
			<th width="150">
				剂型：
			</th>
			<td>
				<input type="text" name="dosageforms" id="dosageforms" value="${infoFeedBack.drugForm }" class="easyui-validatebox text1" size="40" />
			</td>
			<th width="150">
				批准文号：
			</th>
			<td>
				<input type="text" name="licensenumber" id="licensenumber" value="${infoFeedBack.approvalNumber}" class="easyui-validatebox text1" size="40" />
			</td>

		</tr>
		<tr>
			<th width="150">
				生产厂家：
			</th>
			<td>
				<input type="text" name="produceno" id="produceno" value="${infoFeedBack.manufacturer}" class="easyui-validatebox text1" size="40" />
			</td>
			<th width="150">
				单位：
			</th>
			<td>
				<input type="text" name="unit" id="unit" value="${infoFeedBack.unit}" class="easyui-validatebox text1" size="40" />
			</td>
		</tr>

		<tr>
			<th width="150">
				批号：
			</th>
			<td>
				<input type="text" name="batchproduction" id="batchproduction" value="${infoFeedBack.batchproduction}" class="easyui-validatebox text1" size="40" />
			</td>
			<th width="150">
				数量：
			</th>
			<td>
				<input type="text" name="quantity" id="quantity" value="${infoFeedBack.quantity}" class="easyui-validatebox text1" size="40" maxlength="20" />
			</td>
		</tr>
		<tr>
			<th valign="top">
				质量情况反映：
			</th>
			<td colspan="3">
				<textarea name="feedbacksuggestion" id="feedbacksuggestion" cols="94" rows="4" class="easyui-validatebox  textarea">${infoFeedBack.feedbacksuggestion}</textarea>
				<input type="hidden" name="infoFeedId" id="infoFeedId" value="${infoFeedBack.id}"/>
				<input type="hidden" id = "assgintype" value=""/>
			</td>
		</tr>
			<c:set var="infeed" value="

"/>
			<c:set var="infoFeed1" value=""/>
			<c:set var="infoFeed2" value=""/>
			<c:set var="infoFeed3" value=""/>
			<c:set var="infoFeed4" value=""/>
			<c:forEach items="${itemList}" var="item">
				<c:choose>
					<c:when test="${item.type == '0'}">
						<c:set var="infoFeed1" value="${infoFeed1}${item.userName}：${item.content}${infeed }"/>
					</c:when>
					<c:when test="${item.type == '1'}">
						<c:set var="infoFeed2" value="${infoFeed2}${item.userName}：${item.content}${infeed }"/>
					</c:when>
					<c:when test="${item.type == '2'}">
						<c:set var="infoFeed3" value="${infoFeed3}${item.userName}：${item.content}${infeed }"/>
					</c:when>
					<c:when test="${item.type == '3'}">
						<c:set var="infoFeed4" value="${infoFeed4}${item.userName}：${item.content}${infeed }"/>
					</c:when>
				</c:choose>
			</c:forEach>

		<tr>
			<th valign="top">
				所在部门意见：
			</th>
			
			<td colspan="3">
				<textarea name="handlingsuggestion" id="handlingsuggestion" cols="94" rows="4" class="textarea">${infoFeed1}</textarea>
			</td>
		</tr>

		<tr>
			<th valign="top">
				经营质量办意见：
			</th>
			<td colspan="3">
				<textarea name="handlingsuggestion" id="handlingsuggestion" cols="94" rows="4" class="easyui-validatebox  textarea">${infoFeed2}</textarea>
			</td>
		</tr>

		<tr>
			<th valign="top">
				有关部门意见：
			</th>
			<td colspan="3">
				<textarea name="handlingsuggestion" id="handlingsuggestion" cols="94" rows="4" class="textarea">${infoFeed3}</textarea>
			</td>
		</tr>

		<tr>
			<th valign="top">
				处理结果：
			</th>
			<td colspan="3">
				<textarea name="handlingsuggestion" id="handlingsuggestion" cols="94" rows="4" class="textarea">${infoFeed4}</textarea>
			</td>
		</tr>

	</table>
<table>
	<tr align="center">
		<td colspan="4">
		
			<input type="button" class="btn_big" name="cancel" onclick="goBack();" value="<fmt:message key="返回"/>"/>
		
		</td>
	</tr>
</table>
</form:form>


