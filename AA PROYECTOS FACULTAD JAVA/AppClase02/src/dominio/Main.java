package dominio;

public class Main {

	public static void main(String[] args) {
		ArticleGym artG = new ArticleGym("artG", 55);
		System.out.println(artG.toString());
		
		ArticleGym artG2 = new ArticleGym();
		artG2.setPeso(60);
		artG2.setName("artG2");
		System.out.println(artG2.getPesoEnGramos());
		System.out.println(artG2.toString());
	}

}
