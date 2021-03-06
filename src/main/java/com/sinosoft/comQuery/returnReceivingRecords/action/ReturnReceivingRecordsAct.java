package com.sinosoft.comQuery.returnReceivingRecords.action;

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
import com.sinosoft.comQuery.ReturnCheckRecords.service.ReturnCheckRecordsMng;
import com.sinosoft.comQuery.returnReceivingRecords.model.ReturnReceivingRecords;
import com.sinosoft.comQuery.returnReceivingRecords.service.ReturnReceivingRecordsMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.ireportDTO.ReturnDrugsDto;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.IreportUtil;

@Controller
public class ReturnReceivingRecordsAct {
	@Autowired
	private ReturnCheckRecordsMng returnCheckRecordsMng;

	public void setReturnCheckRecordsMng(ReturnCheckRecordsMng returnCheckRecordsMng) {
		this.returnCheckRecordsMng = returnCheckRecordsMng;
	}
	@Autowired
	private ReturnReceivingRecordsMng returnReceivingRecordsMng;

	public void setReturnReceivingRecordsMng(
			ReturnReceivingRecordsMng returnReceivingRecordsMng) {
		this.returnReceivingRecordsMng = returnReceivingRecordsMng;
	}
	@RequestMapping("/comQuery/returnReceivingRecords/list.html")
	public ModelAndView openFramePage(ReturnReceivingRecords rr, HttpServletRequest request, HttpServletResponse response, Model model){
		
			return new ModelAndView("comQuery/returnReceivingRecords/list");
		}
	 @RequestMapping("/comQuery/returnReceivingRecords/query.html")
	  	public ModelAndView queryEnterpristInfoList( ReturnReceivingRecords rr,Model model,HttpServletRequest request,HttpServletResponse response){
			List<?> reslist=new ArrayList();
			List<ReturnReceivingRecords> list = new ArrayList<ReturnReceivingRecords>();
			String tuihuoriqi= request.getParameter("tuihuoriqi");
			String zhi= request.getParameter("zhi");
			String tuihuodanwei= request.getParameter("tuihuodanwei");
			String pihao= request.getParameter("pihao");
			String isfood= request.getParameter("isfood");
			String page = DisplayGetPage.getPageParamName("records", request);
			model.addAttribute("tuihuoriqi", tuihuoriqi);
			model.addAttribute("zhi", zhi);
			if(tuihuodanwei!=null &&  !tuihuodanwei.equals("")){
				QualifiedPurchaseUnits qualifiedPurchaseUnits=	returnCheckRecordsMng.findById(tuihuodanwei);
				  String	name=qualifiedPurchaseUnits.getCustomerName();
					model.addAttribute("tuihuodanwei", name);	
			}
			model.addAttribute("pihao", pihao);
			model.addAttribute("isfood", isfood);
		
		
					StringBuffer sqlBuffer = new StringBuffer("select m.deliveryDate, v.customer_name ,m.medc_no,m.common_name,m.dosage_forms,m.specifications,m.quantity,m.batch_production,m.end_time,m.sccj,m.return_Number,m.qualified_purchase_units_id,m.REALNAME,m.production_date,m.is_food " +
							" from(select  h.deliveryDate,h.qualified_purchase_units_id,h.number,h.return_Number,h.batch_production,h.qualified_medicine_id,h.common_name,h.dosage_forms,h.specifications,h.quantity,h.end_time,c.name as sccj,h.REALNAME,h.medc_no,h.production_date,h.is_food " +
							" from (select  p.deliveryDate,p.qualified_purchase_units_id,p.number,p.return_Number,p.batch_production,p.qualified_medicine_id,q.common_name,q.produceno_id,q.medc_no,p.dosage_forms,p.specifications,p.quantity,p.end_time,p.REALNAME,p.production_date,q.is_food  " +
							" from (select  n.deliveryDate,n.qualified_purchase_units_id,n.number,n.return_Number,i.batch_production,i.qualified_medicine_id,i.dosage_forms,i.specifications,i.quantity,i.end_time,u.REALNAME,i.production_date " +
							" from t_return_receiving_note n " +
							" left join t_return_receiving_note_item i " +
							" on n.id=i.receiving_note_id left join TRTHR_USER u on CAST(n.goods_clerk as numeric(19, 0) )= u.USERID ) p " +
							" left join t_qualified_medicine q " +
							" on q.id=p.qualified_medicine_id)h " +
							" left join t_qualifiedSupplier c " +
							" on c.id=h.produceno_id)m " +
							" left join t_qualified_purchase_units  v " +
							" on v.id=m.qualified_purchase_units_id where 1=1 and m.return_Number <> '000000'");
					
					if(tuihuoriqi!=null && !tuihuoriqi.equals("")){
						sqlBuffer.append(" and  CONVERT(datetime,CONVERT(varchar(10),m.deliveryDate,20),20)>= CONVERT(datetime,'");
					   sqlBuffer.append(tuihuoriqi+"',20)  ");
					}
					if(zhi!=null && !zhi.equals("")){
						sqlBuffer.append(" and  CONVERT(datetime,CONVERT(varchar(10),m.deliveryDate,20),20)<= CONVERT(datetime,'");
					   sqlBuffer.append(zhi+"',20)  ");
					}
					if(tuihuodanwei!=null && !tuihuodanwei.equals("")){
						sqlBuffer.append("  and  m.qualified_purchase_units_id = '");
						sqlBuffer.append(tuihuodanwei+"'  ");
					}
					if(pihao!=null && !pihao.equals("")){
						sqlBuffer.append(" and m.batch_production= '");
					sqlBuffer.append(pihao+"'  ");
					}
					if(isfood!=null && !isfood.equals("")){
						sqlBuffer.append(" and m.is_food= '");
					sqlBuffer.append(isfood+"'  ");
					}
					sqlBuffer.append(" and len(m.batch_production) > 7 order by deliveryDate desc ");
						reslist = returnReceivingRecordsMng.getReturnReceivingRecordsByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
						if(reslist!=null){
							for(int i = 0;i < reslist.size();i++){
								Object[] obj = (Object[]) reslist.get(i);
								ReturnReceivingRecords returnReceiving=new ReturnReceivingRecords();	
								if(obj[0]!=null){
									returnReceiving.setTuihuorq(obj[0].toString());
								}
								if(obj[1]!=null){
									returnReceiving.setTuihuodw(obj[1].toString());
								}
								if(obj[2]!=null){
									returnReceiving.setHuohao(obj[2].toString());
								}
								if(obj[3]!=null){
									returnReceiving.setMingcheng(obj[3].toString());
								}
								if(obj[4]!=null){
									returnReceiving.setJixing(obj[4].toString());
								}
								if(obj[5]!=null){
									returnReceiving.setGuige(obj[5].toString());
								}
								if(obj[6]!=null){
									returnReceiving.setShuliang(Long.valueOf (obj[6].toString()));
								}
								if(obj[7]!=null){
									returnReceiving.setPihao(obj[7].toString());
								}
								if(obj[8]!=null){
									returnReceiving.setYouxiaoqi(obj[8].toString());
								}
								if(obj[9]!=null){
									returnReceiving.setShanghcan(obj[9].toString());
								}
								if(obj[10]!=null){
									returnReceiving.setTuihuodh(obj[10].toString());
								}
								if(obj[12]!= null){
									returnReceiving.setBaoguanyuan(obj[12].toString());
								}
								if(obj[13] != null){
									returnReceiving.setShengchanriqi(obj[13].toString());
								}
								returnReceiving.setBeizhu("");
								list.add(returnReceiving);
							}	
						}
						StringBuffer buffer = new StringBuffer("select count(*)" +
								" from(select  h.deliveryDate,h.qualified_purchase_units_id,h.number,h.return_Number,h.batch_production,h.qualified_medicine_id,h.common_name,h.dosage_forms,h.specifications,h.quantity,h.end_time,c.name as sccj,h.REALNAME,h.medc_no,h.is_food " +
								" from (select  p.deliveryDate,p.qualified_purchase_units_id,p.number,p.return_Number,p.batch_production,p.qualified_medicine_id,q.common_name,q.produceno_id,q.medc_no,p.dosage_forms,p.specifications,p.quantity,p.end_time,p.REALNAME,q.is_food  " +
								" from (select  n.deliveryDate,n.qualified_purchase_units_id,n.number,n.return_Number,i.batch_production,i.qualified_medicine_id,i.dosage_forms,i.specifications,i.quantity,i.end_time,u.REALNAME " +
								" from t_return_receiving_note n " +
								" left join t_return_receiving_note_item i " +
								" on n.id=i.receiving_note_id left join TRTHR_USER u on CAST(n.goods_clerk as numeric(19, 0) )= u.USERID ) p " +
								" left join t_qualified_medicine q " +
								" on q.id=p.qualified_medicine_id)h " +
								" left join t_qualifiedSupplier c " +
								" on c.id=h.produceno_id)m " +
								" left join t_qualified_purchase_units  v " +
								" on v.id=m.qualified_purchase_units_id where 1=1 and m.return_Number <> '000000'");

					if(tuihuoriqi!=null && !tuihuoriqi.equals("")){
						buffer.append(" and  m.deliveryDate>= '");
						buffer.append(tuihuoriqi+"'  ");
					}
					if(zhi!=null && !zhi.equals("")){
						buffer.append(" and  m.deliveryDate<= '");
						buffer.append(zhi+"'  ");
					}
					if(tuihuodanwei!=null && !tuihuodanwei.equals("")){
						buffer.append("  and  m.qualified_purchase_units_id = '");
						buffer.append(tuihuodanwei+"'  ");
					}
					if(pihao!=null && !pihao.equals("")){
						buffer.append(" and m.batch_production= '");
						buffer.append(pihao+"'  ");
					}
					if(isfood!=null && !isfood.equals("")){
						buffer.append(" and m.is_food= '");
						buffer.append(isfood+"'  ");
					}
					buffer.append(" and len(m.batch_production) > 7 ");
					int resultSize = returnReceivingRecordsMng.getQueryCount(buffer.toString());
					double size = resultSize;
					model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
					model.addAttribute("resultSize", resultSize);
					
			//页数

			model.addAttribute("thispage", Integer.parseInt(page));
			model.addAttribute("pageSize", Constants.pagesize);

			model.addAttribute("rr", rr);
			model.addAttribute("reslist", list);
			return new ModelAndView("comQuery/returnReceivingRecords/query");
		}
	 
	 @RequestMapping("/comQuery/returnReceivingRecords/exportAllRecords.html")
	  	public ModelAndView exportAllEnterpristInfoList( ReturnReceivingRecords rr,Model model,HttpServletRequest request,HttpServletResponse response){
			List<?> reslist=new ArrayList();
			List<ReturnReceivingRecords> list = new ArrayList<ReturnReceivingRecords>();
			String tuihuoriqi= request.getParameter("tuihuoriqi");
			String zhi= request.getParameter("zhi");
			String tuihuodanwei= request.getParameter("tuihuodanwei");
			String pihao= request.getParameter("pihao");
			String page = DisplayGetPage.getPageParamName("records", request);
			model.addAttribute("tuihuoriqi", tuihuoriqi);
			model.addAttribute("zhi", zhi);
			if(tuihuodanwei!=null &&  !tuihuodanwei.equals("")){
				QualifiedPurchaseUnits qualifiedPurchaseUnits=	returnCheckRecordsMng.findById(tuihuodanwei);
				  String	name=qualifiedPurchaseUnits.getCustomerName();
					model.addAttribute("tuihuodanwei", name);	
			}
			model.addAttribute("pihao", pihao);
		
		
			StringBuffer sqlBuffer = new StringBuffer("select m.deliveryDate, v.customer_name ,m.medc_no,m.common_name,m.dosage_forms,m.specifications,m.quantity,m.batch_production,m.end_time,m.sccj,m.return_Number,m.qualified_purchase_units_id,m.REALNAME " +
					" from(select  h.deliveryDate,h.qualified_purchase_units_id,h.number,h.return_Number,h.batch_production,h.qualified_medicine_id,h.common_name,h.dosage_forms,h.specifications,h.quantity,h.end_time,c.name as sccj,h.REALNAME,h.medc_no " +
					" from (select  p.deliveryDate,p.qualified_purchase_units_id,p.number,p.return_Number,p.batch_production,p.qualified_medicine_id,q.common_name,q.produceno_id,q.medc_no,p.dosage_forms,p.specifications,p.quantity,p.end_time,p.REALNAME  " +
					" from (select  n.deliveryDate,n.qualified_purchase_units_id,n.number,n.return_Number,i.batch_production,i.qualified_medicine_id,i.dosage_forms,i.specifications,i.quantity,i.end_time,u.REALNAME " +
					" from t_return_receiving_note n " +
					" left join t_return_receiving_note_item i " +
					" on n.id=i.receiving_note_id left join TRTHR_USER u on CAST(n.goods_clerk as numeric(19, 0) )= u.USERID ) p " +
					" left join t_qualified_medicine q " +
					" on q.id=p.qualified_medicine_id)h " +
					" left join t_qualifiedSupplier c " +
					" on c.id=h.produceno_id)m " +
					" left join t_qualified_purchase_units  v " +
					" on v.id=m.qualified_purchase_units_id where 1=1 and m.return_Number <> '000000'");
					
					if(tuihuoriqi!=null && !tuihuoriqi.equals("")){
						sqlBuffer.append(" and  m.deliveryDate>= '");
					   sqlBuffer.append(tuihuoriqi+"'  ");
					}
					if(zhi!=null && !zhi.equals("")){
						sqlBuffer.append(" and  m.deliveryDate<= '");
					   sqlBuffer.append(zhi+"'  ");
					}
					if(tuihuodanwei!=null && !tuihuodanwei.equals("")){
						sqlBuffer.append("  and  m.qualified_purchase_units_id = '");
						sqlBuffer.append(tuihuodanwei+"'  ");
					}
					if(pihao!=null && !pihao.equals("")){
						sqlBuffer.append(" and m.batch_production= '");
					sqlBuffer.append(pihao+"'  ");
					}
					sqlBuffer.append(" and len(m.batch_production) > 7 ");
						reslist = returnReceivingRecordsMng.getAllReturnReceivingRecords(sqlBuffer.toString(), new HashMap<String, Object>());
						if(reslist!=null){
							for(int i = 0;i < reslist.size();i++){
								Object[] obj = (Object[]) reslist.get(i);
								ReturnReceivingRecords returnReceiving=new ReturnReceivingRecords();	
								if(obj[0]!=null){
									returnReceiving.setTuihuorq(obj[0].toString());
								}else{
									returnReceiving.setTuihuorq("");
								}
								if(obj[1]!=null){
									returnReceiving.setTuihuodw(obj[1].toString());
								}else{
									returnReceiving.setTuihuodw("");
								}
								if(obj[2]!=null){
									returnReceiving.setHuohao(obj[2].toString());
								}else{
									returnReceiving.setHuohao("");
								}
								if(obj[3]!=null){
									returnReceiving.setMingcheng(obj[3].toString());
								}else{
									returnReceiving.setMingcheng("");
								}
								if(obj[4]!=null){
									returnReceiving.setJixing(obj[4].toString());
								}else{
									returnReceiving.setJixing("");
								}
								if(obj[5]!=null){
									returnReceiving.setGuige(obj[5].toString());
								}else{
									returnReceiving.setGuige("");
								}
								if(obj[6]!=null){
									returnReceiving.setShuliang(Long.valueOf (obj[6].toString()));
								}else{
									returnReceiving.setShuliang(0L);
								}
								if(obj[7]!=null){
									returnReceiving.setPihao(obj[7].toString());
								}else{
									returnReceiving.setPihao("");
								}
								if(obj[8]!=null){
									returnReceiving.setYouxiaoqi(obj[8].toString());
								}else{
									returnReceiving.setYouxiaoqi("");
								}
								if(obj[9]!=null){
									returnReceiving.setShanghcan(obj[9].toString());
								}else{
									returnReceiving.setShanghcan("");
								}
								if(obj[10]!=null){
									returnReceiving.setTuihuodh(obj[10].toString());
								}else{
									returnReceiving.setTuihuodh("");
								}
								if(obj[12]!= null){
									returnReceiving.setBaoguanyuan(obj[12].toString());
								}
								returnReceiving.setBeizhu("");
								list.add(returnReceiving);
							}	
						}
					List<ReturnDrugsDto> returnDrugList = new ArrayList<ReturnDrugsDto>();
					for(ReturnReceivingRecords records : list ){
						returnDrugList.add(new ReturnDrugsDto(records));
					}
					String fileName = "ReturnDrugs";
					String chineseName = "退货药品记录";
					IreportUtil.export(fileName, chineseName, returnDrugList, request, response);
					return null;
		}
	} 

