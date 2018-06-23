<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<%@ include file="/common/meta.jsp"%>
		<title><decorator:title/></title>

		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/ext/styles/display/display.css'/>"/>
		<script type="text/javascript" src="${ctx}/js/easyui/jquery-1.8.0.min.js"></script>
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
			
		/* ajax 查询做菜单暂时没有考虑清楚注释掉  需要时通取消注释	$(function() { 
				loadLeftMenu();
			})*/
		</script>
	</head>
	<body>
	<div class="ie6-out">
	<div class="ie6-in">
		<div id="min-width">
			<div id="bg">
				<div id="outside">
					<div id="main">
						<div id="top">
							<!-- 系统管理start -->
							<jsp:include page="/common/menu.jsp"/>
							<!-- 系统管理end -->
							<div class="yj">
								<div id="Control">
									<c:if test="${username!=''}"><span class="username"><shiro:principal/></span></c:if>&nbsp;&nbsp;&nbsp;&nbsp;
									<!-- 
									<shiro:authenticated>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${ctx}/slogout.html">退出</a></shiro:authenticated>
									 -->
									<a href="javascript:slogout();">退出</a>
								</div>
							</div>
							<div id="nav1">
								<div id="nav12"></div>
							</div>
						</div>

						<ul id="parent">
							<jsp:include page="../common/leftMenu.jsp"></jsp:include>
						</ul>

						<div id="contentBG">
							<%@ include file="/common/messages.jsp" %>
					                <h1><decorator:getProperty property="meta.heading"/></h1>
					                <decorator:body/>
						</div>

						<div id="boundWin">
							<div id="WinBiao">
								<div id="WinBiaoR">
									
								</div>
							</div>
							<div id="WinContentOut">
								<div id="WinContentIn">
									<iframe id="deptQueryWin" src="" width="580px" height="400px"
										style="border: 0;"></iframe>
								</div>
							</div>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>
	</div>
	</body>
</html>
