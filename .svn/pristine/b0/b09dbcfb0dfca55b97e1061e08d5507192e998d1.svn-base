package com.sinosoft.enterpriseManage.firstEnterprise.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.enterpriseManage.firstEnterprise.model.PurchaseUnit;
import com.sinosoft.enterpriseManage.firstEnterprise.model.TrtssProv;
import com.sinosoft.enterpriseManage.firstEnterprise.service.PurchaseUnitsService;
import com.sinosoft.util.DisplayGetPage;

/**
 * @author lfl:
 * @version 创建时间：May 30, 2013 11:11:32 AM
 * 类说明 已审核
 */
@Controller
public class PurchaseUnitsAuditedAction extends BaseFormController {
	@Autowired
	private PurchaseUnitsService purchaseUnitsService;
	@RequestMapping("/firstEnterprise/ghdwysh.html")
	public ModelAndView purchaseUnitsAuditedList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<PurchaseUnit> purchaseUnitsAuditedList = new ArrayList<PurchaseUnit>();
		String page = DisplayGetPage.getPageParamName("purchaseUnit", request);
		 if(page==null){
			purchaseUnitsAuditedList = purchaseUnitsService.findListByPage(2, 0, Constants.pagesize);
		}else{
			purchaseUnitsAuditedList = purchaseUnitsService.findListByPage(2,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		
/*迎检准备		if(page==null){
			purchaseUnitsAuditedList = purchaseUnitsService.findExceptPurchaseUnit("", 0, Constants.pagesize);
		}else{
			purchaseUnitsAuditedList = purchaseUnitsService.findExceptPurchaseUnit("",(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}*/
		// 获取总条数
		//int resultSize = purchaseUnitsService.countRecordByState(2);
		String sql = "SELECT COUNT(*) FROM t_purchase_units  WHERE review_status = 2 AND authorization_date <> '9999-12-31' AND customer_number IN (select customer_number from t_qualified_purchase_units)";
		int resultSize = purchaseUnitsService.getRecordCount(sql)+1;
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/GHDW/ghdwysh","purchaseUnitsAuditedList",purchaseUnitsAuditedList);
	}
	/**
	 * 模糊查询已审核购货单位
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/firstEnterprise/query_ghdwysh.html")
	public ModelAndView queryPurchaseUnitsAuditedList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<PurchaseUnit> purchaseUnitsAuditedList = new ArrayList<PurchaseUnit>();
	//	String page = DisplayGetPage.getPageParamName("users", request);// 第几页
		String page = DisplayGetPage.getPageParamName("purchaseUnit", request);
		StringBuffer buffer = new StringBuffer();
		StringBuffer sqlBuffer = new StringBuffer();
		buffer.append("from PurchaseUnit a where a.reviewStatus =2 AND authorization_date <> '9999-12-31' ");
		sqlBuffer.append("select count(*) from t_purchase_units where 1=1 and review_status=2");
		String query_qycx = request.getParameter("query_qycx");
		if(query_qycx!=null && !query_qycx.equals("")){
			buffer.append(" and ( a.companyName like '%");
			buffer.append(query_qycx+"%' or a.corporation like '%");
			buffer.append(query_qycx+"%' ) ");
			sqlBuffer.append(" and ( company_name like '%");
			sqlBuffer.append(query_qycx+"%' or corporation like'%");
			sqlBuffer.append(query_qycx+"%' ) ");
		}
		buffer.append(" order by a.id DESC");
		String hql = "from FirstEnterprise a where a.review_status =0 order by a.id DESC";

		if(page==null){
			purchaseUnitsAuditedList = purchaseUnitsService.findListByPage(buffer.toString(),new HashMap<String, Object>(), 0, Constants.pagesize);
		}else{
			purchaseUnitsAuditedList = purchaseUnitsService.findListByPage(buffer.toString(),new HashMap<String, Object>(),(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
/*		if(page==null){
			purchaseUnitsAuditedList = purchaseUnitsService.findExceptPurchaseUnit(query_qycx, 0, Constants.pagesize);
		}else{
			purchaseUnitsAuditedList = purchaseUnitsService.findExceptPurchaseUnit(query_qycx,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}*/
		
		// 获取总条数
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM t_purchase_units  WHERE review_status = 2 AND authorization_date <> '9999-12-31' AND customer_number IN (select customer_number from t_qualified_purchase_units)");
		if(query_qycx != null && !"".equals(query_qycx)){
			sql.append(" and ( company_name like '%" + query_qycx+"%'");
			sql.append(" or corporation like '%"+query_qycx+"%' )");
		}
		
		//int resultSize = purchaseUnitsService.getRecordCount(sqlBuffer.toString());
		int resultSize = purchaseUnitsService.getRecordCount(sql.toString());
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/GHDW/ghdwysh","purchaseUnitsAuditedList",purchaseUnitsAuditedList);
	}
	/**
	 * 根据Id 查看已审核详细信息
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/firstEnterprise/view_ghdwysh.html")
	public ModelAndView modifyPurchaseUnits(Model model,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		PurchaseUnit purchaseUnit = purchaseUnitsService.get(id);
		if(purchaseUnit.getCustomerNumber()!=null){
			TrtssProv tp =purchaseUnitsService.findTrtssProvByNo(purchaseUnit.getCustomerNumber().substring(0, 2));
			if(tp!=null){
				model.addAttribute("name", tp.getProvName());
			}else{
				model.addAttribute("name", "");
			}
		}
		model.addAttribute("purchaseUnit",purchaseUnit);
		return  new  ModelAndView("/QYZZ/GHDW/view_ghdwysh");
	}
}
