package com.sinosoft.comQuery.ReturnCheckRecords.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.comQuery.ReturnCheckRecords.model.ReturnCheckRecords;
import com.sinosoft.comQuery.ReturnCheckRecords.service.ReturnCheckRecordsMng;
import com.sinosoft.comQuery.conserveAcceptRecords.model.ConserveAcceptRecords;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.ireportDTO.SalesReturnCheckDto;
import com.sinosoft.qualityRecords.complantManager.service.DrugComInfoManger;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.IreportUtil;
import com.sinosoft.util.StringUtil;

@Controller
public class ReturnCheckRecordsAct {
	@Autowired
	private ReturnCheckRecordsMng returnCheckRecordsMng;

	public void setReturnCheckRecordsMng(
			ReturnCheckRecordsMng returnCheckRecordsMng) {
		this.returnCheckRecordsMng = returnCheckRecordsMng;
	}

	private DrugComInfoManger drugComInfoManger;

	@Autowired
	public void setDrugComInfoManger(DrugComInfoManger drugComInfoManger) {
		this.drugComInfoManger = drugComInfoManger;
	}

	
	@RequestMapping("/comQuery/ReturnCheckRecords/list.html")
	public ModelAndView openFramePage(ConserveAcceptRecords cr,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Map<String, String> qsmap = drugComInfoManger.qmMap();
		model.addAttribute("qsmap", qsmap);
		return new ModelAndView("comQuery/ReturnCheckRecords/list");
	}

	@RequestMapping("/comQuery/ReturnCheckRecords/query.html")
	public ModelAndView queryEnterpristInfoList(ReturnCheckRecords rr,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		List<?> reslist = new ArrayList();
		List<ReturnCheckRecords> list = new ArrayList<ReturnCheckRecords>();
		String tuihuodanwei = request.getParameter("tuihuodanwei");
		String mingcheng = request.getParameter("mingcheng");
		String yssj = request.getParameter("yssj");
		String zhi = request.getParameter("zhi");
		String returnNo = request.getParameter("returnNo");
		String page = DisplayGetPage.getPageParamName("records", request);
		String department = request.getParameter("department");
		String isfood = request.getParameter("isfood");
		if (tuihuodanwei != null && !tuihuodanwei.equals("")) {
			QualifiedPurchaseUnits qualifiedPurchaseUnits = returnCheckRecordsMng
					.findById(tuihuodanwei);
			String name = qualifiedPurchaseUnits.getCustomerName();
			model.addAttribute("tuihuodanwei", name);
		}

		model.addAttribute("mingcheng", mingcheng);
		model.addAttribute("yssj", yssj);
		model.addAttribute("zhi", zhi);
		model.addAttribute("department", department);
		model.addAttribute("returnNo", returnNo);
		model.addAttribute("isfood", isfood);
		// StringBuffer sqlBuffer = new
		// StringBuffer("select w.ghs, w.arrival_date,w.common_name,w.specifications,w.license_number,w.batch_production,w.name,w.validateDate,w.quantity ,w.check_accept_date ,w.result,w.REALNAME,w.check_conclusion,er.REALNAME as fjr,w.qualified_medicine_id,w.qualified_purchase_units_id,w.visual_examination,w.return_no, tdf.form_name,w.qualified_quantity,w.unqualified_quantity,w.productionDate,w.is_food from "
		// +
		// " (select   u.REALNAME, r.recheck_persion_id , r.common_name,r.produceno_id,r.name,r.qualified_purchase_units_id,r. ghs,r.arrival_date,r.check_accept_date ,r.result,proposer_ID, "
		// +
		// " r.check_conclusion,r.auditor_ID ,r.goods_clerk as  sqr,r.qualified_medicine_id,r.dosage_forms,r.batch_production,r.specifications,r.license_number,r.validateDate,r.quantity,r.visual_examination,r.return_no, r.dosageforms_id,r.qualified_quantity,r.unqualified_quantity,r.productionDate,r.is_food from  "
		// +
		// " (select  h.recheck_persion_id , h.goods_clerk,  h.common_name,h.produceno_id,t.name,h.qualified_purchase_units_id,h.customer_name as ghs,h.arrival_date,h.check_accept_date ,h.result,proposer_ID, "
		// +
		// " h.check_conclusion,h.auditor_ID ,h.qualified_medicine_id,h.dosage_forms,h.batch_production,h.specifications,h.license_number,h.validateDate,h.quantity,h.visual_examination,h.return_no, h.dosageforms_id,h.qualified_quantity,h.unqualified_quantity,h.productionDate,h.is_food  from  "
		// +
		// " (select  k.recheck_persion_id , k.goods_clerk,  q.common_name,q.produceno_id,k.qualified_purchase_units_id,k.customer_name,k.arrival_date,k.check_accept_date ,k.result,proposer_ID,"
		// +
		// " k.check_conclusion,k.auditor_ID ,k.qualified_medicine_id,k.dosage_forms,k.batch_production,q.specifications,q.license_number,k.validateDate,k.quantity,k.visual_examination,k.return_no, q.dosageforms_id,k.qualified_quantity,k.unqualified_quantity,k.productionDate,q.is_food  from  "
		// +
		// " (select  u.recheck_persion_id , u.goods_clerk,  u.qualified_purchase_units_id,p.customer_name,u.arrival_date,u.check_accept_date ,u.result,proposer_ID, "
		// +
		// " u.check_conclusion,u.auditor_ID ,u.qualified_medicine_id,u.dosage_forms,u.batch_production,u.validateDate,u.quantity ,u.visual_examination,u.return_no,u.qualified_quantity,u.unqualified_quantity,u.productionDate from  "
		// +
		// " (select  n.goods_clerk, n.visual_examination, n.qualified_purchase_units_id,n.arrival_date,n.check_accept_date ,n.result,proposer_ID, "
		// +
		// " n.check_conclusion,n.auditor_ID ,i.qualified_medicine_id,i.common_name,i.dosage_forms,i.batch_production,i.validateDate,i.quantity,i.qualified_quantity,i.unqualified_quantity,i.productionDate,n.recheck_persion_id,n.return_no  "
		// +
		// " from t_return_check_accept_note n " +
		// " left join t_returncheck_item i " +
		// " on i.return_check_id=n.id " +
		// " where n.review_status=2)u " +
		// " left join t_qualified_purchase_units p " +
		// " on p.id=u.qualified_purchase_units_id)k " +
		// " left join t_qualified_medicine q " +
		// " on k.qualified_medicine_id =q.id)h " +
		// " left join t_qualifiedSupplier t " +
		// " on t.id=h.produceno_id)r " +
		// " left join TRTHR_USER u  on r.proposer_ID = u.USERID " +
		// ")w " +
		// "  left join TRTHR_USER er " +
		// "  on er.userid=w.recheck_persion_id LEFT JOIN t_dosage_form tdf ON tdf.id = w.dosageforms_id where 1=1");

		StringBuffer sqlBuffer = new StringBuffer(
				" select " +
				"p.customer_name as ghs" +//0 供货商
				",  n.arrival_date" +//1 退回日期
				", isnull(q.common_name,'') as common_name" +//2
				",q.specifications" +//3
				",q.license_number" +//4
				",i.batch_production" +//5
				",t.name" +//6
				",i.validateDate" +//7
				",i.quantity" +//8
				",i.invalid_quantity "+//15//退回供应商数量
				",n.check_accept_date" +//9
				",n.result" +//10
				",u.REALNAME" +//11 验收员
				",n.check_conclusion" +//12
				",er.REALNAME as fjr" +//13
				",i.qualified_medicine_id" +//14
				",n.qualified_purchase_units_id" +//16
				",n.visual_examination" +//17
				",n.return_no" +//18
				",n.review_time "+//19 复检日期
				",tdf.form_name" +//20
				",i.qualified_quantity" +//21 合格数量
				",i.unqualified_quantity" +//22 不合格数量
				",i.productionDate" +//23 生产日期
				",q.medc_no" +//货号24
				",isnull(u2.REALNAME,'') as ysr " +//25
				",ISNULL(n.checkAcceptDate2,'') "+//26 productionDate 验收日期2
				"  from t_return_check_accept_note n left join t_returncheck_item i on i.return_check_id=n.id "+
				" left join t_qualified_purchase_units p on p.id=n.qualified_purchase_units_id"+
				" left join t_qualified_medicine q on i.qualified_medicine_id =q.id"+
				" left join t_qualifiedSupplier t on t.id=q.produceno_id "+
				"  left join TRTHR_USER u on n.proposer_ID = u.USERID"+//验收员1
				" left join TRTHR_USER u2 on n.accepterId = u2.USERID"+//验收员2
				" left join TRTHR_USER er on n.recheck_persion_id = er.USERID"+//复检人
				" LEFT JOIN t_dosage_form tdf ON tdf.id = q.dosageforms_id   where n.review_status=2 ");

		if (tuihuodanwei != null && !tuihuodanwei.equals("")) {
			sqlBuffer.append("  and  n.qualified_purchase_units_id = '");
			sqlBuffer.append(tuihuodanwei + "'  ");
		}
		if (mingcheng != null && !mingcheng.equals("")) {
			sqlBuffer.append(" and i.qualified_medicine_id = '");
			sqlBuffer.append(mingcheng + "'  ");
		}
		if (yssj != null && !yssj.equals("")) {
			sqlBuffer.append(" and CONVERT(date,n.arrival_date,120)>= CONVERT(date,'");
			sqlBuffer.append(yssj + "',120)  ");
		}
		if (zhi != null && !zhi.equals("")) {
			sqlBuffer.append(" and CONVERT(date,n.arrival_date,120)<= CONVERT(date,'");
			sqlBuffer.append(zhi + "',120)  ");
		}
		if (department != null && !"".equals(department.trim())) {
			sqlBuffer.append(" and n.return_no like '" + department + "%' ");
		}
		if (null != returnNo && !"".equals(returnNo.trim())) {
			sqlBuffer.append(" and n.return_no like '%" + returnNo + "%' ");
		}
		if (isfood != null && !"".equals(isfood.trim())) {
			sqlBuffer.append(" and q.is_food like '" + isfood + "%' ");
		}
		sqlBuffer.append(" and len(i.batch_production) > 7 ");
		sqlBuffer.append(" order by arrival_date desc");
		reslist = returnCheckRecordsMng.getReturnCheckRecordsByPage(sqlBuffer
				.toString(), new HashMap<String, Object>(), (Integer
				.parseInt(page) - 1)
				* Constants.pagesize, Constants.pagesize);
		if (reslist != null) {
			for (int i = 0; i < reslist.size(); i++) {
				Object[] obj = (Object[]) reslist.get(i);
				ReturnCheckRecords returnCheck = new ReturnCheckRecords();
				if (obj[0] != null) {
					returnCheck.setTuihuidw(obj[0].toString());
				}
				if (obj[1] != null) {
					returnCheck.setTuihuiriqi(obj[1].toString());
				}
				if (obj[2] != null) {
					returnCheck.setPinming(obj[2].toString());
				}
				if (obj[3] != null) {
					returnCheck.setGuige(obj[3].toString());
				}
				if (obj[4] != null) {
					returnCheck.setPizhunwh(obj[4].toString());
				}
				if (obj[5] != null) {
					returnCheck.setPihao(obj[5].toString());
				}
				if (obj[6] != null) {
					returnCheck.setShengchancj(obj[6].toString());
				}
				if (obj[7] != null) {
					returnCheck.setYouxiaoqi(obj[7].toString());
				}
				if (obj[8] != null) {
					returnCheck.setShuliang(Long.valueOf(obj[8].toString()));
				}
				if (obj[9] != null) {
					returnCheck.setTuihuigongyingshangshuliang(obj[9].toString());
				}
				if (obj[10] != null) {
					returnCheck.setYanshourq(obj[10].toString());
				}
				if (obj[11] != null) {
					returnCheck.setYanshoujg(obj[11].toString());
				}
				if (obj[12] != null) {
					returnCheck.setYanshouyuan(obj[12].toString());
				}
				if (obj[13] != null) {
					returnCheck.setJianchajl(obj[13].toString());
				}
				if (obj[14] != null) {
					returnCheck.setFuyanry(obj[14].toString());
				}
				
				
				if (obj[17] != null) {
					returnCheck.setFuchajielun(obj[17].toString());
				}
				if (obj[18] != null) {
					returnCheck.setXiaoshougongsi(obj[18].toString());
				}
				if (obj[19] != null) {
					returnCheck.setFujianriqi(obj[19].toString());
				}
				if (obj[20] != null) {
					returnCheck.setJixing(obj[20].toString());
				}
				if (obj[21] != null) {
					returnCheck.setHegshuliang(obj[21].toString());
				}
				if (obj[22] != null) {
					returnCheck.setBuhegeshuliang(obj[22].toString());
				}
				if (obj[23] != null) {
					returnCheck.setShengchanriqi(obj[23].toString());
				}
				if(obj[24] !=null){
					returnCheck.setHuohao(obj[24].toString());
				}
				if(obj[25]!=null){
					returnCheck.setYanshouyuan2(obj[25].toString());
				}
				
				if(obj[26]!=null){
					returnCheck.setYanshourq2(obj[26].toString());
				}
				
				
				list.add(returnCheck);
			}
		}
		StringBuffer buffer = new StringBuffer(
				" select count(*) from "
						+ " (select  r.recheck_persion_id,  r.common_name,r.produceno_id,r.name,r.qualified_purchase_units_id,r.ghs,r.arrival_date,r.check_accept_date ,r.result,proposer_ID, "
						+ " r.check_conclusion,r.auditor_ID ,r.goods_clerk as  sqr,r.qualified_medicine_id,r.dosage_forms,r.batch_production,r.specifications,r.license_number,r.validateDate,r.quantity,r.return_no,r.is_food  from  "
						+ " (select  h.recheck_persion_id, h.goods_clerk, h.common_name,h.produceno_id,t.name,h.qualified_purchase_units_id,h.customer_name as ghs,h.arrival_date,h.check_accept_date ,h.result,proposer_ID, "
						+ " h.check_conclusion,h.auditor_ID ,h.qualified_medicine_id,h.dosage_forms,h.batch_production,h.specifications,h.license_number,h.validateDate,h.quantity,h.return_no,h.is_food  from  "
						+ " (select  k.recheck_persion_id, k.goods_clerk,  q.common_name,q.produceno_id,k.qualified_purchase_units_id,k.customer_name,k.arrival_date,k.check_accept_date ,k.result,proposer_ID,"
						+ " k.check_conclusion,k.auditor_ID ,k.qualified_medicine_id,k.dosage_forms,k.batch_production,q.specifications,q.license_number,k.validateDate,k.quantity,k.return_no,q.is_food  from  "
						+ " (select  u.recheck_persion_id,  u.goods_clerk, u.qualified_purchase_units_id,p.customer_name,u.arrival_date,u.check_accept_date ,u.result,proposer_ID, "
						+ " u.check_conclusion,u.auditor_ID ,u.qualified_medicine_id,u.dosage_forms,u.batch_production,u.validateDate,u.quantity,u.return_no  from  "
						+ " (select  n.goods_clerk, n.qualified_purchase_units_id,n.arrival_date,n.check_accept_date ,n.result,proposer_ID, "
						+ " n.check_conclusion,n.auditor_ID ,i.qualified_medicine_id,i.common_name,i.dosage_forms,i.batch_production,i.validateDate,i.quantity,n.recheck_persion_id,n.return_no  "
						+ " from t_return_check_accept_note n "
						+ " left join t_returncheck_item i "
						+ " on i.return_check_id=n.id "
						+ " where n.review_status=2)u "
						+ " left join t_qualified_purchase_units p "
						+ " on p.id=u.qualified_purchase_units_id)k "
						+ " left join t_qualified_medicine q "
						+ " on k.qualified_medicine_id =q.id)h "
						+ " left join t_qualifiedSupplier t "
						+ " on t.id=h.produceno_id)r "
						+ "  left join TRTHR_USER u  on r.proposer_ID = u.USERID"
						+ "  )w " + "  left join TRTHR_USER er "
						+ "  on er.userid=w.recheck_persion_id   where 1=1");

		if (tuihuodanwei != null && !tuihuodanwei.equals("")) {
			buffer.append("  and  w.qualified_purchase_units_id = '");
			buffer.append(tuihuodanwei + "'  ");
		}
		if (mingcheng != null && !mingcheng.equals("")) {
			buffer.append(" and w.qualified_medicine_id  = '");
			buffer.append(mingcheng + "'  ");
		}
		if (yssj != null && !yssj.equals("")) {
			buffer.append(" and CONVERT(date,w.arrival_date,120)>= CONVERT(date,'");
			buffer.append(yssj + "',120)  ");
		}
		if (zhi != null && !zhi.equals("")) {
			buffer.append(" and CONVERT(date,w.arrival_date,120)<= CONVERT(date,'");
			buffer.append(zhi + "',120)  ");
		}
		if (department != null && !"".equals(department.trim())) {
			buffer.append(" and w.return_no like '" + department + "%' ");
		}
		if (null != returnNo && !"".equals(returnNo.trim())) {
			buffer.append(" and w.return_no like '%" + returnNo + "%' ");
		}
		if (isfood != null && !"".equals(isfood.trim())) {
			buffer.append(" and w.is_food like '" + isfood + "%' ");
		}
		buffer.append(" and len(w.batch_production) > 7 ");
		int resultSize = returnCheckRecordsMng.getQueryCount(buffer.toString());
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size
				/ Constants.pagesize));
		model.addAttribute("resultSize", resultSize);

		// 页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("rr", rr);
		model.addAttribute("reslist", list);

		return new ModelAndView("comQuery/ReturnCheckRecords/query");
	}

	@RequestMapping("/comQuery/ReturnCheckRecords/exportAll.html")
	public ModelAndView getAllEnterpristInfoList(ReturnCheckRecords rr,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		List<?> reslist = new ArrayList();
		List<ReturnCheckRecords> list = new ArrayList<ReturnCheckRecords>();
		String tuihuodanwei = request.getParameter("tuihuodanwei");
		String mingcheng = request.getParameter("mingcheng");
		String yssj = request.getParameter("yssj");
		String zhi = request.getParameter("zhi");
		String department = request.getParameter("department");
		String returnNo = request.getParameter("returnNo");
		String page = DisplayGetPage.getPageParamName("records", request);
		if (tuihuodanwei != null && !tuihuodanwei.equals("")) {
			QualifiedPurchaseUnits qualifiedPurchaseUnits = returnCheckRecordsMng
					.findById(tuihuodanwei);
			String name = qualifiedPurchaseUnits.getCustomerName();
			model.addAttribute("tuihuodanwei", name);
		}

		model.addAttribute("mingcheng", mingcheng);
		model.addAttribute("yssj", yssj);
		model.addAttribute("zhi", zhi);
		model.addAttribute("department", department);
		StringBuffer sqlBuffer = new StringBuffer(
				"select w.ghs, w.arrival_date,w.common_name,w.specifications,w.license_number,w.batch_production,w.name,w.validateDate,w.quantity ,w.check_accept_date ,w.result,w.REALNAME,w.check_conclusion,er.REALNAME as fjr,w.qualified_medicine_id,w.qualified_purchase_units_id,w.visual_examination,w.return_no, tdf.form_name,w.qualified_quantity,w.unqualified_quantity,w.productionDate,w.report_no,w.unit,w.pack_rate,w.medc_no,w.review_time from "
						+ " (select r.medc_no, r.report_no,r.pack_rate,  u.REALNAME, r.recheck_persion_id , r.common_name,r.produceno_id,r.name,r.qualified_purchase_units_id,r. ghs,r.arrival_date,r.check_accept_date ,r.result,proposer_ID, "
						+ " r.check_conclusion,r.auditor_ID ,r.goods_clerk as  sqr,r.qualified_medicine_id,r.dosage_forms,r.batch_production,r.specifications,r.license_number,r.validateDate,r.quantity,r.visual_examination,r.return_no, r.dosageforms_id,r.qualified_quantity,r.unqualified_quantity,r.productionDate,r.unit,r.review_time from  "
						+ " (select h.medc_no, h.report_no,h.pack_rate, h.recheck_persion_id , h.goods_clerk,  h.common_name,h.produceno_id,t.name,h.qualified_purchase_units_id,h.customer_name as ghs,h.arrival_date,h.check_accept_date ,h.result,proposer_ID, "
						+ " h.check_conclusion,h.auditor_ID ,h.qualified_medicine_id,h.dosage_forms,h.batch_production,h.specifications,h.license_number,h.validateDate,h.quantity,h.visual_examination,h.return_no, h.dosageforms_id,h.qualified_quantity,h.unqualified_quantity,h.productionDate,h.unit,h.review_time  from  "
						+ " (select q.medc_no,k.report_no,s.pack_rate, k.recheck_persion_id , k.goods_clerk,  q.common_name,q.produceno_id,k.qualified_purchase_units_id,k.customer_name,k.arrival_date,k.check_accept_date ,k.result,proposer_ID,"
						+ " k.check_conclusion,k.auditor_ID ,k.qualified_medicine_id,k.dosage_forms,k.batch_production,q.specifications,q.license_number,q.unit,k.validateDate,k.quantity,k.visual_examination,k.return_no, q.dosageforms_id,k.qualified_quantity,k.unqualified_quantity,k.productionDate,k.review_time  from  "
						+ " (select u.report_no, u.recheck_persion_id , u.goods_clerk,  u.qualified_purchase_units_id,p.customer_name,u.arrival_date,u.check_accept_date ,u.result,proposer_ID, "
						+ " u.check_conclusion,u.auditor_ID ,u.qualified_medicine_id,u.dosage_forms,u.batch_production,u.validateDate,u.quantity ,u.visual_examination,u.return_no,u.qualified_quantity,u.unqualified_quantity,u.productionDate,u.review_time from  "
						+ " (select n.report_no, n.goods_clerk, n.visual_examination, n.qualified_purchase_units_id,n.arrival_date,n.check_accept_date ,n.result,proposer_ID, "
						+ " n.check_conclusion,n.auditor_ID ,i.qualified_medicine_id,i.common_name,i.dosage_forms,i.batch_production,i.validateDate,i.quantity,i.qualified_quantity,i.unqualified_quantity,i.productionDate,n.recheck_persion_id,n.return_no,n.review_time  "
						+ " from t_return_check_accept_note n "
						+ " left join t_returncheck_item i "
						+ " on i.return_check_id=n.id "
						+ " where n.review_status=2)u "
						+ " left join t_qualified_purchase_units p "
						+ " on p.id=u.qualified_purchase_units_id)k "
						+ " left join t_qualified_medicine q "
						+ " on k.qualified_medicine_id =q.id LEFT JOIN t_medc_price s ON q.medc_no = s.medc_no )h "
						+ " left join t_qualifiedSupplier t "
						+ " on t.id=h.produceno_id)r "
						+ " left join TRTHR_USER u  on r.proposer_ID = u.USERID "
						+ ")w "
						+ "  left join TRTHR_USER er "
						+ "  on er.userid=w.recheck_persion_id LEFT JOIN t_dosage_form tdf ON tdf.id = w.dosageforms_id where 1=1");

		if (tuihuodanwei != null && !tuihuodanwei.equals("")) {
			sqlBuffer.append("  and  w.qualified_purchase_units_id = '");
			sqlBuffer.append(tuihuodanwei + "'  ");
		}
		if (mingcheng != null && !mingcheng.equals("")) {
			sqlBuffer.append(" and w.qualified_medicine_id = '");
			sqlBuffer.append(mingcheng + "'  ");
		}
		if (yssj != null && !yssj.equals("")) {
			sqlBuffer.append(" and w.arrival_date>= '");
			sqlBuffer.append(yssj + "'  ");
		}
		if (zhi != null && !zhi.equals("")) {
			sqlBuffer.append(" and w.arrival_date<= '");
			sqlBuffer.append(zhi + "'  ");
		}
		if (department != null && !"".equals(department.trim())) {
			sqlBuffer.append(" and w.return_no like '" + department + "%' ");
		}
		if (returnNo != null && !"".equals(returnNo.trim())) {
			sqlBuffer.append(" and w.return_no like '" + returnNo + "%' ");
		}
		sqlBuffer.append(" and len(w.batch_production) > 7 ");

		reslist = returnCheckRecordsMng.getAllReturnCheckRecord(sqlBuffer
				.toString(), new HashMap<String, Object>());
		if (reslist != null) {
			for (int i = 0; i < reslist.size(); i++) {
				Object[] obj = (Object[]) reslist.get(i);
				ReturnCheckRecords returnCheck = new ReturnCheckRecords();
				if (obj[0] != null) {
					returnCheck.setTuihuidw(obj[0].toString());
				}
				if (obj[1] != null) {
					returnCheck.setTuihuiriqi(obj[1].toString());
				}
				if (obj[2] != null) {
					returnCheck.setPinming(obj[2].toString());
				}
				if (obj[3] != null) {
					returnCheck.setGuige(obj[3].toString());
				}
				if (obj[4] != null) {
					returnCheck.setPizhunwh(obj[4].toString());
				}
				if (obj[5] != null) {
					returnCheck.setPihao(obj[5].toString());
				}
				if (obj[6] != null) {
					returnCheck.setShengchancj(obj[6].toString());
				}
				if (obj[7] != null) {
					returnCheck.setYouxiaoqi(obj[7].toString());
				}
				if (obj[8] != null) {
					returnCheck.setShuliang(Long.valueOf(obj[8].toString()));
				}

				if (obj[9] != null) {
					returnCheck.setYanshourq(obj[9].toString());
				}
				if (obj[10] != null) {
					returnCheck.setYanshoujg(obj[10].toString());
				}
				if (obj[11] != null) {
					returnCheck.setYanshouyuan(obj[11].toString());
				}
				if (obj[12] != null) {
					returnCheck.setJianchajl(obj[12].toString());
				}
				if (obj[13] != null) {
					returnCheck.setFuyanry(obj[13].toString());
				}
				if (obj[16] != null) {
					returnCheck.setFuchajielun(obj[16].toString());
				}
				if (obj[17] != null) {
					returnCheck.setTuihuodanhao(obj[17].toString());
				}
				if (obj[18] != null) {
					returnCheck.setJixing(obj[18].toString());
				}
				if (obj[19] != null) {
					returnCheck.setHegshuliang(obj[19].toString());
				}
				if (obj[20] != null) {
					returnCheck.setBuhegeshuliang(obj[20].toString());
				}
				if (obj[21] != null) {
					returnCheck.setShengchanriqi(obj[21].toString());
				}
				if (obj[22] != null) {
					returnCheck.setBaogaodanhao(obj[22].toString());
				}
				if (obj[23] != null) {
					returnCheck.setUnit(obj[23].toString());
				}
				if (obj[24] != null) {
					String pack_rate = obj[24].toString();
					String quality = returnCheck.getShuliang().toString();
					String js = StringUtil.formatFloatString(String
							.valueOf((Float.valueOf(quality) / Float
									.valueOf(pack_rate))));
					returnCheck.setJianshu(js);
				}
				if (obj[25] != null) {
					returnCheck.setHuohao(obj[25].toString());
				}
				if (obj[26] != null) {
					returnCheck.setFujianriqi(obj[26].toString());
				}
				list.add(returnCheck);
			}
		}
		List<SalesReturnCheckDto> returnCheckDtoList = new ArrayList<SalesReturnCheckDto>();
		for (ReturnCheckRecords record : list) {
			returnCheckDtoList.add(new SalesReturnCheckDto(record));
		}
		String file = "SalesReturnCheck";
		String chineseName = "销售退回验收记录";
		IreportUtil.export(file, chineseName, returnCheckDtoList, request,
				response);
		return null;
	}
}
