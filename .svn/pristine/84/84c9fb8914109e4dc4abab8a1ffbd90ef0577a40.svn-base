package com.sinosoft.varietyManger.firstVarietyManger.action;

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
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.FileOperate;
import com.sinosoft.util.FileUtil;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.DrugStandardsFiles;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.DrugStandardFilesService;

/**
 * @author lfl:
 * @version 创建时间：Jun 5, 2013 11:32:42 AM
 * 类说明
 */
@Controller
public class DrugStrandardFileAction extends BaseFormController {
	@Autowired
	private DrugStandardFilesService sevice;
	@Autowired
	private SystemLogService logService;
	@RequestMapping("/drugVarieties/standardFiles.html")
	public ModelAndView getDrugStandardFileList(Model model ,HttpServletRequest request,HttpServletResponse response){
		
		List<DrugStandardsFiles> drugStandardsFiles = new ArrayList<DrugStandardsFiles>();
			String page = DisplayGetPage.getPageParamName("standardFile", request);
			String hql = "from DrugStandardsFiles a  order by a.number DESC ";
			String sql = "select count(*) from t_quality_standard";
			if(page==null){
				drugStandardsFiles = sevice.findListByPage(hql, 0, Constants.pagesize);
			}else{
				drugStandardsFiles = sevice.findListByPage(hql,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}
			
			// 获取总条数
			int resultSize = sevice.getRecordCount(sql);
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("pagesize", Constants.pagesize);
			double size = resultSize;
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			return new ModelAndView("/arietyManage/drugStandard/ypbzda","standardFiles",drugStandardsFiles);
	}
	@RequestMapping("/drugVarieties/queryStandardFiles.html")
	public ModelAndView queryDrugStandardFileList(Model model ,HttpServletRequest request,HttpServletResponse response){
		
		List<DrugStandardsFiles> drugStandardsFiles = new ArrayList<DrugStandardsFiles>();
			String page = DisplayGetPage.getPageParamName("standardFile", request);
			String query_number = request.getParameter("query_number");
			String query_commonname = request.getParameter("query_commonname");
			StringBuffer hqlBuffer = new StringBuffer("from DrugStandardsFiles a  where 1=1 ");
			StringBuffer sqlbuffer = new StringBuffer("select count(*) from t_quality_standard where 1=1 ");
			
			if(query_number!=null&&!query_number.trim().equals("")){
				hqlBuffer.append(" and a.number like'%"+query_number+"%' ");
				sqlbuffer.append(" and number like'%"+query_number+"%'" );
			}
			if(query_commonname!=null&&!query_commonname.trim().equals("")){
				hqlBuffer.append(" and a.commonName like'%"+query_commonname+"%' ");
				sqlbuffer.append(" and common_name like'%"+query_commonname+"%'" );
			}
			hqlBuffer.append(" order by a.number DESC ");
			if(page==null){
				drugStandardsFiles = sevice.findListByPage(hqlBuffer.toString(), 0, Constants.pagesize);
			}else{
				drugStandardsFiles = sevice.findListByPage(hqlBuffer.toString(),(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}
			
			// 获取总条数
			int resultSize = sevice.getRecordCount(sqlbuffer.toString());
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("pagesize", Constants.pagesize);
			double size = resultSize;
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			return new ModelAndView("/arietyManage/drugStandard/ypbzda","standardFiles",drugStandardsFiles);
	}
	@RequestMapping("/drugVarieties/add_standardFile.html")
	public String addDrugStandardFilePage(Model model,HttpServletRequest request,HttpServletResponse response){
		String maxNumber = sevice.getMaxNumber();
		if(maxNumber!=null && !"".equals(maxNumber)){
			maxNumber = String.format("%04d", (Integer.parseInt(maxNumber)+1));
		}else{
			maxNumber="0001";
		}
		model.addAttribute("maxNumber",maxNumber);
		return "/arietyManage/drugStandard/add_ypbzda";
	}
	@RequestMapping("/drugVarieties/view_standardFile.html")
	public String viewDrugStandardFilePage(Model model,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		String type = request.getParameter("type");
		Long id = null;
		if(p_id!=null && !p_id.trim().equals("")){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		DrugStandardsFiles standardsFile = sevice.get(id);
		model.addAttribute("standardsFile", standardsFile);
		if(type.equals("view")){
			return "/arietyManage/drugStandard/view_ypbzda";
		}else{
			return "/arietyManage/drugStandard/edit_ypbzda";
		}
	}
	
	@RequestMapping("/drugVarieties/save_standardFile.html")
	public String  addDrugStandardFilePage(DrugStandardsFiles standardsFiles ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		//String commonName = request.getParameter("commonName");
		
	//	QualityMidicine 	qualityMidicine = qualityService.get(id);
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		//standardsFiles.setQualityMidicine(qualityMidicine);
	//	standardsFiles.setCommonName(commonName);
		standardsFiles.setCreateUserName(user.getRealname());
		standardsFiles.setCreateDate(new Date());
		//MultipartHttpServletRequest mulitRequest = (MultipartHttpServletRequest)request;
		//batchUpload(mulitRequest,standardsFiles);
		standardsFiles = sevice.save(standardsFiles);
		logService.addLog("新增质量标准档案", user.getRealname(), "新增", "品种管理  >质量标准档案", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		if(standardsFiles.getId()!=null){
			map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		}else{
			map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugVarieties/update_standardFile.html")
	public String  updateDrugStandardFilePage(DrugStandardsFiles standardsFiles ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		//User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		/*String commonName = request.getParameter("commonName");
		Long id = null;
		if(commonName!=null && !commonName.trim().equals("")){
			id = Long.valueOf(commonName);
		}else{
			id = Long.valueOf(0);
		}*/
		DrugStandardsFiles file = sevice.get(standardsFiles.getId());
		//QualityMidicine 	qualityMidicine = qualityService.get(id);
		file.setNumber(standardsFiles.getNumber());
		file.setCommonName(standardsFiles.getCommonName());
		file.setFormsName(standardsFiles.getFormsName());
		//file.setQualityMidicine(qualityMidicine);
		file.setStandardAccord(standardsFiles.getStandardAccord());
		file.setRemark(standardsFiles.getRemark());
	//	MultipartHttpServletRequest mulitRequest = (MultipartHttpServletRequest)request;
	//	batchUpload(mulitRequest,standardsFiles);
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		sevice.saveOrUpdate(file);
		logService.addLog("修改质量标准档案", user.getRealname(), "修改", "品种管理  >质量标准档案", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		
		UtilJson.printMapJson(response, map);
		//UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/drugVarieties/delete_standardFile.html")
	public String  deleteDrugStandardFilePage(String[] delete_id ,HttpServletRequest request,HttpServletResponse response){
		String[] ids = delete_id;
		int index = 1;
		if(ids!=null && ids.length>0){
			for(String id :ids){
				Long p_id = Long.valueOf(id);
				sevice.remove(p_id);
				index++;
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除质量标准档案", user.getRealname(), "删除", "品种管理  >质量标准档案", StringUtil.getIpAddr(request));
		return "redirect:/drugVarieties/standardFiles.html";
	}
	public static void batchUpload(MultipartHttpServletRequest   request,DrugStandardsFiles drugStandardsFiles){
		//response.setCharacterEncoding("utf-8");
		  Map<String, MultipartFile> filesMap = request.getFileMap();
			 String serverRealPath = request.getSession().getServletContext().getRealPath("/");//获取服务器绝对路径
				String fileSavePath = serverRealPath+Constants.UPLOAD_PATH;//上传文件存储的绝对路径
				String fileTempPath = serverRealPath+Constants.TEMPPATH;//上传文件在服务器临时存储的的绝对路径
				new File(fileSavePath).mkdirs();
				try{
					File tempPathFile = new File(fileTempPath);
					if(!tempPathFile.exists()){
						tempPathFile.mkdirs();
				Iterator<String> its = filesMap.keySet().iterator();
				while(its.hasNext()){
					String requestName = its.next();
					MultipartFile item = filesMap.get(requestName);
					String fileName = FileUtil.getFileName();//重命名文件名
					MultipartFile uploadFile = (MultipartFile) item;
					if(uploadFile.getOriginalFilename()==null || uploadFile.getOriginalFilename().equals(""))
						continue;
					String fileNameLong = uploadFile.getOriginalFilename();//获取上传文件的名称
					String fileNameExtension = FileUtil.getFileExtension(fileNameLong);//获取文件的上传拓展名
					String relativeSavePath = Constants.UPLOAD_PATH+fileName+"."+fileNameExtension;//用户保存到数据库的相对文件路径及名称
					relativeSavePath = relativeSavePath.substring(1);
					File savaFile = new File(fileSavePath+fileName+"."+fileNameExtension);
					if(!savaFile.exists()){
						savaFile.createNewFile();
					}
					if(requestName.equals("attach_path")){//营业执照
						drugStandardsFiles.setAttachmentPath(relativeSavePath);
					}else{
						
					}
					uploadFile.transferTo(savaFile);
					}
				}
				}catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	
	@RequestMapping("/drugVarieties/deltefilestand.html")
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
	    DrugStandardsFiles drugStandardsFiles =  sevice.get(enterpriseId);
	   if(type!=null && !type.trim().equals("")){
		   if(type.equals("fj")){
			   drugStandardsFiles.setAttachmentPath("");
		   }
	   }
	   sevice.saveOrUpdate(drugStandardsFiles);
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
}
