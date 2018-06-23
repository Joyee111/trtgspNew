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
					required: true
				},
				address:{
					required: true
				},
				fax:{
					required: true,
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
					required: true,
					emailNo: true
				},
				mobile:{
					required: true,
					phoneNo: true
				},
				telephone:{
					required: true,
					mobileNo: true
				},
				url:{
					required: true,
					urlNo: true
				},
				longitude:{
					required: true,
					longitudeNo: true
				},
				latitude:{
					required: true,
					latitudeNo: true
				},
				doublename:{
					required: true,
					doubleNo: true
				},
				ingetername:{
					required: true,
					integerNo: true
				},
				identitycard:{
					required: true,
					isIdCardNo: true
				},
				postcode:{
					required: true,
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
			<c:if test="${param.method eq 'add'}">
				<form:input path="username" id="username" cssClass="text" cssErrorClass="text large error"/>
	       		<form:errors path="username" cssClass="fieldError"/>
       		</c:if>
       		<c:if test="${param.method eq 'update'}">
       			${user.username}
       			<form:hidden path="username"/>
       		</c:if>
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
		<td  class="right"><fmt:message key="user.passprompt"/><span class="required">*</span>:</td>
		<td class="left"><form:input path="passprompt" id="passprompt" cssClass="text"/></td>
	</tr>
	<tr onmouseover="this.className='red'"
					onmouseout="this.className=''">
		<td  class="right"><fmt:message key="user.passanswer"/><span class="required">*</span>:</td>
		<td class="left"><form:input path="passanswer" id="passanswer" cssClass="text"/></td>
		<td class="first right">
			<fmt:message key="user.email"/><span class="required">*</span>:
		</td>
		<td class="left">
    		<form:input path="email" id="email" cssClass="text"/>
			<form:errors path="email" cssClass="fieldError"/>
		</td>
		<td  class="right">
			<fmt:message key="user.identitycard"/><span class="required">*</span>:
		</td>
		<td class="left">
			<form:input path="identitycard" id="identitycard" cssClass="text"/>
		</td>
	</tr>
	<tr class="hui" onmouseover="this.className='red'"
					onmouseout="this.className='hui'">
		<td  class="right">
			<fmt:message key="user.postcode"/><span class="required">*</span>:
		</td>
		<td class="left">
			<form:input path="postcode" id="postcode" cssClass="text"/>
		</td>
		<td class="first right">
			<fmt:message key="user.mobile"/><span class="required">*</span>:
		</td>
		<td class="left">
			<form:input path="mobile" id="mobile" cssClass="text"/>
		</td>
		<td  class="right">
			<fmt:message key="user.fax"/><span class="required">*</span>:
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
			<fmt:message key="user.address"/><span class="required">*</span>:
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
			<fmt:message key="user.islocktitle"/><span class="required">*</span>:
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
	<tr>
		<th colspan="6"><p class="biao"><fmt:message key="userform.companyheader"/></p></th>
	</tr>
	<tr onmouseover="this.className='red'"
					onmouseout="this.className=''">
		<td class="first right">
			<fmt:message key="user.company"/><span class="required">*</span>:
		</td>
		<td class="left">
			<form:input path="company" id="company" cssClass="text"/>
		</td>
		<td  class="right">
			<fmt:message key="user.companyaddress"/>:
		</td>
		<td class="left">
			<form:input path="companyaddress" id="companyaddress" cssClass="text"/>
		</td>
		<td  class="right">
			<fmt:message key="user.lawyername"/>:
		</td>
		<td class="left">
			<form:input path="lawyername" id="lawyername" cssClass="text"/>
		</td>
	</tr>
	<tr class="hui" onmouseover="this.className='red'"
					onmouseout="this.className='hui'">
		<td class="first right">
			<fmt:message key="user.lawyerphone"/>:
		</td>
		<td class="left">
			<form:input path="lawyerphone" id="lawyerphone" cssClass="text"/>
		</td>
		<td  class="right">
			<fmt:message key="user.lawyermail"/>:
		</td>
		<td class="left">
			<form:input path="lawyermail" id="lawyermail" cssClass="text"/>
		</td>
		<td  class="right">
			<fmt:message key="user.companycode"/>:
		</td>
		<td class="left">
			<form:input path="companycode" id="companycode" cssClass="text"/>
		</td>
	</tr>
	<tr onmouseover="this.className='red'"
					onmouseout="this.className=''">
		<td class="first right">
			<fmt:message key="user.companyfax"/>:
		</td>
		<td class="left">
			<form:input path="companyfax" id="companyfax" cssClass="text"/>
		</td>
		<td  class="right">
			<fmt:message key="user.companyip"/>:
		</td>
		<td class="left">
			<form:input path="companyip" id="companyip" cssClass="text"/>
		</td>
	</tr>
	<tr><th colspan="6"><p class="biao"><fmt:message key="userform.otherheader"/></p></th></tr>
	<tr onmouseover="this.className='red'"
					onmouseout="this.className=''">
		<td class="first right">
			<fmt:message key="user.country"/><span class="required">*</span>:
		</td>
		<td class="left">
			<form:select path="country" id="country" cssClass="text2">
				<form:option value="中国">中国</form:option>
			</form:select>
		</td>
		<td  class="right">
			<fmt:message key="user.province"/><span class="required">*</span>:
		</td>
		<td class="left">
			<form:select path="province" id="province"
								onchange="changepro('city','province');" cssClass="text2">
								<form:option value='北京市'>
									北京市
								</form:option>
								<form:option value='天津市'>
									天津市
								</form:option>
								<form:option value='河北省'>
									河北省
								</form:option>
								<form:option value='山西省'>
									山西省
								</form:option>
								<form:option value='内蒙古自治区'>
									内蒙古自治区
								</form:option>
								<form:option value='辽宁省'>
									辽宁省
								</form:option>
								<form:option value='吉林省'>
									吉林省
								</form:option>
								<form:option value='黑龙江省'>
									黑龙江省
								</form:option>
								<form:option value='上海市'>
									上海市
								</form:option>
								<form:option value='江苏省'>
									江苏省
								</form:option>
								<form:option value='浙江省'>
									浙江省
								</form:option>
								<form:option value='安徽省'>
									安徽省
								</form:option>
								<form:option value='福建省'>
									福建省
								</form:option>
								<form:option value='江西省'>
									江西省
								</form:option>
								<form:option value='山东省'>
									山东省
								</form:option>
								<form:option value='河南省'>
									河南省
								</form:option>
								<form:option value='湖北省'>
									湖北省
								</form:option>
								<form:option value='湖南省'>
									湖南省
								</form:option>
								<form:option value='广东省'>
									广东省
								</form:option>
								<form:option value='广西壮族自治区'>
									广西壮族自治区
								</form:option>
								<form:option value='海南省'>
									海南省
								</form:option>
								<form:option value='重庆市'>
									重庆市
								</form:option>
								<form:option value='四川省'>
									四川省
								</form:option>
								<form:option value='贵州省'>
									贵州省
								</form:option>
								<form:option value='云南省'>
									云南省
								</form:option>
								<form:option value='西藏自治区'>
									西藏自治区
								</form:option>
								<form:option value='陕西省'>
									陕西省
								</form:option>
								<form:option value='甘肃省'>
									甘肃省
								</form:option>
								<form:option value='青海省'>
									青海省
								</form:option>
								<form:option value='宁夏回族自治区'>
									宁夏回族自治区
								</form:option>
								<form:option value='新疆维吾尔自治区'>
									新疆维吾尔自治区
								</form:option>
								<form:option value='台湾省'>
									台湾省
								</form:option>
								<form:option value='香港特别行政区'>
									香港特别行政区
								</form:option>
								<form:option value='澳门特区'>
									澳门特区
								</form:option>
						</form:select>
		</td>
		<td  class="right">
			<fmt:message key="user.city"/><span class="required">*</span>:
		</td>
		<td class="left">
			<form:select path="city" id="city" onchange="changecity('county','city');" cssClass="text2">
				<option value=""><fmt:message key="common.pleaseselect"/></option>
			</form:select>
			
		</td>
	</tr>
	<tr class="hui" onmouseover="this.className='red'"
					onmouseout="this.className='hui'">
		<td class="first right">
			<fmt:message key="user.county"/>:
		</td>
		<td  class="left">
			<form:select path="county" id="county" cssClass="text2">
				<option value=""><fmt:message key="common.pleaseselect"/></option>
			</form:select>
		</td>
		<td  class="right">
			<fmt:message key="user.territory"/><span class="required">*</span>:
		</td>
		<td  class="left">
			<form:select path="territory" cssClass="text2">
			<option value=""><fmt:message key="common.pleaseselect"/></option>
			<c:forEach var="t" items="${territory}">
				<form:option value="${t.key}">${t.value}</form:option>
			</c:forEach>
			</form:select>
		</td>
		<td class="right">
			<fmt:message key="user.grade"/>
		</td>
		<td class="left">
			<form:select path="grade" cssClass="text2">
				<option value=""><fmt:message key="common.pleaseselect"/></option>
				<c:forEach var="g" items="${grade}">
					<form:option value="${g}">${g}</form:option>
				</c:forEach>
			</form:select>
		</td>
	</tr>
	<tr onmouseover="this.className='red'"
					onmouseout="this.className=''">
		<td class="right">
			<fmt:message key="user.ftphomedirectory"/>
		</td>
		<td class="left">
			<form:input path="ftphomedirectory" cssClass="text"/>
		</td>
		<td class="right">
			<fmt:message key="user.idletime"/>
		</td>
		<td class="left">
			<form:input path="idletime" cssClass="text"/>
		</td>
		<td class="right">
			<fmt:message key="user.uploadrate"/>
		</td>
		<td class="left">
			<form:input path="uploadrate" cssClass="text"/>
		</td>
	</tr>
	<tr class="hui" onmouseover="this.className='red'"
					onmouseout="this.className='hui'">
		<td class="right">
			<fmt:message key="user.downloadrate"/>
		</td>
		<td class="left">
			<form:input path="downloadrate" cssClass="text"/>
		</td>
		<td class="right">
			<fmt:message key="user.ftpport"/>
		</td>
		<td class="left">
			<form:input path="ftpport" cssClass="text"/>
		</td>
		<td class="right">
			<fmt:message key="user.ftpurl"/>
		</td>
		<td class="left">
			<form:input path="ftpurl" cssClass="text"/>
		</td>
	</tr>
	<tr onmouseover="this.className='red'"
					onmouseout="this.className=''">
		<td class="right">
			<fmt:message key="user.maxloginnumber"/>
		</td>
		<td class="left">
			<form:input path="maxloginnumber" cssClass="text"/>
		</td>
		<td class="right">
			<fmt:message key="user.maxloginperip"/>
		</td>
		<td class="left">
			<form:input path="maxloginperip" cssClass="text"/>
		</td>
		<shiro:hasPermission name="usertypeManage">
		<td class="right"><fmt:message key="user.usertype"/></td>
		<td class="left">
			<form:select path="usertype" cssClass="text2">
				<c:forEach var="u" items="${usertypemap}">
				<form:option value="${u.key}">${u.value}</form:option>
				</c:forEach>
			</form:select>
		</td>
		</shiro:hasPermission>
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

