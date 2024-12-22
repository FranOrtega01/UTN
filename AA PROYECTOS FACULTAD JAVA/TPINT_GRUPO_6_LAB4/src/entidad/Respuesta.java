package entidad;

public class Respuesta {
	boolean estado;
	String mensaje;
	
	public Respuesta(boolean estado, String mensaje){
		this.estado = estado;
		this.mensaje = mensaje;
	}
	
	public Respuesta() {}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
