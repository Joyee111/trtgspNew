/**
 * 字符串左取指定个数的字符（原型扩展或重载）
 * 
 * @param {num}
 *            获取个数
 * @type string
 * @returns 匹配的字符串
 */
String.prototype.left = function(num, mode) {
	if (!/\d+/.test(num))
		return (this);
	var str = this.substr(0, num);
	if (!mode)
		return str;
	var n = str.len() - str.length;
	num = num - parseInt(n / 2);
	return this.substr(0, num);
}

/**
 * 将字符串转换成JSON
 */
String.prototype.toJSON = function() {
	return eval("("+this+")");
}

/**
 * 字符串右取指定个数的字符（原型扩展或重载）
 * 
 * @param {num}
 *            获取个数
 * @type string
 * @returns 匹配的字符串
 */
String.prototype.right = function(num, mode) {
	if (!/\d+/.test(num))
		return (this);
	var str = this.substr(this.length - num);
	if (!mode)
		return str;
	var n = str.len() - str.length;
	num = num - parseInt(n / 2);
	return this.substr(this.length - num);
}
/**
 * 判断字符串是否以指定的字符串结束
 */
String.prototype.endsWith = function(str) {
	return this.substr(this.length - str.length) == str;
}

/**
 * 判断字符串是否以指定的字符串开始
 */
String.prototype.startsWith = function(str) {
	return this.substr(0, str.length) == str;
}

/**
 * 字符串包含（原型扩展或重载）
 * 
 * @param {string:
 *            str} 要搜索的子字符串
 * @param {bool:
 *            mode} 是否忽略大小写
 * @type int
 * @returns 匹配的个数
 */
String.prototype.matchCount = function(str, mode) {
	return eval("this.match(/(" + str + ")/g" + (mode ? "i" : "") + ").length");
}

/**
 * 去除左右空格（原型扩展或重载）
 * 
 * @type string
 * @returns 处理后的字符串
 */
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

/**
 * 去除左空格（原型扩展或重载）
 * 
 * @type string
 * @returns 处理后的字符串
 */
String.prototype.lTrim = function() {
	return this.replace(/(^\s*)/g, "");
}

/**
 * 去除右空格（原型扩展或重载）
 * 
 * @type string
 * @returns 处理后的字符串
 */
String.prototype.rTrim = function() {
	return this.replace(/(\s*$)/g, "");
}
/**
 * 将字符null转换为空
 */
String.prototype.nullToEmpty = function() {
	if(this == null || this == undefined || this == "" || this.trim() == "" || this.trim() == "null" || this.trim() == "undefined"){
		return "";
	}
	return this;
}
/** 
* 字符串转换为日期型（原型扩展或重载） 
* @type Date 
* @returns 日期 
*/ 

String.prototype.toDate = function(fmt) {
	var defaulFmt = "YYYY-MM-dd HH:mm:ss";
	if(fmt != undefined && fmt != null && fmt.trim() != ""){
		defaulFmt = fmt;
	}
	var converted = Date.parse(this);
	var myDate = new Date(converted);
	if (isNaN(myDate)) {
		var arys = this.split('-');
		myDate = new Date(arys[0], --arys[1], arys[2]);
	}
	return myDate.format(defaulFmt);
}

/** 
 * 检索数组元素（原型扩展或重载） 
 * @param {o} 被检索的元素值 
 * @type int 
 * @returns 元素索引 
 */ 

Array.prototype.contains = function(o) {
	var index = -1;
	for (var i = 0; i < this.length; i++) {
		if (this[i] == o) {
			index = i;
			break;
		}
	}
	return index;
} 

/** 
* 日期格式化（原型扩展或重载） 
* 格式 YYYY/yyyy/YY/yy 表示年份 
* MM/M 月份 
* W/w 星期 
* dd/DD/d/D 日期 
* hh/HH/h/H 时间 
* mm/m 分钟 
* ss/SS/s/S 秒 
* @param {formatStr} 格式模版 
* @type string 
* @returns 日期字符串 
*/ 

Date.prototype.format = function(formatStr) {
	var str = formatStr;
	var Week = [ '日', '一', '二', '三', '四', '五', '六' ];
	str = str.replace(/yyyy|YYYY/, this.getFullYear());
	str = str.replace(/yy|YY/,
			(this.getYear() % 100) > 9 ? (this.getYear() % 100).toString()
					: '0' + (this.getYear() % 100));
	str = str.replace(/MM/, (this.getMonth() + 1) > 9 ? (this.getMonth() + 1)
			.toString() : '0' + (this.getMonth() + 1));
	str = str.replace(/M/g, this.getMonth());
	str = str.replace(/w|W/g, Week[this.getDay()]);
	str = str.replace(/dd|DD/, this.getDate() > 9 ? this.getDate().toString()
			: '0' + this.getDate());
	str = str.replace(/d|D/g, this.getDate());
	str = str.replace(/hh|HH/, this.getHours() > 9 ? this.getHours().toString()
			: '0' + this.getHours());
	str = str.replace(/h|H/g, this.getHours());
	str = str.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes()
			.toString() : '0' + this.getMinutes());
	str = str.replace(/m/g, this.getMinutes());
	str = str.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds()
			.toString() : '0' + this.getSeconds());
	str = str.replace(/s|S/g, this.getSeconds());
	return str;
} 

/** 
* 比较日期差（原型扩展或重载） 
* @param {strInterval} 日期类型：'y、m、d、h、n、s、w' 
* @param {dtEnd} 格式为日期型或者 有效日期格式字符串 
* @type int 
* @returns 比较结果 
*/ 

Date.prototype.dateDiff = function(strInterval, dtEnd) {
	var dtStart = this;
	if (typeof dtEnd == 'string') { // 如果是字符串转换为日期型
		dtEnd = StringToDate(dtEnd);
	}
	switch (strInterval) {
	case 's':
		return parseInt((dtEnd - dtStart) / 1000);
	case 'n':
		return parseInt((dtEnd - dtStart) / 60000);
	case 'h':
		return parseInt((dtEnd - dtStart) / 3600000);
	case 'd':
		return parseInt((dtEnd - dtStart) / 86400000);
	case 'w':
		return parseInt((dtEnd - dtStart) / (86400000 * 7));
	case 'm':
		return (dtEnd.getMonth() + 1)
				+ ((dtEnd.getFullYear() - dtStart.getFullYear()) * 12)
				- (dtStart.getMonth() + 1);
	case 'y':
		return dtEnd.getFullYear() - dtStart.getFullYear();
	}
} 

/** 
* 日期计算（原型扩展或重载） 
* @param {strInterval} 日期类型：'y、m、d、h、n、s、w' 
* @param {Number} 数量 
* @type Date 
* @returns 计算后的日期 
*/ 

Date.prototype.dateAdd = function(strInterval, Number) {
	var dtTmp = this;
	switch (strInterval) {
	case 's':
		return new Date(Date.parse(dtTmp) + (1000 * Number));
	case 'n':
		return new Date(Date.parse(dtTmp) + (60000 * Number));
	case 'h':
		return new Date(Date.parse(dtTmp) + (3600000 * Number));
	case 'd':
		return new Date(Date.parse(dtTmp) + (86400000 * Number));
	case 'w':
		return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));
	case 'q':
		return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number * 3,
				dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp
						.getSeconds());
	case 'm':
		return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp
				.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp
				.getSeconds());
	case 'y':
		return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp
				.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp
				.getSeconds());
	}
} 

/** 
* 取得日期数据信息（原型扩展或重载） 
* @param {interval} 日期类型：'y、m、d、h、n、s、w' 
* @type int 
* @returns 指定的日期部分 
*/ 

Date.prototype.datePart = function(interval) {
	var myDate = this;
	var partStr = '';
	var Week = [ '日', '一', '二', '三', '四', '五', '六' ];
	switch (interval) {
	case 'y':
		partStr = myDate.getFullYear();
		break;
	case 'm':
		partStr = myDate.getMonth() + 1;
		break;
	case 'd':
		partStr = myDate.getDate();
		break;
	case 'w':
		partStr = Week[myDate.getDay()];
		break;
	case 'ww':
		partStr = myDate.WeekNumOfYear();
		break;
	case 'h':
		partStr = myDate.getHours();
		break;
	case 'n':
		partStr = myDate.getMinutes();
		break;
	case 's':
		partStr = myDate.getSeconds();
		break;
	}
	return partStr;
} 

/** 
* 把日期分割成数组（原型扩展或重载） 
* @type array 
* @returns 日期数组 
*/ 

Date.prototype.toArray = function() {
	var myDate = this;
	var myArray = Array();
	myArray[0] = myDate.getFullYear();
	myArray[1] = myDate.getMonth() + 1;
	myArray[2] = myDate.getDate();
	myArray[3] = myDate.getHours();
	myArray[4] = myDate.getMinutes();
	myArray[5] = myDate.getSeconds();
	return myArray;
} 

/** 
* 取得当前月份的天数（原型扩展或重载） 
* @type int 
* @returns 天数 
*/ 

Date.prototype.daysOfMonth = function() {
	var myDate = this;
	var ary = myDate.toArray();
	var date1 = (new Date(ary[0], ary[1] + 1, 1));
	var date2 = date1.dateAdd('m', 1);
	var result = daysDiff(date1.format('yyyy-MM-dd'), date2
			.format('yyyy-MM-dd'));
	return result;
} 

/** 
* 判断闰年（原型扩展或重载） 
* @type boolean 
* @returns 是否为闰年 true/false 
*/ 

Date.prototype.isLeapYear = function() {
	return (0 == this.getYear() % 4 && ((this.getYear() % 100 != 0) || (this
			.getYear() % 400 == 0)));
} 

/** 
* 比较两个日期的天数差（自定义） 
* @param {DateOne} 日期一 
* @param {DateOne} 日期二 
* @type int 
* @returns 比较结果 
*/ 

function daysDiff(DateOne, DateTwo) {
	var OneMonth = DateOne.substring(5, DateOne.lastIndexOf('-'));
	var OneDay = DateOne
			.substring(DateOne.length, DateOne.lastIndexOf('-') + 1);
	var OneYear = DateOne.substring(0, DateOne.indexOf('-'));

	var TwoMonth = DateTwo.substring(5, DateTwo.lastIndexOf('-'));
	var TwoDay = DateTwo
			.substring(DateTwo.length, DateTwo.lastIndexOf('-') + 1);
	var TwoYear = DateTwo.substring(0, DateTwo.indexOf('-'));

	var cha = ((Date.parse(OneMonth + '/' + OneDay + '/' + OneYear) - Date
			.parse(TwoMonth + '/' + TwoDay + '/' + TwoYear)) / 86400000);
	return Math.abs(cha);
} 

/** 
* 日期计算（自定义） 
* @param {strInterval} 日期类型：'y、m、d、h、n、s、w' 
* @param {Number} 数量 
* @param {prmDate} 原日期 
* @type Date 
* @returns 计算后的日期 
*/ 

function dateAdd(interval, number, prmDate) {
	number = parseInt(number);
	if (typeof (prmDate) == "string") {
		prmDate = prmDate.split(/\D/);
		--prmDate[1];
		eval("var prmDate = new Date(" + prmDate.join(",") + ")");
	}
	if (typeof (prmDate) == "object") {
		var prmDate = prmDate
	}
	switch (interval) {
	case "y":
		prmDate.setFullYear(prmDate.getFullYear() + number);
		break;
	case "m":
		prmDate.setMonth(prmDate.getMonth() + number);
		break;
	case "d":
		prmDate.setDate(prmDate.getDate() + number);
		break;
	case "w":
		prmDate.setDate(prmDate.getDate() + 7 * number);
		break;
	case "h":
		prmDate.setHours(prmDate.getHour() + number);
		break;
	case "n":
		prmDate.setMinutes(prmDate.getMinutes() + number);
		break;
	case "s":
		prmDate.setSeconds(prmDate.getSeconds() + number);
		break;
	case "l":
		prmDate.setMilliseconds(prmDate.getMilliseconds() + number);
		break;
	}
	return prmDate;
}

/**
 * 格式化成小数(消除误差)
 * f欲格式化的对象
 * 精度
 */
Math.formatFloat = function(f, digit) { 
    var m = Math.pow(10, digit); 
    return parseInt(f * m, 10) / m; 
}



Math["Number"] = function() {
    /*
     * 判断obj是否为一个整数
     */
    function isInteger(obj) {
        return Math.floor(obj) === obj
    }
    
    /*
     * 将一个浮点数转成整数，返回整数和倍数。如 3.14 >> 314，倍数是 100
     * @param floatNum {number} 小数
     * @return {object}
     *   {times:100, num: 314}
     */
    function toInteger(floatNum) {
        var ret = {times: 1, num: 0}
        var isNegative = floatNum < 0
        if (isInteger(floatNum)) {
            ret.num = floatNum
            return ret
        }
        var strfi  = floatNum + ''
        var dotPos = strfi.indexOf('.')
        var len    = strfi.substr(dotPos+1).length
        var times  = Math.pow(10, len)
        var intNum = parseInt(Math.abs(floatNum) * times + 0.5, 10)
        ret.times  = times
        if (isNegative) {
            intNum = -intNum
        }
        ret.num = intNum
        return ret
    }
    
    /*
     * 核心方法，实现加减乘除运算，确保不丢失精度
     * 思路：把小数放大为整数（乘），进行算术运算，再缩小为小数（除）
     *
     * @param a {number} 运算数1
     * @param b {number} 运算数2
     * @param digits {number} 精度，保留的小数点数，比如 2, 即保留为两位小数
     * @param op {string} 运算类型，有加减乘除（add/subtract/multiply/divide）
     *
     */
    function operation(a, b, digits, op) {
        var o1 = toInteger(a)
        var o2 = toInteger(b)
        var n1 = o1.num
        var n2 = o2.num
        var t1 = o1.times
        var t2 = o2.times
        var max = t1 > t2 ? t1 : t2
        var result = null
        switch (op) {
            case 'add':
                if (t1 === t2) { // 两个小数位数相同
                    result = n1 + n2
                } else if (t1 > t2) { // o1 小数位 大于 o2
                    result = n1 + n2 * (t1 / t2)
                } else { // o1 小数位 小于 o2
                    result = n1 * (t2 / t1) + n2
                }
                return result / max
            case 'subtract':
                if (t1 === t2) {
                    result = n1 - n2
                } else if (t1 > t2) {
                    result = n1 - n2 * (t1 / t2)
                } else {
                    result = n1 * (t2 / t1) - n2
                }
                return result / max
            case 'multiply':
                result = (n1 * n2) / (t1 * t2)
                return result
            case 'divide':
                result = (n1 / n2) * (t2 / t1)
                return result
        }
    }
    
    // 加减乘除的四个接口
    function add(a, b, digits) {
        return operation(a, b, digits, 'add')
    }
    function subtract(a, b, digits) {
        return operation(a, b, digits, 'subtract')
    }
    function multiply(a, b, digits) {
        return operation(a, b, digits, 'multiply')
    }
    function divide(a, b, digits) {
        return operation(a, b, digits, 'divide')
    }
    
    // exports
    return {
        add: add,
        subtract: subtract,
        multiply: multiply,
        divide: divide
    }
}();