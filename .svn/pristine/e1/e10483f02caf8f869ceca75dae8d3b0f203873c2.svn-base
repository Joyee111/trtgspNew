package com.sinosoft.drugState.returnRecords.action;

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
import com.sinosoft.drugState.inspectionRecords.model.QualifiedEdit;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.mackNo.service.MakeNoMng;
import com.sinosoft.drugState.outcheck.model.OutboundCheckBill;
import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;
import com.sinosoft.drugState.outcheck.service.OutCheckMng;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNote;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteItem;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteVO;
import com.sinosoft.drugState.returnRecords.service.ReturnRecordsItemMng;
import com.sinosoft.drugState.returnRecords.service.ReturnRecordsMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedPurchaseUnitsService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

@Controller
public class ReturnRecordsAct {
	@Autowired
	private ReturnRecordsMng returnRecordsMng;
	@Autowired
	private InspectionMng inspectionMng;
	@Autowired 
	private ReturnRecordsItemMng returnRecordsItemMng;
	@Autowired
	private OutCheckMng outCheckMng;
	@Autowired
	private MakeNoMng makeNoMng;
	@Autowired
	private QualifiedPurchaseUnitsService qualifiedPurchaseUnitsService ;
	@Autowired
	private SystemLogService logService;
	@RequestMapping("/drugState/returnRecords/list.html")
	public ModelAndView openFramePage(ReturnReceivingNote re, HttpServletRequest request, HttpServletResponse response, Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		String yhDate = request.getParameter("yhDate");
		String ypname = request.getParameter("ypname");
		String commonName = request.getParameter("commonName");
		String xiaoshoudanhao = request.getParameter("xiaoshoudanhao");//销售单号
		String tuihuodanhao = request.getParameter("tuihuodanhao");//退货单号
		String isfood = request.getParameter("isfood");//是否药品
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		model.addAttribute("commonName", commonName);
		model.addAttribute("xiaoshoudanhao",xiaoshoudanhao);
		model.addAttribute("tuihuodanhao",tuihuodanhao);
		model.addAttribute("isfood",isfood);
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
	//	List<ReturnReceivingNote> reslist=new ArrayList<ReturnReceivingNote>();
		List<ReturnReceivingNoteVO> reslist=null;
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//reslist= returnRecordsMng.getPage(re,0,Constants.pagesize);
			reslist= returnRecordsMng.findReturnReceivingNoteByCondiction(yhDate, ypname, commonName,xiaoshoudanhao,tuihuodanhao,isfood,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			reslist= returnRecordsMng.findReturnReceivingNoteByCondiction(yhDate, ypname, commonName,xiaoshoudanhao,tuihuodanhao,isfood,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		//int resultSize = returnRecordsMng.getTotalCount(re);
		int resultSize = returnRecordsMng.countReturnReceivingNoteByCondiction(yhDate, ypname, commonName,xiaoshoudanhao,tuihuodanhao,isfood);
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("re", re);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("drugState/returnRecords/list");
	}
	
	@RequestMapping("/drugState/returnRecords/view.html")
	public ModelAndView view(ReturnReceivingNote re,String id, HttpServletRequest request, HttpServletResponse response, Model model){
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		ReturnReceivingNote receivingNote=new ReturnReceivingNote();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String number = format.format(new Date());
		String nonumber = makeNoMng.findNo(Constants.SALERETURNaCCEPT);
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
		String titles="查看";
		
		receivingNote=returnRecordsMng.findById(id);
		List<ReturnReceivingNoteItem> receItem= returnRecordsMng.findYp(receivingNote.getId());
		List<QualifiedEdit> qus =  new ArrayList<QualifiedEdit>();
		for(int j=0;j<receItem.size();j++){
			QualifiedPurchaseUnits purchaseUnits=qualifiedPurchaseUnitsService.get(receivingNote.getQualifiedPurchaseUnitsId());
			QualifiedEdit qu = new QualifiedEdit();
			qu.setGouhuodanwei(purchaseUnits.getCustomerName());
			qu.setGouhuodanweiId(String.valueOf(receivingNote.getQualifiedPurchaseUnitsId()));
			ReturnReceivingNoteItem rece = receItem.get(j);
			QualityMidicine qualifiedMedicine = inspectionMng.findHGYP(receItem.get(j).getQualifiedMedicineId());
			if(rece.getEndTime()!=null && !"".equals(rece.getEndTime())){
				qu.setYouxiaoqizhi(rece.getEndTime());
			}
			if(rece.getBatchProduction()!=null){
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
			if(rece.getProductionDate()!=null){
				qu.setShengchanriqi(rece.getProductionDate());
			}else{
				qu.setShengchanriqi("");
			}
			
			if(qualifiedMedicine!=null){
				if(qualifiedMedicine.getProduceno()!=null){
					qu.setShengchangqiye(qualifiedMedicine.getProduceno().getCustomerName());
				}else{
					qu.setShengchangqiye("");
				}
				if(qualifiedMedicine.getStorageStore() != null){
					qu.setStorageStore(qualifiedMedicine.getStorageStore());
				}else{
					qu.setStorageStore("");
				}
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
		QualifiedPurchaseUnits qupu=inspectionMng.findGHSById(receivingNote.getQualifiedPurchaseUnitsId());
		if(qupu!=null){
			model.addAttribute("gongyingshang", qupu.getCustomerName());
		}
		Map<String, String> qsmap=inspectionMng.gouhuoMap();
		model.addAttribute("qsmap", qsmap);
		model.addAttribute("titles", titles);
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		model.addAttribute("re", receivingNote);
		return new ModelAndView("drugState/returnRecords/view");
	}
	
	
	
	
	
	@RequestMapping("/drugState/returnRecords/add.html")
	public ModelAndView add(ReturnReceivingNote re,String id, HttpServletRequest request, HttpServletResponse response, Model model){
		String method = request.getParameter("method");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		ReturnReceivingNote receivingNote=new ReturnReceivingNote();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String number = format.format(new Date());
		String nonumber = makeNoMng.findNo(Constants.SALERETURNaCCEPT);
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
		String titles="新增";
		receivingNote.setReceivingAddress("北京市丰台区南三环中路20号");
		receivingNote.setReceivingUnit("同仁堂");
		receivingNote.setReturnNumber("000000");
		if(!method.equals("add")){
			titles="修改";
			receivingNote=returnRecordsMng.findById(id);
			List<ReturnReceivingNoteItem> receItem= returnRecordsMng.findYp(receivingNote.getId());
			List<QualifiedEdit> qus =  new ArrayList<QualifiedEdit>();
			for(int j=0;j<receItem.size();j++){
				QualifiedPurchaseUnits purchaseUnits=qualifiedPurchaseUnitsService.get(receivingNote.getQualifiedPurchaseUnitsId());
				QualifiedEdit qu = new QualifiedEdit();
				qu.setGouhuodanwei(purchaseUnits.getCustomerName());
				qu.setGouhuodanweiId(String.valueOf(receivingNote.getQualifiedPurchaseUnitsId()));
				ReturnReceivingNoteItem rece = receItem.get(j);
				QualityMidicine qualifiedMedicine = inspectionMng.findHGYP(receItem.get(j).getQualifiedMedicineId());
				if(rece.getEndTime()!=null && !"".equals(rece.getEndTime())){
					qu.setYouxiaoqizhi(rece.getEndTime());
				}
				if(rece.getBatchProduction()!=null){
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
				if(rece.getProductionDate()!=null){
					qu.setShengchanriqi(rece.getProductionDate());
				}else{
					qu.setShengchanriqi("");
				}
				
				if(qualifiedMedicine!=null){
					if(qualifiedMedicine.getProduceno()!=null){
						qu.setShengchangqiye(qualifiedMedicine.getProduceno().getCustomerName());
					}else{
						qu.setShengchangqiye("");
					}
					if(qualifiedMedicine.getStorageStore() != null){
						qu.setStorageStore(qualifiedMedicine.getStorageStore());
					}else{
						qu.setStorageStore("");
					}
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
		QualifiedPurchaseUnits qupu=inspectionMng.findGHSById(receivingNote.getQualifiedPurchaseUnitsId());
		if(qupu!=null){
			model.addAttribute("gongyingshang", qupu.getCustomerName());
		}
		Map<String, String> qsmap=inspectionMng.gouhuoMap();
		model.addAttribute("qsmap", qsmap);
		model.addAttribute("titles", titles);
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		model.addAttribute("re", receivingNote);
		model.addAttribute("method", method);
		return new ModelAndView("drugState/returnRecords/add");
	}
	@RequestMapping("/drugState/returnRecords/saveOrUpdata.html")
	public ModelAndView saveOrUpdate(ReturnReceivingNote re,String counts, HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("method");
		String qualifiedSupplierIdValue = request.getParameter("qualifiedSupplierIdValue");
		String ops = request.getParameter("thispage");
		if(qualifiedSupplierIdValue!=null&&!"".equals(qualifiedSupplierIdValue)){
			re.setQualifiedPurchaseUnitsId(Long.parseLong(qualifiedSupplierIdValue.trim()));		}
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String number = format.format(date);
 		re.setModifyDate(number);
		//re.setNumber(number);
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		re.setGoodsClerk(user.getId().toString());
		re.setUser(user);
		ReturnReceivingNote res =returnRecordsMng.saveReceivingNote(re);
		Long b = res.getId();
		String s =b.toString();
		List<?> list = returnRecordsMng.findAllId(s);
		if(list!=null){
			returnRecordsItemMng.del(list);
		}
		
			makeNoMng.mackNo(Constants.SALERETURNaCCEPT);
		
		if(!"".equals(counts) && null !=counts){
			for(int i=0;i<Integer.parseInt(counts);i++){
				ReturnReceivingNoteItem receivingNoteItem = new ReturnReceivingNoteItem();
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
				String shengchanriqi = request.getParameter("shengchanriqi"+i);
				if(pingming!=null && !"".equals(pingming)){
					receivingNoteItem.setQualifiedMedicineId(Long.parseLong(pingming.trim()));
				}else{
					continue;
				}
				if(shuliang!=null && !"".equals(shuliang)){
					receivingNoteItem.setQuantity(Long.parseLong(shuliang));
				}else{
					continue;
				}
				receivingNoteItem.setReceivingNoteId(res.getId());
				receivingNoteItem.setDosageForms(jixing);
				receivingNoteItem.setSpecifications(guige);
				receivingNoteItem.setLicenseNumber(pizhun);
				receivingNoteItem.setBatchProduction(shengchanpihao);
				receivingNoteItem.setEndTime(youxiaoqi);
				receivingNoteItem.setProductionDate(shengchanriqi);
				returnRecordsItemMng.saveReceivingNoteItem(receivingNoteItem);
			}
		}
		logService.addLog("新增退货药品记录", user.getRealname(), "新增", "药品状态管理  >退货药品", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/returnRecords/del.html")
	public ModelAndView delOne(String ids[], HttpServletRequest request, HttpServletResponse response, Model model){
		if(ids!=null && !"".equals(ids)){
			for(int i=0;i<ids.length;i++){
				returnRecordsMng.del(ids[i]);
				List<?> list = inspectionMng.findAllId(ids[i]);
				if(list!=null && list.size()>0)
					returnRecordsItemMng.del(list);
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除退货药品记录", user.getRealname(), "删除", "药品状态管理  >退货药品", StringUtil.getIpAddr(request));
		return openFramePage(null, request, response, model);
	}
	@RequestMapping("/drugState/returnRecords/findxsd.html")
	public void findxsd(HttpServletRequest request, HttpServletResponse response,Model model){
		List<?> listpu= null;
		//listpu=outCheckMng.findxsJson();
		String requestName = request.getParameter("requestName");
		listpu = outCheckMng.findRetturnRecordSaleDetailNO(requestName);
		String json = "[";
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				/*String head = "";
				if(listpu.get(i)!=null && ((Object[])listpu.get(i))[1].toString().equals("1001")){
					head = "Y";
				}else if (((Object[])listpu.get(i))[1].toString().equals("2001")){
					head="X";
				}else if (((Object[])listpu.get(i))[1].toString().equals("3001")){
					head="S";
				}*/
				if(listpu.get(i)!=null && !"".equals((listpu.get(i)).toString())){
					json+="{";
					json+="\"id\":\""+(listpu.get(i)).toString()+"\",";
					json+="\"text\":\""+(listpu.get(i)).toString()+"\"";
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
	@RequestMapping("/drugState/returnRecords/findxshd.html")
	public void findshmx(String saleNumber, HttpServletRequest request, HttpServletResponse response, Model model){
		//List<OutboundCheckBill> tf = returnRecordsMng.findItemById(saleNumber);
		List<OutboundCheckBill> tf = returnRecordsMng.findOutboundCheckBill(saleNumber);
		List<OutboundCheckItem> receItemAll=new ArrayList<OutboundCheckItem>();
		if(tf!=null && tf.size()>0){
			for(int i=0;i<tf.size();i++){
				List<OutboundCheckItem> list =returnRecordsMng.findOutItem(tf.get(i).getId());
				if(list!=null && list.size()>0){
					for(int j=0;j<list.size();j++){
						receItemAll.add(list.get(j));
					}
				}
			}
		}
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		List<QualifiedEdit> qus =  new ArrayList<QualifiedEdit>();
		for(int i =0;i<tf.size();i++){
			for(int j=0;j<receItemAll.size();j++){
				QualifiedEdit qu = new QualifiedEdit(); 
					//qu.setChukuriqi(tf.get(i).get)
					qu.setXiaoshouriqi(tf.get(i).getApplicationTime());//出库日期
					qu.setGouhuodanwei(tf.get(i).getQualifiedPurchaseUnits().getCustomerName());
					qu.setGouhuodanweiId(String.valueOf(tf.get(i).getQualifiedPurchaseUnits().getId()));
					//qu.setShengchanqiyeId(tf.get(i).getId());
				OutboundCheckItem rece = receItemAll.get(j);
				qu.setBuhegeshu("");
				qu.setBuhegexiang("");
				qu.setHegeshuliang("");
				
				QualityMidicine qualifiedMedicine =inspectionMng.findHGYP(rece.getQualifiedMedicineId());
				if(rece.getTkdat()!=null && !"".equals(rece.getTkdat())){
					qu.setShengchanriqi(rece.getTkdat());
				}else{
					qu.setShengchanriqi("");
				}
				if(rece.getBatchNo()!=null && !"".equals(rece.getBatchNo().toString())){
					qu.setShengchanpihao(rece.getBatchNo());
				}else{
					qu.setShengchanpihao("");
				}
				if(rece.getQuantity()!=null && !"".equals(rece.getQuantity().toString())){
					Integer sumQuantity = returnRecordsMng.getSumQuantity(saleNumber,rece.getBatchNo(),rece.getQualifiedMedicineId()+"");
					Long quantity = rece.getQuantity();
					if(sumQuantity!=null){
						quantity -= sumQuantity;
					}
					qu.setShuliang(quantity+"");
				}else{
					qu.setShuliang("");
				}
				if(rece.getValidityTime()!=null && !"".equals(rece.getValidityTime())){
					qu.setYouxiaoqizhi(rece.getValidityTime());
				}else{
					qu.setYouxiaoqizhi("");
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
				if(qualifiedMedicine!=null){
					if(qualifiedMedicine.getProduceno().getId()>0){
						qu.setShengchanqiyeId(qualifiedMedicine.getProduceno().getId());
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
				
				if(qualifiedMedicine.getStorageStore() != null){
					qu.setStorageStore(qualifiedMedicine.getStorageStore());
				}else{
					qu.setStorageStore("");
				}
				
				qu.setHegezheng("");
				qus.add(qu);
			}
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
}
