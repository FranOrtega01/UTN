package dominio;

public class Gato extends Animal{

	public Gato() {
		super();
	}
	
	public Gato(String nombre) {
		super(nombre);
	
	}
	
//	public String getRaza() {
//		return raza;
//	}
//
//	public void setRaza(String raza) {
//		this.raza = raza;
//	}
	
	public String toString() {
		return "Es un Gato, Nombre: " + super.getNombre();
	}
	
	public String habilidades() {
		return "habilidades de gatos...";
	}
}
