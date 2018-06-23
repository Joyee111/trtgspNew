package com.sinosoft.comQuery.retrunReceiptRecords.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.comQuery.retrunReceiptRecords.model.ReturnReceiptRecords;
import com.sinosoft.comQuery.retrunReceiptRecords.service.ReturnReceiptRecordsMng;
import com.sinosoft.util.DisplayGetPage;

@Controller
public class ReturnReceiptRecordsAct {
	@Autowired
	private ReturnReceiptRecordsMng returnReceiptRecordsMng;

	
	
	public void setReturnReceiptRecordsMng(ReturnReceiptRecordsMng returnReceiptRecordsMng) {
		this.returnReceiptRecordsMng = returnReceiptRecordsMng;
	}
	@RequestMapping("/comQuery/returnReceiptRecords/list.html")
	public ModelAndView openFramePage(ReturnReceiptRecords ir, HttpServletRequest request, HttpServletResponse response, Model model){
		
			return new ModelAndView("comQuery/returnReceiptRecords/list");
		}
	

      @RequestMapping("/comQuery/returnReceiptRecords/query.html")
  	public ModelAndView queryEnterpristInfoList(ReturnReceiptRecords ir,Model model,HttpServletRequest request,HttpServletResponse response){
    	response.setCharacterEncoding("utf-8");
		List<?> reslist=new ArrayList();
		List<ReturnReceiptRecords> list = new ArrayList<ReturnReceiptRecords>();
		String yhDate = request.getParameter("yhDate");//退货日期
		String commonName = request.getParameter("commonName");//通用名称
		String xiaoshoudanhao = request.getParameter("xiaoshoudanhao");//销售单号

		String page = DisplayGetPage.getPageParamName("records", request);

		model.addAttribute("yhDate", yhDate);
		model.addAttribute("commonName", commonName);
		model.addAttribute("xiaoshoudanhao", xiaoshoudanhao);
		
		

		
		
		StringBuffer sqlBuffer = new StringBuffer(
				
				"select  no.number,no.sale_no,me.common_name,me.medc_no,it.batch_production,un.customer_name,"+
				" it.quantity,no.deliveryDate,it.end_time,no.return_reason,u.REALNAME"+
				" FROM t_qualified_medicine me,t_qualified_purchase_units un, "+
				" t_return_receiving_note no left join TRTHR_USER u on no.user_USERID=u.USERID,"+
				" t_return_receiving_note_item it"+
				" WHERE it.receiving_note_id=no.id and no.qualified_purchase_units_id=un.id and it.qualified_medicine_id=me.id ");
				
				if(yhDate!=null && !yhDate.equals("")){
					sqlBuffer.append(" and no.deliveryDate= '");
				sqlBuffer.append(yhDate+"'  ");
				}
				if(commonName!=null && !commonName.equals("")){
					sqlBuffer.append(" and me.common_name like '%");
					   sqlBuffer.append(commonName+"%'  ");
				}
				if(xiaoshoudanhao!=null && !"".equals(xiaoshoudanhao)){
					sqlBuffer.append(" and no.sale_no like '%"+xiaoshoudanhao+"%'" );
				}
				sqlBuffer.append(" and len(it.batch_production) > 7 ");
				sqlBuffer.append(" order by no.id DESC ");
					reslist = returnReceiptRecordsMng.getReturnReceiptRecordsByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
					if(reslist!=null){
						for(int i = 0;i < reslist.size();i++){
							Object[] obj = (Object[]) reslist.get(i);
							ReturnReceiptRecords returnReceiptRecords =new ReturnReceiptRecords();	
							if(obj[0]!=null){
								returnReceiptRecords.setNumber(obj[0].toString());
							}
							if(obj[1]!=null){
								returnReceiptRecords.setSalesNum(obj[1].toString());
							}
							if(obj[2]!=null){
								returnReceiptRecords.setCommonName(obj[2].toString());
							}
							if(obj[3]!=null){
								returnReceiptRecords.setMedc_no(obj[3].toString());
							}
							if(obj[4]!=null){
								returnReceiptRecords.setBatchProduction(obj[4].toString());
							}
							if(obj[5]!=null){
								returnReceiptRecords.setCustomerName(obj[5].toString());
							}
							if(obj[6]!=null){
								returnReceiptRecords.setQuantity(obj[6].toString());
							}
							if(obj[7]!=null){
								returnReceiptRecords.setArrivalDate(obj[7].toString());
							}
							if(obj[8]!=null){
								returnReceiptRecords.setEnddate(obj[8].toString());
							}
							if(obj[9]!=null){
								returnReceiptRecords.setCheckConclusion(obj[9].toString());
							}
							if(obj[10]!=null){
								returnReceiptRecords.setGoodsClerk(obj[10].toString());
							}
							
							
							
							list.add(returnReceiptRecords);
						}	
					}
				StringBuffer buffer=new StringBuffer(
						" select COUNT(*) " +
						" FROM t_qualified_medicine me,t_qualified_purchase_units un, "+
						" t_return_receiving_note no left join TRTHR_USER u on no.user_USERID=u.USERID,"+
						" t_return_receiving_note_item it"+
						" WHERE it.receiving_note_id=no.id and no.qualified_purchase_units_id=un.id and it.qualified_medicine_id=me.id ");
				
				if(yhDate!=null && !yhDate.equals("")){
					buffer.append(" and no.deliveryDate= '");
					buffer.append(yhDate+"'  ");
				}
				if(commonName!=null && !commonName.equals("")){
					buffer.append(" and me.common_name like '%");
					buffer.append(commonName+"%'  ");
				}
				if(xiaoshoudanhao!=null && !"".equals(xiaoshoudanhao)){
					buffer.append(" and no.sale_no like '%"+xiaoshoudanhao+"%'" );
				}			
				buffer.append(" and len(it.batch_production) > 7 ");
				int resultSize = returnReceiptRecordsMng.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
				
		//页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("ir", ir);
		model.addAttribute("reslist", list);
		return new ModelAndView("comQuery/returnReceiptRecords/query");
	}
}
