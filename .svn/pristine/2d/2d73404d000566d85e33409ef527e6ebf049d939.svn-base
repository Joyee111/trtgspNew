<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="userProfile.title"/></title>
    <meta />
</head>
<script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
<script language="javascript" type="text/javascript"
	src="/zywx3/ext/scripts/validator/jquery.validate.js">
</script>
<script type="text/javascript"
	src="/zywx3/ext/scripts/user/selectarea.js">
</script>
<script language="javascript" type="text/javascript"
	src="/zywx3/ext/scripts/validator/validateUtil.js">
</script>
<script type="text/javascript">
jQuery.validator.setDefaults( {
	submitHandler : function() {
		document.suers.submit;
	}
});

jQuery().ready(function() {
		jQuery("#users").validate({
			rules:{
				company:{
					required: false
				},
				address:{
					required: false
				},
				fax:{
					required: false,
					phoneNo: true
				},
				passanswer:{
					required: true
				},
				passprompt:{
					required: true
				},
				password:{
					required: true
				},
				againpassword:{
					required: true,
					passwordNo:true
				},
				realname:{
					required: true,
					chinaNo: true,
					rangelength: [2,5]
				},
				<c:if test="${param.method eq 'add'}">
				username:{
					required: true,
					englishNo: true,
					rangelength: [5,10]
				},
				</c:if>
				email:{
					required: false,
					emailNo: true
				},
				mobile:{
					required: false,
					phoneNo: true
				},
				telephone:{
					required: false,
					mobileNo: true
				},
				url:{
					required: false,
					urlNo: true
				},
				longitude:{
					required: false,
					longitudeNo: true
				},
				latitude:{
					required: false,
					latitudeNo: true
				},
				doublename:{
					required: false,
					doubleNo: true
				},
				ingetername:{
					required: false,
					integerNo: true
				},
				identitycard:{
					required: false,
					isIdCardNo: true
				},
				postcode:{
					required: false,
					integerNo:true,
					rangelength: [6,6]
				}
			},
			
			messages:{
				company:{
					required: "<fmt:message key="validate.company.nul"/>"
				},
				address:{
					required: "<fmt:message key="validate.address.nul"/>"
				},
				fax:{
					required: "<fmt:message key="validate.fax.nul"/>",
					phoneNo: "<fmt:message key="validate.fax.error"/>"
				},
				passanswer:{
					required: "<fmt:message key="validate.passanswer.nul"/>"
				},
				passprompt:{
					required: "<fmt:message key="validate.passprompt.nul"/>"
				},
				realname:{
					required: "<fmt:message key="validate.realname.nul"/>",
					chinaNo: "<fmt:message key="validate.realname.error"/>",
					rangelength: "<fmt:message key="validate.realname.length"/>"
					
				},
				<c:if test="${param.method eq 'add'}">
				username:{
					required: "<fmt:message key="validate.username.nul"/>",
					englishNo: "<fmt:message key="validate.username.error"/>",
					rangelength: "<fmt:message key="validate.username.length"/>"
					
				},
				</c:if>
				password:{
					required:"<fmt:message key="validate.password.nul"/>",
				},
				againpassword:{
					required:"<fmt:message key="validate.password.nul"/>",
					passwordNo:"<fmt:message key="validate.againpassword.error"/>"
				},
				email:{
					required: "<fmt:message key="validate.email.nul"/>",
					emailNo: "<fmt:message key="validate.email.error"/>"
					
				},
				mobile:{
					required: "<fmt:message key="validate.mobile.nul"/>",
					phoneNo: "<fmt:message key="validate.mobile.error"/>"
					
				},
				telephone:{
					required: "<fmt:message key="validate.telephone.nul"/>",
					mobileNo: "<fmt:message key="validate.telephone.error"/>"
					
				},
				url:{
					required: "<fmt:message key="validate.url.nul"/>",
					urlNo: "<fmt:message key="validate.url.error"/>"
				},
				longitude:{
					required: "<fmt:message key="validate.longitude.nul"/>",
					longitudeNo: "<fmt:message key="validate.longitude.error"/>"
					
				},
				latitude:{
					required: "<fmt:message key="validate.latitude.nul"/>",
					latitudeNo: "<fmt:message key="validate.latitude.error"/>"
					
				},
				doublename:{
					required: "<fmt:message key="validate.doublename.nul"/>",
					doubleNo: "<fmt:message key="validate.doublename.error"/>"
					
				},
				ingetername:{
					required: "<fmt:message key="validate.ingetername.nul"/>",
					integerNo: "<fmt:message key="validate.ingetername.error"/>"
					
				},
				identitycard:{
					required: "<fmt:message key="validate.identitycard.nul"/>",
					isIdCardNo: "<fmt:message key="validate.identitycard.error"/>"
				},
				postcode:{
					required: "<fmt:message key="validate.postcode.required"/>",
					integerNo: "<fmt:message key="validate.postcode.integerNo"/>",
					rangelength: "<fmt:message key="validate.postcode.rangelength"/>"
				}
			}
		});
	});
</script>

<div class="box_big">
<form:form commandName="user" method="post" action="saveuser.html" id="users">
<form:hidden path="id"/>
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>
<input type="hidden" name="method" value="<c:out value="${param.method}"/>"/>

<div class="ceng_mar5" style="padding-bottom:5px;">
<table width="100%" class="table_cx" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th colspan="6"><p class="biao"><fmt:message key="userform.baseheader"/></p></th>
	</tr>
	<tr onmouseover="this.className='red'"
					onmouseout="this.className=''">
		<td class="first right" style="width:200px;">
			<fmt:message key="user.username"/><span class="required">*</span>:
		</td>
		<td class="left" style="width:350px;">
			
				<form:input path="username" id="username" cssClass="text" cssErrorClass="text large error"/>
	       		<form:errors path="username" cssClass="fieldError"/>
       		
		</td>
		<td class="right" style="width:200px;">
			<fmt:message key="user.password"/><span class="required">*</span>:
		</td>
		<td class="left" style="width:350px;">
			<form:password path="password" id="password" cssClass="text" showPassword="true"/>
		</td>
		<td class="right" style="width:200px;">
			<fmt:message key="user.againpassword"/><span class="required">*</span>:
		</td>
		<td class="left" style="width:350px;">
			<input type="password" name="againpassword" id="againpassword" value="${user.password}" class="text"/>
		</td>
	</tr>
	<tr class="hui" onmouseover="this.className='red'"
					onmouseout="this.className='hui'">
		<td class="right">
			<fmt:message key="user.realname"/><span class="required">*</span>:
		</td>
		<td class="left">
			<form:input path="realname" id="realname" cssClass="text"/>
		</td>
		<td class="first right">
			<fmt:message key="user.usersex"/><span class="required">*</span>:
		</td>
		<td class="left">
			<form:select path="usersex" cssClass="text2">
				<form:option value="1"><fmt:message key="user.usersex.male"/></form:option>
				<form:option value="2"><fmt:message key="user.usersex.female"/></form:option>
			</form:select>
		</td>
		<td  class="right"><fmt:message key="user.passprompt"/>:</td>
		<td class="left"><form:input path="passprompt" id="passprompt" cssClass="text"/></td>
	</tr>
	<tr onmouseover="this.className='red'"
					onmouseout="this.className=''">
		<td  class="right"><fmt:message key="user.passanswer"/>:</td>
		<td class="left"><form:input path="passanswer" id="passanswer" cssClass="text"/></td>
		<td class="first right">
			<fmt:message key="user.email"/>:
		</td>
		<td class="left">
    		<form:input path="email" id="email" cssClass="text"/>
			<form:errors path="email" cssClass="fieldError"/>
		</td>
		<td  class="right">
			<fmt:message key="user.identitycard"/>:
		</td>
		<td class="left">
			<form:input path="identitycard" id="identitycard" cssClass="text"/>
		</td>
	</tr>
	<tr class="hui" onmouseover="this.className='red'"
					onmouseout="this.className='hui'">
		<td  class="right">
			<fmt:message key="user.postcode"/>:
		</td>
		<td class="left">
			<form:input path="postcode" id="postcode" cssClass="text"/>
		</td>
		<td class="first right">
			<fmt:message key="user.mobile"/>:
		</td>
		<td class="left">
			<form:input path="mobile" id="mobile" cssClass="text"/>
		</td>
		<td  class="right">
			<fmt:message key="user.fax"/>:
		</td>
		<td class="left">
			<form:input path="fax" id="fax" cssClass="text"/>
		</td>
	</tr>
	<tr onmouseover="this.className='red'"
					onmouseout="this.className=''">
		<td  class="right">
			<fmt:message key="user.telephone"/>:
		</td>
		<td class="left">
			<form:input path="telephone" id="telephone" cssClass="text"/>
		</td>
		<td class="first right">
			<fmt:message key="user.address"/>:
		</td>
		<td class="left">
			<form:input path="address" id="address" cssClass="text"/>
		</td>
		<td  class="right">
			<fmt:message key="user.ipaddress"/>:
		</td>
		<td class="left">
			<form:input path="ipaddress" id="ipaddress" cssClass="text"/>
		</td>
	</tr>
	<tr onmouseover="this.className='red'"
					onmouseout="this.className=''">
		<td class="first right">
			<fmt:message key="user.islocktitle"/>:
		</td>
		<td class="left">
			<form:select path="islocked" cssClass="text2">
				<option value=""><fmt:message key="common.pleaseselect"/></option>
				<c:forEach var="l" items="${locksmap}">
					<form:option value="${l.key}">${l.value}</form:option>
				</c:forEach>
			</form:select>
		</td>
	</tr>
	<tr><th colspan="6"><p class="biao"><fmt:message key="userProfile.assignRoles"/></p></th></tr>
	<tr class="hui" onmouseover="this.className='red'"
					onmouseout="this.className='hui'">
		<td colspan="6" class="left">
		<c:forEach var="au" items="${availableRoles}">
			${au.value}<input name="userRoles" type="checkbox" value="${au.label}"
			<c:forEach var="rl" items="${user.roles}">
			<c:if test="${rl!=null && rl.roleid==au.label}">
			checked="checked"
			</c:if>
			</c:forEach>
			/>
		</c:forEach>
		</td>
	</tr>
</table>
<table>
	<tr align="center">
		<td colspan="4">
			<input type="submit" class="btn_blue2" name="save" onclick="bCancel=false" value="<fmt:message key="button.save"/>"/>
			<input type="button" class="btn_blue2" name="cancel" onclick="onCancel();" value="<fmt:message key="button.cancel"/>"/>
		</td>
	</tr>
</table>
</div>
<input type="hidden" name="tz" value="${tzpage}"/>
<input type="hidden" name="pagename" value="${pagename}"/>
<input type="hidden" name="ptmeth" value="${ptmeth}"/>
</form:form>
</div>
<script type="text/javascript">
    Form.focusFirstElement($('users'));
    highlightFormElements();
    function onCancel()
    {
    	history.go(-1);
    }
</script>

