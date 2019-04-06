package com.example.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.baidu.aip.util.Base64Util;
import com.example.bean.CarRecord;
import com.example.bean.Carnum;
import com.example.bean.FeeRule;
import com.example.bean.WhiteList;
import com.example.dao.CarnumMapper;
import com.example.dao.WhiteListMapper;
import com.example.service.AuthService;
import com.example.service.PaymentService;
import com.example.uitls.Sample;
import com.example.utils.HttpUtil;
import com.example.utils.ImageUtils;
import com.example.utils.MenoyUtils;

import oracle.net.aso.q;

/**
 * 
 * <p>
 * Title : PaymentController
 * </p>
 * <p>
 * Description : 自助缴费信息控制类
 * </p>
 * <p>
 * DevelopTools : Eclipse_x64_v4.7.1
 * </p>
 * <p>
 * DevelopSystem : Windows 10
 * </p>
 * <p>
 * Company : org.chenmian
 * </p>
 * 
 * @author : ChenMian
 * @date : 2019年2月27日 上午9:00:02
 * @version : 12.0.0
 */
@Controller
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private WhiteListMapper paymentWhite;

	@Autowired
	private CarnumMapper mapper;

	/*
	 * 自助缴费信息
	 */
	@RequestMapping("/do-payment.ajax")
	@ResponseBody
	public JSONObject payment(String data, HttpServletRequest request) throws Exception {
		JSONObject model = new JSONObject();
//		byte[] baseToByte = ImageUtils.baseToByte(data);
		/*String imgStr = Base64Util.encode(baseToByte);
		String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
		*//**
		 * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。 获取结果中的车牌号，若结果中有着赋予变量number
		 *//*
		String accessToken = AuthService.getAuth();
		String result = HttpUtil.post(otherHost, accessToken, params);*/
		String number = data;
//		HashMap<String, String> options = new HashMap<String, String>(16);
//	    options.put("multi_detect", "true");
//		org.json.JSONObject result = Sample.getClient().plateLicense(baseToByte, options);
//		JSONArray jsonArray;
//		try {
//			jsonArray = result.getJSONArray("words_result");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			model.put("id", 9);
//			return model;
//		}
//		number = jsonArray.getJSONObject(0).getString("number");
		
		// 查找车辆id的入场记录
		if(number != null) {
			CarRecord queryRecord = paymentService.queryRecord(number);
			if (queryRecord != null) {// 如果有继续判断是否是白名单
				WhiteList whiteList = paymentWhite.whiteListInfo(number);
				Date date = new Date();// 记录当前时间
				queryRecord.setCarRecordOutTime(date);
				if (whiteList != null) {
					paymentService.updateRecord(date, queryRecord.getCarRecordId());
					mapper.updatePlaceInfo(number);
					paymentService.deleteRecord(queryRecord.getCarRecordId());
					queryRecord.setCarRecordMemo("0");
					queryRecord.setCarRecordState(3);
					model.put("id", 4);
					model.put("message", "您是尊敬的白名单用户！无需缴费~祝您一路顺风");
					model.put("info", queryRecord);
					return model;
				}
				Carnum checkCarnum = mapper.checkCarnum(number);
				if (checkCarnum.getCarRoleId() == 2) {
					paymentService.updateRecord(date, queryRecord.getCarRecordId());
					mapper.updatePlaceInfo(number);
					paymentService.deleteRecord(queryRecord.getCarRecordId());
					queryRecord.setCarRecordMemo("0");
					queryRecord.setCarRecordState(2);
					model.put("id", 4);
					model.put("message", "您是月缴用户！无需额外缴费~祝您一路顺风");
					model.put("info", queryRecord);
					return model;
				} else {
					Integer sumOfMoney = MenoyUtils.sumOfMoney(queryRecord.getCarRecordComeTime(), date);
					queryRecord.setCarRecordMemo(sumOfMoney + "");
					queryRecord.setCarRecordState(1);
					model.put("id", 0);
					model.put("info", queryRecord);
					return model;
				}
				
			}else {
				Integer updatePlaceInfo = mapper.updatePlaceInfo(number);
				if(updatePlaceInfo > 0) {
					model.put("id", 3);
					model.put("message", "您已经缴费成功，祝您一路顺风");
				}else {
					model.put("id", 2);
					model.put("message", "未找到该车辆信息");
				}
			}
		}else {
			model.put("id", 9);
		}
		return model;
	}

	/*
	 * 缴费
	 */
	@RequestMapping("/do-alipay.ajax")
	@ResponseBody
	public JSONObject alipay(String mechineId, String carRecordId, String carNum, String money,
			HttpServletRequest request) {
		// 提示缴费成功
		JSONObject model = new JSONObject();
		Integer updateRecord = paymentService.updateRecord(new Date(), Integer.parseInt(carRecordId));
		Integer deleteRecord = paymentService.deleteRecord(Integer.parseInt(carRecordId));
		Integer addMechineLog = paymentService.addMechineLog(Integer.parseInt(mechineId), carNum,Integer.parseInt(money));
		mapper.updatePlaceInfo(carNum);
		if (addMechineLog > 0) {
			model.put("id", 0);
			model.put("message", "付费成功");
		} else {
			model.put("id", 1);
			model.put("message", "付费失败");
		}
		return model;
	}
}
