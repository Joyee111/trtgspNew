package com.sinosoft.varietyManger.firstVarietyManger.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.BasedCriteria;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.BasedCriteriaService;
@Controller
public class BasedCriteriaAction extends BaseFormController {
	@Autowired
	private BasedCriteriaService service;
	@RequestMapping("/drugVarieties/basedCriteriaJson.html")
	public void findBasedCriteriaJson(HttpServletRequest request, HttpServletResponse response, Model model){
		List<BasedCriteria> list = null;
		try{
			list = service.getAll();
			String json = "[";
			int index=0;
			if(list!=null && list.size()>0){
				for(BasedCriteria supply : list){
						index++;
						json+="{";
						json+="\"id\":\""+supply.getBasedCriteriaId()+"\",";
						json+="\"text\":\""+supply.getBasedCriteriaName()+"\"";
						if(index==list.size()){
							json+="}";
						}else{
							json+="},";
						}
					}
			}
			json+="]";
			response.setContentType("text/json;charset=UTF-8");
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/system/dictionary/baseCriterias.html")
	public ModelAndView findBaseCriterias(Model model,HttpServletRequest request,HttpServletResponse response){
		List<BasedCriteria> criteriaList = null;
		String hql = "select a from BasedCriteria a where 1=1 order by a.basedCriteriaId DESC";
		String sql = "select count(*) from t_based_criteria";
		String page = DisplayGetPage.getPageParamName("criterList", request);
		if(page==null){
			criteriaList = service.getListByPage(hql, new HashMap(), 0, Constants.pagesize);
		}else{
			criteriaList = service.getListByPage(hql, new HashMap(), (Integer.valueOf(page)-1)*Constants.pagesize, Constants.pagesize);
		}
		int resultSeize = service.getRecordCount(sql);
		model.addAttribute("resultSize",resultSeize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSeize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/systemDataDictionary/baseCriteriaList","criteriaList", criteriaList);
	}
	@RequestMapping("/system/dictionary/queryBaseCriterias.html")
	public ModelAndView queryBaseCriterias(Model model,HttpServletRequest request,HttpServletResponse response){
		List<BasedCriteria> criteriaList = null;
		String baseCriteriaName = request.getParameter("baseCriteriaName");
		StringBuffer hqlBuffer = new StringBuffer("select a from BasedCriteria a where 1=1 ");
		StringBuffer sqlBuffer = new StringBuffer("select count(*) from t_based_criteria where 1=1");
		String page = DisplayGetPage.getPageParamName("criterList", request);
		Map<String, Object> hqlMap = new HashMap<String, Object>();
		if(baseCriteriaName!=null && !baseCriteriaName.trim().equals("")){
			hqlBuffer.append(" and a.basedCriteriaName like :name");
			hqlMap.put("name", "%"+baseCriteriaName+"%");
			sqlBuffer.append(" and basedCriteriaName like '%"+baseCriteriaName+"%'");
		}
		hqlBuffer.append(" order by a.basedCriteriaId DESC");
		if(page==null){
			criteriaList = service.getListByPage(hqlBuffer.toString(), hqlMap, 0, Constants.pagesize);
		}else{
			criteriaList = service.getListByPage(hqlBuffer.toString(), hqlMap, (Integer.valueOf(page)-1)*Constants.pagesize, Constants.pagesize);
		}
		int resultSeize = service.getRecordCount(sqlBuffer.toString());
		model.addAttribute("resultSize",resultSeize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSeize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/systemDataDictionary/baseCriteriaList","criteriaList", criteriaList);
	}
	@RequestMapping("/system/dictionary/addBaseCriteria.html")
	public String addBaseCriteria(Model model, HttpServletRequest request,HttpServletResponse response){
		return "/systemDataDictionary/add_baseCriteria";
	}
	@RequestMapping("/system/dictionary/ajaxSaveBaseCriterias.html")
	public String ajaxSaveBaseCriteris(BasedCriteria criteria, HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		BasedCriteria bc = null;
		Map<String, Object> map = new HashMap<String, Object>();
		bc  = service.save(criteria);
		if(bc.getBasedCriteriaId()>0){
			map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		}else{
			map.put("success", URLEncoder.encode("数据保存失败！", "UTF-8"));
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/system/dictionary/editBaseCriterias.html")
	public String  editBaseCriteria(Model model ,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id !=null && !p_id.trim().equals("")){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		BasedCriteria criteria = service.get(id);
		model.addAttribute("criteria", criteria);
		return "/systemDataDictionary/edit_baseCriteria";
	}
	@RequestMapping("/system/dictionary/ajaxUpdateBaseCriterias.html")
	public String ajaxUpadteBaseCriteris(BasedCriteria criteria, HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		Map<String, Object> map = new HashMap<String, Object>();
		 service.saveOrUpdate(criteria);
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/system/dictionary/ajaxDeleteBaseCriterias.html")
	public String ajaxDeleteBaseCriteria(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		Map<String,Object> map = new HashMap<String, Object>();
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && !p_id.trim().equals("")){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		try{
			service.remove(id );
			map.put("success", URLEncoder.encode("删除数据成功", "UTF-8"));
			UtilJson.printMapJson(response, map);
		}catch (HibernateException e) {
			map.put("success", URLEncoder.encode("删除数据失败 ", "UTF-8"));
			UtilJson.printMapJson(response, map);
			e.printStackTrace();
		} 
		return null;
	}
}
