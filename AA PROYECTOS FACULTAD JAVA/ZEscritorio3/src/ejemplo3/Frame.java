package ejemplo3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombre;
	private JLabel lblID;
	private JLabel lblNombre;
	private JButton btnAceptar;
	private DefaultListModel<Categorias> dlModel;
	private JList list;
	
	
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblID = new JLabel("ID");
		lblID.setBounds(29, 11, 46, 14);
		contentPane.add(lblID);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(29, 45, 46, 14);
		contentPane.add(lblNombre);
		
		txtID = new JTextField();
		txtID.setBounds(85, 8, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(85, 42, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		list = new JList();
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(list.getSelectedIndex() != -1 ) {
					dlModel.remove(list.getSelectedIndex());
				}
			}
		});
		list.setBounds(26, 115, 338, 154);
		contentPane.add(list);
		
		dlModel = new DefaultListModel<Categorias>();
		list.setModel(dlModel);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Categorias x = new Categorias(txtID.getText(), txtNombre.getText());
				dlModel.addElement(x);
				
			}
		});
		
		
		btnAceptar.setBounds(275, 41, 89, 23);
		contentPane.add(btnAceptar);
		
		
		
		
	}
}
