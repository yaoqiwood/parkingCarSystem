/**
 * 
 */
package com.example.service.impl;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.DailyAccount;
import com.example.dao.DailyAccountMapper;
import com.example.service.DailyAccountService;

/**
 * <p>Title:DailyAccountServiceImpl</p>
 * <p>Description:日结算service实现类</p>
 * <p>DevelopTools:Eclipse_x64_v4.7.1</p>
 * <p>DevelopSystem : macOS Sierra 10.12.1</p>
 * <p>Company : org.xiongyi</p>
 * @author:XiongYi
 * @date:2019年2月22日 下午2:28:38
 * @version:12.0.0
 */
@Service
public class DailyAccountServiceImpl implements DailyAccountService{
	
	@Autowired
	private DailyAccountMapper dailyAccountMapper;
	
	/* (non-Javadoc)
	 * @see com.example.service.DailyAccountService#addDailyAccount(com.example.bean.DailyAccount)
	 */
	@Override
	public Integer addDailyAccount(DailyAccount dailyAccount) {
		// TODO Auto-generated method stub
		Integer flag = dailyAccountMapper.addDailyAccount(dailyAccount);
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.example.service.DailyAccountService#dailyAccountPage(java.lang.String, org.apache.ibatis.session.RowBounds)
	 */
	@Override
	public ArrayList<DailyAccount> dailyAccountPage(String time, RowBounds rb) {
		// TODO Auto-generated method stub
		ArrayList<DailyAccount> accList = dailyAccountMapper.dailyAccountPage(time, rb);
		return accList;
	}

	/* (non-Javadoc)
	 * @see com.example.service.DailyAccountService#count(java.lang.String)
	 */
	@Override
	public Integer count(String time) {
		// TODO Auto-generated method stub
		Integer count = dailyAccountMapper.count(time);
		return count;
	}

	/* (non-Javadoc)
	 * @see com.example.service.DailyAccountService#checkDailyAccount(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer checkDailyAccount(String time,String startTime,String endTime) {
		// TODO Auto-generated method stub
		Integer flag = dailyAccountMapper.checkDailyAccount(time,startTime,endTime);
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.example.service.DailyAccountService#sumDailyAccount(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer sumDailyAccount(String startTime, String endTime) {
		// TODO Auto-generated method stub
		Integer sum = dailyAccountMapper.sumDailyAccount(startTime, endTime);
		return sum;
	}

	/* (non-Javadoc)
	 * @see com.example.service.DailyAccountService#showDailyAccount()
	 */
	@Override
	public ArrayList<DailyAccount> showDailyAccount() {
		// TODO Auto-generated method stub
		ArrayList<DailyAccount> accountList = dailyAccountMapper.showDailyAccount();
		return accountList;
	}

	/* (non-Javadoc)
	 * @see com.example.service.DailyAccountService#showDailyAccountDate()
	 */
	@Override
	public ArrayList<String> showDailyAccountDate() {
		// TODO Auto-generated method stub
		ArrayList<String> dateList = dailyAccountMapper.showDailyAccountDate();
		return dateList;
	}

}
