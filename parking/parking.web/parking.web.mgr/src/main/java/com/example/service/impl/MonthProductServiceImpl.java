package com.example.service.impl;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.MonthProduct;
import com.example.dao.MonthProductMapper;
import com.example.service.MonthProductService;

@Service
public class MonthProductServiceImpl implements MonthProductService{
	@Autowired
	private MonthProductMapper monthProductMapper;
	
	@Override
	public ArrayList<MonthProduct> init(String startTime, String endTime, String proName, RowBounds rb) {
		// TODO Auto-generated method stub
		ArrayList<MonthProduct> proList = new ArrayList<MonthProduct>();
		proList=monthProductMapper.init(startTime, endTime, proName, rb);
		return proList;
	}

	@Override
	public Integer count(String startTime, String endTime, String proName) {
		// TODO Auto-generated method stub
		Integer count = monthProductMapper.count(startTime, endTime, proName);
		return count;
	}

	/* (non-Javadoc)
	 * @see com.example.service.MonthProductService#addMonthProduct(com.example.bean.MonthProduct)
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public Integer addMonthProduct(MonthProduct monthProduct) {
		// TODO Auto-generated method stub
		Integer flag = monthProductMapper.addMonthProduct(monthProduct);		
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.example.service.MonthProductService#delMonthProduct(java.lang.String)
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public Integer delMonthProduct(String monthProductId) {
		// TODO Auto-generated method stub
		Integer flag = monthProductMapper.delMonthProduct(monthProductId);
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.example.service.MonthProductService#showMonthProduct(java.lang.String)
	 */
	@Override
	public MonthProduct showMonthProduct(String monthProductId) {
		// TODO Auto-generated method stub
		MonthProduct monthProduct = monthProductMapper.showMonthProduct(monthProductId);
		return monthProduct;
	}

	/* (non-Javadoc)
	 * @see com.example.service.MonthProductService#modMonthProduct(com.example.bean.MonthProduct)
	 */
	@Override
	public Integer modMonthProduct(MonthProduct monthProduct) {
		// TODO Auto-generated method stub
		Integer flag = monthProductMapper.modMonthProduct(monthProduct);
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.example.service.MonthProductService#ableMonthProduct(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer ableMonthProduct(String monthProductId, String monthProductState) {
		// TODO Auto-generated method stub
		Integer flag = monthProductMapper.ableMonthProduct(monthProductId, monthProductState);
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.example.service.MonthProductService#showMonthProduct()
	 */
	@Override
	public ArrayList<MonthProduct> showSellMonthProduct() {
		// TODO Auto-generated method stub
		ArrayList<MonthProduct> proList = monthProductMapper.showSellMonthProduct();
		return proList;
	}

}
