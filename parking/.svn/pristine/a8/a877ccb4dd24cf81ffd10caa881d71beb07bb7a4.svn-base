package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MenuMapper;
import com.example.dto.MenuDto;
import com.example.dto.MenuRoleDto;
import com.example.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuMapper mapper;
	
	@Override
	public List<MenuRoleDto> getMenu(String roleId) {
		// TODO Auto-generated method stub
		List<MenuRoleDto> menu = mapper.getMenu(roleId);
		return menu;
	}

	@Override
	public Integer updatemenu(String roleId) {
		// TODO Auto-generated method stub
		Integer updatemenu = mapper.updatemenu(roleId);
		return updatemenu;
	}

	@Override
	public Integer updatemenuroleId(String roleId) {
		// TODO Auto-generated method stub
		Integer updatemenuroleId = mapper.updatemenuroleId(roleId);
		return updatemenuroleId;
	}

	@Override
	public List<MenuDto> menuInfo() {
		// TODO Auto-generated method stub
		List<MenuDto> menuByParent = mapper.menuByParent(0);
		return menuByParent;
	}

	@Override
	public Integer updateItem(String id, String item) {
		// TODO Auto-generated method stub
		Integer udpateItem = mapper.udpateItem(id, item);
		return udpateItem;
	}

}
