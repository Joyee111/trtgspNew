function ajaxQueryMidinceByBatchNumber(typeStr) {
	var batch_number = $("#batch_number").val();
	if (trim(batch_number) == "") {
		alert("请输入药品批号查询！");
		return;
	}
	$.post("drugVarieties/ajaxHomePageMidince.html", {
				batchNumber : batch_number,
				type : typeStr
			}, function(date) {
				var json = jsonParse(date);
				var purchaseorderstate = json.purchaseorderstate;
				var midinceInfo = json.midinceInfo;// 药品
				var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
				var curingPlanStr = json.curingPlanStr;// 养护计划
				var supplierStr = json.supplierStr;// 采购单供应商预警
				var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
				var receiveMedicStr = json.receiveMedicStr;// 药品验收 药品预警
				var checkAcceptStr = json.checkAcceptStr;// 收获药品预警
				var curingPlanStr = json.curingPlanStr;// 养护计划预警
				var maintainStr = json.maintainStr;// 药品养护药品预警
				var saleSupplyStr = json.saleSupplyStr;// 销售订单购货商预警
				var saleMidinceStr = json.saleMidinceStr;// 销售药品预警
			//	alert(purchaseorderstate);

			 if (purchaseorderstate == '7') {
					purchaseorderstate7(json);
				} else if (purchaseorderstate == '0') {
					purchaseorderstate0(json);
				} else if(purchaseorderstate=='2'){
					purchaseorderstate2(json);
				}else if(purchaseorderstate=='1'){
					purchaseorderstate1(json);
				}else if(purchaseorderstate=='3'){
					purchaseorderstate3(json);
				}else if(purchaseorderstate=='4'){
					purchaseorderstate4(json);
				}else if(purchaseorderstate=='44'){
					purchaseorderstate44(json);
				}else if(purchaseorderstate=='5'){
					purchaseorderstate5(json);
				}else if(purchaseorderstate=='55'){
					purchaseorderstate55(json);
				}else if(purchaseorderstate=='6'){
					purchaseorderstate6(json);
				}else if(purchaseorderstate=='66'){
					purchaseorderstate66(json);
				}else if(purchaseorderstate=='8'){
					purchaseorderstate8(json);
				}else if(purchaseorderstate=='9'){
					purchaseorderstate9(json);
				}else if(purchaseorderstate=='999'){
					purchaseorderstate999(json);
				}else if(purchaseorderstate=='10'){
					purchaseorderstate10(json);
				}else if(purchaseorderstate=='11'){
					purchaseorderstate11(json);
				}else if(purchaseorderstate=='12'){
					purchaseorderstate12(json);
				}
			})

}



function purchaseorderstate0(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	var receiveMedicStr = json.receiveMedicStr;// 药品验收 药品预警
	var checkAcceptStr = json.checkAcceptStr;// 收获药品预警
	var batchNumber = json.batchNumber;//批号
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);
	
	//$("#purchaseOrderStr").empty();
	//$("#purchaseOrderStr").append(purchaseOrderStr);

	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);

	$("#table_button0").attr("class", "btn_4c");
	$("#table_button").attr("class", "btn_4c");
	$("#table_button5").attr("class", "btn_4c");
	$("#table_button6").attr("class", "btn_4c");
	$("#table_button7").attr("class", "btn_4c");
	$("#table_button8").attr("class", "btn_4c");
	$("#table_button15").attr("class", "btn_4c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_4c");
	$("#table_button2").attr("class", "btn_4c");
	$("#table_button3").attr("class", "btn_4c");
	$("#table_button4").attr("class", "btn_4c");
	$("#table_button9").attr("class", "btn_4c");
	$("#table_button10").attr("class", "btn_4c");
	$("#table_button11").attr("class", "btn_4c");
	$("#table_button12").attr("class", "btn_4c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d2.gif");
	$("#image_id223").attr("src", "images/g2.gif");
	$("#image_id224").attr("src", "images/d2.gif");
	$("#image_id225").attr("src", "images/g2.gif");
	$("#image_id226").attr("src", "images/d2.gif");

	$("#image_id1").attr("src", "images/sh2_1.gif");
	$("#image_id2").attr("src", "images/sh1.gif");
	$("#image_id3").attr("src", "images/f2_1.gif");

	$("#image_id4").attr("src", "images/hg1.gif");
	$("#image_id5").attr("src", "images/hg1.gif");
	$("#image_id6").attr("src", "images/sh2_1.gif");

	$("#image_id7").attr("src", "images/sh1.gif");
	$("#image_id8").attr("src", "images/sh1.gif");
	$("#image_id9").attr("src", "images/sh1.gif");
	$("#image_id10").attr("src", "images/hg1.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg1.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2_1.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
}
function purchaseorderstate1(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStrErr = json.supplierStrErr;// 采购单供应商预警
	var purchaseMidicineStrErr = json.purchaseMidicineStrErr;// 采购单药品预警
	var batchNumber = json.batchNumber;//批号
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	$("#purchaseSupplyStr").append(supplierStrErr);
	
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append(purchaseMidicineStrErr);
	
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_3c");
	$("#table_button5").attr("class", "btn_4c");
	$("#table_button6").attr("class", "btn_4c");
	$("#table_button7").attr("class", "btn_4c");
	$("#table_button8").attr("class", "btn_4c");
	$("#table_button15").attr("class", "btn_4c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_3c");
	$("#table_button2").attr("class", "btn_4c");
	$("#table_button3").attr("class", "btn_3c");
	$("#table_button4").attr("class", "btn_4c");
	$("#table_button9").attr("class", "btn_4c");
	$("#table_button10").attr("class", "btn_4c");
	$("#table_button11").attr("class", "btn_4c");
	$("#table_button12").attr("class", "btn_4c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g2.gif");
	$("#image_id224").attr("src", "images/d2.gif");
	$("#image_id225").attr("src", "images/g2.gif");
	$("#image_id226").attr("src", "images/d2.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg1.gif");
	$("#image_id5").attr("src", "images/hg1.gif");
	$("#image_id6").attr("src", "images/sh2_1.gif");

	$("#image_id7").attr("src", "images/sh1.gif");
	$("#image_id8").attr("src", "images/sh1.gif");
	$("#image_id9").attr("src", "images/sh1.gif");
	$("#image_id10").attr("src", "images/hg1.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg1.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2_1.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
	var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	
}
function purchaseorderstate2(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStrErr = json.supplierStrErr;// 采购单供应商预警
	//var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	//var receiveMedicStr = json.receiveMedicStr;// 药品验收 药品预警
	//var checkAcceptStr = json.checkAcceptStr;// 收获药品预警
	var purchaseMidicineStrErr = json.purchaseMidicineStrErr;
	var batchNumber = json.batchNumber;//批号
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	$("#purchaseSupplyStr").append(supplierStrErr);
	
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_3c");
	$("#table_button5").attr("class", "btn_4c");
	$("#table_button6").attr("class", "btn_4c");
	$("#table_button7").attr("class", "btn_4c");
	$("#table_button8").attr("class", "btn_4c");
	$("#table_button15").attr("class", "btn_4c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_3c");
	$("#table_button2").attr("class", "btn_4c");
	$("#table_button3").attr("class", "btn_4c");
	$("#table_button4").attr("class", "btn_4c");
	$("#table_button9").attr("class", "btn_4c");
	$("#table_button10").attr("class", "btn_4c");
	$("#table_button11").attr("class", "btn_4c");
	$("#table_button12").attr("class", "btn_4c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g2.gif");
	$("#image_id224").attr("src", "images/d2.gif");
	$("#image_id225").attr("src", "images/g2.gif");
	$("#image_id226").attr("src", "images/d2.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg1.gif");
	$("#image_id5").attr("src", "images/hg1.gif");
	$("#image_id6").attr("src", "images/sh2_1.gif");

	$("#image_id7").attr("src", "images/sh1.gif");
	$("#image_id8").attr("src", "images/sh1.gif");
	$("#image_id9").attr("src", "images/sh1.gif");
	$("#image_id10").attr("src", "images/hg1.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg1.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2_1.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
	var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	
}
function purchaseorderstate3(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStrErr = json.purchaseMidicineStrErr;// 采购单药品预警
	var batchNumber = json.batchNumber;//批号
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	$("#purchaseSupplyStr").append(supplierStr);
	
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append(purchaseMidicineStrErr);
	
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_3c");
	$("#table_button5").attr("class", "btn_4c");
	$("#table_button6").attr("class", "btn_4c");
	$("#table_button7").attr("class", "btn_4c");
	$("#table_button8").attr("class", "btn_4c");
	$("#table_button15").attr("class", "btn_4c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_3c");
	$("#table_button4").attr("class", "btn_4c");
	$("#table_button9").attr("class", "btn_4c");
	$("#table_button10").attr("class", "btn_4c");
	$("#table_button11").attr("class", "btn_4c");
	$("#table_button12").attr("class", "btn_4c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g2.gif");
	$("#image_id224").attr("src", "images/d2.gif");
	$("#image_id225").attr("src", "images/g2.gif");
	$("#image_id226").attr("src", "images/d2.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg1.gif");
	$("#image_id6").attr("src", "images/sh2_1.gif");

	$("#image_id7").attr("src", "images/sh1.gif");
	$("#image_id8").attr("src", "images/sh1.gif");
	$("#image_id9").attr("src", "images/sh1.gif");
	$("#image_id10").attr("src", "images/hg1.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg1.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2_1.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
	var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	
	
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	
}

function purchaseorderstate4(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	var receiveMedicStrErr = json.receiveMedicStrErr;//收获药品过期
	var batchNumber =json.batchNumber;//批号
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
	if(supplierStr!=""){
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	
	$("#purchaseSupplyStr").append(supplierStr);
	}
	if(purchaseMidicineStr!=""){
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append(purchaseMidicineStr);
	
	}
	if(receiveMedicStrErr!=""){
	$("#table_button5").attr("onmouseover","onmouse_show(this)");
	$("#table_button5").attr("onmouseout","onmouse_out()");
	$("#table_button5").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	$("#receiveMedicStr").append(receiveMedicStrErr);
	
	}
	
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_lc");
	$("#table_button5").attr("class", "btn_3c");
	$("#table_button6").attr("class", "btn_4c");
	$("#table_button7").attr("class", "btn_4c");
	$("#table_button8").attr("class", "btn_4c");
	$("#table_button15").attr("class", "btn_4c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_lc2");
	$("#table_button4").attr("class", "btn_lc2");
	$("#table_button9").attr("class", "btn_4c");
	$("#table_button10").attr("class", "btn_4c");
	$("#table_button11").attr("class", "btn_4c");
	$("#table_button12").attr("class", "btn_4c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g.gif");
	$("#image_id224").attr("src", "images/d.gif");
	$("#image_id225").attr("src", "images/g2.gif");
	$("#image_id226").attr("src", "images/d2.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg1.gif");
	$("#image_id6").attr("src", "images/sh2.gif");

	$("#image_id7").attr("src", "images/sh1.gif");
	$("#image_id8").attr("src", "images/sh1.gif");
	$("#image_id9").attr("src", "images/sh1.gif");
	$("#image_id10").attr("src", "images/hg1.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg1.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2_1.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
	var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	var home_sh = json.home_sh;//收获
	
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_sh!=null && home_sh!=""){
		add_button_link("table_button5","drugState/inspectionRecords/list.html")
		
	}
	
}
function purchaseorderstate44(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	//var receiveMedicStrErr = json.receiveMedicStrErr;//收获药品过期
	var batchNumber =json.batchNumber;//批号
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
	if(supplierStr!=""){
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	
	$("#purchaseSupplyStr").append(supplierStr);
	}
	if(purchaseMidicineStr!=""){
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append("");
	
	}
	$("#table_button5").attr("onmouseover","onmouse_show(this)");
	$("#table_button5").attr("onmouseout","onmouse_out()");
	$("#table_button5").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	$("#receiveMedicStr").append("<li><a>没有收获记录</a></li>");
	
	
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_lc");
	$("#table_button5").attr("class", "btn_3c");
	$("#table_button6").attr("class", "btn_4c");
	$("#table_button7").attr("class", "btn_4c");
	$("#table_button8").attr("class", "btn_4c");
	$("#table_button15").attr("class", "btn_4c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_lc2");
	$("#table_button4").attr("class", "btn_lc2");
	$("#table_button9").attr("class", "btn_4c");
	$("#table_button10").attr("class", "btn_4c");
	$("#table_button11").attr("class", "btn_4c");
	$("#table_button12").attr("class", "btn_4c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g.gif");
	$("#image_id224").attr("src", "images/d.gif");
	$("#image_id225").attr("src", "images/g2.gif");
	$("#image_id226").attr("src", "images/d2.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg1.gif");
	$("#image_id6").attr("src", "images/sh2.gif");

	$("#image_id7").attr("src", "images/sh1.gif");
	$("#image_id8").attr("src", "images/sh1.gif");
	$("#image_id9").attr("src", "images/sh1.gif");
	$("#image_id10").attr("src", "images/hg1.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg1.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2_1.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
	var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	
	
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	
}
function purchaseorderstate5(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	var receiveMedicStr = json.receiveMedicStr;//收获药品预警
	var checkAcceptStr = json.checkAcceptStr;
	var batchNumber = json.batchNumber;
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
	if(supplierStr!=""){
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	
	$("#purchaseSupplyStr").append(supplierStr);
	}
	if(purchaseMidicineStr!=""){
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append("");
	
	}
	if(receiveMedicStr!='' && receiveMedicStr!==null ){
	$("#table_button5").attr("onmouseover","onmouse_show(this)");
	$("#table_button5").attr("onmouseout","onmouse_out()");
	$("#table_button5").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	$("#receiveMedicStr").append(receiveMedicStr);
	}
	
	$("#table_button6").attr("onmouseover","onmouse_show(this)");
	$("#table_button6").attr("onmouseout","onmouse_out()");
	$("#table_button6").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	$("#checkAcceptStr").append("<li><a>没有验收记录</a></li>");
	
	
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_lc");
	$("#table_button5").attr("class", "btn_lc");
	$("#table_button6").attr("class", "btn_3c");
	$("#table_button7").attr("class", "btn_4c");
	$("#table_button8").attr("class", "btn_4c");
	$("#table_button15").attr("class", "btn_4c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_lc2");
	$("#table_button4").attr("class", "btn_lc2");
	$("#table_button9").attr("class", "btn_4c");
	$("#table_button10").attr("class", "btn_4c");
	$("#table_button11").attr("class", "btn_4c");
	$("#table_button12").attr("class", "btn_4c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g.gif");
	$("#image_id224").attr("src", "images/d.gif");
	$("#image_id225").attr("src", "images/g2.gif");
	$("#image_id226").attr("src", "images/d2.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg1.gif");
	$("#image_id6").attr("src", "images/sh2.gif");

	$("#image_id7").attr("src", "images/sh.gif");
	$("#image_id8").attr("src", "images/sh1.gif");
	$("#image_id9").attr("src", "images/sh1.gif");
	$("#image_id10").attr("src", "images/hg1.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg1.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2_1.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
	var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	var home_sh = json.home_sh;//收获
	
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_sh!=null && home_sh!=""){
		add_button_link("table_button5","drugState/inspectionRecords/list.html")
		
	}
	
}
function purchaseorderstate55(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	var receiveMedicStr = json.receiveMedicStr;//收获药品预警
	var checkAcceptStrErr = json.checkAcceptStrErr;
	var batchNumber = batchNumber;
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
	if(supplierStr!=""){
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	
	$("#purchaseSupplyStr").append(supplierStr);
	}
	if(purchaseMidicineStr!=""){
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append("");
	
	}
	if(receiveMedicStr!='' && receiveMedicStr!==null ){
	$("#table_button5").attr("onmouseover","onmouse_show(this)");
	$("#table_button5").attr("onmouseout","onmouse_out()");
	$("#table_button5").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	$("#receiveMedicStr").append(receiveMedicStr);
	}
	
	$("#table_button6").attr("onmouseover","onmouse_show(this)");
	$("#table_button6").attr("onmouseout","onmouse_out()");
	$("#table_button6").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	$("#checkAcceptStr").append(checkAcceptStrErr);
	
	
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_lc");
	$("#table_button5").attr("class", "btn_lc");
	$("#table_button6").attr("class", "btn_3c");
	$("#table_button7").attr("class", "btn_4c");
	$("#table_button8").attr("class", "btn_4c");
	$("#table_button15").attr("class", "btn_4c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_lc2");
	$("#table_button4").attr("class", "btn_lc2");
	$("#table_button9").attr("class", "btn_4c");
	$("#table_button10").attr("class", "btn_4c");
	$("#table_button11").attr("class", "btn_4c");
	$("#table_button12").attr("class", "btn_4c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g.gif");
	$("#image_id224").attr("src", "images/d.gif");
	$("#image_id225").attr("src", "images/g2.gif");
	$("#image_id226").attr("src", "images/d2.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg1.gif");
	$("#image_id6").attr("src", "images/sh2.gif");

	$("#image_id7").attr("src", "images/sh.gif");
	$("#image_id8").attr("src", "images/sh1.gif");
	$("#image_id9").attr("src", "images/sh1.gif");
	$("#image_id10").attr("src", "images/hg1.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg1.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2_1.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
	var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	var home_sh = json.home_sh;//收获
	var home_ys = json.home_ys;//验收
	
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_sh!=null && home_sh!=""){
		add_button_link("table_button5","drugState/inspectionRecords/list.html")
		
	}
	if(home_ys!=null && home_ys!=""){
		add_button_link("table_button6","comQuery/inspeAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	
}

function purchaseorderstate6(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	var receiveMedicStr = json.receiveMedicStr;//收获药品预警
	var checkAcceptStr = json.checkAcceptStr;
	var curingPlan = json.curingPlan;
	var batchNumber = json.batchNumber;
	
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
	if(supplierStr!=""){
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	
	$("#purchaseSupplyStr").append(supplierStr);
	}
	if(purchaseMidicineStr!=""){
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append("");
	
	}
	if(receiveMedicStr!='' && receiveMedicStr!==null ){
	$("#table_button5").attr("onmouseover","onmouse_show(this)");
	$("#table_button5").attr("onmouseout","onmouse_out()");
	$("#table_button5").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	$("#receiveMedicStr").append(receiveMedicStr);
	}
	if(checkAcceptStr!=""){
	$("#table_button6").attr("onmouseover","onmouse_show(this)");
	$("#table_button6").attr("onmouseout","onmouse_out()");
	$("#table_button6").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	$("#checkAcceptStr").append(checkAcceptStr);
	}
	$("#table_button7").attr("onmouseover","onmouse_show(this)");
	$("#table_button7").attr("onmouseout","onmouse_out()");
	$("#table_button7").attr("onclick","onclick_button(this)");
	$("#curingPlanStr").empty();
	$("#curingPlanStr").append("<li><a href='#'>没有生成养护计划</a></li>");
	
	
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_lc");
	$("#table_button5").attr("class", "btn_lc");
	$("#table_button6").attr("class", "btn_lc");
	$("#table_button7").attr("class", "btn_3c");
	$("#table_button8").attr("class", "btn_4c");
	$("#table_button15").attr("class", "btn_4c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_lc2");
	$("#table_button4").attr("class", "btn_lc2");
	$("#table_button9").attr("class", "btn_4c");
	$("#table_button10").attr("class", "btn_4c");
	$("#table_button11").attr("class", "btn_4c");
	$("#table_button12").attr("class", "btn_4c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g.gif");
	$("#image_id224").attr("src", "images/d.gif");
	$("#image_id225").attr("src", "images/g2.gif");
	$("#image_id226").attr("src", "images/d2.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg1.gif");
	$("#image_id6").attr("src", "images/sh2.gif");

	$("#image_id7").attr("src", "images/sh.gif");
	$("#image_id8").attr("src", "images/sh.gif");
	$("#image_id9").attr("src", "images/sh1.gif");
	$("#image_id10").attr("src", "images/hg1.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg1.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2_1.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
	
	
	var home_cgjh = json.home_cgjh;//采购计划
	//alert(home_cgjh)
	var home_cgdd = json.home_cgdd;//采购订单
	//alert(home_cgdd);
	var home_sh = json.home_sh;//收获
	//alert(home_sh);
	var home_ys = json.home_ys;//验收
	//alert(home_ys);
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
	//	alert(home_cgjh)
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
	//	alert(home_cgdd);
		
	}
	if(home_sh!=null && home_sh!=""){
		add_button_link("table_button5","drugState/inspectionRecords/list.html")
		
	}
	if(home_ys!=null && home_ys!=""){
		add_button_link("table_button6","comQuery/inspeAcceptRecords/query.html?pihao="+batchNumber)
		
	}
}
function purchaseorderstate7(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	//alert(purchaseOrderStr);
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	var receiveMedicStr = json.receiveMedicStr;// 药品验收 药品预警
	var checkAcceptStr = json.checkAcceptStr;// 收获药品预警
	var curingPlanStr = json.curingPlanStr;//养护计划
	var batchNumber = json.batchNumber;
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	
	if(supplierStr!=""){
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	
	$("#purchaseSupplyStr").append(supplierStr);
	}
	if(purchaseMidicineStr!=""){
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append(purchaseMidicineStr);
	
	}
	
	if(receiveMedicStr!='' && receiveMedicStr!==null ){
	$("#table_button5").attr("onmouseover","onmouse_show(this)");
	$("#table_button5").attr("onmouseout","onmouse_out()");
	$("#table_button5").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	//alert(receiveMedicStr);
	$("#receiveMedicStr").append(receiveMedicStr);
	}
	//alert(checkAcceptStr);
	if(checkAcceptStr!=""){
	$("#table_button6").attr("onmouseover","onmouse_show(this)");
	$("#table_button6").attr("onmouseout","onmouse_out()");
	$("#table_button6").attr("onclick","onclick_button(this)");
	$("#checkAcceptStr").empty();
	$("#checkAcceptStr").append(checkAcceptStr);
	}
	if(curingPlanStr!=""){
	$("#table_button7").attr("onmouseover","onmouse_show(this)");
	$("#table_button7").attr("onmouseout","onmouse_out()");
	$("#table_button7").attr("onclick","onclick_button(this)");
	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
		
	}
	
	$("#table_button8").attr("onmouseover","onmouse_show(this)");
	$("#table_button8").attr("onmouseout","onmouse_out()");
	$("#table_button8").attr("onclick","onclick_button(this)");
	$("#maintainStr").empty();
	$("#maintainStr").append("<li><a>没有养护记录</a></li>");
	
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_lc");
	$("#table_button5").attr("class", "btn_lc");
	$("#table_button6").attr("class", "btn_lc");
	$("#table_button7").attr("class", "btn_lc");
	$("#table_button8").attr("class", "btn_3c");
	$("#table_button15").attr("class", "btn_4c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_lc2");
	$("#table_button4").attr("class", "btn_lc2");
	$("#table_button9").attr("class", "btn_4c");
	$("#table_button10").attr("class", "btn_4c");
	$("#table_button11").attr("class", "btn_4c");
	$("#table_button12").attr("class", "btn_4c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g.gif");
	$("#image_id224").attr("src", "images/d.gif");
	$("#image_id225").attr("src", "images/g2.gif");
	$("#image_id226").attr("src", "images/d2.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg.gif");
	$("#image_id6").attr("src", "images/sh2.gif");

	$("#image_id7").attr("src", "images/sh.gif");
	$("#image_id8").attr("src", "images/sh.gif");
	$("#image_id9").attr("src", "images/sh.gif");
	$("#image_id10").attr("src", "images/hg1.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg1.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2_1.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
	var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	var home_sh = json.home_sh;//收获
	var home_ys = json.home_ys;//验收
	var home_yhjh = json.home_yhjh;//养护计划
	
	
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_sh!=null && home_sh!=""){
		add_button_link("table_button5","drugState/inspectionRecords/list.html")
		
	}
	if(home_ys!=null && home_ys!=""){
		add_button_link("table_button6","comQuery/inspeAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	
	if(home_yhjh!=null && home_yhjh!=""){
		add_button_link("table_button7","drugState/MaintenancePlan/list.html")
		
	}
	
}
function purchaseorderstate8(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	//alert(purchaseOrderStr);
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	var receiveMedicStr = json.receiveMedicStr;// 药品验收 药品预警
	var checkAcceptStr = json.checkAcceptStr;// 收获药品预警
	var curingPlanStr = json.curingPlanStr;//养护计划
	var maintainStrErr = json.maintainStr;//养护药品
	var batchNumber = json.batchNumber;
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	
	if(supplierStr!=""){
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	
	$("#purchaseSupplyStr").append(supplierStr);
	}
	if(purchaseMidicineStr!=""){
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append(purchaseMidicineStr);
	
	}
	
	if(receiveMedicStr!='' && receiveMedicStr!==null ){
	$("#table_button5").attr("onmouseover","onmouse_show(this)");
	$("#table_button5").attr("onmouseout","onmouse_out()");
	$("#table_button5").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	//alert(receiveMedicStr);
	$("#receiveMedicStr").append(receiveMedicStr);
	}
	//alert(checkAcceptStr);
	if(checkAcceptStr!=""){
	$("#table_button6").attr("onmouseover","onmouse_show(this)");
	$("#table_button6").attr("onmouseout","onmouse_out()");
	$("#table_button6").attr("onclick","onclick_button(this)");
	$("#checkAcceptStr").empty();
	$("#checkAcceptStr").append(checkAcceptStr);
	}
	if(curingPlanStr!=""){
	$("#table_button7").attr("onmouseover","onmouse_show(this)");
	$("#table_button7").attr("onmouseout","onmouse_out()");
	$("#table_button7").attr("onclick","onclick_button(this)");
	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
		
	}
	if(maintainStrErr!=""){
	$("#table_button8").attr("onmouseover","onmouse_show(this)");
	$("#table_button8").attr("onmouseout","onmouse_out()");
	$("#table_button8").attr("onclick","onclick_button(this)");
	$("#maintainStr").empty();
	$("#maintainStr").append(maintainStrErr);
	}
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_lc");
	$("#table_button5").attr("class", "btn_lc");
	$("#table_button6").attr("class", "btn_lc");
	$("#table_button7").attr("class", "btn_lc");
	$("#table_button8").attr("class", "btn_3c");
	$("#table_button15").attr("class", "btn_4c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_lc2");
	$("#table_button4").attr("class", "btn_lc2");
	$("#table_button9").attr("class", "btn_4c");
	$("#table_button10").attr("class", "btn_4c");
	$("#table_button11").attr("class", "btn_4c");
	$("#table_button12").attr("class", "btn_4c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g.gif");
	$("#image_id224").attr("src", "images/d.gif");
	$("#image_id225").attr("src", "images/g2.gif");
	$("#image_id226").attr("src", "images/d2.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg.gif");
	$("#image_id6").attr("src", "images/sh2.gif");

	$("#image_id7").attr("src", "images/sh.gif");
	$("#image_id8").attr("src", "images/sh.gif");
	$("#image_id9").attr("src", "images/sh.gif");
	$("#image_id10").attr("src", "images/hg1.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg1.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2_1.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
	
	var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	var home_sh = json.home_sh;//收获
	var home_ys = json.home_ys;//验收
	var home_yhjh = json.home_yhjh;//养护计划
	var home_yhjl = json.home_yhjl;//养护记录
	
	
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_sh!=null && home_sh!=""){
		add_button_link("table_button5","drugState/inspectionRecords/list.html")
		
	}
	if(home_ys!=null && home_ys!=""){
		add_button_link("table_button6","comQuery/inspeAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	
	if(home_yhjh!=null && home_yhjh!=""){
		add_button_link("table_button7","drugState/MaintenancePlan/list.html")
		
	}
	if(home_yhjl!=null && home_yhjl!=""){
		add_button_link("table_button8","comQuery/conserveAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	
}
function purchaseorderstate9(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	//alert(purchaseOrderStr);
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	var receiveMedicStr = json.receiveMedicStr;// 药品验收 药品预警
	var checkAcceptStr = json.checkAcceptStr;// 收获药品预警
	var curingPlanStr = json.curingPlanStr;//养护计划
	var maintainStrErr = json.maintainStr;//养护药品
	var batchNumber = json.batchNumber;//批号
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	
	if(supplierStr!=""){
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	
	$("#purchaseSupplyStr").append(supplierStr);
	}
	if(purchaseMidicineStr!=""){
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append(purchaseMidicineStr);
	
	}
	
	if(receiveMedicStr!='' && receiveMedicStr!==null ){
	$("#table_button5").attr("onmouseover","onmouse_show(this)");
	$("#table_button5").attr("onmouseout","onmouse_out()");
	$("#table_button5").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	//alert(receiveMedicStr);
	$("#receiveMedicStr").append(receiveMedicStr);
	}
	//alert(checkAcceptStr);
	if(checkAcceptStr!=""){
	$("#table_button6").attr("onmouseover","onmouse_show(this)");
	$("#table_button6").attr("onmouseout","onmouse_out()");
	$("#table_button6").attr("onclick","onclick_button(this)");
	$("#checkAcceptStr").empty();
	$("#checkAcceptStr").append(checkAcceptStr);
	}
	if(curingPlanStr!=""){
	$("#table_button7").attr("onmouseover","onmouse_show(this)");
	$("#table_button7").attr("onmouseout","onmouse_out()");
	$("#table_button7").attr("onclick","onclick_button(this)");
	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
		
	}
	if(maintainStrErr!=""){
	$("#table_button8").attr("onmouseover","onmouse_show(this)");
	$("#table_button8").attr("onmouseout","onmouse_out()");
	$("#table_button8").attr("onclick","onclick_button(this)");
	$("#maintainStr").empty();
	$("#maintainStr").append(maintainStrErr);
	}
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_lc");
	$("#table_button5").attr("class", "btn_lc");
	$("#table_button6").attr("class", "btn_lc");
	$("#table_button7").attr("class", "btn_lc");
	$("#table_button8").attr("class", "btn_lc");
	$("#table_button15").attr("class", "btn_4c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_lc2");
	$("#table_button4").attr("class", "btn_lc2");
	$("#table_button9").attr("class", "btn_4c");
	$("#table_button10").attr("class", "btn_4c");
	$("#table_button11").attr("class", "btn_4c");
	$("#table_button12").attr("class", "btn_4c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g.gif");
	$("#image_id224").attr("src", "images/d.gif");
	$("#image_id225").attr("src", "images/g.gif");
	$("#image_id226").attr("src", "images/d2.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg.gif");
	$("#image_id6").attr("src", "images/sh2.gif");

	$("#image_id7").attr("src", "images/sh.gif");
	$("#image_id8").attr("src", "images/sh.gif");
	$("#image_id9").attr("src", "images/sh.gif");
	$("#image_id10").attr("src", "images/hg1.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg1.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2_1.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
	var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	
	var home_sh = json.home_sh;//收获
	var home_ys = json.home_ys;//验收
	var home_yhjh = json.home_yhjh;//养护计划
	var home_yhjl = json.home_yhjl;//养护记录

	
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_sh!=null && home_sh!=""){
		add_button_link("table_button5","drugState/inspectionRecords/list.html")
		
	}
	if(home_ys!=null && home_ys!=""){
		add_button_link("table_button6","comQuery/inspeAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	
	if(home_yhjh!=null && home_yhjh!=""){
		add_button_link("table_button7","drugState/MaintenancePlan/list.html")
		
	}
	if(home_yhjl!=null && home_yhjl!=""){
		//alert("home_yhjl")
		add_button_link("table_button8","comQuery/conserveAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	
}
function purchaseorderstate99(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	//alert(purchaseOrderStr);
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	var receiveMedicStr = json.receiveMedicStr;// 药品验收 药品预警
	var checkAcceptStr = json.checkAcceptStr;// 收获药品预警
	var curingPlanStr = json.curingPlanStr;//养护计划
	var maintainStrErr = json.maintainStr;//养护药品
	var saleSupplyStrErr = json.saleSupplyStrErr;
	var saleMidinceStrErr = json.saleMidinceStrErr;
	var batchNumber = json.batchNumber;//批号
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	
	if(supplierStr!=""){
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	
	$("#purchaseSupplyStr").append(supplierStr);
	}
	if(purchaseMidicineStr!=""){
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append(purchaseMidicineStr);
	
	}
	
	if(receiveMedicStr!='' && receiveMedicStr!==null ){
	$("#table_button5").attr("onmouseover","onmouse_show(this)");
	$("#table_button5").attr("onmouseout","onmouse_out()");
	$("#table_button5").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	//alert(receiveMedicStr);
	$("#receiveMedicStr").append(receiveMedicStr);
	}
	//alert(checkAcceptStr);
	if(checkAcceptStr!=""){
	$("#table_button6").attr("onmouseover","onmouse_show(this)");
	$("#table_button6").attr("onmouseout","onmouse_out()");
	$("#table_button6").attr("onclick","onclick_button(this)");
	$("#checkAcceptStr").empty();
	$("#checkAcceptStr").append(checkAcceptStr);
	}
	if(curingPlanStr!=""){
	$("#table_button7").attr("onmouseover","onmouse_show(this)");
	$("#table_button7").attr("onmouseout","onmouse_out()");
	$("#table_button7").attr("onclick","onclick_button(this)");
	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
		
	}
	if(maintainStrErr!=""){
	$("#table_button8").attr("onmouseover","onmouse_show(this)");
	$("#table_button8").attr("onmouseout","onmouse_out()");
	$("#table_button8").attr("onclick","onclick_button(this)");
	$("#maintainStr").empty();
	$("#maintainStr").append(maintainStrErr);
	}
	if(saleSupplyStrErr!=""){
	$("#table_button10").attr("onmouseover","onmouse_show(this)");
	$("#table_button10").attr("onmouseout","onmouse_out()");
	$("#table_button10").attr("onclick","onclick_button(this)");
	$("#saleSupplyStrErr").empty();
	$("#saleSupplyStrErr").append(saleSupplyStrErr);
	}
	if(saleMidinceStrErr!=""){
	$("#table_button12").attr("onmouseover","onmouse_show(this)");
	$("#table_button12").attr("onmouseout","onmouse_out()");
	$("#table_button12").attr("onclick","onclick_button(this)");
	$("#saleMidinceStr").empty();
	$("#saleMidinceStr").append(saleMidinceStrsaleMidinceStrErr);
	}
	
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_lc");
	$("#table_button5").attr("class", "btn_lc");
	$("#table_button6").attr("class", "btn_lc");
	$("#table_button7").attr("class", "btn_lc");
	$("#table_button8").attr("class", "btn_lc");
	$("#table_button15").attr("class", "btn_3c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_lc2");
	$("#table_button4").attr("class", "btn_lc2");
	$("#table_button9").attr("class", "btn_lc");
	$("#table_button10").attr("class", "btn_3c");
	$("#table_button11").attr("class", "btn_lc");
	$("#table_button12").attr("class", "btn_3c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g.gif");
	$("#image_id224").attr("src", "images/d.gif");
	$("#image_id225").attr("src", "images/g.gif");
	$("#image_id226").attr("src", "images/d.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg.gif");
	$("#image_id6").attr("src", "images/sh2.gif");

	$("#image_id7").attr("src", "images/sh.gif");
	$("#image_id8").attr("src", "images/sh.gif");
	$("#image_id9").attr("src", "images/sh.gif");
	$("#image_id10").attr("src", "images/hg.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg1.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
		var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	var home_sh = json.home_sh;//收获
	var home_ys = json.home_ys;//验收
	var home_yhjh = json.home_yhjh;//养护计划
	var home_yhjl = json.home_yhjl;//养护记录

	
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_sh!=null && home_sh!=""){
		add_button_link("table_button5","drugState/inspectionRecords/list.html")
		
	}
	if(home_ys!=null && home_ys!=""){
		add_button_link("table_button6","comQuery/inspeAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	
	if(home_yhjh!=null && home_yhjh!=""){
		add_button_link("table_button7","drugState/MaintenancePlan/list.html")
		
	}
	if(home_yhjl!=null && home_yhjl!=""){
		add_button_link("table_button8","comQuery/conserveAcceptRecords/query.html?pihao="+batchNumber)
		
	}
}
function purchaseorderstate999(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	//alert(purchaseOrderStr);
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	var receiveMedicStr = json.receiveMedicStr;// 药品验收 药品预警
	var checkAcceptStr = json.checkAcceptStr;// 收获药品预警
	var curingPlanStr = json.curingPlanStr;//养护计划
	var maintainStrErr = json.maintainStr;//养护药品
	var saleSupplyStrErr = json.saleSupplyStrErr;
	var batchNumber = json.batchNumber;//批号
	//var saleMidinceStrErr = json.saleMidinceStrErr;
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	
	if(supplierStr!=""){
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	
	$("#purchaseSupplyStr").append(supplierStr);
	}
	if(purchaseMidicineStr!=""){
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append(purchaseMidicineStr);
	
	}
	
	if(receiveMedicStr!='' && receiveMedicStr!==null ){
	$("#table_button5").attr("onmouseover","onmouse_show(this)");
	$("#table_button5").attr("onmouseout","onmouse_out()");
	$("#table_button5").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	//alert(receiveMedicStr);
	$("#receiveMedicStr").append(receiveMedicStr);
	}
	//alert(checkAcceptStr);
	if(checkAcceptStr!=""){
	$("#table_button6").attr("onmouseover","onmouse_show(this)");
	$("#table_button6").attr("onmouseout","onmouse_out()");
	$("#table_button6").attr("onclick","onclick_button(this)");
	$("#checkAcceptStr").empty();
	$("#checkAcceptStr").append(checkAcceptStr);
	}
	if(curingPlanStr!=""){
	$("#table_button7").attr("onmouseover","onmouse_show(this)");
	$("#table_button7").attr("onmouseout","onmouse_out()");
	$("#table_button7").attr("onclick","onclick_button(this)");
	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
		
	}
	if(maintainStrErr!=""){
	$("#table_button8").attr("onmouseover","onmouse_show(this)");
	$("#table_button8").attr("onmouseout","onmouse_out()");
	$("#table_button8").attr("onclick","onclick_button(this)");
	$("#maintainStr").empty();
	$("#maintainStr").append(maintainStrErr);
	}
	if(saleSupplyStrErr!=""){
	$("#table_button10").attr("onmouseover","onmouse_show(this)");
	$("#table_button10").attr("onmouseout","onmouse_out()");
	$("#table_button10").attr("onclick","onclick_button(this)");
	$("#saleSupplyStrErr").empty();
	$("#saleSupplyStrErr").append(saleSupplyStrErr);
	}
	/*if(saleMidinceStrErr!=""){
	$("#table_button12").attr("onmouseover","onmouse_show(this)");
	$("#table_button12").attr("onmouseout","onmouse_out()");
	$("#table_button12").attr("onclick","onclick_button(this)");
	$("#saleMidinceStr").empty();
	$("#saleMidinceStr").append(saleMidinceStrsaleMidinceStrErr);
	}*/
	
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_lc");
	$("#table_button5").attr("class", "btn_lc");
	$("#table_button6").attr("class", "btn_lc");
	$("#table_button7").attr("class", "btn_lc");
	$("#table_button8").attr("class", "btn_lc");
	$("#table_button15").attr("class", "btn_3c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_lc2");
	$("#table_button4").attr("class", "btn_lc2");
	$("#table_button9").attr("class", "btn_lc");
	$("#table_button10").attr("class", "btn_lc");
	$("#table_button11").attr("class", "btn_lc");
	$("#table_button12").attr("class", "btn_3c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g.gif");
	$("#image_id224").attr("src", "images/d.gif");
	$("#image_id225").attr("src", "images/g.gif");
	$("#image_id226").attr("src", "images/d.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg.gif");
	$("#image_id6").attr("src", "images/sh2.gif");

	$("#image_id7").attr("src", "images/sh.gif");
	$("#image_id8").attr("src", "images/sh.gif");
	$("#image_id9").attr("src", "images/sh.gif");
	$("#image_id10").attr("src", "images/hg.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
		var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	var home_sh = json.home_sh;//收获
	var home_ys = json.home_ys;//验收
	var home_yhjh = json.home_yhjh;//养护计划
	var home_yhjl = json.home_yhjl;//养护记录

	
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_sh!=null && home_sh!=""){
		add_button_link("table_button5","drugState/inspectionRecords/list.html")
		
	}
	if(home_ys!=null && home_ys!=""){
		add_button_link("table_button6","comQuery/inspeAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	
	if(home_yhjh!=null && home_yhjh!=""){
		add_button_link("table_button7","drugState/MaintenancePlan/list.html")
		
	}
	if(home_yhjl!=null && home_yhjl!=""){
		add_button_link("table_button8","comQuery/conserveAcceptRecords/query.html?pihao="+batchNumber)
		
	}
}
function purchaseorderstate10(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	//alert(purchaseOrderStr);
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	var receiveMedicStr = json.receiveMedicStr;// 药品验收 药品预警
	var checkAcceptStr = json.checkAcceptStr;// 收获药品预警
	var curingPlanStr = json.curingPlanStr;//养护计划
	var maintainStrErr = json.maintainStr;//养护药品
	var saleSupplyStr = json.saleSupplyStr;
	var saleMidinceStrErr = json.saleMidinceStrErr;
	var batchNumber = json.batchNumber;//批号
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	
	if(supplierStr!=""){
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	
	$("#purchaseSupplyStr").append(supplierStr);
	}
	if(purchaseMidicineStr!=""){
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append(purchaseMidicineStr);
	
	}
	
	if(receiveMedicStr!='' && receiveMedicStr!==null ){
	$("#table_button5").attr("onmouseover","onmouse_show(this)");
	$("#table_button5").attr("onmouseout","onmouse_out()");
	$("#table_button5").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	//alert(receiveMedicStr);
	$("#receiveMedicStr").append(receiveMedicStr);
	}
	//alert(checkAcceptStr);
	if(checkAcceptStr!=""){
	$("#table_button6").attr("onmouseover","onmouse_show(this)");
	$("#table_button6").attr("onmouseout","onmouse_out()");
	$("#table_button6").attr("onclick","onclick_button(this)");
	$("#checkAcceptStr").empty();
	$("#checkAcceptStr").append(checkAcceptStr);
	}
	if(curingPlanStr!=""){
	$("#table_button7").attr("onmouseover","onmouse_show(this)");
	$("#table_button7").attr("onmouseout","onmouse_out()");
	$("#table_button7").attr("onclick","onclick_button(this)");
	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
		
	}
	if(maintainStrErr!=""){
	$("#table_button8").attr("onmouseover","onmouse_show(this)");
	$("#table_button8").attr("onmouseout","onmouse_out()");
	$("#table_button8").attr("onclick","onclick_button(this)");
	$("#maintainStr").empty();
	$("#maintainStr").append(maintainStrErr);
	}
	if(saleSupplyStr!=""){
	$("#table_button10").attr("onmouseover","onmouse_show(this)");
	$("#table_button10").attr("onmouseout","onmouse_out()");
	$("#table_button10").attr("onclick","onclick_button(this)");
	$("#saleSupplyStrErr").empty();
	$("#saleSupplyStrErr").append(saleSupplyStr);
	}
	if(saleMidinceStrErr!=""){
	$("#table_button12").attr("onmouseover","onmouse_show(this)");
	$("#table_button12").attr("onmouseout","onmouse_out()");
	$("#table_button12").attr("onclick","onclick_button(this)");
	$("#saleMidinceStr").empty();
	$("#saleMidinceStr").append(saleMidinceStrsaleMidinceStrErr);
	}
	
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_lc");
	$("#table_button5").attr("class", "btn_lc");
	$("#table_button6").attr("class", "btn_lc");
	$("#table_button7").attr("class", "btn_lc");
	$("#table_button8").attr("class", "btn_lc");
	$("#table_button15").attr("class", "btn_3c");
	$("#table_button16").attr("class", "btn_4c");
	$("#table_button17").attr("class", "btn_4c");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_lc2");
	$("#table_button4").attr("class", "btn_lc2");
	$("#table_button9").attr("class", "btn_lc");
	$("#table_button10").attr("class", "btn_lc");
	$("#table_button11").attr("class", "btn_lc");
	$("#table_button12").attr("class", "btn_4c");
	$("#table_button13").attr("class", "btn_4c");
	$("#table_button14").attr("class", "btn_4c");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g.gif");
	$("#image_id224").attr("src", "images/d.gif");
	$("#image_id225").attr("src", "images/g.gif");
	$("#image_id226").attr("src", "images/d.gif");

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg.gif");
	$("#image_id6").attr("src", "images/sh2.gif");

	$("#image_id7").attr("src", "images/sh.gif");
	$("#image_id8").attr("src", "images/sh.gif");
	$("#image_id9").attr("src", "images/sh.gif");
	$("#image_id10").attr("src", "images/hg.gif");
	$("#image_id11").attr("src", "images/f3_1.gif");
	$("#image_id12").attr("src", "images/hg.gif");
	$("#image_id14").attr("src", "images/hg1.gif");
	$("#image_id15").attr("src", "images/sh2.gif");
	$("#image_id16").attr("src", "images/sh2_1.gif");
	$("#image_id17").attr("src", "images/sh2_1.gif");
	
	var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	var home_sh = json.home_sh;//收获
	var home_ys = json.home_ys;//验收
	var home_yhjh = json.home_yhjh;//养护计划
	var home_yhjl = json.home_yhjl;//养护记录
	var home_xsdd = json.home_xsdd;
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_sh!=null && home_sh!=""){
		add_button_link("table_button5","drugState/inspectionRecords/list.html")
		
	}
	if(home_ys!=null && home_ys!=""){
		add_button_link("table_button6","comQuery/inspeAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_yhjh!=null && home_yhjh!=""){
		add_button_link("table_button7","drugState/MaintenancePlan/list.html")
		
	}
	if(home_yhjl!=null && home_yhjl!=""){
		add_button_link("table_button8","comQuery/conserveAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_xsdd!=null && home_xsdd!=""){
		add_button_link("table_button15","comQuery/drugSaleRecords/query.html?pihao="+batchNumber)
		
	}
	
}
function purchaseorderstate11(json) {
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	var receiveMedicStr = json.receiveMedicStr;//收获药品预警
	var checkAcceptStr = json.checkAcceptStr;
	var curingPlanErr = json.curingPlanErr;
	var batchNumber = json.batchNumber;
	$(".mar_l1").empty();
	$(".mar_l1").append(midinceInfo);

	$("#purchaseOrderStr").empty();
	$("#purchaseOrderStr").append(purchaseOrderStr);
	$("#table_button").attr("onmouseover","onmouse_show(this)");
	$("#table_button").attr("onmouseout","onmouse_out()");
	$("#table_button").attr("onclick","onclick_button(this)");

	$("#curingPlanStr").empty();
	$("#curingPlanStr").append(curingPlanStr);
	if(supplierStr!=""){
	$("#table_button1").attr("onmouseover","onmouse_show(this)");
	$("#table_button1").attr("onmouseout","onmouse_out()");
	$("#table_button1").attr("onclick","onclick_button(this)");
	
	$("#purchaseSupplyStr").empty();
	
	$("#purchaseSupplyStr").append(supplierStr);
	}
	if(purchaseMidicineStr!=""){
	$("#table_button3").attr("onmouseover","onmouse_show(this)");
	$("#table_button3").attr("onmouseout","onmouse_out()");
	$("#table_button3").attr("onclick","onclick_button(this)");
	$("#purchaseMidicineStr").empty();
	$("#purchaseMidicineStr").append("");
	
	}
	if(receiveMedicStr!='' && receiveMedicStr!==null ){
	$("#table_button5").attr("onmouseover","onmouse_show(this)");
	$("#table_button5").attr("onmouseout","onmouse_out()");
	$("#table_button5").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	$("#receiveMedicStr").append(receiveMedicStr);
	}
	if(checkAcceptStr!=""){
	$("#table_button6").attr("onmouseover","onmouse_show(this)");
	$("#table_button6").attr("onmouseout","onmouse_out()");
	$("#table_button6").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	$("#checkAcceptStr").append(checkAcceptStr);
	}
	if(curingPlanErr!=""){
	$("#table_button7").attr("onmouseover","onmouse_show(this)");
	$("#table_button7").attr("onmouseout","onmouse_out()");
	$("#table_button7").attr("onclick","onclick_button(this)");
	$("#receiveMedicStr").empty();
	$("#checkAcceptStr").append(curingPlanErr);
	}
	var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	var home_sh = json.home_sh;//收获
	var home_ys = json.home_ys;//验收
	var home_yhjh = json.home_yhjh;//养护计划
	var home_yhjl = json.home_yhjl;//养护记录
	var home_xsdd = json.home_xsdd;
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_sh!=null && home_sh!=""){
		add_button_link("table_button5","drugState/inspectionRecords/list.html")
		
	}
	if(home_ys!=null && home_ys!=""){
		add_button_link("table_button6","comQuery/inspeAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_yhjh!=null && home_yhjh!=""){
		add_button_link("table_button7","drugState/MaintenancePlan/list.html")
		
	}
	if(home_yhjl!=null && home_yhjl!=""){
		add_button_link("table_button8","comQuery/conserveAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_xsdd!=null && home_xsdd!=""){
		add_button_link("table_button15","comQuery/drugSaleRecords/query.html?pihao="+batchNumber)
		
	}
	
	$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_lc");
	$("#table_button5").attr("class", "btn_lc");
	$("#table_button6").attr("class", "btn_lc");
	$("#table_button7").attr("class", "btn_lc");
	$("#table_button8").attr("class", "btn_lc");
	$("#table_button15").attr("class", "btn_lc");
	$("#table_button16").attr("class", "btn_lc");
	$("#table_button17").attr("class", "btn_lc");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_lc2");
	$("#table_button4").attr("class", "btn_lc2");
	$("#table_button9").attr("class", "btn_lc2");
	$("#table_button10").attr("class", "btn_lc2");
	$("#table_button11").attr("class", "btn_lc2");
	$("#table_button12").attr("class", "btn_lc2");
	$("#table_button13").attr("class", "btn_lc2");
	$("#table_button14").attr("class", "btn_lc2");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g.gif");
	$("#image_id224").attr("src", "images/d.gif");
	$("#image_id225").attr("src", "images/g.gif");
	$("#image_id226").attr("src", "images/d.gif");
	$("#image_id227").attr("src", "images/g.gif");
	$("#image_id228").attr("src", "images/d.gif");
	

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh2.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg.gif");
	$("#image_id6").attr("src", "images/sh2.gif");

	$("#image_id7").attr("src", "images/sh.gif");
	$("#image_id8").attr("src", "images/sh.gif");
	$("#image_id9").attr("src", "images/sh.gif");
	$("#image_id10").attr("src", "images/hg.gif");
	$("#image_id11").attr("src", "images/f3.gif");
	$("#image_id12").attr("src", "images/hg.gif");
	$("#image_id14").attr("src", "images/hg.gif");
	$("#image_id15").attr("src", "images/sh2.gif");
	$("#image_id16").attr("src", "images/sh2.gif");
	$("#image_id17").attr("src", "images/sh.gif");
}
function purchaseorderstate12(json){
	var midinceInfo = json.midinceInfo;// 药品
	var purchaseOrderStr = json.purchaseOrderStr;// 采购订单
	var curingPlanStr = json.curingPlanStr;// 养护计划
	var supplierStr = json.supplierStr;// 采购单供应商预警
	var purchaseMidicineStr = json.purchaseMidicineStr;// 采购单药品预警
	var receiveMedicStr = json.receiveMedicStr;//收获药品预警
	var checkAcceptStr = json.checkAcceptStr;
	var curingPlanErr = json.curingPlanErr;
	var batchNumber = json.batchNumber;
				$(".mar_l1").empty();
				$(".mar_l1").append(midinceInfo);

					$("#purchaseOrderStr").empty();
					$("#purchaseOrderStr").append(purchaseOrderStr);
					$("#table_button").attr("onmouseover","onmouse_show(this)");
			$("#table_button").attr("onmouseout","onmouse_out()");
			$("#table_button").attr("onclick","onclick_button(this)");

					$("#curingPlanStr").empty();
					$("#curingPlanStr").append(curingPlanStr);

					$("#table_button0").attr("class", "btn_lc");
	$("#table_button").attr("class", "btn_lc");
	$("#table_button5").attr("class", "btn_lc");
	$("#table_button6").attr("class", "btn_lc");
	$("#table_button7").attr("class", "btn_lc");
	$("#table_button8").attr("class", "btn_lc");
	$("#table_button15").attr("class", "btn_lc");
	$("#table_button16").attr("class", "btn_lc");
	$("#table_button17").attr("class", "btn_lc");
	$("#table_button18").attr("class", "btn_lc");
	$("#table_button19").attr("class", "btn_lc");

	$("#table_button1").attr("class", "btn_lc2");
	$("#table_button2").attr("class", "btn_lc2");
	$("#table_button3").attr("class", "btn_lc2");
	$("#table_button4").attr("class", "btn_lc2");
	$("#table_button9").attr("class", "btn_lc2");
	$("#table_button10").attr("class", "btn_lc2");
	$("#table_button11").attr("class", "btn_lc2");
	$("#table_button12").attr("class", "btn_lc2");
	$("#table_button13").attr("class", "btn_lc2");
	$("#table_button14").attr("class", "btn_lc2");
	
	$("#table_button21").attr("class", "btn_lc2");
	$("#table_button22").attr("class", "btn_lc2");
	$("#table_button23").attr("class", "btn_lc2");

	$("#image_id222").attr("src", "images/d.gif");
	$("#image_id223").attr("src", "images/g.gif");
	$("#image_id224").attr("src", "images/d.gif");
	$("#image_id225").attr("src", "images/g.gif");
	$("#image_id226").attr("src", "images/d.gif");
	$("#image_id227").attr("src", "images/g.gif");
	$("#image_id228").attr("src", "images/d.gif");
	

	$("#image_id1").attr("src", "images/sh2.gif");
	$("#image_id2").attr("src", "images/sh2.gif");
	$("#image_id3").attr("src", "images/f2.gif");

	$("#image_id4").attr("src", "images/hg.gif");
	$("#image_id5").attr("src", "images/hg.gif");
	$("#image_id6").attr("src", "images/sh2.gif");

	$("#image_id7").attr("src", "images/sh.gif");
	$("#image_id8").attr("src", "images/sh.gif");
	$("#image_id9").attr("src", "images/sh.gif");
	$("#image_id10").attr("src", "images/hg.gif");
	$("#image_id11").attr("src", "images/f3.gif");
	$("#image_id12").attr("src", "images/hg.gif");
	$("#image_id14").attr("src", "images/hg.gif");
	$("#image_id15").attr("src", "images/sh2.gif");
	$("#image_id16").attr("src", "images/sh2.gif");
	$("#image_id17").attr("src", "images/sh2.gif");
	$("#image_id18").attr("src", "images/sh2.gif");
	$("#image_id19").attr("src", "images/sh2.gif");
	$("#image_id20").attr("src", "images/sh2.gif");
	
		$("#image_id21").attr("src", "images/hg.gif");
	$("#image_id22").attr("src", "images/hg.gif");
	$("#image_id23").attr("src", "images/hg.gif");
					
	var home_cgjh = json.home_cgjh;//采购计划
	var home_cgdd = json.home_cgdd;//采购订单
	var home_sh = json.home_sh;//收获
	var home_ys = json.home_ys;//验收
	var home_yhjh = json.home_yhjh;//养护计划
	var home_yhjl = json.home_yhjl;//养护记录
	var home_xsdd = json.home_xsdd;//销售订单
	var home_ck = json.home_ck;//出库
	var home_yshu = json.home_yshu;//运输
	var batchNumber = json.batchNumber;
	//var home_zc = json.home_zc;//转出
	
	if(home_cgjh!=null && home_cgjh!=""){
		add_button_link("table_button0","drugState/procurementProgram/list.html")
		
	}
	if(home_cgdd!=null && home_cgdd!=""){
		add_button_link("table_button","comQuery/drugProcureRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_sh!=null && home_sh!=""){
		add_button_link("table_button5","drugState/inspectionRecords/list.html")
		
	}
	
	if(home_ys!=null && home_ys!=""){
		add_button_link("table_button6","comQuery/inspeAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_yhjh!=null && home_yhjh!=""){
		add_button_link("table_button7","drugState/MaintenancePlan/list.html")
		
	}
	if(home_yhjl!=null && home_yhjl!=""){
		add_button_link("table_button8","comQuery/conserveAcceptRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_xsdd!=null && home_xsdd!=""){
		add_button_link("table_button15","comQuery/drugSaleRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_ck!=null && home_ck!=""){
		add_button_link("table_button18","comQuery/outCheckRecords/query.html?pihao="+batchNumber)
		
	}
	if(home_yshu!=null && home_yshu!=""){
		add_button_link("table_button19","/qualityRecords/transportRecords/list.html")
		
	}
}

function add_button_link(object,url){
	$("#"+object).attr("ondblclick","button_click_links('"+url+"')");
}
function button_click_links(str){
	window.location.href=str;
}