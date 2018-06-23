<%@ page language="java"
    pageEncoding="UTF-8"%>
<%@page import="com.sinosoft.enterpriseManage.firstEnterprise.model.OurQualityManagement"%>
<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sinosoft.util.StringUtil"%>
    <%@ include file="/common/taglibs.jsp"%><head>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
OurQualityManagement ourQualityManagement = (OurQualityManagement)request.getAttribute("ourQualityManagement");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>公司修改</title>
</head>
<body>
<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;公司资质管理&nbsp;>&nbsp;公司修改</font>
<form action="update_wgszzglxg.html" name="edit_wgszz" id="edit_wgszz" method="post" enctype="multipart/form-data"> 
      <table border="0" cellspacing="0" cellpadding="0" class="xx_table">
      <tr>
        	<th>公司名称：</th>
        	<td>
        	  <input type="text" class="text1" value="${ourQualityManagement.customer_name}" id="customerName" name="customerName" size="40" />
        	</td>
            <th width="150">法定代表人：</th>
            <td>
              <input id="legalRepresentative" name="legalRepresentative" type="text" value="${ourQualityManagement.legalRepresentative}" class="easyui-validatebox text1" data-options="required:true" size="40"/>
            </td>
        </tr>
          <tr>
          	<th>企业地址：</th>
          	<td><input type="text" class="text1" size="40" value="${ourQualityManagement.address}" name="address" id="address"/></td>
          	<th>质量负责人：</th>
            <td><input type="text" name="qualityPrincipal" value="${ourQualityManagement.qualityPrincipal}" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
          </tr>
          <tr>
            <th valign="top">生产/经营范围：</th>
            <td colspan="3"><textarea name="businessScope" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true">${ourQualityManagement.businessScope }</textarea></td>
          </tr>
          </table>
          <table border="0" cellspacing="0" cellpadding="0" class="xx_table2">
          <tr>
            <th>营业执照：</th>
            <% if(StringUtil.isNull(ourQualityManagement.getBusinessLicencePath())){ //如果营业执照不为空%>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${ourQualityManagement.businessLicencePath}"><%="营业执照"+StringUtil.fileExtensions(ourQualityManagement.getBusinessLicencePath())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${ourQualityManagement.id}','${ourQualityManagement.businessLicencePath }','yyzz')"/>
           </td>
           <%}else{ %>
             <td><input name="businessLicencePath" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
           
           <th>营业执照到期时间：</th>
           <td>
                <input type="text" value="${ourQualityManagement.businessLicenceDate}" name="businessLicenceDate" id="businessLicenceDate" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
          </tr>
          
          <tr>
            <th>经营许可证：</th>
            <% if(StringUtil.isNull(ourQualityManagement.getBusinessPermitPath())){ //如果营业执照不为空%>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${ourQualityManagement.businessPermitPath}"><%="经营许可证"+StringUtil.fileExtensions(ourQualityManagement.getBusinessPermitPath())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${ourQualityManagement.id}','${ourQualityManagement.businessPermitPath }','jyxkz')"/>
           </td>
           <%}else{ %>
             <td><input name="businessPermitPath" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
           
           <th>经营许可证到期时间：</th>
           <td>
                <input type="text" value="${ourQualityManagement.businessPermitDate}" name="businessPermitDate" id="businessPermitDate" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
          </tr>
          
          
          <tr>
            <th>GSP/GSM：</th>
            <% if(StringUtil.isNull(ourQualityManagement.getGspCertificatePath())){ //如果营业执照不为空%>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${ourQualityManagement.gspCertificatePath}"><%="GSP/GSM"+StringUtil.fileExtensions(ourQualityManagement.getGspCertificatePath())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${ourQualityManagement.id}','${ourQualityManagement.gspCertificatePath }','gspzs')"/>
           </td>
           <%}else{ %>
             <td><input name="gspCertificatePath" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
           
           <th>GSP/GSM到期时间：</th>
           <td>
                <input type="text" value="${ourQualityManagement.gspCertificateDate}" name="gspCertificateDate" id="gspCertificateDate" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
          </tr>
          
          
          <tr>
            <th>组织机构代码证：</th>
            <% if(StringUtil.isNull(ourQualityManagement.getOrganizationCodePath())){ //如果营业执照不为空%>
           <td>
           		<img src="../images/pdf.gif" />
            	<a href="../download.html?fileName=${ourQualityManagement.organizationCodePath}"><%="组织机构代码证"+StringUtil.fileExtensions(ourQualityManagement.getOrganizationCodePath())%></a>
                <input name="" type="button" class="btn_small" value="删除" onclick="deleteFile('${ourQualityManagement.id}','${ourQualityManagement.organizationCodePath }','zzjgdm')"/>
           </td>
           <%}else{ %>
             <td><input name="organizationCodePath" type="file" class="easyui-validatebox text1" size="40" /></td>
           <%} %>
           
           <th>组织机构代码证到期时间：</th>
           <td>
                <input type="text" value="${ourQualityManagement.organizationCodeDate}" name="organizationCodeDate" id="organizationCodeDate" class="easyui-datebox" data-options="required:true,validType:'date'" size="40"/>
           </td>
          </tr>
          
          <tr>
            <td colspan="4" align="center" valign="bottom">
            	<input type="hidden" id="id" name="id" value="${ourQualityManagement.id}"/>
            	<input type="hidden" name="reason" id="reason" value=""/>
                <input name="" type="button" class="btn_big" value="保存" onclick="$('#dialog').dialog('open')"/>
                <input name="" type="button" class="btn_big" value="返回" onclick="goBack()"/>
            </td>
          </tr>
          
        </table>
		
		<div id="dialog" title="修改原因" class="easyui-dialog" style="width:800px;height:300px;padding:10px; margin-top: 20px;"  data-options="closed:true,modal:false,top:100">
    	<table>
    	<tr>
            <th valign="top">修改原因：</th>
            <td colspan="3"><textarea name="rejectcause" id="rejectcause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true" ></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center" valign="bottom">
           	<input type="button" class="btn_big" onclick="updata_gszz()" value="确定">
           	<input type="button" class="btn_big" onclick="$('#dialog').dialog('close')" value="取消">
			</td>
		</tr>
		</table>
       </div>
       
       
    </form>
    
  <script type="text/javascript">
  	function return_back(){
    		window.location.href="wgszzgl.html"
    }
    function updata_gszz(){
    var dialog = $("#dialog").dialog();
    var dialogvalue = dialog.get(0).getElementsByTagName("textarea")[0].value;
    $("#reason").val(dialogvalue);
	  $('#edit_wgszz').form('submit',{  
		    success: function(data){  
			var json = jsonParse(data);
			if(json.success!=null && json.success!=""){
				alert(decodeURI( json.success));
			}
			location.href="wgszzgl.html";
		    }  
		}); 
	}
	function deleteFile(id,fileName,type){
			$.post("deleteOurQualityManagementAttachment.html",{
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