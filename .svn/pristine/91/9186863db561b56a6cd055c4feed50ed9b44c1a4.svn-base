//北方交通大学计算中心编写
//自定义函数，适用于java script脚本

////获得某月的天数，用到函数isrunnian
function getdays(y,m)
{
  if(m==2)
  {
    if(isrunnian(y))
      return(29);
    else
      return(28);
  }
  else if(m==4 || m==6 || m==9 || m==11)
  {
    return(30);
  }
  else
  {
    return(31);
  }
}

//判断theInteger是否为整数，如果theInteger是：空值、整数(包括0开头)，返回true，
//其他返回false。不限制长度

function IntValid(theInteger)
{

  var checkOK = "0123456789";
  var i;
  var j;
  var ch;

  for (i = 0;  i < theInteger.length;  i++)
  {
    ch = theInteger.charAt(i);
    if(checkOK.indexOf(ch)==-1)
      return(false);
  }

  return(true);
}

function IsPrice(theInteger)
{

  var checkOK = ".0123456789";
  var i;
  var j;
  var ch;

  for (i = 0;  i < theInteger.length;  i++)
  {
    ch = theInteger.charAt(i);
    if(checkOK.indexOf(ch)==-1)
      return(false);
  }

  return(true);
}


//把串mystr中的单引号“'”换成“''”，处理查询条件中出现单引号的问题。
function switchquot(mystr)
{
    var ch;
    var strall="";
    var n;
    var i;
    n=mystr.length;
    for(i=0;i<=n-1;i++){
      ch=mystr.charAt(i);
      if(ch=="'")
        ch="''";
      strall +=ch;
    }

    return strall;
}



//是否为闰年
function isrunnian(yyyy)
{
  return((yyyy % 4 == 0 && yyyy % 100 != 0) || (yyyy % 400 == 0));
}


//检查是否为数字类型，允许有一个小数点（小数点在首尾都是正确的）。
function notnumber(checkstr)
{//含有非数字字符 返回 true
  var checkOK = "0123456789";
  var decPoints = 0;
  checkstr=trim(checkstr);
  if(checkstr==".")return(true);  //不能只是一个小数点。
  for (i = 0;  i<checkstr.length;  i++)
  {
    ch = checkstr.charAt(i);
    if(checkOK.indexOf(ch)==-1)
    {
      if(ch == ".")
        decPoints++;
      else
      {
        return (true);
        break;
      }
    }
  }
  if (decPoints > 1)
  {
    return (true);
  }
  return (false);
}


//把表单中所有Checkbox标记为未选中
function selectAll(theForm){
 for(var i=0;i<theForm.elements.length;i++){
  if(theForm.elements[i].type == "checkbox"){
	theForm.elements[i].checked = true;
  }
 }
}

//修改时使用（使表中的数据为空） 提交前进行字段补空格
function setbeforeupdate(theform)
{
  for(var i=0;i<theform.elements.length;i++)
  {
    if(theform.elements[i].type == "text" || theform.elements[i].type == "textarea " || theform.elements[i].type == "hidden")
    {
      theform.elements[i].value =theform.elements[i].value+" ";
    }
  }
  return(true);
}


//取消全选
function unselAll(theForm){
 for(var i=0;i<theForm.elements.length;i++){
  if(theForm.elements[i].type == "checkbox"){
   theForm.elements[i].checked = false;
  }
 }
}



//给定年份y和月份m确定天数d，并选中值为dvalue的天，
//其中dvalue和options分别对应表单中的同名的text框和list框。
//用到函数isrunnian,getdays。
function update_listday(y,m,d,totext)
{

  var d_length;
  var i;
  var dvalue=d.options[d.selectedIndex].text ;

  d.length = 0;
  d_length=getdays(y.options[y.selectedIndex].text,m.options[m.selectedIndex].text);

  for(i=1;i<=9;i++)
  {
    d.options[i] = new options("0"+i,"0"+i);
  }

  for(i=10;i<=d_length;i++)
  {
    d.options[i-1] = new options(i+"",i+"");
  }
  d.options[0].selected = true;
  if ( dvalue!=null || dvalue.length!= 0 )
  {
    for( i=0; i < d.length; i++ )
    {
      if(dvalue == d.options[i].value )
      {
        d.options[i].selected = true;
      }
    }
  }
  totext.value=y.options[y.selectedIndex].text+m.options[m.selectedIndex].text+d.options[d.selectedIndex].text;
}


//判断theYear是否为合法年份值

function YearValid(theYear)
{
//参数theYear是年份字符串

  var checkOK = "0123456789";
  var allValid = true;
  var decPoints = 0;
  var allNum = "";
  var i=0;

  if(theYear.length!=4)
  {
    return (false);
  }

  if(theYear.charAt(0)!="1" && theYear.charAt(i)!="2")
  {
    return (false);
  }

  for (i = 1;  i < 3;  i++)
  {
    ch = theYear.charAt(i);
    for (j = 0;  j < checkOK.length;  j++)
      if (ch == checkOK.charAt(j))
        break;
    if (j == checkOK.length)
    {
      return (false);
    }
  }
  return (true);
}


function trim(mystr)
{
//本函数去掉字符串mystr的首尾空格，如果mystr为null则返回空串""
  var i,len,p1,p2;
  if(mystr==null)
    mystr="";
  else
  {
    len=mystr.length;

    p1=0;
    while(p1<len && mystr.charAt(p1)==" ")
    {
      p1++;
    }

    p2=len-1;
    while(p2>=0 && mystr.charAt(p2)==" ")
    {
      p2--;
    }
    if(p2>=p1)
      mystr=mystr.substring(p1,p2+1);
    else
      mystr="";
  }
  return(mystr);
}


<!----isTime------------------------------------------------------>
function isTime(theStr){
     var colonDex = theStr.indexof(':');
     if ((colonDex< 1) || (colonDex>2)) {return(false);}
     else {
        var hh =theStr.substring(0,colonDex);
        var ss =theStr.substring(colonDex+1,theStr.length);
        if ((hh.length < 1) || (hh.length>2) || (!isInt(hh))) {return (false);}
        else if ((ss.length < 1) || (ss.length>2) || (!isInt(ss))) {return(false);}
        else if ((!isBetween(hh,0,23)) || (!isBetween(ss,0,59))) {return(false);}
        else {return(true);}
     }
}


<!---isDate------------------------------------------------------>
function isDate(theStr){
    var the1st=theStr.indexOf('-');
    var the2nd=theStr.lastIndexOf('-');
    if (isEmpty(theStr)) return (true);
    else
    {
    if (the1st==the2nd) {return(false);}
    else {
      var y=theStr.substring(0,the1st);
      var m=theStr.substring(the1st+1,the2nd);
      var d=theStr.substring(the2nd+1,theStr.length);
      var maxDays=31;
   if (isInt(m)==false || isInt(d)==false || isInt(y)==false){
      return(false);}
   else if (y.length < 4) {return (false);}
   else if (!isBetween(m,1,12)) {return(false);}
   else if (m==4 || m==6 ||m==9 || m==11) maxDays=30;
   else if (m==2) {
        if (y % 4> 0) maxDays = 28;
        else  if (y % 100 == 0 && y % 400 >0) maxDays = 28;
        else maxDays =29;
   }
   if (isBetween(d,1,maxDays) == false) {return(false);}
   else {return(true);}

    }
    }
}


<!-------判断是否数字------------------------------------->
function isDigit(theNum) {
      var theMask ='0123456789.';
      var temp;
      var flag;
      flag=true;
      if (isEmpty(theNum)) return (false);
      else
      {
       for (var i=0;i<theNum.length;i++){
				temp=theNum.substring(i,i+1);
				if (theMask.indexOf(temp) == -1)
			  {

			  		flag=false;
			  		break;

			  }
			 }
			 return(flag);
			}

}


function isDigit11(theNum) {
      var theMask ='0123456789';
      var temp;
      var flag;
      flag=true;
      if (isEmpty(theNum)) return (false);
      else
      {
       for (var i=0;i<theNum.length;i++){
				temp=theNum.substring(i,i+1);
				if (theMask.indexOf(temp) == -1)
			  {

			  		flag=false;
			  		break;

			  }
			 }
			 return(flag);
			}

}

function isTelephone(theNum) {
      var theMask ='0123456789-';
      var temp;
      var flag;
      flag=true;
      if (isEmpty(theNum)) return (false);
      else
      {
       for (var i=0;i<theNum.length;i++){
				temp=theNum.substring(i,i+1);
				if (theMask.indexOf(temp) == -1)
			  {

			  		flag=false;
			  		break;

			  }
			 }
			 return(flag);
			}

}


<!------判断是否为电子邮件地址----------------------------------------------------------->
function isEmail (theStr)
{
  var atIndex = theStr.indexOf('@');
  var dotIndex = theStr.indexOf('.',atIndex);
  var flag =true;
  if ((theStr == null) || (theStr.length == 0)) return true;
   else
  {theSub =theStr.substring(0,dotIndex +1);
  if  ((atIndex != theStr.lastIndexOf('@')) || (atIndex < 1) || (dotIndex < atIndex + 2) || (theStr.length <= theSub.length))
  { flag = false; }
  else { flag =true;}
  return (flag);
  }
}


<!-----判断是否为空-------------------------------------------------------------------------------->
function isEmpty (str)
{
  if ((str == null) || (str.length == 0)) return true;
   else return (false);
 }


<!-----判断输入是否为整数------------------------------------------------------>
function isInt(theStr)
{
   var flag=true;
   if (isEmpty(theStr)) { flag=false;}
   else
   {
      for (var i=0;i < theStr.length;i++)
      {
         if (isDigit(theStr.substring(i,i+1)) == false)
            {
               flag=false;
               break;

             }

       }<!--end for------------------------------>

    }
   return (flag);

}

<!---------------------------------------------------------------------------->

function isReal(theStr,decLen)
{
     var dotlst = theStr.indexOf('.');
     var dot2nd = theStr.lastIndexOf('.');
     var ok =true;
     if (isEmpty(theStr)) return false;
     if (dotlst ==-1)
     {
        if (!isInt(theStr)) return (false);
        else return(true);
     }
     else if (dotlst !=dot2nd) return (false);
     else if (dotlst==0) return (false);
     else {

        var intpart = theStr.substring(0,dotlst);
        var decpart = theStr.substring (dot2nd +1);
        if (decpart.length > decLen) return (false);
        else if (!isInt(intpart) || !isInt(decpart)) return (false);
        else if (isEmpty(decpart)) return (false);
        else return(true);
     }


}


function isBetween(val,lo,hi){
if ((val < lo) || (val > hi)) {return(false);}
else {return(true);}
}

function isBetween(str){
   if(str==null){
   	return true;
   }
   else{
   	if(str.length()>=4)
   	if(isInt(str.substring(0,4))){
   		if(str.length()>=7)
   		if(isInt(str.substring(5,7))){

   		}
   		else{

   		}
   	}
   	else{
   	alert("格式为2003-01-01");
   	return false;
   	}
   }
}

