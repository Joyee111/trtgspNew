<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/common/meta.jsp"%>
		<title><decorator:title/></title>
		<link href="${ctx }/style/home.css" rel="stylesheet" type="text/css" />
		<link href="${ctx }/js/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<link href="${ctx }/ext/styles/display/display.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx}/js/common.js"></script>
		<script type="text/javascript" src="${ctx}/js/ChinesePY.js"></script>
		<script type="text/javascript" src="${ctx}/js/easyui/jquery-1.8.0.min.js" ></script>
		<script type="text/javascript" src="${ctx}/js/easyui/jquery.easyui.min.js" ></script>
		<script type="text/javascript" src="${ctx}/js/easyui/extend-validate.js" ></script>
		<script type="text/javascript" src="${ctx}/js/easyui/easyui-lang-zh_CN.js" ></script>
		<script type="text/javascript" src="${ctx}/ext/scripts/display/displaypage.js"></script>
		<script type="text/javascript" src="${ctx}/js/jsoneval.js" ></script>
		<script type="text/javascript" src="${ctx}/js/jqueryprintarea.js" ></script>
		<decorator:head />
		<script type="text/javascript">
			function displaySubMenu(li) {//实现导航子菜单的显示与隐藏
				var subMenu = li.getElementsByTagName("ul")[0];
				subMenu.style.display = "block";
				subMenu.previousSibling.className = "on";
			}
			function hideSubMenu(li) {
				var subMenu = li.getElementsByTagName("ul")[0];
				subMenu.style.display = "none";
				subMenu.previousSibling.className = "";
			}
						
			function loadLeftMenu(){
				var dateStr = Date.parse(new Date());
				$.ajax({
				  url: '${ctx}/menuManage/frame/showLeftMenu.html?dateStr='+dateStr,
				  dataType: 'text',
				  data:{
					 
				  },
				  success: function(data,textStatus, jqXHR){
					  $("#parent").html(data);
				  },
				  error: function(data,textStatus, jqXHR){
					  alert('菜单加载失败！');
				  },
				  async: false
				});
			}
			
		    function slogout(){
		    	var flag = confirm('确定要退出当前系统？');
		    	if(flag){
		    		location.href='${ctx}/slogout.html';
		    	}
		    }
		jQuery(function(){
		jQuery("#displayallpage").val(${displayallpage});
		jQuery("#tz").val(${thispage});
	});
	function viewUserInfo(){
		var  userId = ">${localuser.id}";
		alert(userId);
		$.post("user/ajaxQueryUser.html",{
			userId : userId
		},function (data){
			var json = jsonParse(data);
			var userName = json.username;
			var reanName = json.realname;
			
		})
	}
	function openDialog(){
		$("#dialog_defalult").dialog("open");
	}
	function ajaxChangPassword(){
		var pwd = $("#user_password").val();
		var compwd = $("#user_comfirmpwd").val();
		if(typeof(pwd)==undefined || pwd==""){
			alert("新密码不能为空,请输入新密码");
			$("#user_password").focus();
			return;
		}
		if(typeof(pwd)==undefined || pwd==""){
			alert("确认密码不能空，请输入确认密码");
			$("#user_comfirmpwd").focus();
			return;
		}
		if(pwd!=compwd){
			alert("新密码与确认密码不一致，请重新输入");
			$("#user_comfirmpwd").focus();
			return;
		}
		$('#changpwdfrom').form('submit',{  
			    success: function(data){  
			//  alert(data);
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				$("#dialog_defalult").dialog("close");
			    }  
			});  
		//from.action="user/ajaxChangeUserPassowd.html";
	}
	
	function checkPassword(){
		var pwd = $("#user_password").val();
		var compwd = $("#user_comfirmpwd").val();
		if(typeof(pwd)==undefined || pwd==""){
			alert("新密码不能为空,请输入新密码");
			$("#user_password").focus();
			return;
		}
		if(typeof(pwd)==undefined || pwd==""){
			alert("确认密码不能空，请输入确认密码");
			$("#user_comfirmpwd").focus();
			return;
		}
		if(pwd!=compwd){
			alert("新密码与确认密码不一致，请重新输入");
			$("#user_comfirmpwd").focus();
			return;
		}
	}
	function updateContent(){
		$.post("/trtgsp/homePage/updateContents.html",function(date){
			//alert(date);
			$("#updateContent_p").append(decodeURI(date));
			$("#dialog_updateContent").dialog("open");
		})
	}
	function down_handbook(){
		var url = encodeURI('/trtgsp/download.html?fileName=updateContent/同仁堂药品经营质量管理系统操作手册v1.0.rar');
		window.location.href=url;
	}
		/* ajax 查询做菜单暂时没有考虑清楚注释掉  需要时通取消注释	$(function() { 
				loadLeftMenu();
			})*/
		</script>
	</head>
	<body>
	<div id="main">
    <div id="top">
        <div class="top_con">
        	<c:if test="${username!=''}"><span>${localuser.realname }</span></c:if>┊<a href="javascript:down_handbook()">用户手册下载</a> ┊ <a href="javascript:updateContent()">版本更新内容</a> ┊<a href="javascript:openDialog()">修改密码</a> ┊ <a href="javascript:slogout();">退出</a>
        	<!--<c:if test="${username!=''}"><span>${localuser.realname }</span></c:if>┊ <a href="javascript:slogout();">退出</a>-->
        </div>
        <div id="dialog_defalult" title="修改密码" class="easyui-dialog" style="width:600px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:true,top:200">
        <form id="changpwdfrom" name="" action="user/ajaxChangeUserPassowd.html" method="post">
    	<table border="0" cellspacing="0" cellpadding="0" class="">
    	<tr>
            <th style="font-weight:bold; font-size:12px; color:#727171; text-align:right; line-height:26px;">登录名：</th>
            <td style="padding: 5px,0"><input type="text" name="userName" value="${localuser.username}" readonly="readonly"  /> </td>
		</tr>
		<tr>
            <th style="font-weight:bold; font-size:12px; color:#727171; text-align:right; line-height:26px;">真实姓名：</th>
            <td style="padding: 5px,0"><input type="text" name="realname" value="${localuser.realname}" readonly="readonly" /> </td>
		</tr>
		<tr>
            <th style="font-weight:bold; font-size:12px; color:#727171; text-align:right; line-height:26px;">新密码：</th>
            <td style="padding: 5px,0"><input type="password"  name="password" id="user_password" value="" /> </td>
		</tr>
		<tr>
            <th style="font-weight:bold; font-size:12px; color:#727171; text-align:right; line-height:26px;">确认密码：</th>
            <td style="padding: 5px,0"><input type="password" name="passwordConfirm" id="user_comfirmpwd" value="" onblur="checkPassword()" /> </td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom" style="padding: 5px,0">
			<input type="hidden" id="save_type2" name="save_type" value=""/>
			<input type="hidden" id="userId" name="userId" value="${localuser.id}"/>
           	<input type="button" class="btn_big" onclick="ajaxChangPassword()" value="确定"/>
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消"/>
			</td>
		</tr>
		</table>
		</form>
        </div>
         <div id="dialog_updateContent" title="版本更新内容" class="easyui-dialog" style="width:600px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:true,top:200">
         	<p id="updateContent_p" class="block_con3"> </p>
         </div>
    </div>
    <%@ include file="/common/leftMenu.jsp"%>
	<div id="home">
    <%@ include file="/common/messages.jsp" %>
	<h1><decorator:getProperty property="meta.heading"/></h1>
	<decorator:body/>
    </div>
	<div class="dadi"></div>
	</div>
	</body>
</html>
