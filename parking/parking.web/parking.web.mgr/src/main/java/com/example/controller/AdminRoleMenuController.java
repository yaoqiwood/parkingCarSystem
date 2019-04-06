package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.Admin;
import com.example.bean.AdminRoleMenu;
import com.example.service.AdminRoleMenuService;

@Controller
public class AdminRoleMenuController {
	
	@Autowired
	AdminRoleMenuService service;
	
	@RequestMapping("/roleMenuInf.action")
	@ResponseBody
	public JSONObject roleMenuInf(Integer roleId) {
		JSONObject data = new JSONObject();
		List<AdminRoleMenu> roleMenuInf = service.roleMenuInf(roleId);
		if(roleMenuInf !=null) {
			data.put("list", roleMenuInf);
		}else {
			data.put("list", new ArrayList<>());
		}
		return data;
	}
	
	@RequestMapping("/roleMenuUpdate.action")
	@ResponseBody
	public JSONObject roleMenuUpdate(Integer roleId,String updateInf) {
		JSONObject data = new JSONObject();
		Integer roleMenuUpdate = service.roleMenuUpdate(roleId, updateInf);
		if(roleMenuUpdate > 0) {
			data.put("id", 0);
			data.put("message", "修改成功！");
		}else {
			data.put("id", 1);
			data.put("message", "修改失败！");
		}
		return data;
	}
	
}
