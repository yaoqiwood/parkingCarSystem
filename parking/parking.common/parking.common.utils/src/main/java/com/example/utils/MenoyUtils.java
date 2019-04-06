package com.example.utils;

import java.util.ArrayList;
import java.util.Date;


public class MenoyUtils {
	
	public static Integer sumOfMoney(Date startDate, Date endDate,ArrayList<String> timeList,ArrayList<Integer> moneyList) {
		Integer time = Integer.valueOf((int) ((endDate.getTime() - startDate.getTime())/1000));
		if(time<30*60) {
			return 10;
		}
		ArrayList<Integer> startTime=new ArrayList<Integer>();
		for(int i =0;i<timeList.size();i++) {
			startTime.add(Integer.valueOf((timeList.get(i).split("-")[0])));
		}
		Integer money = 0;
		for(int i = startTime.size()-1;i>=0;i--) {
			if(time-startTime.get(i)<0) {
				continue;
			}
			money += ((time-startTime.get(i))/3600)*moneyList.get(i);
			time = startTime.get(i);
		}
		return money;
	}
	
	public static Integer sumOfMoney(Date startDate, Date endDate) {
		long time = endDate.getTime() - startDate.getTime();
		if(time <= 30*60*1000) {
			return 5;
		}else if( time <= 3*60*60*1000 ){
			return 10;
		}else if( time <= 5*60*60*1000){
			time -= 3*60*60*1000;
			double hour = (double)time/((double)3600*1000);
			if( hour - (int)hour > 0) {
				hour += 1; 
			}
			return 10+(int)hour*5;
		}else if( time <= 8*60*60*1000){
			time -= 5*60*60*1000;
			double hour = (double)time/((double)3600*1000);
			if( hour - (int)hour > 0) {
				hour += 1; 
			}
			return 10+2*5+(int)hour*10;
		}else {
			return 80;
		}
	}

}
