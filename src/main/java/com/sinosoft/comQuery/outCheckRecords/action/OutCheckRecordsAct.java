package com.sinosoft.comQuery.outCheckRecords.action;

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
import com.sinosoft.comQuery.conserveAcceptRecords.model.ConserveAcceptRecords;
import com.sinosoft.comQuery.outCheckRecords.model.OutCheckRecords;
import com.sinosoft.comQuery.outCheckRecords.service.OutCheckRecordsMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.DisplayGetPage;

@Controller
public class OutCheckRecordsAct {
	@Autowired
	private ReturnCheckRecordsMng returnCheckRecordsMng;

	public void setReturnCheckRecordsMng(ReturnCheckRecordsMng returnCheckRecordsMng) {
		this.returnCheckRecordsMng = returnCheckRecordsMng;
	}
	private OutCheckRecordsMng outCheckRecordsMng;
	@Autowired
	public void setOutCheckRecordsMng(OutCheckRecordsMng outCheckRecordsMng) {
		this.outCheckRecordsMng = outCheckRecordsMng;
	}
	
	@RequestMapping("/comQuery/outCheckRecords/list.html")
	public ModelAndView openFramePage(ConserveAcceptRecords cr, HttpServletRequest request, HttpServletResponse response, Model model){
		    
			return new ModelAndView("comQuery/outCheckRecords/list");
		}
	@RequestMapping("/comQuery/outCheckRecords/query.html")
  	public ModelAndView queryEnterpristInfoList( OutCheckRecords oc,Model model,HttpServletRequest request,HttpServletResponse response){
		List<?> reslist=new ArrayList();
		List<OutCheckRecords> list = new ArrayList<OutCheckRecords>();
		String tuihuodanwei= request.getParameter("tuihuodanwei");
		String pihao= request.getParameter("pihao");
		String xsdh= request.getParameter("xsdh");
		String cksj= request.getParameter("cksj");
		String zhi= request.getParameter("zhi");
		String page = DisplayGetPage.getPageParamName("records", request);
		if(tuihuodanwei!=null &&  !tuihuodanwei.equals("")){
			QualifiedPurchaseUnits qualifiedPurchaseUnits=	returnCheckRecordsMng.findById(tuihuodanwei);
			  String	name=qualifiedPurchaseUnits.getCustomerName();
				model.addAttribute("tuihuodanwei", name);	
		}
	
		model.addAttribute("pihao", pihao);
		model.addAttribute("xsdh", xsdh);
		model.addAttribute("cksj", cksj);
		model.addAttribute("zhi", zhi);
				StringBuffer sqlBuffer = new StringBuffer(
						"select  p.customer_name,q.common_name,df.form_name,q.specifications,i.quantity,"+
						"c.name AS sccs,i.batch_no,i.validityTime,er.REALNAME as ckr,uer.REALNAME as fhr," +
						" b.remark,b.sales_time,b.qualifiedPurchaseUnits_id,b.quality_situation,b.sales_number,  " +
						" b.review_time, b.review_status,user2.REALNAME as fhr2" +
						" from t_outbound_check_bill  b  " +
						" left join t_outbound_check_item  i  on b.id=i.outbound_check_bill_id" +
						" left join t_qualified_purchase_units p  on p.id=b.qualifiedPurchaseUnits_id" +
						" left join t_qualified_medicine q  on i.qualified_medicine_id=q.id" +
						" left join   t_qualifiedSupplier c  on c.id=q.produceno_id" +
						" left join t_dosage_form df   on q.dosageforms_id=df.id  " +
						" left join TRTHR_USER uer   on uer.userid=b.auditor_ID   " +
						" left join TRTHR_USER er   on er.userid=b.proposer_ID " +
						" left join TRTHR_USER user2 on user2.USERID = b.auditor2_ID" +
						" where  1=1 and b.review_status='2' and b.quality_situation = '1' and i.quantity > 0 " +
						"        and b.id not in ( select b.id  "+
						"						   from t_outbound_check_bill  b "+
													       "left join t_outbound_check_item  i  on b.id=i.outbound_check_bill_id "+
													       "left join t_qualified_medicine q  on i.qualified_medicine_id=q.id "+
                                                           "where i.batch_no = '17010723' and q.medc_no = '40100119'  and b.review_time >= cast('2014-07-14' as datetime))");

				if(tuihuodanwei!=null && !tuihuodanwei.equals("")){
					sqlBuffer.append("  and  b.qualifiedPurchaseUnits_id = '");
					sqlBuffer.append(tuihuodanwei+"'  ");
				}

				if(pihao!=null && !pihao.equals("")){
					sqlBuffer.append(" and i.batch_no= '");
				sqlBuffer.append(pihao+"'  ");
				}
				
				if(xsdh!=null && !xsdh.equals("")){
					sqlBuffer.append(" and b.sales_number like '%");
				sqlBuffer.append(xsdh+"%'  ");
				}
				if(cksj!=null && !cksj.equals("")){
					sqlBuffer.append(" and CONVERT(datetime,CONVERT(varchar(10),b.review_time,20),20)>= ");
				sqlBuffer.append("CONVERT(datetime,'"+cksj+"',20)  ");
				}
				if(zhi!=null && !zhi.equals("")){
					sqlBuffer.append(" and CONVERT(datetime,CONVERT(varchar(10),b.review_time,20),20)<= ");
				sqlBuffer.append("CONVERT(datetime,'"+zhi+"',20)  ");
				}
				sqlBuffer.append(" and LEN(i.batch_no) > 7 " );
				sqlBuffer.append(" order by b.sales_time DESC " );
					reslist = outCheckRecordsMng.getOutCheckRecordsByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
					if(reslist!=null){
						for(int i = 0;i < reslist.size();i++){
							Object[] obj = (Object[]) reslist.get(i);
							OutCheckRecords outCheck =new OutCheckRecords();
							if(obj[1].equals("安宫牛黄丸")&& DateTimeUtils.compareTwoDate(obj[11].toString(), "2014-07-14")==1){
								continue;
							}
							
							if(obj[0]!=null){
								outCheck.setGouhuodw(obj[0].toString());
							}
							if(obj[1]!=null){
								outCheck.setYaopinm(obj[1].toString());
							}
							if(obj[2]!=null){
								outCheck.setJixing(obj[2].toString());
							}
							if(obj[3]!=null){
								outCheck.setGuige(obj[3].toString());
							}
							if(obj[4]!=null){
								outCheck.setShuliang(Long.valueOf (obj[4].toString()));
							}
							if(obj[5]!=null){
								outCheck.setShengchancj(obj[5].toString());
							}
							if(obj[6]!=null){
								outCheck.setPihao(obj[6].toString());
							}
							if(obj[7]!=null){
								outCheck.setYouxiaoqi(obj[7].toString());
							}
							if(obj[13]!=null){
								if(obj[13].equals("2")){
									outCheck.setZhiliangzk("不合格");	
								}else{
									outCheck.setZhiliangzk("合格");	
								}
							
							}
							if(obj[8]!=null){
								outCheck.setChukuren(obj[8].toString());
							}
							if(obj[9]!=null){
								outCheck.setFuheren(obj[9].toString());
							}
							if(obj[10]!=null){
								outCheck.setBeizhu(obj[10].toString());
							}
							if(obj[11]!=null){
								outCheck.setXiaoshourq(obj[11].toString());
							}
							if(obj[14]!=null){
								outCheck.setXiaoshoudanhao(obj[14].toString());
							}
							
							if(obj[17]!=null){
								outCheck.setFuheren2(obj[17].toString());
							}
							
							list.add(outCheck);
						}	
					}
					StringBuffer buffer = new StringBuffer(
							"select  count(*) " +
							" from t_outbound_check_bill  b  " +
							" left join t_outbound_check_item  i  on b.id=i.outbound_check_bill_id" +
							" left join t_qualified_purchase_units p  on p.id=b.qualifiedPurchaseUnits_id" +
							" left join t_qualified_medicine q  on i.qualified_medicine_id=q.id" +
							" left join   t_qualifiedSupplier c  on c.id=q.produceno_id" +
							" left join t_dosage_form df   on q.dosageforms_id=df.id  " +
							" left join TRTHR_USER uer   on uer.userid=b.auditor_ID   " +
							" left join TRTHR_USER er   on er.userid=b.proposer_ID " +
							" left join TRTHR_USER user2 on user2.USERID = b.auditor2_ID" +
							" where  1=1 and b.review_status='2' and b.quality_situation = '1' and i.quantity > 0 "+
							"        and b.id not in ( select b.id  "+
							"						   from t_outbound_check_bill  b "+
														       "left join t_outbound_check_item  i  on b.id=i.outbound_check_bill_id "+
														       "left join t_qualified_medicine q  on i.qualified_medicine_id=q.id "+
	                                                           "where i.batch_no = '17010723' and q.medc_no = '40100119'  and b.review_time >= cast('2014-07-14' as datetime))");

				if(tuihuodanwei!=null && !tuihuodanwei.equals("")){
					buffer.append("  and  b.qualifiedPurchaseUnits_id = '");
					buffer.append(tuihuodanwei+"'  ");
				}
				if(pihao!=null && !pihao.equals("")){
					buffer.append(" and i.batch_no= '");
					buffer.append(pihao+"'  ");
				}
				if(xsdh!=null && !xsdh.equals("")){
					buffer.append(" and b.sales_number like '%");
					buffer.append(xsdh+"%'  ");
				}
				
				if(cksj!=null && !cksj.equals("")){
					buffer.append(" and CONVERT(datetime,CONVERT(varchar(10),b.review_time,20),20) >= ");
					buffer.append("CONVERT(datetime,'"+cksj+"',20)  ");
				}
				if(zhi!=null && !zhi.equals("")){
					buffer.append(" and CONVERT(datetime,CONVERT(varchar(10),b.review_time,20),20)<= ");
					buffer.append("CONVERT(datetime,'"+zhi+"',20)  ");
				}
				buffer.append(" and LEN(i.batch_no) > 7 " );
				int resultSize = outCheckRecordsMng.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
				
		//页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("oc", oc);
		model.addAttribute("reslist", list);
		return new ModelAndView("comQuery/outCheckRecords/query");
	}
}
