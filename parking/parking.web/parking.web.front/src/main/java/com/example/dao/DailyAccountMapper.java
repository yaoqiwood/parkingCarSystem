/**
 * 
 */
package com.example.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.example.bean.DailyAccount;

/**
 * <p>Title:dailyAccountMapper</p>
 * <p>Description:日结算dao</p>
 * <p>DevelopTools:Eclipse_x64_v4.7.1</p>
 * <p>DevelopSystem : macOS Sierra 10.12.1</p>
 * <p>Company : org.xiongyi</p>
 * @author:XiongYi
 * @date:2019年2月22日 上午10:49:41
 * @version:12.0.0
 */
public interface DailyAccountMapper {
	
	/**
	 * 日结算添加数据
	 * @param dailyAccount
	 * @return
	 */
	Integer addDailyAccount(@Param("dailyAccount") DailyAccount dailyAccount);
	
	/**
	 * 日结算分页
	 * @param time 班次名
	 * @param rowPage 每页显示条数
	 * @param pageCount 当前页
	 * @return DailyAccount对象集合
	 */
	ArrayList<DailyAccount> dailyAccountPage(@Param("time") String time,RowBounds rb);
	
	/**
	 * 日结算统计总条数
	 * @param time 班次名称
	 * @return 总条数
	 */
	Integer count(@Param("time") String time);
	
	/**
	 * 查看日结算是否结算
	 * @param time 班次名称
	 * @param startTime 起始时间
	 * @param endTime 终止时间
	 * @return 条数
	 */
	Integer checkDailyAccount(@Param("time") String time,@Param("startTime") String startTime,@Param("endTime") String endTime);
	
	/**
	 * 统计一天的金额
	 * @param startTime 起始时间
	 * @param endTime 终止时间
	 * @return 总金额
	 */
	Integer sumDailyAccount(@Param("startTime") String startTime,@Param("endTime") String endTime);
	
	/**
	 * 查找所有日结算数据
	 * @return DailyAccount对象集合
	 */
	ArrayList<DailyAccount> showDailyAccount();
	
	/**
	 * 查找不同的时间段日结算
	 * @return DailyAccount对象集合
	 */
	ArrayList<String> showDailyAccountDate();
}
