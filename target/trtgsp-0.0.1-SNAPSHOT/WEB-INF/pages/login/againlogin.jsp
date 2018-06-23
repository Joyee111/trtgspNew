<%@ include file="/common/taglibs.jsp"%>
<head>
	<title><fmt:message key="login.title" /></title>
</head>
<div style="background:#ffffff;height:600px;">
<form method="post" id="loginForm" name="myform"
						action="<c:url value='shirologin.html'/>"
						onsubmit="return validata();">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="login_table">
  <tr height="150px"></tr>
  <tr>
    <td>
    	<div class="login">
        	<div class="top"><div class="top_r"><div class="top_bg"></div></div></div>
            <div class="login_con">
            	<table width="245" border="0" cellspacing="0" cellpadding="0">
                  <tr height="25"></tr>
                  <tr height="32">
                    <td><img src="${ctx}/ext/images/yhm.gif" /></td>
                    <td align="right"><fmt:message key="user.username" />:</td>
                    <td><input type="text" class="text" name="username" size="17" id="username" tabindex="1"/></td>
                  </tr>
                  <tr height="32">
                    <td><img src="${ctx}/ext/images/yhm.gif" /></td>
                    <td align="right"><fmt:message key="user.password" />:</td>
                    <td><input type="password" name="password" class="text" size="17" id="password" tabindex="2"/></td>
                  </tr>
                  <tr height="70">
                    <td colspan="3" align="center"><input name="" type="submit" class="btn_denglu" value=""/><input name="" type="button" class="btn_zhuce" onclick="location.href='<c:url value="/register/register.html"/>'"/></td>
                  </tr>
                </table>
            </div>
        	<div class="di"><div class="di_r"><div class="di_bg"></div></div></div>
        </div>
    </td>
  </tr>
</table>
</form>
</div>