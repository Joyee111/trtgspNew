package com.sinosoft.drugState.stopcell.action;

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
import com.sinosoft.drugState.stopcell.model.StopSaleBill;
import com.sinosoft.drugState.stopcell.model.StopSaleBillVO;
import com.sinosoft.drugState.stopcell.service.StopCellMng;
import com.sinosoft.ireportDTO.StopSellingOrderDto;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;
import com.sinosoft.qualityRecords.unqualifiedManger.service.UnqualifiedManagerMng;
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
public class StopCellAct {
	@Autowired
	private StopCellMng stopCellMng;
	
	@Autowired
	private InspectionMng inspectionMng;
	
	@Autowired
	private QualifiedmedcstoreMng qualifiedmedcstoreMng;
	@Autowired
	private UnqualifiedmedcstoreMng unqualifiedmedcstoreMng;
	
	@Autowired
	private UnqualifiedManagerMng  unqualifiedManagerMng;
	@Autowired
	private SystemLogService logService;

	
	@RequestMapping("/drugState/stopcell/dlrlist.html")
	public ModelAndView openFramePage(HttpServletRequest request, HttpServletResponse response, Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		StopSaleBill mc = new StopSaleBill();
		String ypname = request.getParameter("ypname");
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		//List<StopSaleBill> reslist=new ArrayList<StopSaleBill>();
		List<StopSaleBillVO> reslist = null;
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//reslist= stopCellMng.getPage(mc,0,Constants.pagesize);
			reslist= stopCellMng.getPage(ypname,"0",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			//reslist= stopCellMng.getPage(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			reslist= stopCellMng.getPage(ypname,"0",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
//		int resultSize = stopCellMng.getTotalCount(mc);
		int resultSize = stopCellMng.countStopSaleBillByStatus(ypname, "0");
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("drugState/stopcell/dlrlist");
	}
	@RequestMapping("/drugState/stopcell/dlradd.html")
	public ModelAndView dlradd(HttpServletRequest request, HttpServletResponse response, Model model){
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> qsmap= inspectionMng.gonghuoMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("drugState/stopcell/dlradd");
		
	}
	@RequestMapping("/drugState/stopcell/dlrsave.html")
	public ModelAndView dlrsave(StopSaleBill st,HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("submitType");
		st.setReviewStatus(Long.parseLong(type));
		Date date = new Date();
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		String modifyDate = modifyDateFormat.format(date);
 		st.setApplicationTime(modifyDate);
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		st.setProposerID(user.getId());
		st.setUser(user);
		StopSaleBill bill=stopCellMng.save(st);
		logService.addLog("新增停售管理记录", user.getRealname(), "新增", "药品状态管理  >停售管理", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		/*if(type.equals("1") && !bill.getTempStopStatus().equals("1")){//控制当前停售的流程,暂时停售的药品不进入不合格药品库
		//Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(bill.getBatchProduction());//不合格药品库
		Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(bill.getBatchProduction());//合格药品库
				if(bill.getQuantity()!=null ){//当数量不为空
					if(qu != null ){
						if(qu.getQuantity() > bill.getQuantity()){
							qu.setQuantity(qu.getQuantity()-bill.getQuantity());
							qualifiedmedcstoreMng.updatequ(qu);
						}else{
							map.put("success",URLEncoder.encode("库存不足！", "UTF-8"));
							UtilJson.printMapJson(response, map);
							return null;
						}
					}
					
					if(unqu != null){
						unqu.setQuantity(unqu.getQuantity()+bill.getQuantity());
						unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
					}else {
						unqu = new Unqualifiedmedcstore();
						unqu.setBatchproduction(bill.getBatchProduction());//生产批号
						unqu.setQualifiedmedicineid(bill.getQualifiedMedicineId());//合格药品id
						unqu.setQuantity(bill.getQuantity());//数量
						unqu.setStatus("0");//全部的数量都已经为不合格，此时该药品就不能再生成不合格记录
						unqu.setValiddate(qu.getValiddate());//有效期
						unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
					}
					
					
				}
			}*/
		map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/stopcell/dlredit.html")
	public ModelAndView dshedit(StopSaleBill mc,String id, HttpServletRequest request, HttpServletResponse response,Model model){
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		StopSaleBill mcs=stopCellMng.findById(id);
		model.addAttribute("mc", mcs);
		QualityMidicine qm = inspectionMng.findHGYP(mcs.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		return new ModelAndView("drugState/stopcell/dlredit");
	}
	
	@RequestMapping("/drugState/stopcell/dlrupdate.html")
	public ModelAndView dshupdate(StopSaleBill mc,String counts,String submitType, HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String thispage=request.getParameter("thispage");
		String type = request.getParameter("submitType");
		String tempStopStatue = request.getParameter("tempStopStatus");
		mc.setTempStopStatus(Long.parseLong(tempStopStatue));
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
		stopCellMng.update(mc);
		logService.addLog("修改停售管理记录", user.getRealname(), "修改", "药品状态管理  >停售管理", StringUtil.getIpAddr(request));
		model.addAttribute("thispage", thispage);
		model.addAttribute("mc", mc);
		Map<String, Object> map = new HashMap<String, Object>();
		/*if(type.equals("1")){
		Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(mc.getBatchProduction());
		Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(mc.getBatchProduction());
				if(mc.getQuantity()!=null ){
					if(qu != null ){
						if(qu.getQuantity() > mc.getQuantity()){
							qu.setQuantity(qu.getQuantity()-mc.getQuantity());
							qualifiedmedcstoreMng.updatequ(qu);
						}else{
							map.put("success",URLEncoder.encode("库存不足！", "UTF-8"));
							UtilJson.printMapJson(response, map);
							return null;
						}
					}
					if(unqu != null){
						unqu.setQuantity(unqu.getQuantity()+mc.getQuantity());
						unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
					}else {
						unqu = new Unqualifiedmedcstore();
						unqu.setBatchproduction(mc.getBatchProduction());
						unqu.setQualifiedmedicineid(mc.getQualifiedMedicineId());
						unqu.setQuantity(mc.getQuantity());
						unqu.setStatus("0");
						unqu.setValiddate(qu.getValiddate());
						unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
				}
			}
		}*/
		//Map<String, Object> map = new HashMap<String, Object>();
		map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/stopcell/dlrdel.html")
	public ModelAndView deldlr(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		if(ids!=null && !"".equals(ids)){
			for(int i= 0;i<ids.length;i++){
				stopCellMng.del(ids[i]);
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除停售管理记录", user.getRealname(), "删除", "药品状态管理  >停售管理", StringUtil.getIpAddr(request));
		return openFramePage(request, response, model);
	}
	/**
	 * 待审核
	 * **/
	@RequestMapping("/drugState/stopcell/dshlist.html")
	public ModelAndView dshPage(StopSaleBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<StopSaleBillVO> list = null;
		String ypname = request.getParameter("ypname");
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(mc==null){
			mc=new StopSaleBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= stopCellMng.getPage(ypname,"1",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= stopCellMng.getPage(ypname,"1",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
//		int resultSize = stopCellMng.getTotalCountDsh(mc);
		int resultSize = stopCellMng.countStopSaleBillByStatus(ypname, "1");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/stopcell/dshlist");
	}
	
	@RequestMapping("/drugState/stopcell/dshview.html")
	public ModelAndView dshview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		StopSaleBill ch =stopCellMng.findById(id);
		QualityMidicine  qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		model.addAttribute("mc", ch);
		return new ModelAndView("drugState/stopcell/dshview");
	}	
	@RequestMapping("/drugState/stopcell/audit.html")
	public ModelAndView audit(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		String batch_type=request.getParameter("batch_type");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		if(ids!=null && !"".equals(ids)){
			if("0".equals(batch_type)){
				for(int i =0;i<ids.length;i++){
					StopSaleBill ch =stopCellMng.findById(ids[i]);
					ch.setReviewStatus(2L);
					Date date = new Date();
					SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 		String modifyDate = modifyDateFormat.format(date);
			 		ch.setReviewTime(modifyDate);
					User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
					ch.setAuditorID(user.getId());
					stopCellMng.update(ch);
					//Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(ch.getBatchProduction());
					//if(unqu != null){
					//	unqu.setStatus("1");
					//	unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
					//}
				}
				
			}else if("1".equals(batch_type)){
				for(int i =0;i<ids.length;i++){
					StopSaleBill ch =stopCellMng.findById(ids[i]);
					ch.setReviewStatus(3L);
					Date date = new Date();
					SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 		String modifyDate = modifyDateFormat.format(date);
			 		ch.setReviewTime(modifyDate);
					User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
					ch.setAuditorID(user.getId());
					stopCellMng.update(ch);
					//Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(ch.getBatchProduction());
					//Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(ch.getBatchProduction());
					//	if(unqu!=null){
					//		if(ch.getQuantity()!=null){
					//			unqu.setQuantity(unqu.getQuantity()-ch.getQuantity());
					//			unqu.setStatus("0");
					//			unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
					//		}
					//	}
					//	if(qu!=null){
					//		qu.setQuantity(qu.getQuantity()+ch.getQuantity());
					//		qualifiedmedcstoreMng.updatequ(qu);
					//	}
					}
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("审核停售管理记录", user.getRealname(), "审核", "药品状态管理  >停售管理", StringUtil.getIpAddr(request));
		return dshPage(null, request, response, model);
	}
	@RequestMapping("/drugState/stopcell/shviewcheck.html")
	public ModelAndView auditOne(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		String type=request.getParameter("types");
		if(id!=null){
			StopSaleBill ch =stopCellMng.findById(id);
			ch.setReviewStatus(Long.parseLong(type));
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			stopCellMng.update(ch);
			//Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(ch.getBatchProduction());
			//Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(ch.getBatchProduction());
			if("3".equals(type)){//驳回
				/*if(qu!=null){
					if(ch.getQuantity()!=null){
						qu.setQuantity(qu.getQuantity()+ch.getQuantity());
						qualifiedmedcstoreMng.updatequ(qu);
					}
				}
				if(unqu!=null){
					if(ch.getQuantity()!=null){
						unqu.setQuantity(unqu.getQuantity()-ch.getQuantity());
						unqu.setStatus("0");
						unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
					}
				}*/
				
			}else if("2".equals(type)){//通过
				if(ch.getQuantity()!=null){
					//unqu.setQuantity(unqu.getQuantity()-ch.getQuantity());
					
//					System.out.println("ch.getTempStopStatus()");
					/*if(ch.getTempStopStatus()==1){//暂时停售状态 0取消暂时停售  1暂时停售
						unqu.setStatus("0");////0表示不能生成不合格品记录、1、表示可以生成不合格品记录
					}else{
						unqu.setStatus("1");
					}*/
					
					
					//unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
				}
			}
			
//			if("2".equals(type)){
//				QualityMidicine qm = qualityMidicineMng.findById(ch.getQualifiedMedicineId().toString());
//				if(qm!=null){
//					qm.setUseflag(1);
//					qualityMidicineMng.updata(qm);
//				}
//			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("审核停售管理记录", user.getRealname(), "审核", "药品状态管理  >停售管理", StringUtil.getIpAddr(request));
		return dshPage(null, request, response, model);
	}
	
	
	/**
	 * 
	 * 已审核
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/stopcell/yshlist.html")
	public ModelAndView yshPage(StopSaleBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
//		List<StopSaleBill> list = new ArrayList<StopSaleBill>();
		List<StopSaleBillVO> list = null;
		String ypname = request.getParameter("ypname");
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(mc==null){
			mc=new StopSaleBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= stopCellMng.getPageysh(mc,0,Constants.pagesize);
			list= stopCellMng.getPage(ypname,"2",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
//			list= stopCellMng.getPageysh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			list= stopCellMng.getPage(ypname,"2",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
//		int resultSize = stopCellMng.getTotalCountysh(mc);
		int resultSize = stopCellMng.countStopSaleBillByStatus(ypname, "2");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/stopcell/yshlist");
	}
	@RequestMapping("/drugState/stopcell/printStopCell.html")
	public String printStopBill(Model model ,HttpServletRequest request,HttpServletResponse response){
		String checkReturnId = request.getParameter("checkReturnId");
		StopSaleBillVO stopBIllVO = stopCellMng.getStopSaleBillVOById(checkReturnId);
		List<StopSellingOrderDto> datoList = new ArrayList<StopSellingOrderDto>();
		datoList.add(new StopSellingOrderDto(stopBIllVO));
		model.addAttribute("reportDtos",datoList );
		return "drugState/stopcell/printStopCell";
	}
	@RequestMapping("/drugState/stopcell/yshview.html")
	public ModelAndView yshviewlist(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		StopSaleBill ch =stopCellMng.findById(id);
		QualityMidicine  qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		model.addAttribute("mc", ch);
		return new ModelAndView("drugState/stopcell/yshview");
	}	
	@RequestMapping("/drugState/stopcell/bachcheck.html")
	public ModelAndView yshback(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		if(id!=null&&!"".equals(id)){
			StopSaleBill ch =stopCellMng.findById(id);
			ch.setReviewStatus(3L);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			//Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(ch.getBatchProduction());
			//Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(ch.getBatchProduction());
			/*if(unqu!=null){
				if(ch.getQuantity()!=null && qu.getQuantity()!=null){
					unqu.setQuantity(unqu.getQuantity()-ch.getQuantity());
				}
				unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
			}*/
			/*
			if(qu!=null&& ch!=null){
				qu.setQuantity(qu.getQuantity()+ch.getQuantity());
				qualifiedmedcstoreMng.updatequ(qu);
			}*/
			stopCellMng.update(ch);
		}
		return yshPage(null, request, response, model);
	}
	
	/**
	 * 
	 * 已驳回
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/stopcell/ybhlist.html")
	public ModelAndView ybhPage(StopSaleBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
//		List<StopSaleBill> list = new ArrayList<StopSaleBill>();
		List<StopSaleBillVO> list = null;
		String ypname = request.getParameter("ypname");
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		String pageNo = request.getParameter("thispage");
		if(mc==null){
			mc=new StopSaleBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
//			list= stopCellMng.getPageybh(mc,0,Constants.pagesize);
			list= stopCellMng.getPage(ypname,"3",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
//			list= stopCellMng.getPageybh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			list= stopCellMng.getPage(ypname,"3",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
//		int resultSize = stopCellMng.getTotalCountybh(mc);
		int resultSize = stopCellMng.countStopSaleBillByStatus(ypname, "3");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/stopcell/ybhlist");
	}
	@RequestMapping("/drugState/stopcell/ybhview.html")
	public ModelAndView ybhview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		StopSaleBill ch =stopCellMng.findById(id);
		QualityMidicine  qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		model.addAttribute("mc", ch);
		return new ModelAndView("drugState/stopcell/ybhview");
	}
	@RequestMapping("/drugState/stopcell/bhback.html")
	public ModelAndView ybhaudit(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		if(id!=null){
			StopSaleBill ch =stopCellMng.findById(id);
			//Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(ch.getBatchProduction());
			//unqu.setStatus("0");
			//unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
			ch.setReviewStatus(0L);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			stopCellMng.update(ch);
			logService.addLog("驳回确认停售管理记录", user.getRealname(), "驳回确认", "药品状态管理  >停售管理", StringUtil.getIpAddr(request));
		}
		return ybhPage(null, request, response, model);
	}
	@RequestMapping("/drugState/stopcell/unqu.html")
	public ModelAndView unqu(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		StopSaleBill ch = new StopSaleBill();
		if(id!=null){
			ch =stopCellMng.findById(id);
		}
		QualityMidicine qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		UnqualifiedManager qumr = new UnqualifiedManager();
		//Qualifiedmedcstore qu = new Qualifiedmedcstore();
		//qumr.setQualifiedmedcstore(qu);
		qumr.getQualifiedmedcstore().setQualityMidicine(qm);
		qumr.setQuantity(ch.getQuantity());
		qumr.setBatchno(ch.getBatchProduction());
		model.addAttribute("um", qumr);
		return new ModelAndView("qualityRecords/unqualifiedManger/add");
	}
	@RequestMapping("/drugState/stopcell/findypboxqy.html")
	public void findypbox(HttpServletRequest request, HttpServletResponse response, Model model){
		List<QualityMidicine> listpu= new ArrayList<QualityMidicine>();
		String supplyUnit = request.getParameter("qsid");
		//封装采购单json
		listpu=stopCellMng.findypJsonqy();
		String json = "[";
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				if(supplyUnit!=null && !supplyUnit.trim().equals("")){
					if(!supplyUnit.trim().equals(listpu.get(i).getSupplyUnit().getId()+"")){
						continue;
					}
				}
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
			json = json.substring(0, json.length()-1);
		}
		json+="]";
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/drugState/stopcell/findypboxbyid.html")
	public void findypboxbyid(String id,HttpServletRequest request, HttpServletResponse response, Model model){
		List<Qualifiedmedcstore> listpu= new ArrayList<Qualifiedmedcstore>();
		//封装采购单json
		listpu=stopCellMng.findypJsonqyById(id);
		String json = "[";
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				if(listpu.get(i).getBatchproduction()!=null && !"".equals(listpu.get(i).getBatchproduction())){
					Qualifiedmedcstore unqu = qualifiedmedcstoreMng.findByBaNo(listpu.get(i).getBatchproduction());
					if(unqu!=null){
						json+="{";
						json+="\"id\":\""+listpu.get(i).getBatchproduction()+"_"+listpu.get(i).getQuantity()+"_"+unqu.getQuantity()+"_"+unqu.getValiddate()+"\",";
						json+="\"text\":\""+listpu.get(i).getBatchproduction()+"\"";
						if(i==listpu.size()-1){
							json+="}";
						}else{
							json+="},";
						}
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
