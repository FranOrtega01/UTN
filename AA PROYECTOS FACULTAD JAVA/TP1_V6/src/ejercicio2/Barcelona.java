package ejercicio2;

public class Barcelona {
	private String fechaClub;

	public String getFechaClub() {
		return fechaClub;
	}


	public void setFechaClub(String fechaClub) {
		this.fechaClub = fechaClub;
	}


	@Override
	public String toString() {
		return "Fecha: " + fechaClub;
	}
}
