package com.sinosoft.qualityRecords.complantManager;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.baseInfo.menuManage.model.MenuConfigModel;

@Controller
public class qualityRecordAct {


	@RequestMapping("/qualityRecords/index.html")
public ModelAndView openFramePage(MenuConfigModel mc, HttpServletRequest request, HttpServletResponse response){

		
		return new ModelAndView("qualityRecords/index");
	}
	
}
