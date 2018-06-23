<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页企业</title>
</head>
<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">企业资质管理&nbsp;>&nbsp;首营企业&nbsp;>&nbsp;首营企业新增</font>
	<form action="save_syqy.html?t=(new Date()).valueOf()" name="add_syqy" id="add_syqy" method="post" enctype="multipart/form-data">
		 	<table width="70%" border="0" cellspacing="0" cellpadding="0" class="lch">
          <tr height="89">
            <td align="left" width="5"><img src="../images/lch_l.gif" /></td>
            <td valign="top" align="center" width="20%">
            	<span class="ok" >1</span>
                <br />开始
            </td>
            <td valign="top" align="center" width="20%">
            	<span >2</span>
                <br />已保存
            </td>
            <td valign="top" align="center" width="20%">
            	<span>3</span>
                <br />审核
            </td>
            <td valign="top" align="center" width="20%">
            	<span>4</span>
                <br />已驳回
            </td>
            <td valign="top" align="center" width="20%">
            	<span>5</span>
                <br />审核通过
            </td>
            <td align="right" width="5"><img src="../images/lch_r.gif" /></td>
          </tr>
        </table>

        <table border="0" cellspacing="0" cellpadding="0" class="xx_table1">
          <tr>
          <th>客户编号<span class="required">*</span>：</th>
            <td><input name="customerNumber" type="text" class="easyui-validatebox text1" size="40" data-options="required:true,validType:'checkNumber'" maxlength="20"/></td>
            <th width="150">客户名称<span class="required">*</span>：</th>
            <td><input name="companyName" type="text" class="easyui-validatebox text1" data-options="required:true" size="40" onblur="ajaxChanggeChinaToPinyin(this,'pinyinCode')"/></td>
          <!--   
            -->
          </tr>
          <tr>
          <th>拼音码<span class="required">*</span>：</th>
          <td><input name="pinyinCode" id="pinyinCode" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
          <!--   <th>企业地址<span class="required">*</span>：</th>
            <td><input name="compamyAddress" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td> -->
            <th>邮      编<span class="required">*</span>：</th>
            <td><input name="postalcode" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkPostCode'" size="40"/></td>
          </tr>
           <tr>
            <th>联系电话<span class="required">*</span>：</th>
            <td><input name="phone" type="text" class="easyui-validatebox text1" data-options="required:true" size="40" maxlength="20"/></td>
            <th>传   真<span class="required">*</span>：</th>
            <td><input name="portraiture" type="text" class="easyui-validatebox text1" data-options="required:true" size="40"/></td>
          </tr>
         <tr>
         	<th width="150">法人代表/负责人<span class="required">*</span>：</th>
            <td><input name="corporation" type="text" class="easyui-validatebox text1" data-options="required:true,validType:['checkChina','length[2,10]']" size="40" maxlength="20"/></td>
             <th>纳税人登记号<span class="required">*</span>：</th>
            <td><input name="taxpayerRegisterNo" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkCertificate'" size="40"/></td>
         </tr>
          <tr>
            <th>开户银行<span class="required">*</span>：</th>
            <td><input name="bankName" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkChina'" size="40"/></td>
            <th>开户银行账号<span class="required">*</span>：</th>
            <td><input name="bankNumber" type="text" class="easyui-validatebox text1" data-options="required:true,validType:['checkNumber','length[16,19]']" size="40" /></td>
          </tr>
          <tr>
          	<th>开户户名<span class="required">*</span>：</th>
            <td><input name="bankUserName" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkChina'" size="40"/></td>
             <th>销售代表<span class="required">*</span>：</th>
            <td>
          <input type="text" class="easyui-combobox  text1" data-options="
           required:true,
      	 	valueField: 'id',
       		textField: 'text',
      		url:'../firstEnterprise/findSalesStaffJson.html',
      		onSelect: function(rec){
      			var str = rec.id.split('_');
      			$('#sales_deputy').val(str[1]);
      		}" name="" id="commonnamebox" size="40"/>&nbsp;&nbsp;
			</td>
          </tr>
          <tr>
            
            <th>Email地址<span class="required">*</span>：</th>
            <td><input name="email" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'email'" size="40"/></td>
          </tr>
          <!-- <tr>
            <th>质量负责人<span class="required">*</span>：</th>
            <td><input name="quality_principal" type="text" class="easyui-validatebox text1" data-options="required:true,validType:['checkChina','length[2,10]']" size="40"/></td>
           
          </tr>
          <tr>
            <th>企业经济性质<span class="required">*</span>：</th>
            <td><select name="economic_nature">
            <option value="1">国有企业</option>
				<option value="2">私营企业</option>
				<option value="3">个人独资企业</option>
				<option value="4">集体企业</option>
				<option value="5">外资企业企业</option>
            </select></td> -->
            <!-- 
            <th>十位码<span class="required">*</span>：</th>
            <td><input name="tenBitCode" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkTenCode'" size="40"/></td>
            -->
           <!--  <th>提货人员：</th>
           <td>
           	<input type="text" name="deliveryPersonnel" class="easyui-validatebox text1" data-options="required:false,validType:'checkChina'" size="40"/>
           </td> -->
        <!--   </tr> -->
         
       <!--  <tr>
            
            <th>Email地址<span class="required">*</span>：</th>
            <td><input name="email" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'email'" size="40"/></td>
          </tr>
          <tr>
            <th>经营/生产许可证号<span class="required">*</span>：</th>
            <td><input name="license_No" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkCertificate'" size="40"/></td>
            <th> 营业执照号<span class="required">*</span>：</th>
            <td><input name="business_license_No" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkCertificate'" size="40"/></td>
          </tr>
          <tr>
           
            <th>认证证书号码<span class="required">*</span>：</th>
            <td><input name="certificate_No" type="text" class="easyui-validatebox text1" data-options="required:true,validType:'checkCertificate'" size="40"/></td>
          </tr>
         
          <tr> -->
          
        
         <!--   <th>提货人员<span class="required">*</span>：</th>
           <td>
           	<input type="text" name="deliveryPersonnel" class="easyui-validatebox text1" data-options="required:true,validType:'checkChina'" size="40"/>
           </td>
            -->
        <!--   </tr> -->
          <tr>
            <th valign="top">经营/生产范围<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="businessScope" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true,validType:'checkChina'"></textarea></td>
          </tr>
          <tr>
            <th valign="top">申请原因<span class="required">*</span>：</th>
            <td colspan="3"><textarea name="apply_cause" cols="94" rows="4" class="easyui-validatebox  textarea"  data-options="required:true,validType:'checkChina'"></textarea></td>
          </tr>
          <tr>
            <th valign="top">备注：</th>
            <td colspan="3"><textarea name="remark" cols="94" rows="4" class="textarea" ></textarea></td>
          </tr>
          <tr>
            <th>营业执照：</th>
            <td>
            <input type="file" name="business_licence_path" class="text1" size="40"/>
            </td>
            <th>营业执照到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="business_licence_date" class="easyui-datebox text1" data-options="required:true,validType:'date'"  style="height: 28px;" size="40"/>
            </td>
          </tr>
         <!--    <tr>
            <th>营业执照年检证明：</th>
            <td>
            <input type="file" name="business_licence_inspection_path" class="text1" size="40"/>
            </td>
            <th>营业执照年检时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="business_licence_inspection_date" class="easyui-datebox text1" data-options="required:true,validType:'date'"  style="height: 28px;" size="40"/>
            </td>
          </tr>-->
           <tr>
            <th>经营/生产许可证：</th>
            <td>
            <input type="file" name="licence_path" class="text1" size="40"/>
            </td>
            <th>经营/生产许可证到期日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="licence_date" class="easyui-datebox text1" data-options="required:true,validType:'date'" style="height: 28px;"   size="40"/>
            </td>
          </tr>
          <tr>
            <th>GSP/GMP证书：</th>
            <td>
            <input type="file" name="gsp_certificate_path" class="text1 " size="40"/>
            </td>
            <th>GSP/GMP证书截止日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="gsp_certificate_date" class="easyui-datebox text1"  data-options="required:true,validType:'date'" style="height: 28px;"   size="40"/>
            </td>
          </tr>
          <tr>
            <th>组织机构代码证：</th>
            <td>
            <input type="file" name="organization_code_path" class="text1 " size="40"/>
            </td>
            <th>组织机构代码到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="organization_code_date" class="easyui-datebox text1"  data-options="required:true,validType:'date'" style="height: 28px;"   size="40"/>
            </td>
          </tr>
           <tr>
            <th>组织机构代码证年检：</th>
            <td>
            <input type="file" name="organization_code_inspection_path" class="text1 " size="40"/>
            </td>
            <th>组织机构代码年检日<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="organization_code_inspection_date" class="easyui-datebox text1"  data-options="required:true,validType:'date'" style="height: 28px;"   size="40"/>
            </td>
          </tr>
           <tr>
            <th>质量保证协议：</th>
            <td>
            <input type="file" name="quality_assurance_path" class="text1 " size="40"/>
            </td>
            <th>质量保证书到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="quality_assurance_date" class="easyui-datebox text1"  data-options="required:true,validType:'date'" style="height: 28px;"   size="40"/>
            </td>
          </tr>
           <tr>
            <th>法人委托书：</th>
            <td>
            <input type="file" name="authorization_path" class="text1 " size="40"/>
            </td>
            <th>法人委托书到期时间<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="authorization_date" class="easyui-datebox text1"  data-options="required:true,validType:'date'" style="height: 28px;"   size="40"/>
            </td>
          </tr>
          <!-- 
           <tr>
            <th>开户信息：</th>
            <td>
            <input type="file" name="accountPath" class="text1" size="40"/>
            </td>
            <th>开户信息到期日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="accountDate" class="easyui-datebox text1" data-options="required:true,validType:'date'" style="height: 28px;"  size="40"/>
            </td>
          </tr>
          <tr>
            <th>年检证明：</th>
            <td>
            <input type="file" name="annualSurveyPath" class="text1" size="40"/>
            </td>
            <th>年检证明到期日期<span class="required">*</span>：</th>
            <td>
            	<input type="text" name="annualSurveyDate" class="easyui-datebox text1" data-options="required:true,validType:'date'" style="height: 28px;"  size="40"/>
            </td>
          </tr> -->
          
          <tr >
          	<td colspan="2" align="center" valign="top"><input name="" type="button" class="btn_big1" value="新增GSP/GMP" onclick="addGSPAccessory()"/></td>
          	<td colspan="2" align="center" valign="top"><input name="" type="button" class="btn_big1" value="新增其它证件" onclick="addOtherPAccessory()"/></td>
          </tr>
        </table>
        <table id ="add_dttachment" class="xx_table2">
        	
        </table>
      <table border="0" cellspacing="0" cellpadding="0" class="xx_table2">
      	 <tr height="80">
            <td colspan="4" align="center" valign="bottom">
           		 <input type="hidden" id="save_type" name="save_type" value=""/>
           		 <input type="hidden" name="sales_deputy" id="sales_deputy" value="">
                <input name="" type="button" class="btn_big" value="保存" onclick="save_syqy(0)"/>
                <input name="" type="button" class="btn_big" value="提交" onclick="save_syqy(1)"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
      </table>
	</form>
	<script type="text/javascript">
	 $("#commonnamebox").combobox({
			filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.valueField].indexOf(q.toUpperCase()) == 0;
			
		}
	})		
	
	function save_syqy(value){
			$("#save_type").val(value);
		
		  $('#add_syqy').form('submit',{  
			    success: function(data){  
				var json = jsonParse(data);
				if(json.success!=null && json.success!=""){
					alert(decodeURI( json.success));
				}
				location.href="syqydlr.html";
			    }  
			});  
		}
	var attachment_index = 0;
/*	function add_children(){
		
		if(attachment_index>=5){
			alert("您最多只能添加五个附件！");
			return;
		}
		var  td = "<tr><th>附件"+(attachment_index+1)+"：</th>"+
			"<td><input type='file' name='request_name"+(attachment_index+1)+"' class='text1' size='40'/></td>"+
			"<th>附件"+(attachment_index+1)+"到期日期：</th>"+
			"<td><input type='text' id='accsoryCombox_id"+attachment_index+"' name='firstAccessoryList["+attachment_index+"].accessoryDate' class='easyui-datebox' data-options='required:true' size='40' style='height: 28px;'>"+
			"<input type='hidden' name='firstAccessoryList["+attachment_index+"].request_name' value='request_name"+(attachment_index+1)+"'></td></tr>"
					
		$("#add_dttachment").after(td);
		alert($("#combox_id"+attachment_index));
		$.parser.parse($('#accsoryCombox_id'+attachment_index).parent()); 
		//$.parser.parse(); 
		attachment_index++;
	}*/
	function addGSPAccessory(){
		var tr ="<tr><th width='150'>GSP/GMP证书号码 <span class='required'>*</span>：</th>"+
			"<td><input type='text' name='firstAccessoryList["+attachment_index+"].certificateNumber' class='easyui-validatebox text1' data-options='required:true' size='20'/></td>"+
			"<th width='150'>GSP/GMP证书到期时间<span class='required'>*</span>：</th>"+
			"<td><input type='text' id='accsoryCombox_id"+attachment_index+"' name='firstAccessoryList["+attachment_index+"].accessoryDate' class='easyui-datebox text1' style='height: 28px;' data-options='required:true' size='20'/></td>"+
			"<th width='150'>GSP/GMP证书附件</th>"+
			"<td><input type='file' name='request_name"+attachment_index+"' class='text1' size='20'/></td><td><input type='button' class='btn_big' value='删除' onclick='deleteAccssory(this)'>"+
			"<input type='hidden' name='firstAccessoryList["+attachment_index+"].request_name' value='request_name"+attachment_index+"'/>"+
			"<input type='hidden' name='firstAccessoryList["+attachment_index+"].request_type' value='GSP'/> </td></tr>";
			$("#add_dttachment").append(tr);
			$.parser.parse($('#accsoryCombox_id'+attachment_index).parent()); 
			attachment_index++;
	}
	function addOtherPAccessory(){
		var tr ="<tr><th width='150'>证书号码 <span class='required'>*</span>：</th>"+
			"<td><input type='text' name='firstAccessoryList["+attachment_index+"].certificateNumber' class='easyui-validatebox text1' data-options='required:true' size='20'/></td>"+
			"<th width='150'>证书到期时间<span class='required'>*</span>：</th>"+
			"<td><input type='text' id='accsoryOtherCombox_id"+attachment_index+"' name='firstAccessoryList["+attachment_index+"].accessoryDate' class='easyui-datebox text1' style='height: 28px;' data-options='required:true' size='20'/></td>"+
			"<th width='150'>证书附件</th>"+
			"<td><input type='file' name='request_name"+attachment_index+"' class='text1' size='20'/></td><td><input type='button' class='btn_big' value='删除' onclick='deleteAccssory(this)'>"+
			"<input type='hidden' name='firstAccessoryList["+attachment_index+"].request_name' value='request_name"+attachment_index+"'/>"+
			"<input type='hidden' name='firstAccessoryList["+attachment_index+"].request_type' value='other'/></td></tr>";
			$("#add_dttachment").append(tr);
			$.parser.parse($('#accsoryOtherCombox_id'+attachment_index).parent()); 
			attachment_index++;
	}
	
	function deleteAccssory(obj){
		$(obj).parent().parent().remove();
	}
	function upload(target){
		var value =  $(target).val();
		$.post("../upLoadServlet.do",{
		})
	}
	
	</script>
</body>
</html>