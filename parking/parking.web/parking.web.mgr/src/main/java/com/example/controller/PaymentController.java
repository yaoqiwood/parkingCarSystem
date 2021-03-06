package com.example.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.example.bean.CarRecord;
import com.example.service.PaymentService;
import com.example.utils.MenoyUtils;
/**
 * 
  * <p>Title : PaymentController</p>
  * <p>Description : 自助缴费信息控制类</p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月27日 上午9:00:02
  * @version : 12.0.0
 */
@Controller
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	/*
	 * 自助缴费信息
	 */
	@RequestMapping("/do-payment.ajax")
	@ResponseBody
	public JSONObject payment(String name ,HttpServletRequest request) {
		System.out.println("获取 payment= "+ name );
		//查找车辆id
		Integer CarId = paymentService.queryCarId(name);
		System.out.println("CarId= "+CarId);
		JSONObject model = new JSONObject();
		if(CarId!=null) {
			System.out.println("有carId");
				//更新离开时间
				Integer updateRecord = paymentService.updateRecord(new Date(), CarId);
				CarRecord queryRecord = paymentService.queryRecord(name);
				Integer money = MenoyUtils.sumOfMoney(queryRecord.getCarRecordComeTime(), queryRecord.getCarRecordOutTime());
				model.put("id", "0");
				model.put("queryRecord", queryRecord);
				model.put("money", money);
			
		}else {
			System.out.println("没有carId");
			model.put("id", "1");
			model.put("queryRecord", "");
			model.put("money", "");
		}
		return model;
	}
	

	/*
	 * 缴费
	 */
	@RequestMapping("/do-alipay.ajax")
	@ResponseBody
	public JSONObject alipay(Integer id, String carNo,Integer mechineId,String out_trade_no ,String subject , String total_amount , String body, HttpServletRequest request) {
		System.out.println("获取 alipay "+ out_trade_no + " : " + subject + " : " + total_amount + " : " + body);
		System.out.println(id+" : "+carNo+" : "+mechineId);
		//record表state改成-1
		Integer deleteRecord = paymentService.deleteRecord(id);
			//System.out.println("deleteRecord= "+deleteRecord);
		//插入MACHINE_LOG表日志
		Integer total_amount_int = Integer.valueOf(total_amount);
		Integer addMechineLog = paymentService.addMechineLog(mechineId, carNo, total_amount_int);
		System.out.println("addMechineLog= "+addMechineLog);
		//提示缴费成功
		JSONObject model = new JSONObject();
		String result = null;
		//请求
		try {
			//获得初始化的AlipayClient
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
			
			//设置请求参数
			AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
			alipayRequest.setReturnUrl(AlipayConfig.return_url);
			alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
			
			alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
					+ "\"total_amount\":\""+ total_amount +"\"," 
					+ "\"subject\":\""+ subject +"\"," 
					+ "\"body\":\""+ body +"\"," 
					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
			result = alipayClient.pageExecute(alipayRequest).getBody();
			System.out.println("result= "+result);
			//model.put("result", result);
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.put("result", result);
		return model;
	}
	
	@RequestMapping("/return.ajax")
	@ResponseBody
	public ModelAndView success(HttpServletRequest request ,HttpServletResponse httpResponse) throws Exception, IOException {
		System.out.println("支付成功");
		ModelAndView mv = new ModelAndView();
		mv.addObject("carLicense", "1");
		mv.setViewName("payment");
		return mv;
	}
}
