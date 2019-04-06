package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.dto.PlaceDto;
import com.example.service.PlaceService;

@Controller
public class PlaceController {
	
	@Autowired
	private PlaceService service;
	
	/**
	 * 获取用户所有信息，刷新到表格
	 * @param startTime
	 * @param endTime
	 * @param name
	 * @param role
	 * @param state
	 * @param start
	 * @param end
	 * @param request
	 * @return
	 */
	@RequestMapping("/listPlaceByPage.action")
	@ResponseBody
	public JSONObject listPlaceByPage(String place ,String floor,String name,Integer start,Integer end,HttpServletRequest request) {
		JSONObject data = new JSONObject();
		List<PlaceDto> listPlaceByPage = service.listPlaceByPage(place, floor, name, start, end);
		Integer countPlace = service.countPlace(place, floor, name);
		data.put("admins", listPlaceByPage);
		data.put("count", countPlace);
		data.put("id", 0);
		
		return data;
		}

	/**
	 * 删除用户
	 * @param adminId
	 * @param request
	 * @return
	 */
	@RequestMapping("/delCarplace.action")
	@ResponseBody
	public JSONObject delPlace(String placeId,HttpServletRequest request) {
		JSONObject data = new JSONObject();
		Integer delPlace = service.delPlace(placeId);
		if(delPlace >0 ) {
			data.put("id", 0);
			data.put("message", "删除成功");
		}else {
			data.put("id", 1);
			data.put("message", "删除失败");
		}
		return data;
	}
	
	/**
	 * 修改
	 * @param dplace
	 * @param dfloor
	 * @param placePsId
	 * @param request
	 * @return
	 */
	@RequestMapping("/motifyCarplace.action")
	@ResponseBody
	public JSONObject updatePlace(String dplace, String dfloor, String placePsId, HttpServletRequest request) {
		JSONObject data = new JSONObject();
		Integer updatePlace = service.updatePlace(dplace, dfloor, placePsId);
		if(dplace.equals("") || dplace == null || dfloor.equals("") || dfloor == null ) {
			data.put("message", "不可为空，请重新输入");
		}else {
			if(updatePlace > 0 ) {
				data.put("id", 0);
				data.put("message", "修改成功");
			}else {
				data.put("id", 1);
				data.put("message", "修改失败");
			}
		}
		return data;
	}
	
	/**
	 * 添加用户
	 * @param addname
	 * @param addpassword
	 * @param addrole
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPlace.action")
	@ResponseBody
	public JSONObject addPlace(String addname, String addplace, String addfloor,HttpServletRequest request) {
		JSONObject data = new JSONObject();
		Integer addPlace2 = service.addPlace(addname, addplace, addfloor);
		if(addname.equals("") || addname == null || addplace.equals("") || addplace == null 
				|| addfloor.equals("") ||addfloor == null) {
			data.put("message", "不可为空，请重新输入");
		}else {
			if(addPlace2 >0 ) {
				data.put("id", 0);
				data.put("message", "添加成功");
			}else {
				data.put("id", 1);
				data.put("message", "添加失败");
			}
		}
		return data;
	}
}
