package ejercicio2;

public class Messi {
	private String nacionalidad;
	private IEquipo equipo;
	
	public Messi() {
		
	}
	
	public Messi(String n, IEquipo e) {
		super();
		this.nacionalidad = n;
		this.equipo = e;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public IEquipo getEquipo() {
		return equipo;
	}
	
	public void setEquipo(IEquipo equipo) {
		this.equipo = equipo;
	}
	
	public String toString() {
		return "Nacionalidad: " + nacionalidad + " Equipo: " + equipo.info();
		
	}

	
}
