          scores = new Array(20);
		  var numTotal=0;
		  NS4 = (document.layers) ? 1 : 0;
		  IE4 = (document.all) ? 1 : 0;
		  ver4 = (NS4 || IE4) ? 1 : 0;
		  if (ver4) {
		  with (document)
		  {        write("<STYLE TYPE='text/css'>");
		           if (NS4) {
				    write(".parent {position:absolute; visibility:visible}");
					 write(".child {position:absolute; visibility:visible}");
					 write(".regular {position:absolute; visibility:visible}")
					 }
				   else {            write(".child {display:none}")        }
				   write("</STYLE>");
		  }
		  }
	function getIndex(el) {
	 ind = null;
	    for (i=0; i<document.layers.length; i++)
		{        whichEl = document.layers[i];
		      if (whichEl.id == el) {            ind = i;            break;        }    }
			     return ind;}
 function arrange() {
   nextY = document.layers[firstInd].pageY +document.layers[firstInd].document.height;
    for (i=firstInd+1; i<document.layers.length; i++)
	{
	      whichEl = document.layers[i];
		  if (whichEl.visibility != "hide") {
		           whichEl.pageY = nextY;
				   nextY += whichEl.document.height;
		  }
   }
   }
 function initIt()
 {    if (!ver4) return;
      if (NS4) {
	         for (i=0; i<document.layers.length; i++)
			 {
			         whichEl = document.layers[i];
					 if (whichEl.id.indexOf("Child") != -1)
					 whichEl.visibility = "hide";
		     }
			       arrange();
			}
     else {
	       divColl = document.all.tags("DIV");
		   for (i=0; i<divColl.length; i++) {
		      whichEl = divColl(i);
			  if (whichEl.className == "child")
			        whichEl.style.display = "none";
		   }
		   }
}
function expandIt(el) {
       if (!ver4) return;
	   if (IE4) {
	    whichEl1 = eval(el + "Child");
		for(i=1;i<=numTotal;i++){
		whichEl = eval(scores[i] + "Child");
		if(whichEl!=whichEl1) {
			whichEl.style.display = "none";
		}
		}
		whichEl1 = eval(el + "Child");
		 if (whichEl1.style.display == "none") {
		        whichEl1.style.display = "block";   }
		else { whichEl1.style.display = "none";  }
	 }
	 else {
	    whichEl = eval("document." + el + "Child");
		for(i=1;i<=numTotal;i++){
			whichEl = eval("document." + scores[i] + "Child");
			if(whichEl!=whichEl1) {
				whichEl.visibility = "hide";
			}
		}
		if (whichEl.visibility == "hide") {            whichEl.visibility = "show";        }
		else {            whichEl.visibility = "hide";        }
		arrange();
		}
		}
	onload = initIt;
function type(str){
	var p1 = str.lastIndexOf("_");
	return str.substring(p1);
}

function focusCell(e,msg) {
  alert(msg);
  e.select();
  e.focus();
  return false;
}

function check(myForm){
	//�Ϸ��Լ���
	for(var i=0;i<myForm.elements.length;i++){
		var e = myForm.elements[i];

		if(type(e.id)=="_basic"){
			if (!(doanothercheck(e))){
				return false;
			}
		}

		if(type(e.id) == "_notnullnum" || type(e.id) == "_notnullint" ||
                   type(e.id)=="_notNull" || type(e.id)=="_notnull" ||
                   type(e.id) == "_notnullpercent" ){
			if(e.value == ""){
                          return focusCell(e,"�Բ����ֶ����ݲ���Ϊ�գ����������ݣ�");
			}
			if (!(doanothercheck(e))){
				return false;
			}
		}

		if(type(e.id) == "_notnullnum" || type(e.id)=="_num"){
			if(!isNumber(e.value)){
                          return focusCell(e,"�Բ����ֶγ��ȱ����������֣����������룡");
			}
			if (!(doanothercheck(e))){
				return false;
			}
		}

		if (type(e.id) == "_int" || type(e.id) == "_notnullint"){
		    if (!isNumberInt(e.value)){
                      return focusCell(e,"�Բ����ֶγ��ȱ����������������������룡");
                    }
        }

		if(type(e.id)=="_email"){
			if (!((/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(e.value))||(e.value.length==0))){
                          return focusCell(e,"�Բ��𣬱�������Ϸ���Email��ַ�����������룡");
			}

		}

		if(type(e.id)=="_postalCode" || type(e.id)=="_postalcode" || type(e.id)=="_postcode"){
			if(!isNumber(e.value)){
                          return focusCell(e,"�Բ����ʱ����Ϊ6λ���֣����������룡");
			}
			if ((e.value.length!=6)&&(e.value!="")){
                          return focusCell(e,"�Բ����ʱ����Ϊ6λ���֣����������룡");
			}
		}

                if (type(e.id) == "_percent" || type(e.id) == "_notnullpercent") {
                  if (!isPercent(e.value)) {
                    return focusCell(e,"�Բ��𣬱���Ϊ�ٷ��������������룡");
                  }
                }
	}

	return true;
}



 function isNumberInt(str){
	for (var i=0;i<str.length;i++){
		if (!(str.charAt(i)>="0"&&str.charAt(i)<="9"))
			return false;
	}
	return true;
 }


 //����һ���ַ������ж��û�������ǲ�����Ч������������
 function isNumber(str){
	for (var i=0;i<str.length;i++){
		if (!(str.charAt(i)>="0"&&str.charAt(i)<="9"||(str.charAt(i)=="."&&i!=0)))
			return false;
	}
	return true;
 }


function check_email(e) {
if ((/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(e.value))||(e.value.length==0)){
return (true);
}
alert("Invalid E-mail Address! Please re-enter.");
e.select();
e.focus();
return (false);
}

function isPercent(val) {
  if (!isNumber(val)) return false;

  if (val * 1 > 100 || val * 1 < 0) return false;
  return true;
}

function dodacheck(val) {
var mikExp = /[$\\\\\#%\^\&\*\(\)\[\]\+\{\}\`\~\=\|<>]/;
var strPass = val.value;
var strLength = strPass.length;
var lchar = val.value.charAt((strLength) - 1);
if(lchar.search(mikExp) != -1) {
var tst = val.value.substring(0, (strLength) - 1);
val.value = tst;
   }
}
function doanothercheck(form) {
var mikExp = /[$\\\\\#%\^\&\*\(\)\[\]\+\{\}\`\~\=\|<>]/;
if(form.value.search(mikExp) == -1) {
//alert("Correct Input");
return true;
}
else {
alert("���������������� \n\r\n\r@ $ % ^ & * # ( ) [ ] \\ { + } ` ~ =  | \n");
form.select();
form.focus();
return false;
}
//alert("Correct Input");
return true;
}









