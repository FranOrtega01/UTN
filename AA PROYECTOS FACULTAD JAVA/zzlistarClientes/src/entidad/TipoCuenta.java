package entidad;

public class TipoCuenta {
	private int idTipo;
	private String descripcion;
	
	public TipoCuenta(int idTipo, String descripcion) {
		this.idTipo = idTipo;
		this.descripcion = descripcion;
	}
	
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
