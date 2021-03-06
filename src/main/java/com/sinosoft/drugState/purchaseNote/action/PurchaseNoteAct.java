package com.sinosoft.drugState.purchaseNote.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrder;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItemVO;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderRecords;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderVO;
import com.sinosoft.drugState.inspectionRecords.model.QualifiedEdit;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.mackNo.service.MakeNoMng;
import com.sinosoft.drugState.price.MedcPrice;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;
import com.sinosoft.drugState.procurementProgram.serviece.ProcurementProgramMng;
import com.sinosoft.drugState.purchaseNote.service.PurchaseNoteItemMng;
import com.sinosoft.drugState.purchaseNote.service.PurchaseNoteMng;
import com.sinosoft.drugState.purchaseNote.service.PurchaseOrderRecordsManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyDrugFroms;
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedSuppliersService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.SalesStaffService;
import com.sinosoft.frame.util.DateUtil;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;

@Controller
public class PurchaseNoteAct {

	@Autowired
	private SalesStaffService service;
	@Autowired
	private PurchaseNoteMng purchaseNoteMng;
	@Autowired
	private PurchaseNoteItemMng purchaseNoteItemMng;
	@Autowired
	private InspectionMng inspectionMng;
	@Autowired
	private MakeNoMng makeNoMng;
	@Autowired
	private ProcurementProgramMng procurementProgramMng;
	@Autowired
	private QualityMidicineMng qualityMidicineMng;
	@Autowired
	private SystemLogService logService;
	@Autowired
	private PurchaseOrderRecordsManager purchaseOrderRecordsManager;
	@Autowired
	private QualifiedSuppliersService qualifiedSuppliersService;

	@RequestMapping("/drugState/purchaseNote/list.html")
	public ModelAndView openFramePage(PurchaseOrder re, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		if (re == null) {
			re = new PurchaseOrder();
		}
		// String ypname = request.getParameter("ypname");
		String orderNumber = request.getParameter("orderNumber");// 订单编号
		String modityDate = request.getParameter("modityDate");// 订单时间
		String yhDate = request.getParameter("yhDate");
		String department = request.getParameter("department");
		String isfood = request.getParameter("isfood");
		model.addAttribute("yhDate", yhDate);
		// model.addAttribute("ypname", ypname);
		model.addAttribute("orderNumber", orderNumber);
		model.addAttribute("modityDate", modityDate);
		model.addAttribute("department", department);
		model.addAttribute("isfood", isfood);
		/*
		 * if(ypname!=null && !"".equals(ypname)){ re.setModifyDate(ypname); }
		 */
		if (orderNumber != null && !"".equals(orderNumber)) {
			re.setModifyDate(orderNumber);
		}
		if (modityDate != null && !"".equals(modityDate)) {
			re.setModifyDate(modityDate);
		}
		if (yhDate != null && !"".equals(yhDate)) {
			re.setSeason(yhDate);
		}
		String pageNo = request.getParameter("thispage");
		if (pageNo != null) {
			page = pageNo;
		}
		// List<PurchaseOrder> reslist=new ArrayList<PurchaseOrder>();
		List<PurchaseOrderVO> reslist = null;
		if (page == null) {
			// 如果page等于空，默认从第一条开始查询
			// reslist= purchaseNoteMng.getPage(re,0,Constants.pagesize);
			reslist = purchaseNoteMng.findPurchseOrderVOByStatusNew(yhDate, orderNumber, modityDate, department, isfood,
					"0", 0, Constants.pagesize);
		} else {
			// 否者翻页查询
			// reslist= purchaseNoteMng.getPage(re,(Integer.parseInt(page) - 1)
			// * Constants.pagesize,Constants.pagesize);
			reslist = purchaseNoteMng.findPurchseOrderVOByStatusNew(yhDate, orderNumber, modityDate, department, isfood,
					"0", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// int resultSize = purchaseNoteMng.getTotalCount(re);
		// int resultSize =
		// purchaseNoteMng.countPurchaseOrderVOByCondition(yhDate, ypname);
		// int resultSize =
		// purchaseNoteMng.countPurchaseOrderVOByStatusNew(yhDate, ypname,
		// department,isfood, "0");
		int resultSize = purchaseNoteMng.countPurchaseOrderVOByStatusNew(yhDate, orderNumber, modityDate, department,
				isfood, "0");
		double size = resultSize;
		// 页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("re", re);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("drugState/purchaseNote/list");
	}

	@RequestMapping("/drugState/purchaseNote/dshlist.html")
	public String waitToPurchaseOrderList(Model model, HttpServletRequest request, HttpServletResponse response) {
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页

		// String ypname = request.getParameter("ypname");//批号
		String orderNumber = request.getParameter("orderNumber");// 订单编号
		String modityDate = request.getParameter("modityDate");// 订单时间
		String yhDate = request.getParameter("yhDate");// 通用名称
		String department = request.getParameter("department");// 经营公司
		String isfood = request.getParameter("isfood");

		model.addAttribute("yhDate", yhDate);
		model.addAttribute("orderNumber", orderNumber);
		model.addAttribute("modityDate", modityDate);
		// model.addAttribute("ypname", ypname);
		model.addAttribute("department", department);
		model.addAttribute("isfood", isfood);

		// List<PurchaseOrder> reslist=new ArrayList<PurchaseOrder>();
		List<PurchaseOrderVO> reslist = null;
		if (page == null) {
			// 如果page等于空，默认从第一条开始查询
			// reslist= purchaseNoteMng.getPage(re,0,Constants.pagesize);
			reslist = purchaseNoteMng.findPurchseOrderVOByStatusNew(yhDate, orderNumber, modityDate, department, isfood,
					"1", 0, Constants.pagesize);
		} else {
			// 否者翻页查询
			// reslist= purchaseNoteMng.getPage(re,(Integer.parseInt(page) - 1)
			// * Constants.pagesize,Constants.pagesize);
			reslist = purchaseNoteMng.findPurchseOrderVOByStatusNew(yhDate, orderNumber, modityDate, department, isfood,
					"1", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// int resultSize = purchaseNoteMng.getTotalCount(re);
		// int resultSize =
		// purchaseNoteMng.countPurchaseOrderVOByCondition(yhDate, ypname);
		int resultSize = purchaseNoteMng.countPurchaseOrderVOByStatusNew(yhDate, orderNumber, modityDate, department,
				isfood, "1");
		double size = resultSize;
		// 页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		// model.addAttribute("re", re);
		model.addAttribute("reslist", reslist);
		return "drugState/purchaseNote/dshlist";
	}

	@RequestMapping("/drugState/purchaseNote/yshlist.html")
	public String auditedPurchaseOrderList(Model model, HttpServletRequest request, HttpServletResponse response) {
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页

		// String ypname = request.getParameter("ypname");//批号
		String orderNumber = request.getParameter("orderNumber");// 订单编号
		String modityDate = request.getParameter("modityDate");// 订单时间
		String yhDate = request.getParameter("yhDate");// 通用名称
		String department = request.getParameter("department");// 经营公司
		String useFlag = request.getParameter("useFlag");
		String isfood = request.getParameter("isfood");

		model.addAttribute("yhDate", yhDate);
		// model.addAttribute("ypname", ypname);
		model.addAttribute("orderNumber", orderNumber);
		model.addAttribute("modityDate", modityDate);
		model.addAttribute("department", department);
		model.addAttribute("useFlag", useFlag);
		model.addAttribute("isfood", isfood);

		// List<PurchaseOrder> reslist=new ArrayList<PurchaseOrder>();
		List<PurchaseOrderVO> reslist = null;
		if (page == null) {
			// 如果page等于空，默认从第一条开始查询
			// reslist= purchaseNoteMng.getPage(re,0,Constants.pagesize);
			reslist = purchaseNoteMng.findPurchseOrderVOByStatus(yhDate, orderNumber, modityDate, department, isfood,
					useFlag, "2", 0, Constants.pagesize);
		} else {
			// 否者翻页查询
			// reslist= purchaseNoteMng.getPage(re,(Integer.parseInt(page) - 1)
			// * Constants.pagesize,Constants.pagesize);
			reslist = purchaseNoteMng.findPurchseOrderVOByStatus(yhDate, orderNumber, modityDate, department, isfood,
					useFlag, "2", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// int resultSize = purchaseNoteMng.getTotalCount(re);
		// int resultSize =
		// purchaseNoteMng.countPurchaseOrderVOByCondition(yhDate, ypname);
		int resultSize = purchaseNoteMng.countPurchaseOrderVOByStatus(yhDate, orderNumber, modityDate, department,
				isfood, useFlag, "2");
		double size = resultSize;
		// 页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		// model.addAttribute("re", re);
		model.addAttribute("reslist", reslist);
		return "drugState/purchaseNote/yshlist";
	}

	@RequestMapping("/drugState/purchaseNote/viewPurchaseOrder.html")
	public String viewPurchaseOrder(Model model, HttpServletRequest request, HttpServletResponse response) {
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		PurchaseOrder order = purchaseNoteMng.findById(id);
		List<PurchaseOrderItemVO> itemList = purchaseNoteMng.findPurchaseOrderItemVOByOrderId(order.getId());
		model.addAttribute("order", order);
		model.addAttribute("itemList", itemList);
		model.addAttribute("orderQuant", itemList.size());
		// //找到此批号的计划数量
		//
		// Integer year= 0;
		// Calendar nows = Calendar.getInstance();
		// year=nows.get(Calendar.YEAR);
		// String departmentId = order.getDepartmentId();
		//
		// List<PurchaseOrderItem> receItem=
		// purchaseNoteMng.findYp(order.getId());
		// PurchaseOrderItem rece = receItem.get(0);
		// PurchasePlanStore
		// pl=procurementProgramMng.findps(departmentId,null,year.toString(),rece.getQualifiedMedicineId());

		if (type != null && !"".equals(type) && type.equals("dsh")) {
			return "drugState/purchaseNote/viewDsh";
		} else if (type != null && !"".equals(type) && type.equals("ysh")) {
			return "drugState/purchaseNote/viewYsh";
		}
		return null;
	}

	/**
	 * 审核采购订单信息
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/drugState/purchaseNote/auditPurchaseOrder.html")
	public String waitToAuditPruchaseOrder(Model model, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		String useFlag = request.getParameter("useFlag");
		String reason = request.getParameter("reason");
		String p_id = request.getParameter("id");
		String id = "0";
		String type = request.getParameter("type");
		if (p_id != null && !"".equals(p_id)) {
			id = p_id;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER);
		PurchaseOrder purchaseOrder = purchaseNoteMng.findById(id);
		if (type != null && !type.equals("") && type.equals("0")) {
			if (purchaseOrder == null) {
				map.put("success", URLEncoder.encode("您审核的信息不存在！", "utf-8"));
				UtilJson.printMapJson(response, map);
				return null;
			} else {
				String currentDate = DateTimeUtils.getNowStrDate();
				StringBuffer buffer = new StringBuffer();
				QualifiedSuppliers supplier = purchaseOrder.getQualifiedSupplierId();
				SalesStaff salesStaff = service.get(Long.valueOf(5));
				String yyzz = supplier.getBusiLiceExpiDate();// 营业执照到期时间
				// String yyzznj = supplier.getBusiLIceAnnuSurvey();//营业执照年检到期时间
				String jyxkz = supplier.getLiceExpiDate();// 经营/生产许可证到时间
				String gsp = supplier.getGspExpirDate();// GSP/GMP证书截止日期
				String zzjgdm = supplier.getOrganizationCodeDate();// 组织机构代码到期时间
				String zzjgdmnj = supplier.getOrganizationCodeInspectionDate();// 组织机构代码年检到期时间
				String zlbzxy = supplier.getQualityAssuranceDate();// 质量保证协议书
				String wtsqs = supplier.getAuthorizationDate();// 委托协议书
				String gspWarningDate = gspWarningDate(supplier.getAccessories());// 其它证书
				String xiaoshourenfaren = salesStaff.getPowerOfAttorneyDate();// 销售人员法人委托书
				String xiaoshourenshenfenzheng = salesStaff.getIdentityCardDate();// 销售人员法人委托书
				String xiaoshourentuixiao = salesStaff.getTrainingCertificateDate();// 销售人员药品推销员证书
				List<PurchaseOrderItem> orderItemList = purchaseNoteMng.findYp(purchaseOrder.getId());
				if (yyzz != null && !"".equals(yyzz)) {
					int day = DateTimeUtils.compareTwoDate(currentDate, yyzz);
					if (day > 0) {
						buffer.append("供货厂家的营业执照过期\n");
					}
				}
				/*
				 * if(yyzznj != null && !"".equals(yyzznj)){ int day =
				 * DateTimeUtils.compareTwoDate(currentDate, yyzznj); if(day>0){
				 * buffer.append("供货厂家的营业执照年检过期\n"); } }
				 */
				if (jyxkz != null && !"".equals(jyxkz)) {
					int day = DateTimeUtils.compareTwoDate(currentDate, jyxkz);
					if (day > 0) {
						buffer.append("供货厂家的经营/生产许可证过期\n");
					}
				}
				if (gsp != null && !"".equals(gsp)) {
					int day = DateTimeUtils.compareTwoDate(currentDate, gsp);
					if (day > 0) {
						buffer.append("供货厂家的GSP/GMP证书过期\n");
					}
				}
				if (zzjgdm != null && !"".equals(zzjgdm)) {
					int day = DateTimeUtils.compareTwoDate(currentDate, zzjgdm);
					if (day > 0) {
						buffer.append("供货厂家的组织机构代码过期\n");
					}
				}
				if (zzjgdmnj != null && !"".equals(zzjgdmnj)) {
					int day = DateTimeUtils.compareTwoDate(currentDate, zzjgdmnj);
					if (day > 0) {
						buffer.append("供货厂家的组织机构代码年检过期\n");
					}
				}
				if (zlbzxy != null && !"".equals(zlbzxy)) {
					int day = DateTimeUtils.compareTwoDate(currentDate, zlbzxy);
					if (day > 0) {
						buffer.append("供货厂家的质量保证协议过期\n");
					}
				}
				if (wtsqs != null && !"".equals(wtsqs)) {
					int day = DateTimeUtils.compareTwoDate(currentDate, wtsqs);
					if (day > 0) {
						buffer.append("供货厂家的法人授权委托书过期\n");
					}
				}
				if (gspWarningDate != null && !"".equals(gspWarningDate)) {
					int day = DateTimeUtils.compareTwoDate(currentDate, gspWarningDate);
					if (day > 0) {
						buffer.append("供货厂家的其它证件过期\n");
					}
				}
				if (xiaoshourenfaren != null && !"".equals(xiaoshourenfaren)) {
					int day = DateTimeUtils.compareTwoDate(currentDate, xiaoshourenfaren);
					if (day > 0) {
						buffer.append("供货厂家的销售人员法人委托书到过期\n");
					}
				}
				if (xiaoshourenshenfenzheng != null && !"".equals(xiaoshourenshenfenzheng)) {
					int day = DateTimeUtils.compareTwoDate(currentDate, xiaoshourenshenfenzheng);
					if (day > 0) {
						buffer.append("供货厂家的销售人员身份证过期\n");
					}
				}
				if (xiaoshourentuixiao != null && !"".equals(xiaoshourentuixiao)) {
					int day = DateTimeUtils.compareTwoDate(currentDate, xiaoshourentuixiao);
					if (day > 0) {
						buffer.append("供货厂家的销售人员药品推销员证书过期\n");
					}
				}
				
				for (PurchaseOrderItem item : orderItemList) {
					QualityMidicine midicine = qualityMidicineMng.get(item.getQualifiedMedicineId());
					String ypzczh = midicine.getMedcRegistrApprovalDate();

					

					if (ypzczh != null && !"".equals(ypzczh)) {
						int day = DateTimeUtils.compareTwoDate(currentDate, ypzczh);
						if (day > 0) {
							buffer.append("批号为：" + item.getBatchProduction() + midicine.getCommonname() + "的药品注册证过期\n");
						}
					}
					if (midicine.getUseflag() != 0) {
						buffer.append("批号为：" + item.getBatchProduction() + midicine.getCommonname() + "的药品已经停用\n");
					}


				if (!buffer.toString().isEmpty()) {
					map.put("success", URLEncoder.encode(buffer.toString(), "utf-8"));
					UtilJson.printMapJson(response, map);
					return null;
				} else {
					item.setFlag(1L);
					item.setUploadFlag(1);
					String quantity = request.getParameter("quantity");
					String validDate = request.getParameter("validDate");
					String money = request.getParameter("money");
					String taxPrice = request.getParameter("taxPrice");
					String tkdat = request.getParameter("tkdat");// 生产日期
					if (quantity != null && !"".equals(quantity)) {
						item.setQuantity(Long.parseLong(quantity));
					}
					if (validDate != null && !"".equals(validDate)) {
						item.setEndTime(validDate);
					}
					if (money != null && !"".equals(money)) {
						item.setMoney(money);
					}
					if (taxPrice != null && !"".equals(taxPrice)) {
						item.setTaxPrice(taxPrice);
					}
					if (tkdat != null && !"".equals(tkdat)) {
						item.setTkdat(tkdat);
					}
					purchaseNoteItemMng.saveOrUpdateItem(item);
					purchaseOrder.setStatus("2");
					purchaseOrder.setModifier(user.getId());
					purchaseOrder.setUser(user);
					purchaseNoteMng.saveReceivingNote(purchaseOrder);
					logService.addLog("确认采购记录", user.getRealname(), "确认", "药品状态管理  >采购管理",
							StringUtil.getIpAddr(request));
					map.put("success", URLEncoder.encode("确认成功！", "utf-8"));
					UtilJson.printMapJson(response, map);
					return null;
				}
				}
			}

		}
		// 保存
		if (type != null && !type.equals("") && type.equals("1")) {
			List<PurchaseOrderItem> orderItemList = null;
			PurchaseOrderItem purchaseOrderItem = null;
			if (purchaseOrder.getId() != null && !"".equals(purchaseOrder.getId())) {
				orderItemList = purchaseNoteMng.findYp(purchaseOrder.getId());
			}
			if (orderItemList != null && orderItemList.size() > 0) {
				purchaseOrderItem = orderItemList.get(0);
			}
			// 作废
			if (useFlag != null && !"".equals(useFlag) && useFlag.equals("1")) {
				purchaseOrder.setUseFlag("1");
				purchaseOrder.setReason(reason);
			}
			String quantity = request.getParameter("quantity");
			String validDate = request.getParameter("validDate");
			String money = request.getParameter("money");
			String taxPrice = request.getParameter("taxPrice");
			String tkdat = request.getParameter("tkdat");// 生产日期
			if (quantity != null && !"".equals(quantity)) {
				purchaseOrderItem.setQuantity(Long.parseLong(quantity));
			}
			if (validDate != null && !"".equals(validDate)) {
				purchaseOrderItem.setEndTime(validDate);
			}
			if (money != null && !"".equals(money)) {
				purchaseOrderItem.setMoney(money);
			}
			if (taxPrice != null && !"".equals(taxPrice)) {
				purchaseOrderItem.setTaxPrice(taxPrice);
			}
			if (tkdat != null && !"".equals(tkdat)) {
				purchaseOrderItem.setTkdat(tkdat);
			}
			purchaseNoteItemMng.saveOrUpdateItem(purchaseOrderItem);
			purchaseNoteMng.saveOrUpdateNote(purchaseOrder);
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("success", "2");
			UtilJson.printMapJson(response, map1);
			return null;
		}

		return null;
	}

	/**
	 * 批量审核采购订单
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/drugState/purchaseNote/batchAuditPurchaseOrder.html")
	public String batchAuditPruchaseOrder(Model model, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		String[] ids = request.getParameterValues("ids");
		User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER);
		StringBuffer strBuffer = new StringBuffer();
		Map<String, Object> map = new HashMap<String, Object>();
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				PurchaseOrder purchaseOrder = purchaseNoteMng.findById(id);
				if (purchaseOrder != null) {
					String currentDate = DateTimeUtils.getNowStrDate();
					StringBuffer buffer = new StringBuffer();
					QualifiedSuppliers supplier = purchaseOrder.getQualifiedSupplierId();
					String yyzz = supplier.getBusiLiceExpiDate();// 营业执照到期时间
					// String yyzznj =
					// supplier.getBusiLIceAnnuSurvey();//营业执照年检到期时间
					String jyxkz = supplier.getLiceExpiDate();// 经营/生产许可证到时间
					String gsp = supplier.getGspExpirDate();// GSP/GMP证书截止日期
					String zzjgdm = supplier.getOrganizationCodeDate();// 组织机构代码到期时间
					String zzjgdmnj = supplier.getOrganizationCodeInspectionDate();// 组织机构代码年检到期时间
					String zlbzxy = supplier.getQualityAssuranceDate();// 质量保证协议书
					String wtsqs = supplier.getAuthorizationDate();// 委托协议书
					String gspWarningDate = gspWarningDate(supplier.getAccessories());// 其它证书
					List<PurchaseOrderItem> orderItemList = purchaseNoteMng.findYp(purchaseOrder.getId());
					if (yyzz != null && !"".equals(yyzz)) {
						int day = DateTimeUtils.compareTwoDate(currentDate, yyzz);
						if (day > 0) {
							buffer.append("订单号为：" + purchaseOrder.getNumber() + "供货厂家的营业执照过期\n");
						}
					}
					/*
					 * if(yyzznj != null && !"".equals(yyzznj)){ int day =
					 * DateTimeUtils.compareTwoDate(currentDate, yyzznj);
					 * if(day>0){
					 * buffer.append("订单号为："+purchaseOrder.getNumber()+
					 * "供货厂家的营业执照年检过期\n"); } }
					 */
					if (jyxkz != null && !"".equals(jyxkz)) {
						int day = DateTimeUtils.compareTwoDate(currentDate, jyxkz);
						if (day > 0) {
							buffer.append("订单号为：" + purchaseOrder.getNumber() + "供货厂家的经营/生产许可证过期\n");
						}
					}
					if (gsp != null && !"".equals(gsp)) {
						int day = DateTimeUtils.compareTwoDate(currentDate, gsp);
						if (day > 0) {
							buffer.append("订单号为：" + purchaseOrder.getNumber() + "供货厂家的GSP/GMP证书过期\n");
						}
					}
					if (zzjgdm != null && !"".equals(zzjgdm)) {
						int day = DateTimeUtils.compareTwoDate(currentDate, zzjgdm);
						if (day > 0) {
							buffer.append("订单号为：" + purchaseOrder.getNumber() + "供货厂家的组织机构代码过期\n");
						}
					}
					if (zzjgdmnj != null && !"".equals(zzjgdmnj)) {
						int day = DateTimeUtils.compareTwoDate(currentDate, zzjgdmnj);
						if (day > 0) {
							buffer.append("订单号为：" + purchaseOrder.getNumber() + "供货厂家的组织机构代码年检过期\n");
						}
					}
					if (zlbzxy != null && !"".equals(zlbzxy)) {
						int day = DateTimeUtils.compareTwoDate(currentDate, zlbzxy);
						if (day > 0) {
							buffer.append("订单号为：" + purchaseOrder.getNumber() + "供货厂家的质量保证协议过期\n");
						}
					}
					if (wtsqs != null && !"".equals(wtsqs)) {
						int day = DateTimeUtils.compareTwoDate(currentDate, wtsqs);
						if (day > 0) {
							buffer.append("订单号为：" + purchaseOrder.getNumber() + "供货厂家的授权委托书过期\n");
						}
					}
					if (gspWarningDate != null && !"".equals(gspWarningDate)) {
						int day = DateTimeUtils.compareTwoDate(currentDate, gspWarningDate);
						if (day > 0) {
							buffer.append("订单号为：" + purchaseOrder.getNumber() + "供货厂家的其它证件过期\n");
						}
					}
					for (PurchaseOrderItem item : orderItemList) {
						QualityMidicine midicine = qualityMidicineMng.get(item.getQualifiedMedicineId());
						String ypzczh = midicine.getMedcRegistrApprovalDate();

						item.setFlag(1L);

						purchaseNoteItemMng.saveOrUpdateItem(item);
						if (ypzczh != null && !"".equals(ypzczh)) {
							int day = DateTimeUtils.compareTwoDate(currentDate, ypzczh);
							if (day > 0) {
								buffer.append("订单号为：" + purchaseOrder.getNumber() + "批号为：" + item.getBatchProduction()
										+ "的" + midicine.getCommonname() + "的药品注册证过期\n ");
							}
						}
						if (midicine.getUseflag() != 0) {
							buffer.append("批号为：" + item.getBatchProduction() + midicine.getCommonname() + "的药品已经停用\n");
						}
					}
					strBuffer.append(buffer);
					if (buffer.toString().isEmpty()) {
						purchaseOrder.setStatus("2");
						purchaseOrder.setModifier(user.getId());
						purchaseOrder.setUser(user);
						purchaseNoteMng.saveReceivingNote(purchaseOrder);
					}
				} else {
					continue;
				}
			}
		}
		if (!strBuffer.toString().isEmpty()) {
			map.put("success", URLEncoder.encode(strBuffer.toString(), "utf-8"));
			UtilJson.printMapJson(response, map);
			return null;
		} else {
			logService.addLog("确认采购记录", user.getRealname(), "确认", "药品状态管理  >采购管理", StringUtil.getIpAddr(request));
			map.put("success", URLEncoder.encode("批量确认成功！", "utf-8"));
			UtilJson.printMapJson(response, map);
			return null;
		}
		// return null;
	}

	@RequestMapping("/drugState/purchaseNote/confrimRejectPurchaseOrder.html")
	public String confrimRejectPurchaseOrder(Model model, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		String useFlag = request.getParameter("useFlag");
		String reason = request.getParameter("reason");
		String id = request.getParameter("id");
		// String useFlag = request.getParameter("useFlag");
		PurchaseOrder purchaseOrder = purchaseNoteMng.findById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		// boolean flag =
		// purchaseNoteMng.isAlreadyReceiving(purchaseOrder.getId());
		// 回退
		if (useFlag != null && !"".equals(useFlag) && useFlag.equals("0")) {
			if (purchaseOrder != null) {
				// if(!flag){
				purchaseOrder.setStatus("0");
				purchaseOrder.setRejectFlag("1");
				purchaseOrder.setUseFlag("0");
				// }else{
				// purchaseOrder.setUseFlag(useFlag);
				// }
				purchaseNoteMng.saveReceivingNote(purchaseOrder);
				User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER);
				logService.addLog("驳回采购记录", user.getRealname(), "驳回", "药品状态管理  >采购管理", StringUtil.getIpAddr(request));
				map.put("success", URLEncoder.encode("驳回成功！", "utf-8"));
				UtilJson.printMapJson(response, map);
				return null;
			} else {
				map.put("success", URLEncoder.encode("没有找到相关信息！", "utf-8"));
				UtilJson.printMapJson(response, map);
				return null;

			}
		}
		// 作废
		if (useFlag != null && !"".equals(useFlag) && useFlag.equals("1")) {
			purchaseOrder.setUseFlag("1");
			purchaseOrder.setReason(reason);
			purchaseNoteMng.saveReceivingNote(purchaseOrder);
			map.put("success", URLEncoder.encode("作废成功！", "utf-8"));
			UtilJson.printMapJson(response, map);
			return null;
		} else {
			map.put("success", URLEncoder.encode("作废失败！", "utf-8"));
			UtilJson.printMapJson(response, map);
			return null;

		}

	}
	
	
	
	
	/**
	 * 添加采购订单
	 * 
	 * @param re
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/drugState/purchaseNote/add.html")
	public ModelAndView add(PurchaseOrder re, String id, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Integer year = 0;
		Integer season = 0;
		PurchaseOrder receivingNote = new PurchaseOrder();
		Calendar nows = Calendar.getInstance();
		year = nows.get(Calendar.YEAR);
		int month = nows.get(Calendar.MONTH) + 1;
		if (month == 1 || month == 2 || month == 3) {
			season = 1;
			receivingNote.setSeason("本年度第一季度");
		} else if (month == 4 || month == 5 || month == 6) {
			season = 2;
			receivingNote.setSeason("本年度第二季度");
		} else if (month == 7 || month == 8 || month == 9) {
			season = 3;
			receivingNote.setSeason("本年度第三季度");
		} else if (month == 10 || month == 11 || month == 12) {
			season = 4;
			receivingNote.setSeason("本年度第四季度");
		}
		String method = request.getParameter("method");
		String thispage = request.getParameter("thispage");
		String depertmentId = request.getParameter("operatingCompany");// 经营公司ID
		model.addAttribute("thispage", thispage);
		String nonumber = makeNoMng.findNo(Constants.PURCHASENOTEACT);
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String number = format.format(now);
		if (nonumber != null && !"".equals(nonumber) && number.equals(nonumber.substring(0, 8))) {
			try {
				Long n = Long.parseLong(nonumber) + 1L;
				receivingNote.setNumber(n.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			nonumber = number + "0001";
			receivingNote.setNumber(nonumber);
		}
		String titles = "添加";
		if (!method.equals("add")) {
			titles = "修改";
			receivingNote = purchaseNoteMng.findById(id);
			String departmentId = receivingNote.getDepartmentId();
			model.addAttribute("department", receivingNote.getDepartmentId());
			List<PurchaseOrderItem> receItem = purchaseNoteMng.findYp(receivingNote.getId());
			List<QualifiedEdit> qus = new ArrayList<QualifiedEdit>();
			for (int j = 0; j < receItem.size(); j++) {
				QualifiedEdit qu = new QualifiedEdit();
				PurchaseOrderItem rece = receItem.get(j);
				qu.setPurchaseOrderId(receivingNote.getId());
				qu.setPurchaseOrderItemId(rece.getId());
				PurchasePlanStore pl = procurementProgramMng.findps(departmentId, null, year.toString(),
						rece.getQualifiedMedicineId());// 修改暂时不确定
				if (pl != null) {
					if (pl.getQuantity() != null) {
						qu.setZuidashuliang(pl.getQuantity().toString());
					} else {
						qu.setZuidashuliang("0");
					}
				} else {
					qu.setZuidashuliang("0");
				}
				// QualityMidicine qualifiedMedicine =
				// inspectionMng.findHGYP(receItem.get(j).getQualifiedMedicineId());
				QualityMidicine qualifiedMedicine = qualityMidicineMng.get(receItem.get(j).getQualifiedMedicineId());
				if (rece.getBatchProduction() != null && !"".equals(rece.getBatchProduction().toString())) {
					qu.setShengchanpihao(rece.getBatchProduction());
				} else {
					qu.setShengchanpihao("");
				}

				if (rece.getMoney() != null) {
					qu.setJine(rece.getMoney());
				}
				if (rece.getRate() != null) {
					qu.setKoulv(rece.getRate());
				}
				if (rece.getTaxPrice() != null) {
					qu.setHanshuidanjia(rece.getTaxPrice());
				}
				if (rece.getQuantity() != null && !"".equals(rece.getQuantity().toString())) {
					qu.setShuliang(rece.getQuantity().toString());
				} else {
					qu.setShuliang("");
				}
				if (rece.getQualifiedMedicineId() != null) {
					qu.setYaopinming(rece.getQualifiedMedicineId().toString());
				} else {
					qu.setYaopinming("");
				}
				if (qualifiedMedicine.getDosageforms() != null) {
					if (qualifiedMedicine.getDosageforms().getFormName() != null) {
						qu.setJixing(qualifiedMedicine.getDosageforms().getFormName());
					} else {
						qu.setJixing("");
					}
				} else {
					qu.setJixing("");
				}
				if (rece.getSpecifications() != null) {
					qu.setGuige(rece.getSpecifications());
				} else {
					qu.setGuige("");
				}
				if (qualifiedMedicine.getProduceno() != null) {
					if (qualifiedMedicine.getProduceno().getCustomerName() != null) {
						qu.setShengchangqiye(qualifiedMedicine.getProduceno().getCustomerName());
					} else {
						qu.setShengchangqiye("");
					}
				} else {
					qu.setShengchangqiye("");
				}
				if (rece.getEndTime() != null) {
					qu.setYouxiaoqizhi(rece.getEndTime());
				} else {
					qu.setYouxiaoqizhi("");
				}

				if (rece.getTkdat() != null) {
					qu.setShengchanriqi(rece.getTkdat());
				} else {
					qu.setShengchanriqi("");
				}

				qu.setHegezheng("");
				if (qualifiedMedicine.getLicensenumber() != null) {
					qu.setPizhunwenhao(qualifiedMedicine.getLicensenumber());
				}
				if (qualifiedMedicine != null && qualifiedMedicine.getUnit() != null) {
					qu.setDanwei(qualifiedMedicine.getUnit());
				} else {
					qu.setDanwei("");
				}
				qus.add(qu);
			}
			List<String> jsonStringList = new ArrayList<String>();
			for (int i = 0; i < receItem.size(); i++) {
				QualifiedEdit borg = qus.get(i);
				jsonStringList.add(new JSONObject(borg).toString());
			}
			JSONArray jsonArray = new JSONArray(jsonStringList);
			String jsonString = jsonArray.toString();
			model.addAttribute("receItem", jsonString);
		}
		if (receivingNote.getQualifiedSupplierId() != null) {
			model.addAttribute("gongyingshang", receivingNote.getQualifiedSupplierId().getPinyinCode() + "_"
					+ receivingNote.getQualifiedSupplierId().getId());
		} else {
			model.addAttribute("gongyingshang", "");
		}
		model.addAttribute("titles", titles);
		Map<String, String> quamap = inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> qsmap = inspectionMng.gonghuoMap();
		model.addAttribute("qsmap", qsmap);
		model.addAttribute("re", receivingNote);
		model.addAttribute("method", method);
		return new ModelAndView("drugState/purchaseNote/add");
	}

	@RequestMapping("/drugState/purchaseNote/saveOrUpdata.html")
	public ModelAndView saveOrUpdate(PurchaseOrder re, String counts, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("method");
		String ops = request.getParameter("thispage");
		String modify_reason = request.getParameter("modify_reason");
		String qualifiedSupplierIdValue = request.getParameter("qualifiedSupplierIdValue");
		String reason = request.getParameter("reason");
		QualifiedSuppliers sy = purchaseNoteMng.findByIdSy(qualifiedSupplierIdValue);
		String type = request.getParameter("type");// 0表示保存、1表示提交
		re.setQualifiedSupplierId(sy);
		Date date = new Date();
		Map<String, Object> map = new HashMap<String, Object>();
		// SimpleDateFormat format = new SimpleDateFormat("yyyymmdd");
		// String number = format.format(date);
		// re.setNumber(number);
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String modifyDate = modifyDateFormat.format(date);
		re.setModifyDate(modifyDate);
		User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER);
		re.setModifier(user.getId());
		re.setUser(user);
		if ("add".equals(op)) {
			String nonumber = makeNoMng.mackNo(Constants.PURCHASENOTEACT);
			if (!re.getNumber().equals(nonumber)) {
				map.put("success", "1");
				map.put("number", nonumber);
				re.setNumber(nonumber);
			} else {
				map.put("success", "2");
			}
		}

		if (type.equals("0")) {// 判断提交类型 修改采购订单状态
			re.setStatus("0");
		} else {
			re.setStatus("1");
		}

		PurchaseOrder purchaseOrder = null;
		List<PurchaseOrderItem> orderItemList = null;
		if (re.getId() != null && !"".equals(re.getId())) {
			purchaseOrder = purchaseNoteMng.findById(re.getId().toString());
			orderItemList = purchaseNoteMng.findYp(purchaseOrder.getId());
		}

		Map<Long, PurchaseOrderItem> itemMap = new HashMap<Long, PurchaseOrderItem>();
		if (orderItemList != null && orderItemList.size() > 0) {
			for (PurchaseOrderItem item : orderItemList) {
				itemMap.put(item.getId(), item);
			}
		}

		List<PurchaseOrderItem> itemList = new ArrayList<PurchaseOrderItem>();
		if (counts != null && !"".equals(counts)) {

			for (int i = 0; i < Integer.parseInt(counts); i++) {
				PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();

				purchaseOrderItem.setFlag(0L);// 默认为0
				String pingming = request.getParameter("pinming" + i);
				String shuliang = request.getParameter("shuliang" + i);
				String guige = request.getParameter("guige" + i);
				String pizhun = request.getParameter("pizhun" + i);
				String youxiaoqi = request.getParameter("youxiaoqi" + i);
				String shengchanpihao = request.getParameter("shengchanpihao" + i);
				String money = request.getParameter("money" + i);
				String taxPrice = request.getParameter("taxPrice" + i);
				String rate = request.getParameter("rate" + i);
				String purchaseOrderItemId = request.getParameter("purchaseOrderItemId" + i);
				String tkdat = request.getParameter("tkdat" + i);// 生产日期

				if (purchaseOrderItemId != null && !"".equals(purchaseOrderItemId)) {
					purchaseOrderItem.setId(Long.valueOf(purchaseOrderItemId));
				}
				if (money != null && !"".equals(money)) {
					purchaseOrderItem.setMoney(money);
				}
				if (taxPrice != null && !"".equals(taxPrice)) {
					purchaseOrderItem.setTaxPrice(taxPrice);
				}
				if (rate != null && !"".equals(rate)) {
					purchaseOrderItem.setRate(rate);
				}
				if (pingming != null && !"".equals(pingming)) {
					purchaseOrderItem.setQualifiedMedicineId(Long.parseLong(pingming.trim()));
				} else {
					continue;
				}
				if (shuliang != null && !"".equals(shuliang)) {
					try {
						purchaseOrderItem.setQuantity(Long.parseLong(shuliang));
					} catch (Exception e) {
						purchaseOrderItem.setQuantity(0L);
						e.printStackTrace();
					}
				} else {
					continue;
				}
				QualityMidicine qualifiedMedicine = new QualityMidicine();
				if (!"".equals(pingming.trim())) {
					qualifiedMedicine = inspectionMng.findHGYP(Long.parseLong(pingming.trim()));
				} else {
					continue;
				}
				purchaseOrderItem.setEndTime(youxiaoqi);
				purchaseOrderItem.setTkdat(tkdat);

				purchaseOrderItem.setSpecifications(guige);
				purchaseOrderItem.setLicenseNumber(pizhun);
				if (qualifiedMedicine != null) {
					if (qualifiedMedicine.getProduceno() != null) {
						purchaseOrderItem.setProduceNo(qualifiedMedicine.getProduceno().getId());
					} else {
						purchaseOrderItem.setProduceNo(null);
					}
					if (qualifiedMedicine.getDosageforms() != null) {
						purchaseOrderItem.setDosageForms(qualifiedMedicine.getDosageforms().getId());
					} else {
						purchaseOrderItem.setDosageForms(null);
					}
				} else {
					purchaseOrderItem.setProduceNo(null);
					purchaseOrderItem.setDosageForms(null);
				}
				purchaseOrderItem.setBatchProduction(shengchanpihao);
				itemList.add(purchaseOrderItem);
			}
		}
		if (purchaseOrder != null && purchaseOrder.getRejectFlag() != null
				&& purchaseOrder.getRejectFlag().equals("1")) {
			if (!purchaseOrder.getUseFlag().equals(re.getUseFlag())) {
				String oldCompany = purchaseOrder.getDepartmentId().equals("1001") ? "经营"
						: purchaseOrder.getDepartmentId().equals("2001") ? "新品" : "市场";
				String newCompany = re.getDepartmentId().equals("1001") ? "经营"
						: re.getDepartmentId().equals("2001") ? "新品" : "市场";
				purchaseOrderRecordsManager.addPurchaseOrderRecords(purchaseOrder.getId(), "修改采购订单经营公司",
						"修改采购订单修改之前经营公司为" + oldCompany + " 修改之后采购订单经营公司为" + newCompany, user, modify_reason);
			}
			if (!purchaseOrder.getDepartmentId().equals(re.getDepartmentId())) {
				String oldStatus = (purchaseOrder.getUseFlag().equals("0")) ? "合格" : "作废";
				String newStatus = (re.getUseFlag().equals("0")) ? "合格" : "作废";
				purchaseOrderRecordsManager.addPurchaseOrderRecords(purchaseOrder.getId(), "修改采购订单",
						"采购订单状态修改之前为" + oldStatus + "采购订单状态修改之后为" + newStatus, user, modify_reason);
			}
			for (PurchaseOrderItem item : itemList) {
				QualityMidicine qm = inspectionMng.findHGYP(item.getQualifiedMedicineId());
				if (item.getId() == null || "".equals(item.getId())) {
					purchaseOrderRecordsManager.addPurchaseOrderRecords(purchaseOrder.getId(), "新增药品",
							"新增药品编号为" + ((qm != null) ? qm.getMedicinalNo() : "") + "的"
									+ ((qm != null) ? qm.getCommonname() : ""),
							user, modify_reason);
				} else {
					PurchaseOrderItem pi = itemMap.get(item.getId());
					if (pi == null) {
						purchaseOrderRecordsManager.addPurchaseOrderRecords(purchaseOrder.getId(), "新增药品",
								"新增药品编号为" + ((qm != null) ? qm.getMedicinalNo() : "") + "的"
										+ ((qm != null) ? qm.getCommonname() : ""),
								user, modify_reason);
					} else {
						if (!pi.getQualifiedMedicineId().equals(item.getQualifiedMedicineId())) {
							QualityMidicine newQm = inspectionMng.findHGYP(pi.getQualifiedMedicineId());
							purchaseOrderRecordsManager
									.addPurchaseOrderRecords(purchaseOrder.getId(), "修改药品名称",
											"修改药品名称修改之前药品名称为" + ((qm != null) ? qm.getCommonname() : "") + "修改之后药品名称为"
													+ ((newQm != null) ? newQm.getCommonname() : ""),
											user, modify_reason);
						}
						/*
						 * if(!pi.getBatchProduction().equals(item.
						 * getBatchProduction())){
						 * purchaseOrderRecordsManager.addPurchaseOrderRecords(
						 * purchaseOrder.getId(),
						 * "修改"+((qm!=null)?qm.getCommonname():"")+"药品批号",
						 * "修改之前药品批号为"+pi.getBatchProduction()+"修改之后药品数量为"+item.
						 * getBatchProduction(), user, modify_reason); }
						 */
						if (!pi.getQuantity().equals(item.getQuantity())) {
							purchaseOrderRecordsManager.addPurchaseOrderRecords(purchaseOrder.getId(),
									"修改" + ((qm != null) ? qm.getCommonname() : "") + "药品数量",
									"修改之前药品数量为" + pi.getQuantity() + "修改之后药品数量为" + item.getQuantity(), user,
									modify_reason);
						}
						if (!pi.getTaxPrice().equals(item.getTaxPrice())) {
							purchaseOrderRecordsManager.addPurchaseOrderRecords(purchaseOrder.getId(),
									"修改" + ((qm != null) ? qm.getCommonname() : "") + "药品含税单价",
									"修改之前药品含税单价为" + pi.getTaxPrice() + "修改之后药品含税单价为" + item.getTaxPrice(), user,
									modify_reason);
						}
						if (!pi.getRate().equals(item.getRate())) {
							purchaseOrderRecordsManager.addPurchaseOrderRecords(purchaseOrder.getId(),
									"修改" + ((qm != null) ? qm.getCommonname() : "") + "药品扣率",
									"修改之前药品扣率为" + pi.getRate() + "修改之后药品扣率为" + item.getRate(), user, modify_reason);
						}
						if (!pi.getMoney().equals(item.getMoney())) {
							purchaseOrderRecordsManager.addPurchaseOrderRecords(purchaseOrder.getId(),
									"修改" + ((qm != null) ? qm.getCommonname() : "") + "药品总金额",
									"修改之前药品总金额为" + pi.getMoney() + "修改之后药总金额为" + item.getMoney(), user, modify_reason);
						}
						/*
						 * if(!pi.getTkdat().equals(item.getTkdat())){
						 * purchaseOrderRecordsManager.addPurchaseOrderRecords(
						 * purchaseOrder.getId(),
						 * "修改"+((qm!=null)?qm.getCommonname():"")+"药品生产日期",
						 * "修改之前生产日期为"+pi.getTkdat()+"修改之后生产日期为"+item.getTkdat()
						 * , user, modify_reason); }
						 */
						/*
						 * if(!pi.getEndTime().equals(item.getEndTime())){
						 * purchaseOrderRecordsManager.addPurchaseOrderRecords(
						 * purchaseOrder.getId(),
						 * "修改"+((qm!=null)?qm.getCommonname():"")+"药品有效期至",
						 * "修改之前药品有效期至为"+pi.getEndTime()+"修改之后药有效期至为"+item.
						 * getEndTime(), user, modify_reason); }
						 */
						itemMap.remove(item.getId());
					}
				}
			}
			if (!itemMap.isEmpty()) {
				Iterator<Long> it = itemMap.keySet().iterator();
				while (it.hasNext()) {
					Long key = it.next();
					PurchaseOrderItem item = itemMap.get(key);
					QualityMidicine qm = inspectionMng.findHGYP(item.getQualifiedMedicineId());
					purchaseOrderRecordsManager.addPurchaseOrderRecords(purchaseOrder.getId(), "删除药品",
							"删除药品编号为" + ((qm != null) ? qm.getMedicinalNo() : "") + "的"
									+ ((qm != null) ? qm.getCommonname() : ""),
							user, modify_reason);
				}
			}
		}
		/*
		 * if(orderItemList != null && orderItemList.size()>0 && itemList !=
		 * null && itemList.size()>0){ if(orderItemList.size() >
		 * itemList.size()){ ArrayList<Integer> array = new
		 * ArrayList<Integer>(); for(PurchaseOrderItem item : itemList){
		 * QualityMidicine qm =
		 * inspectionMng.findHGYP(item.getQualifiedMedicineId());
		 * if(item.getId()== null || item.getId().equals("")){
		 * purchaseOrderRecordsManager.addPurchaseOrderRecords(purchaseOrder.
		 * getId(), "新增药品",
		 * "新增药品编号为"+((qm!=null)?qm.getMedicinalNo():"")+"的"+((qm!=null)?qm.
		 * getCommonname():""), user, ""); }else
		 * if(orderItemList.indexOf(item)>0){
		 * array.add(orderItemList.indexOf(item)); PurchaseOrderItem p =
		 * orderItemList.get(orderItemList.indexOf(item)) ; QualityMidicine
		 * newQm = inspectionMng.findHGYP(p.getQualifiedMedicineId());
		 * if(p.getQualifiedMedicineId() != item.getQualifiedMedicineId()){
		 * purchaseOrderRecordsManager.addPurchaseOrderRecords(purchaseOrder.
		 * getId(), "修改药品名称",
		 * "修改药品名称修改之前药品名称为"+((qm!=null)?qm.getCommonname():"")+"修改之后药品名称为"+((
		 * newQm!=null)?newQm.getCommonname():""), user, ""); } } } } }
		 */
		PurchaseOrder res = purchaseNoteMng.saveReceivingNote(re);
		List<?> list = purchaseNoteMng.findAllId(res.getId().toString());
		purchaseNoteItemMng.del(list);
		if (counts != null && !"".equals(counts)) {
			for (int i = 0; i < Integer.parseInt(counts); i++) {
				PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
				purchaseOrderItem.setFlag(0L);// 默认为0
				String pingming = request.getParameter("pinming" + i);
				String shuliang = request.getParameter("shuliang" + i);
				String jixing = request.getParameter("jixing" + i);
				String guige = request.getParameter("guige" + i);
				String shengchang = request.getParameter("shengchang" + i);
				String pizhun = request.getParameter("pizhun" + i);
				String shangbiao = request.getParameter("shangbiao" + i);
				String hege = request.getParameter("hege" + i);
				// String youxiaoqi = request.getParameter("youxiaoqi"+i);
				String shengchanpihao = request.getParameter("shengchanpihao" + i);
				String money = request.getParameter("money" + i);
				String taxPrice = request.getParameter("taxPrice" + i);
				String rate = request.getParameter("rate" + i);
				// String tkdat= request.getParameter("tkdat"+i);
				if (money != null && !"".equals(money)) {
					purchaseOrderItem.setMoney(money);
				}
				if (taxPrice != null && !"".equals(taxPrice)) {
					purchaseOrderItem.setTaxPrice(taxPrice);
				}
				if (rate != null && !"".equals(rate)) {
					purchaseOrderItem.setRate(rate);
				}
				if (pingming != null && !"".equals(pingming)) {
					purchaseOrderItem.setQualifiedMedicineId(Long.parseLong(pingming.trim()));
				} else {
					continue;
				}
				if (shuliang != null && !"".equals(shuliang)) {
					try {
						purchaseOrderItem.setQuantity(Long.parseLong(shuliang));
					} catch (Exception e) {
						purchaseOrderItem.setQuantity(0L);
						e.printStackTrace();
					}
				} else {
					continue;
				}
				QualityMidicine qualifiedMedicine = new QualityMidicine();
				if (!"".equals(pingming.trim())) {
					qualifiedMedicine = inspectionMng.findHGYP(Long.parseLong(pingming.trim()));
				} else {
					continue;
				}
				// purchaseOrderItem.setTkdat(tkdat);
				// purchaseOrderItem.setEndTime(youxiaoqi);
				purchaseOrderItem.setPurchaseOrderId(res.getId());
				purchaseOrderItem.setSpecifications(guige);
				purchaseOrderItem.setLicenseNumber(pizhun);
				if (qualifiedMedicine != null) {
					if (qualifiedMedicine.getProduceno() != null) {
						purchaseOrderItem.setProduceNo(qualifiedMedicine.getProduceno().getId());
					} else {
						purchaseOrderItem.setProduceNo(null);
					}
					if (qualifiedMedicine.getDosageforms() != null) {
						purchaseOrderItem.setDosageForms(qualifiedMedicine.getDosageforms().getId());
					} else {
						purchaseOrderItem.setDosageForms(null);
					}
				} else {
					purchaseOrderItem.setProduceNo(null);
					purchaseOrderItem.setDosageForms(null);
				}
				purchaseOrderItem.setBatchProduction(shengchanpihao);
				purchaseNoteItemMng.savePurchaseOrderItem(purchaseOrderItem);
			}
		}
		logService.addLog("新增采购记录", user.getRealname(), "新增", "药品状态管理  >采购管理", StringUtil.getIpAddr(request));
		UtilJson.printMapJson(response, map);
		return null;
	}

	@RequestMapping("/drugState/purchaseNote/del.html")
	public ModelAndView del(String ids[], HttpServletRequest request, HttpServletResponse response, Model model) {
		if (ids != null && !"".equals(ids)) {
			for (int i = 0; i < ids.length; i++) {
				purchaseNoteMng.del(ids[i]);
				List<?> list = purchaseNoteMng.findAllId(ids[i]);
				purchaseNoteItemMng.del(list);
			}
		}
		User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除采购记录", user.getRealname(), "删除", "药品状态管理  >采购管理", StringUtil.getIpAddr(request));
		return openFramePage(null, request, response, model);
	}

	@RequestMapping("/drugState/purchaseNote/findypboxqy.html")
	public void findypbox(HttpServletRequest request, HttpServletResponse response, Model model) {
		int year = 0;
		int season = 0;
		Calendar now = Calendar.getInstance();
		year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		if (month == 1 || month == 2 || month == 3) {
			season = 1;
		} else if (month == 4 || month == 5 || month == 6) {
			season = 2;
		} else if (month == 7 || month == 8 || month == 9) {
			season = 3;
		} else if (month == 10 || month == 11 || month == 12) {
			season = 4;
		}
		String departmentId = request.getParameter("departmentId");
		String qualifiedSupplierId = "";
		String value = request.getParameter("value");
		if (null != value && !"".equals(value)) {
			String[] str = value.split(",");
			qualifiedSupplierId = str[0];
			if (value.length() > 3) {
				departmentId = str[1];
			}
		}

		List<PurchasePlanStore> listpu = new ArrayList<PurchasePlanStore>();
		// 封装采购单json
		// listpu=purchaseNoteItemMng.findypJsonqy(year,season);
		listpu = purchaseNoteItemMng.findMedicByYearAndDept(String.valueOf(year), departmentId);

		String today = DateTimeUtils.getNowStrDate();
		String json = "[";
		if (listpu != null) {
			if (null != qualifiedSupplierId && !"".equals(qualifiedSupplierId)) {
				QualifiedSuppliers qualifiedSuppliers = qualifiedSuppliersService.findById(qualifiedSupplierId);
				for (int i = 0; i < listpu.size(); i++) {
					boolean dbool = false;
					for (QulifiedSupplyDrugFroms drugFroms : qualifiedSuppliers.getDrugFroms()) {
						if (listpu.get(i).getQualityMidicine().getDosageforms().getId()
								.equals(drugFroms.getDrugFormDictionary_id())) {
							if (null != drugFroms.getDrugFormDate() && !"".equals(drugFroms.getDrugFormDate())
									&& DateTimeUtils.compareTwoDate(drugFroms.getDrugFormDate(), today) >= 0) {
								dbool = true;
								break;
							}
						}
					}

					if (!qualifiedSupplierId.equals(listpu.get(i).getQualityMidicine().getSupplyUnit().getId() + "")) {
						dbool = false;
					}

					if (dbool) {
						if (listpu.get(i).getQualityMidicine() != null
								&& listpu.get(i).getQualityMidicine().getCommonname() != null
								&& !"".equals(listpu.get(i).getQualityMidicine().getCommonname())) {
							json += "{";
							json += "\"id\":\"" + listpu.get(i).getQualityMidicineId() + "\",";
							json += "\"text\":\"" + "(" + listpu.get(i).getQualityMidicine().getMedicinalNo() + ")"
									+ listpu.get(i).getQualityMidicine().getCommonname() + "\"";

							json += "},";
						}
					}
				}
				json = json.substring(0, json.length() - 1);
			} else {
				for (int i = 0; i < listpu.size(); i++) {
					if (listpu.get(i).getQualityMidicine() != null
							&& listpu.get(i).getQualityMidicine().getCommonname() != null
							&& !"".equals(listpu.get(i).getQualityMidicine().getCommonname())) {
						json += "{";
						json += "\"id\":\"" + listpu.get(i).getQualityMidicineId() + "\",";
						json += "\"text\":\"" + "(" + listpu.get(i).getQualityMidicine().getMedicinalNo() + ")"
								+ listpu.get(i).getQualityMidicine().getCommonname() + "\"";
						if (i == listpu.size() - 1) {
							json += "}";
						} else {
							json += "},";
						}
					}
				}
			}
		}

		json += "]";
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/drugState/purchaseNote/findPurchaseOrderRecords.html")
	public String findPurchaseOrderRecords(Model model, HttpServletRequest request, HttpServletResponse response) {
		String purchaseOrderId = request.getParameter("id");
		Long id = null;
		if (purchaseOrderId != null && !"".equals(purchaseOrderId)) {
			id = Long.parseLong(purchaseOrderId);
		} else {
			id = Long.valueOf(0);
		}
		String hql = "select t from PurchaseOrderRecords t where t.purchaseOrderId = :purchaseOrderId";
		String page = DisplayGetPage.getPageParamName("record", request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchaseOrderId", id);
		List<PurchaseOrderRecords> recordList = null;
		if (page == null || "".equals(page) || "null".equalsIgnoreCase(page)) {
			recordList = purchaseOrderRecordsManager.getListByPage(hql, map, 0, Constants.pagesize);
		} else {
			recordList = purchaseOrderRecordsManager.getListByPage(hql, map,
					(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		int resultSize = purchaseOrderRecordsManager
				.getRecordCount("select count(*) from t_purchase_order_records where purchase_order_id = " + id);
		double size = resultSize;
		// 页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordList", recordList);
		return "drugState/purchaseNote/purchaseOrderRecords";
	}

	private String gspWarningDate(Set<QulifiedSupplyAccessory> accessorySet) {
		String gspWarningDate = "";
		List<String> list = new ArrayList<String>();
		if (accessorySet != null && accessorySet.size() > 0) {
			Iterator<QulifiedSupplyAccessory> iterator = accessorySet.iterator();
			while (iterator.hasNext()) {
				String date = iterator.next().getAccessoryDate();
				if (date != null && !"".equals(date) && !"null".equalsIgnoreCase(date)) {
					list.add(date);
				}
			}
			Collections.sort(list);
			if (list.size() > 0)
				gspWarningDate = list.get(0);
		}
		return gspWarningDate;
	}

	@RequestMapping("/drugState/purchaseNote/findavailablequant.html")
	public void findAvailableQuant(String batch, HttpServletRequest request, HttpServletResponse response,
			Model model) {

		int quant = purchaseNoteMng.countQuant(batch);
		String json = "{";

		json += "\"quant\":\"" + quant + "\"";
		json += "}";

		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/drugState/purchaseNote/findprice.html")
	public void findPrice(String batch, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<PurchaseOrderItem> poi = purchaseNoteItemMng.findByBatch(batch);
		String json = "{";

		json += "\"price\":\"" + poi.get(0).getTaxPrice() + "\"";
		json += "}";

		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 已作废
	@RequestMapping("/drugState/purchaseNote/yzflist.html")
	public String voidPurchaseOrderList(Model model, HttpServletRequest request, HttpServletResponse response) {
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页

		// String ypname = request.getParameter("ypname");//批号
		String orderNumber = request.getParameter("orderNumber");// 订单编号
		String modityDate = request.getParameter("modityDate");// 订单时间
		String yhDate = request.getParameter("yhDate");// 通用名称
		String department = request.getParameter("department");// 经营公司

		model.addAttribute("yhDate", yhDate);
		// model.addAttribute("ypname", ypname);
		model.addAttribute("orderNumber", orderNumber);
		model.addAttribute("modityDate", modityDate);
		model.addAttribute("department", department);

		// List<PurchaseOrder> reslist=new ArrayList<PurchaseOrder>();
		List<PurchaseOrderVO> reslist = null;
		if (page == null) {
			// 如果page等于空，默认从第一条开始查询
			// reslist= purchaseNoteMng.getPage(re,0,Constants.pagesize);
			reslist = purchaseNoteMng.findPurchseOrderVOByUseflag(yhDate, orderNumber, modityDate, department, 0,
					Constants.pagesize);
		} else {
			// 否者翻页查询
			// reslist= purchaseNoteMng.getPage(re,(Integer.parseInt(page) - 1)
			// * Constants.pagesize,Constants.pagesize);
			reslist = purchaseNoteMng.findPurchseOrderVOByUseflag(yhDate, orderNumber, modityDate, department,
					(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// int resultSize = purchaseNoteMng.getTotalCount(re);
		// int resultSize =
		// purchaseNoteMng.countPurchaseOrderVOByCondition(yhDate, ypname);
		int resultSize = purchaseNoteMng.countPurchaseOrderVOByUseflag(yhDate, orderNumber, modityDate, department);
		double size = resultSize;
		// 页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		// model.addAttribute("re", re);
		model.addAttribute("reslist", reslist);
		return "drugState/purchaseNote/yzflist";
	}
	
	
	
	/**
	 * 
	 * @param batch
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/drugState/purchaseNote/ajaxQueryMedcAllowBuyQuantity.html")
	public void ajaxQueryMedcAllowBuyQuantity(String medcIds,String itemIds,String dpId, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		String[] medcs = medcIds.split(",");
		List<Integer> ids = new ArrayList();
		for(String id : medcs){
			ids.add(Integer.valueOf(id));
		}
		String[] items = itemIds.split(",");
		List<Integer> itemList = new ArrayList();
		for(String id : items){
			if(id == null || id.trim().equals("")){
				continue;
			}
			itemList.add(Integer.valueOf(id));
		}
		
		List<Map<String, Object>> medcMap = null;
		try {
			medcMap = purchaseNoteMng.findMedcAllowBuyQuantity(ids,itemList, dpId, Integer.toString(DateTimeUtils.getYear(DateTimeUtils.getNowDate())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		UtilJson.printListJson(response, medcMap);
	}

}
