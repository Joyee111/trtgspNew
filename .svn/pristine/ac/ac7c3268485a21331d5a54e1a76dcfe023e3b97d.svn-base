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
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise;
import com.sinosoft.enterpriseManage.firstEnterprise.service.FirstEnterpriseService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
@Controller
public class FirstEnterRejectAction extends BaseFormController {
	private static String REDIRECTPATH ="redirect:/firstEnterprise/syqyybh.html";
	@Autowired
	private FirstEnterpriseService firstEnterpriseService ;
	@Autowired
	private SystemLogService logService;
	@RequestMapping("/firstEnterprise/syqyybh.html")
	public ModelAndView  firstEnterRejectList(Model model ,HttpServletRequest request , HttpServletResponse response){
		List<FirstEnterprise> firstEnterRejectList = new ArrayList<FirstEnterprise>();
		//	String page = DisplayGetPage.getPageParamName("users", request);// 第几页
			String page = DisplayGetPage.getPageParamName("rejectEnter", request);
			String hql = "from FirstEnterprise a where a.review_status =3 order by a.id DESC";
			if(page==null){
				firstEnterRejectList = firstEnterpriseService.getFirstEnterpriseByPage(hql, new HashMap<String, Object>(), 0, Constants.pagesize);
			}else{
				firstEnterRejectList = firstEnterpriseService.getFirstEnterpriseByPage(hql, new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}
			
			// 获取总条数
			int resultSize = firstEnterpriseService.getOrderInfoCountByState(Integer.valueOf(3));
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("pagesize", Constants.pagesize);
		//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
			double size = resultSize;
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			return new ModelAndView("/QYZZ/SYQY/syqyybh","firstEnterRejectList",firstEnterRejectList);
		//return new ModelAndView("");
	}
	@RequestMapping("/firstEnterprise/query_syqyybh.html")
	public ModelAndView queryEnterRejectInfoList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<FirstEnterprise> firstEnterRejectList = new ArrayList<FirstEnterprise>();
		String query_qycx= request.getParameter("query_qycx");
		// 暂时先不考虑String query_zjhm= request.getParameter("query_zjhm");
		
	//	String page = DisplayGetPage.getPageParamName("users", request);// 第几页
		String page = DisplayGetPage.getPageParamName("waitEnter", request);
	//	String hql = "from FirstEnterprise a where a.review_status =2 order by a.id DESC";
		StringBuffer hqlBuffer = new StringBuffer("from FirstEnterprise a where a.review_status =3");
		StringBuffer sqlBuffer = new StringBuffer("select count(*) from t_FirstEnterprise where 1=1 and review_status = 1");
		if(query_qycx!=null && !query_qycx.equals("")){
			hqlBuffer.append(" and ( a.companyName like '%");
			hqlBuffer.append(query_qycx+"%' or a.corporation like '%");
			hqlBuffer.append(query_qycx+"%' ) ");
			sqlBuffer.append(" and (name like '%").append(query_qycx).append("%' or corporation like'%").append(query_qycx).append("%')");
		}
		hqlBuffer.append(" order by a.id DESC");
		if(page==null){
			firstEnterRejectList = firstEnterpriseService.getFirstEnterpriseByPage(hqlBuffer.toString(), new HashMap<String, Object>(), 0, Constants.pagesize);
		}else{
			firstEnterRejectList = firstEnterpriseService.getFirstEnterpriseByPage(hqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		
		// 获取总条数
		int resultSize = firstEnterpriseService.getRecordCount(sqlBuffer.toString());
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/SYQY/syqyybh","firstEnterRejectList",firstEnterRejectList);
	}
	@RequestMapping("/firstEnterprise/view_syqyybh.html")
	public ModelAndView viewFirstEnterReject(Model model,HttpServletRequest request ,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		FirstEnterprise enterprise = firstEnterpriseService.get(id);
		model.addAttribute("rejectEnter",enterprise);
		return  new  ModelAndView("/QYZZ/SYQY/view_syqyybh");
	}
	@RequestMapping("/firstEnterprise/confrim_syqyybh.html")
	public String  confrimPurchaseRejectUnits(Model model,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		FirstEnterprise firstEnterprise = firstEnterpriseService.get(id);
		firstEnterprise.setReview_status(Integer.valueOf(0));
		firstEnterpriseService.saveOrUpdate(firstEnterprise);
	//	model.addAttribute("purchaseUnit",purchaseUnit);
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("确认驳回首营企业", user.getRealname(), "确认驳回", "企业资质管理  > 首营企业", StringUtil.getIpAddr(request));
		return REDIRECTPATH;
	}
}
