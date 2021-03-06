package com.sinosoft.comQuery.unqualifiedManagerRecords.action;

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
import com.sinosoft.comQuery.inspeAcceptRecords.model.InspeAcceptRecords;
import com.sinosoft.comQuery.unqualifiedManagerRecords.service.UnqualifiedManagerRecordsMng;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;
import com.sinosoft.util.DisplayGetPage;
@Controller
public class UnqualifiedManagerRecordsAct {
	@Autowired
	private UnqualifiedManagerRecordsMng unqualifiedManagerRecordsMng;

	public void setUnqualifiedManagerRecordsMng(
			UnqualifiedManagerRecordsMng unqualifiedManagerRecordsMng) {
		this.unqualifiedManagerRecordsMng = unqualifiedManagerRecordsMng;
	}
	@RequestMapping("/comQuery/unqualifiedManagerRecords/list.html")
	public ModelAndView openFramePage(InspeAcceptRecords ir, HttpServletRequest request, HttpServletResponse response, Model model){
		
			return new ModelAndView("comQuery/unqualifiedManagerRecords/list");
		}
      @RequestMapping("/comQuery/unqualifiedManagerRecords/query.html")
  	public ModelAndView queryEnterpristInfoList( HttpServletRequest request, HttpServletResponse response, Model model){

		String shouhuoriqi= request.getParameter("shouhuoriqi");
		String mingcheng= request.getParameter("mingcheng");
		String pihao= request.getParameter("pihao");
		String isfood= request.getParameter("isfood");
		String page = DisplayGetPage.getPageParamName("records", request);
		model.addAttribute("shouhuoriqi", shouhuoriqi);
		model.addAttribute("mingcheng", mingcheng);
		model.addAttribute("pihao", pihao);
		model.addAttribute("isfood", isfood);
	
		UnqualifiedManager um = new UnqualifiedManager();
		if(shouhuoriqi !=null && !"".equals(shouhuoriqi)){
			um.setProcessingDate(shouhuoriqi);
		}
		if(mingcheng !=null && !"".equals(mingcheng)){
			um.setQualifiedmedicineid(Long.parseLong(mingcheng));
		}
		if(pihao !=null && !"".equals(pihao)){
			um.setBatchno(pihao);
		}
	
		List<UnqualifiedManager> reslist=new ArrayList<UnqualifiedManager>();
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			reslist= unqualifiedManagerRecordsMng.getPage(um,isfood,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			reslist= unqualifiedManagerRecordsMng.getPage(um,isfood,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = unqualifiedManagerRecordsMng.getTotalCount(um,isfood);
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("comQuery/unqualifiedManagerRecords/query");
	}
} 
