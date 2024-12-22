package ejercicio1;

public class Empleado {
	//atributos
	private static int cont = 999;
	private final int id;
	private String nombre;
	private int edad;
	
	public static int devuelveProximoID() {
		return cont + 1;
	}
	//constructor
	public Empleado() {
		cont++;
		id = cont;
		nombre = "Sin nombre";
		edad = 99;
	}
	
	public Empleado(String nombre, int edad) {
		cont++;
		id = cont;
		this.nombre = nombre;
		this.edad = edad;
	}
	

	//getters setters
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	//metodos
	
	@Override
	public String toString() {
		return "Empleado: " + nombre + ", Edad: " + edad + ", Legajo: " + id;
	}
}
