package com.sinosoft.drugState.accepreturn.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNote;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNoteRecords;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNoteVO;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptRollBackRecords;
import com.sinosoft.drugState.accepreturn.model.ReturncheckItem;
import com.sinosoft.drugState.accepreturn.service.ReturnCheckAcceptNoteRecordsManager;
import com.sinosoft.drugState.accepreturn.service.ReturnCheckAcceptRollBackRecordsManager;
import com.sinosoft.drugState.accepreturn.service.ReturnTaceItemMng;
import com.sinosoft.drugState.accepreturn.service.ReturnTaceMng;
import com.sinosoft.drugState.acceptance.service.AcceptanceMng;
import com.sinosoft.drugState.inspectionRecords.model.QualifiedEdit;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNote;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.mackNo.service.MakeNoMng;
import com.sinosoft.drugState.price.MedicinePrice;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNote;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteItem;
import com.sinosoft.drugState.returnRecords.service.ReturnRecordsMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedPurchaseUnitsService;
import com.sinosoft.ireportDTO.QualityAcceptanceReportDto;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.user.UserManager;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreRe;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualifiedmedcstoreMng;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualifiedmedcstoreReMng;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.UnqualifiedmedcstoreMng;

@Controller
public class ReturnTanceAct {
	
	@Autowired 
	private ReturnTaceMng returnTaceMng;
	@Autowired 
	private InspectionMng inspectionMng;
	@Autowired
	private ReturnTaceItemMng returnTaceItemMng;
	@Autowired
	private AcceptanceMng acceptanceMng;
	@Autowired
	private MakeNoMng makeNoMng;
	@Autowired
	private UserManager userManager;
	@Autowired
	private ReturnRecordsMng returnRecordsMng;
	@Autowired
	private QualifiedPurchaseUnitsService purchaseUnitsService;
	@Autowired
	private QualifiedmedcstoreMng qualifiedmedcstoreMng;
	@Autowired
	private QualifiedmedcstoreReMng qualifiedmedcstoreReMng;
	@Autowired
	private UnqualifiedmedcstoreMng unqualifiedmedcstoreMng;
	@Autowired
	private SystemLogService logService;
	@Autowired
	private ReturnCheckAcceptNoteRecordsManager recordsManager;
	@Autowired
	private ReturnCheckAcceptRollBackRecordsManager rollBackRecordsManager;

	/***
	 * 待录入
	 * 
	 * */
	@RequestMapping("/drugState/checkreturn/list.html")
	public ModelAndView openFramPage(ReturnCheckAcceptNote reNo,HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
	//	List<ReturnCheckAcceptNote> list = new ArrayList<ReturnCheckAcceptNote>();
		List<ReturnCheckAcceptNoteVO> list = null;
		String pageNo = request.getParameter("thispage");
		String ypname = request.getParameter("ypname");
		String yhDate = request.getParameter("yhdate");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			reNo.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			reNo.setArrivalDate(yhDate);
		}
		if(reNo==null){
			reNo = new ReturnCheckAcceptNote();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= returnTaceMng.getPage(reNo,0,Constants.pagesize);
			//list =returnTaceMng.getReturnCheckAcceptNoteByCondition(yhDate, ypname, "0", 0, Constants.pagesize);
			list =returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "0", 0, Constants.pagesize);
		}
		else{
			//否者翻页查询
			//list= returnTaceMng.getPage(reNo,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			//list =returnTaceMng.getReturnCheckAcceptNoteByCondition(yhDate, ypname, "0", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			list =returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "0", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			
		}
		//int resultSize = returnTaceMng.getTotalCount(reNo);
		//int resultSize =  returnTaceMng.countReturnCheckAcceptNoteByConiction(yhDate, ypname, "0");
		int resultSize =  returnTaceMng.countReturnCheckAcceptNoteVOByConiction(yhDate, ypname, "0");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("reNo", reNo);
		return new ModelAndView("drugState/checkreturn/dlrlist");
	}
	@RequestMapping("/drugState/checkreturn/dlrlist.html")
	public ModelAndView dlrPage(ReturnCheckAcceptNote reNo,HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
	//	List<ReturnCheckAcceptNote> list = new ArrayList<ReturnCheckAcceptNote>();
		List<ReturnCheckAcceptNoteVO> list = null;
		String pageNo = request.getParameter("thispage");
		String ypname = request.getParameter("ypname");
		String yhDate = request.getParameter("yhdate");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			reNo.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			reNo.setArrivalDate(yhDate);
		}
		if(reNo==null){
			reNo = new ReturnCheckAcceptNote();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= returnTaceMng.getPage(reNo,0,Constants.pagesize);
			list= returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "0", 0, Constants.pagesize);
		}
		else{
			//否者翻页查询
			//list= returnTaceMng.getPage(reNo,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			list= returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "0", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		//int resultSize = returnTaceMng.getTotalCount(reNo);
		int resultSize = returnTaceMng.countReturnCheckAcceptNoteVOByConiction(yhDate, ypname, "0");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("reNo", reNo);
		return new ModelAndView("drugState/checkreturn/dlrlist");
	}
	/**
	 * 待验收
	 * @param reNo
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/drugState/checkreturn/dyslist.html")
	public ModelAndView opencheckPage(ReturnCheckAcceptNote reNo,HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
	
		List<ReturnCheckAcceptNoteVO> list = null;
		String pageNo = request.getParameter("thispage");
		String ypname = request.getParameter("ypname");
		String yhDate = request.getParameter("yhdate");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			reNo.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			reNo.setArrivalDate(yhDate);
		}
		if(reNo==null){
			reNo = new ReturnCheckAcceptNote();
		}
		if(page==null){
			list =returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "3", 0, Constants.pagesize);
		}
		else{
			list =returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "3", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			
		}
		int resultSize =  returnTaceMng.countReturnCheckAcceptNoteVOByConiction(yhDate, ypname, "0");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("reNo", reNo);
		return new ModelAndView("drugState/checkreturn/dyslist");
	}
	/**
	 * 查询复检
	 * @param reNo
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/drugState/checkreturn/rechecklist.html")
	public ModelAndView recheckPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		//List<ReturnCheckAcceptNote> list = new ArrayList<ReturnCheckAcceptNote>();
		List<ReturnCheckAcceptNoteVO> list = null;
		String ypname = request.getParameter("ypname");
		String yhDate = request.getParameter("yhdate");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= returnTaceMng.getReturnCheckAcceptNoteByCondition(yhDate,ypname,"4",0,Constants.pagesize);
			list= returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate,ypname,"4",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			//list= returnTaceMng.getReturnCheckAcceptNoteByCondition(yhDate,ypname,"4",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			list= returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate,ypname,"4",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		//int resultSize = returnTaceMng.countReturnCheckAcceptNoteByConiction(yhDate, ypname, "4");
		int resultSize = returnTaceMng.countReturnCheckAcceptNoteVOByConiction(yhDate, ypname, "4");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		//model.addAttribute("reNo", reNo);
		return new ModelAndView("drugState/checkreturn/rechecklist");
	}                 
	@RequestMapping("/drugState/checkreturn/recheckview.html")
	public ModelAndView recheckView(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		ReturnCheckAcceptNote ch =returnTaceMng.findById(id);
		String page = DisplayGetPage.getPageParamName("records", request);
		List<ReturncheckItem> chIt=new ArrayList<ReturncheckItem>();
		QualifiedPurchaseUnits qu = new QualifiedPurchaseUnits();
		if(ch.getQualifiedPurchaseUnitsId()!=null && !"".equals(ch.getQualifiedPurchaseUnitsId())){
			qu=acceptanceMng.findgouhuo(ch.getQualifiedPurchaseUnitsId());
		}
		
		model.addAttribute("qu", qu);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			chIt= returnTaceMng.find(ch.getId(),0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			chIt= returnTaceMng.find(ch.getId(),(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		
		int resultSize = returnTaceMng.findCount(ch.getId());
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("mc", ch);
		model.addAttribute("chIt", chIt);
		model.addAttribute("count",resultSize);
		model.addAttribute("storageStore",chIt.get(0).getQualityMidicine().getStorageStore());
		return new ModelAndView("drugState/checkreturn/recheckview");
	}	
	
	@RequestMapping("/drugState/checkreturn/recheck.html")
	public ModelAndView recheck(String id, HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
	//	String type = request.getParameter("types");
		String outUnqmr = request.getParameter("outUnqmr");//入不合格品库
		//用于申请回退
		String type = request.getParameter("submitType");
		String roll_back_reason = request.getParameter("roll_back_reason");
		User applyUser = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		
		if(id!=null){
			ReturnCheckAcceptNote ch =returnTaceMng.findById(id);
			
			if("2".equals(type)){
				ch.setReviewStatus(5L);
				if(ch.getRollback()!=null && !ch.getRollback().trim().equals("")){
					ch.setRollback(String.valueOf(Long.valueOf(ch.getRollback())+1));
				}else{
				  ch.setRollback("1");
				}
				returnTaceMng.update(ch);
				
				rollBackRecordsManager.addReturnCheckAcceptRollBackRecords(ch.getId(), applyUser, roll_back_reason);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("success",URLEncoder.encode("申请回退成功！", "UTF-8"));
				UtilJson.printMapJson(response, map);
				return null;
				
			}
			
			response.setCharacterEncoding("utf-8");
			String visualExamination = request.getParameter("visualExamination");
			ch.setVisualExamination(visualExamination);
		//	if(type!=null && !"".equals(type)){
				ch.setReviewStatus(Long.parseLong("2"));
		//	}
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setRecheckPersionId(user.getId());
			int count =  Integer.parseInt(request.getParameter("count"));
			List<ReturncheckItem> checkItemList = returnTaceMng.findYp(ch.getId());
			Map<Long, ReturncheckItem> itemMap = new HashMap<Long, ReturncheckItem>();
			for(ReturncheckItem item : checkItemList){
				itemMap.put(item.getId(), item);
			}
			List<ReturncheckItem> list = new ArrayList<ReturncheckItem>();
			for(int i=0;i<count;i++){
				ReturncheckItem chItem = new ReturncheckItem();
				String medicId = request.getParameter("medicId"+i);
				QualityMidicine quMidicine = inspectionMng.findYpById(medicId);
				String shuliang = request.getParameter("shuliang"+i);
				String hegeshuliang = request.getParameter("hegeshuliang"+i);
				String buhegeshuliang = request.getParameter("buhegeshuliang"+i);
				String tuihuishuliang = request.getParameter("tuihuishuliang"+i);
				String youxiaoqizhi = request.getParameter("youxiaoqizhi"+i);
				String shengchanriqi = request.getParameter("shengchanriqi"+i);
				String pihao = request.getParameter("pihao"+i);
				String itemId =  request.getParameter("itemId"+i);
				chItem.setId(Long.valueOf(itemId));
				chItem.setBatchProduction(pihao);
				chItem.setQualifiedMedicineId(Long.parseLong(medicId));
				chItem.setQualityMidicine(quMidicine);
				chItem.setQuantity(Long.parseLong(shuliang));
				chItem.setQualifiedQuantity(Long.parseLong(hegeshuliang));
				chItem.setUnqualifiedQuantity(Long.parseLong(buhegeshuliang));
				if(tuihuishuliang==null || "".equals(tuihuishuliang.trim())){
					chItem.setInvalidQuantity(0L);
				}else{
					chItem.setInvalidQuantity(Long.parseLong(tuihuishuliang.trim()));
				}
				
				chItem.setReturnCheckId(Long.parseLong(id));
				chItem.setValidateDate(youxiaoqizhi);
				chItem.setProductionDate(shengchanriqi);
				list.add(chItem);
			}
			String modify_reson = request.getParameter("modify_reson");
			if(ch.getRejectFlag() != null && ch.getRejectFlag().equals("1")){
				for(ReturncheckItem item : list){
					QualityMidicine qm = inspectionMng.findHGYP(item.getQualifiedMedicineId());
					if(item.getId() == null || "".equals(item.getId())){
						recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "新增药品", "新增药品编号为"+((qm!=null)?qm.getMedicinalNo():"")+"的"+((qm!=null)?qm.getCommonname():""), user, modify_reson);
					}else{
						ReturncheckItem pi = itemMap.get(item.getId());
						if(pi  == null ){
							recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "新增药品", "新增药品编号为"+((qm!=null)?qm.getMedicinalNo():"")+"的"+((qm!=null)?qm.getCommonname():""), user, modify_reson);
						}else{
							if(!pi.getQualifiedMedicineId().equals(item.getQualifiedMedicineId())){
								QualityMidicine newQm = inspectionMng.findHGYP(pi.getQualifiedMedicineId());
								recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改药品名称", "修改药品名称修改之前药品名称为"+((qm!=null)?qm.getCommonname():"")+"修改之后药品名称为"+((newQm!=null)?newQm.getCommonname():""), user, modify_reson);
							}
							if(!pi.getBatchProduction().equals(item.getBatchProduction())){
								recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改"+((qm!=null)?qm.getCommonname():"")+"药品批号", "修改之前药品批号为"+pi.getBatchProduction()+"修改之后药品数量为"+item.getBatchProduction(), user, modify_reson);
							}
							if(!pi.getQuantity().equals(item.getQuantity())){
								recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改"+((qm!=null)?qm.getCommonname():"")+"药品数量", "修改之前药品数量为"+pi.getQuantity()+"修改之后药品数量为"+item.getQuantity(), user, modify_reson);
							}
							if(!pi.getQualifiedQuantity().equals(item.getQualifiedQuantity())){
								recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改"+((qm!=null)?qm.getCommonname():"")+"药品合格数量", "修改之前药品合格数量为"+pi.getQualifiedQuantity()+"修改之后药品合格数量为"+item.getQualifiedQuantity(), user, modify_reson);
							}
							if(pi.getUnqualifiedQuantity() == null || !pi.getUnqualifiedQuantity().equals(item.getUnqualifiedQuantity())){
								recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改"+((qm!=null)?qm.getCommonname():"")+"药品不合格数量", "修改之前药品不合格数量为"+pi.getUnqualifiedQuantity()+"修改之后药品不合格数量为"+item.getUnqualifiedQuantity(), user, modify_reson);
							}
							if(pi.getInvalidQuantity() == null || !pi.getInvalidQuantity().equals(item.getInvalidQuantity())){
								recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改"+((qm!=null)?qm.getCommonname():"")+"药品退回供应商数量", "修改之前药品退回供应商数量为"+pi.getInvalidQuantity()+"修改之后药品退回供应商数量为"+item.getInvalidQuantity(), user, modify_reson);
							}
							
							if(!pi.getValidateDate().equals(item.getValidateDate())){
								recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改"+((qm!=null)?qm.getCommonname():"")+"药品有效期至", "修改之前药品有效期至为"+pi.getValidateDate()+"修改之后药有效期至为"+item.getValidateDate(), user, modify_reson);
							}
							if(!pi.getProductionDate().equals(item.getProductionDate())){
								recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改"+((qm!=null)?qm.getCommonname():"")+"药品生产日期", "修改之前药品生产日期为"+pi.getProductionDate()+"修改之后药生产日期为"+item.getProductionDate(), user, modify_reson);
							}
							itemMap.remove(item.getId());
						}
					}
				}
				
				
				
				if(!itemMap.isEmpty()){
					Iterator<Long> it = itemMap.keySet().iterator();
					while(it.hasNext()){
						Long key = it.next();
						ReturncheckItem item = itemMap.get(key);
						QualityMidicine qm = inspectionMng.findHGYP(item.getQualifiedMedicineId());
						recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "删除药品", "删除药品编号为"+((qm!=null)?qm.getMedicinalNo():"")+"的"+((qm!=null)?qm.getCommonname():""), user, modify_reson);
					}
				}
			}
			
			List<?> itemList = returnTaceMng.findAllId(ch.getId());
			returnTaceItemMng.del(itemList);
			for(int i=0;i<count;i++){
				ReturncheckItem chItem = new ReturncheckItem();
				String medicId = request.getParameter("medicId"+i);
				QualityMidicine quMidicine = inspectionMng.findYpById(medicId);
				String shuliang = request.getParameter("shuliang"+i);
				String hegeshuliang = request.getParameter("hegeshuliang"+i);
				String buhegeshuliang = request.getParameter("buhegeshuliang"+i);
				String tuihuishuliang = request.getParameter("tuihuishuliang"+i);
				String youxiaoqizhi = request.getParameter("youxiaoqizhi"+i);
				String shengchanriqi = request.getParameter("shengchanriqi"+i);
				String pihao = request.getParameter("pihao"+i);
			//	String itemId =  request.getParameter("itemId"+i);
			//	chItem.setId(Long.valueOf(itemId));
				chItem.setBatchProduction(pihao);
				chItem.setQualifiedMedicineId(Long.parseLong(medicId));
				chItem.setQualityMidicine(quMidicine);
				chItem.setQuantity(Long.parseLong(shuliang));
				chItem.setQualifiedQuantity(Long.parseLong(hegeshuliang));
				chItem.setUnqualifiedQuantity(Long.parseLong(buhegeshuliang));
				if(tuihuishuliang==null || "".equals(tuihuishuliang.trim())){
					chItem.setInvalidQuantity(0L);
				}else{
					chItem.setInvalidQuantity(Long.parseLong(tuihuishuliang.trim()));
				}
				chItem.setReturnCheckId(Long.parseLong(id));
				chItem.setValidateDate(youxiaoqizhi);
				chItem.setProductionDate(shengchanriqi);
				returnTaceItemMng.save(chItem);
			}
			
			for(ReturncheckItem ri : list){
				if(outUnqmr != null && !outUnqmr.trim().equals("")){
					Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(ri.getBatchProduction());
					Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(ri.getBatchProduction());
					if(unqu==null){
						unqu = new Unqualifiedmedcstore();
						unqu.setBatchproduction(ri.getBatchProduction());
						unqu.setQualifiedmedicineid(ri.getQualifiedMedicineId());
						unqu.setValiddate(ri.getValidateDate());
						unqu.setQuantity(ri.getQuantity());
					}else{
						unqu.setQuantity(unqu.getQuantity()+ri.getQuantity());
					}
					unqu.setStatus(outUnqmr);
					unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
					
					if(qu == null){
						qu = new Qualifiedmedcstore();
						qu.setQualifiedmedicineid(ri.getQualifiedMedicineId());
						qu.setValiddate(ri.getValidateDate());
						qu.setQuantity(ri.getQuantity());
						qu.setBatchproduction(ri.getBatchProduction());
//						DrugMaintenance dr = inspectionMng.findDrByNumber(chIts.get(j).getBatchProduction());
						QualityMidicine qm = inspectionMng.findHGYP(ri.getQualifiedMedicineId());
						if(ch.getCheckAcceptDate()!=null && qm!=null){
							Calendar cal = Calendar.getInstance();
							SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");   
							Date time=null;
							try {
								time = formatDate.parse(ch.getCheckAcceptDate());
							} catch (java.text.ParseException e) {
								e.printStackTrace();
							}    
							cal.setTime(time);
							cal.add(Calendar.MONTH,Integer.parseInt(qm.getMaintainCycle())+3);
							qu.setNextmaintaindate(formatDate.format(cal.getTime()));
							qu.setCreatedate(ch.getCheckAcceptDate());
						}
						qu.setQualityMidicine(qm);
						
					}else{
						//返厂药品，新的合格药品库中增加此批号的药品
						QualifiedmedcstoreRe quRe = new QualifiedmedcstoreRe();
						quRe.setBatchproduction(ri.getBatchProduction());
						QualityMidicine qm = inspectionMng.findHGYP(ri.getQualifiedMedicineId());
						if(ch.getCheckAcceptDate()!=null && qm!=null){
							Calendar cal = Calendar.getInstance();
							SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");   
							Date time=null;
							try {
								time = formatDate.parse(ch.getCheckAcceptDate());
							} catch (java.text.ParseException e) {
								e.printStackTrace();
							}    
							cal.setTime(time);
							cal.add(Calendar.MONTH,Integer.parseInt(qm.getMaintainCycle())+3);
							quRe.setNextmaintaindate(formatDate.format(cal.getTime()));
							quRe.setCreatedate(ch.getCheckAcceptDate());
						}
						quRe.setQuantity(ri.getQualifiedQuantity());
						quRe.setQualifiedmedicineid(ri.getQualifiedMedicineId());
						quRe.setQualityMidicine(qm);
						quRe.setValiddate(ri.getValidateDate());
						quRe.setRe_flag(1);//1表示是返厂的
						qualifiedmedcstoreReMng.save(quRe);
						//原合格药品库处理方法不变
						qu.setQuantity(qu.getQuantity()+ri.getQualifiedQuantity());
						if(ch!=null){
							qu.setCreatedate(ch.getCheckAcceptDate());
						}
					}
					qualifiedmedcstoreMng.savequ(qu);
					
					
				}
			}
			
			
			
			
			returnTaceMng.update(ch);//最后更新主单，以触发触发器
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", URLEncoder.encode("保存数据成功","utf-8"));
			map.put("checkReturnId",id);
			UtilJson.printMapJson(response, map);
		}
		return null;
	}
	@RequestMapping("/drugState/checkreturn/dlradd.html")
	public ModelAndView dshadd(ReturnCheckAcceptNote mc, HttpServletRequest request, HttpServletResponse response,Model model){
		Date now = new Date();
		String nonumber = makeNoMng.findNo(Constants.RETURNACCEPT);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String number = format.format(now);
		if(nonumber!=null && !"".equals(nonumber) && number.equals(nonumber.substring(0, 8))){
			try {
				Long  n = Long.parseLong(nonumber)+1L;
				mc.setReportNo(n.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			nonumber= number+"0001";
			mc.setReportNo(nonumber);
		}
		SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd");
		String numbers = formats.format(now);
		mc.setCheckAcceptDate(numbers);
		mc.setArrivalDate(numbers);
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		model.addAttribute("mc", mc);
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> qsmap=inspectionMng.gouhuoMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("drugState/checkreturn/dlradd");
	}
	@RequestMapping("/drugState/checkreturn/dlredit.html")
	public ModelAndView dshedit(ReturnCheckAcceptNote mc,String id, HttpServletRequest request, HttpServletResponse response,Model model){
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		ReturnCheckAcceptNote mcs=returnTaceMng.findById(id);
		model.addAttribute("mc", mcs);
		List<ReturncheckItem> receItem= returnTaceMng.findYp(mcs.getId());
		List<QualifiedEdit> qus =  new ArrayList<QualifiedEdit>();
		for(int j=0;j<receItem.size();j++){
			QualifiedEdit qu = new QualifiedEdit();
			ReturncheckItem rece = receItem.get(j);
			QualityMidicine qualifiedMedicine = inspectionMng.findHGYP(receItem.get(j).getQualifiedMedicineId());
			if(rece.getQuantity()!=null && !"".equals(rece.getQuantity().toString())){
				qu.setShuliang(rece.getQuantity().toString());
			}else{
				qu.setShuliang("");
			}
			if(rece.getBatchProduction()!=null){
				qu.setShengchanpihao(rece.getBatchProduction().toString());
			}else{
				qu.setShengchanpihao("");
			}
			if(rece.getQualifiedMedicineId()!=null){
				qu.setYaopinming(rece.getQualifiedMedicineId().toString());
			}else{
				qu.setYaopinming("");
			}
			if(qualifiedMedicine != null){
				qu.setJixing(qualifiedMedicine.getDosageforms().getFormName());
				qu.setGuige(qualifiedMedicine.getSpecifications());
				qu.setZhuceshangbiao(qualifiedMedicine.getRegisteredtrademarkpath());
				qu.setPizhunwenhao(qualifiedMedicine.getLicensenumber());
				qu.setZhuceshangbiao(qualifiedMedicine.getRegisteredtrademarkpath());
				qu.setStorageStore(qualifiedMedicine.getStorageStore());
			}else{
				qu.setJixing("");
				qu.setGuige("");
				qu.setZhuceshangbiao("");
				qu.setPizhunwenhao("");
				qu.setZhuceshangbiao("");
				qu.setStorageStore("");
			}
			
			qu.setYouxiaoqizhi(rece.getValidateDate());
			qu.setShengchanriqi(rece.getProductionDate());
			qu.setHegezheng("");
			if(rece.getQualifiedQuantity()!=null){
				qu.setHegeshuliang(rece.getQualifiedQuantity().toString());
			}else{
				qu.setHegeshuliang("");
			}
			qu.setZhuceshangbiao("");
			if(qualifiedMedicine.getProduceno()!=null){
				if(qualifiedMedicine.getProduceno().getCustomerName()!=null){
					qu.setShengchangqiye(qualifiedMedicine.getProduceno().getCustomerName());
				}else{
					qu.setShengchangqiye("");
				}
			}else{
				qu.setShengchangqiye("");
			}
			qu.setPurchaseOrderId(rece.getId());
			qus.add(qu);
		}
		List<String> jsonStringList = new ArrayList<String>();
		for(int i=0;i<receItem.size();i++)
		{
			QualifiedEdit borg = qus.get(i);
			jsonStringList.add(new JSONObject(borg).toString());
		}
		if(mcs.getQualifiedPurchaseUnits()!=null){
			model.addAttribute("gouhuoshang", mcs.getQualifiedPurchaseUnits().getCustomerName());
		}else{
			model.addAttribute("gouhuoshang","");
		}
		JSONArray jsonArray = new JSONArray(jsonStringList);
		String jsonString = jsonArray.toString();
		model.addAttribute("receItem", jsonString);
		Map<String, String> qsmap=inspectionMng.gouhuoMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("drugState/checkreturn/dlredit");
	}
	
	@RequestMapping("/drugState/checkreturn/dysedit.html")
	public ModelAndView dysedit(ReturnCheckAcceptNote mc,String id, HttpServletRequest request, HttpServletResponse response,Model model){
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		ReturnCheckAcceptNote mcs=returnTaceMng.findById(id);
		Date now = new Date();
		SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd");
		String numbers = formats.format(now);
		mcs.setCheckAcceptDate2(numbers);
		
		model.addAttribute("mc", mcs);
		List<ReturncheckItem> receItem= returnTaceMng.findYp(mcs.getId());
		List<QualifiedEdit> qus =  new ArrayList<QualifiedEdit>();
		for(int j=0;j<receItem.size();j++){
			QualifiedEdit qu = new QualifiedEdit();
			ReturncheckItem rece = receItem.get(j);
			QualityMidicine qualifiedMedicine = inspectionMng.findHGYP(receItem.get(j).getQualifiedMedicineId());
			if(rece.getQuantity()!=null && !"".equals(rece.getQuantity().toString())){
				qu.setShuliang(rece.getQuantity().toString());
			}else{
				qu.setShuliang("");
			}
			if(rece.getBatchProduction()!=null){
				qu.setShengchanpihao(rece.getBatchProduction().toString());
			}else{
				qu.setShengchanpihao("");
			}
			if(rece.getQualifiedMedicineId()!=null){
				qu.setYaopinming(rece.getQualifiedMedicineId().toString());
			}else{
				qu.setYaopinming("");
			}
			if(qualifiedMedicine != null){
				qu.setJixing(qualifiedMedicine.getDosageforms().getFormName());
				qu.setGuige(qualifiedMedicine.getSpecifications());
				qu.setZhuceshangbiao(qualifiedMedicine.getRegisteredtrademarkpath());
				qu.setPizhunwenhao(qualifiedMedicine.getLicensenumber());
				qu.setZhuceshangbiao(qualifiedMedicine.getRegisteredtrademarkpath());
				qu.setStorageStore(qualifiedMedicine.getStorageStore());
			}else{
				qu.setJixing("");
				qu.setGuige("");
				qu.setZhuceshangbiao("");
				qu.setPizhunwenhao("");
				qu.setZhuceshangbiao("");
				qu.setStorageStore("");
			}
			
			qu.setYouxiaoqizhi(rece.getValidateDate());
			qu.setShengchanriqi(rece.getProductionDate());
			qu.setHegezheng("");
			if(rece.getQualifiedQuantity()!=null){
				qu.setHegeshuliang(rece.getQualifiedQuantity().toString());
			}else{
				qu.setHegeshuliang("");
			}
			qu.setZhuceshangbiao("");
			if(qualifiedMedicine.getProduceno()!=null){
				if(qualifiedMedicine.getProduceno().getCustomerName()!=null){
					qu.setShengchangqiye(qualifiedMedicine.getProduceno().getCustomerName());
				}else{
					qu.setShengchangqiye("");
				}
			}else{
				qu.setShengchangqiye("");
			}
			qu.setPurchaseOrderId(rece.getId());
			qus.add(qu);
		}
		List<String> jsonStringList = new ArrayList<String>();
		for(int i=0;i<receItem.size();i++)
		{
			QualifiedEdit borg = qus.get(i);
			jsonStringList.add(new JSONObject(borg).toString());
		}
		if(mcs.getQualifiedPurchaseUnits()!=null){
			model.addAttribute("gouhuoshang", mcs.getQualifiedPurchaseUnits().getCustomerName());
		}else{
			model.addAttribute("gouhuoshang","");
		}
		JSONArray jsonArray = new JSONArray(jsonStringList);
		String jsonString = jsonArray.toString();
		model.addAttribute("receItem", jsonString);
		Map<String, String> qsmap=inspectionMng.gouhuoMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("drugState/checkreturn/dysedit");
	}
	@RequestMapping("/drugState/checkreturn/dlrsave.html")
	public ModelAndView dlrsave(ReturnCheckAcceptNote mc, String counts,HttpServletRequest request, HttpServletResponse response,Model model){
		response.setCharacterEncoding("utf-8");
		String thispage=request.getParameter("thispage");
		String type = request.getParameter("submitType");
		model.addAttribute("thispage", thispage);
		model.addAttribute("mc", mc);
		Map<String, Object> map = new HashMap<String, Object>();
		if("1".equals(type)){
			mc.setReviewStatus(4L);
		}else{
			mc.setReviewStatus(0L);
		}
		
		String nonumber = makeNoMng.mackNo(Constants.RETURNACCEPT);
		if(!mc.getReportNo().equals(nonumber)){
			map.put("success", "1");
			map.put("number", nonumber);
			mc.setReportNo(nonumber);
		}else{
			map.put("success", "2");
		}
		Date date = new Date();
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		String modifyDate = modifyDateFormat.format(date);
 		mc.setApplicationTime(modifyDate);
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		mc.setProposerID(user.getId());
		if(mc.getQualifiedPurchaseUnitsId()!=null){
			mc.setQualifiedPurchaseUnits(inspectionMng.findGHSById(mc.getQualifiedPurchaseUnitsId()));
		}
		ReturnCheckAcceptNote mcs=returnTaceMng.save(mc);
		if(!"".equals(counts) && counts.equals(counts)){
			for(int i=0;i<Integer.parseInt(counts);i++){
				ReturncheckItem chIt= new ReturncheckItem();
				String pingming = request.getParameter("pinming"+i);
				String shuliang = request.getParameter("shuliang"+i);
				String jixing = request.getParameter("jixing"+i);
				String guige = request.getParameter("guige"+i);
				String shengchang = request.getParameter("shengchang"+i);
				String hegeshuliang=request.getParameter("hegeshuliang"+i);
				String pizhun = request.getParameter("pizhun"+i);
				String shangbiao = request.getParameter("shangbiao"+i);
				String shengchanpihao = request.getParameter("shengchanpihao"+i);
				String hege = request.getParameter("hege"+i);
				String youxiaoqi = request.getParameter("youxiaoqi"+i);
				String shengchanriqi =  request.getParameter("shengchanriqi"+i);
				if(pingming!=null && !"".equals(pingming)){
					chIt.setQualifiedMedicineId(Long.parseLong(pingming.trim()));
					chIt.setQualityMidicine(inspectionMng.findYpById(pingming.trim()));
				}else{
					continue;
				}
				if(shuliang!=null && !"".equals(shuliang)){
					chIt.setQuantity(Long.parseLong(shuliang.trim()));
				}else{
					continue;
				}
				chIt.setReturnCheckId(mcs.getId());
				chIt.setDosageForms(jixing);
				chIt.setLicenseNumber(pizhun);
				chIt.setSpecifications(guige);
				chIt.setBatchProduction(shengchanpihao);
				chIt.setValidateDate(youxiaoqi);
				chIt.setProductionDate(shengchanriqi);
				if(!"".equals(hegeshuliang) && hegeshuliang!=null){
					chIt.setQualifiedQuantity(Long.parseLong(hegeshuliang));
				}
				returnTaceItemMng.save(chIt);
			}
		}
		//特使管理药品，双人验收
		if("1".equals(type)){
			List<ReturncheckItem> rCheckItem = returnTaceMng.findYp(mcs.getId());
			for(ReturncheckItem chItem :rCheckItem){
				if(null!= chItem.getQualityMidicine().getMedicineManagement()
						&&"专门管理要求药品".equals(chItem.getQualityMidicine().getMedicineManagement())){
					mcs.setReviewStatus(3L);
				}
			}
		}
		returnTaceMng.update(mcs);
		
		logService.addLog("提交退收验收管理", user.getRealname(), "提交", "药品状态管理  >退收验收管理", StringUtil.getIpAddr(request));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/checkreturn/dlrupdate.html")
	public ModelAndView dshupdate(ReturnCheckAcceptNote mc,String counts, HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String thispage=request.getParameter("thispage");
		String type = request.getParameter("submitType");
		String modify_reson = request.getParameter("modify_reason");
		Map<String, Object> map = new HashMap<String, Object>();
		if("1".equals(type)){
			mc.setReviewStatus(4L);
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
		model.addAttribute("mc", mc);
		List<ReturncheckItem> itemList = new ArrayList<ReturncheckItem>();
		if(!"".equals(counts) && null!=counts){
			for(int i=0;i<Integer.parseInt(counts);i++){
				ReturncheckItem chIt= new ReturncheckItem();
				String pingming = request.getParameter("pinming"+i);
				String shuliang = request.getParameter("shuliang"+i);
				String jixing = request.getParameter("jixing"+i);
				String guige = request.getParameter("guige"+i);
				String hegeshuliang=request.getParameter("hegeshuliang"+i);
				String pizhun = request.getParameter("pizhun"+i);
				String youxiaoqi = request.getParameter("youxiaoqi"+i);
				String shengchanriqi =  request.getParameter("shengchanriqi"+i);
				String shengchanpihao = request.getParameter("shengchanpihao"+i);
				String itemId = request.getParameter("itemId"+i);
				chIt.setId(Long.valueOf(itemId));
				if(pingming!=null && !"".equals(pingming)){
					chIt.setQualifiedMedicineId(Long.parseLong(pingming.trim()));
					chIt.setQualityMidicine(inspectionMng.findYpById(pingming.trim()));
				}else{
					continue;
				}
				if(shuliang!=null && !"".equals(shuliang)){
					chIt.setQuantity(Long.parseLong(shuliang));
				}else{
					continue;
				}
				chIt.setReturnCheckId(mc.getId());
				chIt.setDosageForms(jixing);
				chIt.setLicenseNumber(pizhun);
				chIt.setSpecifications(guige);
				chIt.setValidateDate(youxiaoqi);
				chIt.setProductionDate(shengchanriqi);
				if(!"".equals(hegeshuliang) && null!= hegeshuliang){
					chIt.setQualifiedQuantity(Long.parseLong(hegeshuliang.trim()));
				}else{
					chIt.setQualifiedQuantity(0L);
				}
				chIt.setBatchProduction(shengchanpihao);
				itemList.add(chIt);
			}
		}
		ReturnCheckAcceptNote ch = returnTaceMng.findById(mc.getId().toString());//查询数据库中存在的记录
		List<ReturncheckItem> checkItemList = returnTaceMng.findYp(ch.getId());
		Map<Long, ReturncheckItem > itemMap = new HashMap<Long, ReturncheckItem>();
		for(ReturncheckItem item : checkItemList){
			itemMap.put(item.getId(), item);
		}
		if(ch.getRejectFlag()!= null && ch.getRejectFlag().equals("1")){
			if(!ch.getResult().equals(mc.getResult())){
				recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改验收结果", "验收结果修改之前值为"+ch.getResult()+"修改之后值为"+mc.getResult(), user, modify_reson);
			}
			if(!ch.getCheckConclusion().equals(mc.getCheckConclusion())){
				recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改退货原因", "退货原因修改之前值为"+ch.getCheckConclusion()+"修改之后值为"+mc.getCheckConclusion(), user, modify_reson);
			}
			for(ReturncheckItem item : itemList){
				QualityMidicine qm = inspectionMng.findHGYP(item.getQualifiedMedicineId());
				if(item.getId() == null || "".equals(item.getId())){
					recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "新增药品", "新增药品编号为"+((qm!=null)?qm.getMedicinalNo():"")+"的"+((qm!=null)?qm.getCommonname():""), user, modify_reson);
				}else{
					ReturncheckItem pi = itemMap.get(item.getId());
					if(pi  == null ){
						recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "新增药品", "新增药品编号为"+((qm!=null)?qm.getMedicinalNo():"")+"的"+((qm!=null)?qm.getCommonname():""), user, modify_reson);
					}else{
						if(!pi.getQualifiedMedicineId().equals(item.getQualifiedMedicineId())){
							QualityMidicine newQm = inspectionMng.findHGYP(pi.getQualifiedMedicineId());
							recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改药品名称", "修改药品名称修改之前药品名称为"+((qm!=null)?qm.getCommonname():"")+"修改之后药品名称为"+((newQm!=null)?newQm.getCommonname():""), user, modify_reson);
						}
						if(!pi.getBatchProduction().equals(item.getBatchProduction())){
							recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改"+((qm!=null)?qm.getCommonname():"")+"药品批号", "修改之前药品批号为"+pi.getBatchProduction()+"修改之后药品数量为"+item.getBatchProduction(), user, modify_reson);
						}
						if(!pi.getQuantity().equals(item.getQuantity())){
							recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改"+((qm!=null)?qm.getCommonname():"")+"药品数量", "修改之前药品数量为"+pi.getQuantity()+"修改之后药品数量为"+item.getQuantity(), user, modify_reson);
						}
						
						if(!pi.getValidateDate().equals(item.getValidateDate())){
							recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改"+((qm!=null)?qm.getCommonname():"")+"药品有效期至", "修改之前药品有效期至为"+pi.getValidateDate()+"修改之后药有效期至为"+item.getValidateDate(), user, modify_reson);
						}
						if(!pi.getProductionDate().equals(item.getProductionDate())){
							recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "修改"+((qm!=null)?qm.getCommonname():"")+"药品生产日期", "修改之前药品生产日期为"+pi.getProductionDate()+"修改之后药有效期至为"+item.getProductionDate(), user, modify_reson);
						}
						itemMap.remove(item.getId());
					}
				}
			}
			if(!itemMap.isEmpty()){
				Iterator<Long> it = itemMap.keySet().iterator();
				while(it.hasNext()){
					Long key = it.next();
					ReturncheckItem item = itemMap.get(key);
					QualityMidicine qm = inspectionMng.findHGYP(item.getQualifiedMedicineId());
					recordsManager.addReturnCheckAcceptNoteRecords(ch.getId(), "删除药品", "删除药品编号为"+((qm!=null)?qm.getMedicinalNo():"")+"的"+((qm!=null)?qm.getCommonname():""), user, modify_reson);
				}
			}
		}
		
		returnTaceMng.update(mc);
		//先删除后保存
		List<?> receItem= returnTaceMng.findAllId(mc.getId());
		
		returnTaceItemMng.del(receItem);
		if(!"".equals(counts) && null!=counts){
			for(int i=0;i<Integer.parseInt(counts);i++){
				ReturncheckItem chIt= new ReturncheckItem();
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
				String shengchanriqi =  request.getParameter("shengchanriqi"+i);
				if(pingming!=null && !"".equals(pingming)){
					chIt.setQualifiedMedicineId(Long.parseLong(pingming.trim()));
					chIt.setQualityMidicine(inspectionMng.findYpById(pingming.trim()));
				}else{
					continue;
				}
				if(shuliang!=null && !"".equals(shuliang)){
					chIt.setQuantity(Long.parseLong(shuliang));
				}else{
					continue;
				}
				chIt.setReturnCheckId(mc.getId());
				chIt.setDosageForms(jixing);
				chIt.setLicenseNumber(pizhun);
				chIt.setSpecifications(guige);
				chIt.setValidateDate(youxiaoqi);
				chIt.setProductionDate(shengchanriqi);
				if(!"".equals(hegeshuliang) && null!= hegeshuliang){
					chIt.setQualifiedQuantity(Long.parseLong(hegeshuliang.trim()));
				}else{
					chIt.setQualifiedQuantity(0L);
				}
				chIt.setBatchProduction(shengchanpihao);
				returnTaceItemMng.save(chIt);
			}
		}
		//特使管理药品，双人验收
		if("1".equals(type)){
			List<ReturncheckItem> rCheckItem = returnTaceMng.findYp(mc.getId());
			for(ReturncheckItem chItem :rCheckItem){
				System.out.println(chItem.getQualityMidicine().getMedicineManagement());
				if(null!= chItem.getQualityMidicine().getMedicineManagement()
						&&"专门管理要求药品".equals(chItem.getQualityMidicine().getMedicineManagement())){
					mc.setReviewStatus(3L);
				}
			}
				
		}
		returnTaceMng.update(mc);
		
		logService.addLog("提交退收验收管理", user.getRealname(), "提交", "药品状态管理  >退收验收管理", StringUtil.getIpAddr(request));
		UtilJson.printMapJson(response, map);
		return null;
	}
	/**
	 * 待验收保存
	 * @param mc
	 * @param counts
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/drugState/checkreturn/dysupdate.html")
	public ModelAndView dysupdate(ReturnCheckAcceptNote mc,String counts, HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String thispage=request.getParameter("thispage");
		String type = request.getParameter("submitType");
		String modify_reson = request.getParameter("modify_reason");
		String roll_back_reason = request.getParameter("roll_back_reason");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		ReturnCheckAcceptNote rCheckNote = returnTaceMng.findById(mc.getId().toString());//查询数据库中存在的记录
		
		Map<String, Object> map = new HashMap<String, Object>();
		if("1".equals(type)){
			rCheckNote.setReviewStatus(4L);
			map.put("success",URLEncoder.encode("数据提交成功！", "UTF-8"));
		}else if("2".equals(type)){
			rCheckNote.setReviewStatus(5L);
			rCheckNote.setRollback("1");
			returnTaceMng.update(rCheckNote);
			
			rollBackRecordsManager.addReturnCheckAcceptRollBackRecords(rCheckNote.getId(), user, roll_back_reason);
			
			model.addAttribute("mc", mc);
			model.addAttribute("thispage", thispage);
			map.put("success",URLEncoder.encode("申请回退成功！", "UTF-8"));
			UtilJson.printMapJson(response, map);
			return null;
			
		}else{
			rCheckNote.setReviewStatus(3L);
			map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		}
		
		
		if(rCheckNote.getRejectFlag()!= null && rCheckNote.getRejectFlag().equals("1")){
			if(!rCheckNote.getResult().equals(mc.getResult())){
				recordsManager.addReturnCheckAcceptNoteRecords(rCheckNote.getId(), "修改验收结果2", "验收结果2修改之前值为"+rCheckNote.getResult2()+"修改之后值为"+mc.getResult2(), user, modify_reson);
			}
		}
		rCheckNote.setCheckAcceptDate2(mc.getCheckAcceptDate2());
		rCheckNote.setResult2(mc.getResult2());
		rCheckNote.setAccepterId(user.getId());
		returnTaceMng.update(rCheckNote);
		
		model.addAttribute("mc", mc);
		model.addAttribute("thispage", thispage);
		
		logService.addLog("提交退收验收管理", user.getRealname(), "提交", "药品状态管理  >退收验收管理", StringUtil.getIpAddr(request));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/checkreturn/dlrdel.html")
	public ModelAndView deldlr(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		if(ids!=null && !"".equals(ids)){
			for(int i= 0;i<ids.length;i++){
				returnTaceMng.del(ids[i]);
				List<?> receItem= returnTaceMng.findAllId(Long.parseLong(ids[i]));
				if(receItem!=null && receItem.size()>0){
					returnTaceItemMng.del(receItem);
				}
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除退收验收记录", user.getRealname(), "删除", "药品状态管理  >退收验收管理", StringUtil.getIpAddr(request));
		return dlrPage(null, request, response, model);
	}
	/**
	 * 待审核
	 * **/
	@RequestMapping("/drugState/checkreturn/dshlist.html")
	public ModelAndView dshPage(ReturnCheckAcceptNote mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		//List<ReturnCheckAcceptNote> list = new ArrayList<ReturnCheckAcceptNote>();
		List<ReturnCheckAcceptNoteVO> list = null;
		String pageNo = request.getParameter("thispage");
		String ypname = request.getParameter("ypname");
		String yhDate = request.getParameter("yhdate");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setArrivalDate(yhDate);
		}
		if(mc==null){
			mc = new ReturnCheckAcceptNote();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= returnTaceMng.getPagedsh(mc,0,Constants.pagesize);
			//list = returnTaceMng.getReturnCheckAcceptNoteByCondition(yhDate, ypname, "1", 0, Constants.pagesize);
			list = returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "1", 0, Constants.pagesize);
		}
		else{
			//否者翻页查询
			//list= returnTaceMng.getPagedsh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			//list = returnTaceMng.getReturnCheckAcceptNoteByCondition(yhDate, ypname, "1", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			list = returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "1", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
	//	int resultSize = returnTaceMng.getTotalCountDsh(mc);
	//	int resultSize = returnTaceMng.countReturnCheckAcceptNoteByConiction(yhDate, ypname, "1");
		int resultSize = returnTaceMng.countReturnCheckAcceptNoteVOByConiction(yhDate, ypname, "1");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/checkreturn/dshlist");
	}
	
	@RequestMapping("/drugState/checkreturn/dshview.html")
	public ModelAndView dshview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		ReturnCheckAcceptNote ch =returnTaceMng.findById(id);
		String page = DisplayGetPage.getPageParamName("records", request);
		List<ReturncheckItem> chIt=new ArrayList<ReturncheckItem>();
		QualifiedPurchaseUnits qu = new QualifiedPurchaseUnits();
		if(ch.getQualifiedPurchaseUnitsId()!=null && !"".equals(ch.getQualifiedPurchaseUnitsId())){
			qu=acceptanceMng.findgouhuo(ch.getQualifiedPurchaseUnitsId());
		}
		model.addAttribute("qu", qu);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			chIt= returnTaceMng.find(ch.getId(),0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			chIt= returnTaceMng.find(ch.getId(),(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		
		int resultSize = returnTaceMng.findCount(ch.getId());
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("mc", ch);
		model.addAttribute("chIt", chIt);
		model.addAttribute("checkItemSize", resultSize);
		return new ModelAndView("drugState/checkreturn/dshview");
	}	
	@RequestMapping("/drugState/checkreturn/audit.html")
	public ModelAndView audit(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		String batch_type=request.getParameter("batch_type");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		if(ids!=null && !"".equals(ids)){
			if("0".equals(batch_type)){
				for(int i =0;i<ids.length;i++){
					ReturnCheckAcceptNote ch =returnTaceMng.findById(ids[i]);
					ch.setReviewStatus(2L);
					Date date = new Date();
					SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 		String modifyDate = modifyDateFormat.format(date);
			 		ch.setReviewTime(modifyDate);
					User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
					ch.setAuditorID(user.getId());
					returnTaceMng.update(ch);
					List<ReturncheckItem> checkItemList = returnTaceMng.find(ids[i]);
					if(checkItemList!=null){
						for(ReturncheckItem chItem : checkItemList){
							Qualifiedmedcstore quMedcStore = qualifiedmedcstoreMng.findByBaNo(chItem.getBatchProduction());
							Unqualifiedmedcstore unQuMedcStore = unqualifiedmedcstoreMng.findById(chItem.getBatchProduction());
							if(quMedcStore!=null && chItem.getQuantity()!=null){
								quMedcStore.setQuantity(quMedcStore.getQuantity()+chItem.getQualifiedQuantity());
								qualifiedmedcstoreMng.updatequ(quMedcStore);
							}else {
								quMedcStore = new Qualifiedmedcstore();
								quMedcStore.setBatchproduction(chItem.getBatchProduction());
								quMedcStore.setCreatedate(ch.getApplicationTime());
								quMedcStore.setQualifiedmedicineid(chItem.getQualifiedMedicineId());
								quMedcStore.setQualityMidicine(chItem.getQualityMidicine());
								quMedcStore.setValiddate(chItem.getValidateDate());
								if(ch.getCheckAcceptDate()!=null){
									Calendar cal = Calendar.getInstance();
									SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");   
									Date time=null;
									try {
										time = formatDate.parse(ch.getCheckAcceptDate());
									} catch (java.text.ParseException e) {
										e.printStackTrace();
									}    
									cal.setTime(time);
									cal.add(Calendar.MONTH,Integer.parseInt(chItem.getQualityMidicine().getMaintainCycle())+3);
									quMedcStore.setNextmaintaindate(formatDate.format(cal.getTime()));
									//quMedcStore.setCreatedate(createdate)
								}
								quMedcStore.setQuantity(chItem.getQualifiedQuantity());
								qualifiedmedcstoreMng.savequ(quMedcStore);
							}
							if(unQuMedcStore==null && chItem.getUnqualifiedQuantity()>0){
								unQuMedcStore = new Unqualifiedmedcstore();
								unQuMedcStore.setQualifiedmedicineid(chItem.getQualifiedMedicineId());
								unQuMedcStore.setQuantity(chItem.getUnqualifiedQuantity());
								unQuMedcStore.setBatchproduction(chItem.getBatchProduction());
								unQuMedcStore.setValiddate(chItem.getValidateDate());
								unQuMedcStore.setStatus("1");
								unqualifiedmedcstoreMng.saveUnqualifiedmedcstore(unQuMedcStore);
							}else if(unQuMedcStore!=null && chItem.getUnqualifiedQuantity()>0){
								unQuMedcStore.setQuantity(unQuMedcStore.getQuantity()+chItem.getUnqualifiedQuantity());
								unqualifiedmedcstoreMng.saveOrUpdataHg(unQuMedcStore);
							/*	UnqualifiedManager unMedcstore = new UnqualifiedManager();
								//Qualifiedmedcstore qualifiedmedcstore = qualifiedmedcstoreMng.findByBaNo(chIts.get(j).getBatchProduction());
							//	unMedcstore.setQualifiedmedcstore(qu);
								unMedcstore.setQualifiedmedicineid(chItem.getQualifiedMedicineId());
								unMedcstore.setQuantity(chItem.getUnqualifiedQuantity());
								unMedcstore.setQualifiedpurchaseunitsid(ch.getQualifiedPurchaseUnitsId());
								unMedcstore.setBatchno(chItem.getBatchProduction());
								unMedcstore.setQualitysituation("");//处理结果
								unMedcstore.setRemark("");
								unMedcstore.setShipmentdate("");
								unMedcstore.setQualitysituation("");
								unMedcstore.setModifierid(user.getId());
								unMedcstore.setModifiedtime(new Date());
								unMedcstore.setQualifiedmedcstore(quMedcStore);
								unMedcstore.setQualifiedSuppliers(chItem.getQualityMidicine().getSupplyUnit());
								unMedcstore.setHarvestNumber("");
								unMedcstore.setUnqualified("");
								unMedcstore.setProcessingDate("");
								unMedcstore.setProcessingDate(DateTimeUtils.format(new Date(),"yyyy-MM-dd"));
								unMedcstore.setUser(user);
								unMedcstore.setMedicinalNo(chItem.getQualityMidicine().getMedicinalNo());
								unMedcstore.setValidUntil(chItem.getValidateDate());
								unqualifiedManagerMng.saveOrUpdata(unMedcstore);*/
							}
						}
					}
//			acceptanceMng.audit(ids[i]);sql方法更新，等待删除
				}
			}else if("1".equals(batch_type)){
				for(int i =0;i<ids.length;i++){
					ReturnCheckAcceptNote ch =returnTaceMng.findById(ids[i]);
					ch.setReviewStatus(3L);
					Date date = new Date();
					SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 		String modifyDate = modifyDateFormat.format(date);
			 		ch.setReviewTime(modifyDate);
					User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
					ch.setAuditorID(user.getId());
					returnTaceMng.update(ch);
//				acceptanceMng.audit(ids[i]);sql方法更新，等待删除
				}
		}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("审核退收验收管理", user.getRealname(), "审核", "药品状态管理  >退收验收管理", StringUtil.getIpAddr(request));
		return dshPage(null, request, response, model);
	}
	@RequestMapping("/drugState/checkreturn/shviewcheck.html")
	public ModelAndView auditOne(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		String type = request.getParameter("types");
		if(id!=null){
			ReturnCheckAcceptNote ch =returnTaceMng.findById(id);
			if(type!=null && !"".equals(type)){
				ch.setReviewStatus(Long.parseLong(type));
			}
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			returnTaceMng.update(ch);
			if(type.equals("2")){
			List<ReturncheckItem> checkItemList = returnTaceMng.find(id);
			if(checkItemList!=null){
				for(ReturncheckItem chItem : checkItemList){
					Qualifiedmedcstore quMedcStore = qualifiedmedcstoreMng.findByBaNo(chItem.getBatchProduction());
					Unqualifiedmedcstore unQuMedcStore = unqualifiedmedcstoreMng.findById(chItem.getBatchProduction());
					if(quMedcStore!=null && chItem.getQuantity()!=null){
						quMedcStore.setQuantity(quMedcStore.getQuantity()+chItem.getQualifiedQuantity());
						qualifiedmedcstoreMng.updatequ(quMedcStore);
					}else {
						quMedcStore = new Qualifiedmedcstore();
						quMedcStore.setBatchproduction(chItem.getBatchProduction());
						quMedcStore.setCreatedate(ch.getApplicationTime());
						quMedcStore.setQualifiedmedicineid(chItem.getQualifiedMedicineId());
						quMedcStore.setQualityMidicine(chItem.getQualityMidicine());
						quMedcStore.setValiddate(chItem.getValidateDate());
						if(ch.getCheckAcceptDate()!=null){
							Calendar cal = Calendar.getInstance();
							SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");   
							Date time=null;
							try {
								time = formatDate.parse(ch.getCheckAcceptDate());
							} catch (java.text.ParseException e) {
								e.printStackTrace();
							}    
							cal.setTime(time);
							cal.add(Calendar.MONTH,Integer.parseInt(chItem.getQualityMidicine().getMaintainCycle())+3);
							quMedcStore.setNextmaintaindate(formatDate.format(cal.getTime()));
							//quMedcStore.setCreatedate(createdate)
						}
						quMedcStore.setQuantity(chItem.getQualifiedQuantity());
						qualifiedmedcstoreMng.savequ(quMedcStore);
					}
					if(unQuMedcStore==null && chItem.getUnqualifiedQuantity()>0){
						unQuMedcStore = new Unqualifiedmedcstore();
						unQuMedcStore.setQualifiedmedicineid(chItem.getQualifiedMedicineId());
						unQuMedcStore.setQuantity(chItem.getUnqualifiedQuantity());
						unQuMedcStore.setBatchproduction(chItem.getBatchProduction());
						unQuMedcStore.setValiddate(chItem.getValidateDate());
						unQuMedcStore.setStatus("1");
						unqualifiedmedcstoreMng.saveUnqualifiedmedcstore(unQuMedcStore);
					}else if(unQuMedcStore!=null && chItem.getUnqualifiedQuantity()>0){
						unQuMedcStore.setQuantity(unQuMedcStore.getQuantity()+chItem.getUnqualifiedQuantity());
						unqualifiedmedcstoreMng.saveOrUpdataHg(unQuMedcStore);
					/*	UnqualifiedManager unMedcstore = new UnqualifiedManager();
						//Qualifiedmedcstore qualifiedmedcstore = qualifiedmedcstoreMng.findByBaNo(chIts.get(j).getBatchProduction());
					//	unMedcstore.setQualifiedmedcstore(qu);
						unMedcstore.setQualifiedmedicineid(chItem.getQualifiedMedicineId());
						unMedcstore.setQuantity(chItem.getUnqualifiedQuantity());
						unMedcstore.setQualifiedpurchaseunitsid(ch.getQualifiedPurchaseUnitsId());
						unMedcstore.setBatchno(chItem.getBatchProduction());
						unMedcstore.setQualitysituation("");//处理结果
						unMedcstore.setRemark("");
						unMedcstore.setShipmentdate("");
						unMedcstore.setQualitysituation("");
						unMedcstore.setModifierid(user.getId());
						unMedcstore.setModifiedtime(new Date());
						unMedcstore.setQualifiedmedcstore(quMedcStore);
						unMedcstore.setQualifiedSuppliers(chItem.getQualityMidicine().getSupplyUnit());
						unMedcstore.setHarvestNumber("");
						unMedcstore.setUnqualified("");
						unMedcstore.setProcessingDate("");
						unMedcstore.setProcessingDate(DateTimeUtils.format(new Date(),"yyyy-MM-dd"));
						unMedcstore.setUser(user);
						unMedcstore.setMedicinalNo(chItem.getQualityMidicine().getMedicinalNo());
						unMedcstore.setValidUntil(chItem.getValidateDate());
						unqualifiedManagerMng.saveOrUpdata(unMedcstore);*/
						
					}
				}
				}
			}	
			logService.addLog("审核退收验收管理", user.getRealname(), "审核", "药品状态管理  >退收验收管理", StringUtil.getIpAddr(request));
		}
		return dshPage(null, request, response, model);
	}
	
	/**
	 * 
	 * 已审核
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/checkreturn/yshlist.html")
	public ModelAndView yshPage(ReturnCheckAcceptNote mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		String ypname = request.getParameter("ypname");
		String yhDate = request.getParameter("yhdate");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setArrivalDate(yhDate);
		}
		if(mc==null){
			mc = new ReturnCheckAcceptNote();
		}
		//List<ReturnCheckAcceptNote> list = new ArrayList<ReturnCheckAcceptNote>();
		List<ReturnCheckAcceptNoteVO> list = null;
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list = returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "2", 0, Constants.pagesize);
		}
		else{
			//否者翻页查询
			list = returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "2", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		int resultSize = returnTaceMng.countReturnCheckAcceptNoteVOByConiction(yhDate, ypname, "2");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/checkreturn/yshlist");
	}
	@RequestMapping("/drugState/checkreturn/yshview.html")
	public ModelAndView yshviewlist(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);
		ReturnCheckAcceptNote ch =returnTaceMng.findById(id);
		List<ReturncheckItem> chIt=new ArrayList<ReturncheckItem>();
		QualifiedPurchaseUnits qu=new QualifiedPurchaseUnits();
		if(ch.getQualifiedPurchaseUnitsId()!=null && !"".equals(ch.getQualifiedPurchaseUnitsId())){
			qu=acceptanceMng.findgouhuo(ch.getQualifiedPurchaseUnitsId());
		}
		model.addAttribute("qu", qu);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			chIt= returnTaceMng.find(ch.getId(),0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			chIt= returnTaceMng.find(ch.getId(),(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		
		int resultSize = returnTaceMng.findCount(ch.getId());
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("mc", ch);
		model.addAttribute("id", id);
		model.addAttribute("chIt", chIt);
		model.addAttribute("storageStore", chIt.get(0).getQualityMidicine().getStorageStore());
		return new ModelAndView("drugState/checkreturn/yshview");
	}	
	@RequestMapping("/drugState/checkreturn/yshbackcheck.html")
	public ModelAndView yshback(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		if(id!=null && !"".equals(id)){
			ReturnCheckAcceptNote ch =returnTaceMng.findById(id);
			ch.setReviewStatus(4L);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			ch.setRejectFlag("1");
			returnTaceMng.update(ch);
			List<ReturncheckItem>  itemList = returnTaceMng.find(id);
			if(itemList != null && itemList.size()>0){
				for(ReturncheckItem item : itemList){
					Qualifiedmedcstore quMedcStore = qualifiedmedcstoreMng.findByBaNo(item.getBatchProduction());
					Unqualifiedmedcstore unQuMedcStore = unqualifiedmedcstoreMng.findById(item.getBatchProduction());
					if(quMedcStore != null ){
						if(item.getQualifiedQuantity() != null  && quMedcStore.getQuantity() > item.getQualifiedQuantity() ){
							quMedcStore.setQuantity(quMedcStore.getQuantity()-item.getQualifiedQuantity());
							qualifiedmedcstoreMng.updatequ(quMedcStore);
						}
					}
					if(unQuMedcStore != null){
						if(item.getUnqualifiedQuantity() != null &&  unQuMedcStore.getQuantity()> item.getUnqualifiedQuantity() ){
							unQuMedcStore.setQuantity(unQuMedcStore.getQuantity()-item.getUnqualifiedQuantity());
							unqualifiedmedcstoreMng.saveOrUpdataHg(unQuMedcStore);
						}
					}
					
				}
			}
		}
		return htPage(null, request, response, model);
	}
	
	/**
	 * 已审核申请回退
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @author whn
	 */
	@RequestMapping("/drugState/checkreturn/yshrollback.html")
	public ModelAndView yshrollback(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		
		//用于申请回退
		String type = request.getParameter("submitType");
		String roll_back_reason = request.getParameter("roll_back_reason");
		User applyUser = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		Map<String, Object> map = new HashMap<String, Object>();
		if(id!=null && !"".equals(id)){
			ReturnCheckAcceptNote ch =returnTaceMng.findById(id);
			
			if("2".equals(type)){
				
				
				try {
					ch.setReviewStatus(5L);
					if(ch.getRollback()!=null && !ch.getRollback().trim().equals("")){
					    ch.setRollback(String.valueOf(Long.parseLong(ch.getRollback())+1));	
					}else{
					ch.setRollback("1");
					}
					returnTaceMng.update(ch);
					
					rollBackRecordsManager.addReturnCheckAcceptRollBackRecords(ch.getId(), applyUser, roll_back_reason);
					map.put("success",URLEncoder.encode("申请回退成功！", "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				UtilJson.printMapJson(response, map);
				return null;
				
			}
				
		}else{
			try {
				map.put("success",URLEncoder.encode("申请回退失败！", "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UtilJson.printMapJson(response, map);
			return null;
		}
		return null;
	}
	/**
	 * 
	 * 已驳回
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/checkreturn/ybhlist.html")
	public ModelAndView ybhPage(ReturnCheckAcceptNote mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		String ypname = request.getParameter("ypname");
		String yhDate = request.getParameter("yhdate");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setArrivalDate(yhDate);
		}
		if(mc==null){
			mc = new ReturnCheckAcceptNote();
		}
		//List<ReturnCheckAcceptNote> list = new ArrayList<ReturnCheckAcceptNote>();
		List<ReturnCheckAcceptNoteVO> list = null;
		String pageNo = request.getParameter("thispage");
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//list= returnTaceMng.getPageybh(mc,0,Constants.pagesize);
			//list = returnTaceMng.getReturnCheckAcceptNoteByCondition(yhDate, ypname, "3",0, Constants.pagesize);
			list = returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "3",0, Constants.pagesize);
		}
		else{
			//否者翻页查询
			//list= returnTaceMng.getPageybh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			//list = returnTaceMng.getReturnCheckAcceptNoteByCondition(yhDate, ypname, "3", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			list = returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "3", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		//int resultSize = returnTaceMng.getTotalCountybh(mc);
		//int resultSize = returnTaceMng.countReturnCheckAcceptNoteByConiction(yhDate, ypname, "3");
		int resultSize = returnTaceMng.countReturnCheckAcceptNoteVOByConiction(yhDate, ypname, "3");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/checkreturn/ybhlist");
	}
	@RequestMapping("/drugState/checkreturn/ybhview.html")
	public ModelAndView ybhview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		ReturnCheckAcceptNote ch =returnTaceMng.findById(id);
		String page = DisplayGetPage.getPageParamName("records", request);
		List<ReturncheckItem> chIt=new ArrayList<ReturncheckItem>();
		QualifiedPurchaseUnits qu=new QualifiedPurchaseUnits();
		if(ch.getQualifiedPurchaseUnitsId()!=null && !"".equals(ch.getQualifiedPurchaseUnitsId())){
			qu=acceptanceMng.findgouhuo(ch.getQualifiedPurchaseUnitsId());
		}
		model.addAttribute("qu", qu);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			chIt= returnTaceMng.find(ch.getId(),0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			chIt= returnTaceMng.find(ch.getId(),(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		
		int resultSize = returnTaceMng.findCount(ch.getId());
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("mc", ch);
		model.addAttribute("chIt", chIt);
		return new ModelAndView("drugState/checkreturn/ybhview");
	}
	@RequestMapping("/drugState/checkreturn/bhback.html")
	public ModelAndView ybhaudit(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		if(id!=null){
			ReturnCheckAcceptNote ch =returnTaceMng.findById(id);
			ch.setReviewStatus(0L);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			returnTaceMng.update(ch);
			logService.addLog("驳回确认退收验收管理", user.getRealname(), "驳回确认", "药品状态管理  >退收验收管理", StringUtil.getIpAddr(request));
		}
		return ybhPage(null, request, response, model);
		
	}
	@RequestMapping("/drugState/checkreturn/findthd.html")
	public void findshd(HttpServletRequest request, HttpServletResponse response, Model model){
		List<ReturnReceivingNote> listpu= new ArrayList<ReturnReceivingNote>();
		//封装采购单json
		listpu=returnTaceMng.findthdJson();
//		String json = "[";
//		if(listpu!=null){
//			for(int i =0;i<listpu.size();i++){
//				if(listpu.get(i).getReturnNumber()!=null && !"".equals(listpu.get(i).getReturnNumber())){
//					json+="{";
//					json+="\"id\":"+listpu.get(i).getId()+",";
//					json+="\"text\":\""+listpu.get(i).getReturnNumber()+"\"";
//					if(i==listpu.size()-1){
//						json+="}";
//					}else{
//						json+="},";
//					}
//				}
//			}
//		}
//		json+="]";
		
		StringBuffer json = new StringBuffer("[");
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				if(listpu.get(i).getReturnNumber()!=null && !"".equals(listpu.get(i).getReturnNumber())){
					json.append("{");
					json.append("\"id\":"+listpu.get(i).getId()+",");
					json.append("\"text\":\""+listpu.get(i).getReturnNumber()+"\"");
					json.append("},");
				}
			}
		}
		if(json.toString().endsWith(",")){
			json = new StringBuffer(json.substring(0,json.length()-1));
		}
		json.append("]");
		
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/drugState/checkreturn/findthdItem.html")
	public void findshmx(String id, HttpServletRequest request, HttpServletResponse response, Model model){
		List<ReturnReceivingNoteItem> receItem= returnTaceMng.findthd(id);
		ReturnReceivingNote re = returnRecordsMng.findById(id);
		//ReturnCheckAcceptNote re = returnTaceMng.findById(id);
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		List<QualifiedEdit> qus =  new ArrayList<QualifiedEdit>();
		for(int j=0;j<receItem.size();j++){
			QualifiedEdit qu = new QualifiedEdit();
			ReturnReceivingNoteItem rece = receItem.get(j);
			qu.setBuhegeshu("");
			qu.setBuhegexiang("");
			qu.setHegeshuliang("");
			if(re!=null){
				if(re.getQualifiedPurchaseUnitsId()!=null && !"".equals(re.getQualifiedPurchaseUnitsId())){
					QualifiedPurchaseUnits purchaseUnit = purchaseUnitsService.get(re.getQualifiedPurchaseUnitsId());
					qu.setGouhuodanwei(purchaseUnit.getCustomerName());
					qu.setGouhuodanweiId(String.valueOf(purchaseUnit.getId()));
				}else{
					QualifiedPurchaseUnits qpu = inspectionMng.findGHSById(re.getQualifiedPurchaseUnitsId());
					if(qpu!=null){
						qu.setGouhuodanwei(qpu.getCustomerName());
						qu.setGouhuodanweiId((new Long(qpu.getId())).toString());
					}
				}
			}
			QualityMidicine qualifiedMedicine =inspectionMng.findHGYP(receItem.get(j).getQualifiedMedicineId());
			if(rece.getBatchProduction()!=null && !"".equals(rece.getBatchProduction().toString())){
				qu.setShengchanpihao(rece.getBatchProduction());
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
			if(qualifiedMedicine.getDosageforms()!=null){
				if(qualifiedMedicine.getDosageforms().getFormName()!=null){
					qu.setJixing(qualifiedMedicine.getDosageforms().getFormName());
				}else{
					qu.setJixing("");
				}
				if(qualifiedMedicine.getStorageStore()!=null){
					qu.setStorageStore(qualifiedMedicine.getStorageStore());
				}else{
					qu.setStorageStore("");
				}
			}else{
				qu.setJixing("");
			}
			if(rece.getSpecifications()!=null){
				qu.setGuige(rece.getSpecifications());
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
			if(rece.getEndTime()!=null){
				qu.setYouxiaoqizhi(rece.getEndTime());
			}else{
				qu.setYouxiaoqizhi("");
			}
			qu.setHegezheng("");
			qu.setReturnReason(re.getReturnReason());
			if(re.getGoodsClerk() != null && !"".equals(re.getGoodsClerk().trim())){
				User user = userManager.get(Long.parseLong(re.getGoodsClerk()));
				if(user != null)
					qu.setReceivePerson(user.getRealname());
			}
			qu.setTuihuoriq(re.getDeliveryDate());
			qus.add(qu);

		}
		List<String> jsonStringList = new ArrayList<String>();
		
		
		
		for(int i=0;i<qus.size();i++)
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
	@RequestMapping("/drugState/checkreturn/printCheckReturn.html")
	public String printCheckReturn(Model model ,HttpServletRequest request,HttpServletResponse response){
		String checkReturnId = request.getParameter("checkReturnId");
		ReturnCheckAcceptNote reNote = returnTaceMng.findById(checkReturnId);
		List<ReturncheckItem> reNoteItems = returnTaceMng.find(checkReturnId);
		String yanshourenyuan = userManager.get(reNote.getProposerID()).getRealname();
		//双人验收
		if(null!=reNote.getAccepterId() &&!"".equals(reNote.getAccepterId())){
			String yanshourenyuan2 = userManager.get(reNote.getAccepterId()).getRealname();
			if(null!=yanshourenyuan2&&!"".equalsIgnoreCase(yanshourenyuan2)){
				yanshourenyuan = yanshourenyuan +"，"+yanshourenyuan;
			}
		}
		String fujianrenyuan = userManager.get(reNote.getRecheckPersionId()).getRealname();
		List<QualityAcceptanceReportDto>  reportDtos = new ArrayList<QualityAcceptanceReportDto>();
		for(ReturncheckItem item : reNoteItems){
			MedicinePrice medcPrice = inspectionMng.getMedicPriceByNumber(item.getQualityMidicine().getMedicinalNo());
			reportDtos.add(new QualityAcceptanceReportDto(reNote,item,yanshourenyuan,fujianrenyuan,medcPrice));
		}
		/*if(reportDtos.size()<12){
			for(int i=0,length = 12-reportDtos.size(); i<length;i++){
				reportDtos.add(new QualityAcceptanceReportDto());
			}
		}*/
		model.addAttribute("reportDtos",reportDtos );
		return "/drugState/checkreturn/printCheckReturn";
	}
	@RequestMapping("/drugState/checkreturn/findCheckRetrunAcceptNotes.html")
	public String findCheckRetrunAcceptNotes(Model model, HttpServletRequest request, HttpServletResponse response){
		String  purchaseOrderId = request.getParameter("id");
		Long id = null;
		if(purchaseOrderId != null && !"".equals(purchaseOrderId)){
			id = Long.parseLong(purchaseOrderId);
		}else{
			id = Long.valueOf(0);
		}
		String hql = "select t from ReturnCheckAcceptNoteRecords t where t.returnCheckAcceptNoteId = :purchaseOrderId"; 
		String page = DisplayGetPage.getPageParamName("record", request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchaseOrderId", id);
		List<ReturnCheckAcceptNoteRecords> recordList = null;
		if(page == null || "".equals(page) || "null".equalsIgnoreCase(page)){
			recordList = recordsManager.getListByPage(hql,map , 0, Constants.pagesize);
		}else{
			recordList = recordsManager.getListByPage(hql,map , (Integer.parseInt(page)-1)*Constants.pagesize, Constants.pagesize);
		}
		int resultSize = recordsManager.getRecordCount("select count(*) from t_return_check_accept_note_records where return_check_accept_noteId = "+id);
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordList", recordList);
		return "/drugState/checkreturn/returnCheckAcceptNoteRecordList";
	}
	
	/**
	 * 
	 * 回退页面
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/checkreturn/htlist.html")
	public ModelAndView htPage(ReturnCheckAcceptNote mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		String ypname = request.getParameter("ypname");
		String yhDate = request.getParameter("yhdate");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setArrivalDate(yhDate);
		}
		if(mc==null){
			mc = new ReturnCheckAcceptNote();
		}
		//List<ReturnCheckAcceptNote> list = new ArrayList<ReturnCheckAcceptNote>();
		List<ReturnCheckAcceptNoteVO> list = null;
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list = returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "5", 0, Constants.pagesize);
		}
		else{
			//否者翻页查询
			list = returnTaceMng.getReturnCheckAcceptNoteVOByCondition(yhDate, ypname, "5", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		int resultSize = returnTaceMng.countReturnCheckAcceptNoteVOByConiction(yhDate, ypname, "5");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/checkreturn/htlist");
	}
	
	/**
	 * 查看回退记录
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/drugState/checkreturn/findCheckRetrunAcceptRollbackRecords.html")
	public String findCheckRetrunAcceptRollbackRecords(Model model, HttpServletRequest request, HttpServletResponse response){
		String  purchaseOrderId = request.getParameter("id");
		Long id = null;
		if(purchaseOrderId != null && !"".equals(purchaseOrderId)){
			id = Long.parseLong(purchaseOrderId);
		}else{
			id = Long.valueOf(0);
		}
		String hql = "select t from ReturnCheckAcceptRollBackRecords t where t.returnCheckAcceptNoteId = :purchaseOrderId"; 
		String page = DisplayGetPage.getPageParamName("record", request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchaseOrderId", id);
		List<ReturnCheckAcceptRollBackRecords> recordList = null;
		if(page == null || "".equals(page) || "null".equalsIgnoreCase(page)){
			recordList = rollBackRecordsManager.getListByPage(hql,map , 0, Constants.pagesize);
		}else{
			recordList = rollBackRecordsManager.getListByPage(hql,map , (Integer.parseInt(page)-1)*Constants.pagesize, Constants.pagesize);
		}
		int resultSize = rollBackRecordsManager.getRecordCount("select count(*) from t_return_check_accept_rollback_records where return_check_accept_noteId = "+id);
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordList", recordList);
		return "/drugState/checkreturn/htRecordList";
	}
	
	/**
	 * 查看回退
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/drugState/checkreturn/htview.html")
	public ModelAndView htviewlist(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);
		ReturnCheckAcceptNote ch =returnTaceMng.findById(id);
		List<ReturncheckItem> chIt=new ArrayList<ReturncheckItem>();
		QualifiedPurchaseUnits qu=new QualifiedPurchaseUnits();
		if(ch.getQualifiedPurchaseUnitsId()!=null && !"".equals(ch.getQualifiedPurchaseUnitsId())){
			qu=acceptanceMng.findgouhuo(ch.getQualifiedPurchaseUnitsId());
		}
		model.addAttribute("qu", qu);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			chIt= returnTaceMng.find(ch.getId(),0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			chIt= returnTaceMng.find(ch.getId(),(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		
		int resultSize = returnTaceMng.findCount(ch.getId());
		double size = resultSize;
		
		String hql = "select t from ReturnCheckAcceptRollBackRecords t where t.returnCheckAcceptNoteId = :purchaseOrderId order by id desc"; 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchaseOrderId", Long.valueOf(id));
		List<ReturnCheckAcceptRollBackRecords> recordList = null;
		if(ch.getReviewStatus() == 5){
			recordList = rollBackRecordsManager.getAllByState(hql,map);
			if(recordList != null && recordList.size() > 0){
				model.addAttribute("rollBackReason", recordList.get(0).getRollbackReason());
			}else{
				model.addAttribute("rollBackReason", "");
			}
		}
		
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("mc", ch);
		model.addAttribute("id", id);
		model.addAttribute("chIt", chIt);
		model.addAttribute("storageStore", chIt.get(0).getQualityMidicine().getStorageStore());
		return new ModelAndView("drugState/checkreturn/htview");
	}	
	
	
	
	
}
