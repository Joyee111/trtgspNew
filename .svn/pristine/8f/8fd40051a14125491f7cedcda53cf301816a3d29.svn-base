package com.sinosoft.comQuery.comQuery.action;

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
import org.springframework.web.servlet.ModelAndView;
import com.sinosoft.base.Constants;
import com.sinosoft.comQuery.comQuery.serivice.ComQueryMng;
import com.sinosoft.dictionary.mode.DrugFormDictionary;
import com.sinosoft.dictionary.service.DrugFormDictionaryService;
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise;
import com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.service.PurchaseUnitsService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedProcurementStaffService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedPurchaseUnitsService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedSuppliersService;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;

@Controller
public class ComQueryAct {
	private ComQueryMng comQueryMng;
	@Autowired
	public void setComQueryMng(ComQueryMng comQueryMng) {
		this.comQueryMng = comQueryMng;
	}
	@Autowired
	private QualityMidicineMng service;
	@Autowired
	private QualifiedSuppliersService qualifiedSuppliersService;
	@Autowired
	private QualifiedPurchaseUnitsService qualifiedPurchaseUnitsService;
	@Autowired
	private PurchaseUnitsService purchaseUnitsService;
	@Autowired
	private DrugFormDictionaryService drugFormDictionaryService;
	@Autowired
	private QualifiedProcurementStaffService qualifiedProcurementStaffService;
	/**
	 * 供应商展示list
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/comQuery/comQuery/list.html")
	public ModelAndView firstEnterpristInfoList(String firstJoin,FirstEnterprise fe,Model model,HttpServletRequest request,HttpServletResponse response){
//		List<FirstEnterprise> firstEnterpriseList = new ArrayList<FirstEnterprise>();
		String page = DisplayGetPage.getPageParamName("enterprise", request);
//		if(page==null){	
//		firstEnterpriseList= comQueryMng.getPage(fe, 0,Constants.pagesize);
//		}else{		
//			firstEnterpriseList=comQueryMng.getPage(fe,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
//		}	
//		// 获取总条数
//		String dshValue ="";
//		String mc ="";
//		if("1".equals(firstJoin)){
//			dshValue="1,2,3";
//			mc="0";
//		}
//		 model.addAttribute("mc", mc);
//		 model.addAttribute("dsh", dshValue);
//		int resultSize=comQueryMng.getTotalCount();
		List<QualifiedSuppliers> quSuppList = null;
		if(page!=null ){
			quSuppList = qualifiedSuppliersService.getQualifiedSuppliersList(0, Constants.pagesize);
		}else{
			quSuppList = qualifiedSuppliersService.getQualifiedSuppliersList((Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = qualifiedSuppliersService.getRecordCount("select count(*) from t_qualifiedSupplier ");
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);

		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/comQuery/comQuery/list","quSuppList",quSuppList);
	}
	
	/**
	 * 根据查询条件查询
	 * @param fe
	 * @param pu
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping("/comQuery/comQuery/query.html")
	public String  queryEnterpristInfoList(Model model,HttpServletRequest request,HttpServletResponse response){
		String page = DisplayGetPage.getPageParamName("enterprise", request);
		String customer_type = request.getParameter("customer_type");//查询企业类型
		String customerNumber = request.getParameter("customerNumber");//企业编码
		String customerName = request.getParameter("customerName");//企业名称
		String[] status = request.getParameterValues("status");//使用状态
		model.addAttribute("customerNumber", customerNumber);
		model.addAttribute("customerName", customerName);
		if(customer_type!=null && !"".equals(customer_type) && "0".equals(customer_type)){
			List<QualifiedSuppliers> supplierList = null;
			Map<String, Object> paramMap = new HashMap<String, Object>();
			StringBuffer hqlBuffer = new StringBuffer("select a from QualifiedSuppliers a where 1=1 ");
			StringBuffer sqlBuffer = new StringBuffer("select count(*) from t_qualifiedSupplier a where 1=1 ");
			if(customerNumber!=null && !"".equals(customerNumber)){
				hqlBuffer.append(" and a.customerNumber like :customerNumber ");
				sqlBuffer.append(" and a.customer_number like'%"+customerNumber+"%' " );
				paramMap.put("customerNumber", "%"+customerNumber+"%");
			}
			if(customerName!=null && !"".equals(customerName)){
				hqlBuffer.append(" and a.customerName like :customerName ");
				sqlBuffer.append(" and a.name like '%"+customerName+"%' " );
				paramMap.put("customerName", "%"+customerName+"%");
			}
			if(status!=null && status.length==1){
				hqlBuffer.append(" and a.deleteFlag =:deleteFlag ");
				sqlBuffer.append(" and a.delete_flag='"+status[0]+"' " );
				paramMap.put("deleteFlag", status[0]);
				model.addAttribute("status", status[0]);
			}else{											
				model.addAttribute("status", "0,1");
			}
			if(page==null){
				supplierList = qualifiedSuppliersService.getListByPage(hqlBuffer.toString(), paramMap, 0, Constants.pagesize);
			}else{
				supplierList = qualifiedSuppliersService.getListByPage(hqlBuffer.toString(), paramMap, (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}
			model.addAttribute("supplierList",supplierList);
			int resultSize = qualifiedSuppliersService.getRecordCount(sqlBuffer.toString());
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("pagesize", Constants.pagesize);
			double size = resultSize;
			model.addAttribute("displayallpage", Math.ceil(size/Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			return "/comQuery/comQuery/gyslist";
		}else if( "1".equals(customer_type)){
			List<QualifiedPurchaseUnits> purchaseUnitsList = null;
			Map<String, Object> paramMap = new HashMap<String, Object>();
			StringBuffer hqlBuffer = new StringBuffer("select a from QualifiedPurchaseUnits a where 1=1 and a.delete_flag=0 and a.authorizationDate <> '9999-12-31' ");
			StringBuffer sqlBuffer = new StringBuffer("select count(*) from t_qualified_purchase_units a where 1=1 AND delete_flag=0 and a.authorization_date <> '9999-12-31'");
			if(customerNumber!=null && !customerNumber.equals("")){
				hqlBuffer.append(" and a.customerNumber like :customerNumber ");
				sqlBuffer.append(" and a.customer_number like'%"+customerNumber+"%' ");
				paramMap.put("customerNumber", "%"+customerNumber+"%");
			}
			if(customerName!=null && !customerName.equals("")){
				hqlBuffer.append(" and a.customerName like :customerName ");
				sqlBuffer.append(" and a.customer_name like'%"+customerName+"%' ");
				paramMap.put("customerName", "%"+customerName+"%");
			}
			if(status!=null && status.length==1){
				hqlBuffer.append(" and a.useFlag =:deleteFlag ");
				sqlBuffer.append(" and a.use_flag='"+status[0]+"' " );
				paramMap.put("deleteFlag", status[0]);
				model.addAttribute("status", status[0]);
			}else if(status!=null && status.length==2){	//使用状态选择两个有三种情况
				if("0".equals(status[0]) && "1".equals(status[1])){
					hqlBuffer.append("  and (a.useFlag =:deleteFlag or a.useFlag =:delete_Flag )");
					sqlBuffer.append(" and ( a.use_flag='0' or a.use_flag='1')" );
					paramMap.put("deleteFlag", status[0]);
					paramMap.put("delete_Flag", status[1]);
					model.addAttribute("status", "0,1");
				}
				if("0".equals(status[0]) && "2".equals(status[1])){
					hqlBuffer.append("  and (a.useFlag =:deleteFlag or a.useFlag =:delete_Flag) ");
					sqlBuffer.append("and (a.use_flag='0' or a.use_flag='2') " );
					paramMap.put("deleteFlag", status[0]);
					paramMap.put("delete_Flag", status[1]);
					model.addAttribute("status", "0,2");
				}
				if("1".equals(status[0]) && "2".equals(status[1])){
					hqlBuffer.append("  and (a.useFlag =:deleteFlag or a.useFlag =:delete_Flag)");
					sqlBuffer.append("and( a.use_flag='1' or a.use_flag='2') " );
					paramMap.put("deleteFlag", status[0]);
					paramMap.put("delete_Flag", status[1]);
					model.addAttribute("status", "1,2");
				}
				
			}else{											
				model.addAttribute("status", "0,1,2");
			}
			hqlBuffer.append(" order by a.customerNumber ");
			if(page==null){
				purchaseUnitsList = qualifiedPurchaseUnitsService.getListByPage(hqlBuffer.toString(), paramMap, 0, Constants.pagesize);
			}else{
				purchaseUnitsList = qualifiedPurchaseUnitsService.getListByPage(hqlBuffer.toString(), paramMap, (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}
			model.addAttribute("purchaseUnitsList",purchaseUnitsList);
			int resultSize = qualifiedSuppliersService.getRecordCount(sqlBuffer.toString());
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("pagesize", Constants.pagesize);
			double size = resultSize;
			model.addAttribute("displayallpage", Math.ceil(size/Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			
			return "/comQuery/comQuery/ghdwlist";
		}else{
			return "redirect:/comQuery/comQuery/list.html";
		}
	}
	/**
	 * 供应商查看
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/comQuery/comQuery/gysView.html")
	public ModelAndView editFirstEnterprise(Model model,HttpServletRequest request ,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		QualifiedSuppliers qualifiedSupply = qualifiedSuppliersService.findById(String.valueOf(id));
		List<DrugFormDictionary> drugFromList = drugFormDictionaryService.getAll();
		model.addAttribute("qualifiedSupply",qualifiedSupply);
		model.addAttribute("drugFromList", drugFromList);
		return  new  ModelAndView("/comQuery/comQuery/gysView");
	}
	/**
	 * 供应商药品信息查看
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/comQuery/comQuery/gysypView.html")
	public ModelAndView getQualifiedMidicinesList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<QualityMidicine> qualityMidicinesList =  new ArrayList<QualityMidicine>();
		String page = DisplayGetPage.getPageParamName("qualifiedMedic", request);
		String id = request.getParameter("ids");
		QualifiedSuppliers qualifiedSuppliers=qualifiedSuppliersService.get(Long.valueOf(id));

		Long ids=qualifiedSuppliers.getId();
		String hql = "from QualityMidicine a where produceno  ="+ids;

		if(page==null){
			qualityMidicinesList = service.getListByPage(hql, new HashMap(), 0, Constants.pagesize);
		}else{
			qualityMidicinesList = service.getListByPage(hql,new HashMap(),(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		String sql ="select count(*) from t_qualified_medicine where use_flag=0 and produceno_id ="+ids;
		int resultSize = service.getRecordCount(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);

		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));

		return new ModelAndView("/comQuery/comQuery/yplist","qualityMidicinesList",qualityMidicinesList);
	}
	
	/**
	 * 查看购货商信息
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/comQuery/comQuery/ghsView.html")
	public ModelAndView modifyPurchaseUnits(Model model,HttpServletRequest request,HttpServletResponse response){
		
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		QualifiedPurchaseUnits  quaPurchUnit = qualifiedPurchaseUnitsService.get(id);
		//PurchaseUnit enterprise = purchaseUnitsService.get(id);
		String a =quaPurchUnit.getCustomerNumber().substring(0, 2);
		//ProcurementStaff  procurementStaff = qualifiedProcurementStaffService.get(id);
		
		//model.addAttribute("procurementStaff",procurementStaff);
		model.addAttribute("shengfenValue", a);
		model.addAttribute("quaPurchUnit",quaPurchUnit);
		Map<String, String> quamap= purchaseUnitsService.qmMap();
		model.addAttribute("quamap", quamap);
	//	model.addAttribute("enterprise", enterprise);
		return  new  ModelAndView("/comQuery/comQuery/ghdwView");
	}

}
