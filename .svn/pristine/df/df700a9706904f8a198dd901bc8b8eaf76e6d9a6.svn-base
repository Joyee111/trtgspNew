<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
    <title>菜单列表</title>
    <link href="${ctx }/style/home.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/ext/styles/display/display.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/themes/default/easyui.css">
	<script type="text/javascript" src="${ctx}/js/easyui/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="<c:url value='/ext/scripts/display/displaypage.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/easyui/jquery.easyui.min.js'/>"></script>
    <script type="text/javascript">
    jQuery(function(){
    		jQuery("#displayallpage").val(${displayallpage});
    		jQuery("#tz").val(${thispage});
    	});
    </script>
	</head>
  <body>
    
    <div class="ceng_mar5">
    <div class="box_big">
    	<div id="zyzz_menu" class="" style="float: left; margin-bottom: 20px;">
    	<div style="padding-top: 20px;"><a href="<%=basePath %>firstEnterprise/enterpriseIframe.html">首营企业</a></div>
    	<div style="padding-top: 20px;"><a href="<%=basePath %>firstEnterprise/frame/hggys.html" >合格供应商</a></div>
    	<div style="padding-top: 20px;"><a href="<%=basePath %>firstEnterprise/frame/ghdwdlr.html" >购货单位</a></div>
    	<div style="padding-top: 20px;"><a href="<%=basePath %>firstEnterprise/frame/hgghdw.html" >合格购货单位</a></div>
    </div>
  	
  	<iframe src="frame/syqydlr.html" name="syqy_iframe" id="syqy_iframe" frameborder="0" border="0" marginheight="0"
					marginwidth="0" scrolling="no" width="80%" align="top"
					height="700px;">
  	
  	</iframe>
   
</div>
    </div>
    
  </body>
  
</html>
