package com.sinosoft.varietyManger.firstVarietyManger.action;

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
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicineRecords;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineRecordsService;

/**
 * @author lfl:
 * @version 创建时间：Jun 8, 2013 11:16:37 AM
 * 类说明  合格药品修改记录
 */
@Controller
public class QualityMidicineRecordsAction extends BaseFormController {
	@Autowired
	private QualityMidicineRecordsService service;
	@RequestMapping("/drugVarieties/queryQulidiedMedicinalRecord.html")
	public ModelAndView getQualityMidicineRecords(Model model,HttpServletRequest request,HttpServletResponse response){
		List<QualityMidicineRecords> recordsyList = new ArrayList<QualityMidicineRecords>();
		String page = DisplayGetPage.getPageParamName("record", request);
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && !p_id.equals("")){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		String hql = "from QualityMidicineRecords a where  a.qulityMidicineId="+id+ " order by a.modifyTime DESC";
		String sql ="select count(*) from t_qualified_medicine_archives where qulityMidicineId="+id;
		if(page==null){
			recordsyList = service.getListByPage(hql, new HashMap(), 0, Constants.pagesize);
		}else{
			recordsyList = service.getListByPage(hql, new HashMap(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		
		// 获取总条数
		int resultSize = service.getRecordCount(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/arietyManage/qualifiedmedicinal/hgypjl","recordsyList",recordsyList);
		//return null;
	}
}
