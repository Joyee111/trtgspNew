<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff"%>
<%@page import="com.sinosoft.util.StringUtil"%>
<%@ include file="/common/taglibs.jsp"%><head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SalesStaff sales = (SalesStaff)request.getAttribute("salesStaff");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改合格供货商销售人员</title>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;合格供货商销售人员&nbsp;>&nbsp;合格供货单位销售人员修改</font>
<form action="update_hgxsry.html" name="edit_hgxsry" id="edit_hgxsry" method="post" enctype="multipart/form-data"> 
      <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
          <tr>
            <th width="150">姓名<span class="required">*</span>：</th>
            <td><input name="saleName" value="${salesStaff.saleName }" type="text" class="text1" readonly="readonly" size="40" onblur="ajaxChanggeChinaToPinyin(this,'pinyinCode')"/></td>
            <th width="150">性别<span class="required">*</span>：</th>
           <td>
            <c:if test="${salesStaff.gender=='0'}">
            	 <input name="gender1" type="text" class="text1" value="男" size="40" maxlength="20" readonly="readonly"/>
            	 <input type="hidden" name="gender" value="0">
            </c:if>
             <c:if test="${salesStaff.gender=='1'}">
            	<input name="gender1" type="text" class="text1" value="女" size="40" maxlength="20" readonly="readonly"/>
            	<input type="hidden" name="gender" value="1">
            </c:if>
             <c:if test="${salesStaff.gender=='2'}">
            	<input name="gender1" type="text" class="text1" value="未知" size="40" maxlength="20" readonly="readonly"/>
            	<input type="hidden" name="gender" value="2">
            </c:if>
            </td>
          </tr>
          <tr>
            <th>拼音码<span class="required">*</span>：</th>
            <td><input name="pinyinCode" value="${salesStaff.pinyinCode }" type="text" class="text1" readonly="readonly" size="40"/></td>
            <th>身份证号<span class="required">*</span>：</th>
            <td><input name="IDNumber" value="${salesStaff.IDNumber }" type="text" class="text1" readonly="readonly" size="40"/></td>
          </tr>
           <tr>
          	<th>联系电话<span class="required">*</span>:</th>
          	<td><input type="text" name="telephone" value="${salesStaff.telephone}" id="telephone" class="text1" size="40"/></td>
          </tr>
         
          <tr>
            <th>法人委托书：</th>
            <% if(StringUtil.isNull(sales.getPowerOfAttorneyPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${salesStaff.powerOfAttorneyPath}"><%="法人委托书"+StringUtil.fileExtensions(sales.getPowerOfAttorneyPath())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${salesStaff.id}','${salesStaff.powerOfAttorneyPath}','frwts')"/>
           </td>
           <%}else{ %>
             <td><input name="powerOfAttorneyPath" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
           
            <th>法人委托书到期日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="powerOfAttorneyDate" value="${salesStaff.powerOfAttorneyDate}" class="easyui-datebox text1" data-options="required:false,validType:'date'"  style="height: 28px;" size="40"/>
            </td>
          </tr>
          <tr>
            <th>身份证复印件：</th>
            <% if(StringUtil.isNull(sales.getIdentityCardPath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${salesStaff.identityCardPath}"><%="身份证复印件"+StringUtil.fileExtensions(sales.getIdentityCardPath())%></a>
                <input name="identityCardPath" type="button" class="btn_small" value="删除" onclick="deleteFile('${salesStaff.id}','${salesStaff.identityCardPath}','sfzfyj')"/>
           </td>
           <%}else{ %>
             <td><input name="identityCardPath" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
            <th>身份证有效期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="identityCardDate" value="${salesStaff.identityCardDate}" class="easyui-datebox text1" data-options="required:false,validType:'date'" style="height: 28px;"   size="40"/>
            </td>
          </tr>
          <tr>
            <th>药品推销员证书：</th>
              <% if(StringUtil.isNull(sales.getTrainingCertificatePath())){ %>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${salesStaff.trainingCertificatePath}"><%="药品推销员证书"+StringUtil.fileExtensions(sales.getTrainingCertificatePath())%></a>
            	<input name="trainingCertificatePath" type="button" class="btn_small" value="删除" onclick="deleteFile('${salesStaff.id}','${salesStaff.trainingCertificatePath}','yptxyzs')"/>
           </td>
           <%}else{ %>
           <td><input name="trainingCertificatePath" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
           <th>药品推销员证书有效期<span class="required">*</span>：</th>
           <td>
            <input type="text" name="trainingCertificateDate" value="${salesStaff.trainingCertificateDate}"  class="easyui-datebox text1" data-options="required:false,validType:'date'" style="height: 28px;"   size="40"/>
           </td>
          </tr>
           <tr height="80">
            <td colspan="4" align="center" valign="bottom">
                <input type="hidden" id="id" name="id" value="${salesStaff.id}"/>
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
           	<input type="button" class="btn_big" onclick="updata_hgxsry()" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
       </div>
    </form>    
  <script type="text/javascript">
    function updata_hgxsry(){
        var dialog = $("#dialog").dialog();
        var dialogvalue = dialog.get(0).getElementsByTagName("textarea")[0].value;
        $("#reason").val(dialogvalue);
	
	    $('#edit_hgxsry').form('submit',{  
		    success: function(data){  
			  var json = jsonParse(data);
			  if(json.success!=null && json.success!=""){
				 alert(decodeURI( json.success));
			  }
			  location.href="hgxsry.html";
		   }  
		});  
     }
	   
        function deleteFile(id,fileName,type){
			$.post("delteQualifiedSaleStaffAttachment.html",{
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