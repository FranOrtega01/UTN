package principal;

public class Pelicula {
	private Genero genero;
	private int id;
	private String nombre;
	
	public Pelicula(int id, String nombre, Genero genero) {
		super();
		this.genero = genero;
		this.id = id;
		this.nombre = nombre;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nombre + " - " + genero.toString();
	}	
}
