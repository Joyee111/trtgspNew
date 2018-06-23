package com.sinosoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("getvalidCode.html")
public class GetValidationCodeController {

	/**
	 * 获取当前session中的验证码 通过ajax调用 并验证
	 * @param str
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView aaa(String str,HttpServletRequest request, HttpServletResponse response)throws Exception
    {
		String code = request.getSession().getAttribute("rand").toString().toLowerCase();
		//response.getWriter().write(com.googlecode.jsonplugin.JSONUtil.serialize(code));
		response.getWriter().write(code);
		return null;
    }
}
