package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.Log;
import com.example.service.LogService;
/**
 * 
  * <p>Title : LogController</p>
  * <p>Description : 日志控制类</p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月21日 下午6:21:05
  * @version : 12.0.0
 */
@Controller
public class LogController {
	
	@Autowired
	private LogService logService;
	/**
	 * 日志
	 * @param timeSt 起始时间
	 * @param timeEn 结束时间
	 * @param name 管理员名
	 * @param start 开始页数
	 * @param end 结束页数
	 * @param request
	 * @return
	 */
	@RequestMapping("/do-log.ajax")
	@ResponseBody
	public JSONObject log(String timeSt,String timeEn,String name,String start, String end,HttpServletRequest request) {
		System.out.println("log= "+timeSt+" : "+timeEn+" : "+name+" : "+start+" : "+end+" : ");
		List<Log> logList = logService.queryLogBySearch(timeSt, timeEn, name, start, end);
		Integer count = logService.countLogBySearch(timeSt, timeEn, name);
		JSONObject model = new JSONObject();
		model.put("logList", logList);
		model.put("count", count);
		return model;
	}
	
}
