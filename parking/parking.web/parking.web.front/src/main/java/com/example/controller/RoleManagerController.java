/**
 * 
 */
package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bean.AdminRole;
import com.example.service.RoleManagerService;
import com.example.utils.CheckInfoUtils;

/**
 * Title : RoleManagerController Description : DevelopTools : Eclipse_x64
 * DevelopSystem : Win10 Company : org.NorwegianWoods 角色管理控制层
 * 
 * @author : CatWood
 * @date : Feb 22, 2019 7:15:22 PM
 * @version : 12.0.0
 */

@Controller
public class RoleManagerController {

	@Autowired
	private RoleManagerService roleManagerService;

	/**
	 * 刷新角色表
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("ref-roleManager.action")
	@ResponseBody
	public JSONArray refRoleManager(HttpServletRequest req, HttpServletResponse res) {
		String roleName = req.getParameter("roleName");
		String roleState = req.getParameter("roleState");
		String CurrentPage = req.getParameter("CurrentPage");
		String Limit = req.getParameter("Limit");
		String begin = BeginPage(CurrentPage, Limit);
		String end = EndPage(CurrentPage, Limit);
		JSONArray jsonArray = new JSONArray();
		Integer set = roleState.equals("") ? null : Integer.parseInt(roleState);
		List<AdminRole> adminRoles = roleManagerService.refRoleManager(roleName, set, begin, end);
		jsonArray = (JSONArray) JSONArray.toJSON(adminRoles);

		return jsonArray;
	}

	/**
	 * 统计角色管理表
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/cnt-roleManager.action")
	@ResponseBody
	public JSONObject cntRoleManager(HttpServletRequest req, HttpServletResponse res) {
		String roleName = req.getParameter("roleName");
		String roleState = req.getParameter("roleState");
		JSONObject jsonObject = new JSONObject();
		Integer set = roleState.equals("") ? null : Integer.parseInt(roleState);
		String count = roleManagerService.cntRoleManager(roleName, set);
		jsonObject.put("count", count);
		return jsonObject;
	}

	/**
	 * 添加
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/add-roleManager.action")
	@ResponseBody
	public JSONObject addRoleManager(HttpServletRequest req, HttpServletResponse res) {
		String roleName = req.getParameter("addRoleName");
		JSONObject jsonObject = new JSONObject();
		if (!CheckInfoUtils.isEmpty(roleName)) {
			if (roleManagerService.checkRoleNameR(roleName) == 0) {
				Integer out = roleManagerService.addRoleManager(roleName);
				if (out > 0) {
					jsonObject = jsonMessage("1", "插入成功");
				} else {
					jsonObject = jsonMessage("0", "插入失败");
				}
			} else {
				jsonObject = jsonMessage("3", "角色名不可重复");
			}

		} else {
			jsonObject = jsonMessage("3", "参数有误");
		}
		return jsonObject;
	}

	/**
	 * 修改
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/up-roleManager.action")
	@ResponseBody
	public JSONObject upRoleManager(HttpServletRequest req, HttpServletResponse res) {
		String upRoleId = req.getParameter("upRoleId");
		String upRoleName = req.getParameter("upRoleName");
		JSONObject jsonObject = new JSONObject();
		if ((CheckInfoUtils.isEmpAnIsNum(upRoleId)) && (!CheckInfoUtils.isEmpty(upRoleName))) {
			if (roleManagerService.checkRoleNameR(upRoleName) == 0) {
				Integer out = roleManagerService.upRoleManager(Integer.parseInt(upRoleId), upRoleName);
				if (out > 0) {
					jsonObject = jsonMessage("1", "修改成功");
				} else {
					jsonObject = jsonMessage("0", "修改失败");
				}
			} else {
				jsonObject = jsonMessage("3", "修改名不可重复");
			}

		} else {
			jsonObject = jsonMessage("3", "参数有误");
		}
		return jsonObject;
	}

	/**
	 * 修改状态
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/upState-roleManager.action")
	@ResponseBody
	public JSONObject upStateRoleManager(HttpServletRequest req, HttpServletResponse res) {
		String upState = req.getParameter("upState");
		String Fid = req.getParameter("Fid");
		JSONObject jsonObject = new JSONObject();

		if (CheckInfoUtils.isEmpAnIsNum(upState) && CheckInfoUtils.isEmpAnIsNum(Fid)) {
			Integer out = roleManagerService.upStateRoleManager(Integer.parseInt(upState), Integer.parseInt(Fid));
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
	 * 假删除
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/del-roleManager.action")
	@ResponseBody
	public JSONObject delRoleManager(HttpServletRequest req, HttpServletResponse res) {
		String Fid = req.getParameter("Fid");
		JSONObject jsonObject = new JSONObject();

		if (CheckInfoUtils.isEmpAnIsNum(Fid)) {
			Integer out = roleManagerService.upStateRoleManager(9, Integer.parseInt(Fid));
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

	// ==================================================自用封装================================================//

	/**
	 * 消息封装
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

	/**
	 * 计算分页开始
	 * 
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */
	public String BeginPage(String CurrentPage, String Limit) {
		Integer CPage = Integer.parseInt(CurrentPage);
		Integer Lim = Integer.parseInt(Limit);
		return String.valueOf(CPage * Lim - (Lim - 1));
	}

	/**
	 * 计算分页结束
	 * 
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */
	public String EndPage(String CurrentPage, String Limit) {
		Integer CPage = Integer.parseInt(CurrentPage);
		Integer Lim = Integer.parseInt(Limit);
		return String.valueOf(CPage * Lim);
	}


}
