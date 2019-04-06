/**
 * 
 */
package com.example.service;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.example.bean.DayCount;

/**
 * <p>Title:DayCountService</p>
 * <p>Description:自动日结算</p>
 * <p>DevelopTools:Eclipse_x64_v4.7.1</p>
 * <p>DevelopSystem : macOS Sierra 10.12.1</p>
 * <p>Company : org.xiongyi</p>
 * @author:XiongYi
 * @date:2019年2月23日 下午4:23:03
 * @version:12.0.0
 */

public interface DayCountService {
	/**
	 * 自动日结算分页查询
	 * @param startTime 起始时间
	 * @param endTime 结束时间
	 * @param rb 控制页数
	 * @return DayCount的集合
	 */
	ArrayList<DayCount> dayCountPage(String startTime,String endTime,RowBounds rb);
	
	/**
	 * 自动日结算总条数查询
	 * @param startTime 起始时间
	 * @param endTime 结束时间
	 * @return 总条数
	 */
	Integer count(String startTime,String endTime);
	
	/**
	 * 添加
	 * @param dayCount 实体
	 * @return 0 1
	 */
	Integer addDayCount(DayCount dayCount);
	
	/**
	 * 判断是否结算
	 * @param time 结算日期
	 * @return 结算条数 0 1 
	 */
	Integer checkDayCount(Date time);
	
	/**
	 * 所有日统计数据
	 * @return DayCount的集合
	 */
	ArrayList<DayCount> selectDayCount();
}
