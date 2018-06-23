package com.sinosoft.comQuery.infoFeedbackRecords.action;

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
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedBackItemAndUserVO;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedback;
import com.sinosoft.qualityRecords.infoFeedback.serivice.InfoFeedbackMng;
import com.sinosoft.util.DisplayGetPage;

@Controller
public class InfoFeedbackRecordsAct {
	@Autowired
	private InfoFeedbackMng infoFeedbackMng;
	
	@RequestMapping("/comQuery/infoFeedbackRecords/list.html")
	public ModelAndView openFramePage(String firstJoin,InfoFeedback df, HttpServletRequest request, HttpServletResponse response, Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		String feedbackdepartment = request.getParameter("feedbackdepartment");//反馈部门
		String pinming = request.getParameter("pinming");//品名
		String startDate  = request.getParameter("tousuriqi");//反馈开始时间
		String endDate =  request.getParameter("zhi");//反馈结束时间
		String[] queryType = request.getParameterValues("wcqk") ;//查询类型
		
		List<InfoFeedback> infoFeedbackList = null;//信息反馈单的发起者
		Map<String, Object> paraMap = new HashMap<String, Object>();
		StringBuffer hqlBuffer = new StringBuffer("select t from InfoFeedback t  where 1=1  ");
		StringBuffer countHqlBuffer = new StringBuffer("select count(t) from InfoFeedback t  where 1=1 ");
		
		StringBuffer buffer = new StringBuffer();
		if(feedbackdepartment != null && !"".equals(feedbackdepartment.trim())){
			buffer.append(" and  t.feedbackdepartment like :department ");
			paraMap.put("department", "%"+feedbackdepartment+"%");
		}
		if(pinming != null && !"".equals(pinming.trim())){
			buffer.append(" and  t.commonName like :commonName ");
			paraMap.put("commonName", "%"+pinming+"%");
		}
		if(startDate != null && !"".equals(startDate.trim())){
			buffer.append(" and  CONVERT(varchar(50), t.createDate, 20) >= :startDate ");
			paraMap.put("startDate", startDate+" 00:00:00");
		}
		if(endDate != null && !"".equals(endDate.trim())){
			buffer.append(" and  CONVERT(varchar(50), t.createDate, 20) <= :endDate ");
			paraMap.put("endDate", startDate+" 23:59:59");
		}
		if(queryType == null || queryType.length==0 ||  queryType.length == 2 ){
			
		}else if(queryType.length == 1){
			List<String> list = null;
			if(queryType[0].equals("0")){
				list = infoFeedbackMng.findBackId(" SELECT cast(a.infoFeedback_Id as varchar)  FROM (select ti.type,ti.infoFeedback_Id  from t_InfoFeedback_item ti   WHERE   ti.content is not null GROUP by ti.infoFeedback_Id,ti.type) a  GROUP BY a.infoFeedback_Id HAVING COUNT(a.infoFeedback_Id) = 4 ");
				buffer.append(" and t.id in ( :list )");
			}else if (queryType[0].equals("1")){
				list = infoFeedbackMng.findBackId(" SELECT cast(a.infoFeedback_Id as varchar)  FROM (select ti.type,ti.infoFeedback_Id  from t_InfoFeedback_item ti   WHERE   ti.content is not null GROUP by ti.infoFeedback_Id,ti.type) a  GROUP BY a.infoFeedback_Id HAVING COUNT(a.infoFeedback_Id) <> 4 ");
				buffer.append(" and t.id in  ( :list )");
			}
			List<Long> longList = new ArrayList<Long>();
			for(int i=0,j=list.size();i<j;i++){
				longList.add(Long.valueOf(list.get(i)));
			}
			paraMap.put("list", longList); 
		}
		
		hqlBuffer.append(buffer);
		hqlBuffer.append(" order by createDate desc ");
		//waitToDoHqlBuffer.append(buffer);
		countHqlBuffer.append(buffer);
	//	waitToDoCountHqlBuffer.append(buffer);
		if(page == null || "".equals(page.trim()) || "".equals(page.trim())){
			infoFeedbackList = infoFeedbackMng.findInfoFeedbacks(hqlBuffer.toString(), paraMap, 0, Constants.pagesize);
		}else{
			infoFeedbackList = infoFeedbackMng.findInfoFeedbacks(hqlBuffer.toString(), paraMap, (Integer.parseInt(page)-1)*Constants.pagesize, Constants.pagesize);
		}
		
		int resultSize = infoFeedbackMng.countInfoFeedbacks(countHqlBuffer.toString(), paraMap);
		
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("infoFeedbackList",infoFeedbackList);
		return new ModelAndView("comQuery/infoFeedbackRecords/list");
	}
	@RequestMapping("/comQuery/infoFeedbackRecords/view.html")
	public String viwetInfoFeed(Model model, HttpServletRequest request, HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id != null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else {
			id = Long.valueOf(p_id);
		}
		InfoFeedback infoFeedbackVO = infoFeedbackMng.getInfoFeedback(id);
		List<InfoFeedBackItemAndUserVO> itemList =  null;
		 if(infoFeedbackVO != null){
			 itemList =  infoFeedbackMng.findInfoFeedBackItemAndUserVO(infoFeedbackVO.getId());
		 }
		model.addAttribute("infoFeedBack", infoFeedbackVO);
		model.addAttribute("itemList", itemList);
		return "comQuery/infoFeedbackRecords/view";
	}
}