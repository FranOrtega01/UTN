package entidad;

import java.util.Date;

public class Prestamo {
	private int idPrestamo;
	private int idCuenta;
	private Date fecha;
	private double importePedido;
	private double importeAPagar;
	private int plazoPago;
	private double montoMensual;
	private int cuotas;
	private int cuotasPagas;
	private String estado;
	
	public Prestamo() {
		
	}
	
	public Prestamo(int idPrestamo, int idCuenta, Date fecha, double importePedido, double importeAPagar,
			int plazoPago, double montoMensual, int cuotas, int cuotasPagas, String estado) {
		super();
		this.idPrestamo = idPrestamo;
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.importePedido = importePedido;
		this.importeAPagar = importeAPagar;
		this.plazoPago = plazoPago;
		this.montoMensual = montoMensual;
		this.cuotas = cuotas;
		this.cuotasPagas = cuotasPagas;
		this.estado = estado;
	}
	
	public Prestamo(int idCuenta, double importePedido, double importeAPagar, int plazoPago, int cuotas) {
		super();
		this.idCuenta = idCuenta;
		this.importePedido = importePedido;
		this.importeAPagar = importeAPagar;
		this.plazoPago = plazoPago;
		this.cuotas = cuotas;
	}
	
	public Prestamo(int idCuenta, double importePedido, int plazoPago, int cuotas) {
		super();
		this.idCuenta = idCuenta;
		this.importePedido = importePedido;
		this.plazoPago = plazoPago;
		this.cuotas = cuotas;
	}
	
	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getImportePedido() {
		return importePedido;
	}
	public void setImportePedido(double importePedido) {
		this.importePedido = importePedido;
	}
	public double getImporteAPagar() {
		return importeAPagar;
	}
	public void setImporteAPagar(double importeAPagar) {
		this.importeAPagar = importeAPagar;
	}
	public int getPlazoPago() {
		return plazoPago;
	}
	public void setPlazoPago(int plazoPago) {
		this.plazoPago = plazoPago;
	}
	public double getMontoMensual() {
		return montoMensual;
	}
	public void setMontoMensual(double montoMensual) {
		this.montoMensual = montoMensual;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCuotasPagas() {
		return cuotasPagas;
	}

	public void setCuotasPagas(int cuotasPagas) {
		this.cuotasPagas = cuotasPagas;
	}
}
