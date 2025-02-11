package com.ayalait.terminal.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "actualizarTransaccionTarjetaVenta", procedureName = "actualizarTransaccionTarjetaVenta", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "idVenta", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "id_transaccion", type = String.class)

		}) })
@Table(name = "ventas")
public class Ventas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venta")
	private int idVenta;
	private int estado;
	@Column(name = "id_usuario")
	private String idUsuario;
	@Column(name = "fecha_hora")
	private String fechaHora;
	@Column(name = "fecha_hora_cerrado")
	private String fechaHoraCerrado;

	@Column(name = "id_usuario_autoriza")
	private String idUsuarioAutoriza;

	@Column(name = "id_sucursal")
	private int idSucursal;

	@Column(name = "fecha_baja")
	private String fechaBaja;

	private int movimiento;

	@Column(name = "monto_total")
	private double montoTotal;

	@Column(name = "id_cliente")
	private String idCliente;

	@Column(name = "id_apertura_cajero")
	private int idAperturaCajero;

	@Column(name = "nro_consecutivo")
	private int nroConsecutivo;
	private double iva5;
	private double iva10;
	private double iva22;
	private int condicion;

	@Column(name = "monto_credito")
	private double montoCredito;
	private double redondeo;

	@Column(name = "id_transaccion")
	private String idTransaccion;

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getFechaHoraCerrado() {
		return fechaHoraCerrado;
	}

	public void setFechaHoraCerrado(String fechaHoraCerrado) {
		this.fechaHoraCerrado = fechaHoraCerrado;
	}

	public String getIdUsuarioAutoriza() {
		return idUsuarioAutoriza;
	}

	public void setIdUsuarioAutoriza(String idUsuarioAutoriza) {
		this.idUsuarioAutoriza = idUsuarioAutoriza;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public int getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdAperturaCajero() {
		return idAperturaCajero;
	}

	public void setIdAperturaCajero(int idAperturaCajero) {
		this.idAperturaCajero = idAperturaCajero;
	}

	public int getNroConsecutivo() {
		return nroConsecutivo;
	}

	public void setNroConsecutivo(int nroConsecutivo) {
		this.nroConsecutivo = nroConsecutivo;
	}

	public double getIva5() {
		return iva5;
	}

	public void setIva5(double iva5) {
		this.iva5 = iva5;
	}

	public double getIva10() {
		return iva10;
	}

	public void setIva10(double iva10) {
		this.iva10 = iva10;
	}

	public double getIva22() {
		return iva22;
	}

	public void setIva22(double iva22) {
		this.iva22 = iva22;
	}

	public int getCondicion() {
		return condicion;
	}

	public void setCondicion(int condicion) {
		this.condicion = condicion;
	}

	public double getMontoCredito() {
		return montoCredito;
	}

	public void setMontoCredito(double montoCredito) {
		this.montoCredito = montoCredito;
	}

	public double getRedondeo() {
		return redondeo;
	}

	public void setRedondeo(double redondeo) {
		this.redondeo = redondeo;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	
	

}
