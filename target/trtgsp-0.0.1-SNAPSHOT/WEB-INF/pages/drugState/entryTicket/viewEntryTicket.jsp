<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>药品检查验收记录</title>
</head>
<body>
	<font style="font-family:'宋体';font-weight:normal; font-size: 12;color:#8d3c01;padding: 10px;">综合查询统计分析&nbsp;>&nbsp;药品检查验收记录&nbsp;>&nbsp;修改入库票</font>
	<form action="../ireport/saveOrUpdateEntryTicket.html?t=(new Date()).valueOf()" name="add_entryTicket" id="add_entryTicket" method="post" enctype="multipart/form-data">
        <table border="0" cellspacing="0" cellpadding="0" class="xx_table1">
          <tr>
            <th width="150">供货单位<span class="required">*</span>：</th>
            <td><input name="ghdw" type="text" class="easyui-validatebox text1" data-options="required:false" size="40"  value="${entryTicket.ghdw }"/></td>
            <th width="150">供货日期<span class="required">*</span>：</th>
            <td><input name="ghrq" type="text" class="easyui-datebox text1" data-options="required:false,validType:'date'" size="40" value="${entryTicket.ghrq}"/></td>
          </tr>
          <tr>
            <th width="150">编号<span class="required">*</span>：</th>
            <td><input name="bh" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.bh}" /></td>
            <th width="150">货号<span class="required">*</span>：</th>
            <td><input name="hh" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.hh}" /></td>
          </tr>
          <tr>
            <th width="150">通用名称<span class="required">*</span>：</th>
            <td><input name="tymc" type="text" class="easyui-validatebox text1" data-options="required:false" size="40"  value="${entryTicket.tymc}"/></td>
            <th width="150">剂型<span class="required">*</span>：</th>
            <td><input name="jx" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.jx}"/></td>
          </tr>
          <tr>
            <th width="150">规格<span class="required">*</span>：</th>
            <td><input name="gg" type="text" class="easyui-validatebox text1" data-options="required:false" size="40"  value="${entryTicket.gg }"/></td>
            <th width="150">单位<span class="required">*</span>：</th>
            <td><input name="dw" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.dw}"/></td>
          </tr>
          <tr>
            <th width="150">数量<span class="required">*</span>：</th>
            <td><input name="sl" type="text" class="easyui-validatebox text1" data-options="required:false" size="40"  value="${entryTicket.sl}"/></td>
            <th width="150">单价<span class="required">*</span>：</th>
            <td><input name="dj" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.dj}"/></td>
          </tr>
          <tr>
            <th width="150">金额<span class="required">*</span>：</th>
            <td><input name="je" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.je}"/></td>
            <th width="150">批准文号<span class="required">*</span>：</th>
            <td><input name="pzwh" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.pzwh}"/></td>
          </tr>
          <tr>
            <th width="150">生产批号<span class="required">*</span>：</th>
            <td><input name="scph" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.scph}"/></td>
            <th width="150">有效期至<span class="required">*</span>：</th>
            <td><input name="yxqz" type="text" class="easyui-datebox text1" data-options="required:false,validType:'date'" size="40" value="${entryTicket.yxqz}"/></td>
          </tr>
          <tr>
            <th width="150">内装数量<span class="required">*</span>：</th>
            <td><input name="nzsl" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.nzsl}" /></td>
            <th width="150">件数<span class="required">*</span>：</th>
            <td><input name="js" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.js}"/></td>
          </tr>
          <tr>
            <th width="150">生产厂商<span class="required">*</span>：</th>
            <td><input name="sccs" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.sccs}"/></td>
            <th width="150">备注<span class="required">*</span>：</th>
            <td><input name="bz" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.bz}"/></td>
          </tr>
          <tr>
            <th width="150">采购员<span class="required">*</span>：</th>
            <td><input name="cgy" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.cgy}" /></td>
            <th width="150">收货员<span class="required">*</span>：</th>
            <td><input name="shy" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.shy}"/></td>
          </tr>
          <tr>
            <th width="150">验收员<span class="required">*</span>：</th>
            <td><input name="ysy" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.ysy}"/></td>
            <th width="150">保管员<span class="required">*</span>：</th>
            <td><input name="bgy" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.bgy}"/></td>
          </tr>
          <tr>
            <th width="150">复核员<span class="required">*</span>：</th>
            <td><input name="fhy" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.fhy}"/></td>
            <th width="150">制单人<span class="required">*</span>：</th>
            <td><input name="zdr" type="text" class="easyui-validatebox text1" data-options="required:false" size="40" value="${entryTicket.zdr}"/></td>
          </tr>
         <tr height="80">
            <td colspan="4" align="center" valign="bottom">
           		 <input type="hidden" id="acceptanceId" name="acceptanceId" value="${entryTicket.acceptanceId}"/>
           		 <input type="hidden" name="id" value="${entryTicket.id}">
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
				location.href = "../comQuery/inspeAcceptRecords/query.html";
			}
		});
		}
	</script>
</body>
</html>