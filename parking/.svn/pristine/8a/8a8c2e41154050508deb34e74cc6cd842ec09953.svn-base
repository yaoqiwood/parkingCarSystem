package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.Admin;
import com.example.dao.AdminMapper;
import com.example.dto.AdminDto;
import com.example.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper mapper;

	/**
	 * 用户存在但查不到，则密码错误，错误码99
	 */
	@Override
	public Admin adminLogin(String name, String password) {
		// TODO Auto-generated method stub
		Integer selectAdminName = mapper.selectAdminName(name);
		if(selectAdminName > 0) {
			Admin adminLogin = mapper.adminLogin(name, password);
			if(adminLogin == null) {
				Admin admin = new Admin();
				admin.setAdminState(99);
				return admin;
			}else {
				return adminLogin;
			}
		}else {
			return null;	
		}
	}

	/**
	 * 刷新用户表格
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<AdminDto> listAdminByPage(String startTime, String endTime,String name, Integer roleId, Integer state, Integer start,
			Integer end) {
		// TODO Auto-generated method stub
		List<AdminDto> listAdminByPage = mapper.listAdminByPage(startTime, endTime,"%"+name.trim()+"%", roleId, state, start, end);
		return listAdminByPage;
	}

	/**
	 * 查询用户个数
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer countAdmin(String startTime, String tiendTimeme, String name, Integer roleId, Integer state) {
		// TODO Auto-generated method stub
		Integer countAdmin = mapper.countAdmin(startTime, tiendTimeme, "%"+name.trim()+"%", roleId, state);
		return countAdmin;
	}

	/**
	 * 删除用户
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer delAdmin(String adminId) {
		// TODO Auto-generated method stub
		Integer delAdmin = mapper.delAdmin(adminId);
		return delAdmin;
	}

	/**
	 * 启/禁用
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer updateAdminState(String adminId, String state) {
		// TODO Auto-generated method stub
		Integer updateAdminState = mapper.updateAdminState(adminId, state);
		return updateAdminState;
	}

	/**
	 * 修改用户
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer updateAdmin(String adminId,String dstate,String dname,String drole) {
		// TODO Auto-generated method stub
		Integer updateAdmin = mapper.updateAdmin(dname, drole, dstate, adminId);
		return updateAdmin;
	}

	/**
	 * 重置密码
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer resetteAdmin(String adminId) {
		// TODO Auto-generated method stub
		Integer resetteAdmin = mapper.resetteAdmin(adminId);
		return resetteAdmin;
	}

	/**
	 * 添加用户信息
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer addAdmin(String addname, String addpassword, String addrole) {
		// TODO Auto-generated method stub
		Integer selectAdminName = mapper.selectAdminName(addname);
		if(selectAdminName == 0) {
			Integer addAdmin = mapper.addAdmin(addname, addpassword, addrole);
			return addAdmin;
		}else {
			return -1;
		}
	}

	/**
	 * 注销用户
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer cancelAdmin(String adminId) {
		// TODO Auto-generated method stub
		Integer cancelAdmin = mapper.cancelAdmin(adminId);
		return cancelAdmin;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Admin singleAdminInfo(String adminId) {
		// TODO Auto-generated method stub
		Admin singleAdminInfo = mapper.singleAdminInfo(adminId);
		return singleAdminInfo;
	}

	/**
	 * 修改密码
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer updatepwd(String oldpwd, Integer adminId, String newpwd) {
		// TODO Auto-generated method stub
		Integer updatepwd = mapper.updatepwd(oldpwd, adminId, newpwd);
		return updatepwd;
	}
	
	
}
