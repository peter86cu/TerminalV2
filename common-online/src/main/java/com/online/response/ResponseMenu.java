package com.online.response;

import java.util.List;

import com.online.utils.ErrorState;
import com.online.utils.MenuHome;

public class ResponseMenu {
	
	private boolean status;
	private int code;
	private List<MenuHome> menu;
	private String respuesta;
	private ErrorState error;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public ErrorState getError() {
		return error;
	}
	public void setError(ErrorState error) {
		this.error = error;
	}
	public List<MenuHome> getMenu() {
		return menu;
	}
	public void setMenu(List<MenuHome> menu) {
		this.menu = menu;
	}
	public ResponseMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
