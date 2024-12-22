package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAgregar extends JPanel {
	private static final long serialVersionUID = -1377783464780373392L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnAceptar;

	public PanelAgregar() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(98, 25, 46, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(98, 50, 46, 14);
		add(lblApellido);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(98, 75, 46, 14);
		add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(214, 22, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(214, 47, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(214, 72, 86, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(98, 100, 89, 23);
		add(btnAceptar);
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
		public JButton getBtnAceptar() {
			return btnAceptar;
		}
		public void setBtnAceptar(JButton btnAceptar) {
			this.btnAceptar = btnAceptar;
		}
	
	
}
