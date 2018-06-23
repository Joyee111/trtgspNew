<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>委托储存入库单新增</title>
</head>
<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">药品状态管理&nbsp;>&nbsp;入库单制单&nbsp;>&nbsp;委托储存入库单新增</font>
	<form action="../saveOrUpdateEntryTicket.html?t=(new Date()).valueOf()" name="add_entryTicket" id="add_entryTicket" method="post" enctype="multipart/form-data">
        <table border="0" cellspacing="0" cellpadding="0" class="xx_table1">
          <tr>
            <th width="150">供货单位<span class="required">*</span>：</th>
            <td><input name="ghdw" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="ghdw" value="${entryTicket.ghdw }"readonly="readonly"/></td>
            <th width="150">供货日期<span class="required">*</span>：</th>
            <td><input name="ghrq" type="text" class="easyui-datebox text1" data-options="required:false,validType:'date'" disabled="disabled"size="40" id="ghrq" value="${entryTicket.ghrq}"readonly="readonly"/></td>
          </tr>
          <tr>
            <th width="150">编号<span class="required">*</span>：</th>
            <td><input name="bh" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="bh" value="${entryTicket.bh}" /></td>
            <th width="150">货号<span class="required">*</span>：</th>
            <td><input name="hh" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="hh" value="${entryTicket.hh}" readonly="readonly"/></td>
          </tr>
          <tr>
            <th width="150">通用名称<span class="required">*</span>：</th>
            <td><input name="tymc" type="text" class="easyui-validatebox text1" data-options="required:false" size="40"  id="tymc" value="${entryTicket.tymc}"readonly="readonly"/></td>
            <th width="150">剂型<span class="required">*</span>：</th>
            <td><input name="jx" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="jx" value="${entryTicket.jx}"readonly="readonly"/></td>
          </tr>
          <tr>
            <th width="150">规格<span class="required">*</span>：</th>
            <td><input name="gg" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="gg"  value="${entryTicket.gg }"readonly="readonly"/></td>
            <th width="150">单位<span class="required">*</span>：</th>
            <td><input name="dw" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="dw" value="${entryTicket.dw}"readonly="readonly"/></td>
          </tr>
          <tr>
            <th width="150">数量<span class="required">*</span>：</th>
            <td><input name="sl" type="text" class="easyui-validatebox text1" onchange="count_total_meony('sl','dj','je','nzsl')" data-options="required:false" size="40" id="sl"  value="${entryTicket.sl}"/></td>
            <th width="150">单价<span class="required">*</span>：</th>
            <td><input name="dj" type="text" class="easyui-validatebox text1" onchange="count_total_meony('sl','dj','je','nzsl')" data-options="required:false" size="40" id="dj" value="${entryTicket.dj}"/></td>
          </tr>
          <tr>
            <th width="150">金额<span class="required">*</span>：</th>
            <td><input name="je" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="je" value="${entryTicket.je}"readonly="readonly"/></td>
            <th width="150">批准文号<span class="required">*</span>：</th>
            <td><input name="pzwh" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="pzwh" value="${entryTicket.pzwh}"readonly="readonly"/></td>
          </tr>
          <tr>
            <th width="150">生产批号<span class="required">*</span>：</th>
            <td><input type="text" class="easyui-combobox text1" 
            	data-options="
            		required:true,
            		valueField: 'id',
            		textField: 'text'
				" 
            	size="40" name="scph" id="scph" value=""/>
            	
            </td>
           
            
            <th width="150">有效期至<span class="required">*</span>：</th>
            <td><input name="yxqz" type="text" class="easyui-datebox text1" data-options="required:false,validType:'date'" disabled="disabled"size="40" id="yxqz" value="${entryTicket.yxqz}"/></td>
          </tr>
          <tr>
            <th width="150">内装数量<span class="required">*</span>：</th>
            <td><input name="nzsl" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="nzsl" value="${entryTicket.nzsl}" readonly="readonly"/></td>
            <th width="150">件数<span class="required">*</span>：</th>
            <td><input name="js" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="js" value="${entryTicket.js}"readonly="readonly"/></td>
          </tr>
          <tr>
            <th width="150">生产厂商<span class="required">*</span>：</th>
            <td><input name="sccs" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="sccs" value="${entryTicket.sccs}"readonly="readonly"/></td>
            <th width="150">备注<span class="required"></span>：</th>
            <td><input name="bz" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="bz" value="${entryTicket.bz}"/></td>
          </tr>
          <!--  
          <tr>
            <th width="150">采购员<span class="required">*</span>：</th>
            <td><input name="cgy" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="cgy" value="${entryTicket.cgy}" /></td>
            <th width="150">收货员<span class="required">*</span>：</th>
            <td><input name="shy" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="shy" value="${entryTicket.shy}"/></td>
          </tr>-->
          <tr>
            <th width="150">验收员<span class="required">*</span>：</th>
            <td><input name="ysy" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="ysy" value="${entryTicket.ysy}"readonly="readonly"/></td>
            <th width="150">验收员2<span class="required"></span>：</th>
            <td><input name="ysy2" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="ysy2" value="${entryTicket.ysy2}"readonly="readonly"/></td>
             <!-- <th width="150">保管员<span class="required">*</span>：</th>
            <td><input name="bgy" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="bgy" value="${entryTicket.bgy}"/></td> --> 
          </tr>
           <!-- 
          <tr>
            <th width="150">复核员<span class="required">*</span>：</th>
            <td><input name="fhy" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="fhy" value="${entryTicket.fhy}"/></td>
            <th width="150">制单人<span class="required">*</span>：</th>
            <td><input name="zdr" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" id="zdr" value="${entryTicket.zdr}"/></td>
          </tr>-->
         <tr height="80">
            <td colspan="4" align="center" valign="bottom">
            <input name="jygs" type="hidden"  id="jygs" value="${entryTicket.jygs}" />
            <input name="cgy" type="hidden"  id="cgy" value="${entryTicket.cgy}" />
            <input name="shy" type="hidden"  id="shy" value="${entryTicket.shy}" />
            <input name="bgy" type="hidden"  id="bgy" value="${entryTicket.bgy}" />
            <input name="fhy" type="hidden"  id="fhy" value="${entryTicket.fhy}" />
            <input name="zdr" type="hidden"  id="zdr" value="${entryTicket.zdr}" />
           		 <input type="hidden" id="acceptanceId" name="acceptanceId" value="${entryTicket.acceptanceId}"/>
           		 <input type="hidden" name="id" value="${entryTicket.id}">
           		 <input type="hidden" name="flag"  id="flag" value="1">
                <input name="" type="button" class="btn_big" value="提交" onclick="save_entryTicket()"/>
                <input name="" type="button" class="btn_big" value="取消" onclick="goBack()"/>
            </td>
            </tr>
        </table>
	</form>
	<script type="text/javascript">
		function save_entryTicket(){
		//	$("#add_entryTicket"),from("submit")
			$('#add_entryTicket').form('submit', {
			success : function(data) {
				var json = jsonParse(data);
				if (json.success != null && json.success != "") {
					alert(decodeURI( json.success));
				}
				location.href = "../EntryTicket/list.html";
			}
		});
		}
		function find(id,batch){
					 $("#acceptanceId").val("");
					 $("#ghdw").val("");
					 $("#ghrq").datebox('setValue','');
					 $("#bh").val("");
					 $("#hh").val("");
					 $("#tymc").val("");
					 $("#jx").val("");
					 $("#gg").val("");
					 $("#dw").val("");
					 $("#sl").val("");
					 $("#dj").val("");
					 $("#je").val("");
					 $("#pzwh").val("");
					 $("#scph").combobox('setValue','');
					 $("#yxqz").datebox('setValue','');
					 $("#nzsl").val("");
					 $("#js").val("");
					 $("#sccs").val("");
					 $("#bz").val("");
					 $("#cgy").val("");
					 $("#shy").val("");
					 $("#ysy").val("");
					 $("#bgy").val("");
					 $("#fhy").val("");
					 $("#zdr").val("");
					 $("#ysy2").val("");
					 $("#jygs").val("");
			$.post("${ctx}/trtgsp/drugState/EntryTicket/findETJH.html",{
			"id" : id,"batchNumber":batch,
			},function(data){
				if(data){
					var b = data.toString();
					var c = b.split(",");
					//alert(c[4]);
					 $("#acceptanceId").val(c[0]);
					 $("#ghdw").val(c[1]);
					 $("#ghrq").datebox('setValue',c[2]);
					 $("#bh").val(c[3]);
					 $("#hh").val(c[4]);
					 $("#tymc").val(c[5]);
					 $("#jx").val(c[6]);
					 $("#gg").val(c[7]);
					 $("#dw").val(c[8]);
					 $("#sl").val(c[9]);
					 $("#dj").val(c[10]);
					 $("#je").val(c[11]);
					 $("#pzwh").val(c[12]);
					 $("#scph").combobox('setValue',c[13]);
					 $("#yxqz").datebox('setValue',c[14]);
					 $("#nzsl").val(c[15]);
					 $("#js").val(c[16]);
					 $("#sccs").val(c[17]);
					 $("#bz").val(c[18]);
					 $("#cgy").val(c[19]);
					 $("#shy").val(c[20]);
					 $("#ysy").val(c[21]);
					 $("#bgy").val(c[22]);
					 $("#fhy").val(c[23]);
					 $("#zdr").val(c[24]);
					 $("#ysy2").val(c[25]);
					 $("#jygs").val(c[26]);
				}
			});
			
		}
		//查询批号
		$('#scph').combobox({  
        //url:urlStr,  
        valueField: 'id',
      	textField: 'text', 
        onChange:function (newValue, oldValue){  
            if(newValue !=null && newValue!=""){  
                var urlStr ="${ctx}/trtgsp/drugState/EntryTicket/findysdJH.html?batch=" + encodeURIComponent(newValue);  
                $("#scph").combobox("reload",urlStr);  
            }  
        }  ,
        onSelect: function(rec){
      			var str = rec.id.split('_');
		     	find(str[0],str[1]);
      		}
    });  
		function count_total_meony(quality,taxprice,total,nzsl){
   
 		var qua = $("#"+quality).val();//数量
 		var tax = $("#"+taxprice).val();//含税单价
 		var nzsl = $("#"+nzsl).val();//内装数量
 		
 		if(isNotNull(qua) && isNotNull(tax)){
 			var money = 	(parseFloat(qua))*(parseFloat(tax));
 			//alert(money);
 			$("#"+total).val(parseFloat(money).toFixed(2));
 		}
 		if(isNotNull(qua) && isNotNull(nzsl)){
 			var js = (parseFloat(qua)/parseFloat(nzsl))
 			$("#js").val(parseFloat(js))
 		}
 	} 
		function isNotNull(value){
		return typeof(value)!=undefined && value!=null && value!="";
	}
	</script>
</body>
</html>