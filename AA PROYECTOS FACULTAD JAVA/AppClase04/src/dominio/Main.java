package dominio;

public class Main {
	public static void main(String[] args) {
		//Ejemplo error por abstract en Animal
		//Animal a = new Animal("Animal");
		
		// Ejemplo polimorfismo
		// Puedo instanciarla como Animal porque es Gato
		Animal gato = new Gato("Pepita");
		
		Perro perro = new Perro("Huesos", "Galgo");
		
		System.out.println(gato.toString());
		System.out.println(perro.toString() + " - " + perro.habilidades());
		
		// Polimorfismo, una clase hijo puede guardarse dentro de clase padre
		Animal[] animales = new Animal[2];
		//animales[0] = a;
		animales[0] = gato;
		animales[1] = perro;
		
		for(Animal an : animales) {
			System.out.println(an.toString() + " - " + an.habilidades());
		}
	}
}
