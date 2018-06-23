function removenull(oname)
{                                     
var nstring=""                                     
for (var i=0; i<oname.length ;i++)                  {                                     
if (oname.charAt(i)!=" ")                            {
nstring=nstring+oname.charAt(i);                    }                                     
}                                     
return (nstring);                                     
} 
function isdig(s)
{
	var regu = "^([1-9]*[0-9]*)$"
	var re = new RegExp(regu);
	if (s.search(re) != -1){
		return true;
	}else{
		return false;
	}
}

function check_date(datestr)
{

var datetime_arr,date_arr,time_arr,year,mon,day;
var monthDays = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
datetime_arr=datestr.split(" ")
if(datestr.indexOf("-")<0)
 {
    return false;
  
 }
   if(datestr.indexOf("-")!=-1)
   {
	date_arr=datetime_arr[0].split("-");
   }
if(date_arr[0]*1>9999 || date_arr[0]*1<1910)
 {
   return false;
 }
    if(date_arr.length!=3) return false;
	year=date_arr[0];
	mon=date_arr[1];
	day=date_arr[2];	   
	if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) 
	   monthDays[1]=29;
	if(!isdig(year) || !isdig(mon) || !isdig(day) || mon<1 || mon>12 || day>monthDays[mon-1]) 
	   return false;

	//Passed all check
	return true;
}
function compare(low,high){
var datetime_arr1,datetime_arr2,date_arr1,date_arr2,time_arr;
datetime_arr1=low.split(" ")
datetime_arr2=high.split(" ")
   if(low.indexOf("-")!=-1&&high.indexOf("-")!=-1)
   {
	date_arr1=datetime_arr1[0].split("-");
	date_arr2=datetime_arr2[0].split("-");
   }
   if(date_arr1.length!=3) return false;
 if(date_arr2.length!=3) return false;
  if(date_arr1[0].length==1)
   date_arr1[0]="0"+date_arr1[0];
   if(date_arr1[1].length==1)
   date_arr1[1]="0"+date_arr1[1];
   if(date_arr1[2].length==1)
   date_arr1[2]="0"+date_arr1[2];
   if(date_arr2[0].length==1)
   date_arr2[0]="0"+date_arr2[0];
    if(date_arr2[1].length==1)
   date_arr2[1]="0"+date_arr2[1];
   if(date_arr2[2].length==1)
   date_arr2[2]="0"+date_arr2[2];
  var d1= date_arr1[0]+ date_arr1[1]+ date_arr1[2];
  var d2= date_arr2[0]+ date_arr2[1]+ date_arr2[2];
  if(parseInt(d1)>=parseInt(d2))
  {
    return false;
  }
		return true;
}
function check_Number(str,a)
{
s=removenull(str)*1;
if(a==1)
{
 if(isNaN(s))
  {
   return false;
  }
  else
   {
   return true;
   }
}
if(a==2)
{
 if(isNaN(s))
  {
    if(Math.floor(s)!=s)
      {
        return false
      }
    else
     {
     return ture;
    }
  }
}
return false;
}
//函数功能：将回车键转成TAB键
function captureCR(){
	var keycode=event.keyCode 
	if(event.keyCode == 13){ //回车
		//如果所击中的是submit类型,则提交，否则转成TAB
		var theType = null;
		theType=event.srcElement.type;
		if(theType != 'submit')
			event.keyCode=9; //TAB键
	}
}

//函数功能：执行满位跳转
function autoSkip(){
		var theType = null;
		theType=event.srcElement.type;
		if(theType == 'text'){ //执行满位跳转
			var theMaxLength = event.srcElement.maxLength;
			var theValue = event.srcElement.value;
			if(theValue.length >= theMaxLength){ //找到FORM中的下一个元素，然后转向它
				focusNextElement(event.srcElement);
			}
		}
}
function autoSkip1(){
		var theType = null;
		theType=event.srcElement.type;
		if(theType == 'text'){ //执行满位跳转
			var theMaxLength = event.srcElement.maxLength;
			var theValue = event.srcElement.value;
			if(theValue.length >= theMaxLength){ //找到FORM中的下一个元素，然后转向它
				focusNextElement1(event.srcElement);
			}
		}
}
//将焦点由指定元素移至下一个元素
function focusNextElement(srcElement){
				var theForm = event.srcElement.form;
				var nextElement = null;
				for(i=0; i<theForm.elements.length; i++){
					var obj = theForm.elements(i);
					if(obj == event.srcElement)
						break;
				}
				i++;
				if(i<theForm.elements.length){ //下一个元素存在
					nextElement = theForm.elements(i);
					nextElement.focus();
					nextElement.selected;
				}

}
//将焦点由指定元素移至下一个元素
function focusNextElement1(srcElement){
				var nextTab = srcElement.tabIndex +1; //下一个元素的TAB顺序
				var theForm = event.srcElement.form;
				var nextElement = null;
				for(i=0; i<theForm.elements.length; i++){
					var obj = theForm.elements(i);
					if(obj.tabIndex == nextTab)
						break;
				}
				if(i<theForm.elements.length){ //下一个元素存在
					nextElement = theForm.elements(i);
					nextElement.focus();
				}

}
function browsexqdm(aa){//打开需求代码树
		var keycode=event.keyCode 
		var realkey=String.fromCharCode(event.keyCode) 
		if(event.keyCode==123){
		SetObject(aa);
	    window.open('/xqdm_tree.jsp' ,'newwindow', 'height=400, width=250, top=0, left=400, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no')	  
		}
	}
	
	function clickxqdm(aa){
		SetObject(aa);
	    window.open('/xqdm_tree.jsp' ,'newwindow', 'height=400, width=250, top=0, left=400, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no')	  
	}
	function browseorgan(aa){//打开需求代码树
		var keycode=event.keyCode 
		var realkey=String.fromCharCode(event.keyCode) 
		if(event.keyCode==123){
		SetObject(aa);
	    window.open('/organ_tree.jsp' ,'newwindow', 'height=400, width=250, top=0, left=400, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no')  
		}
	}
	function browsedate(aa){//打开日历
		var keycode=event.keyCode 
		var realkey=String.fromCharCode(event.keyCode) 
		if(event.keyCode==123){
		SetObject(aa);
	  window.showModelessDialog('/date.jsp',window,'dialogHeight: 220px; dialogWidth: 280px; dialogTop: 200px; dialogLeft:200px; edge: Raised; center: Yes; help: No; resizable:no; status:No;scrollbar=no;')	  
		}
	}
		function clickdate(aa){
		SetObject(aa);
	  window.showModelessDialog('/date.jsp',window,'dialogHeight: 220px; dialogWidth: 280px; dialogTop: 200px; dialogLeft:200px; edge: Raised; center: Yes; help: No; resizable:no; status:No;scrollbar=no;')	  
	}
	function turnnext(date){
		if(date.value.length >= 6){ //找到FORM中的下一个元素，然后转向它
				focusNextElement(event.srcElement);
			}
			}
			
	function isYearValid(year,aa){//判断年份正确与否，并加上前缀
       var retyear=year;
       if (year>20 && year<100)
         {
          retyear=year+1900;
         } else {
     if (year>=0 && year<=20)
       {
       retyear=year+2000;
        } else {
       alert("年份填写错误，请重填")
	    eval("form1."+aa).focus();
      return false;
        }
   }
   return retyear;
    }
function isDayValid(year,month,day){//判断日期填写正确与否
     if (day<1||day>31||month<1||month>12)
      {
        return false;
       } else {
if (day==31&&(month==2||month==4||month==6||month==9||month==11))
     {
    return false;
     } else {
if(month==2&&day>28&&!(day==29&&year%4==0&&(year%100!==0||year%400==0)))
  {
   return false;
   }
}
}
return true;
}
function standarddate(aa){//将日期转化为标准形式
	 var date=event.srcElement.value;
	if(date.length!=6&&date.length>0){
		 if(check_date(date)==false){
			 alert("日期输入错误，请重试");
			  eval("form1."+aa).value="";
			  eval("form1."+aa).focus();
			}
		 }
       if(date.length==6){
		  if(isdig(date)){
			var year=date.substring(0,2) 
			var month=date.substring(2,4) 
			var day=date.substring(4,6) 
			year=isYearValid(parseInt(year),aa)
			if(parseInt(month)>12&&parseInt(month)<1){
				alert("月份填写错误")
				 eval("form1."+aa).value="";
				 eval("form1."+aa).focus();
				 
				return false;}
			if(isDayValid(year,month,day)==false){
				alert("日期填写错误")
				 eval("form1."+aa).value="";
				 eval("form1."+aa).focus();
				return false;}
			 var standarddate=year+"-"+month+"-"+day
			eval("form1."+aa).value=standarddate;
			}else{
				alert("日期输入错误，请重试");
				 eval("form1."+aa).value="";
				 eval("form1."+aa).focus();
				}
	   }
	}