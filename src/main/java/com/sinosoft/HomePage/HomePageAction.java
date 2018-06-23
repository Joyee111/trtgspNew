package com.sinosoft.HomePage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNote;
import com.sinosoft.drugState.accepreturn.service.ReturnTaceMng;
import com.sinosoft.drugState.acceptance.model.CheckAcceptNote;
import com.sinosoft.drugState.acceptance.service.AcceptanceMng;
import com.sinosoft.drugState.outcheck.model.OutboundCheckBill;
import com.sinosoft.drugState.outcheck.service.OutCheckMng;
import com.sinosoft.drugState.recoverycell.model.RecoverySaleBill;
import com.sinosoft.drugState.recoverycell.service.RecoveryCellMng;
import com.sinosoft.drugState.salereturn.model.SaleReturnBill;
import com.sinosoft.drugState.salereturn.service.SaleReturnMng;
import com.sinosoft.drugState.stopcell.model.StopSaleBill;
import com.sinosoft.drugState.stopcell.service.StopCellMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise;
import com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.model.PurchaseUnit;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.service.FirstEnterpriseService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.ProcurementStaffService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.PurchaseUnitsService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedPurchaseUnitsService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedSuppliersService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.SalesStaffService;
import com.sinosoft.qualityRecords.complantManager.service.DrugComInfoManger;
import com.sinosoft.qualityRecords.infoFeedback.serivice.InfoFeedbackMng;
import com.sinosoft.systemConfig.WarnConfig;
import com.sinosoft.systemConfig.WarnConfigService;
import com.sinosoft.user.User;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.FirstVariety;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.FirstVarietyService;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualifiedmedcstoreMng;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;

@Controller
public class HomePageAction extends BaseFormController {
	@Autowired
	private FirstEnterpriseService firstService;// 首页企业待录入
	@Autowired
	private PurchaseUnitsService purchaseUtilService;// 购后单位带录入
	@Autowired
	private ProcurementStaffService procureService;// 采购人员
	@Autowired
	private SalesStaffService salesStaffService;// 销售人员
	@Autowired
	private FirstVarietyService firstVarietyService;// 首营品种
	@Autowired
	private AcceptanceMng acceptanceService;// 验收
	@Autowired
	private ReturnTaceMng returnTaceService;// 退货验收
	@Autowired
	private StopCellMng stopCellService;// 停售
	@Autowired
	private RecoveryCellMng recoverySellService;// 恢复销售
	@Autowired
	private OutCheckMng outCheckService;// 出库复核
	@Autowired
	private SaleReturnMng saleReturnService;// 销售退回
	@Autowired
	private WarnConfigService configService;// 预警设置
	@Autowired
	private QualifiedSuppliersService qualifiedSupplyService;// 合格供应商
	@Autowired
	private QualifiedPurchaseUnitsService qualifiedPurchaseUnitsService;
	@Autowired
	private QualifiedmedcstoreMng  qualifiedmedStoreService;
	@Autowired
	private QualityMidicineMng qualityMidicService;
	@Autowired
	private DrugComInfoManger drugComInfoService;
	@Autowired
	private InfoFeedbackMng infoFeedBackService;

	@RequestMapping("/homePage/waitForDo.html")
	public String waitToDoThings(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute(
				Constants.LOCAL_USER);
		Map<Long, String> authoriyMap = user.getAuthoriy();
		Iterator<Long> its = (Iterator<Long>) authoriyMap.keySet().iterator();
		StringBuffer waitDoBuffer = new StringBuffer();
		while (its.hasNext()) {
			Long key = its.next();
			String value = authoriyMap.get(key);
			if (value.trim().equals("FirstEnterprise_recorded")) {
				String waitToDoStr = firstEnterpriWaitDo(0,null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("FirstEnterprise_auditing")) {
				String waitToDoStr = firstEnterpriWaitDo(1,null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("BuyerQualify_recorded")) {
				String waitToDoStr = procurementWaitDo("0",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("BuyerQualify_auditing")) {
				String waitToDoStr = procurementWaitDo("1",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("PurchaseUnit_recorded")) {
				String waitToDoStr = firstPurchaseUtilWaitDo(0,null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("PurchaseUnit_auditing")) {
				String waitToDoStr = firstPurchaseUtilWaitDo(1,null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("SalesQualify_recorded")) {
				String waitToDoStr = salesStaffWaitDo("0",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("SalesQualify_auditing")) {
				String waitToDoStr = salesStaffWaitDo("1",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("FirstMedicine_recorded")) {
				String waitToDoStr = firstVarityWaitDo(0,null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("FirstMedicine_auditing")) {
				String waitToDoStr = firstVarityWaitDo(1,null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("CheckAccept_recorded")) {
				String waitToDoStr = checkAcceptanceWaitDo("0",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("CheckAccept_auditing")) {
				String waitToDoStr = checkAcceptanceWaitDo("1",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("ReturnCheckAccept_recorded")) {
				String waitToDoStr = returnTraceWaitDo("0",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("ReturnCheckAccept_auditing")) {
				String waitToDoStr = returnTraceWaitDo("1",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("StopSale_recorded")) {
				String waitToDoStr = stopSellWaitDo("0",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("StopSale_auditing")) {
				String waitToDoStr = stopSellWaitDo("1",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("RecoverySale_recorded")) {
				String waitToDoStr = recoverSellWaitDo("0",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("RecoverySale_auditing")) {
				String waitToDoStr = recoverSellWaitDo("1",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("SellReturn_recorded")) {
				String waitToDoStr = saleReturnWaitDo("0",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("SellReturn_auditing")) {
				String waitToDoStr = saleReturnWaitDo("1",null);
				waitDoBuffer.append(waitToDoStr);
				continue;
			}
			
			/*删除出库复核待审核和带录入 else if (value.trim().equals("OutboundCheck_recorded")) {
				String waitToDoStr = outCheckWaitDo("0");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("OutboundCheck_auditing")) {
				String waitToDoStr = outCheckWaitDo("1");
				waitDoBuffer.append(waitToDoStr);
				continue;
			}*/

		}
		String complanWaitDo = complaintWaitingToDo(request);
		waitDoBuffer.append(complanWaitDo);//投诉管理代办事项
		String feedBackWaitDo = feedBackWaitingToDo(request);
		waitDoBuffer.append(feedBackWaitDo);//信息反馈代办事项
		Map<String, String> map = new HashMap<String, String>(); 
		map.put("responseStr", waitDoBuffer.toString());
		UtilJson.printMapJson(response,map);
		return null;
	}
	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/homePage/waitForDoMore.html")
	public String waitToDoThingsMore(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute(
				Constants.LOCAL_USER);
		Map<Long, String> authoriyMap = user.getAuthoriy();
		Iterator<Long> its = (Iterator<Long>) authoriyMap.keySet().iterator();
		StringBuffer waitDoBuffer = new StringBuffer();
		while (its.hasNext()) {
			Long key = its.next();
			String value = authoriyMap.get(key);
			if (value.trim().equals("FirstEnterprise_recorded")) {
				String waitToDoStr = firstEnterpriWaitDo(0,"more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("FirstEnterprise_auditing")) {
				String waitToDoStr = firstEnterpriWaitDo(1,"more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("BuyerQualify_recorded")) {
				String waitToDoStr = procurementWaitDo("0","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("BuyerQualify_auditing")) {
				String waitToDoStr = procurementWaitDo("1","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("PurchaseUnit_recorded")) {
				String waitToDoStr = firstPurchaseUtilWaitDo(0,"more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("PurchaseUnit_auditing")) {
				String waitToDoStr = firstPurchaseUtilWaitDo(1,"more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("SalesQualify_recorded")) {
				String waitToDoStr = salesStaffWaitDo("0","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("SalesQualify_auditing")) {
				String waitToDoStr = salesStaffWaitDo("1","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("FirstMedicine_recorded")) {
				String waitToDoStr = firstVarityWaitDo(0,"more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("FirstMedicine_auditing")) {
				String waitToDoStr = firstVarityWaitDo(1,"more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("CheckAccept_recorded")) {
				String waitToDoStr = checkAcceptanceWaitDo("0","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("CheckAccept_auditing")) {
				String waitToDoStr = checkAcceptanceWaitDo("1","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("ReturnCheckAccept_recorded")) {
				String waitToDoStr = returnTraceWaitDo("0","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("ReturnCheckAccept_auditing")) {
				String waitToDoStr = returnTraceWaitDo("1","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("StopSale_recorded")) {
				String waitToDoStr = stopSellWaitDo("0","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("StopSale_auditing")) {
				String waitToDoStr = stopSellWaitDo("1","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("RecoverySale_recorded")) {
				String waitToDoStr = recoverSellWaitDo("0","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("RecoverySale_auditing")) {
				String waitToDoStr = recoverSellWaitDo("1","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("SellReturn_recorded")) {
				String waitToDoStr = saleReturnWaitDo("0","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("SellReturn_auditing")) {
				String waitToDoStr = saleReturnWaitDo("1","more");
				waitDoBuffer.append(waitToDoStr);
				continue;
			}
			
			/*删除出库复核待审核和带录入 else if (value.trim().equals("OutboundCheck_recorded")) {
				String waitToDoStr = outCheckWaitDo("0");
				waitDoBuffer.append(waitToDoStr);
				continue;
			} else if (value.trim().equals("OutboundCheck_auditing")) {
				String waitToDoStr = outCheckWaitDo("1");
				waitDoBuffer.append(waitToDoStr);
				continue;
			}*/

		}
		String complanWaitDo = complaintWaitingToDo(request);
		waitDoBuffer.append(complanWaitDo);//投诉管理代办事项
		String feedBackWaitDo = feedBackWaitingToDo(request);
		waitDoBuffer.append(feedBackWaitDo);//信息反馈代办事项
		Map<String, String> map = new HashMap<String, String>(); 
		map.put("responseStr", waitDoBuffer.toString());
		UtilJson.printMapJson(response,map);
		return null;
	}
	/**
	 * 首页面预警
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/homePage/waring.html")
	public String warning(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		User user  =  (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		Map<Long, String> authoriyMap =  user.getAuthoriy();
		Iterator<Long> its = authoriyMap.keySet().iterator();
		StringBuffer buffer = new StringBuffer();
		boolean hasViewQualityEntripse = true;
		boolean hasViewQualityPurchaseUtil = true;
		boolean hasViewQaulityDrug = true;
		while(its.hasNext()){
			Long key  = its.next();
			String value = authoriyMap.get(key);
			if(value.equals("QualifiedSupplierManage")){
			  buffer.append(qualifiedSuppliersWaring("0",null));
				hasViewQualityEntripse =false;
				continue;
			}else if(value.equals("QualifiedPurchaseUnitManage")){
				buffer.append(qualifiedPurchaseUtilWaring("0",null));
				hasViewQualityPurchaseUtil = false;
			}else if(value.equals("QualifiedMedicineManage")){
				buffer.append(registerMidinceWaring("0",null));
				hasViewQaulityDrug = false;
			}
		}
		if(hasViewQualityEntripse){
			buffer.append(qualifiedSuppliersWaring("1",null));
		}
		if(hasViewQualityPurchaseUtil){
			buffer.append(qualifiedPurchaseUtilWaring("1",null));
		}
		if(hasViewQaulityDrug){
			buffer.append(registerMidinceWaring("1",null));
		}
		//buffer.append(qualifiedMidinceWaring("0",null));
		Map<String, String> map = new HashMap<String, String>();
		map.put("responseStr", buffer.toString());
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/homePage/waringMore.html")
	public String warningMore(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		User user  =  (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		Map<Long, String> authoriyMap =  user.getAuthoriy();
		Iterator<Long> its = authoriyMap.keySet().iterator();
		StringBuffer buffer = new StringBuffer();
		boolean hasViewQualityEntripse = true;
		boolean hasViewQualityPurchaseUtil = true;
		boolean hasViewQaulityDrug = true;
		while(its.hasNext()){
			Long key  = its.next();
			String value = authoriyMap.get(key);
			if(value.equals("QualifiedSupplierManage")){
			  buffer.append(qualifiedSuppliersWaring("0","more"));
				hasViewQualityEntripse =false;
				continue;
			}else if(value.equals("QualifiedPurchaseUnitManage")){
				buffer.append(qualifiedPurchaseUtilWaring("0","more"));
				hasViewQualityPurchaseUtil = false;
			}else if(value.equals("QualifiedMedicineManage")){
				buffer.append(registerMidinceWaring("0","more"));
				hasViewQaulityDrug = false;
			}
		}
		if(hasViewQualityEntripse){
			buffer.append(qualifiedSuppliersWaring("1","more"));
		}
		if(hasViewQualityPurchaseUtil){
			buffer.append(qualifiedPurchaseUtilWaring("1","more"));
		}
		if(hasViewQaulityDrug){
			buffer.append(registerMidinceWaring("1","more"));
		}
	//	buffer.append(qualifiedMidinceWaring("0","more"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("responseStr", buffer.toString());
		UtilJson.printMapJson(response, map);
		return null;
	}


	/**
	 * 首营企业代办事项
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	public String firstEnterpriWaitDo(Integer type,String more) {
		StringBuffer resultBuffer = new StringBuffer();
		String hql = " from FirstEnterprise a where a.review_status=" + type
				+ " order by a.id DESC";
		String hql_more = "from FirstEnterprise a where a.review_status=:status order by a.id DESC";
		Map map = new HashMap();
		 map.put("status", type);
		List<FirstEnterprise> firstEnterpriseList = null;
		if(more==null || more.trim().equals("")){
			firstEnterpriseList = firstService.getFirstEnterpriseByPage(hql, new HashMap(), 0, 3);
		}else{
			firstEnterpriseList = firstService.getAllByState(hql_more, map);
		}
		
		
		if (firstEnterpriseList != null && firstEnterpriseList.size() > 0) {
			for (FirstEnterprise enterprise : firstEnterpriseList) {
				String customerName = enterprise.getCompanyName();
				if (type == 0) {
					resultBuffer
							.append("<li><a href='firstEnterprise/syqydlr.html'>首营企业"
									+ customerName + "待录入</a></li>");
				} else if (type == 1) {
					resultBuffer
							.append("<li><a href='firstEnterprise/syqydsh.html'>首营企业"
									+ customerName + "待审核</a></li>");
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * 购货单位待办事项
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param type
	 * @return
	 */
	public String firstPurchaseUtilWaitDo(Integer type,String more ) {
		StringBuffer resultBuffer = new StringBuffer();
		// String hql =
		// " from FirstEnterprise a where a.review_status=0 order by a.id DESC";
		String hql = "from PurchaseUnit a where 1=1 and  a.reviewStatus=:state order by a.id DESC";
		Map  map = new HashMap();
		map.put("state", type);
		List<PurchaseUnit> purchaseUnitList = null;
		if(more==null || more.trim().equals("")){
			purchaseUnitList= purchaseUtilService.findListByPage(type, 0, 3);
		}else{
			purchaseUnitList= purchaseUtilService.getAllByState(hql, map);
		}
		if (purchaseUnitList != null && purchaseUnitList.size() > 0) {
			for (PurchaseUnit purchaseUtil : purchaseUnitList) {
				String customerName = purchaseUtil.getCompanyName();
				if (type == 0) {
					resultBuffer
							.append("<li><a href='firstEnterprise/ghdwdlr.html'>购货单位"
									+ customerName + "待录入</a></li>");
				} else if (type == 1) {
					resultBuffer
							.append("<li><a href='firstEnterprise/ghdwdsh.html'>购货单位"
									+ customerName + "待审核</a></li>");
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * 采购人员
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param type
	 * @return
	 */
	public String procurementWaitDo(String type,String more) {
		StringBuffer resultBuffer = new StringBuffer();
		// String hql =
		// " from FirstEnterprise a where a.review_status=0 order by a.id DESC";
		String hql = "from ProcurementStaff a where a.reviewStatus=:state order by a.id DESC";
		Map  map = new HashMap();
		map.put("state",type);
		List<ProcurementStaff> procurementStaffList = null;
		if(more==null || more.trim().equals("")){
			procurementStaffList =  procureService.findProcurementStaffByType(type, 0, 3);
		}else{
			procurementStaffList =  procureService.getAllByState(hql, map);
		}
			
		if (procurementStaffList != null && procurementStaffList.size() > 0) {
			for (ProcurementStaff procurementStaff : procurementStaffList) {
				String customerName = procurementStaff.getProcurementName();
				if (type.equals("0")) {
					resultBuffer
							.append("<li><a href='firstEnterprise/procurementStaffList.html?type=0'>采购人员"
									+ customerName + "待录入</a></li>");
				} else if (type.equals("1")) {
					resultBuffer
							.append("<li><a href='firstEnterprise/procurementStaffList.html?type=1'>采购人员"
									+ customerName + "待审核</a></li>");
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * 销售人员代办事项
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param type
	 * @return
	 */
	public String salesStaffWaitDo(String type,String more) {
		StringBuffer resultBuffer = new StringBuffer();
		// String hql =
		// " from FirstEnterprise a where a.review_status=0 order by a.id DESC";
		String hql = " from SalesStaff a where a.reviewStatus=:state order by a.id DESC";
		Map map = new HashMap();
		map.put("state", type);
		List<SalesStaff> salesStaffList = null;
		if(more==null || more.trim().equals("")){
			salesStaffList = salesStaffService.findSalesStaffList(type, 0, 3);
		}else{
			salesStaffList = salesStaffService.getAllByState(hql, map);
		}
			
		if (salesStaffList != null && salesStaffList.size() > 0) {
			for (SalesStaff salesStaff : salesStaffList) {
				String customerName = salesStaff.getSaleName();
				if (type.equals("0")) {
					resultBuffer
							.append("<li><a href='firstEnterprise/salesStaff.html?type=0'>销售人员"
									+ customerName + "待录入</a></li>");
				} else if (type.equals("1")) {
					resultBuffer
							.append("<li><a href='firstEnterprise/salesStaff.html?type=1'>销售人员"
									+ customerName + "待审核</a></li>");
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * 首映品种代办事项
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param type
	 * @return
	 */
	public String firstVarityWaitDo(Integer type,String more ) {
		StringBuffer resultBuffer = new StringBuffer();
		// String hql =
		// " from FirstEnterprise a where a.review_status=0 order by a.id DESC";
		String hql = "from FirstVariety a where a.reviewStatus=:state order by a.id DESC";
		Map map = new HashMap();
		map.put("state", type);
		List<FirstVariety> firstVarietyList = null;
		if(more == null || more.trim().equals("")){
			firstVarietyList = firstVarietyService.findListByType(type, 0, 3);
		}else{
			firstVarietyList = firstVarietyService.getAllByState(hql, map);
		}
			
		if (firstVarietyList != null && firstVarietyList.size() > 0) {
			for (FirstVariety firstVariety : firstVarietyList) {
				String customerName = firstVariety.getCommonName();
				if (type == 0) {
					resultBuffer
							.append("<li><a href='drugVarieties/firstVariety.html?type=input'>首营品种"
									+ customerName + "待录入</a></li>");
				} else if (type == 1) {
					resultBuffer
							.append("<li><a href='drugVarieties/firstVariety.html?type=waitAudit'>首营品种"
									+ customerName + "待审核</a></li>");
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * 验收待办事项
	 * 
	 * @param type
	 * @return
	 */
	public String checkAcceptanceWaitDo(String type,String more ) {
		StringBuffer resultBuffer = new StringBuffer();
		// String hql =
		// " from FirstEnterprise a where a.review_status=0 order by a.id DESC";
		String hql = "from CheckAcceptNote t  where t.reviewStatus=:state order by t.id DESC";
		Map map = new HashMap();
		List<CheckAcceptNote> checkAcceptNoteList = null;
		if (type.equals("0")) {
			if(more == null || more.trim().equals("")){
				checkAcceptNoteList = acceptanceService.getPageysh(null, 0, 3);
			}else{
				map.put("state", 0);
				checkAcceptNoteList = acceptanceService.getAllByState(hql, map);
			}
		} else {
			if(more == null || more.trim().equals("")){
			checkAcceptNoteList = acceptanceService.getPagedsh(null, 0, 3);
			}else{
				map.put("state", 1);
				checkAcceptNoteList = acceptanceService.getAllByState(hql, map);
			}
		}
		if (checkAcceptNoteList != null && checkAcceptNoteList.size() > 0) {
			for (CheckAcceptNote checkAcceptNote : checkAcceptNoteList) {
				String customerName = checkAcceptNote.getNumber();
				if (type.equals("0")) {
					resultBuffer
							.append("<li><a href='drugState/checkaccept/dlrlist.html'>验收单号为"
									+ customerName + "待录入</a></li>");
				} else if (type.equals("1")) {
					resultBuffer
							.append("<li><a href='drugState/checkaccept/dshlist.html'>验收单号为"
									+ customerName + "待批注</a></li>");
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * 退货验收代办事项
	 * 
	 * @param type
	 * @return
	 */
	public String returnTraceWaitDo(String type,String more) {
		StringBuffer resultBuffer = new StringBuffer();
		// String hql =
		// " from FirstEnterprise a where a.review_status=0 order by a.id DESC";
		String hql = "from ReturnCheckAcceptNote t  where t.reviewStatus=:state order by t.id DESC";
		Map map = new HashMap();
		
		List<ReturnCheckAcceptNote> returnCheckAcceptNoteList = null;
		if (type.equals("0")) {
			if(more == null || more.trim().equals("")){
			returnCheckAcceptNoteList = returnTaceService.getPage(
					new ReturnCheckAcceptNote(), 0, 3);
			}else{
				map.put("state", 0);
				returnCheckAcceptNoteList = returnTaceService.getAllByState(hql, map);
			}

		} else {
			if(more == null || more.trim().equals("")){
			returnCheckAcceptNoteList = returnTaceService.getPagedsh(
					new ReturnCheckAcceptNote(), 0, 3);
			}else{
				map.put("state", 1);
				returnCheckAcceptNoteList = returnTaceService.getAllByState(hql, map);
			}
		}
		if (returnCheckAcceptNoteList != null
				&& returnCheckAcceptNoteList.size() > 0) {
			for (ReturnCheckAcceptNote returnCheckAcceptNote : returnCheckAcceptNoteList) {
				String customerName = returnCheckAcceptNote.getReturnNo();
				if (type.equals("0")) {
					resultBuffer
							.append("<li><a href='drugState/checkreturn/list.html'>退货验收单号为"
									+ customerName + "待录入</a></li>");
				} else if (type.equals("1")) {
					resultBuffer
							.append("<li><a href='drugState/checkreturn/dshlist.html'>退货验收单号为"
									+ customerName + "待审核</a></li>");
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * 药品停售代办事项
	 * 
	 * @param type
	 * @return
	 */
	public String stopSellWaitDo(String type,String more) {
		StringBuffer resultBuffer = new StringBuffer();
		// String hql =
		// " from FirstEnterprise a where a.review_status=0 order by a.id DESC";
		String hql = "from StopSaleBill t  where t.reviewStatus=:state order by t.id DESC";
		Map map = new HashMap();
		List<StopSaleBill> stopSaleBillList = null;
		if (type.equals("0")) {
			if(more == null || more.trim().equals("")){
			stopSaleBillList = stopCellService
					.getPage(new StopSaleBill(), 0, 3);
			}else{
				map.put("state", 0);
				stopSaleBillList = stopCellService.getAllByState(hql, map);
			}

		} else {
			if(more == null || more.trim().equals("")){
			stopSaleBillList = stopCellService.getPagedsh(new StopSaleBill(),
					0, 3);
			}else{
				map.put("state", 1);
				stopSaleBillList = stopCellService.getAllByState(hql, map);
			}
		}
		if (stopSaleBillList != null && stopSaleBillList.size() > 0) {
			for (StopSaleBill stopSaleBill : stopSaleBillList) {
				String customerName = stopSaleBill.getBatchProduction();
				if (type.equals("0")) {
					resultBuffer
							.append("<li><a href='drugState/stopcell/dlrlist.html'>批号为"
									+ customerName + "停售药品待录入</a></li>");
				} else if (type.equals("1")) {
					resultBuffer
							.append("<li><a href='drugState/stopcell/dshlist.html'>批号为"
									+ customerName + "停售药品待审核</a></li>");
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * 恢复销售代办事项
	 * 
	 * @param type
	 * @return
	 */
	public String recoverSellWaitDo(String type,String more) {
		StringBuffer resultBuffer = new StringBuffer();
		// String hql =
		// " from FirstEnterprise a where a.review_status=0 order by a.id DESC";
		String hql = "from RecoverySaleBill t  where t.reviewStatus=:state order by t.id DESC";
		Map map = new HashMap();
		List<RecoverySaleBill> recoverySaleBillList = null;
		if (type.equals("0")) {
			if(more == null || more.trim().equals("")){
			recoverySaleBillList = recoverySellService.getPage(
					new RecoverySaleBill(), 0, 3);
			}else{
				map.put("state", 0);
				recoverySaleBillList = recoverySellService.getAllByState(hql, map);
			}

		} else {
			if(more == null || more.trim().equals("")){
			recoverySaleBillList = recoverySellService.getPagedsh(
					new RecoverySaleBill(), 0, 3);
			}else{
				map.put("state", 1);
				recoverySaleBillList = recoverySellService.getAllByState(hql, map);
			}
		}
		if (recoverySaleBillList != null && recoverySaleBillList.size() > 0) {
			for (RecoverySaleBill recoverySaleBill : recoverySaleBillList) {
				String customerName = recoverySaleBill.getBatchProduction();
				if (type.equals("0")) {
					resultBuffer
							.append("<li><a href='drugState/recoverycell/dlrlist.html'>批号为"
									+ customerName + "恢复销售药品待录入</a></li>");
				} else if (type.equals("1")) {
					resultBuffer
							.append("<li><a href='drugState/recoverycell/dshlist.html'>批号为"
									+ customerName + "恢复销售药品待审核</a></li>");
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * 出库复核代办事项
	 * 
	 * @param type
	 * @return
	 */
	public String outCheckWaitDo(String type,String more ) {
		StringBuffer resultBuffer = new StringBuffer();
		// String hql =
		// " from FirstEnterprise a where a.review_status=0 order by a.id DESC";
		String hql = "from OutboundCheckBill t where t.reviewStatus=:state order by t.id DESC";
		Map map = new HashMap();
		List<OutboundCheckBill> outboundCheckBillList = null;
		if (type.equals("0")) {
			if(more == null || more.trim().equals("")){
			outboundCheckBillList = outCheckService.getPage(
					new OutboundCheckBill(), 0, 3);
			}else{
				map.put("state", 0);
				outboundCheckBillList = outCheckService.getAllByState(hql, map);
			}

		} else {
			if(more == null || more.trim().equals("")){
			outboundCheckBillList = outCheckService.getPagedsh(
					new OutboundCheckBill(), 0, 3);
			}else{
				map.put("state", 1);
				outboundCheckBillList= outCheckService.getAllByState(hql, map);
			}
		}
		if (outboundCheckBillList != null && outboundCheckBillList.size() > 0) {
			for (OutboundCheckBill outboundCheckBill : outboundCheckBillList) {
				String customerName = outboundCheckBill.getSalesNumber().toString();
				if (type.equals("0")) {
					resultBuffer
							.append("<li><a href='drugState/outcheck/dlrlist.html'>销售单号为"
									+ customerName + "出库复核待录入</a></li>");
				} else if (type.equals("1")) {
					resultBuffer
							.append("<li><a href='drugState/outcheck/dshlist.html'>销售单号为"
									+ customerName + "出库复核待审核</a></li>");
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * 销售退回代办事项
	 * 
	 * @param type
	 * @return
	 */
	public String saleReturnWaitDo(String type,String more ) {
		StringBuffer resultBuffer = new StringBuffer();
		// String hql =
		// " from FirstEnterprise a where a.review_status=0 order by a.id DESC";
		String hql = "from SaleReturnBill t where t.reviewStatus=:state order by t.id DESC";
		Map map = new HashMap();
		
		List<SaleReturnBill> saleReturnBillList = null;
		if (type.equals("0")) {
			if(more== null || more.trim().equals("")){
			saleReturnBillList = saleReturnService.getPage(
					new SaleReturnBill(), 0, 3);
			}else{
				map.put("state", 0);
				saleReturnBillList = saleReturnService.getAllByState(hql, map);
			}

		} else {
			if(more==null || more.trim().equals("")){
			saleReturnBillList = saleReturnService.getPagedsh(
					new SaleReturnBill(), 0, 3);
			}else{
				map.put("state", 1);
				saleReturnBillList = saleReturnService.getAllByState(hql, map);
			}
		}
		if (saleReturnBillList != null && saleReturnBillList.size() > 0) {
			for (SaleReturnBill saleReturnBill : saleReturnBillList) {
				String customerName = saleReturnBill.getNumber();
				if (type.equals("0")) {
					resultBuffer
							.append("<li><a href='drugState/salereturn/dlrlist.html'>销售单号为"
									+ customerName + "药品退回待审核录入</a></li>");
				} else if (type.equals("1")) {
					resultBuffer
							.append("<li><a href='drugState/salereturn/dshlist.html'>销售单号为"
									+ customerName + "药品退回待审核</a></li>");
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * 合格供应商有效期预警
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	public String qualifiedSuppliersWaring(String type,String more ) {

		String configHql = " from  WarnConfig a where a.limit_name like 'gys%' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		StringBuffer hqlBuffer = new StringBuffer(
				"from QualifiedSuppliers a where 1=1 and  a.deleteFlag=0");
		StringBuffer subjecBuffer = new StringBuffer();
		String yinyezhizhao = "";// 营业执照日期
	//	String yingyezhizhaonianjian = "";// 营业执照年检
		String xukezheng = "";// 经营许可证
		String gspdaoqi = "";// GS到期日期
		String zuzhijigoudama = "";// 组织机构代码
		String zuzhijigoudaimanianjian = "";// 组织机构代码年检
		String zhiliangbaozhengxiyi = "";// 质量保证协议
		String weitoushouqushu = "";// 委托授权书
		String nowdate = DateTimeUtils.getNowStrDate();
		
		StringBuffer buffer = new StringBuffer();

		for (WarnConfig config : configList) {
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
					.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null
					&& limit_name.equals("gys_businessLicense_ExpirationDate")) {
				subjecBuffer.append("or a.busiLiceExpiDate<='" + startDate + "'  ");
				yinyezhizhao = startDate;
			} /*else if (limit_name.equals("gys_businessLicense_annualSurvey")) {
				subjecBuffer.append("or a.busiLIceAnnuSurvey<='" + startDate
						+ "'  ");
				yingyezhizhaonianjian = startDate;
			} */else if (limit_name.equals("gys_licence_ExpirationDate")) {
				subjecBuffer.append("or a.liceExpiDate<='" + startDate + "'  ");
				xukezheng = startDate;
			} else if (limit_name.equals("gys_GPS_ExpirationDate")) {
				subjecBuffer.append("or a.gspExpirDate<='" + startDate + "'  ");
				gspdaoqi = startDate;
			} else if (limit_name.equals("gys_organizationCodeDate")) {
				subjecBuffer.append("or a.organizationCodeDate<='" + startDate
						+ "' ");
				zuzhijigoudama = startDate;
			} else if (limit_name.equals("gys_organizationCodeInspectionDate")) {
				subjecBuffer.append("or a.organizationCodeInspectionDate<='"
						+ startDate + "'  ");
				zuzhijigoudaimanianjian = startDate;
			} else if (limit_name.equals("gys_qualityAssuranceDate")) {
				subjecBuffer.append("or a.qualityAssuranceDate<='" + startDate
						+ "'  ");
				zhiliangbaozhengxiyi = startDate;
			} else if (limit_name.equals("gys_authorizationDate")) {
				subjecBuffer
						.append("or a.authorizationDate<='" + startDate + "'  ");
				weitoushouqushu = startDate;
			}
		}
		String subjecStr = subjecBuffer.toString();
		if(!subjecStr.trim().equals("")){
			String str = subjecStr.substring(2);
			hqlBuffer.append(" and  (");
			hqlBuffer.append(str);
			hqlBuffer.append(")");
		}
	
		List<QualifiedSuppliers> supplyList = null;
		if(more == null || more.trim().equals("")){
			supplyList = qualifiedSupplyService.getQualifiedSuppliersListByCondition(hqlBuffer.toString(),new HashMap<String, Object>(), 0, 3);
		}else{
			supplyList = qualifiedSupplyService.getAllQualifieddSupplisersByCondiction(hqlBuffer.toString(), new HashMap());
		}

		for (QualifiedSuppliers supply : supplyList) {
			// String companyName = supply.getCustomerName();
			String yyzz = supply.getBusiLiceExpiDate();// 营业执照到期时间期
		//	String yyzznj = supply.getBusiLIceAnnuSurvey();// 营业执照年检时间
			String xyz = supply.getLiceExpiDate();// 许可证到期日期
			String gsp = supply.getGspExpirDate();//GSP截止日期
			String zzjgdm = supply.getOrganizationCodeDate();// 组织机构代码
			String zzjgdmnj = supply.getOrganizationCodeInspectionDate();// 组织机构代码年检
			String zlbzxy = supply.getQualityAssuranceDate();// 质量保证协议
			String sqwts = supply.getAuthorizationDate();// 法人委托书
			String other = gspWarningDate(supply.getAccessories());// 其它证件

			if (yinyezhizhao != "" && yyzz != null
					&& DateTimeUtils.compareTwoDate(yinyezhizhao, yyzz) >= 0) {

				int days = DateTimeUtils.compareDateInterval(yyzz, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "营业执照还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "营业执照还有<font>" + days + "</font>天到期</a></li>");
					}
				} else {
				/*	if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "营业执照已过期<font>" + Math.abs(days)
							+ "</font>天</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "营业执照已过期<font>" + Math.abs(days)
								+ "</font>天</a></li>");
						
					}*/
				}
			}
		/* 去掉供应商营业执照年检限制 	if (yingyezhizhaonianjian != ""
					&& yyzznj != null
					&& DateTimeUtils.compareTwoDate(yingyezhizhaonianjian,
							yyzznj) >= 0) {

				int days = DateTimeUtils.compareDateInterval(yyzznj, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "营业执照年检还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "营业执照年检还有<font>" + days + "</font>天到期</a></li>");
						
					}
				} else {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "营业执照年检已过期<font>" + Math.abs(days)
							+ "</font>天</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "营业执照年检已过期<font>" + Math.abs(days)
								+ "</font>天</a></li>");
						
					}
				}

			}*/
			if (xukezheng != "" && xyz != null
					&& DateTimeUtils.compareTwoDate(xukezheng, xyz) >= 0) {
				int days = DateTimeUtils.compareDateInterval(xyz, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "经营许可证还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "经营许可证还有<font>" + days + "</font>天到期</a></li>");
						
					}
				} else {
					/*if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "经营许可证已过期<font>" + Math.abs(days)
							+ "</font>天</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "经营许可证已过期<font>" + Math.abs(days)
								+ "</font>天</a></li>");
						
					}*/
					
				}
			}
			if (gspdaoqi != "" && gsp != null
					&& gsp!="" &&  DateTimeUtils.compareTwoDate(gspdaoqi, gsp) >= 0) {
				int days = DateTimeUtils.compareDateInterval(gsp, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "GSP/GMP认证还有<font>" + days
							+ "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "GSP/GMP认证还有<font>" + days
								+ "</font>天到期</a></li>");
					}
				} else {
					/*if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "GSP/GMP认证已过期<font>" + Math.abs(days)
							+ "</font>天</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "GSP/GMP认证已过期<font>" + Math.abs(days)
								+ "</font>天</a></li>");
						
					}*/
				}
			}
			if (zuzhijigoudama != ""
					&& zzjgdm != null
					&& DateTimeUtils.compareTwoDate(zuzhijigoudama, zzjgdm) >= 0) {
				int days = DateTimeUtils.compareDateInterval(zzjgdm, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "组织机构代码还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "组织机构代码还有<font>" + days + "</font>天到期</a></li>");
					}
				} else {
				/*	if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "组织机构代码已过期<font>" + Math.abs(days)
							+ "</font>天</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "组织机构代码已过期<font>" + Math.abs(days)
								+ "</font>天</a></li>");
						
					}*/
				}

			}
			if (zuzhijigoudaimanianjian != ""
					&& zzjgdmnj != null
					&& DateTimeUtils.compareTwoDate(zuzhijigoudaimanianjian,
							zzjgdmnj) >= 0) {
				int days = DateTimeUtils.compareDateInterval(zzjgdmnj, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "组织机构代码年检还有<font>" + days
							+ "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "组织机构代码年检还有<font>" + days
								+ "</font>天到期</a></li>");
					}
				} else {
				/*	if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "组织机构代码年检已过期<font>" + Math.abs(days)
							+ "</font>天</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "组织机构代码年检已过期<font>" + Math.abs(days)
								+ "</font>天</a></li>");
						
					}*/
				}
			}
			if (zhiliangbaozhengxiyi != ""
					&& zlbzxy != null
					&& DateTimeUtils.compareTwoDate(zhiliangbaozhengxiyi,
							zlbzxy) >= 0) {
				int days = DateTimeUtils.compareDateInterval(zlbzxy, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer
							.append("" + supply.getCustomerName()
									+ "质量保证协议书还有<font>" + days
									+ "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer
								.append("" + supply.getCustomerName()
										+ "质量保证协议书还有<font>" + days
										+ "</font>天到期</a></li>");
						
					}
				} else {
					/*if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "质量保证协议书已过期<font>" + Math.abs(days)
							+ "</font>天</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "质量保证协议书已过期<font>" + Math.abs(days)
								+ "</font>天</a></li>");
						
					}*/
				}
			}
			if (weitoushouqushu != ""
					&& sqwts != null
					&& DateTimeUtils.compareTwoDate(weitoushouqushu, sqwts) >= 0) {
				int days = DateTimeUtils.compareDateInterval(sqwts, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "法人委托书还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "法人委托书还有<font>" + days + "</font>天到期</a></li>");
						
					}
				} else {
					/*if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hggys.html?id="
							+ supply.getId() + "' traget='_blank'>");
					buffer.append("" + supply.getCustomerName()
							+ "法人委托书已过期<font>" + Math.abs(days)
							+ "</font>天</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + supply.getCustomerName()
								+ "法人委托书已过期<font>" + Math.abs(days)
								+ "</font>天</a></li>");
					
					}*/
				}
			}
		}
		return buffer.toString();
	}
/**
 * 购货单位预警
 * @param model
 * @param request
 * @param response
 * @return
 */
	public String qualifiedPurchaseUtilWaring(String type,String more ) {
		String configHql = " from  WarnConfig a where a.limit_name like 'ghs%' or a.limit_name like 'cg%' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		StringBuffer hqlBuffer = new StringBuffer(
				"from QualifiedPurchaseUnits a where 1=1 and  a.delete_flag=0");
		StringBuffer subjectBuffer = new StringBuffer();
		String yinyezhizhao = "";// 营业执照日期
	//	String yingyezhizhaonianjian = "";// 营业执照年检
		String xukezheng = "";// 许可证
		String gspdaoqi = "";// GS到期日期
		String zuzhijigoudaima = "";// 组织机构代码
		String zuzhijigoudaimanianjian = "";// 组织机构代码年检
		String zhiliaobaozhengxieyishu = "";// 质量保证协议书
		String shouquanweitoushu = "";// 委托授权书
		String cgfarenweituoshu = "";//采购人员法人委托书
		String cgshenfenzheng = "";//采购人员身份证
		String nowdate = DateTimeUtils.getNowStrDate();
		StringBuffer buffer = new StringBuffer();
		//修改过期失效时间（不包括当天）
		for (WarnConfig config : configList) {
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
					.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null
					&& limit_name.equals("ghs_businessLicense_ExpirationDate")) {
				subjectBuffer
						.append("or a.busLiceExpiraDate<'" + startDate + "'  ");
				yinyezhizhao = startDate;
			}/* else if (limit_name.equals("ghs_businessLicense_annualSurvey")) {
				subjectBuffer.append("or a.busLiceAnnualSurvey<='" + startDate
						+ "'  ");
				yingyezhizhaonianjian = startDate;
			} */else if (limit_name.equals("ghs_licence_ExpirationDate")) {
				subjectBuffer.append("or a.liceExpirationDate<'" + startDate
						+ "'  ");
				xukezheng = startDate;
			} else if (limit_name.equals("ghs_GPS_ExpirationDate")) {
				subjectBuffer
						.append("or a.gpsExpirationDate<'" + startDate + "' ");
				gspdaoqi = startDate;
			} else if (limit_name.equals("ghs_organizationCodeDate")) {
				subjectBuffer.append("or a.organizationCodeDate<'" + startDate
						+ "'  ");
				zuzhijigoudaima = startDate;
			} else if (limit_name.equals("ghs_organizationCodeInspectionDate")) {
				subjectBuffer.append("or a.organizationCodeInspectionDate<'"
						+ startDate + "'  ");
				zuzhijigoudaimanianjian = startDate;
			} else if (limit_name.equals("ghs_qualityAssuranceDate")) {
				subjectBuffer.append("or a.qualityAssuranceDate<'" + startDate
						+ "'  ");
				zhiliaobaozhengxieyishu = startDate;
			} else if (limit_name.equals("ghs_authorizationDate")) {
				subjectBuffer
						.append("or a.authorizationDate<'" + startDate + "'  ");
				shouquanweitoushu = startDate;
			}else if(limit_name.equals("cg_authorizationDate")){
				cgfarenweituoshu = startDate;
			}else if(limit_name.equals("cg_IDCardValidate")){
				cgshenfenzheng = startDate;
			}
		}
		String subjecStr = subjectBuffer.toString();
		if(!subjecStr.trim().equals("")){
			String str = subjecStr.substring(2);
			hqlBuffer.append(" and (");
			hqlBuffer.append(str);
			hqlBuffer.append(")");
		}
		List<QualifiedPurchaseUnits> purchaseList = null;
		if(more == null || more.trim().equals("")){
			purchaseList = qualifiedPurchaseUnitsService.findList(hqlBuffer.toString());
		}else{
			purchaseList = qualifiedPurchaseUnitsService.getAllByState(hqlBuffer.toString(), new HashMap());
		}
		String today = DateTimeUtils.getNowStrDate();//当前日期
		for (QualifiedPurchaseUnits purchase : purchaseList) {
			// String companyName = supply.getCustomerName();
			String yyzz = purchase.getBusLiceExpiraDate();// 营业执照到期时间期
		//	String yyzznj = purchase.getBusLiceAnnualSurvey();// 营业执照年检时间
			String xyz = purchase.getLiceExpirationDate();// 许可证到期日期
			String gsp = purchase.getGpsExpirationDate();// GSP截止日期
			String zzjgdm = purchase.getOrganizationCodeDate();// 组织机构代码
			String zzjgdmnj = purchase.getOrganizationCodeInspectionDate();// 组织机构代码年检
			String zlbzs = purchase.getQualityAssuranceDate();
			String sqwts = purchase.getAuthorizationDate();
			// String khxx = purchase.getAccountDate();//开户信息到期日期
			ProcurementStaff procurementStaff = purchase.getProcurementStaff();
			if(yyzz!=null && !"".equals(yyzz)&& DateTimeUtils.compareTwoDate(today, yyzz)>0){
				if(purchase.getUseFlag()!=null && purchase.getUseFlag().trim().equals("0")){
					purchase.setUseFlag("2");
					qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}
				
			}/*else if(yyzznj!=null && !"".equals(yyzznj)&& DateTimeUtils.compareTwoDate(today, yyzznj)>0){
				if(purchase.getUseFlag()!=null && !purchase.getUseFlag().trim().equals("1")){
					purchase.setUseFlag("1");
					qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}
				
			}*/else if(xyz!=null && !"".equals(xyz)&& DateTimeUtils.compareTwoDate(today, xyz)>0){
				if(purchase.getUseFlag()!=null && purchase.getUseFlag().trim().equals("0")){
					purchase.setUseFlag("2");
					qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}
				
			}else if(gsp!=null && !"".equals(gsp)&& DateTimeUtils.compareTwoDate(today, gsp)>0){
				if(purchase.getUseFlag()!=null && purchase.getUseFlag().trim().equals("0")){
					purchase.setUseFlag("2");
					qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}
				
			}else if(zzjgdmnj!=null && !"".equals(zzjgdmnj)&& DateTimeUtils.compareTwoDate(today, zzjgdmnj)>0){
				if(purchase.getUseFlag()!=null && purchase.getUseFlag().trim().equals("0")){
					purchase.setUseFlag("2");
					qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}
				
			}else if(zzjgdm!=null && !"".equals(zzjgdm)&& DateTimeUtils.compareTwoDate(today, zzjgdm)>0){
				if(purchase.getUseFlag()!=null && purchase.getUseFlag().trim().equals("0")){
					purchase.setUseFlag("2");
					qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}
				
			}else if(zlbzs!=null && !"".equals(zlbzs)&& DateTimeUtils.compareTwoDate(today, zlbzs)>0){
				if(purchase.getUseFlag()!=null && purchase.getUseFlag().trim().equals("0")){
					purchase.setUseFlag("2");
					qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}
				
			}else if(sqwts!=null && !"".equals(sqwts)&& DateTimeUtils.compareTwoDate(today, sqwts)>0){
				if(purchase.getUseFlag()!=null && purchase.getUseFlag().trim().equals("0")){
					purchase.setUseFlag("2");
					qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}
				
			}
			if(procurementStaff!=null && procurementStaff.getIdentityCardDate()!= null && !"".equals(procurementStaff.getIdentityCardDate()) && DateTimeUtils.compareTwoDate(today, procurementStaff.getIdentityCardDate())>0){
				if(purchase.getUseFlag()!=null && purchase.getUseFlag().trim().equals("0")){
					purchase.setUseFlag("2");
					qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}
				
			}
			if(procurementStaff!=null && procurementStaff.getPowerOfAttorneyDate()!= null && !"".equals(procurementStaff.getPowerOfAttorneyDate()) && DateTimeUtils.compareTwoDate(today, procurementStaff.getPowerOfAttorneyDate())>0){
				if(purchase.getUseFlag()!=null && purchase.getUseFlag().trim().equals("0")){
					purchase.setUseFlag("2");
					qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}
				
			}
		/*	if (yyzz != null && !"".equals(yyzz)
					&& DateTimeUtils.compareTwoDate(today, yyzz) <= 0
					&& yyzznj != null && !"".equals(yyzznj)
					&& DateTimeUtils.compareTwoDate(today, yyzznj) <= 0
					&& xyz != null && !"".equals(xyz)
					&& DateTimeUtils.compareTwoDate(today, xyz) <= 0
					&& gsp != null && !"".equals(gsp)
					&& DateTimeUtils.compareTwoDate(today, gsp) <= 0
					&& zzjgdmnj != null && !"".equals(zzjgdmnj)
					&& DateTimeUtils.compareTwoDate(today, zzjgdmnj) <= 0
					&& zzjgdm != null && !"".equals(zzjgdm)
					&& DateTimeUtils.compareTwoDate(today, zzjgdm) <= 0
					&& zlbzs != null && !"".equals(zlbzs)
					&& DateTimeUtils.compareTwoDate(today, zlbzs) <= 0
					&& sqwts != null && !"".equals(sqwts)
					&& DateTimeUtils.compareTwoDate(today, sqwts) <= 0){
				if(purchase.getUseFlag()!=null && !purchase.getUseFlag().trim().equals("0")){
					purchase.setUseFlag("0");
					qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}
			}*/
			if(purchase.getDelete_flag()==0){
			if (yinyezhizhao != "" && yyzz != null && !"".equals(yyzz)
					&& DateTimeUtils.compareTwoDate(yinyezhizhao, yyzz) >= 0) {

				int days = DateTimeUtils.compareDateInterval(yyzz, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append("" + purchase.getCustomerName()
							+ "营业执照还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + purchase.getCustomerName()
								+ "营业执照还有<font>" + days + "</font>天到期</a></li>");
						
					}
				} else {
				/*	if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer
							.append("" + purchase.getCustomerName()
									+ "营业执照已过期<font>" + Math.abs(days)
									+ "</font>天</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer
								.append("" + purchase.getCustomerName()
										+ "营业执照已过期<font>" + Math.abs(days)
										+ "</font>天</a></li>");
						
					}*/
				}

			}
	/* 去掉购货单位营业执照年检限制		if (yingyezhizhaonianjian != ""
					&& yyzznj != null && !"".equals(yyzznj)
					&& DateTimeUtils.compareTwoDate(yingyezhizhaonianjian,
							yyzznj) >= 0) {

				int days = DateTimeUtils.compareDateInterval(yyzznj, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append("" + purchase.getCustomerName()
							+ "营业执照年检还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javasccript:void(0)'>");
						buffer.append("" + purchase.getCustomerName()
								+ "营业执照年检还有<font>" + days + "</font>天到期</a></li>");
						
					}
				} else {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append("" + purchase.getCustomerName()
							+ "营业执照年检已过期<font>" + Math.abs(days)
							+ "</font>天</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + purchase.getCustomerName()
								+ "营业执照年检已过期<font>" + Math.abs(days)
								+ "</font>天</a></li>");
						
					}
				}

			}*/
			if (xukezheng != "" && xyz != null && !"".equals(xyz)
					&& DateTimeUtils.compareTwoDate(xukezheng, xyz) >= 0) {
				int days = DateTimeUtils.compareDateInterval(xyz, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append("" + purchase.getCustomerName()
							+ "许可证还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + purchase.getCustomerName()
								+ "许可证还有<font>" + days + "</font>天到期</a></li>");
						
					}
				} else {
				/*	if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append("" + purchase.getCustomerName()
							+ "许可证已过期<font>" + Math.abs(days) + "</font>天</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + purchase.getCustomerName()
								+ "许可证已过期<font>" + Math.abs(days) + "</font>天</a></li>");
						
					}*/
				}

			}
			if (gspdaoqi != "" && gsp != null && !"".equals(gsp)
					&& DateTimeUtils.compareTwoDate(gspdaoqi, gsp) >= 0) {
				int days = DateTimeUtils.compareDateInterval(gsp, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append("" + purchase.getCustomerName()
							+ "GSP认证还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + purchase.getCustomerName()
								+ "GSP认证还有<font>" + days + "</font>天到期</a></li>");
						
					}
				} else {
				/*	if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append("" + purchase.getCustomerName()
							+ "GSP认证已过期<font>" + Math.abs(days)
							+ "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + purchase.getCustomerName()
								+ "GSP认证已过期<font>" + Math.abs(days)
								+ "</font>天到期</a></li>");
						
					}*/
				}

			}

			if (zuzhijigoudaima != ""
					&& zzjgdm != null && !"".equals(zzjgdm)
					&& DateTimeUtils.compareTwoDate(zuzhijigoudaima, zzjgdm) >= 0) {
				int days = DateTimeUtils.compareDateInterval(zzjgdm, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append("" + purchase.getCustomerName()
							+ "组织机构代码还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + purchase.getCustomerName()
								+ "组织机构代码还有<font>" + days + "</font>天到期</a></li>");
						
					}
				} else {
				/*	if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append("" + purchase.getCustomerName()
							+ "组织机构代码已过期<font>" + Math.abs(days)
							+ "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + purchase.getCustomerName()
								+ "组织机构代码已过期<font>" + Math.abs(days)
								+ "</font>天到期</a></li>");
						
					}*/

				}
			}
			if (zuzhijigoudaimanianjian != ""
					&& zzjgdmnj != null && !"".equals(zzjgdmnj)
					&& DateTimeUtils.compareTwoDate(zuzhijigoudaimanianjian,
							zzjgdmnj) >= 0) {
				int days = DateTimeUtils.compareDateInterval(zzjgdmnj, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append(""
							+ purchase.getCustomerName()
							+ "组织机构代码年检还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append(""
								+ purchase.getCustomerName()
								+ "组织机构代码年检还有<font>" + days + "</font>天到期</a></li>");
						
					}
				} else {
				/*	if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append(""
							+ purchase.getCustomerName()
							+ "组织机构代码年检已过期<font>" + Math.abs(days)
							+ "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append(""
								+ purchase.getCustomerName()
								+ "组织机构代码年检已过期<font>" + Math.abs(days)
								+ "</font>天到期</a></li>");
					}*/

				}
			}
			if (zhiliaobaozhengxieyishu != ""
					&& zlbzs != null && !"".equals(zlbzs)
					&& DateTimeUtils.compareTwoDate(zhiliaobaozhengxieyishu,
							zlbzs) >= 0) {
				int days = DateTimeUtils.compareDateInterval(zlbzs, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append("" + purchase.getCustomerName()
							+ "质量保证协议书还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + purchase.getCustomerName()
								+ "质量保证协议书还有<font>" + days + "</font>天到期</a></li>");
						
					}
				} else {
				/*	if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append("" + purchase.getCustomerName()
							+ "质量保证协议书已过期<font>" + Math.abs(days)
							+ "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + purchase.getCustomerName()
								+ "质量保证协议书已过期<font>" + Math.abs(days)
								+ "</font>天到期</a></li>");
					}*/

				}
			}
			if (shouquanweitoushu != ""
					&& sqwts != null && !"".equals(sqwts)
					&& DateTimeUtils.compareTwoDate(shouquanweitoushu, sqwts) >= 0) {
				int days = DateTimeUtils.compareDateInterval(sqwts, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append("" + purchase.getCustomerName()
							+ "法人委托书还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + purchase.getCustomerName()
								+ "法人委托书还有<font>" + days + "</font>天到期</a></li>");
						
					}
				} else {
				/*	if(type.equals("0")){
					buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
							+ purchase.getId() + "' traget='_blank'>");
					buffer.append("" + purchase.getCustomerName()
							+ "法人委托书已过期<font>" + Math.abs(days)
							+ "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append("" + purchase.getCustomerName()
								+ "法人委托书已过期<font>" + Math.abs(days)
								+ "</font>天到期</a></li>");
						
					}*/

				}
			}
			
			if(procurementStaff != null){
				if(procurementStaff.getPowerOfAttorneyDate() != null && !"".equals(procurementStaff.getPowerOfAttorneyDate().trim())){
					if(DateTimeUtils.compareTwoDate(cgfarenweituoshu, procurementStaff.getPowerOfAttorneyDate())>=0){
						int days =  DateTimeUtils.compareDateInterval(procurementStaff.getPowerOfAttorneyDate(),nowdate );
						if(days>=0){
							if(type.equals("0")){
								buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
										+ purchase.getId() + "' traget='_blank'>");
								buffer.append("" + purchase.getCustomerName()+"采购员"+procurementStaff.getProcurementName()
										+ "法人委托书还有<font>" + days + "</font>天到期</a></li>");
								}else{
									buffer.append("<li><a href='javascript:void(0)'>");
									buffer.append("" + purchase.getCustomerName()+"采购员"+procurementStaff.getProcurementName()
											+ "法人委托书还有<font>" + days + "</font>天到期</a></li>");
									
								}
						}else{
							
						}
					}
				}
				if(procurementStaff.getIdentityCardDate() != null && !"".equals(procurementStaff.getIdentityCardDate().trim())){
					if(DateTimeUtils.compareTwoDate(cgshenfenzheng, procurementStaff.getIdentityCardDate())>=0){
						int days =  DateTimeUtils.compareDateInterval(procurementStaff.getIdentityCardDate(),nowdate );
						if(days>=0){
							if(type.equals("0")){
								buffer.append("<li><a href='firstEnterprise/view_hgghdw.html?id="
										+ purchase.getId() + "' traget='_blank'>");
								buffer.append("" + purchase.getCustomerName()+"采购员"+procurementStaff.getProcurementName()
										+ "身份证还有<font>" + days + "</font>天到期</a></li>");
								}else{
									buffer.append("<li><a href='javascript:void(0)'>");
									buffer.append("" + purchase.getCustomerName()+"采购员"+procurementStaff.getProcurementName()
											+ "身份证还有<font>" + days + "</font>天到期</a></li>");
									
								}
						}else{
//							buffer.append("&nbsp;<a href='view_hgghdw.html?id="+purchase.getId()+"' traget='_blank'>");
//							buffer.append(""+purchase.getCustomerName()+"采购员"+procurementStaff.getProcurementName()+"身份证已过期<font>"+Math.abs(days)+"</font>天到期</a>");
							
						}
					}
				}
			}
		}
		}
		return buffer.toString();

	}
	/**
	 * 药品有效期
	 * @param type
	 * @return
	 */
	public String qualifiedMidinceWaring(String type,String more){
		String configHql = " from  WarnConfig a where a.limit_name ='yp_valid_date' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		StringBuffer hqlBuffer = new StringBuffer(
				"from Qualifiedmedcstore a where 1=1 ");
		String yaopinyouxiaoqi="";
		String nowdate = DateTimeUtils.getNowStrDate();
		for(WarnConfig config : configList){
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
					.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null
					&& limit_name.equals("yp_valid_date")) {
				hqlBuffer
						.append(" and a.validdate<='" + startDate + "'");
				yaopinyouxiaoqi = startDate;
			} 
		}
		StringBuffer buffer = new StringBuffer();
		List<Qualifiedmedcstore> qualifiedMedList = null;
		if(more == null || more.trim().equals("")){
		 qualifiedMedList = qualifiedmedStoreService.findQualifiedMedcStore(hqlBuffer.toString(),0,3);
		}else{
			qualifiedMedList = qualifiedmedStoreService.getAllByState(hqlBuffer.toString(), new HashMap());
		}
		for(Qualifiedmedcstore medicStore : qualifiedMedList){
			String ypyxq = medicStore.getValiddate();
			if(yaopinyouxiaoqi!=""  && ypyxq!=null && !"".equals(ypyxq) && DateTimeUtils.compareTwoDate(yaopinyouxiaoqi,
					ypyxq) >= 0){
				int days = DateTimeUtils.compareDateInterval(ypyxq, nowdate);
				if (days >= 0) {
					buffer.append("<li><a href='javascript:void(0)' >");
					buffer.append("批号为"+medicStore.getBatchproduction()+"的" + medicStore.getQualityMidicine().getCommonname()
							+ "药品有效期还有<font>" + days + "</font>天到期</a></li>");
				} else {
				/*	buffer.append("<li><a href='javascript:void(0)' >");
					buffer.append("批号为"+medicStore.getBatchproduction()+"的" + medicStore.getQualityMidicine().getCommonname()
							+ "药品已过期<font>" + Math.abs(days)
							+ "</font>天到期</a></li>");*/

				}
			}
		}
		return buffer.toString();
	}
	/**
	 * 药品注册文件效期
	 * @param type
	 * @return
	 */
	public String registerMidinceWaring(String type,String more ){
		String configHql = " from  WarnConfig a where a.limit_name ='yp_medince_regist_date' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		StringBuffer hqlBuffer = new StringBuffer(
				"from QualityMidicine a where 1=1 ");
		String yaopinyouxiaoqi="";
		String nowdate = DateTimeUtils.getNowStrDate();
		for(WarnConfig config : configList){
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
					.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null
					&& limit_name.equals("yp_medince_regist_date")) {
				hqlBuffer
						.append(" and a.medcRegistrApprovalDate<='" + startDate + "'");
				yaopinyouxiaoqi = startDate;
			} 
		}
		StringBuffer buffer = new StringBuffer();
		List<QualityMidicine> qualifiedMedList = null;
		if(more == null || more.trim().equals("")){
			qualifiedMedList =  qualityMidicService.findList(hqlBuffer.toString(), 0,3);
		}else{
			qualifiedMedList =  qualityMidicService.getAllByState(hqlBuffer.toString(), new HashMap());
		}
		for(QualityMidicine medicStore : qualifiedMedList){
			
			String ypyxq = medicStore.getMedcRegistrApprovalDate();
			if(medicStore.getUseflag()==0){
			if(yaopinyouxiaoqi!=""  && ypyxq!=null && !"".equals(ypyxq) && DateTimeUtils.compareTwoDate(yaopinyouxiaoqi,
					ypyxq) >= 0){
				int days = DateTimeUtils.compareDateInterval(ypyxq, nowdate);
				if (days >= 0) {
					if(type.equals("0")){
					buffer.append("<li><a href='drugVarieties/qulidiedMedicinal.html'> ");
					buffer.append(""+medicStore.getCommonname()+"的" +
							 "药品注册证还有<font>" + days + "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'> ");
						buffer.append(""+medicStore.getCommonname()+"的" +
								 "药品注册证还有<font>" + days + "</font>天到期</a></li>");
					}
				} else {
					if(medicStore.getUseflag() != 1 ){
						medicStore.setUseflag(1);
						qualityMidicService.save(medicStore);
					}
				/*	if(type.equals("0")){
					buffer.append("<li><a href='drugVarieties/qulidiedMedicinal.html' traget='_blank'>");
					buffer.append(""+medicStore.getCommonname()+"的"
							+ "药品注册证已过期<font>" + Math.abs(days)
							+ "</font>天到期</a></li>");
					}else{
						buffer.append("<li><a href='javascript:void(0)'>");
						buffer.append(""+medicStore.getCommonname()+"的"
								+ "药品注册证已过期<font>" + Math.abs(days)
								+ "</font>天到期</a></li>");
					}*/

				}
			}
		}
		}
		return buffer.toString();
	}
	private String gspWarningDate(Set<QulifiedSupplyAccessory> accessorySet){
		String gspWarningDate = "";
		List<String> list = new ArrayList<String>();
		if(accessorySet!=null && accessorySet.size()>0){
			Iterator<QulifiedSupplyAccessory>  iterator = accessorySet.iterator();
			while(iterator.hasNext()){
				String date = iterator.next().getAccessoryDate();
				if(date!=null && !"".equals(date)&& !"null".equalsIgnoreCase(date)){
					list.add(date);
				}
			}
			Collections.sort(list);
			if(list.size()>0)
				gspWarningDate  = list.get(0);
		}
		return gspWarningDate;
	}
	/**
	 * 投诉管理代办事项
	 * @param request
	 * @param userId
	 * @return
	 */
	private String complaintWaitingToDo(HttpServletRequest request){
		int count = 0;
		User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER);
		String str = "";
		try{
			count = drugComInfoService.countWaitingToDo(user.getId());
			if(count>0){
				str = "<li><a href='qualityRecords/complantManger/list.html'>投诉事项待处理</a></li>";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * 信息反馈代办事项
	 * @param request
	 * @return
	 */
	private String feedBackWaitingToDo(HttpServletRequest request){
		int count = 0;
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		String str = "";
		try{
			count = infoFeedBackService.countFeedbackWaitingToDo(user.getId());
			if(count>0){
				str = "<li><a href='qualityRecords/infoFeedback/list.html'>信息反馈待处理</a></li>";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * 首页项目跟新内容提示
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/homePage/updateContents.html")
	public String updatesContent(HttpServletRequest request,HttpServletResponse response){
		String contexPaht = request.getSession().getServletContext().getRealPath("/");
		String filePath = contexPaht+"updateContent\\updatesContent.txt";
		StringBuffer buffer = new StringBuffer();
		try{
			File file = new File(filePath);
			if(file.isFile() && file.exists()){//判断文件是否存在
				InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"utf-8");//编码格式utf-8
				BufferedReader bufferReader = new BufferedReader(reader);
				String readLine = null;
				while((readLine=bufferReader.readLine())!=null){
					buffer.append(readLine+"<br>");
				}
			}
			UtilJson.print(response, URLEncoder.encode(buffer.toString(), "utf-8"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
