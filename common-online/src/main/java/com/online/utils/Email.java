package com.online.utils;

public class Email {
	
	private String name;
	private String email;
	private String subject;
	private String message;
	private boolean adjunto;
	private String archivo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isAdjunto() {
		return adjunto;
	}
	public void setAdjunto(boolean adjunto) {
		this.adjunto = adjunto;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	

}
