package dominio;

public abstract class Animal {
	private String nombre;

	public Animal() {
		this.nombre = "";
	}
	
	public Animal(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "Es un animal, Nombre: " + nombre ;
	}
	
	// Los metodos abs DEBEN ser desarrollados en las clases hijas
	public abstract String habilidades();
}
