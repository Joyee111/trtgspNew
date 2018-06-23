package com.sinosoft.qualityRecords.qualityAccident.action;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedSuppliersService;
import com.sinosoft.qualityRecords.complantManager.service.DrugComInfoManger;
import com.sinosoft.qualityRecords.infoFeedback.serivice.InfoFeedbackMng;
import com.sinosoft.qualityRecords.qualityAccident.model.QualityAccident;
import com.sinosoft.qualityRecords.qualityAccident.service.QualityAccidentMng;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;

@Controller
public class QualityAccidentAct {
	private  QualityAccidentMng qualityAccidentMng;
	@Autowired
	public void setQualityAccidentMng(QualityAccidentMng qualityAccidentMng) {
		this.qualityAccidentMng = qualityAccidentMng;
	}
	private QualityMidicineMng qualityMidicineMng;
	@Autowired
	public void setQualityMidicineMng(QualityMidicineMng qualityMidicineMng) {
		this.qualityMidicineMng = qualityMidicineMng;
	}
	private DrugComInfoManger drugComInfoManger;
	@Autowired
	public void setDrugComInfoManger(DrugComInfoManger drugComInfoManger) {
		this.drugComInfoManger = drugComInfoManger;
	}
	private InfoFeedbackMng infoFeedbackMng;
	@Autowired
	public void setInfoFeedbackMng(InfoFeedbackMng infoFeedbackMng) {
		this.infoFeedbackMng = infoFeedbackMng;
	}
	private QualifiedSuppliersService qualifiedSuppliersService;
	@Autowired
	public void setQualifiedSuppliersService(
			QualifiedSuppliersService qualifiedSuppliersService) {
		this.qualifiedSuppliersService = qualifiedSuppliersService;
	}

	@RequestMapping("/qualityRecords/qualityAccident/list.html")
	public ModelAndView openFramePage(QualityAccident qa, HttpServletRequest request, HttpServletResponse response, Model model){
			String page = DisplayGetPage.getPageParamName("records", request);// 第几页
			List<QualityAccident> reslist=new ArrayList<QualityAccident>();
			if(page==null){
				//如果page等于空，默认从第一条开始查询
				
				reslist= qualityAccidentMng.getPage(qa,0,Constants.pagesize);
				
			}
			else{
				//否者翻页查询
				reslist= qualityAccidentMng.getPage(qa,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			}
			int resultSize = qualityAccidentMng.getTotalCount();
			double size = resultSize;
			//页数
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			model.addAttribute("pageSize", Constants.pagesize);
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("qa", qa);
			model.addAttribute("reslist", reslist);
			return new ModelAndView("qualityRecords/qualityAccident/list");
		}
	@RequestMapping("/qualityRecords/qualityAccident/query.html")
	public ModelAndView queryEnterpristInfoList( QualityAccident qa,Model model,HttpServletRequest request,HttpServletResponse response){
		List<QualityAccident> reslist=new ArrayList<QualityAccident>();
		String drugsnumber= request.getParameter("drugsnumber");
		String pinming= request.getParameter("pinming");
		model.addAttribute("drugsnumber", drugsnumber);
		model.addAttribute("pinming", pinming);

		String page = DisplayGetPage.getPageParamName("records", request);
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			reslist= qualityAccidentMng.getPage(qa,0,Constants.pagesize);	
		}else{
			if(pinming.equals("")&&drugsnumber.equals("")){
				reslist= qualityAccidentMng.getPage(qa,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
				int resultSize = qualityAccidentMng.getTotalCount();
				double size = resultSize;
				//页数
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
			}else{
				StringBuffer sqlBuffer = new StringBuffer("select d from QualityAccident  d , QualityMidicine q where  d.qualifiedmedicineid = q.id ");
				if(drugsnumber!=null && !drugsnumber.equals("")){
					sqlBuffer.append(" and d.drugsnumber like '%");
					sqlBuffer.append(drugsnumber+"%'  ");
				}
				if(pinming!=null && !pinming.equals("")){
					sqlBuffer.append("and q.commonname like '%");
					sqlBuffer.append(pinming+"%'  ");
				}
				if(page==null){
					reslist= qualityAccidentMng.getPage(qa,0,Constants.pagesize);
				}else{
					reslist = qualityAccidentMng.getQualityAccidentByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
				}
				StringBuffer buffer=new StringBuffer(" SELECT  count(*) FROM QualityAccident  d ,  QualityMidicine q  where  d.qualifiedmedicineid = q.id  ");
				if(drugsnumber!=null && !drugsnumber.equals("")){
					buffer.append(" and d.drugsnumber like '%");
					buffer.append(drugsnumber+"%'  ");
				}
				if(pinming!=null && !pinming.equals("")){
					buffer.append(" and q.commonname like '%");
					buffer.append(pinming+"%'  ");
				}
				int resultSize = qualityAccidentMng.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
			}
		}
		
				//页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("qa", qa);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("qualityRecords/qualityAccident/list");
	}
	@RequestMapping("/qualityRecords/qualityAccident/add.html")
	public ModelAndView add(QualityAccident qa,String id, HttpServletRequest request, HttpServletResponse response, Model model){
		String method = request.getParameter("method");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		QualityAccident qualityAccident=new QualityAccident();
	    Long medicinalNo=null;
	    String titles="质量事故新增";
		if(!method.equals("add")){
		 titles="质量事故修改";
			qualityAccident=qualityAccidentMng.findById(id);
			QualifiedSuppliers qualifiedSuppliers=new QualifiedSuppliers();
			if(qualityAccident.getQualityMidicine()!=null){
				if(qualityAccident.getQualityMidicine().getMedicinalNo()!=null){
					medicinalNo=qualityAccident.getQualityMidicine().getId();
				}
				if(qualityAccident.getDeliveryunitid()!=null){
					qualifiedSuppliers = qualifiedSuppliersService.findById(qualityAccident.getDeliveryunitid().toString());
					if(qualifiedSuppliers!=null){	
						model.addAttribute("gongyingshang", qualifiedSuppliers.getPinyinCode()+"_"+qualifiedSuppliers.getId());	
					}else{
						model.addAttribute("gongyingshang", "");	
					}
					
				}
			}
		}
		model.addAttribute("titles", titles);
		model.addAttribute("medicinalNo", medicinalNo);
		Map<String, String> quamap= drugComInfoManger.qmMap();
		model.addAttribute("quamap", quamap);
	//	Map<String, String> qsmap=infoFeedbackMng.qsMap();
	//	model.addAttribute("qsmap", qsmap);
		model.addAttribute("qa",qualityAccident );
		model.addAttribute("method", method);	
	
			return new ModelAndView("qualityRecords/qualityAccident/add");
		}
	@RequestMapping("/qualityRecords/qualityAccident/saveOrUpdata.html")
	public ModelAndView saveOrUpdate(QualityAccident qa,String id, HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException{
		String op = request.getParameter("method");
		String qualifiedmedicineid = request.getParameter("qualifiedmedicineid");
		QualityMidicine qualityMidicine=new QualityMidicine();
        qualityMidicine = qualityMidicineMng.findById(qualifiedmedicineid);
		qa.setQualityMidicine(qualityMidicine);
		if(!op.equals("add")){
			qualityAccidentMng.saveOrUpdata(qa);
			
		}else{
			Date  d=new Date();
			qa.setModifiedtime(d);
			
			
			User localuser = (User) request.getSession().getAttribute(
					Constants.LOCAL_USER);
			Long a=localuser.getId();
			
			qa.setModifierid(a);
			qualityAccidentMng.saveQualityAccident(qa);
			
		
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/qualityRecords/qualityAccident/del.html")
	public ModelAndView del(String ids[], HttpServletRequest request, HttpServletResponse response, Model model){
		if(ids!=null && ids.length>0){
			qualityAccidentMng.del(ids);
		}

		return openFramePage(null, request, response, model);
	}


}
