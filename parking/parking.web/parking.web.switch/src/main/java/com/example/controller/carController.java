package com.example.controller;
	import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.util.Base64Util;
import com.example.bean.Carnum;
import com.example.bean.Place;
import com.example.bean.WhiteList;
import com.example.dao.WhiteListMapper;
import com.example.dto.CarnumDto;
import com.example.service.AuthService;
import com.example.service.CarInService;
import com.example.service.CarnumService;
import com.example.utils.HttpUtil;
import com.example.utils.ImageUtils;
import com.example.utils.MenoyUtils;



	/**
	 * OCR 通用识别
	 */
    @Controller
	public class carController {

		@Autowired
		private CarnumService service;
		
		@Autowired
		private CarInService serviceCarIn;
		
	    /**
	     * 重要提示代码中所需工具类
	     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
	     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
	     * 下载
	     */
		/**
		 * 获取车辆所有信息，刷新到表格
		 * @param name
		 * @param start
		 * @param end
		 * @param request
		 * @return
		 */
		@RequestMapping("/listcarOutByPage.action")
		@ResponseBody
		public JSONObject listcarOutByPage(String data,HttpServletRequest request) {
	        // 通用识别url
	        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/license_plate";
	        JSONObject model = new JSONObject();
	        try {
	        	byte[] baseToByte = ImageUtils.baseToByte(data);
	            String imgStr = Base64Util.encode(baseToByte);
	            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
	            /**
	             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
	             */
	            String accessToken = AuthService.getAuth();
	            String result = HttpUtil.post(otherHost, accessToken, params);
	            String number = null;
	            Map<String, Object> map = JSON.parseObject(result.toString(), Map.class);
	            if(map != null) {
	    			Map<String, Object> resultMap = (Map)map.get("words_result");
	    				if(resultMap != null) {
	    						for (Map.Entry<String, Object> entry:resultMap.entrySet()) {
	    							if(entry.getKey().equals("number")) {
	    								number = entry.getValue().toString();
	    								break;
	    							}
	    					}
	    				}
	    		}
	            if(number != null) {
	            	WhiteList whiteListInfo = serviceCarIn.whiteListInfo(number);
	            	Carnum checkCarnum = serviceCarIn.checkCarnum(number);
	            	if(whiteListInfo != null) {
	            		checkCarnum.setCarRoleId(3);
	            		model.put("id", 0);
	            		model.put("car", checkCarnum);
	            	}else if(checkCarnum.getCarRoleId() == 2){
	            		model.put("id", 0);
	            		model.put("car", checkCarnum);
	            	}else {
	            		Place placeInfo = serviceCarIn.placeInfo(number);
	            		if(placeInfo == null) {
	            			model.put("id", 0);
		            		model.put("car", checkCarnum);
	            		}else {
	            			model.put("id", 99);
		            		model.put("message", "请缴交费用后出场！");
		            		model.put("car", number);
	            		}
	            	}
	            }else {
	            	model.put("id", 1);
            		model.put("message", "车牌识别失败");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return model;
	    }
	    
	}

