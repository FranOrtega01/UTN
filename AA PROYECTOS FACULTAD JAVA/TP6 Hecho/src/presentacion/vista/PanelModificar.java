package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelModificar extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;

	/**
	 * Create the panel.
	 */
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
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(351, 166, 89, 23);
		add(btnModificar);
		
		JList list = new JList();
		list.setBounds(10, 33, 430, 120);
		add(list);

	}
}
