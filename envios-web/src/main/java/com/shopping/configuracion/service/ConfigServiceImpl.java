package com.shopping.configuracion.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ayalait.utils.ErrorState;
import com.google.gson.Gson;
import com.online.modelo.MenuOnline;
import com.online.modelo.MenudetalleOnline;
import com.online.modelo.SubmenuOnline;
import com.online.utils.MenuHome;
import com.online.utils.SubMenusHome;
import com.shopping.configuracion.modelo.Menu;
import com.shopping.configuracion.modelo.Menudetalle;
import com.shopping.configuracion.modelo.Submenu;
import com.shopping.configuracion.repositorio.MenuDetalleJPA;
import com.shopping.configuracion.repositorio.MenuJPA;
import com.shopping.configuracion.repositorio.SubmenuJPA;




@Service
public class ConfigServiceImpl implements ConfigService {

	ErrorState error= new ErrorState();
	
	@Autowired
	MenuJPA daoMenu;
	
	@Autowired
	SubmenuJPA daoSubMenu;
	
	@Autowired
	MenuDetalleJPA daoDetalleMenu;
	
	



	@Override
	public ResponseEntity<String> obtenerMenuSubMenu() {
		try {
			
			List<MenuHome> menuOnline= new ArrayList<MenuHome>();
			
			
			 List<Menu> lstMenu = daoMenu.findAll();
			if(!lstMenu.isEmpty()) {
				for (Menu menu2 : lstMenu) {
					MenuHome menu= new MenuHome();
					List<Submenu> lstSub= daoSubMenu.obtenerSubMenuPorID(menu2.getId());
					if(!lstSub.isEmpty()) {
						MenuOnline tmpMenu = new MenuOnline();
						tmpMenu.setEstado(menu2.getEstado());
						tmpMenu.setId(menu2.getId());
						tmpMenu.setMenu(menu2.getMenu());						
						menu.setMenu(tmpMenu);
						
						List<SubMenusHome> subMenus = new ArrayList<SubMenusHome>();
						for (Submenu subMenu : lstSub) {
							SubMenusHome submH= new SubMenusHome();
							SubmenuOnline subO= new SubmenuOnline();
							subO.setId(subMenu.getId());
							subO.setIdmenu(subMenu.getIdmenu());
							subO.setSubmenu(subMenu.getSubmenu());
							subO.setEstado(subMenu.getEstado());
							submH.setSubMenu(subO);
							
							
							List<Menudetalle> lstDetMenu= daoDetalleMenu.obtenerDetalleSubMenuPorID(subMenu.getId());
							if (!lstDetMenu.isEmpty()) {
								List<MenudetalleOnline> subMenusDetail = new ArrayList<MenudetalleOnline>();
								for (Menudetalle menu3 : lstDetMenu) {
									MenudetalleOnline tmpMD = new MenudetalleOnline();
									tmpMD.setDescripcion(menu3.getDescripcion());
									tmpMD.setEstado(menu3.getEstado());
									tmpMD.setId(menu3.getId());
									tmpMD.setIdsubmenu(menu3.getIdsubmenu());
									subMenusDetail.add(tmpMD);
								}
																
								submH.setSubMenus(subMenusDetail);
								subMenus.add(submH);
								menu.setSubMenus(subMenus);
								
								menu.setMenu(tmpMenu);
							}
						}
					}
					menuOnline.add(menu);
				}
				
				
				return new ResponseEntity<String>(new Gson().toJson(menuOnline), HttpStatus.OK);
			}else {
				error.setCode(40001);
				error.setMenssage("No existe menu activos");
				return new ResponseEntity<String>(new Gson().toJson(error), HttpStatus.BAD_REQUEST);

			}
		} catch (Exception e) {
			error.setCode(40001);
			error.setMenssage(e.getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	
	

}
