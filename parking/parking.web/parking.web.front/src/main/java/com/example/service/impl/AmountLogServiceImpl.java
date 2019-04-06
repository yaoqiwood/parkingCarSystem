package com.example.service.impl;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.AdminAmountLog;
import com.example.bean.AmountLog;
import com.example.bean.CarService;
import com.example.bean.MechineLog;
import com.example.bean.SumManual;
import com.example.dao.AmountLogMapper;
import com.example.service.AmountLogService;
/**
 * 
  * <p>Title : AmountLogServiceImpl</p>
  * <p>Description : 收支明细实现类</p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月23日 上午8:47:49
  * @version : 12.0.0
 */
@Service
public class AmountLogServiceImpl implements AmountLogService{
	
	@Autowired
	private AmountLogMapper amountLogMapper;
	/**
	 * 总收入
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer sumAmount() {
		// TODO Auto-generated method stub
		Integer sumAmount = amountLogMapper.sumAmount();
		System.out.println("sumAmount= "+sumAmount);
		return sumAmount;
	}
	/**
	 * 总停车数
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer countAmount() {
		// TODO Auto-generated method stub
		Integer countAmount = amountLogMapper.countAmount();
		System.out.println("countAmount= "+countAmount);
		return countAmount;
	}
	/**
	 * 临时用户数
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer sumCasual() {
		// TODO Auto-generated method stub
		Integer sumCasual = amountLogMapper.sumCasual();
		System.out.println("sumCasual= "+sumCasual);
		return sumCasual;
	}
	/**
	 * 月缴用户数
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer sumMonth() {
		// TODO Auto-generated method stub
		Integer sumMonth = amountLogMapper.sumMonth();
		System.out.println("sumMonth= "+sumMonth);
		return sumMonth;
	}
	/**
	 * 终端用户
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer sumTerminal() {
		// TODO Auto-generated method stub
		Integer sumTerminal = amountLogMapper.sumTerminal();
		System.out.println("sumTerminal= "+sumTerminal);
		return sumTerminal;
	}
	/**
	 * 人工用户
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer sumManual() {
		// TODO Auto-generated method stub
		Integer sumManual = amountLogMapper.sumManual();
		System.out.println("sumManual= "+sumManual);
		return sumManual;
	}
	/* (non-Javadoc)
	 * @see com.example.service.AmountLogService#sumAmountLog(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer sumAmountLog(String startTime, String endTime) {
		// TODO Auto-generated method stub
		Integer flag = amountLogMapper.sumAmountLog(startTime, endTime);
		return flag;
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<AmountLog> queryIncome(String offset, String limit) {
		// TODO Auto-generated method stub
		RowBounds rb = new RowBounds(Integer.parseInt(offset)-1,Integer.parseInt(limit));
		List<AmountLog> queryIncome = amountLogMapper.queryIncome(rb);
		for (AmountLog amountLog : queryIncome) {
			System.out.println(amountLog.toString());
		}
		return queryIncome;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer countIncome() {
		// TODO Auto-generated method stub
		Integer countIncome = amountLogMapper.countIncome();
		System.out.println("countIncome= "+countIncome);
		return countIncome;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<AmountLog> queryIncomeMonth(String offset, String limit) {
		// TODO Auto-generated method stub
		RowBounds rb = new RowBounds(Integer.parseInt(offset)-1,Integer.parseInt(limit));
		List<AmountLog> queryIncomeMonth = amountLogMapper.queryIncomeMonth(rb);
		for (AmountLog amountLog : queryIncomeMonth) {
			System.out.println(amountLog.toString());
		}
		return queryIncomeMonth;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer countIncomeMonth() {
		// TODO Auto-generated method stub
		Integer countIncomeMonth = amountLogMapper.countIncomeMonth();
		System.out.println("countIncomeMonth= "+countIncomeMonth);
		return countIncomeMonth;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<CarService> queryIncomeProduct(String offset, String limit) {
		// TODO Auto-generated method stub
		RowBounds rb = new RowBounds(Integer.parseInt(offset)-1,Integer.parseInt(limit));
		List<CarService> queryIncomeProduct = amountLogMapper.queryIncomeProduct(rb);
		for (CarService carService : queryIncomeProduct) {
			System.out.println(carService.toString());
		}
		return queryIncomeProduct;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer countIncomeProduct() {
		// TODO Auto-generated method stub
		Integer countIncomeProduct = amountLogMapper.countIncomeProduct();
		System.out.println("countIncomeProduct= "+countIncomeProduct);
		return countIncomeProduct;
	}
	@Override
	public Integer sumProduct(String name) {
		// TODO Auto-generated method stub
		Integer sumProduct = amountLogMapper.sumProduct(name);
		System.out.println("sumProduct= "+sumProduct);
		return sumProduct;
	}
	@Override
	public List<MechineLog> queryIncomeMechine(String offset, String limit) {
		// TODO Auto-generated method stub
		RowBounds rb = new RowBounds(Integer.parseInt(offset)-1,Integer.parseInt(limit));
		List<MechineLog> queryIncomeMechine = amountLogMapper.queryIncomeMechine(rb);
		for (MechineLog mechineLog : queryIncomeMechine) {
			System.out.println(mechineLog.toString());
		}
		return queryIncomeMechine;
	}
	@Override
	public Integer countIncomeMechine() {
		// TODO Auto-generated method stub
		Integer countIncomeMechine = amountLogMapper.countIncomeMechine();
		System.out.println("countIncomeMechine= "+countIncomeMechine);
		return countIncomeMechine;
	}
	@Override
	public Integer sumMechine(Integer id) {
		// TODO Auto-generated method stub
		Integer sumMechine = amountLogMapper.sumMechine(id);
		System.out.println("sumMechine= "+sumMechine);
		return sumMechine;
	}
	@Override
	public List<SumManual> sumIncomeManual() {
		// TODO Auto-generated method stub
		List<SumManual> sumIncomeManual = amountLogMapper.sumIncomeManual();
		for (SumManual sumManual : sumIncomeManual) {
			System.out.println(sumManual.toString());
		}
		return sumIncomeManual;
	}
	@Override
	public List<AmountLog> queryIncomeManual(String offset, String limit) {
		// TODO Auto-generated method stub
		RowBounds rb = new RowBounds(Integer.parseInt(offset)-1,Integer.parseInt(limit));
		List<AmountLog> queryIncomeManual = amountLogMapper.queryIncomeManual(rb);
		for (AmountLog amountLog : queryIncomeManual) {
			System.out.println(amountLog.toString());
		}
		return queryIncomeManual;
	}
	@Override
	public Integer countIncomeManual() {
		// TODO Auto-generated method stub
		Integer countIncomeManual = amountLogMapper.countIncomeManual();
		System.out.println("countIncomeManual= "+countIncomeManual);
		return countIncomeManual;
	}
	
	
}
