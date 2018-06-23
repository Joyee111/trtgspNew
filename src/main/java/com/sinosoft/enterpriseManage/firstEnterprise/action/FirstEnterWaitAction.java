package com.sinosoft.enterpriseManage.firstEnterprise.action;

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
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.service.FirstEnterpriseService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedSuppliersService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
@Controller
public class FirstEnterWaitAction extends BaseFormController {
	private static String REDIRECTPATH="redirect:/firstEnterprise/syqydsh.html";
	@Autowired
	private FirstEnterpriseService firstEnterpriseService ;
	@Autowired
	private QualifiedSuppliersService qualifiedSuppliersService;
	@Autowired
	private SystemLogService logService;

	@RequestMapping("/firstEnterprise/syqydsh.html")
	public ModelAndView  firstEnterWaitList(Model model ,HttpServletRequest request , HttpServletResponse response){
		List<FirstEnterprise> firstEnterWaitList = new ArrayList<FirstEnterprise>();
		//	String page = DisplayGetPage.getPageParamName("users", request);// 第几页
			String page = DisplayGetPage.getPageParamName("waitEnter", request);
			String hql = "from FirstEnterprise a where a.review_status =1 order by a.id DESC";
			if(page==null){
				firstEnterWaitList = firstEnterpriseService.getFirstEnterpriseByPage(hql, new HashMap<String, Object>(), 0, Constants.pagesize);
			}else{
				firstEnterWaitList = firstEnterpriseService.getFirstEnterpriseByPage(hql, new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}
			
			// 获取总条数
			int resultSize = firstEnterpriseService.getOrderInfoCountByState(Integer.valueOf(1));
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("pagesize", Constants.pagesize);
		//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
			double size = resultSize;
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			return new ModelAndView("/QYZZ/SYQY/syqydsh","firstEnterWaitList",firstEnterWaitList);
		//return new ModelAndView("");
	}
	@RequestMapping("/firstEnterprise/query_syqydsh.html")
	public ModelAndView queryEnterpristInfoList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<FirstEnterprise> firstEnterWaitList = new ArrayList<FirstEnterprise>();
		String query_qycx= request.getParameter("query_qycx");
		// 暂时先不考虑String query_zjhm= request.getParameter("query_zjhm");
		
	//	String page = DisplayGetPage.getPageParamName("users", request);// 第几页
		String page = DisplayGetPage.getPageParamName("waitEnter", request);
		//String hql = "from FirstEnterprise a where a.review_status =0 order by a.id DESC";
		StringBuffer hqlBuffer = new StringBuffer("from FirstEnterprise a where a.review_status =1");
		StringBuffer sqlBuffer = new StringBuffer("select count(*) from t_FirstEnterprise where 1=1 and review_status = 1");
		if(query_qycx!=null && !query_qycx.equals("")){
			hqlBuffer.append(" and ( a.companyName like '%");
			hqlBuffer.append(query_qycx+"%' or a.corporation like '%");
			hqlBuffer.append(query_qycx+"%' ) ");
			sqlBuffer.append(" and (name like '%").append(query_qycx).append("%' or corporation like'%").append(query_qycx).append("%')");
		}
		hqlBuffer.append(" order by a.id DESC");
		if(page==null){
			firstEnterWaitList = firstEnterpriseService.getFirstEnterpriseByPage(hqlBuffer.toString(), new HashMap<String, Object>(), 0, Constants.pagesize);
		}else{
			firstEnterWaitList = firstEnterpriseService.getFirstEnterpriseByPage(hqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		
		// 获取总条数
		int resultSize = firstEnterpriseService.getRecordCount(sqlBuffer.toString());
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/SYQY/syqydsh","firstEnterWaitList",firstEnterWaitList);
	}
	@RequestMapping("/firstEnterprise/view_syqydsh.html")
	public ModelAndView viewFirstEnterWait(Model model,HttpServletRequest request ,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		FirstEnterprise enterprise = firstEnterpriseService.get(id);
		model.addAttribute("waitEnter",enterprise);
		return  new  ModelAndView("/QYZZ/SYQY/view_syqydsh");
	}
	@RequestMapping("/firstEnterprise/audit_syqydsh.html")
	public String autidFirstEnterWait(Model model,HttpServletRequest request ,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
	//	String rejectCause  = request.getParameter("rejectReason");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		/*String companyName = request.getParameter("companyName");
		String corporation = request.getParameter("corporation");
		String compamyAddress = request.getParameter("compamyAddress");
		String economic_nature = request.getParameter("economic_nature");//企业性质
		String postalcode = request.getParameter("postalcode");
		String quality_principal = request.getParameter("quality_principal");
		String sales_deputy = request.getParameter("sales_deputy");
		String phone = request.getParameter("phone");
		String certificate_No = request.getParameter("certificate_No");
		String business_license_No = request.getParameter("business_license_No");
		String license_No = request.getParameter("license_No");
		
		String apply_cause = request.getParameter("apply_cause");
		String examine_content = request.getParameter("examine_content");
		
		String business_licence = request.getParameter("business_licence");
		String licence = request.getParameter("licence");*/
		String reject_cause = request.getParameter("reject_cause");//驳回原因
		String save_type = request.getParameter("save_type");
	//	String p_id =request.getParameter("id");
		FirstEnterprise enterprise = firstEnterpriseService.get(id);
	
		/*Integer company_type=null;
		if(economic_nature!=null && !economic_nature.trim().equals("")){
			company_type= Integer.valueOf(economic_nature);
		}
		enterprise.setCompanyName(companyName);
		enterprise.setCorporation(corporation);
		enterprise.setCompamyAddress(compamyAddress);
		if(company_type!=null){
			enterprise.setEconomic_nature(company_type);
		}
		enterprise.setPostalcode(postalcode);
		enterprise.setQuality_principal(quality_principal);
		enterprise.setSales_deputy(sales_deputy);
		enterprise.setPhone(phone);
		enterprise.setApply_cause(apply_cause);
		enterprise.setExamine_content(examine_content);
		enterprise.setCertificate_No(certificate_No);
		enterprise.setBusiness_license_No(business_license_No);
		enterprise.setLicense_No(license_No);*/
		enterprise.setReject_cause(reject_cause);
		if(save_type.equals("0")){
			QualifiedSuppliers  s = qualifiedSuppliersService.findByFirstEnterpriseId(enterprise.getId());
			enterprise.setReview_status(2);//审核通过
			
		
			if(s !=null){
				s.setDeleteFlag("0");
				qualifiedSuppliersService.saveOrUpdate(s);
			}else{
				QualifiedSuppliers qualifiedSupp = new QualifiedSuppliers(enterprise);
				qualifiedSupp.setCustomerName(enterprise.getCompanyName());
				qualifiedSupp.setModifierId(user.getId());
				qualifiedSupp.setDeleteFlag("0");
				qualifiedSuppliersService.saveOrUpdate(qualifiedSupp);
			}
			
		}
		if(save_type.equals("1")){
			enterprise.setReview_status(3);//驳回
			enterprise.setReject_cause(reject_cause);
			enterprise.setReview_time(new Date());
		}
		firstEnterpriseService.saveOrUpdate(enterprise);
		logService.addLog("审核首营企业", user.getRealname(), "审核", "企业资质管理  > 首营企业", StringUtil.getIpAddr(request));
		
		
		return  REDIRECTPATH;
	}
	@RequestMapping("/firstEnterprise/batchOperate_syqydsh.html")
	public String batchOperateFirstEnter(Model model,HttpServletRequest request ,HttpServletResponse response){
		String[] p_ids = request.getParameterValues("operate_id");
		String batch_type = request.getParameter("batch_type");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		if(p_ids!=null && !p_ids.equals("")){
			
			for(String str_id : p_ids){
				Long id = Long.valueOf(str_id);
				FirstEnterprise enterprise = firstEnterpriseService.get(id);
				
				if(batch_type.equals("0")){
					QualifiedSuppliers  s = qualifiedSuppliersService.findByFirstEnterpriseId(enterprise.getId());
					enterprise.setReview_status(Integer.valueOf("2"));
					if(s!= null){
						s.setDeleteFlag("0");
						qualifiedSuppliersService.saveOrUpdate(s);
					}else{
						QualifiedSuppliers qualifiedSupp = new QualifiedSuppliers(enterprise);
						qualifiedSupp.setCustomerName(enterprise.getCompanyName());
						qualifiedSupp.setModifierId(user.getId());
						qualifiedSupp.setDeleteFlag("0");
						qualifiedSuppliersService.saveOrUpdate(qualifiedSupp);
					}
					
				}else if(batch_type.equals("1")){
					enterprise.setReview_status(Integer.valueOf("3"));
				}
				firstEnterpriseService.saveOrUpdate(enterprise);
			}
		}
		
		return  REDIRECTPATH;
	}
}
