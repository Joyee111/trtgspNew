<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff"%>
<%@page import="com.sinosoft.util.StringUtil"%>
<%@ include file="/common/taglibs.jsp"%><head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ProcurementStaff proStaff = (ProcurementStaff)request.getAttribute("procurementStaff");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改合格采购人员/提货人员</title>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;合格采购人员/提货人员&nbsp;>&nbsp;合格采购人员/提货人员修改</font>
<form action="update_hgcgry.html" name="edit_hgcgry" id="edit_hgcgry" method="post" enctype="multipart/form-data"> 
      <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
          <tr>
            <th width="150">姓名<span class="required">*</span>：</th>
            <td><input name="saleName" value="${procurementStaff.procurementName }" type="text" class="text1" readonly="readonly" size="40" onblur="ajaxChanggeChinaToPinyin(this,'pinyinCode')"/></td>
            <th width="150">性别<span class="required">*</span>：</th>
           <td>
            <c:if test="${procurementStaff.gender=='0'}">
            	 <input name="gender1" type="text" class="text1" value="男" size="40" maxlength="20" readonly="readonly"/>
            	 <input type="hidden" name="gender" value="0">
            </c:if>
             <c:if test="${procurementStaff.gender=='1'}">
            	<input name="gender1" type="text" class="text1" value="女" size="40" maxlength="20" readonly="readonly"/>
            	<input type="hidden" name="gender" value="1">
            </c:if>
             <c:if test="${procurementStaff.gender=='2'}">
            	<input name="gender1" type="text" class="text1" value="未知" size="40" maxlength="20" readonly="readonly"/>
            	<input type="hidden" name="gender" value="2">
            </c:if>
            </td>
          </tr>
          <tr>
            <th>拼音码<span class="required">*</span>：</th>
            <td><input name="pinyinCode" value="${procurementStaff.pinyinCode }" type="text" class="text1" readonly="readonly" size="40"/></td>
            <th>身份证号<span class="required">*</span>：</th>
            <td><input name="IDNumber" value="${procurementStaff.IDNumber }" type="text" class="text1" readonly="readonly" size="40"/></td>
          </tr>
           
          <tr>
            <th>法人委托书：</th>
            <% if(StringUtil.isNull(proStaff.getPowerOfAttorneyPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${procurementStaff.powerOfAttorneyPath}"><%="法人委托书"+StringUtil.fileExtensions(proStaff.getPowerOfAttorneyPath())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${procurementStaff.id}','${procurementStaff.powerOfAttorneyPath}','frwts')"/>
           </td>
           <%}else{ %>
             <td><input name="powerOfAttorneyPath" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
           
            <th>法人委托书到期日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="powerOfAttorneyDate" value="${procurementStaff.powerOfAttorneyDate}" class="easyui-datebox text1" data-options="required:false,validType:'date'"  style="height: 28px;" size="40"/>
            </td>
          </tr>
          <tr>
            <th>身份证复印件：</th>
            <% if(StringUtil.isNull(proStaff.getIdentityCardPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${procurementStaff.identityCardPath}"><%="身份证复印件"+StringUtil.fileExtensions(proStaff.getIdentityCardPath())%></a>
                <input name="identityCardPath" type="button" class="btn_small" value="删除" onclick="deleteFile('${procurementStaff.id}','${procurementStaff.identityCardPath}','sfzfyj')"/>
           </td>
           <%}else{ %>
             <td><input name="identityCardPath" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
            <th>身份证有效期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="identityCardDate" value="${procurementStaff.identityCardDate}" class="easyui-datebox text1" data-options="required:false,validType:'date'" style="height: 28px;"   size="40"/>
            </td>
          </tr>
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
                <input type="hidden" id="id" name="id" value="${procurementStaff.id}"/>
                <input type="hidden" name="reason" id="reason" value=""/>
                <input name="" type="button" class="btn_big" value="保存" onclick="$('#dialog').dialog('open')"/>
                <input name="" type="button" class="btn_big" value="返回" onclick="goBack()"/>
            </td>
          <td>
      </table>
      <div id="dialog" title="修改原因" class="easyui-dialog" style="width:800px;height:300px;padding:20px; margin-top: 20px;"  data-options="closed:true,modal:false,top:200">
    	<table>
    	<tr>
            <th valign="top">修改原因：</th>
            <td colspan="3"><textarea name="rejectcause" id="rejectcause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true" ></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
           	<input type="button" class="btn_big" onclick="updata_hgcgry()" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
       </div>
    </form>    
  <script type="text/javascript">
    function updata_hgcgry(){
        var dialog = $("#dialog").dialog();
        var dialogvalue = dialog.get(0).getElementsByTagName("textarea")[0].value;
        $("#reason").val(dialogvalue);
	
	    $('#edit_hgcgry').form('submit',{  
		    success: function(data){  
			  var json = jsonParse(data);
			  if(json.success!=null && json.success!=""){
				 alert(decodeURI( json.success));
			  }
			  location.href="hgcgry.html";
		   }  
		});  
     }
	   
        function deleteFile(id,fileName,type){
			$.post("delteQualifiedProcurementStaffAttachment.html",{
				id : id,
				fileName : fileName,
				type : type
			},function(data){
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.reload();
			});
		}
    </script>
</body>
</html>