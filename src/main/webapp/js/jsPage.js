//js分页查询，默认每页10条数据
var first = 1;//第一条记录
var last = 10;//最后一条记录
var currPage = 1;//当前页
var pageSize = 10;

function displayPage(pageParam){
	var prePageTd = document.getElementById("prePage");
	
	if(currPage == 1){
		//首页
		prePageTd.innerHTML="<font color='#CCCCCC'>上一页</font>";
	}
	if(currPage > 1){
		displayRecord("none");
		if(pageParam == 'prePage'){
			currPage--;
		}
		else{
			currPage++;
		}
		prePageTd.innerHTML="<a href=\"javascript:displayPage('prePage');\">上一页</a>";
	}
	
	first = pageSize*currPage-9;
	last = pageSize*currPage;
	displayRecord("");
}

function displayRecord(display){
	var nextPageTd = document.getElementById("nextPage");
	
	for(var i=first; i<=last; i++){
		var trObj = document.getElementById("tr_"+i);
		if(trObj == null){//末页可能出现空值
			nextPageTd.innerHTML="<font color='#CCCCCC'>下一页</font>";
			break;
		}
		else{
			nextPageTd.innerHTML="<a href=\"javascript:displayPage('nextPage');\">下一页</a>";
		}
		trObj.style.display=display;
	}
	if(currPage == 1){
		currPage++;
	}
}