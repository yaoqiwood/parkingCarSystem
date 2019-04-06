/**
 * 
 */
package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.Configure;
import com.example.dao.ConfigureMapper;
import com.example.service.ConfigureService;

/**
 * Title : ConfigureServiceImpl Description : DevelopTools : Eclipse_x64
 * DevelopSystem : Win10 Company : org.NorwegianWoods
 * 
 * @author : CatWood
 * @date : Feb 24, 2019 11:45:58 AM
 * @version : 12.0.0
 */
@Service
public class ConfigureServiceImpl implements ConfigureService {

	@Autowired
	private ConfigureMapper configureMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.service.ConfigureService#refConfigure(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public List<Configure> refConfigure(String configureName, String Start, String End) {
		List<Configure> configures = configureMapper.refConfigure(configureName, Start, End);
		// TODO Auto-generated method stub
		return configures;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.service.ConfigureService#cntConfigure(java.lang.String)
	 */
	@Override
	public String cntConfigure(String configureName) {
		// TODO Auto-generated method stub
		String Count = configureMapper.cntConfigure(configureName);
		return Count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.service.ConfigureService#addConfigure(java.lang.String,
	 * java.lang.String)
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer addConfigure(String configureName, String configureValue) {
		// TODO Auto-generated method stub
		Integer out = configureMapper.addConfigure(configureName, configureValue);
		return out;
	}

	/* (non-Javadoc)
	 * @see com.example.service.ConfigureService#upConfigure(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Integer upConfigure(Integer upConfigID, String upConfigName, String upConfigParamter) {
		// TODO Auto-generated method stub
		Integer out = configureMapper.upConfigure(upConfigID, upConfigName, upConfigParamter);
		return out;
	}

	/* (non-Javadoc)
	 * @see com.example.service.ConfigureService#upStateConfigure(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Integer upStateConfigure(Integer upState, Integer Fid) {
		// TODO Auto-generated method stub
		Integer out = configureMapper.upStateConfigure(upState, Fid);
		return out;
	}

	/* (non-Javadoc)
	 * @see com.example.service.ConfigureService#checkConfigName(java.lang.String)
	 */
	@Override
	public Integer checkConfigName(String configureName) {
		// TODO Auto-generated method stub
		Integer out = configureMapper.checkConfigName(configureName);
		return out;
	}

}
