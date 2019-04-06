package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.bean.FeeRule;

public interface FeeRuleMapper {
	/**
	 * 查询停车费用规则表格用
	 * 
	 * @param ruleMoney
	 * @param time
	 * @param begin
	 * @param end
	 * @return
	 */
	List<FeeRule> refFeeRuleView(@Param("ruleMoney") Integer ruleMoney, @Param("begin") String begin, @Param("end") String end);

	/**
	 * 统计停车费用规则表行数量
	 * 
	 * @param ruleMoney
	 * @param time
	 * @return
	 */
	Integer cntFeeRuleView(@Param("ruleMoney") Integer ruleMoney);

	/**
	 * 添加停车费用规则条目
	 * 
	 * @param time
	 * @param ruleHourMoney
	 * @return
	 */
	Integer insertFeeRuleView(@Param("time") String time, @Param("ruleHourMoney") Integer ruleHourMoney);

	/**
	 * 修改停车费用规则条目
	 * 
	 * @param upRuleID
	 * @param time
	 * @param upRuleMoney
	 * @return
	 */
	Integer upFeeRuleView(@Param("upRuleID") Integer upRuleID, @Param("time") String time,
			@Param("upRuleMoney") Integer upRuleMoney);

	/**
	 * 修改停车费用规则状态
	 * 
	 * @param upState
	 * @param Fid
	 * @return
	 */
	Integer upStateFeeRuleView(@Param("upState") Integer upState, @Param("Fid") Integer Fid);

	/**
	 * 查所有时段
	 * @return
	 */
	List<String> viewTimesPeriod(@Param("upRuleID") Integer upRuleID);

	/**
	 * 查重复时间
	 * @param time
	 * @return
	 */
	Integer checkReTimes(@Param("time") String time);
	
	/**
	 * 查规则ID相关信息
	 * @param feeRuleId
	 * @return
	 */
	FeeRule viewSinFeeRule(@Param("feeRuleId") String feeRuleId);
	
	/**
	 * 
	 * @return
	 */
	List<FeeRule> feeRuleInfo(); 	
}
