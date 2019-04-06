package com.example.controller;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.example.bean.Place;
import com.example.service.PaymentService;
import com.example.utils.MenoyUtils;
import com.example.utils.TimeUtils;
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
	public JSONObject payment(HttpServletRequest request) throws ParseException {
		//查找车辆id
		HttpSession session = request.getSession();
		String carNum = (String)session.getAttribute("carNum");
		Integer CarId = paymentService.queryCarId(carNum);
		JSONObject model = new JSONObject();
		if(CarId!=null) {
			//查询记录
			CarRecord recordInfo = paymentService.queryRecordById(CarId);
			if(recordInfo!=null){
				//更新离开时间
				Integer updateRecord = paymentService.updateRecord(new Date(), CarId);
				CarRecord queryRecord = paymentService.queryRecord(carNum);
				
				session.setAttribute("comeTime",queryRecord.getCarRecordComeTime().toString());
				session.setAttribute("outTime", queryRecord.getCarRecordOutTime().toString());
				Integer money = MenoyUtils.sumOfMoney(queryRecord.getCarRecordComeTime(), queryRecord.getCarRecordOutTime());
				model.put("id", "0");
				model.put("queryRecord", queryRecord);
				model.put("money", money);
			}else {
				model.put("id", "2");
				model.put("queryRecord", "");
				model.put("money", "");
			}
		}else {
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
		//传入session
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("mechineId", mechineId);
		session.setAttribute("carNo", carNo);
		session.setAttribute("out_trade_no", out_trade_no);
		session.setAttribute("subject", subject);
		session.setAttribute("total_amount", total_amount);
		session.setAttribute("body", body);
				
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
			//model.put("result", result);
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.put("result", result);
		return model;
	}
	
	@RequestMapping("/search.action")
	@ResponseBody
	public JSONObject searchCar(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("carNum");
		JSONObject obj = new JSONObject();
		Place searchCar = paymentService.searchCar(name);
		if(searchCar != null) {
			obj.put("id", 0);
			obj.put("car", searchCar);
		}else {
			obj.put("id", 1);
			obj.put("message", "未查找到车子");
		}
		return obj;
	}
	
	/*
	 * 支付成功
	 */
	@RequestMapping("/returnUrl")
	@ResponseBody
	public ModelAndView  returnUrl(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Object objId = session.getAttribute("id");
		Object objAmount = session.getAttribute("total_amount");
		Object objMechineId = session.getAttribute("mechineId");
		Object objCarNo = session.getAttribute("carNo");
		Object objTradeno = session.getAttribute("out_trade_no");
		Object objSubject = session.getAttribute("subject");
		Object objBody = session.getAttribute("body");
		Object objCometime = session.getAttribute("comeTime");
		Object objOuttime = session.getAttribute("outTime");
		String id = objId.toString();
		String total_amount = objAmount.toString();
		String mechineId = objMechineId.toString();
		String carNo = objCarNo.toString();
		String out_trade_no = objTradeno.toString();
		String subject = objSubject.toString();
		String body = objBody.toString();
		String comeTime = objCometime.toString();
		String outTime = objOuttime.toString();
		Integer idInt = Integer.valueOf(id);
		Integer mechineIdInt = Integer.valueOf(mechineId);
		Integer total_amount_int = Integer.valueOf(total_amount);
		//record表state改成-1
		Integer deleteRecord = paymentService.deleteRecord(idInt);
		//插入MACHINE_LOG表日志
		Integer addMechineLog = paymentService.addMechineLog(mechineIdInt, carNo, total_amount_int);
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "老子回来了");
		mv.addObject("id", id);
		mv.addObject("total_amount", total_amount);
		mv.addObject("carNo", carNo);
		mv.addObject("out_trade_no", out_trade_no);
		mv.addObject("subject", subject);
		mv.addObject("body", body);
		mv.addObject("comeTime", comeTime);
		mv.addObject("outTime", outTime);
		mv.setViewName("payment");
		return mv;
	}
	
}
