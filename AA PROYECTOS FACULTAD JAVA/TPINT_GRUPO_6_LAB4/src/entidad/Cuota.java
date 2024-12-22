package entidad;

import java.util.Date;

public class Cuota {
	private int nroCuota;
	private int idPrestamo;
	private Date fechaPago;
	private boolean pagado;
	
	public Cuota() {
		
	}
	
	public Cuota(int nroCuota, int idPrestamo, Date fechaPago, boolean pagado) {
		super();
		this.nroCuota = nroCuota;
		this.idPrestamo = idPrestamo;
		this.fechaPago = fechaPago;
		this.pagado = pagado;
	}

	public int getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	
	
}
