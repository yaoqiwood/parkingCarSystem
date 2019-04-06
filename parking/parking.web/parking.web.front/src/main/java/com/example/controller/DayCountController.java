/**
 * 
 */
package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.management.openmbean.OpenDataException;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.DayCount;
import com.example.service.DailyAccountService;
import com.example.service.DayCountService;

/**
 * <p>Title:DayCountController</p>
 * <p>Description:自动日结算</p>
 * <p>DevelopTools:Eclipse_x64_v4.7.1</p>
 * <p>DevelopSystem : macOS Sierra 10.12.1</p>
 * <p>Company : org.xiongyi</p>
 * @author:XiongYi
 * @date:2019年2月23日 下午3:33:35
 * @version:12.0.0
 */
@Controller
public class DayCountController {
	@Autowired
	private DailyAccountService dailyAccountService;
	
	@Autowired
	private DayCountService dayCountService;
	
	/**
	 * 日结算分页显示
	 * @param startTime 起始时间
	 * @param endTime 结束时间
	 * @param rowPage 每页显示条数
	 * @param pageCount 当前页数
	 * @return json
	 */
	@RequestMapping("/dayCountPage.action")
	@ResponseBody
	public JSONObject dayCountPage(String startTime,String endTime,String rowPage,String pageCount) {
		Integer page = Integer.valueOf(pageCount);
		Integer limit = Integer.valueOf(rowPage);
		RowBounds rs = new RowBounds((page - 1) * limit, limit);
		ArrayList<DayCount> dayCountList = dayCountService.dayCountPage(startTime, endTime, rs);
		Integer count = dayCountService.count(startTime, endTime);
		JSONObject data = new JSONObject();
		data.put("list", dayCountList);
		data.put("count", count);
		return data;
	}
	
	/**
	 * 一天结算
	 * @return json
	 */
	@RequestMapping("/addDayCount.action")
	@ResponseBody
	public JSONObject addDayCount() {
		System.out.println("111");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String st = df.format(new Date());
		String yesDay = operDate(st,-1);
		JSONObject data = new JSONObject();
		try {
			Date day = df.parse(yesDay);
			Integer res = dayCountService.checkDayCount(day);
			if(res==0) {
				data.put("type", 1);
				data.put("message", "昨日未结算，是否结算");
//				Integer sum = dailyAccountService.sumDailyAccount(startTime, endTime);
//				if(sum==null) {
//					sum=0;
//				}
//				DayCount dayCount = new DayCount(null, day, sum, 1, null, null);
//				Integer flag = dayCountService.addDayCount(dayCount);
//				if(flag==0) {
//					data.put("type", 0);
//					data.put("message", "结算失败");
//				}else {
//					data.put("type", 1);
//					data.put("message", "结算成功");
//				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * 结算
	 * @return json
	 * @throws ParseException 
	 */
	@RequestMapping("/automaticDayAccount.action")
	@ResponseBody
	public JSONObject automaticDayAccount() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String st = df.format(new Date());
		String yesDay = operDate(st,-1);
		String startTime = yesDay + " " + "00:00:00";
		String endTime = st + " " + "00:00:00";
		JSONObject data = new JSONObject();
		Date day = df.parse(yesDay);
		Integer sum = dailyAccountService.sumDailyAccount(startTime, endTime);
		if(sum==null) {
			sum=0;
		}
		DayCount dayCount = new DayCount(null, day, sum, 1, null, null);
		Integer flag = dayCountService.addDayCount(dayCount);
		if(flag==0) {
			data.put("type", 0);
			data.put("message", "结算失败");
		}else {
			data.put("type", 1);
			data.put("message", "结算成功");
		}
		return data;
	}
	
	@RequestMapping("/showLineCharts.action")
	@ResponseBody
	public JSONObject showLineCharts() {
		ArrayList<DayCount> list = dayCountService.selectDayCount();
		ArrayList<String> dayList = new ArrayList<String>();
		ArrayList<Integer> moneyList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			moneyList.add(list.get(i).getDayCountMoney());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String time = df.format(list.get(i).getDayCountTime());
			dayList.add(time);
		}
		JSONObject data = new JSONObject();
		data.put("moneyList", moneyList);
		data.put("dayList", dayList);
		return data;
	}
	
	/**
	 * 加减天数
	 * @param str 现在时间
	 * @param day 加或减天数
	 * @return 处理后时间
	 */
	public static String operDate(String str, int day) {
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
			// 当前日期
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");// 格式化对象
			Calendar calendar = Calendar.getInstance();// 日历对象
			calendar.setTime(date);// 设置当前日期
			calendar.add(Calendar.DAY_OF_MONTH, day);// 加、减
			return format.format(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
}
