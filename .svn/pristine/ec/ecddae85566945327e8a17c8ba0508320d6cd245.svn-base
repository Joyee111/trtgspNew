package com.sinosoft.comQuery.receivingRecords.action;

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
import com.sinosoft.comQuery.inspeAcceptRecords.model.InspeAcceptRecords;
import com.sinosoft.comQuery.inspeAcceptRecords.service.InspeAcceptRecordsMng;
import com.sinosoft.comQuery.receivingRecords.model.ReceivingRecords;
import com.sinosoft.comQuery.receivingRecords.service.ReceivingRecordsMng;
import com.sinosoft.util.DisplayGetPage;

@Controller
public class ReceivingRecordsAct {
	@Autowired
	private ReceivingRecordsMng receivingRecordsMng;

	
	
	public void setReceivingRecordsMng(ReceivingRecordsMng receivingRecordsMng) {
		this.receivingRecordsMng = receivingRecordsMng;
	}
	@RequestMapping("/comQuery/receivingRecords/list.html")
	public ModelAndView openFramePage(ReceivingRecords ir, HttpServletRequest request, HttpServletResponse response, Model model){
		
			return new ModelAndView("comQuery/receivingRecords/list");
		}
	

      @RequestMapping("/comQuery/receivingRecords/query.html")
  	public ModelAndView queryEnterpristInfoList( ReceivingRecords ir,Model model,HttpServletRequest request,HttpServletResponse response){
    	response.setCharacterEncoding("utf-8");
		List<?> reslist=new ArrayList();
		List<ReceivingRecords> list = new ArrayList<ReceivingRecords>();
		String mingcheng= request.getParameter("mingcheng");
		String pihao= request.getParameter("pihao");
		String page = DisplayGetPage.getPageParamName("records", request);
//		String printFlag = request.getParameter("printFlag");
		String department = request.getParameter("department");
//		String isfood = request.getParameter("isfood");
//		String medicineManagement = request.getParameter("medicineManagement");
//		if(medicineManagement!=null && !medicineManagement.trim().equals("")){
//			medicineManagement = medicineManagement.trim().equals("0") ? "中成药" : (medicineManagement.trim().equals("1") ? "专门管理要求药品" : "");
//		}
		model.addAttribute("mingcheng", mingcheng);
		model.addAttribute("pihao", pihao);
		model.addAttribute("department", department);
//		model.addAttribute("department", printFlag);
//		model.addAttribute("isfood", isfood);
//		if(medicineManagement!=null){
//			model.addAttribute("medicineManagement", medicineManagement);
//		}
		
		

		
	
		StringBuffer sqlBuffer = new StringBuffer(
				
				" select me.common_name,me.medc_no,me.medicinal_attribute,me.storageStore,"+
				" it.batch_production,it.quantity,no.received_date,no.receiving_address,"+
				" it.tkdat,it.end_time,no.check_conclusion,u.REALNAME"+
				" FROM t_qualified_medicine me,"+
				" t_receiving_note no left join TRTHR_USER u on no.user_USERID=u.USERID,"+
				" t_receiving_note_item it"+
				" WHERE no.id=it.receiving_note_id and it.qualifiedMedicine_id=me.id");
				
				if(pihao!=null && !pihao.equals("")){
					sqlBuffer.append(" and it.batch_production like '%");
				sqlBuffer.append(pihao+"%'  ");
				}
				if(mingcheng!=null && !mingcheng.equals("")){
					sqlBuffer.append(" and me.id = '");
					   sqlBuffer.append(mingcheng+"'  ");
				}
				if(department!=null && !"".equals(department)){
					sqlBuffer.append(" and me.dp_id ='"+department+"'" );
				}
//				if(printFlag==null || "".equals(printFlag)){
//					
//				}else if(printFlag.equals("1")){
//					sqlBuffer.append(" and n.print_flag = '1' ");
//				}else {
//					sqlBuffer.append(" and n.print_flag is null ");
//				}
//				if(isfood!=null && !"".equals(isfood)){
//					sqlBuffer.append(" and q.is_food ='"+isfood+"'" );
//				}
//				if(medicineManagement!=null && !"".equals(medicineManagement)){
//					sqlBuffer.append(" and q.medicineManagement = '"+medicineManagement+"' " );
//				}
				sqlBuffer.append(" and LEN(it.batch_production) > 7 ");
				sqlBuffer.append(" AND it.quantity > 0 ");
				sqlBuffer.append(" and it.qualifiedMedicine_id not in (select qme.id from t_medc_jh jh,t_qualified_medicine qme where jh.medc_no=qme.medc_no)");
				sqlBuffer.append(" order by no.id DESC ");
					reslist = receivingRecordsMng.getReceivingRecordsByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
					if(reslist!=null){
						for(int i = 0;i < reslist.size();i++){
							Object[] obj = (Object[]) reslist.get(i);
							ReceivingRecords receivingRecords =new ReceivingRecords();	
							if(obj[0]!=null){
								receivingRecords.setTongyongmc(obj[0].toString());
							}
							if(obj[1]!=null){
								receivingRecords.setHuohao(obj[1].toString());
							}
							if(obj[2]!=null){
								receivingRecords.setStorageConditions(obj[2].toString());
							}
							if(obj[3]!=null){
								receivingRecords.setStorageStore(obj[3].toString());
							}
							if(obj[4]!=null){
								receivingRecords.setBatchNumber(obj[4].toString());
							}
							if(obj[5]!=null){
								receivingRecords.setQuality(obj[5].toString());
							}
							if(obj[6]!=null){
								receivingRecords.setGoodsReceiptDate(obj[6].toString());
							}
							if(obj[7]!=null){
								receivingRecords.setReceiptAddress(obj[7].toString());
							}
							if(obj[8]!=null){
								receivingRecords.setShengchanriqi(obj[8].toString());
							}
							if(obj[9]!=null){
								receivingRecords.setYouxiaoqizhi(obj[9].toString());
							}
							if(obj[10]!=null){
								receivingRecords.setInspectionResults(obj[10].toString());
							}
							if(obj[11]!=null){
								receivingRecords.setReceiptPeople(obj[11].toString());
							}
							
							
							list.add(receivingRecords);
						}	
					}
				StringBuffer buffer=new StringBuffer(
						" select COUNT(*) " +
						" FROM t_qualified_medicine me,"+
						" t_receiving_note no left join TRTHR_USER u on no.user_USERID=u.USERID,"+
						" t_receiving_note_item it"+
						" WHERE no.id=it.receiving_note_id and it.qualifiedMedicine_id=me.id");
				
				if(pihao!=null && !pihao.equals("")){
					buffer.append(" and it.batch_production like '%");
					buffer.append(pihao+"%'  ");
				}
				if(mingcheng!=null && !mingcheng.equals("")){
					buffer.append(" and me.id = '");
					buffer.append(mingcheng+"'  ");
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
				buffer.append(" and LEN(it.batch_production) > 7 ");
				buffer.append(" AND it.quantity > 0 ");
				buffer.append(" and it.qualifiedMedicine_id not in (select qme.id from t_medc_jh jh,t_qualified_medicine qme where jh.medc_no=qme.medc_no)");

				int resultSize = receivingRecordsMng.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
				
		//页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("ir", ir);
		model.addAttribute("reslist", list);
		return new ModelAndView("comQuery/receivingRecords/query");
	}
}
