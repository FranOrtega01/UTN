package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import entidad.Persona;

import javax.swing.JButton;

public class PanelModificar extends JPanel {
	private static final long serialVersionUID = -6450821243757220267L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnModificar;
	private JList<Persona> listPersonas;

	
	public PanelModificar() {
		setLayout(null);
		
		JLabel lblSeleccioneLaPersona = new JLabel("Seleccione la persona que desea modificar");
		lblSeleccioneLaPersona.setBounds(120, 11, 208, 14);
		add(lblSeleccioneLaPersona);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 167, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(127, 167, 86, 20);
		add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(242, 167, 86, 20);
		add(txtDni);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(351, 166, 89, 23);
		add(btnModificar);
		
		listPersonas = new JList<Persona>();
		listPersonas.setBounds(10, 41, 318, 109);
		add(listPersonas);

	}


	public JTextField getTxtNombre() {
		return txtNombre;
	}


	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}


	public JTextField getTxtApellido() {
		return txtApellido;
	}


	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}


	public JTextField getTxtDni() {
		return txtDni;
	}


	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}


	public JButton getBtnModificar() {
		return btnModificar;
	}


	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}


	public JList<Persona> getListPersonas() {
		return listPersonas;
	}


	public void setListPersonas(JList<Persona> listPersonas) {
		this.listPersonas = listPersonas;
	}
	
	

}
