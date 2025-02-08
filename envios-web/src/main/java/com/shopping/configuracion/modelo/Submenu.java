package com.shopping.configuracion.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the submenu database table.
 * 
 */
@Entity
@NamedQuery(name="Submenu.findAll", query="SELECT s FROM Submenu s")
public class Submenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String estado;

	private int idmenu;

	private String submenu;

	public Submenu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdmenu() {
		return this.idmenu;
	}

	public void setIdmenu(int idmenu) {
		this.idmenu = idmenu;
	}

	public String getSubmenu() {
		return this.submenu;
	}

	public void setSubmenu(String submenu) {
		this.submenu = submenu;
	}

}