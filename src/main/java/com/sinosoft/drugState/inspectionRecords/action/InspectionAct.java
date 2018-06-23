package com.sinosoft.drugState.inspectionRecords.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.baseInfo.menuManage.model.MenuConfigModel;

@Controller
public class InspectionAct {


	@RequestMapping("/drugState/index.html")
public ModelAndView openFramePage(MenuConfigModel mc, HttpServletRequest request, HttpServletResponse response){
		String a = "";
		
		return new ModelAndView("drugState/index");
	}
	
}
