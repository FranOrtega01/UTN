package dominio;

public class Perro extends Animal{
	private String raza;

	public Perro() {
		super();
		raza = "";
	}
	
	public Perro(String nombre, String raza) {
		super(nombre);
		this.raza = raza;
	}
	
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	public String toString() {
		return "Es un Perro, Nombre: " + super.getNombre() + ", Raza: " + raza;
	}
	
}
