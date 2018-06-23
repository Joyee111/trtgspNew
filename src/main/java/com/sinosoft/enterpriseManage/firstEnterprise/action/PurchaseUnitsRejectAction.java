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
import com.sinosoft.enterpriseManage.firstEnterprise.service.PurchaseUnitsService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;

/**
 * @author lfl:
 * @version 创建时间：May 30, 2013 11:28:45 AM
 * 类说明
 */
@Controller
public class PurchaseUnitsRejectAction extends BaseFormController {
	@Autowired
	private PurchaseUnitsService purchaseUnitsService;
	@Autowired
	private SystemLogService logService;
	@RequestMapping("/firstEnterprise/ghdwybh.html")
	public ModelAndView purchaseUnitsRejectList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<PurchaseUnit> purchaseUnitsRejectList = new ArrayList<PurchaseUnit>();
	//	String page = DisplayGetPage.getPageParamName("users", request);// 第几页
		String page = DisplayGetPage.getPageParamName("purchaseUnit", request);
	//	String hql = "from PurchaseUnit a where reviewStatus =1 order by a.id DESC";
		if(page==null){
			purchaseUnitsRejectList = purchaseUnitsService.findListByPage(3, 0, Constants.pagesize);
		}else{
			purchaseUnitsRejectList = purchaseUnitsService.findListByPage(3,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		
		// 获取总条数
		int resultSize = purchaseUnitsService.countRecordByState(3);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/GHDW/ghdwybh","purchaseUnitsRejectList",purchaseUnitsRejectList);
	}
	/**
	 * 模糊查询待审核购货单位
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/firstEnterprise/query_ghdwybh.html")
	public ModelAndView queryPurchaseUnitsRejectList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<PurchaseUnit> purchaseUnitsRejectdList = new ArrayList<PurchaseUnit>();
	//	String page = DisplayGetPage.getPageParamName("users", request);// 第几页
		String page = DisplayGetPage.getPageParamName("purchaseUnit", request);
		StringBuffer buffer = new StringBuffer();
		StringBuffer sqlBuffer = new StringBuffer();
		buffer.append("from PurchaseUnit a where a.reviewStatus =3");
		sqlBuffer.append("select count(*) from t_purchase_units where 1=1 and review_status=3");
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
		//String hql = "from FirstEnterprise a where a.review_status =0 order by a.id DESC";
		
		if(page==null){
			purchaseUnitsRejectdList = purchaseUnitsService.findListByPage(buffer.toString(),new HashMap<String, Object>(), 0, Constants.pagesize);
		}else{
			purchaseUnitsRejectdList = purchaseUnitsService.findListByPage(buffer.toString(),new HashMap<String, Object>(),(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		
		// 获取总条数
		int resultSize = purchaseUnitsService.getRecordCount(sqlBuffer.toString());
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/GHDW/ghdwybh","purchaseUnitsRejectdList",purchaseUnitsRejectdList);
	}
	/**
	 * 根据Id 查看待审核详细信息
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/firstEnterprise/view_ghdwybh.html")
	public ModelAndView modifyPurchaseRejectUnits(Model model,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		PurchaseUnit purchaseUnit = purchaseUnitsService.get(id);
		model.addAttribute("purchaseUnit",purchaseUnit);
		return  new  ModelAndView("/QYZZ/GHDW/view_ghdwybh");
	}
	@RequestMapping("/firstEnterprise/confrimReject_ghdwybh.html")
	public String confrimPurchaseRejectUnits(Model model,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		PurchaseUnit purchaseUnit = purchaseUnitsService.get(id);
		purchaseUnit.setReviewStatus(Integer.valueOf(0));
		purchaseUnitsService.saveOrUpdate(purchaseUnit);
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("确认驳回购货单位", user.getRealname(), "确认驳回", "企业资质管理  > 购货单位", StringUtil.getIpAddr(request));
	//	model.addAttribute("purchaseUnit",purchaseUnit);
		return "redirect:/firstEnterprise/ghdwybh.html";
	}
	
}
