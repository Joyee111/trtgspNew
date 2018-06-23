package com.sinosoft.comQuery.conserveAcceptRecords.action;

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
import com.sinosoft.comQuery.conserveAcceptRecords.model.ConserveAcceptRecords;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
import com.sinosoft.qualityRecords.drugMaintenance.serivice.DrugMaintenanceMng;
import com.sinosoft.util.DisplayGetPage;

@Controller
public class ConserveAcceptRecordsAct {

	private DrugMaintenanceMng drugMaintenanceMng;
	@Autowired
	public void setDrugMaintenanceMng(DrugMaintenanceMng drugMaintenanceMng) {
		this.drugMaintenanceMng = drugMaintenanceMng;
	}
	@RequestMapping("/comQuery/conserveAcceptRecords/list.html")
	public ModelAndView openFramePage(DrugMaintenance dm, HttpServletRequest request, HttpServletResponse response, Model model){
		
			return new ModelAndView("comQuery/conserveAcceptRecords/list");
		}
	
	@RequestMapping("/comQuery/conserveAcceptRecords/query.html")
	  	public ModelAndView queryEnterpristInfoList( DrugMaintenance dm,Model model,HttpServletRequest request,HttpServletResponse response){
			List<?> reslist=new ArrayList();
			List<ConserveAcceptRecords> list = new ArrayList<ConserveAcceptRecords>();
			String jianchariqi= request.getParameter("jianchariqi");
			String zhi= request.getParameter("zhi");
			String pihao= request.getParameter("pihao");
			String mingcheng= request.getParameter("mingcheng");
			String department = request.getParameter("department");
			String page = DisplayGetPage.getPageParamName("records", request);
			model.addAttribute("jianchariqi", jianchariqi);
			model.addAttribute("zhi", zhi);
			model.addAttribute("mingcheng", mingcheng);
			model.addAttribute("pihao", pihao);
			model.addAttribute("department", department);
			if(page==null){
				//如果page等于空，默认从第一条开始查询	
				reslist= drugMaintenanceMng.getPage(dm,0,Constants.pagesize);	
			}else{
					StringBuffer sqlBuffer = new StringBuffer("select  d  from DrugMaintenance  d ,QualifiedmedcstoreRe m, QualityMidicine q  " +
							" where  d.qualifiedmedicineid = m.qualifiedmedicineid  and m.qualifiedmedicineid= q.id  and d.batchnumber = m.batchproduction ");
					
					sqlBuffer.append(" and q.medicinalNo not in (select medicNo from  QualifiedMedcJH ) ");
					
					if(jianchariqi!=null && !jianchariqi.equals("")){
						sqlBuffer.append(" and  CONVERT(datetime,d.maintaindate,20)  >=CONVERT(datetime,'"+jianchariqi+"',20) ");
						
					}
					if(zhi!=null && !zhi.equals("")){
						sqlBuffer.append(" and  CONVERT(datetime,d.maintaindate,20) <=CONVERT(datetime,'"+zhi+"',20) ");
						
					}
					if(mingcheng!=null && !mingcheng.equals("")){
						sqlBuffer.append(" and d.qualifiedmedicineid ='"+mingcheng+"' ");
					
					}
					if(pihao!=null && !pihao.equals("")){
						sqlBuffer.append(" and m.batchproduction ='"+pihao+"' ");
					
					}
					if(department!=null && !department.equals("")){
						sqlBuffer.append(" and q.departmentId ='"+department+"' ");
					}
					sqlBuffer.append(" and LEN(d.batchnumber) > 7");
					sqlBuffer.append(" order by d.maintaindate,d.id DESC ");
					if(page==null){
						reslist= drugMaintenanceMng.getPage(dm,0,Constants.pagesize);
					}else{
						reslist = drugMaintenanceMng.getDrugMaintenanceByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
					}
				
					StringBuffer buffer=new StringBuffer(" SELECT  count(*) FROM t_maintain_info d ,  t_qualified_medicine q ,t_qualified_medc_store_re m" +
							"  where  d.qualified_medicine_id =m.qualified_medicine_id and m.qualified_medicine_id=q.id and d.batch_numbe = m.batch_production ");
					
					buffer.append(" and q.medc_no not in (select medc_no from  t_medc_jh ) ");
					
					if(jianchariqi!=null && !jianchariqi.equals("")){
						buffer.append(" and  CONVERT(datetime,d.maintain_date, 20)  >=CONVERT(datetime,'"+jianchariqi+"', 20) ");
						
					}
					if(zhi!=null && !zhi.equals("")){
						buffer.append(" and  CONVERT(datetime,d.maintain_date, 20) <=CONVERT(datetime,'"+zhi+"', 20) ");
						
					}
					if(mingcheng!=null && !mingcheng.equals("")){
						buffer.append(" and d.qualified_medicine_id ='"+mingcheng+"' ");
					
					}
					if(pihao!=null && !pihao.equals("")){
						buffer.append(" and m.batch_production ='"+pihao+"' ");
					
					}
					if(department!=null && !department.equals("")){
						buffer.append(" and q.dp_id ='"+department+"' ");
					}
					buffer.append(" and LEN(d.batch_numbe) > 7");
					int resultSize = drugMaintenanceMng.getQueryCount(buffer.toString());
					double size = resultSize;
					model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
					model.addAttribute("resultSize", resultSize);
					
				}
			

			
			//页数

			model.addAttribute("thispage", Integer.parseInt(page));
			model.addAttribute("pageSize", Constants.pagesize);

			model.addAttribute("dm", dm);
			model.addAttribute("reslist", reslist);
			return new ModelAndView("comQuery/conserveAcceptRecords/query");
		}
} 
