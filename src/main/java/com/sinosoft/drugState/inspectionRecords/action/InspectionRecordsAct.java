package com.sinosoft.drugState.inspectionRecords.action;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrder;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.inspectionRecords.model.QualifiedEdit;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNote;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNoteItem;
import com.sinosoft.drugState.inspectionRecords.model.ReveivingNoteVO;
import com.sinosoft.drugState.inspectionRecords.model.TicketSamples;
import com.sinosoft.drugState.inspectionRecords.service.InspectItemMng;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.mackNo.service.MakeNoMng;
import com.sinosoft.drugState.price.MedicinePrice;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;
import com.sinosoft.drugState.purchaseNote.service.PurchaseNoteItemMng;
import com.sinosoft.drugState.purchaseNote.service.PurchaseNoteMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyDrugFroms;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualSupplyDrugFromsService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedSuppliersService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.user.UserManager;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.FileOperate;
import com.sinosoft.util.FileUtil;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;

@Controller
public class InspectionRecordsAct {
	@Autowired
	private PurchaseNoteItemMng purchaseNoteItemMng;
	@Autowired
	private MakeNoMng makeNoMng;
	private InspectionMng inspectionMng;
	private InspectItemMng inspectItemMng;
	@Autowired
	private PurchaseNoteMng purchaseNoteMng;
	@Autowired
	public void setInspectItemMng(InspectItemMng inspectItemMng) {
		this.inspectItemMng = inspectItemMng;
	}
	@Autowired
	private UserManager userManager;
	@Autowired
	public void setInspectionMng(InspectionMng inspectionMng) {
		this.inspectionMng = inspectionMng;
	}
	@Autowired
	private QualityMidicineMng qualityMidicineMng;
	@Autowired
	private QualifiedSuppliersService qualifiedSuppliersService;
	@Autowired
	private SystemLogService logService;
	@RequestMapping("/drugState/inspectionRecords/list.html")
	public ModelAndView openFramePage(ReceivingNote re, HttpServletRequest request, HttpServletResponse response, Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 绗嚑椤�
		if(re==null){
			re = new ReceivingNote();
		}
		String ypname = request.getParameter("ypname");
		String yhDate = request.getParameter("yhDate");
		String checkConclusion = request.getParameter("checkConclusion");
		String isfood = request.getParameter("isfood");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		model.addAttribute("checkConclusion", checkConclusion);
		model.addAttribute("isfood", isfood);
		String pageNo = request.getParameter("thispage");
		if(ypname !=null && !"".equals(ypname)){
			re.setCheckConclusion(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			re.setDeliveryDate(yhDate);
		}
		if(pageNo!=null){
			page=pageNo;
		}
		List<ReveivingNoteVO> reslist=new ArrayList<ReveivingNoteVO>();
		if(page==null){
			//濡傛灉page绛変簬绌猴紝榛樿浠庣涓�潯寮�鏌ヨ
			reslist= inspectionMng.getPageIsNotJh(yhDate,ypname,checkConclusion,isfood,0,Constants.pagesize);
		}
		else{
			//鍚﹁�缈婚〉鏌ヨ
			reslist= inspectionMng.getPageIsNotJh(yhDate,ypname,checkConclusion,isfood,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		TicketSamples ticketSamples = inspectionMng.getTicketSamplesByName("ticketSamples");
		model.addAttribute("ticketSamples", ticketSamples);
		TicketSamples stamp = inspectionMng.getTicketSamplesByName("stamp");
		model.addAttribute("stamp", stamp);
		int resultSize = inspectionMng.getTotalCountIsNotJh(yhDate,ypname,checkConclusion,isfood);
		double size = resultSize;
		//椤垫暟
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("re", re);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("drugState/inspectionRecords/list");
	}
	
	@RequestMapping("/drugState/inspectionRecords/add.html")
public ModelAndView add(ReceivingNote re,String id, HttpServletRequest request, HttpServletResponse response, Model model){
		String method = request.getParameter("method");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		ReceivingNote receivingNote=new ReceivingNote();
		String titles="添加";
		String nonumber = makeNoMng.findNo(Constants.INSPECTIONRECORDSACT);
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String number = format.format(now);
		if("add".equals(method)){
			SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd");
			String numbers = formats.format(now);
			receivingNote.setCheckConclusion("1");
			receivingNote.setReceivingAddress("北京市丰台区南三环中路20号");
			receivingNote.setReceivingUnit("同仁堂");
			receivingNote.setDeliveryDate(numbers);
			receivingNote.setReceivedDate(numbers);
		}
		if(nonumber!=null && !"".equals(nonumber) && number.equals(nonumber.substring(0, 8))){
			try {
				Long  n = Long.parseLong(nonumber)+1L;
				receivingNote.setNumber(n.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			nonumber= number+"0001";
			receivingNote.setNumber(nonumber);
		}
		if(!method.equals("add")){
			titles="修改";
			receivingNote=inspectionMng.findById(id);
			List<ReceivingNoteItem> receItem= inspectionMng.findYp(receivingNote.getId());
			List<QualifiedEdit> qus =  new ArrayList<QualifiedEdit>();
			for(int j=0;j<receItem.size();j++){
				QualifiedEdit qu = new QualifiedEdit();
				ReceivingNoteItem rece = receItem.get(j);
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
				}else{
					qu.setJixing("");
					qu.setStorageConditions("");
					qu.setStorageStore("");
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
				
				if(rece.getTkdat()!=null){
					qu.setShengchanriqi(rece.getTkdat());
				}else{
					qu.setShengchanriqi("");
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
		}
		if(receivingNote.getQualifiedSupplierId()!=null){
			model.addAttribute("gongyingshang", receivingNote.getQualifiedSupplierId().getPinyinCode()+"_"+receivingNote.getQualifiedSupplierId().getId());
		}else if("add".equals(method)){
			QualifiedSuppliers ssss = inspectionMng.findGYSById(1L);
			model.addAttribute("gongyingshang",ssss.getPinyinCode()+"_"+ssss.getId());
		}else{
			model.addAttribute("gongyingshang","");
		}
		model.addAttribute("titles", titles);
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> qsmap= inspectionMng.gonghuoMap();
		model.addAttribute("qsmap", qsmap);
		model.addAttribute("re", receivingNote);
		model.addAttribute("method", method);
		return new ModelAndView("drugState/inspectionRecords/add");
	}
	@RequestMapping("/drugState/inspectionRecords/saveOrUpdata.html")
	public ModelAndView saveOrUpdate(ReceivingNote re,String counts, HttpServletRequest request, HttpServletResponse response, Model model){
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("method");
		String ops = request.getParameter("thispage");
		Date date = new Date();
		String qualifiedSupplierIdValue = request.getParameter("qualifiedSupplierIdValue");
		QualifiedSuppliers sy = purchaseNoteMng.findByIdSy(qualifiedSupplierIdValue);
		re.setQualifiedSupplierId(sy);
//		SimpleDateFormat format = new SimpleDateFormat("yyyymmdd");
// 		String number = format.format(date);
//		re.setNumber(Long.parseLong(number));
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		String modifyDate = modifyDateFormat.format(date);
		re.setModifyDate(modifyDate);
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		re.setGoodsClerk(user.getId().toString());
		re.setUser(user);
		Map<String, Object> map = new HashMap<String, Object>();
		if(!op.equals("add")){
			map.put("success", "2");
		}else{
			String nonumber = makeNoMng.mackNo(Constants.INSPECTIONRECORDSACT);
			if(!re.getNumber().equals(nonumber)){
				map.put("success", "1");
				map.put("number", nonumber);
				re.setNumber(nonumber);
			}else{
				map.put("success", "2");
			}
		}
		ReceivingNote res =inspectionMng.saveReceivingNote(re);
		Long b = res.getId();
		String s =b.toString();
		List<?> list = inspectionMng.findAllId(s);
		inspectItemMng.del(list);
		if(counts!=null && !"".equals(counts)){
			for(int i=0;i<Integer.parseInt(counts);i++){
				ReceivingNoteItem receivingNoteItem = new ReceivingNoteItem();
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
				String tkdat = request.getParameter("shengchanriqi"+i);
				if(pingming!=null && !"".equals(pingming)){
					QualityMidicine qmdi =inspectionMng.findHGYP(Long.parseLong(pingming.trim()));
					receivingNoteItem.setQualifiedMedicineId(qmdi.getId());
				}else{
					continue;
				}
				if(shuliang!=null && !"".equals(shuliang)){
					try {
						receivingNoteItem.setQuantity(Long.parseLong(shuliang));
					} catch (Exception e) {
						receivingNoteItem.setQuantity(0L);
						e.printStackTrace();
					}
				}else{
					continue;
				}
				receivingNoteItem.setReceivingNoteId(res.getId());
				receivingNoteItem.setDosageForms(jixing);
				receivingNoteItem.setSpecifications(guige);
				receivingNoteItem.setLicenseNumber(pizhun);
				receivingNoteItem.setProduceNo(shengchang);
				receivingNoteItem.setBatchProduction(shengchanpihao);
				receivingNoteItem.setEndTime(youxiaoqi);
				receivingNoteItem.setTkdat(tkdat);
				inspectItemMng.saveReceivingNoteItem(receivingNoteItem);
			}
		}
		logService.addLog("新增收货记录", user.getRealname(), "新增", "药品状态管理  >收货管理", StringUtil.getIpAddr(request));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/inspectionRecords/del.html")
	public ModelAndView del(String ids[], HttpServletRequest request, HttpServletResponse response, Model model){
			inspectionMng.del(ids);
			if(ids!=null && !"".equals(ids)){
				for(int i=0;i<ids.length;i++){
					List<?> list = inspectionMng.findAllId(ids[i]);
					inspectItemMng.del(list);
				}
			}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除收货记录", user.getRealname(), "删除", "药品状态管理  >收货管理", StringUtil.getIpAddr(request));
		return openFramePage(null, request, response, model);
	}
	@RequestMapping("/drugState/inspectionRecords/quamap.html")
	public void findMq(String quamap, HttpServletRequest request, HttpServletResponse response, Model model){
	//	QualityMidicine qm= inspectionMng.findYpById(quamap);
		QualityMidicine qm = qualityMidicineMng.get(Long.valueOf(quamap));
		MedicinePrice medPrice = inspectionMng.getMedicPriceByNumber(qm.getMedicinalNo());
		String departmentId =  request.getParameter("departmentId");
		int year= 0;
		year=DateTimeUtils.getYear(DateTimeUtils.getNowDate());
		List<PurchasePlanStore> listpu= new ArrayList<PurchasePlanStore>();
		Long sumQm = new Long(0);
		//封装采购单json
		if(departmentId!=null &&  !"".equals(departmentId)){
			listpu= purchaseNoteItemMng.findMedicByYearAndDept(String.valueOf(year), departmentId);
		
			for (PurchasePlanStore purchasePlanStore : listpu) {
				if(purchasePlanStore.getQualityMidicineId()!=null){
					if(purchasePlanStore.getQualityMidicineId().toString().equals(quamap)){
						sumQm+=purchasePlanStore.getQuantity();
					}
				}
			}
		}
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		JSONArray json = new JSONArray();
		json.put(qm.getDosageforms().getFormName());
		json.put(qm.getSpecifications());
		json.put(qm.getProduceno().getCustomerName());
		json.put(qm.getLicensenumber());
		json.put(qm.getRegisteredtrademarkpath());
		json.put("");
		json.put(qm.getValiddate());
		json.put(qm.getProduceno().getCustomerName());
		json.put(qm.getUnit());
		json.put(sumQm);
		if(medPrice!=null){
			json.put(medPrice.getTrade_price());//批发价格
			json.put(medPrice.getTax_price());//含税价格
		}else{
			json.put("");//批发价格
			json.put("");//含税价格
		}
		//json.put(qm.getMedicinalAttribute());
		json.put(qm.getStorageStore());
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json.toString());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/drugState/inspectionRecords/delOne.html")
	public void delOne(String id, HttpServletRequest request, HttpServletResponse response, Model model){
		inspectItemMng.delOne(id);
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除收货记录", user.getRealname(), "删除", "药品状态管理  >收货管理", StringUtil.getIpAddr(request));
	}
	@RequestMapping("/drugState/inspectionRecords/find.html")
	public void find(String caigoudan, HttpServletRequest request, HttpServletResponse response, Model model){
		PurchaseOrder qm = new PurchaseOrder();
		PurchaseOrderItem ret = new PurchaseOrderItem();
		try {
			if(caigoudan!=null && !"".equals(caigoudan)){
				ret = inspectionMng.findcgdmxById(caigoudan);
				PurchaseOrder purchaseOrder=purchaseNoteMng.findById(ret.getPurchaseOrderId().toString());
				qm= inspectionMng.findCGDById(purchaseOrder.getNumber());
				
			}
		} catch (Exception e) {
			try {
				response.getWriter().write("数据查询失败");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		JSONArray json = new JSONArray();
		if(qm!=null){
			if(qm.getQualifiedSupplierId()!=null){
				json.put(qm.getQualifiedSupplierId().getId());
			}else{
				json.put("");
			}
			json.put(qm.getId());
			json.put(qm.getQualifiedSupplierId().getPinyinCode()+"_"+qm.getQualifiedSupplierId().getId());
		}else{
			json.put("");
			json.put("");
			json.put("");
		}
		if(ret!=null){
			json.put(ret.getBatchProduction());
			json.put(ret.getId());
			
		}else{
			json.put("");
		}
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json.toString());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/drugState/inspectionRecords/findmx.html")
	public void findmx(String id, HttpServletRequest request, HttpServletResponse response, Model model){
		List<PurchaseOrderItem> receItem= purchaseNoteMng.findYPBybn(id);
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		List<QualifiedEdit> qus =  new ArrayList<QualifiedEdit>();
		for(int j=0;j<receItem.size();j++){
			QualifiedEdit qu = new QualifiedEdit();
			PurchaseOrderItem rece = receItem.get(j);
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
				
			}else{
				qu.setJixing("");
				qu.setStorageConditions("");
				qu.setStorageStore("");
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
			
			if(rece.getTkdat()!=null){
				qu.setShengchanriqi(rece.getTkdat());
			}else{
				qu.setShengchanriqi("");
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
	@RequestMapping("/drugState/inspectionRecords/findsh.html")
	public void findsh(String shouhuodan, HttpServletRequest request, HttpServletResponse response, Model model){
		ReceivingNote qm=new ReceivingNote();
		try {
			if(shouhuodan!=null && !"".equals(shouhuodan)){
			//	ReceivingNote re =inspectionMng.findById(shouhuodan);
				qm= inspectionMng.findById(shouhuodan);
			}
		} catch (Exception e) {
			try {
				response.getWriter().write("数据查询失败");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		JSONArray json = new JSONArray();
		if(qm!=null){
			json.put(qm.getQualifiedSupplierId().getId());
			json.put(qm.getId());
			json.put(userManager.getUser(qm.getGoodsClerk()).getRealname());
			json.put(qm.getQualifiedSupplierId().getPinyinCode()+"_"+qm.getQualifiedSupplierId().getId());
			json.put(qm.getReceivedDate());
		}
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json.toString());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/drugState/inspectionRecords/findshmx.html")
	public void findshmx(String id, HttpServletRequest request, HttpServletResponse response, Model model){
		List<ReceivingNoteItem> receItem= inspectionMng.findYpItemBy(id);
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		List<QualifiedEdit> qus =  new ArrayList<QualifiedEdit>();
		for(int j=0;j<receItem.size();j++){
			QualifiedEdit qu = new QualifiedEdit();
			ReceivingNoteItem rece = receItem.get(j);
			qu.setBuhegeshu("");
			qu.setBuhegexiang("");
			qu.setHegeshuliang("");
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
			}else{
				qu.setJixing("");
				qu.setStorageConditions("");
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
			
			if(rece.getTkdat()!=null){
				qu.setShengchanriqi(rece.getTkdat());
			}else{
				qu.setShengchanriqi("");
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
	@RequestMapping("/drugState/inspectionRecords/findcgd.html")
	public void findcgd(HttpServletRequest request, HttpServletResponse response, Model model){
		List<PurchaseOrderItem> listpu= new ArrayList<PurchaseOrderItem>();
		listpu=inspectionMng.findcgdITJson();
//		String json = "[";
//		if(listpu!=null){
//			for(int i =0;i<listpu.size();i++){
//				if(listpu.get(i).getBatchProduction()!=null && !"".equals(listpu.get(i).getBatchProduction())){
//					json+="{";
//					json+="\"id\":"+listpu.get(i).getId()+",";
//					json+="\"text\":\""+listpu.get(i).getBatchProduction()+"\"";
//					if(i==listpu.size()-1){
//						json+="}";
//					}else{
//						json+="},";
//					}
//				}
//			}
//		}
//		if(json.endsWith(",")){
//			json = json.substring(0,json.length()-1);
//		}
//		json+="]";
		
		StringBuffer json = new StringBuffer("[");
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				if(listpu.get(i).getBatchProduction()!=null && !"".equals(listpu.get(i).getBatchProduction())){
					json.append("{");
					json.append("\"id\":"+listpu.get(i).getId()+",");
					json.append("\"text\":\""+listpu.get(i).getBatchProduction()+"\"");
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
	@RequestMapping("/drugState/inspectionRecords/findshd.html")
	public void findshd(HttpServletRequest request, HttpServletResponse response, Model model){
		List<ReceivingNoteItem> listpu= new ArrayList<ReceivingNoteItem>();
		listpu=inspectionMng.findshdItemJson();
		String json = "[";
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				if(listpu.get(i).getBatchProduction()!=null && !"".equals(listpu.get(i).getBatchProduction())){
					json+="{";
					json+="\"id\":\""+listpu.get(i).getReceivingNoteId()+"_"+listpu.get(i).getBatchProduction()+"\",";
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
	
	@RequestMapping("/drugState/inspectionRecords/findypboxqy.html")
	public void findypbox(HttpServletRequest request, HttpServletResponse response, Model model){
		List<QualityMidicine> listpu= new ArrayList<QualityMidicine>();
		String qualifiedSupplierId = "";
		String departmentId = request.getParameter("departmentId");
		
		String value = request.getParameter("value");
		if(null!=value){
			String str[] = value.split(",");
			qualifiedSupplierId = str[0];
			if(value.length() >3){
				departmentId = str[1];
			}
		}
		if(departmentId!=null && !"".equals(departmentId)){//判断是否有经营公司ID，若有经营公司ID根据经营公司ID获取药品否则获取所有正在销售的药品
			listpu = inspectionMng.findMedicJsonByDepaetId(departmentId);
		}else{
			listpu=inspectionMng.findypJsonqy();
		}
		String today = DateTimeUtils.getNowStrDate();
		String json = "[";
		if(listpu!=null){
			if(null!=qualifiedSupplierId && !"".equals(qualifiedSupplierId)){
				QualifiedSuppliers qualifiedSuppliers = qualifiedSuppliersService.findById(qualifiedSupplierId);
				for(int i =0;i<listpu.size();i++){
					boolean dbool = false;
					for(QulifiedSupplyDrugFroms drugFroms :qualifiedSuppliers.getDrugFroms()){
			        	if(listpu.get(i).getDosageforms().getId().equals(drugFroms.getDrugFormDictionary_id())){
			        		if(null!=drugFroms.getDrugFormDate()&& !"".equals(drugFroms.getDrugFormDate())
			        				&& DateTimeUtils.compareTwoDate(drugFroms.getDrugFormDate(),today)>=0){
			        			dbool = true;
				        		break;
			        		}
			        	}
			        }
					
					if(!qualifiedSupplierId.trim().equals(listpu.get(i).getSupplyUnit().getId()+"")){
						dbool = false;
					}
					
			        if(dbool){
			        	if(listpu.get(i).getCommonname()!=null && !"".equals(listpu.get(i).getCommonname())){
							json+="{";
							json+="\"id\":"+listpu.get(i).getId()+",";
							json+="\"text\":\""+"("+listpu.get(i).getMedicinalNo()+")"+listpu.get(i).getCommonname()+"\"";
							
							json+="},";
						}
			        }
				}
				json = json.substring(0, json.length()-1);
			}else{
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
		}
		json+="]";
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/drugState/inspectionRecords/findypboxty.html")
	public void findypboxqy(HttpServletRequest request, HttpServletResponse response, Model model){
		List<QualityMidicine> listpu= new ArrayList<QualityMidicine>();
		listpu=inspectionMng.findypJsonty();
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
		json+="]";
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/drugState/inspectionRecords/qualityPurchaseJson.html")
	public void findQulitySupplyJson(HttpServletRequest request, HttpServletResponse response, Model model){
		String name = null;
		String[] a=null;
		try {
			name = new String(request.getParameter("name").getBytes("ISO8859-1"), "UTF-8");
			a = name.split("_");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} 
		List<QualifiedPurchaseUnits> list = null;
		String hql="";
		if(name!=null && !"".equals(name)){
			hql = "select a from QualifiedPurchaseUnits a where a.delete_flag=0 and a.pinyinCode like '%"+a[0]+"%' order by a.customerName" ;
		}else{
			hql = "select a from QualifiedPurchaseUnits a where a.delete_flag=0 order by a.customerName" ;
		}
		list = inspectionMng.findList(hql);
		String json =new String("[");
		int index=0;
		if(list!=null && list.size()>0){
 			for(QualifiedPurchaseUnits supply : list){
					index++;
					json+="{";
					json+="\"id\":\""+supply.getPinyinCode()+"_"+supply.getId()+"\",";
					json+="\"text\":\""+supply.getCustomerName()+"\"";
					if(index==list.size()){
						json+="}";
					}else{
						json+="},";
					}
				}
		}
		json+="]";
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/drugState/inspectionRecords/uploadTicketSamples.html")
	public String uploadTickekSamples(Model mode, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		String ctxPath = request.getSession().getServletContext().getRealPath(  
        "/");
		TicketSamples ticketSamples = inspectionMng.getTicketSamplesByName("ticketSamples");
		if(ticketSamples != null ){
			String filePath = ticketSamples.getTicketSamplesPath();
			if(filePath!=null && !"".equals(filePath)){
				FileOperate.delFile(ctxPath+filePath);
			}
		}else{
			ticketSamples = new TicketSamples();
			ticketSamples.setTicketSamplesName("ticketSamples");
		}
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
		try{
			batchUpload(multiRequest, ticketSamples);
			inspectionMng.saveOrUpdateTicketSamples(ticketSamples);
			UtilJson.print(response, URLEncoder.encode("上传票样成功！", "utf-8"));
		}catch (RuntimeException e) {
			e.printStackTrace();
			UtilJson.print(response, URLEncoder.encode("上传票样失败！", "utf-8"));
			return null;
		}
		
		return null;
	} 
    /**
     * 上传图章
     * @param mode
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
	@RequestMapping("/drugState/inspectionRecords/uploadStamp.html")
	public String uploadStamp(Model mode, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		String ctxPath = request.getSession().getServletContext().getRealPath(  
        "/");
		TicketSamples ticketSamples = inspectionMng.getTicketSamplesByName("stamp");
		if(ticketSamples != null ){
			String filePath = ticketSamples.getTicketSamplesPath();
			if(filePath!=null && !"".equals(filePath)){
				FileOperate.delFile(ctxPath+filePath);
			}
		}else{
			ticketSamples = new TicketSamples();
			ticketSamples.setTicketSamplesName("stamp");
		}
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
		try{
			batchUpload(multiRequest, ticketSamples);
			inspectionMng.saveOrUpdateTicketSamples(ticketSamples);
			UtilJson.print(response, URLEncoder.encode("上传图章成功！", "utf-8"));
		}catch (RuntimeException e) {
			e.printStackTrace();
			UtilJson.print(response, URLEncoder.encode("上传图章失败！", "utf-8"));
			return null;
		}
		
		return null;
	} 
	
	public static void batchUpload(MultipartHttpServletRequest   request,TicketSamples ticketSamples){
		//response.setCharacterEncoding("utf-8");
		  Map<String, MultipartFile> filesMap = request.getFileMap();
			 String serverRealPath = request.getSession().getServletContext().getRealPath("/");//获取服务器绝对路径
				String fileSavePath = serverRealPath+Constants.UPLOAD_PATH;//上传文件存储的绝对路径
				String fileTempPath = serverRealPath+Constants.TEMPPATH;//上传文件在服务器临时存储的的绝对路径
				new File(fileSavePath).mkdirs();
				try{
					File tempPathFile = new File(fileTempPath);
					if(!tempPathFile.exists()){
						tempPathFile.mkdirs();
					}
				
				Iterator<String> its = filesMap.keySet().iterator();
				while(its.hasNext()){
					String requestName = its.next();
					MultipartFile item = filesMap.get(requestName);
					//chang by heju 2014.11.11
					//String fileName = "ticketSamples";//重命名文件名
					String fileName = ticketSamples.getTicketSamplesName(); //重命名文件名
					MultipartFile uploadFile = (MultipartFile) item;
					if(uploadFile.getOriginalFilename()==null || uploadFile.getOriginalFilename().equals(""))
						continue;
					String fileNameLong = uploadFile.getOriginalFilename();//获取上传文件的名称
				//	String requestName = uploadFile.getName();//获取上传文件对应字段名称
					String fileNameExtension = FileUtil.getFileExtension(fileNameLong);//获取文件的上传拓展名
					String relativeSavePath = Constants.UPLOAD_PATH+fileName+"."+fileNameExtension;//用户保存到数据库的相对文件路径及名称
					relativeSavePath = relativeSavePath.substring(1);
					File savaFile = new File(fileSavePath+fileName+"."+fileNameExtension);
					if(!savaFile.exists()){
						savaFile.createNewFile();
					}
					if(requestName.equals("ticketSamples")){//营业执照
						ticketSamples.setTicketSamplesPath(relativeSavePath);
					}
					if(requestName.equals("stamp")){
						ticketSamples.setTicketSamplesPath(relativeSavePath);
					}
					
					uploadFile.transferTo(savaFile);
				}
				}catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	
}