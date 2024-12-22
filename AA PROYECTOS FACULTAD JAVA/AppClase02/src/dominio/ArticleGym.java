package dominio;

public class ArticleGym extends Article {

	private int peso;
	// Final, const, no se puedo cambiar
	// Puede setearse en el constructor
	private static final int gramos = 1000;
	// Constructors
	
	public ArticleGym() {
		super();
	}
	
	public ArticleGym(String name, int peso) {
		super(name);
		this.peso = peso;
	}
	
	public int getPesoEnGramos() {
		return peso*gramos;
	}
	// Getters & Setters
	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return super.toString() + " - Peso: " + peso ;
	}
		

}
