package com.sinosoft.drugState.acceptance.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.sinosoft.drugState.acceptance.model.CheckAcceptNote;
import com.sinosoft.drugState.acceptance.model.CheckAcceptVO;
import com.sinosoft.drugState.acceptance.model.CheckacceptItem;
import com.sinosoft.drugState.acceptance.service.AcceptanceItemMng;
import com.sinosoft.drugState.acceptance.service.AcceptanceMng;
import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptNoteJH;
import com.sinosoft.drugState.acceptanceJH.service.AcceptanceJHMng;
import com.sinosoft.drugState.inspectionRecords.model.QualifiedEdit;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNote;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.mackNo.service.MakeNoMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;
import com.sinosoft.qualityRecords.unqualifiedManger.service.UnqualifiedManagerMng;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.user.UserManager;
import com.sinosoft.util.DateTimeUtils;
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
public class AcceptanceAct {
	@Autowired
	private AcceptanceMng acceptanceMng;
	@Autowired
	private AcceptanceItemMng acceptanceItemMng;
	@Autowired
	private InspectionMng inspectionMng;
	@Autowired
	private QualifiedmedcstoreMng qualifiedmedcstoreMng;
	@Autowired
	private QualifiedmedcstoreReMng qualifiedmedcstoreReMng;
	@Autowired
	private UnqualifiedmedcstoreMng unqualifiedmedcstoreMng;
	@Autowired
	private MakeNoMng makeNoMng;
	@Autowired
	private UnqualifiedManagerMng  unqualifiedManagerMng;
	@Autowired
	private SystemLogService logService;
	@Autowired
	private UserManager userManager;
	@Autowired
	private AcceptanceJHMng acceptanceJHMng;
	
	@RequestMapping("/drugState/checkaccept/list.html")
	public ModelAndView openFramePage(CheckAcceptNote mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<CheckAcceptVO> list = new ArrayList<CheckAcceptVO>();
		String ypname = request.getParameter("ypname");
		String yhDate = request.getParameter("yhdate");
		String pageNo = request.getParameter("thispage");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setArrivalDate(yhDate);
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= acceptanceMng.getPage(yhDate,ypname,"0",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= acceptanceMng.getPage(yhDate,ypname,"0",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = acceptanceMng.getTotalCount(mc);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/checkaccept/dlrlist");
	}
	@RequestMapping("/drugState/checkaccept/dlrlist.html")
	public ModelAndView dlrPage(CheckAcceptNote mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<CheckAcceptVO> list = null;
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
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= (ArrayList<CheckAcceptVO>) acceptanceMng.getPage(yhDate,ypname,"0",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= acceptanceMng.getPage(ypname,ypname,"0",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		//int resultSize = acceptanceMng.getTotalCount(mc);
		int resultSize = acceptanceMng.countTotalPage(yhDate,ypname , "0");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/checkaccept/dlrlist");
	}
	
	@RequestMapping("/drugState/checkaccept/dlradd.html")
	public ModelAndView dshadd(CheckAcceptNote mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String nonumber = makeNoMng.findNo(Constants.ACCEPTANCEACT);
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String number = format.format(now);
		if(nonumber!=null && !"".equals(nonumber) && number.equals(nonumber.substring(0, 8))){
			try {
				Long  n = Long.parseLong(nonumber)+1L;
				mc.setNumber(n.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			nonumber= number+"0001";
			mc.setNumber(nonumber);
		}
		SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd");
		String numbers = formats.format(now);
		mc.setArrivalDate(numbers);
		mc.setCheckAcceptDate(numbers);
		QualifiedSuppliers ssss = inspectionMng.findGYSById(1L);
		if(ssss!=null){
			model.addAttribute("gongyingshang",ssss.getPinyinCode()+"_"+ssss.getId());
		}
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		model.addAttribute("mc", mc);
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> qsmap= inspectionMng.gonghuoMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("drugState/checkaccept/dlradd");
	}
	@RequestMapping("/drugState/checkaccept/dlredit.html")
	public ModelAndView dshedit(CheckAcceptNote mc,String id, HttpServletRequest request, HttpServletResponse response,Model model){
		response.setCharacterEncoding("utf-8");
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		CheckAcceptNote mcs=acceptanceMng.findById(id);
		model.addAttribute("mc", mcs);
		List<CheckacceptItem> receItem= acceptanceMng.findYp(mcs.getId());
		List<QualifiedEdit> qus =  new ArrayList<QualifiedEdit>();
		for(int j=0;j<receItem.size();j++){
			QualifiedEdit qu = new QualifiedEdit();
			CheckacceptItem rece = receItem.get(j);
			QualityMidicine qualifiedMedicine = inspectionMng.findHGYP(receItem.get(j).getQualifiedMedicineId());
			if(rece.getProduceTime()!=null && !"".equals(rece.getProduceTime())){
				qu.setShengchanriqi(rece.getProduceTime());
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
			if(rece.getBatchProduction()!=null){
				qu.setShengchanpihao(rece.getBatchProduction().toString());
			}else{
				qu.setShengchanpihao("");
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
			if(rece.getEndTime()!=null){
				qu.setYouxiaoqizhi(rece.getEndTime());
			}else{
				qu.setYouxiaoqizhi("");
			}
			
			qu.setHegezheng("");
			if(rece.getQualifiedQuantity()!=null){
				qu.setHegeshuliang(rece.getQualifiedQuantity().toString());
			}else{
				qu.setHegeshuliang("");
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
			if(qualifiedMedicine!=null){
				if(qualifiedMedicine.getMedicinalAttribute()!=null){
					qu.setStorageConditions(qualifiedMedicine.getMedicinalAttribute());
				}else{
					qu.setStorageConditions("");
				}
				if(qualifiedMedicine.getStorageStore()!=null){
					qu.setStorageStore(qualifiedMedicine.getStorageStore());
				}else{
					qu.setStorageStore("");
				}
				
			}
			if(rece.getUnqualifiedAmount()!=null){
				qu.setBuhegeshu(rece.getUnqualifiedAmount());
			}else{
				qu.setBuhegeshu("");
			}
			if(rece.getUnqualifiedItems()!=null){
				qu.setBuhegexiang(rece.getUnqualifiedItems());
			}else{
				qu.setBuhegexiang("");
			}
			if(rece.getReturnGoods()!=null){
				qu.setChuzhicuoshi(rece.getReturnGoods());
			}else{
				qu.setChuzhicuoshi("");
			}
			qus.add(qu);
		}
		if(mcs.getQualifiedSupplierIds()!=null){
			model.addAttribute("gongyingshang", mcs.getQualifiedSupplierIds().getPinyinCode()+"_"+mcs.getQualifiedSupplierIds().getId());
		}else{
			model.addAttribute("gongyingshang","");
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
		Map<String, String> qsmap= inspectionMng.gonghuoMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("drugState/checkaccept/dlredit");
	}
	@RequestMapping("/drugState/checkaccept/dlrsave.html")
	public ModelAndView dlrsave(CheckAcceptNote mc, String counts,HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("submitType");
		Map<String, Object> map = new HashMap<String, Object>();
		
		if("0".equals(type)){
			mc.setReviewStatus(0);//带录入状态
			map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		}else if("1".equals(type) && mc.getCheckIsQualified().trim().equals("0")){
			mc.setReviewStatus(3);//已经确认状态
			map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		}else if("1".equals(type) && mc.getCheckIsQualified().trim().equals("1")){
			mc.setReviewStatus(1);//待审核状态
			map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		}
		//String nonumber = makeNoMng.mackNo(Constants.INSPECTIONRECORDSACT);
		Date date = new Date();
		if(mc.getQualifiedSupplierId()!=null){
			mc.setQualifiedSupplierIds(inspectionMng.findGYSById(mc.getQualifiedSupplierId()));
		}
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		String modifyDate = modifyDateFormat.format(date);
 		mc.setApplicationTime(modifyDate);
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		mc.setProposerID(user.getId());
		String nonumber = makeNoMng.mackNo(Constants.ACCEPTANCEACT);
		if(!mc.getNumber().equals(nonumber)){
			map.put("success", "1");
			map.put("number", nonumber);
			//mc.setNumber(nonumber);
		}else{
			map.put("success", "2");
		}
		CheckAcceptNote mcs=acceptanceMng.save(mc);
		if(!"".equals(counts) && counts!=null){//保存药品数据
			for(int i=0;i<Integer.parseInt(counts);i++){
				CheckacceptItem chIt= new CheckacceptItem();
				String pingming = request.getParameter("pinming"+i);
				String shuliang = request.getParameter("shuliang"+i);
				String jixing = request.getParameter("jixing"+i);
				String guige = request.getParameter("guige"+i);
			//	String shengchang = request.getParameter("shengchang"+i);
				String hegeshuliang=request.getParameter("hegeshuliang"+i);
				String pizhun = request.getParameter("pizhun"+i);
			//	String shangbiao = request.getParameter("shangbiao"+i);
				String shengchanpihao = request.getParameter("shengchanpihao"+i);
			//	String hege = request.getParameter("hege"+i);
				String youxiaoqi = request.getParameter("youxiaoqi"+i);
				String buhegeshu = request.getParameter("buhegeshu"+i);
				String buhegexiang = request.getParameter("buhegexiang"+i);
				String chuzhicuoshi = request.getParameter("chuzhicuoshi"+i);
				String shengchanriqi = request.getParameter("shengchanriqi"+i);
				if(shengchanriqi!=null){
					chIt.setProduceTime(shengchanriqi);
				}
				if(buhegeshu!=null){
					chIt.setUnqualifiedAmount(buhegeshu);
				}
				if(buhegexiang!=null){
					chIt.setUnqualifiedItems(buhegexiang);
				}
				if(chuzhicuoshi!=null){
					chIt.setReturnGoods(chuzhicuoshi);
				}
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
				chIt.setReceivingId(mcs.getId());
				chIt.setDosageForms(jixing);
				chIt.setLicenseNumber(pizhun);
				chIt.setSpecifications(guige);
				chIt.setBatchProduction(shengchanpihao);
				chIt.setEndTime(youxiaoqi);
				if(hegeshuliang!=null && !"".equals(hegeshuliang)){
					Double qualifiedQuantity = Double.parseDouble(hegeshuliang);
					chIt.setQualifiedQuantity(Long.valueOf(qualifiedQuantity.longValue()));
				}
				
				chIt = acceptanceItemMng.save(chIt);
				if(type!=null && type.equals("1") && mc.getCheckIsQualified().trim().equals("0")){
					Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(chIt.getBatchProduction());
					Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(chIt.getBatchProduction());
					
					if(unqu==null ){
						unqu = new Unqualifiedmedcstore();
						unqu.setQualifiedmedicineid(chIt.getQualifiedMedicineId());
						unqu.setValiddate(chIt.getEndTime());
						unqu.setQuantity(0L);
						unqu.setBatchproduction(chIt.getBatchProduction());
						unqu.setValiddate(chIt.getEndTime());
						unqu.setStatus("1");
						unqualifiedmedcstoreMng.saveUnqualifiedmedcstore(unqu);
					}
					if(qu!=null){
						//返厂药品，新的合格药品库中增加此批号的药品,验收日期与合格药品库中的创建日期不同时当做返厂处理
						
						QualifiedmedcstoreRe quRe = new QualifiedmedcstoreRe();
						
						QualityMidicine qm = inspectionMng.findHGYP(chIt.getQualifiedMedicineId());
						if(mcs.getCheckAcceptDate()!=null && !mcs.getCheckAcceptDate().equals(qu.getCreatedate())){
							if(mcs.getCheckAcceptDate()!=null && qm!=null){
								Calendar cal = Calendar.getInstance();
								SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");   
								Date time=null;
								try {
									time = formatDate.parse(mcs.getCheckAcceptDate());
								} catch (java.text.ParseException e) {
									e.printStackTrace();
								}    
								cal.setTime(time);
								cal.add(Calendar.MONTH,Integer.parseInt(qm.getMaintainCycle())+3);
								quRe.setNextmaintaindate(formatDate.format(cal.getTime()));
								quRe.setCreatedate(mcs.getCheckAcceptDate());
							}
							quRe.setBatchproduction(chIt.getBatchProduction());
							quRe.setQuantity(chIt.getQualifiedQuantity());
							quRe.setQualifiedmedicineid(chIt.getQualifiedMedicineId());
							quRe.setQualityMidicine(qm);
							quRe.setValiddate(chIt.getEndTime());
							quRe.setRe_flag(1);//1表示是返厂的
							qualifiedmedcstoreReMng.save(quRe);
						}
						
						
						//原合格药品库处理方法:如果此批号药品数量不为0，叠加数量；如果为0，叠加数量且更新下次养护日期。新的合格药品库可以不用管，有触发器会更新新表的数量和日期
						Long quant = qu.getQuantity();
						if(quant == null || (quant != null && quant == 0)){
							qu.setQuantity(chIt.getQualifiedQuantity());
							
							Calendar cal = Calendar.getInstance();
							SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");   
							Date time=null;
							try {
								time = formatDate.parse(mcs.getCheckAcceptDate());
							} catch (java.text.ParseException e) {
								e.printStackTrace();
							}    
							cal.setTime(time);
							cal.add(Calendar.MONTH,Integer.parseInt(qm.getMaintainCycle())+3);
							qu.setNextmaintaindate(formatDate.format(cal.getTime()));
							qu.setCreatedate(mcs.getCheckAcceptDate());
						}
						if(quant > 0){
							qu.setQuantity(chIt.getQualifiedQuantity()+qu.getQuantity());
							if(mcs!=null){
								qu.setCreatedate(mcs.getCheckAcceptDate());
							}
						}
						//QualityMidicine qm = inspectionMng.findHGYP(chIt.getQualifiedMedicineId());
						//qu.setQualityMidicine(qm);
						qualifiedmedcstoreMng.updatequ(qu);
						
						
					}else{
						qu=new Qualifiedmedcstore();
						ReceivingNote re = inspectionMng.findByNumber(mcs.getReceivingNumber());
						if(re!=null){
							qu.setReceivedDate(re.getReceivedDate());
						}
						qu.setQualifiedmedicineid(chIt.getQualifiedMedicineId());
						qu.setValiddate(chIt.getEndTime());
						qu.setQuantity(chIt.getQualifiedQuantity());
						qu.setBatchproduction(chIt.getBatchProduction());
//						DrugMaintenance dr = inspectionMng.findDrByNumber(chIts.get(j).getBatchProduction());
						QualityMidicine qm = inspectionMng.findHGYP(chIt.getQualifiedMedicineId());
						if(mcs.getCheckAcceptDate()!=null && qm!=null){
							Calendar cal = Calendar.getInstance();
							SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");   
							Date time=null;
							try {
								time = formatDate.parse(mcs.getCheckAcceptDate());
							} catch (java.text.ParseException e) {
								e.printStackTrace();
							}    
							cal.setTime(time);
							cal.add(Calendar.MONTH,Integer.parseInt(qm.getMaintainCycle())+3);
							qu.setNextmaintaindate(formatDate.format(cal.getTime()));
							qu.setCreatedate(mcs.getCheckAcceptDate());
						}
						qu.setQualityMidicine(qm);
						qualifiedmedcstoreMng.savequ(qu);
						//新的药品处理方法不变，数据库中增加触发器，原合格药品库新增时在新合格药品库中也新增
					}
				}
			}
		}
		//特殊药品处理
		if("1".equals(type)){
			List<CheckacceptItem> chList = acceptanceMng.findYp(mcs.getId());
			for(CheckacceptItem chItem :chList){
				if(null!= chItem.getQualityMidicine().getMedicineManagement()
						&&"专门管理要求药品".equals(chItem.getQualityMidicine().getMedicineManagement())){
					mcs.setReviewStatus(2);
				}
			}
			acceptanceMng.update(mcs);
		}
		
		logService.addLog("提交验收记录", user.getRealname(), "提交", "药品状态管理  >验收管理", StringUtil.getIpAddr(request));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/checkaccept/dlrupdate.html")
	public ModelAndView dshupdate(CheckAcceptNote mc,String counts, HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
 		String thispage=request.getParameter("thispage");
		String type = request.getParameter("submitType");
		Map<String, Object> map = new HashMap<String, Object>();
		if("0".equals(type)){
			mc.setReviewStatus(0);//带录入状态
			map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		}else if("1".equals(type) && mc.getCheckIsQualified().trim().equals("0")){
			mc.setReviewStatus(3);//已经确认状态
			map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		}else if("1".equals(type) && mc.getCheckIsQualified().trim().equals("1")){
			mc.setReviewStatus(1);//待审核状态
			map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		}
		model.addAttribute("thispage", thispage);
		Date date = new Date();
		if(mc.getQualifiedSupplierId()!=null){
			mc.setQualifiedSupplierIds(inspectionMng.findGYSById(mc.getQualifiedSupplierId()));
		}
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		String modifyDate = modifyDateFormat.format(date);
 		mc.setApplicationTime(modifyDate);
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		mc.setProposerID(user.getId());
		model.addAttribute("mc", mc);
		acceptanceMng.update(mc);
		//先删除后保存
		List<?> receItem= acceptanceMng.findAllId(mc.getId());
		acceptanceItemMng.del(receItem);
		if(!"".equals(counts) && null!=counts){
			for(int i=0;i<Integer.parseInt(counts);i++){
				CheckacceptItem chIt= new CheckacceptItem();
				String pingming = request.getParameter("pinming"+i);
				String shuliang = request.getParameter("shuliang"+i);
				String jixing = request.getParameter("jixing"+i);
				String guige = request.getParameter("guige"+i);
			    //String shengchang = request.getParameter("shengchang"+i);
				String hegeshuliang=request.getParameter("hegeshuliang"+i);
				String pizhun = request.getParameter("pizhun"+i);
			//	String shangbiao = request.getParameter("shangbiao"+i);
			//	String hege = request.getParameter("hege"+i);
				String youxiaoqi = request.getParameter("youxiaoqi"+i);
				String shengchanpihao = request.getParameter("shengchanpihao"+i);
				String buhegeshu = request.getParameter("buhegeshu"+i);
				String buhegexiang = request.getParameter("buhegexiang"+i);
				String chuzhicuoshi = request.getParameter("chuzhicuoshi"+i);
				String shengchanriqi = request.getParameter("shengchanriqi"+i);
				if(shengchanriqi!=null){
					chIt.setProduceTime(shengchanriqi);
				}
				if(buhegeshu!=null){
					chIt.setUnqualifiedAmount(buhegeshu);
				}
				if(buhegexiang!=null){
					chIt.setUnqualifiedItems(buhegexiang);
				}
				if(chuzhicuoshi!=null){
					chIt.setReturnGoods(chuzhicuoshi);
				}
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
				chIt.setEndTime(youxiaoqi);
				chIt.setReceivingId(mc.getId());
				chIt.setDosageForms(jixing);
				chIt.setLicenseNumber(pizhun);
				chIt.setSpecifications(guige);
				chIt.setBatchProduction(shengchanpihao);
				if(!"".equals(hegeshuliang) && null!= hegeshuliang){
					Double qualifiedQuantity = Double.parseDouble(hegeshuliang);
					chIt.setQualifiedQuantity(Long.valueOf(qualifiedQuantity.longValue()));
				}else{
					chIt.setQualifiedQuantity(0L);
				}
				chIt = acceptanceItemMng.save(chIt);
				if(type!=null && type.equals("1") && mc.getCheckIsQualified().trim().equals("0")){
					Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(chIt.getBatchProduction());
					Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(chIt.getBatchProduction());
					if(unqu==null ){
						unqu = new Unqualifiedmedcstore();
						unqu.setQualifiedmedicineid(chIt.getQualifiedMedicineId());
						unqu.setValiddate(chIt.getEndTime());
						unqu.setQuantity(0L);
						unqu.setBatchproduction(chIt.getBatchProduction());
						unqu.setValiddate(chIt.getEndTime());
						unqu.setStatus("1");
						unqualifiedmedcstoreMng.saveUnqualifiedmedcstore(unqu);
					}
					if(qu!=null){
						//返厂药品，新的合格药品库中增加此批号的药品,验收日期与合格药品库中的创建日期不同时当做返厂处理
						
						QualifiedmedcstoreRe quRe = new QualifiedmedcstoreRe();
						
						QualityMidicine qm = inspectionMng.findHGYP(chIt.getQualifiedMedicineId());
						if(mc.getCheckAcceptDate()!=null && mc.getCheckAcceptDate() != qu.getCreatedate()){
							if(mc.getCheckAcceptDate()!=null && qm!=null){
								Calendar cal = Calendar.getInstance();
								SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");   
								Date time=null;
								try {
									time = formatDate.parse(mc.getCheckAcceptDate());
								} catch (java.text.ParseException e) {
									e.printStackTrace();
								}    
								cal.setTime(time);
								cal.add(Calendar.MONTH,Integer.parseInt(qm.getMaintainCycle())+3);
								quRe.setNextmaintaindate(formatDate.format(cal.getTime()));
								quRe.setCreatedate(mc.getCheckAcceptDate());
							}
							quRe.setBatchproduction(chIt.getBatchProduction());
							quRe.setQuantity(chIt.getQualifiedQuantity());
							quRe.setQualifiedmedicineid(chIt.getQualifiedMedicineId());
							quRe.setQualityMidicine(qm);
							quRe.setValiddate(chIt.getEndTime());
							quRe.setRe_flag(1);//1表示是返厂的
							qualifiedmedcstoreReMng.updatequ(quRe);
						}
						
						//原合格药品库处理方法:如果此批号药品数量不为0，叠加数量；如果为0，叠加数量且更新下次养护日期。新的合格药品库可以不用管，有触发器会更新新表的数量和日期
						Long quant = qu.getQuantity();
						if(quant == null || (quant != null && quant == 0)){
							qu.setQuantity(chIt.getQualifiedQuantity());
							
							Calendar cal = Calendar.getInstance();
							SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");   
							Date time=null;
							try {
								time = formatDate.parse(mc.getCheckAcceptDate());
							} catch (java.text.ParseException e) {
								e.printStackTrace();
							}    
							cal.setTime(time);
							cal.add(Calendar.MONTH,Integer.parseInt(qm.getMaintainCycle())+3);
							qu.setNextmaintaindate(formatDate.format(cal.getTime()));
							qu.setCreatedate(mc.getCheckAcceptDate());
						}
						if(quant > 0){
							qu.setQuantity(chIt.getQualifiedQuantity()+qu.getQuantity());
							if(mc!=null){
								qu.setCreatedate(mc.getCheckAcceptDate());
							}
						}
						//QualityMidicine qm = inspectionMng.findHGYP(chIt.getQualifiedMedicineId());
						//qu.setQualityMidicine(qm);
						qualifiedmedcstoreMng.updatequ(qu);
					}else{
						qu=new Qualifiedmedcstore();
						ReceivingNote re = inspectionMng.findByNumber(mc.getReceivingNumber());
						if(re!=null){
							qu.setReceivedDate(re.getReceivedDate());
						}
						qu.setQualifiedmedicineid(chIt.getQualifiedMedicineId());
						qu.setValiddate(chIt.getEndTime());
						qu.setQuantity(chIt.getQualifiedQuantity());
						qu.setBatchproduction(chIt.getBatchProduction());
//						DrugMaintenance dr = inspectionMng.findDrByNumber(chIts.get(j).getBatchProduction());
						QualityMidicine qm = inspectionMng.findHGYP(chIt.getQualifiedMedicineId());
						if(mc.getCheckAcceptDate()!=null && qm!=null){
							Calendar cal = Calendar.getInstance();
							SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");   
							Date time=null;
							try {
								time = formatDate.parse(mc.getCheckAcceptDate());
							} catch (java.text.ParseException e) {
								e.printStackTrace();
							}    
							cal.setTime(time);
							cal.add(Calendar.MONTH,Integer.parseInt(qm.getMaintainCycle())*2);
							qu.setNextmaintaindate(formatDate.format(cal.getTime()));
							qu.setCreatedate(mc.getCheckAcceptDate());
						}
						qu.setQualityMidicine(qm);
						qualifiedmedcstoreMng.savequ(qu);
					}
				}
			}
		}
		//特殊药品处理
		if("1".equals(type)){
			List<CheckacceptItem> chList = acceptanceMng.findYp(mc.getId());
			for(CheckacceptItem chItem :chList){
				if(null!= chItem.getQualityMidicine().getMedicineManagement()
						&&"专门管理要求药品".equals(chItem.getQualityMidicine().getMedicineManagement())){
					mc.setReviewStatus(2);
				}
			}
			acceptanceMng.update(mc);
		}
		
		logService.addLog("审核验收记录", user.getRealname(), "审核", "药品状态管理  >验收管理", StringUtil.getIpAddr(request));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/checkaccept/dlrdel.html")
	public ModelAndView deldlr(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		if(ids!=null && !"".equals(ids)){
			for(int i= 0;i<ids.length;i++){
				acceptanceMng.del(ids[i]);
				List<?> receItem= acceptanceMng.findAllId(Long.parseLong(ids[i]));
				if(receItem!=null && receItem.size()>0){
					acceptanceItemMng.del(receItem);
				}
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除验收记录", user.getRealname(), "删除", "药品状态管理  >验收管理", StringUtil.getIpAddr(request));
		return dlrPage(null, request, response, model);
		
	}
	
	
	
	/**
	 * 待审核
	 * **/
	@RequestMapping("/drugState/checkaccept/dshlist.html")
	public ModelAndView dshPage(CheckAcceptNote mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<CheckAcceptVO> list = new ArrayList<CheckAcceptVO>();
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
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= acceptanceMng.getPage(yhDate, ypname, "1",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= acceptanceMng.getPage(yhDate, ypname, "1",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
	//	int resultSize = acceptanceMng.getTotalCountDsh(mc);
		int resultSize = acceptanceMng.countTotalPage(yhDate,ypname , "1");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/checkaccept/dshlist");
	}
	
	@RequestMapping("/drugState/checkaccept/dshview.html")
	public ModelAndView dshview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		CheckAcceptNote ch =acceptanceMng.findById(id);
		String page = DisplayGetPage.getPageParamName("records", request);
		List<CheckacceptItem> chIt=new ArrayList<CheckacceptItem>();
		QualifiedSuppliers qs=new QualifiedSuppliers();
		if(ch.getQualifiedSupplierId()!=null && !"".equals(ch.getQualifiedSupplierId())){
			qs=acceptanceMng.findgonghuo(ch.getQualifiedSupplierId());
		}
		model.addAttribute("qs", qs);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			chIt= acceptanceMng.find(ch.getId(),0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			chIt= acceptanceMng.find(ch.getId(),(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = acceptanceMng.findCount(ch.getId());
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("chIt", chIt);
		model.addAttribute("mc", ch);
		return new ModelAndView("drugState/checkaccept/dshview");
	}
	@RequestMapping("/drugState/checkaccept/audit.html")
	public ModelAndView audit(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		
		Date date = new Date();
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
 		String modifyDate = modifyDateFormat.format(date);
		if(ids!=null && !"".equals(ids)){
				for(int i =0;i<ids.length;i++){
					String specialManage = "0";
					CheckAcceptNote ch =acceptanceMng.findById(ids[i]);
					List<CheckacceptItem> chIts=acceptanceMng.findYp(ch.getId());
					
					if(null!=chIts){
						for(CheckacceptItem chItem:chIts){
							if(null!= chItem.getQualityMidicine().getMedicineManagement()
									&&"专门管理要求药品".equals(chItem.getQualityMidicine().getMedicineManagement())){
								specialManage = "1";
							}
						}
					}
					
					if("1".equals(specialManage)){
						if("1".equals(ch.getCheckIsQualified()) || ch.getCheckIsQualified2().trim().equals("1")){//第一个人验收不合格
							if(chIts!=null){
								for(int j=0;j<chIts.size();j++){
									Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(chIts.get(j).getBatchProduction());
									Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(chIts.get(j).getBatchProduction());
									if(unqu==null){
										unqu = new Unqualifiedmedcstore(); 
										unqu.setBatchproduction(chIts.get(j).getBatchProduction());
										unqu.setQualifiedmedicineid(chIts.get(j).getQualifiedMedicineId());
										unqu.setValiddate(chIts.get(j).getEndTime());
										if(chIts.get(j).getUnqualifiedAmount()!= null && !"".equals(chIts.get(j).getUnqualifiedAmount().trim())){
											Double quantity = Double.parseDouble(chIts.get(j).getUnqualifiedAmount());
											unqu.setQuantity(Long.valueOf(quantity.longValue()));
										}else{
											unqu.setQuantity(Long.valueOf(0));
										}
										
										unqu.setStatus("1");
										if(chIts.get(j).getReturnGoods()==null){
											unqu.setStatus("0");
										}else if(chIts.get(j).getReturnGoods().trim().equals("")){
											unqu.setStatus("0");
										}
										if(chIts.get(j).getUnqualifiedAmount()==null ){
											unqu.setStatus("0");
										}else if(chIts.get(j).getUnqualifiedAmount().trim().equals("") || chIts.get(j).getUnqualifiedAmount().trim().equals("0") || chIts.get(j).getUnqualifiedAmount().trim().equals("0.00")){
											unqu.setStatus("0");
										}
										
										unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
									}else{
										unqu.setQuantity(unqu.getQuantity()+chIts.get(j).getQuantity());
										unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
									}
									if(qu!=null){
										qu.setQuantity(qu.getQuantity()+chIts.get(j).getQualifiedQuantity());
										if(ch!=null){
											qu.setCreatedate(ch.getCheckAcceptDate());
										}
										qualifiedmedcstoreMng.updatequ(qu);
									}else{
										qu = new Qualifiedmedcstore();
										ReceivingNote re = inspectionMng.findByNumber(ch.getReceivingNumber());
										if(re!=null){
											qu.setReceivedDate(re.getReceivedDate());
										}
										qu.setQualifiedmedicineid(chIts.get(j).getQualifiedMedicineId());
										qu.setValiddate(chIts.get(j).getEndTime());
										qu.setQuantity(chIts.get(j).getQualifiedQuantity());
										qu.setBatchproduction(chIts.get(j).getBatchProduction());
										QualityMidicine qm = inspectionMng.findHGYP(chIts.get(j).getQualifiedMedicineId());
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
											cal.add(Calendar.MONTH,Integer.parseInt(qm.getMaintainCycle())*2);
											qu.setNextmaintaindate(formatDate.format(cal.getTime()));
											qu.setCreatedate(ch.getCheckAcceptDate());
										}
										qu.setQualityMidicine(qm);
										qualifiedmedcstoreMng.savequ(qu);
										
									}
								}
							}
						}
						
						ch.setReviewStatus(3);
						ch.setReviewTime(modifyDate);
						ch.setAuditorID(user.getId());
						acceptanceMng.update(ch);
					}else{
						ch.setReviewStatus(2);
				 		ch.setReviewTime(modifyDate);
						ch.setAuditorID(user.getId());
						acceptanceMng.update(ch);
					}
					
					logService.addLog("审核验收记录", user.getRealname(), "审核", "药品状态管理  >验收管理", StringUtil.getIpAddr(request));
				}
		}
		return dshPage(null, request, response, model);
	}
	@RequestMapping("/drugState/checkaccept/shviewcheck.html")
	public ModelAndView auditOne(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		response.setCharacterEncoding("utf-8");
		String type=request.getParameter("types");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		Date date = new Date();
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		String modifyDate = modifyDateFormat.format(date);
		String specialManage = "0";
		String counts = request.getParameter("counts");
		if(id!=null){
			CheckAcceptNote ch =acceptanceMng.findById(id);
			
			List<CheckacceptItem> chIts=acceptanceMng.findYp(ch.getId());
			if(null!=chIts){
				for(CheckacceptItem chItem:chIts){
					if(null!= chItem.getQualityMidicine().getMedicineManagement()
							&&"专门管理要求药品".equals(chItem.getQualityMidicine().getMedicineManagement())){
						specialManage = "1";
					}
				}
			}
			if("1".equals(specialManage)){
				//特殊药品
				if(ch.getCheckIsQualified().trim().equals("1") || ch.getCheckIsQualified2().trim().equals("1")){//第一个人或者第二个人验收不合格
					if(!"".equals(counts) && null!=counts){
						//先删除后保存
						List<?> receItem= acceptanceMng.findAllId(ch.getId());
						acceptanceItemMng.del(receItem);
						for(int i=0;i<Integer.parseInt(counts);i++){
							CheckacceptItem chIt= new CheckacceptItem();
							String pingmingNumber = request.getParameter("pingmingNumber"+i);
							String shuliang = request.getParameter("shuliang"+i);
							String jixing = request.getParameter("jixing"+i);
							String guige = request.getParameter("guige"+i);
							String pizhun = request.getParameter("pizhunwenhao"+i);
							String youxiaoqi = request.getParameter("youxiaoqizhi"+i);
							String shengchanpihao = request.getParameter("pihao"+i);
							String buhegexiang = request.getParameter("buhegexiang"+i);
							String chuzhicuoshi = request.getParameter("chuzhicuoshi"+i);
							String shengchanriqi = request.getParameter("shengchanriqi"+i);
							String buhegeshu = request.getParameter("buhegeshuliang"+i);
							
							String hegeshuliang = request.getParameter("hegeshuliang"+i);
							if(shengchanriqi!=null){
								chIt.setProduceTime(shengchanriqi);
							}
							if(buhegeshu!=null){
								chIt.setUnqualifiedAmount(buhegeshu);
							}
							if(buhegexiang!=null){
								chIt.setUnqualifiedItems(buhegexiang);
							}
							if(chuzhicuoshi!=null){
								chIt.setReturnGoods(chuzhicuoshi);
							}
							if(pingmingNumber!=null && !"".equals(pingmingNumber)){
								chIt.setQualifiedMedicineId(Long.parseLong(pingmingNumber.trim()));
								chIt.setQualityMidicine(inspectionMng.findYpById(pingmingNumber.trim()));
							}else{
								continue;
							}
							if(shuliang!=null && !"".equals(shuliang)){
								chIt.setQuantity(Long.parseLong(shuliang));
							}else{
								continue;
							}
							chIt.setEndTime(youxiaoqi);
							chIt.setReceivingId(ch.getId());
							chIt.setDosageForms(jixing);
							chIt.setLicenseNumber(pizhun);
							chIt.setSpecifications(guige);
							chIt.setBatchProduction(shengchanpihao);
							if(!"".equals(hegeshuliang) && null!= hegeshuliang){
								Double qualifiedQuantity = Double.parseDouble(hegeshuliang.trim());
								chIt.setQualifiedQuantity(qualifiedQuantity.longValue());
							}else{
								chIt.setQualifiedQuantity(0L);
							}
							chIt = acceptanceItemMng.save(chIt);
							
							
							
							Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(chIts.get(i).getBatchProduction());
							Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(chIts.get(i).getBatchProduction());
							if(unqu==null){
								unqu = new Unqualifiedmedcstore(); 
								unqu.setBatchproduction(chIts.get(i).getBatchProduction());
								unqu.setQualifiedmedicineid(chIts.get(i).getQualifiedMedicineId());
								unqu.setValiddate(chIts.get(i).getEndTime());
								if(chIts.get(i).getUnqualifiedAmount()!= null && !"".equals(chIts.get(i).getUnqualifiedAmount().trim())){
									Double quantity = Double.parseDouble(chIts.get(i).getUnqualifiedAmount());
									unqu.setQuantity(Long.valueOf(quantity.longValue()));
								}else{
									unqu.setQuantity(Long.valueOf(0));
								}
								unqu.setStatus("1");
								if(chIt.getReturnGoods()==null){
									unqu.setStatus("0");
								}else if(chIt.getReturnGoods().trim().equals("")){
									unqu.setStatus("0");
								}
								if(chIt.getUnqualifiedAmount()==null ){
									unqu.setStatus("0");
								}else if(chIt.getUnqualifiedAmount().trim().equals("") || chIt.getUnqualifiedAmount().trim().equals("0") || chIt.getUnqualifiedAmount().trim().equals("0.00")){
									unqu.setStatus("0");
								}
								
								unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
							}else{
								unqu.setQuantity(unqu.getQuantity()+chIts.get(i).getQuantity());
								unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
							}
							if(qu!=null){
								qu.setQuantity(qu.getQuantity()+chIts.get(i).getQualifiedQuantity());
								if(ch!=null){
									qu.setCreatedate(ch.getCheckAcceptDate());
								}
								qualifiedmedcstoreMng.updatequ(qu);
							}else{
								qu = new Qualifiedmedcstore();
								ReceivingNote re = inspectionMng.findByNumber(ch.getReceivingNumber());
								if(re!=null){
									qu.setReceivedDate(re.getReceivedDate());
								}
								qu.setQualifiedmedicineid(chIts.get(i).getQualifiedMedicineId());
								qu.setValiddate(chIts.get(i).getEndTime());
								qu.setQuantity(chIts.get(i).getQualifiedQuantity());
								qu.setBatchproduction(chIts.get(i).getBatchProduction());
								QualityMidicine qm = inspectionMng.findHGYP(chIts.get(i).getQualifiedMedicineId());
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
									cal.add(Calendar.MONTH,Integer.parseInt(qm.getMaintainCycle())*2);
									qu.setNextmaintaindate(formatDate.format(cal.getTime()));
									qu.setCreatedate(ch.getCheckAcceptDate());
								}
								qu.setQualityMidicine(qm);
								qualifiedmedcstoreMng.savequ(qu);
								
							}
						}
					}
				}
				
				ch.setReviewStatus(3);
				ch.setReviewTime(modifyDate);
				ch.setAuditorID(user.getId());
				acceptanceMng.update(ch);
			}else{
				//非特殊药品处理
				
				//不处理合格品记录,但是需要保存页面数据
				if(!"".equals(counts) && null!=counts){
					//先删除后保存
					List<?> receItem= acceptanceMng.findAllId(ch.getId());
					acceptanceItemMng.del(receItem);
					for(int i=0;i<Integer.parseInt(counts);i++){
						CheckacceptItem chIt= new CheckacceptItem();
						String pingmingNumber = request.getParameter("pingmingNumber"+i);
						String shuliang = request.getParameter("shuliang"+i);
						String jixing = request.getParameter("jixing"+i);
						String guige = request.getParameter("guige"+i);
						String pizhun = request.getParameter("pizhunwenhao"+i);
						String youxiaoqi = request.getParameter("youxiaoqizhi"+i);
						String shengchanpihao = request.getParameter("pihao"+i);
						String buhegexiang = request.getParameter("buhegexiang"+i);
						String chuzhicuoshi = request.getParameter("chuzhicuoshi"+i);
						String shengchanriqi = request.getParameter("shengchanriqi"+i);
						String buhegeshu = request.getParameter("buhegeshuliang"+i);
						
						String hegeshuliang = null;
						if(shengchanriqi!=null){
							chIt.setProduceTime(shengchanriqi);
						}
						if(buhegeshu!=null){
							chIt.setUnqualifiedAmount(buhegeshu);
						}
						if(buhegexiang!=null){
							chIt.setUnqualifiedItems(buhegexiang);
						}
						if(chuzhicuoshi!=null){
							chIt.setReturnGoods(chuzhicuoshi);
						}
						if(pingmingNumber!=null && !"".equals(pingmingNumber)){
							chIt.setQualifiedMedicineId(Long.parseLong(pingmingNumber.trim()));
							chIt.setQualityMidicine(inspectionMng.findYpById(pingmingNumber.trim()));
						}else{
							continue;
						}
						if(shuliang!=null && !"".equals(shuliang)){
							chIt.setQuantity(Long.parseLong(shuliang));
						}else{
							continue;
						}
						chIt.setEndTime(youxiaoqi);
						chIt.setReceivingId(ch.getId());
						chIt.setDosageForms(jixing);
						chIt.setLicenseNumber(pizhun);
						chIt.setSpecifications(guige);
						chIt.setBatchProduction(shengchanpihao);
						if(!"".equals(hegeshuliang) && null!= hegeshuliang){
							chIt.setQualifiedQuantity(Long.parseLong(hegeshuliang.trim()));
						}else{
							chIt.setQualifiedQuantity(0L);
						}
						chIt = acceptanceItemMng.save(chIt);
						
					}
				}
				
				ch.setReviewStatus(2);
		 		ch.setReviewTime(modifyDate);
				ch.setAuditorID(user.getId());
				acceptanceMng.update(ch);
			}
			
			logService.addLog("审核验收记录", user.getRealname(), "审核", "药品状态管理  >验收管理", StringUtil.getIpAddr(request));
		}
		return dshPage(null, request, response, model);
	}
	/**
	 * 
	 * 已审核
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/checkaccept/yshlist.html")
	public ModelAndView yshPage(CheckAcceptNote mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<CheckAcceptVO> list = new ArrayList<CheckAcceptVO>();
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
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= acceptanceMng.getPage(yhDate, ypname, "2",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= acceptanceMng.getPage(yhDate, ypname, "2",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		
		//int resultSize = acceptanceMng.getTotalCountysh(mc);
		int resultSize = acceptanceMng.countTotalPage(yhDate,ypname , "2");
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/checkaccept/yshlist");
	}
	@RequestMapping("/drugState/checkaccept/yshview.html")
	public ModelAndView yshview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		CheckAcceptNote ch =acceptanceMng.findById(id);
		String page = DisplayGetPage.getPageParamName("records", request);
		List<CheckacceptItem> chIt=new ArrayList<CheckacceptItem>();
		
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			chIt= acceptanceMng.find(ch.getId(),0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			chIt= acceptanceMng.find(ch.getId(),(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		QualifiedSuppliers qs=new QualifiedSuppliers();
		if(ch.getQualifiedSupplierId()!=null && !"".equals(ch.getQualifiedSupplierId())){
			qs=acceptanceMng.findgonghuo(ch.getQualifiedSupplierId());
		}
		//特殊验收
		String specialManegement = "0";//不是双人验收 
		for(CheckacceptItem chItem :chIt){
			if(null!= chItem.getQualityMidicine().getMedicineManagement()
					&&"专门管理要求药品".equals(chItem.getQualityMidicine().getMedicineManagement())){
				specialManegement = "1";
			}
		}
		model.addAttribute("specialManegement", specialManegement);
		model.addAttribute("qs", qs);
		int resultSize = acceptanceMng.findCount(ch.getId());
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("chIt", chIt);
		model.addAttribute("mc", ch);
		
		return new ModelAndView("drugState/checkaccept/yshview");
	}
	/**
	 * 确认
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/drugState/checkaccept/backcheck.html")
	public ModelAndView yshback(String id,String specialManegement, HttpServletRequest request, HttpServletResponse response,Model model){
		String checkConclusion2 = null;
		String result2 = null;
		String checkIsQualified2 = null;
		try {
			checkConclusion2 = new String(request.getParameter("checkConclusion2").getBytes("iso-8859-1"),"utf-8");
			result2 = new String(request.getParameter("result2").getBytes("iso-8859-1"),"utf-8");
			checkIsQualified2 = new String(request.getParameter("checkIsQualified2").getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if("0".equals(specialManegement)){
			
			if(id!=null && !"".equals(id)){
				CheckAcceptNote ch =acceptanceMng.findById(id);
				User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
				List<CheckacceptItem> chIts=acceptanceMng.findYp(ch.getId());
				if(chIts!=null){
					for(int j=0;j<chIts.size();j++){
						Qualifiedmedcstore qu = qualifiedmedcstoreMng.findByBaNo(chIts.get(j).getBatchProduction());
						Unqualifiedmedcstore unqu=unqualifiedmedcstoreMng.findById(chIts.get(j).getBatchProduction());
						if(unqu==null){
							unqu = new Unqualifiedmedcstore();
							unqu.setBatchproduction(chIts.get(j).getBatchProduction());
							unqu.setQualifiedmedicineid(chIts.get(j).getQualifiedMedicineId());
							unqu.setValiddate(chIts.get(j).getEndTime());
							if(chIts.get(j).getUnqualifiedAmount()!= null && !"".equals(chIts.get(j).getUnqualifiedAmount().trim())){
								Double quantity = Double.parseDouble(chIts.get(j).getUnqualifiedAmount());
								unqu.setQuantity(Long.valueOf(quantity.longValue()));
								//unqu.setQuantity(Long.valueOf(chIts.get(j).getUnqualifiedAmount()));
							}else{
								unqu.setQuantity(Long.valueOf(0));
							}
							
							unqu.setStatus("1");
							if(chIts.get(j).getReturnGoods()==null){
								unqu.setStatus("0");
							}else if(chIts.get(j).getReturnGoods().trim().equals("")){
								unqu.setStatus("0");
							}
							if(chIts.get(j).getUnqualifiedAmount()==null ){
								unqu.setStatus("0");
							}else if(chIts.get(j).getUnqualifiedAmount().trim().equals("") || chIts.get(j).getUnqualifiedAmount().trim().equals("0") || chIts.get(j).getUnqualifiedAmount().trim().equals("0.00")){
								unqu.setStatus("0");
							}
							
							unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
						}else{
							unqu.setQuantity(unqu.getQuantity()+chIts.get(j).getQuantity());
							unqualifiedmedcstoreMng.saveOrUpdataHg(unqu);
						}
						if(qu!=null){
							qu.setQuantity(qu.getQuantity()+chIts.get(j).getQualifiedQuantity());
							if(ch!=null){
								qu.setCreatedate(ch.getCheckAcceptDate());
							}
							qualifiedmedcstoreMng.updatequ(qu);
						}else{
							qu = new Qualifiedmedcstore();
							ReceivingNote re = inspectionMng.findByNumber(ch.getReceivingNumber());
							if(re!=null){
								qu.setReceivedDate(re.getReceivedDate());
							}
							qu.setQualifiedmedicineid(chIts.get(j).getQualifiedMedicineId());
							qu.setValiddate(chIts.get(j).getEndTime());
							qu.setQuantity(chIts.get(j).getQualifiedQuantity());
							qu.setBatchproduction(chIts.get(j).getBatchProduction());
//							DrugMaintenance dr = inspectionMng.findDrByNumber(chIts.get(j).getBatchProduction());
							QualityMidicine qm = inspectionMng.findHGYP(chIts.get(j).getQualifiedMedicineId());
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
							qualifiedmedcstoreMng.savequ(qu);
							
						}
					}
				}
				ch.setReviewStatus(3);
				Date date = new Date();
				SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 		String modifyDate = modifyDateFormat.format(date);
		 		ch.setReviewTime(modifyDate);
				//User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
				ch.setAuditorID(user.getId());
				acceptanceMng.update(ch);
			}
		}else if("1".equals(specialManegement)){//特殊验收
			CheckAcceptNote ch =acceptanceMng.findById(id);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String CheckAcceptDate = modifyDateFormat.format(date);
			
			//当都是合格的情况
			if(null!= ch.getCheckIsQualified()&&"0".equals(ch.getCheckIsQualified())
					&&null!=checkIsQualified2&&"0".equals(checkIsQualified2)){
				ch.setReviewStatus(3);
			}else{//有一个不合格则到批注
				ch.setReviewStatus(1);
			}
			ch.setCheckIsQualified2(checkIsQualified2);
			ch.setCheckAcceptDate2(CheckAcceptDate);
			ch.setResult2(result2);
			ch.setCheckConclusion2(checkConclusion2);
			ch.setReviewTime(CheckAcceptDate);
			ch.setAuditorID(user.getId());
			ch.setAccepterID(user.getId());
			acceptanceMng.update(ch);
		}
		return yshPage(null, request, response, model);
		
	}
	
	/**
	 * 
	 * 已驳回
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/checkaccept/ybhlist.html")
	public ModelAndView ybhPage(CheckAcceptNote mc, HttpServletRequest request, HttpServletResponse response,Model model){
		response.setCharacterEncoding("UTF-8");
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<CheckAcceptVO> list = new ArrayList<CheckAcceptVO>();
		String pageNo = request.getParameter("thispage");
		String ypname = request.getParameter("ypname");
		String yhDate = request.getParameter("yhdate");
		String ypType = request.getParameter("ypType");
		String ypTypeStr = null;
		if(ypType!=null && !ypType.trim().equals("")){
			if(ypType.equals("0")){
				ypTypeStr="一般药品";
			}else{
				ypTypeStr="专门管理要求药品";
			}
		}
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		model.addAttribute("ypType", ypType);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setArrivalDate(yhDate);
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= acceptanceMng.getPageByType3(yhDate, ypname, "3",ypTypeStr,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= acceptanceMng.getPageByType3(yhDate, ypname, "3",ypTypeStr,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		//int resultSize = acceptanceMng.getTotalCountybh(mc);
		//特殊处理
		for(CheckAcceptVO chVO:list){
			if(null!=chVO.getAccepterID()){
				User user = userManager.get(chVO.getAccepterID());
				chVO.setCheckUser2(user.getRealname());
			}
		}
		
		
		int resultSize = acceptanceMng.countTotalPageByType3(yhDate,ypname , "3",ypTypeStr);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/checkaccept/ybhlist");
	}
	@RequestMapping("/drugState/checkaccept/ybhview.html")
	public ModelAndView ybhview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		CheckAcceptNote ch =acceptanceMng.findById(id);
		String page = DisplayGetPage.getPageParamName("records", request);
		List<CheckacceptItem> chIt=new ArrayList<CheckacceptItem>();
		QualifiedSuppliers qs=new QualifiedSuppliers();
		if(ch.getQualifiedSupplierId()!=null && !"".equals(ch.getQualifiedSupplierId())){
			qs=acceptanceMng.findgonghuo(ch.getQualifiedSupplierId());
		}
		model.addAttribute("qs", qs);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			chIt= acceptanceMng.find(ch.getId(),0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			chIt= acceptanceMng.find(ch.getId(),(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = acceptanceMng.findCount(ch.getId());
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("ch", ch);
		model.addAttribute("chIt", chIt);
		model.addAttribute("mc", ch);
		return new ModelAndView("drugState/checkaccept/ybhview");
	}
	@RequestMapping("/drugState/checkaccept/bhback.html")
	public ModelAndView ybhaudit(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		if(id!=null){
			CheckAcceptNote ch =acceptanceMng.findById(id);
			ch.setReviewStatus(0);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			acceptanceMng.update(ch);
			logService.addLog("确认驳回验收记录", user.getRealname(), "确认驳回", "药品状态管理  >验收管理", StringUtil.getIpAddr(request));
		}
		return ybhPage(null, request, response, model);
	}
	@RequestMapping("/drugState/checkaccept/unqu.html")
	public ModelAndView unqu(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		CheckacceptItem ch =acceptanceItemMng.findById(id);
		CheckAcceptNote chs = new CheckAcceptNote();
		if(ch.getReceivingId()!=null){
			 chs =acceptanceMng.findById(ch.getReceivingId().toString());
		}
		if(chs.getQualifiedSupplierIds()!=null){
					model.addAttribute("gongyingshang",chs.getQualifiedSupplierIds().getPinyinCode()+"_"+chs.getQualifiedSupplierIds().getId() );	
		}else{
			model.addAttribute("gongyingshang", "");	
		}
		QualityMidicine qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		UnqualifiedManager qumr = new UnqualifiedManager();
		Qualifiedmedcstore qu = new Qualifiedmedcstore();
		qumr.setQualifiedmedcstore(qu);
		qumr.getQualifiedmedcstore().setQualityMidicine(qm);
		qumr.setUnqualified(ch.getUnqualifiedItems());
		if(ch.getUnqualifiedAmount()!=null &&!"".equals(ch.getUnqualifiedAmount())){
			try {
				Double quantity = Double.parseDouble(ch.getUnqualifiedAmount());
				qumr.setQuantity(quantity.longValue());
				//qumr.setQuantity(Long.parseLong(ch.getUnqualifiedAmount()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		qumr.setShipmentdate(chs.getArrivalDate());
		qumr.setBatchno(ch.getBatchProduction());
		model.addAttribute("um", qumr);
		return new ModelAndView("qualityRecords/unqualifiedManger/add");
	}
	@RequestMapping("/drugState/checkaccept/ajaxCompareNumber.html")
	public String ajaxCompareNumber(Model model ,HttpServletRequest request ,HttpServletResponse response){
		String  number = request.getParameter("number");
		String sql = "select count(*) from t_check_accept_note where 1=1 "; 
		Map<String, Object> map = new HashMap<String, Object>();
		if(number!=null && !number.trim().equals("")){
			sql = sql + " and number='"+number+"'";
		}else{
			map.put("success", "1");//表示number为空
			UtilJson.printMapJson(response, map);
		}
		int  count = acceptanceMng.getRecordCount(sql);
		if(count>0){
			map.put("success", "2");//表示number已经存在
			UtilJson.printMapJson(response, map);
		}else{
			map.put("success", "3");//表示number当前系统不存在可以使用该编号
			UtilJson.printMapJson(response, map);
		}
		return null;
	}
	@RequestMapping("/drugState/checkaccept/ajaxChangePrintFlag.html")
	public String ajaxChangePrintFlag(Model model,HttpServletRequest request,HttpServletResponse response){
		String  id = request.getParameter("acceptNoteId");
		CheckAcceptNote checkAcceptNote = acceptanceMng.findById(id);
		if(checkAcceptNote!=null){
			checkAcceptNote.setPrintFlag("1");
			acceptanceMng.update(checkAcceptNote);
		}
		return null;
	}
	@RequestMapping("/drugState/checkaccept/ajaxChangePrintFlagNew.html")
	public String ajaxChangePrintFlagNew(Model model,HttpServletRequest request,HttpServletResponse response){
		String  id = request.getParameter("acceptNoteId");
		String  flag = request.getParameter("flag");
		if(flag != null && !"".equals(flag) && flag.equals("0")){
			CheckAcceptNote checkAcceptNote = acceptanceMng.findById(id);
			if(checkAcceptNote!=null){
				checkAcceptNote.setPrintFlag("1");
				acceptanceMng.update(checkAcceptNote);
			}
		}
		if(flag != null && !"".equals(flag) && flag.equals("1")){
			CheckAcceptNoteJH checkAcceptNoteJH = acceptanceJHMng.findById(id);
			if(checkAcceptNoteJH!=null){
				checkAcceptNoteJH.setPrintFlag("1");
				acceptanceJHMng.update(checkAcceptNoteJH);
			}
		}
		
		return null;
	}
	
}
