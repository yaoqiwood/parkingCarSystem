package com.example.controller;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
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
import com.example.dto.CarnumDto;
import com.example.service.AuthService;
import com.example.service.CarInService;
import com.example.uitls.Sample;
import com.example.utils.HttpUtil;
import com.example.utils.ImageUtils;

@Controller
public class CarInController {

	@Autowired
	private CarInService service;

	/**
	 * 获取车辆所有信息，刷新到表格
	 * 
	 * @param name
	 * @param start
	 * @param end
	 * @param request
	 * @return
	 */
	@RequestMapping("/listcarInByPage.action")
	@ResponseBody
	public JSONObject listcarInByPage(String data, HttpServletRequest request) {
        JSONObject model = new JSONObject();
        try {
//        	byte[] baseToByte = ImageUtils.baseToByte(data);
        	String number = data;
    		/*HashMap<String, String> options = new HashMap<String, String>(16);
    	    options.put("multi_detect", "true");
    		org.json.JSONObject result = Sample.getClient().plateLicense(baseToByte, options);
			try {
				JSONArray	jsonArray = result.getJSONArray("words_result");
				number = jsonArray.getJSONObject(0).getString("number");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				model.put("id",1);
				model.put("message", "识别失败");
				return model;
			}*/
    		
            if(number != null) {//如果车牌不为空
            	//判断车辆是否已经入场
            	Place placeInfo = service.placeInfo(number);
            	if(placeInfo != null) {
            		model.put("id",1);
            		model.put("message", "已有车位");
            		return model;
            	}
            	Carnum checkCarnum = service.checkCarnum(number);//检查车牌表中是否有该车牌信息
            	if(checkCarnum == null) {//没有车牌进行添加
            		Carnum carnum = new Carnum();
            		carnum.setCarNumber(number);
            		Integer addCarnum = service.addCarnum(carnum);
            		if(addCarnum > 0) {//成功则返回信息，失败直接返回失败json
            			checkCarnum = carnum;
            		}else {
            			model.put("id",1);
                		model.put("message", "录入信息失败");
                		return model;
            		}
            	}
            	//查询白名单，如果预先车辆有在白名单则将信息改变为白名单角色
            	WhiteList whiteListInfo = service.whiteListInfo(number);
            	if(whiteListInfo != null) {
            		checkCarnum.setCarRoleId(3);
            	}
            	//随机分配位置（模拟停车）
            	Integer ppnum = new Random().nextInt(80)+113;
            	//登记入场信息
            	Integer updatePlaceState = service.updatePlaceState(ppnum+"", checkCarnum.getCarNumber());
            	if(updatePlaceState > 0) {
            		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            		Date inTime = new Date();
            		Integer addcarRecord = service.addcarRecord(checkCarnum.getCarnumId()+"", dateFormat.format(inTime));
            		if(addcarRecord > 0) {//添加成功返回信息
            			model.put("id", 0);
            			checkCarnum.setCarnumCreateTime(inTime);
            			model.put("car", checkCarnum);
            			System.out.println(checkCarnum.toString());
            		}else {
            			model.put("id",1);
            			model.put("message", "录入信息失败");
            		}
            	}else {
            		model.put("id",1);
            		model.put("message", "录入信息失败");
            	}
            }else {
            	model.put("id",1);
				model.put("message", "识别失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
	}

}
