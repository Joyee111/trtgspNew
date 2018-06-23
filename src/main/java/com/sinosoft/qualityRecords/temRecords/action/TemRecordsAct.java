package com.sinosoft.qualityRecords.temRecords.action;

import java.util.ArrayList;
import java.util.Calendar;
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
import com.sinosoft.qualityRecords.euqipmentOperation.model.EuqipmentOperation;
import com.sinosoft.qualityRecords.temRecords.model.HumitureRecord;
import com.sinosoft.qualityRecords.temRecords.serivice.TemRecordsMng;
import com.sinosoft.util.DisplayGetPage;

@Controller
public class TemRecordsAct {
	@Autowired
	private TemRecordsMng temRecordsMng;

	public void setTemRecordsMng(TemRecordsMng temRecordsMng) {
		this.temRecordsMng = temRecordsMng;
	}

	@RequestMapping("/qualityRecords/temRecorder/list.html")
	public ModelAndView openFramePage(EuqipmentOperation eo,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		return new ModelAndView("qualityRecords/temRecorder/list");
	}

	@RequestMapping("/qualityRecords/temRecorder/query.html")
	public ModelAndView queryEnterpristInfoList(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		// List<?> reslist=new ArrayList();
		// List<HumitureRecord> list = new ArrayList<HumitureRecord>();
		// HumitureRecord humitureRecord=new HumitureRecord();
		String location = request.getParameter("weizhi");
		String startDate = request.getParameter("kssj");
		String endDate = request.getParameter("zhi");
		String queryYear = request.getParameter("queryYear");
		String page = DisplayGetPage.getPageParamName("records", request);
		model.addAttribute("weizhi", location);
		model.addAttribute("kssj", startDate);
		model.addAttribute("zhi", endDate);
		model.addAttribute("queryYear", queryYear);
		
		/*
		 * 
		 * StringBuffer sqlBuffer = newStringBuffer(
		 * "SELECT sensorname,datetime,humidity,temperature FROM [trtgsp].[dbo].[t_humiture] where 1=1"
		 * );
		 * 
		 * if(weizhi!=null && !weizhi.equals("")){
		 * sqlBuffer.append("  and sensorname like  '%");
		 * sqlBuffer.append(weizhi+"%'  "); } if(kssj!=null &&
		 * !kssj.equals("")){ sqlBuffer.append(" and datetime >= '");
		 * sqlBuffer.append(kssj+"'  "); } if(zhi!=null && !zhi.equals("")){
		 * sqlBuffer.append(" and datetime <= '"); sqlBuffer.append(zhi+"'  ");
		 * }
		 * 
		 * reslist = temRecordsMng.getTemRecordsByPage(sqlBuffer.toString(), new
		 * HashMap<String, Object>(), (Integer.parseInt(page) - 1) *
		 * Constants.pagesize, Constants.pagesize); HumitureRecord
		 * humitureRecord3=new HumitureRecord(); if(reslist!=null){ for(int i =
		 * 0;i < reslist.size();i++){ Object[] obj = (Object[]) reslist.get(i);
		 * 
		 * if(obj[0]!=null){ humitureRecord3.setSensorname(obj[0].toString()); }
		 * if(obj[1]!=null){
		 * 
		 * humitureRecord3.setDatetime(obj[1].toString()); } if(obj[2]!=null){
		 * humitureRecord3.setHumidity(obj[2].toString()); } if(obj[3]!=null){
		 * humitureRecord3.setTemperature(obj[3].toString()); }
		 * 
		 * 
		 * 
		 * list.add(humitureRecord3); } } StringBuffer sql = newStringBuffer(
		 * "SELECT  max(temperature),max(humidity) FROM [trtgsp].[dbo].[t_humiture] where 1=1 "
		 * );
		 * 
		 * if(weizhi!=null && !weizhi.equals("")){
		 * sql.append("  and sensorname like  '%"); sql.append(weizhi+"%'  "); }
		 * if(kssj!=null && !kssj.equals("")){ sql.append(" and datetime >= '");
		 * sql.append(kssj+"'  "); } if(zhi!=null && !zhi.equals("")){
		 * sql.append(" and datetime <= '"); sql.append(zhi+"'  "); } List<?>
		 * alist=new ArrayList();
		 * alist=temRecordsMng.getTemByPage(sql.toString()); if(alist!=null){
		 * for(int i = 0;i < alist.size();i++){ Object[] obj = (Object[])
		 * alist.get(i); humitureRecord.setSensorname("最高值");
		 * humitureRecord.setDatetime(""); if(obj[0]!=null){
		 * humitureRecord.setTemperature(obj[0].toString()); } if(obj[1]!=null){
		 * 
		 * humitureRecord.setHumidity(obj[1].toString()); }
		 * 
		 * 
		 * 
		 * 
		 * list.add(humitureRecord); } } StringBuffer hql = newStringBuffer(
		 * "SELECT  min(temperature),min(humidity) FROM [trtgsp].[dbo].[t_humiture] where 1=1 "
		 * );
		 * 
		 * if(weizhi!=null && !weizhi.equals("")){
		 * hql.append("  and sensorname like  '%"); hql.append(weizhi+"%'  "); }
		 * if(kssj!=null && !kssj.equals("")){ hql.append(" and datetime >= '");
		 * hql.append(kssj+"'  "); } if(zhi!=null && !zhi.equals("")){
		 * hql.append(" and datetime <= '"); hql.append(zhi+"'  "); } List<?>
		 * blist=new ArrayList(); HumitureRecord humitureRecord2=new
		 * HumitureRecord(); blist=temRecordsMng.getHumByPage(hql.toString());
		 * if(blist!=null){ for(int i = 0;i < blist.size();i++){ Object[] obj =
		 * (Object[]) blist.get(i); humitureRecord2.setSensorname("最低值");
		 * humitureRecord2.setDatetime(""); if(obj[0]!=null){
		 * humitureRecord2.setTemperature(obj[0].toString()); }
		 * if(obj[1]!=null){
		 * 
		 * humitureRecord2.setHumidity(obj[1].toString()); }
		 * 
		 * 
		 * 
		 * 
		 * list.add(humitureRecord2); } }
		 * 
		 * StringBuffer buffer=newStringBuffer(
		 * " select count(*) FROM [trtgsp].[dbo].[t_humiture] where 1=1");
		 * 
		 * if(weizhi!=null && !weizhi.equals("")){
		 * buffer.append(" and sensorname like'%");
		 * buffer.append(weizhi+"%'  "); } if(kssj!=null && !kssj.equals("")){
		 * buffer.append(" and datetime >= '"); buffer.append(kssj+"'"); }
		 * if(zhi!=null && !zhi.equals("")){
		 * buffer.append(" and datetime <= '"); buffer.append(zhi+"'"); }
		 */
		List<HumitureRecord> recordList = null;
//		int queryYearNum = Integer.parseInt(queryYear.trim());
//		String tableName = "t_humiture";
		String tableName = "t_humiture2016";
		Calendar cal = Calendar.getInstance();
		int nowYear = cal.get(Calendar.YEAR);
//		if(queryYearNum < 2015){ //2015年前的表都为t_humiture
//			tableName = "t_humiture";
//		}else{
//			tableName = "t_humiture2015";         //暂时写死	+queryYear.trim();
//		}
//		if(queryYearNum > nowYear){//查询时间大于当前的年份,防止没有该表而导致报错
//			tableName = "t_humiture";
//		}
		
		
		if (page == null) {
			recordList = temRecordsMng.findHumAndTemByTableName(tableName, location,
					startDate, endDate, 0, Constants.pagesize);
			
		}else{
			recordList = temRecordsMng.findHumAndTemByTableName(tableName, location,
					startDate, endDate, (Integer.valueOf(page)-1)*Constants.pagesize, Constants.pagesize);
			
			
		}

		// int resultSize = temRecordsMng.getQueryCount(buffer.toString());
//		int resultSize = temRecordsMng.countHumAndTemByCondition(location,
//				startDate, endDate);
		int resultSize = temRecordsMng.countHumAndTemByTableName(tableName,location,
				startDate, endDate);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size
				/ Constants.pagesize));
		model.addAttribute("resultSize", resultSize);

		// 页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		// model.addAttribute("hr", hr);
		model.addAttribute("reslist", recordList);
		return new ModelAndView("qualityRecords/temRecorder/query");
	}
}
