package com.sinosoft.comQuery.inspeAcceptRecordsJH.action;

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
import com.sinosoft.comQuery.inspeAcceptRecordsJH.model.InspeAcceptRecordsJH;
import com.sinosoft.comQuery.inspeAcceptRecordsJH.service.InspeAcceptRecordsJHMng;
import com.sinosoft.util.DisplayGetPage;

@Controller
public class InspeAcceptRecordsJHAct {
	@Autowired
	private InspeAcceptRecordsJHMng inspeAcceptRecordsJHMng;

	
	
	public void setInspeAcceptRecordsJHMng(InspeAcceptRecordsJHMng inspeAcceptRecordsJHMng) {
		this.inspeAcceptRecordsJHMng = inspeAcceptRecordsJHMng;
	}
	@RequestMapping("/comQuery/inspeAcceptRecordsJH/list.html")
	public ModelAndView openFramePage(InspeAcceptRecordsJH ir, HttpServletRequest request, HttpServletResponse response, Model model){
		
			return new ModelAndView("comQuery/inspeAcceptRecordsJH/list");
		}
      @RequestMapping("/comQuery/inspeAcceptRecordsJH/query.html")
  	public ModelAndView queryEnterpristInfoList( InspeAcceptRecordsJH ir,Model model,HttpServletRequest request,HttpServletResponse response){
    	response.setCharacterEncoding("utf-8");
		List<?> reslist=new ArrayList();
		List<InspeAcceptRecordsJH> list = new ArrayList<InspeAcceptRecordsJH>();
		String mingcheng= request.getParameter("mingcheng");
		String pihao= request.getParameter("pihao");
		String page = DisplayGetPage.getPageParamName("records", request);
		String printFlag = request.getParameter("printFlag");
		String department = request.getParameter("department");
		String isfood = request.getParameter("isfood");
		String medicineManagement = request.getParameter("medicineManagement");
		if(medicineManagement!=null && !medicineManagement.trim().equals("")){
			medicineManagement = medicineManagement.trim().equals("0") ? "中成药" : (medicineManagement.trim().equals("1") ? "专门管理要求药品" : "");
		}
		model.addAttribute("mingcheng", mingcheng);
		model.addAttribute("pihao", pihao);
		model.addAttribute("department", department);
		model.addAttribute("department", printFlag);
		model.addAttribute("isfood", isfood);
		if(medicineManagement!=null){
			model.addAttribute("medicineManagement", medicineManagement);
		}
		
		
	
		
		StringBuffer sqlBuffer = new StringBuffer(
				
				"select  n.id,q.common_name,df.form_name,q.specifications,q.license_number,"+
				" i.batch_production,i.end_time,c.name as sccs,qs.name AS gydw,"+
				" i.quantity, n.arrival_date,i.qualified_quantity,i.unqualified_amount , i.unqualified_items, "+
				"i.return_goods,n.proposer,n.check_accept_date,n.check_qualified,"+
				"i.qualified_medicine_id,i.produce_time ,q.medc_no,q.dp_id,"+
				" n.print_flag,q.is_food,'' as ysr,n.checkAcceptDate2"+
				" FROM t_check_accept_note_jh_new n "+
				" left join t_qualifiedSupplier qs on n.qualifiedSupplier_id = qs.id ,"+
//				" left join TRTHR_USER uer on n.proposer_ID = uer.USERID"+
//				" left join TRTHR_USER uer2 on n.accepterID = uer2.USERID,"+//嘉和的验收员直接写在表中，不再通过id连接用户表查询
				" t_checkaccept_item_jh_new i "+
				"  left join t_qualified_medicine q on i.qualified_medicine_id = q.id"+
				"  left join t_dosage_form df on q.dosageforms_id = df.id"+
				" left join t_qualifiedSupplier c on q.produceno_id = c.id"+
				" WHERE n.review_status=3 and  n.id=i.receiving_id ");
		
				
				sqlBuffer.append(" AND n.number NOT LIKE 'YP%' AND n.number NOT LIKE 'T%' AND i.quantity > 0 ");
				
				if(pihao!=null && !pihao.equals("")){
					sqlBuffer.append(" and i.batch_production= '");
				sqlBuffer.append(pihao+"'  ");
				}
				if(mingcheng!=null && !mingcheng.equals("")){
					sqlBuffer.append(" and q.common_name like  '%");
					   sqlBuffer.append(mingcheng+"%'  ");
				}
				if(department!=null && !"".equals(department)){
					sqlBuffer.append(" and q.dp_id ='"+department+"'" );
				}
				if(printFlag==null || "".equals(printFlag)){
					
				}else if(printFlag.equals("1")){
					sqlBuffer.append(" and n.print_flag = '1' ");
				}else {
					sqlBuffer.append(" and n.print_flag = '0' ");
				}
				if(isfood!=null && !"".equals(isfood)){
					sqlBuffer.append(" and q.is_food ='"+isfood+"'" );
				}
				if(medicineManagement!=null && !"".equals(medicineManagement)){
					sqlBuffer.append(" and q.medicineManagement = '"+medicineManagement+"' " );
				}
				
				sqlBuffer.append(" order by n.check_accept_date DESC ");
					reslist = inspeAcceptRecordsJHMng.getInspeAcceptRecordsByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
					if(reslist!=null){
						for(int i = 0;i < reslist.size();i++){
							Object[] obj = (Object[]) reslist.get(i);
							InspeAcceptRecordsJH inspeAccept =new InspeAcceptRecordsJH();	
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
						" FROM t_check_accept_note_jh_new n "+
						" left join t_qualifiedSupplier qs on n.qualifiedSupplier_id = qs.id ,"+
//						" left join TRTHR_USER uer on n.proposer_ID = uer.USERID"+
//						" left join TRTHR_USER uer2 on n.accepterID = uer2.USERID,"+
						" t_checkaccept_item_jh_new i "+
						"  left join t_qualified_medicine q on i.qualified_medicine_id = q.id"+
						"  left join t_dosage_form df on q.dosageforms_id = df.id"+
						" left join t_qualifiedSupplier c on q.produceno_id = c.id"+
						" WHERE n.review_status=3 and  n.id=i.receiving_id ");
				
				
				buffer.append(" AND n.number NOT LIKE 'YP%' AND n.number NOT LIKE 'T%' AND i.quantity > 0 ");
				
				if(pihao!=null && !pihao.equals("")){
					buffer.append(" and i.batch_production= '");
					buffer.append(pihao+"'  ");
				}
				if(mingcheng!=null && !mingcheng.equals("")){
					buffer.append(" and q.common_name like  '%");
					buffer.append(mingcheng+"%'  ");
				}
				if(department!=null && !"".equals(department)){
					buffer.append(" and q.dp_id ='"+department+"'" );
				}
				if(printFlag==null || "".equals(printFlag)){
					
				}else if(printFlag.equals("1")){
					buffer.append(" and n.print_flag = '1' ");
				}else {
					buffer.append(" and n.print_flag = '0' ");
				}
				if(isfood!=null && !"".equals(isfood)){
					buffer.append(" and q.is_food ='"+isfood+"'" );
				}
				if(medicineManagement!=null && !"".equals(medicineManagement)){
					buffer.append(" and q.medicineManagement = '"+medicineManagement+"' " );
				}
				
				int resultSize = inspeAcceptRecordsJHMng.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
				
		//页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("ir", ir);
		model.addAttribute("reslist", list);
		return new ModelAndView("comQuery/inspeAcceptRecordsJH/query");
	}
}
