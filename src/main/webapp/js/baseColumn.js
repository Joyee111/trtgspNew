/**
 * 打开插件showModalDialog
 */
function openDictPage(){
	var plugType = document.getElementById("plugType").value;
	var winObj = window.showModalDialog("../dictInfoManage/frame/openDictPage.html?flag=colu&plugType="+plugType,"","dialogWidth:800px;dialogHeight:500px;dialogTop:80px;dialogLeft:300px;");
	var pluginAddressObj = document.getElementById("pluginAddress");
	pluginAddressObj.value = winObj.dictIds;
	
	var str = createSelect(winObj.dictNames);
	var selectSpanObj = document.getElementById("plugShowSpan");
	selectSpanObj.innerHTML = str;
}

function createSelect(dictNames){
	var namesArr = dictNames.split(",");
	var str = "<select>";
	for(var i=1; i<namesArr.length; i++){
		var valueName = namesArr[i].split("_");
		str += "<option value='"+valueName[0]+"'>"+valueName[1]+"</option>";
	}
	str += "</select>";
	
	return str;
}

function chanagePlugin(obj){
	var plugType = obj.value;
	var fieldTypeLabel = document.getElementById("columnFieldType");
	var plugShowSpanObj = document.getElementById("plugShowSpan");
	if(plugType == "text"){
		fieldTypeLabel.style.display = 'block'; 
	}
	else{
		fieldTypeLabel.style.display = 'none'; 
		str = "<a href='javascript:openDictPage();'>无预览，请编辑</a>";
	}
	plugShowSpanObj.innerHTML = str;
	$.parser.parse(plugShowSpanObj);
}
function chanageFieldType(){
	var fieldTypeLabel = document.getElementById("fieldTypeLabel");
	var plugShowSpanObj = document.getElementById("plugShowSpan");
	var obj = document.getElementById("columnFieldType");
	var str = "";
	if(obj.value == "int"){
		str = "<input type='text' class='easyui-validatebox' data-options=\"required:true,validType:'checkInt'\" size='20'/>";
	}
	else if(obj.value == 'datetime'){
		str = "<input type='text' class='easyui-datebox' data-options='required:true' size='20'/>";
	}
	else if(obj.value == 'idcard'){
		str = "<input type='text' class='easyui-validatebox' data-options=\"required:true,validType:'idcard'\" size='20'/>";
	}
	else if(obj.value == 'phone'){
		str = "<input type='text' class='easyui-validatebox' data-options=\"required:true,validType:'checkPhone'\" size='20'/>";
	}
	else if(obj.value == 'double'){
		str = "<input type='text' class='easyui-validatebox' data-options=\"required:true,validType:'checkDouble'\" size='20'/>";
	}
	else{
		str = "<input type='text' class='easyui-validatebox' data-options='required:true' size='20'/>";
	}
	plugShowSpanObj.innerHTML = str;
	$.parser.parse(plugShowSpanObj);
}

/**
 * 编辑字段时，初始化插件预览span
 */
function spanHtml(){
	var pluginAddress = document.getElementById("pluginAddress").value;
	var plugType = document.getElementById("plugType");
	var columnFieldType = '${perColu.columnFieldType}';
	var columnFieldTypeObj = document.getElementById("columnFieldType");
	if(plugType.value == 'text'){
		columnFieldTypeObj.style.display = 'block';
		chanageFieldType(columnFieldTypeObj);
	}
	else{
		columnFieldTypeObj.style.display = 'none';
   		if(pluginAddress != null && pluginAddress != ''){
	   		var date = Date.parse(new Date());
	   		var plugTypeValue = plugType.value
	   		$.ajax({
			  url: '../dictInfoManage/frame/selectDictInfo.html?date='+date,
			  dataType: 'text',
			  data:{
				 plugType:plugTypeValue,
				 pluginAddress:pluginAddress
			  },
			  success: function(data,textStatus, jqXHR){
				  $("#plugShowSpan").html(data);
			  },
			  async: false
			});
   		}
	}
}
/**
 * 添加字段时，初始化插件预览span
 */
function addSpanHtml(){
	var columnFieldTypeObj = document.getElementById("columnFieldType");
	columnFieldTypeObj.style.display = 'block';
	chanageFieldType(columnFieldTypeObj);
}