package com.example.service;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import com.example.bean.MonthProduct;

/**
 * 月缴产品配置service层类
 * <p>Title:MonthProductService</p>
 * <p>Description:</p>
 * <p>DevelopTools:Eclipse_x64_v4.7.1</p>
 * <p>DevelopSystem : macOS Sierra 10.12.1</p>
 * <p>Company : org.xiongyi</p>
 * @author:XiongYi
 * @date:2019年2月21日 下午6:31:54
 * @version:12.0.0
 */
public interface MonthProductService {
	/**
	 * 分页
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param proName 名字
	 * @param rb RowBounds
	 * @return 产品集合
	 */
	ArrayList<MonthProduct> init(String startTime,String endTime,String proName,RowBounds rb);
	
	/**
	 * 总条数
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param proName 名字
	 * @return 总条数
	 */
	Integer count(String startTime,String endTime,String proName);
	
	/**
	 * 添加产品
	 * @param monthProduct 产品对象
	 * @return 0或1
	 */
	Integer addMonthProduct(MonthProduct monthProduct);
	
	/**
	 * 删除产品
	 * @param monthProductId 产品ID
	 * @return 0或1
	 */
	Integer delMonthProduct(String monthProductId);
	
	/**
	 * 月缴产品修改显示
	 * @param monthProductId 产品id
	 * @return 产品对象
	 */
	MonthProduct showMonthProduct(String monthProductId);
	
	/**
	 * 月缴产品配置修改
	 * @param monthProduct 产品对象
	 * @return 0 1
	 */
	Integer modMonthProduct(MonthProduct monthProduct);
	
	/**
	 * 月缴产品配置修改状态
	 * @param monthProductId 产品id
	 * @param monthProductState 状态
	 * @return 0 1
	 */
	Integer ableMonthProduct(String monthProductId,String monthProductState);
	
	/**
	 * 月缴产品显示
	 * @return 产品的集合
	 */
	ArrayList<MonthProduct> showSellMonthProduct();
}
