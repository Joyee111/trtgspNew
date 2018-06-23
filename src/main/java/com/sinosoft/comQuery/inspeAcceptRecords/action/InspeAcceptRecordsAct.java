package com.sinosoft.comQuery.inspeAcceptRecords.action;

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
import com.sinosoft.util.DisplayGetPage;

@Controller
public class InspeAcceptRecordsAct {
	@Autowired
	private InspeAcceptRecordsMng inspeAcceptRecordsMng;

	
	
	public void setInspeAcceptRecordsMng(InspeAcceptRecordsMng inspeAcceptRecordsMng) {
		this.inspeAcceptRecordsMng = inspeAcceptRecordsMng;
	}
	@RequestMapping("/comQuery/inspeAcceptRecords/list.html")
	public ModelAndView openFramePage(InspeAcceptRecords ir, HttpServletRequest request, HttpServletResponse response, Model model){
		
			return new ModelAndView("comQuery/inspeAcceptRecords/list");
		}
      @RequestMapping("/comQuery/inspeAcceptRecords/query.html")
  	public ModelAndView queryEnterpristInfoList( InspeAcceptRecords ir,Model model,HttpServletRequest request,HttpServletResponse response){
    	response.setCharacterEncoding("utf-8");
		List<?> reslist=new ArrayList();
		List<InspeAcceptRecords> list = new ArrayList<InspeAcceptRecords>();
		String mingcheng= request.getParameter("mingcheng");
		String pihao= request.getParameter("pihao");
		String page = DisplayGetPage.getPageParamName("records", request);
		String printFlag = request.getParameter("printFlag");
		String department = request.getParameter("department");
		String isfood = request.getParameter("isfood");
		String medicineManagement = request.getParameter("medicineManagement");
		if(medicineManagement!=null && !medicineManagement.trim().equals("")){
			medicineManagement = medicineManagement.trim().equals("0") ? "一般药品" : (medicineManagement.trim().equals("1") ? "专门管理要求药品" : "");
		}
		model.addAttribute("mingcheng", mingcheng);
		model.addAttribute("pihao", pihao);
		model.addAttribute("department", department);
		model.addAttribute("department", printFlag);
		model.addAttribute("isfood", isfood);
		if(medicineManagement!=null){
			model.addAttribute("medicineManagement", medicineManagement);
		}
		
		
//		StringBuffer sqlBuffer = new StringBuffer(
//				"select z.id,z.common_name,z.form_name ,z.specifications,z.license_number,z.batch_production,z.end_time,z.sccs ,z.gydw ,"
//						+ "z.quantity,z.arrival_date,"
//						+ " z.qualified_quantity,z.unqualified_amount,z.unqualified_items,z.return_goods ,"
//						+ " uer.REALNAME,z.check_accept_date,z.check_qualified ,z.qualified_medicine_id,z.produce_time,z.medc_no,z.dp_id,z.print_flag,z.is_food"
//						+ " FROM (select w.print_flag, w.id,w.common_name,df.form_name ,w.dosageforms_id,w.specifications,"
//						+ " w.license_number,w.produceno_id,w.proposer_ID ,w.check_accept_date ,w.qualifiedSupplier_id,w.gydw ,w.sccs ,w.arrival_date,w.end_time,"
//						+ " w.batch_production,w.qualified_medicine_id,w.quantity,w.qualified_quantity,w.unqualified_amount,"
//						+ "w.unqualified_items,w.return_goods,w.check_qualified ,w.produce_time,w.medc_no,w.dp_id,w.is_food"
//						+ " FROM (select h.print_flag, h.id,h.common_name,h.dosageforms_id,h.specifications,"
//						+ "h.license_number,h.produceno_id,"
//						+ "h.proposer_ID ,h.check_accept_date ,h.qualifiedSupplier_id,h.name as gydw,c.name as sccs,"
//						+ "h.arrival_date,h.end_time,"
//						+ "h.batch_production,h.qualified_medicine_id,h.quantity,h.qualified_quantity,"
//						+ "h.unqualified_amount,h.unqualified_items,h.return_goods,h.check_qualified ,h.produce_time,h.medc_no,h.dp_id,h.is_food"
//						+ " FROM (select o.print_flag, o.id,p.common_name,p.dosageforms_id,p.specifications,"
//						+ "p.license_number,p.produceno_id,o.proposer_ID ,"
//						+ "o.check_accept_date ,o.qualifiedSupplier_id,o.name,o.arrival_date,o.end_time,"
//						+ "o.batch_production,o.qualified_medicine_id,o.quantity,o.qualified_quantity,o.unqualified_amount,o.unqualified_items,"
//						+ "o.return_goods,o.check_qualified ,o.produce_time,p.medc_no,p.dp_id,p.is_food"
//						+ " FROM (select m.print_flag, m.id,m.proposer_ID ,m.check_accept_date ,m.qualifiedSupplier_id,q.name,m.arrival_date,m.end_time,"
//						+ "m.batch_production,m.qualified_medicine_id,m.quantity,m.qualified_quantity,m.unqualified_amount,"
//						+ "m.unqualified_items,m.return_goods,m.check_qualified ,m.produce_time"
//						+ " FROM (select n.print_flag, n.id,n.proposer_ID ,n.check_accept_date ,n.qualifiedSupplier_id,n.arrival_date,i.end_time,"
//						+ "i.batch_production,i.qualified_medicine_id,i.quantity,i.qualified_quantity,i.unqualified_amount,"
//						+ "i.unqualified_items,i.return_goods,n.check_qualified ,i.produce_time"
//						+ " FROM t_check_accept_note n"
//						+ " LEFT JOIN t_checkaccept_item i on n.id=i.receiving_id"
//						+ " WHERE n.review_status=3)m"
//						+ " LEFT JOIN t_qualifiedSupplier q on m.qualifiedSupplier_id=q.id)o"
//						+ " LEFT JOIN t_qualified_medicine p on p.id=o.qualified_medicine_id)h"
//						+ " LEFT JOIN t_qualifiedSupplier c on h.produceno_id=c.id)w"
//						+ " LEFT JOIN t_dosage_form df on w.dosageforms_id=df.id)z"
//						+ " LEFT JOIN TRTHR_USER uer on z.proposer_ID =uer.USERID"
//						+ " WHERE 1=1");
		
		
		StringBuffer sqlBuffer = new StringBuffer(
				
				"select  n.id,q.common_name,df.form_name,q.specifications,q.license_number,"+
				" i.batch_production,i.end_time,c.name as sccs,qs.name AS gydw,"+
				" i.quantity, n.arrival_date,i.qualified_quantity,i.unqualified_amount , i.unqualified_items, "+
				"i.return_goods,uer.REALNAME,n.check_accept_date,n.check_qualified,"+
				"i.qualified_medicine_id,i.produce_time ,q.medc_no,q.dp_id,"+
				" n.print_flag,q.is_food,uer2.REALNAME as ysr,n.checkAcceptDate2"+
				" FROM t_check_accept_note n "+
				" left join t_qualifiedSupplier qs on n.qualifiedSupplier_id = qs.id"+
				" left join TRTHR_USER uer on n.proposer_ID = uer.USERID"+
				" left join TRTHR_USER uer2 on n.accepterID = uer2.USERID,"+
				" t_checkaccept_item i "+
				"  left join t_qualified_medicine q on i.qualified_medicine_id = q.id"+
				"  left join t_dosage_form df on q.dosageforms_id = df.id"+
				" left join t_qualifiedSupplier c on q.produceno_id = c.id"+
				" WHERE n.review_status=3 and  n.id=i.receiving_id ");
		
				sqlBuffer.append(" AND i.qualified_medicine_id NOT IN (SELECT j.medc_id FROM dbo.t_medc_jh j) ");
				sqlBuffer.append(" AND n.number NOT LIKE 'YP%' AND n.number NOT LIKE 'T%' AND i.quantity > 0 ");
		
				if(pihao!=null && !pihao.equals("")){
					sqlBuffer.append(" and i.batch_production= '");
				sqlBuffer.append(pihao+"'  ");
				}
				if(mingcheng!=null && !mingcheng.equals("")){
					sqlBuffer.append(" and i.qualified_medicine_id = '");
					   sqlBuffer.append(mingcheng+"'  ");
				}
				if(department!=null && !"".equals(department)){
					sqlBuffer.append(" and q.dp_id ='"+department+"'" );
				}
				if(printFlag==null || "".equals(printFlag)){
					
				}else if(printFlag.equals("1")){
					sqlBuffer.append(" and n.print_flag = '1' ");
				}else {
					sqlBuffer.append(" and n.print_flag is null ");
				}
				if(isfood!=null && !"".equals(isfood)){
					sqlBuffer.append(" and q.is_food ='"+isfood+"'" );
				}
				if(medicineManagement!=null && !"".equals(medicineManagement)){
					sqlBuffer.append(" and q.medicineManagement = '"+medicineManagement+"' " );
				}
				sqlBuffer.append(" AND LEN(i.batch_production) > 7 ");
				sqlBuffer.append(" order by n.check_accept_date DESC ");
					reslist = inspeAcceptRecordsMng.getInspeAcceptRecordsByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
					if(reslist!=null){
						for(int i = 0;i < reslist.size();i++){
							Object[] obj = (Object[]) reslist.get(i);
							InspeAcceptRecords inspeAccept =new InspeAcceptRecords();	
							if(obj[0]!=null){
								inspeAccept.setCheckAcceptId(Long.valueOf(obj[0].toString()));
							}
							if(obj[1]!=null){
								inspeAccept.setTongyongmc(obj[1].toString());
							}
							if(obj[2]!=null){
								inspeAccept.setJixing(obj[2].toString());
							}
							if(obj[3]!=null){
								inspeAccept.setGuige(obj[3].toString());
							}
							if(obj[4]!=null){
								inspeAccept.setPizhunwenhao(obj[4].toString());
							}
							if(obj[5]!=null){
								inspeAccept.setShengchanph(obj[5].toString());
							}
							if(obj[6]!=null){
								inspeAccept.setYouxiaoqz(obj[6].toString());
							}
							if(obj[7]!=null){
								inspeAccept.setShengchancs(obj[7].toString());
							}
							if(obj[8]!=null){
								inspeAccept.setGonghuodw(obj[8].toString());
							}
							if(obj[9]!=null){
								inspeAccept.setShuliang(Long.valueOf (obj[9].toString()));
							}
							if(obj[10]!=null){
								inspeAccept.setDaohuorq(obj[10].toString());
							}
							if(obj[11]!=null){
								inspeAccept.setHegesl(Long.valueOf (obj[11].toString()));
							}
							if(obj[12]!=null){
								inspeAccept.setUnhgsl(obj[12].toString());
							}
							if(obj[13]!=null){
								inspeAccept.setBuhgx(obj[13].toString());
							}
							if(obj[14]!=null){
								inspeAccept.setChuzhics(obj[14].toString().trim());
							}
							if(obj[15]!=null){
								inspeAccept.setYsnshouyuan(obj[15].toString());
							}
							if(obj[16]!=null){
								inspeAccept.setYanshourq(obj[16].toString());
							}
							if(obj[17]!=null){
								inspeAccept.setYanshoujg(obj[17].toString());
							}
							if(obj[19]!=null){
								inspeAccept.setShengchanrq(obj[19].toString());
							}
							if(obj[20]!=null){
								inspeAccept.setYaopinhao(obj[20].toString());
							}
							if(obj[21]!=null ){
								if(obj[21].toString().equals("1001")){
									inspeAccept.setDepartment("经营");
								}else if(obj[21].toString().equals("2001")){
									inspeAccept.setDepartment("新品");
								}else if(obj[21].toString().equals("3001")){
									inspeAccept.setDepartment("市场");
								}
							}
							if(obj[22]!=null){
								inspeAccept.setPrintFlag(obj[22].toString());
							}else{
								inspeAccept.setPrintFlag("0");
							}
							
							
							if(obj[24]!=null){
								inspeAccept.setYsnshouyuan2(obj[24].toString());
							}
							if(obj[25]!=null){
								inspeAccept.setYanshourq2(obj[25].toString());
							}
							
							list.add(inspeAccept);
						}	
					}
				StringBuffer buffer=new StringBuffer(
						" select COUNT(*) " +
						" FROM t_check_accept_note n "+
						" left join t_qualifiedSupplier qs on n.qualifiedSupplier_id = qs.id"+
						" left join TRTHR_USER uer on n.proposer_ID = uer.USERID"+
						" left join TRTHR_USER uer2 on n.accepterID = uer2.USERID,"+
						" t_checkaccept_item i "+
						"  left join t_qualified_medicine q on i.qualified_medicine_id = q.id"+
						"  left join t_dosage_form df on q.dosageforms_id = df.id"+
						" left join t_qualifiedSupplier c on q.produceno_id = c.id"+
						" WHERE n.review_status=3 and  n.id=i.receiving_id ");
				
				buffer.append(" AND i.qualified_medicine_id NOT IN (SELECT j.medc_id FROM dbo.t_medc_jh j) ");
				buffer.append(" AND n.number NOT LIKE 'YP%' AND n.number NOT LIKE 'T%' AND i.quantity > 0 ");
				
				if(pihao!=null && !pihao.equals("")){
					buffer.append(" and i.batch_production= '");
					buffer.append(pihao+"'  ");
				}
				if(mingcheng!=null && !mingcheng.equals("")){
					buffer.append(" and i.qualified_medicine_id = '");
					buffer.append(mingcheng+"'  ");
				}
				if(department!=null && !"".equals(department)){
					buffer.append(" and q.dp_id ='"+department+"'" );
				}
				if(printFlag==null || "".equals(printFlag)){
					
				}else if(printFlag.equals("1")){
					buffer.append(" and n.print_flag = '1' ");
				}else {
					buffer.append(" and n.print_flag is null ");
				}
				if(isfood!=null && !"".equals(isfood)){
					buffer.append(" and q.is_food ='"+isfood+"'" );
				}
				if(medicineManagement!=null && !"".equals(medicineManagement)){
					buffer.append(" and q.medicineManagement = '"+medicineManagement+"' " );
				}
				buffer.append(" AND LEN(i.batch_production) > 7 ");
				int resultSize = inspeAcceptRecordsMng.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
				
		//页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("ir", ir);
		model.addAttribute("reslist", list);
		return new ModelAndView("comQuery/inspeAcceptRecords/query");
	}
}
