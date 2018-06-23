package com.sinosoft.baseInfo.menuManage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinosoft.authoriy.Authoriy;
import com.sinosoft.authoriy.AuthoriyManager;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.baseInfo.menuManage.model.MenuConfigModel;
import com.sinosoft.baseInfo.menuManage.model.MenuConfigVo;
import com.sinosoft.baseInfo.menuManage.service.MenuManageService;
import com.sinosoft.util.DisplayGetPage;

@Controller
public class MenuManageAction extends BaseFormController {
	@Autowired
	private MenuManageService menuManageService;
    @Autowired
    private AuthoriyManager authoriyManager;
	
	@RequestMapping("menuManage/menuConfigFrame.html")
	public ModelAndView openFramePage(MenuConfigModel mc, HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView("jsp/baseInfo/menuManage/menuConfigFrame");
	}
	
	//菜单树
	@RequestMapping("/menuManage/frame/menuTree.html")
	public ModelAndView getTree(Model model, String id ,HttpServletRequest request,HttpServletResponse response) throws IOException{
		if(null == id){
			id = "-1";
		}
		
		List<MenuConfigModel> mcList =  menuManageService.getListByHql("from MenuConfigModel where parentId = "+id);
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		
		for(MenuConfigModel mc : mcList){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", mc.getId());
			map.put("text", mc.getMenuName());
			map.put("state", "closed");
			mapList.add(map);
		}
		
		JSONArray array = JSONArray.fromObject(mapList);
		
		response.setContentType("text/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(array.toString());
		out.flush();
		return null;
	}
	
	//菜单栏显示
	@RequestMapping("/menuManage/frame/showLeftMenu.html")
	public ModelAndView showLeftMenu(Model model, HttpServletRequest request, HttpServletResponse response){
		List<MenuConfigVo> voList = menuManageService.showMenuVoList();
 		
		return new ModelAndView("jsp/baseInfo/menuManage/view/showMenuView","leftMenuList",voList);
	}
	
	@RequestMapping("/menuManage/frame/menuConfigList.html")
	public ModelAndView menuConfigList(MenuConfigModel mc, HttpServletRequest request, HttpServletResponse response){
		String currentPage = DisplayGetPage.getPageParamName("entityList", request);// 当前页号
		String menuId = request.getParameter("menuId");
		
		if(null != menuId){
			mc.setParentId(Long.valueOf(menuId));
		}
		
		List<MenuConfigModel> mcList = menuManageService.getListByPage(mc, (Integer.parseInt(currentPage) - 1)*Constants.pagesize, Constants.pagesize	);
		
		int resultSize = menuManageService.getRecordCountByMenuId(menuId);//总记录数
		int pages = resultSize / Constants.pagesize;
		if(resultSize % Constants.pagesize != 0){
			pages += 1;
		}
		
		request.setAttribute("resultSize", resultSize);
		request.setAttribute("pageSize", Constants.pagesize);//页面大小
		request.setAttribute("thispage", currentPage);
		request.setAttribute("displayallpage", pages);
		request.setAttribute("entity", mc);
		request.setAttribute("menuId", menuId);
		
		return new ModelAndView("jsp/baseInfo/menuManage/menuConfigList","entityList",mcList);
	}
	
	@RequestMapping("menuManage/update.html")
	public ModelAndView openUpdatePage(Model model, HttpServletRequest request, HttpServletResponse response){
        List<Authoriy> authoriyList = authoriyManager.getAll();
        model.addAttribute("authoriyList", authoriyList);
		String menuId = request.getParameter("menuId");
		String type = request.getParameter("type");
		MenuConfigModel mc = null;
		request.setAttribute("type", type);
		if("edit".equals(type) && null != menuId){
			mc = menuManageService.get(Long.valueOf(menuId));
		}
		else if("add".equals(type)){
			request.setAttribute("menuId", menuId);
			return new ModelAndView("jsp/baseInfo/menuManage/addMenuConfig");
		}
		
		return new ModelAndView("jsp/baseInfo/menuManage/updateMenuConfig","entity",mc);
	}
	
	@RequestMapping("menuManage/frame/saveMenuConfig.html")
	public String updateMenuConfig(MenuConfigModel mc, HttpServletRequest request, HttpServletResponse response){
		//保存或修改菜单信息
		if(null != mc){
			menuManageService.saveOrUpdate(mc);
		}
		
		return "redirect:/menuManage/menuConfigFrame.html";
	}
	
	@RequestMapping("menuManage/showMenu.html")
	public ModelAndView showMenu(Model model, HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView("jsp/baseInfo/menuManage/updateMenuConfig");
	}
}
