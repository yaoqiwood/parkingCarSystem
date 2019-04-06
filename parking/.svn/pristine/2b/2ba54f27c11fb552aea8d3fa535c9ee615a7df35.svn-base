package com.example.dao;
/**
 * 
  * <p>Title : AmountLogMapper</p>
  * <p>Description :收支明细映射类 </p>
  * <p>DevelopTools : Eclipse_x64_v4.7.1</p>
  * <p>DevelopSystem : Windows 10</p>
  * <p>Company : org.chenmian</p>
  * @author : ChenMian
  * @date : 2019年2月23日 上午8:42:49
  * @version : 12.0.0
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.example.bean.AdminAmountLog;

import com.example.bean.AmountLog;
import com.example.bean.CarService;
import com.example.bean.MechineLog;
import com.example.bean.SumManual;

public interface AmountLogMapper {
	/*总收入*/
	Integer sumAmount();
	/*总停车数*/
	Integer countAmount();
	/**
	 * 日结算统计
	 * @param startTime 起始时间
	 * @param endTime 终止时间
	 * @return 总钱数
	 */
	Integer sumAmountLog(@Param("startTime") String startTime,@Param("endTime") String endTime);

	/*临时收入*/
	Integer sumCasual();
	/*月卡收入*/
	Integer sumMonth();
	/*终端收入*/
	Integer sumTerminal();
	/*人工收入*/
	Integer sumManual();
	
	/**
	 * 添加流水表
	 * @param adminAmountLog 流水表对象
	 * @return 0 1
	 */
	Integer addAmountLog(@Param("adminAmountLog") AdminAmountLog adminAmountLog);


	/*收入明细*/
	List<AmountLog> queryIncome(RowBounds rb);
	/*收入明细分页*/
	Integer countIncome();
	/*临时月缴用户明细*/
	List<AmountLog> queryIncomeMonth(RowBounds rb);
	/*临时月缴用户明细分页*/
	Integer countIncomeMonth();
	/*月缴产品明细*/
	List<CarService> queryIncomeProduct(RowBounds rb);
	/*月缴产品明细分页*/
	Integer countIncomeProduct();
	/*月缴产品统计*/
	Integer sumProduct(@Param("name") String name);
	/*月缴产品明细*/
	List<MechineLog> queryIncomeMechine(RowBounds rb);
	/*月缴产品明细分页*/
	Integer countIncomeMechine();
	/*终端统计总数*/
	Integer sumMechine(@Param("id") Integer id);
	/*人工收费统计查询*/
	List<SumManual> sumIncomeManual();
	/*收费人员明细*/
	List<AmountLog> queryIncomeManual(RowBounds rb);
	/*收费人员明细分页*/
	Integer countIncomeManual();
}
