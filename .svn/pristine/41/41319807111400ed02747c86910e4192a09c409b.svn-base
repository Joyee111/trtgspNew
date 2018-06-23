package com.sinosoft.enterpriseManage.firstEnterprise.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedProcurementStaffAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualProcurementStaffAccessoryService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedProcurementStaffService;
import com.sinosoft.systemConfig.WarnConfig;
import com.sinosoft.systemConfig.WarnConfigService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.FileOperate;
import com.sinosoft.util.FileUtil;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;

@Controller
public class QualifiedProcurementStaffServiceAction extends BaseFormController {
	
	@Autowired
	private QualifiedProcurementStaffService qualifiedProcurementStaffService;
	@Autowired
	private QualProcurementStaffAccessoryService qualProcurementStaffAccessoryService;
	@Autowired
	private SystemLogService logService;
	@Autowired
	private WarnConfigService configService;
	
	@RequestMapping("/firstEnterprise/hgcgry.html")
	public ModelAndView getQulified(Model model ,HttpServletRequest request,HttpServletResponse response){
		List<ProcurementStaff> procurementStaffList = new ArrayList<ProcurementStaff>();
		
		String page = DisplayGetPage.getPageParamName("proStaff", request);
		
		String hql = "from ProcurementStaff a where a.reviewStatus = 2 order by a.id DESC";
		if(page==null){
			procurementStaffList = qualifiedProcurementStaffService.findListByPage(hql, 0, Constants.pagesize);
		}else{
			procurementStaffList = qualifiedProcurementStaffService.findListByPage(hql,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		String sql ="select COUNT(*) from t_procurement_staff where review_status = 2 ";
		int resultSize = qualifiedProcurementStaffService.countRecordByCondition(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		
		return new ModelAndView("/QYZZ/HGCGRY/hgcgry","procurementStaffList",procurementStaffList);
	}
	
	@RequestMapping("/firstEnterprise/queryhgcgry.html")
	public ModelAndView queryQulifiedProcurementStaffList(Model model ,HttpServletRequest request,HttpServletResponse response){
		List<ProcurementStaff> procurementStaffList =  new ArrayList<ProcurementStaff>();
		String page = DisplayGetPage.getPageParamName("proStaff", request);
		String query_proName = request.getParameter("query_proName");
		String query_person_type = request.getParameter("query_person_type");
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("from ProcurementStaff a where 1=1 and a.reviewStatus = 2" );
		String sql ="select count(*) from t_procurement_staff where review_status = 2 ";
		if(query_proName!=null &&  !"".equals(query_proName.trim())){
			buffer.append(" and a.procurementName like'");
			buffer.append("%");
			buffer.append(query_proName.trim()+"%'");
			sql = sql+" and procurement_name like'%"+query_proName.trim()+"%'";
		}
		if(query_person_type!=null &&  !"".equals(query_person_type.trim())){
			buffer.append(" and a.personType = ");
			buffer.append(query_person_type.trim());
			sql = sql+" and person_type = "+query_person_type.trim();
		}
		buffer.append(" order by a.id DESC");
		if(page==null){
			procurementStaffList =qualifiedProcurementStaffService.findListByaPage(buffer.toString(), new HashMap<String, Object>(), 0, Constants.pagesize);
		}else{
			procurementStaffList = qualifiedProcurementStaffService.findListByaPage(buffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		int resultSize = qualifiedProcurementStaffService.countRecordByCondition(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/HGCGRY/hgcgry","procurementStaffList",procurementStaffList);
	}
	
	@RequestMapping("/firstEnterprise/view_hgcgry.html")
	public ModelAndView viewQualifiedPurch(Model model,HttpServletRequest request ,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		ProcurementStaff  procurementStaff = qualifiedProcurementStaffService.get(id);
		
		model.addAttribute("procurementStaff",procurementStaff);
	//	Map<String, String> quamap= purchaseUnitsService.qmMap();
	//	model.addAttribute("quamap", quamap);
		return  new  ModelAndView("/QYZZ/HGCGRY/view_hgcgry");
	}
	
	@RequestMapping("/firstEnterprise/hgcgryxgjl.html")
	public ModelAndView qulifiedSalesStaffListModiRecord(Model model ,HttpServletRequest request,HttpServletResponse response){
		List<QualifiedProcurementStaffAccessory> accessoryList =  new ArrayList<QualifiedProcurementStaffAccessory>();
		String page = DisplayGetPage.getPageParamName("archives", request);
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		if(page==null){
			accessoryList = qualProcurementStaffAccessoryService.findAccessoriesListByPage(id, 0, Constants.pagesize);
		}else{
			accessoryList = qualProcurementStaffAccessoryService.findAccessoriesListByPage(id,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		int resultSize = qualProcurementStaffAccessoryService.countRecord(id);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/HGCGRY/hgcgryjl","accessoryList",accessoryList);
	}
	
	@RequestMapping("/firstEnterprise/update_hgcgry.html")
	public String updataQualifiedSalesStaff(Model model,HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");//人员id
		String powerOfAttorneyDate = request.getParameter("powerOfAttorneyDate");//法人委托书到期日期
		String identityCardDate = request.getParameter("identityCardDate");//身份证有效期
		String reason = request.getParameter("reason");//修改原因
		String gender = request.getParameter("gender");
		String name = request.getParameter("procurementName");
		String pinyinCode = request.getParameter("pinyinCode");
		String IDNumber = request.getParameter("IDNumber");
		//String powerOfAttorneyPath = request.getParameter("powerOfAttorneyPath");//法人委托书
	
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		Long p_Id = null;
		if(isNull(id)){
			p_Id = Long.valueOf(id);
		}else{
			p_Id = Long.valueOf(0);
		}
		ProcurementStaff procurementStaff = new ProcurementStaff();
		if(isNull(name)){
			procurementStaff = qualifiedProcurementStaffService.get(p_Id);
		}
		//ProcurementStaff procurementStaff = qualifiedProcurementStaffService.get(p_Id);
		
		
		if(isNull(pinyinCode)){
			procurementStaff.setPinyinCode(pinyinCode);
		}
		
		List<QualifiedProcurementStaffAccessory> archivesList = new ArrayList<QualifiedProcurementStaffAccessory>();
		
		if(isNull(IDNumber)){
			if(!isQuals(IDNumber, procurementStaff.getIDNumber())){
				QualifiedProcurementStaffAccessory qualifiedProStaffAccessory = new QualifiedProcurementStaffAccessory();
				qualifiedProStaffAccessory.setModifier(user);
				qualifiedProStaffAccessory.setProject_name("修改身份证号");
				qualifiedProStaffAccessory.setQualified_procurement_staff_id(procurementStaff.getId());
				qualifiedProStaffAccessory.setModified_time(new Date());
				qualifiedProStaffAccessory.setChangeContent("修改身份证号，修改前值为："+ procurementStaff.getIDNumber()+"修改后值为："+IDNumber);
				qualifiedProStaffAccessory.setReason(reason);
				archivesList.add(qualifiedProStaffAccessory); 
			
			}
			procurementStaff.setIDNumber(IDNumber);
		}
		if(isNull(name)){
			if(!isQuals(name, procurementStaff.getProcurementName())){
				QualifiedProcurementStaffAccessory qualifiedProStaffAccessory = new QualifiedProcurementStaffAccessory();
				qualifiedProStaffAccessory.setModifier(user);
				qualifiedProStaffAccessory.setProject_name("修改姓名");
				qualifiedProStaffAccessory.setQualified_procurement_staff_id(procurementStaff.getId());
				qualifiedProStaffAccessory.setModified_time(new Date());
				qualifiedProStaffAccessory.setChangeContent("修改姓名，修改前值为："+ procurementStaff.getProcurementName()+"修改后值为："+name);
				qualifiedProStaffAccessory.setReason(reason);
				archivesList.add(qualifiedProStaffAccessory); 
			
			}
			procurementStaff.setProcurementName(name);
		}
		if(isNull(id)){
			if(!isQuals(gender, procurementStaff.getGender())){
				QualifiedProcurementStaffAccessory qualifiedProStaffAccessory = new QualifiedProcurementStaffAccessory();
				qualifiedProStaffAccessory.setModifier(user);
				qualifiedProStaffAccessory.setProject_name("修改性别");
				qualifiedProStaffAccessory.setQualified_procurement_staff_id(procurementStaff.getId());
				qualifiedProStaffAccessory.setModified_time(new Date());
				qualifiedProStaffAccessory.setChangeContent("修改性别，修改前值为："+ procurementStaff.getGender()+"修改后值为："+gender);
				qualifiedProStaffAccessory.setReason(reason);
				archivesList.add(qualifiedProStaffAccessory); 
			
			}
			procurementStaff.setGender(gender);
		}
		
		if(isNull(powerOfAttorneyDate)){
			if(!isQuals(powerOfAttorneyDate, procurementStaff.getPowerOfAttorneyDate())){
				QualifiedProcurementStaffAccessory qualifiedProStaffAccessory = new QualifiedProcurementStaffAccessory();
				qualifiedProStaffAccessory.setModifier(user);
				qualifiedProStaffAccessory.setProject_name("修改法人委托书到期日期");
				qualifiedProStaffAccessory.setQualified_procurement_staff_id(procurementStaff.getId());
				qualifiedProStaffAccessory.setModified_time(new Date());
				qualifiedProStaffAccessory.setChangeContent("修改法人委托书到期日期，修改前值为："+ procurementStaff.getPowerOfAttorneyDate()+"修改后值为："+powerOfAttorneyDate);
				qualifiedProStaffAccessory.setReason(reason);
				archivesList.add(qualifiedProStaffAccessory); 
			
			}
			procurementStaff.setPowerOfAttorneyDate(powerOfAttorneyDate);
		}
		
		if(isNull(identityCardDate)){
			if(!isQuals(identityCardDate, procurementStaff.getIdentityCardDate())){
				QualifiedProcurementStaffAccessory qualifiedproStaffAccessory = new QualifiedProcurementStaffAccessory();
				qualifiedproStaffAccessory.setModifier(user);
				qualifiedproStaffAccessory.setProject_name("修改身份证有效期");
				qualifiedproStaffAccessory.setQualified_procurement_staff_id(procurementStaff.getId());
				qualifiedproStaffAccessory.setModified_time(new Date());
				qualifiedproStaffAccessory.setChangeContent("修改身份证有效期，修改前值为："+ procurementStaff.getIdentityCardDate()+"修改后值为："+identityCardDate);
				qualifiedproStaffAccessory.setReason(reason);
				archivesList.add(qualifiedproStaffAccessory); 
			
			}
			procurementStaff.setIdentityCardDate(identityCardDate);
		}
		
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		batchUpload(multiRequest, procurementStaff);
		qualifiedProcurementStaffService.saveOrUpdate(procurementStaff);
		
		qualProcurementStaffAccessoryService.saveList(archivesList);
		
		logService.addLog("修改合格供货商销售人员", user.getRealname(), "修改", "企业资质管理  > 合格供货商销售人员", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		map.put("psid", procurementStaff.getId());
		UtilJson.printMapJson(response, map);
		return null;
	}
	private boolean isNull(String str){
		return str!=null && !"".equals(str.trim());
	}
	private boolean isQuals(String str1,String str2){
		if(str2==null)
			return false;
		return str1.trim().equals(str2.trim());
	}
	
	public static void batchUpload(MultipartHttpServletRequest   request,ProcurementStaff procurementStaff){
		  Map<String, MultipartFile> filesMap = request.getFileMap();
			 String serverRealPath = request.getSession().getServletContext().getRealPath("/");//获取服务器绝对路径
				String fileSavePath = serverRealPath+Constants.UPLOAD_PATH;//上传文件存储的绝对路径
				String fileTempPath = serverRealPath+Constants.TEMPPATH;//上传文件在服务器临时存储的的绝对路径
				new File(fileSavePath).mkdirs();
				try{
					File tempPathFile = new File(fileTempPath);
					if(!tempPathFile.exists()){
						tempPathFile.mkdirs();
					}
				Iterator<String> its = filesMap.keySet().iterator();
				while(its.hasNext()){
					String requestName = its.next();
					MultipartFile item = filesMap.get(requestName);
					String fileName = FileUtil.getFileName();//重命名文件名
					MultipartFile uploadFile = (MultipartFile) item;
					if(uploadFile.getOriginalFilename()==null || uploadFile.getOriginalFilename().equals(""))
						continue;
					String fileNameLong = uploadFile.getOriginalFilename();//获取上传文件的名称
				//	String requestName = uploadFile.getName();//获取上传文件对应字段名称
					String fileNameExtension = FileUtil.getFileExtension(fileNameLong);//获取文件的上传拓展名
					String relativeSavePath = Constants.UPLOAD_PATH+fileName+"."+fileNameExtension;//用户保存到数据库的相对文件路径及名称
					relativeSavePath = relativeSavePath.substring(1);
					File savaFile = new File(fileSavePath+fileName+"."+fileNameExtension);
					if(!savaFile.exists()){
						savaFile.createNewFile();
					}
					if(requestName.equals("powerOfAttorneyPath")){//法人委托书
						procurementStaff.setPowerOfAttorneyPath(relativeSavePath);
					}else if(requestName.equals("identityCardPath")){//身份证复印件
						procurementStaff.setIdentityCardPath(relativeSavePath);
					}
					uploadFile.transferTo(savaFile);
				}
				}catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
	}
	
	@RequestMapping("/firstEnterprise/delteQualifiedProcurementStaffAttachment.html")
	public ModelAndView deleteFile(Model mode ,HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String fileName = request.getParameter("fileName");
		String type=request.getParameter("type");
	    String ctxPath = request.getSession().getServletContext().getRealPath(  
        "/");
	    String filePath = ctxPath + fileName;
	    Long enterpriseId = null;
	    if(id!=null && !id.trim().equals("")){
	    	enterpriseId = Long.valueOf(id);
	    }else{
	    	enterpriseId = Long.valueOf(0);
	    }
	    ProcurementStaff procurementStaff =  qualifiedProcurementStaffService.get(enterpriseId);
	   if(type!=null && !type.trim().equals("")){
		   if(type.equals("frwts")){
			   procurementStaff.setPowerOfAttorneyPath("");
		   }else if(type.equals("sfzfyj")){
			   procurementStaff.setIdentityCardPath("");
		   }
	   }
	   qualifiedProcurementStaffService.saveOrUpdate(procurementStaff);
	   boolean status = FileOperate.delFile(filePath);
	   Map<String, Object> map = new HashMap<String, Object>();
	   if(status){
		   map.put("success", URLEncoder.encode("删除附件成功！", "UTF-8"));
	   }else{
		   map.put("success", URLEncoder.encode("删除附件失败！", "UTF-8"));
	   }
	   UtilJson.printMapJson(response, map);
		return null;
	}

	
	@RequestMapping("/firstEnterprise/ajaxQueryWarnProcurementStaff.html")
	public String ajaxQuerWarn(Model model,HttpServletRequest request,HttpServletResponse response){
		String configHql = " from  WarnConfig a where a.limit_name like 'cg%' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		StringBuffer hqlBuffer = new StringBuffer("from ProcurementStaff a where 1=1 and  a.reviewStatus = 2 ");
		StringBuffer subjectBuffer = new StringBuffer();
			
		String shouquanweitoushu="";//委托授权书
		String ghshenfenzheng = "";//销售人员人员身份证
		String nowdate = DateTimeUtils.getNowStrDate();
		StringBuffer buffer = new StringBuffer();
			
		for(WarnConfig config : configList){
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
				
			if(limit_name.equals("cg_authorizationDate")){
				shouquanweitoushu = startDate;
			}else if(limit_name.equals("cg_IDCardValidate")){
				ghshenfenzheng = startDate;
		    }
		}
		String subjecStr = subjectBuffer.toString();
		if(!subjecStr.trim().equals("")){
			String str = subjecStr.substring(2);
			hqlBuffer.append(" and ( ");
			hqlBuffer.append(str);
			hqlBuffer.append(" )");
		}
		List<ProcurementStaff> procurementStaffList = qualifiedProcurementStaffService.findList(hqlBuffer.toString());
		
		for(ProcurementStaff procurementStaff : procurementStaffList){
			String person_type	= "";	
			
			if ("0".equals(procurementStaff.getPersonType())){
				person_type = "采购人员";
			}else{
				person_type = "提货人员";
			}
			//身份证有效期
			if(procurementStaff.getIdentityCardDate() != null && !"".equals(procurementStaff.getIdentityCardDate().trim())){
				if(DateTimeUtils.compareTwoDate(ghshenfenzheng, procurementStaff.getIdentityCardDate())>=0){
					int days =  DateTimeUtils.compareDateInterval(procurementStaff.getIdentityCardDate(),nowdate );
					if(days>=0){
						buffer.append("&nbsp;<a href='view_hgcgry.html?id="+procurementStaff.getId()+"' traget='_blank'>");
						buffer.append(person_type+procurementStaff.getProcurementName()+"身份证还有<font>"+days+"</font>天 到期</a>");
					}else{
						buffer.append("&nbsp;<a href='view_hgcgry.html?id="+procurementStaff.getId()+"' traget='_blank'>");
						buffer.append(person_type+procurementStaff.getProcurementName()+"身份证已过期<font>"+Math.abs(days)+"</font>天 到期</a>");
					}
				}
			}
			//委托书有效期
			if(procurementStaff.getPowerOfAttorneyDate() != null && !"".equals(procurementStaff.getPowerOfAttorneyDate().trim())){
				if(DateTimeUtils.compareTwoDate(shouquanweitoushu, procurementStaff.getPowerOfAttorneyDate())>=0){
					int days =  DateTimeUtils.compareDateInterval(procurementStaff.getPowerOfAttorneyDate(),nowdate );
					if(days>=0){
						buffer.append("&nbsp;<a href='view_hgcgry.html?id="+procurementStaff.getId()+"' traget='_blank'>");
						buffer.append(person_type+procurementStaff.getProcurementName()+"法人委托书还有<font>"+days+"</font>天 到期</a>");
					}else{
						buffer.append("&nbsp;<a href='view_hgcgry.html?id="+procurementStaff.getId()+"' traget='_blank'>");
						buffer.append(person_type+procurementStaff.getProcurementName()+"法人委托书已过期<font>"+Math.abs(days)+"</font>天 到期</a>");
					}
				}
			}
		}
				
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", buffer.toString());
		UtilJson.printMapJson(response, map);
			
		return null;
	}
}
