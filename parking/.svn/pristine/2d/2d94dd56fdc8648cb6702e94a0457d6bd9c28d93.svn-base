/**
 * 
 */
package com.example.dto;

import java.util.Date;
import java.util.List;

import com.example.bean.Menu;

/**
 * <p>Title : MenuDto</p>
 * <p>Description : </p>
 * <p>DevelopTools : Eclipse_x64</p>
 * <p>DevelopSystem : Win10</p>
 * <p>Company : org.NorwegianWoods</p>
 * @author : CatWood
 * @date : Feb 22, 2019 8:55:35 AM
 * @version : 12.0.0
 */
public class MenuDto extends Menu {

	private List<Menu> menuBeans;

	public MenuDto() {
		super();
	}
	public MenuDto(Integer menuId, Integer menuParent, String menuName, String menuUrl, Integer menuState,
			String menuMemo, Date menuCreateTime, Date menuUpdateTime, List<Menu> menuBeans) {
		super(menuId, menuParent, menuName, menuUrl, menuState, menuMemo, menuCreateTime, menuUpdateTime);
		this.menuBeans = menuBeans;
	}
	
	@Override
	public String toString() {
		return super.toString()+"MenuDto [menuBeans=" + menuBeans + "]";
	}

	public List<Menu> getMenuBeans() {
		return menuBeans;
	}

	public void setMenuBeans(List<Menu> menuBeans) {
		this.menuBeans = menuBeans;
	}
}
