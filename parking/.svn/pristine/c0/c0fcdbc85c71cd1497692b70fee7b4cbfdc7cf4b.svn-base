package com.example.service;

import java.util.List;

import com.example.bean.AmountLog;
import com.example.bean.CarService;
import com.example.bean.MechineLog;
import com.example.bean.SumManual;

/**
 * 
  * <p>Title : AmountLogService</p>
  * <p>Description : 收支明细</p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月23日 上午8:40:48
  * @version : 12.0.0
 */
public interface AmountLogService {
	/**
	 * 总收入
	 * @return
	 */
	public Integer sumAmount();
	/**
	 * 总停车数
	 * @return
	 */
	public Integer countAmount();
	
	/**
	 * 日结算统计
	 * @param startTime 起始时间
	 * @param endTime 终止时间
	 * @return 总钱数
	 */
	Integer sumAmountLog(String startTime,String endTime);

	/**
	 * 临时用户
	 * @return
	 */
	public Integer sumCasual();
	/**
	 * 月缴用户
	 * @return
	 */
	public Integer sumMonth();
	/**
	 * 自助终端缴费
	 * @return
	 */
	public Integer sumTerminal();
	/**
	 * 人工缴费
	 * @return
	 */
	public Integer sumManual();
	
	/**
	 * 收入明细分页
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<AmountLog> queryIncome(String offset, String limit);
	
	public Integer countIncome();
	/**
	 * 临时月缴用户明细
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<AmountLog> queryIncomeMonth(String offset, String limit);
	/**
	 * 临时月缴用户明细分页
	 * @return
	 */
	public Integer countIncomeMonth();
	/**
	 * 月缴产品明细
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<CarService> queryIncomeProduct(String offset, String limit);
	/**
	 * 月缴产品明细分页
	 * @return
	 */
	public Integer countIncomeProduct();
	/**
	 * 月缴产品统计
	 * @param name
	 * @return
	 */
	public Integer sumProduct(String name);
	/**
	 * 月缴产品明细
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<MechineLog> queryIncomeMechine(String offset, String limit);
	/**
	 * 月缴产品明细分页
	 * @return
	 */
	public Integer countIncomeMechine();
	/**
	 * 终端统计总数
	 * @param id
	 * @return
	 */
	public Integer sumMechine(Integer id);
	/**
	 * 人工收费统计查询
	 * @return
	 */
	public List<SumManual> sumIncomeManual();
	/**
	 * 收费人员明细
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<AmountLog> queryIncomeManual(String offset, String limit);
	/**
	 * 收费人员明细分页
	 * @return
	 */
	public Integer countIncomeManual();
	
	
}
