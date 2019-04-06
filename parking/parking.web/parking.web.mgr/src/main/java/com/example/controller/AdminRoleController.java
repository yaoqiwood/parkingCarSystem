package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.AdminRole;
import com.example.service.AdminRoleService;

/**
 * 管理员角色控制层类
 * @author 黄主文
 *
 */
@Controller
public class AdminRoleController {
	
	@Autowired
	private AdminRoleService service;
	
	/**
	 * 获取角色的名字，添加到下拉框
	 * @param request
	 * @return
	 */
	@RequestMapping("/listrole.action")
	@ResponseBody
	public JSONObject listrole(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		List<AdminRole> types = service.listrole();
		
		data.put("types", types);
		data.put("id", 0);
		return data;
		
	}
	

}
