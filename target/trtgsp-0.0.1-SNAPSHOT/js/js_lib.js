// JavaScript Document
function changeWin(){
	if(parent.place.cols!="10,*")
	{
		parent.place.cols="10,*";
		document.all.menuSwitch.innerHTML="<font class=point>4</font>";
	}
	else
	{
		parent.place.cols="20%,*";
		document.all.menuSwitch.innerHTML="<font class=point>3</font>";
	}
}
function rows(oTable)
 {
   //获取表格对象
   var tblBody = oTable;   //document.all.tabList;

   //返回表格行数
   return tblBody.rows.length;
 }

function getRowIdbyHref(oTable,a)
{
  var tblBody = eval(oTable);   //document.all.tabList;
  var nRows=rows(tblBody);
  for (i=0; i < tblBody.rows.length; i++)
  {
      if(tblBody.rows(i) == a.parentNode.parentNode.parentNode){
			return i;
	 }
	}
	return rows(tblBody)-1;
	
}
function getRowId(oTable,a){
   var tblBody = eval(oTable);   //document.all.tabList;
   var nRows=rows(tblBody);
  for (i=0; i < tblBody.rows.length; i++)
  {
      if(tblBody.rows(i) == a.parentNode.parentNode){
			return i;
	 }
	}
	return rows(tblBody)-1;
}		  
 
function goto_page(url,tag)
{
 	window.open(url,tag," height=500,width=700 ,status=no,toolbar=no,menubar=no,location=no resizable=yes");
}
function isNull(obj, msg)
{
	if(obj.value=="")
	{ 
		alert(msg);
		obj.focus();
		return true;
	}
	else
		return false;
}

function num_input(input)
{
	var posi=input.value.length-1;
	if(isNaN(input.value.charAt(posi)))
	{
		alert("请在本域输入数字！");
		input.focus();
		input.select();
		return false;
	}
}
function show_notice(msg,url)
{
	var message=(msg==null)?"        如果现在放弃操作，该定制的查询将不会被保存！\n确定放弃么？":msg;
	if(confirm(message))
		document.location.href=url;
}
function on_cancle(url,tag)
{
	if(confirm("确定要放弃吗?")){
	if(null==tag)
		document.location.href=url;
	else		
		top.location.href=url;
	}
}

function removenull(oname)
{                                     
var nstring=""                                     
for (var i=0; i<oname.length ;i++)                  {                                     
if (oname.charAt(i)!=" ")                            {
nstring=nstring+oname.charAt(i);                    }                                     
}                                     
return (nstring);                                     
} 

function quit()
{
	document.location.href="/main.jsp";
}

