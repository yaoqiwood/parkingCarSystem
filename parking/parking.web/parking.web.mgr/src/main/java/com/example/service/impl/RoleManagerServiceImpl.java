/**
 * 
 */
package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.AdminRole;
import com.example.dao.RoleManagerMapper;
import com.example.service.RoleManagerService;

/**
 * Title : RoleManagerServiceImpl Description : DevelopTools : Eclipse_x64
 * DevelopSystem : Win10 Company : org.NorwegianWoods
 * 
 * @author : CatWood
 * @date : Feb 22, 2019 7:20:35 PM
 * @version : 12.0.0
 */
@Service
public class RoleManagerServiceImpl implements RoleManagerService {

	@Autowired
	private RoleManagerMapper roleManagerMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.service.RoleManagerService#refRoleManager(java.lang.String,
	 * java.lang.Integer)
	 */
	@Override
	public List<AdminRole> refRoleManager(String roleName, Integer roleState, String begin, String end) {
		// TODO Auto-generated method stub
		System.out.println("roleState"+roleState);
		List<AdminRole> adminRoles = roleManagerMapper.refRoleManager(roleName, roleState, begin, end);
		return adminRoles;
	}

	/* (non-Javadoc)
	 * @see com.example.service.RoleManagerService#cntRoleManager(java.lang.String, java.lang.Integer)
	 */
	@Override
	public String cntRoleManager(String roleName, Integer roleState) {
		// TODO Auto-generated method stub
		String out = roleManagerMapper.cntRoleManager(roleName, roleState);
		return out;
	}

	/* (non-Javadoc)
	 * @see com.example.service.RoleManagerService#addRoleManager(java.lang.String)
	 */
	@Override
	public Integer addRoleManager(String roleName) {
		// TODO Auto-generated method stub
		Integer out = roleManagerMapper.addRoleManager(roleName);
		return out;
	}

	/* (non-Javadoc)
	 * @see com.example.service.RoleManagerService#upRoleManager(java.lang.Integer, java.lang.String)
	 */
	@Override
	public Integer upRoleManager(Integer upRoleId, String upRoleName) {
		// TODO Auto-generated method stub
		Integer out = roleManagerMapper.upRoleManager(upRoleId, upRoleName);
		return out;
	}

	/* (non-Javadoc)
	 * @see com.example.service.RoleManagerService#upStateRoleManager(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Integer upStateRoleManager(Integer upState, Integer Fid) {
		// TODO Auto-generated method stub
		Integer out = roleManagerMapper.upStateRoleManager(upState, Fid);
		return out;
	}

	/* (non-Javadoc)
	 * @see com.example.service.RoleManagerService#checkRoleNameR(java.lang.String)
	 */
	@Override
	public Integer checkRoleNameR(String roleName) {
		// TODO Auto-generated method stub
		Integer out = roleManagerMapper.checkRoleNameR(roleName);
		return out;
	}

}
