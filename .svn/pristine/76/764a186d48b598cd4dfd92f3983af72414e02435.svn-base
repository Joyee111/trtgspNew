package com.sinosoft.drugState.procurementProgram.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlan;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanItem;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;
import com.sinosoft.drugState.procurementProgram.serviece.PlanStoreMng;
import com.sinosoft.drugState.procurementProgram.serviece.ProcurementProgramItemMng;
import com.sinosoft.drugState.procurementProgram.serviece.ProcurementProgramMng;
import com.sinosoft.drugState.purchaseNote.service.PurchaseNoteMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.ireportDTO.PurchasePlanDto;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.IreportUtil;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;


/**
 * 采购计划
 *
 */
@Controller
public class ProcurementProgramAct {
	@Autowired
	private PlanStoreMng planStoreMng;
	@Autowired
	private ProcurementProgramMng procurementProgramMng;
	@Autowired
	private ProcurementProgramItemMng procurementProgramItemMng;
	@Autowired
	private InspectionMng inspectionMng;
	@Autowired
	private PurchaseNoteMng purchaseNoteMng;
	@Autowired
	private SystemLogService logService;
	
	/**
	 * 列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/drugState/procurementProgram/list.html")
	public ModelAndView getPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String seasons = request.getParameter("seasons");
		String years=request.getParameter("years");
		String types = request.getParameter("types");
		String qualifiedSupplierId=request.getParameter("qualifiedSupplierId");
		String plNo = request.getParameter("plNo");
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		String department = request.getParameter("department");
		List<PurchasePlanItem> list = new ArrayList<PurchasePlanItem>();
		PurchasePlan rurIt = new PurchasePlan();
		if(plNo!=null && !"".equals(plNo)){
			rurIt.setPlanNo(plNo);
			model.addAttribute("plNo", plNo);
		}
		if(years!=null && !"".equals(years)){
			rurIt.setYear(years);
			model.addAttribute("years", years);
		}
		if(seasons!=null && !"".equals(seasons)){
			rurIt.setSeason(seasons);
			model.addAttribute("seasons", seasons);
		}
		if(department!=null && !"".equals(department)){
			rurIt.setDepartmentId(department);
			model.addAttribute("department", department);
		}
		if(qualifiedSupplierId!=null && !"".equals(qualifiedSupplierId)){
			rurIt.setQualifiedSupplierId(Long.parseLong(qualifiedSupplierId));
			QualifiedSuppliers sy = purchaseNoteMng.findByIdSy(qualifiedSupplierId);
			model.addAttribute("gongyingshang", sy.getPinyinCode()+"_"+sy.getId());
			model.addAttribute("qualifiedSupplierId", qualifiedSupplierId);
		}
		model.addAttribute("types", types);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= procurementProgramMng.getPage(rurIt,types,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= procurementProgramMng.getPage(rurIt,types,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = procurementProgramMng.getTotalCount(rurIt,types);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		return new ModelAndView("drugState/procurementProgram/list");
	}
	
	/**
	 * 导出EXCEL
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/drugState/procurementProgram/exportToExcel.html")
	public String getAllexportToExcel(HttpServletRequest request, HttpServletResponse response,Model model){
		String seasons = request.getParameter("seasons");
		String years=request.getParameter("years");
		String types = request.getParameter("types");
		String qualifiedSupplierId=request.getParameter("qualifiedSupplierId");
		String plNo = request.getParameter("plNo");
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<PurchasePlanItem> list = new ArrayList<PurchasePlanItem>();
		PurchasePlan rurIt = new PurchasePlan();
		if(plNo!=null && !"".equals(plNo)){
			rurIt.setPlanNo(plNo);
			model.addAttribute("plNo", plNo);
		}
		if(years!=null && !"".equals(years)){
			rurIt.setYear(years);
			model.addAttribute("years", years);
		}
		if(seasons!=null && !"".equals(seasons)){
			rurIt.setSeason(seasons);
			model.addAttribute("seasons", seasons);
		}
		if(qualifiedSupplierId!=null && !"".equals(qualifiedSupplierId)){
			rurIt.setQualifiedSupplierId(Long.parseLong(qualifiedSupplierId));
			QualifiedSuppliers sy = purchaseNoteMng.findByIdSy(qualifiedSupplierId);
			model.addAttribute("gongyingshang", sy.getPinyinCode()+"_"+sy.getId());
			model.addAttribute("qualifiedSupplierId", qualifiedSupplierId);
		}
		model.addAttribute("types", types);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= procurementProgramMng.getAllPurchasePlanIten(rurIt, types);
		}
		else{
			//否者翻页查询
			list= procurementProgramMng.getAllPurchasePlanIten(rurIt, types);
		}
		List<PurchasePlanDto> purchasePlanDtoList = new ArrayList<PurchasePlanDto>();
		for(PurchasePlanItem palItem : list){
			purchasePlanDtoList.add(new PurchasePlanDto(palItem));
		}
		String file = "PurchasePlan";
		String chinesName = "采购计划";
		IreportUtil.export(file, chinesName, purchasePlanDtoList, request, response);
		return null;
	}
	
	/**
	 * 跳转添加页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/drugState/procurementProgram/add.html")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response,Model model){
		return new ModelAndView("drugState/procurementProgram/add");
	}
	
	/**
	 * 保存采购计划
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/drugState/procurementProgram/savePurchasePlan.html")
	public void savePurchasePlan(HttpServletRequest request, HttpServletResponse response,Model model){
		String whone = request.getParameter("quantity").trim();
		String season = request.getParameter("season").trim();
		String year = request.getParameter("year").trim();
	//	String purchaseTime =request.getParameter("purchaseTime");
		String qualifiedSupplier = request.getParameter("qualifiedSupplier").trim();
		String departmentId = request.getParameter("operatingCompany");
		Map<String, Object> map = new HashMap<String, Object>();
		String plNo="";
		String AllNo = procurementProgramMng.findAllNo(year,season,whone);
		if("1".equals(whone) && season!=null && !"".equals(season) && year!=null && !"".equals(year) && qualifiedSupplier!=null && !"".equals(qualifiedSupplier)){
			PurchasePlan pl = procurementProgramMng.find(departmentId,season,year,Long.parseLong(qualifiedSupplier));
			if(pl!=null){
				map.put("success", "1");
				//UtilJson.printMapJson(response, map);
			}else{
				map.put("success", "");
			}
			String plNoFind=year.trim()+season.trim()+"A" ;
			if(!"".equals(AllNo)){
				if(plNoFind.equals(AllNo.substring(0, 6))){
					String a = AllNo.substring(6,AllNo.length());
					Integer b = Integer.parseInt(a)+1;
					String str=String.format("%03d", b);
					plNo=plNoFind+str;
				
				}
			}else{
				plNo = year.trim()+season.trim()+"A001";
			}
//			String nonumber = makeNoMng.findNo(Constants.PLANNO);
//			Date now = new Date();
//			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//			String number = format.format(now);
//			if(nonumber!=null && !"".equals(nonumber) && number.equals(nonumber.substring(0, 8))){
//				try {
//					Long  n = Long.parseLong(nonumber)+1L;
//					receivingNote.setNumber(n.toString());
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}else{
//				nonumber= number+"001";
//				receivingNote.setNumber(nonumber);
//			}
			
		}else if("2".equals(whone) && season!=null && !"".equals(season) && year!=null && !"".equals(year) && qualifiedSupplier!=null && !"".equals(qualifiedSupplier)){
			PurchasePlan pl = procurementProgramMng.find(departmentId,season,year,Long.parseLong(qualifiedSupplier));
			if(pl!=null){
				String plNoFind=year.trim()+season.trim()+"B" ;
				if(!"".equals(AllNo)){
					if(plNoFind.equals(AllNo.substring(0, 6))){
						String a = AllNo.substring(6,AllNo.length());
						Integer b = Integer.parseInt(a)+1;
						String str=String.format("%03d", b);
						plNo=plNoFind+str;
					}
				}else{
					plNo = year.trim()+season.trim()+"B001";
				}
				map.put("success", "3");
			}else{
				map.put("success", "2");
			}
		}else if("3".equals(whone) && season!=null && !"".equals(season) && year!=null && !"".equals(year) && qualifiedSupplier!=null && !"".equals(qualifiedSupplier)){
			PurchasePlan pl = procurementProgramMng.find(departmentId,season,year,Long.parseLong(qualifiedSupplier));
			if(pl!=null){
				String plNoFind=year.trim()+season.trim()+"C" ;
				if(!"".equals(AllNo)){
					if(plNoFind.equals(AllNo.substring(0, 6))){
						String a = AllNo.substring(6,AllNo.length());
						Integer b = Integer.parseInt(a)+1;
						String str=String.format("%03d", b);
						plNo=plNoFind+str;
					}
				}else{
					plNo = year.trim()+season.trim()+"C001";
				}
				map.put("success", "3");
			}else{
				map.put("success", "2");
			}
		}
		map.put("plNo", plNo);
		UtilJson.printMapJson(response, map);
	}
	
	/**
	 * 保存采购计划明细
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/drugState/procurementProgram/savePurchasePlanItem.html")
	public ModelAndView savePurchasePlanItem(HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		String token = (String) request.getSession().getAttribute("token");
		String formtoken = request.getParameter("formtoken");
		Map<String, Object> map = new HashMap<String, Object>();
		if(formtoken.equals(token)){
			request.getSession().removeAttribute("token");
		String whone = request.getParameter("types").trim();
		String season = request.getParameter("seasons").trim();
		String year = request.getParameter("years").trim();
		String supplyTimes= request.getParameter("supplyTimes");
		String plNo = request.getParameter("plNo");
		String qualifiedSupplier = request.getParameter("qualifiedSupplier").trim();
		String departmentId = request.getParameter("departmentId");
		
		String counts = request.getParameter("counts").trim();
		PurchasePlan pl = new PurchasePlan();
		pl.setSeason(season);
		pl.setYear(year);
		pl.setPlanNo(plNo);
		pl.setDepartmentId(departmentId);
		if(qualifiedSupplier!=null && !"".equals(qualifiedSupplier)){
			pl.setQualifiedSupplierId(Long.parseLong(qualifiedSupplier));
			QualifiedSuppliers sy = purchaseNoteMng.findByIdSy(qualifiedSupplier);
			pl.setQualifiedSupplier(sy);
		}
		pl.setPurchaseTime(supplyTimes);
		PurchasePlan pls =procurementProgramMng.save(pl);
		if(counts!=null && !"".equals(counts)){
			for(int i=0;i<Integer.parseInt(counts);i++){
				PurchasePlanItem receivingNoteItem = new PurchasePlanItem();
				String pingming = request.getParameter("pinming"+i);
				String shuliang = request.getParameter("shuliang"+i);
				String remark = request.getParameter("remark"+i);
				String guige = request.getParameter("guige"+i);
				String money = request.getParameter("money"+i);
				String pifajia = request.getParameter("pifajia"+i);
				String koulv  = request.getParameter("koulv"+i);
				if(money!=null && !"".equals(money)){
					receivingNoteItem.setMoney(money);
				}
				if(pifajia!=null && !"".equals(pifajia)){
					receivingNoteItem.setTaxPrice(pifajia);
				}
				if(pingming!=null && !"".equals(pingming)){
					QualityMidicine qmdi =inspectionMng.findHGYP(Long.parseLong(pingming.trim()));
					receivingNoteItem.setQualifiedMedicineId(qmdi.getId());
					receivingNoteItem.setQualityMidicine(qmdi);
				}else{
					continue;
				}
				if(shuliang!=null && !"".equals(shuliang)){
					try {
						receivingNoteItem.setQuantity(shuliang);
					} catch (Exception e) {
						receivingNoteItem.setQuantity("0");
						e.printStackTrace();
					}
				}else{
					continue;
				}
				receivingNoteItem.setDeductionRate(koulv);
				receivingNoteItem.setRemark(remark);
				receivingNoteItem.setPurchasePlanOrder(pls.getId());
				receivingNoteItem.setSpecifications(guige);
				receivingNoteItem.setPlanType(whone);
				receivingNoteItem.setPurchasePlan(pls);
				procurementProgramItemMng.saveReceivingNoteItem(receivingNoteItem);
				
				
				
				
				
				
				/**
				 * 取得计划数量,如果无法取得计划数量则进行初始化
				 */
				PurchasePlanStore planStore = procurementProgramMng.findps(departmentId,season,year,Long.parseLong(pingming.trim()));
				if(planStore == null){
					planStore = new PurchasePlanStore();
					planStore.setPrice(receivingNoteItem.getMoney());
					QualityMidicine qmdi =inspectionMng.findHGYP(Long.parseLong(pingming.trim()));
					planStore.setQualityMidicineId((qmdi.getId()));
					planStore.setQualityMidicine(qmdi);
					planStore.setQuantity(0L);
					planStore.setDepartmentId(departmentId);
					planStore.setSeason(season);
					planStore.setYear(year);
//					planStore.setPrice(receivingNoteItem.getMoney());
					planStore = planStoreMng.save(planStore);
				}
				
				//正常
				if("1".equals(whone) && pingming != null && !"".equals(pingming.trim())){
					planStore.setPrice(receivingNoteItem.getMoney());
					planStore.setQuantity(Long.parseLong(shuliang));
				}
				//追加
				if("2".equals(whone) && pingming != null && !"".equals(pingming.trim())){
					planStore.setPrice(receivingNoteItem.getMoney());
					planStore.setQuantity(Long.parseLong(shuliang)+(planStore.getQuantity() == null ? 0 : planStore.getQuantity()));
				}
				//消减
				if("3".equals(whone) && pingming != null && !"".equals(pingming.trim())){
					if((planStore.getQuantity()-Long.parseLong(shuliang))>=0){
						planStore.setQuantity(planStore.getQuantity()-Long.parseLong(shuliang));
					}
				}
				planStoreMng.update(planStore);
				
				
				
				/*
				//以下为原代码逻辑,过于啰嗦,并且存在严重BUG,优化为以上代码
				if("1".equals(whone)&&!"".equals(pingming.trim())){
					PurchasePlanStore ps = procurementProgramMng.findps(departmentId,year,season,Long.parseLong(pingming.trim()));
					if(ps!=null){
						try {
							ps.setQuantity(ps.getQuantity()+Long.parseLong(shuliang));
							planStoreMng.update(ps);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else{
						ps = new PurchasePlanStore();
						ps.setPrice(receivingNoteItem.getMoney());
						if(pingming!=null && !"".equals(pingming)){
							QualityMidicine qmdi =inspectionMng.findHGYP(Long.parseLong(pingming.trim()));
							ps.setQualityMidicineId((qmdi.getId()));
							ps.setQualityMidicine(qmdi);
						}
						if(shuliang!=null && !"".equals(shuliang)){
							try {
								ps.setQuantity(Long.parseLong(shuliang));
							} catch (Exception e) {
								ps.setQuantity(0L);
								e.printStackTrace();
							}
						}
						ps.setDepartmentId(departmentId);
						ps.setSeason(season);
						ps.setYear(year);
						planStoreMng.save(ps);
					}
				}else if("2".equals(whone) && pingming.trim()!=null && !"".equals(pingming.trim())){
					PurchasePlanStore ps1 = procurementProgramMng.findps(departmentId,season,year,Long.parseLong(pingming.trim()));
					if(ps1!=null &&ps1.getQuantity()!=null){
						ps1.setQuantity(Long.parseLong(shuliang)+ps1.getQuantity());
						planStoreMng.update(ps1);
					}else{
						PurchasePlanStore ps2 = new PurchasePlanStore();
						ps2.setPrice(receivingNoteItem.getMoney());
						if(pingming!=null && !"".equals(pingming)){
							QualityMidicine qmdi =inspectionMng.findHGYP(Long.parseLong(pingming.trim()));
							ps2.setQualityMidicineId((qmdi.getId()));
							ps2.setQualityMidicine(qmdi);
						}else{
							continue;
						}
						if(shuliang!=null && !"".equals(shuliang)){
							try {
								ps2.setQuantity(Long.parseLong(shuliang));
							} catch (Exception e) {
								ps2.setQuantity(0L);
								e.printStackTrace();
							}
						}else{
							continue;
						}
						ps2.setDepartmentId(departmentId);
						ps2.setSeason(season);
						ps2.setYear(year);
						planStoreMng.save(ps2);
					}
				}else{
					PurchasePlanStore ps1 = procurementProgramMng.findps(departmentId,season,year,Long.parseLong(pingming.trim()));
					if(ps1!=null &&ps1.getQuantity()!=null){
						if((ps1.getQuantity()-Long.parseLong(shuliang))>=0){
							ps1.setQuantity(ps1.getQuantity()-Long.parseLong(shuliang));
							planStoreMng.update(ps1);
						}
					}
				}
				*/
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("新增采购计划", user.getRealname(), "新增", "药品状态管理  >采购计划", StringUtil.getIpAddr(request));
		
		map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		
		UtilJson.printMapJson(response, map);
		}else{
			map.put("success", URLEncoder.encode("请不要重复提交！", "UTF-8"));
			UtilJson.printMapJson(response, map);
		}
		return null;
	}
}
