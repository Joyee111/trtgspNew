package com.sinosoft.comQuery.drugComInfoRecords.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.sinosoft.comQuery.drugComInfoRecords.service.DrugComInfoRecordsMng;
import com.sinosoft.qualityRecords.complantManager.model.DrugComInfo;
import com.sinosoft.qualityRecords.complantManager.service.DrugComInfoManger;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;

@Controller
public class DrugComInfoRecordsAct {
	@Autowired
	private DrugComInfoRecordsMng drugComInfoRecordsMng;
	@Autowired
	private  DrugComInfoManger drugComInfoManger;
	public void setDrugComInfoManger(DrugComInfoManger drugComInfoManger) {
		this.drugComInfoManger = drugComInfoManger;
	}

	public void setDrugComInfoRecordsMng(
			DrugComInfoRecordsMng drugComInfoRecordsMng) {
		this.drugComInfoRecordsMng = drugComInfoRecordsMng;
	}
	private QualityMidicineMng qualityMidicineMng;
	@Autowired
	public void setQualityMidicineMng(QualityMidicineMng qualityMidicineMng) {
		this.qualityMidicineMng = qualityMidicineMng;
	}
	@RequestMapping("/comQuery/drugComInfoRecords/list.html")
	public ModelAndView openFramePage(String firstJoin,DrugComInfo dr,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		String page = DisplayGetPage.getPageParamName("records", request);// 
		List<DrugComInfo> reslist = new ArrayList<DrugComInfo>();
		User localuser = (User) request.getSession().getAttribute(
				Constants.LOCAL_USER);
		String 	userId=localuser.getId().toString();//当前用户的id
	
		String wcqkValue ="";
		if("1".equals(firstJoin)){
			wcqkValue="0,1";
		}
		model.addAttribute("wcqk", wcqkValue);
		if (page == null) {

			
			reslist=drugComInfoRecordsMng.getPage(dr, null, 0, Constants.pagesize);

		} else {
			reslist=drugComInfoRecordsMng.getPage(dr, userId, (Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		int resultSize = drugComInfoRecordsMng.getTotalCount();
		double size = resultSize;

		model.addAttribute("displayallpage", Math.ceil(size
				/ Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("dr", dr);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("comQuery/drugComInfoRecords/list");
	}
	
	
	@RequestMapping("/comQuery/drugComInfoRecords/view.html")
	public ModelAndView add(DrugComInfo dr,String id, HttpServletRequest request, HttpServletResponse response, Model model){
		String method = request.getParameter("method");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		DrugComInfo drugComInfo=new DrugComInfo();	
		Long medicinalNo=null;
		String titles="投诉管理新增";
		if(!method.equals("add")){	
			 titles="投诉查看";
			 drugComInfo=drugComInfoRecordsMng.findById(id);		
				if(drugComInfo.getQualityMidicine()!=null){
					if(drugComInfo.getQualityMidicine().getMedicinalNo()!=null){
						medicinalNo=drugComInfo.getQualityMidicine().getId();
					}
				}
				
			
				model.addAttribute("dr", drugComInfo);
		}
		String tousufangshi=drugComInfo.getTousufangshi();
		
		if(tousufangshi.equals("0")){
			tousufangshi="电话";	
		}else if(tousufangshi.equals("1")){
			tousufangshi="传真";
		}else if(tousufangshi.equals("2")){
			tousufangshi="来函";
		}else{
			tousufangshi="上门";
		}
		drugComInfo.setTousufangshi(tousufangshi);
		model.addAttribute("titles", titles);
		model.addAttribute("medicinalNo", medicinalNo);


		model.addAttribute("method", method);	
	
			return new ModelAndView("comQuery/drugComInfoRecords/view");
		}
	@RequestMapping("/comQuery/drugComInfoRecords/query.html")
	public ModelAndView queryEnterpristInfoList( DrugComInfo dr,Model model,HttpServletRequest request,HttpServletResponse response){
		List<DrugComInfo> reslist=new ArrayList<DrugComInfo>();
		String tousu= request.getParameter("tousu");
		String mingcheng= request.getParameter("mingcheng");
		String tousuriqi= request.getParameter("tousuriqi");
		String zhi= request.getParameter("zhi");
		String page = DisplayGetPage.getPageParamName("records", request);
		model.addAttribute("tousu", tousu);
		model.addAttribute("mingcheng", mingcheng);
		model.addAttribute("tousuriqi", tousuriqi);
		model.addAttribute("zhi", zhi);
		String[] wcqk=request.getParameterValues("wcqk");
		String wcqkValue="";
	   if(wcqk!=null){
		   if(wcqk.length>0){
			   for (int i = 0; i < wcqk.length; i++) {
				   if(i==wcqk.length-1){
					   wcqkValue+=wcqk[i].toString().trim();
					   
				   }else{
					   wcqkValue+=wcqk[i].toString().trim()+",";
				   }
			   }
		   }
	   }
	   model.addAttribute("wcqk", wcqkValue);
		QualityMidicine qualityMidicine=new QualityMidicine();
		   if(mingcheng!=null && !mingcheng.equals("")){
				Pattern pattern = Pattern.compile("[0-9]*");
				Matcher isNum = pattern.matcher(mingcheng);
				if( !isNum.matches() ){
				mingcheng=mingcheng;
				}else{
					  qualityMidicine = qualityMidicineMng.findById(mingcheng);

					mingcheng="("+qualityMidicine.getMedicinalNo()+")"+qualityMidicine.getCommonname();
						
				   }
				
				}
		
			
			StringBuffer sqlBuffer = new StringBuffer("select d  from DrugComInfo  d  where 1=1 ");
			
			
			if(tousu!=null && !tousu.equals("")){
				sqlBuffer.append(" and d.complainant like '%");
				sqlBuffer.append(tousu+"%'  ");
			}
			if(mingcheng!=null && !mingcheng.equals("")){
				sqlBuffer.append(" and d.quaMedicId like '%");
				sqlBuffer.append(mingcheng+"%'  ");
			}
			
				
			
			if(tousuriqi!=null &&!tousuriqi.equals("")){
				sqlBuffer.append(" and d.modifiedtime>= '");
				sqlBuffer.append(tousuriqi+"'  ");
			}
			if(zhi!=null &&!zhi.equals("")){
				sqlBuffer.append(" and d.modifiedtime<= '");
				sqlBuffer.append(zhi+"'  ");
			}
			//完成
			if(wcqkValue!=null&&wcqkValue.equals("0")){
				sqlBuffer.append("and d.roleId like '%"+0+"%' ");		
			}
			//完成
			if(wcqkValue!=null&&wcqkValue.equals("1")){
				sqlBuffer.append("and d.roleId not like '%"+0+"%' ");		
			}
			reslist=drugComInfoRecordsMng.getDrugComInfoByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
				
			
			StringBuffer buffer=new StringBuffer(" SELECT  count(*)   from DrugComInfo  d  where 1=1 ");
		
			
			
			if(tousu!=null && !tousu.equals("")){
				buffer.append(" and  d.complainant like '%");
				buffer.append(tousu+"%'  ");
			}
			if(mingcheng!=null && !mingcheng.equals("")){
				buffer.append(" and d.quaMedicId ='"+mingcheng+"' ");
				
			}
			if(tousuriqi!=null &&!tousuriqi.equals("")){
				buffer.append(" and d.modifiedtime>= '");
				buffer.append(tousuriqi+"'  ");
			}
			if(zhi!=null &&!zhi.equals("")){
				buffer.append(" and d.modifiedtime<= '");
				buffer.append(zhi+"'  ");
			}
			//完成
			if(wcqkValue!=null&&wcqkValue.equals("0")){
				buffer.append("and d.roleId like '%"+0+"%' ");	
			}
			//完成
			if(wcqkValue!=null&&wcqkValue.equals("1")){
				buffer.append("and d.roleId not like '%"+0+"%' ");	
			}
			int resultSize = drugComInfoManger.getQueryCount(buffer.toString());
			double size = resultSize;
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("resultSize", resultSize);
			
		
		
		
		//页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("dr", dr);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("comQuery/drugComInfoRecords/list");
	}

}
