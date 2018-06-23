(function($) {
	$.fn.autoSwitch = function(options) {
		alert(options);
		options = jQuery.extend( {
			speed : 'normal', // 切换速度，可选值: slow, normal, fast  
			keeptime : 5000
		//每一个的停留时间，毫秒  
				}, options);
		var _this = this;
		var _count = _this.length;
		var _currentIndex = 0;
		if (_count > 1) {
			_this.hide();
			_this.eq(0).show();
			window.setInterval(function() {
				_currentIndex = ++_currentIndex % _count;
				$('imageview').src = _this.src;
				//_this.filter(':visible').hide();
					_this.eq(_currentIndex).fadeIn(options.speed);
				}, options.keeptime);
		}
		return this;
	}
})(jQuery);

//userlist页面，控制<div id="selectcondiv"/>是否显示
function hiddenselectcon()
{
	if($('selectcondiv').style.display=='none')
	{
		$('selectcondiv').style.display='';
	}
	else
	{
		$('selectcondiv').style.display='none';
	}
}

function hiddenselectconbyid(divid)
{
	if($(divid).style.display=='none')
	{
		$(divid).style.display='';
	}
	else
	{
		$(divid).style.display='none';
	}
}

function changeValidationCode(imgcode) {//看不清 换一张验证码
	imgcode.src = "empty.html?frompage=/login/img&d=" + new Date().getTime();
}

//ajax请求后台数据下载文件
function downloadfile(strurl,path,filename){
			jQuery.ajax({
				url:strurl,
				type:'POST',
				global:false,
				dataType:'json',
				data:{fliepath:path,name:filename},
				success:function(productdata) {
				var mag=productdata.message;
				alert(mag);
			}
			});
		}
