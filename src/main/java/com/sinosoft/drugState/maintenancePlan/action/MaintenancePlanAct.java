package com.sinosoft.drugState.maintenancePlan.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.maintenancePlan.service.MaintenancePlanMng;
import com.sinosoft.qualityRecords.complantManager.service.DrugComInfoManger;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
import com.sinosoft.systemConfig.WarnConfig;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreRe;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
@Controller
public class MaintenancePlanAct {
	
	@Autowired
	private MaintenancePlanMng maintenancePlanMng;
	@Autowired
	private DrugComInfoManger drugComInfoManger;
	@Autowired
	private InspectionMng inspectionMng;
	@RequestMapping("/drugState/MaintenancePlan/list.html")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		String pageNo = request.getParameter("thispage");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String batchNumber = request.getParameter("batchNumber");
		QualifiedmedcstoreRe qm = new QualifiedmedcstoreRe();
		if(pageNo!=null){
			page=pageNo;
		}
		List<QualifiedmedcstoreRe> reslist=new ArrayList<QualifiedmedcstoreRe>();
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			// 由于增加下一个养护日期时间范围查询  注释点 reslist= maintenancePlanMng.getPage(qm,0,Constants.pagesize);
			reslist = maintenancePlanMng.getQualifiedMdecByDate(startDate, endDate,batchNumber, 0, Constants.pagesize);
		}
		else{
			//否者翻页查询
			//reslist= maintenancePlanMng.getPage(qm,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			reslist = maintenancePlanMng.getQualifiedMdecByDate(startDate, endDate,batchNumber, (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		WarnConfig warnConfig =maintenancePlanMng.findWanrn();
		for(QualifiedmedcstoreRe re:reslist){
			
			if(re.getNextmaintaindate()!=null && !"".equals(re.getNextmaintaindate())){
				//String currentDate = DateTimeUtils.getNowStrDate();
				String date = DateTimeUtils.formCurrentDate(DateTimeUtils
						.getCalendar(Integer.valueOf(warnConfig.getLimit_day())));//当前日期加上预警天数后的日期
				String nextDate = re.getNextmaintaindate();
//				Calendar cal = Calendar.getInstance();
//				SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");   
//				Date time=null;
//				try {
//					time = formatDate.parse(re.getNextmaintaindate());
//				} catch (java.text.ParseException e) {
//					e.printStackTrace();
//				}
////				cal.setTime(time);
//				if(warnConfig.getLimit_day()!=null && !"".equals(warnConfig.getLimit_day())){
//					cal.add(Calendar.DATE,-Integer.parseInt(warnConfig.getLimit_day()));
//				}
//				Date date = new Date();
//				Calendar cal2 = Calendar.getInstance();
//				cal2.setTime(date);
				if(DateTimeUtils.compareTwoDate(date,nextDate) >= 0){
					re.setColor("1");
				}else{
					re.setColor("2");
				}
//				if(nextDate date){
//					re.setColor("2");
//				}else{
//					re.setColor("1");
//				}
			}
		}
	//	int resultSize = maintenancePlanMng.getTotalCount(qm);
		int resultSize = maintenancePlanMng.countQualifiedMdeByCondition(startDate, endDate, batchNumber);
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("drugState/MaintenancePlan/list");
	}
	@RequestMapping("/drugState/MaintenancePlan/add.html")
	public ModelAndView add(DrugMaintenance dm,String id, HttpServletRequest request, HttpServletResponse response, Model model){
		QualifiedmedcstoreRe qu = maintenancePlanMng.findById(id);
		QualityMidicine qm = inspectionMng.findHGYP(qu.getQualifiedmedicineid());
		qu.setQualityMidicine(qm);
		if(qu!=null){
			dm.setId(null);
			dm.setMaintaindate(qu.getNextmaintaindate());
			dm.setBatchnumber(qu.getBatchproduction());
			dm.setQuantity(qu.getQuantity());
			dm.setQualifiedmedcstoreRe(qu);
		}
		String method = request.getParameter("method");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		Long medicinalNo=null;
		String titles="药品养护新增";
		model.addAttribute("titles", titles);
		model.addAttribute("medicinalNo", medicinalNo);
		Map<String, String> quamap= drugComInfoManger.qmMap();
		model.addAttribute("quamap", quamap);
		model.addAttribute("dm",dm );
		model.addAttribute("method", method);		
			return new ModelAndView("qualityRecords/drugMaintenance/add");
		}
}
