package com.sinosoft.dictionary.action;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
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
import com.sinosoft.dictionary.mode.DrugFormDictionary;
import com.sinosoft.dictionary.service.DrugFormDictionaryService;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.UtilJson;

/**
 * @author lfl:
 * @version 创建时间：Jun 6, 2013 2:48:09 PM
 * 类说明
 */
@Controller
public class DrugFormDictionaryActioon extends BaseFormController {
	@Autowired
	private  DrugFormDictionaryService service;
	@RequestMapping("/dectionary/ajaxQueryForm.html")
	public String ajaxQueryFormDiction(Model model ,HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		List<DrugFormDictionary> formDictionaryList = new ArrayList<DrugFormDictionary>();
		formDictionaryList = service.getDrugFromDictionnaryOrderByName();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("formDictionaryList",formDictionaryList);
		UtilJson.printMapJson(response, map);
		return null;
	}
	
	@RequestMapping("/system/dictionary/drugFroms.html")
	public ModelAndView findDrugFrom(Model model,HttpServletRequest request,HttpServletResponse response){
		List<DrugFormDictionary> drugFromList = null;
		String hql = "select a from DrugFormDictionary a where 1=1 order by a.id DESC";
		String sql = "select count(*) from t_dosage_form";
		String page = DisplayGetPage.getPageParamName("drugFrom", request);
		if(page==null){
			drugFromList = service.getListByPage(hql, new HashMap(), 0, Constants.pagesize);
		}else{
			drugFromList = service.getListByPage(hql, new HashMap(), (Integer.valueOf(page)-1)*Constants.pagesize, Constants.pagesize);
		}
		int resultSeize = service.getRecordCount(sql);
		model.addAttribute("resultSize",resultSeize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSeize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/systemDataDictionary/drugFromList","drugFromList", drugFromList);
	}
	@RequestMapping("/system/dictionary/queryDrugFrom.html")
	public ModelAndView queryDrugFrom(Model model,HttpServletRequest request,HttpServletResponse response){
		List<DrugFormDictionary> drugFromList = null;
		String formName = request.getParameter("formName");
		StringBuffer hqlBuffer = new StringBuffer("select a from DrugFormDictionary a where 1=1 ");
		StringBuffer sqlBuffer = new StringBuffer("select count(*) from t_dosage_form where 1=1");
		String page = DisplayGetPage.getPageParamName("drugFrom", request);
		Map<String, Object> hqlMap = new HashMap<String, Object>();
		if(formName!=null && !formName.trim().equals("")){
			hqlBuffer.append(" and a.formName like :name");
			hqlMap.put("name", "%"+formName+"%");
			sqlBuffer.append(" and form_name like '%"+formName+"%'");
		}
		hqlBuffer.append(" order by a.id DESC");
		if(page==null){
			drugFromList = service.getListByPage(hqlBuffer.toString(), hqlMap, 0, Constants.pagesize);
		}else{
			drugFromList = service.getListByPage(hqlBuffer.toString(), hqlMap, (Integer.valueOf(page)-1)*Constants.pagesize, Constants.pagesize);
		}
		int resultSeize = service.getRecordCount(sqlBuffer.toString());
		model.addAttribute("resultSize",resultSeize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSeize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/systemDataDictionary/drugFromList","drugFromList", drugFromList);
	}
	@RequestMapping("/system/dictionary/addDrugFrom.html")
	public String addBaseCriteria(Model model, HttpServletRequest request,HttpServletResponse response){
		return "/systemDataDictionary/add_drugFrom";
	}
	@RequestMapping("/system/dictionary/ajaxSaveDrugFrom.html")
	public String ajaxSaveDrugFrom(DrugFormDictionary criteria, HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		DrugFormDictionary bc = null;
		Map<String, Object> map = new HashMap<String, Object>();
		bc  = service.save(criteria);
		if(bc.getId()>0){
			map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		}else{
			map.put("success", URLEncoder.encode("数据保存失败！", "UTF-8"));
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/system/dictionary/editDrugFrom.html")
	public String  editBaseCriteria(Model model ,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id !=null && !p_id.trim().equals("")){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		DrugFormDictionary drugForm = service.get(id);
		model.addAttribute("drugForm", drugForm);
		return "/systemDataDictionary/edit_drugFrom";
	}
	@RequestMapping("/system/dictionary/ajaxUpdateDrugFrom.html")
	public String ajaxUpadteDrugFrom(DrugFormDictionary criteria, HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		Map<String, Object> map = new HashMap<String, Object>();
		 service.saveOrUpdate(criteria);
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/system/dictionary/ajaxDeleteDrugFrom.html")
	public String ajaxDeleteDrugFrom(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
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
