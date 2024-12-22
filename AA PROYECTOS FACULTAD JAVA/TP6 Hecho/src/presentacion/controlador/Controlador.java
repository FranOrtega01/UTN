package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregar;
import presentacion.vista.PanelModificar;
import presentacion.vista.PanelEliminar;
import presentacion.vista.PanelListar;
import presentacion.vista.VentanaPrincipal;

public class Controlador {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregar pnlAgregarPersonas;
	private PanelEliminar pnlEliminarPersonas;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;
	
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
	{
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;
		
		//Instancio los paneles
		this.pnlAgregarPersonas = new PanelAgregar();
		this.pnlEliminarPersonas = new PanelEliminar();
		
		//Enlazo todos los eventos
		
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));

		//Eventos PanelAgregarPersonas
		 this.pnlAgregarPersonas.getBtnAceptar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
	
		//Eventos PanelEliminarPersonas
		 this.pnlEliminarPersonas.getBtnEliminar().addActionListener(s->EventoClickBoton_BorrarPesona_PanelEliminarPersonas(s));
		 
		}
	
	public void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlAgregarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	//EventoClickMenu abrir PanelEliminarPersonas
	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	//EventoClickBoton agregar persona en PanelAgregarPersonas
		private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
			String dni = this.pnlAgregarPersonas.getTxtDni().getText();
			String nombre = this.pnlAgregarPersonas.getTxtNombre().getText();
			String tel = this.pnlAgregarPersonas.getTxtApellido().getText();
			Persona nuevaPersona = new Persona(0, nombre, tel);
			
			boolean estado = pNeg.insert(nuevaPersona);
			String mensaje;
			if(estado==true)
			{
				mensaje="Persona agregada con exito";
				this.pnlAgregarPersonas.getTxtNombre().setText("");
				this.pnlAgregarPersonas.getTxtApellido().setText("");
			}
			else
				mensaje="Persona no agregada, complete todos los campos";
			
			this.refrescarTabla();
		
		}
		
		//EventoClickBoton borrar persona en PanelEliminarPersonas
		public void EventoClickBoton_BorrarPesona_PanelEliminarPersonas(ActionEvent s)
			{
				String id_eliminar = this.pnlEliminarPersonas.getTxtIdEliminar().getText();
				Persona persona = new Persona();
				persona.setIdPersona(Integer.parseInt(id_eliminar));
				
				boolean estado=false;
				String mensaje;
				estado = pNeg.delete(persona);
				if(estado==true)
				{
					mensaje="Persona eliminada con exito";	
				}
				else
				{
					 mensaje="Id inexistente";
				}

				
			}
			
		
		private void refrescarTabla()
		{
			this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
			this.pnlIngresoPersonas.llenarTabla(this.personasEnTabla);
		}

		
		public void inicializar()
		{
			this.ventanaPrincipal.setVisible(true);;
		}
		
	
}
