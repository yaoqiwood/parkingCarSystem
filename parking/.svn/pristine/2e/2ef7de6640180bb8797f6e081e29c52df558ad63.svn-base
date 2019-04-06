package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.AdminRoleMenu;
import com.example.dao.AdminRoleMenuMapper;
import com.example.service.AdminRoleMenuService;

@Service
public class AdminRoleMenuServiceImpl implements AdminRoleMenuService{
	
	@Autowired
	private AdminRoleMenuMapper mapper;

	@Override
	public List<AdminRoleMenu> roleMenuInf(Integer roleId) {
		// TODO Auto-generated method stub
		List<AdminRoleMenu> roleMenuInf = mapper.roleMenuInf(roleId);
		return roleMenuInf;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer roleMenuUpdate(Integer roleId, String updateInf) {
		// TODO Auto-generated method stub
		String[] split = updateInf.split(",");
		Integer count = 0;
		for (int i = 0; i < split.length; i++) {
			String[] split2 = split[i].split("%%");
			AdminRoleMenu roleMenuSingle = mapper.roleMenuSingle(roleId, split2[0]);
			if(roleMenuSingle != null) {
				count += mapper.roleMenuUpdate(roleId, split2[0], split2[1]);
			}else {
				count += mapper.roleMenuInsert(roleId, split2[0], split2[1]);
			}
		}
		if(count != split.length) {
			 try {
				throw new Exception("未添加资产,请重新添加");
			} catch (Exception e) {
				return null;
			}
		}
		return count;
	}

	@Override
	public List<AdminRoleMenu> roleMenuInfById(Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
