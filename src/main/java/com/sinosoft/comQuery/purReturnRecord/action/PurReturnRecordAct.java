package com.sinosoft.comQuery.purReturnRecord.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.comQuery.conserveAcceptRecords.model.ConserveAcceptRecords;
import com.sinosoft.comQuery.purReturnRecord.service.PurReturnRecordMng;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;
import com.sinosoft.ireportDTO.PurchaseReturnDto;

import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.IreportUtil;
@Controller
public class PurReturnRecordAct {
	@Autowired
	private PurReturnRecordMng purReturnRecordMng;
	
	
	@RequestMapping("/comQuery/purReturnRecord/list.html")
	public ModelAndView openFramePage(ConserveAcceptRecords cr, HttpServletRequest request, HttpServletResponse response, Model model){
		
			return new ModelAndView("comQuery/purReturnRecord/list");
		}
	@RequestMapping("/comQuery/purReturnRecord/query.html")
	public ModelAndView openFramePage(HttpServletRequest request, HttpServletResponse response, Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		String qualifiedMedicineId = request.getParameter("qualifiedMedicineId");
		String printFlag = request.getParameter("printFlag");
		String department = request.getParameter("department");
		String isfood = request.getParameter("isfood");

		model.addAttribute("tuihuodanwei", qualifiedMedicineId);
		model.addAttribute("department", department);
		model.addAttribute("isfood", isfood);

		PurchaseReturnBill mc = new PurchaseReturnBill();
		if(qualifiedMedicineId !=null && !"".equals(qualifiedMedicineId)){
			mc.setApplicationTime(qualifiedMedicineId);
		}
		if(printFlag!=null && !"".equals(printFlag)){
			mc.setPrintFlag(printFlag);
		
		}
		if(department !=null && !"".equals(department)){
			mc.setNumber(department);
		}
		model.addAttribute("printFlag", printFlag);
	
		List<PurchaseReturnBill> reslist=new ArrayList<PurchaseReturnBill>();
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			reslist= purReturnRecordMng.getPage(mc,isfood,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			reslist= purReturnRecordMng.getPage(mc,isfood,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = purReturnRecordMng.getTotalCount(mc,isfood);
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("comQuery/purReturnRecord/query");
	}
	@RequestMapping("/comQuery/purReturnRecord/exportAllToExcel.html")
	public ModelAndView getAllExport(HttpServletRequest request, HttpServletResponse response, Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		String qualifiedMedicineId = request.getParameter("qualifiedMedicineId");
		String department = request.getParameter("department");
		model.addAttribute("tuihuodanwei", qualifiedMedicineId);

		PurchaseReturnBill mc = new PurchaseReturnBill();
		if(qualifiedMedicineId !=null && !"".equals(qualifiedMedicineId)){
			mc.setApplicationTime(qualifiedMedicineId);
		}
	
		List<PurchaseReturnBill> reslist=new ArrayList<PurchaseReturnBill>();
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			reslist= purReturnRecordMng.getAll(qualifiedMedicineId,department,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		else{
			//否者翻页查询
			reslist= purReturnRecordMng.getAll(qualifiedMedicineId,department,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		List<PurchaseReturnDto> purReturnDtoList = new ArrayList<PurchaseReturnDto>();
		for(PurchaseReturnBill returnBill : reslist){
			if(returnBill.getUser()!=null) {
				purReturnDtoList.add(new PurchaseReturnDto(returnBill));
			}
		}
		String file = "PurchaseReturn";
		String chineseName = "药品购进退出记录";
		IreportUtil.export(file, chineseName, purReturnDtoList, request, response);
		return null;
	}

}
