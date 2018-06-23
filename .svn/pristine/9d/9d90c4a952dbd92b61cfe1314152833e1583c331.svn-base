package com.sinosoft.qualityRecords.unqualifiedManger.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedSuppliersService;
import com.sinosoft.qualityRecords.complantManager.service.DrugComInfoManger;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;
import com.sinosoft.qualityRecords.unqualifiedManger.service.UnqualifiedManagerMng;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualifiedmedcstoreMng;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.UnqualifiedmedcstoreMng;
/*
 * 不合格药品
 */
@Controller
public class UnqualifiedManagerAct {
	private UnqualifiedManagerMng unqualifiedManagerMng;
	@Autowired
	public void setUnqualifiedManagerMng(UnqualifiedManagerMng unqualifiedManagerMng) {
		this.unqualifiedManagerMng = unqualifiedManagerMng;
	}
	//不合格药品存储库
	@Autowired
	private UnqualifiedmedcstoreMng unqualifiedmedcstoreMng;
	public void setUnqualifiedmedcstoreMng(UnqualifiedmedcstoreMng unqualifiedmedcstoreMng) {
		this.unqualifiedmedcstoreMng = unqualifiedmedcstoreMng;
	}
	/*
	 * 合格药品库
	 */
	private  QualifiedmedcstoreMng qualifiedmedcstoreMng;
	@Autowired
	public void setQualifiedmedcstoreMng(QualifiedmedcstoreMng qualifiedmedcstoreMng) {
		this.qualifiedmedcstoreMng = qualifiedmedcstoreMng;
	}
	private DrugComInfoManger drugComInfoManger;
	@Autowired
	public void setDrugComInfoManger(DrugComInfoManger drugComInfoManger) {
		this.drugComInfoManger = drugComInfoManger;
	}
	private QualityMidicineMng qualityMidicineMng;
	@Autowired
	public void setQualityMidicineMng(QualityMidicineMng qualityMidicineMng) {
		this.qualityMidicineMng = qualityMidicineMng;
	}
	private QualifiedSuppliersService qualifiedSuppliersService;
	@Autowired
	public void setQualifiedSuppliersService(
			QualifiedSuppliersService qualifiedSuppliersService) {
		this.qualifiedSuppliersService = qualifiedSuppliersService;
	}
	@Autowired
	private SystemLogService logService;
	@RequestMapping("/qualityRecords/unqualifiedManger/list.html")
	public ModelAndView openFramePage(UnqualifiedManager um, HttpServletRequest request, HttpServletResponse response, Model model){
			String page = DisplayGetPage.getPageParamName("records", request);// 第几页
			List<UnqualifiedManager> reslist=new ArrayList<UnqualifiedManager>();
			if(page==null){
				//如果page等于空，默认从第一条开始查询
				
				reslist= unqualifiedManagerMng.getPage(um,0,Constants.pagesize);
				
			}
			else{
				//否者翻页查询
				reslist= unqualifiedManagerMng.getPage(um,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			}
			int resultSize = unqualifiedManagerMng.getTotalCount();
			double size = resultSize;
			//页数
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			model.addAttribute("pageSize", Constants.pagesize);
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("um", um);
			model.addAttribute("reslist", reslist);
			return new ModelAndView("qualityRecords/unqualifiedManger/list");
		}
	@RequestMapping("/qualityRecords/unqualifiedManger/query.html")
	public ModelAndView queryEnterpristInfoList( UnqualifiedManager um,Model model,HttpServletRequest request,HttpServletResponse response){
		List<UnqualifiedManager> reslist=new ArrayList<UnqualifiedManager>();
		String pinming= request.getParameter("pinming");
		String page = DisplayGetPage.getPageParamName("records", request);
		model.addAttribute("pinming", pinming);
		
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			
			reslist= unqualifiedManagerMng.getPage(um,0,Constants.pagesize);
			
		}else{
			if(pinming.equals("")){
				//否者翻页查询
				reslist= unqualifiedManagerMng.getPage(um,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
				int resultSize = unqualifiedManagerMng.getTotalCount();
				 double size = resultSize;
					model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
					model.addAttribute("resultSize", resultSize);
				
			}else{
				//StringBuffer sqlBuffer = new StringBuffer	("select  d  from UnqualifiedManager  d ,Qualifiedmedcstore m, QualityMidicine q  " +
				//" where  d.qualifiedmedicineid = m.qualifiedmedicineid  and m.qualifiedmedicineid= q.id  and d.batchno = m.batchproduction");
				StringBuffer sqlBuffer = new StringBuffer	("select  d  from UnqualifiedManager  d ,QualityMidicine q  " +
				" where d.qualifiedmedicineid = q.id");
			
				if(pinming!=null && !pinming.equals("")){
					sqlBuffer.append(" and q.commonname like '%");
					sqlBuffer.append(pinming.trim()+"%'  ");
				}
				sqlBuffer.append(" order by d.processingDate desc ");
				if(page==null){
					reslist= unqualifiedManagerMng.getPage(um,0,Constants.pagesize);
				}else{
					reslist = unqualifiedManagerMng.getUnqualifiedManagerByPage(sqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
				}
				//StringBuffer buffer=new StringBuffer(" SELECT  count(*) FROM t_substandard_record d ,  t_qualified_medicine q ,t_qualified_medc_store m" +
				//"  where  d.qualified_medicine_id =m.qualified_medicine_id and m.qualified_medicine_id=q.id and d.batch_no = m.batch_production");
				StringBuffer buffer = new StringBuffer	("select  count(*)  from UnqualifiedManager  d , QualityMidicine q " +
				" where  d.qualifiedmedicineid = q.id");
				if(pinming!=null && !pinming.equals("")){
					buffer.append(" and q.commonname like '%");
					buffer.append(pinming.trim()+"%'  ");
				}
				int resultSize = unqualifiedManagerMng.getQueryCount(buffer.toString());
				double size = resultSize;
				model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
				model.addAttribute("resultSize", resultSize);
			}
		}
		
		//页数

		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);

		model.addAttribute("um", um);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("qualityRecords/unqualifiedManger/list");
	}
	/*
	 * 添加
	 */
	@RequestMapping("/qualityRecords/unqualifiedManger/add.html")
	public ModelAndView add(UnqualifiedManager um,String id, HttpServletRequest request, HttpServletResponse response, Model model){
		String method = request.getParameter("method");
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		UnqualifiedManager unqualifiedManager=new UnqualifiedManager();
		Long medicinalNo=null;
		 String titles="不合格药品新增";
			String ids;

		model.addAttribute("titles", titles);
		model.addAttribute("medicinalNo", medicinalNo);
		Map<String, String> quamap= drugComInfoManger.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> qsmap=unqualifiedManagerMng.qsMap();
		model.addAttribute("qsmap", qsmap);
		model.addAttribute("um",unqualifiedManager );
		model.addAttribute("method", method);		
			return new ModelAndView("qualityRecords/unqualifiedManger/add");
		}
	/*
	 * 修改
	 */
	@RequestMapping("/qualityRecords/unqualifiedManger/edit.html")
	public ModelAndView edit(UnqualifiedManager um,String id, HttpServletRequest request, HttpServletResponse response, Model model){
		
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		UnqualifiedManager unqualifiedManager=new UnqualifiedManager();
		Long medicinalNo=null;
		 String titles="";
			String ids;
		
			 titles="不合格药品修改";
			unqualifiedManager=unqualifiedManagerMng.findById(id);
			QualifiedSuppliers qualifiedSuppliers=new QualifiedSuppliers();
			if(unqualifiedManager.getQualifiedmedcstore()!=null){
				if(unqualifiedManager.getQualifiedmedcstore().getQualityMidicine()!=null){
					medicinalNo=unqualifiedManager.getQualifiedmedcstore().getQualityMidicine().getId();
				}
				if(unqualifiedManager.getQualifiedpurchaseunitsid()!=null){
					qualifiedSuppliers = qualifiedSuppliersService.findById(unqualifiedManager.getQualifiedpurchaseunitsid().toString());
					if(qualifiedSuppliers!=null){	
						model.addAttribute("gongyingshang", qualifiedSuppliers.getPinyinCode()+"_"+qualifiedSuppliers.getId());	
					}else{
						model.addAttribute("gongyingshang", "");	
					}
					
				}
			}  
			
			ids=((Long) unqualifiedManager.getQualifiedmedicineid()).toString();
	
			QualityMidicine  qualityMidicine=drugComInfoManger.findYpById(ids.toString());
			Qualifiedmedcstore qualifiedmedcstore=new Qualifiedmedcstore();
			qualifiedmedcstore.setQualityMidicine(qualityMidicine);
			unqualifiedManager.setQualifiedmedcstore(qualifiedmedcstore);
			
			   String batchno2=unqualifiedManager.getBatchno();//生产批号
			   //根据批号查询得到合格 药品库

			   qualifiedmedcstore=qualifiedmedcstoreMng.findByBaNo(batchno2);
			   Long  qhgQuantity = null;
			   Long qbhgQuantity = null;
			  /* if(qualifiedmedcstore !=null){
				   qhgQuantity = qualifiedmedcstore.getQuantity();//修改之前合格药品库的该批号药品的数量
				   Unqualifiedmedcstore unqualifiedmedcstore=new Unqualifiedmedcstore();
				   //根据批号查询不合格药品库
			        unqualifiedmedcstore=unqualifiedmedcstoreMng.findById(batchno2);  
		            qbhgQuantity = unqualifiedmedcstore.getQuantity();//修改之前不合格药品库的该批号药品的数量
			   }*/
			   
		model.addAttribute("titles", titles);
		model.addAttribute("medicinalNo", medicinalNo);
		Map<String, String> quamap= drugComInfoManger.qmMap();
		model.addAttribute("quamap", quamap);
		Map<String, String> qsmap=unqualifiedManagerMng.qsMap();
		model.addAttribute("qsmap", qsmap);
		model.addAttribute("um",unqualifiedManager );
		model.addAttribute("qhgQuantity", qhgQuantity);
		model.addAttribute("qbhgQuantity", qbhgQuantity);

			
			return new ModelAndView("qualityRecords/unqualifiedManger/edit");
		}
	/*
	 * 添加保存
	 */
	@RequestMapping("/qualityRecords/unqualifiedManger/save.html")
	public ModelAndView save(UnqualifiedManager um, HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException{
		String op = request.getParameter("method");
		String qualifiedmedicineid = request.getParameter("qualifiedMedicineId");

		String qualifiedpurchaseunitsid = request.getParameter("qualifiedpurchaseunitsid");
		QualifiedSuppliers qualifiedSuppliers=new QualifiedSuppliers();
		if(qualifiedpurchaseunitsid!=null && !"".equals(qualifiedpurchaseunitsid)){
			qualifiedSuppliers = qualifiedSuppliersService.findById(qualifiedpurchaseunitsid);
			um.setQualifiedSuppliers(qualifiedSuppliers);	
		}
			Date  d=new Date();
			um.setModifiedtime(d);
			User localuser = (User) request.getSession().getAttribute(
					Constants.LOCAL_USER);
			long a=localuser.getId();
			
			um.setModifierid(a);
			um.setQualifiedmedicineid(Long.parseLong(qualifiedmedicineid));
			unqualifiedManagerMng.saveUnqualifiedManager(um);
	/*		  Long qualifiedmedicineid2 =um.getQualifiedmedicineid();// int,    -- 合格药品id 
			   Long  quantity2=um.getQuantity();
			   String batchno2=um.getBatchno();//生产批号
			   String validdate2=um.getQualifiedmedcstore().getValiddate();
			   //根据批号查询得到不合格药品（如果不合格药品库没有该批号的药品就new ）
			   Unqualifiedmedcstore unqualifiedmedcstore=new Unqualifiedmedcstore();
	             unqualifiedmedcstore=unqualifiedmedcstoreMng.findById(batchno2);  
	            Long qbhgQuantity= unqualifiedmedcstore.getQuantity();//添加之前不合格药品库的该批号药品的数量
	            //添加之后合格药品库该批号药品的数量
				   Long hbhgQuantity=0L;
				   if(qbhgQuantity!=null &&quantity2!=null){
					   hbhgQuantity=qbhgQuantity+quantity2;//等于添加之前的数量减去要添加的数来那个  
				   }
//			   unqualifiedmedcstore.setBatchproduction(batchno2);
//			   unqualifiedmedcstore.setQualifiedmedicineid(qualifiedmedicineid2);
			   unqualifiedmedcstore.setQuantity(hbhgQuantity);
			   //unqualifiedmedcstore.setValiddate(validdate2);
			   unqualifiedmedcstoreMng.saveOrUpdataHg(unqualifiedmedcstore);
			   //根据批号查询得到合格 药品库
			   Qualifiedmedcstore qualifiedmedcstore=new Qualifiedmedcstore();
			   qualifiedmedcstore=qualifiedmedcstoreMng.findByBaNo(batchno2);
			   Long  qhgQuantity=qualifiedmedcstore.getQuantity();//添加之前合格药品库的该批号药品的数量
			   //添加之后合格药品库该批号药品的数量
			   Long hhgQuantity=0L;
			   if(qhgQuantity!=null &&quantity2!=null){
				   hhgQuantity=qhgQuantity-quantity2;//等于添加之前的数量减去要添加的数来那个  
			   }
			   qualifiedmedcstore.setQuantity(hhgQuantity);
				qualifiedmedcstoreMng.updatequ(qualifiedmedcstore);*/
				User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
				logService.addLog("新增不合格药品", user.getRealname(), "新增", "质量记录管理  >不合格药品", StringUtil.getIpAddr(request));
			//	model.addAttribute("qhgQuantity", qhgQuantity);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	/*
	 * 修改保存
	 */
	@RequestMapping("/qualityRecords/unqualifiedManger/updata.html")
	public ModelAndView update(UnqualifiedManager um,HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException{
		String op = request.getParameter("method");
		String qualifiedmedicineid = request.getParameter("qualifiedMedicineId");
		String shuliang=request.getParameter("shuliang");//修改之前不合格药品的数量
		String qpihao=request.getParameter("qpihao");//修改之前不合格药品的批号
		Long xgqsl=0L;
		xgqsl=Long.valueOf(shuliang);

		String qualifiedpurchaseunitsid = request.getParameter("qualifiedpurchaseunitsid");
		QualifiedSuppliers qualifiedSuppliers=new QualifiedSuppliers();
		if(qualifiedpurchaseunitsid!=null && !"".equals(qualifiedpurchaseunitsid)){
			qualifiedSuppliers = qualifiedSuppliersService.findById(qualifiedpurchaseunitsid);
			um.setQualifiedSuppliers(qualifiedSuppliers);	
		}
	             um.setQualifiedmedicineid(Long.parseLong(qualifiedmedicineid));
			unqualifiedManagerMng.saveOrUpdata(um);
			//Map<String, Object> map = new HashMap<String, Object>();
			/* Long qualifiedmedicineid2 =um.getQualifiedmedicineid();// int,    -- 合格药品id 
			   Long  quantity2=um.getQuantity();
			   String batchno2=um.getBatchno();//生产批号
			   String validdate2=um.getQualifiedmedcstore().getValiddate();
			   if(batchno2.equals(qpihao)){
				   Unqualifiedmedcstore unqualifiedmedcstore=new Unqualifiedmedcstore();
				   unqualifiedmedcstore= unqualifiedmedcstoreMng.findById(batchno2);
				   
				   Long  qbhgQuantity=unqualifiedmedcstore.getQuantity();//修改之前不合格药品库的该批号药品的数量
				   //添加之后不合格药品库该批号药品的数量
				   Long hbhgQuantity=0L;
				   //如果 不合格数量由小变大（比如由10改为12）那么 不合格药品库的数量就是加去2个
				   //即合格药品库的数量=合格药品库的数量-（不合格药品修改数-修改之前的数）
				   if(qbhgQuantity!=null &&quantity2!=null && quantity2 > xgqsl){
					   hbhgQuantity=qbhgQuantity+(quantity2-xgqsl);//等于添加之前的数量减去要添加的数
					   //如果不合格数量由大变小（12变为10）那么不合格药品库的数量就是减去2个
					   //即合格药品库的数量=之前合格药品库的数量+（修改之前的数量-修不合格药品的修改数）
				   }else if(hbhgQuantity!=null &&quantity2!=null && quantity2 < xgqsl){
					   hbhgQuantity=qbhgQuantity-(xgqsl-quantity2);//等于添加之前的数量减去要添加的数    
				   }else {
					   hbhgQuantity=hbhgQuantity;
				   }
				   unqualifiedmedcstore.setQuantity(hbhgQuantity);
				   

				   unqualifiedmedcstoreMng.saveOrUpdataHg(unqualifiedmedcstore);
				   //根据批号查询得到合格 药品库
				   Qualifiedmedcstore qualifiedmedcstore=new Qualifiedmedcstore();
				   qualifiedmedcstore=qualifiedmedcstoreMng.findByBaNo(batchno2);
				   Long  qhgQuantity=qualifiedmedcstore.getQuantity();//修改之前合格药品库的该批号药品的数量
				   //添加之后合格药品库该批号药品的数量
				   Long hhgQuantity=0L;
				   //如果 不合格数量由小变大（比如由10改为12）那么 合格药品库的数量就是减去2个
				   //即合格药品库的数量=合格药品库的数量-（不合格药品修改数-修改之前的数）
				   if(qhgQuantity!=null &&quantity2!=null && quantity2 > xgqsl){
					   hhgQuantity=qhgQuantity-(quantity2-xgqsl);//等于添加之前的数量减去要添加的数
					   //如果不合格数量由大变小（12变为10）那么合格药品库的数量就是加上2个
					   //即合格药品库的数量=之前合格药品库的数量+（修改之前的数量-修不合格药品的修改数）
				   }else if(qhgQuantity!=null &&quantity2!=null && quantity2 < xgqsl){
					   hhgQuantity=qhgQuantity+(xgqsl-quantity2);//等于添加之前的数量减去要添加的数    
				   }else {
					   hhgQuantity=qhgQuantity;
				   }
				   qualifiedmedcstore.setQuantity(hhgQuantity);
					qualifiedmedcstoreMng.updatequ(qualifiedmedcstore); 
			   }else{
				   //01批号改为02批号 
				   //01批号不合格库数量的变化
				   Unqualifiedmedcstore qunqualifiedmedcstore=new Unqualifiedmedcstore();
				   qunqualifiedmedcstore= unqualifiedmedcstoreMng.findById(qpihao);
				   
				   Long  qbhgs=qunqualifiedmedcstore.getQuantity();//修改之前不合格药品库的该批号药品的数量
				   //添加之后不合格药品库该批号药品的数量
				   Long qbhgQuantity=0L;
				   //如果 不合格数量由小变大（比如由10改为12）那么 不合格药品库的数量就是加去2个
				   //即合格药品库的数量=合格药品库的数量-（不合格药品修改数-修改之前的数）
				   if(qbhgs!=null &&quantity2!=null && quantity2 > xgqsl){
					   qbhgQuantity=qbhgs-(quantity2-xgqsl);//等于添加之前的数量减去要添加的数
					   //如果不合格数量由大变小（12变为10）那么不合格药品库的数量就是减去2个
					   //即合格药品库的数量=之前合格药品库的数量+（修改之前的数量-修不合格药品的修改数）
				   }else if(qbhgs!=null &&quantity2!=null && quantity2 < xgqsl){
					   qbhgQuantity=qbhgs-(xgqsl-quantity2);//等于添加之前的数量减去要添加的数    
				   }else {
					   qbhgQuantity=qbhgs -quantity2;
				   }
				   qunqualifiedmedcstore.setQuantity(qbhgQuantity);
				   

				   unqualifiedmedcstoreMng.saveOrUpdataHg(qunqualifiedmedcstore);
				   
				   //01批号合格库数量的变化
				   Qualifiedmedcstore qqualifiedmedcstore=new Qualifiedmedcstore();
				   qqualifiedmedcstore=qualifiedmedcstoreMng.findByBaNo(qpihao);
				   Long  qhgs=qqualifiedmedcstore.getQuantity();//修改之前合格药品库的该批号药品的数量
				   //添加之后合格药品库该批号药品的数量
				   Long qhgQuantity=0L;
				   //如果 不合格数量由小变大（比如由10改为12）那么 合格药品库的数量就是减去2个
				   //即合格药品库的数量=合格药品库的数量-（不合格药品修改数-修改之前的数）
				   if(qhgs!=null &&quantity2!=null && quantity2 > xgqsl){
					   qhgQuantity=qhgs+(quantity2-xgqsl);//等于添加之前的数量减去要添加的数
					   //如果不合格数量由大变小（12变为10）那么合格药品库的数量就是加上2个
					   //即合格药品库的数量=之前合格药品库的数量+（修改之前的数量-修不合格药品的修改数）
				   }else if(qhgs!=null &&quantity2!=null && quantity2 < xgqsl){
					   qhgQuantity=qhgs+(xgqsl-quantity2);//等于添加之前的数量减去要添加的数    
				   }else {
					   qhgQuantity=qhgs+quantity2;
				   }
				   qqualifiedmedcstore.setQuantity(qhgQuantity);
					qualifiedmedcstoreMng.updatequ(qqualifiedmedcstore); 
				   
				   
				   
				   
				   //02批号不合格库合格库数量的bianhau
				   Unqualifiedmedcstore unqualifiedmedcstore=new Unqualifiedmedcstore();
				   unqualifiedmedcstore= unqualifiedmedcstoreMng.findById(batchno2);
				   
				   Long  hbhgs=unqualifiedmedcstore.getQuantity();//修改之前不合格药品库的该批号药品的数量
				   //添加之后不合格药品库该批号药品的数量
				   Long hbhgQuantity=0L;
				   //如果 不合格数量由小变大（比如由10改为12）那么 不合格药品库的数量就是加去2个
				   //即合格药品库的数量=合格药品库的数量-（不合格药品修改数-修改之前的数）
				   if(hbhgs!=null &&quantity2!=null && quantity2 > xgqsl){
					   hbhgQuantity=hbhgs+(quantity2-xgqsl);//等于添加之前的数量减去要添加的数
					   //如果不合格数量由大变小（12变为10）那么不合格药品库的数量就是减去2个
					   //即合格药品库的数量=之前合格药品库的数量+（修改之前的数量-修不合格药品的修改数）
				   }else if(hbhgQuantity!=null &&quantity2!=null && quantity2 < xgqsl){
					   hbhgQuantity=hbhgs+(xgqsl-quantity2);//等于添加之前的数量减去要添加的数    
				   }else {
					   hbhgQuantity=hbhgs+quantity2;
				   }
				   unqualifiedmedcstore.setQuantity(hbhgQuantity);
				   

				   unqualifiedmedcstoreMng.saveOrUpdataHg(unqualifiedmedcstore);
				   
				   
				 //02批号合格库合格库数量的
				   Qualifiedmedcstore hqualifiedmedcstore=new Qualifiedmedcstore();
				   hqualifiedmedcstore=qualifiedmedcstoreMng.findByBaNo(batchno2);
				   Long  hhgs=hqualifiedmedcstore.getQuantity();//修改之前合格药品库的该批号药品的数量
				   //添加之后合格药品库该批号药品的数量
				   Long hhgQuantity=0L;
				   //如果 不合格数量由小变大（比如由10改为12）那么 合格药品库的数量就是减去2个
				   //即合格药品库的数量=合格药品库的数量-（不合格药品修改数-修改之前的数）
				   if(qhgs!=null &&quantity2!=null && quantity2 > xgqsl){
					   hhgQuantity=hhgs-(quantity2-xgqsl);//等于添加之前的数量减去要添加的数
					   //如果不合格数量由大变小（12变为10）那么合格药品库的数量就是加上2个
					   //即合格药品库的数量=之前合格药品库的数量+（修改之前的数量-修不合格药品的修改数）
				   }else if(qhgs!=null &&quantity2!=null && quantity2 < xgqsl){
					   hhgQuantity=hhgs-(xgqsl-quantity2);//等于添加之前的数量减去要添加的数    
				   }else {
					   hhgQuantity=hhgs-quantity2;
				   }
				   hqualifiedmedcstore.setQuantity(hhgQuantity);
					qualifiedmedcstoreMng.updatequ(hqualifiedmedcstore);*/
					User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
					logService.addLog("修改不合格药品", user.getRealname(), "修改", "质量记录管理  >不合格药品", StringUtil.getIpAddr(request));
			 //  }
			   
	   
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/qualityRecords/unqualifiedManger/del.html")
	public ModelAndView del(String ids[], HttpServletRequest request, HttpServletResponse response, Model model){
		if(ids!=null && ids.length>0){
			unqualifiedManagerMng.del(ids);
			User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
			logService.addLog("删除不合格药品", user.getRealname(), "删除", "质量记录管理  >不合格药品", StringUtil.getIpAddr(request));
		}
	
		
		
	
		
		return openFramePage(null, request, response, model);
	}
	@RequestMapping("/qualityRecords/unqualifiedManger/quamap.html")
	public void findMq(String quamap, HttpServletRequest request, HttpServletResponse response, Model model){
		QualityMidicine qm= drugComInfoManger.findYpById(quamap);
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		JSONArray json = new JSONArray();
		json.put(qm.getCommonname());//通用名称
		json.put(qm.getDosageforms().getFormName());//剂型
		json.put(qm.getSpecifications());//规格
		json.put(qm.getLicensenumber());//批号
		json.put(qm.getProduceno().getCustomerName());//生产厂商
		json.put(qm.getMedicinalNo());//药品
		json.put(qm.getUnit());//单位
		if(qm.getSupplyUnit()!=null){
			json.put(qm.getSupplyUnit().getCustomerName());//来货单位
		}
		

		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json.toString());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	@RequestMapping("/qualityRecords/unqualifiedManger/findypboxqy.html")
	public void findypbox(HttpServletRequest request, HttpServletResponse response, Model model){
		List<Qualifiedmedcstore> listpu= new ArrayList<Qualifiedmedcstore>();
		//封装采购单json
		listpu=unqualifiedManagerMng.findypJsonqy();
		String json = "[";
		if(listpu!=null){
			String id="";
			for(int i =0;i<listpu.size();i++){
				if(listpu.get(i).getQualifiedmedicineid()!=null && !"".equals(listpu.get(i).getQualifiedmedicineid())){
					id=listpu.get(i).getQualifiedmedicineid().toString();
					QualityMidicine qualityMidicine=new QualityMidicine();
			        qualityMidicine = qualityMidicineMng.findById(id);
			        json+="{";
			        json+="\"id\":"+listpu.get(i).getId()+",";
			        json+="\"text\":\""+"("+qualityMidicine.getMedicinalNo()+")"+qualityMidicine.getCommonname()+"\"";
			        if(i==listpu.size()-1){
						json+="}";
					}else{
						json+="},";
					}
				}
				
			}
		}
		json+="]";
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 根据批号得到合格药品库该批号药品的数量（来验证添加时添加的数不能大于合格药品库的数量）
	 */
	@RequestMapping("/qualityRecords/unqualifiedManger/hgmap.html")
	public void findMp(String hgmap, HttpServletRequest request, HttpServletResponse response, Model model){
		//根据批号找合格药品库该批号药品
		Qualifiedmedcstore qualifiedmedcstore=qualifiedmedcstoreMng.findByBaNo(hgmap);
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		JSONArray json = new JSONArray();
		json.put(qualifiedmedcstore.getQuantity());//根据批号找合格药品库该批号药品的数量
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json.toString());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	@RequestMapping("/qualityRecords/unqualifiedManger/queryUnQualifiedMedc.html")
	public void findUnQualifiedMedc(HttpServletRequest request, HttpServletResponse response){
		List<QualityMidicine> list= null;
		//封装采购单json
		list= unqualifiedmedcstoreMng.findUnqualifiedMedcStore();
		String json = "[";
		if(list!=null){
			for(int i =0;i<list.size();i++){
				if(list.get(i).getCommonname()!=null && !"".equals(list.get(i).getCommonname())){
					json+="{";
					json+="\"id\":"+list.get(i).getId()+",";
					json+="\"text\":\""+"("+list.get(i).getMedicinalNo()+")"+list.get(i).getCommonname()+"\"";
					if(i==list.size()-1){
						json+="}";
					}else{
						json+="},";
					}
				}
			}
		}
		json+="]";
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//取所有药品
	@RequestMapping("/qualityRecords/unqualifiedManger/queryQualifiedMedc.html")
	public void findQualifiedMedc(HttpServletRequest request, HttpServletResponse response){
		List<QualityMidicine> list= null;
		
		list= unqualifiedmedcstoreMng.findQualifiedMedcStore();
		String json = "[";
		if(list!=null){
			for(int i =0;i<list.size();i++){
				if(list.get(i).getCommonname()!=null && !"".equals(list.get(i).getCommonname())){
					json+="{";
					json+="\"id\":"+list.get(i).getId()+",";
					json+="\"text\":\""+"("+list.get(i).getMedicinalNo()+")"+list.get(i).getCommonname()+"\"";
					if(i==list.size()-1){
						json+="}";
					}else{
						json+="},";
					}
				}
			}
		}
		json+="]";
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/qualityRecords/unqualifiedManger/queryUnQualifiedMedcBatchNum.html")
	public void findUnqualifiedMedcBatchNumber(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("medcId");
		if(id != null && !"".equals(id.trim())){
			List<Unqualifiedmedcstore> listpu= null;
			//封装采购单json
			listpu=unqualifiedmedcstoreMng.findUnqualifiedMedcStoreByMedcId(Long.valueOf(id));
			String json = "[";
			if(listpu!=null){
				for(int i =0;i<listpu.size();i++){
					if(listpu.get(i).getBatchproduction()!=null && !"".equals(listpu.get(i).getBatchproduction())){
						//Qualifiedmedcstore unqu = qualifiedmedcstoreMng.findByBaNo(listpu.get(i).getBatchproduction());
						
							json+="{";
							json+="\"id\":\""+listpu.get(i).getBatchproduction()+"_"+listpu.get(i).getQuantity()+"_"+listpu.get(i).getValiddate()+"\",";
							json+="\"text\":\""+listpu.get(i).getBatchproduction()+"\"";
							if(i==listpu.size()-1){
								json+="}";
							}else{
								json+="},";
							}
						}
					}
				}
			json+="]";
			response.setContentType("text/json;charset=UTF-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
		
}
