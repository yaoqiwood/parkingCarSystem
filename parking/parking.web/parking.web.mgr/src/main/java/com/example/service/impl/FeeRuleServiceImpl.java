package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.FeeRule;
import com.example.dao.FeeRuleMapper;
import com.example.service.FeeRuleService;
import com.example.utils.CheckInfoUtils;

/**
 * 停车规则费用服务接口 Title : FeeRuleServiceImpl Description : DevelopTools :
 * Eclipse_x64 DevelopSystem : Win10 Company : org.NorwegianWoods
 * 
 * @author : CatWood
 * @date : Feb 21, 2019 6:26:41 PM
 * @version : 12.0.0
 */

@Service
public class FeeRuleServiceImpl implements FeeRuleService {

	@Autowired
	private FeeRuleMapper feeRuleMapper;

	@Override
	public List<FeeRule> refFeeRuleView(String ruleMoney, String begin, String end) {
		// TODO Auto-generated method stub
		// 检查是否为空
		if (CheckInfoUtils.isEmpty(begin) || CheckInfoUtils.isEmpty(end))
			return null;

		Integer money = null;
		if (!ruleMoney.equals("")) {
			money = Integer.parseInt(ruleMoney);
		}
		List<FeeRule> feeRules = feeRuleMapper.refFeeRuleView(money,begin, end);
		return feeRules;
	}

	/*
	 * (non-Javadoc) 统计停车费用配置表数量
	 * 
	 * @see com.example.service.FeeRuleService#cntFeeRuleView(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Integer cntFeeRuleView(String ruleMoney) {
		// TODO Auto-generated method stub
		Integer money = null;
		if (!ruleMoney.equals("")) {
			money = Integer.parseInt(ruleMoney);
		}

		Integer Count = feeRuleMapper.cntFeeRuleView(money);
		return Count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.service.FeeRuleService#insertFeeRuleView(java.lang.String,
	 * java.lang.Integer)
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer insertFeeRuleView(String time, Integer ruleHourMoney) {
		// TODO Auto-generated method stub

		Integer ret = feeRuleMapper.insertFeeRuleView(time, ruleHourMoney);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.service.FeeRuleService#upFeeRuleView(java.lang.Integer,
	 * java.lang.String, java.lang.Integer)
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer upFeeRuleView(Integer upRuleID, String time, Integer upRuleMoney) {
		// TODO Auto-generated method stub
		Integer ret = feeRuleMapper.upFeeRuleView(upRuleID, time, upRuleMoney);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.service.FeeRuleService#upStateFeeRuleView(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer upStateFeeRuleView(Integer upState, Integer Fid) {
		// TODO Auto-generated method stub
		Integer ret = feeRuleMapper.upStateFeeRuleView(upState, Fid);

		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.service.FeeRuleService#delFeeRuleView(java.lang.Integer)
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer delFeeRuleView(Integer Fid) {
		// TODO Auto-generated method stub
		// 假删除为9
		Integer ret = feeRuleMapper.upStateFeeRuleView(9, Fid);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.service.FeeRuleService#viewTimesPeriod(java.lang.String)
	 */
	@Override
	public List<String> viewTimesPeriod(String upRuleID) {
		// TODO Auto-generated method stub
		
		Integer tempRuleID = null;
		if (!upRuleID.equals("") && upRuleID !=null ) {
			tempRuleID = Integer.parseInt(upRuleID);
		}
		List<String> times = feeRuleMapper.viewTimesPeriod(tempRuleID);
		System.out.println(times);
		return times;
	}

	/* (non-Javadoc)
	 * @see com.example.service.FeeRuleService#checkReTimes(java.lang.String)
	 */
	@Override
	public Integer checkReTimes(String time) {
		// TODO Auto-generated method stub
		Integer Count = feeRuleMapper.checkReTimes(time);
		return Count;
	}

	/* (non-Javadoc)
	 * @see com.example.service.FeeRuleService#viewSinFeeRule(java.lang.String)
	 */
	@Override
	public FeeRule viewSinFeeRule(String feeRuleId) {
		// TODO Auto-generated method stub
		FeeRule feeRule = feeRuleMapper.viewSinFeeRule(feeRuleId);
		return feeRule;
	}

	/* (non-Javadoc)
	 * @see com.example.service.FeeRuleService#VTaddFeeRuleView()
	 */
	@Override
	public Integer VTaddFeeRuleView() {
		// TODO Auto-generated method stub
		Integer maxT = feeRuleMapper.viewMaxTFeeRule();
		return maxT;
	}

	/* (non-Javadoc)
	 * @see com.example.service.FeeRuleService#viewMaxSFeeRule()
	 */
	@Override
	public FeeRule viewMaxTFeeRuleForCol() {
		// TODO Auto-generated method stub
		FeeRule feeRule = feeRuleMapper.viewMaxTFeeRuleForCol();
		return feeRule;
	}

	/* (non-Javadoc)
	 * @see com.example.service.FeeRuleService#selectFeeRule()
	 */
	@Override
	public ArrayList<FeeRule> selectFeeRule() {
		// TODO Auto-generated method stub
		ArrayList<FeeRule> feeRuleList = feeRuleMapper.selectFeeRule();
		return feeRuleList;
	}

}
