package com.sinosoft.varietyManger.firstVarietyManger.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.FileOperate;
import com.sinosoft.util.FileUtil;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityFiles;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityTrackRecord;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityFilesService;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityTrackrecordService;
@Controller
public class QualityTrackrecordAction extends BaseFormController {
	@Autowired
	private QualityTrackrecordService service;
	@Autowired
	private QualityMidicineMng qualityMidicineMng;
	@Autowired
	private SystemLogService logService;
	@Autowired
	private QualityFilesService qualityFilesService;
	@RequestMapping("/drugVarieties/qualityFiles.html")
	public ModelAndView findQualityMidicineList(Model model ,HttpServletRequest request,HttpServletResponse response){
		String page = DisplayGetPage.getPageParamName("record", request);
		//List<QualityMidicine> qualityMidinceList = null;
		String medicNo = request.getParameter("medicNo");
		String commonName = request.getParameter("commonName");
		List<QualityFiles> qualitFilesList = null;
		if(page==null){
			qualitFilesList = service.getQualityFiles(medicNo, commonName, 0,Constants.pagesize);
		}else{
				qualitFilesList  = service.getQualityFiles(medicNo, commonName,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
		
		//String sql = "select count(*) from t_qualified_medicine a where a.id in (select b.qualified_medicine_id from  t_quality_track_record b group by b.qualified_medicine_id) "; 
		int resultSize = service.countQualityFiles(medicNo, commonName);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("arietyManage/qualityTrackRecord/qualityFiles","qualitFilesList",qualitFilesList);
	}
	@RequestMapping("/drugVarieties/findQualityTrackRecord.html")
	public ModelAndView findQualityTrackRecord(Model model ,HttpServletRequest request,HttpServletResponse response){
		String page = DisplayGetPage.getPageParamName("record", request);
		 
		String qualityFilesId = request.getParameter("qualityFilesId");
		Long id  = null;
		if(qualityFilesId!=null && qualityFilesId.trim().length()>0){
			id = Long.valueOf(qualityFilesId);
		}else{
			id = Long.valueOf(0);
		}
		List<QualityTrackRecord> recordList = null;
		if(page==null){
			recordList = service.getTrackRecordList(id, 0, Constants.pagesize);
		}else{
			recordList = service.getTrackRecordList(id,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
	//	StringBuffer sqlBuffer = new StringBuffer( "select count(*) from t_quality_track_record a where a.qualified_medicine_id ="+qualityMidicineId);
	//	int resultSize = service.getRecordCount(sqlBuffer.toString());
		int resultSize = service.countTrackRecordList(id);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("qualified", id);
		return new ModelAndView("arietyManage/qualityTrackRecord/qualityTrackRecordList","recordList",recordList);
	}
	@RequestMapping("/drugVarieties/addQualityFiles.html")
	public String addQualityFiles(Model model,HttpServletRequest request,HttpServletResponse response){
		return "arietyManage/qualityTrackRecord/addQualityFiels";
	}
	@RequestMapping("/drugVarieties/addQualityTrackRecord.html")
	public ModelAndView addQualityTrackRecord(Model model ,HttpServletRequest request,HttpServletResponse response){
		String qualityFilesId  = request.getParameter("qualityFilesId");
		QualityFiles qualityFiles = service.getQualified(Long.parseLong(qualityFilesId));
		model.addAttribute("qualityFilesId", qualityFilesId);
		model.addAttribute("qualityFiles", qualityFiles);
		return new ModelAndView("arietyManage/qualityTrackRecord/addQualityTrackRecord");
	}
	@RequestMapping("/drugVarieties/saveQualityTrackRecord.html")
	public ModelAndView saveQualityTrackRecord(QualityTrackRecord trackRecord,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		String qulityFilesId = request.getParameter("qualityFilesId");
		response.setCharacterEncoding("utf-8");
		QualityFiles qualityFiles = service.getQualified(Long.parseLong(qulityFilesId));
		trackRecord.setQualityFiles(qualityFiles);
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
		batchUpload(multiRequest, trackRecord);
		trackRecord.setModifiedTime(new Date());
		trackRecord.setModifierId(user.getId());
		QualityTrackRecord record = service.save(trackRecord);
		logService.addLog("新增质量档案", user.getRealname(), "新增", "品种管理  >质量档案", StringUtil.getIpAddr(request));
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		if(record.getId()!=null){
			resultMap.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		}else{
			resultMap.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
		}
		resultMap.put("qualityFilesId", qulityFilesId);
		UtilJson.printMapJson(response, resultMap);
		return null;
	}
	@RequestMapping("/drugVarieties/saveQualityFiles.html")
	public String saveQualityFiels(QualityFiles qualityFiles,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		String createDate = DateTimeUtils.format(new Date(), DateTimeUtils.JAVA_DATE_FORMATTER);
		qualityFiles.setCreateDate(createDate);
		String qualityMidicine = request.getParameter("qualityMidicineId");
		QualityMidicine quMidicine = qualityMidicineMng.get(Long.parseLong(qualityMidicine));
		qualityFiles.setQualityMidicine(quMidicine);
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			service.saveQaulified(qualityFiles);
			map.put("success", URLEncoder.encode("保存数据成功！", "UTF-8"));
		}catch (Exception e) {
			e.printStackTrace();
			map.put("success", URLEncoder.encode("保存数据失败！", "UTF-8"));
			UtilJson.printMapJson(response, map);
			return null;
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugVarieties/viewQualityFiles.html")
	public ModelAndView viewQualityFiles(Model model ,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		String type = request.getParameter("type");
		Long id = null;
		if(p_id!=null && p_id.trim().length()>0){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		QualityFiles qualityFiles = qualityFilesService.getQualified(id);
		//QualityMidicine qualityMidince = midinceService.get(record.getQualifiedMedicineId());
		model.addAttribute("qualityFiles", qualityFiles);
		//model.addAttribute("qualityMidince", qualityMidince);
		if(type.equals("view")){
			return new ModelAndView("arietyManage/qualityTrackRecord/viewQualityFiles");
		}else{
			return new ModelAndView("arietyManage/qualityTrackRecord/editQualityFiles");
		}
		
	}
	@RequestMapping("/drugVarieties/viewQualityTrackRecord.html")
	public ModelAndView viewQualityTrackRecord(Model model ,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && p_id.trim().length()>0){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		QualityTrackRecord record = service.get(id);
		//QualityMidicine qualityMidince = midinceService.get(record.getQualifiedMedicineId());
		model.addAttribute("record", record);
		//model.addAttribute("qualityMidince", qualityMidince);
		return new ModelAndView("arietyManage/qualityTrackRecord/viewQualityTrackRecord");
	}
	@RequestMapping("/drugVarieties/updateQualityFiles.html")
	public String updateQualityFiles(QualityFiles qualityFiles,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		Map<String, Object> map = new HashMap<String, Object>();
		String qualityMidicine = request.getParameter("qualityMidicineId");
		QualityMidicine quMidicine = qualityMidicineMng.get(Long.parseLong(qualityMidicine));
		qualityFiles.setQualityMidicine(quMidicine);
		try{
			qualityFilesService.saveOrUpdate(qualityFiles);
			map.put("success", URLEncoder.encode("修改数据成功！","UTF-8"));
		}catch (Exception e) {
			e.printStackTrace();
			map.put("success", URLEncoder.encode("修改数据失败！","UTF-8"));
			UtilJson.printMapJson(response, map);
			return null;
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugVarieties/updateQualityTrackRecord.html")
	public ModelAndView updateQualityTrackRecord(QualityTrackRecord trackRecord,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		String qualityFilesId = request.getParameter("qualityFilesId");
		QualityFiles qualityFiles = service.getQualified(Long.parseLong(qualityFilesId));
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("qulityFilesId",qualityFilesId);
		try{
			trackRecord.setQualityFiles(qualityFiles);
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			batchUpload(multiRequest, trackRecord);
			trackRecord.setModifiedTime(new Date());
			trackRecord.setModifierId(user.getId());
			service.saveOrUpdate(trackRecord);
			logService.addLog("修改质量档案", user.getRealname(), "修改", "品种管理  >质量档案", StringUtil.getIpAddr(request));
			resultMap.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
			UtilJson.printMapJson(response, resultMap);
		}catch (Exception e) {
			resultMap.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
			UtilJson.printMapJson(response, resultMap);
		}
		return null;
	}
	@RequestMapping("/drugVarieties/deleteQualityFiles.html")
	public String deleteQualityFiles(Model model,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		String qualityFiles = request.getParameter("qualityFilesId");
		Long id = null;
		if(qualityFiles!=null && !"".equals(qualityFiles)){
			id = Long.parseLong(qualityFiles);
		}else{
			id = Long.valueOf(0);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			
			service.deleteQualified(id);
			map.put("success",URLEncoder.encode("删除数据成功！", "UTF-8"));
		}catch (Exception e) {
			e.printStackTrace();
			map.put("success",URLEncoder.encode("删除数据失败！", "UTF-8"));
			UtilJson.printMapJson(response, map);
			return null;
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugVarieties/deleteQualityTrackRecord.html")
	public ModelAndView deleteQualityTrackRecord(Model model ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && p_id.trim().length()>0){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			service.remove(id);
			User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
			logService.addLog("删除质量档案", user.getRealname(), "删除", "品种管理  >质量档案", StringUtil.getIpAddr(request));
		}catch (Exception e) {
			map.put("success", URLEncoder.encode("删除数据失败！", "UTF-8"));
			UtilJson.printMapJson(response, map);
		}
		map.put("success", URLEncoder.encode("删除数据成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}

	public static void batchUpload(MultipartHttpServletRequest request,
			QualityTrackRecord qualityTrackRecord) {
		// response.setCharacterEncoding("utf-8");
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
				if (requestName.equals("accessory_path")) {// 营业执照
					qualityTrackRecord.setAccessoryPath(relativeSavePath);
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
	@RequestMapping("/drugVarieties/deleteQualityTrackRecordFile.html")
	public ModelAndView deleteFile(Model mode ,HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String fileName = request.getParameter("fileName");
	//	String type=request.getParameter("type");
	    String ctxPath = request.getSession().getServletContext().getRealPath(  
        "/");
	    String filePath = ctxPath + fileName;
	    Long enterpriseId = null;
	    if(id!=null && !id.trim().equals("")){
	    	enterpriseId = Long.valueOf(id);
	    }else{
	    	enterpriseId = Long.valueOf(0);
	    }
	    QualityTrackRecord qualityTrackRecord =  service.get(enterpriseId);
	    qualityTrackRecord.setAccessoryPath("");
	    service.saveOrUpdate(qualityTrackRecord);
	   boolean status = FileOperate.delFile(filePath);
	   Map<String, Object> map = new HashMap<String, Object>();
	   if(status){
		   map.put("success",  URLEncoder.encode("删除附件成功！", "UTF-8"));
	   }else{
		   map.put("success", URLEncoder.encode("删除附件失败！", "UTF-8"));
	   }
	   UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugVarieties/ajaxQueryQualityMidince.html")
	public String findQualityMideic(Model model,HttpServletRequest request,HttpServletResponse response){
		List<QualityMidicine> midicList= null;
		StringBuffer json = new StringBuffer("[");
		response.setContentType("text/json;charset=UTF-8");
		try{
			midicList = service.findQualityMedic();
			for(int i=0,size = midicList.size();i<size;i++){
				QualityMidicine midicine = midicList.get(i);
				json.append("{");
				json.append("\"id\":"+midicine.getId()+",");
				json.append("\"text\":\"("+midicine.getMedicinalNo()+")"+midicine.getCommonname()+"\"");
				if(i==midicList.size()-1){
					json.append("}");
				}else{
					json.append("},");
				}
			}
			json.append("]");
			response.getWriter().write(json.toString());
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
