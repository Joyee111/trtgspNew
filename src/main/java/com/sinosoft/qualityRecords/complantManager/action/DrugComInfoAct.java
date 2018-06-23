package com.sinosoft.qualityRecords.complantManager.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.qualityRecords.complantManager.model.DrugComInfo;
import com.sinosoft.qualityRecords.complantManager.model.DrugComInfoItem;
import com.sinosoft.qualityRecords.complantManager.service.DrugComInfoManger;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;
@Controller
public class DrugComInfoAct {
	private DrugComInfoManger drugComInfoManger;
	private QualityMidicineMng qualityMidicineMng;
	private InspectionMng inspectionMng;
	@Autowired
	public void setInspectionMng(InspectionMng inspectionMng) {
		this.inspectionMng = inspectionMng;
	}
	@Autowired
	public void setQualityMidicineMng(QualityMidicineMng qualityMidicineMng) {
		this.qualityMidicineMng = qualityMidicineMng;
	}


	@Autowired
	public void setDrugComInfoManger(DrugComInfoManger drugComInfoManger) {
		this.drugComInfoManger = drugComInfoManger;
	}
	@Autowired
	private SystemLogService logService;
	
	@RequestMapping("/qualityRecords/complantManger/list.html")
public ModelAndView openFramePage(DrugComInfoItem dr, HttpServletRequest request, HttpServletResponse response, Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<DrugComInfoItem> reslist=new ArrayList<DrugComInfoItem>();
		User localuser = (User) request.getSession().getAttribute(
				Constants.LOCAL_USER);
		String 	userId=localuser.getId().toString();//当前用户的id
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			
			reslist= drugComInfoManger.getPage(dr,null,0,Constants.pagesize);
			
		}
		else{
			//否者翻页查询
			reslist= drugComInfoManger.getPage(dr,userId,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = drugComInfoManger.getTotalCount(userId);
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("dr", dr);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("qualityRecords/complantManger/list");
	}
	@RequestMapping("/qualityRecords/complantManger/query.html")
	public ModelAndView queryEnterpristInfoList( DrugComInfoItem dr,Model model,HttpServletRequest request,HttpServletResponse response){

		List<DrugComInfoItem> reslist=new ArrayList<DrugComInfoItem>();
		String tousu= request.getParameter("tousu");
		String pinming= request.getParameter("pinming");
		String page = DisplayGetPage.getPageParamName("records", request);
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		model.addAttribute("tousu", tousu);
		model.addAttribute("pinming", pinming);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);

		User localuser = (User) request.getSession().getAttribute(
				Constants.LOCAL_USER);
		String 	userId=localuser.getId().toString();//当前用户的id
		
			if(tousu.equals("")&&pinming.equals("") && startDate.equals("") && endDate.equals(endDate) ){
				//否者翻页查询
				reslist= drugComInfoManger.getPage(dr,userId,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
				int resultSize = drugComInfoManger.getTotalCount(userId);
				 double size = resultSize;
					model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
					model.addAttribute("resultSize", resultSize);
					model.addAttribute("reslist", reslist);
			}else{
				StringBuffer sqlBuffer = new StringBuffer("select f from DrugComInfo  d , DrugComInfoItem f where   d.id=f.drugComInfoId and f.zhipaiId="+userId );
			
			
				if(tousu!=null && !tousu.equals("")){
					sqlBuffer.append(" and d.complainant like '%");
					sqlBuffer.append(tousu+"%'  ");
				}
				if(pinming!=null && !pinming.equals("")){
					sqlBuffer.append(" and d.quaMedicId like '%");
					sqlBuffer.append(pinming+"%'  ");
				}
				if(startDate != null && !"".equals(startDate)){
					sqlBuffer.append(" and convert(varchar(50),d.modifiedtime,20) >= '"+startDate+" 00:00:00'");
				}
				if(endDate != null && !"".equals(endDate)){
					sqlBuffer.append(" and convert(varchar(50),d.modifiedtime,20) <= '"+startDate+" 23:59:59'");
				}
					
				reslist = drugComInfoManger.getDrugComInfoByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
				
				StringBuffer buffer=new StringBuffer(" SELECT  count(*) from DrugComInfo  d , DrugComInfoItem f where   d.id=f.drugComInfoId and f.zhipaiId="+userId );
			
				
				
				if(tousu!=null && !tousu.equals("")){
					buffer.append(" and  d.complainant like '%");
					buffer.append(tousu+"%'  ");
				}
				if(pinming!=null && !pinming.equals("")){
					buffer.append(" and d.quaMedicId like '%");
					buffer.append(pinming+"%'  ");
				}
				if(startDate != null && !"".equals(startDate)){
					buffer.append(" and convert(varchar(50),d.modifiedtime,20) >= '"+startDate+" 00:00:00'");
				}
				if(endDate != null && !"".equals(endDate)){
					buffer.append(" and convert(varchar(50),d.modifiedtime,20) <= '"+startDate+" 23:59:59'");
				}
				int resultSize = drugComInfoManger.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
				
			}	
		//页数
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("dr", dr);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("qualityRecords/complantManger/list");
	}

	
	@RequestMapping("/qualityRecords/complantManger/add.html")
	public ModelAndView add(DrugComInfo dr,String id, HttpServletRequest request, HttpServletResponse response, Model model){
		String method = request.getParameter("method");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		DrugComInfo drugComInfo=new DrugComInfo();	
		Long medicinalNo=null;
		String titles="投诉管理新增";
		if(!method.equals("add")){	
			 titles="投诉管理修改";
			drugComInfo=drugComInfoManger.findById(id);		
			if(drugComInfo.getQualityMidicine()!=null){
				if(drugComInfo.getQualityMidicine().getMedicinalNo()!=null){
					medicinalNo=drugComInfo.getQualityMidicine().getId();
				}
			}	
			model.addAttribute("dr", drugComInfo);
			List<?> receItem= drugComInfoManger.findZhiPaiId(drugComInfo.getId());
			String pinming="";
			  if(receItem!=null){
				   if(receItem.size()>0){
					   for (int i = 0; i < receItem.size(); i++) {
						   if(i==receItem.size()-1){
							   pinming+=receItem.get(i).toString().trim();
							   
						   }else{
							   pinming+=receItem.get(i).toString().trim()+",";
						   }
					   }
				   }
			   }
			  model.addAttribute("pinming", pinming);
		}
		
		Map<String, String> qsmap=drugComInfoManger.jsMap();
		model.addAttribute("qsmap", qsmap);	
		model.addAttribute("titles", titles);
		model.addAttribute("medicinalNo", medicinalNo);
		Map<String, String> quamap= drugComInfoManger.qmMap();
		model.addAttribute("quamap", quamap);
		model.addAttribute("dr",drugComInfo );
		model.addAttribute("method", method);	
			return new ModelAndView("qualityRecords/complantManger/add");
		}
	@RequestMapping("/qualityRecords/complantManger/saveOrUpdata.html")
	public ModelAndView saveOrUpdate(DrugComInfo dr,String counts, String pinming,String id, HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException{
		String op = request.getParameter("method");
		String tousufangshi = request.getParameter("tousufangshi");//投诉方式
		String tousufangshi_type=null;
		if(tousufangshi!=null && !tousufangshi.trim().equals("")){
			tousufangshi_type= tousufangshi;
		}
		if(tousufangshi_type!=null){
			dr.setTousufangshi(tousufangshi_type);
		}
		//String quaMedicId = request.getParameter("quaMedicId");

		String jixing = request.getParameter("dosageforms");
		String guige = request.getParameter("specifications");
		String pihao = request.getParameter("licensenumber");
		//QualityMidicine qualityMidicine=new QualityMidicine();
      //判断药品名在添加时是手动输入的还是在下拉框里选择的（手动输入的药品名是中文，下拉框选择的药品是药品的Id）
	//	if(quaMedicId!=null && !quaMedicId.equals("")){
	//	Pattern pattern = Pattern.compile("[0-9]*");
	//	Matcher isNum = pattern.matcher(quaMedicId);
		//如果是手动输入的即药品的id 是中文
	//	if( !isNum.matches() ){
			dr.setJixing(jixing);
			dr.setGuige(guige);
			dr.setPihao(pihao);
		//}else{
			//在下拉框选择的药品即药品的Id
		//	  qualityMidicine = qualityMidicineMng.findById(quaMedicId);
		//		dr.setQualityMidicine(qualityMidicine);
		//		dr.setQuaMedicId("("+qualityMidicine.getMedicinalNo()+")"+qualityMidicine.getCommonname());
		//		dr.setJixing(jixing);
		//		dr.setGuige(guige);
		//		dr.setPihao(pihao);
		 //  }
		
	//	}
	
		if(!op.equals("add")){
			
			Date  date=new Date();
			dr.setUpdateMdifiedtime(date);
			
			
			User updateLocaluser = (User) request.getSession().getAttribute(
					Constants.LOCAL_USER);
			long 	b=updateLocaluser.getId();
			
			dr.setUpdateModifierid(b);
			dr.setRoleId(pinming);
			drugComInfoManger.saveOrUpdata(dr);
			//先删除后保存
			List<?> receItem= drugComInfoManger.findAllId(dr.getId());

			drugComInfoManger.del(receItem);

			if(!"".equals(counts) && null!=counts){
				//指派人不为空
				if(pinming!=null && !"".equals(pinming)){
				String[] s= pinming.split(",");
		    	for (int j = 0; j < s.length; j++) {
		    		DrugComInfoItem drugComInfoItem=new DrugComInfoItem();
		    		drugComInfoItem.setZhipaiId((s[j]));	
		    		drugComInfoItem.setDrugComInfoId(dr.getId());
		    		drugComInfoManger.save(drugComInfoItem);
		    	}	
			}}
	
		}else{
			Date  d=new Date();
			dr.setModifiedtime(d);		
			User localuser = (User) request.getSession().getAttribute(
					Constants.LOCAL_USER);
			long a=localuser.getId();
			
			dr.setModifierid(a);
			dr.setRoleId(pinming);

			drugComInfoManger.saveDrugComInfo(dr);
			
			if(pinming!=null && !"".equals(pinming)){
				String[] b = pinming.split(",");
		    	for (int j = 0; j < b.length; j++) {
		    		DrugComInfoItem drugComInfoItem=new DrugComInfoItem();
		    		drugComInfoItem.setZhipaiId((b[j]));	
		    		drugComInfoItem.setDrugComInfoId(dr.getId());
		    		drugComInfoManger.save(drugComInfoItem);
		    	}	
			}
		
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("新增投诉记录", user.getRealname(), "新增", "质量记录管理  >投诉管理", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	
	@RequestMapping("/qualityRecords/complantManger/del.html")
	public ModelAndView del(String ids[], HttpServletRequest request, HttpServletResponse response, Model model){	
		if(ids!=null&&!"".equals("ids")){
			for(int i= 0;i<ids.length;i++){
				DrugComInfo drugComInfo=new DrugComInfo();	
				drugComInfo=drugComInfoManger.findById(ids[i]);		
				drugComInfoManger.delss(ids[i]);
				//根据投诉的id 找到所有的指派	
				List<?> receItem= drugComInfoManger.findAllId(drugComInfo.getId());
				if(receItem!=null && receItem.size()>0){
					drugComInfoManger.del(receItem);
					
				}
				
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除投诉记录", user.getRealname(), "删除", "质量记录管理  >投诉管理", StringUtil.getIpAddr(request));
		return openFramePage(null, request, response, model);
	}
	@RequestMapping("/qualityRecords/complantManger/findypboxqy.html")
	public void findypbox(HttpServletRequest request, HttpServletResponse response, Model model){
		List<QualityMidicine> listpu= new ArrayList<QualityMidicine>();
		//封装药品json 
		listpu=inspectionMng.findypJsonqy();
		String json = "[";
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				if(listpu.get(i).getCommonname()!=null && !"".equals(listpu.get(i).getCommonname())){
					json+="{";
					json+="\"id\":"+listpu.get(i).getId()+",";
					json+="\"text\":\""+"("+listpu.get(i).getMedicinalNo()+")"+listpu.get(i).getCommonname()+"\"";
					if(i==listpu.size()-1){
						json+="}";
					}else{
						json+="},";
					}
				}
			}
		}
		json+="]";
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
