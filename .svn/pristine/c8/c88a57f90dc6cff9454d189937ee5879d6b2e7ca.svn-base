package com.sinosoft.drugState.EntryTicket.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.drugState.acceptance.model.CheckacceptItem;
import com.sinosoft.drugState.acceptance.service.AcceptanceItemMng;
import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptItemJH;
import com.sinosoft.drugState.acceptanceJH.service.AcceptanceItemJHMng;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNoteItem;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.purchaseNote.service.PurchaseNoteMng;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.ireportDTO.EntryTicket;
import com.sinosoft.ireportDTO.EntryTicketMangaer;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

@Controller
public class EntryTicketAct {
	@Autowired
	private EntryTicketMangaer entryTicketMangaer;
	@Autowired
	private AcceptanceItemMng acceptItemMng;
	@Autowired
	private AcceptanceItemJHMng acceptItemJHMng;
	@Autowired
	private PurchaseNoteMng purchaseMng;
	@RequestMapping("/drugState/EntryTicket/list.html")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		String yhDate = request.getParameter("yhdate");
		String ypname = request.getParameter("ypname");
		String department = request.getParameter("department");
		String returnTime = request.getParameter("returnTime");
		String batchNumber = request.getParameter("batch");
		model.addAttribute("returnTime", returnTime);
		model.addAttribute("batchNumber", batchNumber);
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		model.addAttribute("department", department);
		EntryTicket et = new EntryTicket();
		
		List<EntryTicket> reslist=new ArrayList<EntryTicket>();
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			reslist= entryTicketMangaer.getPage(et,0,Constants.pagesize,batchNumber);
		}
		else{
			//否者翻页查询
			reslist= entryTicketMangaer.getPage(et,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize,batchNumber);
		}
		int resultSize = entryTicketMangaer.getTotalCount(et);
		double size = resultSize;
		
		
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("drugState/entryTicket/list");
	}
	
	
	@RequestMapping("/drugState/EntryTicket/add.html")
	public ModelAndView dlradd(HttpServletRequest request, HttpServletResponse response, Model model){
		
		return new ModelAndView("drugState/entryTicket/add");
		
	}
	@RequestMapping("/drugState/EntryTicket/addJH.html")
	public ModelAndView addJH(HttpServletRequest request, HttpServletResponse response, Model model){

		return new ModelAndView("drugState/entryTicket/addJH");
		
	}
	
	@RequestMapping("/drugState/EntryTicket/edit.html")
	public ModelAndView edit(EntryTicket mc,String id,HttpServletRequest request, HttpServletResponse response, Model model){
		EntryTicket mcs=entryTicketMangaer.findById(id);
//		 Qualifiedmedcstore store = qualifiedmedcstoreMng.findByBaNo(mcs.getBatchNumber().trim());
//		 if(store != null){
//			 model.addAttribute("maxQuantity", store.getQuantity());
//		 }
		
		model.addAttribute("entryTicket", mcs); 
//		QualityMidicine qm = inspectionMng.findHGYP(mcs.getQualifiedMedicineId());
//		model.addAttribute("qm", qm);
//		/**
//		 * 合格药品供应商
//		 * */
//		QualifiedSuppliers qs = purReturnMng.findghById(mcs.getQualifiedSupplierId());
//		model.addAttribute("qs", qs);
//		model.addAttribute("gouhuoshang", mcs.getQualifiedSuppliers().getPinyinCode()+"_"+mcs.getQualifiedSuppliers().getId());
		return new ModelAndView("drugState/entryTicket/edit");
		
	}
	
	@RequestMapping("/drugState/EntryTicket/view.html")
	public ModelAndView view(EntryTicket mc,String id,HttpServletRequest request, HttpServletResponse response, Model model){
		EntryTicket mcs=entryTicketMangaer.findById(id);
		model.addAttribute("entryTicket", mcs); 
		return new ModelAndView("drugState/entryTicket/view");
		
	}
	
	@RequestMapping("/drugState/saveOrUpdateEntryTicket.html")
	public String saveOrUpdateEntryTicket(EntryTicket entryTicket,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			entryTicketMangaer.saveOrUpdate(entryTicket);
		
			map.put("success", URLEncoder.encode("保存数据成功！","utf-8"));
			UtilJson.printMapJson(response, map);
		}catch (Exception e) {
			map.put("success", URLEncoder.encode("保存数据失败！","utf-8"));
			UtilJson.printMapJson(response, map);
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	@RequestMapping("/drugState/EntryTicket/findysd.html")
	public void findysd(HttpServletRequest request, HttpServletResponse response, Model model){
		List<Map<String,Object>> listpu= new ArrayList<Map<String,Object>>();
		String batch = request.getParameter("batch");
		listpu=acceptItemMng.findysdItemJsonByBatchSize2(batch);
		String json = "[";
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				if(listpu.get(i).get("batch")!=null && !"".equals(listpu.get(i).get("batch"))){
					json+="{";
					json+="\"id\":\""+listpu.get(i).get("poId")+"_"+listpu.get(i).get("batch")+"\",";
					json+="\"text\":\""+listpu.get(i).get("batch")+"\"";
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
	
	@RequestMapping("/drugState/EntryTicket/findysdJH.html")
	public void findysdJH(HttpServletRequest request, HttpServletResponse response, Model model){
		List<CheckAcceptItemJH> listpu= new ArrayList<CheckAcceptItemJH>();
//		listpu=acceptItemJHMng.findysdItemJHJson();
		String batch = request.getParameter("batch");
		listpu=acceptItemJHMng.findysdItemJsonByBatchSize(batch);
		String json = "[";
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				if(listpu.get(i).getBatchProduction()!=null && !"".equals(listpu.get(i).getBatchProduction())){
					json+="{";
					json+="\"id\":\""+listpu.get(i).getReceivingId()+"_"+listpu.get(i).getBatchProduction()+"\",";
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
	
	@RequestMapping("/drugState/EntryTicket/findET.html")
	public void findET(String id,String batchNumber, HttpServletRequest request, HttpServletResponse response, Model model){
		JSONArray json = new JSONArray();
		List<EntryTicket> entryTicketList = null;
		String idBatch = id + "," + batchNumber;
		
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		
		EntryTicket  entryTicket = null;
//		 entryTicket =   entryTicketMangaer.getEntryTicketByAcceptanceId(id);
		if(entryTicket==null){
			entryTicketList = acceptItemMng.findCheckAndAcceptByBatchNumber(idBatch);
			List<Map<String, Object>> purList = purchaseMng.findPurchaseOrderByBathcNumer(idBatch);
			//List<Map<String, Object>> usernameList = purchaseMng.findOpeatorNameByBatchNumber(idBatch);
			EntryTicket et = null;
			if (entryTicketList != null && entryTicketList.size() > 0) {
				User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER);
				et = entryTicketList.get(0);
				if (purList != null && purList.size() > 0) {
					Map<String, Object> purMap = null;
					purMap = purList.get(0);
					String price = (String) purMap.get("tax_price");
					String sl = et.getSl();
					et.setDj(price);
					Float f = (Float.valueOf(sl) * Float.valueOf(price));
					String str = String.format("%.2f", f);
					et.setJe(str);
					et.setCgy((String) purMap.get("realname"));
					et.setGhrq((String)purMap.get("modify_date"));
					et.setYxqz((String)purMap.get("enddate"));
					et.setZdr((String) purMap.get("realname"));//制单人和采购员是同一个，其他人员手填
					et.setYsy((String) purMap.get("erp_check"));
					et.setYsy2((String) purMap.get("erp_receiver"));
				}
				
				
				//entryTicketList.clear();
				//entryTicketList.add(et);
				
			}
			entryTicket = et;
		}
		json.put(entryTicket.getAcceptanceId());
		json.put(entryTicket.getGhdw());
		json.put(entryTicket.getGhrq());
		json.put(entryTicket.getBh());
		json.put(entryTicket.getHh());
		json.put(entryTicket.getTymc());
		json.put(entryTicket.getJx());		
		json.put(entryTicket.getGg());		
		json.put(entryTicket.getDw());		
		json.put(entryTicket.getSl());
		json.put(entryTicket.getDj());
		json.put(entryTicket.getJe());
		json.put(entryTicket.getPzwh());		
		json.put(entryTicket.getScph().trim());		
		json.put(entryTicket.getYxqz());		
		json.put(entryTicket.getNzsl());
		json.put(entryTicket.getJs());
		json.put(entryTicket.getSccs());
		json.put(entryTicket.getBz());		
		json.put(entryTicket.getCgy());		
		json.put(entryTicket.getShy());		
		json.put(entryTicket.getYsy());
		json.put(entryTicket.getBgy());
		json.put(entryTicket.getFhy());
		json.put(entryTicket.getZdr());
		json.put(entryTicket.getYsy2());
		json.put(entryTicket.getJygs());
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json.toString());
		} catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	//嘉和药品加载入库单信息
	@RequestMapping("/drugState/EntryTicket/findETJH.html")
	public void findETJH(String id,String batchNumber, HttpServletRequest request, HttpServletResponse response, Model model){
		JSONArray json = new JSONArray();
		List<EntryTicket> entryTicketList = null;
		String idBatch = id + "," + batchNumber;
		
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		
		EntryTicket  entryTicket = null;
//		 entryTicket =   entryTicketMangaer.getEntryTicketByAcceptanceId(id);
		if(entryTicket==null){
			entryTicketList = acceptItemJHMng.findCheckAndAcceptByBatchNumber(idBatch);
			List<Map<String, Object>> purList = purchaseMng.findPurchaseOrderJHByBathcNumer(idBatch);
//			List<Map<String, Object>> usernameList = purchaseMng.findOpeatorNameJHByBatchNumber(idBatch);
			EntryTicket et = null;
			if (entryTicketList != null && entryTicketList.size() > 0) {
				User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER);
				et = entryTicketList.get(0);
				if (purList != null && purList.size() > 0) {
					Map<String, Object> purMap = null;
					purMap = purList.get(0);
					String price = (String) purMap.get("tax_price");
					String sl = et.getSl();
					et.setDj(price);
					Float f = (Float.valueOf(sl) * Float.valueOf(price));
//					String str = String.format("%1$f", f);
					String str = String.format("%.2f", f);
					et.setJe(str);
					et.setCgy((String) purMap.get("realname"));
					et.setGhrq((String)purMap.get("modify_date"));
					et.setYxqz((String)purMap.get("enddate"));
					et.setZdr((String) purMap.get("realname"));//制单人和采购员是同一个，其他人员手填
					
				}
//				if(usernameList!=null && usernameList.size()>0){
//					Map<String, Object> map = usernameList.get(0);
//					et.setYsy((String) map.get("yanshouren"));
//					et.setFhy((String) map.get("shenheren"));
//				}
				
				
				//entryTicketList.clear();
				//entryTicketList.add(et);
				
			}
			entryTicket = et;
		}
		json.put(entryTicket.getAcceptanceId());
		json.put(entryTicket.getGhdw());
		json.put(entryTicket.getGhrq());
		json.put(entryTicket.getBh());
		json.put(entryTicket.getHh());
		json.put(entryTicket.getTymc());
		json.put(entryTicket.getJx());		
		json.put(entryTicket.getGg());		
		json.put(entryTicket.getDw());		
		json.put(entryTicket.getSl());
		json.put(entryTicket.getDj());
		json.put(entryTicket.getJe());
		json.put(entryTicket.getPzwh());		
		json.put(entryTicket.getScph().trim());		
		json.put(entryTicket.getYxqz());		
		json.put(entryTicket.getNzsl());
		json.put(entryTicket.getJs());
		json.put(entryTicket.getSccs());
		json.put(entryTicket.getBz());		
		json.put(entryTicket.getCgy());		
		json.put(entryTicket.getShy());		
		json.put(entryTicket.getYsy());
		json.put(entryTicket.getBgy());
		json.put(entryTicket.getFhy());
		json.put(entryTicket.getZdr());	
		json.put(entryTicket.getYsy2());
		json.put(entryTicket.getJygs());
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json.toString());
		} catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
}
