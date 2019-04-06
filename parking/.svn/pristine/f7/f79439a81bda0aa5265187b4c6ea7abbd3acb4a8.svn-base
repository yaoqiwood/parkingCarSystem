package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.AdminRole;
import com.example.dao.AdminRoleMapper;
import com.example.service.AdminRoleService;

/**
 * 管理员角色业务实现类
 * @author 黄主文
 *
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService{

	@Autowired
	private AdminRoleMapper mapper;
	
	/**
	 * 获取角色名字，添加到下拉框
	 */
	@Override
	public List<AdminRole> listrole() {
		// TODO Auto-generated method stub
		List<AdminRole> listrole = mapper.listrole();
		return listrole;
	}

}
