//������ͨ��ѧ�������ı�д
//�Զ��庯����������java script�ű�

////���ĳ�µ��������õ�����isrunnian
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

//�ж�theInteger�Ƿ�Ϊ���������theInteger�ǣ���ֵ������(����0��ͷ)������true��
//��������false�������Ƴ���

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


//�Ѵ�mystr�еĵ����š�'�����ɡ�''���������ѯ�����г��ֵ����ŵ����⡣
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



//�Ƿ�Ϊ����
function isrunnian(yyyy)
{
  return((yyyy % 4 == 0 && yyyy % 100 != 0) || (yyyy % 400 == 0));
}


//����Ƿ�Ϊ�������ͣ�������һ��С���㣨С��������β������ȷ�ģ���
function notnumber(checkstr)
{//���з������ַ� ���� true
  var checkOK = "0123456789";
  var decPoints = 0;
  checkstr=trim(checkstr);
  if(checkstr==".")return(true);  //����ֻ��һ��С���㡣
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


//�ѱ�������Checkbox���Ϊδѡ��
function selectAll(theForm){
 for(var i=0;i<theForm.elements.length;i++){
  if(theForm.elements[i].type == "checkbox"){
	theForm.elements[i].checked = true;
  }
 }
}

//�޸�ʱʹ�ã�ʹ���е�����Ϊ�գ� �ύǰ�����ֶβ��ո�
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


//ȡ��ȫѡ
function unselAll(theForm){
 for(var i=0;i<theForm.elements.length;i++){
  if(theForm.elements[i].type == "checkbox"){
   theForm.elements[i].checked = false;
  }
 }
}



//�������y���·�mȷ������d����ѡ��ֵΪdvalue���죬
//����dvalue��options�ֱ��Ӧ���е�ͬ����text���list��
//�õ�����isrunnian,getdays��
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


//�ж�theYear�Ƿ�Ϊ�Ϸ����ֵ

function YearValid(theYear)
{
//����theYear������ַ���

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
//������ȥ���ַ���mystr����β�ո����mystrΪnull�򷵻ؿմ�""
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


<!-------�ж��Ƿ�����------------------------------------->
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


<!------�ж��Ƿ�Ϊ�����ʼ���ַ----------------------------------------------------------->
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


<!-----�ж��Ƿ�Ϊ��-------------------------------------------------------------------------------->
function isEmpty (str)
{
  if ((str == null) || (str.length == 0)) return true;
   else return (false);
 }


<!-----�ж������Ƿ�Ϊ����------------------------------------------------------>
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
   	alert("��ʽΪ2003-01-01");
   	return false;
   	}
   }
}

