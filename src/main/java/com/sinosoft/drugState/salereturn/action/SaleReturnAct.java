package com.sinosoft.drugState.salereturn.action;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.salereturn.model.SaleReturnBill;
import com.sinosoft.drugState.salereturn.service.SaleReturnMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

@Controller
public class SaleReturnAct {
	@Autowired
	private SaleReturnMng saleReturnMng;
	
	@Autowired
	private InspectionMng inspectionMng;
	
	@RequestMapping("/drugState/salereturn/dlrlist.html")
	public ModelAndView openFramePage(HttpServletRequest request, HttpServletResponse response, Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		SaleReturnBill mc = new SaleReturnBill();
		String yhDate = request.getParameter("yhdate");
		String ypname = request.getParameter("ypname");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setNumber(yhDate);
		}
		String pageNo = request.getParameter("thispage");
		List<SaleReturnBill> reslist=new ArrayList<SaleReturnBill>();
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			reslist= saleReturnMng.getPage(mc,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			reslist= saleReturnMng.getPage(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = saleReturnMng.getTotalCount(mc);
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("drugState/salereturn/dlrlist");
	}
	@RequestMapping("/drugState/salereturn/dlradd.html")
	public ModelAndView dlradd(HttpServletRequest request, HttpServletResponse response, Model model){
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> qsmap= inspectionMng.gouhuoMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("drugState/salereturn/dlradd");
		
	}
	@RequestMapping("/drugState/salereturn/dlrsave.html")
	public ModelAndView dlrsave(SaleReturnBill st,HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("submitType");
		st.setReviewStatus(Long.parseLong(type));
		Date dae = new Date();
//		st.setApplicationTime(dae.toString());
		Date date = new Date();
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		String modifyDate = modifyDateFormat.format(date);
 		st.setApplicationTime(modifyDate);
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		st.setProposerID(user.getId());
		st.setUser(user);
		if(st.getQualifiedPurchaseUnitsId()!=null){
			try {
				st.setQualifiedPurchaseUnits(inspectionMng.findGHSById(st.getQualifiedPurchaseUnitsId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(st.getQualifiedMedicineId()!=null){
			try {
				st.setQualityMidicine(inspectionMng.findHGYP(st.getQualifiedMedicineId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		SaleReturnBill bill=saleReturnMng.save(st);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/salereturn/dlredit.html")
	public ModelAndView dshedit(SaleReturnBill mc,String id, HttpServletRequest request, HttpServletResponse response,Model model){
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> qsmap= inspectionMng.gouhuoMap();
		model.addAttribute("qsmap", qsmap);
		SaleReturnBill mcs=saleReturnMng.findById(id);
		model.addAttribute("returnType", mcs.getReturnType());
		model.addAttribute("mc", mcs);
		QualityMidicine qm = inspectionMng.findHGYP(mcs.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		model.addAttribute("gouhuoshang", mcs.getQualifiedPurchaseUnits().getCustomerName());
		return new ModelAndView("drugState/salereturn/dlredit");
	}
	
	@RequestMapping("/drugState/salereturn/dlrupdate.html")
	public ModelAndView dshupdate(SaleReturnBill mc,String counts,String submitType, HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String thispage=request.getParameter("thispage");
		String type = request.getParameter("submitType");
		if("1".equals(submitType)){
			mc.setReviewStatus(1L);
		}else{
			mc.setReviewStatus(0L);
		}
		Date date = new Date();
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		String modifyDate = modifyDateFormat.format(date);
 		mc.setApplicationTime(modifyDate);
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		mc.setProposerID(user.getId());
		mc.setUser(user);
		if(mc.getQualifiedPurchaseUnitsId()!=null){
			try {
				mc.setQualifiedPurchaseUnits(inspectionMng.findGHSById(mc.getQualifiedPurchaseUnitsId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(mc.getQualifiedMedicineId()!=null){
			try {
				mc.setQualityMidicine(inspectionMng.findHGYP(mc.getQualifiedMedicineId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		saleReturnMng.update(mc);
		model.addAttribute("thispage", thispage);
		model.addAttribute("mc", mc);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/salereturn/dlrdel.html")
	public ModelAndView deldlr(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		if(ids!=null && !"".equals(ids)){
			for(int i= 0;i<ids.length;i++){
				saleReturnMng.del(ids[i]);
			}
		}
		return openFramePage(request, response, model);
	}
	/**
	 * 待审核
	 * **/
	@RequestMapping("/drugState/salereturn/dshlist.html")
	public ModelAndView dshPage(SaleReturnBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<SaleReturnBill> list = new ArrayList<SaleReturnBill>();
		String pageNo = request.getParameter("thispage");
		String yhDate = request.getParameter("yhdate");
		String ypname = request.getParameter("ypname");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setNumber(yhDate);
		}
		if(mc==null){
			mc = new SaleReturnBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= saleReturnMng.getPagedsh(mc,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= saleReturnMng.getPagedsh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = saleReturnMng.getTotalCountDsh(mc);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/salereturn/dshlist");
	}
	
	@RequestMapping("/drugState/salereturn/dshview.html")
	public ModelAndView dshview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		SaleReturnBill ch =saleReturnMng.findById(id);
		QualityMidicine  qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		model.addAttribute("mc", ch);
		/**
		 * 购货商
		 * */
		QualifiedPurchaseUnits qs = saleReturnMng.findghById(ch.getQualifiedPurchaseUnitsId());
		model.addAttribute("qs", qs);
		return new ModelAndView("drugState/salereturn/dshview");
	}	
	@RequestMapping("/drugState/salereturn/audit.html")
	public ModelAndView audit(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		String batch_type=request.getParameter("batch_type");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		if(ids!=null && !"".equals(ids)){
			if("0".equals(batch_type)){
				for(int i =0;i<ids.length;i++){
					SaleReturnBill ch =saleReturnMng.findById(ids[i]);
					ch.setReviewStatus(2L);
					Date date = new Date();
					SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 		String modifyDate = modifyDateFormat.format(date);
			 		ch.setReviewTime(modifyDate);
					User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
					ch.setAuditorID(user.getId());
					saleReturnMng.update(ch);
				}
			}else if("1".equals(batch_type)){
				for(int i =0;i<ids.length;i++){
					SaleReturnBill ch =saleReturnMng.findById(ids[i]);
					ch.setReviewStatus(3L);
					Date date = new Date();
					SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 		String modifyDate = modifyDateFormat.format(date);
			 		ch.setReviewTime(modifyDate);
					User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
					ch.setAuditorID(user.getId());
					saleReturnMng.update(ch);
				}
		}
		}
		return dshPage(null, request, response, model);
	}
	@RequestMapping("/drugState/salereturn/shviewcheck.html")
	public ModelAndView auditOne(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		String type=request.getParameter("types");
		if(id!=null){
			SaleReturnBill ch =saleReturnMng.findById(id);
			ch.setReviewStatus(Long.parseLong(type));
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			saleReturnMng.update(ch);
		}
		return dshPage(null, request, response, model);
	}
	/**
	 * 
	 * 已审核
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/salereturn/yshlist.html")
	public ModelAndView yshPage(SaleReturnBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<SaleReturnBill> list = new ArrayList<SaleReturnBill>();
		String yhDate = request.getParameter("yhdate");
		String ypname = request.getParameter("ypname");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setNumber(yhDate);
		}
		if(mc==null){
			mc = new SaleReturnBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= saleReturnMng.getPageysh(mc,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= saleReturnMng.getPageysh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = saleReturnMng.getTotalCountysh(mc);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/salereturn/yshlist");
	}
	@RequestMapping("/drugState/salereturn/yshview.html")
	public ModelAndView yshviewlist(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		SaleReturnBill ch =saleReturnMng.findById(id);
		QualityMidicine  qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		model.addAttribute("mc", ch);
		/**
		 * 购货商
		 * */
		QualifiedPurchaseUnits qs = saleReturnMng.findghById(ch.getQualifiedPurchaseUnitsId());
		model.addAttribute("qs", qs);
		return new ModelAndView("drugState/salereturn/yshview");
	}	
	@RequestMapping("/drugState/salereturn/backcheck.html")
	public ModelAndView yshcheck(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		if(id!=null&&!"".equals(id)){
			SaleReturnBill ch =saleReturnMng.findById(id);
			ch.setReviewStatus(3L);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			saleReturnMng.update(ch);
		}
		return yshPage(null, request, response, model);
	}
	
	
	
	
	/**
	 * 
	 * 已驳回
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/salereturn/ybhlist.html")
	public ModelAndView ybhPage(SaleReturnBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<SaleReturnBill> list = new ArrayList<SaleReturnBill>();
		String yhDate = request.getParameter("yhdate");
		String ypname = request.getParameter("ypname");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setNumber(yhDate);
		}
		if(mc==null){
			mc = new SaleReturnBill();
		}
		String pageNo = request.getParameter("thispage");
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= saleReturnMng.getPageybh(mc,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= saleReturnMng.getPageybh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = saleReturnMng.getTotalCountybh(mc);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/salereturn/ybhlist");
	}
	@RequestMapping("/drugState/salereturn/ybhview.html")
	public ModelAndView ybhview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		SaleReturnBill ch =saleReturnMng.findById(id);
		QualityMidicine  qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		model.addAttribute("mc", ch);
		/**
		 * 购货商
		 * */
		QualifiedPurchaseUnits qs = saleReturnMng.findghById(ch.getQualifiedPurchaseUnitsId());
		model.addAttribute("qs", qs);
		return new ModelAndView("drugState/salereturn/ybhview");
	}
	@RequestMapping("/drugState/salereturn/bhback.html")
	public ModelAndView ybhaudit(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		if(id!=null){
			SaleReturnBill ch =saleReturnMng.findById(id);
			ch.setReviewStatus(0L);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			saleReturnMng.update(ch);
		}
		return ybhPage(null, request, response, model);
	}

}
