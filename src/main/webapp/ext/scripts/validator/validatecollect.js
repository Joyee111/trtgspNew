function validate_all(field, reg, alerttxt) {
	with (field) {
		if (!reg.test(value)) {

			alert(alerttxt);
			return false
		} else {
			return true
		}
	}
}

function validate_required(field, alerttxt) {
	with (field) {
		if (value == "" || value == null) {

			alert(alerttxt);
			return false
		} else {
			return true
		}
	}
}

function validate_int(field, reg, alerttxt, alerttext) {
	with (field) {
		if (!reg.test(value)) {
			alert(alerttxt);
			return false;
		} else {

			if (value - 0 > 100) {
				alert(alerttext);
				return false;
			} else {
				return true;
			}

		}
	}
}

function check_box() {

	
	var collectsensorvali = document.getElementById("collectsensorvali").value; 
	
	var count = document.signupForm.sensorid.length;
	var j = 0;
	for ( var i = 0; i < count; i++) {
		if (document.signupForm.sensorid[i].checked)
			++j;
	}
	if (j == 0) {
		alert(collectsensorvali);//
		return false;
	} else {
		return true;
	}

}

function validate_data() {
	var bvalue = document.signupForm.btime.value;
	var evalue = document.signupForm.etime.value;
	var d1 = new Date(Date.parse(bvalue.substr(0, 19).replace(/-/g, "/")));
	var d2 = new Date(Date.parse(evalue.substr(0, 19).replace(/-/g, "/")));

	
	var collecttimevali = document.getElementById("collecttimevali").value; 
	
	if (Date.parse(d1) - Date.parse(d2) >= 0) {
		alert(collecttimevali);//
		return false;
	} else {
		return true;
	}

}

function validate_longandlat() {
	var ullong = document.signupForm.upperleftlong.value;//左上角经度
	var ullat = document.signupForm.upperleftlat.value;//左上角纬度
	var urlong = document.signupForm.upperrightlong.value;//右上角经度
	var urlat = document.signupForm.upperrightlat.value;//右上角纬度
	var lllong = document.signupForm.lowerleftlong.value;//左下角经度
	var lllat = document.signupForm.lowerleftlat.value;//左下角纬度
	var lrlong = document.signupForm.lowerrightlong.value;//右下角经度
	var lrlat = document.signupForm.lowerrightlat.value;//右下角纬度 
	//alert(1);
	//ullong  < urlong    || lllong <  lrlong   ||   ullat > lllat  || urlat >  lrlat
	
	var collectullongurlongvali = document.getElementById("collectullongurlongvali").value; 
	var collectlllonglrlongvali = document.getElementById("collectlllonglrlongvali").value; 
	var collectullatllatvali = document.getElementById("collectullatllatvali").value; 
	var collectutlatlrlatvali = document.getElementById("collectutlatlrlatvali").value; 
	
	
	
	if (ullong - 0 > urlong - 0) {
		alert(collectullongurlongvali);//
		return false;
	}
	if (lllong - 0 > lrlong - 0) {
		alert("collectlllonglrlongvali");//
		return false;
	}
	if (ullat - 0 < lllat - 0) {
		alert(collectullatllatvali);//
		return false;
	}
	if (urlat - 0 < lrlat - 0) {
		alert(collectutlatlrlatvali);//
		return false;
	}

}

//sensorid
function validate_form(thisform) {
	with (thisform) {
		var long_reg = /^-?(?:(?:180(?:\.0{1,5})?)|(?:(?:(?:1[0-7]\d)|(?:[1-9]?\d))(?:\.\d{1,5})?))$/;//经度正则表达式 
		var lat_reg = /^-?(?:90(?:\.0{1,5})?|(?:[1-8]?\d(?:\.\d{1,5})?))$/;//纬度正则表达式 
		var cloudcover_reg = /^\d+$/; //整形 
		var gsd_reg = /^\d+((\.?\d+)|(\d*))$/;//double

		
		
		var collectupperleftlongvali = document.getElementById("collectupperleftlongvali").value; 
		var collectupperleftlatvali = document.getElementById("collectupperleftlatvali").value; 
		var collectupperrightlongvali = document.getElementById("collectupperrightlongvali").value; 
		var collectupperrightlatvali = document.getElementById("collectupperrightlatvali").value; 
		var collectlowerleftlongvali = document.getElementById("collectlowerleftlongvali").value; 
		
		var collectlowerleftlatvali = document.getElementById("collectlowerleftlatvali").value; 
		var collectlowerrightlongvali = document.getElementById("collectlowerrightlongvali").value; 
		var collectlowerrightlatvali = document.getElementById("collectlowerrightlatvali").value; 
		var collectbtimevali = document.getElementById("collectbtimevali").value; 
		var collectetimevali = document.getElementById("collectetimevali").value; 
		
		var collectcloudcovervali = document.getElementById("collectcloudcovervali").value; 
		var collectcloudcovermaxvali = document.getElementById("collectcloudcovermaxvali").value; 
		var collectgsdvali = document.getElementById("collectgsdvali").value; 
		var collectgsdmaxvali = document.getElementById("collectgsdmaxvali").value; 
		
		
		
		
		if (validate_all(upperleftlong, long_reg,
				collectupperleftlongvali) == false) {//
			upperleftlong.focus();
			return false
		}

		if (validate_all(upperleftlat, lat_reg,
				collectupperleftlatvali) == false) {//
			upperleftlat.focus();
			return false
		}
		if (validate_all(upperrightlong, long_reg,
				collectupperrightlongvali) == false) {//
			upperrightlong.focus();
			return false
		}

		if (validate_all(upperrightlat, lat_reg,
				collectupperrightlatvali) == false) {//
			upperrightlat.focus();
			return false
		}
		if (validate_all(lowerleftlong, long_reg,
				collectlowerleftlongvali) == false) {//
			lowerleftlong.focus();
			return false
		}

		if (validate_all(lowerleftlat, lat_reg,
				collectlowerleftlatvali) == false) {//
			lowerleftlat.focus();
			return false
		}
		if (validate_all(lowerrightlong, long_reg,
				collectlowerrightlongvali) == false) {//
			lowerrightlong.focus();
			return false
		}

		if (validate_all(lowerrightlat, lat_reg,
				collectlowerrightlatvali) == false) {//
			lowerrightlat.focus();
			return false
		}

		if (validate_required(btime,
				collectbtimevali) == false) {//

			btime.focus();
			return false
		}
		if (validate_required(etime,
				collectetimevali) == false) {//
			etime.focus();
			return false
		}
		if (validate_int(cloudcover, cloudcover_reg,
				collectcloudcovervali,//
				collectcloudcovermaxvali) == false) {//
			cloudcover.focus();
			return false
		}
		if (validate_int(gsd, gsd_reg,
				collectgsdvali,//
				collectgsdmaxvali) == false) {//
			gsd.focus();
			return false
		}
		if (check_box() == false) {
			return false
		}
		if (validate_data() == false) {
			return false
		}
		if (validate_longandlat() == false) {
			return false
		}
	}
}


/*
collect.sensor.vali = 至少选择一个，卫星传感器！！
collect.time.vali = 最早时间必须小于最晚时间  !
collect.ullongurlong.vali = 右上角经度 必须大于 左上角经度
collect.lllonglrlong.vali = 右下角经度  必须小于 左下角经度
collect.ullatllat.vali = 左上角纬度 必须大于 左下角纬度 
collect.utlatlrlat.vali = 右上角纬度 必须大于 右下角纬度
collect.upperleftlong.vali = 左上角经度，输入有误！
collect.upperleftlat.vali = 左上角纬度，输入有误！ 
collect.upperrightlong.vali = 右上角经度，输入有误！
collect.upperrightlat.vali = 右上角纬度，输入有误！
collect.lowerleftlong.vali  = 左下角经度，输入有误！
collect.lowerleftlat.vali = 左下角纬度，输入有误！
collect.lowerrightlong.vali = 右下角经度，输入有误！
collect.lowerrightlat.vali = 右下角纬度，输入有误！
collect.btime.vali = 开始时间不能为空 ！
collect.etime.vali = 结束时间不能为空 ！
collect.cloudcover.vali = 平均云量，输入有误 ！
collect.cloudcover.maxvali = 平均云量，不能大于100
collect.gsd.vali = 分辨率，输入有误 ！ 
collect.gsd.maxvali = 分辨率，不能大于100

*/
