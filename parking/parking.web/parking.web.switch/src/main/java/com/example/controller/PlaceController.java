package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.example.service.PlaceService;

@Controller
public class PlaceController {
	
	@Autowired
	private PlaceService placeService;
	
	@RequestMapping("placeCountInf.action")
	@ResponseBody
	public JSONObject placeCountInf() {
		JSONObject obj = new JSONObject();
		Integer placeCount = placeService.placeCount();
		Integer placeHasCount = placeService.placeHasCount();
		obj.put("placeCount", placeCount);
		obj.put("placeHasCount", placeHasCount);
		return obj;
	}

}
