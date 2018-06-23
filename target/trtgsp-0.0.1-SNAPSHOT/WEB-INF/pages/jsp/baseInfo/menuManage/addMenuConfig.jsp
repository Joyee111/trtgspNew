<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>添加【菜单配置】信息</title>
    <meta name="menu" content="UserMenu"/>
</head>
<script type="text/javascript" src="${ctx}/js/easyui/jquery-1.8.0.min.js"></script>
<script language="javascript" type="text/javascript" src="${ctx}/ext/scripts/validator/jquery.validate.js"></script>
<script language="javascript" type="text/javascript" src="${ctx}/ext/scripts/validator/validateUtil.js"></script>
<script type="text/javascript">
	jQuery.validator.setDefaults( {
		submitHandler : function() {
			document.form1.action="${ctx}/menuManage/frame/saveMenuConfig.html";
//			document.userForm.submit;
			alert("更新成功，点击确定查看列表！");
			form1.submit();
		}
	});
	
	jQuery().ready(function() {
			jQuery("#userForm").validate({
				rules:{
					menuName:{
						required: true
					},
					controlUrl:{
						required: true
					},
					parentId:{
						required: true
					}
				},
				
				messages:{
					menuName:{
						required: "不能为空！"
					},
					controlUrl:{
						required: "不能为空！"
					},
					parentId:{
						required: "不能为空！"
					}
				}
			});
		});
</script>
<p class="biao"><b>添加【菜单配置】信息(*为必填项)</b></p>
<div class="box_big" style="padding-top:5px;">
<form:form commandName="entity" method="post" name="form1" id="userForm">
<div class="ceng_mar5" style="padding-bottom:5px;">
<c:if test="${type == 'edit'}">
<input name="id" type="hidden" id="id" value="${entity.id}"/>
</c:if>
<table width="100%" class="table_cx" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th colspan="6"><p class="biao">【菜单配置】信息</p></th>
	</tr>
	<tr onmouseover="this.className='red'" onmouseout="this.className=''">
		<td class="right" style="width:200px;">
			菜单名称<span class="required">*</span>:
		</td>
		<td class="left">
		   <label>
		      <input name="menuName" type="text" id="menuName"/>
		  </label>
            <form:errors path="menuName" cssClass="fieldError"/>
		</td>
		<td class="right" style="width:200px;">
			唯一标识<span class="required">*</span>:
		</td>
		<td class="left">
		   <label>
		      <input name="uniqueKey" type="text" id="uniqueKey"  <c:if test="${type == 'edit'}">readonly="readonly" style="background-color:#EAEAEA"</c:if> />
		  </label>
            <form:errors path="uniqueKey" cssClass="fieldError"/>
		</td>
	</tr>
		<tr onmouseover="this.className='red'" onmouseout="this.className=''">
		
		<td class="right" style="width:200px;">
			操作链接<span class="required">*</span>:
		</td>
		<td class="left"  colspan="3">
		   <label>
		      <input name="controlUrl" type="text" id="controlUrl" value="${entity.controlUrl}" size="70"/>
		  </label>
            <form:errors path="controlUrl" cssClass="fieldError"/>
		</td>

	</tr>
		<tr onmouseover="this.className='red'" onmouseout="this.className=''">
		
		<td class="right" style="width:200px;">
			父菜单<span class="required">*</span>:
		</td>
		<td class="left">
		   <label>
		      <input name="parentId" type="text" id="parentId" value="${menuId}"/>
		  </label>
            <form:errors path="parentId" cssClass="fieldError"/>
		</td>
		<td class="right" style="width:200px;">
			对应权限<span class="required">*</span>:
		</td>
		<td class="left">
		   <label>
		      <select name="authoriy.id" id="authorityId">
                  <option value="">请选择</option>
                  <c:forEach items="${authoriyList}" var="authority">
                  <option value="${authority.authoriyid}">${authority.description}</option>
                  </c:forEach>
		      </select>
		  </label>
            <form:errors path="authoriy" cssClass="fieldError"/>
		</td>
	</tr>
	<tr onmouseover="this.className='red'" onmouseout="this.className=''">
		<td class="right">
			备注说明<span class="required">&nbsp;</span>:
		</td>
		<td colspan="3" class="left">
		   <label>
		     <textarea name="description" id="description" cols="117" rows="5">${entity.description}</textarea>
		   </label>
		</td>
	</tr>
</table>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr height="70" valign="top">
		<td align="center">
			<input type="submit" class="btn_blue2" name="save" onclick="bCancel=false" value="<fmt:message key="button.save"/>"/>
			<input type="button" class="btn_blue2" name="cancel" onclick="javascript:cancle()" value="<fmt:message key="button.cancel"/>"/>
		</td>
	</tr>
</table>
</form:form>
</div>
<script type="text/javascript">
//    Form.focusFirstElement($('userForm'));
//    highlightFormElements();
    function cancle(){
  		window.location.href="${ctx}/menuManage/menuConfigFrame.html";
  	}
</script>