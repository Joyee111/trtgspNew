package com.sinosoft.drugState.outcheck.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.sinosoft.drugState.acceptance.service.AcceptanceMng;
import com.sinosoft.drugState.inspectionRecords.model.QualifiedEdit;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.outcheck.model.OutboundCheckBill;
import com.sinosoft.drugState.outcheck.model.OutboundCheckBillVO;
import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;
import com.sinosoft.drugState.outcheck.model.TrtssSalesFormInfo;
import com.sinosoft.drugState.outcheck.model.TrtssSalesFormInfoVO;
import com.sinosoft.drugState.outcheck.model.TrtssSalesItemsInfo;
import com.sinosoft.drugState.outcheck.service.OutCheckItemMng;
import com.sinosoft.drugState.outcheck.service.OutCheckMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedPurchaseUnitsService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualifiedmedcstoreMng;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;

@Controller
public class OutCheckAct {
	@Autowired
	private OutCheckMng outCheckMng;
	@Autowired
	private OutCheckItemMng outCheckItemMng;
	@Autowired 
	private InspectionMng inspectionMng;
	@Autowired
	private AcceptanceMng acceptanceMng;
	@Autowired
	private QualifiedmedcstoreMng qualifiedmedcstoreMng;
	@Autowired
	private QualifiedPurchaseUnitsService unitsService;
	@Autowired
	private QualityMidicineMng midicineMng; 
	@Autowired
	private QualifiedmedcstoreMng midicineStoreServer;
	@Autowired
	private SystemLogService logService;
	@RequestMapping("/drugState/outcheck/saleNodlr.html")
	public ModelAndView saleNodlr(HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		String saleNumber = request.getParameter("saleNumber");
		String contractNumber = request.getParameter("contractNumber");
		List<TrtssSalesFormInfoVO> fromInfoVOList = null;
		fromInfoVOList=outCheckMng.findSalesFromInfoVO(saleNumber, contractNumber,(Integer.parseInt(page) - 1) * Constants.pagesize,20);
		model.addAttribute("fromInfoVOList",fromInfoVOList);
		int resultSize = outCheckMng.countSalesFromInfoVO(saleNumber, contractNumber);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", 20);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("saleNumber", saleNumber);
		model.addAttribute("contractNumber", contractNumber);
		return new ModelAndView("drugState/outcheck/saleNodlr");
	}
	
	
	@RequestMapping("/drugState/outcheck/list.html")
	public ModelAndView openFramPage(OutboundCheckBill reNo,HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		//List<OutboundCheckBill> list = new ArrayList<OutboundCheckBill>();
		List<OutboundCheckBillVO> list =null;
		String pageNo = request.getParameter("thispage");
		if(reNo==null){
			reNo = new OutboundCheckBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= outCheckMng.getPage(reNo,0,Constants.pagesize);
			list= outCheckMng.findOutboundCheckBillByStatus("0", 0, Constants.pagesize);
		}
		else{
			//否者翻页查询
			//list= outCheckMng.getPage(reNo,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			list= outCheckMng.findOutboundCheckBillByStatus("0",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = outCheckMng.countOutboundCheckBillByStatus("0");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("reNo", reNo);
		return new ModelAndView("drugState/outcheck/dlrlist");
	}
	@RequestMapping("/drugState/outcheck/dlrlist.html")
	public ModelAndView dlrPage(OutboundCheckBill reNo,HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		//List<OutboundCheckBill> list = new ArrayList<OutboundCheckBill>();
		List<OutboundCheckBillVO> list = null;
		String pageNo = request.getParameter("thispage");
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= outCheckMng.getPage(reNo,0,Constants.pagesize);
			list= outCheckMng.findOutboundCheckBillByStatus("0",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			//list= outCheckMng.getPage(reNo,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			list= outCheckMng.findOutboundCheckBillByStatus("0",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
//		int resultSize = outCheckMng.getTotalCount();
		int resultSize = outCheckMng.countOutboundCheckBillByStatus("0");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("reNo", reNo);
		return new ModelAndView("drugState/outcheck/dlrlist");
	}
	@RequestMapping("/drugState/outcheck/dlradd.html")
	public ModelAndView dshadd(OutboundCheckBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		model.addAttribute("mc", mc);
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> qsmap=inspectionMng.gouhuoMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("drugState/outcheck/dlradd");
	}
	@RequestMapping("/drugState/outcheck/dlredit.html")
	public ModelAndView dshedit(OutboundCheckBill mc,String id, HttpServletRequest request, HttpServletResponse response,Model model){
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		OutboundCheckBill mcs=outCheckMng.findById(id);
		model.addAttribute("mc", mcs);
		if(mcs.getQualifiedPurchaseUnits()!=null){
			model.addAttribute("gouhuoshang", mcs.getQualifiedPurchaseUnits().getCustomerName());
		}
	//	TrtssSalesFormInfo tf = outCheckMng.findxsById(mcs.getSalesNumber().toString());
		TrtssSalesFormInfo tf = outCheckMng.findSalesFromInfoBySalesItemId(mcs.getSalesNumber().toString());
		
		if(mcs!=null){
			model.addAttribute("xiaoshou", mcs.getSalesNumber());
			model.addAttribute("salesFromNumber", mcs.getSalesFromNumber());
		}
		List<OutboundCheckItem> receItem= outCheckMng.findYp(mcs.getId());
		List<QualifiedEdit> qus =  new ArrayList<QualifiedEdit>();
		for(int j=0;j<receItem.size();j++){
			QualifiedEdit qu = new QualifiedEdit();
			OutboundCheckItem rece = receItem.get(j);
			QualityMidicine qualifiedMedicine = inspectionMng.findHGYP(receItem.get(j).getQualifiedMedicineId());
			if(rece.getBatchNo()!=null && !"".equals(rece.getBatchNo())){
				qu.setShengchanpihao(rece.getBatchNo());
			}else{
				qu.setShengchanpihao("");
			}
			if(rece.getQuantity()!=null && !"".equals(rece.getQuantity().toString())){
				qu.setShuliang(rece.getQuantity().toString());
			}else{
				qu.setShuliang("");
			}
			if(rece.getQualifiedMedicineId()!=null){
				qu.setYaopinming(rece.getQualifiedMedicineId().toString());
			}else{
				qu.setYaopinming("");
			}
			if(rece.getDosageForms()!=null){
				qu.setJixing(rece.getDosageForms());
			}else{
				qu.setJixing("");
			}
			if(rece.getSpecifications()!=null){
				qu.setGuige(rece.getSpecifications());
			}else{
				qu.setGuige("");
			}
			if(qualifiedMedicine.getRegisteredtrademarkpath()!=null){
				qu.setZhuceshangbiao(qualifiedMedicine.getRegisteredtrademarkpath());
			}else{
				qu.setZhuceshangbiao("");
			}
			if(qualifiedMedicine.getLicensenumber()!=null){
				qu.setPizhunwenhao(qualifiedMedicine.getLicensenumber());
			}else{
				qu.setPizhunwenhao("");
			}
			if(rece.getValidityTime()!=null){
				qu.setYouxiaoqizhi(rece.getValidityTime());
			}else{
				qu.setYouxiaoqizhi("");
			}
			qu.setHegezheng("");
			if(qualifiedMedicine.getProduceno()!=null){
				if(qualifiedMedicine.getProduceno().getCustomerName()!=null){
					qu.setShengchangqiye(qualifiedMedicine.getProduceno().getCustomerName());
				}else{
					qu.setShengchangqiye("");
				}
			}else{
				qu.setShengchangqiye("");
			}
			qu.setSalesFromNumber(tf.getContractNo());
			if(tf.getCreaterDate()!=null){
				SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 		String modifyDate = modifyDateFormat.format(tf.getCreaterDate());
		 		qu.setXiaoshouriqi(modifyDate);
		 		model.addAttribute("xiaoshouriqi", modifyDate);
			}
			qus.add(qu);
		}
		List<String> jsonStringList = new ArrayList<String>();
		for(int i=0;i<receItem.size();i++)
		{
			QualifiedEdit borg = qus.get(i);
			jsonStringList.add(new JSONObject(borg).toString());
		}
		JSONArray jsonArray = new JSONArray(jsonStringList);
		String jsonString = jsonArray.toString();
		model.addAttribute("receItem", jsonString);
		Map<String, String> qsmap=inspectionMng.gouhuoMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("drugState/outcheck/dlredit");
	}
	@RequestMapping("/drugState/outcheck/dlrsave.html")
	public ModelAndView dlrsave(OutboundCheckBill mc, String counts,HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String thispage=request.getParameter("thispage");
		String type = request.getParameter("submitType");
		model.addAttribute("thispage", thispage);
		model.addAttribute("mc", mc);
		Map<String, Object> map = new HashMap<String, Object>();
		if("1".equals(type)){
			mc.setReviewStatus(1L);
			map.put("success",URLEncoder.encode("数据提交成功！", "UTF-8"));
		}else{
			mc.setReviewStatus(0L);
			map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		}
		Date date = new Date();
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		String modifyDate = modifyDateFormat.format(date);
 		mc.setApplicationTime(modifyDate);
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		mc.setProposerID(user.getId());
		mc.setUser(user);
		mc.setProposerID(user.getId());
		if(mc.getQualifiedPurchaseUnitsId()!=null){
			mc.setQualifiedPurchaseUnits(inspectionMng.findGHSById(mc.getQualifiedPurchaseUnitsId()));
		}
		OutboundCheckBill mcs=outCheckMng.save(mc);
		if(!"".equals(counts) && counts!=null){
			for(int i=0;i<Integer.parseInt(counts);i++){
				OutboundCheckItem chIt= new OutboundCheckItem();
				String pingming = request.getParameter("pinming"+i);
				String shuliang = request.getParameter("shuliang"+i);
				String jixing = request.getParameter("jixing"+i);
				String guige = request.getParameter("guige"+i);
				String shengchang = request.getParameter("shengchang"+i);
				String pizhun = request.getParameter("pizhun"+i);
				String shangbiao = request.getParameter("shangbiao"+i);
				String hege = request.getParameter("hege"+i);
				String youxiaoqi = request.getParameter("youxiaoqi"+i);
				String shengchanpihao = request.getParameter("shengchanpihao"+i);
				if(pingming!=null && !"".equals(pingming)){
					chIt.setQualifiedMedicineId(Long.parseLong(pingming.trim()));
					chIt.setQualityMidicine(inspectionMng.findYpById(pingming.trim()));
				}else{
					continue;
				}
				if(shuliang!=null && !"".equals(shuliang)){
					String[] shuliangs = shuliang.split("\\.");
					chIt.setQuantity(Long.parseLong(shuliangs[0]));
				}else{
					continue;
				}
				chIt.setOutboundCheckBillId(mcs.getId());
				chIt.setDosageForms(jixing);
				chIt.setLicenseNumber(pizhun);
				chIt.setSpecifications(guige);
				chIt.setBatchNo(shengchanpihao);
				chIt.setValidityTime(youxiaoqi);
				outCheckItemMng.save(chIt);
			}
		}
		logService.addLog("新增出库复核记录", user.getRealname(), "新增", "药品状态管理  >出库复核管理", StringUtil.getIpAddr(request));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/outcheck/dlrupdate.html")
	public ModelAndView dshupdate(OutboundCheckBill mc,String counts, HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String thispage=request.getParameter("thispage");
		String type = request.getParameter("submitType");
		Map<String, Object> map = new HashMap<String, Object>();
		if("1".equals(type)){
			mc.setReviewStatus(1L);
			map.put("success",URLEncoder.encode("数据提交成功！", "UTF-8"));
		}else{
			mc.setReviewStatus(0L);
			map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		}
		model.addAttribute("thispage", thispage);
		Date date = new Date();
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		String modifyDate = modifyDateFormat.format(date);
 		mc.setApplicationTime(modifyDate);
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		mc.setProposerID(user.getId());
		if(mc.getQualifiedPurchaseUnitsId()!=null){
			mc.setQualifiedPurchaseUnits(inspectionMng.findGHSById(mc.getQualifiedPurchaseUnitsId()));
		}
		mc.setUser(user);
		model.addAttribute("mc", mc);
		outCheckMng.update(mc);
		//先删除后保存
		List<?> receItem= outCheckMng.findAllId(mc.getId());
		outCheckItemMng.del(receItem);
		if(!"".equals(counts) && null!=counts){
			for(int i=0;i<Integer.parseInt(counts);i++){
				OutboundCheckItem chIt= new OutboundCheckItem();
				String pingming = request.getParameter("pinming"+i);
				String shuliang = request.getParameter("shuliang"+i);
				String jixing = request.getParameter("jixing"+i);
				String guige = request.getParameter("guige"+i);
				String shengchang = request.getParameter("shengchang"+i);
				String hegeshuliang=request.getParameter("hegeshuliang"+i);
				String pizhun = request.getParameter("pizhun"+i);
				String shangbiao = request.getParameter("shangbiao"+i);
				String hege = request.getParameter("hege"+i);
				String youxiaoqi = request.getParameter("youxiaoqi"+i);
				String shengchanpihao = request.getParameter("shengchanpihao"+i);
				if(pingming!=null && !"".equals(pingming)){
					chIt.setQualifiedMedicineId(Long.parseLong(pingming.trim()));
					chIt.setQualityMidicine(inspectionMng.findYpById(pingming.trim()));
				}else{
					continue;
				}
				if(shuliang!=null && !"".equals(shuliang)){
					String[] shuliangs = shuliang.trim().split("\\.");
					chIt.setQuantity(Long.parseLong(shuliangs[0]));
				}else{
					continue;
				}
				chIt.setOutboundCheckBillId(mc.getId());
				chIt.setDosageForms(jixing);
				chIt.setLicenseNumber(pizhun);
				chIt.setSpecifications(guige);
				chIt.setBatchNo(shengchanpihao);
				chIt.setValidityTime(youxiaoqi);
				outCheckItemMng.save(chIt);
			}
		}
		logService.addLog("提交出库复核记录", user.getRealname(), "提交", "药品状态管理  >出库复核管理", StringUtil.getIpAddr(request));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/outcheck/dlrdel.html")
	public ModelAndView deldlr(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		if(ids!=null && !"".equals(ids)){
			for(int i= 0;i<ids.length;i++){
				outCheckMng.del(ids[i]);
				List<?> receItem= outCheckMng.findAllId(Long.parseLong(ids[i]));
				if(receItem!=null && receItem.size()>0){
					outCheckItemMng.del(receItem);
				}
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除出库复核记录", user.getRealname(), "删除", "药品状态管理  >出库复核管理", StringUtil.getIpAddr(request));
		return dlrPage(null, request, response, model);
	}
	/**
	 * 待审核
	 * **/
	@RequestMapping("/drugState/outcheck/dshlist.html")
	public ModelAndView dshPage(OutboundCheckBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		//List<OutboundCheckBill> list = new ArrayList<OutboundCheckBill>();
		List<OutboundCheckBillVO> list = null;
		String pageNo = request.getParameter("thispage");
		if(mc==null){
			mc = new OutboundCheckBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= outCheckMng.getPagedsh(mc,0,Constants.pagesize);
			list= outCheckMng.findOutboundCheckBillByStatus("1",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			//list= outCheckMng.getPagedsh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			list= outCheckMng.findOutboundCheckBillByStatus("1",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		//int resultSize = outCheckMng.getTotalCountDsh();
		int resultSize = outCheckMng.countOutboundCheckBillByStatus("1");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/outcheck/dshlist");
	}
	
	@RequestMapping("/drugState/outcheck/dshview.html")
	public ModelAndView dshview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		OutboundCheckBill ch =outCheckMng.findById(id);
		//根据ID查询销售实体
		//TrtssSalesFormInfo tf = outCheckMng.findxsById(ch.getSalesNumber().toString());
		
		//TrtssSalesFormInfo tf = outCheckMng.findSalesFromInfoBySalesItemId(ch.getSalesNumber());
		//if(tf!=null && tf.getSqlesFormNo()!=null){
		//	ch.setSalesNumber(tf.getSqlesFormNo());
		//}
		
		String page = DisplayGetPage.getPageParamName("records", request);
		List<OutboundCheckItem> chIt=new ArrayList<OutboundCheckItem>();
		QualifiedPurchaseUnits qu = new QualifiedPurchaseUnits();
		if(ch.getQualifiedPurchaseUnitsId()!=null && !"".equals(ch.getQualifiedPurchaseUnitsId())){
			qu=acceptanceMng.findgouhuo(ch.getQualifiedPurchaseUnitsId());
		}
		model.addAttribute("qu", qu);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			chIt= outCheckMng.find(ch.getId(),0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			chIt= outCheckMng.find(ch.getId(),(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		
		int resultSize = outCheckMng.findCount(ch.getId());
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("mc", ch);
		model.addAttribute("chIt", chIt);
		
		return new ModelAndView("drugState/outcheck/dshview");
	}	
	@RequestMapping("/drugState/outcheck/audit.html")
	public ModelAndView audit(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		String batch_type=request.getParameter("batch_type");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		if(ids!=null && !"".equals(ids)){
			if("0".equals(batch_type)){
				for(int i =0;i<ids.length;i++){
					OutboundCheckBill ch =outCheckMng.findById(ids[i]);
					ch.setReviewStatus(2L);
					Date date = new Date();
					SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 		String modifyDate = modifyDateFormat.format(date);
			 		ch.setReviewTime(modifyDate);
					User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
					ch.setAuditorID(user.getId());
					outCheckMng.update(ch);
					List<OutboundCheckItem> receItem= outCheckMng.findYp(ch.getId());
					if(receItem!=null && receItem.size()>0){
						for(int j=0;j<receItem.size();j++){
							OutboundCheckItem receItemone = receItem.get(j);
							Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(receItemone.getBatchNo());
							if(qu!=null&& ch!=null){
								qu.setQuantity(qu.getQuantity()-receItemone.getQuantity());
								qualifiedmedcstoreMng.updatequ(qu);
							}
						}
					}
//			acceptanceMng.audit(ids[i]);sql方法更新，等待删除
				}
			}else if("1".equals(batch_type)){
				for(int i =0;i<ids.length;i++){
					OutboundCheckBill ch =outCheckMng.findById(ids[i]);
					ch.setReviewStatus(3L);
					Date date = new Date();
					SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 		String modifyDate = modifyDateFormat.format(date);
			 		ch.setReviewTime(modifyDate);
					User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
					ch.setAuditorID(user.getId());
					outCheckMng.update(ch);
//				acceptanceMng.audit(ids[i]);sql方法更新，等待删除
				}
		}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("审核出库复核记录", user.getRealname(), "审核", "药品状态管理  >出库复核管理", StringUtil.getIpAddr(request));
		return dshPage(null, request, response, model);
	}
	@RequestMapping("/drugState/outcheck/shviewcheck.html")
	public ModelAndView auditOne(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		String type=request.getParameter("types");
		if(id!=null){
			OutboundCheckBill ch =outCheckMng.findById(id);
			String quality_Situation = request.getParameter("quality_Situation");
			String remak_content = request.getParameter("remak_content");
			ch.setQualitySituation(quality_Situation);
			ch.setRemark(remak_content);
			ch.setReviewStatus(Long.parseLong(type));
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			outCheckMng.update(ch);
			if(type.equals("2")){
				List<OutboundCheckItem> itemList = outCheckMng.find(ch.getId().toString());
				if(itemList!=null && itemList.size()>0){
					for(OutboundCheckItem item : itemList){
						if(item.getBatchNo()!=null && !"".equals(item.getBatchNo())){
							Qualifiedmedcstore store = midicineStoreServer.findByBaNo(item.getBatchNo());
							if(store!=null && item.getQuantity()!=null){
								store.setQuantity(store.getQuantity()-item.getQuantity());
								midicineStoreServer.updatequ(store);
							}
						}
					}
					 
				}
			}
			
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("审核出库复核记录", user.getRealname(), "审核", "药品状态管理  >出库复核管理", StringUtil.getIpAddr(request));
		return dshPage(null, request, response, model);
	}
	/**
	 * 
	 * 已审核
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/outcheck/yshlist.html")
	public ModelAndView yshPage(OutboundCheckBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		//List<OutboundCheckBill> list = new ArrayList<OutboundCheckBill>();
		List<OutboundCheckBillVO> list = null;
		if(mc==null){
			mc = new OutboundCheckBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= outCheckMng.getPageysh(mc,0,Constants.pagesize);
			list= outCheckMng.findOutboundCheckBillByStatus("2",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			//list= outCheckMng.getPageysh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			list= outCheckMng.findOutboundCheckBillByStatus("2",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		//int resultSize = outCheckMng.getTotalCountysh();
		int resultSize = outCheckMng.countOutboundCheckBillByStatus("2");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/outcheck/yshlist");
	}
	@RequestMapping("/drugState/outcheck/yshview.html")
	public ModelAndView yshviewlist(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);
		OutboundCheckBill ch =outCheckMng.findById(id);
		//TrtssSalesFormInfo tf = outCheckMng.findxsById(ch.getSalesNumber().toString());
		//TrtssSalesFormInfo tf = outCheckMng.findSalesFromInfoBySalesItemId(ch.getSalesNumber());
		//if(tf!=null && tf.getSqlesFormNo()!=null){
		//	ch.setSalesNumber(tf.getSqlesFormNo());
		//}
		
		List<OutboundCheckItem> chIt=new ArrayList<OutboundCheckItem>();
		QualifiedPurchaseUnits qu=new QualifiedPurchaseUnits();
		if(ch.getQualifiedPurchaseUnitsId()!=null && !"".equals(ch.getQualifiedPurchaseUnitsId())){
			qu=acceptanceMng.findgouhuo(ch.getQualifiedPurchaseUnitsId());
		}
		model.addAttribute("qu", qu);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			chIt= outCheckMng.find(ch.getId(),0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			chIt= outCheckMng.find(ch.getId(),(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		
		int resultSize = outCheckMng.findCount(ch.getId());
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("ch", ch);
		model.addAttribute("id", id);
		model.addAttribute("chIt", chIt);
		return new ModelAndView("drugState/outcheck/yshview");
	}	
	@RequestMapping("/drugState/outcheck/backcheck.html")
	public ModelAndView yshcheck(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		if(id!=null&&!"".equals(id)){
			OutboundCheckBill ch =outCheckMng.findById(id);
			ch.setReviewStatus(3L);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			outCheckMng.update(ch);
			List<OutboundCheckItem> receItem= outCheckMng.findYp(ch.getId());
			if(receItem!=null && receItem.size()>0){
				for(int j=0;j<receItem.size();j++){
					OutboundCheckItem receItemone = receItem.get(j);
					Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(receItemone.getBatchNo());
					if(qu!=null&& ch!=null){
						qu.setQuantity(qu.getQuantity()+receItemone.getQuantity());
						qualifiedmedcstoreMng.updatequ(qu);
					}
				}
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("驳回出库复核记录", user.getRealname(), "驳回", "药品状态管理  >出库复核管理", StringUtil.getIpAddr(request));
		return yshPage(null, request, response, model);
		
	}
	/**
	 * 
	 * 已驳回
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/outcheck/ybhlist.html")
	public ModelAndView ybhPage(OutboundCheckBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		//List<OutboundCheckBill> list = new ArrayList<OutboundCheckBill>();
		List<OutboundCheckBillVO> list = null;
		String pageNo = request.getParameter("thispage");
		if(mc==null){
			mc = new OutboundCheckBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= outCheckMng.getPageybh(mc,0,Constants.pagesize);
			list= outCheckMng.findOutboundCheckBillByStatus("3",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			//list= outCheckMng.getPageybh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			list= outCheckMng.findOutboundCheckBillByStatus("3",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		//int resultSize = outCheckMng.getTotalCountybh();
		int resultSize = outCheckMng.countOutboundCheckBillByStatus("3");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/outcheck/ybhlist");
	}
	@RequestMapping("/drugState/outcheck/ybhview.html")
	public ModelAndView ybhview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		OutboundCheckBill ch =outCheckMng.findById(id);
		TrtssSalesFormInfo tf = outCheckMng.findxsById(ch.getSalesNumber().toString());
		if(tf!=null && tf.getSqlesFormNo()!=null){
			ch.setSalesNumber(tf.getSqlesFormNo());
		}
		if(ch!=null){
			if("1".equals(ch.getQualitySituation())){
				ch.setQualitySituation("合格");
			}else if("2".equals(ch.getQualitySituation())){
				ch.setQualitySituation("不合格");
			}
		}
		String page = DisplayGetPage.getPageParamName("records", request);
		List<OutboundCheckItem> chIt=new ArrayList<OutboundCheckItem>();
		QualifiedPurchaseUnits qu=new QualifiedPurchaseUnits();
		if(ch.getQualifiedPurchaseUnitsId()!=null && !"".equals(ch.getQualifiedPurchaseUnitsId())){
			qu=acceptanceMng.findgouhuo(ch.getQualifiedPurchaseUnitsId());
		}
		model.addAttribute("qu", qu);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			chIt= outCheckMng.find(ch.getId(),0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			chIt= outCheckMng.find(ch.getId(),(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		
		int resultSize = outCheckMng.findCount(ch.getId());
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("mc", ch);
		model.addAttribute("chIt", chIt);
		return new ModelAndView("drugState/outcheck/ybhview");
	}
	@RequestMapping("/drugState/outcheck/bhback.html")
	public ModelAndView ybhaudit(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		if(id!=null){
			OutboundCheckBill ch =outCheckMng.findById(id);
			ch.setReviewStatus(0L);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			outCheckMng.update(ch);
			logService.addLog("确认驳回出库复核记录", user.getRealname(), "确认驳回", "药品状态管理  >出库复核管理", StringUtil.getIpAddr(request));
		}
		return ybhPage(null, request, response, model);
	}
	@RequestMapping("/drugState/outcheck/findxsd.html")
	public void findxsd(HttpServletRequest request, HttpServletResponse response,Model model){
		// 销售单号  改为销售明细单号 List<TrtssSalesFormInfo> listpu= new ArrayList<TrtssSalesFormInfo>();
		List<String[]> listpu = null;
		//listpu=outCheckMng.findxsJson();
		String requestName = request.getParameter("requestName");
		listpu = outCheckMng.findSaleDetailNO(requestName);
		String json = "[";
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				/*String head = "";
				if(((Object[])listpu.get(i))[1].toString().equals("1001")){
					head="Y";
				}else if(((Object[])listpu.get(i))[1].toString().equals("2001")){
					head="X";
				}else if(((Object[])listpu.get(i))[1].toString().equals("3001")){
					head="S";
				}*/
				if(((Object[])listpu.get(i))[0].toString()!=null && !"".equals(((Object[])listpu.get(i))[0].toString())){
					
					json+="{";
					json+="\"id\":\""+((Object[])listpu.get(i))[0].toString()+"\",";
					json+="\"text\":\""+((Object[])listpu.get(i))[0].toString()+"\"";
					if(i==listpu.size()-1){
						json+="}";
					}else{
						json+="},";
					}
				}
			}
		}
		json+="]";
//		System.out.println(json);
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/drugState/outcheck/findxsmx.html")
	public void findshmx(String id, HttpServletRequest request, HttpServletResponse response, Model model){
		//TrtssSalesFormInfo tf = outCheckMng.findTFById(id);
		TrtssSalesFormInfo tf  = outCheckMng.findSalesFromInfoBySalesItemId(id);//根据销售明细单号查询销售单
		List<TrtssSalesItemsInfo> receItem= outCheckMng.findxsItem(id);
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		List<QualifiedEdit> qus =  new ArrayList<QualifiedEdit>();
		for(int j=0;j<receItem.size();j++){
			QualifiedEdit qu = new QualifiedEdit(); 
			if(tf!=null){
				SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 		String modifyDate = modifyDateFormat.format(tf.getCreaterDate());
		 		qu.setXiaoshouriqi(modifyDate);
		 		QualifiedPurchaseUnits qpu = inspectionMng.findGHSById(tf.getQualifiedPurchaseUnitsId());
		 		if(qpu!=null){
		 			qu.setGouhuodanwei(qpu.getCustomerName());
		 			qu.setGouhuodanweiId(qpu.getId()+"");
		 		}
			}
			TrtssSalesItemsInfo rece = receItem.get(j);
			qu.setBuhegeshu("");
			qu.setBuhegexiang("");
			qu.setHegeshuliang("");
			QualityMidicine qualifiedMedicine =inspectionMng.findHGYP(receItem.get(j).getQualified_medicineId());
			if(rece.getBatchNo()!=null && !"".equals(rece.getBatchNo().toString())){
				qu.setShengchanpihao(rece.getBatchNo());
			}else{
				qu.setShengchanpihao("");
			}
			if(rece.getQuantity()!=null && !"".equals(rece.getQuantity().toString())){
				qu.setShuliang(rece.getQuantity().toString());
			}else{
				qu.setShuliang("");
			}
			if(rece.getQualified_medicineId()!=null){
				qu.setYaopinming(rece.getQualified_medicineId().toString());
			}else{
				qu.setYaopinming("");
			}
			if(qualifiedMedicine.getDosageforms()!=null){
				if(qualifiedMedicine.getDosageforms().getFormName()!=null){
					qu.setJixing(qualifiedMedicine.getDosageforms().getFormName());
				}else{
					qu.setJixing("");
				}
			}else{
				qu.setJixing("");
			}
			if(qualifiedMedicine.getSpecifications()!=null){
				qu.setGuige(qualifiedMedicine.getSpecifications());
			}else{
				qu.setGuige("");
			}
			if(qualifiedMedicine.getProduceno()!=null){
				if(qualifiedMedicine.getProduceno().getCustomerName()!=null){
					qu.setShengchangqiye(qualifiedMedicine.getProduceno().getCustomerName());
				}else{
					qu.setShengchangqiye("");
				}
			}else{
				qu.setShengchangqiye("");
			}
			if(qualifiedMedicine.getRegisteredtrademarkpath()!=null){
				qu.setZhuceshangbiao(qualifiedMedicine.getRegisteredtrademarkpath());
			}else{
				qu.setZhuceshangbiao("");
			}
			if(qualifiedMedicine.getLicensenumber()!=null){
				qu.setPizhunwenhao(qualifiedMedicine.getLicensenumber());
			}else{
				qu.setPizhunwenhao("");
			}
			if(rece.getExpireDate()!=null){
				qu.setYouxiaoqizhi(rece.getExpireDate());
			}else{
				qu.setYouxiaoqizhi("");
			}
			if(tf!=null){
				qu.setSalesFromNumber(tf.getContractNo());
			}
			qu.setHegezheng("");
			qus.add(qu);
		}
		List<String> jsonStringList = new ArrayList<String>();
		
		
		
		for(int i=0;i<receItem.size();i++)
		{
			QualifiedEdit borg = qus.get(i);
			jsonStringList.add(new JSONObject(borg).toString());
		}
		JSONArray jsonArray = new JSONArray(jsonStringList);
		String jsonString = jsonArray.toString();
		model.addAttribute("receItem", jsonString);
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(jsonString);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/drugState/outcheck/saleNoadd.html")
	public ModelAndView saleNoadd(String salesItemNum[], HttpServletRequest request, HttpServletResponse response,Model model){
		
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		String currentDate = DateTimeUtils.getNowStrDate();
		if(salesItemNum!=null && salesItemNum.length>0){
			TrtssSalesFormInfo  salFormInfo =  null;
			List<TrtssSalesItemsInfo> salesItemsInfoList = null;
			for(int i=0,length = salesItemNum.length;i<length;i++){
				 String salesItemNumber = salesItemNum[i];
				 salFormInfo =  outCheckMng.findSalesFromInfoBySalesItemId(salesItemNumber);
				 salesItemsInfoList = outCheckMng.findxsItem(salesItemNumber);
				 OutboundCheckBill  outboundCheckBill = new OutboundCheckBill();
				 if(user!=null){
					 outboundCheckBill.setProposerID(user.getId());
					 outboundCheckBill.setUser(user);
				 }
				 QualifiedPurchaseUnits units = unitsService.get(salFormInfo.getQualifiedPurchaseUnitsId());
				 outboundCheckBill.setQualifiedPurchaseUnits(units);
				 outboundCheckBill.setQualifiedPurchaseUnitsId(salFormInfo.getQualifiedPurchaseUnitsId());
				 outboundCheckBill.setApplicationTime(currentDate);
				 outboundCheckBill.setSalesFromNumber(salFormInfo.getContractNo());
				 outboundCheckBill.setSalesNumber(salesItemNumber);
				 outboundCheckBill.setReviewStatus(1L);
				 outboundCheckBill.setSaleTime(DateTimeUtils.format(salFormInfo.getCreaterDate(), DateTimeUtils.JAVA_DATE_FORMATTER));
				 outboundCheckBill.setQualitySituation("1");
				 outboundCheckBill = outCheckMng.save(outboundCheckBill);
				 for(TrtssSalesItemsInfo ieItemsInfo : salesItemsInfoList){
					 OutboundCheckItem  outcCheckItem = new OutboundCheckItem();
					 QualityMidicine qualityMidicine = midicineMng.get(ieItemsInfo.getQualified_medicineId());
					 outcCheckItem.setBatchNo(ieItemsInfo.getBatchNo());
					 outcCheckItem.setQuantity(ieItemsInfo.getQuantity().longValue());
					 outcCheckItem.setOutboundCheckBillId(outboundCheckBill.getId());
					 if(qualityMidicine!=null){
						 outcCheckItem.setCommonName(qualityMidicine.getCommonname());
						 outcCheckItem.setDosageForms(qualityMidicine.getDosageforms().getFormName());
						 outcCheckItem.setLicenseNumber(qualityMidicine.getLicensenumber());
						 outcCheckItem.setSpecifications(qualityMidicine.getSpecifications());
						 outcCheckItem.setQualityMidicine(qualityMidicine);
					 }
					 outcCheckItem.setQualifiedMedicineId(ieItemsInfo.getQualified_medicineId());
					 outcCheckItem.setValidityTime(ieItemsInfo.getExpireDate());
					 outCheckItemMng.save(outcCheckItem);
					
				 }
				 
			}
			 
			  //salesItemsInfoList = outCheckMng.findxsItem(salesItemNumber);
		}
/*		if(ids!=null && !"".equals(ids)){
			for(int i= 0;i<ids.length;i++){
				TrtssSalesFormInfo tf = outCheckMng.findTFById(ids[i]);
				List<TrtssSalesItemsInfo> receItem= outCheckMng.findxsItem(ids[i]);
				OutboundCheckBill mc = new OutboundCheckBill();
				//OutboundCheckBill ock = null;
				if(tf!=null){
					Date date = new Date();
					SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 		String modifyDate = modifyDateFormat.format(date);
			 		mc.setApplicationTime(modifyDate);
					User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
					mc.setProposerID(user.getId());
					mc.setUser(user);
					mc.setProposerID(user.getId());
					mc.setQualitySituation("1");
					if(tf.getQualifiedPurchaseUnitsId()!=null){
						mc.setQualifiedPurchaseUnitsId(tf.getQualifiedPurchaseUnitsId());
						mc.setQualifiedPurchaseUnits(inspectionMng.findGHSById(mc.getQualifiedPurchaseUnitsId()));
					}
					if(tf.getCreaterDate()!=null){
						
					}
					String saleTime = modifyDateFormat.format(tf.getCreaterDate());
					mc.setSaleTime(saleTime);
					mc.setReviewStatus(0L);
					mc.setReviewTime(modifyDate);
					mc.setSalesNumber(tf.getId().toString());
					mc = outCheckMng.save(mc);
				}
				if(receItem!=null){
					if(receItem.size()>0){
						for(int j=0;j<receItem.size();j++){
							TrtssSalesItemsInfo tff = receItem.get(j);
							OutboundCheckItem qt = new OutboundCheckItem();
							qt.setBatchNo(receItem.get(j).getBatchNo());
							try {
								if(receItem.get(j).getQuantity()!=null){
									//String a[] = receItem.get(j).getQuantity().toString().split(".");
									Long  value = receItem.get(j).getQuantity().longValue();
									qt.setQuantity(value);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							QualityMidicine mq = new QualityMidicine();
							if(tff!=null){
								if(tff.getQualified_medicineId()!=null){
									qt.setQualifiedMedicineId(tff.getQualified_medicineId());
									mq=inspectionMng.findYpById(tff.getQualified_medicineId().toString());
									qt.setQualityMidicine(inspectionMng.findYpById(tff.getQualified_medicineId().toString()));
								}
							}
							qt.setOutboundCheckBillId(mc.getId());
							if(mq.getDosageforms()!=null){
								qt.setDosageForms(mq.getDosageforms().getFormName());
							}
							qt.setLicenseNumber(mq.getLicensenumber());
							qt.setSpecifications(mq.getSpecifications());
							qt.setValidityTime(tff.getExpireDate());
							outCheckItemMng.save(qt);
						}
					}
				}
			}
		}*/
		return dlrPage(null, request, response, model);
	}
	@RequestMapping("/drugState/outcheck/updateAuditedOutCheckBill")
	public String updateAuditedOutCheckBill(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		String  outcheckId = request.getParameter("outcheckId");
		String  qualitySituation = request.getParameter("qualitySituation");
		
		if(outcheckId == null ||  "".equals(outcheckId.trim())){
			outcheckId = "0";
		}
		OutboundCheckBill outCheckBill = outCheckMng.findById(outcheckId);
		if(outCheckBill != null ){
			outCheckBill.setQualitySituation(qualitySituation);
			try{
				outCheckMng.update(outCheckBill);
				UtilJson.print(response, URLEncoder.encode("修改数据成功", "UTF-8"));
			}catch (Exception e) {
				e.printStackTrace();
				UtilJson.print(response, URLEncoder.encode("修改数据成功", "UTF-8"));
				return null;
			}
		}else{
			UtilJson.print(response, URLEncoder.encode("修改数据成功", "UTF-8"));
		}
		return null;
	}
}
