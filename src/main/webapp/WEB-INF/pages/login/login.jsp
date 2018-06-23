<%@page contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
	String webRoot = request.getContextPath().length()>1? request.getContextPath():"";
%>
<html>
<head>
<title>同仁堂药品质量管理系统</title>
<script language="JavaScript">
delCookie("iframeSrc");

function juge()
{
if(form1.username.value=="")
{
alert("账号不能为空");
form1.username.focus();
return false;
}
if(form1.password.value=="")
{
  alert("密码不能为空");
  form1.password.focus();
  return false;
}
return true;
}

//测试用直接登录
function test(){
	form1.user_id.value="admin";
	form1.user_pwd.value="1";
	form1.submit();
}

function delCookie(name){//为了删除指定名称的cookie，可以将其过期时间设定为一个过去的时间
	 var date = new Date();
	 date.setTime(date.getTime() - 10000);
	 document.cookie = name + "=a; expires=" + date.toGMTString();
	 }
</script>
<link href="style/login.css" rel="stylesheet" type="text/css" />
</head>
<body onload="form1.username.focus()">

<center>
<form method="post"  name="form1"  onSubmit="return juge()" action="<%=request.getContextPath() %>/shirologin.html" >
<table width="100%" height="90%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
    	<div class="login"><div class="login_con">
        	<div class="table_box">
			<table border="0" cellspacing="0" cellpadding="0">
              <tr height="44">
                <th>用户名：</th>
                <td><input name="username" type="text" class="text" maxlength="20"/></td>
              </tr>
              <tr height="44">
                <th>密&nbsp;&nbsp;码：</th>
                <td><input name="password" type="password" class="text"/></td>
              </tr>
              <tr height="80">
                <th><font color="red" size="-1">${errorMessage}</font></th>
                <td align="left"><input name="" type="submit" class="btn_login" value="登录" onmousemove='document.getElementById("btn").className="current";document.execCommand("BackgroundImageCache", false, true);' onmouseout='document.getElementById("btn").className=""'/></td>
              </tr>
            </table>
            </div>
		</div></div>
		<div id="footer">京ICP备05021752号 互联网药品信息服务资格证书编号：(京)-非经营性-2009-0013</div>
    </td>
  </tr>
</table>
</form>
</center>

</body>
</html>
