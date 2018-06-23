package com.sinosoft.enterpriseManage.firstEnterprise.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.sinosoft.enterpriseManage.firstEnterprise.model.CommissionedStorageUnitQualification;
import com.sinosoft.enterpriseManage.firstEnterprise.model.CommissionedStorageUnitQualificationAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.service.CommissionedStorageUnitQualificationAccessoryService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.CommissionedStorageUnitQualificationService;
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
 * @version 创建时间：Nov 27, 2014 3:33:01 PM 类说明 委托储存单位资质Action
 */
/*
 * 该类采用了java反射机制进行处理了一些重复get/set方法,如果要看项目仿着写建议不要参考本类
 */
@Controller
public class CommissionedStorageUnitQualificationAction extends
		BaseFormController {

	@Autowired
	private CommissionedStorageUnitQualificationService csuqService;
	@Autowired
	private CommissionedStorageUnitQualificationAccessoryService csuqAccessoryService;
	@Autowired
	private SystemLogService logService;

	/*
	 * 显示“委托储存单位资质”页面
	 */
	@RequestMapping("/firstEnterprise/wtccdwzz.html")
	public ModelAndView getCommissionedStorageUnitQualificationList(
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		List<CommissionedStorageUnitQualification> csuqList = new ArrayList<CommissionedStorageUnitQualification>();
		String page = DisplayGetPage.getPageParamName("csuq", request);// 取出页面数据
		String hql = "from CommissionedStorageUnitQualification a where a.delete_flag=0 order by a.id DESC";
		if (page == null) {
			csuqList = csuqService.findListByPage(hql, 0, Constants.pagesize);
		} else {
			csuqList = csuqService.findListByPage(hql,
					(Integer.parseInt(page) - 1) * Constants.pagesize,
					Constants.pagesize);
		}
		// 获取总条数
		String sql = "select count(*) from t_commissioned_storage_unit_qualification where delete_flag=0";// ?
		int resultSize = csuqService.countRecordByCondition(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size
				/ Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);

		return new ModelAndView("/QYZZ/WTCCDWZZ/wtccdwzz", "csuqList", csuqList);
	}

	/*
	 * 修改委托储存单位
	 */
	@RequestMapping("/firstEnterprise/update_wtccdwzzxg.html")
	public String updataCommissionedStorageUnitQualification(Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");// 客户ID
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("companyName", "企业名称");
		parameter.put("legalRepresentative", "法定代表人");
		parameter.put("compamyAddress", "企业地址");
		parameter.put("quality_principal", "质量负责人");
//		parameter.put("bankName", "开户银行");
//		parameter.put("bankNumber", "开户银行账号");
//		parameter.put("taxReceiptAddress", "税票信息地址");
//		parameter.put("taxReceiptPhone", "税票电话");
		parameter.put("warehouseAddress", "储存仓库地址");
		parameter.put("storageScope", "储存范围");
		parameter.put("business_licence_date", "营业执照到期时间期");
		parameter.put("licence_date", "经营许可证到期时间");
		parameter.put("gsp_certificate_date", "gsp证书到期日期");
//		parameter.put("organization_code_date", "组织机构代码到期时间期");
//		parameter.put("organization_code_inspection_date", "组织机构代码年检时间");
		parameter.put("third_logistics_drug_confirmation_date",
				"第三方药品物流业务确认书到期时间");
		parameter.put("remark", "备注");
		String reason = request.getParameter("reason");// 修改原因

		User user = (User) request.getSession().getAttribute(
				Constants.LOCAL_USER);
		Long p_Id = null;
		if (isNull(id)) {
			p_Id = Long.valueOf(id);
		} else {
			p_Id = Long.valueOf(0);
		}
		CommissionedStorageUnitQualification csuq = csuqService.get(p_Id);
		List<CommissionedStorageUnitQualificationAccessory> archivesList = new ArrayList<CommissionedStorageUnitQualificationAccessory>();// 储存操作记录

		Set<String> parameterKey = parameter.keySet();
		String project_name = null;
		for (String key : parameterKey) {// 遍历key
			String requestParameter = request.getParameter(key);// 获取页面参数，在JSP中尽量放一样的名字
			Object obj = CallMethod(csuq, "get" + toUpperCaseFirstOne(key),
					null);// 调用实体类中的getXX方法
			if (obj instanceof String) {
				if (isNull(requestParameter)) {
					if (!isQuals(requestParameter, (String) obj)) {
						project_name = parameter.get(key);// 取的是中文名称
						CommissionedStorageUnitQualificationAccessory csuqAccessory = new CommissionedStorageUnitQualificationAccessory();
						csuqAccessory.setModifier(user);
						csuqAccessory.setProject_name("修改" + project_name);
						csuqAccessory.setCsuqId(csuq.getId());
						csuqAccessory.setModified_time(new Date());
						csuqAccessory.setChangeContent("修改" + project_name
								+ "，修改前值为：" + (String) obj + "修改后值为："
								+ requestParameter);
						csuqAccessory.setReason(reason);
						archivesList.add(csuqAccessory);
					}
					CallMethod(csuq, "set" + toUpperCaseFirstOne(key),
							requestParameter);
				}
			}

		}

		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		batchUpload(multiRequest, csuq);
		csuqService.saveOrUpdate(csuq);
		csuqAccessoryService.saveList(archivesList);
		System.out.println(csuq.getCompanyNumber());
		if (project_name != null) {
			logService.addLog("修改" + project_name, user.getRealname(), "修改",
					"企业资质管理  > 委托储存单位资质", StringUtil.getIpAddr(request));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}

	public static void batchUpload(MultipartHttpServletRequest request,
			CommissionedStorageUnitQualification csuq) {
		Map<String, MultipartFile> filesMap = request.getFileMap();
		String serverRealPath = request.getSession().getServletContext()
				.getRealPath("/");// 获取服务器绝对路径
		String fileSavePath = serverRealPath + Constants.UPLOAD_PATH;// 上传文件存储的绝对路径
		String fileTempPath = serverRealPath + Constants.TEMPPATH;// 上传文件在服务器临时存储的的绝对路径
		new File(fileSavePath).mkdirs();
		try {
			File tempPathFile = new File(fileTempPath);
			if (!tempPathFile.exists()) {
				tempPathFile.mkdirs();
			}
			Iterator<String> its = filesMap.keySet().iterator();
			while (its.hasNext()) {
				String requestName = its.next();
				MultipartFile item = filesMap.get(requestName);
				String fileName = FileUtil.getFileName();// 重命名文件名
				MultipartFile uploadFile = (MultipartFile) item;
				if (uploadFile.getOriginalFilename() == null
						|| uploadFile.getOriginalFilename().equals(""))
					continue;
				String fileNameLong = uploadFile.getOriginalFilename();// 获取上传文件的名称
				// String requestName = uploadFile.getName();//获取上传文件对应字段名称
				String fileNameExtension = FileUtil
						.getFileExtension(fileNameLong);// 获取文件的上传拓展名
				String relativeSavePath = Constants.UPLOAD_PATH + fileName
						+ "." + fileNameExtension;// 用户保存到数据库的相对文件路径及名称
				relativeSavePath = relativeSavePath.substring(1);
				File savaFile = new File(fileSavePath + fileName + "."
						+ fileNameExtension);
				if (!savaFile.exists()) {
					savaFile.createNewFile();
				}
				if (requestName.equals("business_licence_path")) {// 营业执照路径
					csuq.setBusiness_licence_path(relativeSavePath);
				} else if (requestName.equals("licence_path")) {// 经营许可证路径
					csuq.setLicence_path(relativeSavePath);
				} else if (requestName.equals("gsp_certificate_path")) {// GSP路径
					csuq.setGsp_certificate_path(relativeSavePath);
				} else if (requestName.equals("organization_code_path")) {// 组织机构代码证路径
					csuq.setOrganization_code_path(relativeSavePath);
				} else if (requestName
						.equals("tax_Registration_Certificate_Path")) {// 税务登记证
					csuq.setTax_Registration_Certificate_Path(relativeSavePath);
				} else if (requestName
						.equals("third_logistics_drug_confirmation_path")) {// 第三方药品物流业务确认书
					csuq
							.setThird_logistics_drug_confirmation_path(relativeSavePath);
				}
				uploadFile.transferTo(savaFile);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 查看公司资质修改记录
	 */
	@RequestMapping("/firstEnterprise/query_wtccdwzzjl.html")
	public ModelAndView commissionedStorageUnitQualificationListModiRecord(
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		List<CommissionedStorageUnitQualificationAccessory> accessoryList = new ArrayList<CommissionedStorageUnitQualificationAccessory>();// new一个操作记录的ArraysList
		String page = DisplayGetPage.getPageParamName("archives", request);
		String p_id = request.getParameter("id");
		Long id = null;
		if (p_id != null && !"".equals(p_id)) {
			id = Long.valueOf(p_id);
		} else {
			id = Long.valueOf(0);
		}
		if (page == null) {
			accessoryList = csuqAccessoryService.findAccessoriesListByPage(id,
					0, Constants.pagesize);
		} else {
			accessoryList = csuqAccessoryService.findAccessoriesListByPage(id,
					(Integer.parseInt(page) - 1) * Constants.pagesize,
					Constants.pagesize);
		}
		// 获取总条数
		// String sql
		// ="select count(*) from t_qualified_purchase_units_archives where qualified_purchase_units_id="+id;
		int resultSize = csuqAccessoryService.countRecord(id);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size
				/ Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/QYZZ/WTCCDWZZ/wtccdwzzjl", "accessoryList",
				accessoryList);
	}

	@RequestMapping("/firstEnterprise/view_wtccdwzz.html")
	public ModelAndView viewCommissionedStorageUnitQualification(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("id"));
		String p_id = request.getParameter("id");
		Long id = null;
		if (p_id != null && !"".equals(p_id)) {
			id = Long.valueOf(p_id);
		} else {
			id = new Long(0);
		}

		CommissionedStorageUnitQualification csuq = csuqService.get(id);// NullPointerException
		System.out.println(csuq.getCompanyNumber());
		model.addAttribute("csuq", csuq);
		return new ModelAndView("/QYZZ/WTCCDWZZ/view_wtccdwzz");
	}

	@RequestMapping("/firstEnterprise/deleteCommissionedStorageUnitQualification.html")
	public ModelAndView deleteFile(Model mode, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String fileName = request.getParameter("fileName");
		String type = request.getParameter("type");
		String ctxPath = request.getSession().getServletContext().getRealPath(
				"/");
		String filePath = ctxPath + fileName;
		Long oqmId = null;
		if (id != null && !id.trim().equals("")) {
			oqmId = Long.valueOf(id);
		} else {
			oqmId = Long.valueOf(0);
		}
		CommissionedStorageUnitQualification csuq = csuqService.get(oqmId);
		if (type != null && !type.trim().equals("")) {
			if (type.equals("yyzz")) {
				csuq.setBusiness_licence_path("");
			} else if (type.equals("jyxkz")) {
				csuq.setLicence_path("");
			} else if (type.equals("gspzs")) {
				csuq.setGsp_certificate_path("");
			} else if (type.equals("zzjgdmz")) {
				csuq.setOrganization_code_path("");
			} else if (type.equals("swdjz")) {
				csuq.setTax_Registration_Certificate_Path("");
			} else if (type.equals("dsfypwlywqrs")) {
				csuq.setThird_logistics_drug_confirmation_path("");
			}
		}
		csuqService.saveOrUpdate(csuq);
		boolean status = FileOperate.delFile(filePath);
		Map<String, Object> map = new HashMap<String, Object>();
		if (status) {
			map.put("success", URLEncoder.encode("删除附件成功！", "UTF-8"));
		} else {
			map.put("success", URLEncoder.encode("删除附件失败！", "UTF-8"));
		}
		UtilJson.printMapJson(response, map);
		return null;
	}

	@RequestMapping("/firstEnterprise/ajaxQueryWarnCommissionedStorageUnitQualification.html")
	public String ajaxQuerWarn(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		StringBuffer warnStr = new StringBuffer();// 警告信息
		StringBuffer hqlBuffer = new StringBuffer(
				" from CommissionedStorageUnitQualification a where 1=1 and  a.delete_flag=0");
		StringBuffer subjectBuffer = new StringBuffer();
		String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
				.getCalendar(Integer.valueOf(60)));// 60天的预警
		String nowdate = DateTimeUtils.getNowStrDate();
		subjectBuffer.append("or a.business_licence_date<='" + startDate
				+ "'  ");// 营业执照
		subjectBuffer.append("or a.licence_date<='" + startDate + "'  ");// 经营许可证
		subjectBuffer
				.append("or a.gsp_certificate_date<='" + startDate + "'  ");// GSP/GMP
//		subjectBuffer.append("or a.organization_code_date<='" + startDate
//				+ "'  ");// 组织机构代码
//		subjectBuffer.append("or a.organization_code_inspection_date<='"
//				+ startDate + "'  ");// 组织机构代码年检时间
		subjectBuffer.append("or a.third_logistics_drug_confirmation_date<='"
				+ startDate + "'  ");// 第三方药品物流业务确认书

		String subjecStr = subjectBuffer.toString();

		if (!subjecStr.trim().equals("")) {
			String str = subjecStr.substring(2);
			hqlBuffer.append(" and ( ");
			hqlBuffer.append(str);
			hqlBuffer.append(" )");
		}

		Map<String, String> dataArrays = new HashMap<String, String>();
		dataArrays.put("business_licence_date", "营业执照");
		dataArrays.put("licence_date", "经营/生产许可证");
		dataArrays.put("gsp_certificate_date", "GSP/GMP证书");
//		dataArrays.put("organization_code_date", "组织机构代码");
//		dataArrays.put("organization_code_inspection_date", "组织机构代码年检");
		dataArrays
				.put("third_logistics_drug_confirmation_date", "第三方药品物流业务确认书");

		List<CommissionedStorageUnitQualification> csuqList = csuqService
				.findList(hqlBuffer.toString());
		for (CommissionedStorageUnitQualification csuq : csuqList) {
			String today = DateTimeUtils.getNowStrDate();
			Set<String> dateKeySet = dataArrays.keySet();

			for (String dataName : dateKeySet) {
				Object obj = CallMethod(csuq, "get"
						+ toUpperCaseFirstOne(dataName), null);

				if (csuq.getDelete_flag() != 0) {
					continue;
				}
				obj = CallMethod(csuq, "get" + toUpperCaseFirstOne(dataName),
						null);
				if (obj != null && obj instanceof String) {
					String str = (String) obj;
					int date = DateTimeUtils
							.compareTwoDate(startDate, str);// 比较出时间的间隔
					if (date >= 0) {
						int days = DateTimeUtils.compareDateInterval(str,
								nowdate);
						if (days >= 0) {
							warnStr
									.append("&nbsp;<a href='view_wtccdwzz.html?id="
											+ csuq.getId()
											+ "' traget='_blank'>");
							warnStr.append("" + csuq.getCompanyName()
									+ dataArrays.get(dataName) + "还有<font>"
									+ days + "</font>天 到期</a>");
						} else {
							warnStr
									.append("&nbsp;<a href='view_wtccdwzz.html?id="
											+ csuq.getId()
											+ "' traget='_blank'>");
							warnStr.append("" + csuq.getCompanyName()
									+ dataArrays.get(dataName) + "已过期<font>"
									+ Math.abs(days) + "</font>天</a>");
						}
					}
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", warnStr.toString());
		UtilJson.printMapJson(response, map);
		return null;
	}

	@RequestMapping("/firstEnterprise/querywtccdwzz.html")
	public ModelAndView queryCommissionedStorageUnitQualificationList(
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		List<CommissionedStorageUnitQualification> csuqList = new ArrayList<CommissionedStorageUnitQualification>();
		String page = DisplayGetPage.getPageParamName("csuq", request);
		String query_khbh = request.getParameter("query_khbh");
		String query_kfmc = request.getParameter("query_kfmc");
		StringBuffer buffer = new StringBuffer();
		buffer.append("from CommissionedStorageUnitQualification a where 1=1 and  a.delete_flag=0 ");
		String sql = "select count(*) from t_commissioned_storage_unit_qualification where delete_flag=0 ";
		if (query_khbh != null && !"".equals(query_khbh.trim())) {
			buffer.append(" and a.companyNumber like'");
			buffer.append("%");
			buffer.append(query_khbh.trim() + "%'");
			sql = sql + " and companyNumber like'%" + query_khbh.trim() + "%'";
		}
		if (query_kfmc != null && !"".equals(query_kfmc.trim())) {
			buffer.append(" and a.companyName like'");
			buffer.append("%");
			buffer.append(query_kfmc.trim() + "%'");
			sql = sql + " and companyName like'%" + query_kfmc.trim() + "%'";
		}
		buffer.append(" order by a.companyNumber DESC");
		if (page == null) {
			csuqList = csuqService.findListByaPage(buffer.toString(), new HashMap<String, Object>(), 0, Constants.pagesize);
		} else {
			csuqList = csuqService.findListByaPage(buffer.toString(),
					new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数

		int resultSize = csuqService.countRecordByCondition(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size
				/ Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/QYZZ/WTCCDWZZ/wtccdwzz", "csuqList", csuqList);
	}

	@RequestMapping("/firstEnterprise/addCommissionedStorageUnitQualification.html")
	public String addSalesStaff(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		return "/QYZZ/WTCCDWZZ/add_wtccdwzz";
	}
	
	@RequestMapping("/firstEnterprise/saveCommissionedStorageUnitQualification.html")
	public String saveCommissionedStorageUnitQualification(Model model ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String companyNumber = request.getParameter("companyNumber");//公司编号
		String companyName = request.getParameter("companyName");// 企业名称
		String legalRepresentative = request.getParameter("legalRepresentative");// 法定代表人
		String compamyAddress = request.getParameter("compamyAddress");// 企业地址
		String quality_principal = request.getParameter("quality_principal");// 质量负责人
//		String taxReceiptAddress = request.getParameter("taxReceiptAddress");//税票信息地址
//		String taxReceiptPhone = request.getParameter("taxReceiptPhone");//税票电话
		String storageScope = request.getParameter("storageScope");//储存范围
		String warehouseAddress = request.getParameter("warehouseAddress");//储存仓库地址
		String business_licence_date = request.getParameter("business_licence_date");// 营业执照到期时间期
		String licence_date = request.getParameter("licence_date");// 经营许可证到期时间
//		String bankName = request.getParameter("bankName");// 开户银行
//		String bankNumber = request.getParameter("bankNumber");// 开户银行账号
		String gsp_certificate_date = request.getParameter("gsp_certificate_date");// gsp证书到期日期
//		String organization_code_date = request.getParameter("organization_code_date");// 组织机构代码到期时间期
//		String organization_code_inspection_date = request.getParameter("organization_code_inspection_date");//组织机构代码年检时间
		String third_logistics_drug_confirmation_date = request.getParameter("third_logistics_drug_confirmation_date");//第三方药品物流业务确认书到期时间
		String remark = request.getParameter("remark");// 备注
		
		MultipartHttpServletRequest multRequest = (MultipartHttpServletRequest) request; 
		User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER);
		CommissionedStorageUnitQualification csuq = new CommissionedStorageUnitQualification();
//		csuq.setBankName(bankName);
//		csuq.setBankNumber(bankNumber);
		csuq.setBusiness_licence_date(business_licence_date);
		csuq.setCompamyAddress(compamyAddress);
		csuq.setCompanyName(companyName);
		csuq.setCompanyNumber(Long.parseLong(companyNumber));
		csuq.setGsp_certificate_date(gsp_certificate_date);
		csuq.setLegalRepresentative(legalRepresentative);
		csuq.setLicence_date(licence_date);
//		csuq.setOrganization_code_date(organization_code_date);
//		csuq.setOrganization_code_inspection_date(organization_code_inspection_date);
		csuq.setQuality_principal(quality_principal);
		csuq.setRemark(remark);
		csuq.setStorageScope(storageScope);
//		csuq.setTaxReceiptAddress(taxReceiptAddress);
//		csuq.setTaxReceiptPhone(taxReceiptPhone);
		csuq.setThird_logistics_drug_confirmation_date(third_logistics_drug_confirmation_date);
		csuq.setWarehouseAddress(warehouseAddress);
		csuq.setDelete_flag(0);
		csuq.setUseFlag("0");
		
		batchUpload(multRequest,csuq);
		csuqService.save(csuq);
		logService.addLog("委托储存单位", user.getRealname(), "新增", "企业资质管理 > 委托储存单位资质", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * 利用java反射机制调用方法 Ps:该方法不支持基本类型的传递，请使用包装类
	 * 
	 * @param classType
	 *            调用哪个类
	 * @param classData
	 *            请把该类传递进来
	 * @param methodName
	 *            方法名
	 * @param parameterTypes
	 *            参数类型(请保证传递的参数和方法类型一致，否则后果哼哼)
	 * @param parameterData
	 *            请把该参数传递进来
	 * @return
	 */
	private static Object CallMethod(Object classData, String methodName,
			Object parameterData) {
		try {
			Method m = null;
			if (parameterData == null) {
				m = classData.getClass().getMethod(methodName);
				return m.invoke(classData);// 调用methodName方法;
			} else {
				m = classData.getClass().getMethod(methodName,
						parameterData.getClass());
				return m.invoke(classData, parameterData);// 调用methodName方法;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String toUpperCaseFirstOne(String str) {
		return str.substring(0, 1).toUpperCase() + str.replaceFirst("\\w", "");
	}

	private String toLowerCaseFirstOne(String str) {
		return str.substring(0, 1).toLowerCase() + str.replaceFirst("\\w", "");
	}

	private boolean isNull(String str) {

		return str != null && !"".equals(str.trim());
	}

	private boolean isQuals(String str1, String str2) {
		if (str2 == null)
			return false;
		return str1.trim().equals(str2.trim());
	}
}
