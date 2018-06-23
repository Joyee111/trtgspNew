<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>菜单配置</title>
    
	<link rel="stylesheet" type="text/css" href="${ctx}/style/contentRight.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/themes/default/easyui.css">
	<script type="text/javascript" src="${ctx}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		 $(function() { 
			$('#typeTree').tree({
				url:'${ctx}/menuManage/frame/menuTree.html',
				onBeforeExpand:function(node){
					$('#typeTree').tree('options').url = '${ctx}/menuManage/frame/menuTree.html?parentId='+node.id;
				},
				onSelect:function(node){
					$('#ifra_main').attr('src','${ctx}/menuManage/frame/menuConfigList.html?menuId='+node.id);
				}
			})
		});
	</script>
  </head>
  
  <body>
    <table border="1" cellpadding="" cellspacing="0" height="100%"
		width="100%" bgcolor="#fff8ec" bordercolor="#FFFFFF">
		<tr>
			<td id="left" width="20%" valign="top" bgcolor="#fff8ec">
				<div style="overflow: auto; width: 100%; height: 480px;">
					<div id="typeTree"></div>
				</div>
			</td>
			<td width="80%" style="text-align: center" valign="top" bgcolor="#fff8ec" height="580px" id="tdFrame">
			
				<iframe id="ifra_main" frameborder="0" marginheight="0"
					marginwidth="5" scrolling="auto" width="100%" align="top"
					height="100%" src="${ctx}/menuManage/frame/menuConfigList.html"></iframe>
			</td>
		</tr>
	</table>
  </body>
</html>

