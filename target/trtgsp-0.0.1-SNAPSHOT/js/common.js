   function btn_hoverOn(id){// 实现按钮的hover
	 document.getElementById(id).className="current";
	 document.execCommand("BackgroundImageCache", false, true);
   } 
   function btn_hoverOut(id){
	 document.getElementById(id).className="queryAll"
   } 
   
/**
 * 获取上传文件的大小，最大限制为2M
 * 
 * @param {}
 *            filePath
 * @return {Boolean}
 */   	
function getFileSize(filePath){    
   	var fso = new ActiveXObject("Scripting.FileSystemObject");
   	var maxFileSize = 2*1024*1024;
   	if(maxFileSize <= fso.getFile(filePath).size){
   		return false;
   	}
   	else{
   		return true;
   	}
}    
/**
 * 返回上一页
 * 
 * @return
 */
function goBack()
{
window.history.back()
}

var checkflag = "false";
/**
 * checkbox 全选 和 取消
 * 
 * @param fieldName
 *            name名称
 * @return
 */
function checkAll(fieldName) {
// alert(field);
// var field=document.getElementsByName("delete_id");
	var field=document.getElementsByName(fieldName);
// alert(field);
	if (checkflag == "false") {
	for (i = 0; i < field.length; i++) {
	field[i].checked = true;}
	checkflag = "true";
	return "Uncheck All"; }
	else {
	for (i = 0; i < field.length; i++) {
	field[i].checked = false; }
	checkflag = "false";
	return "Check All"; }
}

function isNull(str){
	return str!=null&& trim(str)!="";
}
function trim(str){
	return str.replace(/(^\s*)|(\s*$)/g, "");
 }
function fileExtension(str){
	var start = str.lastIndexOf(".");
	return str.substr(start);
}
/**
 * ajax查询药品剂型
 */
function ajaxQueryForm(){
	$.ajax({ url: "../dectionary/ajaxQueryForm.html", 
		async:false, 
		success: function(data){
		var json = jsonParse(data);
		var formDictionaryList = json.formDictionaryList;
		var options = "<option value=''>请选择剂型</option>"
		$.each(formDictionaryList,function(name,value){
			options = options+"<option value='"+value.id+"'>"+value.formName+"</option>";
		});
		$("#dosageForms").empty();
		$("#dosageForms").append(options);
		
		if(typeof(fromDefault)!="undefined" && fromDefault!=null){
			setDefaultForCheckbox("dosageForms",fromDefault);
		}
	}});
	/*
	 * $.post("../dectionary/ajaxQueryForm.html",function(data){ var json =
	 * jsonParse(data); var formDictionaryList = json.formDictionaryList; var
	 * options = "<option value=''>请选择剂型</option>"
	 * $.each(formDictionaryList,function(name,value){ options = options+"<option
	 * value='"+value.id+"'>"+value.formName+"</option>"; });
	 * $("#dosageForms").empty(); $("#dosageForms").append(options);
	 * if(fromDefault!=null){ setDefaultForCheckbox("dosageForms",dosageForms); }
	 * });
	 */
}	
/**
 * ajax查询合格供应商
 * 
 * @return
 */
function ajaxQueryQualifiedSuppliers(){
	$.ajax({ url: "../firstEnterprise/ajaxQueryQualifiedSuppliers.html", 
		async:false, 
		success: function(data){
		var json = jsonParse(data);
		var qualSuppList = json.qualSuppList;
		var options = "<option value=''>请选择供应商</option>"
		$.each(qualSuppList,function(name,value){
			options = options+"<option value='"+value.id+"'>"+value.customerName+"</option>";
		});
		$("#produce_no").empty();
		$("#produce_no").append(options);
		if(typeof(supplyDefault)!="undefined" && supplyDefault!=null){
			setDefaultForCheckbox("produce_no",supplyDefault);
		}
	}});
	/*
	 * $.post("../firstEnterprise/ajaxQueryQualifiedSuppliers.html",function(data){
	 * var json = jsonParse(data); var qualSuppList = json.qualSuppList; var
	 * options = "<option value=''>请选择供应商</option>"
	 * $.each(qualSuppList,function(name,value){ options = options+"<option
	 * value='"+value.id+"'>"+value.customerName+"</option>"; });
	 * $("#produce_no").empty(); $("#produce_no").append(options); });
	 */
}
function setDefaultForCheckbox(id,index){
// alert("hello")
	$("select[id='"+id+"']").val(index);
	// document.getElementById(id).options[index].selected=true;
}
function setDefaultForRadio(radioName,radioValue){
var obj = document.getElementsByName(radioName);
    for(i = 0; i < obj.length; i++){

      if(obj[i].value == radioValue)
      {  
        obj[i].checked = true;
      }  
    }
    
    return true;
}

function ajaxQueryQualityMidince(){
	$.ajax({ url: "../drugVarieties/ajaxQueryQulidiedMedicinal.html?day="+Date.parse(new Date()), 
		async:false, 
		success: function(data){
		var json = jsonParse(data);
		var midicineList = json.midicineList;
		var options = "<option value=''>请选择品名</option>"
		$.each(midicineList,function(name,value){
			options = options+"<option value='"+value[0]+"'>"+value[1]+"</option>";
		});
		$("#common_name").empty();
		$("#common_name").append(options);
		
		if(typeof(fromDefault)!="undefined" && fromDefault!=null){
			setDefaultForCheckbox("common_name",fromDefault);
		}
	}});
}

function ajaxQueryReceiveMidicine(str,type){
	$(".out_tch").hide();
	if(typeof(type)!=undefined && type=="onclick"){
		$(str).attr("onmouseout","");
	}
	$.ajax({ url: "drugVarieties/ajaxQueryReceiveMidicine.html?day="+Date.parse(new Date()), 
		async:true, 
		success: function(data){
		var json = jsonParse(data);
		var str = json.success;
	// $("#yaopinyanghu_guanli").after("");
		$("#shouhuo_guanli").after(str);
		$("#yaopinyanshou_guanli").after("");
		$("#yaopinyanghu_guanli").after("");
		$("#chuku_jianguan").after("");
		// $("#dialog_table").append(str);
		// $('#dialog').dialog('open');
	}
	});
}
function ajaxQueryAcceptMidicine(str,type){
	$(".out_tch").hide();
	if(typeof(type)!=undefined && type=="onclick"){
		$(str).attr("onmouseout","");
	}
	$.ajax({ url: "drugVarieties/ajaxQueryAcceptMidicine.html?day="+Date.parse(new Date()), 
		async:true, 
		success: function(data){
		var json = jsonParse(data);
		var str = json.success;
	// $("#yaopinyanghu_guanli").after("");
		$("#yaopinyanshou_guanli").after(str);
			$("#shouhuo_guanli").after("");
		$("#yaopinyanghu_guanli").after("");
		$("#chuku_jianguan").after("");
		// $("#dialog_table").append(str);
		// $('#dialog').dialog('open');
	}
	});
}
function ajaxQueryMaintainMidicine(str,type){
	$(".out_tch").hide();
	if(typeof(type)!=undefined && type=="onclick"){
		$(str).attr("onmouseout","");
	}
	$.ajax({ url: "drugVarieties/ajaxQueryMaintainMidicine.html?day="+Date.parse(new Date()), 
		async:true, 
		success: function(data){
		var json = jsonParse(data);
		var str = json.success;
	// $("#yaopinyanghu_guanli").after("");
		$("#yaopinyanghu_guanli").after(str);
		$("#yaopinyanshou_guanli").after("");
		$("#shouhuo_guanli").after("");
		$("#chuku_jianguan").after("");
		// $("#dialog_table").append(str);
		// $('#dialog').dialog('open');
	}
	});
}
function ajaxQueryPurchaseOrderMidicine(str,type){
	$(".out_tch").hide();
	if(typeof(type)!=undefined && type=="onclick"){
		$(str).attr("onmouseout","");
	}
	
	$.ajax({ url: "drugVarieties/ajaxQueryPurchaseOrderMidicine.html?day="+Date.parse(new Date()),
		async:true, 
		success: function(data){
		var json = jsonParse(data);
		var str = json.success;
	// $("#yaopinyanghu_guanli").after("");
		$("#chuku_jianguan").after(str);
		$("#yaopinyanghu_guanli").after("");
		$("#yaopinyanshou_guanli").after("");
		$("#shouhuo_guanli").after("");
		
		// $("#dialog_table").append(str);
		// $('#dialog').dialog('open');
	}
	});
	// $(str).next().show();
}

function hideDiolag(str){
	$(str).next().hide();
}
function childHideDiolag(str){
	$(str).hide().prev().attr("onmouseout","hideDiolag(this)");
}
function childShowDiolag(str){
	$(".out_tch").hide();
	$(str).show();
}

function changeLink(click,url){
	$(click).addClass("on");
	$(click).siblings().removeClass("on");
	$("#change_src").attr("href",url);
	
}
/**
 * 汉字转换为拼音码
 * 
 * @param {}
 *            str
 * @param {}
 *            target
 */
function ajaxChanggeChinaToPinyin(str,target,type){
	$.post("ajaxChanggeChinaToPinyin.html",
		{
			chinaValue : $(str).val(),
			type : type
		},
		function(data){
			var json = jsonParse(data);
			var purchasUnits = json.purchasUnits;
			var returnValue = json.returnValue;
			if(purchasUnits!=null && purchasUnits!=""){
				var str = "<li>系统中已存在以下公司</li>";
				$.each(purchasUnits,function(key,value){
					var companyName = value.companyName;
					str =str +"<li>"+companyName + "</li>";
					
				});
				$("#companyNamePrompt").empty();
				$("#companyNamePrompt").append(str);
				//$(".out_tch").show();
			}
			// alert(data);
			$("#"+target).val(returnValue);
	})
}

function setCheckByName(checkboxName,values){
		var checkBoxs = document.getElementsByName(checkboxName)
		if(typeof(values)!=undefined && values!=""){
			if(values.toString().indexOf(",")>-1){
				var strs = values.toString().split(",");
				for(var i=0,len=strs.length;i<len;i++){
					for(var j=0,ln=checkBoxs.length;j<ln;j++){
						if(strs[i]==checkBoxs[j].value)
							checkBoxs[j].checked=true;
					}
				}
			}else{
					for(var j=0,ln=checkBoxs.length;j<ln;j++){
						if(checkBoxs[j].value== values)
							checkBoxs[j].checked=true;
					}
			}
		}		
	}
	/**
	 * 根据name获取选中radios的值
	 * 
	 * @param {}
	 *            name
	 * @return {}
	 */
	function getRadioValueByName(name){
 		var radios = document.getElementsByName(name);
 		var value = "";
 		for(var i=0,length = radios.length;i<length;i++){
 			if(radios[i].checked){
 				value=radios[i].value;
 				break;
 			}
 		}
 		return value;
 	}
 	/**
	 * 根据radio名字修改指定ID的DOM的值
	 * 
	 * @param {}
	 *            name
	 * @param {}
	 *            target
	 */
 	function changeradio(name,target){
	var season = document.getElementsByName(name);
	var strNew;
	   for(var j=0;j<season.length;j++){    
	    if(season[j].checked){   
	          strNew=season[j].value;    
        }else{
           }
       }
	$("#"+target).val(strNew); 
}

var hkey_root,hkey_path,hkey_key,
hkey_root="HKEY_CURRENT_USER",
hkey_path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";

// 设置页眉页脚为空
function PageSetup_Null()
{
try{
  var RegWsh = new ActiveXObject("WScript.Shell") ;
  hkey_key="header" ;
  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
  hkey_key="footer" ;
  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
  }
catch(e){}
}

// 设置页眉页脚为默认值
function PageSetup_Default()
{
try{
  var RegWsh = new ActiveXObject("WScript.Shell") ;
  hkey_key="header" ;
  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"&w&b页码，&p/&P") ;
  hkey_key="footer" ;
  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"&u&b&d") ;
  }
catch(e){}
}
//验证表单重复提交
function checkSubmit() {
	var submited = false;
	if (!submited) {
		submited = true;
		return true;
	} else {
		alert("请不要重复提交！");
		return false;
	}
}