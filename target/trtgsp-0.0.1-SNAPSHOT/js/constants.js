var extName = ['人员基本信息','学历基本信息','通讯基本信息','岗位基本信息','职称基本信息','技能等级基本信息'];
var extType = ['EmployeeBaseInfo','EmployeeEducation','EmployeeContacts','EmployeePost',
				  'EmployeeStafftitles','IndustrialGrade'];
var extURL = ['perInfoManage','degreeInfoManage','contactsInfoManage','positionInfoManage',
				 'jobTitleInfoManage','skillLevelInfoManage'];
				 
function displayColuList(){
	var date = Date.parse(new Date());
	var type = null;
	for(var i=0; i<extType.length; i++){
		type = extType[i];		//extType为js/constants.js中的常量
		$.ajax({
		  url: '${ctx}/partyInfoManage/comSearchColuList.html?date='+date,
		  dataType: 'text',
		  data:{
			columnTypeId : type
		  },
		  success: function(data,textStatus, jqXHR){
			  $("#div_"+type).html(data);
		  },
		  error: function(){
			  alert(extName[i]+"加载失败！");//extName为js/constants.js中的常量
		  },
		  async: false
		});
	}
}