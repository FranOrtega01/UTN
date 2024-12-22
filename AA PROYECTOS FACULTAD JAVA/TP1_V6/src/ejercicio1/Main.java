package ejercicio1;

public class Main {

	public static void main(String[] args) {
		Empleado emp = new Empleado();
		System.out.println(emp.toString());
		Empleado emp2 = new Empleado();
		System.out.println(emp2.toString());
		Empleado emp3 = new Empleado();
		System.out.println(emp3.toString());
		System.out.println(Empleado.devuelveProximoID());
	}

}
