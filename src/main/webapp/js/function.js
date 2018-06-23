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
//�������ܣ����س���ת��TAB��
function captureCR(){
	var keycode=event.keyCode 
	if(event.keyCode == 13){ //�س�
		//��������е���submit����,���ύ������ת��TAB
		var theType = null;
		theType=event.srcElement.type;
		if(theType != 'submit')
			event.keyCode=9; //TAB��
	}
}

//�������ܣ�ִ����λ��ת
function autoSkip(){
		var theType = null;
		theType=event.srcElement.type;
		if(theType == 'text'){ //ִ����λ��ת
			var theMaxLength = event.srcElement.maxLength;
			var theValue = event.srcElement.value;
			if(theValue.length >= theMaxLength){ //�ҵ�FORM�е���һ��Ԫ�أ�Ȼ��ת����
				focusNextElement(event.srcElement);
			}
		}
}
function autoSkip1(){
		var theType = null;
		theType=event.srcElement.type;
		if(theType == 'text'){ //ִ����λ��ת
			var theMaxLength = event.srcElement.maxLength;
			var theValue = event.srcElement.value;
			if(theValue.length >= theMaxLength){ //�ҵ�FORM�е���һ��Ԫ�أ�Ȼ��ת����
				focusNextElement1(event.srcElement);
			}
		}
}
//��������ָ��Ԫ��������һ��Ԫ��
function focusNextElement(srcElement){
				var theForm = event.srcElement.form;
				var nextElement = null;
				for(i=0; i<theForm.elements.length; i++){
					var obj = theForm.elements(i);
					if(obj == event.srcElement)
						break;
				}
				i++;
				if(i<theForm.elements.length){ //��һ��Ԫ�ش���
					nextElement = theForm.elements(i);
					nextElement.focus();
					nextElement.selected;
				}

}
//��������ָ��Ԫ��������һ��Ԫ��
function focusNextElement1(srcElement){
				var nextTab = srcElement.tabIndex +1; //��һ��Ԫ�ص�TAB˳��
				var theForm = event.srcElement.form;
				var nextElement = null;
				for(i=0; i<theForm.elements.length; i++){
					var obj = theForm.elements(i);
					if(obj.tabIndex == nextTab)
						break;
				}
				if(i<theForm.elements.length){ //��һ��Ԫ�ش���
					nextElement = theForm.elements(i);
					nextElement.focus();
				}

}
function browsexqdm(aa){//�����������
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
	function browseorgan(aa){//�����������
		var keycode=event.keyCode 
		var realkey=String.fromCharCode(event.keyCode) 
		if(event.keyCode==123){
		SetObject(aa);
	    window.open('/organ_tree.jsp' ,'newwindow', 'height=400, width=250, top=0, left=400, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no')  
		}
	}
	function browsedate(aa){//������
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
		if(date.value.length >= 6){ //�ҵ�FORM�е���һ��Ԫ�أ�Ȼ��ת����
				focusNextElement(event.srcElement);
			}
			}
			
	function isYearValid(year,aa){//�ж������ȷ��񣬲�����ǰ׺
       var retyear=year;
       if (year>20 && year<100)
         {
          retyear=year+1900;
         } else {
     if (year>=0 && year<=20)
       {
       retyear=year+2000;
        } else {
       alert("�����д����������")
	    eval("form1."+aa).focus();
      return false;
        }
   }
   return retyear;
    }
function isDayValid(year,month,day){//�ж�������д��ȷ���
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
function standarddate(aa){//������ת��Ϊ��׼��ʽ
	 var date=event.srcElement.value;
	if(date.length!=6&&date.length>0){
		 if(check_date(date)==false){
			 alert("�����������������");
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
				alert("�·���д����")
				 eval("form1."+aa).value="";
				 eval("form1."+aa).focus();
				 
				return false;}
			if(isDayValid(year,month,day)==false){
				alert("������д����")
				 eval("form1."+aa).value="";
				 eval("form1."+aa).focus();
				return false;}
			 var standarddate=year+"-"+month+"-"+day
			eval("form1."+aa).value=standarddate;
			}else{
				alert("�����������������");
				 eval("form1."+aa).value="";
				 eval("form1."+aa).focus();
				}
	   }
	}