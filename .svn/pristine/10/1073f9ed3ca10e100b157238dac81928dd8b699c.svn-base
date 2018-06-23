<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>有效期预警设置</title>
</head>
<body>
		<form action="saveWarnConfig.html" name="save_warnconfig" id="save_warnconfig" >
        <table border="0" cellspacing="0" cellpadding="0" class="xx_table"> 
        <tr>
        	<th>供应商资质预警设置</th>
        </tr> 
          <tr>
            <th width="150">营业执照到期时间<span class="required">*</span>：</th>
            <td>
            <input type="hidden" name="warnConfig[0].limit_name" value="gys_businessLicense_ExpirationDate">
            <input name="warnConfig[0].limit_day" type="text" class="easyui-validatebox text1" value="${gys_businessLicense_ExpirationDate.limit_day}" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[0].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[0].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr style="display: none;"> 
            <th width="150">营业执照年检时间<span class="required">*</span>：</th>
            <td>
            <input type="hidden" name="warnConfig[1].limit_name" value="gys_businessLicense_annualSurvey">
            <input name="warnConfig[1].limit_day" type="text" class="easyui-validatebox text1" value="${gys_businessLicense_annualSurvey.limit_day }"  size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[1].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name=warnConfig[1].use_flag value="1" checked="checked"/></td>
          </tr>
           <tr>
            <th width="150">经营/生产许可证到期时间<span class="required">*</span>：</th>
            <td>
            <input type="hidden" name="warnConfig[2].limit_name" value="gys_licence_ExpirationDate">
            <input name="warnConfig[2].limit_day" type="text" class="easyui-validatebox text1" value="${gys_licence_ExpirationDate.limit_day }"  size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[2].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[2].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr>
            <th width="150">GSP/GMP到期日<span class="required">*</span>：</th>
            <td>
            <input type="hidden" name="warnConfig[3].limit_name" value="gys_GPS_ExpirationDate">
            <input name="warnConfig[3].limit_day" type="text" class="easyui-validatebox text1" value="${gys_GPS_ExpirationDate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[3].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[3].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr>
            <th width="150">组织机构代码到期时间<span class="required">*</span>：</th>
            <td>
            <input type="hidden" name="warnConfig[4].limit_name" value="gys_organizationCodeDate">
            <input name="warnConfig[4].limit_day" type="text" class="easyui-validatebox text1" value="${gys_organizationCodeDate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[4].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[4].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr>
            <th width="150">组织机构代码年检时间<span class="required">*</span>：</th>
            <td>
            <input type="hidden" name="warnConfig[5].limit_name" value="gys_organizationCodeInspectionDate">
            <input name="warnConfig[5].limit_day" type="text" class="easyui-validatebox text1" value="${gys_organizationCodeInspectionDate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[5].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[5].use_flag" value="1" checked="checked"/></td>
          </tr>
           <tr>
            <th width="150">质量保证协议<span class="required">*</span>：</th>
            <td>
             <input type="hidden" name="warnConfig[6].limit_name" value="gys_qualityAssuranceDate">
            <input name="warnConfig[6].limit_day" type="text" class="easyui-validatebox text1" value="${gys_qualityAssuranceDate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[6].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[6].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr>
            <th width="150">法人委托书到期时间<span class="required">*</span>：</th>
            <td>
             <input type="hidden" name="warnConfig[7].limit_name" value="gys_authorizationDate">
            <input name="warnConfig[7].limit_day" type="text" class="easyui-validatebox text1" value="${gys_authorizationDate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[7].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[7].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr>
            <th width="150">销售人员身份证有效期<span class="required">*</span>：</th>
            <td>
             <input type="hidden" name="warnConfig[21].limit_name" value="gys_authorizationDate">
            <input name="warnConfig[21].limit_day" type="text" class="easyui-validatebox text1" value="${gys_authorizationDate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[21].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[21].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr>
            <th width="150">药品推销员培训证书有效期<span class="required">*</span>：</th>
            <td>
             <input type="hidden" name="warnConfig[22].limit_name" value="gys_authorizationDate">
            <input name="warnConfig[22].limit_day" type="text" class="easyui-validatebox text1" value="${gys_authorizationDate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[22].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[22].use_flag" value="1" checked="checked"/></td>
          </tr>
          <!-- 
          <tr>
            <th width="150">认证证书到期日<span class="required">*</span>：</th>
            <td><input name="gys_litterae_credentiales_date" type="text" class="easyui-validatebox text1" value="${gys_litterae_credentiales_date.limit_day }"  size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="litterae_credentiales_date_gys" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="litterae_credentiales_date_gys" value="1" checked="checked"/></td>
          </tr>
          <tr>
            <th width="150">开户信息到期日<span class="required">*</span>：</th>
            <td><input name="gys_account_date" type="text" class="easyui-validatebox text1" value="${gys_account_date.limit_day }"  size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="account_date_gys" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="account_date_gys" value="1" checked="checked"/></td>
          </tr> -->
     	 <tr>
        	<th class>购货单位资质预警设置</th>
        </tr> 
        <tr>
            <th width="150">营业执照到期时间<span class="required">*</span>：</th>
            <td>
             <input type="hidden" name="warnConfig[8].limit_name" value="ghs_businessLicense_ExpirationDate">
            <input name="warnConfig[8].limit_day" type="text" class="easyui-validatebox text1" value="${ghs_businessLicense_ExpirationDate.limit_day}" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[8].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[8].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr style="display: none;">
            <th width="150">营业执照年检时间<span class="required">*</span>：</th>
            <td>
             <input type="hidden" name="warnConfig[9].limit_name" value="ghs_businessLicense_annualSurvey">
            <input name="warnConfig[9].limit_day" type="text" class="easyui-validatebox text1" value="${ghs_businessLicense_annualSurvey.limit_day }"  size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[9].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[9].use_flag" value="1" checked="checked"/></td>
          </tr>
           <tr>
            <th width="150">经营/生产许可证到期时间<span class="required">*</span>：</th>
            <td>
             <input type="hidden" name="warnConfig[10].limit_name" value="ghs_licence_ExpirationDate">
            <input name="warnConfig[10].limit_day" type="text" class="easyui-validatebox text1" value="${ghs_licence_ExpirationDate.limit_day }"  size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[10].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[10].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr>
            <th width="150">GSP/GMP到期日<span class="required">*</span>：</th>
            <td>
              <input type="hidden" name="warnConfig[11].limit_name" value="ghs_GPS_ExpirationDate">
            <input name="warnConfig[11].limit_day" type="text" class="easyui-validatebox text1" value="${ghs_GPS_ExpirationDate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[11].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[11].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr>
            <th width="150">组织机构代码到期时间<span class="required">*</span>：</th>
            <td>
             <input type="hidden" name="warnConfig[12].limit_name" value="ghs_organizationCodeDate">
            <input name="warnConfig[12].limit_day" type="text" class="easyui-validatebox text1" value="${ghs_organizationCodeDate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[12].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[12].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr>
            <th width="150">组织机构代码年检时间<span class="required">*</span>：</th>
            <td>
            <input type="hidden" name="warnConfig[13].limit_name" value="ghs_organizationCodeInspectionDate">
            <input name="warnConfig[13].limit_day" type="text" class="easyui-validatebox text1" value="${ghs_organizationCodeInspectionDate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[13].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[13].use_flag" value="1" checked="checked"/></td>
          </tr>
           <tr>
            <th width="150">质量保证协议<span class="required">*</span>：</th>
            <td>
              <input type="hidden" name="warnConfig[14].limit_name" value="ghs_qualityAssuranceDate">
            <input name="warnConfig[14].limit_day" type="text" class="easyui-validatebox text1" value="${ghs_qualityAssuranceDate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[14].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[14].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr>
            <th width="150">法人委托书到期时间<span class="required">*</span>：</th>
            <td>
             <input type="hidden" name="warnConfig[15].limit_name" value="ghs_authorizationDate">
            <input name="warnConfig[15].limit_day" type="text" class="easyui-validatebox text1" value="${ghs_authorizationDate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[15].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[15].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr>
            <th width="150">药品有效期到期日<span class="required">*</span>：</th>
            <td>
            <input type="hidden" name="warnConfig[16].limit_name" value="yp_valid_date">
            <input name="warnConfig[16].limit_day" type="text" class="easyui-validatebox text1"  value="${yp_valid_date.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[16].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[16].use_flag" value="1" checked="checked"/></td>
          </tr>
           <tr>
            <th width="150">药品注册批准文件到期日<span class="required">*</span>：</th>
            <td>
             <input type="hidden" name="warnConfig[17].limit_name" value="yp_medince_regist_date">
            <input name="warnConfig[17].limit_day" type="text" class="easyui-validatebox text1"  value="${yp_medince_regist_date.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[17].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[17].use_flag" value="1" checked="checked"/></td>
          </tr>
          <tr>
            <th width="150">养护计划周期<span class="required">*</span>：</th>
            <td>
             <input type="hidden" name="warnConfig[18].limit_name" value="yh_maintenance_plan">
            <input name="warnConfig[18].limit_day" type="text" class="easyui-validatebox text1"  value="${yh_maintenance_plan.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[18].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[18].use_flag" value="1" checked="checked"/></td>
          </tr>
           <tr>
            <th width="150">采购人员法人委托书到日期<span class="required">*</span>：</th>
            <td>
             <input type="hidden" name="warnConfig[19].limit_name" value="cg_authorizationDate">
            <input name="warnConfig[19].limit_day" type="text" class="easyui-validatebox text1"  value="${cg_authorizationDate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[19].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[19].use_flag" value="1" checked="checked"/></td>
          </tr>
            <tr>
            <th width="150">采购人员身份证有效期<span class="required">*</span>：</th>
            <td>
             <input type="hidden" name="warnConfig[20].limit_name" value="cg_IDCardValidate">
            <input name="warnConfig[20].limit_day" type="text" class="easyui-validatebox text1"  value="${cg_IDCardValidate.limit_day }" size="40"/></td>
            <td>&nbsp;&nbsp;启用<input type="radio" name="warnConfig[20].use_flag" value="0" />&nbsp;&nbsp;&nbsp;停用<input type="radio" name="warnConfig[20].use_flag" value="1" checked="checked"/></td>
          </tr>
        	
          <tr height="80">
            <td colspan="4" align="center" valign="bottom">
           	 <input  name="warnConfig[0].id" type="hidden" value="${gys_businessLicense_ExpirationDate.id}"/>
           	 <input  name="warnConfig[1].id" type="hidden" value="${gys_businessLicense_annualSurvey.id }"/>
           	 <input  name="warnConfig[2].id" type="hidden" value="${gys_licence_ExpirationDate.id}"/>
           	 <input  name="warnConfig[3].id" type="hidden" value="${gys_GPS_ExpirationDate.id }"/>
           	 <input  name="warnConfig[4].id" type="hidden" value="${gys_organizationCodeDate.id }"/>
           	 <input  name="warnConfig[5].id" type="hidden" value="${gys_organizationCodeInspectionDate.id }"/>
           	 <input  name="warnConfig[6].id" type="hidden" value="${gys_qualityAssuranceDate.id }"/>
           	 <input  name="warnConfig[7].id" type="hidden" value="${gys_authorizationDate.id }"/>
        	 <input  name="warnConfig[21].id" type="hidden" value="${gh_IDCardValidate.id }"/>
           	 <input  name="warnConfig[22].id" type="hidden" value="${gh_PharmaceuticalSalesmanTrainingCertificateDate.id }"/>
        	 
           	  <input  name="warnConfig[8].id" type="hidden" value="${ghs_businessLicense_ExpirationDate.id}"/>
           	 <input  name="warnConfig[9].id" type="hidden" value="${ghs_businessLicense_annualSurvey.id }"/>
           	 <input  name="warnConfig[10].id" type="hidden" value="${ghs_licence_ExpirationDate.id}"/>
           	 <input  name="warnConfig[11].id" type="hidden" value="${ghs_GPS_ExpirationDate.id }"/>
           	 <input  name="warnConfig[12].id" type="hidden" value="${ghs_organizationCodeDate.id }"/>
           	 <input  name="warnConfig[13].id" type="hidden" value="${ghs_organizationCodeInspectionDate.id }"/>
           	 <input  name="warnConfig[14].id" type="hidden" value="${ghs_qualityAssuranceDate.id }"/>
           	 <input  name="warnConfig[15].id" type="hidden" value="${ghs_authorizationDate.id }"/>
           	 <input  name="warnConfig[16].id" type="hidden" value="${yp_valid_date.id }"/>
           	 <input  name="warnConfig[17].id" type="hidden" value="${yp_medince_regist_date.id }"/>
           	 <input  name="warnConfig[18].id" type="hidden" value="${yh_maintenance_plan.id }"/>
           	 <input  name="warnConfig[19].id" type="hidden" value="${cg_authorizationDate.id }"/>
           	 <input  name="warnConfig[20].id" type="hidden" value="${cg_IDCardValidate.id }"/>
           	 <shiro:hasPermission name="CompanyManage_save">
             <input name="" type="button" class="btn_big" value="保存" onclick="update_config()"/>
             </shiro:hasPermission>
             <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
        </table>
        </form>
	<script type="text/javascript">
		function update_config(){
			$('#save_warnconfig').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="viewWarnConfig.html";
			    }  
			});  
		}
		setDefaultForRadio("warnConfig[0].use_flag","${gys_businessLicense_ExpirationDate.use_flag}");
		setDefaultForRadio("warnConfig[1].use_flag","${gys_businessLicense_annualSurvey.use_flag}");
		setDefaultForRadio("warnConfig[2].use_flag","${gys_licence_ExpirationDate.use_flag}");
		setDefaultForRadio("warnConfig[3].use_flag","${gys_GPS_ExpirationDate.use_flag}");
		setDefaultForRadio("warnConfig[4].use_flag","${gys_organizationCodeDate.use_flag}");
		setDefaultForRadio("warnConfig[5].use_flag","${gys_organizationCodeInspectionDate.use_flag}");
		setDefaultForRadio("warnConfig[6].use_flag","${gys_qualityAssuranceDate.use_flag}");
		setDefaultForRadio("warnConfig[7].use_flag","${gys_authorizationDate.use_flag}");
		setDefaultForRadio("warnConfig[21].use_flag","${gh_IDCardValidate.use_flag}");
		setDefaultForRadio("warnConfig[22].use_flag","${gh_PharmaceuticalSalesmanTrainingCertificateDate.use_flag}");
		
		setDefaultForRadio("warnConfig[8].use_flag","${ghs_businessLicense_ExpirationDate.use_flag}");
		setDefaultForRadio("warnConfig[9].use_flag","${ghs_businessLicense_annualSurvey.use_flag}");
		setDefaultForRadio("warnConfig[10].use_flag","${ghs_licence_ExpirationDate.use_flag}");
		setDefaultForRadio("warnConfig[11].use_flag","${ghs_GPS_ExpirationDate.use_flag}");
		setDefaultForRadio("warnConfig[12].use_flag","${ghs_organizationCodeDate.use_flag}");
		setDefaultForRadio("warnConfig[13].use_flag","${ghs_organizationCodeInspectionDate.use_flag}");
		setDefaultForRadio("warnConfig[14].use_flag","${ghs_qualityAssuranceDate.use_flag}");
		setDefaultForRadio("warnConfig[15].use_flag","${ghs_authorizationDate.use_flag}");
		
		setDefaultForRadio("warnConfig[16].use_flag","${yp_valid_date.use_flag}");
		setDefaultForRadio("warnConfig[17].use_flag","${yp_medince_regist_date.use_flag}");
		setDefaultForRadio("warnConfig[18].use_flag","${yh_maintenance_plan.use_flag}");
		setDefaultForRadio("warnConfig[19].use_flag","${cg_authorizationDate.use_flag}");
		setDefaultForRadio("warnConfig[20].use_flag","${cg_IDCardValidate.use_flag}");
	</script>
</body>
</html>