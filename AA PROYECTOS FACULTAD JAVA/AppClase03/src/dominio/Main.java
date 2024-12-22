package dominio;

public class Main {
	public static void main(String[] args) {
		Animal a = new Animal("Animal");
		
		// Ejemplo polimorfismo
		Animal gato = new Gato("Pepita");
		
		Perro perro = new Perro("Huesos", "Galgo");
		
		System.out.println(a.toString());
		System.out.println(gato.toString());
		System.out.println(perro.toString());
		
		// Polimorfismo, una clase hijo puede guardarse dentro de clase padre
		Animal[] animales = new Animal[3];
		animales[0] = a;
		animales[1] = gato;
		animales[2] = perro;
		
		for(Animal an : animales) {
			System.out.println(an.toString());
		}
	}
}
