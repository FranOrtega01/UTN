package entidad;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movimiento {
	private int idMovimiento;
	private int nroCuenta;
	private Date fecha;
	private String detalle;
	private double importe;
	private TipoMovimiento tipoMovimiento;
	
	public Movimiento() {
		
	}
	
	public Movimiento(int idMovimiento, int nroCuenta, Date fecha, String detalle, double importe,
		TipoMovimiento tipoMovimiento) {
		this.idMovimiento = idMovimiento;
		this.nroCuenta = nroCuenta;
		this.fecha = fecha;
		this.detalle = detalle;
		this.importe = importe;
		this.tipoMovimiento = tipoMovimiento;
	}
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public int getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public Date getFecha() {
		return fecha;
	}
	public String getFechaString() {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		 return sdf.format(this.fecha);
		 
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	} 
	
	
}
