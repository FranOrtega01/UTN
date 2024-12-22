package entidad;

public class TipoMovimiento {
	private int idTipo;
	private String descripcion;
	
	public TipoMovimiento(int idTipo, String descripcion) {
		this.idTipo = idTipo;
		this.descripcion = descripcion;
	}
	
	public TipoMovimiento(int idTipo) {
		this.idTipo = idTipo;
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
