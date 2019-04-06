/**
 * 
 */
package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.DailyAccount;
import com.example.service.AmountLogService;
import com.example.service.DailyAccountService;
import com.google.gson.JsonObject;

/**
 * <p>
 * Title:DailyAccountController
 * </p>
 * <p>
 * Description:日结算控制层类
 * </p>
 * <p>
 * DevelopTools:Eclipse_x64_v4.7.1
 * </p>
 * <p>
 * DevelopSystem : macOS Sierra 10.12.1
 * </p>
 * <p>
 * Company : org.xiongyi
 * </p>
 * 
 * @author:XiongYi
 * @date:2019年2月22日 下午2:37:14
 * @version:12.0.0
 */
@Controller
public class DailyAccountController {
	@Autowired
	private DailyAccountService dailyAccountService;

	@Autowired
	private AmountLogService amountLogService;
	
	/**
	 * 日结分页显示
	 * 
	 * @param time
	 * @param rowPage
	 * @param pageCount
	 * @return
	 */
	@RequestMapping("/dailyAccountPage.action")
	@ResponseBody
	public JSONObject dailyAccountPage(String time, String rowPage, String pageCount) {
		Integer page = Integer.valueOf(pageCount);
		Integer limit = Integer.valueOf(rowPage);
		RowBounds rs = new RowBounds((page - 1) * limit, limit);
		ArrayList<DailyAccount> accList = dailyAccountService.dailyAccountPage(time, rs);
		Integer count = dailyAccountService.count(time);
		JSONObject data = new JSONObject();
		data.put("list", accList);
		data.put("count", count);
		return data;
	}

	@RequestMapping("/automaticDailyAccount.action")
	@ResponseBody
	public JSONObject automaticDailyAccount() {
//		timer();
//		timeTask.doJob();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sysTime = dt.format(new Date());// 系统时间
		String middleTime = df.format(new Date()) + " " + "00:00:00";// 中班结算点
		String nightTime = df.format(new Date()) + " " + "08:00:00";// 晚班结算点
		String moringTime = df.format(new Date()) + " " + "16:00:00";// 早班结算点
		JSONObject data = new JSONObject();
		if (isTime(sysTime, middleTime, nightTime)) {
			String startTime = df.format(new Date()) + " " + "00:00:00";
			String endTime = operDate(df.format(new Date()), 1) + " " + "00:00:00";
			String className = "中班";
			Integer res = dailyAccountService.checkDailyAccount(className, startTime, endTime);
			if (res == 0) {
				data.put("type", 2);
				data.put("message", "昨天中班未结算，是否结算？");
			}
		} else if (isTime(sysTime, nightTime, moringTime)) {
			String startTime = df.format(new Date()) + " " + "00:00:00";
			String endTime = operDate(df.format(new Date()), 1) + " " + "00:00:00";
			String className = "晚班";
			Integer res = dailyAccountService.checkDailyAccount(className, startTime, endTime);
			if (res == 0) {
				data.put("type", 2);
				data.put("message", "今天晚班未结算，是否结算？");
			}
		} else if (isTime(sysTime, moringTime) == 1) {
			String startTime = df.format(new Date()) + " " + "00:00:00";
			String endTime = operDate(df.format(new Date()), 1) + " " + "00:00:00";
			String className = "早班";
			Integer res = dailyAccountService.checkDailyAccount(className, startTime, endTime);
			if (res == 0) {
				data.put("type", 2);
				data.put("message", "今天早班未结算，是否结算？");
			}
		}

		return data;
	}

	@RequestMapping("/automaticAccount.action")
	@ResponseBody
	public JSONObject automaticAccount() {
		JSONObject data = new JSONObject();
		DailyAccount dailyAccount = new DailyAccount();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sysTime = dt.format(new Date());// 系统时间
		String middleTime = df.format(new Date()) + " " + "00:00:00";// 中班结算点
		String nightTime = df.format(new Date()) + " " + "08:00:00";// 晚班结算点
		String moringTime = df.format(new Date()) + " " + "16:00:00";// 早班结算点
		if (isTime(sysTime, middleTime, nightTime)) {
			String yesMoringTime = operDate(df.format(new Date()), -1) + " " + "16:00:00";
			Integer ret = amountLogService.sumAmountLog(yesMoringTime, middleTime);
			if (ret == null) {
				ret = 0;
			}
			String time = "中班";
			dailyAccount.setDailyAccountTime(time);
			dailyAccount.setDailyAccountDate(df.format(new Date()));
			dailyAccount.setDailyAccountMoney(ret);
			dailyAccountService.addDailyAccount(dailyAccount);
			data.put("type", 1);
			data.put("message", "中班结算成功");
		} else if (isTime(sysTime, nightTime, moringTime)) {
			Integer ret = amountLogService.sumAmountLog(middleTime, nightTime);
			if (ret == null) {
				ret = 0;
			}
			String time = "晚班";
			dailyAccount.setDailyAccountTime(time);
			dailyAccount.setDailyAccountDate(df.format(new Date()));
			dailyAccount.setDailyAccountMoney(ret);
			dailyAccountService.addDailyAccount(dailyAccount);
			data.put("type", 1);
			data.put("message", "晚班结算成功");
		} else if (isTime(sysTime, moringTime) == 1) {
			Integer ret = amountLogService.sumAmountLog(nightTime, moringTime);
			if (ret == null) {
				ret = 0;
			}
			String time = "早班";
			dailyAccount.setDailyAccountTime(time);
			dailyAccount.setDailyAccountDate(df.format(new Date()));
			dailyAccount.setDailyAccountMoney(ret);
			dailyAccountService.addDailyAccount(dailyAccount);
			data.put("type", 1);
			data.put("message", "早班结算成功");
		}
		return data;
	}
	
	@RequestMapping("/showECharts.action")
	@ResponseBody
	public JSONObject showECharts() {
		ArrayList<DailyAccount> accountList = dailyAccountService.showDailyAccount();
		ArrayList<String> dateList = dailyAccountService.showDailyAccountDate();
		ArrayList<Integer> morList = new ArrayList<Integer>();
		ArrayList<Integer> midList = new ArrayList<Integer>();
		ArrayList<Integer> nigList = new ArrayList<Integer>();
		for(int i = 0; i<accountList.size();i++) {
			if(accountList.get(i).getDailyAccountTime().equals("早班")) {
				morList.add(accountList.get(i).getDailyAccountMoney());
			}else if(accountList.get(i).getDailyAccountTime().equals("中班")) {
				midList.add(accountList.get(i).getDailyAccountMoney());
			}else {
				nigList.add(accountList.get(i).getDailyAccountMoney());
			}
			
		}
		JSONObject data = new JSONObject();
		data.put("dateList", dateList);
		data.put("morList", morList);
		data.put("midList", midList);
		data.put("nigList", nigList);
		return data;
	}

	/**
	 * 判断时间的方法
	 * 
	 * @param st        系统时间
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @return true(系统时间在开始时间和结束时间中间)
	 */
	public boolean isTime(String st, String startTime, String endTime) {
		boolean flag = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date sysdate;
		try {
			sysdate = sdf.parse(st);
			Date sTime = sdf.parse(startTime);
			Date eTime = sdf.parse(endTime);
			int compareToStime = sysdate.compareTo(sTime);
			int compareToEtime = sysdate.compareTo(eTime);
			if (compareToStime == 1 && compareToEtime == -1) {
				flag = true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 判断时间的方法
	 * 
	 * @param st        系统时间
	 * @param startTime 比较时间
	 * @return -1 系统时间小于比较时间 0 等于 1 小于
	 */
	public Integer isTime(String st, String startTime) {
		Integer flag = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date sysdate;
		try {
			sysdate = sdf.parse(st);
			Date sTime = sdf.parse(startTime);
			int compareToStime = sysdate.compareTo(sTime);
			if (compareToStime == 1) {
				flag = 1;
			} else if (compareToStime == 0) {
				flag = 0;
			} else {
				flag = -1;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public String operDate(String str, int day) {
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

	// Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
	public void timer() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 8); // 控制时
		calendar.set(Calendar.MINUTE, 0); // 控制分
		calendar.set(Calendar.SECOND, 0); // 控制秒
		Date time = calendar.getTime(); // 得出执行任务的时间,此处为今天的8：00：00
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				DailyAccount dailyAccount = new DailyAccount();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String sysTime = dt.format(new Date());// 系统时间
				String middleTime = df.format(new Date()) + " " + "00:00:00";// 中班结算点
				String nightTime = df.format(new Date()) + " " + "08:00:00";// 晚班结算点
				String moringTime = df.format(new Date()) + " " + "16:00:00";// 早班结算点
				String testTime = df.format(new Date()) + " " + "16:20:00";// 测试结算点
				if (isTime(sysTime, middleTime) == 0) {
					String yesMoringTime = operDate(df.format(new Date()), -1) + " " + "16:00:00";
					Integer ret = amountLogService.sumAmountLog(yesMoringTime, middleTime);
					if (ret == null) {
						ret = 0;
					}
					String time = "中班";
					dailyAccount.setDailyAccountTime(time);
					dailyAccount.setDailyAccountMoney(ret);
					dailyAccountService.addDailyAccount(dailyAccount);
				} else if (isTime(sysTime, nightTime) == 0) {
					Integer ret = amountLogService.sumAmountLog(middleTime, nightTime);
					if (ret == null) {
						ret = 0;
					}
					String time = "晚班";
					dailyAccount.setDailyAccountTime(time);
					dailyAccount.setDailyAccountMoney(ret);
					dailyAccountService.addDailyAccount(dailyAccount);
				} else if (isTime(sysTime, moringTime) == 0) {
					Integer ret = amountLogService.sumAmountLog(nightTime, moringTime);
					if (ret == null) {
						ret = 0;
					}
					String time = "早班";
					dailyAccount.setDailyAccountTime(time);
					dailyAccount.setDailyAccountMoney(ret);
					dailyAccountService.addDailyAccount(dailyAccount);
				} else if(isTime(sysTime, testTime) == 0) {
					System.out.println("开心到爆炸");
				}
			}
		}, time, 1000 * 60 * 1);// 这里设定将延时每天固定执行
	}
}
