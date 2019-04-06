package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.WhiteList;
import com.example.dao.WhiteListMapper;
import com.example.service.WhiteListService;

@Service
public class WhiteListServiceImpl implements WhiteListService{

	
	@Autowired
	private WhiteListMapper mapper;
	
	/**
	 * 刷新白名单表格
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<WhiteList> listwhiteListByPage(String startTime, String endTime, String name,Integer start, Integer end) {
		// TODO Auto-generated method stub
		List<WhiteList> listcarnumByPage = mapper.listwhiteListByPage(startTime, endTime,"%"+name.trim()+"%",start, end);
		return listcarnumByPage;
	}

	/**
	 * 白名单个数
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer countWhiteList(String startTime, String endTime, String name) {
		// TODO Auto-generated method stub
		Integer whiteList = mapper.whiteList(startTime, endTime, "%"+name.trim()+"%");
		return whiteList;
	}

	/**
	 * 删除
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer delWhiteList(String whiteListId) {
		// TODO Auto-generated method stub
		Integer delwhiteList = mapper.delwhiteList(whiteListId);
		return delwhiteList;
	}

	/**
	 * 添加
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer addWhiteList(String addname) {
		// TODO Auto-generated method stub
		Integer addWhiteList = mapper.addWhiteList(addname);
		return addWhiteList;
	}

}
