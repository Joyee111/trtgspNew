package com.sinosoft.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.user.User;
import com.sinosoft.util.SystemLogUtil;

@Controller
public class SystemUserListController extends BaseFormController {

	@RequestMapping("/getuserlist.html")
	public ModelAndView userlist() {
		// return "systemUserList/userList";

		return new ModelAndView("systemUserList/userList", "userlist",
				getlistUser());

	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/ajaxuser.html")
	public String ajax(ModelMap map, HttpServletResponse response,
			HttpServletRequest request) {
		JSONObject jsonObj = new JSONObject();

		List<User> userlist = new ArrayList<User>();
		userlist = getlistUser();
		for (int i = 0; i < userlist.size(); i++) {
			User user = userlist.get(i);
			Map<String, String> ingredients = new HashMap<String, String>();
			ingredients.put("realname", user.getRealname());
			ingredients.put("username", user.getUsername());
			ingredients.put("company", user.getCompany());
			ingredients.put("address", user.getAddress());
			ingredients.put("ipaddress", user.getIp());
			jsonObj.put("ingredients" + i, ingredients);
		}
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			SystemLogUtil.saveError(Constants.LOG_ERROR, e.getMessage());
		}

		return null;

	}

	@RequestMapping("/realtime.html")
	public ModelAndView realtime(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int str = getlistUser().size();

		JSONObject jsonObj = new JSONObject();
		Map<String, String> ingredients = new HashMap<String, String>();
		ingredients.put("str", String.valueOf(str));
		jsonObj.put("ingredients", ingredients);
		response.getWriter().write(jsonObj.toString());
		return null;

	}

}
