package com.sinosoft.comQuery.drugSaleRecords.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.sinosoft.comQuery.drugSaleRecords.service.DrugSaleRecordsMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.DisplayGetPage;

@Controller
public class DrugSaleRecordsAct {
	@Autowired
	private ReturnCheckRecordsMng returnCheckRecordsMng;

	public void setReturnCheckRecordsMng(ReturnCheckRecordsMng returnCheckRecordsMng) {
		this.returnCheckRecordsMng = returnCheckRecordsMng;
	}
	@Autowired
	private DrugSaleRecordsMng drugSaleRecordsMng;

	public void setDrugSaleRecordsMng(DrugSaleRecordsMng drugSaleRecordsMng) {
		this.drugSaleRecordsMng = drugSaleRecordsMng;
	}
	@RequestMapping("/comQuery/drugSaleRecords/list.html")
	public ModelAndView openFramePage(DrugSaleRecords ds, HttpServletRequest request, HttpServletResponse response, Model model){
		
			return new ModelAndView("comQuery/drugSaleRecords/list");
		}
	 @RequestMapping("/comQuery/drugSaleRecords/query.html")
	  	public ModelAndView queryEnterpristInfoList( DrugSaleRecords ds,Model model,HttpServletRequest request,HttpServletResponse response){
			List<?> reslist=new ArrayList();
			List<DrugSaleRecords> list = new ArrayList<DrugSaleRecords>();
			String xiaoshoudh= request.getParameter("xiaoshoudh");
			String tuihuodanwei= request.getParameter("tuihuodanwei");
			String pihao= request.getParameter("pihao");
			String page = DisplayGetPage.getPageParamName("records", request);
			String commonName = request.getParameter("commonName");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar c = Calendar.getInstance(); 
			String end_date=sdf.format(c.getTime());
			c.add(Calendar.DATE, - 7);
			String start_date = sdf.format(c.getTime());

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
			if(tuihuodanwei!=null &&  !tuihuodanwei.equals("")){
				QualifiedPurchaseUnits qualifiedPurchaseUnits=	returnCheckRecordsMng.findById(tuihuodanwei);
				  String	name=qualifiedPurchaseUnits.getCustomerName();
					model.addAttribute("tuihuodanwei", name);	
			}
			model.addAttribute("pihao", pihao);
		
		
//					StringBuffer sqlBuffer = new StringBuffer (" select  u.sales_form_no,u.create_date,u.customer_name,u.medc_no,u.common_name,df.form_name,u.specifications,u.unit,u.sales_price,u.quantity,u.total_amount,u.batch_no,u.expire_date,u.sccs,u.creater_id ,u.qualified_purchase_units_id,u.sales_item_no ,u.department_id,u.is_food from" +
//							" (select w.sales_form_no, w.medc_no,w.common_name,w.dosageforms_id,w.specifications,w.unit,w.produceno_id,f.name as sccs,w.create_date,w.qualified_purchase_units_id,w.customer_name,w.qualified_medicine_id,w.sales_price,w.quantity,w.total_amount,w.batch_no,w.expire_date,w.creater_id,w.sales_item_no ,w.department_id,w.is_food from " +
//							"(select p.sales_form_no,q.medc_no,q.common_name,q.dosageforms_id,q.specifications,q.unit,q.produceno_id,p.create_date,p.qualified_purchase_units_id,p.customer_name,p.qualified_medicine_id,p.sales_price,p.quantity,p.total_amount,p.batch_no,p.expire_date,p.creater_id,p.sales_item_no,p.department_id,q.is_food from " +
//							"(select m.sales_form_no,m.create_date,m.qualified_purchase_units_id,v.customer_name ,m.qualified_medicine_id,m.sales_price,m.quantity,m.total_amount,m.batch_no,m.expire_date,m.creater_id,m.sales_item_no,m.department_id from " +
//							"(select n.sales_form_no,n.create_date,n.qualified_purchase_units_id,i.qualified_medicine_id,i.sales_price,i.quantity,i.total_amount,i.batch_no,i.expire_date,n.creater_id,i.sales_item_no ,i.department_id from   " +
//							" trtss_sales_form_info  n " +
//							" left join trtss_sales_items_info  i " +
//							" on n.id=i.trtss_sales_form_info_id WHERE i.medc_no IN ( SELECT medc_no FROM dbo.t_qualified_medicine ))m " +  //不显示gsp中没有的货号的销售记录
//							" left join t_qualified_purchase_units v " +
//							"  on v.id=m.qualified_purchase_units_id)p " +
//							" left join t_qualified_medicine q " +
//							" on q.id=p.qualified_medicine_id)w " +
//							" left join t_qualifiedSupplier f " +
//							" on f.id=w.produceno_id)u " +
//							" left join t_dosage_form df " +
//							" on u.dosageforms_id=df.id where 1=1");
			
					StringBuffer sqlBuffer = new StringBuffer (" select  u.sales_form_no,u.create_date,u.customer_name,u.medc_no,u.common_name,df.form_name,u.specifications,u.unit,u.sales_price,u.quantity,u.total_amount,u.batch_no,u.expire_date,u.sccs,u.creater_id ,u.qualified_purchase_units_id,u.sales_item_no ,u.department_id,u.is_food from" +
							" (select w.sales_form_no, w.medc_no,w.common_name,w.dosageforms_id,w.specifications,w.unit,w.produceno_id,f.name as sccs,w.create_date,w.qualified_purchase_units_id,w.customer_name,w.qualified_medicine_id,w.sales_price,w.quantity,w.total_amount,w.batch_no,w.expire_date,w.creater_id,w.sales_item_no ,w.department_id,w.is_food from " +
							"(select p.sales_form_no,q.medc_no,q.common_name,q.dosageforms_id,q.specifications,q.unit,q.produceno_id,p.create_date,p.qualified_purchase_units_id,p.customer_name,q.id AS qualified_medicine_id,p.sales_price,p.quantity,p.total_amount,p.batch_no,p.expire_date,p.creater_id,p.sales_item_no,p.department_id,q.is_food from " +
							"(select m.sales_form_no,m.create_date,v.id AS qualified_purchase_units_id,v.customer_name ,m.medc_no,m.sales_price,m.quantity,m.total_amount,m.batch_no,m.expire_date,m.operator_name AS creater_id ,m.sales_item_no,m.department_id from " +
							"(select a.sales_form_no,a.create_date,a.customer_id,a.medc_no,a.sales_price,a.quantity,a.total_amount,a.batch_no,a.exp_date as expire_date,a.operator_name,a.sales_item_no,a.department_id  from " +
							" dbo.V_SmsToGsp_Sales_Records a )m " + 
							" left join t_qualified_purchase_units v " +
							"  on v.customer_number = m.customer_id)p " +
							" left join t_qualified_medicine q " +
							" on q.medc_no = p.medc_no)w " +
							" left join t_qualifiedSupplier f " +
							" on f.id=w.produceno_id)u " +
							" left join t_dosage_form df " +
							" on u.dosageforms_id=df.id where 1=1");
					
				
					if(xiaoshoudh!=null && !xiaoshoudh.equals("")){
						sqlBuffer.append(" and  u.sales_item_no like '%");
					sqlBuffer.append(xiaoshoudh+"%'  ");
					}
					if(tuihuodanwei!=null && !tuihuodanwei.equals("")){
						sqlBuffer.append("  and  u.qualified_purchase_units_id = '");
						sqlBuffer.append(tuihuodanwei+"'  ");
					}
					if(pihao!=null && !pihao.equals("")){
						sqlBuffer.append(" and u.batch_no like '%");
					sqlBuffer.append(pihao+"%'  ");
					}
					if(commonName!=null && !"".equals(commonName)){
						sqlBuffer.append(" and u.common_name like '"+commonName+"'");
					}
					if(deparment!=null && !"".equals(deparment)){
						sqlBuffer.append(" and u.department_id ='"+deparment+"' ");
					}
					if(isfood!=null && !"".equals(isfood)){
						sqlBuffer.append(" and u.is_food ='"+isfood+"' ");
					}
//					sqlBuffer.append(" and CONVERT(date,u.create_date,120 ) >= '2013-09-01 00:00:00'");
					if(start_date!=null && !"".equals(start_date)){
						sqlBuffer.append(" and CONVERT(date,u.create_date,120 ) >= CONVERT(date,'"+start_date+"',120 )");
					}
					if(end_date!=null && !"".equals(end_date)){
						sqlBuffer.append(" and CONVERT(date,u.create_date,120 ) <= CONVERT(date,'"+end_date+"',120 )");
					}
				//	sqlBuffer.append("and u.common_name <>'安宫牛黄丸' ");
//					sqlBuffer.append(" and len(u.batch_no) > 7 ");//视图已过滤可以不用加
					sqlBuffer.append(" order by u.create_date DESC");
					
					
						String export = request.getParameter(TableTagParameters.PARAMETER_EXPORTING);
						if(export != null && !"".equals(export)){
							reslist = drugSaleRecordsMng.getAllDrugSaleRecordsByCondiction(sqlBuffer.toString(), new HashMap<String, Object>());
							
						}else{
							reslist = drugSaleRecordsMng.getDrugSaleRecordsByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
						}

						if(reslist!=null){
							for(int i = 0;i < reslist.size();i++){
								Object[] obj = (Object[]) reslist.get(i);
								DrugSaleRecords drugSale=new DrugSaleRecords();	
								
								if(obj[4].equals("安宫牛黄丸")&& DateTimeUtils.compareTwoDate(obj[1].toString(), "2014-07-14")==1){
									continue;
								}
								if(obj[1]!=null){
									drugSale.setXiaoshouriqi(obj[1].toString());
								}
								if(obj[2]!=null){
									drugSale.setGouhuodw(obj[2].toString());
								}
								if(obj[3]!=null){
									drugSale.setYaopinhao(obj[3].toString());
								}
								if(obj[4]!=null){
									drugSale.setMingcheng(obj[4].toString());
								}
								if(obj[5]!=null){
									drugSale.setJixing(obj[5].toString());
								}
								if(obj[6]!=null){
									drugSale.setGuige(obj[6].toString());
								}
								if(obj[7]!=null){
									drugSale.setDanwei(obj[7].toString());
								}
								if(obj[8]!=null){
									drugSale.setJiage(obj[8].toString());
								}
								if(obj[9]!=null){
									drugSale.setShuliang(obj[9].toString());
								}
								if(obj[10]!=null){
									drugSale.setJine(obj[10].toString());
								}
								if(obj[11]!=null){
									drugSale.setPihao(obj[11].toString());
								}
								if(obj[12]!=null){
									drugSale.setYouxiaoqi(obj[12].toString());
								}
								if(obj[13]!=null){
									drugSale.setShengchancs(obj[13].toString());
								}
								if(obj[14]!=null){
									drugSale.setXiaoshouyuan(obj[14].toString());
								}
								if(obj[16]!=null){
									drugSale.setSaleItemNumber(obj[16].toString());
								}
								if(obj[17]!=null){
									drugSale.setDepartment(obj[17].toString());
								}
								list.add(drugSale);
							}	
						}
//						StringBuffer buffer = new StringBuffer (" select count(*) from" +
//								" (select w.sales_form_no, w.medc_no,w.common_name,w.dosageforms_id,w.specifications,w.unit,w.produceno_id,f.name as sccs,w.create_date,w.qualified_purchase_units_id,w.customer_name,w.qualified_medicine_id,w.sales_price,w.quantity,w.total_amount,w.batch_no,w.expire_date,w.creater_id,w.sales_item_no ,w.department_id,w.is_food from " +
//								"(select p.sales_form_no,q.medc_no,q.common_name,q.dosageforms_id,q.specifications,q.unit,q.produceno_id,p.create_date,p.qualified_purchase_units_id,p.customer_name,p.qualified_medicine_id,p.sales_price,p.quantity,p.total_amount,p.batch_no,p.expire_date,p.creater_id,p.sales_item_no,p.department_id,q.is_food from " +
//								"(select m.sales_form_no,m.create_date,m.qualified_purchase_units_id,v.customer_name ,m.qualified_medicine_id,m.sales_price,m.quantity,m.total_amount,m.batch_no,m.expire_date,m.creater_id,m.sales_item_no,m.department_id from " +
//								"(select n.sales_form_no,n.create_date,n.qualified_purchase_units_id,i.qualified_medicine_id,i.sales_price,i.quantity,i.total_amount,i.batch_no,i.expire_date,n.creater_id,i.sales_item_no ,i.department_id from   " +
//								" trtss_sales_form_info  n " +
//								" left join trtss_sales_items_info  i " +
//								" on n.id=i.trtss_sales_form_info_id WHERE i.medc_no IN ( SELECT medc_no FROM dbo.t_qualified_medicine ))m " +
//								" left join t_qualified_purchase_units v " +
//								"  on v.id=m.qualified_purchase_units_id)p " +
//								" left join t_qualified_medicine q " +
//								" on q.id=p.qualified_medicine_id)w " +
//								" left join t_qualifiedSupplier f " +
//								" on f.id=w.produceno_id)u " +
//								" left join t_dosage_form df " +
//								" on u.dosageforms_id=df.id where 1=1");
					
						StringBuffer buffer = new StringBuffer (" select count(*) from" +
								" (select w.sales_form_no, w.medc_no,w.common_name,w.dosageforms_id,w.specifications,w.unit,w.produceno_id,f.name as sccs,w.create_date,w.qualified_purchase_units_id,w.customer_name,w.qualified_medicine_id,w.sales_price,w.quantity,w.total_amount,w.batch_no,w.expire_date,w.creater_id,w.sales_item_no ,w.department_id,w.is_food from " +
								"(select p.sales_form_no,q.medc_no,q.common_name,q.dosageforms_id,q.specifications,q.unit,q.produceno_id,p.create_date,p.qualified_purchase_units_id,p.customer_name,q.id AS qualified_medicine_id,p.sales_price,p.quantity,p.total_amount,p.batch_no,p.expire_date,p.creater_id,p.sales_item_no,p.department_id,q.is_food from " +
								"(select m.sales_form_no,m.create_date,v.id AS qualified_purchase_units_id,v.customer_name ,m.medc_no,m.sales_price,m.quantity,m.total_amount,m.batch_no,m.expire_date,m.operator_name AS creater_id ,m.sales_item_no,m.department_id from " +
								"(select a.sales_form_no,a.create_date,a.customer_id,a.medc_no,a.sales_price,a.quantity,a.total_amount,a.batch_no,a.exp_date as expire_date,a.operator_name,a.sales_item_no,a.department_id  from " +
								" dbo.V_SmsToGsp_Sales_Records a )m " + 
								" left join t_qualified_purchase_units v " +
								"  on v.customer_number = m.customer_id)p " +
								" left join t_qualified_medicine q " +
								" on q.medc_no = p.medc_no)w " +
								" left join t_qualifiedSupplier f " +
								" on f.id=w.produceno_id)u " +
								" left join t_dosage_form df " +
								" on u.dosageforms_id=df.id where 1=1");
					
					if(xiaoshoudh!=null && !xiaoshoudh.equals("")){
						buffer.append(" and  u.sales_item_no like '%");
						buffer.append(xiaoshoudh+"%'  ");
					}
					if(tuihuodanwei!=null && !tuihuodanwei.equals("")){
						buffer.append("  and  u.qualified_purchase_units_id = '");
						buffer.append(tuihuodanwei+"'  ");
					}
					if(pihao!=null && !pihao.equals("")){
						buffer.append(" and u.batch_no like '%");
						buffer.append(pihao+"%'  ");
					}
					if(commonName!=null && !"".equals(commonName)){
						buffer.append(" and u.common_name like '%"+commonName+"%'");
					}
					if(deparment!=null && !"".equals(deparment)){
						buffer.append(" and u.department_id ='"+deparment+"' ");
					}
					if(isfood!=null && !"".equals(isfood)){
						buffer.append(" and u.is_food ='"+isfood+"' ");
					}
//					buffer.append(" and CONVERT(date,u.create_date,120 ) >= '2013-09-01 00:00:00'");
					if(start_date!=null && !"".equals(start_date)){
						buffer.append(" and CONVERT(date,u.create_date,120 ) >= CONVERT(date,'"+start_date+"',120 )");
					}
					if(end_date!=null && !"".equals(end_date)){
						buffer.append(" and CONVERT(date,u.create_date,120 ) <= CONVERT(date,'"+end_date+"',120 )");
					}
				//	sqlBuffer.append("and u.common_name <>'安宫牛黄丸' ");
//					buffer.append(" and len(u.batch_no) > 7 ");
					int resultSize = drugSaleRecordsMng.getQueryCount(buffer.toString());
					double size = resultSize;
					model.addAttribute("startDate",start_date.substring(0,10));
					model.addAttribute("endDate",end_date.substring(0,10));
					model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
					model.addAttribute("resultSize", resultSize);
					
			//页数

			model.addAttribute("thispage", Integer.parseInt(page));
			model.addAttribute("pageSize", Constants.pagesize);

			model.addAttribute("ds", ds);
			model.addAttribute("reslist", list);
			return new ModelAndView("comQuery/drugSaleRecords/query");
		}
}