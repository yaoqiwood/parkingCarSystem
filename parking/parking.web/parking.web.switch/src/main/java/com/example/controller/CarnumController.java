package com.example.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.service.CarnumService;

@Controller
public class CarnumController {
	
	@Autowired
	private CarnumService service;
	
	
	/**
	 * 插入流水出入场信息
	 * @param carNum
	 * @param money
	 * @param startTime
	 * @param carNumId
	 * @param request
	 * @return
	 */
	@RequestMapping("/addCarnum.action")
	@ResponseBody
	public JSONObject addCarnum(String carNum,String money,String startTime,String carNumId,HttpServletRequest request) {
		JSONObject data = new JSONObject();
		Integer addAmountLog = service.addAmountLog(carNum, money);
		Integer addcarRecord = service.addcarRecord(carNumId, startTime);
		
		if(addAmountLog > 0 && addcarRecord >0) {
			data.put("message", "结算成功,祝您一路顺风");
			data.put("id", 0);
		}
		return data;
	}

}
