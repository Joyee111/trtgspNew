<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
 <!-- lfl	修改之前   <div id="nav">
    	<img src="${ctx}/images/navl.gif" class="nav_l"/>
    	
        <a href='${ctx}/indexPage.html'>首页</a>
        <shiro:hasPermission name="EnterpriseManage">
        <a href="${ctx}/firstEnterprise/enterpriseIframe.html" class="on">企业资质管理</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="MedicinalManage">
        <a href="#">品种管理</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="MedicinalStatusManage">
        <a href="${ctx}/drugState/index.html">药品状态管理</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="QualityRecordsManage">
        <a href="${ctx}/qualityRecords/index.html">质量记录管理</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="StatisticAlanalysis">
        <a href="#">综合查询统计分析</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="SystemManage">
        <a href="#">系统管理</a>
        </shiro:hasPermission>
    	<img src="${ctx}/images/navr.gif" class="nav_r"/>
    </div>
    
 -->

<div id="nav">
	<img src="${ctx}/images/navl.gif" class="nav_l" />
	<ul>
		<li>
			<a href='${ctx}/indexPage.html'><span>首页</span></a>
		</li>
		<shiro:hasPermission name="EnterpriseManage">
			
			<li onmouseover=displaySubMenu(this);; onmouseout=hideSubMenu(this);>
				<a href="#"><span>企业资质管理</span></a>
				<ul>
				<shiro:hasPermission name="SalesQualify">
				<li>
					<a href="${ctx}/firstEnterprise/salesStaff.html?type=0">供货单位销售人员</a>
				</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="QualifiedSalesQualify">
				<li>
					<a href="${ctx}/firstEnterprise/hgxsry.html">合格供货单位销售人员</a>
				</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="FirstEnterpriseManage">
					<li>
						<a href="${ctx}/firstEnterprise/syqydlr.html">首营企业</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="QualifiedSupplierManage">
					<li>
						<a href="${ctx}/firstEnterprise/hggys.html">合格供货单位</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="BuyerQualify">
				<li>
				<a href="${ctx}/firstEnterprise/procurementStaffList.html?type=0">采购人员/提货人员</a>
				</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="QualifiedBuyerQualify">
				<li>
				<a href="${ctx}/firstEnterprise/hgcgry.html?type=0">合格采购人员/提货人员</a>
				</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="PurchaseUnitManage">
					<li>
						<a href="${ctx}/firstEnterprise/ghdwdlr.html">购货单位</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="QualifiedPurchaseUnitManage">
					<li>
						<a href="${ctx}/firstEnterprise/hgghdw.html">合格购货单位</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="CarriageQualify">
				<li>
					<a href="${ctx}/firstEnterprise/transporterQualification.html">承运商资质</a>
				</li>
				</shiro:hasPermission>
				
				
				
				<shiro:hasPermission name="OurQualityManagement">
				<li>
					<a href="${ctx}/firstEnterprise/wgszzgl.html">我公司资质管理</a>
				</li>
				</shiro:hasPermission>
				
				<shiro:hasPermission name="CommissionedStorageUnitQualification">
				<li>
					<a href="${ctx}/firstEnterprise/wtccdwzz.html">委托储存单位资质</a>
				</li>
				</shiro:hasPermission>
				
				
				
				</ul>
			</li>
		</shiro:hasPermission>
		<shiro:hasPermission name="MedicinalManage">
			<li onmouseover=displaySubMenu(this);; onmouseout=hideSubMenu(this);>
				<a href="#"><span>品种管理</span></a>
				<ul>
				<shiro:hasPermission name="FirstMedicineManage">
					<li>
						<a href="${ctx}/drugVarieties/firstVariety.html?type=input">首营品种</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="QualifiedMedicineManage">
					<li>
						<a href="${ctx }/drugVarieties/qulidiedMedicinal.html">合格品种</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="MedicineArchivesManage">
					<li>
						<a href="${ctx}/drugVarieties/standardFiles.html">质量标准档案</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="QualityStandardManage">
				<li>
						<a href="${ctx}/drugVarieties/qualityFiles.html">质量档案</a>
				</li>
				</shiro:hasPermission>
				</ul>
			</li>
		</shiro:hasPermission>
		<shiro:hasPermission name="MedicinalStatusManage">
			<li onmouseover=displaySubMenu(this);; onmouseout=hideSubMenu(this);>
				<a href="#"><span>药品状态管理</span></a>
				<ul>
				<shiro:hasPermission name="ProcurementPlan">
					<li>
						<a href="${ctx}/drugState/procurementProgram/list.html">采购计划</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="PurchasingOrder">
					<li>
						<a href="${ctx}/drugState/purchaseNote/list.html">采购订单</a>
					</li>
				</shiro:hasPermission>
			   <!--<shiro:hasPermission name="ReceivingManage">
					<li>
						<a href="${ctx}/drugState/inspectionRecords/list.html">收货管理</a>
					</li>
				</shiro:hasPermission> 
				 <shiro:hasPermission name="CheckAcceptManage">
					<li>
						<a href="${ctx}/drugState/checkaccept/list.html">验收管理</a>
					</li>
				</shiro:hasPermission>-->
				<shiro:hasPermission name="ReturnCheckAcceptManage">
					<li>
					    <a href="${ctx}/drugState/checkreturn/rechecklist.html">退货复检</a>
						<!-- <a href="${ctx}/drugState/checkreturn/list.html">退货验收</a>-->
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="StopSaleManage">
					<li>
						<a href="${ctx}/drugState/stopcell/dlrlist.html">停售管理</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="RecoverySaleManage">
					<li>
						<a href="${ctx}/drugState/recoverycell/dlrlist.html">恢复销售管理</a>
					</li>
				</shiro:hasPermission>
				<%-- 
				<shiro:hasPermission name="SellReturn">
					<li>
						<a href="${ctx}/drugState/salereturn/dlrlist.html">销售退回</a>
					</li>
				</shiro:hasPermission>
				--%>
				<shiro:hasPermission name="PurchaseReturn">
					<li>
						<a href="${ctx}/drugState/purreturn/dlrlist.html">购进退出管理</a>
					</li>
				</shiro:hasPermission>
				<%-- <shiro:hasPermission name="OutboundCheckManage">
					<li>
						<a href="${ctx}/drugState/outcheck/list.html">出库复核管理</a>
					</li>
				</shiro:hasPermission>--%>
				<!--<shiro:hasPermission name="MaintainPlan">
				<li>
					<a href="${ctx}/drugState/MaintenancePlan/list.html">养护计划</a>
				</li>
				</shiro:hasPermission>-->
				<shiro:hasPermission name="EntryTicket">
				<li>
					<a href="${ctx}/drugState/EntryTicket/list.html">入库单制单</a>
				</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="Scrap">
				<li>
					<a href="${ctx}/drugState/scrap/dlrlist.html">报废管理</a>
				</li>
				</shiro:hasPermission>
				</ul>
			</li>
		</shiro:hasPermission>
		<shiro:hasPermission name="QualityRecordsManage">
			<li onmouseover=displaySubMenu(this);; onmouseout=hideSubMenu(this);>
				<a href="#"><span>质量记录管理</span></a>
				<ul>
				<shiro:hasPermission name="ComplaintManage">
					<li>
						<a href="${ctx}/qualityRecords/complantManger/list.html">投诉管理</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="QualityRecordQueryManage">
					<li>
						<a href="${ctx}/qualityRecords/qualityQuery/list.html">质量查询</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="FeedbackManage">
					<li>
						<a href="${ctx}/qualityRecords/infoFeedback/list.html">信息反馈</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="AdverseReactionManage">
					<li>
						<a href="${ctx}/qualityRecords/adverseReactionInfo/dlrlist.html">不良反应</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="QualityAccidentManage">
					<li>
						<a href="${ctx}/qualityRecords/qualityAccident/list.html">质量事故</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="InstrumenttationManage">
					<li>
						<a href="${ctx}/qualityRecords/euqipmentOperation/list.html">设备运行</a>
					</li>
				</shiro:hasPermission>
				<!-- <shiro:hasPermission name="MaintainManage">
					<li>
					<a href="${ctx}/qualityRecords/drugMaintenance/list.html">药品养护</a>
					</li>
				</shiro:hasPermission>-->
					<shiro:hasPermission name="UnqualifiedMedc">
					<li>
					<a href="${ctx}/qualityRecords/unqualifiedManger/list.html">不合格药品</a>
					</li>
				</shiro:hasPermission>
				</ul>
			</li>
		</shiro:hasPermission>
		

               <shiro:hasPermission name="StatisticAlanalysis"> 
			<li onmouseover=displaySubMenu(this);; onmouseout=hideSubMenu(this);>
				<a href="#"><span>综合查询统计分析</span></a>
				<ul>
				<shiro:hasPermission name="SupplierBuyer">
					<li>
						<a href="${ctx}/comQuery/comQuery/list.html?firstJoin=1">供货单位购货单位</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="VarietyQuery ">
					<li>
						<a href="${ctx}/comQuery/varietyQuery/list.html?firstJoin=1">品种查询</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="QualityRecordQuery">
					<li>
					<a href="${ctx}/qualityRecords/qualityQuery/list.html?type=commonQuery">药品质量查询</a>
					</li>
				</shiro:hasPermission>
				
				<shiro:hasPermission name="PurchaseRecord">
					<li>
						<a href="${ctx}/comQuery/drugProcureRecords/list.html">药品采购记录</a>
					</li>
				</shiro:hasPermission>
				
				<shiro:hasPermission name="ReceivingRecord">
					<li>
						<a href="${ctx}/comQuery/receivingRecords/list.html">收货记录</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="CheckRecord">
					<li>
						<a href="${ctx}/comQuery/inspeAcceptRecords/list.html">药品检查验收记录</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="MaintainRecord">
					<li>
						<a href="${ctx}/comQuery/conserveAcceptRecords/list.html">养护检查记录</a>
					</li>
				</shiro:hasPermission>				
				<shiro:hasPermission name="ReceivingRecordJH">
					<li>
						<a href="${ctx}/comQuery/receivingRecordsJH/list.html">委托储存收货记录</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="CheckRecordJH">
					<li>
						<a href="${ctx}/comQuery/inspeAcceptRecordsJH/list.html">委托储存验收检查记录</a>
					</li>
				</shiro:hasPermission>					
				<shiro:hasPermission name="MaintainRecordJH">
					<li>
						<a href="${ctx}/comQuery/conserveJHAcceptRecords/list.html">委托储存养护记录</a>
					</li>
				</shiro:hasPermission>
					<shiro:hasPermission name="OutboundRecord">
					<li>
						<a href="${ctx}/comQuery/outCheckRecords/list.html">出库复核记录</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="SampleTicketRecord">
					<li>
						<a href="${ctx}/comQuery/sampleTicketRecords/list.html">样品票记录</a>
					</li>
				</shiro:hasPermission>
					<shiro:hasPermission name="UnqualifiedRecord">
					<li>
						<a href="${ctx}/comQuery/unqualifiedManagerRecords/list.html">不合格品记录</a>
					</li>
				</shiro:hasPermission>
					<shiro:hasPermission name="ReturnGoodsRecord">
					<li>
						<a href="${ctx}/comQuery/returnReceivingRecords/list.html">退货药品记录</a>
					</li>
				</shiro:hasPermission>
					<shiro:hasPermission name="ReturnReceiptRecord">
					<li>
						<a href="${ctx}/comQuery/returnReceiptRecords/list.html">退货收货记录</a>
					</li>
				</shiro:hasPermission>

					<shiro:hasPermission name="SalesRecord">
					<li>
						<a href="${ctx}/comQuery/drugSaleRecords/query.html">药品销售记录</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="Sales_return_acceptance_Record">
					<li>
						<a href="${ctx}/comQuery/ReturnCheckRecords/list.html">销售退回验收记录</a>
					</li>
				</shiro:hasPermission>
					<shiro:hasPermission name="PurchaseReturn_Record">
					<li>
						<a href="${ctx}/comQuery/purReturnRecord/list.html">药品购进退出记录</a>
					</li>
				</shiro:hasPermission>
					<shiro:hasPermission name="Scrap_Record">
					<li>
						<a href="${ctx}/comQuery/scrap/list.html">药品报废申请记录</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="TransportRecord">
					<li>
					<a href="${ctx}/qualityRecords/transportRecords/list.html">运输记录</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="HumitureRecord">
					<li>
					<a href="${ctx}/qualityRecords/temRecorder/list.html">温湿度记录</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="Feedback_Record">
					<li>
					<a href="${ctx}/comQuery/infoFeedbackRecords/list.html?firstJoin=1">信息反馈查询</a>
					</li>
				</shiro:hasPermission>
				<shiro:hasPermission name="Complaint_Record">
					<li>
					<a href="${ctx}/comQuery/drugComInfoRecords/list.html?firstJoin=1">投诉查询</a>
					</li>
				</shiro:hasPermission>
				<!--<shiro:hasPermission name="NearPeriodEarlyWarning ">
				<li>
					<a href="${ctx}/comQuery/varietyQuery/qualityMedicStoreWarningList.html">近效期药品月预警</a>
				</li>
				</shiro:hasPermission>-->
				</ul>
			</li>
	</shiro:hasPermission> 		
		

		
		
			
		<shiro:hasPermission name="SystemManage">
			<li onmouseover=displaySubMenu(this);; onmouseout=hideSubMenu(this);>
				<a href="#"><span>系统管理</span></a>
				<img src="${ctx}/images/navr.gif" class="nav_r" />
				<ul>
					<shiro:hasPermission name="UserManage">
						<li>
							<a href="${ctx}/user/users.html?method=list"><fmt:message
									key="menu.sysmanage.sys1" /> </a>
						</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="RoleManage">
						<li>
							<a href="${ctx}/user/roleform.html?method=query&operate=select"><fmt:message
									key="menu.sysmanage.sys2" /> </a>
						</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="ResourceManage">
						<li>
							<a href="${ctx}/user/authoriyform.html?method=query"><fmt:message
									key="menu.sysmanage.sys3" /> </a>
						</li>
					</shiro:hasPermission>
					<%-- 
					<shiro:hasPermission name="ConfigManage">
						<li>
							<a href="${ctx}/systemConfig/sysConfigEdit.html?method=list"><fmt:message
									key="menu.sysmanage.sys4" /> </a>
						</li>
					</shiro:hasPermission>
					--%>
					<shiro:hasPermission name="LogManage">
						<li>
							<a href="${ctx}/systemlog/systemLog.html"><fmt:message
									key="menu.sysmanage.sys5" /> </a>
						</li>
					</shiro:hasPermission>
					<%-- 
					<shiro:hasPermission name="CompanyManage">
						<li>
							<a href="${ctx}/systemConfig/sysLog.html?method=list"><fmt:message
									key="menu.sysmanage.sys6" /> </a>
						</li>
					</shiro:hasPermission>
					
					<shiro:hasPermission name="DBManage">
						<li>
							<a href="${ctx}/systemConfig/sysLog.html?method=list"><fmt:message
									key="menu.sysmanage.sys7" /> </a>
						</li>
					</shiro:hasPermission>
					--%>
					<shiro:hasPermission name="dictmanage">
						<li>
							<a href="${ctx }/system/dictionary/drugFroms.html"><fmt:message
									key="menu.sysmanage.sys8" /> </a>
						</li>
					</shiro:hasPermission>

					<%--<shiro:hasPermission name="menumanage">
						<li>
							<a href="${ctx }/menuManage/menuConfigFrame.html">菜单配置</a>
						</li>
					</shiro:hasPermission>
					--%>
					<shiro:hasPermission name="CompanyManage">
						<li>
							<a href="${ctx }/systemConfig/viewWarnConfig.html">预警设置</a>
						</li>
					</shiro:hasPermission>
						

				</ul>
			</li>
		</shiro:hasPermission>
	</ul>
</div>
