package dominio;

public class Article {
	// Variables
	private int id;
	private String name;
	
	// Var Estaticas
	private static int cont = 0;
	
	// Metodo Estatico
	public static int proxID() {
		return cont + 1;
	}
	
	// Constructors
	public Article() {
		cont++;
		this.id = cont;
		this.name = "";
	}
	
	public Article(String name) {
		cont++;
		this.id = cont;
		this.name = name;
	}
	 
	// Getters
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Metodos 
	public String toString() {
		return "ID: " + id + " - Nombre: \"" + name + "\"" ;
	}
}
