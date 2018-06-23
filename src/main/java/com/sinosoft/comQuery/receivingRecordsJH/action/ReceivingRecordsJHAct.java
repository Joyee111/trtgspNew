package com.sinosoft.comQuery.receivingRecordsJH.action;

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
import com.sinosoft.comQuery.receivingRecords.model.ReceivingRecords;
import com.sinosoft.comQuery.receivingRecords.service.ReceivingRecordsMng;
import com.sinosoft.comQuery.receivingRecordsJH.model.ReceivingRecordsJH;
import com.sinosoft.comQuery.receivingRecordsJH.service.ReceivingRecordsJHMng;
import com.sinosoft.util.DisplayGetPage;

@Controller
public class ReceivingRecordsJHAct {
	@Autowired
	private ReceivingRecordsJHMng receivingRecordsJHMng;
	
	public void setReceivingRecordsJHMng(ReceivingRecordsJHMng receivingRecordsJHMng) {
		this.receivingRecordsJHMng = receivingRecordsJHMng;
	}
	@RequestMapping("/comQuery/receivingRecordsJH/list.html")
	public ModelAndView openFramePage(ReceivingRecordsJH ir, HttpServletRequest request, HttpServletResponse response, Model model){
		
			return new ModelAndView("comQuery/receivingRecordsJH/list");
		}
	
	                    
      @RequestMapping("/comQuery/receivingRecordsJH/query.html")
  	public ModelAndView queryEnterpristInfoList( ReceivingRecordsJH ir,Model model,HttpServletRequest request,HttpServletResponse response){
    	response.setCharacterEncoding("utf-8");
		List<?> reslist=new ArrayList();
		List<ReceivingRecordsJH> list = new ArrayList<ReceivingRecordsJH>();
		String mingcheng= request.getParameter("mingcheng");
		String pihao= request.getParameter("pihao");
		String page = DisplayGetPage.getPageParamName("records", request);
		String department = request.getParameter("department");
		model.addAttribute("mingcheng", mingcheng);
		model.addAttribute("pihao", pihao);
		model.addAttribute("department", department);
		
		

		
		
		StringBuffer sqlBuffer = new StringBuffer(
				
				" select me.common_name,me.medc_no,me.medicinal_attribute,me.storageStore,"+
				" it.batch_production,it.quantity,no.received_date,no.receiving_address,"+
				" it.tkdat,it.end_time,no.check_conclusion,no.goods_clerk"+
				" FROM t_qualified_medicine me,"+
				" t_receiving_note_jh_new no ,"+
				" t_receiving_note_item_jh_new it"+
				" WHERE no.id=it.receiving_note_id and it.qualifiedMedicine_id=me.id");
				
				if(pihao!=null && !pihao.equals("")){
					sqlBuffer.append(" and it.batch_production like '%");
				sqlBuffer.append(pihao+"%'  ");
				}
				if(mingcheng!=null && !mingcheng.equals("")){
					sqlBuffer.append(" and me.common_name like '%");
					   sqlBuffer.append(mingcheng+"%'  ");
				}
				if(department!=null && !"".equals(department)){
					sqlBuffer.append(" and me.dp_id ='"+department+"'" );
				}
				sqlBuffer.append(" AND it.quantity > 0 ");
				
				sqlBuffer.append(" order by no.received_date DESC ");
					reslist = receivingRecordsJHMng.getReceivingRecordsJHByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
					if(reslist!=null){
						for(int i = 0;i < reslist.size();i++){
							Object[] obj = (Object[]) reslist.get(i);
							ReceivingRecordsJH receivingRecordsJH =new ReceivingRecordsJH();	
							if(obj[0]!=null){
								receivingRecordsJH.setTongyongmc(obj[0].toString());
							}
							if(obj[1]!=null){
								receivingRecordsJH.setHuohao(obj[1].toString());
							}
							if(obj[2]!=null){
								receivingRecordsJH.setStorageConditions(obj[2].toString());
							}
							if(obj[3]!=null){
								receivingRecordsJH.setStorageStore(obj[3].toString());
							}
							if(obj[4]!=null){
								receivingRecordsJH.setBatchNumber(obj[4].toString());
							}
							if(obj[5]!=null){
								receivingRecordsJH.setQuality(obj[5].toString());
							}
							if(obj[6]!=null){
								receivingRecordsJH.setGoodsReceiptDate(obj[6].toString());
							}
							if(obj[7]!=null){
								receivingRecordsJH.setReceiptAddress(obj[7].toString());
							}
							if(obj[8]!=null){
								receivingRecordsJH.setShengchanriqi(obj[8].toString());
							}
							if(obj[9]!=null){
								receivingRecordsJH.setYouxiaoqizhi(obj[9].toString());
							}
							if(obj[10]!=null){
								receivingRecordsJH.setInspectionResults(obj[10].toString());
							}
							if(obj[11]!=null){
								receivingRecordsJH.setReceiptPeople(obj[11].toString());
							}
							
							
							list.add(receivingRecordsJH);
						}	
					}
				StringBuffer buffer=new StringBuffer(
						" select COUNT(*) " +
						" FROM t_qualified_medicine me,"+
						" t_receiving_note_jh_new no ,"+
						" t_receiving_note_item_jh_new it"+
						" WHERE no.id=it.receiving_note_id and it.qualifiedMedicine_id=me.id");
				
				if(pihao!=null && !pihao.equals("")){
					buffer.append(" and it.batch_production like '%");
					buffer.append(pihao+"%'  ");
				}
				if(mingcheng!=null && !mingcheng.equals("")){
					buffer.append(" and me.common_name like '%");
					buffer.append(mingcheng+"%'  ");
				}
				if(department!=null && !"".equals(department)){
					buffer.append(" and me.dp_id ='"+department+"'" );
				}
//				if(printFlag==null || "".equals(printFlag)){
//					
//				}else if(printFlag.equals("1")){
//					buffer.append(" and n.print_flag = '1' ");
//				}else {
//					buffer.append(" and n.print_flag is null ");
//				}
//				if(isfood!=null && !"".equals(isfood)){
//					buffer.append(" and q.is_food ='"+isfood+"'" );
//				}
//				if(medicineManagement!=null && !"".equals(medicineManagement)){
//					buffer.append(" and q.medicineManagement = '"+medicineManagement+"' " );
//				}
				buffer.append(" AND it.quantity > 0 ");
				

				int resultSize = receivingRecordsJHMng.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
				
		//页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("ir", ir);
		model.addAttribute("reslist", list);
		return new ModelAndView("comQuery/receivingRecordsJH/query");
	}
}
