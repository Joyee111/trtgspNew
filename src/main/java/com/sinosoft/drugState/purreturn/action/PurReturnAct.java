package com.sinosoft.drugState.purreturn.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.sinosoft.drugState.mackNo.service.MakeNoMng;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBillRecords;
import com.sinosoft.drugState.purreturn.service.PurReturnMng;
import com.sinosoft.drugState.purreturn.service.PurchaseReturnBillRecordsDaoManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.systemConfig.MakingNo;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualifiedmedcstoreMng;

@Controller
public class PurReturnAct {
	@Autowired
	private PurReturnMng purReturnMng;
	@Autowired
	private InspectionMng inspectionMng;
	@Autowired
	private SystemLogService logService;
	@Autowired
	private PurchaseReturnBillRecordsDaoManager recordsDaoManager;
	@Autowired
	private QualifiedmedcstoreMng qualifiedmedcstoreMng;
	@Autowired
	private MakeNoMng makeNoMng;
	@RequestMapping("/drugState/purreturn/dlrlist.html")
	public ModelAndView openFramePage(HttpServletRequest request, HttpServletResponse response, Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		String yhDate = request.getParameter("yhdate");
		String ypname = request.getParameter("ypname");
 		String department = request.getParameter("department");
		String returnTime = request.getParameter("returnTime");
		String batchNumber = request.getParameter("batchNumber");
		model.addAttribute("returnTime", returnTime);
		model.addAttribute("batchNumber", batchNumber);
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		model.addAttribute("department", department);
		PurchaseReturnBill mc = new PurchaseReturnBill();
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setNumber(yhDate);
		}
		if(department != null && !"".equals(department)){
			mc.setDepartment(department);
		}
		if(returnTime != null && !"".equals(returnTime)){
			mc.setReturnTime(returnTime);
		}
		if(batchNumber != null && !"".equals(batchNumber)){
			mc.setBatchNumber(batchNumber);
		}
		
		List<PurchaseReturnBill> reslist=new ArrayList<PurchaseReturnBill>();
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			reslist= purReturnMng.getPage(mc,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			reslist= purReturnMng.getPage(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = purReturnMng.getTotalCount(mc);
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("drugState/purreturn/dlrlist");
	}
	@RequestMapping("/drugState/purreturn/dlradd.html")
	public ModelAndView dlradd(PurchaseReturnBill mc,HttpServletRequest request, HttpServletResponse response, Model model){
		//添加编号
		String nonumber = makeNoMng.findNo(Constants.PURRETURN);
		if(nonumber!=null && !"".equals(nonumber) ){
			try {
				Long  n = Long.parseLong(nonumber)+1L;
				mc.setNumber("T" + n.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			nonumber = "T160000001";
			mc.setNumber(nonumber);
		}
		model.addAttribute("mc", mc);
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> qsmap= inspectionMng.gonghuoMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("drugState/purreturn/dlradd");
		
	}
	//获取票据类型，并动态加载票号
	@RequestMapping("/drugState/purreturn/getNumberJson.html")
	public void getNumber(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception{ 
		Map<String,Object> queryParams=new HashMap<String,Object>();
		queryParams.put("sample",Constants.SAMPLE );
		queryParams.put("rework",Constants.REWORK);
		List<MakingNo> list=null;
		MakingNo mns=null;
		MakingNo mnr=null;
		try{
			list=makeNoMng.getBillType(queryParams);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(list==null || list.size()<1){
			mns=createNo(Constants.SAMPLE);
			mnr=createNo(Constants.REWORK);
			mns=makeNoMng.save(mns);
			mnr=makeNoMng.save(mnr);
		}
		if(list!=null && list.size()==1){
			if(list.get(0).getName().trim().equals("提样")){
				mns=list.get(0);
				mnr=createNo(Constants.REWORK);
				mnr=makeNoMng.save(mnr);
			}
			
			if(list.get(0).getName().trim().equals("返工")){
				mnr=list.get(0);
				mns=createNo(Constants.SAMPLE);
				mns=makeNoMng.save(mns);
			}
		}
		if(list.size()==2){
			if(list.get(0).getName().trim().equals("提样")){
					mns=list.get(0);
					mnr=list.get(1);
			}
			if(list.get(0).getName().trim().equals("返工")){
					mnr=list.get(0);
					mns=list.get(1);
			}
		}
		
		mns=updateNo(mns);
		makeNoMng.update(mns);
		mnr=updateNo(mnr);
		makeNoMng.update(mnr);
		
		String json = "[";
		int index=0;
		if(list!=null && list.size()>0){
			for(MakingNo mn : list){
					index++;
					json+="{";
					json+="\"id\":\""+mn.getId()+"_"+mn.getNo()+"\",";
					json+="\"text\":\""+mn.getName()+"\"";
					if(index==list.size()){
						json+="}";
					}else{
						json+="},";
					}
				}
		}
		json+="]";
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * 票据类型更新 no
	 */
	public MakingNo updateNo(MakingNo mn){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String no=mn.getNo();
		String num="";
		String t=null;
		if(mn.getName().trim().equals("提样")){
			String str=no.substring(2,6)+"-"+no.substring(6,8)+"-"+no.substring(8,10);
			if(!sdf.format(date).equals(str)){
//				num=Integer.valueOf(no.substring(10, no.length()))+1+"";
//				if(num.trim().length()<2){
//					t="0"+num;
//				}else{
//					t=num.trim();
//				}
//				mn.setNo(no.substring(0,10)+t);
				mn.setNo(createNo(mn.getName()).getNo());
			}
				
			
			
		}
        if(mn.getName().trim().equals("返工")){
        	int jidu=0;
        	String str=no.substring(5,6);
        	String month=sdf.format(date).split("-")[1];
		    if(Integer.valueOf(month)>=1 && Integer.valueOf(month)<=3 ){
		    	jidu=1;
		    }
		    if(Integer.valueOf(month)>3 && Integer.valueOf(month)<=6 ){
		    	jidu=2;
		    }
		    if(Integer.valueOf(month)>6 && Integer.valueOf(month)<=9 ){
		    	jidu=3;
		    }
		    if(Integer.valueOf(month)>9 && Integer.valueOf(month)<=12 ){
		    	jidu=4;
		    }
		    if(Integer.valueOf(str.trim())!=jidu){
//		    	num=Integer.valueOf(no.substring(6, no.length()))+1+"";
//		    	if(num.trim().length()==1){
//					t="000"+num;
//				}else if(num.trim().length()==2){
//					
//					t="00"+num;
//					t=num+"".trim();
//				}else if(num.trim().length()==3){
//					t="0"+num;
//				}else{
//					t=num.trim();
//				}
//		    	mn.setNo(no.substring(0,6)+t);
		    	mn.setNo(createNo(mn.getName()).getNo());
		    }
		    	
		    
        }

		return mn;
	}
	
	
	/**
	 * 生成票据类型     提样：YP2017052301
	 *          返工：D201720076
	 */
	public MakingNo createNo(String str){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String strDate=sdf.format(date);
		String[] array=strDate.split("-");
		MakingNo mn=new MakingNo();
		String no="";
		if(str.trim().equals("提样")){
			no="YP"+array[0]+array[1]+array[2]+"01";
			mn.setName("提样");
			mn.setNo(no);
			
		}
        if(str.trim().equals("返工")){
			if(Integer.parseInt(array[1])>=1 && Integer.parseInt(array[1])<=3){
				 no="D"+array[0]+"1"+"0001";
			}
			if(Integer.parseInt(array[1])>3 && Integer.parseInt(array[1])<=6){
				 no="D"+array[0]+"2"+"0001";
			}
			if(Integer.parseInt(array[1])>6 && Integer.parseInt(array[1])<=9){
				 no="D"+array[0]+"3"+"0001";
			}
			if(Integer.parseInt(array[1])>9 && Integer.parseInt(array[1])<=12){
				 no="D"+array[0]+"4"+"0001";
			}
			mn.setName("返工");
			mn.setNo(no);
			
		}
		return mn;
	}
	@RequestMapping("/drugState/purreturn/dlrsave.html")
	public ModelAndView dlrsave(PurchaseReturnBill st,HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException, SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		response.setCharacterEncoding("utf-8");
		int checkNumber = purReturnMng.getCount(st);
		if(checkNumber>0) {
			map.put("msg",URLEncoder.encode("票号重复", "UTF-8"));
			UtilJson.printMapJson(response, map);
			return null;
		}
		String type = request.getParameter("submitType");
		String billTypeId=request.getParameter("billTypeId");
		st.setReviewStatus(Long.parseLong(type));
		Date date = new Date();
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		String modifyDate = modifyDateFormat.format(date);
 		st.setApplicationTime(modifyDate);
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		st.setProposerID(user.getId());
		st.setUser(user);
		if(st.getQualifiedSupplierId()!=null){
			try {
				st.setQualifiedSuppliers(inspectionMng.findGYSById(st.getQualifiedSupplierId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(st.getQualifiedMedicineId()!=null){
			try {
				st.setQualityMidicine(inspectionMng.findHGYP(st.getQualifiedMedicineId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		st.setManualFlag("1");//手动录入的设置标志位为1
		//票号+1
		//makeNoMng.makeNo(Constants.PURRETURN);
		//票号+1
		MakingNo mn=makeNoMng.findMNById(Long.valueOf(billTypeId.trim()));
		String num="";
		String t="";
		if(mn.getName().trim().equals("提样")){
			 num=Integer.valueOf(mn.getNo().substring(10, mn.getNo().length()))+1+"";
			if(num.trim().length()<2){
				t="0"+num;
			}else{
				t=num.trim();
			}
			mn.setNo(mn.getNo().substring(0,10)+t);
			
		}
		if(mn.getName().trim().equals("返工")){
		  	num=Integer.valueOf(mn.getNo().substring(6, mn.getNo().length()))+1+"";
	    	if(num.trim().length()==1){
				t="000"+num;
			}else if(num.trim().length()==2){
				
				t="00"+num;
				
			}else if(num.trim().length()==3){
				t="0"+num;
			}else{
				t=num;
			}
	    	mn.setNo(mn.getNo().substring(0,6)+t);
			
		}
		
		makeNoMng.update(mn);
		PurchaseReturnBill bill=purReturnMng.save(st);
		logService.addLog("新增购进退出记录", user.getRealname(), "新增", "药品状态管理  >购进退出管理", StringUtil.getIpAddr(request));
		map.put("msg",URLEncoder.encode("数据保存成功！", "UTF-8"));
		map.put("success",URLEncoder.encode("success", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/purreturn/dlredit.html")
	public ModelAndView dshedit(PurchaseReturnBill mc,String id, HttpServletRequest request, HttpServletResponse response,Model model){
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> qsmap= inspectionMng.gonghuoMap();
		model.addAttribute("qsmap", qsmap);
		PurchaseReturnBill mcs=purReturnMng.findById(id);
		 Qualifiedmedcstore store = qualifiedmedcstoreMng.findByBaNo(mcs.getBatchNumber().trim());
		 if(store != null){
			 model.addAttribute("maxQuantity", store.getQuantity());
		 }
		
		model.addAttribute("mc", mcs); 
		QualityMidicine qm = inspectionMng.findHGYP(mcs.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		/**
		 * 合格药品供应商
		 * */
		QualifiedSuppliers qs = purReturnMng.findghById(mcs.getQualifiedSupplierId());
		model.addAttribute("qs", qs);
		model.addAttribute("gouhuoshang", mcs.getQualifiedSuppliers().getPinyinCode()+"_"+mcs.getQualifiedSuppliers().getId());
		return new ModelAndView("drugState/purreturn/dlredit");
	}
	
	@RequestMapping("/drugState/purreturn/dlrupdate.html")
	public ModelAndView dshupdate(PurchaseReturnBill mc,String counts,String submitType, HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String thispage=request.getParameter("thispage");
		String type = request.getParameter("submitType");
		String modify_reason = request.getParameter("modify_reason");
		if("1".equals(submitType)){
			mc.setReviewStatus(1L);
		}else{
			mc.setReviewStatus(0L);
		}
		Date date = new Date();
		SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		String modifyDate = modifyDateFormat.format(date);
 		mc.setApplicationTime(modifyDate);
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		mc.setProposerID(user.getId());
		mc.setUser(user);
		if(mc.getQualifiedSupplierId()!=null){
			try {
				mc.setQualifiedSuppliers(inspectionMng.findGYSById(mc.getQualifiedSupplierId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(mc.getQualifiedMedicineId()!=null){
			try {
				mc.setQualityMidicine(inspectionMng.findHGYP(mc.getQualifiedMedicineId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		PurchaseReturnBill bill = purReturnMng.findById(mc.getId().toString());
		if(mc != null && bill!=null){
			if(mc.getQualifiedSuppliers() != null && bill.getQualifiedSuppliers()!= null  && mc.getQualifiedSuppliers().getId() != bill.getQualifiedSuppliers().getId()){
				recordsDaoManager.addPurchaseReturnBillRecords(bill.getId(), "修改供货单位", "修改供货单位修改之前供货单位称为"+bill.getQualifiedSuppliers().getCustomerName()+"修改之后供货单位为"+mc.getQualifiedSuppliers().getCustomerName(), user, modify_reason);
			}
			if(mc.getQualityMidicine() != null && bill.getQualityMidicine()!=null && mc.getQualityMidicine().getId()!= bill.getQualityMidicine().getId()){
				recordsDaoManager.addPurchaseReturnBillRecords(bill.getId(), "修改药品通用名称", "修改药品通用名称修改之前药品通用名称称为"+bill.getQualityMidicine().getCommonname()+"修改之后药品通用名称为"+mc.getQualityMidicine().getCommonname(), user, modify_reason);
			}
			if(!mc.getBatchNumber().equals(bill.getBatchNumber())){
				recordsDaoManager.addPurchaseReturnBillRecords(bill.getId(), "修改药品生产批号", "修改药品生产批号修改之前药品生产批号为"+bill.getBatchNumber()+"修改之后药品生产批号为"+mc.getBatchNumber(), user, modify_reason);
			}
			
			if(Math.abs(mc.getQuantity()) != Math.abs(bill.getQuantity())){
				recordsDaoManager.addPurchaseReturnBillRecords(bill.getId(), "修改药品数量", "修改药品数量修改之前药品数量为"+bill.getQuantity()+"修改之后药品数量为"+mc.getQuantity(), user, modify_reason);
			}
			if(!mc.getPuMoney().equals(bill.getPuMoney())){
				recordsDaoManager.addPurchaseReturnBillRecords(bill.getId(), "修改药品购进价格", "修改药品购进价格修改之前药品购进价格为"+bill.getPuMoney()+"修改之后药品购进价格为"+mc.getPuMoney(), user, modify_reason);
			}
			if(!mc.getMoney().equals(bill.getMoney())){
				recordsDaoManager.addPurchaseReturnBillRecords(bill.getId(), "修改药品退出金额", "修改药品退出金额修改之前药品退出金额为"+bill.getMoney()+"修改之后药品退出金额为"+mc.getMoney(), user, modify_reason);
			}
			if(!mc.getEndTime().equals(bill.getEndTime())){
				recordsDaoManager.addPurchaseReturnBillRecords(bill.getId(), "修改药品有效期至", "修改药品有效期至修改之前药品有效期至为"+bill.getEndTime()+"修改之后药品有效期至为"+mc.getEndTime(), user, modify_reason);
			}
			if(!mc.getReturnReason().equals(bill.getReturnReason())){
				recordsDaoManager.addPurchaseReturnBillRecords(bill.getId(), "修改药品退货原因", "修改药品退货原因修改之前药品退货原因为"+bill.getReturnReason()+"修改之后药品退货原因为"+mc.getReturnReason(), user, modify_reason);
			}
		}
		purReturnMng.update(mc);
		logService.addLog("修改购进退出记录", user.getRealname(), "修改", "药品状态管理  >购进退出管理", StringUtil.getIpAddr(request));
		model.addAttribute("thispage", thispage);
		model.addAttribute("mc", mc);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success",URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugState/purreturn/dlrdel.html")
	public ModelAndView deldlr(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		if(ids!=null && !"".equals(ids)){
			for(int i= 0;i<ids.length;i++){
				purReturnMng.del(ids[i]);
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除购进退出记录", user.getRealname(), "删除", "药品状态管理  >购进退出管理", StringUtil.getIpAddr(request));
		return openFramePage(request, response, model);
	}
	/**
	 * 待审核
	 * **/
	@RequestMapping("/drugState/purreturn/dshlist.html")
	public ModelAndView dshPage(PurchaseReturnBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<PurchaseReturnBill> list = new ArrayList<PurchaseReturnBill>();
		String yhDate = request.getParameter("yhdate");
		String ypname = request.getParameter("ypname");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setNumber(yhDate);
		}
		if(mc==null){
			mc = new PurchaseReturnBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= purReturnMng.getPagedsh(mc,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= purReturnMng.getPagedsh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = purReturnMng.getTotalCountDsh(mc);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/purreturn/dshlist");
	}
	
	@RequestMapping("/drugState/purreturn/dshview.html")
	public ModelAndView dshview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		PurchaseReturnBill ch =purReturnMng.findById(id);
		QualityMidicine  qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		model.addAttribute("mc", ch);
		/**
		 * 合格药品供应商
		 * */
		QualifiedSuppliers qs = purReturnMng.findghById(ch.getQualifiedSupplierId());
		model.addAttribute("qs", qs);
		return new ModelAndView("drugState/purreturn/dshview");
	}	
	@RequestMapping("/drugState/purreturn/audit.html")
	public ModelAndView audit(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		String batch_type=request.getParameter("batch_type");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		if(ids!=null && !"".equals(ids)){
			if("0".equals(batch_type)){
				for(int i =0;i<ids.length;i++){
					PurchaseReturnBill ch =purReturnMng.findById(ids[i]);
					ch.setReviewStatus(2L);
					Date date = new Date();
					SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 		String modifyDate = modifyDateFormat.format(date);
			 		ch.setReviewTime(modifyDate);
					User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
					ch.setAuditorID(user.getId());
					purReturnMng.update(ch);
				}
			}else if("1".equals(batch_type)){
				for(int i =0;i<ids.length;i++){
					PurchaseReturnBill ch =purReturnMng.findById(ids[i]);
					ch.setReviewStatus(3L);
					Date date = new Date();
					SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 		String modifyDate = modifyDateFormat.format(date);
			 		ch.setReviewTime(modifyDate);
					User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
					ch.setAuditorID(user.getId());
					purReturnMng.update(ch);
				}
		}
		}
		return dshPage(null, request, response, model);
	}
	@RequestMapping("/drugState/purreturn/shviewcheck.html")
	public ModelAndView auditOne(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		String type=request.getParameter("types");
		if(id!=null){
			PurchaseReturnBill ch =purReturnMng.findById(id);
			ch.setReviewStatus(Long.parseLong(type));
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			purReturnMng.update(ch);
		}
		return dshPage(null, request, response, model);
	}
	/**
	 * 
	 * 已审核
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/purreturn/yshlist.html")
	public ModelAndView yshPage(PurchaseReturnBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<PurchaseReturnBill> list = new ArrayList<PurchaseReturnBill>();
		String yhDate = request.getParameter("yhdate");
		String ypname = request.getParameter("ypname");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setNumber(yhDate);
		}
		if(mc==null){
			mc = new PurchaseReturnBill();
		}
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= purReturnMng.getPageysh(mc,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= purReturnMng.getPageysh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = purReturnMng.getTotalCountysh(mc);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/purreturn/yshlist");
	}
	@RequestMapping("/drugState/purreturn/yshview.html")
	public ModelAndView yshviewlist(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		PurchaseReturnBill ch =purReturnMng.findById(id);
		QualityMidicine  qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		model.addAttribute("mc", ch);
		QualifiedSuppliers qs = purReturnMng.findghById(ch.getQualifiedSupplierId());
		model.addAttribute("qs", qs);
		return new ModelAndView("drugState/purreturn/yshview");
	}	
	@RequestMapping("/drugState/purreturn/backcheck.html")
	public ModelAndView yshcheck(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		if(id!=null){
			PurchaseReturnBill ch =purReturnMng.findById(id);
			ch.setReviewStatus(3L);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			purReturnMng.update(ch);
		}
		return yshPage(null, request, response, model);
	}
	/**
	 * 
	 * 已驳回
	 * 
	 * 
	 * **/
	@RequestMapping("/drugState/purreturn/ybhlist.html")
	public ModelAndView ybhPage(PurchaseReturnBill mc, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<PurchaseReturnBill> list = new ArrayList<PurchaseReturnBill>();
		String yhDate = request.getParameter("yhdate");
		String ypname = request.getParameter("ypname");
		model.addAttribute("yhDate", yhDate);
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		if(yhDate !=null && !"".equals(yhDate)){
			mc.setNumber(yhDate);
		}
		if(mc==null){
			mc = new PurchaseReturnBill();
		}
		String pageNo = request.getParameter("thispage");
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= purReturnMng.getPageybh(mc,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= purReturnMng.getPageybh(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = purReturnMng.getTotalCountybh(mc);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("mc", mc);
		return new ModelAndView("drugState/purreturn/ybhlist");
	}
	@RequestMapping("/drugState/purreturn/ybhview.html")
	public ModelAndView ybhview(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		PurchaseReturnBill ch =purReturnMng.findById(id);
		QualityMidicine  qm = inspectionMng.findHGYP(ch.getQualifiedMedicineId());
		model.addAttribute("qm", qm);
		model.addAttribute("mc", ch);
		QualifiedSuppliers qs = purReturnMng.findghById(ch.getQualifiedSupplierId());
		model.addAttribute("qs", qs);
		return new ModelAndView("drugState/purreturn/ybhview");
	}
	@RequestMapping("/drugState/purreturn/bhback.html")
	public ModelAndView ybhaudit(String id, HttpServletRequest request, HttpServletResponse response,Model model){
		if(id!=null){
			PurchaseReturnBill ch =purReturnMng.findById(id);
			ch.setReviewStatus(0L);
			Date date = new Date();
			SimpleDateFormat modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 		String modifyDate = modifyDateFormat.format(date);
	 		ch.setReviewTime(modifyDate);
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			ch.setAuditorID(user.getId());
			purReturnMng.update(ch);
		}
		return ybhPage(null, request, response, model);
	}
	@RequestMapping("/drugState/purreturn/ajaxChangePrintFlag.html")
	public String ajaxChangePrintFlag(Model model, HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("returnBillId");
		PurchaseReturnBill returnBill =  purReturnMng.findById(id);
		if(returnBill!=null){
			returnBill.setPrintFlag("1");
			purReturnMng.update(returnBill);
		}
		return null;
	}
	@RequestMapping("/drugState/purreturn/findPurchaseRetuenBillRecords.html")
	public String findPurchaseRetuenBillRecords(Model model, HttpServletRequest request, HttpServletResponse response){
		String  purchaseOrderId = request.getParameter("id");
		Long id = null;
		if(purchaseOrderId != null && !"".equals(purchaseOrderId)){
			id = Long.parseLong(purchaseOrderId);
		}else{
			id = Long.valueOf(0);
		}
		String hql = "select t from PurchaseReturnBillRecords t where t.purchaseReturnBillId = :purchaseOrderId"; 
		String page = DisplayGetPage.getPageParamName("record", request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchaseOrderId", id);
		List<PurchaseReturnBillRecords> recordList = null;
		if(page == null || "".equals(page) || "null".equalsIgnoreCase(page)){
			recordList = recordsDaoManager.getListByPage(hql,map , 0, Constants.pagesize);
		}else{
			recordList = recordsDaoManager.getListByPage(hql,map , (Integer.parseInt(page)-1)*Constants.pagesize, Constants.pagesize);
		}
		int resultSize = recordsDaoManager.getRecordCount("select count(*) from t_purchase_return_bill_tecords where purchase_return_bill_id = "+id);
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordList", recordList);
		return "drugState/purreturn/purchaseReturnBillRecords";
	}
}
