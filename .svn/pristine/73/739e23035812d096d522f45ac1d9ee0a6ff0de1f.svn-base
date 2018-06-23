/**
 * 控制样式变化的JS
 */

function btn_hoverOn(id){//实现按钮的hover
	 document.getElementById(id).className="current";
	 document.execCommand("BackgroundImageCache", false, true);
 } 
function btn_hoverOut(id){
	document.getElementById(id).className="uncurrent";
} 


function btn_hoverOnFor(name){//实现按钮的hover
	 document.getElementsByName(name)[0].className="current";
	 document.execCommand("BackgroundImageCache", false, true);
} 
function btn_hoverOutFor(name){
	document.getElementsByName(name)[0].className="uncurrent";
} 


function boundWinC(s){//单击"查询"按钮，弹出框的控制
	alert(123);
	if(document.getElementById("boundWin").style.display == "block"){
		document.getElementById("boundWin").style.display ="none";
	}else{
		document.getElementById("deptQueryWin").src=s;
		document.getElementById("boundWin").style.display ="block";
	}
}	