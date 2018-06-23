package com.sinosoft.qualityRecords.euqipmentOperation.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import com.sinosoft.qualityRecords.euqipmentOperation.model.EuqipmentOperation;
import com.sinosoft.qualityRecords.euqipmentOperation.serivice.EuqipmentOperationMng;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.UtilJson;
@Controller
public class EuqipmentOperationAct {
	private  EuqipmentOperationMng euqipmentOperationMng;
	@Autowired
	public void setEuqipmentOperationMng(EuqipmentOperationMng euqipmentOperationMng) {
		this.euqipmentOperationMng = euqipmentOperationMng;
	}
	@RequestMapping("/qualityRecords/euqipmentOperation/list.html")
	public ModelAndView openFramePage(EuqipmentOperation eo, HttpServletRequest request, HttpServletResponse response, Model model){
			String page = DisplayGetPage.getPageParamName("records", request);// 第几页
			List<EuqipmentOperation> reslist=new ArrayList<EuqipmentOperation>();
			if(page==null){
				//如果page等于空，默认从第一条开始查询
				
				reslist= euqipmentOperationMng.getPage(eo,0,Constants.pagesize);
				
			}
			else{
				Integer a = (Integer.parseInt(page) - 1) * Constants.pagesize;
				//否者翻页查询
				reslist= euqipmentOperationMng.getPage(eo,a,Constants.pagesize);
			}
			for(int i=0;i<reslist.size();i++){
				if(reslist.get(i).getIsreport().equals("0")){
					reslist.get(i).setIsreport("否");
					
				}else{
					reslist.get(i).setIsreport("是");
				}
				if(reslist.get(i).getIstroubleclear().equals("0")){
					reslist.get(i).setIstroubleclear("否");
					
				}else{
					reslist.get(i).setIstroubleclear("是");
				}
				
			}
			int resultSize = euqipmentOperationMng.getTotalCount();
			double size = resultSize;
			//页数
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			model.addAttribute("pageSize", Constants.pagesize);
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("eo", eo);
			model.addAttribute("reslist", reslist);
			return new ModelAndView("qualityRecords/euqipmentOperation/list");
		}
	@RequestMapping("/qualityRecords/euqipmentOperation/query.html")
	public ModelAndView queryEnterpristInfoList( EuqipmentOperation eo,Model model,HttpServletRequest request,HttpServletResponse response){
		List<EuqipmentOperation> reslist=new ArrayList<EuqipmentOperation>();
		String handperson= request.getParameter("handperson");
		String handoverdate= request.getParameter("handoverdate");
		String page = DisplayGetPage.getPageParamName("records", request);
		model.addAttribute("handperson", handperson);
		model.addAttribute("handoverdate", handoverdate);
		
		if(page==null){
			reslist= euqipmentOperationMng.getPage(eo,0,Constants.pagesize);
		}else{
			if( handperson.equals("") &&  handoverdate.equals("")){
				Integer a = (Integer.parseInt(page) - 1) * Constants.pagesize;
				//否者翻页查询
				reslist= euqipmentOperationMng.getPage(eo,a,Constants.pagesize);
				 int resultSize = euqipmentOperationMng.getTotalCount();
				 double size = resultSize;
					model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
					model.addAttribute("resultSize", resultSize);
			}else{
				StringBuffer sqlBuffer = new StringBuffer("select d from EuqipmentOperation  d where");
				StringBuffer buffer=new StringBuffer(" SELECT  count(*) FROM EuqipmentOperation  d where  ");
				if(handperson!=null && !handperson.equals("") && handoverdate.equals("")){
					sqlBuffer.append(" d.handperson like '%");
					sqlBuffer.append(handperson+"%'  ");
					
					buffer.append(" d. handperson like '%");
					buffer.append(handperson+"%'  ");
				}
				if(handoverdate!=null && !handoverdate.equals("")&& handperson.equals("")){
					sqlBuffer.append("  d.handoverdate like '%");
					sqlBuffer.append(handoverdate+"%'  ");
					
					buffer.append(" d. handoverdate like '%");
					buffer.append(handoverdate+"%'  ");
				}
				if(handperson!=null && !handperson.equals("") && handoverdate!=null && !handoverdate.equals("")){
					sqlBuffer.append(" d.handperson like '%"+ handperson+"%'  and  d.handoverdate like '%" + handoverdate+"%'  ");
					
					buffer.append(" d.handperson like '%"+ handperson+"%'  and  d.handoverdate like '%" + handoverdate+"%'  ");
					
				}
				reslist = euqipmentOperationMng.getEuqipmentOperationByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
				int resultSize = euqipmentOperationMng.getQueryCount(buffer.toString());
				double size = resultSize;
				//页数
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
			}
			
			}
		for(int i=0;i<reslist.size();i++){
			if(reslist.get(i).getIsreport().equals("0")){
				reslist.get(i).setIsreport("否");
				
			}else{
				reslist.get(i).setIsreport("是");
			}
			if(reslist.get(i).getIstroubleclear().equals("0")){
				reslist.get(i).setIstroubleclear("否");
				
			}else{
				reslist.get(i).setIstroubleclear("是");
			}
			
		}
			
			model.addAttribute("thispage", Integer.parseInt(page));
			model.addAttribute("pageSize", Constants.pagesize);
			
			model.addAttribute("eo", eo);
			model.addAttribute("reslist", reslist);
			return new ModelAndView("qualityRecords/euqipmentOperation/list");	
					
				}			
		
		  
	      
	

	@RequestMapping("/qualityRecords/euqipmentOperation/add.html")
	public ModelAndView add(EuqipmentOperation eo,String id, HttpServletRequest request, HttpServletResponse response, Model model){
		String method = request.getParameter("method");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		EuqipmentOperation euqipmentOperation=new EuqipmentOperation();	
		String titles="设备运行新增";
		if(!method.equals("add")){	
		 titles="设备运行修改";
			euqipmentOperation=euqipmentOperationMng.findById(id);		
		}
		model.addAttribute("titles",titles);
		model.addAttribute("eo",euqipmentOperation );
		model.addAttribute("method", method);	
	
			return new ModelAndView("qualityRecords/euqipmentOperation/add");
		}
	@RequestMapping("/qualityRecords/euqipmentOperation/saveOrUpdata.html")
	public ModelAndView saveOrUpdate(EuqipmentOperation eo,String id, HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException{
		String op = request.getParameter("method");
		String isreport = request.getParameter("isreport");//是否上报
		String isreport_type=null;
		if(isreport!=null && !isreport.trim().equals("")){
			isreport_type= isreport;
		}
		if(isreport_type!=null){
			eo.setIsreport(isreport_type);
		}
		String istroubleclear = request.getParameter("istroubleclear");//是否故障排除
		String istroubleclear_type=null;
		if(istroubleclear!=null && !istroubleclear.trim().equals("")){
			istroubleclear_type= istroubleclear;
		}
		if(istroubleclear_type!=null){
			eo.setIstroubleclear(istroubleclear_type);
		}
		if(!op.equals("add")){
			euqipmentOperationMng.saveOrUpdata(eo);
			
		}else{
			euqipmentOperationMng.saveEuqipmentOperation(eo);
		
		
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/qualityRecords/euqipmentOperation/del.html")
	public ModelAndView del(String ids[], HttpServletRequest request, HttpServletResponse response, Model model){
		if(ids!=null && ids.length>0){
			euqipmentOperationMng.del(ids);
		}
		return openFramePage(null, request, response, model);
	}
}
