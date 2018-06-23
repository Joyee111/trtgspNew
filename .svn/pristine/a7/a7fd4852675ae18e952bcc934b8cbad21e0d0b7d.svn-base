package com.sinosoft.comQuery.varietyQuery.action;

import java.io.IOException;
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

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.comQuery.ReturnCheckRecords.model.ReturnCheckRecords;
import com.sinosoft.comQuery.ReturnCheckRecords.service.ReturnCheckRecordsMng;
import com.sinosoft.comQuery.unqualifiedManagerRecords.service.UnqualifiedManagerRecordsMng;
import com.sinosoft.dictionary.mode.DrugFormDictionary;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.ireportDTO.MedicineInfo;
import com.sinosoft.ireportDTO.SalesReturnCheckDto;

import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.IreportUtil;
import com.sinosoft.util.StringUtil;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;
@Controller
public class VarietyQueryAct extends BaseFormController{
	
	@Autowired
	private ReturnCheckRecordsMng returnCheckRecordsMng;
	
	@Autowired
	private QualityMidicineMng service;
	@Autowired 
	private UnqualifiedManagerRecordsMng unqualifiedManagerRecordsMng;
	public void setUnqualifiedManagerRecordsMng(
			UnqualifiedManagerRecordsMng unqualifiedManagerRecordsMng) {
		this.unqualifiedManagerRecordsMng = unqualifiedManagerRecordsMng;
	}
	/**
	 * 药品品种展示list
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/comQuery/varietyQuery/list.html")
	public ModelAndView getQualifiedMidicinesList(String firstJoin,Model model,HttpServletRequest request,HttpServletResponse response){
		List<QualityMidicine> qualityMidicinesList =  new ArrayList<QualityMidicine>();
		String page = DisplayGetPage.getPageParamName("qualifiedMedic", request);
		

		String hql = "from QualityMidicine where 1=1 and departmentId is not null";
		if(page==null){
			qualityMidicinesList = service.getListByPage(hql, new HashMap(), 0, Constants.pagesize);
		}else{
			qualityMidicinesList = service.getListByPage(hql,new HashMap(),(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		String tyztValue ="";
		if("1".equals(firstJoin)){
			tyztValue="0,1";
		}
		model.addAttribute("tyzt", tyztValue);
		// 获取总条数
		String sql ="select count(*) from t_qualified_medicine  where dp_id is not null";
		int resultSize = service.getRecordCount(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		//List<QualifiedSuppliers> qualiSuppList = qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/comQuery/varietyQuery/list","qualityMidicinesList",qualityMidicinesList);
	}
	@RequestMapping("/comQuery/varietyQuery/queryQulidiedMedicinal.html")
	public ModelAndView queryQualifiedMidicinesList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<QualityMidicine> qualityMidicinesList =  new ArrayList<QualityMidicine>();
	
		String mingcheng = request.getParameter("mingcheng");//通用名称
		String forms = request.getParameter("forms");//剂型
		String medicine_no=request.getParameter("medicine_no");//药品编号
		String department = request.getParameter("department");//经营公司
		String isfood = request.getParameter("isfood");//是否食品
		String page = DisplayGetPage.getPageParamName("qualifiedMedic", request);
		String[] tyzt=request.getParameterValues("tyzt");
		String tyztValue="";
	   if(tyzt!=null){
		   if(tyzt.length>0){
			   for (int i = 0; i < tyzt.length; i++) {
				   if(i==tyzt.length-1){
					   tyztValue+=tyzt[i].toString().trim();
					   
				   }else{
					   tyztValue+=tyzt[i].toString().trim()+",";
				   }
			   }
		   }
	   }
	   
	    model.addAttribute("mingcheng", mingcheng);
	    model.addAttribute("forms", forms);
	    model.addAttribute("medicine_no", medicine_no);
	    model.addAttribute("tyzt", tyztValue);
	    model.addAttribute("department", department);
	    model.addAttribute("isfood", isfood);
	    
		StringBuffer hqlBuffer = new StringBuffer("from QualityMidicine a where 1=1 and  a.departmentId is not null");
		StringBuffer sqlBuffer = new StringBuffer("select count(*) from  t_qualified_medicine q join t_dosage_form d on q.dosageforms_id=d.id where 1=1 and q.dp_id is not null");
		if(mingcheng!=null && !"".equals(mingcheng.trim())){
			hqlBuffer.append(" and a.id ='"+mingcheng.trim()+"'");
			sqlBuffer.append(" and q.id ='"+mingcheng.trim()+"'");
		}
		if(forms!=null && !"".equals(forms.trim())){
			hqlBuffer.append(" and a.dosageforms.id ='"+forms.trim()+"'");
			sqlBuffer.append(" and d.id ='"+forms.trim()+"'");
		}
		if(medicine_no!=null && !"".equals(medicine_no.trim())){
			hqlBuffer.append(" and a.medicinalNo like'%"+medicine_no.trim()+"%'");
			sqlBuffer.append(" and q.medc_no like'%"+medicine_no.trim()+"%'");
		}
		//药品状态    启用
		if(tyztValue!=null&&tyztValue.equals("0")){
			hqlBuffer.append(" and a.useflag ='"+0+"'");
			sqlBuffer.append(" and q.use_flag = '"+0+"'");
			
		}
		//药品状态    停用
		if(tyztValue!=null&&tyztValue.equals("1")){
			hqlBuffer.append(" and a.useflag = 1");
			sqlBuffer.append(" and q.use_flag = 1");
			
		}
		if(department!=null && !"".equals(department)){
			hqlBuffer.append(" and a.departmentId ='"+department+"' ");
			sqlBuffer.append(" and q.dp_id ='"+department+"' ");
		}
		if(isfood!=null && !"".equals(isfood)){
			hqlBuffer.append(" and a.isfood ='"+isfood+"' ");
			sqlBuffer.append(" and q.is_food ='"+isfood+"' ");
		}
		if(page==null){
			qualityMidicinesList = service.getListByPage(hqlBuffer.toString(), new HashMap(), 0, Constants.pagesize);
		}else{
			qualityMidicinesList = service.getListByPage(hqlBuffer.toString(),new HashMap(),(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		//String sql ="select count(*) from t_qualified_purchase_units where delete_flag=0";
		int resultSize = service.getRecordCount(sqlBuffer.toString());
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		//List<QualifiedSuppliers> qualiSuppList = qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/comQuery/varietyQuery/list","qualityMidicinesList",qualityMidicinesList);
	}
	
	@RequestMapping("/comQuery/varietyQuery/viewQulidiedMedicinal.html")
	public ModelAndView viewQulifiedMedicinal(Model model ,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && !p_id.trim().equals("")){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		QualityMidicine qualityMidicine = service.get(id);
		model.addAttribute("qualityMidicine", qualityMidicine);
		return new ModelAndView("/comQuery/varietyQuery/view");
	}
	
	@RequestMapping("/comQuery/varietyQuery/findjxboxqy.html")
	public void findQulitySupplyJson(HttpServletRequest request, HttpServletResponse response, Model model){
		List<DrugFormDictionary> list = null;
		String hql = "select a from DrugFormDictionary a " ;
		list = unqualifiedManagerRecordsMng.findList(hql);
		//封装采购单json
		
//		String json = "[";
//		int index=0;
//		if(list!=null && list.size()>0){
//			for(DrugFormDictionary supply : list){
//					index++;
//					json+="{";
//					json+="\"id\":\""+supply.getId()+"\",";
//					json+="\"text\":\""+supply.getFormName()+"\"";
//					if(index==list.size()){
//						json+="}";
//					}else{
//						json+="},";
//					}
//				}
//		}
//		json+="]";
		
		StringBuffer json = new StringBuffer("[");
		if(list!=null && list.size()>0){
			for(int i =0;i<list.size();i++){
				json.append("{");
				json.append("\"id\":\""+list.get(i).getId()+"\",");
				json.append("\"text\":\""+list.get(i).getFormName()+"\"");
				json.append("},");
			}
		}
		if(json.toString().endsWith(",")){
			json = new StringBuffer(json.substring(0,json.length()-1));
		}
		json.append("]");
		
		
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/comQuery/varietyQuery/exportAll.html")
  	public ModelAndView getMedcInfoList( ReturnCheckRecords rr,Model model,HttpServletRequest request,HttpServletResponse response){
		List<?> reslist=new ArrayList();
		List<MedicineInfo> list = new ArrayList<MedicineInfo>();
		String mingcheng= request.getParameter("mingcheng");
		String forms = request.getParameter("forms");
		String department = request.getParameter("department");
		String isfood = request.getParameter("isfood");
		
		model.addAttribute("mingcheng", mingcheng);
		model.addAttribute("forms", forms);
		model.addAttribute("department", department);
		model.addAttribute("isfood", isfood);
		StringBuffer sqlBuffer = new StringBuffer("select a.common_name,b.form_name,a.medc_no,a.license_number,c.name,c.name,a.mass_specifications,a.specifications,a.unit,a.qualityStandard_name,a.medicine_category,a.medicinal_attribute,a.valid_date,a.feature,a.medc_registr_approval_date"+
																			" from t_qualified_medicine a,t_dosage_form b,t_qualifiedSupplier c where a.dosageforms_id = b.id and a.produceno_id = c.id and a.dp_id is not null ");
		
		if(mingcheng!=null && !mingcheng.equals("")){
			sqlBuffer.append(" and a.id = '");
		   sqlBuffer.append(mingcheng+"'  ");
		}
		if(forms!=null && !forms.equals("")){
			sqlBuffer.append(" and a.dosageforms_id = '");
		sqlBuffer.append(forms+"'  ");
		}
		if(department != null && !"".equals(department.trim())){
			sqlBuffer.append(" and a.dp_id like '"+department+"%' " );
		}
		if(isfood != null && !"".equals(isfood.trim())){
			sqlBuffer.append(" and a.is_food = '"+isfood+"' " );
		}
	
			reslist = returnCheckRecordsMng.getAllReturnCheckRecord(sqlBuffer.toString(), new HashMap<String, Object>());
			if(reslist!=null){
				for(int i = 0;i < reslist.size();i++){
					Object[] obj = (Object[]) reslist.get(i);
					MedicineInfo medcinfo =new MedicineInfo();	
					if(obj[0]!=null){
						medcinfo.setTymc(obj[0].toString());
					}
					if(obj[1]!=null){
						medcinfo.setJx(obj[1].toString());
					}
					if(obj[2]!=null){
						medcinfo.setHh(obj[2].toString());
					}
					if(obj[3]!=null){
						medcinfo.setPzwh(obj[3].toString());
					}
					if(obj[4]!=null){
						medcinfo.setScqy(obj[4].toString());
					}
					if(obj[5]!=null){
						medcinfo.setGhdw(obj[5].toString());
					}
					if(obj[6]!=null){
						medcinfo.setYpgg(obj[6].toString());
					}
					if(obj[7]!=null){
						medcinfo.setBzgg(obj[7].toString());
					}
					if(obj[8]!=null){
						medcinfo.setDw(obj[8].toString());
					}
					if(obj[9]!=null){
						medcinfo.setZlbzyj(obj[9].toString());
					}
					if(obj[10]!=null){
						medcinfo.setYplb(obj[10].toString());
					}
					if(obj[11]!=null){
						medcinfo.setCutj(obj[11].toString());
					}
					if(obj[12]!=null){
						medcinfo.setYpyxq(obj[12].toString());
					}
					if(obj[13]!=null){
						medcinfo.setYpgn(obj[13].toString());
					}
					if(obj[14]!=null){
						medcinfo.setZczdqr(obj[14].toString());
					}
					list.add(medcinfo);
				}	
			}
			//List<SalesReturnCheckDto> returnCheckDtoList = new ArrayList<SalesReturnCheckDto>();
			//	for(ReturnCheckRecords record : list){
			//		returnCheckDtoList.add(new SalesReturnCheckDto(record));
			//	}
				String file = "medc_info";
				String chineseName = "品种记录表";
				IreportUtil.export(file, chineseName, list, request, response);
				return null;
	}
}
