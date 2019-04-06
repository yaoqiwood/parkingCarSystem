package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.dto.MenuDto;
import com.example.dto.MenuRoleDto;
import com.example.service.MenuService;

@Controller
public class MenuController {

	@Autowired
	private MenuService service;

	@RequestMapping("/listMenuupdate.action")
	@ResponseBody
	public JSONObject listMenuupdate(String roleId, HttpServletRequest request) {
		JSONObject data = new JSONObject();
		List<MenuRoleDto> menu = service.getMenu(roleId);
		// 数据处理
		List<MenuRoleDto> misRes = new ArrayList<MenuRoleDto>();
		// 将1级的菜单存放到misRes对象中
		for (int i = 0; i < menu.size(); i++) {
			MenuRoleDto mi = menu.get(i);
			if (mi.getMenuParent() == 0) {
				misRes.add(mi);
				menu.remove(mi);
			}
		}
		// 找到2级菜单
		for (int i = 0; i < menu.size(); i++) {
			MenuRoleDto mi = menu.get(i);
			for (int j = 0; j < misRes.size(); j++) {
				MenuRoleDto miParent = misRes.get(j);
				if (miParent.getMenuId() == mi.getMenuParent()) {
					miParent.getMenuInfs().add(mi);
					break;
				}
			}
		}
		data.put("menus", misRes);
		data.put("id", 0);

		return data;
	}

	@RequestMapping("/listbtn.action")
	@ResponseBody
	public JSONObject listbtn(String roleId, String list, HttpServletRequest request) {
		JSONObject data = new JSONObject();
		Integer updatemenu = service.updatemenu(roleId);
		String[] uiroleId = list.split(",");
		ArrayList<String> uiroleIdlist = new ArrayList<String>();
		for (int i = 0; i < uiroleId.length; i++) {
			uiroleIdlist.add(uiroleId[i]);
		}
		int sum = 0;
		for (int i = 0; i < uiroleIdlist.size(); i++) {
			int count1 = service.updatemenuroleId(uiroleIdlist.get(i));
			sum += count1;
		}
		if (updatemenu > 0 && sum == uiroleIdlist.size()) {
			data.put("message", "修改成功");
			data.put("id", 0);
		} else {
			data.put("message", "修改失败");
			data.put("id", 1);
		}
		return data;
	}
	
	/**
	 * 获取当前所有菜单信息
	 * @return
	 */
	@RequestMapping("/menuInfo.action")
	@ResponseBody
	public JSONObject menuInfo() {
		JSONObject data = new JSONObject();
		List<MenuDto> menuInfo = service.menuInfo();
		data.put("list", menuInfo);
		return data;
	}
	
	/**
	 * 修改菜单图标
	 * @return
	 */
	@RequestMapping("/updateItem.action")
	@ResponseBody
	public JSONObject menuInfo(String id,String item) {
		JSONObject data = new JSONObject();
		Integer updateItem = service.updateItem(id, item);
		if(updateItem > 0) {
			data.put("id", 0);
			data.put("message", "修改成功");
		}else {
			data.put("id", 1);
			data.put("message", "修改失败");
		}
		return data;
	}
	

}
