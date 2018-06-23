function fucCheck(INDEX) {
	var i, j, strTemp;
	strTemp = "0123456789";
	for (i = 0; i < INDEX.length; i++) {
		j = strTemp.indexOf(INDEX.charAt(i));
		if (j == -1) {
			//说明有字符不合法     
			return false;
		}
	}
	//说明合法     
	return true;
}

function firstPage_Go() {
	var page = document.getElementById("tz").value;
	var total = document.getElementById("displayallpage").value;
	if (!fucCheck(page)) {
		alert('输入的页码不是数字类型，请检查');
		return false;
	}
	if (page-0 > total-0 || page -0< 1) {
		alert('输入的页码应在1和'+total+'之间');
	} 
	else {
		var str = document.getElementById("hd").value.replace("p=","p="+page);
		window.location=str;
	}
}

function OtherPage_Go() {
	var page = document.getElementById("tz").value;
	var total = document.getElementById("displayallpage").value; 
	if (!fucCheck(page)) {
		alert('输入的页码不是数字类型，请检查');
		return false;
	}
	if (page-0 > total-0 || page -0< 1) {
		alert('输入的页码应在1和'+total+'之间');
	} 
	else {
		var str = document.getElementById("hd").value.replace("p=1","p="+document.getElementById("tz").value);
		window.location=str;
	}
}

function preparaSubmit(evt){
				  	var nKeyCode = window.event?event.keyCode:evt.which;
				  	if(nKeyCode==13){
				  		go2();
				    }
			}