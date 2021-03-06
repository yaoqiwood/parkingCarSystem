package com.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * <p>Title : TimeUtils</p>
 * <p>Description : 有关世界的工具类</p>
 * <p>DevelopTools : Eclipse_x64_v4.9.0</p>
 * <p>DevelopSystem : window 10</p>
 * @author : Lian
 * @date : 2019年2月22日 下午7:09:25
 * @version : 1.0.0
 */
public class TimeUtils {
	
	/**
	 * 直接返回当前系统的时间
	 * @return	返回格式为"YYYY-MM-DD"的字符串
	 */
	public static String getYyyyMmDd() {
		 Date d = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 String dateNowStr = sdf.format(d);
		 return dateNowStr;
	}
	
	/**
	 * 判断时间先后 （前为开始时间，后为结束时间） 例如 13:00 15:00 则返回true 15：00 13：00 返回false
	 * @param timeStart
	 * @param timeEnd
	 * @return
	 * @throws ParseException
	 */
	public static boolean checkTimeBefore(String timeStart,String timeEnd) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
	    Date now = df.parse(df.format(new Date()));
	    Date begin = df.parse(timeStart);
	    Date end = df.parse(timeEnd);
	    Calendar nowTime = Calendar.getInstance();
	    nowTime.setTime(now);
	    Calendar beginTime = Calendar.getInstance();
	    beginTime.setTime(begin);
	    Calendar endTime = Calendar.getInstance();
	    endTime.setTime(end);
	    if (beginTime.before(endTime)) {
	    	return true;
	    }else {
			return false;
		}
	}
	
	/**
	 * 检查时间区间是否交集重叠
	 * @param fTStartStr
	 * @param fTEndStr
	 * @param eTStartStr
	 * @param eTEndStr
	 * @return
	 * @throws ParseException
	 */
	public static boolean checkTimeLaps(String fTStartStr, String fTEndStr, List<String> timePeriods) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		Date fFirstTime = df.parse(fTStartStr); // t1
		Date fEndTime = df.parse(fTEndStr); // t2
		for (String i : timePeriods) {
			String[] eTime = i.split("-");
			String eTStartStr = eTime[0];
			String eTEndStr = eTime[1];
			Date eStartTime = df.parse(eTStartStr); // t3
			Date eEndTime = df.parse(eTEndStr); // t4
			System.out.println(eTStartStr +"-"+ eTEndStr);
//			t3<t2 && t4>t1
			if (eStartTime.getTime() < fEndTime.getTime() && eEndTime.getTime() > fFirstTime.getTime()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 检查时间是否符合格式 23：59
	 * @param timeStr
	 * @return
	 */
	public static boolean checkTimeRule(String timeStr) {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		df.setLenient(false);
		try {
			df.parse(timeStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 格林威治时间转时分秒
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date parseGMT(String strDate) throws ParseException {
        if (strDate != null && strDate.trim().length() > 0) {
            strDate = strDate.substring(4,24).replace(" ","/");
            strDate = strDate.replace("Jan","01");
            strDate = strDate.replace("Feb","02");
            strDate = strDate.replace("Mar","03");
            strDate = strDate.replace("Apr","04");
            strDate = strDate.replace("May","05");
            strDate = strDate.replace("Jun","06");
            strDate = strDate.replace("Jul","07");
            strDate = strDate.replace("Aug","08");
            strDate = strDate.replace("Sep","09");
            strDate = strDate.replace("Oct","10");
            strDate = strDate.replace("Nov","11");
            strDate = strDate.replace("Dec","12");
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy/HH:mm:ss");
            Date date = sdf.parse(strDate);
            return date;
        }
        return null;
    }

	
	

}
