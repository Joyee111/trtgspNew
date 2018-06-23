package com.sinosoft.drugState.recoverycell.action;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.recoverycell.model.RecoverySaleBill;
import com.sinosoft.drugState.recoverycell.model.RecoverySaleBillVO;
import com.sinosoft.drugState.recoverycell.service.RecoveryCellMng;
import com.sinosoft.drugState.stopcell.model.StopSaleBill;
import com.sinosoft.drugState.stopcell.service.StopCellMng;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualifiedmedcstoreMng;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.UnqualifiedmedcstoreMng;

@Controller
public class RecoveryCellAct {

	@Autowired
	private RecoveryCellMng recoveryCellMng;
	
	@Autowired
	private InspectionMng inspectionMng;
	
	@Autowired
	private QualifiedmedcstoreMng qualifiedmedcstoreMng;
	@Autowired
	private UnqualifiedmedcstoreMng unqualifiedmedcstoreMng;
	@Autowired
	private SystemLogService logService;
	@Autowired
	private StopCellMng stopSaleMng;
	
	@RequestMapping("/drugState/recoverycell/dlrlist.html")
	public ModelAndView openFramePage(HttpServletRequest request, HttpServletResponse response, Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		RecoverySaleBill mc = new RecoverySaleBill();
		String ypname = request.getParameter("ypname");
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
//		List<RecoverySaleBill> reslist=new ArrayList<RecoverySaleBill>();
		List<RecoverySaleBillVO> reslist=null;
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//reslist= recoveryCellMng.getPage(mc,0,Constants.pagesize);
			reslist= recoveryCellMng.getRecoverCellByCondication(ypname, "0",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
//			reslist= recoveryCellMng.getPage(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			reslist= recoveryCellMng.getRecoverCellByCondication(ypname, "0",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
//		int resultSize = recoveryCellMng.getTotalCount(mc);
		int resultSize = recoveryCellMng.countRecoverCellByCondication(ypname, "0");
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("drugState/recoverycell/dlrlist");
	}
	@RequestMapping("/drugState/recoverycell/dlradd.html")
	public ModelAndView dlradd(HttpServletRequest request, HttpServletResponse response, Model model){
		Map<String, String> quamap= inspectionMng.qmMaps();
		model.addAttribute("quamap", quamap);
		Map<String, String> qsmap= inspectionMng.gonghuoMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("drugState/recoverycell/dlradd");
		
	}
	@RequestMapping("/drugState/recoverycell/dlrsave.html")
	public ModelAndView dlrsave(RecoverySaleBill st,HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException{
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
		RecoverySaleBill bill=recoveryCellMng.save(st);
		logService.addLog("新增恢复销售记录", user.getRealname(), "新增", "药品状态管理  >恢复销售管理", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/recoverycell/dlredit.html")
	public ModelAndView dshedit(RecoverySaleBill mc,String id, HttpServletRequest request, HttpServletResponse response,Model model){
		Map<String, String> quamap= inspectionMng.qmMaps();
		model.addAttribute("quamap", quamap);
		RecoverySaleBill mcs=recoveryCellMng.findById(id);
		model.addAttribute("mc", mcs);
		QualityMidicine qm = inspectionMng.findHGYP(mcs.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		return new ModelAndView("drugState/recoverycell/dlredit");
	}
	
	@RequestMapping("/drugState/recoverycell/dlrupdate.html")
	public ModelAndView dshupdate(RecoverySaleBill mc,String counts,String submitType, HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
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
		recoveryCellMng.update(mc);
		logService.addLog("修改恢复销售记录", user.getRealname(), "修改", "药品状态管理  >恢复销售管理", StringUtil.getIpAddr(request));
		model.addAttribute("thispage", thispage);
		model.addAttribute("mc", mc);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/recoverycell/dlrdel.html")
	public ModelAndView deldlr(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		if(ids!=null && !"".equals(ids)){
			for(int i= 0;i<ids.length;i++){
				recoveryCellMng.del(ids[i]);
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除恢复销售记录", user.getRealname(), "删除", "药品状态管理  >恢复销售管理", StringUtil.getIpAddr(request));
		return openFramePage(request, response, model);
	}
	/**
	 * 待审核
	 * **/
	@RequestMapping("/drugState/recoverycell/dshlist.html")
	public ModelAndView dshPage(RecoverySaleBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		//List<RecoverySaleBill> list = new ArrayList<RecoverySaleBill>();
		List<RecoverySaleBillVO> list = null;
		String ypname = request.getParameter("ypname");
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(mc==null){
			mc= new RecoverySaleBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= recoveryCellMng.getPagedsh(mc,0,Constants.pagesize);
			list= recoveryCellMng.getRecoverCellByCondication(ypname, "1",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
//			list= recoveryCellMng.getPagedsh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			list= recoveryCellMng.getRecoverCellByCondication(ypname, "1",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
//		int resultSize = recoveryCellMng.getTotalCountDsh(mc);
		int resultSize = recoveryCellMng.countRecoverCellByCondication(ypname, "1");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/recoverycell/dshlist");
	}
	
	@RequestMapping("/drugState/recoverycell/dshview.html")
	public ModelAndView dshview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		RecoverySaleBill ch =recoveryCellMng.findById(id);
		QualityMidicine  qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		model.addAttribute("mc", ch);
		return new ModelAndView("drugState/recoverycell/dshview");
	}	
	@RequestMapping("/drugState/recoverycell/audit.html")
	public ModelAndView audit(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		String batch_type=request.getParameter("batch_type");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		if(ids!=null && !"".equals(ids)){
			if("0".equals(batch_type)){
				for(int i =0;i<ids.length;i++){
					RecoverySaleBill ch =recoveryCellMng.findById(ids[i]);
					ch.setReviewStatus(2L);
					Date date = new Date();
					SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 		String modifyDate = modifyDateFormat.format(date);
			 		ch.setReviewTime(modifyDate);
					User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
					ch.setAuditorID(user.getId());
//					QualityMidicine qm = new QualityMidicine();
//					if(ch.getQualifiedMedicineId()!=null){
//						qm = qualityMidicineMng.findById(ch.getQualifiedMedicineId().toString());
//					}
//					if(qm!=null){
//						qm.setUseflag(0);
//						qualityMidicineMng.updata(qm);
//					}
					recoveryCellMng.update(ch);
					Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(ch.getBatchProduction());
					Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(ch.getBatchProduction());
						if(unqu!=null){
							if(ch.getQuantity()!=null){
								unqu.setQuantity(unqu.getQuantity()-Long.parseLong(ch.getQuantity()));
								QualityMidicine qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
								unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
							}
						}
						if(qu!=null){
							qu.setQuantity(qu.getQuantity()+Long.parseLong(ch.getQuantity()));
							QualityMidicine qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
							qu.setQualityMidicine(qm);
							qualifiedmedcstoreMng.updatequ(qu);
						}
					}
			}else if("1".equals(batch_type)){
				for(int i =0;i<ids.length;i++){
					RecoverySaleBill ch =recoveryCellMng.findById(ids[i]);
					ch.setReviewStatus(3L);
					Date date = new Date();
					SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 		String modifyDate = modifyDateFormat.format(date);
			 		ch.setReviewTime(modifyDate);
					User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
					ch.setAuditorID(user.getId());
					recoveryCellMng.update(ch);
				}
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("审核恢复销售记录", user.getRealname(), "审核", "药品状态管理  >恢复销售管理", StringUtil.getIpAddr(request));
		return dshPage(null, request, response, model);
	}
	@RequestMapping("/drugState/recoverycell/shviewcheck.html")
	public ModelAndView auditOne(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		String type=request.getParameter("types");
		if(id!=null){
			RecoverySaleBill ch =recoveryCellMng.findById(id);
			ch.setReviewStatus(Long.parseLong(type));
			recoveryCellMng.update(ch);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(ch.getBatchProduction());
			Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(ch.getBatchProduction());
			if("2".equals(type)){
				if(unqu!=null){
					if(ch.getQuantity()!=null){
						unqu.setQuantity(unqu.getQuantity()-Long.parseLong(ch.getQuantity()));
						QualityMidicine qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
						unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
					}
				}
				if(qu!=null){
					qu.setQuantity(qu.getQuantity()+Long.parseLong(ch.getQuantity()));
					QualityMidicine qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
					qu.setQualityMidicine(qm);
					qualifiedmedcstoreMng.updatequ(qu);
				}
//				QualityMidicine qm = qualityMidicineMng.findById(ch.getQualifiedMedicineId().toString());
//				if(qm!=null){
//					qm.setUseflag(0);
//					qualityMidicineMng.updata(qm);
//				}
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("审核恢复销售记录", user.getRealname(), "审核", "药品状态管理  >恢复销售管理", StringUtil.getIpAddr(request));
		return dshPage(null, request, response, model);
	}
	/**
	 * 
	 * 已审核
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/recoverycell/yshlist.html")
	public ModelAndView yshPage(RecoverySaleBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		//List<RecoverySaleBill> list = new ArrayList<RecoverySaleBill>();
		List<RecoverySaleBillVO> list = null;
		String ypname = request.getParameter("ypname");
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(mc==null){
			mc= new RecoverySaleBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= recoveryCellMng.getPageysh(mc,0,Constants.pagesize);
			list= recoveryCellMng.getRecoverCellByCondication(ypname, "2",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
//			list= recoveryCellMng.getPageysh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			list= recoveryCellMng.getRecoverCellByCondication(ypname, "2",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
//		int resultSize = recoveryCellMng.getTotalCountysh(mc);
		int resultSize = recoveryCellMng.countRecoverCellByCondication(ypname, "2");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/recoverycell/yshlist");
	}
	@RequestMapping("/drugState/recoverycell/yshview.html")
	public ModelAndView yshviewlist(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		RecoverySaleBill ch =recoveryCellMng.findById(id);
		QualityMidicine  qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		model.addAttribute("mc", ch);
		return new ModelAndView("drugState/recoverycell/yshview");
	}	
	
	@RequestMapping("/drugState/recoverycell/backcheck.html")
	public ModelAndView yshback(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		if(id!=null&& !"".equals(id)){
			RecoverySaleBill ch =recoveryCellMng.findById(id);
			ch.setReviewStatus(3L);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(ch.getBatchProduction());
			Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(ch.getBatchProduction());
			if(unqu!=null){
				if(ch.getQuantity()!=null && qu.getQuantity()!=null){
					unqu.setQuantity(unqu.getQuantity()+Long.parseLong(ch.getQuantity()));
				}
				unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
			}
			if(qu!=null&& ch!=null){
				qu.setQuantity(qu.getQuantity()-Long.parseLong(ch.getQuantity()));
				qualifiedmedcstoreMng.updatequ(qu);
			}
			recoveryCellMng.update(ch);
		}
		return yshPage(null, request, response, model);
	}
	
	
	
	
	/**
	 * 
	 * 已驳回
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/recoverycell/ybhlist.html")
	public ModelAndView ybhPage(RecoverySaleBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
//		List<RecoverySaleBill> list = new ArrayList<RecoverySaleBill>();
		List<RecoverySaleBillVO> list = null;
		String ypname = request.getParameter("ypname");
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(mc==null){
			mc= new RecoverySaleBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= recoveryCellMng.getPageybh(mc,0,Constants.pagesize);
			list= recoveryCellMng.getRecoverCellByCondication(ypname, "3", 0,Constants.pagesize);
		}
		else{
			//否者翻页查询
//			list= recoveryCellMng.getPageybh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			list= recoveryCellMng.getRecoverCellByCondication(ypname, "3", (Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
//		int resultSize = recoveryCellMng.getTotalCountybh(mc);
		int resultSize = recoveryCellMng.countRecoverCellByCondication(ypname, "3");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/recoverycell/ybhlist");
	}
	@RequestMapping("/drugState/recoverycell/ybhview.html")
	public ModelAndView ybhview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		RecoverySaleBill ch =recoveryCellMng.findById(id);
		QualityMidicine  qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		model.addAttribute("mc", ch);
		return new ModelAndView("drugState/recoverycell/ybhview");
	}
	@RequestMapping("/drugState/recoverycell/bhback.html")
	public ModelAndView ybhaudit(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		if(id!=null){
			RecoverySaleBill ch =recoveryCellMng.findById(id);
			ch.setReviewStatus(0L);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			recoveryCellMng.update(ch);
			logService.addLog("驳回确认恢复销售记录", user.getRealname(), "驳回确认", "药品状态管理  >恢复销售管理", StringUtil.getIpAddr(request));
		}
		return ybhPage(null, request, response, model);
	}
	
	@RequestMapping("/drugState/recoverycell/findypboxqy.html")
	public void findypbox(HttpServletRequest request, HttpServletResponse response, Model model){
		List<QualityMidicine> listpu= new ArrayList<QualityMidicine>();
		//封装采购单json
		listpu=recoveryCellMng.findypJsonqy();
		String json = "[";
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				if(listpu.get(i).getCommonname()!=null && !"".equals(listpu.get(i).getCommonname())){
					json+="{";
					json+="\"id\":"+listpu.get(i).getId()+",";
					json+="\"text\":\""+"("+listpu.get(i).getMedicinalNo()+")"+listpu.get(i).getCommonname()+"\"";
					if(i==listpu.size()-1){
						json+="}";
					}else{
						json+="},";
					}
				}
			}
		}
		if(json.endsWith(",")){
			json = json.substring(0,json.length()-1);
		}
		json+="]";
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/drugState/recoverycell/findypboxbyid.html")
	public void findypboxbyid(String id,HttpServletRequest request, HttpServletResponse response, Model model){
		
		/* 根据药品id查询不合格药品库的数据用于恢复销售，暂时弃用，因为暂时停售的药品并未进入不合格药品库
		List<Unqualifiedmedcstore> listpu= new ArrayList<Unqualifiedmedcstore>();
		//封装采购单json
		listpu=recoveryCellMng.findypJsonqyById(id);
		String json = "[";
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				if(listpu.get(i).getBatchproduction()!=null && !"".equals(listpu.get(i).getBatchproduction())){
					json+="{";
					json+="\"id\":\""+listpu.get(i).getBatchproduction()+"_"+listpu.get(i).getQuantity()+"\",";
					json+="\"text\":\""+listpu.get(i).getBatchproduction()+"\"";
					if(i==listpu.size()-1){
						json+="}";
					}else{
						json+="},";
					}
				}
			}
		}
		json+="]";
		*/
		List<StopSaleBill> listpu= new ArrayList<StopSaleBill>();
		//封装采购单json
		listpu=stopSaleMng.findStopSaleById(id);
		String json = "[";
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				if(listpu.get(i).getBatchProduction()!=null && !"".equals(listpu.get(i).getBatchProduction())){
					json+="{";
					json+="\"id\":\""+listpu.get(i).getBatchProduction()+"_"+listpu.get(i).getQuantity()+"\",";
					json+="\"text\":\""+listpu.get(i).getBatchProduction()+"\"";
					if(i==listpu.size()-1){
						json+="}";
					}else{
						json+="},";
					}
				}
			}
		}
		json+="]";
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
