package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

public class PanelEliminar extends JPanel {

	private JButton btnEliminar;

	public PanelEliminar() {
		setLayout(null);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar Usuarios");
		lblEliminarUsuarios.setBounds(180, 11, 87, 14);
		add(lblEliminarUsuarios);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(178, 185, 89, 23);
		add(btnEliminar);
		
		JList list = new JList();
		list.setBounds(132, 40, 173, 137);
		add(list);
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	
	
}
