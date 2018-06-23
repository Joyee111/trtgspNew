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
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSalesStaffAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualSalesStaffAccessoryService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedSalesStaffService;
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
public class QualifiedSalesStaffServiceAction extends BaseFormController {
	
	@Autowired
	private  QualifiedSalesStaffService qualifiedSalesStaffService;
	@Autowired
	private QualSalesStaffAccessoryService qualSalesStaffAccessoryService;
	@Autowired
	private SystemLogService logService;
	@Autowired
	private WarnConfigService configService;
	
	@RequestMapping("/firstEnterprise/hgxsry.html")
	public ModelAndView getQulified(Model model ,HttpServletRequest request,HttpServletResponse response){
		List<SalesStaff> salesStaffList = new ArrayList<SalesStaff>();
		
		String page = DisplayGetPage.getPageParamName("sales", request);
		
		String hql = "from SalesStaff a where a.reviewStatus = 2 order by a.id DESC";
		if(page==null){
			salesStaffList = qualifiedSalesStaffService.findListByPage(hql, 0, Constants.pagesize);
		}else{
			salesStaffList = qualifiedSalesStaffService.findListByPage(hql,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		String sql ="select COUNT(*) from t_salesstaff where review_status = 2 ";
		int resultSize = qualifiedSalesStaffService.countRecordByCondition(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		
		return new ModelAndView("/QYZZ/HGXSRY/hgxsry","salesStaffList",salesStaffList);
	}
	
	@RequestMapping("/firstEnterprise/queryhgxsry.html")
	public ModelAndView queryQulifiedSalesStaffList(Model model ,HttpServletRequest request,HttpServletResponse response){
		List<SalesStaff> salesStaffList =  new ArrayList<SalesStaff>();
		String page = DisplayGetPage.getPageParamName("sales", request);
		String query_saleName = request.getParameter("query_saleName");
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("from SalesStaff a where 1=1 and a.reviewStatus = 2" );
		String sql ="select count(*) from t_salesstaff where review_status = 2 ";
		if(query_saleName!=null &&  !"".equals(query_saleName.trim())){
			buffer.append(" and a.saleName like'");
			buffer.append("%");
			buffer.append(query_saleName.trim()+"%'");
			sql = sql+" and sale_name like'%"+query_saleName.trim()+"%'";
		}
		
		buffer.append(" order by a.id DESC");
		if(page==null){
			salesStaffList =qualifiedSalesStaffService.findListByaPage(buffer.toString(), new HashMap<String, Object>(), 0, Constants.pagesize);
		}else{
			salesStaffList = qualifiedSalesStaffService.findListByaPage(buffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		int resultSize = qualifiedSalesStaffService.countRecordByCondition(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/HGXSRY/hgxsry","salesStaffList",salesStaffList);
	}
	
	@RequestMapping("/firstEnterprise/view_hgxsry.html")
	public ModelAndView viewQualifiedPurch(Model model,HttpServletRequest request ,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		SalesStaff  salesStaff = qualifiedSalesStaffService.get(id);
		
		model.addAttribute("salesStaff",salesStaff);
	//	Map<String, String> quamap= purchaseUnitsService.qmMap();
	//	model.addAttribute("quamap", quamap);
		return  new  ModelAndView("/QYZZ/HGXSRY/view_hgxsry");
	}
	
	@RequestMapping("/firstEnterprise/hgxsryxgjl.html")
	public ModelAndView qulifiedSalesStaffListModiRecord(Model model ,HttpServletRequest request,HttpServletResponse response){
		List<QualifiedSalesStaffAccessory> accessoryList =  new ArrayList<QualifiedSalesStaffAccessory>();
		String page = DisplayGetPage.getPageParamName("archives", request);
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		if(page==null){
			accessoryList = qualSalesStaffAccessoryService.findAccessoriesListByPage(id, 0, Constants.pagesize);
		}else{
			accessoryList = qualSalesStaffAccessoryService.findAccessoriesListByPage(id,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		int resultSize = qualSalesStaffAccessoryService.countRecord(id);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/HGXSRY/hgxsryjl","accessoryList",accessoryList);
	}
	
	@RequestMapping("/firstEnterprise/update_hgxsry.html")
	public String updataQualifiedSalesStaff(Model model,HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");//人员id
		String telephone = request.getParameter("telephone");//联系电话
		String powerOfAttorneyDate = request.getParameter("powerOfAttorneyDate");//法人委托书到期日期
		String identityCardDate = request.getParameter("identityCardDate");//身份证有效期
		String trainingCertificateDate = request.getParameter("trainingCertificateDate");//药品推销员证书有效期
		String reason = request.getParameter("reason");//修改原因
	
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		Long p_Id = null;
		if(isNull(id)){
			p_Id = Long.valueOf(id);
		}else{
			p_Id = Long.valueOf(0);
		}
		SalesStaff SalesStaff = qualifiedSalesStaffService.get(p_Id);
		
		List<QualifiedSalesStaffAccessory> archivesList = new ArrayList<QualifiedSalesStaffAccessory>();
		
		if(isNull(telephone)){
			if(!isQuals(telephone, SalesStaff.getTelephone())){
				QualifiedSalesStaffAccessory qualifiedSalesStaffAccessory = new QualifiedSalesStaffAccessory();
				qualifiedSalesStaffAccessory.setModifier(user);
				qualifiedSalesStaffAccessory.setProject_name("修改联系电话");
				qualifiedSalesStaffAccessory.setQualified_sales_staff_id(SalesStaff.getId());
				qualifiedSalesStaffAccessory.setModified_time(new Date());
				qualifiedSalesStaffAccessory.setChangeContent("修改联系电话，修改前值为："+ SalesStaff.getTelephone()+"修改后值为："+telephone);
				qualifiedSalesStaffAccessory.setReason(reason);
				archivesList.add(qualifiedSalesStaffAccessory); 
			
			}
			SalesStaff.setTelephone(telephone);
		}
		
		if(isNull(powerOfAttorneyDate)){
			if(!isQuals(powerOfAttorneyDate, SalesStaff.getPowerOfAttorneyDate())){
				QualifiedSalesStaffAccessory qualifiedSalesStaffAccessory = new QualifiedSalesStaffAccessory();
				qualifiedSalesStaffAccessory.setModifier(user);
				qualifiedSalesStaffAccessory.setProject_name("修改法人委托书到期日期");
				qualifiedSalesStaffAccessory.setQualified_sales_staff_id(SalesStaff.getId());
				qualifiedSalesStaffAccessory.setModified_time(new Date());
				qualifiedSalesStaffAccessory.setChangeContent("修改法人委托书到期日期，修改前值为："+ SalesStaff.getPowerOfAttorneyDate()+"修改后值为："+powerOfAttorneyDate);
				qualifiedSalesStaffAccessory.setReason(reason);
				archivesList.add(qualifiedSalesStaffAccessory); 
			
			}
			SalesStaff.setPowerOfAttorneyDate(powerOfAttorneyDate);
		}
		
		if(isNull(identityCardDate)){
			if(!isQuals(identityCardDate, SalesStaff.getIdentityCardDate())){
				QualifiedSalesStaffAccessory qualifiedSalesStaffAccessory = new QualifiedSalesStaffAccessory();
				qualifiedSalesStaffAccessory.setModifier(user);
				qualifiedSalesStaffAccessory.setProject_name("修改身份证有效期");
				qualifiedSalesStaffAccessory.setQualified_sales_staff_id(SalesStaff.getId());
				qualifiedSalesStaffAccessory.setModified_time(new Date());
				qualifiedSalesStaffAccessory.setChangeContent("修改身份证有效期，修改前值为："+ SalesStaff.getIdentityCardDate()+"修改后值为："+identityCardDate);
				qualifiedSalesStaffAccessory.setReason(reason);
				archivesList.add(qualifiedSalesStaffAccessory); 
			
			}
			SalesStaff.setIdentityCardDate(identityCardDate);
		}
		
		if(isNull(trainingCertificateDate)){
			if(!isQuals(trainingCertificateDate, SalesStaff.getTrainingCertificateDate())){
				QualifiedSalesStaffAccessory qualifiedSalesStaffAccessory = new QualifiedSalesStaffAccessory();
				qualifiedSalesStaffAccessory.setModifier(user);
				qualifiedSalesStaffAccessory.setProject_name("修改药品推销员证书有效期");
				qualifiedSalesStaffAccessory.setQualified_sales_staff_id(SalesStaff.getId());
				qualifiedSalesStaffAccessory.setModified_time(new Date());
				qualifiedSalesStaffAccessory.setChangeContent("修改药品推销员证书有效期，修改前值为："+ SalesStaff.getTrainingCertificateDate()+"修改后值为："+trainingCertificateDate);
				qualifiedSalesStaffAccessory.setReason(reason);
				archivesList.add(qualifiedSalesStaffAccessory); 
			
			}
			SalesStaff.setTrainingCertificateDate(trainingCertificateDate);
		}
		
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		batchUpload(multiRequest, SalesStaff);
		qualifiedSalesStaffService.saveOrUpdate(SalesStaff);
		
		qualSalesStaffAccessoryService.saveList(archivesList);
		
		logService.addLog("修改合格供货商销售人员", user.getRealname(), "修改", "企业资质管理  > 合格供货商销售人员", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
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
	
	public static void batchUpload(MultipartHttpServletRequest   request,SalesStaff salesStaff){
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
						salesStaff.setPowerOfAttorneyPath(relativeSavePath);
					}else if(requestName.equals("identityCardPath")){//身份证复印件
						salesStaff.setIdentityCardPath(relativeSavePath);
					}else if(requestName.equals("trainingCertificatePath")){//药品推销员证书
						salesStaff.setTrainingCertificatePath(relativeSavePath);
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
	
	@RequestMapping("/firstEnterprise/delteQualifiedSaleStaffAttachment.html")
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
	   SalesStaff salesStaff =  qualifiedSalesStaffService.get(enterpriseId);
	   if(type!=null && !type.trim().equals("")){
		   if(type.equals("frwts")){
			   salesStaff.setPowerOfAttorneyPath("");
		   }else if(type.equals("sfzfyj")){
			   salesStaff.setIdentityCardPath("");
		   }else if(type.equals("yptxyzs")){
			   salesStaff.setTrainingCertificatePath("");
		   
		   }
	   }
	   qualifiedSalesStaffService.saveOrUpdate(salesStaff);
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

	
	@RequestMapping("/firstEnterprise/ajaxQueryWarnSalesStaff.html")
	public String ajaxQuerWarn(Model model,HttpServletRequest request,HttpServletResponse response){
			
			String configHql = " from  WarnConfig a where a.limit_name like 'gh%' and a.use_flag=0";
			List<WarnConfig> configList = configService.findList(configHql);
			StringBuffer hqlBuffer = new StringBuffer("from SalesStaff a where 1=1 and  a.reviewStatus = 2 ");
			StringBuffer subjectBuffer = new StringBuffer();
			
			String shouquanweitoushu="";//委托授权书
			String ghshenfenzheng = "";//销售人员人员身份证
			String ghpeixunzhengshu = "";//药品推销员培训证书
			String nowdate = DateTimeUtils.getNowStrDate();
			StringBuffer buffer = new StringBuffer();
			
			for(WarnConfig config : configList){
				String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils.getCalendar(Integer.valueOf(config.getLimit_day())));
				String limit_name = config.getLimit_name();
				
				if(limit_name.equals("ghs_authorizationDate")){
					shouquanweitoushu = startDate;
				}else if(limit_name.equals("gh_IDCardValidate")){
					ghshenfenzheng = startDate;
				}else if(limit_name.equals("gh_PharmaceuticalSalesmanTrainingCertificateDate")){
					ghpeixunzhengshu = startDate;
				}
			}
			String subjecStr = subjectBuffer.toString();
			if(!subjecStr.trim().equals("")){
				String str = subjecStr.substring(2);
				hqlBuffer.append(" and ( ");
				hqlBuffer.append(str);
				hqlBuffer.append(" )");
			}
			List<SalesStaff> salesStaffList = qualifiedSalesStaffService.findList(hqlBuffer.toString());
		
				for(SalesStaff salesStaff : salesStaffList){
					
					//String today = DateTimeUtils.getNowStrDate();
					//身份证有效期
					if(salesStaff.getIdentityCardDate() != null && !"".equals(salesStaff.getIdentityCardDate().trim())){
						if(DateTimeUtils.compareTwoDate(ghshenfenzheng, salesStaff.getIdentityCardDate())>=0){
							int days =  DateTimeUtils.compareDateInterval(salesStaff.getIdentityCardDate(),nowdate );
							if(days>=0){
								buffer.append("&nbsp;<a href='view_hgxsry.html?id="+salesStaff.getId()+"' traget='_blank'>");
								buffer.append("销售人员"+salesStaff.getSaleName()+"身份证还有<font>"+days+"</font>天 到期</a>");
							}else{
								buffer.append("&nbsp;<a href='view_hgxsry.html?id="+salesStaff.getId()+"' traget='_blank'>");
								buffer.append("销售人员"+salesStaff.getSaleName()+"身份证已过期<font>"+Math.abs(days)+"</font>天 到期</a>");
									
							}
						}
					}
					//委托书有效期
					if(salesStaff.getPowerOfAttorneyDate() != null && !"".equals(salesStaff.getPowerOfAttorneyDate().trim())){
						if(DateTimeUtils.compareTwoDate(shouquanweitoushu, salesStaff.getPowerOfAttorneyDate())>=0){
							int days =  DateTimeUtils.compareDateInterval(salesStaff.getPowerOfAttorneyDate(),nowdate );
							if(days>=0){
								buffer.append("&nbsp;<a href='view_hgxsry.html?id="+salesStaff.getId()+"' traget='_blank'>");
								buffer.append("销售人员"+salesStaff.getSaleName()+"法人委托书还有<font>"+days+"</font>天 到期</a>");
							}else{
								buffer.append("&nbsp;<a href='view_hgxsry.html?id="+salesStaff.getId()+"' traget='_blank'>");
								buffer.append("销售人员"+salesStaff.getSaleName()+"法人委托书已过期<font>"+Math.abs(days)+"</font>天 到期</a>");
									
							}
						}
					}
					//药品推销员证书有效期
					if(salesStaff.getTrainingCertificateDate() != null && !"".equals(salesStaff.getTrainingCertificateDate().trim())){
						if(DateTimeUtils.compareTwoDate(ghpeixunzhengshu, salesStaff.getTrainingCertificateDate())>=0){
							int days =  DateTimeUtils.compareDateInterval(salesStaff.getTrainingCertificateDate(),nowdate );
							if(days>=0){
								buffer.append("&nbsp;<a href='view_hgxsry.html?id="+salesStaff.getId()+"' traget='_blank'>");
								buffer.append("销售人员"+salesStaff.getSaleName()+"法人委托书还有<font>"+days+"</font>天 到期</a>");
							}else{
								buffer.append("&nbsp;<a href='view_hgxsry.html?id="+salesStaff.getId()+"' traget='_blank'>");
								buffer.append("销售人员"+salesStaff.getSaleName()+"法人委托书已过期<font>"+Math.abs(days)+"</font>天 到期</a>");
									
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
