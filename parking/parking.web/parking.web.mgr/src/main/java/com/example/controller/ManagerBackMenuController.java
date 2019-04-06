/**
 * 
 */
package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bean.Admin;
import com.example.bean.Menu;
import com.example.dto.MenuDto;
import com.example.service.ManagerBackMenuService;
import com.example.utils.CToolUtils;
import com.example.utils.CheckInfoUtils;

/**
 * Title : ManagerFrontMenuController Description : DevelopTools : Eclipse_x64
 * DevelopSystem : Win10 Company : org.NorwegianWoods
 * 
 * @author : CatWood
 * @date : Feb 21, 2019 10:59:31 PM
 * @version : 12.0.0
 */

@Controller
public class ManagerBackMenuController {
	@Autowired
	private ManagerBackMenuService managerBackMenuService;

	/**
	 * 初始化左导航
	 * 
	 * @return
	 */
	@RequestMapping("/init-leftMenu.action")
	@ResponseBody
	public JSONArray initLeftMenu(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		List<MenuDto> menus = managerBackMenuService.initLeftMenu(admin.getAdminRoleId());
		JSONArray jsonArray = (JSONArray) JSONArray.toJSON(menus);
		return jsonArray;
	}

	/**
	 * 刷新菜单表
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/ref-menuManager.action")
	@ResponseBody
	public JSONArray refMenuManager(String menuName, String menuState, String CurrentPage, String Limit,
			HttpServletRequest req, HttpServletResponse res) {
		JSONArray jsonArray = new JSONArray();
		if (CToolUtils.isEmpAnIsNum(CurrentPage) && CToolUtils.isEmpAnIsNum(Limit)) {
			String begin = CToolUtils.BeginPage(CurrentPage, Limit);
			String end = CToolUtils.EndPage(CurrentPage, Limit);
			if (!CToolUtils.isEmpAnIsNum(menuState)) {
				menuState = "";
			}
			List<Menu> menus = managerBackMenuService.refMenuManager(menuName, menuState, begin, end);
			jsonArray = (JSONArray) JSONArray.toJSON(menus);
		}
		return jsonArray;
	}

	/**
	 * 统计数量
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/cnt-menuManager.action")
	@ResponseBody
	public JSONObject cntMenuManager(String menuName, String menuState, HttpServletRequest req,
			HttpServletResponse res) {
		JSONObject jsonObject = new JSONObject();

		if (!CToolUtils.isEmpAnIsNum(menuState)) {
			menuState = "";
		}
		String cnt = managerBackMenuService.cntMenuManager(menuName, menuState);
		jsonObject.put("count", cnt);
		return jsonObject;
	}
	
	/**
	 * 根据fid查菜单栏
	 * @param fid
	 * @return
	 */
	@RequestMapping("/viewUp-menuManager.action")
	@ResponseBody
	public JSONObject viewUpMenuManager(String fid) {
		JSONObject jsonObject = new JSONObject();
		if (!CheckInfoUtils.isEmpty(fid)) {
			Menu menu = managerBackMenuService.viewUpMenuManager(fid);
			jsonObject = (JSONObject) JSONObject.toJSON(menu);
		}
		return jsonObject;
	}

	/**
	 * 添加菜单
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/add-menuManager.action")
	@ResponseBody
	public JSONObject addMenuManager(String addMenuName, String addParentID, String addURL, HttpServletRequest req,
			HttpServletResponse res) {
		JSONObject jsonObject = new JSONObject();
		if ((!CheckInfoUtils.isEmpty(addMenuName)) && CToolUtils.isEmpAnIsNum(addParentID)
				&& (!CheckInfoUtils.isEmpty(addURL))) {
			// 检查名称是否重复
			if (managerBackMenuService.checkReMName(addMenuName) == 0) {
				Integer out = managerBackMenuService.addMenuManager(addMenuName, Integer.parseInt(addParentID), addURL);
				if (out > 0) {
					jsonObject.put("id", "1");
					jsonObject.put("message", "插入成功");
				} else {
					jsonObject.put("id", "0");
					jsonObject.put("message", "插入失败");
				}
			} else {
				jsonObject.put("id", "3");
				jsonObject.put("message", "不可插入一个菜单名重复的数据");
			}
		} else {
			jsonObject.put("id", "3");
			jsonObject.put("message", "数据有误");
		}
		return jsonObject;
	}

	/**
	 * 修改菜单名
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/up-menuManager.action")
	@ResponseBody
	public JSONObject upMenuManager(String upMenuId, String upMenuName, String upParentID, String upURL,
			HttpServletRequest req, HttpServletResponse res) {
		JSONObject jsonObject = new JSONObject();
		if (CToolUtils.isEmpAnIsNum(upMenuId) && (!CheckInfoUtils.isEmpty(upMenuName))
				&& CToolUtils.isEmpAnIsNum(upParentID) && (!CheckInfoUtils.isEmpty(upURL))) {
			if (managerBackMenuService.checkReMName(upMenuName) == 0) {
				Integer out = managerBackMenuService.upMenuManager(Integer.parseInt(upMenuId), upMenuName,
						Integer.parseInt(upParentID), upURL);
				if (out > 0) {
					jsonObject = jsonMessage("1", "更新成功");
				} else {
					jsonObject = jsonMessage("0", "更新成功");
				}
			} else {
				jsonObject.put("id", "3");
				jsonObject.put("message", "不可插入修改菜单名为重复的数据");
			}
		} else {
			jsonObject = jsonMessage("3", "参数有误");
		}
		return jsonObject;
	}

	/**
	 * 修改状态
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/upState-menuManager.action")
	@ResponseBody
	public JSONObject upStateMenuManager(String upState, String Fid, HttpServletRequest req, HttpServletResponse res) {
		JSONObject jsonObject = new JSONObject();
		if (CToolUtils.isEmpAnIsNum(upState) && CToolUtils.isEmpAnIsNum(Fid)) {
			Integer out = managerBackMenuService.upStateMenuManager(Integer.parseInt(upState), Integer.parseInt(Fid));
			if (out > 0) {
				jsonObject = jsonMessage("1", upState.equals("0") ? "禁用成功" : "启用成功");
			} else {
				jsonObject = jsonMessage("0", upState.equals("0") ? "禁用失败" : "启用失败");
			}
		} else {
			jsonObject = jsonMessage("3", "参数有误");
		}
		return jsonObject;
	}

	/**
	 * 删除菜单
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/del-menuManager.action")
	@ResponseBody
	public JSONObject delMenuManager(String Fid, HttpServletRequest req, HttpServletResponse res) {
		JSONObject jsonObject = new JSONObject();
		if (CToolUtils.isEmpAnIsNum(Fid)) {
			// 假删除
			Integer out = managerBackMenuService.upStateMenuManager(9, Integer.parseInt(Fid));
			if (out > 0) {
				jsonObject = jsonMessage("1", "删除成功");
			} else {
				jsonObject = jsonMessage("0", "删除失败");
			}
		} else {
			jsonObject = jsonMessage("3", "参数有误");
		}
		return jsonObject;
	}

	/**
	 * 消息封装 (Util缺FASTJSON包)
	 * 
	 * @param id
	 * @param message
	 * @return
	 */
	public JSONObject jsonMessage(String id, String message) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", id);
		jsonObject.put("message", message);
		return jsonObject;
	}

}
