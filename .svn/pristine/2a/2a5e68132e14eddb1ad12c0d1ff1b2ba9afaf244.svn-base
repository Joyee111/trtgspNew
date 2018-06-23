package com.sinosoft.qualityRecords.transportRecords.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.displaytag.tags.TableTagParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.enterpriseManage.firstEnterprise.model.TransporterQualification;
import com.sinosoft.qualityRecords.transportRecords.model.TransportRecords;
import com.sinosoft.qualityRecords.transportRecords.model.TransportRecordsResource;
import com.sinosoft.qualityRecords.transportRecords.serivice.TransportRecordsMng;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.UtilJson;

@Controller
public class TransportRecordsAct {
	private  TransportRecordsMng transportRecordsMng;
	@Autowired
	public void setTransportRecordsMng(TransportRecordsMng transportRecordsMng) {
		this.transportRecordsMng = transportRecordsMng;
	}
	@RequestMapping("/qualityRecords/transportRecords/list.html")
	public ModelAndView openFramePage( TransportRecords tr, HttpServletRequest request, HttpServletResponse response, Model model){
			String page = DisplayGetPage.getPageParamName("records", request);// 第几页
			List<TransportRecords> reslist=new ArrayList<TransportRecords>();
			String exportParam = request.getParameter(TableTagParameters.PARAMETER_EXPORTING);
			if(exportParam!=null && !"".equals(exportParam)){
				reslist = transportRecordsMng.getAllTransportRecords("select t from TransportRecords t ", new HashMap<String, Object>());
			}else{
				if(page==null){
					//如果page等于空，默认从第一条开始查询
					
					reslist= transportRecordsMng.getPage(tr,0,Constants.pagesize);
					
					
				}
				else{
					Integer a = (Integer.parseInt(page) - 1) * Constants.pagesize;
					//否者翻页查询   
					reslist= transportRecordsMng.getPage(tr,a,Constants.pagesize);
					
					
				}
			}
			
		
			int resultSize = transportRecordsMng.getTotalCount();
			double size = resultSize;
			//页数
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			model.addAttribute("pageSize", Constants.pagesize);
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("tr", tr);
			model.addAttribute("reslist", reslist);
			return new ModelAndView("qualityRecords/transportRecords/list");
		}
	@RequestMapping("/qualityRecords/transportRecords/query.html")
	public ModelAndView queryEnterpristInfoList(Model model,HttpServletRequest request,HttpServletResponse response){
		//List<TransportRecords> reslist=new ArrayList<TransportRecords>();
		List<TransportRecords> reslist= null;
		String pcdh= request.getParameter("pcdh");
		String fhsj= request.getParameter("fhsj");
		String zhi= request.getParameter("zhi");
		String trasportType = request.getParameter("trasportType");
/*		if(fhsj!=null && !fhsj.equals("")){
			fhsj= request.getParameter("fhsj")+" " +"00:00:00.0";
		} if(zhi!=null && !zhi.equals("")){
			 zhi= request.getParameter("zhi")+" "+"23:59:59.0";
		}
*/		model.addAttribute("pcdh", pcdh);
		model.addAttribute("fhsj", fhsj);
		model.addAttribute("zhi", zhi);
		model.addAttribute("trasportType", trasportType);
		String page = DisplayGetPage.getPageParamName("records", request);
		/*if(page==null){
			//如果page等于空，默认从第一条开始查询
			reslist= transportRecordsMng.getPage(tr,0,Constants.pagesize);	
		}else{
			if(pcdh.equals("")&&fhsj.equals("")){
				reslist= transportRecordsMng.getPage(tr,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
				int resultSize = transportRecordsMng.getTotalCount();
				double size = resultSize;
				//页数
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
			}else{
				StringBuffer sqlBuffer = new StringBuffer("select d  from TransportRecords  d  where 1=1 ");
				if(pcdh!=null && !pcdh.equals("")){
					sqlBuffer.append(" and d.orderno = "+pcdh+" ");
				
				}
				if(fhsj!=null && !fhsj.equals("")){
				
					sqlBuffer.append(" and d.deliverydate >= '");
					sqlBuffer.append(fhsj+"'  ");
				}
				if(zhi!=null && !zhi.equals("")){
					
					sqlBuffer.append(" and d.deliverydate <= '");
					sqlBuffer.append(zhi+"'  ");
				}
				if(page==null){
					reslist= transportRecordsMng.getPage(tr,0,Constants.pagesize);
				}else{
					reslist = transportRecordsMng.getTransportRecordsByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
				
				}
				StringBuffer buffer=new StringBuffer(" SELECT  count(*) FROM TransportRecords  d   where  1=1  ");
				if(pcdh!=null && !pcdh.equals("")){
					buffer.append(" and d.orderno = "+pcdh+" ");
				
				}
				if(fhsj!=null && !fhsj.equals("")){
				
					buffer.append(" and d.deliverydate >= '");
					buffer.append(fhsj+"'  ");
				}
				if(zhi!=null && !zhi.equals("")){
					
					buffer.append(" and d.deliverydate <= '");
					buffer.append(zhi+"'  ");
				}
				int resultSize = transportRecordsMng.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
			}
		}*/
		StringBuffer hqlBuffer = new StringBuffer("select t from TransportRecords t where 1=1 ");
		StringBuffer countBuffer = new StringBuffer("select count(*) from TransportRecords t where 1=1");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(pcdh!=null && !"".equals(pcdh)){
			hqlBuffer.append(" and t.orderno like :orderNo ");
			countBuffer.append(" and t.orderno like '%"+pcdh+"%'");
			paramMap.put("orderNo", "%"+pcdh+"%");
		}
		if(fhsj!=null && !"".equals(fhsj)){
			hqlBuffer.append(" and t.deliverydate >= :startDate ");
			countBuffer.append(" and t.deliverydate >= '"+fhsj+" 00:00:00'");
			paramMap.put("startDate", fhsj+" 00:00:00");
		}
		if(zhi!=null && !"".equals(zhi)){
			hqlBuffer.append(" and t.deliverydate <= :endDate ");
			countBuffer.append(" and t.deliverydate <= '"+zhi+" 23:59:99'");
			paramMap.put("endDate", zhi+" 23:59:99");
		}
		if(trasportType!=null && !"".equals(trasportType)){
			hqlBuffer.append(" and t.transporttype = :trasportType");
			countBuffer.append(" and t.transporttype = '"+trasportType+"'");
			paramMap.put("trasportType", trasportType);
		}
		hqlBuffer.append(" order by t.deliverydate DESC");
		String exportParam = request.getParameter(TableTagParameters.PARAMETER_EXPORTING);
		if(exportParam!=null && !"".equals(exportParam)){//判断是否是导出
			reslist = transportRecordsMng.getAllTransportRecords(hqlBuffer.toString(), paramMap);
		}else{
			if(page==null || page.equals("") || page=="0"){
				reslist = transportRecordsMng.getTransportRecordsByPage(hqlBuffer.toString(), paramMap, 0,Constants.pagesize);
			}else{
				reslist = transportRecordsMng.getTransportRecordsByPage(hqlBuffer.toString(), paramMap, (Integer.valueOf(page)-1)*Constants.pagesize,Constants.pagesize);
			}
		}
		int resultSize = transportRecordsMng.getQueryCount(countBuffer.toString());
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

	//	model.addAttribute("tr", tr);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("qualityRecords/transportRecords/list");
	}
	@RequestMapping("/qualityRecords/transportRecords/add.html")
	public ModelAndView add(TransportRecords tr,String id, HttpServletRequest request, HttpServletResponse response, Model model){
		String method = request.getParameter("method");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		TransportRecords transportRecords=new TransportRecords();	
		String titles="运输记录新增";
		if(!method.equals("add")){	
		 titles="运输记录修改";
		 transportRecords=transportRecordsMng.findById(id);		
		//String orderno=transportRecords.getOrderno();//得到货单号
		//根据货单号查询model 
		//TransportRecordsResource transportRecordsResource=transportRecordsMng.findByIds(orderno);
		//String transporttype =transportRecordsResource.getTransporttype();
		/*if(transportRecordsResource.getTransporttype()!=null){
			if(transportRecordsResource.getTransporttype().equals("0")){
				transportRecordsResource.setTransporttype("自运");
			}else{
				transportRecordsResource.setTransporttype("承运");
			}
		}
	
		transportRecords.setTransportRecordsResource(transportRecordsResource);
		String operator=transportRecords.getOperator();
	
		User user=transportRecordsMng.findByUserId(operator);
		transportRecords.setUser(user);
	      String carrierunit=	transportRecordsResource.getCarrierunit();//得到承运单位的id 
	      TransporterQualification transporterQualification=  transportRecordsMng. findByCarrierunit(carrierunit);//得到承运单位
	      transportRecordsResource.setTransporterQualification(transporterQualification);
		*/
		
		}
		model.addAttribute("titles",titles);
		Map<String, String> qsmap=transportRecordsMng.qsMap();
		model.addAttribute("qsmap", qsmap);
		model.addAttribute("tr",transportRecords );
		model.addAttribute("method", method);	
	
			return new ModelAndView("qualityRecords/transportRecords/add");
		}
	@RequestMapping("/qualityRecords/transportRecords/saveOrUpdata.html")
	public ModelAndView saveOrUpdate(TransportRecords tr,String id, HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException{
		String op = request.getParameter("method");	
		if(!op.equals("add")){
			transportRecordsMng.saveOrUpdata(tr);
			
		}else{
			User localuser = (User) request.getSession().getAttribute(
					Constants.LOCAL_USER);
			String a=localuser.getId().toString();
			
			tr.setOperator(a);
			transportRecordsMng.saveTransportRecords(tr);
			
		
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/qualityRecords/transportRecords/del.html")
	public ModelAndView del(String ids[], HttpServletRequest request, HttpServletResponse response, Model model){
		if(ids!=null && ids.length>0){
			transportRecordsMng.del(ids);
		}
		return openFramePage(null, request, response, model);
	}
	/*
	 * 根据货单号得到货运model
	 */
	@RequestMapping("/qualityRecords/transportRecords/hgmap.html")
	public void findMp(String hgmap, HttpServletRequest request, HttpServletResponse response, Model model){
		//根据批号找合格药品库该批号药品
		TransportRecordsResource transportRecordsResource=transportRecordsMng.findByOrderno(hgmap);
		
		User localuser = (User) request.getSession().getAttribute(
				Constants.LOCAL_USER);
		String a=localuser.getId().toString();
		User user=transportRecordsMng.findByUserId(a);
		
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		JSONArray json = new JSONArray();
		if(transportRecordsResource !=null){
			String carrierunit=transportRecordsResource.getCarrierunit();//承运单位的id 
			TransporterQualification transporterQualification=transportRecordsMng.findByCarrierunit(carrierunit);
			json.put(transportRecordsResource.getDeliverydate());//发货时间
			json.put(transportRecordsResource.getDeliveryaddress());//发货地址
			json.put(transportRecordsResource.getReceivingunit());//收货单位
			json.put(transportRecordsResource.getReceivingaddress());//收货地址
			json.put(transportRecordsResource.getQuantity());//药品件数
			
			 if(transportRecordsResource.getTransporttype().equals("0")){
				 transportRecordsResource.setTransporttype("自运");
			 }else{
				 transportRecordsResource. setTransporttype("承运");
			 }
			 json.put(transportRecordsResource.getTransporttype());//运输方式
			json.put(transportRecordsResource.getPlateno());//车牌号
			json.put(user.getRealname());//经办人
			if(transporterQualification!=null){
				json.put(transporterQualification.getTransporterName());//承运单位	
			}
			
			
		}
		
	

	
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json.toString());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	@RequestMapping("/qualityRecords/transportRecords/findypboxqy.html")
	public void findypbox(HttpServletRequest request, HttpServletResponse response, Model model){
		List<TransportRecordsResource> listpu= new ArrayList<TransportRecordsResource>();
		//封装采购单json
		listpu=transportRecordsMng.findtrJsonty();
		String json = "[";
		if(listpu!=null){
			for(int i =0;i<listpu.size();i++){
				if(listpu.get(i).getOrderno()!=null && !"".equals(listpu.get(i).getOrderno())){
					json+="{";
					json+="\"id\":"+listpu.get(i).getId()+",";
					json+="\"text\":\""+listpu.get(i).getOrderno()+"\"";
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
