/**
 * 
 */
package com.example.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.DayCount;
import com.example.dao.DailyAccountMapper;
import com.example.dao.DayCountMapper;
import com.example.service.DayCountService;

/**
 * <p>Title:DayCountServiceImpl</p>
 * <p>Description:自动日结算实现类</p>
 * <p>DevelopTools:Eclipse_x64_v4.7.1</p>
 * <p>DevelopSystem : macOS Sierra 10.12.1</p>
 * <p>Company : org.xiongyi</p>
 * @author:XiongYi
 * @date:2019年2月23日 下午4:24:41
 * @version:12.0.0
 */
@Service
public class DayCountServiceImpl implements DayCountService{
	
	@Autowired
	private DayCountMapper dayCountMapper;

	/* (non-Javadoc)
	 * @see com.example.service.DayCountService#dayCountPage(java.lang.String, java.lang.String, org.apache.ibatis.session.RowBounds)
	 */
	@Override
	public ArrayList<DayCount> dayCountPage(String startTime, String endTime, RowBounds rb) {
		// TODO Auto-generated method stub
		ArrayList<DayCount> dayCountList = dayCountMapper.dayCountPage(startTime, endTime, rb);
		return dayCountList;
	}

	/* (non-Javadoc)
	 * @see com.example.service.DayCountService#count(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer count(String startTime, String endTime) {
		// TODO Auto-generated method stub
		Integer flag = dayCountMapper.count(startTime, endTime);
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.example.service.DayCountService#addDayCount(com.example.bean.DayCount)
	 */
	@Override
	public Integer addDayCount(DayCount dayCount) {
		// TODO Auto-generated method stub
		Integer flag = dayCountMapper.addDayCount(dayCount);
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.example.service.DayCountService#checkDayCount(java.util.Date)
	 */
	@Override
	public Integer checkDayCount(Date time) {
		// TODO Auto-generated method stub
		Integer flag = dayCountMapper.checkDayCount(time);
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.example.service.DayCountService#selectDayCount()
	 */
	@Override
	public ArrayList<DayCount> selectDayCount() {
		// TODO Auto-generated method stub
		ArrayList<DayCount> list = dayCountMapper.selectDayCount();
		return list;
	}
	
	
}
