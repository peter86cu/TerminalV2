package com.online.modelo;

import java.io.Serializable;


public class MenudetalleOnline implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;

	private String descripcion;

	private String estado;

	private int idsubmenu;

	public MenudetalleOnline() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdsubmenu() {
		return this.idsubmenu;
	}

	public void setIdsubmenu(int idsubmenu) {
		this.idsubmenu = idsubmenu;
	}

}