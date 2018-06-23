package com.sinosoft.comQuery.scrapRecords;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.Constants;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.scrap.model.ScrapAndQualityMedicineVo;
import com.sinosoft.drugState.scrap.model.ScrapMedicine;
import com.sinosoft.drugState.scrap.service.ScrapMng;
import com.sinosoft.drugState.stopcell.model.StopSaleBill;
import com.sinosoft.drugState.stopcell.model.StopSaleBillVO;
import com.sinosoft.drugState.stopcell.service.StopCellMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedSuppliersService;
import com.sinosoft.ireportDTO.StopSellingOrderDto;
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
/**
 * 药品报废申请记录
 * @author whn
 *
 */
@Controller
public class ScrapRecordsAct {
	@Autowired
	private StopCellMng stopCellMng;
	
	@Autowired
	private InspectionMng inspectionMng;
	
	@Autowired
	private QualifiedmedcstoreMng qualifiedmedcstoreMng;
	@Autowired
	private UnqualifiedmedcstoreMng unqualifiedmedcstoreMng;
	
	@Autowired
	private UnqualifiedManagerMng  unqualifiedManagerMng;
	@Autowired
	private SystemLogService logService;
	
	@Autowired
	private ScrapMng scrapMng;
	
	@Autowired
	private QualityMidicineMng qualityMidicineMng;
	@Autowired
	private QualifiedSuppliersService qualifiedSuppliersService;
	@Autowired
	private DrugComInfoManger drugComInfoManger;
	
	
	/**
	 * 报废药品申请列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/comQuery/scrap/list.html")
	public ModelAndView openYshPage(HttpServletRequest request, HttpServletResponse response, Model model){
		String page = DisplayGetPage.getPageParamName("records", request);// 第几页
		StopSaleBill mc = new StopSaleBill();
		String ypname = request.getParameter("ypname");
		model.addAttribute("ypname", ypname);
		if(ypname !=null && !"".equals(ypname)){
			mc.setApplicationTime(ypname);
		}
		//List<StopSaleBill> reslist=new ArrayList<StopSaleBill>();
		//List<ScrapMedicine> reslist = null;
		List<ScrapAndQualityMedicineVo> reslist = null;
		if(page==null){
			//如果page等于空，默认从第一条开始查询
			//reslist= stopCellMng.getPage(mc,0,Constants.pagesize);
			reslist= scrapMng.getPage(ypname,"2",0,Constants.pagesize);
		}
		else{
			//否者翻页查询
			//reslist= stopCellMng.getPage(mc,(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
			reslist= scrapMng.getPage(ypname,"2",(Integer.parseInt(page) - 1) * Constants.pagesize,Constants.pagesize);
		}
//		int resultSize = stopCellMng.getTotalCount(mc);
		int resultSize = scrapMng.countScrapMedicineByStatus(ypname, "2");
		double size = resultSize;
		//页数
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pageSize", Constants.pagesize);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("reslist", reslist);
		return new ModelAndView("comQuery/scrap/list");
	}
	
	
	/**
	 * 查看页面	 
	 * @param um
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/comQuery/scrap/view.html")
	public ModelAndView yshviewPage(String id, HttpServletRequest request, HttpServletResponse response, Model model){
		
		String thispage=request.getParameter("thispage");
		model.addAttribute("thispage", thispage);
		ScrapMedicine scrapMedicine = new ScrapMedicine();
		Long medicinalNo=null;
		String titles="";
		String ids;
		
		titles="查看";
		scrapMedicine = scrapMng.findById(id);
		ids=((Long) scrapMedicine.getQualifiedmedicineid()).toString();

		QualityMidicine  qualityMidicine=drugComInfoManger.findYpById(ids.toString());
		//Qualifiedmedcstore qualifiedmedcstore=new Qualifiedmedcstore();
		//qualifiedmedcstore.setQualityMidicine(qualityMidicine);
		
		//scrapMedicine.setQualifiedmedcstore(qualifiedmedcstore);
		
		
			   
		model.addAttribute("titles", titles);
		model.addAttribute("medicinalNo", medicinalNo);
		model.addAttribute("um",scrapMedicine );
		model.addAttribute("qm",qualityMidicine );


			
			return new ModelAndView("comQuery/scrap/view");
		}


}
