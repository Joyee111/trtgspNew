package com.sinosoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinosoft.base.BaseFormController;

@Controller
@RequestMapping("/empty.html")
public class EmptyController extends BaseFormController {
	
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public String onSubmit(HttpServletRequest request, HttpServletResponse response)throws Exception
    {
		String page = request.getParameter("frompage");
		return page;
    }
}
