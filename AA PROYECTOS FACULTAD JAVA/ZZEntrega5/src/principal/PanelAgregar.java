package principal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAgregar extends JPanel {
	private JTextField txtNombre;
	private JLabel lblID;
	private JLabel lblIDText;
	private JLabel lblNombre;
	private JLabel lblGenero;
	private JButton btnAceptar;
	private JComboBox<Genero> cbGeneros;
	private DefaultListModel<Pelicula> dlModel;
	
	static int ID = 1;
	
	public void setListModel(DefaultListModel<Pelicula> model) {
		dlModel = model;
	}
	
	public PanelAgregar() {
		setLayout(null);
		
		lblID = new JLabel("ID: ");
		lblID.setBounds(46, 49, 46, 14);
		add(lblID);
		
		lblIDText = new JLabel("" + ID);
		lblIDText.setBounds(227, 49, 46, 14);
		add(lblIDText);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(46, 103, 46, 14);
		add(lblNombre);
		
		lblGenero = new JLabel("Genero");
		lblGenero.setBounds(46, 162, 46, 14);
		add(lblGenero);
		

		txtNombre = new JTextField();
		txtNombre.setBounds(227, 100, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		cbGeneros = new JComboBox<Genero>();
		cbGeneros.setBounds(227, 159, 89, 20);
		
		cbGeneros.addItem(new Genero("Seleccion un genero"));
		cbGeneros.addItem(new Genero("Terror"));
		cbGeneros.addItem(new Genero("Accion"));
		cbGeneros.addItem(new Genero("Suspenso"));
		cbGeneros.addItem(new Genero("Romantica"));
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Agregar Pelicula
				Pelicula x = new Pelicula(ID, txtNombre.getText(), (Genero)cbGeneros.getSelectedItem());
				dlModel.addElement(x);
				ID++;
				lblIDText.setText("" + ID);
			}
		});
		btnAceptar.setBounds(133, 240, 89, 23);
		add(btnAceptar);
		
		
		
		add(cbGeneros);
	}
	
}
