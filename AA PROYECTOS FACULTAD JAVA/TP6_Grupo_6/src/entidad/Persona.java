package entidad;

public class Persona 
{
	private int idPersona;
	private String nombre;
	private String apellido;

	public Persona()
	{
		
	}
			
			
	public Persona(int id, String n, String a)
	{
		this.idPersona = id;
		this.nombre = n;
		this.apellido = a;
	}
	
	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int id) 
	{
		this.idPersona = id;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String n) 
	{
		this.nombre = n;
	}

	public String getApellido() 
	{
		return this.apellido;
	}

	public void setApellido(String a) 
	{
		this.apellido = a;
	}
}
