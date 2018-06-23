package com.sinosoft.comQuery.sampleTicketRecords.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.displaytag.tags.TableTagParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.comQuery.ReturnCheckRecords.service.ReturnCheckRecordsMng;
import com.sinosoft.comQuery.drugSaleRecords.model.DrugSaleRecords;
import com.sinosoft.comQuery.sampleTicketRecords.model.SampleTicketRecords;
import com.sinosoft.comQuery.sampleTicketRecords.service.SampleTicketRecordsMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.util.DisplayGetPage;

@Controller
public class SampleTicketRecordsAct {
	@Autowired
	private ReturnCheckRecordsMng returnCheckRecordsMng;

	public void setReturnCheckRecordsMng(ReturnCheckRecordsMng returnCheckRecordsMng) {
		this.returnCheckRecordsMng = returnCheckRecordsMng;
	}
	@Autowired
	private SampleTicketRecordsMng sampleTicketRecordsMng;

	public void setSampleTicketRecordsMng(SampleTicketRecordsMng sampleTicketRecordsMng) {
		this.sampleTicketRecordsMng = sampleTicketRecordsMng;
	}
	@RequestMapping("/comQuery/sampleTicketRecords/list.html")
	public ModelAndView openFramePage(SampleTicketRecords ds, HttpServletRequest request, HttpServletResponse response, Model model){
		
			return new ModelAndView("comQuery/sampleTicketRecords/list");
		}
	 @RequestMapping("/comQuery/sampleTicketRecords/query.html")
	  	public ModelAndView queryEnterpristInfoList( SampleTicketRecords ds,Model model,HttpServletRequest request,HttpServletResponse response){
			List<?> reslist=new ArrayList();
			List<SampleTicketRecords> list = new ArrayList<SampleTicketRecords>();
			String xiaoshoudh= request.getParameter("xiaoshoudh");
			String tuihuodanwei= request.getParameter("tuihuodanwei");
			String pihao= request.getParameter("pihao");
			String page = DisplayGetPage.getPageParamName("records", request);
			String commonName = request.getParameter("commonName");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String start_date  = "";
			String end_date = "";
			if(startDate!=null && !"".equals(startDate)){
				start_date = startDate+" 00:00:00";
			}
			if(endDate!=null && !"".equals(endDate)){
				end_date = endDate+" 23:59:59";
			}
			//Date start_date = DateTimeUtils.StringToDate(strDate)
			String deparment = request.getParameter("deparment");
			String isfood =  request.getParameter("isfood");
			model.addAttribute("deparment",deparment);
			model.addAttribute("xiaoshoudh", xiaoshoudh);
			model.addAttribute("isfood", isfood);
			
			String	name=null;
			if(tuihuodanwei!=null &&  !tuihuodanwei.equals("")){
				Long qpuId = null;
				QualifiedPurchaseUnits qualifiedPurchaseUnits = null;
				try{
					qpuId = Long.parseLong(tuihuodanwei);
					qualifiedPurchaseUnits=	returnCheckRecordsMng.findById(tuihuodanwei);
				}catch(Exception e){//如果无法转换成字符则代表是name
					qualifiedPurchaseUnits = null;
				}
				
				if(qualifiedPurchaseUnits == null){
					name = tuihuodanwei;
				}else{
					 name=qualifiedPurchaseUnits.getCustomerName();
				}
				
				model.addAttribute("tuihuodanwei", name);	
			}
			model.addAttribute("pihao", pihao);
				StringBuffer sqlBuffer = new StringBuffer(
						"select create_day,customer_name,medc_no,medc_name,medc_type_name," +
								"medc_spec,unit,sales_price,quantity,sales_amount,"+
								"batch_no,exp_date,works_no,user_name,model_no,department_id"+
						" from V_SmsToGsp_Sales_Model where 1=1  ");
				if(xiaoshoudh!=null && !xiaoshoudh.equals("")){
					sqlBuffer.append(" and  model_no like '%");
				sqlBuffer.append(xiaoshoudh+"%'  ");
				}
				if(name!=null && !name.equals("")){
					sqlBuffer.append("  and  customer_name like '%");
					sqlBuffer.append(name+"%'  ");
				}
				if(pihao!=null && !pihao.equals("")){
					sqlBuffer.append(" and batch_no like '%");
				sqlBuffer.append(pihao+"%'  ");
				}
				if(commonName!=null && !"".equals(commonName)){
					sqlBuffer.append(" and medc_name like '%"+commonName+"%'");
				}
				if(deparment!=null && !"".equals(deparment)){
					sqlBuffer.append(" and department_id ='"+deparment+"' ");
				}
//				if(isfood!=null && !"".equals(isfood)){
//					sqlBuffer.append(" and is_food ='"+isfood+"' ");
//				}
//				sqlBuffer.append(" and CONVERT(date,u.create_date,120 ) >= '2013-09-01 00:00:00'");
				if(start_date!=null && !"".equals(start_date)){
					sqlBuffer.append(" and CONVERT(date,create_day,120 ) >= CONVERT(date,'"+start_date+"',120 )");
				}
				if(end_date!=null && !"".equals(end_date)){
					sqlBuffer.append(" and CONVERT(date,create_day,120 ) <= CONVERT(date,'"+end_date+"',120 )");
				}
				sqlBuffer.append(" and len(batch_no) > 7 ");
				sqlBuffer.append(" order by create_day DESC");
					String export = request.getParameter(TableTagParameters.PARAMETER_EXPORTING);
					if(export != null && !"".equals(export)){
						reslist = sampleTicketRecordsMng.getAllSampleTicketRecordsByCondiction(sqlBuffer.toString(), new HashMap<String, Object>());
					}else{
						reslist = sampleTicketRecordsMng.getSampleTicketRecordsByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
					}

					if(reslist!=null){
						for(int i = 0;i < reslist.size();i++){
							Object[] obj = (Object[]) reslist.get(i);
							SampleTicketRecords sampleTicket=new SampleTicketRecords();	
							
							if(obj[0]!=null){
								sampleTicket.setXiaoshouriqi(obj[0].toString());
							}
							if(obj[1]!=null){
								sampleTicket.setGouhuodw(obj[1].toString());
							}
							if(obj[2]!=null){
								sampleTicket.setYaopinhao(obj[2].toString());
							}
							if(obj[3]!=null){
								sampleTicket.setMingcheng(obj[3].toString());
							}
							if(obj[4]!=null){
								sampleTicket.setJixing(obj[4].toString());
							}
							if(obj[5]!=null){
								sampleTicket.setGuige(obj[5].toString());
							}
							if(obj[6]!=null){
								sampleTicket.setDanwei(obj[6].toString());
							}
							if(obj[7]!=null){
								sampleTicket.setJiage(obj[7].toString());
							}
							if(obj[8]!=null){
								sampleTicket.setShuliang(obj[8].toString());
							}
							if(obj[9]!=null){
								sampleTicket.setJine(obj[9].toString());
							}
							if(obj[10]!=null){
								sampleTicket.setPihao(obj[10].toString());
							}
							if(obj[11]!=null){
								sampleTicket.setYouxiaoqi(obj[11].toString());
							}
							if(obj[12]!=null){
								sampleTicket.setShengchancs(obj[12].toString());
							}
							if(obj[13]!=null){
								sampleTicket.setXiaoshouyuan(obj[13].toString());
							}
							if(obj[14]!=null){
								sampleTicket.setSaleItemNumber(obj[14].toString());
							}
							if(obj[15]!=null){
								sampleTicket.setDepartment(obj[15].toString());
							}
							list.add(sampleTicket);
						}	
					}
					StringBuffer buffer = new StringBuffer(
							"select  count(*) " +
							" from V_SmsToGsp_Sales_Model where 1=1");
					

					if(xiaoshoudh!=null && !xiaoshoudh.equals("")){
						buffer.append(" and  model_no like '%");
						buffer.append(xiaoshoudh+"%'  ");
					}
					if(name!=null && !name.equals("")){
						buffer.append("  and  customer_name like '%");
						buffer.append(name+"%'  ");
					}
					if(pihao!=null && !pihao.equals("")){
						buffer.append(" and batch_no like '%");
						buffer.append(pihao+"%'  ");
					}
					if(commonName!=null && !"".equals(commonName)){
						buffer.append(" and medc_name like '%"+commonName+"%'");
					}
					if(deparment!=null && !"".equals(deparment)){
						buffer.append(" and department_id ='"+deparment+"' ");
					}
//					if(isfood!=null && !"".equals(isfood)){
//						buffer.append(" and u.is_food ='"+isfood+"' ");
//					}
//					buffer.append(" and CONVERT(date,u.create_date,120 ) >= '2013-09-01 00:00:00'");
					if(start_date!=null && !"".equals(start_date)){
						buffer.append(" and CONVERT(date,create_day,120 ) >= CONVERT(date,'"+start_date+"',120 )");
					}
					if(end_date!=null && !"".equals(end_date)){
						buffer.append(" and CONVERT(date,create_day,120 ) <= CONVERT(date,'"+end_date+"',120 )");
					}
					buffer.append(" and len(batch_no) > 7 ");
					int resultSize = sampleTicketRecordsMng.getQueryCount(buffer.toString());
					double size = resultSize;
					model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
					model.addAttribute("resultSize", resultSize);
					
			//页数

			model.addAttribute("thispage", Integer.parseInt(page));
			model.addAttribute("pageSize", Constants.pagesize);

			model.addAttribute("ds", ds);
			model.addAttribute("reslist", list);
			return new ModelAndView("comQuery/sampleTicketRecords/query");
		}
}