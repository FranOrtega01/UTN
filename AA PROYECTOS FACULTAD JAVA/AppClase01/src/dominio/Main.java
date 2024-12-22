package dominio;

public class Main {

	public static void main(String[] args) {
		Article art = new Article();
		art.setName("Mi lirbo");
		System.out.println(art.toString());
		
		Article art2 = new Article();
		art2.setName("Mi lirbo2");
		System.out.println(art2.toString());
		
		System.out.println(Article.proxID() );
	}

}
