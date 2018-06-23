$
		.extend(
				$.fn.validatebox.defaults.rules,
				{
					idcard : {// 验证身份证
						validator : function(num) {
							var len = num.length, re;
							if (len == 15)
								re = new RegExp(
										/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
							else if (len == 18)
								re = new RegExp(
										/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d)$/);
							else {
								// alert("请输入15或18位身份证号,您输入的是 "+len+ "位");
								return false;
							}
							var a = num.match(re);
							if (a != null) {
								if (len == 15) {
									var D = new Date("19" + a[3] + "/" + a[4]
											+ "/" + a[5]);
									var B = D.getYear() == a[3]
											&& (D.getMonth() + 1) == a[4]
											&& D.getDate() == a[5];
								} else {
									var D = new Date(a[3] + "/" + a[4] + "/"
											+ a[5]);
									var B = D.getFullYear() == a[3]
											&& (D.getMonth() + 1) == a[4]
											&& D.getDate() == a[5];
								}
								if (!B) {
									// alert("输入的身份证号 "+ a[0] +" 里出生日期不对！");
									return false;
								}
							}

							return true;
						},
						message : '身份证号码格式不正确'
					},
					checkInt : {// 整形数据验证，含正负值
						validator : function(num) {
							return /^[-\+]?\d+$/.test(num);
						},
						message : '请输入数字'
					},
					checkPhone : {// 手机号验证
						validator : function(num) {
							return /^1[3|4|5|8][0-9]\d{4,8}$/.test(num);
						},
						message : '手机号格式不正确'
					},
					checkDouble : {// 验证小数
						validator : function(num) {
							return /^[-\+]?\d+(\.\d+)?$/.test(num);
						},
						message : '输入小数格式不正确'
					},
					checkChina : {// 中文验证
						validator : function(num) {
							return /^[\u0391-\uFFE5]+$/.test(num);
						},
						message : '请输入中文'
					},
					checkEnglish : {// 英文验证
						validator : function(num) {
							return /^[A-Za-z]+$/.test(num);
						},
						message : '请输入英文字符'
					},
					checkPassword : {// 密码验证
						validator : function(num) {
							var password = jQuery("#password").val();
							var againpassword = jQuery("#againpassword").val();

							if (password != againpassword) {
								return false;
							}
							return true;
						},
						message : '输入的两个密码不相等，请重新输入'
					},
					checkDate : {// 日期验证
						validator : function(num) {
							return /^((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29)$/
									.test(num);
						},
						message : '请输入合法日期'
					},
					checkPostCode : {// 验证邮编
						validator : function(num) {
							return /^[0-9][0-9]{5}$/.test(num);
						},
						message : '请输入合法的邮政编码！'
					},
					checkTenCode : {// 验证十位码
						validator : function(num) {
							return /^\d{10}$/.test(num);
						},
						message : '请输入合法的十位编码！'
					},
					checkNumber : {// 验证数字
						validator : function(num) {
							return /^[0-9]*$/.test(num);
						},
						message : '请输入合法的客户编号！'
					},
					checkTellOrPhone : {// 同时验证手机和电话号码
						validator : function(num) {
							return /(^0\d{2,3}\-\d{7,8}$)|(^1[3|4|5|6|7|8][0-9]{9}$)/
									.test(num);
						},
						message : '请输入合法的手机或电话号码！'
					},
					checkCertificate : {// 验证证书号
							validator : function(num) {
							return /^[A-Za-z0-9-]+$/.test(num);
						},
						message : '请输入合法的证件号码！'
						},
					checkFax : {// 验证传真
							validator : function(num) {
							return /^(\d{3,4}-)?\d{7,8}$/.test(num);
						},
						message : '请输入合法的传真号码！'
						},
					date: {    
            			validator: function(value){  
                		var reg = /^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$/  
                		return reg.test(value);    
            			},    
            			message: '此项必须为yyyy-MM-dd格式的日期'
        			}    

				})