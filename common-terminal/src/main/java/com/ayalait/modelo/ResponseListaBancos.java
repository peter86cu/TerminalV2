package com.ayalait.modelo;

import java.util.List;

import com.ayalait.modelo.Banco;
import com.ayalait.utils.ErrorState;

public class ResponseListaBancos {

	private boolean status;
	private int code;
	private List<Banco> banco;
	private String resultado;
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

	

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	

	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

	public List<Banco> getBanco() {
		return banco;
	}

	public void setBanco(List<Banco> banco) {
		this.banco = banco;
	}

}
