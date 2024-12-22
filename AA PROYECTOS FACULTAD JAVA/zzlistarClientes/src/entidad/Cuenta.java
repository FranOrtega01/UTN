package entidad;
import java.util.Date;

public class Cuenta {
	private int nroCuenta;
	private int idCliente;
	private Date fechaCreacion;
	//private TipoCuenta tipoCuenta;
	private int tipoCuenta;
	private String cbu;
	private double saldo;
	
	public Cuenta(int nroCuenta, int idCliente, Date fechaCreacion, int tipoCuenta, String cbu, double saldo) {
		this.nroCuenta = nroCuenta;
		this.idCliente = idCliente;
		this.fechaCreacion = fechaCreacion;
		this.tipoCuenta = tipoCuenta;
		this.cbu = cbu;
		this.saldo = saldo;
	}
	
	public int getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(int tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public String getCbu() {
		return cbu;
	}
	public void setCbu(String cbu) {
		this.cbu = cbu;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
