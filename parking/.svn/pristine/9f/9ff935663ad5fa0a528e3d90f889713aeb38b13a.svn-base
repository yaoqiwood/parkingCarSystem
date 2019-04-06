package com.example.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.bean.Admin;
import com.example.service.AdminService;
import com.example.utils.AipOcrSample;
import com.example.utils.ImageUtils;

@Controller
public class FaceController {
	
	@Autowired
	private AdminService service;
	
	@RequestMapping("/faceLogin.action")
	@ResponseBody
	public JSONObject faceLogin(String data,HttpServletRequest request) {
		
		byte[] baseToByte = ImageUtils.baseToByte(data);
		org.json.JSONObject obj = AipOcrSample.searchFace(baseToByte, "User", null);
//		System.out.println(obj.toString());
		
		String id = null;
		//解析json信息 
		Map<String, Object> map = JSON.parseObject(obj.toString(), Map.class);
		if(map != null) {
			Map<String, Object> resultMap = (Map)map.get("result");
			if(resultMap != null) {
				List<Map<String,Object>> userList = (List)resultMap.get("user_list");
				if(userList != null) {
					for (Map<String, Object> objectMap:userList) {
						for (Map.Entry<String, Object> entry:objectMap.entrySet()) {
//							System.out.println(entry.getKey()+"\\"+entry.getValue().toString());
							if(entry.getKey().equals("user_id")) {
								id = entry.getValue().toString();
								break;
							}
						}
					}
				}
			}
		}
		
		JSONObject model = new JSONObject();
		Admin adminLogin = service.adminLogin(Integer.parseInt(id));
		if(adminLogin != null) {
			model.put("message", "登录成功");
			model.put("id","0");
			model.put("location","frame");
		}else {
			model.put("message", "登录失败");
			model.put("id","1");
		}
		System.out.println(model.toString());
		return model;
	}

}
