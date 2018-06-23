package com.sinosoft.qualityRecords.adverseReactionInfo.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;

import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionDoubtItem;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionInfo;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionUseItem;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.Filed;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.QualityFiled;
import com.sinosoft.qualityRecords.adverseReactionInfo.service.AdverseReactionDoubtItemMng;
import com.sinosoft.qualityRecords.adverseReactionInfo.service.AdverseReactionInfoService;
import com.sinosoft.qualityRecords.adverseReactionInfo.service.AdverseReactionUseItemMng;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

@Controller
public class AdverseReactionInfoAction {
	private AdverseReactionInfoService adverseReactionInfoService;
	private AdverseReactionDoubtItemMng adverseReactionDoubtItemMng;
	private AdverseReactionUseItemMng adverseReactionUseItemMng;
	@Autowired
	public void setAdverseReactionUseItemMng(
			AdverseReactionUseItemMng adverseReactionUseItemMng) {
		this.adverseReactionUseItemMng = adverseReactionUseItemMng;
	}
	@Autowired
	private InspectionMng inspectionMng;
	@Autowired
	public void setAdverseReactionInfoService(
			AdverseReactionInfoService adverseReactionInfoService) {
		this.adverseReactionInfoService = adverseReactionInfoService;
	}
	@Autowired
	public void setAdverseReactionDoubtItemMng(AdverseReactionDoubtItemMng adverseReactionDoubtItemMng) {
		this.adverseReactionDoubtItemMng = adverseReactionDoubtItemMng;
	}

	@RequestMapping("/qualityRecords/adverseReactionInfo/dlrlist.html")
	public ModelAndView dlrPage(AdverseReactionInfo ar, HttpServletRequest request, HttpServletResponse response,Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		List<AdverseReactionInfo> list = new ArrayList<AdverseReactionInfo>();
		String pageNo = request.getParameter("thispage");
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			list= adverseReactionInfoService.getPage(ar,0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			list= adverseReactionInfoService.getPage(ar,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		

		for(int i=0;i<list.size();i++){
			if(list.get(i).getAdverseReactionResult().equals("0")){
				list.get(i).setAdverseReactionResult("治愈");
				
			}else if(list.get(i).getAdverseReactionResult().equals("1")){
				list.get(i).setAdverseReactionResult("好转");
			}else if(list.get(i).getAdverseReactionResult().equals("2")){
				list.get(i).setAdverseReactionResult("后遗症");
			}else{
				list.get(i).setAdverseReactionResult("死亡");
			}
			
			
		}
		int resultSize = adverseReactionInfoService.getTotalCount();
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("recordlist", list);
		model.addAttribute("ar", ar);
		return new ModelAndView("qualityRecords/adverseReactionInfo/dlrlist");
	}

	@RequestMapping("/qualityRecords/adverseReactionInfo/query.html")
	public ModelAndView queryEnterpristInfoList( AdverseReactionInfo ar,Model model,HttpServletRequest request,HttpServletResponse response){
		List<AdverseReactionInfo> reslist=new ArrayList<AdverseReactionInfo>();
		String occurrenceDate= request.getParameter("occurrenceDate");
		String name= request.getParameter("name");
		String page = DisplayGetPage.getPageParamName("records", request);
		model.addAttribute("occurrenceDate", occurrenceDate);
		model.addAttribute("name", name);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			reslist= adverseReactionInfoService.getPage(ar,0,Constants.pagesize);
		}else{
			if(occurrenceDate.equals("")&&name.equals("")){
				reslist= adverseReactionInfoService.getPage(ar,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
				int resultSize = adverseReactionInfoService.getTotalCount();
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
				
			}else{
				StringBuffer sqlBuffer = new StringBuffer("select d from AdverseReactionInfo  d where");
				if(name!=null && !name.equals("") &&  occurrenceDate.equals("")){
					sqlBuffer.append(" d.name like '%");
					sqlBuffer.append(name+"%'  ");
				}
				if(occurrenceDate!=null && !occurrenceDate.equals("")&&  name.equals("")){
					sqlBuffer.append("  d.occurrenceDate like '%");
					sqlBuffer.append(occurrenceDate+"%'  ");
				}
				if(name!=null && !name.equals("")&& occurrenceDate!=null && !occurrenceDate.equals("")){
					sqlBuffer.append(" d.name like '%"+ name+"%'  and  d.occurrenceDate like '%" + occurrenceDate+"%'  ");
					
				}
				if(page==null){
					reslist= adverseReactionInfoService.getPage(ar,0,Constants.pagesize);
				}else{
					reslist = adverseReactionInfoService.getAdverseReactionInfoByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
				}
				StringBuffer buffer=new StringBuffer(" SELECT  count(*) FROM AdverseReactionInfo  d where  ");
				if(name!=null && !name.equals("") && occurrenceDate.equals("")){
					buffer.append(" d. name like '%");
					buffer.append(name+"%'  ");
				}
				if(occurrenceDate!=null && !occurrenceDate.equals("") && name.equals("")){
					buffer.append(" d. occurrenceDate like '%");
					buffer.append(occurrenceDate+"%'  ");
				}
				if(name!=null && !name.equals("")&& occurrenceDate!=null && !occurrenceDate.equals("")){
					buffer.append(" d.name like '%"+ name+"%'  and  d.occurrenceDate like '%" + occurrenceDate+"%'  ");
					
				}
				int resultSize = adverseReactionInfoService.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
			}
		}
		for(int i=0;i<reslist.size();i++){
			if(reslist.get(i).getAdverseReactionResult().equals("0")){
				reslist.get(i).setAdverseReactionResult("治愈");
				
			}else if(reslist.get(i).getAdverseReactionResult().equals("1")){
				reslist.get(i).setAdverseReactionResult("好转");
			}else if(reslist.get(i).getAdverseReactionResult().equals("2")){
				reslist.get(i).setAdverseReactionResult("后遗症");
			}else{
				reslist.get(i).setAdverseReactionResult("死亡");
			}
			
			
		}
		//页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
	
		model.addAttribute("ar", ar);
		model.addAttribute("recordlist", reslist);
		return new ModelAndView("qualityRecords/adverseReactionInfo/dlrlist");
	}
	
	@RequestMapping("/qualityRecords/adverseReactionInfo/dlradd.html")
	public ModelAndView dshadd(AdverseReactionInfo ar, HttpServletRequest request, HttpServletResponse response,Model model){
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		model.addAttribute("ar", ar);
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> quamaps= inspectionMng.qmMap();
		model.addAttribute("quamaps", quamaps);
		Map<String, String> qsmap= inspectionMng.gonghuoMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("qualityRecords/adverseReactionInfo/dlradd");
	}
	@RequestMapping("/qualityRecords/adverseReactionInfo/dlredit.html")
	public ModelAndView dshedit(AdverseReactionInfo ar,String id, HttpServletRequest request, HttpServletResponse response,Model model){
		Map<String, String> quamap= inspectionMng.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> quamaps= inspectionMng.qmMap();
		model.addAttribute("quamaps", quamaps);
		AdverseReactionInfo mcs=adverseReactionInfoService.findById(id);
		model.addAttribute("ar", mcs);
		//根据id 找到怀疑用药
		List<AdverseReactionDoubtItem> receItem= adverseReactionInfoService.findYp(mcs.getId());
		List<QualityFiled> qus =  new ArrayList<QualityFiled>();
		for(int j=0;j<receItem.size();j++){
			QualityFiled qu = new QualityFiled();
			AdverseReactionDoubtItem rece = receItem.get(j);
			QualityMidicine qualifiedMedicine = inspectionMng.findHGYP(receItem.get(j).getQualifiedMedicineId());
			if(rece.getCommonName()!=null && !"".equals(rece.getCommonName().toString())){
				qu.setTongyongming(rece.getCommonName().toString());
			}else{
				qu.setTongyongming("");
			}
			if(rece.getQualifiedMedicineId()!=null){
				qu.setPinming(rece.getQualifiedMedicineId().toString());
			}else{
				qu.setPinming("");
			}
			if(rece.getLicenseNo()!=null){
				qu.setPihao(rece.getLicenseNo());
			}else{
				qu.setPihao("");
			}
			if(rece.getUsageDosage()!=null){
				qu.setYongfayongliang(rece.getUsageDosage());
			}else{
				qu.setYongfayongliang("");
			}
			if(rece.getBeginDate()!=null){
				qu.setYongyaoshijian(rece.getBeginDate());
			}else{
				qu.setYongyaoshijian("");
			}
			if(rece.getReason()!=null){
				qu.setYongyaoyuanyin(rece.getReason());
			}else{
				qu.setYongyaoyuanyin("");
			}
			if(rece.getRemark()!=null){
				qu.setBeizhu(rece.getRemark());
			}else{
				qu.setBeizhu("");
			}
		
			qus.add(qu);
		}
		//根据id 找到并用
		List<AdverseReactionUseItem> useItem= adverseReactionInfoService.findBYYp(mcs.getId());
					List<Filed> fileds =  new ArrayList<Filed>();
					for(int j=0;j<useItem.size();j++){
						Filed filed = new Filed();
						AdverseReactionUseItem use = useItem.get(j);
						QualityMidicine qualifiedMedicine = inspectionMng.findHGYP(useItem.get(j).getQualifiedMedicineId());
						if(use.getCommonName()!=null && !"".equals(use.getCommonName().toString())){
							filed.setTym(use.getCommonName().toString());
						}else{
							filed.setTym("");
						}
						if(use.getQualifiedMedicineId()!=null){
							filed.setPm(use.getQualifiedMedicineId().toString());
						}else{
							filed.setPm("");
						}
						if(use.getLicenseNo()!=null){
							filed.setPh(use.getLicenseNo());
						}else{
							filed.setPh("");
						}
						if(use.getUsageDosage()!=null){
							filed.setYfyl(use.getUsageDosage());
						}else{
							filed.setYfyl("");
						}
						if(use.getBeginDate()!=null){
							filed.setYysj(use.getBeginDate());
						}else{
							filed.setYysj("");
						}
						if(use.getReason()!=null){
							filed.setYyyy(use.getReason());
						}else{
							filed.setYyyy("");
						}
						if(use.getRemark()!=null){
							filed.setBz(use.getRemark());
						}else{
							filed.setBz("");
						}
					
						fileds.add(filed);
					}
					
		List<String> jsonStringList = new ArrayList<String>();
		for(int i=0;i<receItem.size();i++)
		{
			QualityFiled borg = qus.get(i);
			jsonStringList.add(new JSONObject(borg).toString());
		}
		JSONArray jsonArray = new JSONArray(jsonStringList);
		String jsonString = jsonArray.toString();
		model.addAttribute("receItem", jsonString);

		List<String> jsonStringListTwo = new ArrayList<String>();
		for(int i=0;i<useItem.size();i++)
		{
			Filed borgTwo = fileds.get(i);
			jsonStringListTwo.add(new JSONObject(borgTwo).toString());
		}	
		JSONArray jsonArrayTwo = new JSONArray(jsonStringListTwo);
		String jsonStringTwo = jsonArrayTwo.toString();
		model.addAttribute("useItem", jsonStringTwo);
		Map<String, String> qsmap= inspectionMng.gonghuoMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("qualityRecords/adverseReactionInfo/dlredit");
	}
	@RequestMapping("/qualityRecords/adverseReactionInfo/dlrsave.html")
	public ModelAndView dlrsave(AdverseReactionInfo ar, String counts,String countss,HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		String thispage=request.getParameter("thispage");
		String type = request.getParameter("submitType");
		model.addAttribute("thispage", thispage);
		model.addAttribute("ar", ar);
		String fytype = request.getParameter("type");//不良反应类型
		Integer type_fytype=null;
		if(fytype!=null && !fytype.trim().equals("")){
			type_fytype= Integer.valueOf(fytype);
		}
		if(type_fytype!=null){
			ar.setType(type_fytype);
		}
		String reportType = request.getParameter("reportType");//上报者类型
		Integer reportType_type=null;
		if(reportType!=null && !reportType.trim().equals("")){
			reportType_type= Integer.valueOf(reportType);
		}
		if(reportType_type!=null){
			ar.setReportType(reportType_type);
		}
		String gender = request.getParameter("gender");//性别
		Integer gender_type=null;
		if(gender!=null && !gender.trim().equals("")){
			gender_type= Integer.valueOf(gender);
		}
		if(gender_type!=null){
			ar.setGender(gender_type);
		}
		String familyAdverseReaction = request.getParameter("familyAdverseReaction");//家族不良反应
		Integer familyAdverseReaction_type=null;
		if(familyAdverseReaction!=null && !familyAdverseReaction.trim().equals("")){
			familyAdverseReaction_type= Integer.valueOf(familyAdverseReaction);
		}
		if(familyAdverseReaction_type!=null){
			ar.setFamilyAdverseReaction(familyAdverseReaction_type);
		}
		String sinceAdverseReaction = request.getParameter("sinceAdverseReaction");//既往不良反应
		Integer sinceAdverseReaction_type=null;
		if(sinceAdverseReaction!=null && !sinceAdverseReaction.trim().equals("")){
			sinceAdverseReaction_type= Integer.valueOf(sinceAdverseReaction);
		}
		if(sinceAdverseReaction_type!=null){
			ar.setSinceAdverseReaction(sinceAdverseReaction_type);
		}
		String adverseReactionResult = request.getParameter("adverseReactionResult");//不良反应结果
		Integer adverseReactionResult_type=null;
		if(adverseReactionResult!=null && !adverseReactionResult.trim().equals("")){
			adverseReactionResult_type= Integer.valueOf(adverseReactionResult);
		}
	
		String influence = request.getParameter("influence");//对原来疾病影响
		Integer influence_type=null;
		if(influence!=null && !influence.trim().equals("")){
			influence_type= Integer.valueOf(influence);
		}
		if(influence_type!=null){
			ar.setInfluence(influence_type);
		}
		String similarDomestic = request.getParameter("similarDomestic");//国内类似
		Integer similarDomestic_type=null;
		if(similarDomestic!=null && !similarDomestic.trim().equals("")){
			similarDomestic_type= Integer.valueOf(similarDomestic);
		}
		if(similarDomestic_type!=null){
			ar.setSimilarDomestic(similarDomestic_type);
		}
		
		String foreignSimilar = request.getParameter("foreignSimilar");//国外类似
		Integer foreignSimilar_type=null;
		if(foreignSimilar!=null && !foreignSimilar.trim().equals("")){
			foreignSimilar_type= Integer.valueOf(foreignSimilar);
		}
		if(foreignSimilar_type!=null){
			ar.setForeignSimilar(foreignSimilar_type);
		}
		Date  d=new Date();
		ar.setModifiedtime(d);
		User localuser = (User) request.getSession().getAttribute(
				Constants.LOCAL_USER);
		long a=localuser.getId();
		
		ar.setModifierid(a);
		AdverseReactionInfo mcs=adverseReactionInfoService.save(ar);
		if(!"".equals(counts) && counts.equals(counts)){
			for(int i=0;i<Integer.parseInt(counts);i++){
				AdverseReactionDoubtItem chIt= new AdverseReactionDoubtItem();
				String pingming = request.getParameter("pinming"+i);
				String tongyongming = request.getParameter("tongyongming"+i);
				String pihao = request.getParameter("pihao"+i);
				String yongfayongliang = request.getParameter("yongfayongliang"+i);
				String yongyaoshijian = request.getParameter("yongyaoshijian"+i);
				String yongyaoyuanyin=request.getParameter("yongyaoyuanyin"+i);
				String beizhu = request.getParameter("beizhu"+i);

				if(pingming!=null && !"".equals(pingming)){
					chIt.setQualifiedMedicineId(Long.parseLong(pingming.trim()));
				}

					chIt.setCommonName(tongyongming);
				
				chIt.setAdverseReactionInfoId(mcs.getId());
				chIt.setLicenseNo(pihao);
				chIt.setUsageDosage(yongfayongliang);
				chIt.setBeginDate(yongyaoshijian);
				chIt.setReason(yongyaoyuanyin);
				chIt.setRemark(beizhu);
				
				adverseReactionDoubtItemMng.save(chIt);
			}
		}
		
		if(!"".equals(countss) && counts.equals(countss)){
			for(int i=0;i<Integer.parseInt(countss);i++){
				AdverseReactionUseItem useitem= new AdverseReactionUseItem();
				String pm = request.getParameter("pm"+i);
				String tym = request.getParameter("tym"+i);
				String ph = request.getParameter("ph"+i);
				String yfyl = request.getParameter("yfyl"+i);
				String yysj = request.getParameter("yysj"+i);
				String yyyy=request.getParameter("yyyy"+i);
				String bz = request.getParameter("bz"+i);

				if(pm!=null && !"".equals(pm)){
					useitem.setQualifiedMedicineId(Long.parseLong(pm.trim()));
				}

                  useitem.setCommonName(tym);
				
				useitem.setAdverseReactionInfoId(mcs.getId());
				useitem.setLicenseNo(ph);
				useitem.setUsageDosage(yfyl);
				useitem.setBeginDate(yysj);
				useitem.setReason(yyyy);
				useitem.setRemark(bz);
				
				
				adverseReactionUseItemMng.save(useitem);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;

	}
	
	@RequestMapping("/qualityRecords/adverseReactionInfo/dlrupdate.html")
	public ModelAndView dshupdate(AdverseReactionInfo ar,String counts,String countss, HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
 		String thispage=request.getParameter("thispage");
		String type = request.getParameter("submitType");
		
		model.addAttribute("thispage", thispage);
		model.addAttribute("ar", ar);
		String fytype = request.getParameter("type");//不良反应类型
		Integer type_fytype=null;
		if(fytype!=null && !fytype.trim().equals("")){
			type_fytype= Integer.valueOf(fytype);
		}
		if(type_fytype!=null){
			ar.setType(type_fytype);
		}
		String reportType = request.getParameter("reportType");//上报者类型
		Integer reportType_type=null;
		if(reportType!=null && !reportType.trim().equals("")){
			reportType_type= Integer.valueOf(reportType);
		}
		if(reportType_type!=null){
			ar.setReportType(reportType_type);
		}
		String gender = request.getParameter("gender");//性别
		Integer gender_type=null;
		if(gender!=null && !gender.trim().equals("")){
			gender_type= Integer.valueOf(gender);
		}
		if(gender_type!=null){
			ar.setGender(gender_type);
		}
		String familyAdverseReaction = request.getParameter("familyAdverseReaction");//家族不良反应
		Integer familyAdverseReaction_type=null;
		if(familyAdverseReaction!=null && !familyAdverseReaction.trim().equals("")){
			familyAdverseReaction_type= Integer.valueOf(familyAdverseReaction);
		}
		if(familyAdverseReaction_type!=null){
			ar.setFamilyAdverseReaction(familyAdverseReaction_type);
		}
		String sinceAdverseReaction = request.getParameter("sinceAdverseReaction");//既往不良反应
		Integer sinceAdverseReaction_type=null;
		if(sinceAdverseReaction!=null && !sinceAdverseReaction.trim().equals("")){
			sinceAdverseReaction_type= Integer.valueOf(sinceAdverseReaction);
		}
		if(sinceAdverseReaction_type!=null){
			ar.setSinceAdverseReaction(sinceAdverseReaction_type);
		}
		
		//
		String adverseReactionResult = request.getParameter("adverseReactionResult");//是否上报
		String adverseReactionResult_type=null;
		if(adverseReactionResult!=null && !adverseReactionResult.trim().equals("")){
			adverseReactionResult_type= adverseReactionResult;
		}
		if(adverseReactionResult_type!=null){
			ar.setAdverseReactionResult(adverseReactionResult_type);
		}

		String influence = request.getParameter("influence");//对原来疾病影响
		Integer influence_type=null;
		if(influence!=null && !influence.trim().equals("")){
			influence_type= Integer.valueOf(influence);
		}
		if(influence_type!=null){
			ar.setInfluence(influence_type);
		}
		String similarDomestic = request.getParameter("similarDomestic");//国内类似
		Integer similarDomestic_type=null;
		if(similarDomestic!=null && !similarDomestic.trim().equals("")){
			similarDomestic_type= Integer.valueOf(similarDomestic);
		}
		if(similarDomestic_type!=null){
			ar.setSimilarDomestic(similarDomestic_type);
		}
		
		String foreignSimilar = request.getParameter("foreignSimilar");//国外类似
		Integer foreignSimilar_type=null;
		if(foreignSimilar!=null && !foreignSimilar.trim().equals("")){
			foreignSimilar_type= Integer.valueOf(foreignSimilar);
		}
		if(foreignSimilar_type!=null){
			ar.setForeignSimilar(foreignSimilar_type);
		}
		adverseReactionInfoService.update(ar);
		//先删除后保存
		List<?> receItem= adverseReactionInfoService.findAllId(ar.getId());
		List<?> useItem=	adverseReactionInfoService.findAllIds(ar.getId());
		adverseReactionDoubtItemMng.del(receItem);
		adverseReactionUseItemMng.del(useItem);
		if(!"".equals(counts) && null!=counts){
			for(int i=0;i<Integer.parseInt(counts);i++){
				AdverseReactionDoubtItem chIt= new AdverseReactionDoubtItem();
				String pingming = request.getParameter("pinming"+i);
				String tongyongming = request.getParameter("tongyongming"+i);
				String pihao = request.getParameter("pihao"+i);
				String yongfayongliang = request.getParameter("yongfayongliang"+i);
				String yongyaoshijian = request.getParameter("yongyaoshijian"+i);
				String yongyaoyuanyin=request.getParameter("yongyaoyuanyin"+i);
				String beizhu = request.getParameter("beizhu"+i);
				if(pingming!=null && !"".equals(pingming)){
					chIt.setQualifiedMedicineId(Long.parseLong(pingming.trim()));
				}else{
					continue;
				}
				chIt.setAdverseReactionInfoId(ar.getId());
				chIt.setCommonName(tongyongming);
				chIt.setLicenseNo(pihao);
				chIt.setUsageDosage(yongfayongliang);
				chIt.setBeginDate(yongyaoshijian);
				chIt.setReason(yongyaoyuanyin);
				chIt.setRemark(beizhu);
				adverseReactionDoubtItemMng.save(chIt);
			}
		}
		if(!"".equals(countss) && null!=countss){
			for(int i=0;i<Integer.parseInt(countss);i++){
				
				AdverseReactionUseItem useitem= new AdverseReactionUseItem();
				String pm = request.getParameter("pm"+i);
				String tym = request.getParameter("tym"+i);
				String ph = request.getParameter("ph"+i);
				String yfyl = request.getParameter("yfyl"+i);
				String yysj = request.getParameter("yysj"+i);
				String yyyy=request.getParameter("yyyy"+i);
				String bz = request.getParameter("bz"+i);
				if(pm!=null && !"".equals(pm)){
					useitem.setQualifiedMedicineId(Long.parseLong(pm.trim()));
				}else{
					continue;
				}
				useitem.setAdverseReactionInfoId(ar.getId());
				useitem.setCommonName(tym);
				useitem.setLicenseNo(ph);
				useitem.setUsageDosage(yfyl);
				useitem.setBeginDate(yysj);
				useitem.setReason(yyyy);
				useitem.setRemark(bz);
				adverseReactionUseItemMng.save(useitem);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}

	
	@RequestMapping("/qualityRecords/adverseReactionInfo/dlrdel.html")
	public ModelAndView deldlr(String ids[], HttpServletRequest request, HttpServletResponse response,Model model){
		if(ids!=null&&!"".equals("ids")){
			for(int i= 0;i<ids.length;i++){
				adverseReactionInfoService.del(ids[i]);
				List<?> receItem= adverseReactionInfoService.findAllId(Long.parseLong(ids[i]));
				if(receItem!=null && receItem.size()>0){
					adverseReactionDoubtItemMng.del(receItem);
					adverseReactionUseItemMng.del(receItem);
				}
			}
		}
		return dlrPage(null, request, response, model);
		
	}	
	@RequestMapping("/qualityRecords/adverseReactionInfo/quamap.html")
	public void findMq(String quamap, HttpServletRequest request, HttpServletResponse response, Model model){
		QualityMidicine qm= adverseReactionInfoService.findYpById(quamap);
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		JSONArray json = new JSONArray();
		json.put(qm.getTradename());//商品名tradename
		json.put(qm.getCommonname());//通用名称
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json.toString());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/qualityRecords/adverseReactionInfo/quamaps.html")
	public void findMqs(String quamaps, HttpServletRequest request, HttpServletResponse response, Model model){
		QualityMidicine qm= adverseReactionInfoService.findYpById(quamaps);
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		JSONArray json = new JSONArray();
		json.put(qm.getTradename());//商品名tradename
		json.put(qm.getCommonname());//通用名称
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json.toString());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	}
