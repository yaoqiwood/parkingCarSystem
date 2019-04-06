package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

@Controller
public class WelcomeController {

	/**
	 * 登录界面
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView welcomePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("frame");
		return mv;
	}

	/**
	 * 测试支付页面
	 * 
	 * @return alipay.trade.page.pay.jsp
	 */
	@RequestMapping("/alipays")
	public ModelAndView alipays() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alipays");
		return mv;
	}

	/**
	 * 支付页面
	 * 
	 * @return amechineLog.jsp
	 */
	@RequestMapping("/pays")
	public ModelAndView pays() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pays");
		return mv;
	}
	
	
	/**
	 * 缴费信息
	 * 
	 * @return
	 */
	@RequestMapping("/payment")
	public ModelAndView payment() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("payment");
		return mv;
	}
	

	/**
	 * 支付页面
	 * @return 
	 */
	@RequestMapping("/parkState")
	public ModelAndView parkState() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("parkState");
		return mv;
	}
	
	/**
	 * 支付页面
	 * @return 
	 */
	@RequestMapping("/setcarnum.action")
	@ResponseBody
	public JSONObject setCarnum(String name,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		try {
			HttpSession session = request.getSession();
			session.setAttribute("carNum", name);
			obj.put("id", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			obj.put("id", 1);
		}
		return obj;
	}
	
	/**
	 * 支付页面
	 * @return 
	 */
	@RequestMapping("/hascarnum.action")
	@ResponseBody
	public JSONObject hasCarnum(HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		try {
			HttpSession session = request.getSession();
			String carNum = (String)session.getAttribute("carNum");
			if(carNum != null) {
				obj.put("id", 0);
				obj.put("carNum", carNum);
			}else {
				obj.put("id", 1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			obj.put("id", 1);
		}
		return obj;
	}
	
	/**
	 * 支付页面
	 * @return 
	 */
	@RequestMapping("/exitcarnum.action")
	@ResponseBody
	public JSONObject exitCarnum(HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			obj.put("id", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			obj.put("id", 1);
		}
		return obj;
	}
	
}
