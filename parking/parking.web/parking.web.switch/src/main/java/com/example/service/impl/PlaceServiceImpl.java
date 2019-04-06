package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PlaceMapper;
import com.example.service.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService {
	@Autowired
	private PlaceMapper mapper;

	@Override
	public Integer placeCount() {
		// TODO Auto-generated method stub
		Integer placeCount = mapper.placeCount();
		return placeCount;
	}

	@Override
	public Integer placeHasCount() {
		// TODO Auto-generated method stub
		Integer placeHasCount = mapper.placeHasCount();
		return placeHasCount;
	}

}
