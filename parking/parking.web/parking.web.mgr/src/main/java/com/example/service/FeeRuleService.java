package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.FeeRule;


public interface FeeRuleService {
	
	/**
	 * 查看停车费用配置表
	 * @param begin
	 * @param end
	 * @return
	 */
	List<FeeRule> refFeeRuleView(String ruleMoney,String begin, String end);
	
	/**
	 * 统计停车费用配置表数量
	 * @param ruleMoney
	 * @param time
	 * @return
	 */
	Integer cntFeeRuleView(String ruleMoney);
	
	/**
	 * 添加停车费用规则条目
	 * @param time
	 * @param ruleHourMoney
	 * @return
	 */
	Integer insertFeeRuleView(String time, Integer ruleHourMoney);
	
	/**
	 * 修改停车费用规则条目
	 * @param upRuleID
	 * @param time
	 * @param upRuleMoney
	 * @return
	 */
	Integer upFeeRuleView(Integer upRuleID,String time,Integer upRuleMoney);
	
	/**
	 * 修改停车费用规则状态
	 * @param upState
	 * @param Fid
	 * @return
	 */
	Integer upStateFeeRuleView(Integer upState,Integer Fid);
	
	/**
	 * 删除（假删除）
	 * @param Fid
	 * @return
	 */
	Integer delFeeRuleView(Integer Fid);
	
	/**
	 * 查时间区间
	 * @param 
	 * @return
	 */
	List<String> viewTimesPeriod(String upRuleID);
	
	/**
	 * 查看是否有重复的时间
	 * @param time
	 * @return
	 */
	Integer checkReTimes(String time);
	
	/**
	 * 查看当前ID下所有规则信息
	 * @param feeRuleId
	 * @return
	 */
	FeeRule viewSinFeeRule(String feeRuleId);
	
	/**
	 * 查看当前最大时间规则数
	 * @return
	 */
	Integer VTaddFeeRuleView();
	
	/**
	 * 查看当前最大开始时间行
	 * @return
	 */
	FeeRule viewMaxTFeeRuleForCol();
	
	/**
	 * 查询所有规则
	 * @return 规则的集合
	 */
	ArrayList<FeeRule> selectFeeRule();
}
