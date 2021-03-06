package com.sinosoft.comQuery.drugProcureRecords.action;

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
import com.sinosoft.comQuery.drugProcureRecords.model.DrugProcureRecords;
import com.sinosoft.comQuery.drugProcureRecords.serivice.DrugProcureRecordsMng;

import com.sinosoft.util.DisplayGetPage;

@Controller
public class DrugProcureRecordsAct {
	@Autowired
	private  DrugProcureRecordsMng drugProcureRecordsMng;

	public void setDrugProcureRecordsMng(DrugProcureRecordsMng drugProcureRecordsMng) {
		this.drugProcureRecordsMng = drugProcureRecordsMng;
	}
	@RequestMapping("/comQuery/drugProcureRecords/list.html")
	public ModelAndView openFramePage(DrugProcureRecords dp, HttpServletRequest request, HttpServletResponse response, Model model){
		
			return new ModelAndView("comQuery/drugProcureRecords/list");
		}
      @RequestMapping("/comQuery/drugProcureRecords/query.html")
  	public ModelAndView queryEnterpristInfoList( DrugProcureRecords dp,Model model,HttpServletRequest request,HttpServletResponse response){
		List<?> reslist=new ArrayList();
		List<DrugProcureRecords> list = new ArrayList<DrugProcureRecords>();
		String gouriqi= request.getParameter("gouriqi");
		String caigoudh= request.getParameter("caigoudh");
		String pihao= request.getParameter("pihao");
		String zhi= request.getParameter("zhi");
		String page = DisplayGetPage.getPageParamName("records", request);
		String department = request.getParameter("department");
		String commonName = request.getParameter("commonName");
		String useFalg = request.getParameter("useFlag");
		String isfood = request.getParameter("isfood");
		String medcNo=request.getParameter("medcNo");
		model.addAttribute("gouriqi", gouriqi);
		model.addAttribute("caigoudh", caigoudh);
		model.addAttribute("pihao", pihao);
		model.addAttribute("zhi", zhi);
		model.addAttribute("commonName", commonName);
		model.addAttribute("department", department);
		model.addAttribute("useFlag", useFalg);
		model.addAttribute("isfood", isfood);
		model.addAttribute("medcNo",medcNo);
	
				StringBuffer sqlBuffer = new StringBuffer("  select u.number,u.modify_date,u.name1,u.medc_no,u.common_name,u.form_name,u.specifications,u.unit," +
						" u.tax_price,u.quantity,u.produce_no,u.name2,u.batch_production,u.end_time,uer.REALNAME,u.department_id,u.use_flag,u.is_food,u.actual_received_quantity from " +
						" ( select d.number,d.modify_date,d.qualifiedSupplierId_id ,d.modifier,d.name1, d.qualified_medicine_id,d.quantity, d. name2 ," +
						" d.produce_no,d.batch_production,d.end_time,d.dosageforms_id ,d.medc_no,d.common_name,d.specifications," +
						" d.unit,df.form_name ,d.tax_price,d.department_id,d.use_flag,d.is_food,d.actual_received_quantity from " +
						" (select h.number, h.modify_date,h.qualifiedSupplierId_id ,h.modifier,h.name1, " +
						" h.qualified_medicine_id,h.quantity, h. name2 ,h.produce_no,h.batch_production,h.end_time,p.dosageforms_id ," +
						" p.medc_no,p.common_name,p.specifications,p.unit ,h.tax_price ,h.department_id,h.use_flag,p.is_food,h.actual_received_quantity from " +
						" ( select n.number, n.modify_date,n.qualifiedSupplierId_id ,n.modifier,n.name as name1, " +
						" n.qualified_medicine_id,n.quantity, c.name as name2 ,n.produce_no,n.batch_production,n.end_time ,n.tax_price,n.department_id,n.use_flag,n.actual_received_quantity from " +
						" (select m.number, m.modify_date,m.qualifiedSupplierId_id ,m.modifier,q.name,m.qualified_medicine_id,m.quantity," +
						" m.produce_no, m.batch_production,m.end_time ,m.tax_price,m.department_id,m.use_flag,m.actual_received_quantity from " +
						" (select t.use_flag, t.department_id, t.number, t.modify_date,t.qualifiedSupplierId_id ,t.modifier,i.qualified_medicine_id,i.quantity,i.produce_no,i.batch_production, " +
						" i.end_time,i.tax_price,i.actual_received_quantity from t_purchase_order t " +
						" left join t_purchase_order_item i " +
						//" on t.id=i.purchase_order_id where t.status='2' and LEN(i.batch_production) > 7) m" +
						" on t.id=i.purchase_order_id where t.status='2' and t.use_flag='0') m" +
						" left join t_qualifiedSupplier q " +
						"  on m.qualifiedSupplierId_id=q.id )n" +
						" left join t_qualifiedSupplier c" +
						" on c.id=n.produce_no)h" +
						" left join  t_qualified_medicine  p" +
						"  on p.id=h.qualified_medicine_id)d" +
						" left join t_dosage_form df" +
						" on df.id=d.dosageforms_id)u" +
						" left join TRTHR_USER uer" +
						"  on u.modifier=uer.USERID  where 1=1");
				if(gouriqi!=null && !gouriqi.equals("")){
					sqlBuffer.append(" and CONVERT(datetime,u.modify_date,20) >= CONVERT(datetime,'"+gouriqi+"',20) ");

				}
				if(zhi!=null && !zhi.equals("")){
					sqlBuffer.append(" and  CONVERT(datetime,u.modify_date,20) <= CONVERT(datetime,'"+zhi+"',20) ");

				}
				if(caigoudh!=null && !caigoudh.equals("")){
					sqlBuffer.append(" and u.number like '%");
				sqlBuffer.append(caigoudh+"%'  ");
				}
				if(pihao!=null && !pihao.equals("")){
					sqlBuffer.append(" and u.batch_production like  '%");
					sqlBuffer.append(pihao+"%'  ");
				}
				if(department!=null && !"".equals(department)){
					sqlBuffer.append(" and u.department_id ='"+department+"' ");
				}
				if(commonName!=null && !"".equals(commonName)){
					sqlBuffer.append(" and u.common_name like '"+commonName+"' ");
				}
				if(useFalg != null && !"".equals(useFalg)){
					sqlBuffer.append(" and u.use_flag ='"+useFalg+"' ");
				}
				if(isfood != null && !"".equals(isfood)){
					sqlBuffer.append(" and u.is_food ='"+isfood+"' ");
				}
				if(medcNo !=null && !"".equals(medcNo.trim())){
					sqlBuffer.append(" and u.medc_no='"+medcNo.trim()+"' ");
				}
				sqlBuffer.append(" order by u.modify_date DESC ");
					reslist = drugProcureRecordsMng.getDrugProcureRecordsByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
					String export = request.getParameter(TableTagParameters.PARAMETER_EXPORTING);
	  				if(export!=null && !"".equals(export.trim())){
	  					reslist = drugProcureRecordsMng.getAllDrugProcureRecords(sqlBuffer.toString(), new HashMap<String, Object>());
	  				}
					if(reslist!=null){
						for(int i = 0;i < reslist.size();i++){
							Object[] obj = (Object[]) reslist.get(i);
							DrugProcureRecords rugProcure =new DrugProcureRecords();
							if(obj[0]!=null){
								rugProcure.setCaigoudh(obj[0].toString());
							}
							if(obj[1]!=null){
								rugProcure.setGouriqi(obj[1].toString());
							}
							if(obj[2]!=null){
								rugProcure.setGonghuodw(obj[2].toString());
							}
							if(obj[3]!=null){
								rugProcure.setYopinbh(obj[3].toString());
							}
							if(obj[4]!=null){
								rugProcure.setTongyongmc(obj[4].toString());
							}
							if(obj[5]!=null){
								rugProcure.setJixing(obj[5].toString());
							}
							if(obj[6]!=null){
								rugProcure.setGuige(obj[6].toString());
							}
							if(obj[7]!=null){
								rugProcure.setDanwei(obj[7].toString());
							}
							if(obj[8]!=null){
								rugProcure.setGoujinjg(obj[8].toString());
							}
							if(obj[9]!=null){
								rugProcure.setGoujinsl(Long.valueOf (obj[9].toString()));
							}
							if(obj[18]!=null){
								rugProcure.setActualReceivedQuantity(Long.valueOf(obj[18].toString()));
							}
							if(obj[12]!=null){
								rugProcure.setPihao(obj[12].toString());
							}
							if(obj[11]!=null){
								rugProcure.setShengchancs(obj[11].toString());
							}
							if(obj[13]!=null){
								rugProcure.setYouxiaoqi(obj[13].toString());
							}
							if(obj[14]!=null){
								rugProcure.setCaigouyuan(obj[14].toString());
							}
							if(obj[15]==null || "".equals(obj[15].toString())){
								rugProcure.setDepartmentId("");
							} else if(obj[15].toString().equals("1001")){
								rugProcure.setDepartmentId("经营");
							}else if( obj[15].toString().equals("2001")){
								rugProcure.setDepartmentId("新品");
							}else if( obj[15].toString().equals("3001")){
								rugProcure.setDepartmentId("市场");
							}
							
							
//						aidCenterDistSum.setEareName((String)temp[1]);
//						aidCenterDistSum.setAidCenterNum((Integer)temp[2]);
//						aidCenterDistSum.setStaffNum((Integer)temp[3]);
//						aidCenterDistSum.setTechStaffNum((Integer)temp[4]);
//						aidCenterDistSum.setExpertNum((Integer)temp[5]);
							
							list.add(rugProcure);
						}	
					}
					StringBuffer buffer = new StringBuffer("  select count(*) from " +
							" ( select d.number,d.modify_date,d.qualifiedSupplierId_id ,d.modifier,d.name1, d.qualified_medicine_id,d.quantity, d. name2 ," +
							" d.produce_no,d.batch_production,d.end_time,d.dosageforms_id ,d.medc_no,d.common_name,d.specifications," +
							" d.unit,df.form_name ,d.tax_price,d.department_id,d.use_flag,d.is_food,d.actual_received_quantity from " +
							" (select h.number, h.modify_date,h.qualifiedSupplierId_id ,h.modifier,h.name1, " +
							" h.qualified_medicine_id,h.quantity, h. name2 ,h.produce_no,h.batch_production,h.end_time,p.dosageforms_id ," +
							" p.medc_no,p.common_name,p.specifications,p.unit ,h.tax_price ,h.department_id,h.use_flag,p.is_food,h.actual_received_quantity from " +
							" ( select n.number, n.modify_date,n.qualifiedSupplierId_id ,n.modifier,n.name as name1, " +
							" n.qualified_medicine_id,n.quantity, c.name as name2 ,n.produce_no,n.batch_production,n.end_time ,n.tax_price,n.department_id,n.use_flag,n.actual_received_quantity from " +
							" (select m.number, m.modify_date,m.qualifiedSupplierId_id ,m.modifier,q.name,m.qualified_medicine_id,m.quantity," +
							" m.produce_no, m.batch_production,m.end_time ,m.tax_price,m.department_id,m.use_flag,m.actual_received_quantity from " +
							" (select t.use_flag, t.department_id, t.number, t.modify_date,t.qualifiedSupplierId_id ,t.modifier,i.qualified_medicine_id,i.quantity,i.produce_no,i.batch_production, " +
							" i.end_time,i.tax_price,i.actual_received_quantity from t_purchase_order t " +
							" left join t_purchase_order_item i " +
							//" on t.id=i.purchase_order_id where t.status='2' and LEN(i.batch_production) > 7) m" +
							" on t.id=i.purchase_order_id where t.status='2' and t.use_flag='0') m" +
							" left join t_qualifiedSupplier q " +
							"  on m.qualifiedSupplierId_id=q.id )n" +
							" left join t_qualifiedSupplier c" +
							" on c.id=n.produce_no)h" +
							" left join  t_qualified_medicine  p" +
							"  on p.id=h.qualified_medicine_id)d" +
							" left join t_dosage_form df" +
							" on df.id=d.dosageforms_id)u" +
							" left join TRTHR_USER uer" +
							"  on u.modifier=uer.USERID  where 1=1");
					
					buffer.append(" and u.quantity > 0 ");

				if(gouriqi!=null && !gouriqi.equals("")){
					buffer.append(" and CONVERT(datetime,u.modify_date,20) >= CONVERT(datetime,'"+gouriqi+"',20) ");

				}
				if(zhi!=null && !zhi.equals("")){
					buffer.append(" and  CONVERT(datetime,u.modify_date,20) <= CONVERT(datetime,'"+zhi+"',20) ");

				}
				if(caigoudh!=null && !caigoudh.equals("")){
					buffer.append(" and u.number like '%");
					buffer.append(caigoudh+"%'  ");
				}
				if(pihao!=null && !pihao.equals("")){
					buffer.append(" and u.batch_production like  '%");
					buffer.append(pihao+"%'  ");
				}
				if(department!=null && !"".equals(department)){
					buffer.append(" and u.department_id ='"+department+"' ");
				}
				if(commonName!=null && !"".equals(commonName)){
					buffer.append(" and u.common_name like '%"+commonName+"' ");
				}
				if(useFalg != null && !"".equals(useFalg)){
					buffer.append(" and u.use_flag = '"+useFalg+"'");
				}
				if(isfood != null && !"".equals(isfood)){
					buffer.append(" and u.is_food ='"+isfood+"' ");
				}
				if(medcNo !=null && !"".equals(medcNo.trim())){
					buffer.append(" and u.medc_no='"+medcNo.trim()+"' ");
				}
				int resultSize = drugProcureRecordsMng.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
				
		//页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("dp", dp);
		model.addAttribute("reslist", list);
		return new ModelAndView("comQuery/drugProcureRecords/query");
	}
      @RequestMapping("/comQuery/drugProcureRecords/exportQuery.html")
    	public ModelAndView queryAllEnterpristInfoList( DrugProcureRecords dp,Model model,HttpServletRequest request,HttpServletResponse response){
  		List<?> reslist=new ArrayList();
  		List<DrugProcureRecords> list = new ArrayList<DrugProcureRecords>();
  		String gouriqi= request.getParameter("gouriqi");
  		String caigoudh= request.getParameter("caigoudh");
  		String pihao= request.getParameter("pihao");
  		String zhi= request.getParameter("zhi");
  		String  useFalg = request.getParameter("useFlag");
  		String page = DisplayGetPage.getPageParamName("records", request);
  		model.addAttribute("gouriqi", gouriqi);
  		model.addAttribute("caigoudh", caigoudh);
  		model.addAttribute("pihao", pihao);
  		model.addAttribute("zhi", zhi);
  		model.addAttribute("useFlag", useFalg);
  	
  	
  		StringBuffer sqlBuffer = new StringBuffer("  select u.number,u.modify_date,u.name1,u.medc_no,u.common_name,u.form_name,u.specifications,u.unit," +
				" u.tax_price,u.quantity,u.produce_no,u.name2,u.batch_production,u.end_time,uer.REALNAME,u.department_id,u.use_flag from " +
				" ( select d.number,d.modify_date,d.qualifiedSupplierId_id ,d.modifier,d.name1, d.qualified_medicine_id,d.quantity, d. name2 ," +
				" d.produce_no,d.batch_production,d.end_time,d.dosageforms_id ,d.medc_no,d.common_name,d.specifications," +
				" d.unit,df.form_name ,d.tax_price,d.department_id,d.use_flag from " +
				" (select h.number, h.modify_date,h.qualifiedSupplierId_id ,h.modifier,h.name1, " +
				" h.qualified_medicine_id,h.quantity, h. name2 ,h.produce_no,h.batch_production,h.end_time,p.dosageforms_id ," +
				" p.medc_no,p.common_name,p.specifications,p.unit ,h.tax_price ,h.department_id,h.use_flag from " +
				" ( select n.number, n.modify_date,n.qualifiedSupplierId_id ,n.modifier,n.name as name1, " +
				" n.qualified_medicine_id,n.quantity, c.name as name2 ,n.produce_no,n.batch_production,n.end_time ,n.tax_price,n.department_id,n.use_flag from " +
				" (select m.number, m.modify_date,m.qualifiedSupplierId_id ,m.modifier,q.name,m.qualified_medicine_id,m.quantity," +
				" m.produce_no, m.batch_production,m.end_time ,m.tax_price,m.department_id,m.use_flag from " +
				" (select t.use_flag, t.department_id, t.number, t.modify_date,t.qualifiedSupplierId_id ,t.modifier,i.qualified_medicine_id,i.quantity,i.produce_no,i.batch_production, " +
				" i.end_time,i.tax_price from t_purchase_order t " +
				" left join t_purchase_order_item i " +
				" on t.id=i.purchase_order_id where t.status='2') m" +
				" left join t_qualifiedSupplier q " +
				"  on m.qualifiedSupplierId_id=q.id )n" +
				" left join t_qualifiedSupplier c" +
				" on c.id=n.produce_no)h" +
				" left join  t_qualified_medicine  p" +
				"  on p.id=h.qualified_medicine_id)d" +
				" left join t_dosage_form df" +
				" on df.id=d.dosageforms_id)u" +
				" left join TRTHR_USER uer" +
				"  on u.modifier=uer.USERID  where 1=1 and u.quantity > 0 ");
  				if(gouriqi!=null && !gouriqi.equals("")){
  					sqlBuffer.append(" and u.modify_date >= '"+gouriqi+"' ");

  				}
  				if(zhi!=null && !zhi.equals("")){
  					sqlBuffer.append(" and  u.modify_date <= '"+zhi+"' ");

  				}
  				if(caigoudh!=null && !caigoudh.equals("")){
  					sqlBuffer.append(" and u.number like '%");
  				sqlBuffer.append(caigoudh+"%'  ");
  				}
  				if(pihao!=null && !pihao.equals("")){
  					sqlBuffer.append(" and u.batch_production like  '%");
  					sqlBuffer.append(pihao+"%'  ");
  				}
  					reslist = drugProcureRecordsMng.getAllDrugProcureRecords(sqlBuffer.toString(), new HashMap<String, Object>());
  			
  					if(reslist!=null){
  						for(int i = 0;i < reslist.size();i++){
  							Object[] obj = (Object[]) reslist.get(i);
  							DrugProcureRecords rugProcure =new DrugProcureRecords();	
  							if(obj[1]!=null){
  								rugProcure.setGouriqi(obj[1].toString());
  							}
  							if(obj[2]!=null){
  								rugProcure.setGonghuodw(obj[2].toString());
  							}
  							if(obj[3]!=null){
  								rugProcure.setYopinbh(obj[3].toString());
  							}
  							if(obj[4]!=null){
  								rugProcure.setTongyongmc(obj[4].toString());
  							}
  							if(obj[5]!=null){
  								rugProcure.setJixing(obj[5].toString());
  							}
  							if(obj[6]!=null){
  								rugProcure.setGuige(obj[6].toString());
  							}
  							if(obj[7]!=null){
  								rugProcure.setDanwei(obj[7].toString());
  							}
  							if(obj[8]!=null){
  								rugProcure.setGoujinjg(obj[8].toString());
  							}
  							if(obj[9]!=null){
  								rugProcure.setGoujinsl(Long.valueOf (obj[9].toString()));
  							}
  							if(obj[12]!=null){
  								rugProcure.setPihao(obj[12].toString());
  							}
  							if(obj[11]!=null){
  								rugProcure.setShengchancs(obj[11].toString());
  							}
  							if(obj[13]!=null){
  								rugProcure.setYouxiaoqi(obj[13].toString());
  							}
  							if(obj[14]!=null){
  								rugProcure.setCaigouyuan(obj[14].toString());
  							}
  							
  							
  							
//  						aidCenterDistSum.setEareName((String)temp[1]);
//  						aidCenterDistSum.setAidCenterNum((Integer)temp[2]);
//  						aidCenterDistSum.setStaffNum((Integer)temp[3]);
//  						aidCenterDistSum.setTechStaffNum((Integer)temp[4]);
//  						aidCenterDistSum.setExpertNum((Integer)temp[5]);
  							
  							list.add(rugProcure);
  						}	
  					}
  				StringBuffer buffer=new StringBuffer(" select count(*) from " +
  						" ( select d.number,d.modify_date,d.qualifiedSupplierId_id ,d.modifier,d.name1, d.qualified_medicine_id,d.quantity, d. name2 ," +
  						" d.produce_no,d.batch_production,d.end_time,d.dosageforms_id ,d.medc_no,d.common_name,d.specifications," +
  						" d.unit,df.form_name ,d.tax_price from " +
  						" (select h.number, h.modify_date,h.qualifiedSupplierId_id ,h.modifier,h.name1, " +
  						" h.qualified_medicine_id,h.quantity, h. name2 ,h.produce_no,h.batch_production,h.end_time,p.dosageforms_id ," +
  						" p.medc_no,p.common_name,p.specifications,p.unit ,h.tax_price from " +
  						" ( select n.number, n.modify_date,n.qualifiedSupplierId_id ,n.modifier,n.name as name1, " +
  						" n.qualified_medicine_id,n.quantity, c.name as name2 ,n.produce_no,n.batch_production,n.end_time ,n.tax_price from " +
  						" (select m.number, m.modify_date,m.qualifiedSupplierId_id ,m.modifier,q.name,m.qualified_medicine_id,m.quantity," +
  						" m.produce_no, m.batch_production,m.end_time ,m.tax_price from " +
  						" (select t.number, t.modify_date,t.qualifiedSupplierId_id ,t.modifier,i.qualified_medicine_id,i.quantity,i.produce_no,i.batch_production, " +
  						" i.end_time,i.tax_price from t_purchase_order t " +
  						" left join t_purchase_order_item i " +
  						" on t.id=i.purchase_order_id) m" +
  						" left join t_qualifiedSupplier q " +
  						"  on m.qualifiedSupplierId_id=q.id )n" +
  						" left join t_qualifiedSupplier c" +
  						" on c.id=n.produce_no)h" +
  						" left join  t_qualified_medicine  p" +
  						"  on p.id=h.qualified_medicine_id)d" +
  						" left join t_dosage_form df" +
  						" on df.id=d.dosageforms_id)u" +
  						" left join TRTHR_USER uer" +
  						"  on u.modifier=uer.USERID  where 1=1 and u.quantity > 0 ");

  				if(gouriqi!=null && !gouriqi.equals("")){
  					buffer.append(" and u.modify_date >= '"+gouriqi+"' ");

  				}
  				if(zhi!=null && !zhi.equals("")){
  					buffer.append(" and  u.modify_date <= '"+zhi+"' ");

  				}
  				if(caigoudh!=null && !caigoudh.equals("")){
  					buffer.append(" and u.number like '%");
  					buffer.append(caigoudh+"%'  ");
  				}
  				if(pihao!=null && !pihao.equals("")){
  					buffer.append(" and u.batch_production like  '%");
  					buffer.append(pihao+"%'  ");
  				}
  				int resultSize = drugProcureRecordsMng.getQueryCount(buffer.toString());
  				double size = resultSize;
  				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
  				model.addAttribute("resultSize", resultSize);
  				
  		//页数

  		model.addAttribute("thispage", Integer.parseInt(page));
  		model.addAttribute("pageSize", Constants.pagesize);

  		model.addAttribute("dp", dp);
  		model.addAttribute("reslist", list);
  		return new ModelAndView("comQuery/drugProcureRecords/query");
  	}
}

