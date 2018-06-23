package com.sinosoft.enterpriseManage.firstEnterprise.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.TrtssProv;
import com.sinosoft.enterpriseManage.firstEnterprise.service.PurchaseUnitsService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedPurchaseUnitsService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;

/**
 * @author lfl:
 * @version 创建时间：May 30, 2013 9:27:37 AM
 * 类说明
 */
@Controller
public class PurchaseUnitsWaitAction extends BaseFormController {
	@Autowired
	private PurchaseUnitsService purchaseUnitsService;
	@Autowired
	private QualifiedPurchaseUnitsService qualifiedPurchaseUnitsService;
	@Autowired
	private SystemLogService logService;
	@RequestMapping("/firstEnterprise/ghdwdsh.html")
	public ModelAndView purchaseUnitsWaitList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<PurchaseUnit> purchaseUnitsWaitList = new ArrayList<PurchaseUnit>();
	//	String page = DisplayGetPage.getPageParamName("users", request);// 第几页
		String page = DisplayGetPage.getPageParamName("purchaseUnit", request);
	//	String hql = "from PurchaseUnit a where reviewStatus =1 order by a.id DESC";
		if(page==null){
			purchaseUnitsWaitList = purchaseUnitsService.findListByPage(1, 0, Constants.pagesize);
		}else{
			purchaseUnitsWaitList = purchaseUnitsService.findListByPage(1,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		
		// 获取总条数
		int resultSize = purchaseUnitsService.countRecordByState(1);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/GHDW/ghdwdsh","purchaseUnitsWaitList",purchaseUnitsWaitList);
	}
	/**
	 * 模糊查询待审核购货单位
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/firstEnterprise/query_ghdwdsh.html")
	public ModelAndView queryPurchaseUnitsWaitList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<PurchaseUnit> purchaseUnitsWaitList = new ArrayList<PurchaseUnit>();
	//	String page = DisplayGetPage.getPageParamName("users", request);// 第几页
		String page = DisplayGetPage.getPageParamName("purchaseUnit", request);
		StringBuffer buffer = new StringBuffer();
		StringBuffer sqlBuffer = new StringBuffer();
		buffer.append("from PurchaseUnit a where a.reviewStatus =1");
		sqlBuffer.append("select count(*) from t_purchase_units where 1=1 and review_status=1");
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
			purchaseUnitsWaitList = purchaseUnitsService.findListByPage(buffer.toString(),new HashMap<String, Object>(), 0, Constants.pagesize);
		}else{
			purchaseUnitsWaitList = purchaseUnitsService.findListByPage(buffer.toString(),new HashMap<String, Object>(),(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		
		// 获取总条数
		int resultSize = purchaseUnitsService.getRecordCount(sqlBuffer.toString());
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/GHDW/ghdwdsh","purchaseUnitsWaitList",purchaseUnitsWaitList);
	}
	/**
	 * 根据Id 查看待审核详细信息
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/firstEnterprise/view_ghdwdsh.html")
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
		return  new  ModelAndView("/QYZZ/GHDW/view_ghdwdsh");
	}
	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/firstEnterprise/autid_ghdwdsh.html")
	public String autidPurchaseUnits(Model model,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		String p_id = request.getParameter("id");
		String examineContent = request.getParameter("examineContent");//审核意见
		String rejectCause = request.getParameter("rejectCause");//驳回意见
		String autid_type = request.getParameter("autid_type");
		User  user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		PurchaseUnit purchaseunit = purchaseUnitsService.get(id);
		if(autid_type.equals("0")){
			purchaseunit.setReviewStatus(Integer.valueOf(2));
			purchaseunit.setExamineContent(examineContent);
			purchaseunit.setReviewTime(new Date());
			purchaseunit.setAuditorId(user.getId());
			QualifiedPurchaseUnits q  = qualifiedPurchaseUnitsService.findByPurchaseUtilsId(purchaseunit.getId());
			if(q!=null){
				q.setDelete_flag(0);
				qualifiedPurchaseUnitsService.saveOrUpdate(q);
			}else{
				QualifiedPurchaseUnits qualifiedPurchaseUnits = new QualifiedPurchaseUnits(purchaseunit);
				qualifiedPurchaseUnits.setDelete_flag(Integer.valueOf(0));
				qualifiedPurchaseUnitsService.save(qualifiedPurchaseUnits);
			}
			
		
		}else if(autid_type.equals("1")) {
			purchaseunit.setRejectCause(rejectCause);
			purchaseunit.setReviewStatus(Integer.valueOf(3));
			purchaseunit.setReviewTime(new Date());
		}
		purchaseUnitsService.saveOrUpdate(purchaseunit);
		logService.addLog("提交购货单位", user.getRealname(), "提交", "企业资质管理  > 购货单位", StringUtil.getIpAddr(request));
		return  "redirect:/firstEnterprise/ghdwdsh.html";
	}
	/**
	 * 批量审批或者驳回购货单位申请
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/firstEnterprise/batchOperate_dhdwdsh.html")
	public String batchOperateFirstEnter(Model model,HttpServletRequest request ,HttpServletResponse response){
		String[] p_ids = request.getParameterValues("operate_id");
		String batch_type = request.getParameter("batch_type");
		if(p_ids!=null && !p_ids.equals("")){
			
			for(String str_id : p_ids){
				Long id = Long.valueOf(str_id);
				PurchaseUnit purchaseunit = purchaseUnitsService.get(id);
				if(batch_type.equals("0")){
					purchaseunit.setReviewStatus(Integer.valueOf("2"));
				}else if(batch_type.equals("1")){
					purchaseunit.setReviewStatus(Integer.valueOf("3"));
				}
				purchaseUnitsService.saveOrUpdate(purchaseunit);
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("批量审核购货单位", user.getRealname(), "批量", "企业资质管理  > 购货单位", StringUtil.getIpAddr(request));
		return  "redirect:/firstEnterprise/ghdwdsh.html";
	}
}
