package com.shopping.configuracion.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menudetalle database table.
 * 
 */
@Entity
@NamedQuery(name="Menudetalle.findAll", query="SELECT m FROM Menudetalle m")
public class Menudetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	private String estado;

	private int idsubmenu;

	public Menudetalle() {
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