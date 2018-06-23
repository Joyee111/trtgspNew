// JavaScript Document

	function aAction (treeA,parentId){
		treePArray=document.getElementById(parentId).getElementsByTagName('a');
		for ( i=0;i<treePArray.length;i++){
			treePArray[i].className="";
		}
		treeA.className="on";
	}
	
	
	
	