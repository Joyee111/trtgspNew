package com.sinosoft.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.util.SystemConfigUtil;

@Controller
@RequestMapping("/ajax")
public class AjaxController extends BaseFormController {

	@RequestMapping("/getsensors.html")
	public String getSensors(String key,HttpServletRequest request,HttpServletResponse response)
	{
		//为返回页面的JSON对象做准备
		String json =  "{\"name\":\"zywx\"}"; 
	    JSONObject jsonObj = JSONObject.fromObject(json); 
		String[] sensor = SystemConfigUtil.getSystemValue(key, this.getServletContext());
		jsonObj.put("ingredients",sensor); 
	    try { 
	        response.getWriter().write(jsonObj.toString()); 
	    } catch (IOException e) { 
	        e.printStackTrace(); 
	    } 
		return null;
	}
}
