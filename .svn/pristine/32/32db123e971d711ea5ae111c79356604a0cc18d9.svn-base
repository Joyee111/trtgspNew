package com.sinosoft.qualityRecords.qualityQuery.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sinosoft.base.Constants;
import com.sinosoft.qualityRecords.complantManager.service.DrugComInfoManger;
import com.sinosoft.qualityRecords.qualityQuery.model.QulityQuery;
import com.sinosoft.qualityRecords.qualityQuery.serivice.QualityQueryMng;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;

@Controller
public class QualityQueryAct {
	private QualityQueryMng qualityQueryMng;
	private QualityMidicineMng qualityMidicineMng;
	@Autowired
	public void setQualityMidicineMng(QualityMidicineMng qualityMidicineMng) {
		this.qualityMidicineMng = qualityMidicineMng;
	}
	@Autowired
	public void setQualityQueryMng(QualityQueryMng qualityQueryMng) {
		this.qualityQueryMng = qualityQueryMng;
	}
	private DrugComInfoManger drugComInfoManger;
	@Autowired
	public void setDrugComInfoManger(DrugComInfoManger drugComInfoManger) {
		this.drugComInfoManger = drugComInfoManger;
	}
	@Autowired
	private SystemLogService logService;

	@RequestMapping("/qualityRecords/qualityQuery/list.html")
	public ModelAndView openFramePage(QulityQuery qq, HttpServletRequest request, HttpServletResponse response, Model model){
			String page = DisplayGetPage.getPageParamName("records", request);// 第几页
			String  type = request.getParameter("type");
			List<QulityQuery> reslist=new ArrayList<QulityQuery>();
			if(page==null){
				//如果page等于空，默认从第一条开始查询
				
				reslist= qualityQueryMng.getPage(qq,0,Constants.pagesize);
				
			}
			else{
				//否者翻页查询
				reslist= qualityQueryMng.getPage(qq,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			}
			int resultSize = qualityQueryMng.getTotalCount();
			double size = resultSize;
			//页数
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			model.addAttribute("pageSize", Constants.pagesize);
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("qq", qq);
			model.addAttribute("reslist", reslist);
			if(type!=null && !"".equals(type)){
				return new ModelAndView("/comQuery/qualityQuery/list");
			}else{
				return new ModelAndView("qualityRecords/qualityQuery/list");
			}
			
		}
	@RequestMapping("/qualityRecords/qualityQuery/query.html")
	public ModelAndView queryEnterpristInfoList( QulityQuery qq,Model model,HttpServletRequest request,HttpServletResponse response){
		List<QulityQuery> reslist=new ArrayList<QulityQuery>();
		String inquiryunit= request.getParameter("inquiryunit");
		String pinming= request.getParameter("pinming");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String page = DisplayGetPage.getPageParamName("records", request);
		model.addAttribute("inquiryunit", inquiryunit);
		model.addAttribute("pinming", pinming);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		String type= request.getParameter("type");
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			
			reslist= qualityQueryMng.getPage(qq,0,Constants.pagesize);
			
		}else{
			if( inquiryunit.equals("")&& pinming.equals("") && startDate.equals("") && endDate.equals("")){
				//否者翻页查询
				reslist= qualityQueryMng.getPage(qq,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
				int resultSize = qualityQueryMng.getTotalCount();
				 double size = resultSize;
					model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
					model.addAttribute("resultSize", resultSize);
			}else{
				StringBuffer sqlBuffer = new StringBuffer("select d from QulityQuery  d where  1=1");
				if(inquiryunit!=null && !inquiryunit.equals("")){
					sqlBuffer.append(" and d.inquiryunit like '%");
					sqlBuffer.append(inquiryunit+"%'  ");
				}
				if(pinming!=null && !pinming.equals("")){
					sqlBuffer.append(" and  d.qualifiedmedicineid like '%");
					sqlBuffer.append(pinming+"%'  ");
				}
				if(startDate != null && !"".equals(startDate)){
					sqlBuffer.append(" and  CONVERT(datetime,CONVERT(varchar(10),d.modifiedtime,20),20) >=CONVERT(datetime,'"+startDate+"',20)");
				}
				if(endDate != null && !"".equals(endDate)){
					sqlBuffer.append(" and  CONVERT(datetime,CONVERT(varchar(10),d.modifiedtime,20),20) <=CONVERT(datetime,'"+endDate+"',20)");
				}
				if(page==null){
					reslist= qualityQueryMng.getPage(qq,0,Constants.pagesize);
				}else{
					reslist = qualityQueryMng.getQulityQueryByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
				}
				StringBuffer buffer=new StringBuffer(" SELECT  count(*) FROM QulityQuery  d   where  1=1  ");
				if(inquiryunit!=null && !inquiryunit.equals("")){
					buffer.append(" and d.inquiryunit like '%");
					buffer.append(inquiryunit+"%'  ");
				}
				if(pinming!=null && !pinming.equals("")){
					buffer.append(" and  d.qualifiedmedicineid like '%");
					buffer.append(pinming+"%'  ");
				}
				if(startDate != null && !"".equals(startDate)){
					buffer.append(" and  CONVERT(datetime,CONVERT(varchar(10),d.modifiedtime,20),20) >=CONVERT(datetime,'"+startDate+"',20)");
				}
				if(endDate != null && !"".equals(endDate)){
					buffer.append(" and  CONVERT(datetime,CONVERT(varchar(10),d.modifiedtime,20),20) <=CONVERT(datetime,'"+endDate+"',20)");
				}
				int resultSize = qualityQueryMng.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
			}
			
		}
		
		//页数
		
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
	
		model.addAttribute("qq", qq);
		model.addAttribute("reslist", reslist);
		if(type!=null && !"".equals(type)){
			return new ModelAndView("/comQuery/qualityQuery/list");
		}else{
			return new ModelAndView("qualityRecords/qualityQuery/list");
		}
		
	}
	@RequestMapping("/qualityRecords/qualityQuery/add.html")
	public ModelAndView add(QulityQuery qq,String id, HttpServletRequest request, HttpServletResponse response, Model model){
		String type=request.getParameter("type");
		String method = request.getParameter("method");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		QulityQuery qulityQuery=new QulityQuery();
		Long medicinalNo=null;
	    String titles="质量查询新增";
	    if("add".equals(method)){
	    	Date now = new Date();
			SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd");
			String numbers = formats.format(now);
			qulityQuery.setQualitydate(numbers);
		}
		if(!method.equals("add")){
			 titles="质量查询修改";
			qulityQuery=qualityQueryMng.findById(id);
			if(qulityQuery.getQualityMidicine()!=null){
				if(qulityQuery.getQualityMidicine().getMedicinalNo()!=null){
					medicinalNo=qulityQuery.getQualityMidicine().getId();
				}
			}
		}
		model.addAttribute("titles", titles);
		model.addAttribute("medicinalNo", medicinalNo);
		Map<String, String> quamap= drugComInfoManger.qmMap();
		model.addAttribute("quamap", quamap);
		model.addAttribute("qq",qulityQuery );
		model.addAttribute("method", method);
		if(type!=null && !"".equals(type)){
			return new ModelAndView("/comQuery/qualityQuery/add");
		}else{
			return new ModelAndView("qualityRecords/qualityQuery/add");
		}
			
		}
	@RequestMapping("/qualityRecords/qualityQuery/saveOrUpdata.html")
	public ModelAndView saveOrUpdate(QulityQuery qq, HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException{
		String op = request.getParameter("method");
		String jixing = request.getParameter("dosageforms");
		String guige = request.getParameter("specifications");
		String pihao = request.getParameter("licensenumber");
		String danwei = request.getParameter("unit");
		String scdw = request.getParameter("produceno");
		//String qualifiedmedicineid = request.getParameter("qualifiedmedicineid");
		//QualityMidicine qualityMidicine=new QualityMidicine();
	      //判断药品名在添加时是手动输入的还是在下拉框里选择的（手动输入的药品名是中文，下拉框选择的药品是药品的Id）
		//if(qualifiedmedicineid!=null && !qualifiedmedicineid.equals("")){
		//	Pattern pattern = Pattern.compile("[0-9]*");
		//	Matcher isNum = pattern.matcher(qualifiedmedicineid);
			//如果是手动输入的即药品的id 是中文
		//	if( !isNum.matches() ){
				qq.setJixing(jixing);
				qq.setGuige(guige);
				qq.setPihao(pihao);

				qq.setScdw(scdw);
//			}else{
//				//在下拉框选择的药品即药品的Id
//				  qualityMidicine = qualityMidicineMng.findById(qualifiedmedicineid);
//					qq.setQualityMidicine(qualityMidicine);
//					qq.setQualifiedmedicineid("("+qualityMidicine.getMedicinalNo()+")"+qualityMidicine.getCommonname());
//					qq.setJixing(jixing);
//					qq.setGuige(guige);
//					qq.setPihao(pihao);
//					qq.setScdw(scdw);
//			   }
			
	//		}
		if(!op.equals("add")){
			qualityQueryMng.saveOrUpdata(qq);
			
		}else{
			Date  d=new Date();
     		qq.setModifiedtime(d);
     		User localuser = (User) request.getSession().getAttribute(
					Constants.LOCAL_USER);
			long a=localuser.getId();
			
			qq.setModifierid(a);
		
			qualityQueryMng.saveQulityQuery(qq);
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("新增质量查询", user.getRealname(), "新增", "质量记录管理  >质量查询", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	
	@RequestMapping("/qualityRecords/qualityQuery/del.html")
	public ModelAndView del(String ids[], HttpServletRequest request, HttpServletResponse response, Model model){
		if(ids!=null && ids.length>0){
			qualityQueryMng.del(ids);
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除质量查询", user.getRealname(), "删除", "质量记录管理  >质量查询", StringUtil.getIpAddr(request));
		QulityQuery qulityQuery = new QulityQuery();
		return openFramePage(null, request, response, model);
	}
	@RequestMapping("/qualityRecords/qualityQuery/quamap.html")
	public void findMq(String quamap, HttpServletRequest request, HttpServletResponse response, Model model){
		QualityMidicine qm= drugComInfoManger.findYpById(quamap);
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		JSONArray json = new JSONArray();
		json.put(qm.getCommonname());//通用名称
		json.put(qm.getDosageforms().getFormName());//剂型
		json.put(qm.getSpecifications());//规格
		json.put(qm.getLicensenumber());//批号
		json.put(qm.getProduceno().getCustomerName());//生产厂商
		json.put(qm.getId());
		json.put(qm.getUnit());//单位
		json.put(qm.getValiddate());//有效期
		json.put(qm.getTradename());//商品名称
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json.toString());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
