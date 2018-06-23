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
import com.sinosoft.enterpriseManage.firstEnterprise.model.OurQualityManagement;
import com.sinosoft.enterpriseManage.firstEnterprise.model.OurQualityManagementAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.service.OurQualityManagementAccessoryService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.OurQualityManagementService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.FileOperate;
import com.sinosoft.util.FileUtil;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;


/**
 * @author cbl:
 * @version 创建时间：Nov 27, 2014 3:33:01 PM
 * 类说明
 * 公司资质管理
 */

@Controller
public class OurQualityManagementAction extends BaseFormController {
	
	@Autowired
	private OurQualityManagementService ourQualityManagementService;
	@Autowired
	private OurQualityManagementAccessoryService ourQualityManagementAccessoryService;
	@Autowired
	private SystemLogService logService;

	/*
	 * 显示“我公司资质管理”页面
	 */
	@RequestMapping("/firstEnterprise/wgszzgl.html")
	public ModelAndView getOurQualityManagementList(Model model ,HttpServletRequest request,HttpServletResponse response){
		List<OurQualityManagement> ourQualityManagementList =  new ArrayList<OurQualityManagement>();
		String page = DisplayGetPage.getPageParamName("ourQualityManagement", request);//取出页面数据
		String hql = "from OurQualityManagement a where a.delete_flag=0 order by a.id DESC";
		if(page==null){
			ourQualityManagementList = ourQualityManagementService.findListByPage(hql, 0, Constants.pagesize);
		}else{
			ourQualityManagementList = ourQualityManagementService.findListByPage(hql,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		String sql ="select count(*) from t_company_quality_management where delete_flag=0";//?
		int resultSize = ourQualityManagementService.countRecordByCondition(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		//List<QualifiedSuppliers> qualiSuppList = qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		
		return new ModelAndView("/QYZZ/WGSZZGL/wgszzgl","ourQualityManagementList",ourQualityManagementList);
	}
	
	
	
	/*
	 * 修改公司资质
	 */
	@RequestMapping("/firstEnterprise/update_wgszzglxg.html")
	public String updataOurQualityManagement(Model model,HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");//客户ID
		String customer_name = request.getParameter("customerName");//公司名称
		String address = request.getParameter("address");//企业地址
		String businessScope = request.getParameter("businessScope");//经营范围
		String legalRepresentative = request.getParameter("legalRepresentative");//法定代表人
		String qualityPrincipal = request.getParameter("qualityPrincipal");//质量负责人
		String businessLicenceDate = request.getParameter("businessLicenceDate");//营业执照到期时间
		String businessPermitDate = request.getParameter("businessPermitDate");//经营许可证到期时间
		String gspCertificateDate = request.getParameter("gspCertificateDate");//GSP到期时间
		String organizationCodeDate = request.getParameter("organizationCodeDate");//组织机构代码到期时间
		String remark = request.getParameter("remark");//备注
		//String remark = null;
		String reason = request.getParameter("reason");//修改原因
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		Long p_Id = null;
		if(isNull(id)){
			p_Id = Long.valueOf(id);
		}else{
			p_Id = Long.valueOf(0);
		}
		
		
		OurQualityManagement ourQualityManagement = ourQualityManagementService.get(p_Id);;
		//OurQualityManagement ourQualityManagement = ourQualityManagementService.get(p_Id);
		List<OurQualityManagementAccessory> archivesList = new ArrayList<OurQualityManagementAccessory>();
		if(isNull(customer_name)){
			if(!isQuals(customer_name, ourQualityManagement.getCustomer_name())){
				OurQualityManagementAccessory ourQualityManagementAccessory = new OurQualityManagementAccessory();
				ourQualityManagementAccessory.setModifier(user);
				ourQualityManagementAccessory.setProject_name("公司名称");
				ourQualityManagementAccessory.setCompany_quality_management_id(ourQualityManagement.getId());
				ourQualityManagementAccessory.setModified_time(new Date());
				ourQualityManagementAccessory.setChangeContent("公司名称，修改前值为："+ourQualityManagement.getCustomer_name()+"修改后值为："+customer_name);
				ourQualityManagementAccessory.setReason(reason);
				archivesList.add(ourQualityManagementAccessory);
			}
			ourQualityManagement.setCustomer_name(customer_name);
		}
		
		if(isNull(address)){
			if(!isQuals(address, ourQualityManagement.getAddress())){
				OurQualityManagementAccessory ourQualityManagementAccessory = new OurQualityManagementAccessory();
				ourQualityManagementAccessory.setModifier(user);//修改人ID
				ourQualityManagementAccessory.setProject_name("企业地址");//项目名称
				ourQualityManagementAccessory.setCompany_quality_management_id(ourQualityManagement.getId());//公司ID
				ourQualityManagementAccessory.setModified_time(new Date());//修改时间
				ourQualityManagementAccessory.setChangeContent("企业地址，修改前值为："+ourQualityManagement.getAddress()+"修改后值为："+address);//修改内容
				ourQualityManagementAccessory.setReason(reason);//修改原因
				archivesList.add(ourQualityManagementAccessory);
			}
			ourQualityManagement.setAddress(address);
		}
		
		
		if(isNull(businessScope)){
			if(!isQuals(businessScope, ourQualityManagement.getBusinessScope())){
				OurQualityManagementAccessory ourQualityManagementAccessory = new OurQualityManagementAccessory();
				ourQualityManagementAccessory.setModifier(user);//修改人
				ourQualityManagementAccessory.setProject_name("修改"+"经营范围");//项目名称
				ourQualityManagementAccessory.setCompany_quality_management_id(ourQualityManagement.getId());//公司ID
				ourQualityManagementAccessory.setModified_time(new Date());//修改时间
				ourQualityManagementAccessory.setChangeContent("修改"+"经营范围，修改前值为："+ourQualityManagement.getBusinessScope()+"修改后值为："+businessScope);//修改内容
				ourQualityManagementAccessory.setReason(reason);//修改原因
				archivesList.add(ourQualityManagementAccessory);
			}
			ourQualityManagement.setBusinessScope(businessScope);//
		}
		
		
		if(isNull( legalRepresentative )){
			if(!isQuals( legalRepresentative , ourQualityManagement.getLegalRepresentative()  )){
				OurQualityManagementAccessory ourQualityManagementAccessory = new OurQualityManagementAccessory();
				ourQualityManagementAccessory.setModifier(user);//修改人
				ourQualityManagementAccessory.setProject_name("修改"+"法定代表人");//项目名称
				ourQualityManagementAccessory.setCompany_quality_management_id(ourQualityManagement.getId());//公司ID
				ourQualityManagementAccessory.setModified_time(new Date());//修改时间
				ourQualityManagementAccessory.setChangeContent("修改"+"法定代表人，修改前值为："+ourQualityManagement.getLegalRepresentative()  +"修改后值为："+legalRepresentative  );//修改内容
				ourQualityManagementAccessory.setReason(reason);//修改原因
				archivesList.add(ourQualityManagementAccessory);
			}
			ourQualityManagement.setLegalRepresentative( legalRepresentative );//
		}
		
		
		if(isNull( qualityPrincipal )){
			if(!isQuals( qualityPrincipal , ourQualityManagement.getQualityPrincipal()  )){
				OurQualityManagementAccessory ourQualityManagementAccessory = new OurQualityManagementAccessory();
				ourQualityManagementAccessory.setModifier(user);//修改人
				ourQualityManagementAccessory.setProject_name("修改"+"质量负责人");//项目名称
				ourQualityManagementAccessory.setCompany_quality_management_id(ourQualityManagement.getId());//公司ID
				ourQualityManagementAccessory.setModified_time(new Date());//修改时间
				ourQualityManagementAccessory.setChangeContent("修改"+"质量负责人，修改前值为："+ourQualityManagement.getQualityPrincipal()  +"修改后值为："+ qualityPrincipal );//修改内容
				ourQualityManagementAccessory.setReason(reason);//修改原因
				archivesList.add(ourQualityManagementAccessory);
			}
			ourQualityManagement.setQualityPrincipal(qualityPrincipal);//
		}
		
		if(isNull( businessLicenceDate )){
			if(!isQuals( businessLicenceDate , ourQualityManagement.getBusinessLicenceDate () )){
				OurQualityManagementAccessory ourQualityManagementAccessory = new OurQualityManagementAccessory();
				ourQualityManagementAccessory.setModifier(user);//修改人
				ourQualityManagementAccessory.setProject_name("修改"+"营业执照到期时间");//项目名称
				ourQualityManagementAccessory.setCompany_quality_management_id(ourQualityManagement.getId());//公司ID
				ourQualityManagementAccessory.setModified_time(new Date());//修改时间
				ourQualityManagementAccessory.setChangeContent("修改"+"营业执照到期时间，修改前值为："+ourQualityManagement.getBusinessLicenceDate () +"修改后值为："+ businessLicenceDate );//修改内容
				ourQualityManagementAccessory.setReason(reason);//修改原因
				archivesList.add(ourQualityManagementAccessory);
			}
			ourQualityManagement.setBusinessLicenceDate(businessLicenceDate);//
		}
		
		
		if(isNull( businessPermitDate )){
			if(!isQuals( businessPermitDate , ourQualityManagement.getBusinessPermitDate () )){
				OurQualityManagementAccessory ourQualityManagementAccessory = new OurQualityManagementAccessory();
				ourQualityManagementAccessory.setModifier(user);//修改人
				ourQualityManagementAccessory.setProject_name("修改"+"经营许可证到期时间");//项目名称
				ourQualityManagementAccessory.setCompany_quality_management_id(ourQualityManagement.getId());//公司ID
				ourQualityManagementAccessory.setModified_time(new Date());//修改时间
				ourQualityManagementAccessory.setChangeContent("修改"+"经营许可证到期时间，修改前值为："+ourQualityManagement.getBusinessPermitDate () +"修改后值为："+ businessPermitDate );//修改内容
				ourQualityManagementAccessory.setReason(reason);//修改原因
				archivesList.add(ourQualityManagementAccessory);
			}
			ourQualityManagement.setBusinessPermitDate (businessPermitDate);//
		}
		
		
		if(isNull( gspCertificateDate )){
			if(!isQuals( gspCertificateDate , ourQualityManagement.getGspCertificateDate () )){
				OurQualityManagementAccessory ourQualityManagementAccessory = new OurQualityManagementAccessory();
				ourQualityManagementAccessory.setModifier(user);//修改人
				ourQualityManagementAccessory.setProject_name("修改"+"GSP/GMP到期时间");//项目名称
				ourQualityManagementAccessory.setCompany_quality_management_id(ourQualityManagement.getId());//公司ID
				ourQualityManagementAccessory.setModified_time(new Date());//修改时间
				ourQualityManagementAccessory.setChangeContent("修改"+"GSP/GMP到期时间，修改前值为："+ourQualityManagement.getGspCertificateDate () +"修改后值为："+ gspCertificateDate );//修改内容
				ourQualityManagementAccessory.setReason(reason);//修改原因
				archivesList.add(ourQualityManagementAccessory);
			}
			ourQualityManagement.setGspCertificateDate (gspCertificateDate);//
		}
		
		
		if(isNull( organizationCodeDate )){
			if(!isQuals( organizationCodeDate , ourQualityManagement.getOrganizationCodeDate () )){
				OurQualityManagementAccessory ourQualityManagementAccessory = new OurQualityManagementAccessory();
				ourQualityManagementAccessory.setModifier(user);//修改人
				ourQualityManagementAccessory.setProject_name("修改"+"组织机构代码到期时间");//项目名称
				ourQualityManagementAccessory.setCompany_quality_management_id(ourQualityManagement.getId());//公司ID
				ourQualityManagementAccessory.setModified_time(new Date());//修改时间
				ourQualityManagementAccessory.setChangeContent("修改"+"组织机构代码到期时间，修改前值为："+ourQualityManagement.getOrganizationCodeDate () +"修改后值为："+ organizationCodeDate );//修改内容
				ourQualityManagementAccessory.setReason(reason);//修改原因
				archivesList.add(ourQualityManagementAccessory);
			}
			ourQualityManagement.setOrganizationCodeDate (organizationCodeDate);//
		}
		
		
		if(isNull( remark )){
			if(!isQuals( remark , ourQualityManagement.getRemark () )){
				OurQualityManagementAccessory ourQualityManagementAccessory = new OurQualityManagementAccessory();
				ourQualityManagementAccessory.setModifier(user);//修改人
				ourQualityManagementAccessory.setProject_name("修改"+"备注");//项目名称
				ourQualityManagementAccessory.setCompany_quality_management_id(ourQualityManagement.getId());//公司ID
				ourQualityManagementAccessory.setModified_time(new Date());//修改时间
				ourQualityManagementAccessory.setChangeContent("修改"+"备注，修改前值为："+ourQualityManagement.getRemark () +"修改后值为："+ remark );//修改内容
				ourQualityManagementAccessory.setReason(reason);//修改原因
				archivesList.add(ourQualityManagementAccessory);
			}
			ourQualityManagement.setRemark (remark);//
		}
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		batchUpload(multiRequest, ourQualityManagement);
		ourQualityManagementService.saveOrUpdate(ourQualityManagement);//注意,这句原本是saveOrUpdate
		ourQualityManagementAccessoryService.saveList(archivesList);
		logService.addLog("修改我公司资质管理", user.getRealname(), "修改", "企业资质管理  > 我公司资质管理", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	
	public static void batchUpload(MultipartHttpServletRequest   request,OurQualityManagement ourQualityManagementUnit){
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
					if(requestName.equals("businessLicencePath")){//营业执照路径
						ourQualityManagementUnit.setBusinessLicencePath(relativeSavePath);
					}else if(requestName.equals("businessPermitPath")){//经营许可证路径
						ourQualityManagementUnit.setBusinessPermitPath(relativeSavePath);
					}else if(requestName.equals("gspCertificatePath")){//GSP路径
						ourQualityManagementUnit.setGspCertificatePath(relativeSavePath);
					}else if(requestName.equals("organizationCodePath")){//组织机构代码证路径
						ourQualityManagementUnit.setOrganizationCodePath(relativeSavePath);
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
	
	/*
	 * 查看公司资质修改记录
	 */
	@RequestMapping("/firstEnterprise/query_wgszzgljl.html")
	public ModelAndView ourQualityManagementListModiRecord(Model model,HttpServletRequest request ,HttpServletResponse response){
		List<OurQualityManagementAccessory> accessoryList =  new ArrayList<OurQualityManagementAccessory>();//new一个操作记录的ArraysList
		String page = DisplayGetPage.getPageParamName("archives", request);
		String hql = "from OurQualityManagement a where a.deleteFlag=0 order by a.id DESC";
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		if(page==null){
			accessoryList = ourQualityManagementAccessoryService.findAccessoriesListByPage(id, 0, Constants.pagesize);
		}else{
			accessoryList = ourQualityManagementAccessoryService.findAccessoriesListByPage(id,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		//String sql ="select count(*) from t_qualified_purchase_units_archives where qualified_purchase_units_id="+id;
		int resultSize = ourQualityManagementAccessoryService.countRecord(id);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		//List<QualifiedSuppliers> qualiSuppList = qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/QYZZ/WGSZZGL/wgszzgljl","accessoryList",accessoryList);
	}
	
	
	@RequestMapping("/firstEnterprise/view_wgszzglxg.html")
	public ModelAndView viewOurQualityManagement(Model model,HttpServletRequest request ,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		
		OurQualityManagement ourQualityManagement = ourQualityManagementService.findById(id);//NullPointerException
		model.addAttribute("ourQualityManagement",ourQualityManagement);
		return  new  ModelAndView("/QYZZ/WGSZZGL/view_wgszzgl");
	}
	
	
	@RequestMapping("/firstEnterprise/deleteOurQualityManagementAttachment.html")
	public ModelAndView deleteFile(Model mode ,HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String fileName = request.getParameter("fileName");
		String type=request.getParameter("type");
	    String ctxPath = request.getSession().getServletContext().getRealPath(  
        "/");
	    String filePath = ctxPath + fileName;
	    Long oqmId = null;
	    if(id!=null && !id.trim().equals("")){
	    	oqmId = Long.valueOf(id);
	    }else{
	    	oqmId = Long.valueOf(0);
	    }
	   OurQualityManagement OurQualityManagement =  ourQualityManagementService.get(oqmId);
	   if(type!=null && !type.trim().equals("")){
		   if(type.equals("yyzz")){
			   OurQualityManagement.setBusinessLicencePath("");
		   }else if(type.equals("jyxkz")){
			   OurQualityManagement.setBusinessPermitPath("");
		   }else if(type.equals("gspzs")){
			   OurQualityManagement.setGspCertificatePath("");
		   }else if(type.equals("zzjgdm")){
			   OurQualityManagement.setOrganizationCodePath("");
		   }
	   }
	   ourQualityManagementService.saveOrUpdate(OurQualityManagement);
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
	
	
	
	@RequestMapping("/firstEnterprise/ajaxQueryWarnOurQualityManagement.html")
	public String ajaxQuerWarn(Model model,HttpServletRequest request,HttpServletResponse response){
		StringBuffer warnStr = new StringBuffer();//警告信息
		StringBuffer hqlBuffer = new StringBuffer(" from OurQualityManagement a where 1=1 and  a.delete_flag=0 ");
		StringBuffer subjectBuffer = new StringBuffer();
		String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils.getCalendar(Integer.valueOf(60)));//60天的预警
		String nowdate = DateTimeUtils.getNowStrDate();
		subjectBuffer.append("or a.businessLicenceDate<='"+startDate+"'  ");//营业执照
		subjectBuffer.append("or a.businessPermitDate<='"+startDate+"'  ");//经营许可证
		subjectBuffer.append("or a.gspCertificateDate<='"+startDate+"'  ");//GSP/GMP
		subjectBuffer.append("or a.organizationCodeDate<='"+startDate+"'  ");//组织机构代码
		String subjecStr = subjectBuffer.toString();
		
		if(!subjecStr.trim().equals("")){
			String str = subjecStr.substring(2);
			hqlBuffer.append(" and ( ");
			hqlBuffer.append(str);
			hqlBuffer.append(" )");
		}
		
		
		List<OurQualityManagement> ourQualityManagementList = ourQualityManagementService.findList(hqlBuffer.toString());
		for(OurQualityManagement oqm : ourQualityManagementList){
			String yyzz = oqm.getBusinessLicenceDate();//营业执照到期时间
			String jyxk = oqm.getBusinessPermitDate();//经营许可证到期时间
			String gsp = oqm.getGspCertificateDate();//GSP到期时间
			String zzjgdmnj=oqm.getOrganizationCodeDate();//组织机构代码到期时间
			String today = DateTimeUtils.getNowStrDate();
			
			if(oqm.getDelete_flag()==0){
				if(oqm.getBusinessLicenceDate()!="" && yyzz!=null && DateTimeUtils.compareTwoDate(startDate,yyzz)>=0){
					int days =  DateTimeUtils.compareDateInterval(yyzz, nowdate);
					if(days>=0){
						warnStr.append("&nbsp;<a href='view_wgszzglxg.html?id="+oqm.getId()+"' traget='_blank'>");
						warnStr.append(""+oqm.getCustomer_name()+"营业执照还有<font>"+days+"</font>天 到期</a>");
					}else{
						warnStr.append("&nbsp;<a href='view_wgszzglxg.html?id="+oqm.getId()+"' traget='_blank'>");
						warnStr.append(""+oqm.getCustomer_name()+"营业执照已过期<font>"+Math.abs(days)+"</font>天</a>");
					}
				}
				
				if(oqm.getBusinessPermitDate()!="" && jyxk!=null && DateTimeUtils.compareTwoDate(startDate,jyxk)>=0){
					int days =  DateTimeUtils.compareDateInterval(jyxk, nowdate);
					if(days>=0){
						warnStr.append("&nbsp;<a href='view_wgszzglxg.html?id="+oqm.getId()+"' traget='_blank'>");
						warnStr.append(""+oqm.getCustomer_name()+"经营/生产许可证还有<font>"+days+"</font>天 到期</a>");
					}else{
						warnStr.append("&nbsp;<a href='view_wgszzglxg.html?id="+oqm.getId()+"' traget='_blank'>");
						warnStr.append(""+oqm.getCustomer_name()+"经营/生产许可证已过期<font>"+Math.abs(days)+"</font>天</a>");
					}
				}
				
				
				if(oqm.getGspCertificateDate()!="" && gsp!=null && DateTimeUtils.compareTwoDate(startDate,gsp)>=0){
					int days =  DateTimeUtils.compareDateInterval(gsp, nowdate);
					if(days>=0){
						warnStr.append("&nbsp;<a href='view_wgszzglxg.html?id="+oqm.getId()+"' traget='_blank'>");
						warnStr.append(""+oqm.getCustomer_name()+"GSP/GMP证书还有<font>"+days+"</font>天 到期</a>");
					}else{
						warnStr.append("&nbsp;<a href='view_wgszzglxg.html?id="+oqm.getId()+"' traget='_blank'>");
						warnStr.append(""+oqm.getCustomer_name()+"GSP/GMP证书已过期<font>"+Math.abs(days)+"</font>天</a>");
					}
				}
				
				
				if(oqm.getOrganizationCodeDate()!="" && zzjgdmnj!=null && DateTimeUtils.compareTwoDate(startDate,zzjgdmnj)>=0){
					int days =  DateTimeUtils.compareDateInterval(zzjgdmnj, nowdate);
					if(days>=0){
						warnStr.append("&nbsp;<a href='view_wgszzglxg.html?id="+oqm.getId()+"' traget='_blank'>");
						warnStr.append(""+oqm.getCustomer_name()+"组织机构代码证还有<font>"+days+"</font>天 到期</a>");
					}else{
						warnStr.append("&nbsp;<a href='view_wgszzglxg.html?id="+oqm.getId()+"' traget='_blank'>");
						warnStr.append(""+oqm.getCustomer_name()+"组织机构代码证已过期<font>"+Math.abs(days)+"</font>天</a>");
					}
				}
				
				
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", warnStr.toString());
		UtilJson.printMapJson(response, map);
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String calculationTime(OurQualityManagement oqm){
		
		
		
		
		return "";
	}
	
	
	
	
	
	
	private boolean isNull(String str){
		
		return str!=null && !"".equals(str.trim());
	}
	
	private boolean isQuals(String str1,String str2){
		if(str2==null)
			return false;
		return str1.trim().equals(str2.trim());
	}
}
