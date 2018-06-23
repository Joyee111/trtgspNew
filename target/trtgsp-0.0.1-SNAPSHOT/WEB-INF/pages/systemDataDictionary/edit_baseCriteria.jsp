<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>质量标准依据修改</title>
</head>
<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">系统管理&nbsp;>&nbsp;数据字典&nbsp;>&nbsp;质量标准依据修改</font>
	<form action="ajaxUpdateBaseCriterias.html" name="edit_baseCriteria" id="edit_baseCriteria" method="post" >
        <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
          <tr>
            <th width="150">质量标准依据名称：</th>
            <td><input name="basedCriteriaName" type="text" value="${criteria.basedCriteriaName}" class="easyui-validatebox text1" data-options="required:true" size="40" /></td>
          </tr>
         
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
            	<input type="hidden" name="id" value="${criteria.basedCriteriaId}">
                <input name="" type="button" class="btn_big" value="保存" onclick="update_baseCriteria()"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	<script type="text/javascript">
		function update_baseCriteria(){
		  $('#edit_baseCriteria').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI(json.success));
				}
				location.href="baseCriterias.html";
			    }  
			});  
		}
	</script>
</body>
</html>