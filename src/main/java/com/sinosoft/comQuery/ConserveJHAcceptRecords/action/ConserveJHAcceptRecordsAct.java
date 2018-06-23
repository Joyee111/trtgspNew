package com.sinosoft.comQuery.ConserveJHAcceptRecords.action;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;
import jxl.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.qualityRecords.drugMaintenanceJH.dao.DrugMaintenanceJHDao;
import com.sinosoft.qualityRecords.drugMaintenanceJH.model.DrugMaintenanceJH;
import com.sinosoft.qualityRecords.drugMaintenanceJH.service.DrugMaintenanceJHMng;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.UtilJson;

@Controller
public class ConserveJHAcceptRecordsAct {
	@Autowired
	private DrugMaintenanceJHMng drugMaintenanceJHMng;
	@Autowired
	private DrugMaintenanceJHDao drugMaintenanceJHDao;
	@Autowired
	public void setDrugMaintenanceJHMng(DrugMaintenanceJHMng drugMaintenanceJHMng) {
		this.drugMaintenanceJHMng = drugMaintenanceJHMng;
	}
	
	@RequestMapping("/comQuery/conserveJHAcceptRecords/list.html")
	public ModelAndView openFramePage(DrugMaintenanceJH dm, HttpServletRequest request, HttpServletResponse response, Model model){
		
			return new ModelAndView("comQuery/conserveJHAcceptRecords/list");
		}
	@RequestMapping("/comQuery/conserveJHAcceptRecords/query.html")
  	public ModelAndView queryEnterpristInfoList( DrugMaintenanceJH dm,Model model,HttpServletRequest request,HttpServletResponse response){
		List<?> reslist=new ArrayList();
		String jianchariqi= request.getParameter("jianchariqi");
		String zhi= request.getParameter("zhi");
		String pihao= request.getParameter("pihao");
		String mingcheng= request.getParameter("mingcheng");
		String page = DisplayGetPage.getPageParamName("records", request);
		model.addAttribute("jianchariqi", jianchariqi);
		model.addAttribute("zhi", zhi);
		model.addAttribute("mingcheng", mingcheng);
		model.addAttribute("pihao", pihao);
		if(page==null){
			//如果page等于空，默认从第一条开始查询	
			reslist= drugMaintenanceJHMng.getPage(dm,0,Constants.pagesize);	
		}else{
				StringBuffer sqlBuffer = new StringBuffer("select  d  from DrugMaintenanceJH  d where 1 = 1 ");
								
				if(jianchariqi!=null && !jianchariqi.equals("")){
					sqlBuffer.append(" and  CONVERT(datetime,d.maintainDate,20)  >=CONVERT(datetime,'"+jianchariqi+"',20) ");
					
				}
				if(zhi!=null && !zhi.equals("")){
					sqlBuffer.append(" and  CONVERT(datetime,d.maintainDate,20) <=CONVERT(datetime,'"+zhi+"',20) ");
					
				}
				if(mingcheng!=null && !mingcheng.equals("")){
					sqlBuffer.append(" and d.medcName like '%"+mingcheng+"%' ");
				
				}
				if(pihao!=null && !pihao.equals("")){
					sqlBuffer.append(" and d.batchNumber ='"+pihao+"' ");
				
				}
				
				sqlBuffer.append(" order by d.maintainDate,d.id DESC ");
				if(page==null){
					reslist= drugMaintenanceJHMng.getPage(dm,0,Constants.pagesize);
				}else{
					reslist = drugMaintenanceJHMng.getDrugMaintenanceByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
				}
			
				StringBuffer buffer=new StringBuffer(" SELECT  count(*) FROM t_maintain_info_JH d where 1 = 1 " );
				
				
				if(jianchariqi!=null && !jianchariqi.equals("")){
					buffer.append(" and  CONVERT(datetime,d.maintain_date, 20)  >=CONVERT(datetime,'"+jianchariqi+"', 20) ");
					
				}
				if(zhi!=null && !zhi.equals("")){
					buffer.append(" and  CONVERT(datetime,d.maintain_date, 20) <=CONVERT(datetime,'"+zhi+"', 20) ");
					
				}
				if(mingcheng!=null && !mingcheng.equals("")){
					buffer.append(" and medc_name like '%"+mingcheng+"%' ");
				
				}
				if(pihao!=null && !pihao.equals("")){
					buffer.append(" and d.batch_number ='"+pihao+"' ");
				
				}
				int resultSize = drugMaintenanceJHMng.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
				
			}
		

		
		//页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("dm", dm);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("comQuery/conserveJHAcceptRecords/query");
	}
	
	@RequestMapping("/comQuery/conserveJHAcceptRecords/ajaxUploadUpdate.html")
	public void loadFileUp(HttpServletRequest request,	HttpServletResponse response) {
		String ss=null;
		try {
			ss=upLoadFile(request,response,drugMaintenanceJHDao);
			String [] s=ss.split(",");
			UtilJson.print(response, "成功导入"+s[1]+"条");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String upLoadFile(HttpServletRequest request ,HttpServletResponse response,DrugMaintenanceJHDao drugMaintenanceJHDao )throws IOException {

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 得到上传的文件
		MultipartFile mFile = multipartRequest.getFile("loadUp");
		String ss=saveToDb(mFile,drugMaintenanceJHDao);
		return ss;
	}
	
	public static List<DrugMaintenanceJH> getAllByExcel(MultipartFile file){
        List<DrugMaintenanceJH> list=new ArrayList<DrugMaintenanceJH>();
        try {
            Workbook rwb=Workbook.getWorkbook(file.getInputStream());
            Sheet rs=rwb.getSheet(0);//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String customerId=rs.getCell(j++, i).getContents();
                    String customerName=rs.getCell(j++, i).getContents();
                	String medcCode=rs.getCell(j++, i).getContents();
                	String medcName=rs.getCell(j++, i).getContents();
                	String specifications=rs.getCell(j++, i).getContents();
                	String unit=rs.getCell(j++, i).getContents();
                	String dosageforms=rs.getCell(j++, i).getContents();
                	String supplier=rs.getCell(j++, i).getContents();
                	String licenseNumber=rs.getCell(j++, i).getContents();
                	String trademark=rs.getCell(j++, i).getContents();
                	String quantity=rs.getCell(j++, i).getContents();
                	String batchNumber=rs.getCell(j++, i).getContents();
                	String endTime=rs.getCell(j++, i).getContents();
                	String result=rs.getCell(j++, i).getContents();
                	String conclusion=rs.getCell(j++, i).getContents();
                	String conserveType=rs.getCell(j++, i).getContents();
                	String conservationStaff=rs.getCell(j++, i).getContents();
                	String maintainDate=rs.getCell(j++, i).getContents();
                	String arrivalDate=rs.getCell(j++, i).getContents();
                	String printFlag=rs.getCell(j++, i).getContents();
                	String conservationStaff2=rs.getCell(j++, i).getContents();
                	
                	SimpleDateFormat sdf = new SimpleDateFormat("yy-M-d");
                	Date date = sdf.parse(endTime);
                	Date date2 = sdf.parse(maintainDate);
                	Date date3 = sdf.parse(arrivalDate);
                	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                	endTime = sdf2.format(date);
                	maintainDate = sdf2.format(date2);
                	arrivalDate = sdf2.format(date3);
                	
                    list.add(new DrugMaintenanceJH(customerId,customerName,medcCode,medcName,specifications,
                    		unit,dosageforms,supplier,licenseNumber,trademark,
                    		Long.parseLong(quantity),batchNumber,endTime,result,conclusion,
                    		conserveType,conservationStaff,maintainDate,arrivalDate,
                    		printFlag,conservationStaff2));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return list;
        
    }
	public static String saveToDb(MultipartFile file,DrugMaintenanceJHDao drugMaintenanceJHDao){
		 List<DrugMaintenanceJH> listExcel=getAllByExcel(file);
		 int dupRecord=0;//重复记录的条数
		 int importSolt=0;
	     for (DrugMaintenanceJH drugMaintenanceJH : listExcel) {
	    		 drugMaintenanceJHDao.save(drugMaintenanceJH);
	    		 importSolt++;
	     }
	     return dupRecord+","+importSolt;

	}
	
	
}
