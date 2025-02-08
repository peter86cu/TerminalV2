package com.online.utils;

import java.util.List;

import com.online.modelo.MenuOnline;

public class MenuHome {
	
	private MenuOnline menu;
	private List<SubMenusHome> subMenus;
	
	public MenuOnline getMenu() {
		return menu;
	}

	public void setMenu(MenuOnline menu) {
		this.menu = menu;
	}

	public List<SubMenusHome> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenusHome> subMenus) {
		this.subMenus = subMenus;
	}

	public MenuHome() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
