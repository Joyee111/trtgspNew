package com.sinosoft.qualityRecords.drugMaintenance.action;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.maintenancePlan.service.MaintenancePlanMng;
import com.sinosoft.qualityRecords.complantManager.service.DrugComInfoManger;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenanceRecords;
import com.sinosoft.qualityRecords.drugMaintenance.serivice.DrugMaintenanceMng;
import com.sinosoft.qualityRecords.drugMaintenance.serivice.DrugMaintenanceRecordsManager;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreRe;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualifiedmedcstoreMng;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualifiedmedcstoreReMng;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;

@Controller
public class DrugMaintenanceAct {
	@Autowired
	private MaintenancePlanMng maintenancePlanMng;
	@Autowired
	private InspectionMng inspectionMng;
	private DrugMaintenanceMng drugMaintenanceMng;
	@Autowired
	public void setDrugMaintenanceMng(DrugMaintenanceMng drugMaintenanceMng) {
		this.drugMaintenanceMng = drugMaintenanceMng;
	}
	@Autowired
	private DrugMaintenanceRecordsManager drugMaintenanceRecordsManager;
	/*
	 * 合格药品库
	 */
	private  QualifiedmedcstoreMng qualifiedmedcstoreMng;
	/*
	 * 新合格药品库，包括返厂的
	 */
	@Autowired
	private  QualifiedmedcstoreReMng qualifiedmedcstoreReMng;
	@Autowired
	public void setQualifiedmedcstoreMng(QualifiedmedcstoreMng qualifiedmedcstoreMng) {
		this.qualifiedmedcstoreMng = qualifiedmedcstoreMng;
	}
	private DrugComInfoManger drugComInfoManger;
	@Autowired
	public void setDrugComInfoManger(DrugComInfoManger drugComInfoManger) {
		this.drugComInfoManger = drugComInfoManger;
	}
	@Autowired
	private SystemLogService logService;
	@Autowired
	private QualityMidicineMng qualityMidicineMng;
	@Autowired
	private DrugMaintenanceRecordsManager dRecordsManager;
	@RequestMapping("/qualityRecords/drugMaintenance/list.html")
	public ModelAndView openFramePage(DrugMaintenance dm, HttpServletRequest request, HttpServletResponse response, Model model){
			String page = DisplayGetPage.getPageParamName("records", request);// 第几页
			List<DrugMaintenance> reslist=new ArrayList<DrugMaintenance>();
			if(page==null){
				//如果page等于空，默认从第一条开始查询
				
				reslist= drugMaintenanceMng.getPage(dm,0,Constants.pagesize);
				
			}
			else{
				//否者翻页查询
				reslist= drugMaintenanceMng.getPage(dm,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			}
			for(int i=0;i<reslist.size();i++){
				if(reslist.get(i).getIsqualified().equals("0")){
					reslist.get(i).setIsqualified("不合格");
					
				}else{
					reslist.get(i).setIsqualified("合格");
				}
				
				
			}
			

			int resultSize = drugMaintenanceMng.getTotalCount();
			double size = resultSize;
			//页数
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			model.addAttribute("pageSize", Constants.pagesize);
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("dm", dm);
			model.addAttribute("reslist", reslist);
			return new ModelAndView("qualityRecords/drugMaintenance/list");
		}
	@RequestMapping("/qualityRecords/drugMaintenance/query.html")
	public ModelAndView queryEnterpristInfoList( DrugMaintenance dm,Model model,HttpServletRequest request,HttpServletResponse response){
		List<DrugMaintenance> reslist=new ArrayList<DrugMaintenance>();
		String maintaindate= request.getParameter("maintaindate");
		String pinming= request.getParameter("pinming");
		String page = DisplayGetPage.getPageParamName("records", request);
		model.addAttribute("maintaindate", maintaindate);
		model.addAttribute("pinming", pinming);
	
		if(page==null){
			//如果page等于空，默认从第一条开始查询	
			reslist= drugMaintenanceMng.getPage(dm,0,Constants.pagesize);	
		}else{
			if(maintaindate.equals("")&& pinming.equals("")){
				Integer a = (Integer.parseInt(page) - 1) * Constants.pagesize;
				//否者翻页查询
				reslist= drugMaintenanceMng.getPage(dm,a,Constants.pagesize);
				 int resultSize = drugMaintenanceMng.getTotalCount();
				 double size = resultSize;
					model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
					model.addAttribute("resultSize", resultSize);
			}else{
				StringBuffer sqlBuffer = new StringBuffer("select  d  from DrugMaintenance  d ,QualifiedmedcstoreRe m, QualityMidicine q  " +
						" where  d.qualifiedmedicineid = m.qualifiedmedicineid  and m.qualifiedmedicineid= q.id  and d.batchnumber= m.batchproduction");
				if(maintaindate!=null && !maintaindate.equals("")){
					sqlBuffer.append(" and  d.maintaindate = '");
					sqlBuffer.append(maintaindate+"'  ");
				}
				if(pinming!=null && !pinming.equals("")){
					sqlBuffer.append(" and q.commonname like '%");
					sqlBuffer.append(pinming+"%'  ");
				}
				if(page==null){
					reslist= drugMaintenanceMng.getPage(dm,0,Constants.pagesize);
				}else{
					reslist = drugMaintenanceMng.getDrugMaintenanceByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
				}
			
				StringBuffer buffer=new StringBuffer(" SELECT  count(*) FROM t_maintain_info d ,  t_qualified_medicine q ,t_qualified_medc_store m" +
						"  where  d.qualified_medicine_id =m.qualified_medicine_id and m.qualified_medicine_id=q.id and d.batch_numbe = m.batch_production ");

				if(maintaindate!=null && !maintaindate.equals("")){
					buffer.append("  and d.maintain_date ='");
					buffer.append(maintaindate+"'  ");
				}
				if(pinming!=null && !pinming.equals("")){
					buffer.append(" and q.common_name like '%");
					buffer.append(pinming+"%'  ");
				}
				int resultSize = drugMaintenanceMng.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
				
			}
		}
//		for(int i=0;i<reslist.size();i++){
//			if(reslist.get(i).getIsqualified().equals("0")){
//				reslist.get(i).setIsqualified("不合格");
//				
//			}else{
//				reslist.get(i).setIsqualified("合格");
//			}
//		
//			
//		}
		
		//页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("dm", dm);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("qualityRecords/drugMaintenance/list");
	}
	@RequestMapping("/qualityRecords/drugMaintenance/add.html")
	public ModelAndView add(DrugMaintenance dm,String id, HttpServletRequest request, HttpServletResponse response, Model model){
		String method = request.getParameter("method");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		DrugMaintenance drugMaintenance=new DrugMaintenance();
		Long medicinalNo=null;
		String titles="药品养护新增";
		String ids;
		if(!method.equals("add")){
			 titles="药品养护修改";
			drugMaintenance=drugMaintenanceMng.findById(id);
			if(drugMaintenance.getQualifiedmedcstoreRe()!=null){
				if(drugMaintenance.getQualifiedmedcstoreRe().getQualityMidicine()!=null){
					medicinalNo=drugMaintenance.getQualifiedmedcstoreRe().getQualityMidicine().getId();
				}
			
			}
			ids=((Long) drugMaintenance.getQualifiedmedicineid()).toString();
			
			QualityMidicine  qualityMidicine=drugComInfoManger.findYpById(ids.toString());
			QualifiedmedcstoreRe qualifiedmedcstoreRe=new QualifiedmedcstoreRe();
			qualifiedmedcstoreRe.setQualityMidicine(qualityMidicine);
			drugMaintenance.setQualifiedmedcstoreRe(qualifiedmedcstoreRe);
		}

		
		model.addAttribute("titles", titles);
		model.addAttribute("medicinalNo", medicinalNo);
		Map<String, String> quamap= drugComInfoManger.qmMap();
		model.addAttribute("quamap", quamap);
		model.addAttribute("dm",drugMaintenance );
		model.addAttribute("method", method);		
			return new ModelAndView("qualityRecords/drugMaintenance/add");
		}
	@RequestMapping("/qualityRecords/drugMaintenance/saveOrUpdata.html")
	public ModelAndView saveOrUpdate(DrugMaintenance dm, HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException{
		String op = request.getParameter("method");
		String id = request.getParameter("re_id");
		String qualifiedmedicineid = request.getParameter("qualifiedMedicineId");
		String isqualified = request.getParameter("isqualified");//是否合格
		String isqualified_type=null;
		if(isqualified!=null && !isqualified.trim().equals("")){
			isqualified_type= isqualified;
		}
		if(isqualified_type!=null){
			dm.setIsqualified(isqualified_type);
		}
		dm.setQualifiedmedicineid(Long.parseLong(qualifiedmedicineid));
		QualifiedmedcstoreRe qualifiedmedcstoreRe=new QualifiedmedcstoreRe();

		
		String pihao=dm.getBatchnumber();
		//根据id找到新合格药品库
		if(id!=null){
			qualifiedmedcstoreRe=maintenancePlanMng.findById(id);
		}
		Long ypid = null;
		QualityMidicine qm = null;
		if(qualifiedmedcstoreRe!=null){
			 //药品id
			ypid=qualifiedmedcstoreRe.getQualifiedmedicineid();
			//根据药品id得到药品 然后得到药品的养护周期
			    qm = inspectionMng.findHGYP(ypid); 
		}
	   
	    if(dm.getMaintaindate()!=null &&qm!=null){

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");   
			Date time=null;
			try {
				time = formatDate.parse(dm.getMaintaindate());
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}    
			cal.setTime(time);
			cal.add(Calendar.MONTH,Integer.parseInt(qm.getMaintainCycle()));
			qualifiedmedcstoreRe.setNextmaintaindate(formatDate.format(cal.getTime()));	
	    }
	    if(qualifiedmedcstoreRe!=null){
	    	qualifiedmedcstoreReMng.updatequ(qualifiedmedcstoreRe);
	    }
	    
		dm.setModifiedtime(new Date());
		
		
		User localuser = (User) request.getSession().getAttribute(
				Constants.LOCAL_USER);
		dm.setModifierid(localuser.getId());

		if(!op.equals("add")){
			String modify_reason = request.getParameter("modify_reason");
			DrugMaintenance maintenance = drugMaintenanceMng.findById(dm.getId().toString());
			if(!maintenance.getQualifiedmedicineid().equals(dm.getQualifiedmedicineid())){
				QualityMidicine oldMidicine = qualityMidicineMng.get(maintenance.getQualifiedmedicineid());
				QualityMidicine newMidicine = qualityMidicineMng.get(dm.getQualifiedmedicineid());
				dRecordsManager.saveDrugMaintenanceRecords(maintenance.getId(), "修改养护药品", "养护药品修改之前为货号是"+oldMidicine.getMedicinalNo()+"的"+oldMidicine.getCommonname()+"修改之后是货号为"+newMidicine.getMedicinalNo()+"的"+newMidicine.getCommonname(), localuser, modify_reason);
			}
			if(!maintenance.getMaintaindate().equals(dm.getMaintaindate())){
				dRecordsManager.saveDrugMaintenanceRecords(maintenance.getId(), "修改药品养护时间", "药品养护时间修改之前为"+maintenance.getMaintaindate()+"修改之后药品养护时间为"+dm.getMaintaindate(), localuser, modify_reason);
			}
			if(!maintenance.getGoodsallocation().equals(dm.getGoodsallocation())){
				dRecordsManager.saveDrugMaintenanceRecords(maintenance.getId(), "修改药品养护货位", "药品养护货位修改之前为"+maintenance.getGoodsallocation()+"修改之后药品养护货位为"+dm.getGoodsallocation(), localuser, modify_reason);
			}
			if(!maintenance.getQuantity().equals(dm.getQuantity())){
				dRecordsManager.saveDrugMaintenanceRecords(maintenance.getId(), "修改养护药品数量", "养护药品数量修改之前为"+maintenance.getQuantity()+"修改之后养护药品数量为"+dm.getQuantity(), localuser, modify_reason);
			}
			if(!maintenance.getBatchnumber().equals(dm.getBatchnumber())){
				dRecordsManager.saveDrugMaintenanceRecords(maintenance.getId(), "修改养护药品批号", "养护药品批号修改之前为"+maintenance.getBatchnumber()+"修改之后养护药品批号为"+dm.getBatchnumber(), localuser, modify_reason);
			}
			if(!maintenance.getIsqualified().equals(dm.getIsqualified())){
				String oldStatus = (maintenance.getIsqualified().equals("1"))?"合格":"不合格";
				String newStatus = (dm.getIsqualified().equals("1"))?"合格":"不合格";
				dRecordsManager.saveDrugMaintenanceRecords(maintenance.getId(), "修改养护药品状态", "养护药品状态修改之前为"+oldStatus+"修改之后养护药品状态为"+newStatus, localuser, modify_reason);
			}
			if(!maintenance.getQualityproblemString().trim().equalsIgnoreCase(dm.getQualityproblemString().trim())){
				dRecordsManager.saveDrugMaintenanceRecords(maintenance.getId(), "修改养护药品质量情况", "养护药品质量情况修改之前为"+maintenance.getQualityproblemString()+"修改之后养护药品质量情况为"+dm.getQualityproblemString(), localuser, modify_reason);
			}
			if(!maintenance.getResult().trim().equals(dm.getResult().trim())){
				dRecordsManager.saveDrugMaintenanceRecords(maintenance.getId(), "修改养护药品处理结果", "养护药品处理结果修改之前为"+maintenance.getResult()+"修改之后养护药品处理结果为"+dm.getResult(), localuser, modify_reason);
			}
			if(!maintenance.getRemark().trim().equals(dm.getRemark().trim())){
				dRecordsManager.saveDrugMaintenanceRecords(maintenance.getId(), "修改养护药品备注", "养护药品备注修改之前为"+maintenance.getRemark()+"修改之后养护药品备注为"+dm.getRemark(), localuser, modify_reason);
			}
			drugMaintenanceMng.saveOrUpdata(dm);
			
			
		}else{
			drugMaintenanceMng.saveDrugMaintenance(dm);	
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("新增养护记录", user.getRealname(), "新增", "质量记录管理  >养护记录", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/qualityRecords/drugMaintenance/del.html")
	public ModelAndView del(String ids[], HttpServletRequest request, HttpServletResponse response, Model model){
		if(ids!=null && ids.length>0){
			drugMaintenanceMng.del(ids);
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除养护记录", user.getRealname(), "删除", "质量记录管理  >养护记录", StringUtil.getIpAddr(request));
		return openFramePage(null, request, response, model);
	}
	@RequestMapping("/qualityRecords/drugMaintenance/findDrugMaintenanceRecords.html")
	public String findDrugMaintenanceRecords(Model model, HttpServletRequest request, HttpServletResponse response){
		List<DrugMaintenanceRecords> list = null;
		String drugmainId = request.getParameter("id");
		Long id = null;
		if(drugmainId != null && !"".equals(drugmainId)){
			id = Long.parseLong(drugmainId);
		}else{
			id = Long.valueOf(0);
		}
		String page = DisplayGetPage.getPageParamName("records", request);
		String hql = "select d from DrugMaintenanceRecords d where 1=1 and drugMaintenanceId = :drugMainId";
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("drugMainId", id);
		if(page == null || "".equals(page) || "null".equalsIgnoreCase(page)){
			list = drugMaintenanceRecordsManager.getListByPage(hql, paraMap, 0, Constants.pagesize);
		}else{
			list = drugMaintenanceRecordsManager.getListByPage(hql, paraMap, (Integer.parseInt(page)-1)*Constants.pagesize, Constants.pagesize);
		}
		
		int resultSize = drugMaintenanceRecordsManager.getRecordCount("select count(*) from t_drugMaintenance_records where 1=1 and drugMaintenance_id = "+id);
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordList", list);
		return "qualityRecords/drugMaintenance/drugMaintenanceRecords";
	}

}
