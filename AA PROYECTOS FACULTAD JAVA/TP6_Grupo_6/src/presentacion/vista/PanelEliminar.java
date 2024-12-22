package presentacion.vista;

import javax.swing.JPanel;

import entidad.Persona;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

public class PanelEliminar extends JPanel {
	private static final long serialVersionUID = -8366463788035694043L;
	private JList<Persona> listPersonas;
	private JButton btnEliminar;
	
	public PanelEliminar() {
		setLayout(null);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar Usuarios");
		lblEliminarUsuarios.setBounds(180, 11, 87, 14);
		add(lblEliminarUsuarios);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(178, 185, 89, 23);
		add(btnEliminar);
		
		listPersonas = new JList<Persona>();
		listPersonas.setBounds(122, 39, 197, 140);
		add(listPersonas);
	}

	public JList getListPersonas() {
		return listPersonas;
	}

	public void setListPersonas(JList<Persona> listPersonas) {
		this.listPersonas = listPersonas;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	
	
}
