package com.sinosoft.ireportDTO;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
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

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.comQuery.comQuery.serivice.ComQueryMng;
import com.sinosoft.drugState.acceptance.service.AcceptanceItemMng;
import com.sinosoft.drugState.acceptanceJH.service.AcceptanceItemJHMng;
import com.sinosoft.drugState.purchaseNote.service.PurchaseNoteMng;
import com.sinosoft.drugState.purreturn.service.PurReturnMng;
import com.sinosoft.user.User;
import com.sinosoft.util.IreportUtil;
import com.sinosoft.util.UtilJson;
@Controller
public class CheckAndAcceptReportAction extends BaseFormController {
	@Autowired
	private AcceptanceItemMng acceptItemMng;
	@Autowired
	private AcceptanceItemJHMng acceptItemJHMng;
	@Autowired
	private PurchaseNoteMng purchaseMng;
	@Autowired
	private ComQueryMng comQueryMng;
	@Autowired
	private PurReturnMng purReturnMng;
	@Autowired
	private EntryTicketMangaer entryTicketMangaer;
	@RequestMapping("/ireport/exportEntryTicket.html")
	public String exportEntryTicket(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		String batchNumber = request.getParameter("batchNumber");
		String[] acceptIdAndNumber = batchNumber.split(",");
		EntryTicket entryTicket = null;
		List<EntryTicket> list = new ArrayList<EntryTicket>();
		entryTicket = entryTicketMangaer.findById(id);//改为按入库票id查询，由于多了另一个验收的表，acceptId有可能重复
//		entryTicket = entryTicketMangaer
//				.getEntryTicketByAcceptanceId(acceptIdAndNumber[0]);
		if (entryTicket == null) {
			list = acceptItemMng.findCheckAndAcceptByBatchNumber(batchNumber);
			List<Map<String, Object>> purList = purchaseMng
					.findPurchaseOrderByBathcNumer(batchNumber);
			List<Map<String, Object>> usernameList = purchaseMng
					.findOpeatorNameByBatchNumber(batchNumber);
			EntryTicket et = null;

		//	String file = "entry_ticket";
		//	String chinesName = "北京同仁堂科技发展股份有限公司入库单";

			if (list != null && list.size() > 0) {
				User user = (User) request.getSession().getAttribute(
						Constants.LOCAL_USER);
				et = list.get(0);
				if (purList != null && purList.size() > 0) {
					Map<String, Object> purMap = null;
					purMap = purList.get(0);
					String price = (String) purMap.get("tax_price");
					String sl = et.getSl();
					et.setDj(price);
					Float f = (Float.valueOf(sl) * Float.valueOf(price));
					BigDecimal decimal = new BigDecimal(f);
					f = decimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
					String str = String.format("%1$.2f", f);
					et.setJe(str);
					et.setCgy((String) purMap.get("realname"));
					et.setZdr((String) purMap.get("realname"));
					et.setGhrq((String)purMap.get("modify_date"));
				}
				if (usernameList != null && usernameList.size() > 0) {
					Map<String, Object> map = usernameList.get(0);
//					et.setYsy((String) map.get("yanshouren"));
					//et.setFhy((String) map.get("shenheren"));
				}
				
				list.clear();
				list.add(et);

				/*
				 * if (et != null) IreportUtil.export(file, chinesName, list,
				 * request, response);
				 */

			}
		}else{
			entryTicket.setYsy("");//验收员手填
			String endtime = entryTicket.getYxqz().substring(0, 7);
			entryTicket.setYxqz(endtime);
			list.add(entryTicket);
		}
		
		model.addAttribute("list", list);

		// return "redirect:../comQuery/inspeAcceptRecords/query.html";
		return "/comQuery/inspeAcceptRecords/ireportExport";

	}
	
	/**
	 * 嘉和药品生成入库单（暂时未使用）
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/ireport/exportEntryTicketJH.html")
	public String exportEntryTicketJH(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		String batchNumber = request.getParameter("batchNumber");
		String[] acceptIdAndNumber = batchNumber.split(",");
		EntryTicket entryTicket = null;
		List<EntryTicket> list = new ArrayList<EntryTicket>();
		entryTicket = entryTicketMangaer.findById(id);//改为按入库票id查询，由于多了另一个验收的表，acceptId有可能重复
//		entryTicket = entryTicketMangaer
//				.getEntryTicketByAcceptanceId(acceptIdAndNumber[0]);
		if (entryTicket == null) {
			list = acceptItemJHMng.findCheckAndAcceptByBatchNumber(batchNumber);
			List<Map<String, Object>> purList = purchaseMng
					.findPurchaseOrderJHByBathcNumer(batchNumber);
			List<Map<String, Object>> usernameList = purchaseMng
					.findOpeatorNameJHByBatchNumber(batchNumber);
			EntryTicket et = null;

		//	String file = "entry_ticket";
		//	String chinesName = "北京同仁堂科技发展股份有限公司入库单";

			if (list != null && list.size() > 0) {
				User user = (User) request.getSession().getAttribute(
						Constants.LOCAL_USER);
				et = list.get(0);
				if (purList != null && purList.size() > 0) {
					Map<String, Object> purMap = null;
					purMap = purList.get(0);
					String price = (String) purMap.get("tax_price");
					String sl = et.getSl();
					et.setDj(price);
					Float f = (Float.valueOf(sl) * Float.valueOf(price));
					BigDecimal decimal = new BigDecimal(f);
					f = decimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
					String str = String.format("%1$.2f", f);
					et.setJe(str);
					et.setCgy((String) purMap.get("realname"));
					et.setZdr((String) purMap.get("realname"));
					et.setGhrq((String)purMap.get("modify_date"));
				}
				if (usernameList != null && usernameList.size() > 0) {
					Map<String, Object> map = usernameList.get(0);
					et.setYsy((String) map.get("yanshouren"));
					//et.setFhy((String) map.get("shenheren"));
				}
				
				list.clear();
				list.add(et);
			}
		}else{
			list.add(entryTicket);
		}
		model.addAttribute("list", list);
		return "/comQuery/inspeAcceptRecordsJH/ireportExport";

	}
	@RequestMapping("/ireport/exportPurchaseUnitToExcel.html")
	public String exportPurchaseUnits(Model model ,HttpServletRequest request,HttpServletResponse response){
		
		String customerNumber = request.getParameter("customerNumber");
		String customerName = request.getParameter("customerName");
		String[] status = request.getParameterValues("status");
		StringBuffer hqlBuffer = new StringBuffer(
				"select new com.sinosoft.ireportDTO.CustomerInfo(u,p.provinceName) from QualifiedPurchaseUnits u ,Province p where 1=1 and substring(u.customerNumber,1,2)=p.provinceId  and LENGTH(u.customerNumber)= 9 ");
		//hqlBuffer.append(" and u.reviewStatus != 0");
		if(customerNumber!=null && !customerNumber.equals("")){
			hqlBuffer.append(" and u.customerNumber like '%"+customerNumber+"%'");
		}
		if(customerName!=null && !customerName.equals("")){
			hqlBuffer.append(" and u.customerName like '%"+customerName+"%");
		}
		if(status!=null && status.length==1){
			hqlBuffer.append(" and u.useFlag ='"+status[0]+"'");
			
		}
		hqlBuffer.append(" order by u.customerNumber ");
		List<CustomerInfo> list = comQueryMng.getCustomerInfoList(hqlBuffer.toString(), new HashMap<String, String>());
		for(int i =0 ;i<list.size();i++){
			String xslb = list.get(i).getXslb();
			list.get(i).setXslb(xslb.replace("1", "经营").replace("2", "新品").replace("3", "市场"));
			list.get(i).setBeizhu(list.get(i).getBeizhu() == null ? "" : list.get(i).getBeizhu());
		}
		String file = "customer_info";
		String chinesName = "北京同仁堂科技发展股份有限公司购货商";
		IreportUtil.export(file, chinesName, list, request, response);
		return null;
	
	}
	@RequestMapping("/ireport/exportPurchaseReturnToExcel.html")
	public String exportPurchaseReturnBill(Model model ,HttpServletRequest request,HttpServletResponse response){
		String purchaseId = request.getParameter("id");
		List<EntryTicket> entryTicketList = null;
		if(purchaseId!=null && !"".equals(purchaseId)){
			entryTicketList = purReturnMng.findPurchaseReturnBillById(purchaseId);
			for(EntryTicket entry : entryTicketList){
				//String date = entry.getGhrq();
				//date = date.replace("-", "");
				//String bh ="0000"+entry.getBh();
				//	bh = bh.substring(bh.length()-4);
				//entry.setBh(date+bh);
				if(entry.getBh()==null || entry.getBh().trim().equals("")){
					entry.setBh("");
				}
				String endtime = entry.getYxqz().substring(0, 7);
				entry.setYxqz(endtime);
			}
		}
		model.addAttribute("entryTicketList", entryTicketList);
		return "/drugState/purreturn/exportPurchaseReturn";
	}
	@RequestMapping("/ireport/viewEntryTicket.html")
	public String viewEntryTicket(Model model,HttpServletRequest request,HttpServletResponse response){
		String batchNumber  = request.getParameter("batchNumber");
		String[] acceptIdAndNumber =  batchNumber.split(",");
		List<EntryTicket> entryTicketList = null;
		EntryTicket  entryTicket = null;
		 entryTicket =   entryTicketMangaer.getEntryTicketByAcceptanceId(acceptIdAndNumber[0]);
		if(entryTicket==null){
			entryTicketList = acceptItemMng.findCheckAndAcceptByBatchNumber(batchNumber);
			List<Map<String, Object>> purList = purchaseMng.findPurchaseOrderByBathcNumer(batchNumber);
			List<Map<String, Object>> usernameList = purchaseMng.findOpeatorNameByBatchNumber(batchNumber);
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
					String str = String.format("%1$f", f);
					et.setJe(str);
					et.setCgy((String) purMap.get("realname"));
				}
				if(usernameList!=null && usernameList.size()>0){
					Map<String, Object> map = usernameList.get(0);
					et.setYsy((String) map.get("yanshouren"));
					et.setFhy((String) map.get("shenheren"));
				}
				et.setZdr(user.getRealname());
				//entryTicketList.clear();
				//entryTicketList.add(et);
				
			}
			entryTicket = et;
		}
		model.addAttribute("entryTicket", entryTicket);
		return "/comQuery/inspeAcceptRecords/viewEntryTicket";
	}
	@RequestMapping("/ireport/saveOrUpdateEntryTicket.html")
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
}
