<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="com.sinosoft.user.User"%>
<%@page import="com.sinosoft.base.Constants"%> 
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页面</title>
<link href="${ctx }/style/home.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx }/js/ad.js"></script>
<script type="text/javascript" src="${ctx }/js/index.js"></script>
<!--[if IE 6]><script type="text/javascript" src="${ctx }/js/ie6png.js"></script> <![endif]-->
</head>
<% User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER); 
	String userName =  user.getUsername();
%>
<body>
	<div class="tab_con">
        	<div class="sou_yao">
	            <h4>生产批号：<input name=""  id="batch_number" type="text" class="text1"/>
	            
	            <shiro:hasPermission name="home_buttonLink"><input name="" type="button" class="btn_big" value="查询" onclick="ajaxQueryMidinceByBatchNumber('0')"/></shiro:hasPermission>
	            <shiro:lacksPermission name="home_buttonLink"><input name="" type="button" class="btn_big" value="查询" onclick="ajaxQueryMidinceByBatchNumber('1')"/></shiro:lacksPermission>
	            </h4>
                <div class="box_bai">
                	<table border="0" cellspacing="0" cellpadding="0" class="mar_l1">
                      <tr>
                        <th>药品号：</th>
                        <td></td>
                        <th>品名：</th>
                        <td></td>
                        <th>剂型：</th>
                        <td></td>
                        <th>规格：</th>
                        <td></td>
                        <th>生产厂家：</th>
                        <td></td>
                      </tr>
                    </table>
                </div>
            </div>
        </div>
    	<div class="ceng_box">
        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr height="25"></tr>
              <tr align="center" height="120">
                <td><img src="images/lc1.gif" /></td>
                <td><img src="images/lc-.gif" /></td>
                <td><img src="images/lc2.gif" /></td>
                <td><img src="images/lc-.gif" /></td>
                <td><img src="images/lc3.gif" /></td>
                <td><img src="images/lc-.gif" /></td>
                <td><img src="images/lc4.gif" /></td>
              </tr>
            </table>
            <table width="85%" border="0" cellspacing="0" cellpadding="0">
              <tr align="center">
              	<!-- <td><img src="images/d.gif" /></td>
                <td><img src="images/g.gif" /></td> -->
                 <td><img src="images/d2.gif" id="image_id222" /></td>
                <td><img src="images/g2.gif"  id="image_id223"/></td>
              	<td><img src="images/d2.gif" id="image_id224" /></td>
                <td><img src="images/g2.gif"  id="image_id225"/></td>
              	<td><img src="images/d2.gif"  id="image_id226"/></td>
                <td><img src="images/g2.gif" id="image_id227" /></td>
              	<td><img src="images/d2.gif"  id="image_id228"/></td>
              </tr>
            </table>
			<div class="ceng_box" style="padding-bottom:25px;">
            	<div class="anniu_box" id="lc1">
                	<table border="0" cellspacing="0" cellpadding="0" align="center">
                      <tr>
                        <td><img src="images/sh2_1.gif"  id="image_id1"/></td>
                      </tr>
                      <tr>
                        <td class="shubg"><input name="" type="button" class="btn_4c" id="table_button0" value="采购计划"/></td>
                      </tr>
                      <tr>
                        <td><img src="images/sh1.gif" id="image_id2" /></td>
                      </tr>
                      <tr>
                        <td rowspan="2" class="shubg"><input  name="" type="button" class="btn_4c" id="table_button" value="采购订单" onmouseover="" onmouseout="" onclick=""/>
                        <div class="out_tch" style="display:none;" onmouseover="div_onmouse(this)" onmouseout="div_onmouseout(this)" style="overflow: hidden;" >
                            <div class="outbox">
                                <div class="outbox_con" style="overflow: hidden;">
                                    <ul id="purchaseOrderStr"  style="overflow: hidden;">
                                    </ul>
                                    <span><a href="#">显示更多</a>...</span>
                                </div>
                            </div>
                            <img src="images/out_j.gif" />
                        </div></td>
                      </tr>
                    </table>
                	<table border="0" cellspacing="0" cellpadding="0" align="center" id="lc1_z1">
                      <tr height="48">
                        <td rowspan="2"><img src="images/f2_1.gif"  id="image_id3"/></td>
                        <td><input name="" type="button" class="btn_4c" id="table_button1" value="合格供货单位"/>
                       	<div class="out_tch" style="display:none;" onmouseover="div_onmouse(this)" onmouseout="div_onmouseout(this)">
                            <div class="outbox">
                                <div class="outbox_con" style="overflow: hidden;">
                                    <ul id="purchaseSupplyStr">
                                    </ul>
                                    <span><a href="#">显示更多</a>...</span>
                                </div>
                            </div>
                            <img src="images/out_j.gif" />
                        </div>
                        </td>
                        <td><img src="images/hg1.gif" id="image_id4" /></td>
                        <td><input name="" type="button" class="btn_4c" id="table_button2" value="首营企业"/></td>
                      </tr>
                      <tr height="48">
                        <td><input name="" type="button" class="btn_4c" id="table_button3" value="合格品种" />
                        	  	<div class="out_tch" style="display:none;" onmouseover="div_onmouse(this)" onmouseout="div_onmouseout(this)">
                            <div class="outbox">
                                <div class="outbox_con" style="overflow: hidden;">
                                    <ul id="purchaseMidicineStr">
                                    </ul>
                                    <span><a href="#">显示更多</a>...</span>
                                </div>
                            </div>
                            <img src="images/out_j.gif" />
                        </div>
                        </td>
                        <td><img src="images/hg1.gif" id="image_id5" /></td>
                        <td><input name="" type="button" class="btn_4c" id="table_button4" value="首营品种"/>
                        </td>
                      </tr>
                    </table>
                </div>
                <div class="anniu_box" id="lc2">
                	<table border="0" cellspacing="0" cellpadding="0" align="center">
                      <tr>
                        <td><img src="images/sh2_1.gif" id="image_id6" /></td>
                      </tr>
                      <tr>
                        <td class="shubg"><input name="" type="button" id="table_button5" class="btn_4c" value="收货"/>
                        	  	<div class="out_tch" style="display:none;" onmouseover="div_onmouse(this)" onmouseout="div_onmouseout(this)">
                            <div class="outbox">
                                <div class="outbox_con" style="overflow: hidden;">
                                    <ul id="receiveMedicStr">
                                    </ul>
                                    <span><a href="#">显示更多</a>...</span>
                                </div>
                            </div>
                            <img src="images/out_j.gif" />
                        </div>
                        </td>
                      </tr>
                      <tr>
                        <td><img src="images/sh1.gif"  id="image_id7"/></td>
                      </tr>
                      <tr>
                        <td class="shubg"><input name="" type="button" id="table_button6" class="btn_4c" value="验收"/>
                          	<div class="out_tch" style="display:none;" onmouseover="div_onmouse(this)" onmouseout="div_onmouseout(this)">
                            <div class="outbox">
                                <div class="outbox_con" style="overflow: hidden;">
                                    <ul id="checkAcceptStr">
                                    </ul>
                                    <span><a href="#">显示更多</a>...</span>
                                </div>
                            </div>
                            <img src="images/out_j.gif" />
                        </div>
                        </td>
                      </tr>
                      <tr>
                        <td><img src="images/sh1.gif" id="image_id8"/></td>
                      </tr>
                      <tr>
                        <td class="shubg"><input name="" type="button" id="table_button7" class="btn_4c" value="养护计划" />
                         <div class="out_tch" style="display:none;" onmouseover="div_onmouse(this)" onmouseout="div_onmouseout(this)">
                            <div class="outbox">
                                <div class="outbox_con" style="overflow: hidden;">
                                    <ul id="curingPlanStr">
                                    </ul>
                                    <span><a href="#">显示更多</a>...</span>
                                </div>
                            </div>
                            <img src="images/out_j.gif" id="image_id13" />
                        </div>
                        </td>
                      </tr>
                      <tr>
                        <td><img src="images/sh1.gif" id="image_id9"/></td>
                      </tr>
                      <tr>
                        <td class="shubg"><input name="" type="button" id="table_button8"  class="btn_4c" value="养护记录"/>
                       <div class="out_tch" style="display:none;" onmouseover="div_onmouse(this)" onmouseout="div_onmouseout(this)">
                            <div class="outbox">
                                <div class="outbox_con" style="overflow: hidden;">
                                    <ul id="maintainStr">
                                    </ul>
                                    <span><a href="#">显示更多</a>...</span>
                                </div>
                            </div>
                            <img src="images/out_j.gif" id="image_id13" />
                        </div>
                        </td>
                      </tr>
                    </table>
                </div>
                
                <div class="anniu_box" id="lc3">
                	<table border="0" cellspacing="0" cellpadding="0" align="center" id="lc3_z1">
                      <tr height="48">
                        <td><input name="" type="button" class="btn_4c" id="table_button9"  value="新购货商"/></td>
                        <td><img src="images/hg1.gif" id="image_id10" /></td>
                        <td><input name="" type="button" class="btn_4c" id="table_button10" value="合格购货单位"/>
                        	  	<div class="out_tch" style="display:none;" onmouseover="div_onmouse(this)" onmouseout="div_onmouseout(this)">
                            <div class="outbox">
                                <div class="outbox_con" style="overflow: hidden;">
                                    <ul id="saleSupplyStr">
                                    </ul>
                                    <span><a href="#">显示更多</a>...</span>
                                </div>
                            </div>
                            <img src="images/out_j.gif" />
                        </div>
                        </td>
                        <td rowspan="3"><img src="images/f3_1.gif"  id="image_id11" /></td>
                      </tr>
                      <tr height="48">
                        <td><input name="" type="button" class="btn_4c" id="table_button11" value="首营品种"/></td>
                        <td><img src="images/hg1.gif" id="image_id12"  /></td>
                        <td><input name="" type="button" class="btn_4c" id="table_button12" value="合格品种"/>
                        
                          	<div class="out_tch" style="display:none;" onmouseover="div_onmouse(this)" onmouseout="div_onmouseout(this)">
                            <div class="outbox">
                                <div class="outbox_con" style="overflow: hidden;">
                                    <ul id="saleMidinceStr">
                                    </ul>
                                    <span><a href="#">显示更多</a>...</span>
                                </div>
                            </div>
                            <img src="images/out_j.gif" />
                        </div>
                        </td>
                      </tr>
                      <tr height="48">
                        <td><input name="" type="button" class="btn_4c" id="table_button13" value="养护记录"/>
                            
                        </td>
                        <td><img src="images/hg1.gif"  id="image_id14"  /></td>
                        <td><input name="" type="button" class="btn_4c" id="table_button14" value="合格养护品种"/>
                        </td>
                      </tr>
                    </table>
                	<table border="0" cellspacing="0" cellpadding="0" align="center">
                      <tr>
                        <td><img src="images/sh2_1.gif"  id="image_id15" /></td>
                      </tr>
                      <tr>
                        <td class="shubg"><input name="" type="button" id="table_button15" class="btn_4c" value="销售订单"/></td>
                      </tr>
                      <tr>
                        <td><img src="images/sh1.gif" id="image_id16"  /></td>
                      </tr>
                      <tr>
                        <td class="shubg"><input name="" type="button" class="btn_4c" id="table_button16" value="销售合同"/></td>
                      </tr>
                      <tr>
                        <td><img src="images/sh1.gif" id="image_id17"  /></td>
                      </tr>
                      <tr>
                        <td class="shubg"><input name="" type="button" class="btn_4c" id="table_button17" value="销售单"/></td>
                      </tr>
                    </table>
                </div>
                <div class="anniu_box" id="lc4">
                	<table border="0" cellspacing="0" cellpadding="0" align="center" style="float:right;">
                      <tr>
                        <td><img src="images/sh2_1.gif" id="image_id18" /></td>
                      </tr>
                      <tr>
                        <td class="shubg"><input name="" id="table_button18" type="button" class="btn_4c" value="出库"/></td>
                      </tr>
                      <tr>
                        <td><img src="images/sh1.gif"  id="image_id19"/></td>
                      </tr>
                      <tr>
                        <td class="shubg"><input name="" type="button" id="table_button19" class="btn_4c" value="运输"/></td>
                      </tr>
                      <tr>
                        <td><img src="images/sh1.gif"  id="image_id20"/></td>
                      </tr>
                      <tr>
                        <td class="shubg"><input name="" type="button" id="table_button20" class="btn_4c" value="转出"/></td>
                      </tr>
                    </table>
                	<table border="0" cellspacing="0" cellpadding="0" align="center" id="lc4_z1">
                      <tr height="48">
                        <td><input name="" id="table_button21" type="button" class="btn_4c" value="出库复核"/></td>
                        <td rowspan="3"><img src="images/hg1.gif" id="image_id21" /></td>
                      </tr>
                    </table>
                	<table border="0" cellspacing="0" cellpadding="0" align="center" id="lc4_z2">
                      <tr height="48">
                        <td><input name="" id="table_button22" type="button" class="btn_4c" style="width:106px" value="承运商资质审批"/></td>
                        <td rowspan="3"><img src="images/hg1.gif"  id="image_id22"/></td>
                        <td><input name="" id="table_button23" type="button" class="btn_4c" value="合格承运商" onmousemove="mouseover_test(this)" onmouseout="mouseout_test(this)" onclick="onclickTest(this)"/>
                        	<!--  <div class="out_tch" style="display:none;" onmousemove="divmouseover_test(this)" onmouseout="divmouseout_test(this)">
                            <div class="outbox">
                                <div class="outbox_con" style="overflow: hidden;">
                                    <ul>
                                        <li><a href="#">1.批号为Y1234656的六味地黄丸即将过有效期</a></li>
                                        <li><a href="#">1.批号为Y1234656的六味地黄丸即将过有效期</a></li>
                                        <li><a href="#">1.批号为Y1234656的六味地黄丸即将过有效期</a></li>
                                        <li><a href="#">1.批号为Y1234656的六味地黄丸即将过有效期</a></li>
                                        <li><a href="#">1.批号为Y1234656的六味地黄丸即将过有效期</a></li>
                                    </ul>
                                    <span><a href="#">显示更多</a>...</span>
                                </div>
                            </div>
                            <img src="images/out_j.gif" />
                        </div> -->
                        </td>
                        <td rowspan="3"><img src="images/hg1.gif"  id="image_id23"/></td>
                      </tr>
                    </table>
                </div>
            </div>
        </div>
		<div class="ceng_box">
		<div class="box_right_l">
			<div class="biao2">
				<img src="images/biao1l.gif" class="l"/>
				<shiro:hasPermission name="FirstEnterprise_recorded_add">
				<a href="javascript:void(0)" class="on" onclick="changeLink(this,'firstEnterprise/add_syqy.html')">首营企业</a>
				</shiro:hasPermission>
				<shiro:lacksPermission name="FirstEnterprise_recorded_add">
				<a href="javascript:void(0)" class="on" >首营企业</a>
				</shiro:lacksPermission>
				<font>|</font>
				<shiro:hasPermission name="FirstMedicine_recorded_add">
				<a href="javascript:void(0)" onclick="changeLink(this,'drugVarieties/addFirstVariety.html')" >首营品种</a>
				</shiro:hasPermission>
				<shiro:lacksPermission name="FirstMedicine_recorded_add">
				<a href="javascript:void(0)"  >首营品种</a>
				</shiro:lacksPermission>
				<font>|</font>
				<shiro:hasPermission name="PurchaseUnit_recorded_add">
				<a href="javascript:void(0)"  onclick="changeLink(this,'firstEnterprise/add_ghdwdlr.html')">新购货商</a>
				</shiro:hasPermission>
				<shiro:lacksPermission name="PurchaseUnit_recorded_add">
				<a href="javascript:void(0)"  >新购货商</a>
				</shiro:lacksPermission>
				<img src="images/biao1r.gif" class="r"/>
			</div>
			<div class="con_box">
                <div class="con_box_con">
                	<table width="100%" height="262" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td align="center">
                    <shiro:hasPermission name="FirstEnterprise_recorded_add">
					<a href="firstEnterprise/add_syqy.html" id="change_src"><img src="images/y.gif"/></a>
					</shiro:hasPermission>
					<shiro:lacksPermission name="FirstEnterprise_recorded_add">
						<a href="javascript:void(0)" id="change_src"><img src="images/y.gif"/></a>
					</shiro:lacksPermission>
					
					</td>
                      </tr>
                    </table>
                </div>
			</div>
			<img src="images/dir.gif" class="img_lb"/>
		</div>
        <div class="box_mid">
        	<div class="biao1">
            	<img src="images/biao1l.gif" class="l"/>
                <h5><img src="images/icon3.gif" /> 新闻资讯</h5>
                <span>
                	<a href="#">更多...</a>
                </span>
            </div>
            <div class="con_box">
                <div class="con_box_con">
                	<ul class="block_con1" style="height:233px">
                    <!-- 	<li><font>1.</font><a href="#">股份集团营销分公司开展"益坤丸"</a><span>【2012-09-05】</span></li>
                        <li><font>2.</font><a href="#">北京同仁堂参茸有限责任公司招聘启事</a><span>【2012-09-05】</span></li>
                        <li><font>3.</font><a href="#">北京同仁堂股份有限公司同仁果公示公告</a><span>【2012-09-05】</span></li>
                        <li><font>4.</font><a href="#">股份集团营销分公司开展"赛</a><span>【2012-09-05】</span></li>
                    	<li><font>1.</font><a href="#">股份集团营销分公司开展"益坤丸"</a><span>【2012-09-05】</span></li>
                        <li><font>2.</font><a href="#">北京同仁堂参茸有限责任公司招聘启事</a><span>【2012-09-05】</span></li>
                        <li><font>3.</font><a href="#">北京同仁堂股份有限公司同仁果公示公告</a><span>【2012-09-05】</span></li>
                        <li><font>4.</font><a href="#">股份集团营销分公司开展"赛</a><span>【2012-09-05】</span></li>
                    	<li><font>1.</font><a href="#">股份集团营销分公司开展"益坤丸"</a><span>【2012-09-05】</span></li>
                        <li><font>2.</font><a href="#">北京同仁堂参茸有限责任公司招聘启事</a><span>【2012-09-05】</span></li>
                         -->
                    </ul>
                </div>
            </div>
            <img src="images/mid_di.gif" class="img_lb"/>
        </div>
			<div class="box_left_l">
				<div class="biao1">
					<img src="images/biao1l.gif" class="l"/>
					<h5><img src="images/icon1.gif" /> 资质预警</h5>
					<span>
						<a href="javascript:ajaxQueryWaringMore()">更多...</a>
					</span>
				</div>
				<div class="con_box">
					<div class="con_box_con" style="overflow: hidden;">
						<ul class="block_con3" id="homePageWaring" style="height:78px">
						</ul>
					</div>
				</div>
				<img src="images/dil.gif" class="img_lb"/>
				<div class="biao1">
					<img src="images/biao1l.gif" class="l"/>
					<h5><img src="images/icon2.gif" /> 待办事项</h5>
					<span>
						<a href="javascript:ajaxQueryWaitForDoMore()">更多...</a>
					</span>
				</div>
				<div class="con_box">
					<div class="con_box_con" style="overflow: hidden;">
					
						<ul class="block_con2" style="height:78px" id="waitForDoThings"><!---->
				
						</ul>
					</div>
				</div>
				<img src="images/dil.gif" class="img_lb"/>
			</div>
		<div id="dialog_homeWaringMore" title="资质预警" class="easyui-dialog" style="width:600px;height:300px;padding:10px; margin-top: 0px;"  data-options="closed:true,modal:true,top:500">
			<ul id="homeWaringMore" class="block_con2">
				
			</ul>
        </div>
        <div id="dialog_homeWaitToDoMore" title="代办事项" class="easyui-dialog" style="width:600px;height:auto;padding:10px; margin-top: 0px;"  data-options="closed:true,modal:true,top:500">
			<ul id="homeWaitToDoMore" class="block_con2">
				
			</ul>
        </div>
		</div>
	<script type="text/javascript">
		function onmouse_show(str){
			$(str).next().show();
		}
		function onmouse_out(){
			$(".out_tch").hide();
		}
		function onclick_button(str){
			//$(".out_tch").hide();
			$(str).attr("onmouseout","");
			$(str).next().show();
			
		}
		function div_onmouse(str){
			$(str).show();
			$(str).prev().attr("onmouseout","")
			
		}
		function div_onmouseout(str){
			$(str).hide();
			$(str).prev().attr("onmouseout","onmouse_out()")
			//$("#table_button").att("onmouseout","onmouse_out()")
			
		}
		function ajaxQueryWaitForDo(){
			$.post("homePage/waitForDo.html",function(date){
				//alert(date);
				var json = jsonParse(date);
				
				$("#waitForDoThings").empty();
				
				if(json.responseStr==null || json.responseStr==""){
					$("#waitForDoThings").append("<li><a href='#'>暂无代办事项</a></li>");
				}else{
					$("#waitForDoThings").append(json.responseStr);
				}
			})
		}
		function ajaxQueryWaring(){
			$.post("homePage/waring.html",function(date){
				//alert(date);
				var json = jsonParse(date);
			//	alert(json);
				$("#homePageWaring").empty();
				
				if(json.responseStr==null || json.responseStr==""){
					$("#homePageWaring").append("<li><a href='#'>暂无预警信息</a></li>");
				}else{
					$("#homePageWaring").append(json.responseStr);
				}
			})
		}
		function ajaxQueryWaitForDoMore(){
			$.post("homePage/waitForDoMore.html",function(date){
				//alert(date);
				var json = jsonParse(date);
				
				$("#homeWaitToDoMore").empty();
				
				if(json.responseStr==null || json.responseStr==""){
					$("#homeWaitToDoMore").append("<li><a href='#'>暂无代办事项</a></li>");
				}else{
					$("#homeWaitToDoMore").append(json.responseStr);
				}
				$("#dialog_homeWaitToDoMore").dialog("open");
			})
		}
		function ajaxQueryWaringMore(){
			$.post("homePage/waringMore.html",function(date){
				//alert(date);
				var json = jsonParse(date);
			//	alert(json);
				$("#homeWaringMore").empty();
				
				if(json.responseStr==null || json.responseStr==""){
					$("#homeWaringMore").append("<li><a href='#'>暂无预警信息</a></li>");
				}else{
					$("#homeWaringMore").append(json.responseStr);
				}
				$("#dialog_homeWaringMore").dialog("open");
			})
		}
		$(function(){
			ajaxQueryWaitForDo();
			ajaxQueryWaring();
		})
		
		function mouseover_test(obj){
			$(obj).next().show();
		}
		function mouseout_test(obj){
			$(obj).next().hide();
		}
		function onclickTest(obj){
			$(obj).next().show();
			$(obj).attr("onmouseout","");
		}
		function divmouseover_test(obj){
			$(obj).show();
		}
		function divmouseout_test(obj){
			$(obj).hide();
			$(obj).prev().attr("onmouseout","mouseout_test(this)");
		}
		$(function(){
			checkQulitySupply();
		})
		//设置资质过期的供货单位为暂时停用
		function checkQulitySupply(){
			$.post("firstEnterprise/checkQqualitySupply.html",function(date){
				
			})
		}
	</script>
</body>
</html>
