package com.sinosoft.qualityRecords.infoFeedback.action;


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
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.qualityRecords.complantManager.service.DrugComInfoManger;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedBackItemVO;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedback;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedbackItem;
import com.sinosoft.qualityRecords.infoFeedback.serivice.InfoFeedbackMng;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;

@Controller
public class InfoFeedbackAct {
	@Autowired
	private InfoFeedbackMng infoFeedbackMng;
	@Autowired
	private DrugComInfoManger drugComInfoManger;
	@Autowired
	private SystemLogService logService;
	/**
	 * @param df
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/qualityRecords/infoFeedback/list.html")
	public ModelAndView openFramePage(InfoFeedbackItem df, HttpServletRequest request, HttpServletResponse response, Model model){
			String page = DisplayGetPage.getPageParamName("records", request);// 第几页
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);//登录人
			String feedbackdepartment = request.getParameter("feedbackdepartment");//反馈部门
			String pinming = request.getParameter("pinming");//品名
			String startDate  = request.getParameter("startDate");//反馈开始时间
			String endDate =  request.getParameter("endDate");//反馈结束时间
			
			List<InfoFeedback> infoFeedbackList = null;//信息反馈单的发起者
			if(page == null || "".equals(page.trim()) || "".equals(page.trim())){
				infoFeedbackList = infoFeedbackMng.findInfoFeedBackByCondition(user.getId(),feedbackdepartment, pinming, startDate, endDate, 0, Constants.pagesize);
			}else{
				infoFeedbackList = infoFeedbackMng.findInfoFeedBackByCondition(user.getId(),feedbackdepartment, pinming, startDate, endDate, (Integer.parseInt(page)-1)*Constants.pagesize, Constants.pagesize);
			}
			
			int resultSize = infoFeedbackMng.countInfoFeedBackByCondition(user.getId(),feedbackdepartment, pinming, startDate, endDate);
			double size = resultSize;
			//页数
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			model.addAttribute("pageSize", Constants.pagesize);
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("reslist", infoFeedbackList);
			return new ModelAndView("qualityRecords/infoFeedback/list");
		}
		@RequestMapping("/qualityRecords/infoFeedback/add.html")
		public String addInfoFeedBack(Model model, HttpServletRequest request, HttpServletResponse response){
			
			return "qualityRecords/infoFeedback/add";
		}
		@RequestMapping("/qualityRecords/infoFeedback/editAssign.html")
		public String editInfoFeedBack(Model model, HttpServletRequest request, HttpServletResponse response){
			String id = request.getParameter("id");
			Long infoId = null;
			if(id != null && !"".equals(id.trim())){
				infoId = Long.parseLong(id);
			}else{
				infoId = Long.valueOf(0);
			}
			InfoFeedback infoFeedbackVO = infoFeedbackMng.getInfoFeedback(infoId);
			List<String> alreadyAssignList = infoFeedbackMng.findAlreadyAssignWork(infoId);
			model.addAttribute("infoFeddBack", infoFeedbackVO);
			model.addAttribute("alreadyAssignList",alreadyAssignList);
			return "qualityRecords/infoFeedback/add";
		}
		@RequestMapping("/qualityRecords/infoFeedback/editWaitDo.html")
		public String editInfoFeedBackWaitDo(Model model, HttpServletRequest request, HttpServletResponse response){
			String id = request.getParameter("id");
			Long infoId = null;
			if(id != null && !"".equals(id.trim())){
				infoId = Long.parseLong(id);
			}else{
				infoId = Long.valueOf(0);
			}
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			InfoFeedback infoFeedbackVO = infoFeedbackMng.getInfoFeedback(infoId);
			List<InfoFeedbackItem> waitDoList = infoFeedbackMng.findInfoFeedbackItemsByCondiction(infoId, String.valueOf(user.getId()));
			//List<String> waitDoList = infoFeedbackMng.findWaitToDoWort(infoId, String.valueOf(user.getId()));
			model.addAttribute("infoFeddBack", infoFeedbackVO);
			model.addAttribute("waitDoList",waitDoList);
			return "qualityRecords/infoFeedback/viewWaitDo";
		}
		@RequestMapping("/qualityRecords/infoFeedback/saveInfoFeedBack.html")
		public String saveInfoFeedBack(InfoFeedback infoFeedback, Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			infoFeedback.setCreatePersonId(user.getId());//创建人
			infoFeedback.setCreateDate(new Date());
			InfoFeedback info = infoFeedbackMng.saveOrUpdateInfoFeedback(infoFeedback);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			if(info != null ){
				resultMap.put("success", URLEncoder.encode("保存数据成功！", "utf-8"));
				logService.addLog("录入信息反馈", user.getRealname(), "新增", "质量管理记录  > 信息反馈", StringUtil.getIpAddr(request));

			}else{
				resultMap.put("success",URLEncoder.encode("保存数据失败！", "utf-8"));
			}
			UtilJson.printMapJson(response, resultMap);
			return null;
		}
		@RequestMapping("/qualityRecords/infoFeedback/ajaxAssginInfoFeedBack.html")
		public String ajaxAssginInfoFeedBack( Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		
			String assginUserIds = request.getParameter("assginUserIds");//指派人
			String type= request.getParameter("type");
			 String id = request.getParameter("id");//信息反馈ID
			 String  commonName = request.getParameter("commonName") ;//通用名称
			 String  specification = request.getParameter("specification") ;//规格
			 String  drugForm = request.getParameter("drugForm") ;//剂型
			 String  approvalNumber = request.getParameter("approvalNumber") ;//批准文号
			 String  manufacturer = request.getParameter("manufacturer") ;//生产厂家
			 String  unit = request.getParameter("unit") ;//单位
			 String batchproduction = request.getParameter("batchproduction") ;//批号
			 String quantity  = request.getParameter("quantity") ;;  // -- 数量 
			 String feedbackdepartment = request.getParameter("feedbackdepartment") ;//    -- 反馈部门 
			 String feedbacksuggestion  = request.getParameter("feedbacksuggestion") ; //   -- 质量情况反映
			 String returnUnit = request.getParameter("returnUnit");// 供货单位
			User user =  (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			InfoFeedback infoFeedbackVO = null;
			if(id == null ||  "".equals(id.trim())){//判断是否保存主表反馈信息 若ID不存在保存主表反馈信息
				InfoFeedback feedback = new InfoFeedback();
				feedback.setCommonName(commonName);
				feedback.setSpecification(specification);
				feedback.setDrugForm(drugForm);
				feedback.setApprovalNumber(approvalNumber);
				feedback.setManufacturer(manufacturer);
				feedback.setUnit(unit);
				feedback.setBatchproduction(batchproduction);
				feedback.setQuantity(quantity);
				feedback.setFeedbackdepartment(feedbackdepartment);
				feedback.setFeedbacksuggestion(feedbacksuggestion);
				feedback.setReturnUnit(returnUnit);
				feedback.setCreateDate(new Date());
				feedback.setCreatePersonId(user.getId());
				feedback = infoFeedbackMng.saveOrUpdateInfoFeedback(feedback);
				logService.addLog("录入信息反馈", user.getRealname(), "新增", "质量管理记录  > 信息反馈", StringUtil.getIpAddr(request));
				infoFeedbackVO = infoFeedbackMng.getInfoFeedback(feedback.getId());
				if(assginUserIds!= null && !"".equals(assginUserIds)){//保存指派信息明细
					String[] userIds = assginUserIds.split(",");
					for(String userId : userIds){
						if(!StringUtil.validateInteger(userId))
							continue;
						InfoFeedbackItem item = new InfoFeedbackItem();
						item.setInfoFeedbackId(feedback.getId());
						item.setType(type);
						item.setZhipaiId(userId);
						infoFeedbackMng.saveOrUpdateInfoFeedbackItem(item);
					}
				}
				
			}else{
				InfoFeedback feedback = infoFeedbackMng.getInfoFeedback(Long.parseLong(id));
				feedback.setCommonName(commonName);
				feedback.setSpecification(specification);
				feedback.setDrugForm(drugForm);
				feedback.setApprovalNumber(approvalNumber);
				feedback.setManufacturer(manufacturer);
				feedback.setUnit(unit);
				feedback.setBatchproduction(batchproduction);
				feedback.setQuantity(quantity);
				feedback.setFeedbackdepartment(feedbackdepartment);
				feedback.setFeedbacksuggestion(feedbacksuggestion);
				feedback.setReturnUnit(returnUnit);
				feedback = infoFeedbackMng.saveOrUpdateInfoFeedback(feedback);
				logService.addLog("修改信息反馈", user.getRealname(), "修改", "质量管理记录  > 信息反馈", StringUtil.getIpAddr(request));
				infoFeedbackVO = infoFeedbackMng.getInfoFeedback(Long.parseLong(id));
				if(assginUserIds!= null && !"".equals(assginUserIds)){//保存指派信息明细
					String[] userIds = assginUserIds.split(",");
					for(String userId : userIds){
						if(!StringUtil.validateInteger(userId))
							continue;
						InfoFeedbackItem item = new InfoFeedbackItem();
						item.setInfoFeedbackId(Long.valueOf(id));
						item.setType(type);
						item.setZhipaiId(userId);
						infoFeedbackMng.saveOrUpdateInfoFeedbackItem(item);
					}
				}
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", URLEncoder.encode("指派成功！", "utf-8"));
			map.put("infoFeedbackVO", infoFeedbackVO);
			map.put("type", type);
			UtilJson.printMapJson(response, map);
			return null;
		}
		@RequestMapping("/qualityRecords/infoFeedback/saveInfoFeedBacks.html")
		public String saveInfoFeedBackItems(InfoFeedBackItemVO itemVO, Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
			List<InfoFeedbackItem> itemList = itemVO.getList();
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			for(InfoFeedbackItem item : itemList){
				infoFeedbackMng.saveOrUpdateInfoFeedbackItem(item);
			}
			logService.addLog("修改信息反馈", user.getRealname(), "修改", "质量管理记录  > 信息反馈", StringUtil.getIpAddr(request));
			UtilJson.print(response, URLEncoder.encode("保存数据成功！", "utf-8"));
			return null;
		}
		@RequestMapping("/qualityRecords/infoFeedback/ajaxQueryAssginUser.html")
		public void  ajaxQueryAssginUsers(HttpServletRequest request, HttpServletResponse response){
			Map<String, String > map = drugComInfoManger.jsMap();
			String json = "[";
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				String value = map.get(key);
				json+="{";
				json+="\"id\":\""+key+"\",";
				json+="\"text\":\""+value+"\"";
				json+="},";
			}
			json = json.substring(0,json.length()-1);
			json+="]";
			response.setContentType("text/json;charset=UTF-8");
			try {
				response.getWriter().write(json);
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@RequestMapping("/qualityRecords/infoFeedback/del.html")
		public String deleteInfoFeedBack(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
			String id = request.getParameter("ids");
			User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
			if(id == null || "".equals(id.trim())){
				UtilJson.print(response, URLEncoder.encode("您要是删除的信息不存在！", "utf-8"));
			}else{
				infoFeedbackMng.deleteInfoFeedbacks(Long.parseLong(id));
				logService.addLog("删除信息反馈", user.getRealname(), "修改", "质量管理记录  > 信息反馈", StringUtil.getIpAddr(request));
				UtilJson.print(response, URLEncoder.encode("删除成功！", "utf-8"));
			}
			return null;
		}
}
